package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.AssetProcessRecord;
import com.dt.platform.domain.eam.InventoryAsset;
import com.dt.platform.domain.eam.meta.InventoryMeta;
import com.dt.platform.domain.eam.meta.InventoryVOMeta;
import com.dt.platform.eam.service.IInventoryAssetService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.eam.Inventory;
import com.dt.platform.domain.eam.InventoryVO;

import java.text.SimpleDateFormat;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.dt.platform.eam.service.IInventoryService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 资产盘点 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-20 12:34:49
*/


@Service("EamInventoryService")
public class InventoryServiceImpl extends SuperService<Inventory> implements IInventoryService {


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
	private InventoryUserServiceImpl inventoryUserServiceImpl;
	@Autowired 
	private InventoryDirectorServiceImpl inventoryDirectorServiceImpl;
	@Autowired 
	private InventoryManagerServiceImpl inventoryManagerServiceImpl;

	@Autowired
	private InventoryPositionServiceImpl inventoryPositionServiceImpl;

	@Autowired
	private InventoryWarehouseServiceImpl inventoryWarehouseServiceImpl;

	@Autowired
	private InventoryCatalogServiceImpl inventoryCatalogServiceImpl;

	@Autowired
	private InventoryAssetServiceImpl inventoryAssetServiceImpl;

