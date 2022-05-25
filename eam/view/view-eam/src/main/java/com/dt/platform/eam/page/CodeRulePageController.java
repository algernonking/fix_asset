package com.dt.platform.eam.page;

import com.dt.platform.domain.eam.AssetLabelPaper;
import com.dt.platform.domain.eam.AssetLabelPaperVO;
import com.dt.platform.domain.eam.CodePart;
import com.dt.platform.domain.eam.CodePartVO;
import com.dt.platform.proxy.eam.AssetLabelPaperServiceProxy;
import com.dt.platform.proxy.eam.CodePartServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CodeRuleServiceProxy;
import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 编码字段 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 20:46:23
*/

@Controller("EamCodeRulePageController")
@RequestMapping(CodeRulePageController.prefix)
public class CodeRulePageController extends ViewController {
	
	public static final String prefix="business/eam/code_rule";

	private CodeRuleServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CodeRuleServiceProxy proxy() {
		if(proxy==null) {
			proxy=CodeRuleServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 编码字段 功能主页面
	 */
	@RequestMapping("/code_rule.html")
	public String ruleList(Model model,HttpServletRequest request) {


		Result<List<CodePart>> result= CodePartServiceProxy.api().queryList(new CodePartVO());
		List<CodePart> list=result.getData();
		List<CodePart> list2 = list.stream().sorted(Comparator.comparing(a -> a.getSort())).collect(Collectors.toList());
		model.addAttribute("codeParts",list2);
		return prefix+"/code_rule";
	}

	/**
	 * 编码字段 功能主页面
	 */
	@RequestMapping("/code_rule_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/code_rule_list";
	}

	/**
	 * 编码字段 表单页面
	 */
	@RequestMapping("/code_rule_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/code_rule_form";
	}
}