package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.MaintainPlan;
import com.dt.platform.domain.eam.MaintainPlanVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 保养方案  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-05 09:51:44
 */
@FeignClient(value = ServiceNames.EAM, contextId = MaintainPlanServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MaintainPlanServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-maintain-plan
     */
    public static final String API_CONTEXT_PATH = "eam-maintain-plan";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加保养方案
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除保养方案
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除保养方案
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新保养方案
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存保养方案
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个保养方案
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个保养方案
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询保养方案
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询保养方案
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出保养方案数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载保养方案导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入保养方案数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 获取单个保养方案
     */
    public static final String START = API_PREFIX + "start";

    public static final String STOP = API_PREFIX + "stop";

    public static final String EXECUTE = API_PREFIX + "execute";

    @RequestMapping(MaintainPlanServiceProxy.EXECUTE)
    Result execute(@RequestParam(name = "id") String id);

    /**
     * 添加保养方案
     */
    @RequestMapping(MaintainPlanServiceProxy.INSERT)
    Result insert(@RequestParam(name = "maintainPlanVO") MaintainPlanVO maintainPlanVO);

    /**
     * 删除保养方案
     */
    @RequestMapping(MaintainPlanServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除保养方案
     */
    @RequestMapping(MaintainPlanServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新保养方案
     */
    @RequestMapping(MaintainPlanServiceProxy.UPDATE)
    Result update(@RequestParam(name = "maintainPlanVO") MaintainPlanVO maintainPlanVO);

    /**
     * 更新保养方案
     */
    @RequestMapping(MaintainPlanServiceProxy.SAVE)
    Result save(@RequestParam(name = "maintainPlanVO") MaintainPlanVO maintainPlanVO);

    /**
     * 获取保养方案
     */
    @RequestMapping(MaintainPlanServiceProxy.GET_BY_ID)
    Result<MaintainPlan> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个保养方案
     */
    @RequestMapping(MaintainPlanServiceProxy.GET_BY_IDS)
    Result<List<MaintainPlan>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询保养方案
     */
    @RequestMapping(MaintainPlanServiceProxy.QUERY_LIST)
    Result<List<MaintainPlan>> queryList(@RequestParam(name = "sample") MaintainPlanVO sample);

    /**
     * 分页查询保养方案
     */
    @RequestMapping(MaintainPlanServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MaintainPlan>> queryPagedList(@RequestParam(name = "sample") MaintainPlanVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.MaintainPlanController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MaintainPlanServiceProxy api() {
        return APIProxy.get(MaintainPlanServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
