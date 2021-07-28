package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.ServicetypeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 服务种类 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-27 15:03:54
*/

@Controller("OpsServicetypePageController")
@RequestMapping(ServicetypePageController.prefix)
public class ServicetypePageController extends ViewController {
	
	public static final String prefix="business/ops/servicetype";

	private ServicetypeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ServicetypeServiceProxy proxy() {
		if(proxy==null) {
			proxy=ServicetypeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 服务种类 功能主页面
	 */
	@RequestMapping("/servicetype_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/servicetype_list";
	}

	/**
	 * 服务种类 表单页面
	 */
	@RequestMapping("/servicetype_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/servicetype_form";
	}
}