	@Autowired
	private AssetProcessRecordServiceImpl assetProcessRecordServiceImpl;

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}



	@Override
	public Result createAssetRecord(String id) {
		Inventory inventory=this.getById(id);
		String tenantId=SessionUser.getCurrent().getActivatedTenantId();
		dao.execute("delete from eam_inventory_asset where inventory_id=?",id);
		String sql="insert into eam_inventory_asset (id,inventory_id,status,asset_id)" +
				"select uuid(),'"+id+"','"+AssetInventoryDetailStatusEnum.NOT_COUNTED.code()+"',id from eam_asset where deleted=0 and tenant_id='"+tenantId+"' and owner_code='"+inventory.getType()+"' and status='"+AssetHandleStatusEnum.COMPLETE.code()+"' ";
		//资产状态
		sql=sql+" and clean_out='0'";
		if(!StringUtil.isBlank(inventory.getAssetStatus())) {
			String[] statusArr=inventory.getAssetStatus().split(",");
			String s="";
			for(int i=0;i<statusArr.length;i++){
				if(i==0){
					s="'"+statusArr[i]+"'";}
				else{
					s=s+",'"+statusArr[i]+"'";
				}
			}
			sql=sql+" and asset_status in ("+s+")";
		}
		//购置时间
		//开始时间
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Date purchaseStartDate= inventory.getPurchaseStartDate();
		if(purchaseStartDate!=null){
			sql=sql+" and purchase_date>'"+sdf1.format(purchaseStartDate)+"'";
		}

		//结束时间
		Date purchaseEndDate= inventory.getPurchaseEndDate();
		if(purchaseEndDate!=null){
			sql=sql+" and purchase_date<'"+sdf1.format(purchaseEndDate)+"'";
		}

		//管理人员
		String csql1="select count(1) cnt from eam_inventory_manager where inventory_id=? and deleted=0";
		if(dao.queryRecord(csql1,id).getInteger("cnt")>0){
			sql=sql+" and manager_id in (select user_id from eam_inventory_manager where inventory_id='"+id+"' and deleted=0)";
		}

		//位置
		String csql2="select count(1) cnt from eam_inventory_position where inventory_id=? and deleted=0";
		if(dao.queryRecord(csql2,id).getInteger("cnt")>0){
			sql=sql+" and position_id in (select value from eam_inventory_position where inventory_id='"+id+"' and deleted=0)";
		}

		//仓库
		String csql3="select count(1) cnt from eam_inventory_warehouse where inventory_id=? and deleted=0";
		if(dao.queryRecord(csql3,id).getInteger("cnt")>0){
			sql=sql+" and warehouse_id in (select value from eam_inventory_warehouse where inventory_id='"+id+"' and deleted=0)";
		}

		//资产分类
		String csql4="select count(1) cnt from eam_inventory_catalog where inventory_id=? and deleted=0";
		if(dao.queryRecord(csql4,id).getInteger("cnt")>0){
			sql=sql+" and category_id in (select value from eam_inventory_catalog where inventory_id='"+id+"' and deleted=0)";
		}

		//所属公司
		String companyId=inventory.getOwnCompanyId();
		if(!StringUtil.isBlank(companyId)){
			String[] companyIdArr=companyId.split(",");
			if(companyIdArr.length>0){
				String subsql="(";
				for(int i=0;i<companyIdArr.length;i++){
					if(i==0){
						subsql=subsql+"'"+companyIdArr[i]+"'";
					}else{
						subsql=subsql+",'"+companyIdArr[i]+"'";
					}
				}
				subsql=subsql+")";
				sql=sql+ " and own_company_id in " +subsql;
			}
		}


		//使用部门
		String orgId=inventory.getUseOrganizationId();
		if(!StringUtil.isBlank(orgId)){
			String[] orgIdArr=orgId.split(",");
			if(orgIdArr.length>0){
				String subsql="(";
				for(int i=0;i<orgIdArr.length;i++){
					if(i==0){
						subsql=subsql+"'"+orgIdArr[i]+"'";
					}else{
						subsql=subsql+",'"+orgIdArr[i]+"'";
					}
				}
				subsql=subsql+")";
				sql=sql+ " and use_organization_id in " +subsql;
			}
		}

		System.out.println(sql);
		dao.execute(sql);
		return ErrorDesc.success();
	}

	@Override
	public Result start(String id) {
		Inventory inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.NOT_START.code().equals(inventory.getInventoryStatus())
		){
			Result r=createAssetRecord(id);
			if(!r.success()){
				return r;
			}
			inventory.setInventoryStatus(AssetInventoryActionStatusEnum.ACTING.code());
			inventory.setStartTime(new Date());
			return super.update(inventory,SaveMode.NOT_NULL_FIELDS);
		}else{
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}


	}

	@Override
	public Result cancel(String id) {
		Inventory inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.NOT_START.code().equals(inventory.getInventoryStatus())){
			inventory.setInventoryStatus(AssetInventoryActionStatusEnum.CANCEL.code());
			return super.update(inventory,SaveMode.NOT_NULL_FIELDS);
		}else{
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}
	}

	@Override
	public Result finish(String id) {
		InventoryAsset q=new InventoryAsset();
		q.setInventoryId(id);
		q.setStatus(AssetInventoryDetailStatusEnum.NOT_COUNTED.code());
		if(inventoryAssetServiceImpl.queryList(q).size()>0){
			return ErrorDesc.failure().message("资产未盘点完，不能进行结束操作!");
		}

		Inventory inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.ACTING.code().equals(inventory.getInventoryStatus())){
			inventory.setInventoryStatus(AssetInventoryActionStatusEnum.FINISH.code());
			return super.update(inventory,SaveMode.NOT_NULL_FIELDS);
		}else{
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}
	}

	@Override
	public Result dataSync(String id) {
		Inventory inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.FINISH.code().equals(inventory.getInventoryStatus())
			&&AssetInventoryDataStatusEnum.NOT_SYNC.code().equals(inventory.getDataStatus())) {

			InventoryAsset q=new InventoryAsset();
			q.setInventoryId(id);
			List<InventoryAsset> inventoryAssetList=inventoryAssetServiceImpl.queryList(q);

			if(inventoryAssetList.size()>0){
				List<AssetProcessRecord> rcdsList=new ArrayList<>();
				for(int i=0;i<inventoryAssetList.size();i++){
					AssetProcessRecord r=new AssetProcessRecord();
					r.setAssetId(inventoryAssetList.get(i).getAssetId());
					r.setBusinessCode(inventory.getBusinessCode());
					r.setProcessType(AssetOperateEnum.EAM_ASSET_INVENTORY.code());
					r.setContent("盘点操作结束 "+inventoryAssetList.get(i).getNotes());
					rcdsList.add(r);

				}
				assetProcessRecordServiceImpl.insertList(rcdsList);
			}
			//更新核对时间
			dao.execute("update eam_asset set last_verification_date=now() where id in (select  asset_id from eam_inventory_asset where deleted='0' and inventory_id=?)",id);

		}else{
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}


		return ErrorDesc.success();
	}

	@Override
	public Result inventoryAsset(String id,String assetId, String action,String notes) {
		Inventory inventory=this.getById(id);
		if(!AssetInventoryActionStatusEnum.ACTING.code().equals(inventory.getInventoryStatus()) ) {
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}

		InventoryAsset q=new InventoryAsset();
		q.setInventoryId(id);
		q.setAssetId(assetId);
		InventoryAsset inventoryAsset=inventoryAssetServiceImpl.queryEntity(q);
		inventoryAsset.setStatus(action);
		inventoryAsset.setNotes(notes);
		inventoryAsset.setOperEmplId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		inventoryAsset.setOperDate(new Date());
		return inventoryAssetServiceImpl.update(inventoryAsset,SaveMode.NOT_NULL_FIELDS);

	}



	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param inventory  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	@Transactional
	public Result insert(Inventory inventory,boolean throwsException) {

		if(StringUtil.isBlank(inventory.getType())){
			inventory.setType(AssetOwnerCodeEnum.ASSET.code());
		}

		if(StringUtil.isBlank(inventory.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_INVENTORY.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				inventory.setBusinessCode(codeResult.getData().toString());
			}
		}

		if(StringUtil.isBlank(inventory.getStatus())){
			inventory.setStatus(AssetHandleStatusEnum.COMPLETE.code());
		}
		if(StringUtil.isBlank(inventory.getInventoryStatus())){
			inventory.setInventoryStatus(AssetInventoryActionStatusEnum.NOT_START.code());
		}

		if(StringUtil.isBlank(inventory.getDataStatus())){
			inventory.setDataStatus(AssetInventoryDataStatusEnum.NOT_SYNC.code());
		}

		if(StringUtil.isBlank(inventory.getOriginatorId())){
			inventory.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		if(StringUtil.isBlank(inventory.getBusinessDate())){
			inventory.setBusinessDate(new Date());
		}



		Result r=super.insert(inventory,throwsException);
		//保存关系
		if(r.success()) {
			inventoryUserServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryUserIds());
			inventoryDirectorServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryDirectorIds());
			inventoryManagerServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryManagerIds());

			inventoryPositionServiceImpl.saveRelation(inventory.getId(), inventory.getPositionIds());
			inventoryWarehouseServiceImpl.saveRelation(inventory.getId(), inventory.getWarehouseIds());
			inventoryCatalogServiceImpl.saveRelation(inventory.getId(), inventory.getCategoryIds());

		}

		//this.createAssetRecord(inventory.getId());
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param inventory 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(Inventory inventory) {
		return this.insert(inventory,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param inventoryList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Inventory> inventoryList) {
		return super.insertList(inventoryList);
	}

	
	/**
	 * 按主键删除 资产盘点
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Inventory inventory = new Inventory();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inventory.setId(id);
		try {
			boolean suc = dao.deleteEntity(inventory);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产盘点
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {

		Inventory inventoryData=this.getById(id);
		if(AssetInventoryActionStatusEnum.FINISH.code().equals(inventoryData.getInventoryStatus())
		||AssetInventoryActionStatusEnum.ACTING.code().equals(inventoryData.getInventoryStatus())
		){
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}


		Inventory inventory = new Inventory();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inventory.setId(id);
		inventory.setDeleted(dao.getDBTreaty().getTrueValue());
		inventory.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		inventory.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(inventory,SaveMode.NOT_NULL_FIELDS);
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
	 * @param inventory 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(Inventory inventory , SaveMode mode) {
		return this.update(inventory,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param inventory 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(Inventory inventory , SaveMode mode,boolean throwsException) {
		Result r=super.update(inventory , mode , throwsException);
		//保存关系
		if(r.success()) {
			inventoryUserServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryUserIds());
			inventoryDirectorServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryDirectorIds());
			inventoryManagerServiceImpl.saveRelation(inventory.getId(), inventory.getInventoryManagerIds());
			inventoryPositionServiceImpl.saveRelation(inventory.getId(), inventory.getPositionIds());
			inventoryWarehouseServiceImpl.saveRelation(inventory.getId(), inventory.getWarehouseIds());
			inventoryCatalogServiceImpl.saveRelation(inventory.getId(), inventory.getCategoryIds());

		}
		//this.createAssetRecord(inventory.getId());
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param inventoryList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Inventory> inventoryList , SaveMode mode) {
		return super.updateList(inventoryList , mode);

	}

	
	/**
	 * 按主键更新字段 资产盘点
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
	 * 按主键获取 资产盘点
	 *
	 * @param id 主键
	 * @return Inventory 数据对象
	 */
	public Inventory getById(String id) {
		Inventory sample = new Inventory();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Inventory> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Inventory> queryList(Inventory sample) {
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
	public PagedList<Inventory> queryPagedList(Inventory sample, int pageSize, int pageIndex) {
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
	public PagedList<Inventory> queryPagedList(Inventory sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param inventory 数据对象
	 * @return 判断结果
	 */
	public Result<Inventory> checkExists(Inventory inventory) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(inventory, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Inventory sample) {
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