package com.dt.platform.knowledgebase.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.knowledgebase.GradeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 知识分级 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-14 17:46:20
*/

@Controller("KnGradePageController")
@RequestMapping(GradePageController.prefix)
public class GradePageController extends ViewController {
	
	public static final String prefix="business/knowledgebase/grade";

	private GradeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public GradeServiceProxy proxy() {
		if(proxy==null) {
			proxy=GradeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 知识分级 功能主页面
	 */
	@RequestMapping("/grade_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/grade_list";
	}

	/**
	 * 知识分级 表单页面
	 */
	@RequestMapping("/grade_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/grade_form";
	}
}