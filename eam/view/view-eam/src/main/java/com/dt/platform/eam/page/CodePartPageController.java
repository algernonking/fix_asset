package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CodePartServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 编码字段 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 21:06:36
*/

@Controller("EamCodePartPageController")
@RequestMapping(CodePartPageController.prefix)
public class CodePartPageController extends ViewController {
	
	public static final String prefix="business/eam/code_part";

	private CodePartServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CodePartServiceProxy proxy() {
		if(proxy==null) {
			proxy=CodePartServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 编码字段 功能主页面
	 */
	@RequestMapping("/code_part_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/code_part_list";
	}

	/**
	 * 编码字段 表单页面
	 */
	@RequestMapping("/code_part_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/code_part_form";
	}
}