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


import com.dt.platform.proxy.ops.MonitorNodeValueLastServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeValueLastVOMeta;
import com.dt.platform.domain.ops.MonitorNodeValueLast;
import com.dt.platform.domain.ops.MonitorNodeValueLastVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeValueLastMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeValueLastService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点数值最新 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-15 12:29:38
*/

@Api(tags = "节点数值最新")
@ApiSort(0)
@RestController("OpsMonitorNodeValueLastController")
public class MonitorNodeValueLastController extends SuperController {

	@Autowired
	private IMonitorNodeValueLastService monitorNodeValueLastService;


	/**
	 * 添加节点数值最新
	*/
	@ApiOperation(value = "添加节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_STATUS , value = "结果状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_MESSAGE , value = "结果内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_DATETIME , value = "系统时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_NUMBER , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_FREE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_SIZE , value = "物理内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_SIZE , value = "虚拟内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_USED , value = "物理内存使用率" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE3 , value = "编码3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT1 , value = "整数1" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT2 , value = "整数2" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT3 , value = "整数3" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL1 , value = "标签列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL2 , value = "标签列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL3 , value = "标签列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE1 , value = "编码列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE2 , value = "编码列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE3 , value = "编码列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER1 , value = "数值列1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER2 , value = "数值列2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER3 , value = "数值列3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR1 , value = "字符串列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR2 , value = "字符串列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR3 , value = "字符串列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT1 , value = "整数列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT2 , value = "整数列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT3 , value = "整数列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IS_CONNECTED , value = "是否连接" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.INSERT)
	public Result insert(MonitorNodeValueLastVO monitorNodeValueLastVO) {
		Result result=monitorNodeValueLastService.insert(monitorNodeValueLastVO,false);
		return result;
	}



