package com.dt.platform.eam.page;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.AssetAttributeItemOwnerEnum;
import com.dt.platform.constants.enums.eam.AssetCategoryCodeEnum;
import com.dt.platform.domain.eam.AssetAttributeItem;
import com.dt.platform.domain.eam.AssetAttributeItemVO;
import com.dt.platform.proxy.eam.AssetAttributeItemServiceProxy;
import com.dt.platform.proxy.eam.AssetCategoryServiceProxy;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 资产 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-07 16:11:51
*/

@Controller("EAMAssetReportPageController")
@RequestMapping(AssetReportPageController.prefix)
public class AssetReportPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_report";

	private AssetServiceProxy proxy;


	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetServiceProxy.api();
		}
		return proxy;
	}


	/**
	 * 资产分类查询数据
	 */
	@RequestMapping("/category_report_list.html")
	public String categoryReportList(Model model,HttpServletRequest request , String id) {

		return prefix+"/category_report_list";
	}

	/**
	 * 资产分类查询数据
	 */
	@RequestMapping("/company_status_report_list.html")
	public String companyStatusReportList(Model model,HttpServletRequest request , String id) {

		return prefix+"/company_status_report_list";
	}


	/**
	 * 资产分类查询数据
	 */
	@RequestMapping("/category_status_report_list.html")
	public String categoryStatusReportList(Model model,HttpServletRequest request , String id) {

		return prefix+"/category_status_report_list";
	}


	/**
	 * 资产组织查询数据
	 */
	@RequestMapping("/org_report_list.html")
	public String orgReportList(Model model,HttpServletRequest request , String id) {

		return prefix+"/org_report_list";
	}


	/**
	 * 资产dashboard
	 */
	@RequestMapping("/report_dashboard.html")
	public String reportDashboard(Model model,HttpServletRequest request , String tenantId) {

		model.addAttribute("tenantId",tenantId);
		return prefix+"/report_dashboard";
	}



	/**
	 * 资产对帐表
	 */
	@RequestMapping("/asset_insert_month.html")
	public String searchList(Model model,HttpServletRequest request) {


		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_BOOK.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}
		return prefix+"/asset_insert_month";
	}




}