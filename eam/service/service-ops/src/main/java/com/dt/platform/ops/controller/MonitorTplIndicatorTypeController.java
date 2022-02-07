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


import com.dt.platform.proxy.ops.MonitorTplIndicatorTypeServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorTplIndicatorTypeVOMeta;
import com.dt.platform.domain.ops.MonitorTplIndicatorType;
import com.dt.platform.domain.ops.MonitorTplIndicatorTypeVO;
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
import com.dt.platform.domain.ops.meta.MonitorTplIndicatorTypeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorTplIndicatorTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 指标类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-03 19:08:16
*/

@Api(tags = "指标类型")
@ApiSort(0)
@RestController("OpsMonitorTplIndicatorTypeController")
public class MonitorTplIndicatorTypeController extends SuperController {

	@Autowired
	private IMonitorTplIndicatorTypeService monitorTplIndicatorTypeService;


	/**
	 * 添加指标类型
	*/
	@ApiOperation(value = "添加指标类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplIndicatorTypeServiceProxy.INSERT)
	public Result insert(MonitorTplIndicatorTypeVO monitorTplIndicatorTypeVO) {
		Result result=monitorTplIndicatorTypeService.insert(monitorTplIndicatorTypeVO,false);
		return result;
	}



	/**
	 * 删除指标类型
	*/
	@ApiOperation(value = "删除指标类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorTplIndicatorTypeVOMeta.ID)
	@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplIndicatorTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorTplIndicatorTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除指标类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除指标类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorTplIndicatorTypeVOMeta.IDS)
	@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplIndicatorTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorTplIndicatorTypeService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新指标类型
	*/
	@ApiOperation(value = "更新指标类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorTplIndicatorTypeVOMeta.PAGE_INDEX , MonitorTplIndicatorTypeVOMeta.PAGE_SIZE , MonitorTplIndicatorTypeVOMeta.SEARCH_FIELD , MonitorTplIndicatorTypeVOMeta.FUZZY_FIELD , MonitorTplIndicatorTypeVOMeta.SEARCH_VALUE , MonitorTplIndicatorTypeVOMeta.DIRTY_FIELDS , MonitorTplIndicatorTypeVOMeta.SORT_FIELD , MonitorTplIndicatorTypeVOMeta.SORT_TYPE , MonitorTplIndicatorTypeVOMeta.IDS } )
	@NotNull(name = MonitorTplIndicatorTypeVOMeta.ID)
	@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplIndicatorTypeServiceProxy.UPDATE)
	public Result update(MonitorTplIndicatorTypeVO monitorTplIndicatorTypeVO) {
		Result result=monitorTplIndicatorTypeService.update(monitorTplIndicatorTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存指标类型
	*/
	@ApiOperation(value = "保存指标类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorTplIndicatorTypeVOMeta.PAGE_INDEX , MonitorTplIndicatorTypeVOMeta.PAGE_SIZE , MonitorTplIndicatorTypeVOMeta.SEARCH_FIELD , MonitorTplIndicatorTypeVOMeta.FUZZY_FIELD , MonitorTplIndicatorTypeVOMeta.SEARCH_VALUE , MonitorTplIndicatorTypeVOMeta.DIRTY_FIELDS , MonitorTplIndicatorTypeVOMeta.SORT_FIELD , MonitorTplIndicatorTypeVOMeta.SORT_TYPE , MonitorTplIndicatorTypeVOMeta.IDS } )
	@NotNull(name = MonitorTplIndicatorTypeVOMeta.ID)
	@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplIndicatorTypeServiceProxy.SAVE)
	public Result save(MonitorTplIndicatorTypeVO monitorTplIndicatorTypeVO) {
		Result result=monitorTplIndicatorTypeService.save(monitorTplIndicatorTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取指标类型
	*/
	@ApiOperation(value = "获取指标类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorTplIndicatorTypeVOMeta.ID)
	@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplIndicatorTypeServiceProxy.GET_BY_ID)
	public Result<MonitorTplIndicatorType> getById(String id) {
		Result<MonitorTplIndicatorType> result=new Result<>();
		MonitorTplIndicatorType monitorTplIndicatorType=monitorTplIndicatorTypeService.getById(id);
		result.success(true).data(monitorTplIndicatorType);
		return result;
	}


	/**
	 * 批量获取指标类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取指标类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorTplIndicatorTypeVOMeta.IDS)
		@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplIndicatorTypeServiceProxy.GET_BY_IDS)
	public Result<List<MonitorTplIndicatorType>> getByIds(List<String> ids) {
		Result<List<MonitorTplIndicatorType>> result=new Result<>();
		List<MonitorTplIndicatorType> list=monitorTplIndicatorTypeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询指标类型
	*/
	@ApiOperation(value = "查询指标类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorTplIndicatorTypeVOMeta.PAGE_INDEX , MonitorTplIndicatorTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplIndicatorTypeServiceProxy.QUERY_LIST)
	public Result<List<MonitorTplIndicatorType>> queryList(MonitorTplIndicatorTypeVO sample) {
		Result<List<MonitorTplIndicatorType>> result=new Result<>();
		List<MonitorTplIndicatorType> list=monitorTplIndicatorTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询指标类型
	*/
	@ApiOperation(value = "分页查询指标类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplIndicatorTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorTplIndicatorType>> queryPagedList(MonitorTplIndicatorTypeVO sample) {
		Result<PagedList<MonitorTplIndicatorType>> result=new Result<>();
		PagedList<MonitorTplIndicatorType> list=monitorTplIndicatorTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplIndicatorTypeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorTplIndicatorTypeVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorTplIndicatorTypeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplIndicatorTypeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorTplIndicatorTypeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplIndicatorTypeServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorTplIndicatorTypeService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}