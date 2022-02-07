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


import com.dt.platform.proxy.ops.MonitorNodeTypeServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeTypeVOMeta;
import com.dt.platform.domain.ops.MonitorNodeType;
import com.dt.platform.domain.ops.MonitorNodeTypeVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeTypeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-07 09:51:43
*/

@Api(tags = "节点类型")
@ApiSort(0)
@RestController("OpsMonitorNodeTypeController")
public class MonitorNodeTypeController extends SuperController {

	@Autowired
	private IMonitorNodeTypeService monitorNodeTypeService;


	/**
	 * 添加节点类型
	*/
	@ApiOperation(value = "添加节点类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "操作系统"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorNodeTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTypeServiceProxy.INSERT)
	public Result insert(MonitorNodeTypeVO monitorNodeTypeVO) {
		Result result=monitorNodeTypeService.insert(monitorNodeTypeVO,false);
		return result;
	}



	/**
	 * 删除节点类型
	*/
	@ApiOperation(value = "删除节点类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorNodeTypeVOMeta.ID)
	@SentinelResource(value = MonitorNodeTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorNodeTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除节点类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除节点类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorNodeTypeVOMeta.IDS)
	@SentinelResource(value = MonitorNodeTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorNodeTypeService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新节点类型
	*/
	@ApiOperation(value = "更新节点类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "操作系统"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorNodeTypeVOMeta.PAGE_INDEX , MonitorNodeTypeVOMeta.PAGE_SIZE , MonitorNodeTypeVOMeta.SEARCH_FIELD , MonitorNodeTypeVOMeta.FUZZY_FIELD , MonitorNodeTypeVOMeta.SEARCH_VALUE , MonitorNodeTypeVOMeta.DIRTY_FIELDS , MonitorNodeTypeVOMeta.SORT_FIELD , MonitorNodeTypeVOMeta.SORT_TYPE , MonitorNodeTypeVOMeta.IDS } )
	@NotNull(name = MonitorNodeTypeVOMeta.ID)
	@SentinelResource(value = MonitorNodeTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTypeServiceProxy.UPDATE)
	public Result update(MonitorNodeTypeVO monitorNodeTypeVO) {
		Result result=monitorNodeTypeService.update(monitorNodeTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存节点类型
	*/
	@ApiOperation(value = "保存节点类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "操作系统"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeTypeVOMeta.PAGE_INDEX , MonitorNodeTypeVOMeta.PAGE_SIZE , MonitorNodeTypeVOMeta.SEARCH_FIELD , MonitorNodeTypeVOMeta.FUZZY_FIELD , MonitorNodeTypeVOMeta.SEARCH_VALUE , MonitorNodeTypeVOMeta.DIRTY_FIELDS , MonitorNodeTypeVOMeta.SORT_FIELD , MonitorNodeTypeVOMeta.SORT_TYPE , MonitorNodeTypeVOMeta.IDS } )
	@NotNull(name = MonitorNodeTypeVOMeta.ID)
	@SentinelResource(value = MonitorNodeTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTypeServiceProxy.SAVE)
	public Result save(MonitorNodeTypeVO monitorNodeTypeVO) {
		Result result=monitorNodeTypeService.save(monitorNodeTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取节点类型
	*/
	@ApiOperation(value = "获取节点类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorNodeTypeVOMeta.ID)
	@SentinelResource(value = MonitorNodeTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTypeServiceProxy.GET_BY_ID)
	public Result<MonitorNodeType> getById(String id) {
		Result<MonitorNodeType> result=new Result<>();
		MonitorNodeType monitorNodeType=monitorNodeTypeService.getById(id);
		result.success(true).data(monitorNodeType);
		return result;
	}


	/**
	 * 批量获取节点类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取节点类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorNodeTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorNodeTypeVOMeta.IDS)
		@SentinelResource(value = MonitorNodeTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTypeServiceProxy.GET_BY_IDS)
	public Result<List<MonitorNodeType>> getByIds(List<String> ids) {
		Result<List<MonitorNodeType>> result=new Result<>();
		List<MonitorNodeType> list=monitorNodeTypeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询节点类型
	*/
	@ApiOperation(value = "查询节点类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "操作系统"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeTypeVOMeta.PAGE_INDEX , MonitorNodeTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorNodeTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTypeServiceProxy.QUERY_LIST)
	public Result<List<MonitorNodeType>> queryList(MonitorNodeTypeVO sample) {
		Result<List<MonitorNodeType>> result=new Result<>();
		List<MonitorNodeType> list=monitorNodeTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询节点类型
	*/
	@ApiOperation(value = "分页查询节点类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "操作系统"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorNodeTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorNodeTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorNodeType>> queryPagedList(MonitorNodeTypeVO sample) {
		Result<PagedList<MonitorNodeType>> result=new Result<>();
		PagedList<MonitorNodeType> list=monitorNodeTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorNodeTypeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeTypeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorNodeTypeVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorNodeTypeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorNodeTypeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeTypeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorNodeTypeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorNodeTypeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeTypeServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorNodeTypeService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}