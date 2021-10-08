package com.dt.platform.eam.page;

import com.dt.platform.proxy.eam.MyBusinessServiceProxy;
import com.dt.platform.proxy.eam.SupplierServiceProxy;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 供应商 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 11:16:21
*/

@Controller("EamMyBusinessPageController")
@RequestMapping(MyBusinessPageController.prefix)
public class MyBusinessPageController extends ViewController {
	
	public static final String prefix="business/eam/my_business";

	private MyBusinessServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MyBusinessServiceProxy proxy() {
		if(proxy==null) {
			proxy=MyBusinessServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 *
	 */
	@RequestMapping("/todo_list.html")
	public String todoList(Model model,HttpServletRequest request, String id) {
		return prefix+"/todo_list";
	}

	/**
	 *
	 */
	@RequestMapping("/done_list.html")
	public String doneList(Model model,HttpServletRequest request , String id) {

		return prefix+"/done_list";
	}


	/**
	 *
	 */
	@RequestMapping("/assetInsert_list.html")
	public String assetInsertList(Model model,HttpServletRequest request , String id) {

		return prefix+"/assetInsert_list";
	}


	/**
	 *
	 */
	@RequestMapping("/changeMaintenance_list.html")
	public String changeMaintenanceList(Model model,HttpServletRequest request , String id) {

		return prefix+"/changeMaintenance_list";
	}


	/**
	 *
	 */
	@RequestMapping("/changeBaseInfo_list.html")
	public String changeBaseInfoList(Model model,HttpServletRequest request , String id) {

		return prefix+"/changeBaseInfo_list";
	}

	/**
	 *
	 */
	@RequestMapping("/changeFinance_list.html")
	public String changeFinanceList(Model model,HttpServletRequest request , String id) {

		return prefix+"/changeFinance_list";
	}


}