package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.ActionCrontabLogServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 日志 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-03 20:08:18
*/

@Controller("EamActionCrontabLogPageController")
@RequestMapping(ActionCrontabLogPageController.prefix)
public class ActionCrontabLogPageController extends ViewController {
	
	public static final String prefix="business/eam/action_crontab_log";

	private ActionCrontabLogServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ActionCrontabLogServiceProxy proxy() {
		if(proxy==null) {
			proxy=ActionCrontabLogServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 日志 功能主页面
	 */
	@RequestMapping("/action_crontab_log_list.html")
	public String list(Model model,HttpServletRequest request,String ownerId) {
		model.addAttribute("ownerId",ownerId);
		return prefix+"/action_crontab_log_list";
	}

	/**
	 * 日志 表单页面
	 */
	@RequestMapping("/action_crontab_log_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/action_crontab_log_form";
	}
}