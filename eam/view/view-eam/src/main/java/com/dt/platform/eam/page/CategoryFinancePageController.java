package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CategoryFinanceServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 财务分类 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-10 13:01:35
*/

@Controller("EamCategoryFinancePageController")
@RequestMapping(CategoryFinancePageController.prefix)
public class CategoryFinancePageController extends ViewController {
	
	public static final String prefix="business/eam/category_finance";

	private CategoryFinanceServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CategoryFinanceServiceProxy proxy() {
		if(proxy==null) {
			proxy=CategoryFinanceServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 财务分类 功能主页面
	 */
	@RequestMapping("/category_finance_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/category_finance_list";
	}

	/**
	 * 财务分类 表单页面
	 */
	@RequestMapping("/category_finance_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/category_finance_form";
	}
}