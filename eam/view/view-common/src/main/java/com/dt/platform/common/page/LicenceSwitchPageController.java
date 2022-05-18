package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.LicenceSwitchServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 版本切换 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-16 17:15:10
*/

@Controller("SysLicenceSwitchPageController")
@RequestMapping(LicenceSwitchPageController.prefix)
public class LicenceSwitchPageController extends ViewController {
	
	public static final String prefix="business/common/licence_switch";

	private LicenceSwitchServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public LicenceSwitchServiceProxy proxy() {
		if(proxy==null) {
			proxy=LicenceSwitchServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 版本切换 功能主页面
	 */
	@RequestMapping("/licence_switch_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/licence_switch_list";
	}

	/**
	 * 版本切换 表单页面
	 */
	@RequestMapping("/licence_switch_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/licence_switch_form";
	}
}