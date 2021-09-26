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


import com.dt.platform.proxy.common.CodeAllocationServiceProxy;
import com.dt.platform.domain.common.meta.CodeAllocationVOMeta;
import com.dt.platform.domain.common.CodeAllocation;
import com.dt.platform.domain.common.CodeAllocationVO;
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
import com.dt.platform.domain.common.meta.CodeAllocationMeta;
import com.dt.platform.domain.common.CodeRule;
import com.dt.platform.domain.common.CodeRegister;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.ICodeAllocationService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 编码分配 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 11:14:40
*/

@Api(tags = "编码分配")
@ApiSort(0)
@RestController("SysCodeAllocationController")
public class CodeAllocationController extends SuperController {

	@Autowired
	private ICodeAllocationService codeAllocationService;

	
	/**
	 * 添加编码分配
	*/
	@ApiOperation(value = "添加编码分配")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAllocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.CODE , value = "业务编码" , required = false , dataTypeClass=String.class , example = "eam_asset_allocate"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.RULE_ID , value = "规则ID" , required = false , dataTypeClass=String.class , example = "5"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "EAM资产调拨编码生成规则"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CodeAllocationServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAllocationServiceProxy.INSERT)
	public Result insert(CodeAllocationVO codeAllocationVO) {
		Result result=codeAllocationService.insert(codeAllocationVO);
		return result;
	}

	
	/**
	 * 删除编码分配
	*/
	@ApiOperation(value = "删除编码分配")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAllocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CodeAllocationVOMeta.ID)
	@SentinelResource(value = CodeAllocationServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAllocationServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=codeAllocationService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除编码分配 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除编码分配")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAllocationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CodeAllocationVOMeta.IDS)
	@SentinelResource(value = CodeAllocationServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAllocationServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=codeAllocationService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新编码分配
	*/
	@ApiOperation(value = "更新编码分配")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAllocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.CODE , value = "业务编码" , required = false , dataTypeClass=String.class , example = "eam_asset_allocate"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.RULE_ID , value = "规则ID" , required = false , dataTypeClass=String.class , example = "5"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "EAM资产调拨编码生成规则"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CodeAllocationVOMeta.PAGE_INDEX , CodeAllocationVOMeta.PAGE_SIZE , CodeAllocationVOMeta.SEARCH_FIELD , CodeAllocationVOMeta.FUZZY_FIELD , CodeAllocationVOMeta.SEARCH_VALUE , CodeAllocationVOMeta.SORT_FIELD , CodeAllocationVOMeta.SORT_TYPE , CodeAllocationVOMeta.IDS } ) 
	@NotNull(name = CodeAllocationVOMeta.ID)
	@SentinelResource(value = CodeAllocationServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAllocationServiceProxy.UPDATE)
	public Result update(CodeAllocationVO codeAllocationVO) {
		Result result=codeAllocationService.update(codeAllocationVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存编码分配
	*/
	@ApiOperation(value = "保存编码分配")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAllocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.CODE , value = "业务编码" , required = false , dataTypeClass=String.class , example = "eam_asset_allocate"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.RULE_ID , value = "规则ID" , required = false , dataTypeClass=String.class , example = "5"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "EAM资产调拨编码生成规则"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeAllocationVOMeta.PAGE_INDEX , CodeAllocationVOMeta.PAGE_SIZE , CodeAllocationVOMeta.SEARCH_FIELD , CodeAllocationVOMeta.FUZZY_FIELD , CodeAllocationVOMeta.SEARCH_VALUE , CodeAllocationVOMeta.SORT_FIELD , CodeAllocationVOMeta.SORT_TYPE , CodeAllocationVOMeta.IDS } )
	@NotNull(name = CodeAllocationVOMeta.ID)
	@SentinelResource(value = CodeAllocationServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAllocationServiceProxy.SAVE)
	public Result save(CodeAllocationVO codeAllocationVO) {
		Result result=codeAllocationService.save(codeAllocationVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取编码分配
	*/
	@ApiOperation(value = "获取编码分配")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAllocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CodeAllocationVOMeta.ID)
	@SentinelResource(value = CodeAllocationServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAllocationServiceProxy.GET_BY_ID)
	public Result<CodeAllocation> getById(String id) {
		Result<CodeAllocation> result=new Result<>();
		CodeAllocation codeAllocation=codeAllocationService.getById(id);
		// 关联出 业务编码 数据
		codeAllocationService.join(codeAllocation,CodeAllocationMeta.BUSINESS_CODE);
		// 关联出 编码规则 数据
		codeAllocationService.join(codeAllocation,CodeAllocationMeta.RULE);
		result.success(true).data(codeAllocation);
		return result;
	}


	/**
	 * 批量删除编码分配 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除编码分配")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CodeAllocationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CodeAllocationVOMeta.IDS)
		@SentinelResource(value = CodeAllocationServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAllocationServiceProxy.GET_BY_IDS)
	public Result<List<CodeAllocation>> getByIds(List<String> ids) {
		Result<List<CodeAllocation>> result=new Result<>();
		List<CodeAllocation> list=codeAllocationService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询编码分配
	*/
	@ApiOperation(value = "查询编码分配")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAllocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.CODE , value = "业务编码" , required = false , dataTypeClass=String.class , example = "eam_asset_allocate"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.RULE_ID , value = "规则ID" , required = false , dataTypeClass=String.class , example = "5"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "EAM资产调拨编码生成规则"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeAllocationVOMeta.PAGE_INDEX , CodeAllocationVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CodeAllocationServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAllocationServiceProxy.QUERY_LIST)
	public Result<List<CodeAllocation>> queryList(CodeAllocationVO sample) {
		Result<List<CodeAllocation>> result=new Result<>();
		List<CodeAllocation> list=codeAllocationService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询编码分配
	*/
	@ApiOperation(value = "分页查询编码分配")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAllocationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.CODE , value = "业务编码" , required = false , dataTypeClass=String.class , example = "eam_asset_allocate"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.RULE_ID , value = "规则ID" , required = false , dataTypeClass=String.class , example = "5"),
		@ApiImplicitParam(name = CodeAllocationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "EAM资产调拨编码生成规则"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CodeAllocationServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAllocationServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CodeAllocation>> queryPagedList(CodeAllocationVO sample) {
		Result<PagedList<CodeAllocation>> result=new Result<>();
		PagedList<CodeAllocation> list=codeAllocationService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 业务编码 数据
		codeAllocationService.join(list,CodeAllocationMeta.BUSINESS_CODE);
		// 关联出 编码规则 数据
		codeAllocationService.join(list,CodeAllocationMeta.RULE);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CodeAllocationServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeAllocationServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CodeAllocationVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=codeAllocationService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CodeAllocationServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeAllocationServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=codeAllocationService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = CodeAllocationServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeAllocationServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=codeAllocationService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}