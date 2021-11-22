package com.dt.platform.eam.page;

import com.dt.platform.proxy.eam.AssetDataChangeServiceProxy;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.aspect.PageHelper;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.StockServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 资产库存 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-22 13:52:28
*/

@Controller("EamStockPageController")
@RequestMapping(StockPageController.prefix)
public class StockPageController extends ViewController {
	
	public static final String prefix="business/eam/stock";

	private StockServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public StockServiceProxy proxy() {
		if(proxy==null) {
			proxy=StockServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 资产库存 功能主页面
	 */
	@RequestMapping("/stock_list.html")
	public String list(Model model,HttpServletRequest request,String ownerCode,String stockType,String operType) {

		String authPrefix="eam_"+ownerCode;
		model.addAttribute("forApprovalBtn", SessionUser.getCurrent().permission().checkAuth(authPrefix+":for-approval" ) );
		model.addAttribute("confirmDataBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":confirm"));
		model.addAttribute("revokeDataBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":revoke" ));
		model.addAttribute("agreeBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":agree") );
		model.addAttribute("denyBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":deny"));

		model.addAttribute("stockViewFormBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":view-form"));
		model.addAttribute("stockCreateBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":create") );
		model.addAttribute("stockModifyBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":update") );
		model.addAttribute("stockDeleteBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":delete") );
		model.addAttribute("stockQueryBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":query") );

		model.addAttribute("stockExportBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":export") );
		model.addAttribute("stockImportBtn",SessionUser.getCurrent().permission().checkAuth(authPrefix+":import") );

		//审批
		boolean approvalRequired=true;
		Result approvalResult= OperateServiceProxy.api().approvalRequired(operType);
		if(approvalResult.isSuccess()){
			approvalRequired= (boolean) approvalResult.getData();
		}
		model.addAttribute("approvalRequired",approvalRequired);

		model.addAttribute("authPrefix",authPrefix);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("stockType",stockType);
		model.addAttribute("operType",operType);


		//表格显示
		PageHelper p=new PageHelper(request, SessionUser.getCurrent());
		model.addAttribute("layuiTableWidthConfig",p.getTableColumnWidthConfig("dt"+ownerCode+stockType+approvalRequired));
		model.addAttribute("tableId","dt"+ownerCode+stockType+approvalRequired);


		return prefix+"/stock_list";
	}

	/**
	 * 资产库存 表单页面
	 */
	@RequestMapping("/stock_form.html")
	public String form(Model model,HttpServletRequest request , String id,String ownerCode,String stockType) {

		String authPrefix="eam_"+ownerCode;
		model.addAttribute("authPrefix",authPrefix);
		model.addAttribute("ownerCode",ownerCode);
		model.addAttribute("stockType",stockType);



		return prefix+"/stock_form";
	}
}