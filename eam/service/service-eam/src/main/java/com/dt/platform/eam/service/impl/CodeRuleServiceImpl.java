package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.dt.platform.domain.eam.CodePart;
import com.dt.platform.eam.service.ICodePartService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.eam.CodeRule;
import com.dt.platform.domain.eam.CodeRuleVO;

import java.util.*;

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
import com.dt.platform.eam.service.ICodeRuleService;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 编码字段 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 20:46:23
*/


@Service("EamCodeRuleService")
public class CodeRuleServiceImpl extends SuperService<CodeRule> implements ICodeRuleService {


	@Autowired
	private ICodePartService codePartService;

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
	 * @param codeRule  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(CodeRule codeRule,boolean throwsException) {
		Result r=super.insert(codeRule,throwsException);
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param codeRule 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(CodeRule codeRule) {
		return this.insert(codeRule,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param codeRuleList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<CodeRule> codeRuleList) {
		return super.insertList(codeRuleList);
	}

	
	/**
	 * 按主键删除 编码字段
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		CodeRule codeRule = new CodeRule();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		codeRule.setId(id);
		try {
			boolean suc = dao.deleteEntity(codeRule);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 编码字段
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		CodeRule codeRule = new CodeRule();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		codeRule.setId(id);
		codeRule.setDeleted(dao.getDBTreaty().getTrueValue());
		codeRule.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		codeRule.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(codeRule,SaveMode.NOT_NULL_FIELDS);
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
	 * @param codeRule 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CodeRule codeRule , SaveMode mode) {
		return this.update(codeRule,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param codeRule 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(CodeRule codeRule , SaveMode mode,boolean throwsException) {

		String ids=codeRule.getPartIds();
		if(StringUtil.isBlank(ids)){
			return ErrorDesc.failureMessage("请选择资产编码属性");
		}

		if(codeRule.getNumberSeq()>8){
			return ErrorDesc.failureMessage("序列位数过长，不可超过8位");
		}

		if(codeRule.getFs1().length()>5){
			return ErrorDesc.failureMessage("字符串过长");
		}

		if(codeRule.getCodeSeparator().length()>3){
			return ErrorDesc.failureMessage("字符串过长");
		}

		JSONArray idsArr=JSONArray.parseArray(ids);
		if(idsArr==null||idsArr.size()==0){
			return ErrorDesc.failureMessage("请选择资产编码属性");
		}

		ConditionExpr expr=new ConditionExpr();
		expr.andIn("id",idsArr.toJavaList(String.class));
		List<CodePart> partList=codePartService.queryList(expr);
		Map<String,CodePart> map=new HashMap<>();
		for(CodePart part:partList){
			map.put(part.getId(),part);
		}
		String value="";

		for(int i=0;i<idsArr.size();i++){
			CodePart part=map.get(idsArr.getString(i));
			if("time".equals(part.getType())){
				value=value+part.getCode();
			}else if("separator".equals(part.getType())){
				value=value+part.getCode().replaceAll("#SP#",codeRule.getCodeSeparator());
			}else if("number_seq".equals(part.getType())){
				value=value+part.getCode().replaceAll("#NUM#",codeRule.getNumberSeq().toString());
			}else if("string_fix".equals(part.getType())){
				value=value+part.getCode().replaceAll("#FS1#",codeRule.getFs1());
			}
			codeRule.setValue(value);
		}
		//更新
		Result r=super.update(codeRule , mode , throwsException);

		if(r.isSuccess()){
			Rcd rs=dao.queryRecord("select * from sys_code_allocation where code='eam_asset_code'");
			if(rs==null){
				return ErrorDesc.failureMessage("资产编码未生效");
			}
			String ruleId=rs.getString("rule_id");
			String ups="update sys_code_rule set rule=? where id=?";
			dao.execute(ups,codeRule.getValue(),ruleId);
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param codeRuleList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<CodeRule> codeRuleList , SaveMode mode) {
		return super.updateList(codeRuleList , mode);
	}

	
	/**
	 * 按主键更新字段 编码字段
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
	 * 按主键获取 编码字段
	 *
	 * @param id 主键
	 * @return CodeRule 数据对象
	 */
	public CodeRule getById(String id) {
		CodeRule sample = new CodeRule();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<CodeRule> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, CodeRule> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, CodeRule::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<CodeRule> queryList(CodeRule sample) {
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
	public PagedList<CodeRule> queryPagedList(CodeRule sample, int pageSize, int pageIndex) {
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
	public PagedList<CodeRule> queryPagedList(CodeRule sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param codeRule 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(CodeRule codeRule) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(codeRule, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(CodeRule sample) {
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