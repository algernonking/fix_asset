package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InspectionRouteServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 巡检路径 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 14:02:52
*/

@Controller("EamInspectionRoutePageController")
@RequestMapping(InspectionRoutePageController.prefix)
public class InspectionRoutePageController extends ViewController {
	
	public static final String prefix="business/eam/inspection_route";

	private InspectionRouteServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InspectionRouteServiceProxy proxy() {
		if(proxy==null) {
			proxy=InspectionRouteServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 巡检路径 功能主页面
	 */
	@RequestMapping("/inspection_route_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/inspection_route_list";
	}

	/**
	 * 巡检路径 表单页面
	 */
	@RequestMapping("/inspection_route_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/inspection_route_form";
	}
}