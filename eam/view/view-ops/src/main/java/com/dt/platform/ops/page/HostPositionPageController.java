package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.HostPositionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 主机位置 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-18 14:02:16
*/

@Controller("OpsHostPositionPageController")
@RequestMapping(HostPositionPageController.prefix)
public class HostPositionPageController extends ViewController {
	
	public static final String prefix="business/ops/host_position";

	private HostPositionServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public HostPositionServiceProxy proxy() {
		if(proxy==null) {
			proxy=HostPositionServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 主机位置 功能主页面
	 */
	@RequestMapping("/host_position_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/host_position_list";
	}

	/**
	 * 主机位置 表单页面
	 */
	@RequestMapping("/host_position_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/host_position_form";
	}
}