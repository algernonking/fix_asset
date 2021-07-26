package com.dt.platform.hrm.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 * <p>
 * 员工表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-10 13:23:34
*/

@Controller("HrmEmployeePageController")
@RequestMapping(EmployeePageController.prefix)
public class EmployeePageController {
	
	public static final String prefix="business/hrm/employee";

	/**
	 * 员工 功能主页面
	 */
	@RequestMapping("/employee_list.html")
	public String list(Model model) {
		return prefix+"/employee_list";
	}

	/**
	 * 员工 表单页面
	 */
	@RequestMapping("/employee_form.html")
	public String form(Model model , String id) {
		return prefix+"/employee_form";
	}
}