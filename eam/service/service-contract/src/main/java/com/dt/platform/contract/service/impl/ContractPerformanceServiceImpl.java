package com.dt.platform.contract.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.contract.ContractPerformance;
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
import java.util.ArrayList;
import com.dt.platform.contract.service.IContractPerformanceService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 合同履行情况表 服务实现
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-28 14:20:20
*/


@Service("ContContractPerformanceService")
public class ContractPerformanceServiceImpl extends SuperService<ContractPerformance> implements IContractPerformanceService {

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
	 * @param contractPerformance  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(ContractPerformance contractPerformance,boolean throwsException) {
		Result r=super.insert(contractPerformance,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param contractPerformance 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(ContractPerformance contractPerformance) {
		return this.insert(contractPerformance,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param contractPerformanceList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<ContractPerformance> contractPerformanceList) {
		return super.insertList(contractPerformanceList);
	}

	
	/**
	 * 按主键删除 合同履行情况
	 *
	 * @param id id
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		ContractPerformance contractPerformance = new ContractPerformance();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		contractPerformance.setId(id);
		try {
			boolean suc = dao.deleteEntity(contractPerformance);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 合同履行情况
	 *
	 * @param id id
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		ContractPerformance contractPerformance = new ContractPerformance();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		contractPerformance.setId(id);
		contractPerformance.setDeleted(dao.getDBTreaty().getTrueValue());
		contractPerformance.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		contractPerformance.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(contractPerformance,SaveMode.NOT_NULL_FIELDS);
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
	 * @param contractPerformance 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ContractPerformance contractPerformance , SaveMode mode) {
		return this.update(contractPerformance,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param contractPerformance 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ContractPerformance contractPerformance , SaveMode mode,boolean throwsException) {
		Result r=super.update(contractPerformance , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param contractPerformanceList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<ContractPerformance> contractPerformanceList , SaveMode mode) {
		return super.updateList(contractPerformanceList , mode);
	}

	
	/**
	 * 按主键更新字段 合同履行情况
	 *
	 * @param id id
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}

	
	/**
	 * 按主键获取 合同履行情况
	 *
	 * @param id id
	 * @return ContractPerformance 数据对象
	 */
	public ContractPerformance getById(String id) {
		ContractPerformance sample = new ContractPerformance();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<ContractPerformance> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<ContractPerformance> queryList(ContractPerformance sample) {
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
	public PagedList<ContractPerformance> queryPagedList(ContractPerformance sample, int pageSize, int pageIndex) {
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
	public PagedList<ContractPerformance> queryPagedList(ContractPerformance sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param contractPerformance 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(ContractPerformance contractPerformance) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(contractPerformance, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(ContractPerformance sample) {
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