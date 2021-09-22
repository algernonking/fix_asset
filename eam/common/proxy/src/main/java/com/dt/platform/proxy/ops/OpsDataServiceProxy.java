package com.dt.platform.proxy.ops;

import com.dt.platform.proxy.ServiceNames;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 主机  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:06:49
*/

@FeignClient(value = ServiceNames.OPS, contextId = OpsDataServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface OpsDataServiceProxy {
	
	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";

	/**
	 * API 上下文路径 , ops-host
	*/
	public static final String API_CONTEXT_PATH = "ops-data";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";



	/**
	 * 导出主机
	 */
	public static final String EXPORT_HOST = API_PREFIX + "export-host";

	/**
	 * 导出信息系统
	 */
	public static final String EXPORT_INFORMATION_SYSTEM = API_PREFIX + "export-information-system";

	/**
	 * 导出数据库实例
	 */
	public static final String EXPORT_DATABASE_INSTANCE = API_PREFIX + "export-database-instance";


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.OpsDataController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static OpsDataServiceProxy api() {
		return APIProxy.get(OpsDataServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}