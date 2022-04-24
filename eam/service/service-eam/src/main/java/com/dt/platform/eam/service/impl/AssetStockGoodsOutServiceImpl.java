package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetHandleConfirmOperationEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.AssetStockGoodsTypeEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta;
import com.dt.platform.eam.service.IGoodsStockService;
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
import com.dt.platform.eam.service.IAssetStockGoodsOutService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 库存出库 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-22 20:46:11
*/


@Service("EamAssetStockGoodsOutService")
public class AssetStockGoodsOutServiceImpl extends SuperService<AssetStockGoodsOut> implements IAssetStockGoodsOutService {

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
	private IOperateService operateService;

	@Autowired
	private IGoodsStockService goodsStockService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param assetStockGoodsOut  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetStockGoodsOut assetStockGoodsOut,boolean throwsException) {
		String selectedCode=assetStockGoodsOut.getSelectedCode();
		GoodsStock qE=new GoodsStock();
		qE.setSelectedCode(selectedCode);
		List<GoodsStock> list =goodsStockService.queryList(qE);
		if(list.size()==0){
			return ErrorDesc.failureMessage("请选择数据");
		}


		//制单人、
		if(StringUtil.isBlank(assetStockGoodsOut.getOriginatorId())){
			assetStockGoodsOut.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//办理情况
		if(StringUtil.isBlank(assetStockGoodsOut.getStatus())){
			assetStockGoodsOut.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}



		//登记日期
		if(assetStockGoodsOut.getBusinessDate()==null){
			assetStockGoodsOut.setBusinessDate(new Date());
		}

		//编码
		String codeRule="";
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(assetStockGoodsOut.getOwnerType())){
			codeRule= CodeModuleEnum.EAM_ASSET_STOCK_GOODS_OUT.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(assetStockGoodsOut.getOwnerType())){
			codeRule= CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_OUT.code();
		}
		if(StringUtil.isBlank(assetStockGoodsOut.getBusinessCode())){
			if(!StringUtil.isBlank(codeRule)){
				if(!StringUtil.isBlank(codeRule)){
					Result codeResult= CodeModuleServiceProxy.api().generateCode(codeRule) ;
					if(!codeResult.isSuccess()){
						return codeResult;
					}else{
						assetStockGoodsOut.setBusinessCode(codeResult.getData().toString());
					}
				}
			}
		}
		Result r=super.insert(assetStockGoodsOut,throwsException);
		for(int i=0;i<list.size();i++){
			list.get(i).setWarehouseId(assetStockGoodsOut.getWarehouseId());
		}
		return goodsStockService.saveOwnerData(assetStockGoodsOut.getId(),assetStockGoodsOut.getOwnerType(),list);
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
	public Result approve(String instanceId, List<AssetAllocation> assets, String approveAction, String opinion) {
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


	/**
	 * 操作
	 * @param id  ID
	 * @param result 结果
	 * @return
	 * */
	private Result operateResult(String id,String result,String status,String message) {
		if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){
			AssetStockGoodsOut bill=new AssetStockGoodsOut();
			bill.setId(id);
			bill.setStatus(status);
			this.dao.execute("update eam_goods_stock set status=? where owner_id=?",status,bill.getId());
			//后续需要加盘点
			computeStockData(id);
			return super.update(bill,SaveMode.NOT_NULL_FIELDS,false);
		}else if(AssetHandleConfirmOperationEnum.FAILED.code().equals(result)){
			return ErrorDesc.failureMessage(message);
		}else{
			return ErrorDesc.failureMessage("返回未知结果");
		}
	}

	private Result computeStockData(String id){

		AssetStockGoodsOut bill=this.getById(id);
		this.dao().fill(bill)
				.with(AssetStockGoodsInMeta.GOODS_LIST)
				.execute();
		//不进行判断，直接进行库存减
		List<GoodsStock> goods=bill.getGoodsList();
		if(goods!=null&&goods.size()>0){
			for(int i=0;i<goods.size();i++){
				String rid=goods.get(i).getRealStockId();
				String value=goods.get(i).getStockInNumber()+"";
				String sql="update eam_goods_stock set stock_cur_number=stock_cur_number-"+value+" where id=?";
				this.dao.execute(sql,rid);
			}
		}
		return ErrorDesc.success();
	}


	@Override
	public Result confirmOperation(String id) {
		AssetStockGoodsOut billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			String operCode="";
			if(AssetStockGoodsTypeEnum.STOCK.code().equals(billData.getOwnerType())){
				operCode= AssetOperateEnum.EAM_ASSET_STOCK_GOODS_OUT.code();
			}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(billData.getOwnerType())){
				operCode=AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_OUT.code();
			}
			if(operateService.approvalRequired(operCode) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(id,AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}

	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetStockGoodsOut 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetStockGoodsOut assetStockGoodsOut) {
		return this.insert(assetStockGoodsOut,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetStockGoodsOutList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetStockGoodsOut> assetStockGoodsOutList) {
		return super.insertList(assetStockGoodsOutList);
	}

	
	/**
	 * 按主键删除 库存出库
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetStockGoodsOut assetStockGoodsOut = new AssetStockGoodsOut();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockGoodsOut.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetStockGoodsOut);
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
		AssetStockGoodsOut assetStockGoodsOut = new AssetStockGoodsOut();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockGoodsOut.setId(id);
		assetStockGoodsOut.setDeleted(dao.getDBTreaty().getTrueValue());
		assetStockGoodsOut.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetStockGoodsOut.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetStockGoodsOut,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetStockGoodsOut 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockGoodsOut assetStockGoodsOut , SaveMode mode) {
		return this.update(assetStockGoodsOut,mode,true);
	}


	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetStockGoodsOut 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockGoodsOut assetStockGoodsOut , SaveMode mode,boolean throwsException) {
		GoodsStock qE=new GoodsStock();
		qE.setOwnerTmpId(assetStockGoodsOut.getId());
		List<GoodsStock> list =goodsStockService.queryList(qE);
		if(list.size()==0){
			return ErrorDesc.failureMessage("请选择数据");
		}
		Result r=super.update(assetStockGoodsOut , mode , throwsException);
		for(int i=0;i<list.size();i++){
			list.get(i).setWarehouseId(assetStockGoodsOut.getWarehouseId());
		}
		return goodsStockService.saveOwnerData(assetStockGoodsOut.getId(),assetStockGoodsOut.getOwnerType(),list);

	}

	/**
	 * 更新实体集，事务内
	 * @param assetStockGoodsOutList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetStockGoodsOut> assetStockGoodsOutList , SaveMode mode) {
		return super.updateList(assetStockGoodsOutList , mode);
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
	 * @return AssetStockGoodsOut 数据对象
	 */
	public AssetStockGoodsOut getById(String id) {
		AssetStockGoodsOut sample = new AssetStockGoodsOut();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetStockGoodsOut> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetStockGoodsOut> queryList(AssetStockGoodsOut sample) {
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
	public PagedList<AssetStockGoodsOut> queryPagedList(AssetStockGoodsOut sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetStockGoodsOut> queryPagedList(AssetStockGoodsOut sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetStockGoodsOut 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetStockGoodsOut assetStockGoodsOut) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetStockGoodsOut, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(AssetStockGoodsOut sample) {
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