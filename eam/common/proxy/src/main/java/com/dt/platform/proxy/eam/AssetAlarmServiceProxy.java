package com.dt.platform.proxy.eam;

import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 资产  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-02 16:01:39
*/

@FeignClient(value = ServiceNames.EAM, contextId = AssetAlarmServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface AssetAlarmServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-asset
	*/
	public static final String API_CONTEXT_PATH = "eam-asset-alarm";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";


	/**
	 * 查询维保过期数据
	 */
	public static final String QUERY_MAINTENANCE_EXPIRATION_DATA = API_PREFIX + "query-maintenance-expiration-data";


	/**
	 * 查询领用过期数据
	 */
	public static final String QUERY_COLLECTION_EXPIRATION_DATA = API_PREFIX + "query-collection-expiration-data";


	/**
	 * 查询借用过期数据
	 */
	public static final String QUERY_BORROW_EXPIRATION_DATA = API_PREFIX + "query-borrow-expiration-data";

	/**
	 * 资产序列唯一
	 */
	public static final String QUERY_ASSET_SERIAL_NUMBER_UNIQUE = API_PREFIX + "query-asset-serial-number-unique";

	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.AssetAlarmController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static AssetAlarmServiceProxy api() {
		return APIProxy.get(AssetAlarmServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}