package com.dt.platform.datacenter.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.datacenter.LayerServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 层级 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-17 22:01:18
*/

@Controller("DcLayerPageController")
@RequestMapping(LayerPageController.prefix)
public class LayerPageController extends ViewController {
	
	public static final String prefix="business/datacenter/layer";

	private LayerServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public LayerServiceProxy proxy() {
		if(proxy==null) {
			proxy=LayerServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 层级 功能主页面
	 */
	@RequestMapping("/layer_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/layer_list";
	}

	/**
	 * 层级 表单页面
	 */
	@RequestMapping("/layer_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/layer_form";
	}
}