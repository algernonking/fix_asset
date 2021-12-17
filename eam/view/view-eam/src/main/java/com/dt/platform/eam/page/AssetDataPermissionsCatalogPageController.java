package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetDataPermissionsCatalogServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 分类 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-12-16 15:22:58
*/

@Controller("EamAssetDataPermissionsCatalogPageController")
@RequestMapping(AssetDataPermissionsCatalogPageController.prefix)
public class AssetDataPermissionsCatalogPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_data_permissions_catalog";

	private AssetDataPermissionsCatalogServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetDataPermissionsCatalogServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetDataPermissionsCatalogServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 分类 功能主页面
	 */
	@RequestMapping("/asset_data_permissions_catalog_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_data_permissions_catalog_list";
	}

	/**
	 * 分类 表单页面
	 */
	@RequestMapping("/asset_data_permissions_catalog_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_data_permissions_catalog_form";
	}
}