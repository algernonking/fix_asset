package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetStorageMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
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
 * 资产入库 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-19 13:26:20
*/


@Service("EamAssetStorageService")
public class AssetStorageServiceImpl extends SuperService<AssetStorage> implements IAssetStorageService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	@Autowired
	private IOperateService operateService;

	@Autowired
	private IAssetItemService assetItemService;

	@Autowired
	private IAssetDataService assetDataService;

	@Autowired
	private IAssetService assetService;
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
	 * @param assetStorage  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetStorage assetStorage,boolean throwsException) {

		//插入
		String selectedCode=assetStorage.getSelectedCode();
		Result importR=assetDataService.importAssetByLuckySheet(AssetOwnerCodeEnum.ASSET_STORAGE.code(),assetStorage.getCustomData(),selectedCode);
		assetStorage.setCustomData("");
		if(!importR.isSuccess()){
			return ErrorDesc.failureMessage("导入资产报错");
		}
		String sql="select id from eam_asset where deleted=0 and asset_selected_code=?";
		RcdSet importDataRs=dao.query(sql,selectedCode);
		if(importDataRs.size()==0){
			return ErrorDesc.failureMessage("请选择资产");
		}


		//制单人
		if(StringUtil.isBlank(assetStorage.getOriginatorId())){
			assetStorage.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//业务时间
		if(StringUtil.isBlank(assetStorage.getBusinessDate())){
			assetStorage.setBusinessDate(new Date());
		}

		//办理状态
		if(StringUtil.isBlank(assetStorage.getStatus())){
			assetStorage.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		//生成编码规则
		if(StringUtil.isBlank(assetStorage.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_STORAGE.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetStorage.setBusinessCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(assetStorage,throwsException);
		if(r.isSuccess()){
			List<AssetItem> list=new ArrayList<>();
			for(Rcd rs:importDataRs){
				AssetItem item=new AssetItem();
				item.setAssetId(rs.getString("id"));
				item.setHandleId(assetStorage.getId());
				list.add(item);
			}
			assetItemService.insertList(list);
		}
		return r;
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
	public Result approve(String instanceId, List<AssetTranfer> assets, String approveAction, String opinion) {
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
			AssetStorage bill=this.getById(id);
			dao.fill(bill).with(AssetStorageMeta.ASSET_LIST)
					.execute();
			bill.setStatus(status);
			List<Asset> list=bill.getAssetList();
			if(list!=null&&list.size()>0){
				for(Asset asset:list){
					asset.setStatus(status);
					asset.setOwnerCode(AssetOwnerCodeEnum.ASSET.code());
					Result codeResult= CodeModuleServiceProxy.api().generateCode(CodeModuleEnum.EAM_ASSET_CODE.code()) ;
					if(!codeResult.isSuccess()){
						return codeResult;
					}else{
						asset.setAssetCode(codeResult.getData().toString());
					}
					assetService.update(asset,SaveMode.NOT_NULL_FIELDS,false);
				}
			}
			return super.update(bill,SaveMode.NOT_NULL_FIELDS,false);
		}else if(AssetHandleConfirmOperationEnum.FAILED.code().equals(result)){
			return ErrorDesc.failureMessage(message);
		}else{
			return ErrorDesc.failureMessage("返回未知结果");
		}
	}

	@Override
	public Result confirmOperation(String id) {
		AssetStorage billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_STORAGE.code()) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(id, AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetStorage 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetStorage assetStorage) {
		return this.insert(assetStorage,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetStorageList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetStorage> assetStorageList) {
		return super.insertList(assetStorageList);
	}

	
	/**
	 * 按主键删除 资产入库
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetStorage assetStorage = new AssetStorage();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStorage.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetStorage);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产入库
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetStorage assetStorage = new AssetStorage();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStorage.setId(id);
		assetStorage.setDeleted(dao.getDBTreaty().getTrueValue());
		assetStorage.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetStorage.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetStorage,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetStorage 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStorage assetStorage , SaveMode mode) {
		return this.update(assetStorage,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetStorage 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStorage assetStorage , SaveMode mode,boolean throwsException) {
		//插入
		String selectedCode=assetStorage.getSelectedCode();
		Result importR=assetDataService.importAssetByLuckySheet(AssetOwnerCodeEnum.ASSET_STORAGE.code(),assetStorage.getCustomData(),selectedCode);
		if(!importR.isSuccess()){
			return ErrorDesc.failureMessage("导入资产报错");
		}
		String sql="select id from eam_asset where deleted=0 and asset_selected_code=?";
		RcdSet importDataRs=dao.query(sql,selectedCode);
		if(importDataRs.size()==0){
			return ErrorDesc.failureMessage("请选择资产");
		}

		assetStorage.setCustomData("");
		//业务时间
		if(StringUtil.isBlank(assetStorage.getBusinessDate())){
			assetStorage.setBusinessDate(new Date());
		}


		Result r=super.update(assetStorage , mode , throwsException);
		if(r.isSuccess()){
			List<AssetItem> list=new ArrayList<>();
			for(Rcd rs:importDataRs){
				AssetItem item=new AssetItem();
				item.setAssetId(rs.getString("id"));
				item.setHandleId(assetStorage.getId());
				list.add(item);
			}
			dao.execute("delete from eam_asset_item where handle_id=? ",assetStorage.getId());
			assetItemService.insertList(list);
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetStorageList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetStorage> assetStorageList , SaveMode mode) {
		return super.updateList(assetStorageList , mode);
	}

	
	/**
	 * 按主键更新字段 资产入库
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
	 * 按主键获取 资产入库
	 *
	 * @param id 主键
	 * @return AssetStorage 数据对象
	 */
	public AssetStorage getById(String id) {
		AssetStorage sample = new AssetStorage();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetStorage> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AssetStorage> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AssetStorage::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetStorage> queryList(AssetStorage sample) {
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
	public PagedList<AssetStorage> queryPagedList(AssetStorage sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetStorage> queryPagedList(AssetStorage sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetStorage 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetStorage assetStorage) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetStorage, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(AssetStorage sample) {
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