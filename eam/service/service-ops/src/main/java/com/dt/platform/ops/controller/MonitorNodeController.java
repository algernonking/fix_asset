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


import com.dt.platform.proxy.ops.MonitorNodeServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeVOMeta;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorNodeVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeMeta;
import com.dt.platform.domain.ops.MonitorVoucher;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorNodeDb;
import com.dt.platform.domain.ops.MonitorNodeValue;
import com.dt.platform.domain.ops.MonitorNodeGroup;
import com.dt.platform.domain.ops.MonitorNodeType;
import com.dt.platform.domain.ops.MonitorNodeSubtype;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-07 12:08:17
*/

@Api(tags = "节点")
@ApiSort(0)
@RestController("OpsMonitorNodeController")
public class MonitorNodeController extends SuperController {

	@Autowired
	private IMonitorNodeService monitorNodeService;


	/**
	 * 添加节点
	*/
	@ApiOperation(value = "添加节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_IP , value = "IP" , required = false , dataTypeClass=String.class , example = "121.43.103.102"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.PID , value = "父节点" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SUB_TYPE , value = "子类型" , required = false , dataTypeClass=String.class , example = "Redhat"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.GROUP_ID , value = "节点分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME , value = "主机名" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME_SHOW , value = "可见主机名" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_ENABLED , value = "是否启用" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.STATUS , value = "监控状态" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_VOUCHER_ID , value = "凭证(SSH)" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_PORT , value = "SSH端口" , required = false , dataTypeClass=Integer.class , example = "22"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.AGENT_PORT , value = "Agent端口" , required = false , dataTypeClass=Integer.class , example = "10052"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_PORT , value = "Snmp端口" , required = false , dataTypeClass=Integer.class , example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_VERSION , value = "Snmp版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_COMMUNITY , value = "Snmp团体" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JMX_PORT , value = "Jmx端口" , required = false , dataTypeClass=Integer.class , example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.IMPI_PORT , value = "Jmx端口" , required = false , dataTypeClass=Integer.class , example = "623"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JDBC_URL , value = "Jdbc地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorNodeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeServiceProxy.INSERT)
	public Result insert(MonitorNodeVO monitorNodeVO) {
		Result result=monitorNodeService.insert(monitorNodeVO,false);
		return result;
	}



