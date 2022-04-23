package com.dt.platform.vehicle.service.impl;


import javax.annotation.Resource;

import com.github.foxnic.commons.lang.DateUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.entity.QuerySQLBuilder;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.sql.expr.Expr;
import com.github.foxnic.sql.expr.OrderBy;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.vehicle.Info;
import com.dt.platform.domain.vehicle.InfoVO;
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
import com.dt.platform.vehicle.service.IInfoService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 车辆信息 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 13:04:04
*/


@Service("VehicleInfoService")
public class InfoServiceImpl extends SuperService<Info> implements IInfoService {

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
	 * @param info  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(Info info,boolean throwsException) {
		Result r=super.insert(info,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param info 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(Info info) {
		return this.insert(info,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param infoList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Info> infoList) {

		return super.insertList(infoList);
	}

	
	/**
	 * 按主键删除 车辆信息
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Info info = new Info();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		info.setId(id);
		try {
			boolean suc = dao.deleteEntity(info);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 车辆信息
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Info info = new Info();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		info.setId(id);
		info.setDeleted(dao.getDBTreaty().getTrueValue());
		info.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		info.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(info,SaveMode.NOT_NULL_FIELDS);
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
	 * @param info 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Info info , SaveMode mode) {
		return this.update(info,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param info 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(Info info , SaveMode mode,boolean throwsException) {
		Result r=super.update(info , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param infoList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Info> infoList , SaveMode mode) {
		return super.updateList(infoList , mode);
	}

	
	/**
	 * 按主键更新字段 车辆信息
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
	 * 按主键获取 车辆信息
	 *
	 * @param id 主键
	 * @return Info 数据对象
	 */
	public Info getById(String id) {
		Info sample = new Info();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Info> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Info> queryList(Info sample) {
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
	public PagedList<Info> queryPagedList(Info sample, int pageSize, int pageIndex) {
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
	public PagedList<Info> queryPagedList(Info sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param info 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(Info info) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(info, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(Info sample){
	DBTableMeta tm=this.dao().getTableMeta(this.table());


	String tableAlais="t";
	OrderBy orderBy=this.buildOrderBy(sample);
		if(orderBy==null) {
		DBColumnMeta cm=dao().getTableColumnMeta(table(), dao().getDBTreaty().getCreateTimeField());
		if(cm!=null) {
			orderBy=OrderBy.byDesc(tableAlais+"."+cm.getColumn());
		}
	}

	Expr select=buildQuerySQL(sample,tableAlais,null,orderBy);

	String subsql=" id ,  name ," +
			"  (select label from sys_dict_item a where dict_code='vehicle_status' and a.code=t.vehicle_status) vehicle_status," +
			"  (select label from sys_dict_item a where dict_code='vehicle_type' and a.code=t.type) type , " +
			" code ,  model ,  registrant ," +
			"  (select full_name from hrm_organization where id=t.owner_org_id) owner_org_id , " +
			" (select full_name from hrm_organization where id=t.use_org_id) use_org_id, " +
			" (select name from hrm_person where id in (select person_id from hrm_employee  where id=t.use_user_id) )use_user_id , " +
			" color ,  engine_number ,  frame_number ,  driving_license ,  kilometers ,  rescue_money ,  commercial_insurance_money ,  insurance_company ,  licensing_time ,  insurance_expire_date ,  version ,  scrap_time ,  position_detail ,  pictures ,  originator_id ,  technical_parameter ,  vehicle_count ,  notes ,  create_by ,  create_time ,  update_by ,  update_time ,  deleted ,  delete_by ,  delete_time ,  tenant_id ";
	String sql="select "+subsql+" from vehicle_info t WHERE ( ( t.deleted= 0 AND t.tenant_id= 'T001' )) ORDER BY t.create_time DESC";
	//查询数据
		System.out.println("#########SQL:\n"+sql);
	RcdSet rs=this.dao().query(sql);
	//写入
	ExcelWriter ew=new ExcelWriter();
	ExcelStructure es=buildExcelStructure(true);
	//ExcelStructure es1=ExcelStructure.parse(rs,true);

	//Sheet sheet=ew.fillSheet(rs, tm.getShortTopic()+"清单",es);
	ew.setWorkBookName(tm.getShortTopic()+"清单-"+ DateUtil.format(new Date(),"yyyyMMdd-HHmmss") +".xlsx");
	Logger.info("导出 "+this.table()+" 数据 "+rs.size() +" 行");
		return ew;

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