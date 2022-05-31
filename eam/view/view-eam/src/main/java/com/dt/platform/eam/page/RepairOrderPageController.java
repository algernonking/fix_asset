package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.RepairOrderServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 维修工单 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 19:33:23
*/

@Controller("EamRepairOrderPageController")
@RequestMapping(RepairOrderPageController.prefix)
public class RepairOrderPageController extends ViewController {
	
	public static final String prefix="business/eam/repair_order";

	private RepairOrderServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public RepairOrderServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepairOrderServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 维修工单 功能主页面
	 */
	@RequestMapping("/repair_order_list.html")
	public String list(Model model,HttpServletRequest request) {
		boolean approvalRequired=true;
		Result approvalResult= OperateServiceProxy.api().approvalRequired(AssetOperateEnum.EAM_ASSET_REPAIR_ORDER.code());
		if(approvalResult.isSuccess()){
			approvalRequired= (boolean) approvalResult.getData();
		}
		model.addAttribute("approvalRequired",approvalRequired);
		return prefix+"/repair_order_list";
	}

	/**
	 * 维修工单 表单页面
	 */
	@RequestMapping("/repair_order_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		model.addAttribute("billId",id);
		model.addAttribute("billType", AssetOperateEnum.EAM_ASSET_REPAIR_ORDER.code());
		return prefix+"/repair_order_form";
	}
}