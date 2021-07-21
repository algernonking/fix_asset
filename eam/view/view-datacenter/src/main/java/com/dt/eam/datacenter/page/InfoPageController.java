package com.dt.eam.datacenter.page;

import com.dt.eam.proxy.datacenter.InfoServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据中心 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-21 09:05:52
*/

@Controller("DcInfoPageController")
@RequestMapping(InfoPageController.prefix)
public class InfoPageController extends ViewController {
	
	public static final String prefix="business/datacenter/info";

	private InfoServiceProxy proxy;


	@PostConstruct
	public void start()
	{
		System.out.println("vvv");
	}
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=InfoServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 数据中心 功能主页面
	 */
	@RequestMapping("/info_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/info_list";
	}

	/**
	 * 数据中心 表单页面
	 */
	@RequestMapping("/info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/info_form";
	}
}