package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InventoryPositionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 盘点位置 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-04 11:05:01
*/

@Controller("EamInventoryPositionPageController")
@RequestMapping(InventoryPositionPageController.prefix)
public class InventoryPositionPageController extends ViewController {
	
	public static final String prefix="business/eam/inventory_position";

	private InventoryPositionServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InventoryPositionServiceProxy proxy() {
		if(proxy==null) {
			proxy=InventoryPositionServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 盘点位置 功能主页面
	 */
	@RequestMapping("/inventory_position_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/inventory_position_list";
	}

	/**
	 * 盘点位置 表单页面
	 */
	@RequestMapping("/inventory_position_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/inventory_position_form";
	}
}