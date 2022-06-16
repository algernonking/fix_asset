package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.CertificateItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 证书项 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-15 06:07:51
*/

@Controller("OpsCertificateItemPageController")
@RequestMapping(CertificateItemPageController.prefix)
public class CertificateItemPageController extends ViewController {
	
	public static final String prefix="business/ops/certificate_item";

	private CertificateItemServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CertificateItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=CertificateItemServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 证书项 功能主页面
	 */
	@RequestMapping("/certificate_item_list.html")
	public String list(Model model,HttpServletRequest request,String certificateId) {
		model.addAttribute("certificateId",certificateId);
		return prefix+"/certificate_item_list";
	}

	/**
	 * 证书项 表单页面
	 */
	@RequestMapping("/certificate_item_form.html")
	public String form(Model model,HttpServletRequest request , String id,String certificateId) {

		model.addAttribute("certificateId",certificateId);
		return prefix+"/certificate_item_form";
	}
}