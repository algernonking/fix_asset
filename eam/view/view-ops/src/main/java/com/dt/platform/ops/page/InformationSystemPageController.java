package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.InformationSystemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 信息系统 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-17 14:45:17
*/

@Controller("OpsInformationSystemPageController")
@RequestMapping(InformationSystemPageController.prefix)
public class InformationSystemPageController extends ViewController {
	
	public static final String prefix="business/ops/information_system";

	private InformationSystemServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InformationSystemServiceProxy proxy() {
		if(proxy==null) {
			proxy=InformationSystemServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 信息系统 功能主页面
	 */
	@RequestMapping("/information_system_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/information_system_list";
	}

	/**
	 * 信息系统 表单页面
	 */
	@RequestMapping("/information_system_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/information_system_form";
	}
}