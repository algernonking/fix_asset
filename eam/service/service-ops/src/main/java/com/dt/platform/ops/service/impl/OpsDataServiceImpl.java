package com.dt.platform.ops.service.impl;


import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.ops.service.IDbInstanceService;
import com.dt.platform.ops.service.IHostService;
import com.dt.platform.ops.service.IInformationSystemService;
import com.dt.platform.ops.service.IOpsDataService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import oshi.software.os.windows.WindowsOSSystemInfo;

import javax.annotation.Resource;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 主机 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:06:43
*/


@Service("OpsDataService")
public class OpsDataServiceImpl extends SuperService<Host> implements IOpsDataService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Autowired
	IHostService hostService;

	@Autowired
	IInformationSystemService informationSystemService;

	@Autowired
	IDbInstanceService dbinstanceService;

	@Override
	public List<Host> queryHostList(HostVO host) {
		return hostService.queryList(host);
	}

	@Override
	public Map<String, Object> queryHostMap(HostVO host) {
		Map<String,Object> map=new HashMap<>();
		List<Host> list= queryHostList(host);

		// 关联出 信息系统 数据
		hostService.join(list, HostMeta.INFO_SYSTEM);
		// 关联出 所在位置 数据
		hostService.join(list,HostMeta.POSITION);
		// 关联出 数据库 数据
		hostService.join(list,HostMeta.HOST_DB_LIST);
		// 关联出 中间件 数据
		hostService.join(list,HostMeta.HOST_MIDDLEWARE_LIST);
		// 关联出 操作系统 数据
		hostService.join(list,HostMeta.HOST_OS_LIST);


		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for(int i=0;i<list.size();i++){
			Host item=list.get(i);
			Map<String, Object> hostMap= BeanUtil.toMap(item);
			if(item.getPosition()!=null){
				hostMap.put("hostPositionName",item.getPosition().getName());
			}

			if(item.getInfoSystem()!=null){
				hostMap.put("hostInfoSystemName",item.getInfoSystem().getName());
			}

			if(item.getHostOsList()!=null){
				List<ServiceInfo> os=item.getHostOsList();
				String osstr="";
				for(int j=0;j<os.size();j++){
					osstr=osstr+","+os.get(j).getName();
				}
				hostMap.put("hostOs",osstr.replaceFirst(",",""));
			}

			if(item.getHostDbList()!=null){
				List<ServiceInfo> db=item.getHostDbList();
				String dbstr="";
				for(int j=0;j<db.size();j++){
					dbstr=dbstr+","+db.get(j).getName();
				}
				hostMap.put("hostDb",dbstr.replaceFirst(",",""));
			}

			if(item.getHostMiddlewareList()!=null){
				List<ServiceInfo> mid=item.getHostMiddlewareList();
				String midstr="";
				for(int j=0;j<mid.size();j++){
					midstr=midstr+","+mid.get(j).getName();
				}
				hostMap.put("hostMid",midstr.replaceFirst(",",""));

			}
			listMap.add(hostMap);
		}
		map.put("hostList", listMap);
		//System.out.println(map);
		return map;
	}



	@Override
	public List<InformationSystem> queryInformationSystemList(InformationSystemVO sample) {
		return informationSystemService.queryList(sample);
	}

	@Override
	public Map<String, Object> queryInformationSystemMap(InformationSystemVO sample) {
		Map<String,Object> map=new HashMap<>();
		List<InformationSystem> list= queryInformationSystemList(sample);
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for(int i=0;i<list.size();i++) {
			InformationSystem item = list.get(i);
			Map<String, Object> hostMap= BeanUtil.toMap(item);



			listMap.add(hostMap);
		}
		map.put("hostList", listMap);
		return map;
	}

	@Override
	public List<DbInstance> queryDatabaseInstanceList(DbInstanceVO sample) {
		return dbinstanceService.queryList(sample);
	}

	@Override
	public Map<String, Object> queryDatabaseInstanceMap(DbInstanceVO sample){
		Map<String,Object> map=new HashMap<>();
		List<DbInstance> list= queryDatabaseInstanceList(sample);
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for(int i=0;i<list.size();i++) {
			DbInstance item = list.get(i);
			Map<String, Object> hostMap= BeanUtil.toMap(item);



			listMap.add(hostMap);

		}
		map.put("hostList", listMap);
		return map;

	}



	public File saveTempFile(InputStream is, String fileName){

		int BYTESIZE=1024;
		String path = System.getProperty("java.io.tmpdir");
		File temp = new File(path + fileName);
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try{
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(new FileOutputStream(temp));                            //把文件流转为文件，保存在临时目录
			int len = 0;
			byte[] buf = new byte[10*BYTESIZE];                                                    //缓冲区
			while((len=bis.read(buf)) != -1){
				bos.write(buf, 0, len);
			}
			bos.flush();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				if(bos!=null) bos.close();
				if(bis!=null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}



}