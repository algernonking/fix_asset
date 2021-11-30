package com.dt.platform.ops.service.impl;


import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.ops.HostMid;
import com.dt.platform.domain.ops.HostMidVO;
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
import com.dt.platform.ops.service.IHostMidService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import com.dt.platform.constants.db.EAMTables.*;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.ServiceInfo;

/**
 * <p>
 * 中间件 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-30 13:55:56
*/


@Service("OpsHostMidService")
public class HostMidServiceImpl extends SuperService<HostMid> implements IHostMidService {

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
	 * @param hostMid  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(HostMid hostMid,boolean throwsException) {
		Result r=super.insert(hostMid,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param hostMid 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(HostMid hostMid) {
		return this.insert(hostMid,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param hostMidList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<HostMid> hostMidList) {
		return super.insertList(hostMidList);
	}

	
	/**
	 * 按主键删除 中间件
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		HostMid hostMid = new HostMid();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		hostMid.setId(id);
		try {
			boolean suc = dao.deleteEntity(hostMid);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 中间件
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		HostMid hostMid = new HostMid();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		hostMid.setId(id);
		hostMid.setDeleted(dao.getDBTreaty().getTrueValue());
		hostMid.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		hostMid.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(hostMid,SaveMode.NOT_NULL_FIELDS);
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
	 * @param hostMid 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(HostMid hostMid , SaveMode mode) {
		return this.update(hostMid,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param hostMid 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(HostMid hostMid , SaveMode mode,boolean throwsException) {
		Result r=super.update(hostMid , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param hostMidList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<HostMid> hostMidList , SaveMode mode) {
		return super.updateList(hostMidList , mode);
	}

	
	/**
	 * 按主键更新字段 中间件
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
	 * 按主键获取 中间件
	 *
	 * @param id 主键
	 * @return HostMid 数据对象
	 */
	public HostMid getById(String id) {
		HostMid sample = new HostMid();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<HostMid> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<HostMid> queryList(HostMid sample) {
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
	public PagedList<HostMid> queryPagedList(HostMid sample, int pageSize, int pageIndex) {
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
	public PagedList<HostMid> queryPagedList(HostMid sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param hostMid 数据对象
	 * @return 判断结果
	 */
	public Result<HostMid> checkExists(HostMid hostMid) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(hostMid, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(HostMid sample) {
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
     * @param hostId 主机
     * @param serviceInfoIds 服务内容清单
     */
	public void saveRelation(String hostId,List<String> serviceInfoIds) {
		super.saveRelation(Host.class,OPS_HOST_MID.HOST_ID,hostId,ServiceInfo.class,OPS_HOST_MID.SERVICE_INFO_ID,serviceInfoIds,true);
	}

}