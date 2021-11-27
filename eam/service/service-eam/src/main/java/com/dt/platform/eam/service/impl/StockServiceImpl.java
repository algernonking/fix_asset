package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.StockMeta;
import com.dt.platform.eam.service.IAssetSelectedDataService;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.eam.service.IOperateService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
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
import com.dt.platform.eam.service.IStockService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 资产库存 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-22 13:52:26
*/


@Service("EamStockService")
public class StockServiceImpl extends SuperService<Stock> implements IStockService {

	@Autowired
	private AssetItemServiceImpl assetItemService;

	@Autowired
	private IAssetSelectedDataService assetSelectedDataService;

	@Autowired
	private IAssetService assetService;

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


	@Override
	public Result startProcess(ProcessStartVO startVO) {
		return null;
	}

	@Override
	public Result approve(ProcessApproveVO approveVO) {
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

	@Override
	public Result confirmOperation(String id) {
		Stock billData=getById(id);
		String code="";
		if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(billData.getOwnerCode())){
			code=AssetOperateEnum.EAM_ASSET_CONSUMABLES_STOCK_IN.code();
		}else if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(billData.getOwnerCode())){
			code=AssetOperateEnum.EAM_ASSET_STOCK_IN.code();
		}

		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(code) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(id,AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}

	}

	/**
	 * 操作
	 * @param id  ID
	 * @param result 结果
	 * @return
	 * */
	private Result operateResult(String id,String result,String status,String message) {
		Stock stock=this.getById(id);
		dao().fill(stock)
				.with(StockMeta.STOCK_ASSET_LIST)
				.execute();

		if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){
			stock.setId(id);
			stock.setStatus(status);
			super.update(stock,SaveMode.NOT_NULL_FIELDS);
			List<Asset> assetList=stock.getStockAssetList();
			if(assetList!=null&&assetList.size()>0){
				for(int i=0;i<assetList.size();i++){
					assetList.get(i).setStatus(status);
					if(StringUtil.isBlank(assetList.get(i).getWarehouseId())){
						assetList.get(i).setWarehouseId(stock.getWarehouseId());
					}
					if(StringUtil.isBlank(assetList.get(i).getOwnCompanyId())){
						assetList.get(i).setOwnCompanyId(stock.getOwnCompanyId());
					}
					if(StringUtil.isBlank(assetList.get(i).getSourceId())){
						assetList.get(i).setSourceId(stock.getSourceId());
					}
					if(StringUtil.isBlank(assetList.get(i).getManagerId())){
						assetList.get(i).setManagerId(stock.getManagerId());
					}
					if(StringUtil.isBlank(assetList.get(i).getSupplierId())){
						assetList.get(i).setSupplierId(stock.getSupplierId());
					}
					if(StringUtil.isBlank(assetList.get(i).getBatchCode())){
						assetList.get(i).setBatchCode(stock.getStockBatchCode());
					}
				}
				assetService.updateList(assetList,SaveMode.NOT_NULL_FIELDS);
			}
			return ErrorDesc.success();
		}else if(AssetHandleConfirmOperationEnum.FAILED.code().equals(result)){
			return ErrorDesc.failureMessage(message);
		}else{
			return ErrorDesc.failureMessage("返回未知结果");
		}
	}


	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param stock  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(Stock stock,boolean throwsException) {

		if(stock.getStockAssetIds()==null||stock.getStockAssetIds().size()==0){
			String assetSelectedCode=stock.getSelectedCode();
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode==null?"":assetSelectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
			stock.setStockAssetIds(list);
		}

		if(stock.getStockAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}

		Result ckResult=assetService.checkAssetDataForBusiessAction(AssetOperateEnum.EAM_ASSET_COLLECTION.code(),stock.getStockAssetIds());
		if(!ckResult.isSuccess()){
			return ckResult;
		}



		//填充制单人
		if( StringUtil.isBlank(stock.getOriginatorId())){
			stock.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//业务时间
		if(StringUtil.isBlank(stock.getBusinessDate())){
			stock.setBusinessDate(new Date());
		}
		//办理状态
		if(StringUtil.isBlank( stock.getStatus())){
			stock.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		//办理状态
		if(StringUtil.isBlank(stock.getStockType())){
			stock.setStockType(AssetStockTypeEnum.IN.code());
		}

		//生成编码规则
		if(StringUtil.isBlank(stock.getBusinessCode())){
			String code=AssetOperateEnum.EAM_ASSET_STOCK_IN.code();
			if(AssetOwnerCodeEnum.ASSET_STOCK.code().equals(stock.getOwnerCode())){
				if(AssetStockTypeEnum.IN.code().equals(stock.getStockType())){
					code=CodeModuleEnum.EAM_ASSET_STOCK_IN.code();
				}else if(AssetStockTypeEnum.OUT.code().equals(stock.getStockType())){
					code=CodeModuleEnum.EAM_ASSET_STOCK_OUT.code();
				}else if(AssetStockTypeEnum.ALLOCATE.code().equals(stock.getStockType())){
					code=CodeModuleEnum.EAM_ASSET_STOCK_ALLOCATE.code();
				}
			}else if(AssetOwnerCodeEnum.ASSET_CONSUMABLES.code().equals(stock.getOwnerCode())){
				if(AssetStockTypeEnum.IN.code().equals(stock.getStockType())){
					code=CodeModuleEnum.EAM_ASSET_CONSUMABLES_STOCK_IN.code();
				}else if(AssetStockTypeEnum.OUT.code().equals(stock.getStockType())){
					code=CodeModuleEnum.EAM_ASSET_CONSUMABLES_STOCK_OUT.code();
				}else if(AssetStockTypeEnum.ALLOCATE.code().equals(stock.getStockType())){
					code=CodeModuleEnum.EAM_ASSET_CONSUMABLES_ALLOCATE.code();
				}
			}

			Result codeResult= CodeModuleServiceProxy.api().generateCode(code);
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				stock.setBusinessCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(stock,throwsException);


		if (r.isSuccess()){
			//保存资产数据
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<stock.getStockAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setId(IDGenerator.getSnowflakeIdString());
				asset.setHandleId(stock.getId());
				asset.setAssetId(stock.getStockAssetIds().get(i));
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
	 * @param stock 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Stock stock) {
		return this.insert(stock,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param stockList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Stock> stockList) {
		return super.insertList(stockList);
	}

	
	/**
	 * 按主键删除 资产库存
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Stock stock = new Stock();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		stock.setId(id);
		try {
			boolean suc = dao.deleteEntity(stock);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产库存
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Stock stock = new Stock();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		stock.setId(id);
		stock.setDeleted(dao.getDBTreaty().getTrueValue());
		stock.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		stock.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(stock,SaveMode.NOT_NULL_FIELDS);
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
	 * @param stock 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Stock stock , SaveMode mode) {
		return this.update(stock,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param stock 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Stock stock , SaveMode mode,boolean throwsException) {
		Result r=super.update(stock , mode , throwsException);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",stock.getId());
			dao.execute("delete from eam_asset_item where crd in ('d','rd') and  handle_id=?",stock.getId());
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param stockList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Stock> stockList , SaveMode mode) {
		return super.updateList(stockList , mode);
	}

	
	/**
	 * 按主键更新字段 资产库存
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
	 * 按主键获取 资产库存
	 *
	 * @param id 主键
	 * @return Stock 数据对象
	 */
	public Stock getById(String id) {
		Stock sample = new Stock();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Stock> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Stock> queryList(Stock sample) {
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
	public PagedList<Stock> queryPagedList(Stock sample, int pageSize, int pageIndex) {
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
	public PagedList<Stock> queryPagedList(Stock sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param stock 数据对象
	 * @return 判断结果
	 */
	public Result<Stock> checkExists(Stock stock) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(stock, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Stock sample) {
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