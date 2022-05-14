package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.eam.AssetHandleConfirmOperationEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.AssetOwnerCodeEnum;
import com.dt.platform.domain.eam.*;
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
import com.dt.platform.eam.service.IAssetSoftwareService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 软件资产 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-04 19:59:02
*/


@Service("EamAssetSoftwareService")
public class AssetSoftwareServiceImpl extends SuperService<AssetSoftware> implements IAssetSoftwareService {


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
	 * @param assetSoftware  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetSoftware assetSoftware,boolean throwsException) {

		//制单人
		if(StringUtil.isBlank(assetSoftware.getOriginatorId())){
			assetSoftware.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//办理情况
		if(StringUtil.isBlank(assetSoftware.getStatus())){
			assetSoftware.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		if(StringUtil.isBlank(assetSoftware.getOwnerCode())){
			assetSoftware.setOwnerCode(AssetOwnerCodeEnum.ASSET_SOFTWARE.code());
		}

		if(StringUtil.isBlank(assetSoftware.getAuthorizedAvailableNumber())){
			assetSoftware.setAuthorizedAvailableNumber(assetSoftware.getAuthorizedNumber());
		}

		//登记日期
		if(assetSoftware.getRegisterDate()==null){
			assetSoftware.setRegisterDate(new Date());
		}

		//生成编码规则
		if(StringUtil.isBlank(assetSoftware.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_SOFTWARE_INSERT.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetSoftware.setBusinessCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(assetSoftware,throwsException);
		return r;
	}

	@Override
	public PagedList<AssetSoftware> queryPagedListBySelected(AssetSoftwareVO sample, String operType) {
		sample.setOwnerCode(AssetOwnerCodeEnum.ASSET_DATA_SELECTED.code());
		ConditionExpr queryCondition=new ConditionExpr();
		PagedList<AssetSoftware> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		return list;

	}
	@Override
	public PagedList<AssetSoftware> queryPagedListBySelect(AssetSoftwareVO sample, String assetSearchContent) {

		sample.setOwnerCode(AssetOwnerCodeEnum.ASSET_SOFTWARE.code());
		ConditionExpr queryCondition=new ConditionExpr();
		PagedList<AssetSoftware> list= queryPagedList(sample,queryCondition,sample.getPageSize(),sample.getPageIndex());
		return list;
	}

	@Override
	public Result assetSelected(List<String> ids, String selectedCode, String operType) {

		if(ids==null||ids.size()==0){
			return ErrorDesc.failureMessage("请选择数据");
		}
		ConditionExpr expr=new ConditionExpr();
		expr.andIn("id",ids);
		List<AssetSoftware> list=queryList(expr);
		for(int i=0;i<list.size();i++){
			AssetSoftware as=list.get(i);
			String sid=as.getId();
			as.setOwnerCode(AssetOwnerCodeEnum.ASSET_DATA_SELECTED.code());
			as.setId(null);
			as.setCtl(sid);
			as.setAuthorizedAvailableNumber(1);
			as.setCreateTime(new Date());
			as.setSelectedCode(selectedCode);
			super.insert(as,false);
		}
		return ErrorDesc.success();
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
			AssetSoftware bill=new AssetSoftware();
			bill.setId(id);
			bill.setStatus(status);
			return super.update(bill,SaveMode.NOT_NULL_FIELDS,false);
		}else if(AssetHandleConfirmOperationEnum.FAILED.code().equals(result)){
			return ErrorDesc.failureMessage(message);
		}else{
			return ErrorDesc.failureMessage("返回未知结果");
		}
	}

	@Override
	public Result confirmOperation(String id) {
		AssetSoftware billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			if(operateService.approvalRequired(AssetOperateEnum.EAM_ASSET_BORROW.code()) ) {
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
	 * @param assetSoftware 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetSoftware assetSoftware) {
		return this.insert(assetSoftware,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetSoftwareList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetSoftware> assetSoftwareList) {
		return super.insertList(assetSoftwareList);
	}

	
	/**
	 * 按主键删除 软件资产
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetSoftware assetSoftware = new AssetSoftware();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetSoftware.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetSoftware);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 软件资产
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetSoftware assetSoftware = new AssetSoftware();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetSoftware.setId(id);
		assetSoftware.setDeleted(dao.getDBTreaty().getTrueValue());
		assetSoftware.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetSoftware.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetSoftware,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetSoftware 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetSoftware assetSoftware , SaveMode mode) {
		return this.update(assetSoftware,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetSoftware 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetSoftware assetSoftware , SaveMode mode,boolean throwsException) {
		Result r=super.update(assetSoftware , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetSoftwareList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetSoftware> assetSoftwareList , SaveMode mode) {
		return super.updateList(assetSoftwareList , mode);
	}

	
	/**
	 * 按主键更新字段 软件资产
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
	 * 按主键获取 软件资产
	 *
	 * @param id 主键
	 * @return AssetSoftware 数据对象
	 */
	public AssetSoftware getById(String id) {
		AssetSoftware sample = new AssetSoftware();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetSoftware> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetSoftware> queryList(AssetSoftware sample) {
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
	public PagedList<AssetSoftware> queryPagedList(AssetSoftware sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetSoftware> queryPagedList(AssetSoftware sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetSoftware 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetSoftware assetSoftware) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetSoftware, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(AssetSoftware sample) {
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
