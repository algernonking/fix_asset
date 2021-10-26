package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.HostOsServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 操作系统 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:28:26
*/

@Controller("OpsHostOsPageController")
@RequestMapping(HostOsPageController.prefix)
public class HostOsPageController extends ViewController {
	
	public static final String prefix="business/ops/host_os";

	private HostOsServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public HostOsServiceProxy proxy() {
		if(proxy==null) {
			proxy=HostOsServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 操作系统 功能主页面
	 */
	@RequestMapping("/host_os_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/host_os_list";
	}

	/**
	 * 操作系统 表单页面
	 */
	@RequestMapping("/host_os_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/host_os_form";
	}
}