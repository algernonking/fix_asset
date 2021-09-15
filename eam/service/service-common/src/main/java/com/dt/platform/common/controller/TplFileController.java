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


import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.dt.platform.domain.common.meta.TplFileVOMeta;
import com.dt.platform.domain.common.TplFile;
import com.dt.platform.domain.common.TplFileVO;
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
import com.dt.platform.domain.common.meta.TplFileMeta;
import com.dt.platform.domain.common.CodeRegister;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.ITplFileService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 模板文件 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-14 19:38:58
*/

@Api(tags = "模板文件")
@ApiSort(0)
@RestController("SysTplFileController")
public class TplFileController extends SuperController {

	@Autowired
	private ITplFileService tplFileService;

	
	/**
	 * 添加模板文件
	*/
	@ApiOperation(value = "添加模板文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TplFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.TYPE , value = "模板类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.CODE , value = "业务编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.TPL_FILE_TYPE , value = "模板文件类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = TplFileVOMeta.ID)
	@SentinelResource(value = TplFileServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TplFileServiceProxy.INSERT)
	public Result insert(TplFileVO tplFileVO) {
		Result result=tplFileService.insert(tplFileVO);
		return result;
	}





	/**
	 * 删除模板文件
	*/
	@ApiOperation(value = "删除模板文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TplFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = TplFileVOMeta.ID)
	@SentinelResource(value = TplFileServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TplFileServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=tplFileService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除模板文件 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除模板文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TplFileVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = TplFileVOMeta.IDS)
	@SentinelResource(value = TplFileServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TplFileServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=tplFileService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新模板文件
	*/
	@ApiOperation(value = "更新模板文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TplFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.TYPE , value = "模板类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.CODE , value = "业务编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.TPL_FILE_TYPE , value = "模板文件类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { TplFileVOMeta.PAGE_INDEX , TplFileVOMeta.PAGE_SIZE , TplFileVOMeta.SEARCH_FIELD , TplFileVOMeta.FUZZY_FIELD , TplFileVOMeta.SEARCH_VALUE , TplFileVOMeta.SORT_FIELD , TplFileVOMeta.SORT_TYPE , TplFileVOMeta.IDS } ) 
	@NotNull(name = TplFileVOMeta.ID)
	@SentinelResource(value = TplFileServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TplFileServiceProxy.UPDATE)
	public Result update(TplFileVO tplFileVO) {
		Result result=tplFileService.update(tplFileVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存模板文件
	*/
	@ApiOperation(value = "保存模板文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TplFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.TYPE , value = "模板类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.CODE , value = "业务编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.TPL_FILE_TYPE , value = "模板文件类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TplFileVOMeta.PAGE_INDEX , TplFileVOMeta.PAGE_SIZE , TplFileVOMeta.SEARCH_FIELD , TplFileVOMeta.FUZZY_FIELD , TplFileVOMeta.SEARCH_VALUE , TplFileVOMeta.SORT_FIELD , TplFileVOMeta.SORT_TYPE , TplFileVOMeta.IDS } )
	@NotNull(name = TplFileVOMeta.ID)
	@SentinelResource(value = TplFileServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TplFileServiceProxy.SAVE)
	public Result save(TplFileVO tplFileVO) {
		Result result=tplFileService.save(tplFileVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取模板文件
	*/
	@ApiOperation(value = "获取模板文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TplFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = TplFileVOMeta.ID)
	@SentinelResource(value = TplFileServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TplFileServiceProxy.GET_BY_ID)
	public Result<TplFile> getById(String id) {
		Result<TplFile> result=new Result<>();
		TplFile tplFile=tplFileService.getById(id);
		// 关联出 业务编码 数据
		tplFileService.join(tplFile,TplFileMeta.BUSINESS_CODE);
		result.success(true).data(tplFile);
		return result;
	}


	/**
	 * 批量删除模板文件 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除模板文件")
		@ApiImplicitParams({
				@ApiImplicitParam(name = TplFileVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = TplFileVOMeta.IDS)
		@SentinelResource(value = TplFileServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TplFileServiceProxy.GET_BY_IDS)
	public Result<List<TplFile>> getByIds(List<String> ids) {
		Result<List<TplFile>> result=new Result<>();
		List<TplFile> list=tplFileService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询模板文件
	*/
	@ApiOperation(value = "查询模板文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TplFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.TYPE , value = "模板类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.CODE , value = "业务编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.TPL_FILE_TYPE , value = "模板文件类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TplFileVOMeta.PAGE_INDEX , TplFileVOMeta.PAGE_SIZE } )
	@SentinelResource(value = TplFileServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TplFileServiceProxy.QUERY_LIST)
	public Result<List<TplFile>> queryList(TplFileVO sample) {
		Result<List<TplFile>> result=new Result<>();
		List<TplFile> list=tplFileService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询模板文件
	*/
	@ApiOperation(value = "分页查询模板文件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TplFileVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.TYPE , value = "模板类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.CODE , value = "业务编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.TPL_FILE_TYPE , value = "模板文件类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.FILE_ID , value = "文件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = TplFileVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = TplFileServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TplFileServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<TplFile>> queryPagedList(TplFileVO sample) {
		Result<PagedList<TplFile>> result=new Result<>();
		PagedList<TplFile> list=tplFileService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 业务编码 数据
		tplFileService.join(list,TplFileMeta.BUSINESS_CODE);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 删除模板文件
	 */
	@ApiOperation(value = "获取文件流")
	@ApiImplicitParams({
			@ApiImplicitParam(name = TplFileVOMeta.CODE , value = "编码" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=9)
	@SentinelResource(value = TplFileServiceProxy.GET_TPL_FILE_STREAM_BY_CODE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TplFileServiceProxy.GET_TPL_FILE_STREAM_BY_CODE)
	public InputStream getTplFileStreamByCode(String code) {
		return tplFileService.getTplFileStreamByCode(code);
	}

	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = TplFileServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(TplFileServiceProxy.EXPORT_EXCEL)
	public void exportExcel(TplFileVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=tplFileService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = TplFileServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(TplFileServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=tplFileService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = TplFileServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(TplFileServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=tplFileService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}