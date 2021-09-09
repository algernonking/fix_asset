package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.TplFileServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 模板文件 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-09 12:26:05
*/

@Controller("EamTplFilePageController")
@RequestMapping(TplFilePageController.prefix)
public class TplFilePageController extends ViewController {
	
	public static final String prefix="business/eam/tpl_file";

	private TplFileServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public TplFileServiceProxy proxy() {
		if(proxy==null) {
			proxy=TplFileServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 模板文件 功能主页面
	 */
	@RequestMapping("/tpl_file_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/tpl_file_list";
	}

	/**
	 * 模板文件 表单页面
	 */
	@RequestMapping("/tpl_file_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/tpl_file_form";
	}
}