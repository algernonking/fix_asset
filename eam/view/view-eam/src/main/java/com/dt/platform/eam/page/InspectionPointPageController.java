package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InspectionPointServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 巡检点 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-11 08:31:05
*/

@Controller("EamInspectionPointPageController")
@RequestMapping(InspectionPointPageController.prefix)
public class InspectionPointPageController extends ViewController {
	
	public static final String prefix="business/eam/inspection_point";

	private InspectionPointServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InspectionPointServiceProxy proxy() {
		if(proxy==null) {
			proxy=InspectionPointServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 巡检点 功能主页面
	 */
	@RequestMapping("/inspection_point_selected_list.html")
	public String selectedlist(Model model,HttpServletRequest request,
							   String ownerId,String ownerType,String selectedCode,String pageType) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("selectedCode",selectedCode);
		model.addAttribute("pageType",pageType);
		return prefix+"/inspection_point_selected_list";
	}

	/**
	 * 巡检点 功能主页面
	 */
	@RequestMapping("/inspection_point_select_list.html")
	public String selectlist(Model model,HttpServletRequest request, String ownerId,String ownerType,String selectedCode) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/inspection_point_select_list";
	}


	/**
	 * 巡检点 功能主页面
	 */
	@RequestMapping("/inspection_point_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/inspection_point_list";
	}

	/**
	 * 巡检点 表单页面
	 */
	@RequestMapping("/inspection_point_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/inspection_point_form";
	}
}