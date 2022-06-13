package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import com.dt.platform.domain.eam.InspectionTaskPointVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 巡检点  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-12 21:07:10
 */
@FeignClient(value = ServiceNames.EAM, contextId = InspectionTaskPointServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InspectionTaskPointServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inspection-task-point
     */
    public static final String API_CONTEXT_PATH = "eam-inspection-task-point";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加巡检点
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除巡检点
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除巡检点
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新巡检点
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存巡检点
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个巡检点
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个巡检点
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询巡检点
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询巡检点
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出巡检点数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载巡检点导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入巡检点数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加巡检点
     */
    @RequestMapping(InspectionTaskPointServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inspectionTaskPointVO") InspectionTaskPointVO inspectionTaskPointVO);

    /**
     * 删除巡检点
     */
    @RequestMapping(InspectionTaskPointServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除巡检点
     */
    @RequestMapping(InspectionTaskPointServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新巡检点
     */
    @RequestMapping(InspectionTaskPointServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inspectionTaskPointVO") InspectionTaskPointVO inspectionTaskPointVO);

    /**
     * 更新巡检点
     */
    @RequestMapping(InspectionTaskPointServiceProxy.SAVE)
    Result save(@RequestParam(name = "inspectionTaskPointVO") InspectionTaskPointVO inspectionTaskPointVO);

    /**
     * 获取巡检点
     */
    @RequestMapping(InspectionTaskPointServiceProxy.GET_BY_ID)
    Result<InspectionTaskPoint> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个巡检点
     */
    @RequestMapping(InspectionTaskPointServiceProxy.GET_BY_IDS)
    Result<List<InspectionTaskPoint>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询巡检点
     */
    @RequestMapping(InspectionTaskPointServiceProxy.QUERY_LIST)
    Result<List<InspectionTaskPoint>> queryList(@RequestParam(name = "sample") InspectionTaskPointVO sample);

    /**
     * 分页查询巡检点
     */
    @RequestMapping(InspectionTaskPointServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InspectionTaskPoint>> queryPagedList(@RequestParam(name = "sample") InspectionTaskPointVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InspectionTaskPointController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InspectionTaskPointServiceProxy api() {
        return APIProxy.get(InspectionTaskPointServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
