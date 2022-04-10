package com.dt.platform.cms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.cms.CategoryServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 类型 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-10 11:54:36
*/

@Controller("CmsCategoryPageController")
@RequestMapping(CategoryPageController.prefix)
public class CategoryPageController extends ViewController {
	
	public static final String prefix="business/cms/category";

	private CategoryServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CategoryServiceProxy proxy() {
		if(proxy==null) {
			proxy=CategoryServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 类型 功能主页面
	 */
	@RequestMapping("/category_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/category_list";
	}

	/**
	 * 类型 表单页面
	 */
	@RequestMapping("/category_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/category_form";
	}
}