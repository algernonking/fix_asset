package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.BaseStationServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * rfid基站 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-03 15:24:08
*/

@Controller("RfidBaseStationPageController")
@RequestMapping(BaseStationPageController.prefix)
public class BaseStationPageController extends ViewController {
	
	public static final String prefix="business/eam/base_station";

	private BaseStationServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public BaseStationServiceProxy proxy() {
		if(proxy==null) {
			proxy=BaseStationServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * rfid基站 功能主页面
	 */
	@RequestMapping("/base_station_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/base_station_list";
	}

	/**
	 * rfid基站 表单页面
	 */
	@RequestMapping("/base_station_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/base_station_form";
	}
}