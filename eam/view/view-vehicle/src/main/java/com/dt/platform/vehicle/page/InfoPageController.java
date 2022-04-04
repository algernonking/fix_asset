package com.dt.platform.vehicle.page;


import com.alibaba.fastjson.JSONArray;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;
import com.dt.platform.proxy.vehicle.InfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 车辆信息 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 17:59:08
*/

@Controller("VehicleInfoPageController")
@RequestMapping(InfoPageController.prefix)
public class InfoPageController extends ViewController {
	
	public static final String prefix="business/vehicle/info";

	private InfoServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public InfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=InfoServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 车辆信息 功能主页面
	 */
	@RequestMapping("/info_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/info_list";
	}


	/**
	 * 车辆信息 功能主页面
	 */
	@RequestMapping("/select_info_list.html")
	public String selectInfoList(Model model,HttpServletRequest request,String ids,String type) {
		JSONArray idsArr=new JSONArray();
		if(!StringUtil.isBlank(ids)){
			String[] idsStrArr=ids.split(",");
			for(int i=0;i<idsStrArr.length;i++){
				idsArr.add(idsStrArr[i]);
			}
		}
		model.addAttribute("ids",idsArr);
		model.addAttribute("type",type);
		return prefix+"/select_info_list";
	}


	/**
	 * 车辆信息 功能主页面
	 */
	@RequestMapping("/selected_info_list.html")
	public String selectedInfoList(Model model,HttpServletRequest request,String ids,String type,String action) {
		JSONArray idsArr=new JSONArray();
		if(!StringUtil.isBlank(ids)){
			String[] idsStrArr=ids.split(",");
			for(int i=0;i<idsStrArr.length;i++){
				idsArr.add(idsStrArr[i]);
			}
		}
		model.addAttribute("ids",idsArr);
		model.addAttribute("type",type);
		model.addAttribute("action",action);
		return prefix+"/selected_info_list";
	}

	/**
	 * 车辆信息 表单页面
	 */
	@RequestMapping("/info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/info_form";
	}
}