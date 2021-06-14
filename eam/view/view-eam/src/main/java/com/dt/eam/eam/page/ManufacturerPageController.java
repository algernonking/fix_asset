package com.dt.eam.eam.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 生产厂商 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-06-12 14:21:18
*/

@Controller("EamManufacturerPageController")
@RequestMapping(ManufacturerPageController.prefix)
public class ManufacturerPageController {
	
	public static final String prefix="business/eam/manufacturer";

	/**
	 * 生产厂商 功能主页面
	 */
	@RequestMapping("/manufacturer_list.html")
	public String list(Model model) {
		return prefix+"/manufacturer_list";
	}

	/**
	 * 生产厂商 表单页面
	 */
	@RequestMapping("/manufacturer_form.html")
	public String form(Model model , String id) {
		return prefix+"/manufacturer_form";
	}
}