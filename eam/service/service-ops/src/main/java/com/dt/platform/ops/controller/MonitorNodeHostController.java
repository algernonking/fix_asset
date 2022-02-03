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


import com.dt.platform.proxy.ops.MonitorNodeHostServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeHostVOMeta;
import com.dt.platform.domain.ops.MonitorNodeHost;
import com.dt.platform.domain.ops.MonitorNodeHostVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeHostMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeHostService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点主机 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-02 14:55:24
*/

@Api(tags = "节点主机")
@ApiSort(0)
@RestController("OpsMonitorNodeHostController")
public class MonitorNodeHostController extends SuperController {

	@Autowired
	private IMonitorNodeHostService monitorNodeHostService;


	/**
	 * 添加节点主机
	*/
	@ApiOperation(value = "添加节点主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_FRE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.MEMORY , value = "内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.MEMORY_USED , value = "内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.VMEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.P_MEMORY_USED , value = "内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.V_MEMORY_USED , value = "虚拟内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorNodeHostServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeHostServiceProxy.INSERT)
	public Result insert(MonitorNodeHostVO monitorNodeHostVO) {
		Result result=monitorNodeHostService.insert(monitorNodeHostVO,false);
		return result;
	}



	/**
	 * 删除节点主机
	*/
	@ApiOperation(value = "删除节点主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorNodeHostVOMeta.ID)
	@SentinelResource(value = MonitorNodeHostServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeHostServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorNodeHostService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除节点主机 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除节点主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorNodeHostVOMeta.IDS)
	@SentinelResource(value = MonitorNodeHostServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeHostServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorNodeHostService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新节点主机
	*/
	@ApiOperation(value = "更新节点主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_FRE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.MEMORY , value = "内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.MEMORY_USED , value = "内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.VMEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.P_MEMORY_USED , value = "内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.V_MEMORY_USED , value = "虚拟内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorNodeHostVOMeta.PAGE_INDEX , MonitorNodeHostVOMeta.PAGE_SIZE , MonitorNodeHostVOMeta.SEARCH_FIELD , MonitorNodeHostVOMeta.FUZZY_FIELD , MonitorNodeHostVOMeta.SEARCH_VALUE , MonitorNodeHostVOMeta.DIRTY_FIELDS , MonitorNodeHostVOMeta.SORT_FIELD , MonitorNodeHostVOMeta.SORT_TYPE , MonitorNodeHostVOMeta.IDS } )
	@NotNull(name = MonitorNodeHostVOMeta.ID)
	@SentinelResource(value = MonitorNodeHostServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeHostServiceProxy.UPDATE)
	public Result update(MonitorNodeHostVO monitorNodeHostVO) {
		Result result=monitorNodeHostService.update(monitorNodeHostVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存节点主机
	*/
	@ApiOperation(value = "保存节点主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_FRE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.MEMORY , value = "内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.MEMORY_USED , value = "内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.VMEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.P_MEMORY_USED , value = "内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.V_MEMORY_USED , value = "虚拟内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeHostVOMeta.PAGE_INDEX , MonitorNodeHostVOMeta.PAGE_SIZE , MonitorNodeHostVOMeta.SEARCH_FIELD , MonitorNodeHostVOMeta.FUZZY_FIELD , MonitorNodeHostVOMeta.SEARCH_VALUE , MonitorNodeHostVOMeta.DIRTY_FIELDS , MonitorNodeHostVOMeta.SORT_FIELD , MonitorNodeHostVOMeta.SORT_TYPE , MonitorNodeHostVOMeta.IDS } )
	@NotNull(name = MonitorNodeHostVOMeta.ID)
	@SentinelResource(value = MonitorNodeHostServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeHostServiceProxy.SAVE)
	public Result save(MonitorNodeHostVO monitorNodeHostVO) {
		Result result=monitorNodeHostService.save(monitorNodeHostVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取节点主机
	*/
	@ApiOperation(value = "获取节点主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorNodeHostVOMeta.ID)
	@SentinelResource(value = MonitorNodeHostServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeHostServiceProxy.GET_BY_ID)
	public Result<MonitorNodeHost> getById(String id) {
		Result<MonitorNodeHost> result=new Result<>();
		MonitorNodeHost monitorNodeHost=monitorNodeHostService.getById(id);
		result.success(true).data(monitorNodeHost);
		return result;
	}


	/**
	 * 批量获取节点主机 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取节点主机")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorNodeHostVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorNodeHostVOMeta.IDS)
		@SentinelResource(value = MonitorNodeHostServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeHostServiceProxy.GET_BY_IDS)
	public Result<List<MonitorNodeHost>> getByIds(List<String> ids) {
		Result<List<MonitorNodeHost>> result=new Result<>();
		List<MonitorNodeHost> list=monitorNodeHostService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询节点主机
	*/
	@ApiOperation(value = "查询节点主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_FRE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.MEMORY , value = "内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.MEMORY_USED , value = "内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.VMEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.P_MEMORY_USED , value = "内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.V_MEMORY_USED , value = "虚拟内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeHostVOMeta.PAGE_INDEX , MonitorNodeHostVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorNodeHostServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeHostServiceProxy.QUERY_LIST)
	public Result<List<MonitorNodeHost>> queryList(MonitorNodeHostVO sample) {
		Result<List<MonitorNodeHost>> result=new Result<>();
		List<MonitorNodeHost> list=monitorNodeHostService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询节点主机
	*/
	@ApiOperation(value = "分页查询节点主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.HOSTNAME , value = "主机名称" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.BOOTTIME , value = "启动时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_VERION , value = "系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.ARCH , value = "架构" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU , value = "CPU数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_FRE , value = "CPU主频" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.MEMORY , value = "内存(M)" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_SYS , value = "cpuSys" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_USER , value = "cpuUser" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_WAIT , value = "cpuWait" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_IDLE , value = "CPU空闲旅" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.CPU_USED , value = "CPU使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD , value = "系统负载" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD5 , value = "系统负载5" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.OS_LOAD15 , value = "系统负载15" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.MEMORY_USED , value = "内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.VMEMORY_USED , value = "虚拟内存使用率" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NETWORK_FLOW_UP , value = "上行流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NETWORK_FLOW_DOWN , value = "下流量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.PROCESS_CNT , value = "连接数" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.P_MEMORY_USED , value = "内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.V_MEMORY_USED , value = "虚拟内存" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.INFO , value = "信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MonitorNodeHostVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorNodeHostServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeHostServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorNodeHost>> queryPagedList(MonitorNodeHostVO sample) {
		Result<PagedList<MonitorNodeHost>> result=new Result<>();
		PagedList<MonitorNodeHost> list=monitorNodeHostService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorNodeHostServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeHostServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorNodeHostVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorNodeHostService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorNodeHostServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeHostServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorNodeHostService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorNodeHostServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeHostServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorNodeHostService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}