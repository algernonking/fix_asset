package com.dt.platform.eam.page;

import com.dt.platform.proxy.eam.GoodsStockServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 库存物品 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 20:41:09
*/

@Controller("EamGoodsStockGoodsPageController")
@RequestMapping(GoodsStockGoodsPageController.prefix)
public class GoodsStockGoodsPageController extends ViewController {
	
	public static final String prefix="business/eam/goods_stock_goods";

	private GoodsStockServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public GoodsStockServiceProxy proxy() {
		if(proxy==null) {
			proxy=GoodsStockServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_list.html")
	public String list(Model model,HttpServletRequest request,String ownerCode,String ownerType) {

		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("ownerType",ownerType);
		return prefix+"/goods_stock_list";
	}


	/**
	 * 库存物品 表单页面
	 */
	@RequestMapping("/goods_stock_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerCode,String ownerType) {


		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("ownerType",ownerType);


		return prefix+"/goods_stock_form";
	}


}