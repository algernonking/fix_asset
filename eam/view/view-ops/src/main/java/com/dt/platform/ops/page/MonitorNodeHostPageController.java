package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.MonitorNodeHostServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 节点主机 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:45
*/

@Controller("OpsMonitorNodeHostPageController")
@RequestMapping(MonitorNodeHostPageController.prefix)
public class MonitorNodeHostPageController extends ViewController {
	
	public static final String prefix="business/ops/monitor_node_host";

	private MonitorNodeHostServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MonitorNodeHostServiceProxy proxy() {
		if(proxy==null) {
			proxy=MonitorNodeHostServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 节点主机 功能主页面
	 */
	@RequestMapping("/monitor_node_host_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/monitor_node_host_list";
	}

	/**
	 * 节点主机 表单页面
	 */
	@RequestMapping("/monitor_node_host_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/monitor_node_host_form";
	}
}