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


import com.dt.platform.proxy.ops.MonitorNodeListValueServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeListValueVOMeta;
import com.dt.platform.domain.ops.MonitorNodeListValue;
import com.dt.platform.domain.ops.MonitorNodeListValueVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeListValueMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeListValueService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点列表数值 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-07 09:51:46
*/

@Api(tags = "节点列表数值")
@ApiSort(0)
@RestController("OpsMonitorNodeListValueController")
public class MonitorNodeListValueController extends SuperController {

	@Autowired
	private IMonitorNodeListValueService monitorNodeListValueService;


	/**
	 * 添加节点列表数值
	*/
	@ApiOperation(value = "添加节点列表数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_TYPE , value = "值类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorNodeListValueServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeListValueServiceProxy.INSERT)
	public Result insert(MonitorNodeListValueVO monitorNodeListValueVO) {
		Result result=monitorNodeListValueService.insert(monitorNodeListValueVO,false);
		return result;
	}



	/**
	 * 删除节点列表数值
	*/
	@ApiOperation(value = "删除节点列表数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorNodeListValueVOMeta.ID)
	@SentinelResource(value = MonitorNodeListValueServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeListValueServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorNodeListValueService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除节点列表数值 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除节点列表数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorNodeListValueVOMeta.IDS)
	@SentinelResource(value = MonitorNodeListValueServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeListValueServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorNodeListValueService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新节点列表数值
	*/
	@ApiOperation(value = "更新节点列表数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_TYPE , value = "值类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorNodeListValueVOMeta.PAGE_INDEX , MonitorNodeListValueVOMeta.PAGE_SIZE , MonitorNodeListValueVOMeta.SEARCH_FIELD , MonitorNodeListValueVOMeta.FUZZY_FIELD , MonitorNodeListValueVOMeta.SEARCH_VALUE , MonitorNodeListValueVOMeta.DIRTY_FIELDS , MonitorNodeListValueVOMeta.SORT_FIELD , MonitorNodeListValueVOMeta.SORT_TYPE , MonitorNodeListValueVOMeta.IDS } )
	@NotNull(name = MonitorNodeListValueVOMeta.ID)
	@SentinelResource(value = MonitorNodeListValueServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeListValueServiceProxy.UPDATE)
	public Result update(MonitorNodeListValueVO monitorNodeListValueVO) {
		Result result=monitorNodeListValueService.update(monitorNodeListValueVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存节点列表数值
	*/
	@ApiOperation(value = "保存节点列表数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_TYPE , value = "值类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeListValueVOMeta.PAGE_INDEX , MonitorNodeListValueVOMeta.PAGE_SIZE , MonitorNodeListValueVOMeta.SEARCH_FIELD , MonitorNodeListValueVOMeta.FUZZY_FIELD , MonitorNodeListValueVOMeta.SEARCH_VALUE , MonitorNodeListValueVOMeta.DIRTY_FIELDS , MonitorNodeListValueVOMeta.SORT_FIELD , MonitorNodeListValueVOMeta.SORT_TYPE , MonitorNodeListValueVOMeta.IDS } )
	@NotNull(name = MonitorNodeListValueVOMeta.ID)
	@SentinelResource(value = MonitorNodeListValueServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeListValueServiceProxy.SAVE)
	public Result save(MonitorNodeListValueVO monitorNodeListValueVO) {
		Result result=monitorNodeListValueService.save(monitorNodeListValueVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取节点列表数值
	*/
	@ApiOperation(value = "获取节点列表数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorNodeListValueVOMeta.ID)
	@SentinelResource(value = MonitorNodeListValueServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeListValueServiceProxy.GET_BY_ID)
	public Result<MonitorNodeListValue> getById(String id) {
		Result<MonitorNodeListValue> result=new Result<>();
		MonitorNodeListValue monitorNodeListValue=monitorNodeListValueService.getById(id);
		result.success(true).data(monitorNodeListValue);
		return result;
	}


	/**
	 * 批量获取节点列表数值 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取节点列表数值")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorNodeListValueVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorNodeListValueVOMeta.IDS)
		@SentinelResource(value = MonitorNodeListValueServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeListValueServiceProxy.GET_BY_IDS)
	public Result<List<MonitorNodeListValue>> getByIds(List<String> ids) {
		Result<List<MonitorNodeListValue>> result=new Result<>();
		List<MonitorNodeListValue> list=monitorNodeListValueService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询节点列表数值
	*/
	@ApiOperation(value = "查询节点列表数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_TYPE , value = "值类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeListValueVOMeta.PAGE_INDEX , MonitorNodeListValueVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorNodeListValueServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeListValueServiceProxy.QUERY_LIST)
	public Result<List<MonitorNodeListValue>> queryList(MonitorNodeListValueVO sample) {
		Result<List<MonitorNodeListValue>> result=new Result<>();
		List<MonitorNodeListValue> list=monitorNodeListValueService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询节点列表数值
	*/
	@ApiOperation(value = "分页查询节点列表数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_TYPE , value = "值类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeListValueVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorNodeListValueServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeListValueServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorNodeListValue>> queryPagedList(MonitorNodeListValueVO sample) {
		Result<PagedList<MonitorNodeListValue>> result=new Result<>();
		PagedList<MonitorNodeListValue> list=monitorNodeListValueService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorNodeListValueServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeListValueServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorNodeListValueVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorNodeListValueService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorNodeListValueServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeListValueServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorNodeListValueService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorNodeListValueServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeListValueServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorNodeListValueService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}