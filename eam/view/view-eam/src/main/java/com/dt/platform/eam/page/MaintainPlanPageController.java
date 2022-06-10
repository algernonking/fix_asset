package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.MaintainPlanServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 保养方案 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-05 09:51:44
*/

@Controller("EamMaintainPlanPageController")
@RequestMapping(MaintainPlanPageController.prefix)
public class MaintainPlanPageController extends ViewController {
	
	public static final String prefix="business/eam/maintain_plan";

	private MaintainPlanServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MaintainPlanServiceProxy proxy() {
		if(proxy==null) {
			proxy=MaintainPlanServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 保养方案 功能主页面
	 */
	@RequestMapping("/maintain_plan_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/maintain_plan_list";
	}

	/**
	 * 保养方案 表单页面
	 */
	@RequestMapping("/maintain_plan_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		model.addAttribute("billId",id);
		model.addAttribute("billType", AssetOperateEnum.EAM_ASSET_MAINTAIN_PLAN.code());
		return prefix+"/maintain_plan_form";
	}
}