package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.MonitorNodeTplItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 节点监控模版 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:55
*/

@Controller("OpsMonitorNodeTplItemPageController")
@RequestMapping(MonitorNodeTplItemPageController.prefix)
public class MonitorNodeTplItemPageController extends ViewController {
	
	public static final String prefix="business/ops/monitor_node_tpl_item";

	private MonitorNodeTplItemServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MonitorNodeTplItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=MonitorNodeTplItemServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 节点监控模版 功能主页面
	 */
	@RequestMapping("/monitor_node_tpl_item_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/monitor_node_tpl_item_list";
	}

	/**
	 * 节点监控模版 表单页面
	 */
	@RequestMapping("/monitor_node_tpl_item_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/monitor_node_tpl_item_form";
	}
}