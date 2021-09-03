package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.VoucherHistoryServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 凭证记录 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-04 00:03:35
*/

@Controller("OpsVoucherHistoryPageController")
@RequestMapping(VoucherHistoryPageController.prefix)
public class VoucherHistoryPageController extends ViewController {
	
	public static final String prefix="business/ops/voucher_history";

	private VoucherHistoryServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public VoucherHistoryServiceProxy proxy() {
		if(proxy==null) {
			proxy=VoucherHistoryServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 凭证记录 功能主页面
	 */
	@RequestMapping("/voucher_history_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/voucher_history_list";
	}

	/**
	 * 凭证记录 表单页面
	 */
	@RequestMapping("/voucher_history_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/voucher_history_form";
	}
}