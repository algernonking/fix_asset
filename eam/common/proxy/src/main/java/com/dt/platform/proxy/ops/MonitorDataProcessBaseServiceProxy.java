package com.dt.platform.proxy.ops;

import com.dt.platform.domain.ops.MonitorNodeDb;
import com.dt.platform.domain.ops.MonitorNodeDbVO;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.proxy.ServiceNames;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 主机  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:06:49
 */
@FeignClient(value = ServiceNames.OPS, contextId = MonitorDataProcessBaseServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MonitorDataProcessBaseServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 ,collect-data
     */
    public static final String API_CONTEXT_PATH = "monitor-data-process-base";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     */
    public static final String QUERY_NODE_ZABBIX_AGENT_DATA = API_PREFIX + "query-node-zabbix-agent-data";

    /**
     */
    public static final String QUERY_TPL_LIST_BY_NODE_ID = API_PREFIX + "query-tpl-list-by-node-id";

    /**
     * 分页查询节点数据库
     */
    @RequestMapping(MonitorDataProcessBaseServiceProxy.QUERY_NODE_ZABBIX_AGENT_DATA)
    Result<List<MonitorTpl>> queryTplListByNodeId(@RequestParam(name = "nodeId") String nodeId);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.MonitorDataProcessBaseController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MonitorDataProcessBaseServiceProxy api() {
        return APIProxy.get(MonitorDataProcessBaseServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
