package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.FailureRegistrationMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.excel.ExcelStructure;
import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.sql.expr.Select;
import java.util.ArrayList;

import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 故障登记 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-28 16:13:08
*/


@Service("EamFailureRegistrationService")
public class FailureRegistrationServiceImpl extends SuperService<FailureRegistration> implements IFailureRegistrationService {

	@Autowired
	private IAssetService assetService;

	@Autowired
	private AssetItemServiceImpl assetItemService;

	@Autowired
	private IAssetSelectedDataService assetSelectedDataService;


	@Autowired
	private IOperateService operateService;

	@Autowired
	private IAssetProcessRecordService assetProcessRecordService;

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param failureRegistration  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(FailureRegistration failureRegistration,boolean throwsException) {
		if(failureRegistration.getAssetIds()==null||failureRegistration.getAssetIds().size()==0){
			String assetSelectedCode=failureRegistration.getSelectedCode();
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode==null?"":assetSelectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
			failureRegistration.setAssetIds(list);
		}

		//校验数据资产
		if(failureRegistration.getAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}
		Result ckResult=assetService.checkAssetDataForBusinessAction(AssetOperateEnum.EAM_EQUIPMENT_FAILURE_REGISTRATION.code(),failureRegistration.getAssetIds());
		if(!ckResult.isSuccess()){
			return ckResult;
		}

		//办理状态
		if(StringUtil.isBlank(failureRegistration.getStatus())){
			failureRegistration.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		//编码
		if(StringUtil.isBlank(failureRegistration.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_EQUIPMENT_FAILURE_REGISTRATION.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				failureRegistration.setBusinessCode(codeResult.getData().toString());
			}
		}

		//制单人
		if(StringUtil.isBlank(failureRegistration.getOriginatorId())){
			failureRegistration.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		Result r=super.insert(failureRegistration,throwsException);
		if(r.isSuccess()){
			//保存资产数据
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<failureRegistration.getAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setId(IDGenerator.getSnowflakeIdString());
				asset.setHandleId(failureRegistration.getId());
				asset.setAssetId(failureRegistration.getAssetIds().get(i));
				saveList.add(asset);
			}
			Result batchInsertReuslt= assetItemService.insertList(saveList);
			if(!batchInsertReuslt.isSuccess()){
				return batchInsertReuslt;
			}
		}
		return r;
	}

	@Override
	public Result confirmOperation(String id) {

		FailureRegistration bill=this.getById(id);
		Result verifyResult= verifyBillData(id);
		if(!verifyResult.isSuccess()) return verifyResult;
		FailureRegistration change=new FailureRegistration();
		change.setId(id);
		change.setStatus(AssetHandleStatusEnum.COMPLETE.code());
		Result r=super.update(change,SaveMode.NOT_NULL_FIELDS,false);
		if(r.isSuccess()){
			this.join(bill, FailureRegistrationMeta.ASSET_LIST);
			List<Asset> assetList=bill.getAssetList();
			if(assetList!=null&&assetList.size()>0){
				for(Asset asset:assetList){
					AssetProcessRecord assetProcessRecord=new AssetProcessRecord();
					assetProcessRecord.setContent("完成故障登记操作");
					assetProcessRecord.setAssetId(asset.getId());
					assetProcessRecord.setBusinessCode(bill.getBusinessCode());
					assetProcessRecord.setProcessType(AssetOperateEnum.EAM_EQUIPMENT_FAILURE_REGISTRATION.code());
					assetProcessRecord.setProcessdTime(new Date());
					assetProcessRecordService.insert(assetProcessRecord);
				}
			}
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param failureRegistration 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(FailureRegistration failureRegistration) {
		return this.insert(failureRegistration,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param failureRegistrationList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<FailureRegistration> failureRegistrationList) {
		return super.insertList(failureRegistrationList);
	}

	
	/**
	 * 按主键删除 故障登记
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		FailureRegistration failureRegistration = new FailureRegistration();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		failureRegistration.setId(id);
		try {
			boolean suc = dao.deleteEntity(failureRegistration);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 故障登记
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		FailureRegistration failureRegistration = new FailureRegistration();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		failureRegistration.setId(id);
		failureRegistration.setDeleted(true);
		failureRegistration.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		failureRegistration.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(failureRegistration,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param failureRegistration 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(FailureRegistration failureRegistration , SaveMode mode) {
		return this.update(failureRegistration,mode,true);
	}

	private Result verifyBillData(String handleId){
		//c  新建,r  原纪录,d  删除,cd 新建删除
		//验证数据
		ConditionExpr itemRecordcondition=new ConditionExpr();
		itemRecordcondition.andIn("handle_id",handleId);
		itemRecordcondition.andIn("crd","c","r");
		List<String> ckDatalist=assetItemService.queryValues(EAMTables.EAM_ASSET_ITEM.ASSET_ID,String.class,itemRecordcondition);
		if(ckDatalist.size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}
		return assetService.checkAssetDataForBusinessAction(CodeModuleEnum.EAM_EQUIPMENT_FAILURE_REGISTRATION.code(),ckDatalist);
	}


	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param failureRegistration 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(FailureRegistration failureRegistration , SaveMode mode,boolean throwsException) {
		Result verifyResult = verifyBillData(failureRegistration.getId());
		if(!verifyResult.isSuccess())return verifyResult;
		Result r=super.update(failureRegistration , mode , throwsException);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",failureRegistration.getId());
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and  handle_id=?",failureRegistration.getId());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param failureRegistrationList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<FailureRegistration> failureRegistrationList , SaveMode mode) {
		return super.updateList(failureRegistrationList , mode);
	}

	
	/**
	 * 按主键更新字段 故障登记
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}

	
	/**
	 * 按主键获取 故障登记
	 *
	 * @param id 主键
	 * @return FailureRegistration 数据对象
	 */
	public FailureRegistration getById(String id) {
		FailureRegistration sample = new FailureRegistration();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<FailureRegistration> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, FailureRegistration> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, FailureRegistration::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<FailureRegistration> queryList(FailureRegistration sample) {
		return super.queryList(sample);
	}


	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<FailureRegistration> queryPagedList(FailureRegistration sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}

	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<FailureRegistration> queryPagedList(FailureRegistration sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param failureRegistration 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(FailureRegistration failureRegistration) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(failureRegistration, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(FailureRegistration sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}