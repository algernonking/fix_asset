package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RepairOrderActServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 维修工单 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-31 14:52:54
*/

@Controller("EamRepairOrderActPageController")
@RequestMapping(RepairOrderActPageController.prefix)
public class RepairOrderActPageController extends ViewController {
	
	public static final String prefix="business/eam/repair_order_act";

	private RepairOrderActServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public RepairOrderActServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepairOrderActServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 维修工单 功能主页面
	 */
	@RequestMapping("/repair_order_act_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/repair_order_act_list";
	}

	/**
	 * 维修工单 表单页面
	 */
	@RequestMapping("/repair_order_act_form.html")
	public String form(Model model,HttpServletRequest request , String id,String orderId) {

		model.addAttribute("orderId",orderId);
		return prefix+"/repair_order_act_form";
	}
}