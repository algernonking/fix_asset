package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.ActionCrontabServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 执行动作 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-03 13:51:56
*/

@Controller("EamActionCrontabPageController")
@RequestMapping(ActionCrontabPageController.prefix)
public class ActionCrontabPageController extends ViewController {
	
	public static final String prefix="business/eam/action_crontab";

	private ActionCrontabServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ActionCrontabServiceProxy proxy() {
		if(proxy==null) {
			proxy=ActionCrontabServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 执行动作 功能主页面
	 */
	@RequestMapping("/action_crontab_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/action_crontab_list";
	}

	/**
	 * 执行动作 表单页面
	 */
	@RequestMapping("/action_crontab_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerId) {

		model.addAttribute("ownerId",ownerId);
		return prefix+"/action_crontab_form";

	}
}