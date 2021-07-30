package com.dt.platform.datacenter.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.datacenter.RackServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 机柜管理 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-30 14:59:21
*/

@Controller("DcRackPageController")
@RequestMapping(RackPageController.prefix)
public class RackPageController extends ViewController {
	
	public static final String prefix="business/datacenter/rack";

	private RackServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public RackServiceProxy proxy() {
		if(proxy==null) {
			proxy=RackServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 机柜管理 功能主页面
	 */
	@RequestMapping("/rack_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/rack_list";
	}

	/**
	 * 机柜管理 表单页面
	 */
	@RequestMapping("/rack_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/rack_form";
	}
}