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


import com.dt.platform.proxy.ops.MonitorNodeValueServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeValueVOMeta;
import com.dt.platform.domain.ops.MonitorNodeValue;
import com.dt.platform.domain.ops.MonitorNodeValueVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeValueMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeValueService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点数值 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-31 06:06:04
*/

@Api(tags = "节点数值")
@ApiSort(0)
@RestController("OpsMonitorNodeValueController")
public class MonitorNodeValueController extends SuperController {

	@Autowired
	private IMonitorNodeValueService monitorNodeValueService;


	/**
	 * 添加节点数值
	*/
	@ApiOperation(value = "添加节点数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_FRE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.MEMORY , value = "内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.MEMORY_USED , value = "内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.VMEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.P_MEMORY_USED , value = "内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.V_MEMORY_USED , value = "虚拟内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorNodeValueServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueServiceProxy.INSERT)
	public Result insert(MonitorNodeValueVO monitorNodeValueVO) {
		Result result=monitorNodeValueService.insert(monitorNodeValueVO,false);
		return result;
	}



	/**
	 * 删除节点数值
	*/
	@ApiOperation(value = "删除节点数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorNodeValueVOMeta.ID)
	@SentinelResource(value = MonitorNodeValueServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorNodeValueService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除节点数值 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除节点数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorNodeValueVOMeta.IDS)
	@SentinelResource(value = MonitorNodeValueServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorNodeValueService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新节点数值
	*/
	@ApiOperation(value = "更新节点数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_FRE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.MEMORY , value = "内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.MEMORY_USED , value = "内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.VMEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.P_MEMORY_USED , value = "内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.V_MEMORY_USED , value = "虚拟内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorNodeValueVOMeta.PAGE_INDEX , MonitorNodeValueVOMeta.PAGE_SIZE , MonitorNodeValueVOMeta.SEARCH_FIELD , MonitorNodeValueVOMeta.FUZZY_FIELD , MonitorNodeValueVOMeta.SEARCH_VALUE , MonitorNodeValueVOMeta.DIRTY_FIELDS , MonitorNodeValueVOMeta.SORT_FIELD , MonitorNodeValueVOMeta.SORT_TYPE , MonitorNodeValueVOMeta.IDS } )
	@NotNull(name = MonitorNodeValueVOMeta.ID)
	@SentinelResource(value = MonitorNodeValueServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueServiceProxy.UPDATE)
	public Result update(MonitorNodeValueVO monitorNodeValueVO) {
		Result result=monitorNodeValueService.update(monitorNodeValueVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存节点数值
	*/
	@ApiOperation(value = "保存节点数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_FRE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.MEMORY , value = "内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.MEMORY_USED , value = "内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.VMEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.P_MEMORY_USED , value = "内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.V_MEMORY_USED , value = "虚拟内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeValueVOMeta.PAGE_INDEX , MonitorNodeValueVOMeta.PAGE_SIZE , MonitorNodeValueVOMeta.SEARCH_FIELD , MonitorNodeValueVOMeta.FUZZY_FIELD , MonitorNodeValueVOMeta.SEARCH_VALUE , MonitorNodeValueVOMeta.DIRTY_FIELDS , MonitorNodeValueVOMeta.SORT_FIELD , MonitorNodeValueVOMeta.SORT_TYPE , MonitorNodeValueVOMeta.IDS } )
	@NotNull(name = MonitorNodeValueVOMeta.ID)
	@SentinelResource(value = MonitorNodeValueServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueServiceProxy.SAVE)
	public Result save(MonitorNodeValueVO monitorNodeValueVO) {
		Result result=monitorNodeValueService.save(monitorNodeValueVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取节点数值
	*/
	@ApiOperation(value = "获取节点数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorNodeValueVOMeta.ID)
	@SentinelResource(value = MonitorNodeValueServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueServiceProxy.GET_BY_ID)
	public Result<MonitorNodeValue> getById(String id) {
		Result<MonitorNodeValue> result=new Result<>();
		MonitorNodeValue monitorNodeValue=monitorNodeValueService.getById(id);
		result.success(true).data(monitorNodeValue);
		return result;
	}


	/**
	 * 批量获取节点数值 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取节点数值")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorNodeValueVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorNodeValueVOMeta.IDS)
		@SentinelResource(value = MonitorNodeValueServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueServiceProxy.GET_BY_IDS)
	public Result<List<MonitorNodeValue>> getByIds(List<String> ids) {
		Result<List<MonitorNodeValue>> result=new Result<>();
		List<MonitorNodeValue> list=monitorNodeValueService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询节点数值
	*/
	@ApiOperation(value = "查询节点数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_FRE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.MEMORY , value = "内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.MEMORY_USED , value = "内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.VMEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.P_MEMORY_USED , value = "内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.V_MEMORY_USED , value = "虚拟内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeValueVOMeta.PAGE_INDEX , MonitorNodeValueVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorNodeValueServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueServiceProxy.QUERY_LIST)
	public Result<List<MonitorNodeValue>> queryList(MonitorNodeValueVO sample) {
		Result<List<MonitorNodeValue>> result=new Result<>();
		List<MonitorNodeValue> list=monitorNodeValueService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询节点数值
	*/
	@ApiOperation(value = "分页查询节点数值")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_FRE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.MEMORY , value = "内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.MEMORY_USED , value = "内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.VMEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.P_MEMORY_USED , value = "内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.V_MEMORY_USED , value = "虚拟内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeValueVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorNodeValueServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeValueServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorNodeValue>> queryPagedList(MonitorNodeValueVO sample) {
		Result<PagedList<MonitorNodeValue>> result=new Result<>();
		PagedList<MonitorNodeValue> list=monitorNodeValueService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorNodeValueServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeValueServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorNodeValueVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorNodeValueService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorNodeValueServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeValueServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorNodeValueService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorNodeValueServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeValueServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorNodeValueService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}