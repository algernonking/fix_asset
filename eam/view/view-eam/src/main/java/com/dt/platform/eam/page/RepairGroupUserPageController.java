package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RepairGroupUserServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 班组人员 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 13:29:30
*/

@Controller("EamRepairGroupUserPageController")
@RequestMapping(RepairGroupUserPageController.prefix)
public class RepairGroupUserPageController extends ViewController {
	
	public static final String prefix="business/eam/repair_group_user";

	private RepairGroupUserServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public RepairGroupUserServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepairGroupUserServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 班组人员 功能主页面
	 */
	@RequestMapping("/repair_group_user_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/repair_group_user_list";
	}

	/**
	 * 班组人员 表单页面
	 */
	@RequestMapping("/repair_group_user_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/repair_group_user_form";
	}
}