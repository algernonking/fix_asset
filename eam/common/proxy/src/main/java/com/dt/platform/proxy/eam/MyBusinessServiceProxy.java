package com.dt.platform.proxy.eam;

import com.dt.platform.domain.eam.TplFile;
import com.dt.platform.domain.eam.TplFileVO;
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
 * 模板文件  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-09 12:26:05
*/

@FeignClient(value = ServiceNames.EAM, contextId = MyBusinessServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface MyBusinessServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 ,eam-my-business
	*/
	public static final String API_CONTEXT_PATH = "eam-my-business";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	

	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.MyBusinessController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static MyBusinessServiceProxy api() {
		return APIProxy.get(MyBusinessServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}