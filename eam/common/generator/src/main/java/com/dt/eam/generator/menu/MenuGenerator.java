package com.dt.eam.generator.menu;

import com.dt.eam.constants.db.EAMTables;
import com.dt.eam.constants.db.EAMTables.DC_INFO;
import com.dt.eam.datacenter.page.InfoPageController;
import com.dt.eam.eam.page.BrandPageController;
import com.dt.eam.generator.config.EamConfigs;
import com.dt.eam.proxy.datacenter.InfoServiceProxy;
import com.dt.eam.proxy.eam.BrandServiceProxy;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.project.maven.MavenProject;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.generator.builder.business.ControllerProxyFile;
import com.github.foxnic.sql.meta.DBTable;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.MenuType;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.MenuResource;
import org.github.foxnic.web.domain.oauth.Resourze;
import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MenuGenerator {

	/**
	 * 超级管理员角色ID
	 * */
	public static final String SUPER_ADMIN_ROLE_ID="110352963290923110";

	/**
	 * 数据中心菜单ID，配置后，从数据库取得
	 * */
	public static final String DATACENTER_MENU_ID="470155869825269760";

	/**
	 * 数据中心菜单ID，配置后，从数据库取得
	 * */
	public static final String EAM_MENU_ID="eam";


	public static void main(String[] args) {

		MenuGenerator mg=null;

		mg=new MenuGenerator(EAMTables.EAM_BRAND.$TABLE, BrandServiceProxy.class, BrandPageController.class);
		mg.removeByBatchId("469531569673994240");
		mg.generate(EAM_MENU_ID);

//		mg=new MenuGenerator(DC_INFO.$TABLE, InfoServiceProxy.class, InfoPageController.class);
//		mg.generate(DATACENTER_MENU_ID);
	}



	private EamConfigs configs;
	private DAO dao;
	private DBTable table;
	private Class proxyType;
	private Class pageType;
	//
	private String batchId;
	private Menu topMenu=null;
	private List<Resourze> resourzes=new ArrayList<>();
	private Map<String,Resourze> resourceMap=new HashMap<>();
	private String authorityPrefix;
	private String roleId;

	public MenuGenerator(DBTable table, Class proxyType, Class pageType) {
		this("service-eam",SUPER_ADMIN_ROLE_ID,table,proxyType,pageType);
	}
	
	public MenuGenerator(String appId, String roleId, DBTable table, Class proxyType, Class pageType) {
		this.configs=new EamConfigs(appId);
		this.dao=this.configs.getDAO();
		this.table=table;
		this.proxyType =proxyType;
		this.pageType =pageType;
		this.batchId=IDGenerator.getSnowflakeIdString();
		this.authorityPrefix=table.name().toLowerCase()+":";
		this.roleId=roleId;

	}

	public void grantAll() {
		List<Menu> menus=dao.queryEntities(Menu.class,"SELECT * FROM sys_menu where id not in (SELECT menu_id FROM sys_role_menu)");
		for (Menu menu : menus) {
			RoleMenu rm=new RoleMenu();
			rm.setId(IDGenerator.getSnowflakeIdString());
			rm.setMenuId(menu.getId());
			rm.setRoleId(roleId);
			dao.insertEntity(rm);
		}
	}



	public void generate(String parentId) {

		Menu parent=dao.queryEntity(Menu.create().setId(parentId));
		if(parent==null) {
			System.err.println("上级菜单 ID = "+parentId+" 不存在");
			return;
		}

		dao.execute("delete from "+ FoxnicWeb.SYS_RESOURZE.$NAME +" where deleted=1");

		try {
			dao.beginTransaction();
			createPageResources();
			createTopMenu(parentId);
			createApiResource();
			createSubMenus();
			refreshHierarchy();
			grant();
			dao.commit();
		} catch (Exception e){
			dao.rollback();
			System.err.println("生成失败，数据已回滚");
			e.printStackTrace();
		}
	}

	/**
	 * 刷新层级路径
	 * */
	protected void refreshHierarchy() {

		dao.execute("update sys_menu set hierarchy=id where parent_id is null or trim(parent_id)=''");

		String sql="UPDATE sys_menu c, sys_menu p " +
				"SET c.hierarchy=CONCAT(p.hierarchy,'/',c.id) " +
				"WHERE p.id=c.parent_id and c.hierarchy is null and p.hierarchy is not null";
		while (true) {
			int i=dao.execute(sql);
			if(i==0) break;
		}


	}

	protected  String getFunctionString() {
		return ControllerProxyFile.CATALOG;
	}


	private void createSubMenus() {
		String[] tmp=getFunctionString().split(";");
		int idx=0;
		for (String s : tmp) {
			String[] line=s.split(":");
			String name=line[0];
			String auth=line[1];
			String[] suffixes=line[2].split(",");
			for (int i = 0; i < suffixes.length; i++) {
				suffixes[i]=suffixes[i].trim();
			}
			Menu menu=new Menu();
			menu.setId(IDGenerator.getSnowflakeIdString());
			menu.setAuthority(authorityPrefix+auth);
			menu.setBatchId(batchId);
			menu.setType(MenuType.function.name());
			menu.setSort(idx);
			menu.setLabel(name);
			menu.setParentId(topMenu.getId());
			menu.setHidden(0);
			idx++;
			//
			dao.insertEntity(menu);

			for (int i = 0; i < suffixes.length; i++) {
				Resourze resourze=resourceMap.get(suffixes[i]);
				if(resourze==null) {
					System.out.println("");
					continue;
				}
				MenuResource mr=new MenuResource();
				mr.setId(IDGenerator.getSnowflakeIdString());
				mr.setMenuId(menu.getId());
				if(resourze.getId()==null) {
					System.out.println("");
				}
				mr.setResourceId(resourze.getId());
				this.dao.insertEntity(mr);
			}

		}

	}

	private void createTopMenu(String parentId) throws Exception {

		for (Resourze resourze : resourzes) {
			if(resourze.getUrl().endsWith("_list.html")) {
				topMenu=new Menu();
				topMenu.setBatchId(batchId);
				topMenu.setId(IDGenerator.getSnowflakeIdString());
				topMenu.setType(MenuType.page.name());
				topMenu.setSort(0);
				topMenu.setUrl("#!"+table.name().toLowerCase()+"_list");
				topMenu.setLabel(getTopic()+"管理");
				topMenu.setHidden(0);
				topMenu.setAuthority(authorityPrefix+"mngr");
				topMenu.setPathResourceId(resourze.getId());
				topMenu.setParentId(parentId);
				dao.insertEntity(topMenu);
				break;
			}
		}

	}



	/**
	 * 从页面控制器提取页面资源
	 * */
	private void createPageResources() throws Exception {
		String prefix=(String)pageType.getDeclaredField("prefix").get(null);
		prefix=StringUtil.removeFirst(prefix, "/");

		File file=(new MavenProject(pageType)).getSourceFile(pageType);
		String source= FileUtil.readText(file);
		String[] lines=source.split("\n");

		Method[] ms=pageType.getDeclaredMethods();

		for (Method m : ms) {
			RequestMapping rm=m.getAnnotation(RequestMapping.class);
			if(rm==null) continue;
			String path="/"+StringUtil.joinUrl(prefix,rm.value()[0]);
			System.out.println(path);
			String doc=this.findDoc(m.getName(),source,lines);
			String[] parts=doc.split(" ");
			String name=parts[parts.length-1];
			if(path.endsWith("_list.html")) {
				name="查询页面";
			} else if(path.endsWith("_form.html")) {
				name="表单页面";
			}


			Resourze resourze=new Resourze();
			resourze.setId(IDGenerator.getSnowflakeIdString());
			resourze.setName(name);
			resourze.setUrl(path);
			resourze.setType("page");
			resourze.setMethod("GET");
			resourze.setTableName(table.name());
			resourze.setModule(this.getTopic());
			resourze.setBatchId(batchId);

			resourzes.add(resourze);
			if(path.endsWith("_list.html")) {
				resourceMap.put("_list.html",resourze);
			} else if(path.endsWith("_form.html")) {
				resourceMap.put("_form.html",resourze);
			}

			dao.insertEntity(resourze);
		}

	}

	private void createApiResource() throws Exception {

		File file=this.configs.getProxyProject().getSourceFile(proxyType);
		String source= FileUtil.readText(file);
		String[] lines=source.split("\n");


		Field[] fs=proxyType.getDeclaredFields();


		for (Field f : fs) {
			String name=f.getName();
			//排除一些无效的静态属性
			if(name.equals("CONTROLLER_CLASS_NAME") || name.startsWith("API_") ) continue;
			String value=(String)f.get(null);
			String doc=this.findDoc(f.getName(),source,lines);

			Resourze resourze=new Resourze();
			resourze.setId(IDGenerator.getSnowflakeIdString());
			resourze.setName(doc);
			resourze.setUrl(value);
			resourze.setType("api");
			resourze.setMethod("POST");
			resourze.setTableName(table.name());
			resourze.setModule(this.getTopic());
			resourze.setBatchId(batchId);

			dao.insertEntity(resourze);

			resourzes.add(resourze);

			value=value.substring(value.lastIndexOf("/"));

			resourceMap.put(value,resourze);

		}
	}


	public String getTopic() {
		DBTableMeta tm=dao.getTableMeta(table.name());
		String topic=tm.getTopic();
		topic=StringUtil.removeLast(topic, "数据表");
		topic=StringUtil.removeLast(topic, "表");
		return  topic;
	}



	private void grant() {

		RcdSet menus=dao.query("select id from "+ FoxnicWeb.SYS_MENU.$NAME+" where batch_id=?",batchId);
		for (Rcd r : menus) {
			dao.insert(FoxnicWeb.SYS_ROLE_MENU.$NAME)
			.set(FoxnicWeb.SYS_ROLE_MENU.ID, IDGenerator.getSnowflakeId())
			.set(FoxnicWeb.SYS_ROLE_MENU.ROLE_ID, roleId)
			.set(FoxnicWeb.SYS_ROLE_MENU.MENU_ID, r.getString(FoxnicWeb.SYS_MENU.ID))
			.set(FoxnicWeb.SYS_ROLE_MENU.CREATE_BY,"auto")
			.execute();
		}
	}

	private String findDoc(String name, String source, String[] lines) {
		String line=null;
		int index=-1;
		for (int i = 0; i < lines.length; i++) {
			line=lines[i];
			if(line.contains(" "+name+" ") || line.contains(" "+name+"=")) {
				index=i;
				break;
			}
		}
		if(index==-1) return name;

		String doc=lines[index-2];
		doc=doc.trim();
		doc=StringUtil.removeFirst(doc,"*").trim();
		return doc;
	}

	public void removeByBatchId(String batchId)  {

		try {
			this.dao.beginTransaction();
			this.dao.execute("delete from sys_menu_resource where resource_id in (select id from sys_resourze where batch_id=?)",batchId);
			this.dao.execute("delete from sys_resourze where batch_id=?",batchId);
			this.dao.execute("delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id=?)",batchId);
			this.dao.execute("delete from sys_menu where batch_id=?",batchId);
			this.dao.commit();
		} catch (Exception e) {
			this.dao.rollback();
			e.printStackTrace();;
		}


	}
	
	

}
