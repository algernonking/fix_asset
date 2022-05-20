package com.dt.platform.eam.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dt.platform.proxy.eam.AssetDataServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetStorageServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 资产入库 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-19 13:26:20
*/

@Controller("EamAssetStoragePageController")
@RequestMapping(AssetStoragePageController.prefix)
public class AssetStoragePageController extends ViewController {
	
	public static final String prefix="business/eam/asset_storage";

	private AssetStorageServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetStorageServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetStorageServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 资产入库 功能主页面
	 */
	@RequestMapping("/asset_excel_oper.html")
	public String assetExcelOper(Model model,HttpServletRequest request,String id,String pageType,String selectedCode) {

		model.addAttribute("id",id);
		model.addAttribute("pageType",pageType);
		model.addAttribute("selectedCode",selectedCode);

		Result r= AssetDataServiceProxy.api().queryAssetLuckySheet("",50,id);
		JSONObject conf= (JSONObject) r.getData();
		model.addAttribute("sheetConfig", JSON.toJSONString(conf, SerializerFeature.DisableCircularReferenceDetect));
		return prefix+"/asset_excel_oper";
	}

	/**
	 * 资产入库 功能主页面
	 */
	@RequestMapping("/asset_storage_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_storage_list";
	}

	/**
	 * 资产入库 表单页面
	 */
	@RequestMapping("/asset_storage_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_storage_form";
	}
}