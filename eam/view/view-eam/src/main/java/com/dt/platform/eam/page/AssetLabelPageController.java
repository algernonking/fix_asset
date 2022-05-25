package com.dt.platform.eam.page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dt.platform.domain.eam.*;
import com.dt.platform.proxy.eam.AssetLabelColServiceProxy;
import com.dt.platform.proxy.eam.AssetLabelPaperServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.AssetLabelServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 资产标签 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-20 21:18:06
*/

@Controller("EamAssetLabelPageController")
@RequestMapping(AssetLabelPageController.prefix)
public class AssetLabelPageController extends ViewController {
	
	public static final String prefix="business/eam/asset_label";

	private AssetLabelServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AssetLabelServiceProxy proxy() {
		if(proxy==null) {
			proxy=AssetLabelServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 资产标签 功能主页面
	 */
	@RequestMapping("/asset_label_setting.html")
	public String labelSetting(Model model,HttpServletRequest request) {

		Result<List<AssetLabelPaper>>  result=AssetLabelPaperServiceProxy.api().queryList(new AssetLabelPaperVO());
		List<AssetLabelPaper> list=result.getData();

		model.addAttribute("paperTypeData",list);
		return prefix+"/asset_label_setting";
	}

	/**
	 * 资产标签 功能主页面
	 */
	@RequestMapping("/asset_label_custom.html")
	public String labelCustom(Model model,HttpServletRequest request) {
		Result<List<AssetLabelCol>>  result= AssetLabelColServiceProxy.api().queryList(new AssetLabelColVO());
		List<AssetLabelCol> list=result.getData();
		List<AssetLabelCol> list2 = list.stream().sorted(Comparator.comparing(a -> a.getSort())).collect(Collectors.toList());
		model.addAttribute("assetLabelColumn",list2);
		return prefix+"/asset_label_custom";
	}



	/**
	 * 资产标签 功能主页面
	 */
	@RequestMapping("/asset_label_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/asset_label_list";
	}

	/**
	 * 资产标签 表单页面
	 */
	@RequestMapping("/asset_label_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/asset_label_form";
	}
}