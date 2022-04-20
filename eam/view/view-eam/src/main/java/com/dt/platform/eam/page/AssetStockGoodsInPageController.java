package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetStockGoodsInServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 库存物品单 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 13:37:42
*/

@Controller("EamAssetStockGoodsInPageController")
@RequestMapping(AssetStockGoodsInPageController.prefix)
public class AssetStockGoodsInPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_stock_goods_in";

	private AssetStockGoodsInServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetStockGoodsInServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetStockGoodsInServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 库存物品单 功能主页面
	 */
	@RequestMapping("/asset_stock_goods_in_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_stock_goods_in_list";
	}

	/**
	 * 库存物品单 表单页面
	 */
	@RequestMapping("/asset_stock_goods_in_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_stock_goods_in_form";
	}
}