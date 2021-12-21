package com.dt.platform.proxy.eam;

import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 资产  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-02 16:01:39
*/

@FeignClient(value = ServiceNames.EAM, contextId = AssetReportServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface AssetReportServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-asset
	*/
	public static final String API_CONTEXT_PATH = "eam-asset-report";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 查询分类数据
	 */
	public static final String QUERY_CATEGORY_DATA = API_PREFIX + "query-category-data";

	/**
	 * 查询组织数据
	 */
	public static final String QUERY_ORGANIZATION_DATA = API_PREFIX + "query-organization-data";

	/**
	 * 资产dashboard
	 */
	public static final String DASHBOARD = API_PREFIX + "dashboard";

	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.AssetReportController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static AssetReportServiceProxy api() {
		return APIProxy.get(AssetReportServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}