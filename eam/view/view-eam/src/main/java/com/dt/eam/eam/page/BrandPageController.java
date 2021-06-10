package com.dt.eam.eam.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 品牌表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-10 14:30:18
*/

@Controller("EamBrandPageController")
@RequestMapping(BrandPageController.prefix)
public class BrandPageController {
	
	public static final String prefix="business/eam/brand";

	/**
	 * 品牌 功能主页面
	 */
	@RequestMapping("/brand_list.html")
	public String list(Model model) {
		return prefix+"/brand_list";
	}

	/**
	 * 品牌 表单页面
	 */
	@RequestMapping("/brand_form.html")
	public String form(Model model , String id) {
		return prefix+"/brand_form";
	}
}