package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InventoryPlanServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 盘点计划 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-03 10:30:41
*/

@Controller("EamInventoryPlanPageController")
@RequestMapping(InventoryPlanPageController.prefix)
public class InventoryPlanPageController extends ViewController {
	
	public static final String prefix="business/eam/inventory_plan";

	private InventoryPlanServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InventoryPlanServiceProxy proxy() {
		if(proxy==null) {
			proxy=InventoryPlanServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 盘点计划 功能主页面
	 */
	@RequestMapping("/inventory_plan_list.html")
	public String list(Model model,HttpServletRequest request,String ownerCode) {
		model.addAttribute("ownerCode",ownerCode);
		return prefix+"/inventory_plan_list";
	}

	/**
	 * 盘点计划 表单页面
	 */
	@RequestMapping("/inventory_plan_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerCode) {
		model.addAttribute("ownerCode",ownerCode);
		return prefix+"/inventory_plan_form";
	}
}