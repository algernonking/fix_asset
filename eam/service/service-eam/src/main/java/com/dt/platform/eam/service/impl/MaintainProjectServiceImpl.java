package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.MaintainProjectSelect;
import com.dt.platform.eam.service.IMaintainProjectSelectService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.RcdSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.eam.MaintainProject;
import com.dt.platform.domain.eam.MaintainProjectVO;
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
import com.dt.platform.eam.service.IMaintainProjectService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 保养项目 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-04 06:14:43
*/


@Service("EamMaintainProjectService")
public class MaintainProjectServiceImpl extends SuperService<MaintainProject> implements IMaintainProjectService {

	@Autowired
	private IMaintainProjectSelectService maintainProjectSelectService;

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
	 * @param maintainProject  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(MaintainProject maintainProject,boolean throwsException) {

		//生成编码规则
		//编码
		if(StringUtil.isBlank(maintainProject.getCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_MAINTAIN_PROJECT.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				maintainProject.setCode(codeResult.getData().toString());
			}
		}
		Result r=super.insert(maintainProject,throwsException);
		return r;
	}

	@Override
	public PagedList<MaintainProject> queryPagedListBySelected(MaintainProjectVO sample, String ownerId, String ownerType) {
		ConditionExpr expr=new ConditionExpr();
		List<String> idsList=new ArrayList<>();
		String selectedCode=sample.getSelectedCode();
		sample.setSelectedCode(null);
		RcdSet rs=null;
		if(StringUtil.isBlank(ownerId)){
			rs=dao.query("select project_id from eam_maintain_project_select where deleted=0 and selected_code=?",selectedCode);
		 }else{
			rs=dao.query("select project_id from eam_maintain_project_select where deleted=0 and owner_id=?",ownerId);
		}
		if(rs.size()>0){
			idsList=rs.getValueList("projectId",String.class);
		}
		if(idsList.size()==0){
			idsList.add("-1");
		}
		expr.andIn("id",idsList);

		return super.queryPagedList(sample,expr,sample.getPageSize(),sample.getPageIndex());
	}

	@Override
	public PagedList<MaintainProject> queryPagedListBySelect(MaintainProjectVO sample, String ownerId, String ownerType) {
		ConditionExpr expr=new ConditionExpr();
		expr.and("1=1");
		List<String> idsList=new ArrayList<>();

		String selectedCode=sample.getSelectedCode();
		sample.setSelectedCode(null);
		RcdSet rs=null;
		if(StringUtil.isBlank(ownerId)){
			rs=dao.query("select project_id from eam_maintain_project_select where deleted=0 and selected_code=?",selectedCode);
		}else{
			rs=dao.query("select project_id from eam_maintain_project_select where deleted=0 and owner_id=?",ownerId);
		}
		if(rs.size()>0){
			idsList=rs.getValueList("projectId",String.class);
			expr.andNotIn("id",idsList.toArray());
		}
		return super.queryPagedList(sample,expr,sample.getPageSize(),sample.getPageIndex());
	}

	@Override
	public Result selected(List<String> ids, String ownerId, String selectedCode) {
		List<MaintainProjectSelect> list=new ArrayList<>();
		if(ids.size()==0){
			return ErrorDesc.failureMessage("请选择保养项目");
		}
		for(int i=0;i<ids.size();i++){
			MaintainProjectSelect project=new MaintainProjectSelect();
			project.setProjectId(ids.get(i));
			project.setSelectedCode(selectedCode);
			if(!StringUtil.isBlank(ownerId)){
				project.setOwnerId(ownerId);
			}
			list.add(project);
		}
		if(list.size()>0){
			maintainProjectSelectService.insertList(list);
		}
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param maintainProject 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(MaintainProject maintainProject) {
		return this.insert(maintainProject,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param maintainProjectList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<MaintainProject> maintainProjectList) {
		return super.insertList(maintainProjectList);
	}

	
	/**
	 * 按主键删除 保养项目
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		MaintainProject maintainProject = new MaintainProject();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintainProject.setId(id);
		try {
			boolean suc = dao.deleteEntity(maintainProject);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 保养项目
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		MaintainProject maintainProject = new MaintainProject();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		maintainProject.setId(id);
		maintainProject.setDeleted(true);
		maintainProject.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		maintainProject.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(maintainProject,SaveMode.NOT_NULL_FIELDS);
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
	 * @param maintainProject 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MaintainProject maintainProject , SaveMode mode) {
		return this.update(maintainProject,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param maintainProject 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(MaintainProject maintainProject , SaveMode mode,boolean throwsException) {


		Result r=super.update(maintainProject , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param maintainProjectList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<MaintainProject> maintainProjectList , SaveMode mode) {
		return super.updateList(maintainProjectList , mode);
	}

	
	/**
	 * 按主键更新字段 保养项目
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
	 * 按主键获取 保养项目
	 *
	 * @param id 主键
	 * @return MaintainProject 数据对象
	 */
	public MaintainProject getById(String id) {
		MaintainProject sample = new MaintainProject();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<MaintainProject> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, MaintainProject> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, MaintainProject::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<MaintainProject> queryList(MaintainProject sample) {
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
	public PagedList<MaintainProject> queryPagedList(MaintainProject sample, int pageSize, int pageIndex) {
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
	public PagedList<MaintainProject> queryPagedList(MaintainProject sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param maintainProject 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(MaintainProject maintainProject) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(maintainProject, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(MaintainProject sample) {
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