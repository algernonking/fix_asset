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
	public static final String API_CONTEXT_PATH = "eam-asset";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加资产
	 */
	public static final String INSERT = API_PREFIX + "insert";
	


	
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