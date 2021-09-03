package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.WorkorderCategoryServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 工单类型 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-03 21:14:40
*/

@Controller("WorkorderCategoryPageController")
@RequestMapping(WorkorderCategoryPageController.prefix)
public class WorkorderCategoryPageController extends ViewController {
	
	public static final String prefix="business/ops/workorder_category";

	private WorkorderCategoryServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public WorkorderCategoryServiceProxy proxy() {
		if(proxy==null) {
			proxy=WorkorderCategoryServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 工单类型 功能主页面
	 */
	@RequestMapping("/workorder_category_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/workorder_category_list";
	}

	/**
	 * 工单类型 表单页面
	 */
	@RequestMapping("/workorder_category_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/workorder_category_form";
	}
}