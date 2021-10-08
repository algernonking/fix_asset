package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetHandleConfirmOperationEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.eam.common.AssetCommonError;
import com.dt.platform.eam.service.IAssetSelectedDataService;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.eam.service.IOperateService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.dt.platform.eam.service.IAssetCollectionReturnService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 资产退库 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-21 15:45:51
*/


@Service("EamAssetCollectionReturnService")
public class AssetCollectionReturnServiceImpl extends SuperService<AssetCollectionReturn> implements IAssetCollectionReturnService {
	
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
	private IAssetService assetService;

	@Autowired
	private AssetItemServiceImpl assetItemService;


	@Autowired
	private IAssetSelectedDataService assetSelectedDataService;

	@Autowired
	private IOperateService operateService;

	/**
	 * 撤销
	 * @param id ID
	 * @return 是否成功
	 * */
	@Override
	public Result revokeOperation(String id) {
		AssetCollectionReturn billData=getById(id);
		if(AssetHandleStatusEnum.APPROVAL.code().equals(billData.getStatus())){

		}else{
			return ErrorDesc.failureMessage("当前状态不能，不能进行撤销操作");
		}
		return ErrorDesc.success();
	}


	/**
	 * 送审
	 * @param id ID
	 * @return 是否成功
	 * */
	@Override
	public Result forApproval(String id){

		AssetCollectionReturn billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_COLLECTION_RETURN.code()) ) {
				//审批操作

			}else{
				return ErrorDesc.failureMessage("当前操作不需要送审,请直接进行确认操作");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
		return ErrorDesc.success();
	}

	/**
	 * 确认操作
	 * @param id ID
	 * @return 是否成功
	 * */
	@Override
	public Result confirmOperation(String id) {
		AssetCollectionReturn billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_COLLECTION_RETURN.code()) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(id,AssetHandleConfirmOperationEnum.SUCCESS.code());
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
	}


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}



	/**
	 * 操作成功
	 * @param id ID
	 * @return 是否成功
	 * */
	public Result operateSuccess(String id) {

		return ErrorDesc.success();
	}

	/**
	 * 操作失败
	 * @param id ID
	 * @return 是否成功
	 * */
	public Result operateFailed(String id) {
		return ErrorDesc.success();
	}

	/**
	 * 操作
	 * @param id  ID
	 * @param result 结果
	 * @return
	 * */
	public Result operateResult(String id,String result) {

		if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){
			return operateSuccess(id);
		}else if(AssetHandleConfirmOperationEnum.FAILED.code().equals(result)){
			return operateFailed(id);
		}else{
			return ErrorDesc.failureMessage("返回未知结果");
		}
	}



	/**
	 * 插入实体
	 * @param assetCollectionReturn 实体数据
	 * @param assetSelectedCode 数据标记
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetCollectionReturn assetCollectionReturn, String assetSelectedCode) {

		if(!StringUtil.isBlank(assetSelectedCode)){
			//获取资产列表
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
			assetCollectionReturn.setAssetIds(list);
			//保存单据数据
			Result insertReuslt=insert(assetCollectionReturn);
			if(!insertReuslt.isSuccess()){
				return insertReuslt;
			}
		}else{
			return ErrorDesc.failure().message("请选择资产");
		}
		return ErrorDesc.success();
	}


	/**
	 * 插入实体
	 * @param assetCollectionReturn 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(AssetCollectionReturn assetCollectionReturn) {

		//校验数据资产
		if(assetCollectionReturn.getAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}
		Result ckResult=assetService.checkAssetDataForBusiessAction(AssetOperateEnum.EAM_ASSET_COLLECTION_RETURN.code(),assetCollectionReturn.getAssetIds());
		if(!ckResult.isSuccess()){
			return ckResult;
		}




		//制单人
		if(StringUtil.isBlank(assetCollectionReturn.getOriginatorId())){
			assetCollectionReturn.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//业务时间
		if(StringUtil.isBlank(assetCollectionReturn.getBusinessDate())){
			assetCollectionReturn.setBusinessDate(new Date());
		}

		//办理状态
		if(StringUtil.isBlank(assetCollectionReturn.getStatus())){
			assetCollectionReturn.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		//生成编码规则
		if(StringUtil.isBlank(assetCollectionReturn.getBusinessCode())){
			Result codeResult=CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_COLLECTION_RETURN.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetCollectionReturn.setBusinessCode(codeResult.getData().toString());
			}
		}


		Result r=super.insert(assetCollectionReturn);
		if (r.isSuccess()){
			//保存资产数据
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<assetCollectionReturn.getAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setHandleId(assetCollectionReturn.getId());
				asset.setAssetId(assetCollectionReturn.getAssetIds().get(i));
				saveList.add(asset);
			}
			Result batchInsertReuslt= assetItemService.insertList(saveList);
			if(!batchInsertReuslt.isSuccess()){
				return batchInsertReuslt;
			}
		}
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param assetCollectionReturnList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetCollectionReturn> assetCollectionReturnList) {
		return super.insertList(assetCollectionReturnList);
	}
	
	
	/**
	 * 按主键删除 资产退库
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetCollectionReturn assetCollectionReturn = new AssetCollectionReturn();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetCollectionReturn.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetCollectionReturn);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产退库
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetCollectionReturn assetCollectionReturn = new AssetCollectionReturn();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetCollectionReturn.setId(id);
		assetCollectionReturn.setDeleted(dao.getDBTreaty().getTrueValue());
		assetCollectionReturn.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetCollectionReturn.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetCollectionReturn,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 更新实体
	 * @param assetCollectionReturn 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(AssetCollectionReturn assetCollectionReturn , SaveMode mode) {
		//c  新建,r  原纪录,d  删除,cd 新建删除
		//验证数据
		String handleId=assetCollectionReturn.getId();
		ConditionExpr itemRecordCondition=new ConditionExpr();
		itemRecordCondition.andIn("handle_id",handleId);
		itemRecordCondition.andIn("crd","c","r");
		List<String> ckDatalist=assetItemService.queryValues(EAMTables.EAM_ASSET_ITEM.ASSET_ID,String.class,itemRecordCondition);
		assetCollectionReturn.setAssetIds(ckDatalist);
		if(assetCollectionReturn.getAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}
		Result ckResult=assetService.checkAssetDataForBusiessAction(CodeModuleEnum.EAM_ASSET_COLLECTION_RETURN.code(),assetCollectionReturn.getAssetIds());
		if(!ckResult.isSuccess()){
			return ckResult;
		}
		Result r=super.update(assetCollectionReturn,mode);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",handleId);
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and  handle_id=?",handleId);
		}
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param assetCollectionReturnList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetCollectionReturn> assetCollectionReturnList , SaveMode mode) {
		return super.updateList(assetCollectionReturnList , mode);
	}
	
	
	/**
	 * 按主键更新字段 资产退库
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
	 * 按主键获取 资产退库
	 *
	 * @param id 主键
	 * @return AssetCollectionReturn 数据对象
	 */
	public AssetCollectionReturn getById(String id) {
		AssetCollectionReturn sample = new AssetCollectionReturn();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetCollectionReturn> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetCollectionReturn> queryList(AssetCollectionReturn sample) {
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
	public PagedList<AssetCollectionReturn> queryPagedList(AssetCollectionReturn sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetCollectionReturn> queryPagedList(AssetCollectionReturn sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param assetCollectionReturn 数据对象
	 * @return 判断结果
	 */
	public Result<AssetCollectionReturn> checkExists(AssetCollectionReturn assetCollectionReturn) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(assetCollectionReturn, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(AssetCollectionReturn sample) {
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