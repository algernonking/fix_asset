package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RepairOrderAcceptanceServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 维修验收 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-01 07:17:17
*/

@Controller("EamRepairOrderAcceptancePageController")
@RequestMapping(RepairOrderAcceptancePageController.prefix)
public class RepairOrderAcceptancePageController extends ViewController {
	
	public static final String prefix="business/eam/repair_order_acceptance";

	private RepairOrderAcceptanceServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public RepairOrderAcceptanceServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepairOrderAcceptanceServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 维修验收 功能主页面
	 */
	@RequestMapping("/repair_order_acceptance_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/repair_order_acceptance_list";
	}

	/**
	 * 维修验收 表单页面
	 */
	@RequestMapping("/repair_order_acceptance_form.html")
	public String form(Model model,HttpServletRequest request , String id,String orderActId) {

		model.addAttribute("orderActId",orderActId);
		return prefix+"/repair_order_acceptance_form";
	}
}