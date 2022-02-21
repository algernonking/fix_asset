package com.dt.platform.proxy.ops;

import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 主机  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:06:49
*/

@FeignClient(value = ServiceNames.OPS, contextId = MonitorDataProcessZabbixServerServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface MonitorDataProcessZabbixServerServiceProxy {
	
	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";

	/**
	 * API 上下文路径 ,collect-data
	*/
	public static final String API_CONTEXT_PATH = "monitor-process-zabbix-server";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";


	/**
	 * 收集数据
	 */
	public static final String COLLECT_DATA = API_PREFIX + "collect-data";


	/**
	 * 收集数据
	 */
	public static final String CLEAR_NODE_VALUE_LAST_HISTORY_DATA = API_PREFIX + "clear-node-value-last-history-data";


	/**
	 * 添加节点数据库
	 */
	@RequestMapping(MonitorDataProcessZabbixServerServiceProxy.COLLECT_DATA)
	public Result collectData();

	/**
	 * 添加节点数据库
	 */
	@RequestMapping(MonitorDataProcessZabbixServerServiceProxy.CLEAR_NODE_VALUE_LAST_HISTORY_DATA)
	public Result clearNodeValueLastHistoryData();

	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.MonitorDataProcessZabbixServerController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static MonitorDataProcessZabbixServerServiceProxy api() {
		return APIProxy.get(MonitorDataProcessZabbixServerServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}