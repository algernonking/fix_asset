package com.dt.platform.eam.page;

import com.dt.platform.proxy.eam.RepairGroupServiceProxy;
import com.dt.platform.proxy.eam.RepairReportServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 维修班组 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 12:58:15
*/

@Controller("RepairReportPageController")
@RequestMapping(RepairReportPageController.prefix)
public class RepairReportPageController extends ViewController {
	
	public static final String prefix="business/eam/repair_report";
	private RepairReportServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public RepairReportServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepairReportServiceProxy.api();
		}
		return proxy;
	}

	@RequestMapping("/group_report_list.html")
	public String groupReportList(Model model,HttpServletRequest request) {
		return prefix+"/group_report_list";
	}

}