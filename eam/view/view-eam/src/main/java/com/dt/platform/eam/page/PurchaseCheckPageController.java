package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.PurchaseCheckServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 采购验收 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-16 23:19:17
*/

@Controller("EamPurchaseCheckPageController")
@RequestMapping(PurchaseCheckPageController.prefix)
public class PurchaseCheckPageController extends ViewController {
	
	public static final String prefix="business/eam/purchase_check";

	private PurchaseCheckServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public PurchaseCheckServiceProxy proxy() {
		if(proxy==null) {
			proxy=PurchaseCheckServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 采购验收 功能主页面
	 */
	@RequestMapping("/purchase_check_list.html")
	public String list(Model model,HttpServletRequest request,String pageType) {
		model.addAttribute("pageType",pageType);
		return prefix+"/purchase_check_list";
	}

	/**
	 * 采购验收 表单页面
	 */
	@RequestMapping("/purchase_check_form.html")
	public String form(Model model,HttpServletRequest request , String id,String applyId) {
		model.addAttribute("applyId",applyId);
		return prefix+"/purchase_check_form";
	}
}