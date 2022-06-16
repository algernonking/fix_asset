package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.CertificatePositionServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 证书位置 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-15 07:17:50
*/

@Controller("OpsCertificatePositionPageController")
@RequestMapping(CertificatePositionPageController.prefix)
public class CertificatePositionPageController extends ViewController {
	
	public static final String prefix="business/ops/certificate_position";

	private CertificatePositionServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CertificatePositionServiceProxy proxy() {
		if(proxy==null) {
			proxy=CertificatePositionServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 证书位置 功能主页面
	 */
	@RequestMapping("/certificate_position_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/certificate_position_list";
	}

	/**
	 * 证书位置 表单页面
	 */
	@RequestMapping("/certificate_position_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/certificate_position_form";
	}
}