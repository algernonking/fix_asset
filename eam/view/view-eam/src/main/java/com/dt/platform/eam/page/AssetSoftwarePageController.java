package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetCategoryCodeEnum;
import com.dt.platform.constants.enums.eam.AssetCategoryTypeEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetSoftwareServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 软件资产 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-04 19:59:02
*/

@Controller("EamAssetSoftwarePageController")
@RequestMapping(AssetSoftwarePageController.prefix)
public class AssetSoftwarePageController extends ViewController {
	
	public static final String prefix="business/eam/asset_software";

	private AssetSoftwareServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetSoftwareServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetSoftwareServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 软件资产 功能主页面
	 */
	@RequestMapping("/asset_software_list.html")
	public String list(Model model,HttpServletRequest request) {

		boolean approvalRequired=true;
		Result approvalResult= OperateServiceProxy.api().approvalRequired(AssetOperateEnum.EAM_ASSET_SOFTWARE_INSERT.code());
		if(approvalResult.isSuccess()){
			approvalRequired= (boolean) approvalResult.getData();
		}
		model.addAttribute("approvalRequired",approvalRequired);
		return prefix+"/asset_software_list";
	}

	/**
	 * 软件资产 表单页面
	 */
	@RequestMapping("/asset_software_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		boolean approvalRequired=true;
		Result approvalResult= OperateServiceProxy.api().approvalRequired(AssetOperateEnum.EAM_ASSET_SOFTWARE_DISTRIBUTE.code());
		if(approvalResult.isSuccess()){
			approvalRequired= (boolean) approvalResult.getData();
		}


		//设置资产分类
		CatalogVO catalog=new CatalogVO();
		String categoryCode= AssetCategoryTypeEnum.ASSET_SOFTWARE.code();
		catalog.setCode(categoryCode);
		Result<List<Catalog>> catalogListResult= CatalogServiceProxy.api().queryList(catalog);
		String categoryId="";
		if(catalogListResult.isSuccess()){
			List<Catalog> catalogList=catalogListResult.getData();
			if(catalogList.size()>0){
				categoryId=catalogList.get(0).getId();
				CatalogVO catalog2=new CatalogVO();
				catalog2.setParentId(categoryId);
				catalog2.setIsLoadAllDescendants(1);
				Result<List<ZTreeNode>> treeResult=CatalogServiceProxy.api().queryNodes(catalog2);
				model.addAttribute("assetCategoryData",treeResult.getData());
			}
		}
		//AssetCategoryTypeEnum
		model.addAttribute("approvalRequired",approvalRequired);

		return prefix+"/asset_software_form";
	}
}