	/**
	 * 删除节点
	*/
	@ApiOperation(value = "删除节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorNodeVOMeta.ID)
	@SentinelResource(value = MonitorNodeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorNodeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除节点 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorNodeVOMeta.IDS)
	@SentinelResource(value = MonitorNodeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorNodeService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新节点
	*/
	@ApiOperation(value = "更新节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_IP , value = "IP" , required = false , dataTypeClass=String.class , example = "121.43.103.102"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.PID , value = "父节点" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SUB_TYPE , value = "子类型" , required = false , dataTypeClass=String.class , example = "Redhat"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.GROUP_ID , value = "节点分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME , value = "主机名" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME_SHOW , value = "可见主机名" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_ENABLED , value = "是否启用" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.STATUS , value = "监控状态" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_VOUCHER_ID , value = "凭证(SSH)" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_PORT , value = "SSH端口" , required = false , dataTypeClass=Integer.class , example = "22"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.AGENT_PORT , value = "Agent端口" , required = false , dataTypeClass=Integer.class , example = "10052"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_PORT , value = "Snmp端口" , required = false , dataTypeClass=Integer.class , example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_VERSION , value = "Snmp版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_COMMUNITY , value = "Snmp团体" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JMX_PORT , value = "Jmx端口" , required = false , dataTypeClass=Integer.class , example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.IMPI_PORT , value = "Jmx端口" , required = false , dataTypeClass=Integer.class , example = "623"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JDBC_URL , value = "Jdbc地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorNodeVOMeta.PAGE_INDEX , MonitorNodeVOMeta.PAGE_SIZE , MonitorNodeVOMeta.SEARCH_FIELD , MonitorNodeVOMeta.FUZZY_FIELD , MonitorNodeVOMeta.SEARCH_VALUE , MonitorNodeVOMeta.DIRTY_FIELDS , MonitorNodeVOMeta.SORT_FIELD , MonitorNodeVOMeta.SORT_TYPE , MonitorNodeVOMeta.IDS } )
	@NotNull(name = MonitorNodeVOMeta.ID)
	@SentinelResource(value = MonitorNodeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeServiceProxy.UPDATE)
	public Result update(MonitorNodeVO monitorNodeVO) {
		Result result=monitorNodeService.update(monitorNodeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存节点
	*/
	@ApiOperation(value = "保存节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_IP , value = "IP" , required = false , dataTypeClass=String.class , example = "121.43.103.102"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.PID , value = "父节点" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SUB_TYPE , value = "子类型" , required = false , dataTypeClass=String.class , example = "Redhat"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.GROUP_ID , value = "节点分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME , value = "主机名" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME_SHOW , value = "可见主机名" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_ENABLED , value = "是否启用" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.STATUS , value = "监控状态" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_VOUCHER_ID , value = "凭证(SSH)" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_PORT , value = "SSH端口" , required = false , dataTypeClass=Integer.class , example = "22"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.AGENT_PORT , value = "Agent端口" , required = false , dataTypeClass=Integer.class , example = "10052"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_PORT , value = "Snmp端口" , required = false , dataTypeClass=Integer.class , example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_VERSION , value = "Snmp版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_COMMUNITY , value = "Snmp团体" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JMX_PORT , value = "Jmx端口" , required = false , dataTypeClass=Integer.class , example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.IMPI_PORT , value = "Jmx端口" , required = false , dataTypeClass=Integer.class , example = "623"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JDBC_URL , value = "Jdbc地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeVOMeta.PAGE_INDEX , MonitorNodeVOMeta.PAGE_SIZE , MonitorNodeVOMeta.SEARCH_FIELD , MonitorNodeVOMeta.FUZZY_FIELD , MonitorNodeVOMeta.SEARCH_VALUE , MonitorNodeVOMeta.DIRTY_FIELDS , MonitorNodeVOMeta.SORT_FIELD , MonitorNodeVOMeta.SORT_TYPE , MonitorNodeVOMeta.IDS } )
	@NotNull(name = MonitorNodeVOMeta.ID)
	@SentinelResource(value = MonitorNodeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeServiceProxy.SAVE)
	public Result save(MonitorNodeVO monitorNodeVO) {
		Result result=monitorNodeService.save(monitorNodeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取节点
	*/
	@ApiOperation(value = "获取节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorNodeVOMeta.ID)
	@SentinelResource(value = MonitorNodeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeServiceProxy.GET_BY_ID)
	public Result<MonitorNode> getById(String id) {
		Result<MonitorNode> result=new Result<>();
		MonitorNode monitorNode=monitorNodeService.getById(id);
		// join 关联的对象
		monitorNodeService.dao().fill(monitorNode)
			.with(MonitorNodeMeta.SSH_VOUCHER)
			.with(MonitorNodeMeta.MONITOR_NODE_GROUP)
			.with(MonitorNodeMeta.MONITOR_NODE_TYPE)
			.with(MonitorNodeMeta.MONITOR_NODE_SUB_TYPE)
			.execute();
		result.success(true).data(monitorNode);
		return result;
	}


	/**
	 * 批量获取节点 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取节点")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorNodeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorNodeVOMeta.IDS)
		@SentinelResource(value = MonitorNodeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeServiceProxy.GET_BY_IDS)
	public Result<List<MonitorNode>> getByIds(List<String> ids) {
		Result<List<MonitorNode>> result=new Result<>();
		List<MonitorNode> list=monitorNodeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询节点
	*/
	@ApiOperation(value = "查询节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_IP , value = "IP" , required = false , dataTypeClass=String.class , example = "121.43.103.102"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.PID , value = "父节点" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SUB_TYPE , value = "子类型" , required = false , dataTypeClass=String.class , example = "Redhat"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.GROUP_ID , value = "节点分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME , value = "主机名" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME_SHOW , value = "可见主机名" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_ENABLED , value = "是否启用" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.STATUS , value = "监控状态" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_VOUCHER_ID , value = "凭证(SSH)" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_PORT , value = "SSH端口" , required = false , dataTypeClass=Integer.class , example = "22"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.AGENT_PORT , value = "Agent端口" , required = false , dataTypeClass=Integer.class , example = "10052"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_PORT , value = "Snmp端口" , required = false , dataTypeClass=Integer.class , example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_VERSION , value = "Snmp版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_COMMUNITY , value = "Snmp团体" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JMX_PORT , value = "Jmx端口" , required = false , dataTypeClass=Integer.class , example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.IMPI_PORT , value = "Jmx端口" , required = false , dataTypeClass=Integer.class , example = "623"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JDBC_URL , value = "Jdbc地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeVOMeta.PAGE_INDEX , MonitorNodeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorNodeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeServiceProxy.QUERY_LIST)
	public Result<List<MonitorNode>> queryList(MonitorNodeVO sample) {
		Result<List<MonitorNode>> result=new Result<>();
		List<MonitorNode> list=monitorNodeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询节点
	*/
	@ApiOperation(value = "分页查询节点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_IP , value = "IP" , required = false , dataTypeClass=String.class , example = "121.43.103.102"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.PID , value = "父节点" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SUB_TYPE , value = "子类型" , required = false , dataTypeClass=String.class , example = "Redhat"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.GROUP_ID , value = "节点分组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME , value = "主机名" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME_SHOW , value = "可见主机名" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_ENABLED , value = "是否启用" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.STATUS , value = "监控状态" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_VOUCHER_ID , value = "凭证(SSH)" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_PORT , value = "SSH端口" , required = false , dataTypeClass=Integer.class , example = "22"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.AGENT_PORT , value = "Agent端口" , required = false , dataTypeClass=Integer.class , example = "10052"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_PORT , value = "Snmp端口" , required = false , dataTypeClass=Integer.class , example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_VERSION , value = "Snmp版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_COMMUNITY , value = "Snmp团体" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JMX_PORT , value = "Jmx端口" , required = false , dataTypeClass=Integer.class , example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.IMPI_PORT , value = "Jmx端口" , required = false , dataTypeClass=Integer.class , example = "623"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JDBC_URL , value = "Jdbc地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorNodeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorNode>> queryPagedList(MonitorNodeVO sample) {
		Result<PagedList<MonitorNode>> result=new Result<>();
		PagedList<MonitorNode> list=monitorNodeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		monitorNodeService.dao().fill(list)
			.with(MonitorNodeMeta.SSH_VOUCHER)
			.with(MonitorNodeMeta.MONITOR_NODE_GROUP)
			.with(MonitorNodeMeta.MONITOR_NODE_TYPE)
			.with(MonitorNodeMeta.MONITOR_NODE_SUB_TYPE)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorNodeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorNodeVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorNodeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorNodeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorNodeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorNodeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorNodeService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}