package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;


import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetApprovalTypeEnum;
import com.dt.platform.constants.enums.eam.AssetHandleConfirmOperationEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetSelectedDataMeta;
import com.dt.platform.eam.common.AssetCommonError;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeAllocationServiceProxy;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.api.error.CommonError;
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
	private IOperateService operateService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}


	/**
	 * 送审
	 * @param id ID
	 * @return 是否成功
	 * */
	@Override
	public Result forApproval(String id){

		return ErrorDesc.success();
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
		}else if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){
			return operateFailed(id);
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
		if(AssetHandleStatusEnum.INCOMPLETE.equals(billData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_ALLOCATE.code()) ) {
				//发起审批
			}else{
				//确认单据

			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行过该操作");
		}
		return ErrorDesc.success();
	}
	/**
	 * 插入实体
	 * @param assetBorrow 实体数据
	 * @param assetSelectedCode 数据标记
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetBorrow assetBorrow,String assetSelectedCode) {

		if(!StringUtil.isBlank(assetSelectedCode)){
			//获取资产列表
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_SELECTED_CODE,String.class,condition);
			assetBorrow.setAssetIds(list);
			//保存单据数据
			Result insertReuslt=insert(assetBorrow);
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
	 * @param assetBorrow 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetBorrow assetBorrow) {

		//校验数据资产
		if(assetBorrow.getAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}
		Result ckResult=assetService.checkAssetDataForBusiessAction(AssetOperateEnum.EAM_ASSET_BORROW.code(),assetBorrow.getAssetIds());
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
		String handleId=assetBorrow.getId();
		ConditionExpr itemRecordCondition=new ConditionExpr();
		itemRecordCondition.andIn("handle_id",handleId);
		itemRecordCondition.andIn("crd","c","r");
		List<String> ckDatalist=assetItemService.queryValues(EAMTables.EAM_ASSET_ITEM.ASSET_ID,String.class,itemRecordCondition);
		assetBorrow.setAssetIds(ckDatalist);
		if(assetBorrow.getAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}
		Result ckResult=assetService.checkAssetDataForBusiessAction(CodeModuleEnum.EAM_ASSET_BORROW.code(),assetBorrow.getAssetIds());
		if(!ckResult.isSuccess()){
			return ckResult;
		}
		Result r=super.update(assetBorrow,mode);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",handleId);
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and  handle_id=?",handleId);
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
		return new ArrayList<>(getByIdsMap(ids).values());
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
	public PagedList<AssetBorrow> queryPagedList(AssetBorrow sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
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