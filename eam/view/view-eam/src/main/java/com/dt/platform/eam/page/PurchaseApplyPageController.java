package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.PurchaseApplyServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 采购申请 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-16 22:09:37
*/

@Controller("EamPurchaseApplyPageController")
@RequestMapping(PurchaseApplyPageController.prefix)
public class PurchaseApplyPageController extends ViewController {
	
	public static final String prefix="business/eam/purchase_apply";

	private PurchaseApplyServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public PurchaseApplyServiceProxy proxy() {
		if(proxy==null) {
			proxy=PurchaseApplyServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 采购申请 功能主页面
	 */
	@RequestMapping("/purchase_apply_list.html")
	public String list(Model model,HttpServletRequest request) {
		boolean approvalRequired=true;
		Result approvalResult= OperateServiceProxy.api().approvalRequired(AssetOperateEnum.EAM_ASSET_PURCHASE_APPLY.code());
		if(approvalResult.isSuccess()){
			approvalRequired= (boolean) approvalResult.getData();
		}
		model.addAttribute("approvalRequired",approvalRequired);
		return prefix+"/purchase_apply_list";
	}

	/**
	 * 采购申请 表单页面
	 */
	@RequestMapping("/purchase_apply_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/purchase_apply_form";
	}
}