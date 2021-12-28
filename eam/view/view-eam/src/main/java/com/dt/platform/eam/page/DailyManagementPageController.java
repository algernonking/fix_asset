package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetAttributeItemOwnerEnum;
import com.dt.platform.domain.eam.AssetAttributeItem;
import com.dt.platform.proxy.eam.AssetAttributeItemServiceProxy;
import com.dt.platform.proxy.eam.BrandServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 品牌 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-17 07:47:56
*/

@Controller("EamDailyManagementPageController")
@RequestMapping(DailyManagementPageController.prefix)
public class DailyManagementPageController extends ViewController {
	
	public static final String prefix="business/eam/daily_management";


	/**
	 * 品牌 功能主页面
	 */
	@RequestMapping("/myAsset_list.html")
	public String list(Model model,HttpServletRequest request) {

		Result<HashMap<String, List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.PUBLIC_SHOW.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}

		String employeeId= SessionUser.getCurrent().getActivatedEmployeeId();
		model.addAttribute("employeeId",employeeId);
		return prefix+"/myAsset_list";
	}

	/**
	 * 品牌 功能主页面
	 */
	@RequestMapping("/myAssetMgr_list.html")
	public String listMgr(Model model,HttpServletRequest request) {

		Result<HashMap<String, List<AssetAttributeItem>>> result = AssetAttributeItemServiceProxy.api().queryListColumnByModule(AssetAttributeItemOwnerEnum.PUBLIC_SHOW.code(),null);
		if(result.isSuccess()){
			HashMap<String,List<AssetAttributeItem>> data = result.getData();
			List<AssetAttributeItem> list=data.get("attributeListData");
			model.addAttribute("attributeListData",list);
		}

		String employeeId= SessionUser.getCurrent().getActivatedEmployeeId();
		model.addAttribute("employeeId",employeeId);

		return prefix+"/myAssetMgr_list";
	}


}