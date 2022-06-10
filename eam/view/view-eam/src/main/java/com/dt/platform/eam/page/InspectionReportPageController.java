package com.dt.platform.eam.page;

import com.dt.platform.proxy.eam.InspectionPlanServiceProxy;
import com.dt.platform.proxy.eam.InspectionReportServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 巡检计划 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-06 21:18:33
*/

@Controller("InspectionReportPageController")
@RequestMapping(InspectionReportPageController.prefix)
public class InspectionReportPageController extends ViewController {
	
	public static final String prefix="business/eam/inspection_report";

	private InspectionReportServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InspectionReportServiceProxy proxy() {
		if(proxy==null) {
			proxy=InspectionReportServiceProxy.api();
		}
		return proxy;
	}


	@RequestMapping("/inspection_point_report_list.html")
	public String inspectionPointReport(Model model,HttpServletRequest request) {
		return prefix+"/inspection_point_report_list";
	}



}