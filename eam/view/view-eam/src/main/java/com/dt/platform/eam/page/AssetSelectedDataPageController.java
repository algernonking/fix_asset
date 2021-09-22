package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetSelectedDataServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 资产选择 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 19:01:00
*/

@Controller("EamAssetSelectedDataPageController")
@RequestMapping(AssetSelectedDataPageController.prefix)
public class AssetSelectedDataPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_selected_data";

	private AssetSelectedDataServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetSelectedDataServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetSelectedDataServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 资产选择 功能主页面
	 */
	@RequestMapping("/asset_selected_data_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_selected_data_list";
	}

	/**
	 * 资产选择 表单页面
	 */
	@RequestMapping("/asset_selected_data_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_selected_data_form";
	}
}