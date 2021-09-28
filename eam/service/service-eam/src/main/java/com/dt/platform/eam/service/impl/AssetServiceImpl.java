package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.excel.*;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.sql.SQLBuilder;
import com.github.foxnic.sql.expr.*;
import com.github.foxnic.sql.treaty.DBTreaty;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.EmployeeVO;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
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

import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;

import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 资产 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 21:49:26
*/


@Service("EamAssetService")
public class AssetServiceImpl extends SuperService<Asset> implements IAssetService {


	@Autowired
	private IOperateService operateService;

	@Autowired
	private IAssetDataService assetDataService;

	@Autowired
	private IPositionService positionService;

	@Autowired
	private IWarehouseService warehouseService;

	@Autowired
	private IMaintainerService maintainerService;

	@Autowired
	private IManufacturerService manufacturerService;

	@Autowired
	private IGoodsService goodsService;

	@Autowired
	private ICategoryFinanceService categoryFinanceService;



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
		}else if(AssetHandleConfirmOperationEnum.FAILED.code().equals(result)){
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
	public Result confirmOperation(String id) {
		Asset assetData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(assetData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_INSERT.code()) ) {
				//发起审批
			}else{
				//确认单据
				if(update(EAMTables.EAM_ASSET.STATUS,AssetHandleStatusEnum.COMPLETE.code(),id)){
					return operateResult(AssetHandleConfirmOperationEnum.SUCCESS.code(),id);
				}
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+assetData.getStatus()+",不能进行过该操作");
		}
		return ErrorDesc.success();
	}


	/**
	 * 插入实体
	 * @param asset 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Asset asset) {


		//制单人
		if(StringUtil.isBlank(asset.getOriginatorId())){
			asset.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//办理状态
		if(StringUtil.isBlank(asset.getStatus())){
			asset.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}


		//资产状态
		if(StringUtil.isBlank(asset.getAssetStatus())){
			asset.setAssetStatus(AssetStatusEnum.IDLE.code());
		}

		//编码
		if(!StringUtil.isBlank(asset.getAssetCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(CodeModuleEnum.EAM_ASSET_CODE.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				asset.setAssetCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(asset);
		return r;
	}



	/**
	 * 批量插入实体，事务内
	 * @param assetList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Asset> assetList) {
		return super.insertList(assetList);
	}
	
	
	/**
	 * 按主键删除 资产
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Asset asset = new Asset();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		asset.setId(id);
		try {
			boolean suc = dao.deleteEntity(asset);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Asset asset = new Asset();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		asset.setId(id);
		asset.setDeleted(dao.getDBTreaty().getTrueValue());
		asset.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		asset.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(asset,SaveMode.NOT_NULL_FIELDS);
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
	 * @param asset 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Asset asset , SaveMode mode) {
		if(!StringUtil.isBlank(asset.getAssetCode())){
			asset.setAssetCode(null);
		}
		Result r=super.update(asset , mode);
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param assetList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Asset> assetList , SaveMode mode) {
		return super.updateList(assetList , mode);
	}
	
	
	/**
	 * 按主键更新字段 资产
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
	 * 按主键获取 资产
	 *
	 * @param id 主键
	 * @return Asset 数据对象
	 */
	public Asset getById(String id) {
		Asset sample = new Asset();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Asset> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Asset> queryList(Asset sample) {
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
	public PagedList<Asset> queryPagedList(Asset sample, int pageSize, int pageIndex) {

		Expr select=new Expr("select * from "+table()+" t ");
		ConditionExpr expr=new ConditionExpr();
		if(sample instanceof AssetVO) {
			AssetVO vo=(AssetVO) sample;
			if(!StringUtil.isBlank(vo.getUseOrganizationId())) {
				expr.and("use_organization_id in (select id from hrm_organization where deleted=0 and type in ('com','dept') and (concat('/',hierarchy) like '%/"+vo.getUseOrganizationId()+"/%' or id=?))",vo.getUseOrganizationId());
				vo.setUseOrganizationId(null);
			}
			if(!StringUtil.isBlank(vo.getCategoryId())) {
				expr.and("category_id in (select id from pcm_catalog where deleted=0 and (concat('/',hierarchy) like '%/"+vo.getCategoryId()+"/%' or id=?))",vo.getCategoryId());
				vo.setCategoryId(null);
			}
			if(!StringUtil.isBlank(vo.getCategoryFinance())) {
				expr.and("category_id in (select id from eam_category_finance where deleted=0 and (concat('/',hierarchy) like '%/"+vo.getCategoryFinance()+"/%' or id=?))",vo.getCategoryFinance());
				vo.setFinancialCategoryId(null);
			}
			if(!StringUtil.isBlank(vo.getOwnCompanyId())) {
				expr.and("own_company_id in (select id from hrm_organization where deleted=0 and type in ('com','dept') and (concat('/',hierarchy) like '%/"+vo.getOwnCompanyId()+"/%' or id=?))",vo.getOwnCompanyId());
				vo.setOwnCompanyId(null);
			}
		}
		ConditionExpr base=this.buildQueryCondition(sample,"t");
		expr.and(base);
		select.append(expr.startWithWhere()+" order by create_time desc");
		PagedList<Asset> pagedList=this.dao().queryPagedEntities(Asset.class,pageSize,pageIndex,select);
		return pagedList;


	}

	public Result conditionAssetBusinessType(String businessType,ConditionExpr queryCondition){

		//过滤资产状态
		if(CodeModuleEnum.EAM_ASSET_BORROW.code().equals(businessType)){
			//借用
			queryCondition.andIn("asset_status",AssetStatusEnum.USING,AssetStatusEnum.IDLE);
		}else if(CodeModuleEnum.EAM_ASSET_COLLECTION.code().equals(businessType)){
			//领用
			queryCondition.andIn("asset_status",AssetStatusEnum.IDLE);
		}else if(CodeModuleEnum.EAM_ASSET_COLLECTION_RETURN.code().equals(businessType)){
			//退库
			queryCondition.andIn("asset_status",AssetStatusEnum.IDLE);
		}else if(CodeModuleEnum.EAM_ASSET_REPAIR.code().equals(businessType)){
			//报修
			queryCondition.andIn("asset_status",AssetStatusEnum.USING,AssetStatusEnum.IDLE);
		}else if(CodeModuleEnum.EAM_ASSET_SCRAP.code().equals(businessType)){
			//报废
			queryCondition.andIn("asset_status",AssetStatusEnum.USING,AssetStatusEnum.IDLE);
		}else if(CodeModuleEnum.EAM_ASSET_ALLOCATE.code().equals(businessType)){
			//调拨
			queryCondition.andIn("asset_status",AssetStatusEnum.USING,AssetStatusEnum.IDLE);
		}else if(CodeModuleEnum.EAM_ASSET_TRANFER.code().equals(businessType)){
			//转移
			queryCondition.andIn("asset_status",AssetStatusEnum.USING,AssetStatusEnum.IDLE);
		}else{
			return ErrorDesc.failure().message("不支持当前业务类型操作");
		}
		return ErrorDesc.success().data(queryCondition);
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
	public PagedList<Asset> queryPagedList(Asset sample, ConditionExpr condition, int pageSize, int pageIndex) {

		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}


	@Override
	public PagedList<Asset> queryPagedListBySelect(AssetVO sample,String businessType,String assetOwnerId,String assetSelectedCode,String assetSearchContent) {

		ConditionExpr queryCondition=new ConditionExpr();

		//过滤资产已选数据
		if(!StringUtil.isBlank(assetOwnerId)) {
			queryCondition.andIf("id not in (select asset_id from eam_asset_item where deleted=0 and handle_id=?)" ,assetOwnerId);
		}else{
			if(!StringUtil.isBlank(assetSelectedCode)) {
				queryCondition.andIf("id not in (select asset_id from eam_asset_selected_data where deleted=0 and asset_selected_code=?)" ,assetSelectedCode);
			}
		}

		if(!StringUtil.isBlank(sample.getCategoryId())) {
			queryCondition.and("category_id in (select id from pcm_catalog where deleted=0 and (concat('/',hierarchy) like '%/"+sample.getCategoryId()+"/%' or id=?))",sample.getCategoryId());
			sample.setCategoryId(null);
		}


		Result r=conditionAssetBusinessType(businessType,queryCondition);
		if(r.isSuccess()){
			r.getData();
		}

		PagedList<Asset> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		return list;
	}


	/**
	 * 插入实体
	 * @param businessType 业务类型
	 * @param assetIds 资产
	 * @return 插入是否成功
	 * */
	@Override
	public Result checkAssetDataForBusiessAction(String businessType,List<String> assetIds) {

		Result result=new Result();
		ConditionExpr queryCondition=new ConditionExpr();
		queryCondition.andIn("id",assetIds);
		Result r=conditionAssetBusinessType(businessType,queryCondition);
		if(!r.isSuccess()){
			return r;
		}
		List<Asset> list=queryList(queryCondition);
		if(list.size()!=assetIds.size()){
			return ErrorDesc.failure().message("当前选择的资产中部分状态异常,请重新选择");
		}
		return result;
	}



	@Override
	public PagedList<Asset> queryPagedListBySelected(AssetVO sample,String assetSelectedCode,String assetOwnerId,String dataType){

		ConditionExpr queryCondition=new ConditionExpr();
		if(assetOwnerId!=null&&assetOwnerId.length()>0){
		    //实现临时快照
			if("refresh".equals(dataType)){
				dao.execute("delete from eam_asset_item where crd in ('cd','c') and handle_id=?",assetOwnerId);
				dao.execute("update eam_asset_item set crd='r' where crd='d' and handle_id=?",assetOwnerId);
			}
			queryCondition.andIf("id in (select asset_id from eam_asset_item where crd in ('c','r') and deleted=0 and handle_id=?)" ,assetOwnerId);
		}else{
			if(assetSelectedCode!=null&&assetSelectedCode.length()>0){
				queryCondition.andIf("id  in (select asset_id from eam_asset_selected_data where deleted=0 and asset_selected_code=?)" ,assetSelectedCode);
			}
		}
		PagedList<Asset> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		return list;
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param asset 数据对象
	 * @return 判断结果
	 */
	public Result<Asset> checkExists(Asset asset) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(asset, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Asset sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate(String categoryId) {
		ExcelWriter ew = new ExcelWriter();
		ExcelStructure es = buildExcelStructure(categoryId);
		ew.setWorkBookName("资产导入模板.xlsx");
		return ew;

	}


	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch,String businessType,boolean dataType,String categoryId) {

		List<ValidateResult> errors=new ArrayList<>();
		ExcelReader er=null;
		try {
			er=new ExcelReader(input);
		} catch (Exception e) {
			errors.add(new ValidateResult(null,-1,"缺少文件"));
			return errors;
		}
		//构建 Excel 结构
		ExcelStructure es=buildExcelStructure(categoryId);
		//装换成记录集
		RcdSet rs=null;
		try {
			rs=er.read(sheetIndex,es);

		} catch (Exception e) {
			Logger.error("Excel 导入错误",e);
			errors.add(new ValidateResult(null,-1,"Excel 读取失败"));
			return errors;
		}

		DBTableMeta tm=dao().getTableMeta(this.table());
		DBTreaty dbTreaty= dao().getDBTreaty();


		HashMap<String,HashMap<String,String>> matchMap=new HashMap<String,HashMap<String,String>>();
		matchMap.put("organizationMap",assetDataService.queryUseOrganizationNodes());
		matchMap.put("categoryMap",assetDataService.queryAssetCategoryNodes());

		List<SQL> sqls=new ArrayList<>();
		for (Rcd r : rs) {
			//可在此处校验数据
			System.out.println("before:"+r);

			Result verifyResult=assetDataService.verifyAssetRecord(r,matchMap,dataType);
			if(!verifyResult.isSuccess()){
				errors.add(new ValidateResult(null,1,verifyResult.getMessage()));
			}

			String sql="";
			if(StringUtil.isBlank(r.getString(AssetDataExportColumnEnum.ASSET_ID.text()))){

				Insert insert = SQLBuilder.buildInsert(r,this.table(),this.dao(), true);
				//办理情况
				if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_INSERT.code()) ){
					insert.set("status",AssetHandleStatusEnum.INCOMPLETE.code());
				}else{
					insert.set("status",AssetHandleStatusEnum.COMPLETE.code());
				}

				//资产编号
				Result codeResult= CodeModuleServiceProxy.api().generateCode(CodeModuleEnum.EAM_ASSET_CODE.code());
				if(!codeResult.isSuccess()){
					//返回报错
					errors.add(new ValidateResult(null,2,codeResult.getMessage()));
				}else{
					insert.set(AssetDataExportColumnEnum.ASSET_CODE.text(),codeResult.getData().toString());
				}

				insert.set("id",IDGenerator.getSnowflakeIdString());
				insert.set("tenant_id","T001");
				//制单人
				insert.set("originator_id",SessionUser.getCurrent().getUser().getActivatedEmployeeId());

				//设置创建时间
				if(tm.getColumn(dbTreaty.getCreateTimeField())!=null) {
					insert.set(dbTreaty.getCreateTimeField(),new Date());
				}
				if(tm.getColumn(dbTreaty.getCreateUserIdField())!=null) {
					insert.set(dbTreaty.getCreateUserIdField(), dbTreaty.getLoginUserId());
				}
				if(tm.getColumn(dbTreaty.getDeletedField())!=null) {
					insert.set(dbTreaty.getDeletedField(), dbTreaty.getFalseValue());
				}
				if(batch) {
					sqls.add(insert);
				} else {
					this.dao().execute(insert);
				}
				 sql=insert.getSQL();

			}else{


//				r.set(AssetDataExportColumnEnum.ASSET_CODE.text(),null);
//				r.set("status",null);
				Update update=SQLBuilder.buildUpdate(r,SaveMode.ALL_FIELDS,this.table(),this.dao());


				//设置创建时间
				if(tm.getColumn(dbTreaty.getUpdateTimeField())!=null) {
					update.set(dbTreaty.getUpdateTimeField(),new Date());
				}
				if(tm.getColumn(dbTreaty.getUpdateUserIdField())!=null) {
					update.set(dbTreaty.getUpdateUserIdField(), dbTreaty.getLoginUserId());
				}
				if(batch) {
					sqls.add(update);
				} else {
					this.dao().execute(update);
				}
				sql=update.getSQL();

			}
			System.out.println("after:"+r);
			System.out.println(sql);
		}

		if(batch) {
			try {
				if(errors.size()==0){
					dao().batchExecute(sqls);
				}
			} catch (Exception e) {
				errors.add(new ValidateResult(null,3,"批量导入失败"));
				throw  e;
			}
		}
		return errors;

	}

	@Override
	public ExcelStructure buildExcelStructure(String categoryId) {
		ExcelStructure es=new ExcelStructure();
		es.setDataColumnBegin(0);
		es.setDataRowBegin(2);
		String code=AssetOperateEnum.EAM_DOWNLOAD_ASSET.code();
		InputStream inputStream= TplFileServiceProxy.api().getTplFileStreamByCode(code);
		Workbook workbook;
		if ( inputStream != null) {
			try {
				workbook = WorkbookFactory.create(inputStream);
				Sheet sheet=workbook.getSheetAt(0);
				//int rownum=sheet.getPhysicalNumberOfRows();
				Row firstRow=sheet.getRow(0);
				Row row=sheet.getRow(1);

				String charIndex="";
				for(int i=0;i<row.getLastCellNum();i++){
					String asset_column=row.getCell(i).toString().replaceFirst("\\{\\{\\$fe:","")
							.replaceFirst("dataList","")
							.replaceFirst("}}","")
							.replaceFirst("t.","").trim();
					//filter
					if(AssetDataExportColumnEnum.USE_USER_NAME.code().equals(asset_column)
						||AssetDataExportColumnEnum.MANAGER_NAME.code().equals(asset_column)){
						continue;
					}
					String rAssetColumn=EnumUtil.parseByCode(AssetDataExportColumnEnum.class,asset_column)==null?
							BeanNameUtil.instance().depart(asset_column):
							EnumUtil.parseByCode(AssetDataExportColumnEnum.class,asset_column).text();

					System.out.println(row.getCell(i)  +","+ firstRow.getCell(i)+","+asset_column+rAssetColumn);
					charIndex=ExcelStructure.toExcel26(i);
					es.addColumn(charIndex,rAssetColumn,firstRow.getCell(i).toString(), ExcelColumn.STRING_CELL_READER);
				}
				//追加自定义属性部分
			} catch (Exception e) {
				Logger.debug("Excel 读取错误", e);
			}
		}

		return es;
	}

}