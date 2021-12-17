package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetCategoryCodeEnum;
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
import com.dt.platform.proxy.eam.AssetDataPermissionsServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 资产数据权限 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-12-17 09:20:41
*/

@Controller("EamAssetDataPermissionsPageController")
@RequestMapping(AssetDataPermissionsPageController.prefix)
public class AssetDataPermissionsPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_data_permissions";

	private AssetDataPermissionsServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetDataPermissionsServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetDataPermissionsServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 资产数据权限 功能主页面
	 */
	@RequestMapping("/asset_data_permissions_list.html")
	public String list(Model model,HttpServletRequest request,String categoryCode) {

		model.addAttribute("categoryCode",categoryCode);


		return prefix+"/asset_data_permissions_list";
	}

	/**
	 * 资产数据权限 表单页面
	 */
	@RequestMapping("/asset_data_permissions_form.html")
	public String form(Model model,HttpServletRequest request , String id,String categoryCode) {
		//设置资产分类
		CatalogVO catalog=new CatalogVO();
		if(StringUtil.isBlank(categoryCode)||"null".equals(categoryCode.toLowerCase())){
			catalog.setCode(AssetCategoryCodeEnum.ASSET.code());
		}else{
			catalog.setCode(categoryCode);
		}
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
		return prefix+"/asset_data_permissions_form";
	}
}