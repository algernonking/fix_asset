package com.dt.platform.ops.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetDataExportColumnEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.ops.OpsHostDataExportColumnEnum;
import com.dt.platform.constants.enums.ops.OpsOperateEnum;
import com.dt.platform.constants.enums.ops.ServiceTypeEnum;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.ops.service.IOpsDataService;
import com.dt.platform.ops.service.IServiceInfoService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.excel.*;
import com.github.foxnic.dao.meta.DBTableMeta;
import com.github.foxnic.dao.sql.SQLBuilder;
import com.github.foxnic.sql.expr.*;
import com.github.foxnic.sql.treaty.DBTreaty;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.HostVO;

import java.util.HashMap;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.api.error.ErrorDesc;

import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.dt.platform.ops.service.IHostService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 主机 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 11:16:53
*/


@Service("OpsHostService")
public class HostServiceImpl extends SuperService<Host> implements IHostService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Autowired 
	private HostMidServiceImpl hostMidServiceImpl;
	@Autowired 
	private HostOsServiceImpl hostOsServiceImpl;
	@Autowired 
	private HostDbServiceImpl hostDbServiceImpl;

	@Autowired
	private IOpsDataService opsDataService;

	@Autowired
	private IServiceInfoService serviceInfoService;
	
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}
	
	/**
	 * 插入实体
	 * @param host 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(Host host) {
		Result r=super.insert(host);
		//保存关系
		if(r.success()) {
			hostMidServiceImpl.saveRelation(host.getId(), host.getHostMiddlewareIds());
			hostOsServiceImpl.saveRelation(host.getId(), host.getHostOsIds());
			hostDbServiceImpl.saveRelation(host.getId(), host.getHostDbIds());
		}
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param hostList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<Host> hostList) {
		return super.insertList(hostList);
	}
	
	
	/**
	 * 按主键删除 主机
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		Host host = new Host();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		host.setId(id);
		try {
			boolean suc = dao.deleteEntity(host);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 主机
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		Host host = new Host();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		host.setId(id);
		host.setDeleted(dao.getDBTreaty().getTrueValue());
		host.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		host.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(host,SaveMode.NOT_NULL_FIELDS);
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
	 * @param host 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(Host host , SaveMode mode) {
		Result r=super.update(host , mode);
		//保存关系
		if(r.success()) {
			hostMidServiceImpl.saveRelation(host.getId(), host.getHostMiddlewareIds());
			hostOsServiceImpl.saveRelation(host.getId(), host.getHostOsIds());
			hostDbServiceImpl.saveRelation(host.getId(), host.getHostDbIds());
		}
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param hostList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<Host> hostList , SaveMode mode) {
		return super.updateList(hostList , mode);
	}
	
	
	/**
	 * 按主键更新字段 主机
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
	 * 按主键获取 主机
	 *
	 * @param id 主键
	 * @return Host 数据对象
	 */
	public Host getById(String id) {
		Host sample = new Host();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<Host> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<Host> queryList(Host sample) {
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
	public PagedList<Host> queryPagedList(Host sample, int pageSize, int pageIndex) {
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
	public PagedList<Host> queryPagedList(Host sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param host 数据对象
	 * @return 判断结果
	 */
	public Result<Host> checkExists(Host host) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(host, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(Host sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}


	public Result<List<SQL>> verifyHostOsDbMid(Rcd r) {
			Result<List<SQL>> result=new  Result<List<SQL>>();
			result.success();
			List<SQL> list=new ArrayList<SQL>();
			String id=r.getString("id");
			String os=r.getString("host_os");
			String db=r.getString("host_db");
			String mid=r.getString("host_mid");
			if(!StringUtil.isBlank(os)){
				String[] itemArr=os.split(",");
				for(int i=0;i<itemArr.length;i++){
					String item=itemArr[i].trim();
					ServiceInfo vo=serviceInfoService.queryEntity(ServiceInfo.create().setGroupId(ServiceTypeEnum.SERVICE_OS.code()).setName(item));
					if(vo==null){
						result.failure();
						return result.message("操作系统列表不存在:"+item);
					}else{
						Insert s=new Insert("ops_host_os");
						s.set("id",IDGenerator.getSnowflakeIdString());
						s.set("host_id",id);
						s.set("service_info_id",vo.getId());
						list.add(s);
					}
				}
			}
			if(!StringUtil.isBlank(db)){
				String[] itemArr=db.split(",");
				for(int i=0;i<itemArr.length;i++){
					String item=itemArr[i].trim();
					ServiceInfo vo=serviceInfoService.queryEntity(ServiceInfo.create().setGroupId(ServiceTypeEnum.SERVICE_DB.code()).setName(item));
					if(vo==null){
						result.failure();
						return result.message("数据库列表不存在:"+item);
					}else{
						Insert s=new Insert("ops_host_db");
						s.set("id",IDGenerator.getSnowflakeIdString());
						s.set("host_id",id);
						s.set("service_info_id",vo.getId());
						list.add(s);
					}
				}
			}

		if(!StringUtil.isBlank(mid)){
			String[] itemArr=mid.split(",");
			for(int i=0;i<itemArr.length;i++){
				String item=itemArr[i].trim();
				ServiceInfo vo=serviceInfoService.queryEntity(ServiceInfo.create().setGroupId(ServiceTypeEnum.SERVICE_MID.code()).setName(item));
				if(vo==null){
					result.failure();
					return result.message("中间件列表不存在:"+item);
				}else{
					Insert s=new Insert("ops_host_mid");
					s.set("id",IDGenerator.getSnowflakeIdString());
					s.set("host_id",id);
					s.set("service_info_id",vo.getId());
					list.add(s);
				}
			}
		}

		return result.data(list);
	}

		@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch,boolean fill) {

		List<ValidateResult> errors=new ArrayList<>();
		ExcelReader er=null;
		try {
			er=new ExcelReader(input);
		} catch (Exception e) {
			errors.add(new ValidateResult(null,-1,"缺少文件"));
			return errors;
		}
		//构建 Excel 结构
		ExcelStructure es=buildExcelStructure(false);
		//装换成记录集
		RcdSet rs=null;
		try {
			rs=er.read(sheetIndex,es);

		} catch (Exception e) {
			Logger.error("Excel 导入错误",e);
			errors.add(new ValidateResult(null,-1,"Excel 读取失败"));
			return errors;
		}

		DBTableMeta tm=dao().getTableMeta(this.table());
		DBTreaty dbTreaty= dao().getDBTreaty();

		List<SQL> sqls=new ArrayList<>();
		List<SQL> deleteSqls=new ArrayList<>();
		List<SQL> addSqls=new ArrayList<>();
		for (Rcd r : rs) {

			//可在此处校验数据
			System.out.println("before:"+r);
			Result verifyResult=opsDataService.verifyHostRecord(r,null,fill);
			if(!verifyResult.isSuccess()){
				errors.add(new ValidateResult(null,1,verifyResult.getMessage()));
				continue;
			}

			String sql="";

			if(StringUtil.isBlank(r.getString(OpsHostDataExportColumnEnum.HOST_ID.text()))){
				r.set("id",IDGenerator.getSnowflakeIdString());
				Result<List<SQL>> resultHost=verifyHostOsDbMid(r);
				if(!resultHost.isSuccess()){
					errors.add(new ValidateResult(null,1,verifyResult.getMessage()));
					continue;
				}
				addSqls=resultHost.getData();
				Insert insert = SQLBuilder.buildInsert(r,this.table(),this.dao(), true);
				insert.set("tenant_id","T001");

				//设置创建时间
				if(tm.getColumn(dbTreaty.getCreateTimeField())!=null) {
					insert.set(dbTreaty.getCreateTimeField(),new Date());
				}
				if(tm.getColumn(dbTreaty.getCreateUserIdField())!=null) {
					insert.set(dbTreaty.getCreateUserIdField(), dbTreaty.getLoginUserId());
				}
				if(tm.getColumn(dbTreaty.getDeletedField())!=null) {
					insert.set(dbTreaty.getDeletedField(), dbTreaty.getFalseValue());
				}
				if(batch) {
					sqls.add(insert);
				} else {
					this.dao().execute(insert);
				}
				sql=insert.getSQL();

			}else{
				Result<List<SQL>> resultHost=verifyHostOsDbMid(r);
				if(!resultHost.isSuccess()){
					errors.add(new ValidateResult(null,1,verifyResult.getMessage()));
					continue;
				}
				addSqls=resultHost.getData();
				Delete del1=new Delete("ops_host_os");
				del1.where().and("host_id=?",r.getString("id"));
				Delete del2=new Delete("ops_host_db");
				del1.where().and("host_id=?",r.getString("id"));
				Delete del3=new Delete("ops_host_mid");
				del1.where().and("host_id=?",r.getString("id"));
				deleteSqls.add(del1);
				deleteSqls.add(del2);
				deleteSqls.add(del3);
				Update update=SQLBuilder.buildUpdate(r,SaveMode.ALL_FIELDS,this.table(),this.dao());

				//设置创建时间
				if(tm.getColumn(dbTreaty.getUpdateTimeField())!=null) {
					update.set(dbTreaty.getUpdateTimeField(),new Date());
				}
				if(tm.getColumn(dbTreaty.getUpdateUserIdField())!=null) {
					update.set(dbTreaty.getUpdateUserIdField(), dbTreaty.getLoginUserId());
				}
				if(batch) {
					sqls.add(update);
				} else {
					this.dao().execute(update);
				}
				sql=update.getSQL();

			}
			System.out.println("after:"+r);
			System.out.println(sql);
		}

		if(batch) {
			try {
				if(errors.size()==0){
					dao().batchExecute(sqls);
					if(deleteSqls.size()>0){
						dao().batchExecute(deleteSqls);
					}
					if(addSqls.size()>0){
						for(int i=0;i<addSqls.size();i++){
							System.out.println(addSqls.get(i).getSQL());
						}
						dao().batchExecute(addSqls);
					}
				}

			} catch (Exception e) {
				errors.add(new ValidateResult(null,3,"批量导入失败"));
				throw  e;
			}
		}
		return errors;

	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport)
	{

		ExcelStructure es=new ExcelStructure();
		es.setDataColumnBegin(0);
		es.setDataRowBegin(2);
		String code= OpsOperateEnum.OPS_DOWNLOAD_HOST.code();
		InputStream inputStream= TplFileServiceProxy.api().getTplFileStreamByCode(code);
		Workbook workbook;
		if ( inputStream != null) {
			try {
				workbook = WorkbookFactory.create(inputStream);
				Sheet sheet=workbook.getSheetAt(0);
				Row firstRow=sheet.getRow(0);
				Row row=sheet.getRow(1);
				String charIndex="";
				for(int i=0;i<row.getLastCellNum();i++){
					String column=row.getCell(i).toString().replaceFirst("\\{\\{\\$fe:","")
							.replaceFirst("dataList","")
							.replaceFirst("}}","")
							.replaceFirst("t.","").trim();

					String rColumn= EnumUtil.parseByCode(OpsHostDataExportColumnEnum.class,column)==null?
							BeanNameUtil.instance().depart(column):
							EnumUtil.parseByCode(OpsHostDataExportColumnEnum.class,column).text();

					System.out.println(row.getCell(i)  +","+ firstRow.getCell(i)+","+column+","+rColumn);
					charIndex=ExcelStructure.toExcel26(i);
					es.addColumn(charIndex,rColumn,firstRow.getCell(i).toString(), ExcelColumn.STRING_CELL_READER);
				}
				//追加自定义属性部分
			} catch (Exception e) {
				Logger.debug("Excel 读取错误", e);
			}
		}

		return es;
	}


}