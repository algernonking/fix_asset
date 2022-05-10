package com.dt.platform.eam.service.impl;


import com.dt.platform.constants.db.EAMTables.EAM_INVENTORY_MANAGER;
import com.dt.platform.domain.eam.InventoryManager;
import com.dt.platform.eam.service.IInventoryManagerService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 资产管理人 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-19 21:37:25
*/


@Service("EamInventoryManagerService")
public class InventoryManagerServiceImpl extends SuperService<InventoryManager> implements IInventoryManagerService {

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
	 * @param inventoryManager  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(InventoryManager inventoryManager,boolean throwsException) {
		Result r=super.insert(inventoryManager,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param inventoryManager 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(InventoryManager inventoryManager) {
		return this.insert(inventoryManager,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param inventoryManagerList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<InventoryManager> inventoryManagerList) {
		return super.insertList(inventoryManagerList);
	}

	
	/**
	 * 按主键删除 资产管理人
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		InventoryManager inventoryManager = new InventoryManager();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inventoryManager.setId(id);
		try {
			boolean suc = dao.deleteEntity(inventoryManager);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产管理人
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		InventoryManager inventoryManager = new InventoryManager();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inventoryManager.setId(id);
		inventoryManager.setDeleted(dao.getDBTreaty().getTrueValue());
		inventoryManager.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		inventoryManager.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(inventoryManager,SaveMode.NOT_NULL_FIELDS);
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
	 * @param inventoryManager 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InventoryManager inventoryManager , SaveMode mode) {
		return this.update(inventoryManager,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param inventoryManager 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InventoryManager inventoryManager , SaveMode mode,boolean throwsException) {
		Result r=super.update(inventoryManager , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param inventoryManagerList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<InventoryManager> inventoryManagerList , SaveMode mode) {
		return super.updateList(inventoryManagerList , mode);
	}

	
	/**
	 * 按主键更新字段 资产管理人
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
	 * 按主键获取 资产管理人
	 *
	 * @param id 主键
	 * @return InventoryManager 数据对象
	 */
	public InventoryManager getById(String id) {
		InventoryManager sample = new InventoryManager();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<InventoryManager> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<InventoryManager> queryList(InventoryManager sample) {
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
	public PagedList<InventoryManager> queryPagedList(InventoryManager sample, int pageSize, int pageIndex) {
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
	public PagedList<InventoryManager> queryPagedList(InventoryManager sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param inventoryManager 数据对象
	 * @return 判断结果
	 */
	public Result<InventoryManager> checkExists(InventoryManager inventoryManager) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(inventoryManager, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(InventoryManager sample) {
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

	/**
     * 保存关系
     * @param inventoryId 盘点
     * @param userIds 盘点人清单
     */
	public void saveRelation(String inventoryId,List<String> userIds) {
		super.saveRelation(InventoryManager.class,EAM_INVENTORY_MANAGER.INVENTORY_ID,inventoryId, Employee.class, EAM_INVENTORY_MANAGER.USER_ID,userIds,true);
	}

}
