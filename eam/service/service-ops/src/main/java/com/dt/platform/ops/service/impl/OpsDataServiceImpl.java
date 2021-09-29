package com.dt.platform.ops.service.impl;


import com.dt.platform.constants.enums.eam.AssetDataExportColumnEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.constants.enums.ops.HostMonitorStatusEnum;
import com.dt.platform.constants.enums.ops.HostStatusEnum;
import com.dt.platform.constants.enums.ops.OpsHostDataExportColumnEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.InformationSystemMeta;
import com.dt.platform.ops.service.*;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import oshi.software.os.windows.WindowsOSSystemInfo;

import javax.annotation.Resource;
import java.io.*;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	@Autowired
	IHostPositionService hostPositionService;



	@Override
	public List<Host> queryHostList(HostVO host) {
		return hostService.queryList(host);
	}

	@Override
	public String getMapKey(HashMap<String,String> map,String value){
		String key = null;
		//Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
		for(String getKey: map.keySet()){
			if(map.get(getKey).equals(value)){
				key = getKey;
				return key;
			}
		}
		return key;
		//这个key肯定是最后一个满足该条件的key.
	}


	@Override
	public HashMap<String,String> queryUseOrganizationNodes(){
		//id name
		HashMap<String,String> map=new HashMap<String,String>();
		OrganizationVO vo=new OrganizationVO();
		vo.setIsLoadAllDescendants(1);
		vo.setTenantId("T001");
		Result r= OrganizationServiceProxy.api().queryNodesFlatten(vo);
		if(r.isSuccess()){
			List<ZTreeNode> list= (List<ZTreeNode> )r.getData();
			for(int i=0;i<list.size();i++){
				ZTreeNode node= list.get(i);
				String path="";
				for(int j=0;j<node.getNamePathArray().size();j++){
					if(j==0){
						path=node.getNamePathArray().get(j);
					}else{
						path=path+"/"+node.getNamePathArray().get(j);
					}
				}
				System.out.println(node.getId()+","+path);
				map.put(node.getId(),path);
			}
		}
		return map;
	}


	@Override
	public Map<String, Object> queryHostMap(List<Host> list) {
		Map<String,Object> map=new HashMap<>();


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
				hostMap.put(OpsHostDataExportColumnEnum.POSITION_ID.code(),item.getPosition().getName());
			}

			if(item.getInfoSystem()!=null){
				hostMap.put(OpsHostDataExportColumnEnum.HOST_INFO_SYSTEM_NAME.code(),item.getInfoSystem().getName());
			}


			//状态
			CodeTextEnum vStatus= EnumUtil.parseByCode(HostStatusEnum.class,item.getStatus());
			hostMap.put(OpsHostDataExportColumnEnum.HOST_STATUS.code(),vStatus==null?"":vStatus.text());


			//monitor状态
			CodeTextEnum vMonitorStatus= EnumUtil.parseByCode(HostMonitorStatusEnum.class,item.getMonitorStatus());
			hostMap.put(OpsHostDataExportColumnEnum.HOST_MONITOR_STATUS.code(),vMonitorStatus==null?"":vMonitorStatus.text());

			//HOST_TYPE
			String hostType=item.getHostType();
			if(StringUtil.isBlank(hostType)){

				hostMap.put(OpsHostDataExportColumnEnum.HOST_TYPE.code(),"");
			}else{
				DictItemVO vo=new DictItemVO();
				vo.setDictCode("ops_host_type");
				vo.setCode(hostType);
				Result<List<DictItem>>hostTypeResult=DictItemServiceProxy.api().queryList(vo);
				if(hostTypeResult.success()&&hostTypeResult.getData().size()>0){
					hostMap.put(OpsHostDataExportColumnEnum.HOST_TYPE.code(),hostTypeResult.getData().get(0).getLabel());
				}else{
					hostMap.put(OpsHostDataExportColumnEnum.HOST_TYPE.code(),"");
				}
			}


			//PASSWORD_STRATEGY_ID
			String hostPasswordStrategy=item.getPasswordStrategyId();
			if(StringUtil.isBlank(hostPasswordStrategy)){
				hostMap.put(OpsHostDataExportColumnEnum.HOST_PASSWORD_STRATEGY.code(),"");
			}else{
				DictItemVO vo=new DictItemVO();
				vo.setDictCode("ops_host_password_strategy");
				vo.setCode(hostPasswordStrategy);
				Result<List<DictItem>>hostTypeResult=DictItemServiceProxy.api().queryList(vo);
				if(hostTypeResult.success()&&hostTypeResult.getData().size()>0){
					hostMap.put(OpsHostDataExportColumnEnum.HOST_PASSWORD_STRATEGY.code(),hostTypeResult.getData().get(0).getLabel());
				}else{
					hostMap.put(OpsHostDataExportColumnEnum.HOST_PASSWORD_STRATEGY.code(),"");
				}
			}

			//ENVIRONMENT
			String hostEnv=item.getEnvironment();
			if(StringUtil.isBlank(hostEnv)){
				hostMap.put(OpsHostDataExportColumnEnum.HOST_ENVIRONMENT.code(),"");
			}else{
				DictItemVO vo=new DictItemVO();
				vo.setDictCode("ops_environment");
				vo.setCode(hostEnv);
				Result<List<DictItem>>hostTypeResult=DictItemServiceProxy.api().queryList(vo);
				if(hostTypeResult.success()&&hostTypeResult.getData().size()>0){
					hostMap.put(OpsHostDataExportColumnEnum.HOST_ENVIRONMENT.code(),hostTypeResult.getData().get(0).getLabel());
				}else{
					hostMap.put(OpsHostDataExportColumnEnum.HOST_ENVIRONMENT.code(),"");
				}
			}


			if(item.getHostOsList()!=null){
				List<ServiceInfo> os=item.getHostOsList();
				String osstr="";
				for(int j=0;j<os.size();j++){
					osstr=osstr+","+os.get(j).getName();
				}
				hostMap.put(OpsHostDataExportColumnEnum.HOST_OS.code(),osstr.replaceFirst(",",""));
			}

			if(item.getHostDbList()!=null){
				List<ServiceInfo> db=item.getHostDbList();
				String dbstr="";
				for(int j=0;j<db.size();j++){
					dbstr=dbstr+","+db.get(j).getName();
				}
				hostMap.put(OpsHostDataExportColumnEnum.HOST_DB.code(),dbstr.replaceFirst(",",""));
			}

			if(item.getHostMiddlewareList()!=null){
				List<ServiceInfo> mid=item.getHostMiddlewareList();
				String midstr="";
				for(int j=0;j<mid.size();j++){
					midstr=midstr+","+mid.get(j).getName();
				}
				hostMap.put(OpsHostDataExportColumnEnum.HOST_MID.code(),midstr.replaceFirst(",",""));
			}
			listMap.add(hostMap);
		}
		map.put("dataList", listMap);
		return map;
	}


	@Override
	public Result verifyISRecord(Rcd rcd, HashMap<String,HashMap<String,String>> matchMap, boolean filldata){

		//日期类型
		String[] dateColumns = {InformationSystemMeta.LASTDRILL_DATE,InformationSystemMeta.OFFLINE_DATE,InformationSystemMeta.OFFLINE_DATE,};
		for(int j=0;j<dateColumns.length;j++){
			String dateColumn=dateColumns[j];
			String value=rcd.getString(BeanNameUtil.instance().depart(dateColumn));
			if(value!=null){
				int valueLen=value.trim().length();
				try {
					DateFormat format1=null;
					if(valueLen==10){
						format1 = new SimpleDateFormat("yyyy-MM-dd");
					}else if(valueLen==19){
						format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					}else{
						return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
					}
					Date date = format1.parse(value);
					rcd.set(dateColumn,date);
				} catch (ParseException e) {
					return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
				}
			}
		}
		return ErrorDesc.success();
	}


	@Override
	public Result verifyHostRecord(Rcd rcd, HashMap<String,HashMap<String,String>> matchMap, boolean filldata){





		//日期类型
		String[] dateColumns = {HostMeta.OFFLINE_TIME,HostMeta.ONLINE_TIME};
		for(int j=0;j<dateColumns.length;j++){
			String dateColumn=dateColumns[j];
			String value=rcd.getString(BeanNameUtil.instance().depart(dateColumn));
			if(value!=null){
				int valueLen=value.trim().length();
				try {
					DateFormat format1=null;
					if(valueLen==10){
						format1 = new SimpleDateFormat("yyyy-MM-dd");
					}else if(valueLen==19){
						format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					}else{
						return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
					}
					Date date = format1.parse(value);
					rcd.set(dateColumn,date);
				} catch (ParseException e) {
					return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
				}
			}
		}


		//下拉框
		//位置
		String valuePosition=rcd.getString(BeanNameUtil.instance().depart(HostMeta.POSITION_ID));
		if(!StringUtil.isBlank(valuePosition)){
			HostPosition position = hostPositionService.queryEntity(HostPosition.create().setName(valuePosition));
			if(position==null){
				if(filldata){
					position=new HostPosition();
					position.setName(valuePosition);
					hostPositionService.insert(position);
					rcd.setValue(BeanNameUtil.instance().depart(HostMeta.POSITION_ID),position.getId());
				}else{
					return ErrorDesc.failureMessage("资产位置不存在:"+valuePosition);
				}
			}else{
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.POSITION_ID),position.getId());
			}
		}



		String valueIs=rcd.getString(BeanNameUtil.instance().depart(HostMeta.SYSTEM_ID));
		if(!StringUtil.isBlank(valueIs)){
			InformationSystem infoSystem = informationSystemService.queryEntity(InformationSystem.create().setName(valueIs));
			if(infoSystem==null){
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.SYSTEM_ID),"");
			}else{
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.SYSTEM_ID),infoSystem.getId());
			}
		}


		String valueEnv=rcd.getString(BeanNameUtil.instance().depart(HostMeta.ENVIRONMENT));
		if(!StringUtil.isBlank(valueEnv)){
			DictItemVO dictVo=new DictItemVO();
			dictVo.setLabel(valueEnv);
			dictVo.setDictCode("ops_environment");
			Result<List<DictItem> >dictItemResult= DictItemServiceProxy.api().queryList(dictVo);
			if(dictItemResult.isSuccess()&&dictItemResult.getData().size()>0){
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.ENVIRONMENT),dictItemResult.getData().get(0).getCode());
			}else{
				//返回报错
				return ErrorDesc.failureMessage("环境不存在:"+valueEnv);
			}
		}

		String valuePwdStragety=rcd.getString(BeanNameUtil.instance().depart(HostMeta.PASSWORD_STRATEGY_ID));
		if(!StringUtil.isBlank(valuePwdStragety)){
			DictItemVO dictVo=new DictItemVO();
			dictVo.setLabel(valuePwdStragety);
			dictVo.setDictCode("ops_host_password_strategy");
			Result<List<DictItem> >dictItemResult= DictItemServiceProxy.api().queryList(dictVo);
			if(dictItemResult.isSuccess()&&dictItemResult.getData().size()>0){
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.PASSWORD_STRATEGY_ID),dictItemResult.getData().get(0).getCode());
			}else{
				//返回报错
				return ErrorDesc.failureMessage("密码策略不存在:"+valuePwdStragety);
			}
		}


		String valeHostType=rcd.getString(BeanNameUtil.instance().depart(HostMeta.HOST_TYPE));
		if(!StringUtil.isBlank(valeHostType)){
			DictItemVO dictVo=new DictItemVO();
			dictVo.setLabel(valeHostType);
			dictVo.setDictCode("ops_host_type");
			Result<List<DictItem> >dictItemResult= DictItemServiceProxy.api().queryList(dictVo);
			if(dictItemResult.isSuccess()&&dictItemResult.getData().size()>0){
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.HOST_TYPE),dictItemResult.getData().get(0).getCode());
			}else{
				//返回报错
				return ErrorDesc.failureMessage("主机类型不存在:"+valeHostType);
			}
		}


		//枚举
		String valueStatus=rcd.getString(BeanNameUtil.instance().depart(HostMeta.STATUS));
		if(!StringUtil.isBlank(valueStatus)){
			CodeTextEnum value=EnumUtil.parseByText(HostStatusEnum.class,valueStatus) ;
			if(value==null){
				return ErrorDesc.failureMessage("主机状态不存在:"+valueStatus);
			}else{
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.STATUS),value.code());
			}
		} else{
			return ErrorDesc.failureMessage("主机状态不存在:"+valueStatus);
		}


		String valueMonitorStatus=rcd.getString(BeanNameUtil.instance().depart(HostMeta.MONITOR_STATUS));
		if(!StringUtil.isBlank(valueMonitorStatus)){
			CodeTextEnum value=EnumUtil.parseByText(HostMonitorStatusEnum.class,valueMonitorStatus) ;
			if(value==null){
				return ErrorDesc.failureMessage("主机状态不存在:"+valueMonitorStatus);
			}else{
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.MONITOR_STATUS),value.code());
			}
		} else{
			return ErrorDesc.failureMessage("主机状态不存在:"+valueMonitorStatus);
		}

		return ErrorDesc.success();

	}
	@Override
	public List<InformationSystem> queryInformationSystemList(InformationSystemVO sample) {
		return informationSystemService.queryList(sample);
	}

	@Override
	public Map<String, Object> queryInformationSystemMap(List<InformationSystem> list) {
		Map<String,Object> map=new HashMap<>();

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
	public Map<String, Object> queryDatabaseInstanceMap(List<DbInstance> list){
		Map<String,Object> map=new HashMap<>();
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for(int i=0;i<list.size();i++) {
			DbInstance item = list.get(i);
			Map<String, Object> hostMap= BeanUtil.toMap(item);

			listMap.add(hostMap);

		}
		map.put("dataList", listMap);
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