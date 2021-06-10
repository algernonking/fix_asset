package com.dt.eam.hrm.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * <p>
 * 公司表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-10 13:27:47
*/

@Controller("HrmCompanyPageController")
@RequestMapping(CompanyPageController.prefix)
public class CompanyPageController {
	
	public static final String prefix="business/hrm/company";

	/**
	 * 公司 功能主页面
	 */
	@RequestMapping("/company_list.html")
	public String list(Model model) {
		return prefix+"/company_list";
	}

	/**
	 * 公司 表单页面
	 */
	@RequestMapping("/company_form.html")
	public String form(Model model , String id) {
		return prefix+"/company_form";
	}
}