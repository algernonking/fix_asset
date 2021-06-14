package com.dt.eam.eam.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 资产物品表 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-06-12 11:21:24
*/

@Controller("EamGoodsPageController")
@RequestMapping(GoodsPageController.prefix)
public class GoodsPageController {
	
	public static final String prefix="business/eam/goods";

	/**
	 * 资产物品 功能主页面
	 */
	@RequestMapping("/goods_list.html")
	public String list(Model model) {
		return prefix+"/goods_list";
	}

	/**
	 * 资产物品 表单页面
	 */
	@RequestMapping("/goods_form.html")
	public String form(Model model , String id) {
		return prefix+"/goods_form";
	}
}