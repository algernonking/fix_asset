package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RepairGroupServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 维修班组 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 12:58:15
*/

@Controller("EamRepairGroupPageController")
@RequestMapping(RepairGroupPageController.prefix)
public class RepairGroupPageController extends ViewController {
	
	public static final String prefix="business/eam/repair_group";

	private RepairGroupServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public RepairGroupServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepairGroupServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 维修班组 功能主页面
	 */
	@RequestMapping("/repair_group_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/repair_group_list";
	}

	/**
	 * 维修班组 表单页面
	 */
	@RequestMapping("/repair_group_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/repair_group_form";
	}
}