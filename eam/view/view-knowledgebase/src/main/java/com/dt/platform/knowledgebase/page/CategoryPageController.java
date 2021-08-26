package com.dt.platform.knowledgebase.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.knowledgebase.CategoryServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 知识分类 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-26 09:23:37
*/

@Controller("KnCategoryPageController")
@RequestMapping(CategoryPageController.prefix)
public class CategoryPageController extends ViewController {
	
	public static final String prefix="business/knowledgebase/category";

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
	 * 知识分类 功能主页面
	 */
	@RequestMapping("/category_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/category_list";
	}

	/**
	 * 知识分类 表单页面
	 */
	@RequestMapping("/category_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/category_form";
	}
}