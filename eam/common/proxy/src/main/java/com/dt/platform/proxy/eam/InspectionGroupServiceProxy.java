package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InspectionGroup;
import com.dt.platform.domain.eam.InspectionGroupVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 巡检班组  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 12:57:14
 */
@FeignClient(value = ServiceNames.EAM, contextId = InspectionGroupServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InspectionGroupServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inspection-group
     */
    public static final String API_CONTEXT_PATH = "eam-inspection-group";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加巡检班组
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除巡检班组
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除巡检班组
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新巡检班组
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存巡检班组
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个巡检班组
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个巡检班组
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询巡检班组
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询巡检班组
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出巡检班组数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载巡检班组导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入巡检班组数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加巡检班组
     */
    @RequestMapping(InspectionGroupServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inspectionGroupVO") InspectionGroupVO inspectionGroupVO);

    /**
     * 删除巡检班组
     */
    @RequestMapping(InspectionGroupServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除巡检班组
     */
    @RequestMapping(InspectionGroupServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新巡检班组
     */
    @RequestMapping(InspectionGroupServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inspectionGroupVO") InspectionGroupVO inspectionGroupVO);

    /**
     * 更新巡检班组
     */
    @RequestMapping(InspectionGroupServiceProxy.SAVE)
    Result save(@RequestParam(name = "inspectionGroupVO") InspectionGroupVO inspectionGroupVO);

    /**
     * 获取巡检班组
     */
    @RequestMapping(InspectionGroupServiceProxy.GET_BY_ID)
    Result<InspectionGroup> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个巡检班组
     */
    @RequestMapping(InspectionGroupServiceProxy.GET_BY_IDS)
    Result<List<InspectionGroup>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询巡检班组
     */
    @RequestMapping(InspectionGroupServiceProxy.QUERY_LIST)
    Result<List<InspectionGroup>> queryList(@RequestParam(name = "sample") InspectionGroupVO sample);

    /**
     * 分页查询巡检班组
     */
    @RequestMapping(InspectionGroupServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InspectionGroup>> queryPagedList(@RequestParam(name = "sample") InspectionGroupVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InspectionGroupController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InspectionGroupServiceProxy api() {
        return APIProxy.get(InspectionGroupServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
