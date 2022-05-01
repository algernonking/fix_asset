package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetStockGoodsOwnerEnum;
import com.dt.platform.constants.enums.eam.AssetStockGoodsTypeEnum;
import com.dt.platform.constants.enums.eam.AssetStockTypeEnum;
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

@Controller("GoodsStockRealPageController")
@RequestMapping(GoodsStockRealPageController.prefix)
public class GoodsStockRealPageController extends ViewController {
	
	public static final String prefix="business/eam/goods_stock_real";

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
	public String list(Model model,HttpServletRequest request,String ownerType) {

		String ownerCode="blank";
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(ownerType)){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_STOCK.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(ownerType)){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_CONSUMABLES.code();
		}else if(AssetStockGoodsTypeEnum.PART.code().equals(ownerType)){
			ownerCode=AssetStockGoodsOwnerEnum.REAL_PART.code();
		}
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("ownerCode",ownerCode);

		return prefix+"/goods_stock_list";
	}




}