	/**
	 * 删除节点数值最新
	*/
	@ApiOperation(value = "删除节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorNodeValueLastVOMeta.ID)
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorNodeValueLastService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除节点数值最新 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorNodeValueLastVOMeta.IDS)
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorNodeValueLastService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新节点数值最新
	*/
	@ApiOperation(value = "更新节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_STATUS , value = "结果状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_MESSAGE , value = "结果内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_DATETIME , value = "系统时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_NUMBER , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_FREE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_SIZE , value = "物理内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_SIZE , value = "虚拟内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_USED , value = "物理内存使用率" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE3 , value = "编码3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT1 , value = "整数1" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT2 , value = "整数2" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT3 , value = "整数3" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL1 , value = "标签列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL2 , value = "标签列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL3 , value = "标签列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE1 , value = "编码列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE2 , value = "编码列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE3 , value = "编码列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER1 , value = "数值列1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER2 , value = "数值列2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER3 , value = "数值列3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR1 , value = "字符串列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR2 , value = "字符串列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR3 , value = "字符串列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT1 , value = "整数列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT2 , value = "整数列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT3 , value = "整数列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IS_CONNECTED , value = "是否连接" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorNodeValueLastVOMeta.PAGE_INDEX , MonitorNodeValueLastVOMeta.PAGE_SIZE , MonitorNodeValueLastVOMeta.SEARCH_FIELD , MonitorNodeValueLastVOMeta.FUZZY_FIELD , MonitorNodeValueLastVOMeta.SEARCH_VALUE , MonitorNodeValueLastVOMeta.DIRTY_FIELDS , MonitorNodeValueLastVOMeta.SORT_FIELD , MonitorNodeValueLastVOMeta.SORT_TYPE , MonitorNodeValueLastVOMeta.IDS } )
	@NotNull(name = MonitorNodeValueLastVOMeta.ID)
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.UPDATE)
	public Result update(MonitorNodeValueLastVO monitorNodeValueLastVO) {
		Result result=monitorNodeValueLastService.update(monitorNodeValueLastVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存节点数值最新
	*/
	@ApiOperation(value = "保存节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_STATUS , value = "结果状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_MESSAGE , value = "结果内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_DATETIME , value = "系统时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_NUMBER , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_FREE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_SIZE , value = "物理内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_SIZE , value = "虚拟内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_USED , value = "物理内存使用率" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE3 , value = "编码3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT1 , value = "整数1" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT2 , value = "整数2" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT3 , value = "整数3" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL1 , value = "标签列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL2 , value = "标签列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL3 , value = "标签列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE1 , value = "编码列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE2 , value = "编码列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE3 , value = "编码列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER1 , value = "数值列1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER2 , value = "数值列2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER3 , value = "数值列3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR1 , value = "字符串列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR2 , value = "字符串列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR3 , value = "字符串列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT1 , value = "整数列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT2 , value = "整数列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT3 , value = "整数列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IS_CONNECTED , value = "是否连接" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeValueLastVOMeta.PAGE_INDEX , MonitorNodeValueLastVOMeta.PAGE_SIZE , MonitorNodeValueLastVOMeta.SEARCH_FIELD , MonitorNodeValueLastVOMeta.FUZZY_FIELD , MonitorNodeValueLastVOMeta.SEARCH_VALUE , MonitorNodeValueLastVOMeta.DIRTY_FIELDS , MonitorNodeValueLastVOMeta.SORT_FIELD , MonitorNodeValueLastVOMeta.SORT_TYPE , MonitorNodeValueLastVOMeta.IDS } )
	@NotNull(name = MonitorNodeValueLastVOMeta.ID)
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.SAVE)
	public Result save(MonitorNodeValueLastVO monitorNodeValueLastVO) {
		Result result=monitorNodeValueLastService.save(monitorNodeValueLastVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取节点数值最新
	*/
	@ApiOperation(value = "获取节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorNodeValueLastVOMeta.ID)
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.GET_BY_ID)
	public Result<MonitorNodeValueLast> getById(String id) {
		Result<MonitorNodeValueLast> result=new Result<>();
		MonitorNodeValueLast monitorNodeValueLast=monitorNodeValueLastService.getById(id);
		result.success(true).data(monitorNodeValueLast);
		return result;
	}


	/**
	 * 批量获取节点数值最新 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取节点数值最新")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorNodeValueLastVOMeta.IDS)
		@SentinelResource(value = MonitorNodeValueLastServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.GET_BY_IDS)
	public Result<List<MonitorNodeValueLast>> getByIds(List<String> ids) {
		Result<List<MonitorNodeValueLast>> result=new Result<>();
		List<MonitorNodeValueLast> list=monitorNodeValueLastService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询节点数值最新
	*/
	@ApiOperation(value = "查询节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_STATUS , value = "结果状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_MESSAGE , value = "结果内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_DATETIME , value = "系统时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_NUMBER , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_FREE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_SIZE , value = "物理内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_SIZE , value = "虚拟内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_USED , value = "物理内存使用率" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE3 , value = "编码3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT1 , value = "整数1" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT2 , value = "整数2" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT3 , value = "整数3" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL1 , value = "标签列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL2 , value = "标签列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL3 , value = "标签列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE1 , value = "编码列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE2 , value = "编码列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE3 , value = "编码列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER1 , value = "数值列1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER2 , value = "数值列2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER3 , value = "数值列3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR1 , value = "字符串列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR2 , value = "字符串列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR3 , value = "字符串列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT1 , value = "整数列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT2 , value = "整数列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT3 , value = "整数列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IS_CONNECTED , value = "是否连接" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeValueLastVOMeta.PAGE_INDEX , MonitorNodeValueLastVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.QUERY_LIST)
	public Result<List<MonitorNodeValueLast>> queryList(MonitorNodeValueLastVO sample) {
		Result<List<MonitorNodeValueLast>> result=new Result<>();
		List<MonitorNodeValueLast> list=monitorNodeValueLastService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询节点数值最新
	*/
	@ApiOperation(value = "分页查询节点数值最新")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.MONITOR_TPL_CODE , value = "监控模版" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_STATUS , value = "结果状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RESULT_MESSAGE , value = "结果内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INDICATOR_CODE , value = "指标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_DATETIME , value = "系统时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_NUMBER , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_FREE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_SIZE , value = "物理内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_SIZE , value = "虚拟内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.P_MEMORY_USED , value = "物理内存使用率" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.V_MEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE1 , value = "编码1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE2 , value = "编码2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.CODE3 , value = "编码3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER1 , value = "数值1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER2 , value = "数值2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_NUMBER3 , value = "数值3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR1 , value = "字符串1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR2 , value = "字符串2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_STR3 , value = "字符串3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT1 , value = "整数1" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT2 , value = "整数2" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.VALUE_INT3 , value = "整数3" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL1 , value = "标签列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL2 , value = "标签列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_LABEL3 , value = "标签列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE1 , value = "编码列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE2 , value = "编码列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_CODE3 , value = "编码列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER1 , value = "数值列1" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER2 , value = "数值列2" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_NUMBER3 , value = "数值列3" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR1 , value = "字符串列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR2 , value = "字符串列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_STR3 , value = "字符串列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT1 , value = "整数列1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT2 , value = "整数列2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.LIST_VALUE_INT3 , value = "整数列3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.UID , value = "唯一标识" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.IS_CONNECTED , value = "是否连接" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueLastVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueLastServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorNodeValueLast>> queryPagedList(MonitorNodeValueLastVO sample) {
		Result<PagedList<MonitorNodeValueLast>> result=new Result<>();
		PagedList<MonitorNodeValueLast> list=monitorNodeValueLastService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeValueLastServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorNodeValueLastVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorNodeValueLastService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorNodeValueLastServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeValueLastServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorNodeValueLastService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorNodeValueLastServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeValueLastServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorNodeValueLastService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}