package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetDataChangeMeta;
import com.dt.platform.eam.service.IAssetSelectedDataService;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.eam.service.IOperateService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.sql.expr.*;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.constants.enums.changes.ApprovalAction;
import org.github.foxnic.web.constants.enums.changes.ApprovalStatus;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import org.github.foxnic.web.domain.bpm.Appover;
import org.github.foxnic.web.domain.changes.*;
import org.github.foxnic.web.framework.change.ChangesAssistant;
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
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.excel.ExcelStructure;
import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.dt.platform.eam.service.IAssetDataChangeService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 数据变更 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-08 16:01:26
*/


@Service("EamAssetDataChangeService")
public class AssetDataChangeServiceImpl extends SuperService<AssetDataChange> implements IAssetDataChangeService {

	@Autowired
	private IAssetService assetService;

	@Autowired
	private AssetItemServiceImpl assetItemService;

	@Autowired
	private IAssetSelectedDataService assetSelectedDataService;

	@Autowired
	private IOperateService operateService;


	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }


	private void syncBill(String id,ChangeEvent event) {
		AssetDataChange asset4Update=AssetDataChange.create();
		asset4Update.setId(id)
				//设置变更ID
				.setChangeInstanceId(event.getInstance().getId())
				//更新状态
				.setChsStatus(event.getInstance().getStatusEnum().code())
				//更新最后审批人
				.setLatestApproverId(event.getApproverId())
				.setLatestApproverName(event.getApproverName())
				//设置下一节点审批人
				.setNextApproverIds(event.getSimpleNextApproverIds())
				.setNextApproverNames(event.getSimpleNextApproverNames())
				//更新流程概要
				.setSummary(event.getDefinition().getName()+","+event.getApproveActionEnum().text());
		//执行更新
		this.update(asset4Update,SaveMode.BESET_FIELDS);
	}


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}


	@Override
	public Result startProcess(ProcessStartVO startVO) {
		Result result=new Result();
		for (String id : startVO.getBillIds()) {
			Result<ChangeEvent> r=startProcess(id);
			if(r.failure()) {
				result.addError(r);
			} else {
				// 处理逻辑
				ChangeEvent event=r.data();
				syncBill(id,event);
			}
		}
		return result;
	}


	/**
	 * 启动
	 * */
	public Result startProcess(String id) {

		//变更后数据
		AssetDataChange assetAfter=this.getById(id);
		String changeType=assetAfter.getChangeType();
		if(assetAfter==null) {
			return ErrorDesc.failure().message("单据不存在");
		}
		//校验是否勾选的订单都处于待审批状态
//		if(!ApprovalStatus.drafting.code().equals(assetAfter.getChsStatus())) {
//			return ErrorDesc.failure().message("单据状态错误,无法提交审批");
//		}

		//关联订单明细
		this.join(assetAfter, Asset.class);
		List<String> billIds=Arrays.asList(assetAfter.getId());


		//变更前数据
		AssetDataChange assetBefore=this.getById(assetAfter.getId());
		this.join(assetBefore, Asset.class);


		//创建变更辅助工具
		ChangesAssistant assistant=new ChangesAssistant(this);
		ChangeRequestBody requestBody=new ChangeRequestBody(changeType, ChangeType.create);

		//设置当前提交人
		requestBody.setApproverId(SessionUser.getCurrent().getActivatedEmployeeId());
		requestBody.setApproverName(SessionUser.getCurrent().getRealName());

		//可按数据情况，设置不同的审批人；若未设置审批人，则按变更配置中的审批人执行；
		//后续可按审批人对接待办体系
		List<Appover> employeeApprovers=assistant.getEmployeeApproversById("E001","488741245229731840");
		List<Appover> bpmRoleApprovers1=assistant.getBpmRoleApproversById("498946989573017600","498947090244702209");
		List<Appover> bpmRoleApprovers2=assistant.getBpmRoleApproversByCode("drafter","approver");

		List<Appover> appovers=new ArrayList<>();
		appovers.addAll(employeeApprovers);
		appovers.addAll(bpmRoleApprovers1);
		appovers.addAll(bpmRoleApprovers2);

		requestBody.setNextNodeAppovers(appovers);

		//
		requestBody.setDataType(AssetDataChange.class);

		//设置变更前数据,simple审批模式仅支持单据的独立审批
		requestBody.setDataBefore(assetAfter);
		//设置变更后数据,simple审批模式仅支持单据的独立审批
		requestBody.setDataAfter(assetBefore);

		//设置审批单据号
		requestBody.setBillIds(billIds);
		//设置审批意见
		requestBody.setOpinion("启动流程");
		//发起审批

		Result result=assistant.request(requestBody);
		System.out.println(1111);
		return result;
	}

	@Override
	public Result approve(ProcessApproveVO approveVO) {

		Result result=new Result();
		if(approveVO.getInstanceIds()==null || approveVO.getInstanceIds().isEmpty()) {
			return result.success(false).message("至少指定一个变更ID");
		}
		In in=new In(EAMTables.EAM_ASSET_DATA_CHANGE.CHANGE_INSTANCE_ID,approveVO.getInstanceIds());

		List<AssetDataChange> assets=this.queryList(in.toConditionExpr());
		Map<String,List<AssetDataChange>> assetsMap= CollectorUtil.groupBy(assets,AssetDataChange::getChangeInstanceId);
		for (Map.Entry<String,List<AssetDataChange>> e : assetsMap.entrySet()) {
			Result<ChangeEvent> r=this.approve(e.getKey(),e.getValue(),approveVO.getAction(),approveVO.getOpinion());
			if(r.failure()){
				result.addError(r);
			} else {
				//同步订状态
				ChangeEvent event=r.data();
				for (AssetDataChange asset : e.getValue()) {
					syncBill(asset.getId(),event);
					//
				}
			}
		}
		return result;
	}

	@Override
	public Result approve(String instanceId, List<AssetDataChange> assets, String approveAction, String opinion) {

		ApprovalAction action=ApprovalAction.parseByCode(approveAction);

		//审批数据
		if(assets==null || assets.isEmpty()) {
			return ErrorDesc.failure().message("单据不存在");
		}
		AssetDataChange asset=assets.get(0);

		ChangeApproveBody approveBody=new ChangeApproveBody(asset.getChangeType());
		//设置变更ID
		approveBody.setChangeInstanceId(asset.getChangeInstanceId());

		//设置当前提交人
		approveBody.setApproverId(SessionUser.getCurrent().getActivatedEmployeeId());
		approveBody.setApproverName(SessionUser.getCurrent().getRealName());
		approveBody.setApprovalAction(action);

		//设置审批意见
		approveBody.setOpinion(opinion);

		//创建变更辅助工具
		ChangesAssistant assistant=new ChangesAssistant(this);
		//发起审批
		Result result= assistant.approve(approveBody);

		//审批结束
		if(!result.isSuccess()){
			return result;
		}

		//审批结束后的动作
		AssetDataChange chs=new AssetDataChange();
		chs.setId(asset.getId());
		chs.setApprovalOpinion(opinion);
		if(ApprovalAction.agree.code().equals(approveAction)){
			chs.setStatus(AssetHandleStatusEnum.COMPLETE.code());
			//applyChange(asset.getId());
		}else if(ApprovalAction.reject.code().equals(approveAction)){
			chs.setStatus(AssetHandleStatusEnum.DENY.code());
		}else if(ApprovalAction.submit.code().equals(approveAction)){
			//chs.setStatus(AssetHandleStatusEnum.APPROVAL.code());
		}
		if(chs.getStatus()!=null){
			this.update(chs,SaveMode.NOT_NULL_FIELDS);
		}
		return result;
	}



	@Override
	public String queryDataChangeDimensionByChangeType(String changeType) {
		String dim="";
		if(AssetOperateEnum.EAM_ASSET_CHANGE_BASE_INFO.code().equals(changeType)){
			dim=AssetAttributeDimensionEnum.ATTRIBUTION.code();
		}else if(AssetOperateEnum.EAM_ASSET_CHANGE_FINANCIAL.code().equals(changeType)){
			dim=AssetAttributeDimensionEnum.FINANCIAL.code();
		}else if(AssetOperateEnum.EAM_ASSET_CHANGE_MAINTENANCE.code().equals(changeType)){
			dim=AssetAttributeDimensionEnum.MAINTAINER.code();
		}else if(AssetOperateEnum.EAM_ASSET_CHANGE_EQUIPMENT.code().equals(changeType)){
			dim=AssetAttributeDimensionEnum.EQUIPMENT.code();
		}
		return dim;
	}

	/**
	 * 提取获取变更的字段和值
	 * @param rcd
	 * @return 结果集
	 * */
	private HashMap<String, Object> extractDataChangeValue(Rcd rcd) {
		HashMap<String,Object> map=new HashMap<>();
		for(String col:rcd.getOwnerSet().getFields()){
			 Object v=rcd.getValue(col);
			 if(v!=null) map.put(col,v);
		}
		return map;
	}


	/**
	 * 提取获取变更的字段
	 * @param id
	 * @return Rcd
	 * */
	@Override
	public HashMap<String, Object> queryDataChange(String id) {
		AssetDataChange datachange=getById(id);
		String dimension=queryDataChangeDimensionByChangeType(datachange.getChangeType());
		Rcd dataRcd=dao.queryRecord("select * from eam_asset where id=?",id);
		String tentantId= SessionUser.getCurrent().getActivatedTenantId();
		String sql="select b.code from eam_asset_attribute_item a,eam_asset_attribute b where a.attribute_id=b.id and a.deleted=0 and b.deleted=0 and a.owner_code='"+ AssetAttributeItemOwnerEnum.ASSET_CHANGE.code()+"' and a.tenant_id='"+tentantId+"' and form_show='1'";
		if(!StringUtil.isBlank(dimension)){
			sql=sql+" and a.dimension='"+dimension+"'";
		}
		RcdSet colsRs=dao.query(sql);
		List<String> colsList=colsRs.getValueList("code",String.class);
		System.out.println("colList:"+colsList);
		for(String col:dataRcd.getOwnerSet().getFields()){
			System.out.println("\n"+col+"\nrcd column "+col+" before value:"+dataRcd.getString(col));
			if(col.equals("business_code")
					||col.equals("proc_id")
					||col.equals("status")
					||col.equals("owner_code")
					||col.equals("tenant_id")
					||col.equals("originator_id")
					||col.equals("version")
					||col.equals("create_by")
					||col.equals("create_time")
					||col.equals("update_by")
					||col.equals("update_time")
					||col.equals("deleted")
					||col.equals("delete_by")
					||col.equals("delete_time")
					||col.equals("internal_control_label")){
				dataRcd.setValue(col,null);
				System.out.println("rcd column "+col+" after value:"+dataRcd.getString(col));
				continue;
			}
			if(colsList.contains(col)){
				String value=dataRcd.getString(col);
				System.out.println("col:"+col+",exist");
				if(value==null||"".equals(value)){
					System.out.println("col:"+col+" to set null");
					dataRcd.setValue(col,null);
				}
			}else{
				System.out.println("col "+col+",not exist");
				System.out.println("col:"+col+" to set null");
				dataRcd.setValue(col,null);
			}
			System.out.println(col+"rcd column "+col+" after value:"+dataRcd.getString(col));
		}
		return extractDataChangeValue(dataRcd);
	}


	/**
	 * 插入实体
	 * @param assetDataChange 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetDataChange assetDataChange) {
		Result r=super.insert(assetDataChange);
		return r;
	}

	/**
	 * 撤销
	 * @param id ID
	 * @return 是否成功
	 * */
	@Override
	public Result revokeOperation(String id) {
		AssetDataChange billData=getById(id);
		if(AssetHandleStatusEnum.DENY.code().equals(billData.getStatus())||AssetHandleStatusEnum.APPROVAL.code().equals(billData.getStatus())  ){


			ProcessApproveVO processApproveVO=new ProcessApproveVO();
			AssetDataChange bill=getById(id);
			List<String> instances=new ArrayList<>();
			instances.add(bill.getChangeInstanceId());
			processApproveVO.setOpinion("撤销");
			processApproveVO.setInstanceIds(instances);
			processApproveVO.setAction(ApprovalAction.revoke.code());
			Result processApproveResult=approve(processApproveVO);
			if(!processApproveResult.isSuccess()) return processApproveResult;

			billData.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
			billData.setChsStatus("");
			billData.setChangeInstanceId("");
			super.update(billData,SaveMode.NOT_NULL_FIELDS);


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
		AssetDataChange billData=getById(id);
		join(billData, AssetDataChangeMeta.ASSET_LIST);
		if(AssetHandleStatusEnum.DENY.code().equals(billData.getStatus()) ||AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())  ){
			if(operateService.approvalRequired(billData.getChangeType()) ) {
				//审批操作
				//步骤一开始启动流程
				ProcessStartVO startVO=new ProcessStartVO();
				startVO.setOpinion("启动流程");
				List<String> bills=new ArrayList<>();
				bills.add(id);
				startVO.setBillIds(bills);
				Result startReuslt= startProcess(startVO);
				if(!startReuslt.isSuccess()) return startReuslt;


				//步骤二进入提交阶段
				ProcessApproveVO processApproveVO=new ProcessApproveVO();
				AssetDataChange bill=getById(id);
				List<String> instances=new ArrayList<>();
				instances.add(bill.getChangeInstanceId());
				processApproveVO.setOpinion("提交流程");
				processApproveVO.setInstanceIds(instances);
				processApproveVO.setAction(ApprovalAction.submit.code());

				Result processApproveResult=approve(processApproveVO);
				if(!processApproveResult.isSuccess()) return processApproveResult;

//				//步骤三进入修改status
				update(EAMTables.EAM_ASSET_DATA_CHANGE.STATUS,AssetHandleStatusEnum.APPROVAL.code(),id);
			}else{
				return ErrorDesc.failureMessage("当前操作不需要送审,请直接进行确认操作");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
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
			Result applayResult=applyChange(id);
			if(!applayResult.isSuccess()) return applayResult;
			AssetDataChange bill=new AssetDataChange();
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
		AssetDataChange billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(billData.getChangeType()) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(id,AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
	}


	private Result applyChange(String id){
		AssetDataChange billData=getById(id);
		join(billData,AssetDataChangeMeta.ASSET_LIST);
		HashMap<String,List<SQL>> resultMap=assetService.parseAssetChangeRecordWithChangeAsset(billData.getAssetList(),queryDataChange(id),billData.getBusinessCode(),billData.getChangeType(),"");
		for(String key:resultMap.keySet()){
			List<SQL> sqls=resultMap.get(key);
			if(sqls.size()>0){
				dao.batchExecute(sqls);
			}
		}
		return ErrorDesc.success();
	}

	/**
	 * 提取AssetDatachange
	 * @param vo AssetDataChangeRecordVO实体数据
	 * @return 提取AssetDatachange
	 * */
	@Override
	public AssetDataChange extractAssetDataChange(AssetDataChangeRecord vo,String assetSelectedCode) {
		AssetDataChange data=new AssetDataChange();
		List<String> list=new ArrayList<>();
		//获取资产列表
		if(!StringUtil.isBlank(assetSelectedCode)){
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode);
			list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
		}else{
			String handleId=vo.getId();
			ConditionExpr itemRecordCondition=new ConditionExpr();
			itemRecordCondition.andIn("handle_id",handleId);
			itemRecordCondition.andIn("crd","c","r");
			list=assetItemService.queryValues(EAMTables.EAM_ASSET_ITEM.ASSET_ID,String.class,itemRecordCondition);
			data.setId(vo.getId());
		}
		data.setAssetIds(list);
		Asset asset=(Asset)vo;
		asset.setOwnerCode(vo.getChangeType());
		if(StringUtil.isBlank(asset.getId()) && StringUtil.isBlank(asset.getStatus())){
			asset.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		data.setChangeData(asset);
		data.setChangeType(vo.getChangeType());
		data.setChangeDate(vo.getChangeDate());
		data.setChangeNotes(vo.getChangeNotes());
		return data;
	}

	/**
	 * 插入实体
	 * @param assetDataChangeRecord 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insertRecord(AssetDataChangeRecord assetDataChangeRecord) {

		String assetSelectedCode=assetDataChangeRecord.getSelectedCode();
		if(!StringUtil.isBlank(assetSelectedCode)){

			//获取AssetDataChange
			AssetDataChange assetDataChange=extractAssetDataChange(assetDataChangeRecord,assetSelectedCode);

			//assetData
			Asset assetData=assetDataChange.getChangeData();


			//生成编码规则
			Result codeResult= CodeModuleServiceProxy.api().generateCode(assetDataChangeRecord.getChangeType());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetData.setBusinessCode(codeResult.getData().toString());
				assetDataChange.setBusinessCode(codeResult.getData().toString());
			}

			//保存单据资产数据
			Result inserAssetResult=assetService.insert(assetData);
			if(!inserAssetResult.isSuccess())return inserAssetResult;
			assetDataChange.setOriginatorId(assetData.getOriginatorId());
			assetDataChange.setAssetChangeId(assetData.getId());
			assetDataChange.setStatus(assetData.getStatus());
			//直接使用assetId作为基本数据
			assetDataChange.setId(assetData.getId());
			assetDataChange.setBusinessName(assetDataChangeRecord.getBusinessName());

			//判断是否唯一
			if(operateService.queryAssetSerialNumberNeedUnique()){
				if(!StringUtil.isBlank(assetDataChangeRecord.getSerialNumber())){
					if(assetDataChange.getAssetIds().size()>1){
						return  ErrorDesc.failure().message("当前要变更的资产请保持序列唯一,当前序列为:"+assetDataChangeRecord.getSerialNumber());
					}else if(assetDataChange.getAssetIds().size()==1){
						String assetId=assetDataChange.getAssetIds().get(0);
						if(!operateService.queryAssetSerialNumberIsUnique(assetDataChangeRecord.getSerialNumber(),assetId)){
							return ErrorDesc.failure().message("当前资产序列号不唯一:"+assetDataChangeRecord.getSerialNumber());
						}
					}
				}
			}


			//保存单据数据
			Result insertReuslt=insert(assetDataChange);
			if(!insertReuslt.isSuccess()){
				return insertReuslt;
			}

			//保存要修改的资产列表
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<assetDataChange.getAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setId(IDGenerator.getSnowflakeIdString());
				asset.setHandleId(assetDataChange.getId());
				asset.setAssetId(assetDataChange.getAssetIds().get(i));
				saveList.add(asset);
			}
			Result batchInsertReuslt= assetItemService.insertList(saveList);
			if(!batchInsertReuslt.isSuccess()){
				return batchInsertReuslt;
			}

		}else{
			return ErrorDesc.failure().message("请选择资产");
		}


		return ErrorDesc.success();
	}




	/**
	 * 更实体
	 * @param assetDataChangeRecord 实体数据
	 * @return 更新是否成功
	 * */
	@Override
	@Transactional
	public Result updateRecord(AssetDataChangeRecord assetDataChangeRecord){
		//c  新建,r  原纪录,d  删除,cd 新建删除
		//验证数据
		//获取AssetDataChange
		AssetDataChange assetDataChange=extractAssetDataChange(assetDataChangeRecord,null);
		String handleId=assetDataChange.getId();
		if(assetDataChange.getAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}

		//判断是否唯一
		if(operateService.queryAssetSerialNumberNeedUnique()){
			if(!StringUtil.isBlank(assetDataChangeRecord.getSerialNumber())){
				if(assetDataChange.getAssetIds().size()>1){
					return  ErrorDesc.failure().message("当前要变更的资产请保持序列唯一,当前序列为:"+assetDataChangeRecord.getSerialNumber());
				}else if(assetDataChange.getAssetIds().size()==1){
					String assetId=assetDataChange.getAssetIds().get(0);
					if(!operateService.queryAssetSerialNumberIsUnique(assetDataChangeRecord.getSerialNumber(),assetId)){
						return ErrorDesc.failure().message("当前资产序列号不唯一:"+assetDataChangeRecord.getSerialNumber());
					}
				}
			}
		}


		Result updateAssetResult=assetService.update(assetDataChange.getChangeData(),SaveMode.NOT_NULL_FIELDS);
		if(!updateAssetResult.isSuccess())return updateAssetResult;

		assetDataChange.setBusinessName(assetDataChangeRecord.getBusinessName());
		Result r=super.update(assetDataChange,SaveMode.NOT_NULL_FIELDS);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",handleId);
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and handle_id=?",handleId);
		}
		return r;
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetDataChangeList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetDataChange> assetDataChangeList) {
		return super.insertList(assetDataChangeList);
	}
	
	
	/**
	 * 按主键删除 数据变更
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetDataChange assetDataChange = new AssetDataChange();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetDataChange.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetDataChange);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 数据变更
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetDataChange assetDataChange = new AssetDataChange();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetDataChange.setId(id);
		assetDataChange.setDeleted(dao.getDBTreaty().getTrueValue());
		assetDataChange.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetDataChange.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetDataChange,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetDataChange 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetDataChange assetDataChange , SaveMode mode) {

		Result r=super.update(assetDataChange , mode);
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param assetDataChangeList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetDataChange> assetDataChangeList , SaveMode mode) {
		return super.updateList(assetDataChangeList , mode);
	}
	
	
	/**
	 * 按主键更新字段 数据变更
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
	 * 按主键获取 数据变更
	 *
	 * @param id 主键
	 * @return AssetDataChange 数据对象
	 */
	public AssetDataChange getById(String id) {
		AssetDataChange sample = new AssetDataChange();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetDataChange> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetDataChange> queryList(AssetDataChange sample) {
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
	public PagedList<AssetDataChange> queryPagedList(AssetDataChange sample, int pageSize, int pageIndex,String dp) {

		if(StringUtil.isBlank(dp)){
			return super.queryPagedList(sample, pageSize, pageIndex);
		}else{
			return super.queryPagedList(sample, pageSize, pageIndex,dp);
		}

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
	public PagedList<AssetDataChange> queryPagedList(AssetDataChange sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);

	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param assetDataChange 数据对象
	 * @return 判断结果
	 */
	public Result<AssetDataChange> checkExists(AssetDataChange assetDataChange) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(assetDataChange, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(AssetDataChange sample) {
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