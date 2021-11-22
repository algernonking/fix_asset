package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InventoryManagerServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 资产管理人 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-19 21:37:25
*/

@Controller("EamInventoryManagerPageController")
@RequestMapping(InventoryManagerPageController.prefix)
public class InventoryManagerPageController extends ViewController {
	
	public static final String prefix="business/eam/inventory_manager";

	private InventoryManagerServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InventoryManagerServiceProxy proxy() {
		if(proxy==null) {
			proxy=InventoryManagerServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 资产管理人 功能主页面
	 */
	@RequestMapping("/inventory_manager_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/inventory_manager_list";
	}

	/**
	 * 资产管理人 表单页面
	 */
	@RequestMapping("/inventory_manager_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/inventory_manager_form";
	}
}