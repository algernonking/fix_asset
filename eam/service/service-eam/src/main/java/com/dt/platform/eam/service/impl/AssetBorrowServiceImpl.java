package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;
import javax.xml.crypto.Data;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetAllocationMeta;
import com.dt.platform.domain.eam.meta.AssetBorrowMeta;
import com.dt.platform.domain.eam.meta.AssetCollectionMeta;
import com.dt.platform.domain.eam.meta.AssetSelectedDataMeta;
import com.dt.platform.eam.common.AssetCommonError;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeAllocationServiceProxy;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.dt.platform.proxy.eam.AssetAllocationServiceProxy;
import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.sql.expr.SQL;
import org.github.foxnic.web.domain.changes.ChangeEvent;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
import org.github.foxnic.web.domain.changes.ProcessStartVO;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

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

import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 资产借用 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-19 13:01:38
*/


@Service("EamAssetBorrowService")
public class AssetBorrowServiceImpl extends SuperService<AssetBorrow> implements IAssetBorrowService {


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
	private IAssetDataChangeService assetDataChangeService;

	@Autowired
	private IOperateService operateService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}



	@Override
	public Result startProcess(ProcessStartVO startVO) {
		return null;
	}

	@Override
	public Result approve(ProcessApproveVO approveVO) {
		return null;
	}



	@Override
	public Result approve(String instanceId, List<AssetBorrow> assets, String approveAction, String opinion) {
		return null;
	}


	/**
	 * 归还资产
	 * @param ids 单据IDS
	 * @return 返回结果
	 * */
	public Result assetReturn(List<String> ids){
		Result result=new Result();
		for(String id:ids){
			Result r=assetReturn(id);
			if(!r.isSuccess()){
				result.addError(r.getMessage());
			}
		}
		return result;
	}

	/**
	 * 归还资产
	 * @param id 单据ID
	 * @return 返回结果
	 * */
	private Result assetReturn(String id){
		AssetBorrow bill=getById(id);
		join(bill,AssetBorrowMeta.ASSET_ITEM_LIST);
		if(!AssetBorrowStatusEnum.BORROWED.code().equals(bill.getBorrowStatus())){
			return ErrorDesc.failureMessage("当前单据为非借用状态。");
		}
		String str="";
		for(AssetItem item:bill.getAssetItemList()){
			Asset asset=assetService.getById(item.getAssetId());
			if(!AssetStatusEnum.BORROW.code().equals(asset.getAssetStatus())){
				str=str+"资产编码"+asset.getAssetCode()+",当前状态为非借用状态,不在变更  ";
				continue;
			}
			List<Asset> changeList=new ArrayList<>();
			changeList.add(asset);
			HashMap<String,Object> map=new HashMap<>();
			map.put("asset_status",item.getBeforeAssetStatus());
			map.put("use_user_id",item.getBeforeUseUserId()==null?"":item.getBeforeUseUserId());
			HashMap<String,List<SQL>> resultMap=assetService.parseAssetChangeRecordWithChangeAsset(changeList,map,bill.getBusinessCode(),AssetOperateEnum.EAM_ASSET_BORROW_RETURN.code(),"资产归还");
			for(String key:resultMap.keySet()){
				List<SQL> sqls=resultMap.get(key);
				if(sqls.size()>0){
					dao.batchExecute(sqls);
				}
			}

		}
		if(StringUtil.isBlank(str)){
			bill.setBorrowStatus(AssetBorrowStatusEnum.RETURNED.code());
			bill.setReturnDate(new Date());
			super.update(bill,SaveMode.NOT_NULL_FIELDS);
			return  ErrorDesc.success();
		}else{
			return ErrorDesc.failureMessage(str);
		}
	}


	@Override
	public Map<String, Object> getBill(String id) {

		AssetBorrow data= AssetBorrowServiceProxy.api().getById(id).getData();
		join(data, AssetBorrowMeta.ASSET_LIST);

		Map<String, Object> map= BeanUtil.toMap(data);
		if(data.getStatus()!=null){
			CodeTextEnum en= EnumUtil.parseByCode(AssetHandleStatusEnum.class,data.getStatus());
			map.put("statusName", en==null?data.getStatus():en.text());
		}
		return map;
	}

	private void syncBill(String id, ChangeEvent event) {
		AssetBorrow asset4Update=AssetBorrow.create();
//		asset4Update.setId(id)
//				//设置变更ID
//				.setChangeInstanceId(event.getInstance().getId())
//				//更新状态
//				.setChsStatus(event.getInstance().getStatusEnum().code())
//				//更新最后审批人
//				.setLatestApproverId(event.getApproverId())
//				.setLatestApproverName(event.getApproverName())
//				//设置下一节点审批人
//				.setNextApproverIds(event.getSimpleNextApproverIds())
//				.setNextApproverNames(event.getSimpleNextApproverNames())
//				//更新流程概要
//				.setSummary(event.getDefinition().getName()+","+event.getApproveActionEnum().text());
		//执行更新
		this.update(asset4Update,SaveMode.BESET_FIELDS);
	}

	/**
	 * 启动流程
	 * */
	public Result startProcess(String id) {
		return null;
	}


	/**
	 * 撤销
	 * @param id ID
	 * @return 是否成功
	 * */
	@Override
	public Result revokeOperation(String id) {
		AssetBorrow billData=getById(id);
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

		AssetBorrow billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_BORROW.code()) ) {
				//审批操作
			}else{
				return ErrorDesc.failureMessage("当前操作不需要送审,请直接进行确认操作");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
		return ErrorDesc.success();

	}


	private Result applyChange(String id){
		AssetBorrow billData=getById(id);
		join(billData, AssetBorrowMeta.ASSET_LIST);
		HashMap<String,Object> map=new HashMap<>();
		//保存当前使用人
		dao.execute("update eam_asset_item a,eam_asset b set a.before_use_user_id=b.use_user_id,a.before_asset_status=b.asset_status where a.asset_id=b.id and a.handle_id=?",id);
		map.put("use_user_id",billData.getBorrowerId());
		map.put("asset_status", AssetStatusEnum.BORROW.code());
		HashMap<String,List<SQL>> resultMap=assetService.parseAssetChangeRecordWithChangeAsset(billData.getAssetList(),map,billData.getBusinessCode(),AssetOperateEnum.EAM_ASSET_BORROW.code(),"");
		for(String key:resultMap.keySet()){
			List<SQL> sqls=resultMap.get(key);
			if(sqls.size()>0){
				dao.batchExecute(sqls);
			}
		}
		billData.setBorrowStatus(AssetBorrowStatusEnum.BORROWED.code());
		super.update(billData,SaveMode.NOT_NULL_FIELDS);
		return ErrorDesc.success();
	}



	/**
	 * 操作
	 * @param id  ID
	 * @param result 结果
	 * @return
	 * */
	private Result operateResult(String id,String result,String status,String message) {
		if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){
			Result verifyResult= verifyBillData(id);
			if(!verifyResult.isSuccess()) return verifyResult;

			Result applayResult=applyChange(id);
			if(!applayResult.isSuccess()) return applayResult;
			AssetBorrow bill=new AssetBorrow();
			bill.setId(id);
			bill.setStatus(status);
			return super.update(bill,SaveMode.NOT_NULL_FIELDS);
		}else if(AssetHandleConfirmOperationEnum.FAILED.code().equals(result)){
			return ErrorDesc.failureMessage(message);
		}else{
			return ErrorDesc.failureMessage("返回未知结果");
		}
	}

	/**
	 * 确认操作
	 * @param id ID
	 * @return 是否成功
	 * */
	@Override
	public Result confirmOperation(String id) {
		AssetBorrow billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_BORROW.code()) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(id,AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
	}

	/**
	 * 插入实体
	 * @param assetBorrow 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetBorrow assetBorrow) {

		if(assetBorrow.getAssetIds()==null||assetBorrow.getAssetIds().size()==0){
			String assetSelectedCode=assetBorrow.getSelectedCode();
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode==null?"":assetSelectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
			assetBorrow.setAssetIds(list);
		}

		//校验数据资产
		if(assetBorrow.getAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}

		Result ckResult=assetService.checkAssetDataForBusinessAction(AssetOperateEnum.EAM_ASSET_BORROW.code(),assetBorrow.getAssetIds());
		if(!ckResult.isSuccess()){
			return ckResult;
		}


		//填充制单人
		if( StringUtil.isBlank(assetBorrow.getOriginatorId())){
			assetBorrow.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//业务时间
		if(StringUtil.isBlank(assetBorrow.getBusinessDate())){
			assetBorrow.setBusinessDate(new Date());
		}

		//办理状态
		if(StringUtil.isBlank( assetBorrow.getStatus())){
			assetBorrow.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		//借用状态
		if(StringUtil.isBlank( assetBorrow.getBorrowStatus())){
			assetBorrow.setBorrowStatus(AssetBorrowStatusEnum.NOT_BORROWED.code());
		}

		//生成编码规则
		if(StringUtil.isBlank(assetBorrow.getBusinessCode())){
			Result codeResult=CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_BORROW.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetBorrow.setBusinessCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(assetBorrow);
		if (r.isSuccess()){
			//保存资产数据
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<assetBorrow.getAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setId(IDGenerator.getSnowflakeIdString());
				asset.setHandleId(assetBorrow.getId());
				asset.setAssetId(assetBorrow.getAssetIds().get(i));
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
	 * @param assetBorrowList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetBorrow> assetBorrowList) {
		return super.insertList(assetBorrowList);
	}


	/**
	 * 按主键删除 资产借用
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetBorrow assetBorrow = new AssetBorrow();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetBorrow.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetBorrow);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 按主键删除 资产借用
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetBorrow assetBorrow = new AssetBorrow();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetBorrow.setId(id);
		assetBorrow.setDeleted(dao.getDBTreaty().getTrueValue());
		assetBorrow.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetBorrow.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetBorrow,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
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
		return assetService.checkAssetDataForBusinessAction(CodeModuleEnum.EAM_ASSET_BORROW.code(),ckDatalist);
	}


	/**
	 * 更新实体
	 * @param assetBorrow 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetBorrow assetBorrow , SaveMode mode) {
		//c  新建,r  原纪录,d  删除,cd 新建删除
		//验证数据
		Result verifyResult = verifyBillData(assetBorrow.getId());
		if(!verifyResult.isSuccess())return verifyResult;

		Result r=super.update(assetBorrow,mode);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",assetBorrow.getId());
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and  handle_id=?",assetBorrow.getId());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetBorrowList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetBorrow> assetBorrowList , SaveMode mode) {
		return super.updateList(assetBorrowList , mode);
	}


	/**
	 * 按主键更新字段 资产借用
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
	 * 按主键获取 资产借用
	 *
	 * @param id 主键
	 * @return AssetBorrow 数据对象
	 */
	public AssetBorrow getById(String id) {
		AssetBorrow sample = new AssetBorrow();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetBorrow> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetBorrow> queryList(AssetBorrow sample) {
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
	public PagedList<AssetBorrow> queryPagedList(AssetBorrow sample, int pageSize, int pageIndex) {
		String dp=AssetOperateEnum.EAM_ASSET_BORROW.code();
		return super.queryPagedList(sample, pageSize, pageIndex,dp);
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
	public PagedList<AssetBorrow> queryPagedList(AssetBorrow sample, ConditionExpr condition, int pageSize, int pageIndex) {
		String dp=AssetOperateEnum.EAM_ASSET_BORROW.code();
		return super.queryPagedList(sample, condition, pageSize, pageIndex,dp);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param assetBorrow 数据对象
	 * @return 判断结果
	 */
	public Result<AssetBorrow> checkExists(AssetBorrow assetBorrow) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(assetBorrow, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(AssetBorrow sample) {
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
