package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.SafetylevelServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 风险等级 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:28:10
*/

@Controller("EamSafetylevelPageController")
@RequestMapping(SafetylevelPageController.prefix)
public class SafetylevelPageController extends ViewController {
	
	public static final String prefix="business/eam/safetylevel";

	private SafetylevelServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public SafetylevelServiceProxy proxy() {
		if(proxy==null) {
			proxy=SafetylevelServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 风险等级 功能主页面
	 */
	@RequestMapping("/safetylevel_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/safetylevel_list";
	}

	/**
	 * 风险等级 表单页面
	 */
	@RequestMapping("/safetylevel_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/safetylevel_form";
	}
}