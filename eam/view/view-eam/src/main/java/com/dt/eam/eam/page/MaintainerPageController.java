package com.dt.eam.eam.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 维保厂商 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-06-12 14:21:18
*/

@Controller("EamMaintainerPageController")
@RequestMapping(MaintainerPageController.prefix)
public class MaintainerPageController {
	
	public static final String prefix="business/eam/maintainer";

	/**
	 * 维保厂商 功能主页面
	 */
	@RequestMapping("/maintainer_list.html")
	public String list(Model model) {
		return prefix+"/maintainer_list";
	}

	/**
	 * 维保厂商 表单页面
	 */
	@RequestMapping("/maintainer_form.html")
	public String form(Model model , String id) {
		return prefix+"/maintainer_form";
	}
}