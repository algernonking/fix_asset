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


import com.dt.platform.proxy.ops.MonitorWarnServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorWarnVOMeta;
import com.dt.platform.domain.ops.MonitorWarn;
import com.dt.platform.domain.ops.MonitorWarnVO;
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
import com.dt.platform.domain.ops.meta.MonitorWarnMeta;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorWarnService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点告警 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-07 09:51:49
*/

@Api(tags = "节点告警")
@ApiSort(0)
@RestController("OpsMonitorWarnController")
public class MonitorWarnController extends SuperController {

	@Autowired
	private IMonitorWarnService monitorWarnService;


	/**
	 * 添加节点告警
	*/
	@ApiOperation(value = "添加节点告警")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorWarnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NODE_VALUE_ID , value = "监控数值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.INDICATOR_CODE , value = "监控指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.INDICATOR_NAME , value = "指标名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.WARN_LEVEL , value = "告警等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.STATUS , value = "处理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.HANDLED_TIME , value = "处理时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.WARN_TIME , value = "告警时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorWarnServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorWarnServiceProxy.INSERT)
	public Result insert(MonitorWarnVO monitorWarnVO) {
		Result result=monitorWarnService.insert(monitorWarnVO,false);
		return result;
	}



	/**
	 * 删除节点告警
	*/
	@ApiOperation(value = "删除节点告警")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorWarnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorWarnVOMeta.ID)
	@SentinelResource(value = MonitorWarnServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorWarnServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorWarnService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除节点告警 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除节点告警")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorWarnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorWarnVOMeta.IDS)
	@SentinelResource(value = MonitorWarnServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorWarnServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorWarnService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新节点告警
	*/
	@ApiOperation(value = "更新节点告警")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorWarnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NODE_VALUE_ID , value = "监控数值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.INDICATOR_CODE , value = "监控指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.INDICATOR_NAME , value = "指标名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.WARN_LEVEL , value = "告警等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.STATUS , value = "处理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.HANDLED_TIME , value = "处理时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.WARN_TIME , value = "告警时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorWarnVOMeta.PAGE_INDEX , MonitorWarnVOMeta.PAGE_SIZE , MonitorWarnVOMeta.SEARCH_FIELD , MonitorWarnVOMeta.FUZZY_FIELD , MonitorWarnVOMeta.SEARCH_VALUE , MonitorWarnVOMeta.DIRTY_FIELDS , MonitorWarnVOMeta.SORT_FIELD , MonitorWarnVOMeta.SORT_TYPE , MonitorWarnVOMeta.IDS } )
	@NotNull(name = MonitorWarnVOMeta.ID)
	@SentinelResource(value = MonitorWarnServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorWarnServiceProxy.UPDATE)
	public Result update(MonitorWarnVO monitorWarnVO) {
		Result result=monitorWarnService.update(monitorWarnVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存节点告警
	*/
	@ApiOperation(value = "保存节点告警")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorWarnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NODE_VALUE_ID , value = "监控数值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.INDICATOR_CODE , value = "监控指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.INDICATOR_NAME , value = "指标名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.WARN_LEVEL , value = "告警等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.STATUS , value = "处理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.HANDLED_TIME , value = "处理时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.WARN_TIME , value = "告警时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorWarnVOMeta.PAGE_INDEX , MonitorWarnVOMeta.PAGE_SIZE , MonitorWarnVOMeta.SEARCH_FIELD , MonitorWarnVOMeta.FUZZY_FIELD , MonitorWarnVOMeta.SEARCH_VALUE , MonitorWarnVOMeta.DIRTY_FIELDS , MonitorWarnVOMeta.SORT_FIELD , MonitorWarnVOMeta.SORT_TYPE , MonitorWarnVOMeta.IDS } )
	@NotNull(name = MonitorWarnVOMeta.ID)
	@SentinelResource(value = MonitorWarnServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorWarnServiceProxy.SAVE)
	public Result save(MonitorWarnVO monitorWarnVO) {
		Result result=monitorWarnService.save(monitorWarnVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取节点告警
	*/
	@ApiOperation(value = "获取节点告警")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorWarnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorWarnVOMeta.ID)
	@SentinelResource(value = MonitorWarnServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorWarnServiceProxy.GET_BY_ID)
	public Result<MonitorWarn> getById(String id) {
		Result<MonitorWarn> result=new Result<>();
		MonitorWarn monitorWarn=monitorWarnService.getById(id);
		result.success(true).data(monitorWarn);
		return result;
	}


	/**
	 * 批量获取节点告警 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取节点告警")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorWarnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorWarnVOMeta.IDS)
		@SentinelResource(value = MonitorWarnServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorWarnServiceProxy.GET_BY_IDS)
	public Result<List<MonitorWarn>> getByIds(List<String> ids) {
		Result<List<MonitorWarn>> result=new Result<>();
		List<MonitorWarn> list=monitorWarnService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询节点告警
	*/
	@ApiOperation(value = "查询节点告警")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorWarnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NODE_VALUE_ID , value = "监控数值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.INDICATOR_CODE , value = "监控指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.INDICATOR_NAME , value = "指标名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.WARN_LEVEL , value = "告警等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.STATUS , value = "处理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.HANDLED_TIME , value = "处理时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.WARN_TIME , value = "告警时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorWarnVOMeta.PAGE_INDEX , MonitorWarnVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorWarnServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorWarnServiceProxy.QUERY_LIST)
	public Result<List<MonitorWarn>> queryList(MonitorWarnVO sample) {
		Result<List<MonitorWarn>> result=new Result<>();
		List<MonitorWarn> list=monitorWarnService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询节点告警
	*/
	@ApiOperation(value = "分页查询节点告警")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorWarnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NODE_VALUE_ID , value = "监控数值" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.INDICATOR_CODE , value = "监控指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.INDICATOR_NAME , value = "指标名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.WARN_LEVEL , value = "告警等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.STATUS , value = "处理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.HANDLED_TIME , value = "处理时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.WARN_TIME , value = "告警时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorWarnVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorWarnServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorWarnServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorWarn>> queryPagedList(MonitorWarnVO sample) {
		Result<PagedList<MonitorWarn>> result=new Result<>();
		PagedList<MonitorWarn> list=monitorWarnService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorWarnServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorWarnServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorWarnVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorWarnService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorWarnServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorWarnServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorWarnService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorWarnServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorWarnServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorWarnService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}