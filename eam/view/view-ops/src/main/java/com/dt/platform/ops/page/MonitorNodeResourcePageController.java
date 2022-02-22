package com.dt.platform.ops.page;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.proxy.ops.MonitorDataProcessBaseServiceProxy;
import com.dt.platform.proxy.ops.MonitorNodeValueServiceProxy;
import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 节点数值 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 12:24:24
*/

@Controller("MonitorNodeResourcePageController")
@RequestMapping(MonitorNodeResourcePageController.prefix)
public class MonitorNodeResourcePageController extends ViewController {
	
	public static final String prefix="business/ops/monitor_node_resource";

	private MonitorNodeValueServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public MonitorNodeValueServiceProxy proxy() {
		if(proxy==null) {
			proxy=MonitorNodeValueServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 节点数值 功能主页面
	 */
	@RequestMapping("/monitor_node_host_list.html")
	public String nodeHostList(Model model,HttpServletRequest request) {

		return prefix+"/monitor_node_host_list";
	}



	@RequestMapping("monitor_zabbix_agent_list.html")
	public String zabbixAgentList(Model model,HttpServletRequest request) {
		return prefix+"/monitor_zabbix_agent_list";
	}


	/**
	 * 节点数值 功能主页面
	 */
	@RequestMapping("/monitor_node_host_tree.html")
	public String nodeHostTree(Model model,HttpServletRequest request) {

		return prefix+"/monitor_node_host_tree";
	}


	/**
	 * 节点报错
	 */
	@RequestMapping("/monitor_node_collect_error.html")
	public String nodeCollectDataErrorList(Model model,HttpServletRequest request) {
		return prefix+"/monitor_node_collect_error";
	}

	/**
	 * 节点数据
	 */
	@RequestMapping("/monitor_node_collect_data.html")
	public String nodeCollectData(Model model,HttpServletRequest request,String nodeId) {

		model.addAttribute("nodeId",nodeId);
		return prefix+"/monitor_node_collect_data";
	}



	/**
	 * 节点数据
	 */
	@RequestMapping("/monitor_node_collect_data_graph.html")
	public String nodeCollectDataGraph(Model model,HttpServletRequest request,String nodeId) {

		model.addAttribute("nodeId",nodeId);
		Result<List<MonitorTpl>> res= MonitorDataProcessBaseServiceProxy.api().queryTplListByNodeId(nodeId);
		JSONArray tplArr=new JSONArray();
		if(res.isSuccess()){
			for(MonitorTpl tpl:res.getData()){
				JSONObject obj=new JSONObject();
				obj.put("code",tpl.getCode());
				obj.put("name",tpl.getName());
				tplArr.add(obj);
			}
		}
		model.addAttribute("nodeTplData",tplArr);


		return prefix+"/monitor_node_collect_data_graph";
	}


	/**
	 * 节点数值 表单页面
	 */
	@RequestMapping("/monitor_node_value_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/monitor_node_value_form";
	}
}