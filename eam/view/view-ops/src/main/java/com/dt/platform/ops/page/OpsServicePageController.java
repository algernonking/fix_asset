package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.OpsServiceServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 服务 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-13 21:59:33
*/

@Controller("OpsServicePageController")
@RequestMapping(OpsServicePageController.prefix)
public class OpsServicePageController extends ViewController {
	
	public static final String prefix="business/ops/ops_service";

	private OpsServiceServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public OpsServiceServiceProxy proxy() {
		if(proxy==null) {
			proxy=OpsServiceServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 服务 功能主页面
	 */
	@RequestMapping("/ops_service_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/ops_service_list";
	}

	/**
	 * 服务 表单页面
	 */
	@RequestMapping("/ops_service_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/ops_service_form";
	}
}