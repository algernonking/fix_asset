package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.MaintainTaskServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 保养任务 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-06 21:41:15
*/

@Controller("EamMaintainTaskPageController")
@RequestMapping(MaintainTaskPageController.prefix)
public class MaintainTaskPageController extends ViewController {
	
	public static final String prefix="business/eam/maintain_task";

	private MaintainTaskServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MaintainTaskServiceProxy proxy() {
		if(proxy==null) {
			proxy=MaintainTaskServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 保养任务 功能主页面
	 */
	@RequestMapping("/maintain_task_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/maintain_task_list";
	}

	/**
	 * 保养任务 表单页面
	 */
	@RequestMapping("/maintain_task_form.html")
	public String form(Model model,HttpServletRequest request , String id) {

		String employeeId= SessionUser.getCurrent().getActivatedEmployeeId();
		model.addAttribute("employeeId",employeeId);

		model.addAttribute("groupEmployee",employeeId);
		return prefix+"/maintain_task_form";
	}
}