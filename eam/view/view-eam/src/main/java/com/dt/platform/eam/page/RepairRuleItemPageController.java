package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RepairRuleItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 规则单 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 07:24:13
*/

@Controller("EamRepairRuleItemPageController")
@RequestMapping(RepairRuleItemPageController.prefix)
public class RepairRuleItemPageController extends ViewController {
	
	public static final String prefix="business/eam/repair_rule_item";

	private RepairRuleItemServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public RepairRuleItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepairRuleItemServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 规则单 功能主页面
	 */
	@RequestMapping("/repair_rule_item_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/repair_rule_item_list";
	}

	/**
	 * 规则单 表单页面
	 */
	@RequestMapping("/repair_rule_item_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/repair_rule_item_form";
	}
}