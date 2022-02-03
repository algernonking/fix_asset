package com.dt.platform.ops.page;

import com.dt.platform.proxy.ops.MonitorStatisticalDataServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("MonitorDashBoardPageController")
@RequestMapping(MonitorDashBoardPageController.prefix)
public class MonitorDashBoardPageController {

    public static final String prefix="business/ops/monitor_dashboard";

    private MonitorStatisticalDataServiceProxy proxy;


    /**
     * 获得代理对象<br>
     * 1、单体应用时，在应用内部调用；<br>
     * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
     * 3、微服务时，通过feign调用; <br>
     * */
    public MonitorStatisticalDataServiceProxy proxy() {
        if(proxy==null) {
            proxy=MonitorStatisticalDataServiceProxy.api();
        }
        return proxy;
    }


    /**
     * 节点数据库 功能主页面
     */
    @RequestMapping("/monitor_dashboard_list.html")
    public String monitorDashboardList(Model model, HttpServletRequest request) {
        return prefix+"/monitor_dashboard_list";
    }

}
