package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetAttributeItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 资产字段配置项 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-10 16:42:44
*/

@Controller("EamAssetAttributeItemPageController")
@RequestMapping(AssetAttributeItemPageController.prefix)
public class AssetAttributeItemPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_attribute_item";

	private AssetAttributeItemServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetAttributeItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetAttributeItemServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 资产字段配置项 功能主页面
	 */
	@RequestMapping("/asset_attribute_item_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_attribute_item_list";
	}

	/**
	 * 资产字段配置项 表单页面
	 */
	@RequestMapping("/asset_attribute_item_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_attribute_item_form";
	}
}