package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.WorkorderTypeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 工单类型 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-11 21:30:48
*/

@Controller("WorkorderTypePageController")
@RequestMapping(WorkorderTypePageController.prefix)
public class WorkorderTypePageController extends ViewController {
	
	public static final String prefix="business/ops/workorder_type";

	private WorkorderTypeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public WorkorderTypeServiceProxy proxy() {
		if(proxy==null) {
			proxy=WorkorderTypeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 工单类型 功能主页面
	 */
	@RequestMapping("/workorder_type_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/workorder_type_list";
	}

	/**
	 * 工单类型 表单页面
	 */
	@RequestMapping("/workorder_type_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/workorder_type_form";
	}
}