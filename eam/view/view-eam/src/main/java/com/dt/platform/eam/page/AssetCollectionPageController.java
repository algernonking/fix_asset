package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetCollectionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 资产领用 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-19 13:01:36
*/

@Controller("EamAssetCollectionPageController")
@RequestMapping(AssetCollectionPageController.prefix)
public class AssetCollectionPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_collection";

	private AssetCollectionServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetCollectionServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetCollectionServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 资产领用 功能主页面
	 */
	@RequestMapping("/asset_collection_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_collection_list";
	}

	/**
	 * 资产领用 表单页面
	 */
	@RequestMapping("/asset_collection_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_collection_form";
	}
}