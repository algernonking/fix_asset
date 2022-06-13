package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InspectionTaskPointServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 巡检点 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-12 21:07:10
*/

@Controller("EamInspectionTaskPointPageController")
@RequestMapping(InspectionTaskPointPageController.prefix)
public class InspectionTaskPointPageController extends ViewController {
	
	public static final String prefix="business/eam/inspection_task_point";

	private InspectionTaskPointServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InspectionTaskPointServiceProxy proxy() {
		if(proxy==null) {
			proxy=InspectionTaskPointServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 巡检点 功能主页面
	 */
	@RequestMapping("/inspection_task_point_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/inspection_task_point_list";
	}

	/**
	 * 巡检点 功能主页面
	 */
	@RequestMapping("/inspection_task_point_selected_list.html")
	public String selectedList(Model model,HttpServletRequest request,String taskId,String pageType,String selectedCode,String ownerType) {

		model.addAttribute("taskId",taskId);
		model.addAttribute("pageType",pageType);
		model.addAttribute("selectedCode",selectedCode);
		model.addAttribute("ownerType",ownerType);
		return prefix+"/inspection_task_point_selected_list";
	}

	/**
	 * 巡检点 表单页面
	 */
	@RequestMapping("/inspection_task_point_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/inspection_task_point_form";
	}
}