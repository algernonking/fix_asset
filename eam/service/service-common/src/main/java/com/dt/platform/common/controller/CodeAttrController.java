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


import com.dt.platform.proxy.common.CodeAttrServiceProxy;
import com.dt.platform.domain.common.meta.CodeAttrVOMeta;
import com.dt.platform.domain.common.CodeAttr;
import com.dt.platform.domain.common.CodeAttrVO;
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
import com.dt.platform.domain.common.meta.CodeAttrMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.ICodeAttrService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 编码属性 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-22 21:46:59
*/

@Api(tags = "编码属性")
@ApiSort(0)
@RestController("SysCodeAttrController")
public class CodeAttrController extends SuperController {

	@Autowired
	private ICodeAttrService codeAttrService;


	/**
	 * 添加编码属性
	*/
	@ApiOperation(value = "添加编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.CODE , value = "占位符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "9999"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CodeAttrServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.INSERT)
	public Result insert(CodeAttrVO codeAttrVO) {
		Result result=codeAttrService.insert(codeAttrVO);
		return result;
	}



	/**
	 * 删除编码属性
	*/
	@ApiOperation(value = "删除编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CodeAttrVOMeta.ID)
	@SentinelResource(value = CodeAttrServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=codeAttrService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除编码属性 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CodeAttrVOMeta.IDS)
	@SentinelResource(value = CodeAttrServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=codeAttrService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新编码属性
	*/
	@ApiOperation(value = "更新编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.CODE , value = "占位符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "9999"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CodeAttrVOMeta.PAGE_INDEX , CodeAttrVOMeta.PAGE_SIZE , CodeAttrVOMeta.SEARCH_FIELD , CodeAttrVOMeta.FUZZY_FIELD , CodeAttrVOMeta.SEARCH_VALUE , CodeAttrVOMeta.SORT_FIELD , CodeAttrVOMeta.SORT_TYPE , CodeAttrVOMeta.IDS } )
	@NotNull(name = CodeAttrVOMeta.ID)
	@SentinelResource(value = CodeAttrServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.UPDATE)
	public Result update(CodeAttrVO codeAttrVO) {
		Result result=codeAttrService.update(codeAttrVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存编码属性
	*/
	@ApiOperation(value = "保存编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.CODE , value = "占位符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "9999"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeAttrVOMeta.PAGE_INDEX , CodeAttrVOMeta.PAGE_SIZE , CodeAttrVOMeta.SEARCH_FIELD , CodeAttrVOMeta.FUZZY_FIELD , CodeAttrVOMeta.SEARCH_VALUE , CodeAttrVOMeta.SORT_FIELD , CodeAttrVOMeta.SORT_TYPE , CodeAttrVOMeta.IDS } )
	@NotNull(name = CodeAttrVOMeta.ID)
	@SentinelResource(value = CodeAttrServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.SAVE)
	public Result save(CodeAttrVO codeAttrVO) {
		Result result=codeAttrService.save(codeAttrVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取编码属性
	*/
	@ApiOperation(value = "获取编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CodeAttrVOMeta.ID)
	@SentinelResource(value = CodeAttrServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.GET_BY_ID)
	public Result<CodeAttr> getById(String id) {
		Result<CodeAttr> result=new Result<>();
		CodeAttr codeAttr=codeAttrService.getById(id);

		// join 关联的对象
		codeAttrService.dao().fill(codeAttr)
			.execute();

		result.success(true).data(codeAttr);
		return result;
	}


	/**
	 * 批量获取编码属性 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取编码属性")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CodeAttrVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CodeAttrVOMeta.IDS)
		@SentinelResource(value = CodeAttrServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.GET_BY_IDS)
	public Result<List<CodeAttr>> getByIds(List<String> ids) {
		Result<List<CodeAttr>> result=new Result<>();
		List<CodeAttr> list=codeAttrService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询编码属性
	*/
	@ApiOperation(value = "查询编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.CODE , value = "占位符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "9999"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CodeAttrVOMeta.PAGE_INDEX , CodeAttrVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CodeAttrServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.QUERY_LIST)
	public Result<List<CodeAttr>> queryList(CodeAttrVO sample) {
		Result<List<CodeAttr>> result=new Result<>();
		List<CodeAttr> list=codeAttrService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询编码属性
	*/
	@ApiOperation(value = "分页查询编码属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CodeAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.NAME , value = "编码名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.TYPE , value = "编码类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.CODE , value = "占位符" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CodeAttrVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "9999"),
		@ApiImplicitParam(name = CodeAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CodeAttrServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CodeAttrServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CodeAttr>> queryPagedList(CodeAttrVO sample) {
		Result<PagedList<CodeAttr>> result=new Result<>();
		PagedList<CodeAttr> list=codeAttrService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		codeAttrService.dao().fill(list)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CodeAttrServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeAttrServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CodeAttrVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=codeAttrService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CodeAttrServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeAttrServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=codeAttrService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = CodeAttrServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CodeAttrServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=codeAttrService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}