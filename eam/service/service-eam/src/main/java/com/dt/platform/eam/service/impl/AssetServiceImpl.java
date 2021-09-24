package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetApprovalTypeEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.domain.eam.ApproveConfigure;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
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
import com.dt.platform.eam.service.IAssetService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 资产 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 21:49:26
*/


@Service("EamAssetService")
public class AssetServiceImpl extends SuperService<Asset> implements IAssetService {
	
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
	 * 插入实体
	 * @param asset 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Asset asset) {

		//编码
		Result codeResult= CodeModuleServiceProxy.api().generateCode(CodeModuleEnum.EAM_ASSET_CODE.code());
		if(!codeResult.isSuccess()){
			return codeResult;
		}else{
			asset.setAssetCode(codeResult.getData().toString());
		}


		//办理状态
		if(asset.getStatus()==null||"".equals(asset.getStatus())){
			asset.setStatus(AssetHandleStatusEnum.COMPLETE.code());
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
	public PagedList<Asset> queryPagedList(Asset sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}


	@Override
	public PagedList<Asset> queryPagedListBySelect(AssetVO sample,String businessType,String assetOwnerId,String assetSelectedCode,String assetSearchContent) {

		ConditionExpr queryCondition=new ConditionExpr();

		//过滤资产已选数据
		if(assetOwnerId!=null&&assetOwnerId.length()>0){
			queryCondition.andIf("id not in (select asset_id from eam_asset_item where deleted=0 and handle_id=?)" ,assetOwnerId);
		}else{
			if(assetSelectedCode!=null&&assetSelectedCode.length()>0){
				queryCondition.andIf("id not in (select asset_id from eam_asset_selected_data where deleted=0 and asset_selected_code=?)" ,assetSelectedCode);
			}
		}

		//过滤资产办理状态
		//sample.setStatus(AssetHandleStatusEnum.COMPLETE.code());

		//过滤资产状态
		if(CodeModuleEnum.EAM_ASSET_BORROW.equals(businessType)){
			//借用
			queryCondition.andIn("asset_status",AssetStatusEnum.USING,AssetStatusEnum.IDLE);
		}else if(CodeModuleEnum.EAM_ASSET_COLLECTION.equals(businessType)){
			//领用
			queryCondition.andIn("asset_status",AssetStatusEnum.IDLE);
		}else if(CodeModuleEnum.EAM_ASSET_COLLECTION_RETURN.equals(businessType)){
			//退库
			queryCondition.andIn("asset_status",AssetStatusEnum.IDLE);
		}else if(CodeModuleEnum.EAM_ASSET_REPAIR.equals(businessType)){
			//报修
			queryCondition.andIn("asset_status",AssetStatusEnum.USING,AssetStatusEnum.IDLE);
		}else if(CodeModuleEnum.EAM_ASSET_SCRAP.equals(businessType)){
			//报废
			queryCondition.andIn("asset_status",AssetStatusEnum.USING,AssetStatusEnum.IDLE);
		}else if(CodeModuleEnum.EAM_ASSET_ALLOCATE.equals(businessType)){
			//调拨
			queryCondition.andIn("asset_status",AssetStatusEnum.USING,AssetStatusEnum.IDLE);
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