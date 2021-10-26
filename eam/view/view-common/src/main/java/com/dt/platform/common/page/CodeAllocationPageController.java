package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.CodeAllocationServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 编码分配 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:26:32
*/

@Controller("SysCodeAllocationPageController")
@RequestMapping(CodeAllocationPageController.prefix)
public class CodeAllocationPageController extends ViewController {
	
	public static final String prefix="business/common/code_allocation";

	private CodeAllocationServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CodeAllocationServiceProxy proxy() {
		if(proxy==null) {
			proxy=CodeAllocationServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 编码分配 功能主页面
	 */
	@RequestMapping("/code_allocation_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/code_allocation_list";
	}

	/**
	 * 编码分配 表单页面
	 */
	@RequestMapping("/code_allocation_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/code_allocation_form";
	}
}