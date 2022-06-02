package com.dt.platform.eam.page;

import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.FailureRegistrationServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 故障登记 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-28 16:13:09
*/

@Controller("EamFailureRegistrationPageController")
@RequestMapping(FailureRegistrationPageController.prefix)
public class FailureRegistrationPageController extends ViewController {
	
	public static final String prefix="business/eam/failure_registration";

	private FailureRegistrationServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public FailureRegistrationServiceProxy proxy() {
		if(proxy==null) {
			proxy=FailureRegistrationServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 故障登记 功能主页面
	 */
	@RequestMapping("/failure_registration_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/failure_registration_list";
	}

	/**
	 * 故障登记 表单页面
	 */
	@RequestMapping("/failure_registration_form.html")
	public String form(Model model,HttpServletRequest request , String id) {

		model.addAttribute("billId",id);
		model.addAttribute("billType", AssetOperateEnum.EAM_EQUIPMENT_FAILURE_REGISTRATION.code());
		return prefix+"/failure_registration_form";
	}
}