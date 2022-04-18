package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetAttributeItemOwnerEnum;
import com.dt.platform.constants.enums.eam.AssetCategoryCodeEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.AssetOwnerCodeEnum;
import com.dt.platform.domain.eam.AssetAttributeItem;
import com.dt.platform.proxy.eam.AssetAttributeItemServiceProxy;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetStockDeliverServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 库存出库 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-17 19:24:30
*/

@Controller("EamAssetStockDeliverPageController")
@RequestMapping(AssetStockDeliverPageController.prefix)
public class AssetStockDeliverPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_stock_deliver";

	private AssetStockDeliverServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetStockDeliverServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetStockDeliverServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 库存出库 功能主页面
	 */
	@RequestMapping("/asset_stock_deliver_list.html")
	public String list(Model model,HttpServletRequest request,String ownerCode,String type) {
		boolean approvalRequired=true;
		Result approvalResult= OperateServiceProxy.api().approvalRequired(AssetOperateEnum.EAM_ASSET_CONSUMABLES_COLLECTION.code());
		if(approvalResult.isSuccess()){
			approvalRequired= (boolean) approvalResult.getData();
		}
		model.addAttribute("approvalRequired",approvalRequired);

		model.addAttribute("forApprovalBtn", SessionUser.getCurrent().permission().checkAuth(type+":for-approval" ) );
		model.addAttribute("confirmDataBtn",SessionUser.getCurrent().permission().checkAuth(type+":confirm"));
		model.addAttribute("revokeDataBtn",SessionUser.getCurrent().permission().checkAuth(type+":revoke" ));
		model.addAttribute("billBtn",SessionUser.getCurrent().permission().checkAuth(type+":bill") );
		model.addAttribute("createBtn",SessionUser.getCurrent().permission().checkAuth(type+":create") );
		model.addAttribute("modifyBtn",SessionUser.getCurrent().permission().checkAuth(type+":update") );
		model.addAttribute("deleteBtn",SessionUser.getCurrent().permission().checkAuth(type+":delete") );
		model.addAttribute("viewBtn",SessionUser.getCurrent().permission().checkAuth(type+":query") );

		model.addAttribute("ownerCode",ownerCode);

		return prefix+"/asset_stock_deliver_list";
	}

	/**
	 * 库存出库 表单页面
	 */
	@RequestMapping("/asset_stock_deliver_form.html")
	public String form(Model model,HttpServletRequest request ,String id,String ownerCode) {
		model.addAttribute("billId",id);
		model.addAttribute("billType", AssetOperateEnum.EAM_ASSET_STOCK_DELIVER.code());
		model.addAttribute("ownerCode",ownerCode);
		return prefix+"/asset_stock_deliver_form";
	}
}