package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetDataPermissionsPositionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 位置 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-12-17 09:15:33
*/

@Controller("EamAssetDataPermissionsPositionPageController")
@RequestMapping(AssetDataPermissionsPositionPageController.prefix)
public class AssetDataPermissionsPositionPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_data_permissions_position";

	private AssetDataPermissionsPositionServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetDataPermissionsPositionServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetDataPermissionsPositionServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 位置 功能主页面
	 */
	@RequestMapping("/asset_data_permissions_position_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_data_permissions_position_list";
	}

	/**
	 * 位置 表单页面
	 */
	@RequestMapping("/asset_data_permissions_position_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_data_permissions_position_form";
	}
}