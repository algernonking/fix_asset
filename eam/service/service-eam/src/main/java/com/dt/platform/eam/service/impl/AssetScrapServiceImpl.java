package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetBorrowMeta;
import com.dt.platform.domain.eam.meta.AssetDataChangeMeta;
import com.dt.platform.domain.eam.meta.AssetRepairMeta;
import com.dt.platform.domain.eam.meta.AssetScrapMeta;
import com.dt.platform.eam.common.AssetCommonError;
import com.dt.platform.eam.service.IAssetSelectedDataService;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.eam.service.IOperateService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.dt.platform.proxy.eam.AssetRepairServiceProxy;
import com.dt.platform.proxy.eam.AssetScrapServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.SQL;
import org.github.foxnic.web.constants.enums.changes.ApprovalAction;
import org.github.foxnic.web.constants.enums.changes.ApprovalMode;
import org.github.foxnic.web.constants.enums.changes.ChangeType;
import org.github.foxnic.web.domain.bpm.Appover;
import org.github.foxnic.web.domain.changes.*;
import org.github.foxnic.web.framework.change.ChangesAssistant;
import org.github.foxnic.web.proxy.changes.ChangeDefinitionServiceProxy;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.dt.platform.eam.service.IAssetScrapService;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 资产报废 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-21 05:51:18
*/


@Service("EamAssetScrapService")
public class AssetScrapServiceImpl extends SuperService<AssetScrap> implements IAssetScrapService {
	
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
	
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	@Autowired
	private IOperateService operateService;


