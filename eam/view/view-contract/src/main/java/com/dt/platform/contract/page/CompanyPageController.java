package com.dt.platform.contract.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.contract.CompanyServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 单位 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-22 21:48:36
*/

@Controller("ContCompanyPageController")
@RequestMapping(CompanyPageController.prefix)
public class CompanyPageController extends ViewController {
	
	public static final String prefix="business/contract/company";

	private CompanyServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CompanyServiceProxy proxy() {
		if(proxy==null) {
			proxy=CompanyServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 单位 功能主页面
	 */
	@RequestMapping("/company_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/company_list";
	}

	/**
	 * 单位 表单页面
	 */
	@RequestMapping("/company_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/company_form";
	}
}