package com.dt.platform.contract.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.contract.ContractPerformanceServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 合同履行情况表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-28 14:20:20
*/

@Controller("ContContractPerformancePageController")
@RequestMapping(ContractPerformancePageController.prefix)
public class ContractPerformancePageController extends ViewController {
	
	public static final String prefix="business/contract/contract_performance";

	private ContractPerformanceServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ContractPerformanceServiceProxy proxy() {
		if(proxy==null) {
			proxy=ContractPerformanceServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 合同履行情况 功能主页面
	 */
	@RequestMapping("/contract_performance_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/contract_performance_list";
	}

	/**
	 * 合同履行情况 表单页面
	 */
	@RequestMapping("/contract_performance_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/contract_performance_form";
	}
}