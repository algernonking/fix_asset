package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.InspectionTaskServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 巡检任务 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-13 10:28:05
*/

@Controller("EamInspectionTaskPageController")
@RequestMapping(InspectionTaskPageController.prefix)
public class InspectionTaskPageController extends ViewController {
	
	public static final String prefix="business/eam/inspection_task";

	private InspectionTaskServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InspectionTaskServiceProxy proxy() {
		if(proxy==null) {
			proxy=InspectionTaskServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 巡检任务 功能主页面
	 */
	@RequestMapping("/inspection_task_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/inspection_task_list";
	}

	/**
	 * 巡检任务 表单页面
	 */
	@RequestMapping("/inspection_task_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/inspection_task_form";
	}
}