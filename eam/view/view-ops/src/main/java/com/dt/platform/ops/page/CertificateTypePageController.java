package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.CertificateTypeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 证书类型 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-15 07:17:54
*/

@Controller("OpsCertificateTypePageController")
@RequestMapping(CertificateTypePageController.prefix)
public class CertificateTypePageController extends ViewController {
	
	public static final String prefix="business/ops/certificate_type";

	private CertificateTypeServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CertificateTypeServiceProxy proxy() {
		if(proxy==null) {
			proxy=CertificateTypeServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 证书类型 功能主页面
	 */
	@RequestMapping("/certificate_type_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/certificate_type_list";
	}

	/**
	 * 证书类型 表单页面
	 */
	@RequestMapping("/certificate_type_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/certificate_type_form";
	}
}