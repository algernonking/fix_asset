package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.HostMidServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 中间件 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-30 13:55:56
*/

@Controller("OpsHostMidPageController")
@RequestMapping(HostMidPageController.prefix)
public class HostMidPageController extends ViewController {
	
	public static final String prefix="business/ops/host_mid";

	private HostMidServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public HostMidServiceProxy proxy() {
		if(proxy==null) {
			proxy=HostMidServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 中间件 功能主页面
	 */
	@RequestMapping("/host_mid_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/host_mid_list";
	}

	/**
	 * 中间件 表单页面
	 */
	@RequestMapping("/host_mid_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/host_mid_form";
	}
}