	@Override
	public Result cleanOut(String id) {

		AssetScrap billData=getById(id);
		if(AssetHandleStatusEnum.COMPLETE.code().equals(billData.getStatus())){
			String sql="update eam_asset set asset_status='"+AssetStatusEnum.HANDLED+"',owner_code=? where id in (select asset_id from eam_asset_item where handle_id=? and crd in ('r','c') and deleted=0)";
			dao.execute(sql, AssetOwnerCodeEnum.ASSET_CLEAN_OUT.code(),id);
			AssetScrap bill=new AssetScrap();
			bill.setId(id);
			bill.setCleanStatus(AssetHandleStatusEnum.COMPLETE.code());
			return super.update(bill,SaveMode.NOT_NULL_FIELDS);
		}else{
			return ErrorDesc.failureMessage("当前单据状态，不能对资产进行清理。");
		}

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

	@Override
	public Result approve(ProcessApproveVO approveVO) {

		Result result=new Result();
		if(approveVO.getInstanceIds()==null || approveVO.getInstanceIds().isEmpty()) {
			return result.success(false).message("至少指定一个变更ID");
		}
		In in=new In(EAMTables.EAM_ASSET_SCRAP.CHANGE_INSTANCE_ID,approveVO.getInstanceIds());

		List<AssetScrap> assets=this.queryList(in.toConditionExpr());
		Map<String,List<AssetScrap>> assetsMap= CollectorUtil.groupBy(assets,AssetScrap::getChangeInstanceId);
		for (Map.Entry<String,List<AssetScrap>> e : assetsMap.entrySet()) {
			Result<ChangeEvent> r=this.approve(e.getKey(),e.getValue(),approveVO.getAction(),approveVO.getOpinion());
			if(r.failure()){
				result.addError(r);
			} else {
				//同步订状态
				ChangeEvent event=r.data();
				for (AssetScrap asset : e.getValue()) {
					syncBill(asset.getId(),event);
					//
				}
			}
		}
		return result;
	}



	@Override
	public Result approve(String instanceId, List<AssetScrap> assets, String approveAction, String opinion) {
		ApprovalAction action=ApprovalAction.parseByCode(approveAction);

		//审批数据
		if(assets==null || assets.isEmpty()) {
			return ErrorDesc.failure().message("单据不存在");
		}
		AssetScrap asset=assets.get(0);

		ChangeApproveBody approveBody=new ChangeApproveBody("eam_asset_scrap");
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
		AssetScrap chs=new AssetScrap();
		chs.setId(asset.getId());
		chs.setApprovalOpinion(opinion);
		if(ApprovalAction.agree.code().equals(approveAction)){
			chs.setStatus(AssetHandleStatusEnum.COMPLETE.code());
			operateResult(asset.getId(),AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
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
	public Map<String, Object> getBill(String id) {
		AssetScrap data= AssetScrapServiceProxy.api().getById(id).getData();
		join(data, AssetScrapMeta.ASSET_LIST);

		Map<String, Object> map= BeanUtil.toMap(data);
		if(data.getStatus()!=null){
			CodeTextEnum en= EnumUtil.parseByCode(AssetHandleStatusEnum.class,data.getStatus());
			map.put("statusName", en==null?data.getStatus():en.text());
		}
		return map;
	}

	private void syncBill(String id, ChangeEvent event) {
		AssetScrap asset4Update=AssetScrap.create();
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

	/**
	 * 启动流程
	 * */
	public Result startProcess(String id) {

		//变更后数据
		AssetScrap assetAfter=this.getById(id);
		String changeType="eam_asset_scrap";
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
		AssetScrap assetBefore=this.getById(assetAfter.getId());
		this.join(assetBefore, Asset.class);


		//创建变更辅助工具
		ChangesAssistant assistant=new ChangesAssistant(this);
		ChangeRequestBody requestBody=new ChangeRequestBody(changeType, ChangeType.create);

		//设置当前提交人
		requestBody.setApproverId(SessionUser.getCurrent().getActivatedEmployeeId());
		requestBody.setApproverName(SessionUser.getCurrent().getRealName());

		//可按数据情况，设置不同的审批人；若未设置审批人，则按变更配置中的审批人执行；
		//后续可按审批人对接待办体系
		String simpleApprovers=dao.queryRecord("select simple_approvers from chs_change_definition where code=?",changeType).getString("simple_approvers");
		if(!StringUtil.isBlank(simpleApprovers)){
			List<Appover> appoverList=new ArrayList<>();
			JSONArray sarr=JSONArray.parseArray(simpleApprovers);
			for(int i=0;i<sarr.size();i++){
				JSONObject e=sarr.getJSONObject(i);
				String targetId=e.getString("targetId");
				String targetType=e.getString("targetType");
				if("busi_role".equals(targetType)){
					List<Appover> bpmRoleApprovers1=assistant.getBpmRoleApproversById(targetId);
					appoverList.addAll(bpmRoleApprovers1);
				}else if("employee".equals(targetType)){
					List<Appover> approvers1=assistant.getEmployeeApproversById(targetId);
					appoverList.addAll(approvers1);
				}
			}
			requestBody.setNextNodeAppovers(appoverList);
		}

		//
		requestBody.setDataType(AssetScrap.class);

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
		return result;
	}



	/**
	 * 撤销
	 * @param id ID
	 * @return 是否成功
	 * */
	@Override
	public Result revokeOperation(String id) {
		AssetScrap billData=getById(id);
		if(AssetHandleStatusEnum.DENY.code().equals(billData.getStatus())||AssetHandleStatusEnum.APPROVAL.code().equals(billData.getStatus())  ){
			ProcessApproveVO processApproveVO=new ProcessApproveVO();
			AssetScrap bill=getById(id);
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

		AssetScrap billData=getById(id);
		join(billData, AssetScrapMeta.ASSET_LIST);
		if(AssetHandleStatusEnum.DENY.code().equals(billData.getStatus()) ||AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())  ){
			if(operateService.approvalRequired("eam_asset_scrap") ) {
				ChangeDefinitionVO changeDefinitionVO=new ChangeDefinitionVO();
				changeDefinitionVO.setCode("eam_asset_scrap");


				Result<List<ChangeDefinition>> changeDefinitionResult= ChangeDefinitionServiceProxy.api().queryList(changeDefinitionVO);
				if(!changeDefinitionResult.isSuccess()){
					return ErrorDesc.failureMessage("获取流程配置失败");
				}else{
					if(changeDefinitionResult.getData().size()==0){
						return ErrorDesc.failureMessage("未配置流程信息");
					}
					ChangeDefinition ChangeDefinition=changeDefinitionResult.getData().get(0);
					if(!ApprovalMode.simple.code().equals(ChangeDefinition.getMode())){
						return ErrorDesc.failureMessage("当前只支持简单流程方式");
					}
				}

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
				AssetScrap bill=getById(id);
				List<String> instances=new ArrayList<>();
				instances.add(bill.getChangeInstanceId());
				processApproveVO.setOpinion("提交流程");
				processApproveVO.setInstanceIds(instances);
				processApproveVO.setAction(ApprovalAction.submit.code());

				Result processApproveResult=approve(processApproveVO);
				if(!processApproveResult.isSuccess()) return processApproveResult;

//				//步骤三进入修改status
				update(EAMTables.EAM_ASSET_SCRAP.STATUS,AssetHandleStatusEnum.APPROVAL.code(),id);
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
	@Transactional
	Result operateResult(String id,String result,String status,String message) {
		if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){
			Result verifyResult= verifyBillData(id);
			if(!verifyResult.isSuccess()) return verifyResult;

			Result applayResult=applyChange(id);
			if(!applayResult.isSuccess()) return applayResult;
			AssetScrap bill=new AssetScrap();
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
	@Transactional
	public Result confirmOperation(String id) {
		AssetScrap billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_SCRAP.code()) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(id,AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
	}


	private Result applyChange(String id){
		AssetScrap billData=getById(id);
		join(billData, AssetScrapMeta.ASSET_LIST);
		HashMap<String,Object> map=new HashMap<>();
		map.put("asset_status", AssetStatusEnum.SCRAP.code());
		HashMap<String,List<SQL>> resultMap=assetService.parseAssetChangeRecordWithChangeAsset(billData.getAssetList(),map,billData.getBusinessCode(),AssetOperateEnum.EAM_ASSET_SCRAP.code(),"完成报废");
		for(String key:resultMap.keySet()){
			List<SQL> sqls=resultMap.get(key);
			if(sqls.size()>0){
				dao.batchExecute(sqls);
			}
		}
		return ErrorDesc.success();
	}



	/**
	 * 插入实体
	 * @param assetScrap 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(AssetScrap assetScrap) {

		if(assetScrap.getAssetIds()==null||assetScrap.getAssetIds().size()==0){
			String assetSelectedCode=assetScrap.getSelectedCode();
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode==null?"":assetSelectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
			assetScrap.setAssetIds(list);
		}

		//校验数据资产
		if(assetScrap.getAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}


		assetScrap.setCleanStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		Result ckResult=assetService.checkAssetDataForBusiessAction(AssetOperateEnum.EAM_ASSET_SCRAP.code(),assetScrap.getAssetIds());
		if(!ckResult.isSuccess()){
			return ckResult;
		}

		//制单人
		if(StringUtil.isBlank(assetScrap.getOriginatorId())){
			assetScrap.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//业务时间
		if(StringUtil.isBlank(assetScrap.getBusinessDate())){
			assetScrap.setBusinessDate(new Date());
		}

		//办理状态
		if(StringUtil.isBlank(assetScrap.getStatus())){
			assetScrap.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		//生成编码规则
		if(StringUtil.isBlank(assetScrap.getBusinessCode())){
			Result codeResult=CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_SCRAP.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetScrap.setBusinessCode(codeResult.getData().toString());
			}
		}


		Result r=super.insert(assetScrap);
		if (r.isSuccess()){
			//保存资产数据
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<assetScrap.getAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setId(IDGenerator.getSnowflakeIdString());
				asset.setHandleId(assetScrap.getId());
				asset.setAssetId(assetScrap.getAssetIds().get(i));
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
	 * @param assetScrapList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetScrap> assetScrapList) {
		return super.insertList(assetScrapList);
	}
	
	
	/**
	 * 按主键删除 资产报废
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetScrap assetScrap = new AssetScrap();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetScrap.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetScrap);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产报废
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetScrap assetScrap = new AssetScrap();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetScrap.setId(id);
		assetScrap.setDeleted(dao.getDBTreaty().getTrueValue());
		assetScrap.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetScrap.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetScrap,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetScrap 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(AssetScrap assetScrap , SaveMode mode) {
		//c  新建,r  原纪录,d  删除,cd 新建删除
		//验证数据
		Result verifyResult=verifyBillData(assetScrap.getId());
		if(!verifyResult.isSuccess())return verifyResult;
		Result r=super.update(assetScrap,mode);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",assetScrap.getId());
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and  handle_id=?",assetScrap.getId());
		}
		return r;
	}

	private Result verifyBillData(String id){
		ConditionExpr itemRecordCondition=new ConditionExpr();
		itemRecordCondition.andIn("handle_id",id);
		itemRecordCondition.andIn("crd","c","r");
		List<String> ckDatalist=assetItemService.queryValues(EAMTables.EAM_ASSET_ITEM.ASSET_ID,String.class,itemRecordCondition);
		if(ckDatalist.size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}
		return assetService.checkAssetDataForBusiessAction(CodeModuleEnum.EAM_ASSET_SCRAP.code(),ckDatalist);
	}
	
	/**
	 * 更新实体集，事务内
	 * @param assetScrapList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetScrap> assetScrapList , SaveMode mode) {
		return super.updateList(assetScrapList , mode);
	}
	
	
	/**
	 * 按主键更新字段 资产报废
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
	 * 按主键获取 资产报废
	 *
	 * @param id 主键
	 * @return AssetScrap 数据对象
	 */
	public AssetScrap getById(String id) {
		AssetScrap sample = new AssetScrap();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetScrap> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetScrap> queryList(AssetScrap sample) {
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
	public PagedList<AssetScrap> queryPagedList(AssetScrap sample, int pageSize, int pageIndex) {
		String dp=AssetOperateEnum.EAM_ASSET_SCRAP.code();
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
	public PagedList<AssetScrap> queryPagedList(AssetScrap sample, ConditionExpr condition, int pageSize, int pageIndex) {
		String dp=AssetOperateEnum.EAM_ASSET_SCRAP.code();
		return super.queryPagedList(sample, condition, pageSize, pageIndex,dp);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param assetScrap 数据对象
	 * @return 判断结果
	 */
	public Result<AssetScrap> checkExists(AssetScrap assetScrap) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(assetScrap, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(AssetScrap sample) {
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