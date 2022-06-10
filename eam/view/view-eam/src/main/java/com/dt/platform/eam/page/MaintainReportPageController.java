package com.dt.platform.eam.page;

import com.dt.platform.proxy.eam.MaintainGroupServiceProxy;
import com.dt.platform.proxy.eam.MaintainReportServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 保养班组 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 19:20:57
*/

@Controller("MaintainReportPageController")
@RequestMapping(MaintainReportPageController.prefix)
public class MaintainReportPageController extends ViewController {
	
	public static final String prefix="business/eam/maintain_report";

	private MaintainReportServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MaintainReportServiceProxy proxy() {
		if(proxy==null) {
			proxy=MaintainReportServiceProxy.api();
		}
		return proxy;
	}

	@RequestMapping("/maintain_item_report_list.html")
	public String maintainItemReport(Model model,HttpServletRequest request) {
		return prefix+"/maintain_item_report_list";
	}



}