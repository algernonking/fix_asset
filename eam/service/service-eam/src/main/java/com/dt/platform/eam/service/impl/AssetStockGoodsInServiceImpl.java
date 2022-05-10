package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetRepairMeta;
import com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta;
import com.dt.platform.domain.eam.meta.GoodsMeta;
import com.dt.platform.domain.eam.meta.GoodsStockMeta;
import com.dt.platform.eam.service.IGoodsStockService;
import com.dt.platform.eam.service.IOperateService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.dt.platform.proxy.eam.AssetRepairServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.sql.expr.Insert;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
import org.github.foxnic.web.domain.changes.ProcessStartVO;
import org.github.foxnic.web.domain.hrm.Person;
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
import com.dt.platform.eam.service.IAssetStockGoodsInService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 库存物品单 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 13:05:35
*/


@Service("EamAssetStockGoodsInService")
public class AssetStockGoodsInServiceImpl extends SuperService<AssetStockGoodsIn> implements IAssetStockGoodsInService {



	@Autowired
	private IOperateService operateService;

	@Autowired
	private IGoodsStockService goodsStockService;

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
	 * @param assetStockGoodsIn  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetStockGoodsIn assetStockGoodsIn,boolean throwsException) {

		String selectedCode=assetStockGoodsIn.getSelectedCode();
		GoodsStock qE=new GoodsStock();
		qE.setSelectedCode(selectedCode);
		List<GoodsStock> list =goodsStockService.queryList(qE);
		if(list.size()==0){
			return ErrorDesc.failureMessage("请选择数据");
		}


		//制单人
		if(StringUtil.isBlank(assetStockGoodsIn.getOriginatorId())){
			assetStockGoodsIn.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//办理情况
		if(StringUtil.isBlank(assetStockGoodsIn.getStatus())){
			assetStockGoodsIn.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}


		//登记日期
		if(assetStockGoodsIn.getBusinessDate()==null){
			assetStockGoodsIn.setBusinessDate(new Date());
		}

		//编码
		String codeRule="";
	//	String ownerCode="";
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(assetStockGoodsIn.getOwnerType())){
			codeRule= CodeModuleEnum.EAM_ASSET_STOCK_GOODS_IN.code();
		//	ownerCode=AssetStockGoodsOwnerEnum.STOCK.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(assetStockGoodsIn.getOwnerType())) {
			codeRule= CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_IN.code();
	//		ownerCode=AssetStockGoodsOwnerEnum.CONSUMABLES.code();
		}else if(AssetStockGoodsTypeEnum.PART.code().equals(assetStockGoodsIn.getOwnerType())) {
			codeRule= CodeModuleEnum.EAM_ASSET_PART_GOODS_IN.code();
	//		ownerCode=AssetStockGoodsOwnerEnum.PART.code();
		}
		if(StringUtil.isBlank(assetStockGoodsIn.getBusinessCode())){
			if(!StringUtil.isBlank(codeRule)){
				if(!StringUtil.isBlank(codeRule)){
					Result codeResult= CodeModuleServiceProxy.api().generateCode(codeRule) ;
					if(!codeResult.isSuccess()){
						return codeResult;
					}else{
						assetStockGoodsIn.setBusinessCode(codeResult.getData().toString());
					}
				}
			}
		}

		Result r=super.insert(assetStockGoodsIn,throwsException);
		for(int i=0;i<list.size();i++){

			list.get(i).setBatchCode(assetStockGoodsIn.getBatchCode());
			list.get(i).setOwnCompanyId(assetStockGoodsIn.getOwnCompanyId());
			list.get(i).setSupplierName(assetStockGoodsIn.getSupplierName());
			list.get(i).setWarehouseId(assetStockGoodsIn.getWarehouseId());
			list.get(i).setManagerId(assetStockGoodsIn.getManagerId());
			list.get(i).setStatus(assetStockGoodsIn.getStatus());
			list.get(i).setStorageDate(new Date());
			list.get(i).setBusinessCode(assetStockGoodsIn.getBusinessCode());
			list.get(i).setOwnerCode(assetStockGoodsIn.getOwnerType());

		}
		return goodsStockService.saveOwnerData(assetStockGoodsIn.getId(),assetStockGoodsIn.getOwnerType(),list);
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

		AssetStockGoodsIn data=getById(id);
		this.dao().fill(data)
				.with("ownerCompany")
				.with("originator")
				.with("manager")
				.with(AssetStockGoodsInMeta.GOODS_LIST)
				.with(AssetStockGoodsInMeta.WAREHOUSE)
				.with(AssetStockGoodsInMeta.SOURCE)
				.with(AssetStockGoodsInMeta.STOCK_TYPE_DICT)
				.execute();

		this.dao().join(data.getManager(), Person.class);
		this.dao().join(data.getOriginator(),Person.class);
		GoodsStockVO vo=new GoodsStockVO();
		vo.setPageIndex(1);
		vo.setPageSize(1000);
		vo.setOwnerTmpId(id);
		PagedList<GoodsStock> list=goodsStockService.queryPagedListBySelected(vo,"","reset");
		goodsStockService.dao().fill(list)
				.with("ownerCompany")
				.with("useOrganization")
				.with("manager")
				.with("originator")
				.with(GoodsStockMeta.CATEGORY)
				.with(GoodsStockMeta.GOODS)
				.with(GoodsStockMeta.SOURCE)
				.with(GoodsStockMeta.WAREHOUSE)
				.with(GoodsMeta.CATEGORY)
				.with(GoodsStockMeta.BRAND)
				.with(GoodsMeta.MANUFACTURER)
				.execute();
		data.setGoodsList(list.getList());
		Map<String, Object> map= BeanUtil.toMap(data);
		if(data.getStatus()!=null){
			CodeTextEnum en= EnumUtil.parseByCode(AssetHandleStatusEnum.class,data.getStatus());
			map.put("statusName", en==null?data.getStatus():en.text());
		}
		return map;
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
			AssetStockGoodsIn bill=new AssetStockGoodsIn();
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
		AssetStockGoodsIn bill=this.getById(id);
		String tenantId= SessionUser.getCurrent().getActivatedTenantId();
		this.dao().fill(bill)
				.with(AssetStockGoodsInMeta.GOODS_LIST)
				.execute();
		String ownerCode="";
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(bill.getOwnerType())){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_STOCK.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(bill.getOwnerType())){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_CONSUMABLES.code();
		}else if(AssetStockGoodsTypeEnum.PART.code().equals(bill.getOwnerType())){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_PART.code();
		}
		List<GoodsStock> goods=bill.getGoodsList();
		if(goods!=null&&goods.size()>0){
			for(int i=0;i<goods.size();i++){
				String goodsId=goods.get(i).getGoodsId();
				String stockInNumber=goods.get(i).getStockInNumber()+"";
				String warehouseId=goods.get(i).getWarehouseId();
				if(StringUtil.isBlank(goodsId)||StringUtil.isBlank(warehouseId)){
					System.out.println("goodsId or warehouseId is empty");
				}else{
					String sql="select id,goods_id from eam_goods_stock where owner_code=? and deleted=0 and tenant_id=? and goods_id=? and warehouse_id=?";
					Rcd rs=this.dao.queryRecord(sql,ownerCode,tenantId,goodsId,warehouseId);
					if(rs==null){
						//新增
						Insert ins=new Insert("eam_goods_stock");
						ins.set("id",IDGenerator.getSnowflakeIdString());
						ins.set("owner_code",ownerCode);
						ins.set("owner_type",bill.getOwnerType());
						ins.set("stock_cur_number",stockInNumber);
						ins.set("tenant_id",tenantId);
						ins.set("warehouse_id",warehouseId);
						ins.set("goods_id",goodsId);
						this.dao.execute(ins);
					}else{
						String gid=rs.getString("id");
						String updateSql="update eam_goods_stock set stock_cur_number=stock_cur_number+"+stockInNumber+" where id=?";
						this.dao.execute(updateSql,gid);
					}
				}
			}
		}
		return ErrorDesc.success();
	}
	@Override
	public Result confirmOperation(String id) {

		AssetStockGoodsIn billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			String operCode="";
			if(AssetStockGoodsTypeEnum.STOCK.code().equals(billData.getOwnerType())){
				operCode=AssetOperateEnum.EAM_ASSET_STOCK_GOODS_IN.code();
			}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(billData.getOwnerType())){
				operCode=AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_IN.code();
			}else if(AssetStockGoodsTypeEnum.PART.code().equals(billData.getOwnerType())){
				operCode=AssetOperateEnum.EAM_ASSET_PART_GOODS_IN.code();
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
	 * @param assetStockGoodsIn 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetStockGoodsIn assetStockGoodsIn) {
		return this.insert(assetStockGoodsIn,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetStockGoodsInList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetStockGoodsIn> assetStockGoodsInList) {
		return super.insertList(assetStockGoodsInList);
	}

	
	/**
	 * 按主键删除 库存物品单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetStockGoodsIn assetStockGoodsIn = new AssetStockGoodsIn();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockGoodsIn.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetStockGoodsIn);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 库存物品单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetStockGoodsIn assetStockGoodsIn = new AssetStockGoodsIn();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockGoodsIn.setId(id);
		assetStockGoodsIn.setDeleted(dao.getDBTreaty().getTrueValue());
		assetStockGoodsIn.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetStockGoodsIn.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetStockGoodsIn,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetStockGoodsIn 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockGoodsIn assetStockGoodsIn , SaveMode mode) {
		return this.update(assetStockGoodsIn,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetStockGoodsIn 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockGoodsIn assetStockGoodsIn , SaveMode mode,boolean throwsException) {

		GoodsStock qE=new GoodsStock();
		qE.setOwnerTmpId(assetStockGoodsIn.getId());
		List<GoodsStock> list =goodsStockService.queryList(qE);
		if(list.size()==0){
			return ErrorDesc.failureMessage("请选择数据");
		}

		Result r=super.update(assetStockGoodsIn , mode , throwsException);
		for(int i=0;i<list.size();i++){
			list.get(i).setBatchCode(assetStockGoodsIn.getBatchCode());
			list.get(i).setOwnCompanyId(assetStockGoodsIn.getOwnCompanyId());
			list.get(i).setSupplierName(assetStockGoodsIn.getSupplierName());
			list.get(i).setWarehouseId(assetStockGoodsIn.getWarehouseId());
			list.get(i).setManagerId(assetStockGoodsIn.getManagerId());
			list.get(i).setStatus(assetStockGoodsIn.getStatus());
			list.get(i).setStorageDate(new Date());
			list.get(i).setBusinessCode(assetStockGoodsIn.getBusinessCode());
			list.get(i).setOwnerCode(assetStockGoodsIn.getOwnerType());

		}
		return goodsStockService.saveOwnerData(assetStockGoodsIn.getId(),assetStockGoodsIn.getOwnerType(),list);

	}

	/**
	 * 更新实体集，事务内
	 * @param assetStockGoodsInList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetStockGoodsIn> assetStockGoodsInList , SaveMode mode) {
		return super.updateList(assetStockGoodsInList , mode);
	}

	
	/**
	 * 按主键更新字段 库存物品单
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
	 * 按主键获取 库存物品单
	 *
	 * @param id 主键
	 * @return AssetStockGoodsIn 数据对象
	 */
	public AssetStockGoodsIn getById(String id) {
		AssetStockGoodsIn sample = new AssetStockGoodsIn();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetStockGoodsIn> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetStockGoodsIn> queryList(AssetStockGoodsIn sample) {
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
	public PagedList<AssetStockGoodsIn> queryPagedList(AssetStockGoodsIn sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetStockGoodsIn> queryPagedList(AssetStockGoodsIn sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetStockGoodsIn 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetStockGoodsIn assetStockGoodsIn) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetStockGoodsIn, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(AssetStockGoodsIn sample) {
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
