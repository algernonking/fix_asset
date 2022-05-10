package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetHandleConfirmOperationEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.AssetStockGoodsTypeEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.service.IGoodsStockService;
import com.dt.platform.eam.service.IOperateService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
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
import com.dt.platform.eam.service.IAssetStockGoodsAdjustService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 库存调整 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-24 12:15:09
*/


@Service("EamAssetStockGoodsAdjustService")
public class AssetStockGoodsAdjustServiceImpl extends SuperService<AssetStockGoodsAdjust> implements IAssetStockGoodsAdjustService {


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
	 * @param assetStockGoodsAdjust  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetStockGoodsAdjust assetStockGoodsAdjust,boolean throwsException) {

		String selectedCode=assetStockGoodsAdjust.getSelectedCode();
		GoodsStock qE=new GoodsStock();
		qE.setSelectedCode(selectedCode);
		List<GoodsStock> list =goodsStockService.queryList(qE);
		if(list.size()==0){
			return ErrorDesc.failureMessage("请选择数据");
		}

		//制单人
		if(StringUtil.isBlank(assetStockGoodsAdjust.getOriginatorId())){
			assetStockGoodsAdjust.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//办理情况
		if(StringUtil.isBlank(assetStockGoodsAdjust.getStatus())){
			assetStockGoodsAdjust.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}


		//登记日期
		if(assetStockGoodsAdjust.getBusinessDate()==null){
			assetStockGoodsAdjust.setBusinessDate(new Date());
		}

		//编码
		String codeRule="";
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(assetStockGoodsAdjust.getOwnerType())){
			codeRule= CodeModuleEnum.EAM_ASSET_STOCK_GOODS_ADJUST.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(assetStockGoodsAdjust.getOwnerType())) {
			codeRule= CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_ADJUST.code();
		}else if(AssetStockGoodsTypeEnum.PART.code().equals(assetStockGoodsAdjust.getOwnerType())) {
			codeRule= CodeModuleEnum.EAM_ASSET_PART_GOODS_ADJUST.code();
		}

		if(StringUtil.isBlank(assetStockGoodsAdjust.getBusinessCode())){
			if(!StringUtil.isBlank(codeRule)){
				if(!StringUtil.isBlank(codeRule)){
					Result codeResult= CodeModuleServiceProxy.api().generateCode(codeRule) ;
					if(!codeResult.isSuccess()){
						return codeResult;
					}else{
						assetStockGoodsAdjust.setBusinessCode(codeResult.getData().toString());
					}
				}
			}
		}

		Result r=super.insert(assetStockGoodsAdjust,throwsException);
		for(int i=0;i<list.size();i++){
			list.get(i).setWarehouseId(assetStockGoodsAdjust.getWarehouseId());
			list.get(i).setBusinessCode(assetStockGoodsAdjust.getBusinessCode());
			list.get(i).setOwnerCode(assetStockGoodsAdjust.getOwnerType());
		}
		return goodsStockService.saveOwnerData(assetStockGoodsAdjust.getId(),assetStockGoodsAdjust.getOwnerType(),list);

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
		AssetStockGoodsAdjust data = getById(id);
		this.dao().fill(data)
				.with("originator")
				.with(AssetStockGoodsAdjustMeta.WAREHOUSE)
				.execute();

		this.dao().join(data.getOriginator(), Person.class);
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
		Map<String, Object> map = BeanUtil.toMap(data);
		if (data.getStatus() != null) {
			CodeTextEnum en = EnumUtil.parseByCode(AssetHandleStatusEnum.class, data.getStatus());
			map.put("statusName", en == null ? data.getStatus() : en.text());
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
			AssetStockGoodsAdjust bill=new AssetStockGoodsAdjust();
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
		//调整
		AssetStockGoodsAdjust bill=this.getById(id);
		this.dao().fill(bill)
				.with(AssetStockGoodsInMeta.GOODS_LIST)
				.execute();
		//不进行判断，直接进行库存减
		List<GoodsStock> goods=bill.getGoodsList();
		if(goods!=null&&goods.size()>0){
			for(int i=0;i<goods.size();i++){
				String rid=goods.get(i).getRealStockId();
				String value=goods.get(i).getStockInNumber()+"";
				String sql="update eam_goods_stock set stock_cur_number="+value+" where id=?";
				this.dao.execute(sql,rid);
			}
		}
		return ErrorDesc.success();
	}

	@Override
	public Result confirmOperation(String id) {
		AssetStockGoodsAdjust billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			String operCode="";
			if(AssetStockGoodsTypeEnum.STOCK.code().equals(billData.getOwnerType())){
				operCode= AssetOperateEnum.EAM_ASSET_STOCK_GOODS_ADJUST.code();
			}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(billData.getOwnerType())){
				operCode=AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_ADJUST.code();
			}else if(AssetStockGoodsTypeEnum.PART.code().equals(billData.getOwnerType())){
				operCode=AssetOperateEnum.EAM_ASSET_PART_GOODS_ADJUST.code();
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
	 * @param assetStockGoodsAdjust 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetStockGoodsAdjust assetStockGoodsAdjust) {
		return this.insert(assetStockGoodsAdjust,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetStockGoodsAdjustList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetStockGoodsAdjust> assetStockGoodsAdjustList) {
		return super.insertList(assetStockGoodsAdjustList);
	}

	
	/**
	 * 按主键删除 库存调整
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetStockGoodsAdjust assetStockGoodsAdjust = new AssetStockGoodsAdjust();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockGoodsAdjust.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetStockGoodsAdjust);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 库存调整
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetStockGoodsAdjust assetStockGoodsAdjust = new AssetStockGoodsAdjust();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockGoodsAdjust.setId(id);
		assetStockGoodsAdjust.setDeleted(dao.getDBTreaty().getTrueValue());
		assetStockGoodsAdjust.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetStockGoodsAdjust.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetStockGoodsAdjust,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetStockGoodsAdjust 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockGoodsAdjust assetStockGoodsAdjust , SaveMode mode) {
		return this.update(assetStockGoodsAdjust,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetStockGoodsAdjust 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockGoodsAdjust assetStockGoodsAdjust , SaveMode mode,boolean throwsException) {

		GoodsStock qE=new GoodsStock();
		qE.setOwnerTmpId(assetStockGoodsAdjust.getId());
		List<GoodsStock> list =goodsStockService.queryList(qE);
		if(list.size()==0){
			return ErrorDesc.failureMessage("请选择数据");
		}

		Result r=super.update(assetStockGoodsAdjust , mode , throwsException);
		for(int i=0;i<list.size();i++){
			list.get(i).setWarehouseId(assetStockGoodsAdjust.getWarehouseId());
			list.get(i).setBusinessCode(assetStockGoodsAdjust.getBusinessCode());
			list.get(i).setOwnerCode(assetStockGoodsAdjust.getOwnerType());
		}
		return goodsStockService.saveOwnerData(assetStockGoodsAdjust.getId(),assetStockGoodsAdjust.getOwnerType(),list);


	}

	/**
	 * 更新实体集，事务内
	 * @param assetStockGoodsAdjustList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetStockGoodsAdjust> assetStockGoodsAdjustList , SaveMode mode) {


		return super.updateList(assetStockGoodsAdjustList , mode);
	}

	
	/**
	 * 按主键更新字段 库存调整
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
	 * 按主键获取 库存调整
	 *
	 * @param id 主键
	 * @return AssetStockGoodsAdjust 数据对象
	 */
	public AssetStockGoodsAdjust getById(String id) {
		AssetStockGoodsAdjust sample = new AssetStockGoodsAdjust();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetStockGoodsAdjust> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetStockGoodsAdjust> queryList(AssetStockGoodsAdjust sample) {
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
	public PagedList<AssetStockGoodsAdjust> queryPagedList(AssetStockGoodsAdjust sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetStockGoodsAdjust> queryPagedList(AssetStockGoodsAdjust sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetStockGoodsAdjust 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetStockGoodsAdjust assetStockGoodsAdjust) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetStockGoodsAdjust, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(AssetStockGoodsAdjust sample) {
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
