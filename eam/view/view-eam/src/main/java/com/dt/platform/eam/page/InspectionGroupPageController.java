package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InspectionGroupServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 巡检班组 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 12:57:14
*/

@Controller("EamInspectionGroupPageController")
@RequestMapping(InspectionGroupPageController.prefix)
public class InspectionGroupPageController extends ViewController {
	
	public static final String prefix="business/eam/inspection_group";

	private InspectionGroupServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InspectionGroupServiceProxy proxy() {
		if(proxy==null) {
			proxy=InspectionGroupServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 巡检班组 功能主页面
	 */
	@RequestMapping("/inspection_group_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/inspection_group_list";
	}

	/**
	 * 巡检班组 表单页面
	 */
	@RequestMapping("/inspection_group_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/inspection_group_form";
	}
}