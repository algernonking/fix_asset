package com.dt.platform.datacenter.service.impl;


import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.datacenter.RackArea;
import com.dt.platform.domain.datacenter.RackAreaVO;
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
import com.dt.platform.datacenter.service.IRackAreaService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 机柜区域 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-30 16:39:10
*/


@Service("DcRackAreaService")
public class RackAreaServiceImpl extends SuperService<RackArea> implements IRackAreaService {
	
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
	 * @param rackArea 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(RackArea rackArea) {
		return super.insert(rackArea);
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param rackAreaList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<RackArea> rackAreaList) {
		return super.insertList(rackAreaList);
	}
	
	
	/**
	 * 按主键删除 机柜区域
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		RackArea rackArea = new RackArea();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		rackArea.setId(id);
		try {
			boolean suc = dao.deleteEntity(rackArea);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 机柜区域
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		RackArea rackArea = new RackArea();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		rackArea.setId(id);
		rackArea.setDeleted(dao.getDBTreaty().getTrueValue());
		rackArea.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		rackArea.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(rackArea,SaveMode.NOT_NULL_FIELDS);
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
	 * @param rackArea 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RackArea rackArea , SaveMode mode) {
		return super.update(rackArea , mode);
	}
	
	/**
	 * 更新实体集，事务内
	 * @param rackAreaList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<RackArea> rackAreaList , SaveMode mode) {
		return super.updateList(rackAreaList , mode);
	}
	
	
	/**
	 * 按主键更新字段 机柜区域
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
	 * 按主键获取 机柜区域
	 *
	 * @param id 主键
	 * @return RackArea 数据对象
	 */
	public RackArea getById(String id) {
		RackArea sample = new RackArea();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<RackArea> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<RackArea> queryList(RackArea sample) {
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
	public PagedList<RackArea> queryPagedList(RackArea sample, int pageSize, int pageIndex) {
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
	public PagedList<RackArea> queryPagedList(RackArea sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param rackArea 数据对象
	 * @return 判断结果
	 */
	public Result<RackArea> checkExists(RackArea rackArea) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(rackArea, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(RackArea sample) {
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