package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetStockCollectionMeta;
import com.dt.platform.domain.eam.meta.AssetStockDeliverMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.sql.expr.SQL;
import com.github.foxnic.sql.expr.Update;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
import org.github.foxnic.web.domain.changes.ProcessStartVO;
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
 * 库存出库 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-17 19:24:29
*/


@Service("EamAssetStockDeliverService")
public class AssetStockDeliverServiceImpl extends SuperService<AssetStockDeliver> implements IAssetStockDeliverService {


	@Autowired
	private IAssetService assetService;

	@Autowired
	private IAssetItemService assetItemService;

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



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param assetStockDeliver  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetStockDeliver assetStockDeliver,boolean throwsException) {
		//
		if(assetStockDeliver.getDeliverAssetIds()==null||assetStockDeliver.getDeliverAssetIds().size()==0){
			String assetSelectedCode=assetStockDeliver.getSelectedCode();
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode==null?"":assetSelectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
			assetStockDeliver.setDeliverAssetIds(list);
		}


		//校验数据资产
		if(assetStockDeliver.getDeliverAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}



		//办理状态
		if(StringUtil.isBlank(assetStockDeliver.getStatus())){
			assetStockDeliver.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}


		//出库状态
		if(StringUtil.isBlank(assetStockDeliver.getDeliverStatus())){
			assetStockDeliver.setDeliverStatus(AssetDeliverStatusEnum.WAIT.code());
		}


		//填充制单人
		if( StringUtil.isBlank(assetStockDeliver.getOriginatorId())){
			assetStockDeliver.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}


		//生成编码规则
		if(StringUtil.isBlank(assetStockDeliver.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(queryModuleCode(assetStockDeliver.getOwnerCode()));
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetStockDeliver.setBusinessCode(codeResult.getData().toString());
			}

		}

		Result r=super.insert(assetStockDeliver,throwsException);
		if (r.isSuccess()){
			//保存资产数据
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<assetStockDeliver.getDeliverAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setId(IDGenerator.getSnowflakeIdString());
				asset.setHandleId(assetStockDeliver.getId());
				asset.setAssetId(assetStockDeliver.getDeliverAssetIds().get(i));
				saveList.add(asset);
			}
			Result batchInsertReuslt= assetItemService.insertList(saveList);
			if(!batchInsertReuslt.isSuccess()){
				return batchInsertReuslt;
			}
		}
		return r;
	}

	private String queryModuleCode(String ownerCode){
		String moduleCode="";
		if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(ownerCode)){
			moduleCode= CodeModuleEnum.EAM_ASSET_STOCK_DELIVER.code();
		}else if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(ownerCode)){
			moduleCode=CodeModuleEnum.EAM_ASSET_CONSUMABLES_DELIVER.code();
		}
		return moduleCode;
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

	private String queryOperateCode(String ownerCode){
		String operCode="";
		if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(ownerCode)){
			operCode= AssetOperateEnum.EAM_ASSET_STOCK_DELIVER.code();
		}else if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(ownerCode)){
			operCode=CodeModuleEnum.EAM_ASSET_CONSUMABLES_DELIVER.code();
		}
		return operCode;
	}

	private Result checkStock(String id){

		String sql="select * from (\t\t\t\n" +
				"SELECT source_code, SUM(source_remain_number) AS source_remain_number, SUM(remain_number) AS remain_number\n" +
				"FROM (\n" +
				"\tSELECT (\n" +
				"\t\t\tSELECT asset_code\n" +
				"\t\t\tFROM eam_asset i\n" +
				"\t\t\tWHERE i.id = t.internal_control_label\n" +
				"\t\t) AS source_code\n" +
				"\t\t, (\n" +
				"\t\t\tSELECT remain_number\n" +
				"\t\t\tFROM eam_asset i\n" +
				"\t\t\tWHERE i.id = t.internal_control_label\n" +
				"\t\t) AS source_remain_number, t.internal_control_label AS source_asset_id, id, remain_number\n" +
				"\tFROM eam_asset t\n" +
				"\tWHERE id IN (\n" +
				"\t\tSELECT asset_id\n" +
				"\t\tFROM eam_asset_item\n" +
				"\t\tWHERE handle_id = ?\n" +
				"\t\t\tAND deleted = '0'\n" +
				"\t)\n" +
				") end\n" +
				"GROUP BY source_code ) out2 where out2.remain_number>out2.source_remain_number";
		RcdSet rs=dao.query(sql,id);
		if(rs.size()==0){
			return ErrorDesc.success();
		}
		return ErrorDesc.failureMessage("当前库存不足,编号:"+rs.getRcd(0).getString("source_code"));
	}
	private Result applyChange(String id){

		String sql="\t\tSELECT (\n" +
				"\t\t\tSELECT asset_code\n" +
				"\t\t\tFROM eam_asset i\n" +
				"\t\t\tWHERE i.id = t.internal_control_label\n" +
				"\t\t) AS source_code\n" +
				"\t\t, (\n" +
				"\t\t\tSELECT remain_number\n" +
				"\t\t\tFROM eam_asset i\n" +
				"\t\t\tWHERE i.id = t.internal_control_label\n" +
				"\t\t) AS source_remain_number, t.internal_control_label AS source_asset_id, id, remain_number\n" +
				"\tFROM eam_asset t\n" +
				"\tWHERE id IN (\n" +
				"\t\tSELECT asset_id\n" +
				"\t\tFROM eam_asset_item\n" +
				"\t\tWHERE handle_id = ?\n" +
				"\t\t\tAND deleted = '0'\n" +
				"\t)";
		RcdSet rs=dao.query(sql,id);
		List<SQL> list=new ArrayList<>();
		for(Rcd r:rs){
			Update ups=new Update("eam_asset");
			ups.setExpr("remain_number","remain_number-"+r.getString("remain_number"));
			ups.where().and("id=?",r.getString("source_asset_id"));
			list.add(ups);
		}
		if(list.size()>0){
			dao.batchExecute(list);
		}
		return ErrorDesc.success();

	}
	/**
	 * 操作
	 * @param result  result
	 * @param result 结果
	 * @return
	 * */
	private Result operateResult(AssetStockDeliver asset,String result,String status,String message) {
		String operCode=queryOperateCode(asset.getOwnerCode());
		if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){
			Result verifyResult= checkStock(asset.getId());
			if(!verifyResult.isSuccess()) return verifyResult;

			Result applayResult=applyChange(asset.getId());
			if(!applayResult.isSuccess()) return applayResult;

			AssetStockDeliver bill=new AssetStockDeliver();
			bill.setId(asset.getId());
			bill.setStatus(status);

			Result r=super.update(bill,SaveMode.NOT_NULL_FIELDS,false);
			if(r.isSuccess()){
				//减去库存
				join(asset, AssetStockDeliverMeta.DELIVER_ASSET_LIST);
				List<Asset> assetList=asset.getDeliverAssetList();
				if(assetList.size()>0){
					for(int i=0;i<assetList.size();i++){
						String sql="update asset set asset_number=asset_number-"+assetList.get(i).getAssetNumber()+",remain_number=remain_number-"+assetList.get(i).getAssetNumber()+" where id=?";
						dao.execute(sql,assetList.get(i).getInternalControlLabel());
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


	@Override
	public Result confirmOperation(String id) {
		AssetStockDeliver billData=getById(id);
		String operCode=queryOperateCode(billData.getOwnerCode());
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(operCode) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(billData, AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetStockDeliver 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetStockDeliver assetStockDeliver) {
		return this.insert(assetStockDeliver,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetStockDeliverList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetStockDeliver> assetStockDeliverList) {
		return super.insertList(assetStockDeliverList);
	}

	
	/**
	 * 按主键删除 库存出库
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetStockDeliver assetStockDeliver = new AssetStockDeliver();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockDeliver.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetStockDeliver);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 库存出库
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetStockDeliver assetStockDeliver = new AssetStockDeliver();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockDeliver.setId(id);
		assetStockDeliver.setDeleted(dao.getDBTreaty().getTrueValue());
		assetStockDeliver.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetStockDeliver.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetStockDeliver,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetStockDeliver 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockDeliver assetStockDeliver , SaveMode mode) {
		return this.update(assetStockDeliver,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetStockDeliver 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockDeliver assetStockDeliver , SaveMode mode,boolean throwsException) {
		Result r=super.update(assetStockDeliver , mode , throwsException);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",assetStockDeliver.getId());
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and  handle_id=?",assetStockDeliver.getId());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetStockDeliverList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetStockDeliver> assetStockDeliverList , SaveMode mode) {
		return super.updateList(assetStockDeliverList , mode);
	}

	
	/**
	 * 按主键更新字段 库存出库
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
	 * 按主键获取 库存出库
	 *
	 * @param id 主键
	 * @return AssetStockDeliver 数据对象
	 */
	public AssetStockDeliver getById(String id) {
		AssetStockDeliver sample = new AssetStockDeliver();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetStockDeliver> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetStockDeliver> queryList(AssetStockDeliver sample) {
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
	public PagedList<AssetStockDeliver> queryPagedList(AssetStockDeliver sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetStockDeliver> queryPagedList(AssetStockDeliver sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetStockDeliver 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetStockDeliver assetStockDeliver) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetStockDeliver, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(AssetStockDeliver sample) {
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
