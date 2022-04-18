package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.PurchaseOrderServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 采购订单 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-16 07:45:23
*/

@Controller("EamPurchaseOrderPageController")
@RequestMapping(PurchaseOrderPageController.prefix)
public class PurchaseOrderPageController extends ViewController {
	
	public static final String prefix="business/eam/purchase_order";

	private PurchaseOrderServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public PurchaseOrderServiceProxy proxy() {
		if(proxy==null) {
			proxy=PurchaseOrderServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 采购订单 功能主页面
	 */
	@RequestMapping("/purchase_order_list.html")
	public String list(Model model,HttpServletRequest request,String pageType,String applyId,String selectedCode) {
		model.addAttribute("pageType",pageType);
		model.addAttribute("applyId",applyId);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/purchase_order_list";

	}

	/**
	 * 采购订单 表单页面
	 */
	@RequestMapping("/purchase_order_form.html")
	public String form(Model model,HttpServletRequest request , String id,String applyId,String selectedCode) {
		model.addAttribute("applyId",applyId);
		model.addAttribute("selectedCode",selectedCode);
		return prefix+"/purchase_order_form";
	}
}