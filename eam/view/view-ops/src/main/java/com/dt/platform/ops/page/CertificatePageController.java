package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.CertificateServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 证书 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-15 06:10:09
*/

@Controller("OpsCertificatePageController")
@RequestMapping(CertificatePageController.prefix)
public class CertificatePageController extends ViewController {
	
	public static final String prefix="business/ops/certificate";

	private CertificateServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CertificateServiceProxy proxy() {
		if(proxy==null) {
			proxy=CertificateServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 证书 功能主页面
	 */
	@RequestMapping("/certificate_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/certificate_list";
	}

	/**
	 * 证书 表单页面
	 */
	@RequestMapping("/certificate_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/certificate_form";
	}
}