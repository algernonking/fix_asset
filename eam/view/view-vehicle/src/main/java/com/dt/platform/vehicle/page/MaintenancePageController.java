package com.dt.platform.vehicle.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.vehicle.MaintenanceServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 车辆维修保养 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 19:58:40
*/

@Controller("VehicleMaintenancePageController")
@RequestMapping(MaintenancePageController.prefix)
public class MaintenancePageController extends ViewController {
	
	public static final String prefix="business/vehicle/maintenance";

	private MaintenanceServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MaintenanceServiceProxy proxy() {
		if(proxy==null) {
			proxy=MaintenanceServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 车辆维修保养 功能主页面
	 */
	@RequestMapping("/maintenance_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/maintenance_list";
	}

	/**
	 * 车辆维修保养 表单页面
	 */
	@RequestMapping("/maintenance_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/maintenance_form";
	}
}