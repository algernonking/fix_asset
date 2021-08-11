package com.dt.platform.ops.service.impl;


import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.ops.WorkorderType;
import com.dt.platform.domain.ops.WorkorderTypeVO;
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
import com.dt.platform.ops.service.IWorkorderTypeService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 工单类型 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-11 21:30:42
*/


@Service("WorkorderTypeService")
public class WorkorderTypeServiceImpl extends SuperService<WorkorderType> implements IWorkorderTypeService {
	
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
	 * @param workorderType 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(WorkorderType workorderType) {
		return super.insert(workorderType);
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param workorderTypeList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<WorkorderType> workorderTypeList) {
		return super.insertList(workorderTypeList);
	}
	
	
	/**
	 * 按主键删除 工单类型
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		WorkorderType workorderType = new WorkorderType();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		workorderType.setId(id);
		try {
			boolean suc = dao.deleteEntity(workorderType);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 工单类型
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		WorkorderType workorderType = new WorkorderType();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		workorderType.setId(id);
		workorderType.setDeleted(dao.getDBTreaty().getTrueValue());
		workorderType.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		workorderType.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(workorderType,SaveMode.NOT_NULL_FIELDS);
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
	 * @param workorderType 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(WorkorderType workorderType , SaveMode mode) {
		return super.update(workorderType , mode);
	}
	
	/**
	 * 更新实体集，事务内
	 * @param workorderTypeList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<WorkorderType> workorderTypeList , SaveMode mode) {
		return super.updateList(workorderTypeList , mode);
	}
	
	
	/**
	 * 按主键更新字段 工单类型
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
	 * 按主键获取 工单类型
	 *
	 * @param id 主键
	 * @return WorkorderType 数据对象
	 */
	public WorkorderType getById(String id) {
		WorkorderType sample = new WorkorderType();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<WorkorderType> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<WorkorderType> queryList(WorkorderType sample) {
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
	public PagedList<WorkorderType> queryPagedList(WorkorderType sample, int pageSize, int pageIndex) {
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
	public PagedList<WorkorderType> queryPagedList(WorkorderType sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param workorderType 数据对象
	 * @return 判断结果
	 */
	public Result<WorkorderType> checkExists(WorkorderType workorderType) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(workorderType, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(WorkorderType sample) {
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