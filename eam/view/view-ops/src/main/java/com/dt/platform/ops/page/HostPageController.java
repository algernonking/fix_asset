package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.HostServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 主机 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-29 11:01:54
*/

@Controller("OpsHostPageController")
@RequestMapping(HostPageController.prefix)
public class HostPageController extends ViewController {
	
	public static final String prefix="business/ops/host";

	private HostServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public HostServiceProxy proxy() {
		if(proxy==null) {
			proxy=HostServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 主机 功能主页面
	 */
	@RequestMapping("/host_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/host_list";
	}

	/**
	 * 主机 表单页面
	 */
	@RequestMapping("/host_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/host_form";
	}
}