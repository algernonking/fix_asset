package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.MaintainProjectServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 保养项目 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-06 21:12:01
*/

@Controller("EamMaintainProjectPageController")
@RequestMapping(MaintainProjectPageController.prefix)
public class MaintainProjectPageController extends ViewController {
	
	public static final String prefix="business/eam/maintain_project";

	private MaintainProjectServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MaintainProjectServiceProxy proxy() {
		if(proxy==null) {
			proxy=MaintainProjectServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 保养项目 功能主页面
	 */
	@RequestMapping("/maintain_project_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/maintain_project_list";
	}

	/**
	 * 保养项目 功能主页面
	 */
	@RequestMapping("/maintain_project_selected_exec_list.html")
	public String selectedExecList(Model model,HttpServletRequest request,String selectedCode,String ownerId,String ownerType,String pageType) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("selectedCode",selectedCode);
		model.addAttribute("pageType",pageType);
		return prefix+"/maintain_project_selected_exec_list";
	}



	/**
	 * 保养项目 功能主页面
	 */
	@RequestMapping("/maintain_project_selected_list.html")
	public String selectedList(Model model,HttpServletRequest request,String selectedCode,String ownerId,String ownerType,String pageType) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("selectedCode",selectedCode);
		model.addAttribute("pageType",pageType);
		return prefix+"/maintain_project_selected_list";
	}

	/**
	 * 保养项目 功能主页面
	 */
	@RequestMapping("/maintain_project_select_list.html")
	public String selectList(Model model,HttpServletRequest request,String selectedCode,String ownerId,String ownerType) {
		model.addAttribute("ownerId",ownerId);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/maintain_project_select_list";
	}
	/**
	 * 保养项目 表单页面
	 */
	@RequestMapping("/maintain_project_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/maintain_project_form";
	}
}