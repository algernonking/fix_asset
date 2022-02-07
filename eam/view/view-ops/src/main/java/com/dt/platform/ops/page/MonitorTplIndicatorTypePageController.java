package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.MonitorTplIndicatorTypeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 指标类型 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-03 19:08:16
*/

@Controller("OpsMonitorTplIndicatorTypePageController")
@RequestMapping(MonitorTplIndicatorTypePageController.prefix)
public class MonitorTplIndicatorTypePageController extends ViewController {
	
	public static final String prefix="business/ops/monitor_tpl_indicator_type";

	private MonitorTplIndicatorTypeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MonitorTplIndicatorTypeServiceProxy proxy() {
		if(proxy==null) {
			proxy=MonitorTplIndicatorTypeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 指标类型 功能主页面
	 */
	@RequestMapping("/monitor_tpl_indicator_type_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/monitor_tpl_indicator_type_list";
	}

	/**
	 * 指标类型 表单页面
	 */
	@RequestMapping("/monitor_tpl_indicator_type_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/monitor_tpl_indicator_type_form";
	}
}