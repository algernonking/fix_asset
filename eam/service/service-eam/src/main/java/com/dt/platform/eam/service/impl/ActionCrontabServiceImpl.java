package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.github.foxnic.commons.lang.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.eam.ActionCrontab;
import com.dt.platform.domain.eam.ActionCrontabVO;
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
import com.dt.platform.eam.service.IActionCrontabService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 执行动作 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-03 13:55:20
*/


@Service("EamActionCrontabService")
public class ActionCrontabServiceImpl extends SuperService<ActionCrontab> implements IActionCrontabService {

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
	 * @param actionCrontab  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(ActionCrontab actionCrontab,boolean throwsException) {
		if(StringUtil.isBlank(actionCrontab.getOwnerId())){
			return ErrorDesc.failureMessage("请设置所属");
		}

		ActionCrontab data=getByOwnerId(actionCrontab.getOwnerId());
		if(data!=null){
			return ErrorDesc.failureMessage("请误重复创建");
		}

		Result r=super.insert(actionCrontab,throwsException);
		return r;
	}

	@Override
	public ActionCrontab getByOwnerId(String ownerId) {
		ActionCrontab data=new ActionCrontab();
		data.setOwnerId(ownerId);
		return this.queryEntity(data);
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param actionCrontab 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(ActionCrontab actionCrontab) {
		return this.insert(actionCrontab,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param actionCrontabList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<ActionCrontab> actionCrontabList) {
		return super.insertList(actionCrontabList);
	}

	
	/**
	 * 按主键删除 执行动作
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		ActionCrontab actionCrontab = new ActionCrontab();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		actionCrontab.setId(id);
		try {
			boolean suc = dao.deleteEntity(actionCrontab);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 执行动作
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		ActionCrontab actionCrontab = new ActionCrontab();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		actionCrontab.setId(id);
		actionCrontab.setDeleted(true);
		actionCrontab.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		actionCrontab.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(actionCrontab,SaveMode.NOT_NULL_FIELDS);
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
	 * @param actionCrontab 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ActionCrontab actionCrontab , SaveMode mode) {
		return this.update(actionCrontab,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param actionCrontab 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(ActionCrontab actionCrontab , SaveMode mode,boolean throwsException) {

		Result r=super.update(actionCrontab , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param actionCrontabList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<ActionCrontab> actionCrontabList , SaveMode mode) {
		return super.updateList(actionCrontabList , mode);
	}

	
	/**
	 * 按主键更新字段 执行动作
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
	 * 按主键获取 执行动作
	 *
	 * @param id 主键
	 * @return ActionCrontab 数据对象
	 */
	public ActionCrontab getById(String id) {
		ActionCrontab sample = new ActionCrontab();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<ActionCrontab> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, ActionCrontab> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, ActionCrontab::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<ActionCrontab> queryList(ActionCrontab sample) {
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
	public PagedList<ActionCrontab> queryPagedList(ActionCrontab sample, int pageSize, int pageIndex) {
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
	public PagedList<ActionCrontab> queryPagedList(ActionCrontab sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param actionCrontab 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(ActionCrontab actionCrontab) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(actionCrontab, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(ActionCrontab sample) {
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