package com.dt.platform.datacenter.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.dt.platform.proxy.datacenter.DcInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据中心 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-26 15:14:29
*/

@Controller("DcInfoPageController")
@RequestMapping(DcInfoPageController.prefix)
public class DcInfoPageController extends ViewController {
	
	public static final String prefix="business/datacenter/dc_info";

	private DcInfoServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public DcInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=DcInfoServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 数据中心 功能主页面
	 */
	@RequestMapping("/dc_info_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/dc_info_list";
	}

	/**
	 * 数据中心 表单页面
	 */
	@RequestMapping("/dc_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/dc_info_form";
	}
}