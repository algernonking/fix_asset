package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InventoryWarehouseServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 盘点仓库 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-04 11:09:02
*/

@Controller("EamInventoryWarehousePageController")
@RequestMapping(InventoryWarehousePageController.prefix)
public class InventoryWarehousePageController extends ViewController {
	
	public static final String prefix="business/eam/inventory_warehouse";

	private InventoryWarehouseServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InventoryWarehouseServiceProxy proxy() {
		if(proxy==null) {
			proxy=InventoryWarehouseServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 盘点仓库 功能主页面
	 */
	@RequestMapping("/inventory_warehouse_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/inventory_warehouse_list";
	}

	/**
	 * 盘点仓库 表单页面
	 */
	@RequestMapping("/inventory_warehouse_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/inventory_warehouse_form";
	}
}