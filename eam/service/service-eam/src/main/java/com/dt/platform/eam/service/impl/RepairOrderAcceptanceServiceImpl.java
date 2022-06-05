package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.RepairOrderStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.RepairOrderMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
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
import java.util.Map;

/**
 * <p>
 * 维修验收 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-01 07:17:16
*/


@Service("EamRepairOrderAcceptanceService")
public class RepairOrderAcceptanceServiceImpl extends SuperService<RepairOrderAcceptance> implements IRepairOrderAcceptanceService {


	@Autowired
	private IRepairOrderActService repairOrderActService;

	@Autowired
	private IRepairOrderService repairOrderService;

	@Autowired
	private IOperateService operateService;

	@Autowired
	private IAssetProcessRecordService assetProcessRecordService;

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
	public Result acceptance(String id) {
		RepairOrderAcceptance accept=this.getById(id);
		RepairOrder order=repairOrderService.getById(accept.getOrderId());
		if(RepairOrderStatusEnum.WAIT_ACCEPTANCE.code().equals(order.getRepairStatus())){
			Result r=repairOrderService.changeRepairOrderStatus(order.getId(),RepairOrderStatusEnum.FINISH.code());
			if(r.isSuccess()){
				//维修操作完成，登记记录
				repairOrderService.join(order, RepairOrderMeta.ASSET_LIST);
				List<Asset> assetList=order.getAssetList();
				if(assetList!=null&&assetList.size()>0){
					for(Asset asset:assetList){
						AssetProcessRecord assetProcessRecord=new AssetProcessRecord();
						assetProcessRecord.setContent("资产维修验证完成");
						assetProcessRecord.setAssetId(asset.getId());
						assetProcessRecord.setBusinessCode(accept.getBusinessCode());
						assetProcessRecord.setProcessType(AssetOperateEnum.EAM_ASSET_REPAIR_ORDER_ACCEPTANCE.code());
						assetProcessRecord.setProcessdTime(new Date());
						assetProcessRecordService.insert(assetProcessRecord);
					}
				}
			}else{
				return r;
			}
		}else{
			return ErrorDesc.failureMessage("当前维修状态异常，不能进行验收工作");
		}
		return ErrorDesc.success();
	}



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param repairOrderAcceptance  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(RepairOrderAcceptance repairOrderAcceptance,boolean throwsException) {

		if(StringUtil.isBlank(repairOrderAcceptance.getOrderActId())){
			return ErrorDesc.failureMessage("维修工单不存在");
		}
		RepairOrderAct act=repairOrderActService.getById(repairOrderAcceptance.getOrderActId());
		repairOrderAcceptance.setOrderId(act.getOrderId());

		//制单人
		if(StringUtil.isBlank(repairOrderAcceptance.getOriginatorId())){
			repairOrderAcceptance.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//编码
		if(StringUtil.isBlank(repairOrderAcceptance.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_REPAIR_ORDER_ACCEPTANCE.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				repairOrderAcceptance.setBusinessCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(repairOrderAcceptance,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param repairOrderAcceptance 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(RepairOrderAcceptance repairOrderAcceptance) {
		return this.insert(repairOrderAcceptance,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param repairOrderAcceptanceList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<RepairOrderAcceptance> repairOrderAcceptanceList) {
		return super.insertList(repairOrderAcceptanceList);
	}

	
	/**
	 * 按主键删除 维修验收
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		RepairOrderAcceptance repairOrderAcceptance = new RepairOrderAcceptance();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		repairOrderAcceptance.setId(id);
		try {
			boolean suc = dao.deleteEntity(repairOrderAcceptance);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 维修验收
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		RepairOrderAcceptance repairOrderAcceptance = new RepairOrderAcceptance();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		repairOrderAcceptance.setId(id);
		repairOrderAcceptance.setDeleted(true);
		repairOrderAcceptance.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		repairOrderAcceptance.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(repairOrderAcceptance,SaveMode.NOT_NULL_FIELDS);
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
	 * @param repairOrderAcceptance 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RepairOrderAcceptance repairOrderAcceptance , SaveMode mode) {
		return this.update(repairOrderAcceptance,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param repairOrderAcceptance 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RepairOrderAcceptance repairOrderAcceptance , SaveMode mode,boolean throwsException) {
		Result r=super.update(repairOrderAcceptance , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param repairOrderAcceptanceList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<RepairOrderAcceptance> repairOrderAcceptanceList , SaveMode mode) {
		return super.updateList(repairOrderAcceptanceList , mode);
	}

	
	/**
	 * 按主键更新字段 维修验收
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
	 * 按主键获取 维修验收
	 *
	 * @param id 主键
	 * @return RepairOrderAcceptance 数据对象
	 */
	public RepairOrderAcceptance getById(String id) {
		RepairOrderAcceptance sample = new RepairOrderAcceptance();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<RepairOrderAcceptance> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, RepairOrderAcceptance> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, RepairOrderAcceptance::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<RepairOrderAcceptance> queryList(RepairOrderAcceptance sample) {
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
	public PagedList<RepairOrderAcceptance> queryPagedList(RepairOrderAcceptance sample, int pageSize, int pageIndex) {
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
	public PagedList<RepairOrderAcceptance> queryPagedList(RepairOrderAcceptance sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param repairOrderAcceptance 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(RepairOrderAcceptance repairOrderAcceptance) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(repairOrderAcceptance, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(RepairOrderAcceptance sample) {
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