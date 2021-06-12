package com.dt.eam.generator.data;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.dt.eam.constants.db.EAMTables;
import com.dt.eam.eam.page.GoodsPageController;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_MENU;
import org.github.foxnic.web.constants.db.FoxnicWeb.SYS_ROLE_MENU;
import org.github.foxnic.web.constants.enums.MenuType;
import org.github.foxnic.web.domain.oauth.Menu;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dt.eam.constants.db.EAMTables.EAM_BRAND;
import com.dt.eam.constants.db.EAMTables.EAM_GOODS;
import com.dt.eam.eam.page.BrandPageController;
import com.dt.eam.generator.config.EamConfigs;
import com.dt.eam.proxy.eam.BrandServiceProxy;
import com.dt.eam.proxy.eam.GoodsServiceProxy;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.io.FileUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.meta.DBTable;

 

public class MenuGenerator {
	
	public static final String superAdminRoleId="110352963290923110";
	
	public static void main(String[] args) throws Exception {
		
		MenuGenerator generator=new MenuGenerator();
		//
//		generator.generate(HRM_COMPANY.$TABLE,CompanyServiceProxy.class,CompanyPageController.class,"hrm");
//		generator.generate(HRM_EMPLOYEE.$TABLE,EmployeeServiceProxy.class,EmployeePageController.class,"hrm");
		
		generator.generate(EAM_BRAND.$TABLE,BrandServiceProxy.class,BrandPageController.class,"eam");

		generator.generate(EAM_GOODS.$TABLE,GoodsServiceProxy.class, GoodsPageController.class,"eam");
		
//		generator.generate(SYS_LANG.$TABLE,LangServiceProxy.class,LangPageController.class,"system");
		
//		generator.generate(SYS_ROLE.$TABLE,RoleServiceProxy.class,RolePageController.class,"oauth");
		
//		generator.generate(SYS_MENU.$TABLE,MenuServiceProxy.class,MenuPageController.class,"oauth");
		
//		generator.removeByBatchId("454331740924674048");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private EamConfigs configs;
	private DAO dao;
	
	public MenuGenerator() {
		this.configs=new EamConfigs("service-eam");
		this.dao=this.configs.getDAO();
	}
	
	public void removeByBatchId(String batchId) throws Exception {

	 this.dao.beginTransaction();
	 this.dao.execute("delete from sys_role_menu where menu_id in (select id from sys_menu where batch_id=?)",batchId);
	 this.dao.execute("delete from sys_menu where batch_id=?",batchId);
	 this.dao.commit();
	 

	}
	
	public void generate(DBTable table, Class proxy,Class page,String parentId) throws Exception {

		String batchId=generateMenus(table,proxy,page,parentId);
		
		grant(batchId);
		
		System.err.println("batchId = "+batchId);

	}

	private void grant(String batchId) {
		

		RcdSet menus=dao.query("select id from "+SYS_MENU.$NAME+" where batch_id=?",batchId);
		for (Rcd r : menus) {
			dao.insert(SYS_ROLE_MENU.$NAME)
			.set(SYS_ROLE_MENU.ID, IDGenerator.getSnowflakeId())
			.set(SYS_ROLE_MENU.ROLE_ID, superAdminRoleId)
			.set(SYS_ROLE_MENU.MENU_ID, r.getString(SYS_MENU.ID))
			.set(SYS_ROLE_MENU.CREATE_BY,"auto")
			.execute();
		}
	}
 
	
	
	private String generateMenus(DBTable table, Class proxy, Class page, String parentId) throws Exception {
		
		String authorityPrefix=table.name()+"::";
		//批次号
		String batchId=IDGenerator.getSnowflakeIdString();
		
		DBTableMeta tm=dao.getTableMeta(table.name());
		
		String topic=tm.getTopic();
		topic=StringUtil.removeLast(topic, "数据表");
		topic=StringUtil.removeLast(topic, "表");
	 
		 
		//插入模块目录
		Menu listMenu=null;
		Menu formMenu=null;
		
		
		
		String prefix=(String)page.getDeclaredField("prefix").get(null);
		prefix=StringUtil.removeFirst(prefix, "/");
		Method[] ms=page.getDeclaredMethods();
		int sort = 0;
		for (Method m : ms) {
			RequestMapping rm=m.getAnnotation(RequestMapping.class);
			if(rm==null) continue;
			String path="/"+StringUtil.joinUrl(prefix,rm.value()[0]);
			System.out.println(path);
			
 
			
			Menu menu=new Menu();
			menu.setId(IDGenerator.getSnowflakeIdString());
			menu.setPath(path);
			menu.setType(MenuType.page.name());
			
			if(path.endsWith("_form.html")) {
				menu.setUrl("#!"+table.name().toLowerCase()+"_edit");
				
				menu.setLabel("编辑"+topic);
				menu.setHidden(1);
				menu.setSort(sort++);
				formMenu=menu;
			}
			
			if(path.endsWith("_list.html")) {
				menu.setUrl("#!"+table.name().toLowerCase()+"_mngr");
				menu.setLabel(topic+"管理");
				menu.setHidden(0);
				menu.setSort(sort++);
				listMenu=menu;
				
			}
			
		}
		
		if(formMenu==null || listMenu==null) return null;
		
		listMenu.setAuthority(authorityPrefix+"list::view");
		listMenu.setBatchId(batchId);
		formMenu.setBatchId(batchId);
		listMenu.setParentId(parentId);
		formMenu.setParentId(listMenu.getId());
		formMenu.setAuthority(authorityPrefix+"form::view");
		dao.insertEntity(formMenu);
		dao.insertEntity(listMenu);	
	 
		
		
		Menu api=new Menu();
		api.setId(IDGenerator.getSnowflakeIdString());
		api.setLabel("api");
		api.setHidden(1);
		api.setType(MenuType.folder.name());
		api.setParentId(listMenu.getId());
		api.setAuthority(authorityPrefix+"apiset");
		api.setBatchId(batchId);
		api.setSort(sort++);
		dao.insertEntity(api);	
		
		File file=this.configs.getProxyProject().getSourceFile(proxy);
		String source=FileUtil.readText(file);
		String[] lines=source.split("\n");
		
		
		Field[] fs=proxy.getDeclaredFields();

		for (Field f : fs) {
			String name=f.getName();
			//排除一些无效的静态属性
			if(name.equals("CONTROLLER_CLASS_NAME") || name.startsWith("API_") ) continue;
			String value=(String)f.get(null);
			String doc=this.findDoc(f.getName(),source,lines);
			System.out.println(name + " = "+value+" , "+doc);
			
			Menu rest=new Menu();
			rest.setId(IDGenerator.getSnowflakeIdString());
			rest.setType(MenuType.api.name());
			rest.setHidden(1);
			rest.setAuthority(authorityPrefix+"api::"+name.toLowerCase());
			rest.setParentId(api.getId());
			rest.setPath(value);
			rest.setLabel(doc);
			rest.setSort(sort++);
			rest.setBatchId(batchId);
			dao.insertEntity(rest);	
			
		}
		
		return batchId;
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

	
	
	
	
	

}
