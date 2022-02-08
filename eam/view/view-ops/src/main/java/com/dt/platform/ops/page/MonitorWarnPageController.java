package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.MonitorWarnServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 节点告警 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:57
*/

@Controller("OpsMonitorWarnPageController")
@RequestMapping(MonitorWarnPageController.prefix)
public class MonitorWarnPageController extends ViewController {
	
	public static final String prefix="business/ops/monitor_warn";

	private MonitorWarnServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MonitorWarnServiceProxy proxy() {
		if(proxy==null) {
			proxy=MonitorWarnServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 节点告警 功能主页面
	 */
	@RequestMapping("/monitor_warn_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/monitor_warn_list";
	}

	/**
	 * 节点告警 表单页面
	 */
	@RequestMapping("/monitor_warn_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/monitor_warn_form";
	}
}