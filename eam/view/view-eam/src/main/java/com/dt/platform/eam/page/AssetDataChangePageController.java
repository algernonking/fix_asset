package com.dt.platform.eam.page;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.AssetAttributeDimensionEnum;
import com.dt.platform.constants.enums.eam.AssetAttributeItemOwnerEnum;
import com.dt.platform.constants.enums.eam.AssetChangeTypeEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.AssetAttributeItem;
import com.dt.platform.domain.eam.AssetAttributeItemVO;
import com.dt.platform.proxy.eam.AssetAttributeItemServiceProxy;
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.pcm.CatalogVO;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetDataChangeServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 数据变更 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-08 16:01:29
*/

@Controller("EamAssetDataChangePageController")
@RequestMapping(AssetDataChangePageController.prefix)
public class AssetDataChangePageController extends ViewController {
	
	public static final String prefix="business/eam/asset_data_change";

	private AssetDataChangeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetDataChangeServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetDataChangeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 数据变更 功能主页面
	 */
	@RequestMapping("/asset_data_change_list.html")
	public String list(Model model,HttpServletRequest request,String changeType,String pageType) {
		boolean approvalRequired=true;
		Result approvalResult= OperateServiceProxy.api().approvalRequired(changeType);
		if(approvalResult.isSuccess()){
			approvalRequired= (boolean) approvalResult.getData();
		}
		model.addAttribute("approvalRequired",approvalRequired);
		model.addAttribute("changeType",changeType);
		model.addAttribute("pageType",pageType);
		String assetAttributeDimension=AssetDataChangeServiceProxy.api().queryDataChangeDimensionByChangeType(changeType).getCode();
		//设置字段布局
		Result<HashMap<String, List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.ASSET_CHANGE.code(), assetAttributeDimension);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}

		CatalogVO catalog=new CatalogVO();
		catalog.setCode("asset");
		Result<List<Catalog>> catalogListResult= CatalogServiceProxy.api().queryList(catalog);
		if(catalogListResult.isSuccess()){
			List<Catalog> catalogList=catalogListResult.getData();
			if(catalogList.size()>0){
				CatalogVO catalog2=new CatalogVO();
				catalog2.setParentId(catalogList.get(0).getId());
				catalog2.setIsLoadAllDescendants(1);
				Result<List<ZTreeNode>> treeResult=CatalogServiceProxy.api().queryNodes(catalog2);
				model.addAttribute("assetCategoryData",treeResult.getData());
			}
		}


		return prefix+"/asset_data_change_list";
	}

	/**
	 * 数据变更 表单页面
	 */
	@RequestMapping("/asset_data_change_form.html")
	public String form(Model model,HttpServletRequest request , String id,String changeType) {


		String assetAttributeDimension="";
		if(AssetChangeTypeEnum.EAM_ASSET_CHANGE_BASE_INFO.code().equals(changeType)){
			assetAttributeDimension=AssetAttributeDimensionEnum.ATTRIBUTION.code();
		}else if(AssetChangeTypeEnum.EAM_ASSET_CHANGE_FINANCIAL.code().equals(changeType)){
			assetAttributeDimension=AssetAttributeDimensionEnum.FINANCIAL.code();
		}else if(AssetChangeTypeEnum.EAM_ASSET_CHANGE_MAINTENANCE.code().equals(changeType)){
			assetAttributeDimension=AssetAttributeDimensionEnum.MAINTAINER.code();
		}

		Result<HashMap<String,List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryFormColumnByModule(AssetAttributeItemOwnerEnum.ASSET_CHANGE.code(),assetAttributeDimension);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			model.addAttribute("attributeData3Column1",data.get("attributeData3Column1"));
			model.addAttribute("attributeData3Column2",data.get("attributeData3Column2") );
			model.addAttribute("attributeData3Column3",data.get("attributeData3Column3") );

			model.addAttribute("attributeData1Column1",data.get("attributeData1Column1") );
		}

		//设置字段必选
		AssetAttributeItemVO attributeItem=new AssetAttributeItemVO();
		attributeItem.setOwnerCode(AssetAttributeItemOwnerEnum.ASSET_CHANGE.code());
		attributeItem.setRequired("1");
		attributeItem.setDimension(changeType);
		Result<List<AssetAttributeItem>> attributeItemRequiredListResult = AssetAttributeItemServiceProxy.api().queryList(attributeItem);
		JSONObject attributeItemRequiredObject=new JSONObject();
		if(attributeItemRequiredListResult.isSuccess()){
			List<AssetAttributeItem>  attributeItemRequiredList = attributeItemRequiredListResult.getData();
			if(attributeItemRequiredList.size()>0){
				for(int i=0;i<attributeItemRequiredList.size();i++){
					JSONObject obj=new JSONObject();
					if(AssetAttributeDimensionEnum.ATTRIBUTION.code().equals(attributeItemRequiredList.get(i).getDimension())
							||AssetAttributeDimensionEnum.FINANCIAL.code().equals(attributeItemRequiredList.get(i).getDimension())
							||AssetAttributeDimensionEnum.MAINTAINER.code().equals(attributeItemRequiredList.get(i).getDimension())){
						obj.put("labelInForm",attributeItemRequiredList.get(i).getAttribute().getLabel());
						obj.put("inputType",attributeItemRequiredList.get(i).getAttribute().getComponentType());
						obj.put("required",true);
					}
					attributeItemRequiredObject.put(BeanNameUtil.instance().getPropertyName(attributeItemRequiredList.get(i).getAttribute().getCode()),obj);
				}
			}
		}
		model.addAttribute("attributeRequiredData",attributeItemRequiredObject);

		CatalogVO catalog=new CatalogVO();
		catalog.setCode("asset");
		Result<List<Catalog>> catalogListResult=CatalogServiceProxy.api().queryList(catalog);
		if(catalogListResult.isSuccess()){
			List<Catalog> catalogList=catalogListResult.getData();
			if(catalogList.size()>0){
				CatalogVO catalog2=new CatalogVO();
				catalog2.setParentId(catalogList.get(0).getId());
				catalog2.setIsLoadAllDescendants(1);
				Result<List<ZTreeNode>> treeResult=CatalogServiceProxy.api().queryNodes(catalog2);
				model.addAttribute("assetCategoryData",treeResult.getData());
			}
		}

		model.addAttribute("changeType", changeType);
		model.addAttribute("billId",id);
		model.addAttribute("billType", changeType);
		return prefix+"/asset_data_change_form";
	}
}