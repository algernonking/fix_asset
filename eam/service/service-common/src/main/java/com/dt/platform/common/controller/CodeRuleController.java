package com.dt.platform.common.controller;

 
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.common.CodeRuleServiceProxy;
import com.dt.platform.domain.common.meta.CodeRuleVOMeta;
import com.dt.platform.domain.common.CodeRule;
import com.dt.platform.domain.common.CodeRuleVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.common.meta.CodeRuleMeta;
import org.github.foxnic.web.domain.oauth.Menu;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.ICodeRuleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 编码规则 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-03 21:35:02
*/

@Api(tags = "编码规则")
@ApiSort(0)
@RestController("SysCodeRuleController")
public class CodeRuleController extends SuperController {

	@Autowired
	private ICodeRuleService codeRuleService;

	
	/**
	 * 添加编码规则
	*/
	@ApiOperation(value = "添加编码规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeRuleVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class , example = "EAM资产编号"),
		@ApiImplicitParam(name = CodeRuleVOMeta.MODULE_ID , value = "业务模块" , required = false , dataTypeClass=String.class , example = "eam"),
		@ApiImplicitParam(name = CodeRuleVOMeta.RULE , value = "编码规则" , required = false , dataTypeClass=String.class , example = "${string_fix,AS}${string_fix,-}${number_rand,5}${number_seq,5,asset}"),
		@ApiImplicitParam(name = CodeRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = CodeRuleVOMeta.ID)
	@SentinelResource(value = CodeRuleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeRuleServiceProxy.INSERT)
	public Result insert(CodeRuleVO codeRuleVO) {
		Result result=codeRuleService.insert(codeRuleVO);
		return result;
	}

	
	/**
	 * 删除编码规则
	*/
	@ApiOperation(value = "删除编码规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CodeRuleVOMeta.ID)
	@SentinelResource(value = CodeRuleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeRuleServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=codeRuleService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除编码规则 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除编码规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeRuleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CodeRuleVOMeta.IDS)
	@SentinelResource(value = CodeRuleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeRuleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=codeRuleService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新编码规则
	*/
	@ApiOperation(value = "更新编码规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeRuleVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class , example = "EAM资产编号"),
		@ApiImplicitParam(name = CodeRuleVOMeta.MODULE_ID , value = "业务模块" , required = false , dataTypeClass=String.class , example = "eam"),
		@ApiImplicitParam(name = CodeRuleVOMeta.RULE , value = "编码规则" , required = false , dataTypeClass=String.class , example = "${string_fix,AS}${string_fix,-}${number_rand,5}${number_seq,5,asset}"),
		@ApiImplicitParam(name = CodeRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CodeRuleVOMeta.PAGE_INDEX , CodeRuleVOMeta.PAGE_SIZE , CodeRuleVOMeta.SEARCH_FIELD , CodeRuleVOMeta.FUZZY_FIELD , CodeRuleVOMeta.SEARCH_VALUE , CodeRuleVOMeta.SORT_FIELD , CodeRuleVOMeta.SORT_TYPE , CodeRuleVOMeta.IDS } ) 
	@NotNull(name = CodeRuleVOMeta.ID)
	@SentinelResource(value = CodeRuleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeRuleServiceProxy.UPDATE)
	public Result update(CodeRuleVO codeRuleVO) {
		Result result=codeRuleService.update(codeRuleVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存编码规则
	*/
	@ApiOperation(value = "保存编码规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeRuleVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class , example = "EAM资产编号"),
		@ApiImplicitParam(name = CodeRuleVOMeta.MODULE_ID , value = "业务模块" , required = false , dataTypeClass=String.class , example = "eam"),
		@ApiImplicitParam(name = CodeRuleVOMeta.RULE , value = "编码规则" , required = false , dataTypeClass=String.class , example = "${string_fix,AS}${string_fix,-}${number_rand,5}${number_seq,5,asset}"),
		@ApiImplicitParam(name = CodeRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeRuleVOMeta.PAGE_INDEX , CodeRuleVOMeta.PAGE_SIZE , CodeRuleVOMeta.SEARCH_FIELD , CodeRuleVOMeta.FUZZY_FIELD , CodeRuleVOMeta.SEARCH_VALUE , CodeRuleVOMeta.SORT_FIELD , CodeRuleVOMeta.SORT_TYPE , CodeRuleVOMeta.IDS } )
	@NotNull(name = CodeRuleVOMeta.ID)
	@SentinelResource(value = CodeRuleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeRuleServiceProxy.SAVE)
	public Result save(CodeRuleVO codeRuleVO) {
		Result result=codeRuleService.save(codeRuleVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取编码规则
	*/
	@ApiOperation(value = "获取编码规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CodeRuleVOMeta.ID)
	@SentinelResource(value = CodeRuleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeRuleServiceProxy.GET_BY_ID)
	public Result<CodeRule> getById(String id) {
		Result<CodeRule> result=new Result<>();
		CodeRule codeRule=codeRuleService.getById(id);
		// 关联出 模块 数据
		codeRuleService.join(codeRule,CodeRuleMeta.MODULE);
		result.success(true).data(codeRule);
		return result;
	}


	/**
	 * 批量删除编码规则 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除编码规则")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CodeRuleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CodeRuleVOMeta.IDS)
		@SentinelResource(value = CodeRuleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeRuleServiceProxy.GET_BY_IDS)
	public Result<List<CodeRule>> getByIds(List<String> ids) {
		Result<List<CodeRule>> result=new Result<>();
		List<CodeRule> list=codeRuleService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询编码规则
	*/
	@ApiOperation(value = "查询编码规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeRuleVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class , example = "EAM资产编号"),
		@ApiImplicitParam(name = CodeRuleVOMeta.MODULE_ID , value = "业务模块" , required = false , dataTypeClass=String.class , example = "eam"),
		@ApiImplicitParam(name = CodeRuleVOMeta.RULE , value = "编码规则" , required = false , dataTypeClass=String.class , example = "${string_fix,AS}${string_fix,-}${number_rand,5}${number_seq,5,asset}"),
		@ApiImplicitParam(name = CodeRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeRuleVOMeta.PAGE_INDEX , CodeRuleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CodeRuleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeRuleServiceProxy.QUERY_LIST)
	public Result<List<CodeRule>> queryList(CodeRuleVO sample) {
		Result<List<CodeRule>> result=new Result<>();
		List<CodeRule> list=codeRuleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询编码规则
	*/
	@ApiOperation(value = "分页查询编码规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeRuleVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class , example = "EAM资产编号"),
		@ApiImplicitParam(name = CodeRuleVOMeta.MODULE_ID , value = "业务模块" , required = false , dataTypeClass=String.class , example = "eam"),
		@ApiImplicitParam(name = CodeRuleVOMeta.RULE , value = "编码规则" , required = false , dataTypeClass=String.class , example = "${string_fix,AS}${string_fix,-}${number_rand,5}${number_seq,5,asset}"),
		@ApiImplicitParam(name = CodeRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CodeRuleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeRuleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CodeRule>> queryPagedList(CodeRuleVO sample) {
		Result<PagedList<CodeRule>> result=new Result<>();
		PagedList<CodeRule> list=codeRuleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 模块 数据
		codeRuleService.join(list,CodeRuleMeta.MODULE);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CodeRuleServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeRuleServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CodeRuleVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=codeRuleService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CodeRuleServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeRuleServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=codeRuleService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = CodeRuleServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeRuleServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

			//获得上传的文件
			Map<String, MultipartFile> map = request.getFileMap();
			InputStream input=null;
			for (MultipartFile mf : map.values()) {
				input=StreamUtil.bytes2input(mf.getBytes());
				break;
			}

			if(input==null) {
				return ErrorDesc.failure().message("缺少上传的文件");
			}

			List<ValidateResult> errors=codeRuleService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}