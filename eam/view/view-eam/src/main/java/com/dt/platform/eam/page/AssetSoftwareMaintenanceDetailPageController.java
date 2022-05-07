package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetSoftwareMaintenanceDetailServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 软件维保明细 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 06:34:37
*/

@Controller("EamAssetSoftwareMaintenanceDetailPageController")
@RequestMapping(AssetSoftwareMaintenanceDetailPageController.prefix)
public class AssetSoftwareMaintenanceDetailPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_software_maintenance_detail";

	private AssetSoftwareMaintenanceDetailServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetSoftwareMaintenanceDetailServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetSoftwareMaintenanceDetailServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 软件维保明细 功能主页面
	 */
	@RequestMapping("/asset_software_maintenance_detail_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_software_maintenance_detail_list";
	}

	/**
	 * 软件维保明细 表单页面
	 */
	@RequestMapping("/asset_software_maintenance_detail_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_software_maintenance_detail_form";
	}
}