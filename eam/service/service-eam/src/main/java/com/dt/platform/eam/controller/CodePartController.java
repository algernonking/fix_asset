package com.dt.platform.eam.controller;


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


import com.dt.platform.proxy.eam.CodePartServiceProxy;
import com.dt.platform.domain.eam.meta.CodePartVOMeta;
import com.dt.platform.domain.eam.CodePart;
import com.dt.platform.domain.eam.CodePartVO;
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
import com.dt.platform.domain.eam.meta.CodePartMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICodePartService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 编码字段 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 21:06:36
*/

@Api(tags = "编码字段")
@ApiSort(0)
@RestController("EamCodePartController")
public class CodePartController extends SuperController {

	@Autowired
	private ICodePartService codePartService;


	/**
	 * 添加编码字段
	*/
	@ApiOperation(value = "添加编码字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodePartVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodePartVOMeta.CODE , value = "字段" , required = false , dataTypeClass=String.class , example = "${time,yyyy}"),
		@ApiImplicitParam(name = CodePartVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "年-(2021)"),
		@ApiImplicitParam(name = CodePartVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "time"),
		@ApiImplicitParam(name = CodePartVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CodePartServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodePartServiceProxy.INSERT)
	public Result insert(CodePartVO codePartVO) {
		Result result=codePartService.insert(codePartVO,false);
		return result;
	}



	/**
	 * 删除编码字段
	*/
	@ApiOperation(value = "删除编码字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodePartVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CodePartVOMeta.ID)
	@SentinelResource(value = CodePartServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodePartServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=codePartService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除编码字段 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除编码字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodePartVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CodePartVOMeta.IDS)
	@SentinelResource(value = CodePartServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodePartServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=codePartService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新编码字段
	*/
	@ApiOperation(value = "更新编码字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodePartVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodePartVOMeta.CODE , value = "字段" , required = false , dataTypeClass=String.class , example = "${time,yyyy}"),
		@ApiImplicitParam(name = CodePartVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "年-(2021)"),
		@ApiImplicitParam(name = CodePartVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "time"),
		@ApiImplicitParam(name = CodePartVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CodePartVOMeta.PAGE_INDEX , CodePartVOMeta.PAGE_SIZE , CodePartVOMeta.SEARCH_FIELD , CodePartVOMeta.FUZZY_FIELD , CodePartVOMeta.SEARCH_VALUE , CodePartVOMeta.DIRTY_FIELDS , CodePartVOMeta.SORT_FIELD , CodePartVOMeta.SORT_TYPE , CodePartVOMeta.IDS } )
	@NotNull(name = CodePartVOMeta.ID)
	@SentinelResource(value = CodePartServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodePartServiceProxy.UPDATE)
	public Result update(CodePartVO codePartVO) {
		Result result=codePartService.update(codePartVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存编码字段
	*/
	@ApiOperation(value = "保存编码字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodePartVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodePartVOMeta.CODE , value = "字段" , required = false , dataTypeClass=String.class , example = "${time,yyyy}"),
		@ApiImplicitParam(name = CodePartVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "年-(2021)"),
		@ApiImplicitParam(name = CodePartVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "time"),
		@ApiImplicitParam(name = CodePartVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodePartVOMeta.PAGE_INDEX , CodePartVOMeta.PAGE_SIZE , CodePartVOMeta.SEARCH_FIELD , CodePartVOMeta.FUZZY_FIELD , CodePartVOMeta.SEARCH_VALUE , CodePartVOMeta.DIRTY_FIELDS , CodePartVOMeta.SORT_FIELD , CodePartVOMeta.SORT_TYPE , CodePartVOMeta.IDS } )
	@NotNull(name = CodePartVOMeta.ID)
	@SentinelResource(value = CodePartServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodePartServiceProxy.SAVE)
	public Result save(CodePartVO codePartVO) {
		Result result=codePartService.save(codePartVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取编码字段
	*/
	@ApiOperation(value = "获取编码字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodePartVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CodePartVOMeta.ID)
	@SentinelResource(value = CodePartServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodePartServiceProxy.GET_BY_ID)
	public Result<CodePart> getById(String id) {
		Result<CodePart> result=new Result<>();
		CodePart codePart=codePartService.getById(id);
		result.success(true).data(codePart);
		return result;
	}


	/**
	 * 批量获取编码字段 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取编码字段")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CodePartVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CodePartVOMeta.IDS)
		@SentinelResource(value = CodePartServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodePartServiceProxy.GET_BY_IDS)
	public Result<List<CodePart>> getByIds(List<String> ids) {
		Result<List<CodePart>> result=new Result<>();
		List<CodePart> list=codePartService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询编码字段
	*/
	@ApiOperation(value = "查询编码字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodePartVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodePartVOMeta.CODE , value = "字段" , required = false , dataTypeClass=String.class , example = "${time,yyyy}"),
		@ApiImplicitParam(name = CodePartVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "年-(2021)"),
		@ApiImplicitParam(name = CodePartVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "time"),
		@ApiImplicitParam(name = CodePartVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodePartVOMeta.PAGE_INDEX , CodePartVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CodePartServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodePartServiceProxy.QUERY_LIST)
	public Result<List<CodePart>> queryList(CodePartVO sample) {
		Result<List<CodePart>> result=new Result<>();
		List<CodePart> list=codePartService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询编码字段
	*/
	@ApiOperation(value = "分页查询编码字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodePartVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = CodePartVOMeta.CODE , value = "字段" , required = false , dataTypeClass=String.class , example = "${time,yyyy}"),
		@ApiImplicitParam(name = CodePartVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "年-(2021)"),
		@ApiImplicitParam(name = CodePartVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "time"),
		@ApiImplicitParam(name = CodePartVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CodePartServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodePartServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CodePart>> queryPagedList(CodePartVO sample) {
		Result<PagedList<CodePart>> result=new Result<>();
		PagedList<CodePart> list=codePartService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CodePartServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodePartServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CodePartVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=codePartService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CodePartServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodePartServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=codePartService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = CodePartServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodePartServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=codePartService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}