package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetRepairMeta;
import com.dt.platform.domain.eam.meta.RepairOrderMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.SQL;
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
 * 维修工单 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 19:33:23
*/


@Service("EamRepairOrderService")
public class RepairOrderServiceImpl extends SuperService<RepairOrder> implements IRepairOrderService {


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


	@Override
	public Result validateDispatchOrder(List<String> ids) {
		ConditionExpr expr=new ConditionExpr();
		expr.andIn("id",ids);
		RepairOrder order=new RepairOrder();
		order.setStatus(AssetHandleStatusEnum.COMPLETE.code());
		order.setRepairStatus(RepairOrderStatusEnum.NOT_DISPATCH.code());
		List<RepairOrder> orderList=this.queryList(order,expr);
		if(orderList.size()!=ids.size()){
			return ErrorDesc.failureMessage("申请单数据不一致,无法完成派单工作");
		}
		return ErrorDesc.success();

	}

	@Override
	public Result dispatchOrder(List<String> ids,String actId) {
		Result validOrder=validateDispatchOrder(ids);
		if(!validOrder.isSuccess()){
			return validOrder;
		}
		return ErrorDesc.success();
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
	public Result approve(String instanceId, List<AssetRepair> assets, String approveAction, String opinion) {
		return null;
	}

	@Override
	public Map<String, Object> getBill(String id) {
		return null;
	}

	@Override
	public Result revokeOperation(String id) {
		return null;
	}

	@Override
	public Result forApproval(String id) {
		return null;
	}


//	private Result applyChange(String id){
//		RepairOrder billData=getById(id);
//		join(billData, RepairOrderMeta.ASSET_LIST);
//		//维修前状态
//		dao.execute("update eam_asset_item a,eam_repair_order b set a.before_asset_status=b.asset_status where a.asset_id=b.id and a.handle_id=?",id);
//		HashMap<String,Object> map=new HashMap<>();
//		map.put("asset_status", AssetStatusEnum.REPAIR.code());
//		HashMap<String,List<SQL>> resultMap=assetService.parseAssetChangeRecordWithChangeAsset(billData.getAssetList(),map,billData.getBusinessCode(),AssetOperateEnum.EAM_ASSET_REPAIR.code(),"维修中");
//		for(String key:resultMap.keySet()){
//			List<SQL> sqls=resultMap.get(key);
//			if(sqls.size()>0){
//				dao.batchExecute(sqls);
//			}
//		}
//		billData.setRepairStatus(AssetRepairStatusEnum.REPAIRING.code());
//		super.update(billData,SaveMode.NOT_NULL_FIELDS);
//		return ErrorDesc.success();
//	}

	/**
	 * 操作
	 * @param id  ID
	 * @param result 结果
	 * @return
	 * */
	private Result operateResult(String id,String result,String status,String message) {
		RepairOrder repair=this.getById(id);
		if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){
			Result verifyResult= verifyBillData(id);
			if(!verifyResult.isSuccess()) return verifyResult;
		//	Result applayResult=applyChange(id);
	//		if(!applayResult.isSuccess()) return applayResult;
			RepairOrder bill=new RepairOrder();
			bill.setId(id);
			bill.setStatus(status);
			Result r=super.update(bill,SaveMode.NOT_NULL_FIELDS,false);
			if(r.isSuccess()){
				this.join(repair, AssetRepairMeta.ASSET_LIST);
				List<Asset> assetList=repair.getAssetList();
				if(assetList!=null&&assetList.size()>0){
					for(Asset asset:assetList){
						AssetProcessRecord assetProcessRecord=new AssetProcessRecord();
						assetProcessRecord.setContent("资产维修操作完成");
						assetProcessRecord.setAssetId(asset.getId());
						assetProcessRecord.setBusinessCode(repair.getBusinessCode());
						assetProcessRecord.setProcessType(AssetOperateEnum.EAM_ASSET_REPAIR_ORDER.code());
						assetProcessRecord.setProcessdTime(new Date());
						assetProcessRecordService.insert(assetProcessRecord);
					}
				}
			}
			return r;
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
		RepairOrder billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_REPAIR_ORDER.code()) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(id, AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
	}


	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param repairOrder  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(RepairOrder repairOrder,boolean throwsException) {
		if(repairOrder.getAssetIds()==null||repairOrder.getAssetIds().size()==0){
			String assetSelectedCode=repairOrder.getSelectedCode();
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode==null?"":assetSelectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
			repairOrder.setAssetIds(list);
		}


		//校验数据资产
		if(repairOrder.getAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}
		Result ckResult=assetService.checkAssetDataForBusinessAction(AssetOperateEnum.EAM_ASSET_REPAIR_ORDER.code(),repairOrder.getAssetIds());
		if(!ckResult.isSuccess()){
			return ckResult;
		}

		//制单人
		if(StringUtil.isBlank(repairOrder.getOriginatorId())){
			repairOrder.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}


		//报修人
		if(StringUtil.isBlank(repairOrder.getReportUserId())){
			repairOrder.setReportUserId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//业务时间
		if(StringUtil.isBlank(repairOrder.getBusinessDate())){
			repairOrder.setBusinessDate(new Date());
		}

		//办理状态
		if(StringUtil.isBlank(repairOrder.getStatus())){
			repairOrder.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		repairOrder.setRepairStatus(RepairOrderStatusEnum.NOT_DISPATCH.code());


		//生成编码规则
		//编码
		if(StringUtil.isBlank(repairOrder.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_REPAIR_ORDER.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				repairOrder.setBusinessCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(repairOrder,throwsException);
		if(r.isSuccess()){
			//保存资产数据
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<repairOrder.getAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setId(IDGenerator.getSnowflakeIdString());
				asset.setHandleId(repairOrder.getId());
				asset.setAssetId(repairOrder.getAssetIds().get(i));
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
	 * 添加，如果语句错误，则抛出异常
	 * @param repairOrder 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(RepairOrder repairOrder) {
		return this.insert(repairOrder,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param repairOrderList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<RepairOrder> repairOrderList) {
		return super.insertList(repairOrderList);
	}

	
	/**
	 * 按主键删除 维修工单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		RepairOrder repairOrder = new RepairOrder();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		repairOrder.setId(id);
		try {
			boolean suc = dao.deleteEntity(repairOrder);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 维修工单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		RepairOrder repairOrder = new RepairOrder();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		repairOrder.setId(id);
		repairOrder.setDeleted(true);
		repairOrder.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		repairOrder.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(repairOrder,SaveMode.NOT_NULL_FIELDS);
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
		return assetService.checkAssetDataForBusinessAction(CodeModuleEnum.EAM_ASSET_REPAIR_ORDER.code(),ckDatalist);
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param repairOrder 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RepairOrder repairOrder , SaveMode mode) {
		return this.update(repairOrder,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param repairOrder 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RepairOrder repairOrder , SaveMode mode,boolean throwsException) {

		Result verifyResult = verifyBillData(repairOrder.getId());
		if(!verifyResult.isSuccess())return verifyResult;
		Result r=super.update(repairOrder,mode,false);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",repairOrder.getId());
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and  handle_id=?",repairOrder.getId());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param repairOrderList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<RepairOrder> repairOrderList , SaveMode mode) {
		return super.updateList(repairOrderList , mode);
	}

	
	/**
	 * 按主键更新字段 维修工单
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
	 * 按主键获取 维修工单
	 *
	 * @param id 主键
	 * @return RepairOrder 数据对象
	 */
	public RepairOrder getById(String id) {
		RepairOrder sample = new RepairOrder();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<RepairOrder> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, RepairOrder> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, RepairOrder::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<RepairOrder> queryList(RepairOrder sample) {
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
	public PagedList<RepairOrder> queryPagedList(RepairOrder sample, int pageSize, int pageIndex) {
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
	public PagedList<RepairOrder> queryPagedList(RepairOrder sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param repairOrder 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(RepairOrder repairOrder) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(repairOrder, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(RepairOrder sample) {
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