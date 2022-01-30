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


import com.dt.platform.proxy.ops.MonitorNodeMapServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeMapVOMeta;
import com.dt.platform.domain.ops.MonitorNodeMap;
import com.dt.platform.domain.ops.MonitorNodeMapVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeMapMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeMapService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点映射 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-31 07:10:54
*/

@Api(tags = "节点映射")
@ApiSort(0)
@RestController("OpsMonitorNodeMapController")
public class MonitorNodeMapController extends SuperController {

	@Autowired
	private IMonitorNodeMapService monitorNodeMapService;


	/**
	 * 添加节点映射
	*/
	@ApiOperation(value = "添加节点映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.SOURCE_ID , value = "源值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.IP , value = "IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ACTION_METHOD , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorNodeMapServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeMapServiceProxy.INSERT)
	public Result insert(MonitorNodeMapVO monitorNodeMapVO) {
		Result result=monitorNodeMapService.insert(monitorNodeMapVO,false);
		return result;
	}



	/**
	 * 删除节点映射
	*/
	@ApiOperation(value = "删除节点映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorNodeMapVOMeta.ID)
	@SentinelResource(value = MonitorNodeMapServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeMapServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorNodeMapService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除节点映射 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除节点映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorNodeMapVOMeta.IDS)
	@SentinelResource(value = MonitorNodeMapServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeMapServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorNodeMapService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新节点映射
	*/
	@ApiOperation(value = "更新节点映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.SOURCE_ID , value = "源值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.IP , value = "IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ACTION_METHOD , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorNodeMapVOMeta.PAGE_INDEX , MonitorNodeMapVOMeta.PAGE_SIZE , MonitorNodeMapVOMeta.SEARCH_FIELD , MonitorNodeMapVOMeta.FUZZY_FIELD , MonitorNodeMapVOMeta.SEARCH_VALUE , MonitorNodeMapVOMeta.DIRTY_FIELDS , MonitorNodeMapVOMeta.SORT_FIELD , MonitorNodeMapVOMeta.SORT_TYPE , MonitorNodeMapVOMeta.IDS } )
	@NotNull(name = MonitorNodeMapVOMeta.ID)
	@SentinelResource(value = MonitorNodeMapServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeMapServiceProxy.UPDATE)
	public Result update(MonitorNodeMapVO monitorNodeMapVO) {
		Result result=monitorNodeMapService.update(monitorNodeMapVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存节点映射
	*/
	@ApiOperation(value = "保存节点映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.SOURCE_ID , value = "源值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.IP , value = "IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ACTION_METHOD , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeMapVOMeta.PAGE_INDEX , MonitorNodeMapVOMeta.PAGE_SIZE , MonitorNodeMapVOMeta.SEARCH_FIELD , MonitorNodeMapVOMeta.FUZZY_FIELD , MonitorNodeMapVOMeta.SEARCH_VALUE , MonitorNodeMapVOMeta.DIRTY_FIELDS , MonitorNodeMapVOMeta.SORT_FIELD , MonitorNodeMapVOMeta.SORT_TYPE , MonitorNodeMapVOMeta.IDS } )
	@NotNull(name = MonitorNodeMapVOMeta.ID)
	@SentinelResource(value = MonitorNodeMapServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeMapServiceProxy.SAVE)
	public Result save(MonitorNodeMapVO monitorNodeMapVO) {
		Result result=monitorNodeMapService.save(monitorNodeMapVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取节点映射
	*/
	@ApiOperation(value = "获取节点映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorNodeMapVOMeta.ID)
	@SentinelResource(value = MonitorNodeMapServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeMapServiceProxy.GET_BY_ID)
	public Result<MonitorNodeMap> getById(String id) {
		Result<MonitorNodeMap> result=new Result<>();
		MonitorNodeMap monitorNodeMap=monitorNodeMapService.getById(id);
		result.success(true).data(monitorNodeMap);
		return result;
	}


	/**
	 * 批量获取节点映射 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取节点映射")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorNodeMapVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorNodeMapVOMeta.IDS)
		@SentinelResource(value = MonitorNodeMapServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeMapServiceProxy.GET_BY_IDS)
	public Result<List<MonitorNodeMap>> getByIds(List<String> ids) {
		Result<List<MonitorNodeMap>> result=new Result<>();
		List<MonitorNodeMap> list=monitorNodeMapService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询节点映射
	*/
	@ApiOperation(value = "查询节点映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.SOURCE_ID , value = "源值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.IP , value = "IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ACTION_METHOD , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeMapVOMeta.PAGE_INDEX , MonitorNodeMapVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorNodeMapServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeMapServiceProxy.QUERY_LIST)
	public Result<List<MonitorNodeMap>> queryList(MonitorNodeMapVO sample) {
		Result<List<MonitorNodeMap>> result=new Result<>();
		List<MonitorNodeMap> list=monitorNodeMapService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询节点映射
	*/
	@ApiOperation(value = "分页查询节点映射")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.SOURCE_ID , value = "源值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.IP , value = "IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.ACTION_METHOD , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeMapVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorNodeMapServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeMapServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorNodeMap>> queryPagedList(MonitorNodeMapVO sample) {
		Result<PagedList<MonitorNodeMap>> result=new Result<>();
		PagedList<MonitorNodeMap> list=monitorNodeMapService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorNodeMapServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeMapServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorNodeMapVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorNodeMapService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorNodeMapServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeMapServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorNodeMapService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorNodeMapServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeMapServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorNodeMapService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}