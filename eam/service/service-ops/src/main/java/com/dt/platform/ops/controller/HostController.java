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


import com.dt.platform.proxy.ops.HostServiceProxy;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.HostVO;
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
import com.dt.platform.domain.ops.meta.HostMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.ops.InformationSystem;
import com.dt.platform.domain.ops.HostPosition;
import com.dt.platform.domain.ops.ServiceInfo;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IHostService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 主机 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-14 14:29:45
*/

@Api(tags = "主机")
@ApiSort(0)
@RestController("OpsHostController")
public class HostController extends SuperController {

	@Autowired
	private IHostService hostService;

	
	/**
	 * 添加主机
	*/
	@ApiOperation(value = "添加主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostVOMeta.SYSTEM_ID , value = "信息系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_TYPE , value = "主机类型" , required = false , dataTypeClass=String.class , example = "business"),
		@ApiImplicitParam(name = HostVOMeta.STATUS , value = "主机状态online" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.HOST_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostVOMeta.HOST_IP , value = "IP" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.HOST_VIP , value = "VIP" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.ENVIRONMENT , value = "运行环境prod" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = HostVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = HostVOMeta.MONITOR_STATUS , value = "监控状态:valid" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.DIRECTOR_USERNAME , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_MEMORY , value = "内存" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = HostVOMeta.HOST_CPU , value = "CPU" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = HostVOMeta.HOST_CONF , value = "其他配置" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OS_ADMIN , value = "系统管理员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.USER_DB_ADMIN , value = "数据库管理员" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_DB_USED , value = "数据库使用用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_APP_USED , value = "应用使用用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OPS_OPER , value = "运维操作用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OTHER , value = "其他用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.PASSWORD_STRATEGY_ID , value = "改密策略" , required = false , dataTypeClass=String.class , example = "ops"),
		@ApiImplicitParam(name = HostVOMeta.OFFLINE_TIME , value = "下线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-13 12:00:00"),
		@ApiImplicitParam(name = HostVOMeta.ONLINE_TIME , value = "上线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-14 12:00:00"),
		@ApiImplicitParam(name = HostVOMeta.ARCH , value = "是否归档1归档0不归档" , required = true , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = HostVOMeta.LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = HostVOMeta.ID)
	@NotNull(name = HostVOMeta.HOST_IP)
	@NotNull(name = HostVOMeta.ARCH)
	@SentinelResource(value = HostServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostServiceProxy.INSERT)
	public Result insert(HostVO hostVO) {
		Result result=hostService.insert(hostVO);
		return result;
	}

	
	/**
	 * 删除主机
	*/
	@ApiOperation(value = "删除主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478194091549523968")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = HostVOMeta.ID)
	@SentinelResource(value = HostServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=hostService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除主机 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = HostVOMeta.IDS)
	@SentinelResource(value = HostServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=hostService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新主机
	*/
	@ApiOperation(value = "更新主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostVOMeta.SYSTEM_ID , value = "信息系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_TYPE , value = "主机类型" , required = false , dataTypeClass=String.class , example = "business"),
		@ApiImplicitParam(name = HostVOMeta.STATUS , value = "主机状态online" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.HOST_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostVOMeta.HOST_IP , value = "IP" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.HOST_VIP , value = "VIP" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.ENVIRONMENT , value = "运行环境prod" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = HostVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = HostVOMeta.MONITOR_STATUS , value = "监控状态:valid" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.DIRECTOR_USERNAME , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_MEMORY , value = "内存" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = HostVOMeta.HOST_CPU , value = "CPU" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = HostVOMeta.HOST_CONF , value = "其他配置" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OS_ADMIN , value = "系统管理员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.USER_DB_ADMIN , value = "数据库管理员" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_DB_USED , value = "数据库使用用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_APP_USED , value = "应用使用用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OPS_OPER , value = "运维操作用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OTHER , value = "其他用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.PASSWORD_STRATEGY_ID , value = "改密策略" , required = false , dataTypeClass=String.class , example = "ops"),
		@ApiImplicitParam(name = HostVOMeta.OFFLINE_TIME , value = "下线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-13 12:00:00"),
		@ApiImplicitParam(name = HostVOMeta.ONLINE_TIME , value = "上线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-14 12:00:00"),
		@ApiImplicitParam(name = HostVOMeta.ARCH , value = "是否归档1归档0不归档" , required = true , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = HostVOMeta.LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { HostVOMeta.PAGE_INDEX , HostVOMeta.PAGE_SIZE , HostVOMeta.SEARCH_FIELD , HostVOMeta.FUZZY_FIELD , HostVOMeta.SEARCH_VALUE , HostVOMeta.SORT_FIELD , HostVOMeta.SORT_TYPE , HostVOMeta.IDS } ) 
	@NotNull(name = HostVOMeta.ID)
	@NotNull(name = HostVOMeta.HOST_IP)
	@NotNull(name = HostVOMeta.ARCH)
	@SentinelResource(value = HostServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostServiceProxy.UPDATE)
	public Result update(HostVO hostVO) {
		Result result=hostService.update(hostVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存主机
	*/
	@ApiOperation(value = "保存主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostVOMeta.SYSTEM_ID , value = "信息系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_TYPE , value = "主机类型" , required = false , dataTypeClass=String.class , example = "business"),
		@ApiImplicitParam(name = HostVOMeta.STATUS , value = "主机状态online" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.HOST_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostVOMeta.HOST_IP , value = "IP" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.HOST_VIP , value = "VIP" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.ENVIRONMENT , value = "运行环境prod" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = HostVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = HostVOMeta.MONITOR_STATUS , value = "监控状态:valid" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.DIRECTOR_USERNAME , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_MEMORY , value = "内存" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = HostVOMeta.HOST_CPU , value = "CPU" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = HostVOMeta.HOST_CONF , value = "其他配置" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OS_ADMIN , value = "系统管理员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.USER_DB_ADMIN , value = "数据库管理员" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_DB_USED , value = "数据库使用用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_APP_USED , value = "应用使用用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OPS_OPER , value = "运维操作用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OTHER , value = "其他用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.PASSWORD_STRATEGY_ID , value = "改密策略" , required = false , dataTypeClass=String.class , example = "ops"),
		@ApiImplicitParam(name = HostVOMeta.OFFLINE_TIME , value = "下线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-13 12:00:00"),
		@ApiImplicitParam(name = HostVOMeta.ONLINE_TIME , value = "上线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-14 12:00:00"),
		@ApiImplicitParam(name = HostVOMeta.ARCH , value = "是否归档1归档0不归档" , required = true , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = HostVOMeta.LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { HostVOMeta.PAGE_INDEX , HostVOMeta.PAGE_SIZE , HostVOMeta.SEARCH_FIELD , HostVOMeta.FUZZY_FIELD , HostVOMeta.SEARCH_VALUE , HostVOMeta.SORT_FIELD , HostVOMeta.SORT_TYPE , HostVOMeta.IDS } )
	@NotNull(name = HostVOMeta.ID)
	@NotNull(name = HostVOMeta.HOST_IP)
	@NotNull(name = HostVOMeta.ARCH)
	@SentinelResource(value = HostServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostServiceProxy.SAVE)
	public Result save(HostVO hostVO) {
		Result result=hostService.save(hostVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取主机
	*/
	@ApiOperation(value = "获取主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = HostVOMeta.ID)
	@SentinelResource(value = HostServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostServiceProxy.GET_BY_ID)
	public Result<Host> getById(String id) {
		Result<Host> result=new Result<>();
		Host host=hostService.getById(id);
		// 关联出 信息系统 数据
		hostService.join(host,HostMeta.INFO_SYSTEM);
		// 关联出 所在位置 数据
		hostService.join(host,HostMeta.POSITION);
		// 关联出 数据库 数据
		hostService.join(host,HostMeta.HOST_DB_LIST);
		// 关联出 中间件 数据
		hostService.join(host,HostMeta.HOST_MIDDLEWARE_LIST);
		// 关联出 操作系统 数据
		hostService.join(host,HostMeta.HOST_OS_LIST);
		result.success(true).data(host);
		return result;
	}


	/**
	 * 批量删除主机 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除主机")
		@ApiImplicitParams({
				@ApiImplicitParam(name = HostVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = HostVOMeta.IDS)
		@SentinelResource(value = HostServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostServiceProxy.GET_BY_IDS)
	public Result<List<Host>> getByIds(List<String> ids) {
		Result<List<Host>> result=new Result<>();
		List<Host> list=hostService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询主机
	*/
	@ApiOperation(value = "查询主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostVOMeta.SYSTEM_ID , value = "信息系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_TYPE , value = "主机类型" , required = false , dataTypeClass=String.class , example = "business"),
		@ApiImplicitParam(name = HostVOMeta.STATUS , value = "主机状态online" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.HOST_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostVOMeta.HOST_IP , value = "IP" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.HOST_VIP , value = "VIP" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.ENVIRONMENT , value = "运行环境prod" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = HostVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = HostVOMeta.MONITOR_STATUS , value = "监控状态:valid" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.DIRECTOR_USERNAME , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_MEMORY , value = "内存" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = HostVOMeta.HOST_CPU , value = "CPU" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = HostVOMeta.HOST_CONF , value = "其他配置" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OS_ADMIN , value = "系统管理员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.USER_DB_ADMIN , value = "数据库管理员" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_DB_USED , value = "数据库使用用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_APP_USED , value = "应用使用用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OPS_OPER , value = "运维操作用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OTHER , value = "其他用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.PASSWORD_STRATEGY_ID , value = "改密策略" , required = false , dataTypeClass=String.class , example = "ops"),
		@ApiImplicitParam(name = HostVOMeta.OFFLINE_TIME , value = "下线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-13 12:00:00"),
		@ApiImplicitParam(name = HostVOMeta.ONLINE_TIME , value = "上线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-14 12:00:00"),
		@ApiImplicitParam(name = HostVOMeta.ARCH , value = "是否归档1归档0不归档" , required = true , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = HostVOMeta.LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { HostVOMeta.PAGE_INDEX , HostVOMeta.PAGE_SIZE } )
	@SentinelResource(value = HostServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostServiceProxy.QUERY_LIST)
	public Result<List<Host>> queryList(HostVO sample) {
		Result<List<Host>> result=new Result<>();
		List<Host> list=hostService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询主机
	*/
	@ApiOperation(value = "分页查询主机")
	@ApiImplicitParams({
		@ApiImplicitParam(name = HostVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478194091549523968"),
		@ApiImplicitParam(name = HostVOMeta.SYSTEM_ID , value = "信息系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_TYPE , value = "主机类型" , required = false , dataTypeClass=String.class , example = "business"),
		@ApiImplicitParam(name = HostVOMeta.STATUS , value = "主机状态online" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.HOST_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = HostVOMeta.HOST_IP , value = "IP" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.HOST_VIP , value = "VIP" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.ENVIRONMENT , value = "运行环境prod" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = HostVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = HostVOMeta.MONITOR_STATUS , value = "监控状态:valid" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.DIRECTOR_USERNAME , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_MEMORY , value = "内存" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = HostVOMeta.HOST_CPU , value = "CPU" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = HostVOMeta.HOST_CONF , value = "其他配置" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OS_ADMIN , value = "系统管理员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.USER_DB_ADMIN , value = "数据库管理员" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_DB_USED , value = "数据库使用用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_APP_USED , value = "应用使用用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OPS_OPER , value = "运维操作用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.USER_OTHER , value = "其他用户" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = HostVOMeta.PASSWORD_STRATEGY_ID , value = "改密策略" , required = false , dataTypeClass=String.class , example = "ops"),
		@ApiImplicitParam(name = HostVOMeta.OFFLINE_TIME , value = "下线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-13 12:00:00"),
		@ApiImplicitParam(name = HostVOMeta.ONLINE_TIME , value = "上线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-14 12:00:00"),
		@ApiImplicitParam(name = HostVOMeta.ARCH , value = "是否归档1归档0不归档" , required = true , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = HostVOMeta.LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = HostVOMeta.HOST_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = HostServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(HostServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Host>> queryPagedList(HostVO sample) {
		Result<PagedList<Host>> result=new Result<>();
		PagedList<Host> list=hostService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 信息系统 数据
		hostService.join(list,HostMeta.INFO_SYSTEM);
		// 关联出 所在位置 数据
		hostService.join(list,HostMeta.POSITION);
		// 关联出 数据库 数据
		hostService.join(list,HostMeta.HOST_DB_LIST);
		// 关联出 中间件 数据
		hostService.join(list,HostMeta.HOST_MIDDLEWARE_LIST);
		// 关联出 操作系统 数据
		hostService.join(list,HostMeta.HOST_OS_LIST);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = HostServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostServiceProxy.EXPORT_EXCEL)
	public void exportExcel(HostVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=hostService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = HostServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=hostService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = HostServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(HostServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=hostService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}