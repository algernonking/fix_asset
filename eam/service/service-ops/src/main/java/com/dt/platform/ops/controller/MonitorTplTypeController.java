package com.dt.platform.ops.controller;


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


import com.dt.platform.proxy.ops.MonitorTplTypeServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorTplTypeVOMeta;
import com.dt.platform.domain.ops.MonitorTplType;
import com.dt.platform.domain.ops.MonitorTplTypeVO;
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
import com.dt.platform.domain.ops.meta.MonitorTplTypeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorTplTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 模版类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-04 07:28:27
*/

@Api(tags = "模版类型")
@ApiSort(0)
@RestController("OpsMonitorTplTypeController")
public class MonitorTplTypeController extends SuperController {

	@Autowired
	private IMonitorTplTypeService monitorTplTypeService;


	/**
	 * 添加模版类型
	*/
	@ApiOperation(value = "添加模版类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorTplTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplTypeServiceProxy.INSERT)
	public Result insert(MonitorTplTypeVO monitorTplTypeVO) {
		Result result=monitorTplTypeService.insert(monitorTplTypeVO,false);
		return result;
	}



	/**
	 * 删除模版类型
	*/
	@ApiOperation(value = "删除模版类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorTplTypeVOMeta.ID)
	@SentinelResource(value = MonitorTplTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorTplTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除模版类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除模版类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorTplTypeVOMeta.IDS)
	@SentinelResource(value = MonitorTplTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorTplTypeService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新模版类型
	*/
	@ApiOperation(value = "更新模版类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorTplTypeVOMeta.PAGE_INDEX , MonitorTplTypeVOMeta.PAGE_SIZE , MonitorTplTypeVOMeta.SEARCH_FIELD , MonitorTplTypeVOMeta.FUZZY_FIELD , MonitorTplTypeVOMeta.SEARCH_VALUE , MonitorTplTypeVOMeta.DIRTY_FIELDS , MonitorTplTypeVOMeta.SORT_FIELD , MonitorTplTypeVOMeta.SORT_TYPE , MonitorTplTypeVOMeta.IDS } )
	@NotNull(name = MonitorTplTypeVOMeta.ID)
	@SentinelResource(value = MonitorTplTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplTypeServiceProxy.UPDATE)
	public Result update(MonitorTplTypeVO monitorTplTypeVO) {
		Result result=monitorTplTypeService.update(monitorTplTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存模版类型
	*/
	@ApiOperation(value = "保存模版类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorTplTypeVOMeta.PAGE_INDEX , MonitorTplTypeVOMeta.PAGE_SIZE , MonitorTplTypeVOMeta.SEARCH_FIELD , MonitorTplTypeVOMeta.FUZZY_FIELD , MonitorTplTypeVOMeta.SEARCH_VALUE , MonitorTplTypeVOMeta.DIRTY_FIELDS , MonitorTplTypeVOMeta.SORT_FIELD , MonitorTplTypeVOMeta.SORT_TYPE , MonitorTplTypeVOMeta.IDS } )
	@NotNull(name = MonitorTplTypeVOMeta.ID)
	@SentinelResource(value = MonitorTplTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplTypeServiceProxy.SAVE)
	public Result save(MonitorTplTypeVO monitorTplTypeVO) {
		Result result=monitorTplTypeService.save(monitorTplTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取模版类型
	*/
	@ApiOperation(value = "获取模版类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorTplTypeVOMeta.ID)
	@SentinelResource(value = MonitorTplTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplTypeServiceProxy.GET_BY_ID)
	public Result<MonitorTplType> getById(String id) {
		Result<MonitorTplType> result=new Result<>();
		MonitorTplType monitorTplType=monitorTplTypeService.getById(id);
		result.success(true).data(monitorTplType);
		return result;
	}


	/**
	 * 批量获取模版类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取模版类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorTplTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorTplTypeVOMeta.IDS)
		@SentinelResource(value = MonitorTplTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplTypeServiceProxy.GET_BY_IDS)
	public Result<List<MonitorTplType>> getByIds(List<String> ids) {
		Result<List<MonitorTplType>> result=new Result<>();
		List<MonitorTplType> list=monitorTplTypeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询模版类型
	*/
	@ApiOperation(value = "查询模版类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorTplTypeVOMeta.PAGE_INDEX , MonitorTplTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorTplTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplTypeServiceProxy.QUERY_LIST)
	public Result<List<MonitorTplType>> queryList(MonitorTplTypeVO sample) {
		Result<List<MonitorTplType>> result=new Result<>();
		List<MonitorTplType> list=monitorTplTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询模版类型
	*/
	@ApiOperation(value = "分页查询模版类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorTplTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorTplType>> queryPagedList(MonitorTplTypeVO sample) {
		Result<PagedList<MonitorTplType>> result=new Result<>();
		PagedList<MonitorTplType> list=monitorTplTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorTplTypeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplTypeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorTplTypeVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorTplTypeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorTplTypeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplTypeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorTplTypeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorTplTypeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplTypeServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorTplTypeService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}