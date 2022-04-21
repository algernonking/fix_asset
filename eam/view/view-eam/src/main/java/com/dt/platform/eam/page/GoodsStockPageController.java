package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.AssetAttributeItem;
import com.dt.platform.proxy.eam.AssetAttributeItemServiceProxy;
import com.dt.platform.proxy.eam.AssetCategoryServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.GoodsStockServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 库存物品 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-20 20:41:09
*/

@Controller("EamGoodsStockPageController")
@RequestMapping(GoodsStockPageController.prefix)
public class GoodsStockPageController extends ViewController {
	
	public static final String prefix="business/eam/goods_stock";

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
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/goods_stock_list";
	}


	/**
	 * 库存物品 表单页面
	 */
	@RequestMapping("/goods_stock_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/goods_stock_form";
	}



	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_select_tree.html")
	public String selectTree(Model model,HttpServletRequest request,String ownerTmpId,String operType,String pageType,String ownerCode,String ownerType,String selectedCode) {

		Result idResult= AssetCategoryServiceProxy.api().queryNodesByCode(AssetCategoryCodeEnum.ASSET.code());
		model.addAttribute("categoryParentId",idResult.getData());

		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("ownerTmpId",ownerTmpId);
		model.addAttribute("operType",operType);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("pageType",pageType);
		model.addAttribute("selectedCode",selectedCode);

		return prefix+"/goods_stock_select_tree";
	}


	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_select_list.html")
	public String selectList(Model model,HttpServletRequest request,String ownerTmpId,String operType,String pageType,String ownerCode,String ownerType,String selectedCode) {



		if(AssetOperateEnum.EAM_ASSET_STOCK_GOODS_IN.code().equals(operType)){
			model.addAttribute("ownerCode",AssetStockGoodsOwnerEnum.GOODS.code());
		}else{
			model.addAttribute("ownerCode",ownerCode);
		}
		model.addAttribute("ownerTmpId",ownerTmpId);
		model.addAttribute("operType",operType);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("pageType",pageType);
		model.addAttribute("selectedCode",selectedCode);

		//model.addAttribute("multiple",multiple);
		return prefix + "/goods_stock_select_list";
	}

	/**
	 * 库存物品 功能主页面
	 */
	@RequestMapping("/goods_stock_selected_list.html")
	public String selectedList(Model model,HttpServletRequest request,String ownerTmpId,String operType,String pageType,String ownerCode,String ownerType,String selectedCode) {
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("ownerTmpId",ownerTmpId);
		model.addAttribute("operType",operType);
		model.addAttribute("ownerType",ownerType);
		model.addAttribute("pageType",pageType);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/goods_stock_selected_list";
	}



}