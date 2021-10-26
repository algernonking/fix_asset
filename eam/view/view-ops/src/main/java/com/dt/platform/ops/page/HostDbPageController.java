package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.HostDbServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 数据库 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:28:28
*/

@Controller("OpsHostDbPageController")
@RequestMapping(HostDbPageController.prefix)
public class HostDbPageController extends ViewController {
	
	public static final String prefix="business/ops/host_db";

	private HostDbServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public HostDbServiceProxy proxy() {
		if(proxy==null) {
			proxy=HostDbServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 数据库 功能主页面
	 */
	@RequestMapping("/host_db_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/host_db_list";
	}

	/**
	 * 数据库 表单页面
	 */
	@RequestMapping("/host_db_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/host_db_form";
	}
}