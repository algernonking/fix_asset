package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.ServiceDetailServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 服务明细 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-11 14:39:04
*/

@Controller("OpsServiceDetailPageController")
@RequestMapping(ServiceDetailPageController.prefix)
public class ServiceDetailPageController extends ViewController {
	
	public static final String prefix="business/ops/service_detail";

	private ServiceDetailServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ServiceDetailServiceProxy proxy() {
		if(proxy==null) {
			proxy=ServiceDetailServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 服务明细 功能主页面
	 */
	@RequestMapping("/service_detail_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/service_detail_list";
	}

	/**
	 * 服务明细 表单页面
	 */
	@RequestMapping("/service_detail_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/service_detail_form";
	}
}