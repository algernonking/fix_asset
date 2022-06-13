package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InspectionPointOwner;
import com.dt.platform.domain.eam.InspectionPointOwnerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 巡检点  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-11 17:33:04
 */
@FeignClient(value = ServiceNames.EAM, contextId = InspectionPointOwnerServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InspectionPointOwnerServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inspection-point-owner
     */
    public static final String API_CONTEXT_PATH = "eam-inspection-point-owner";

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
    @RequestMapping(InspectionPointOwnerServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inspectionPointOwnerVO") InspectionPointOwnerVO inspectionPointOwnerVO);

    /**
     * 删除巡检点
     */
    @RequestMapping(InspectionPointOwnerServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除巡检点
     */
    @RequestMapping(InspectionPointOwnerServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新巡检点
     */
    @RequestMapping(InspectionPointOwnerServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inspectionPointOwnerVO") InspectionPointOwnerVO inspectionPointOwnerVO);

    /**
     * 更新巡检点
     */
    @RequestMapping(InspectionPointOwnerServiceProxy.SAVE)
    Result save(@RequestParam(name = "inspectionPointOwnerVO") InspectionPointOwnerVO inspectionPointOwnerVO);

    /**
     * 获取巡检点
     */
    @RequestMapping(InspectionPointOwnerServiceProxy.GET_BY_ID)
    Result<InspectionPointOwner> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个巡检点
     */
    @RequestMapping(InspectionPointOwnerServiceProxy.GET_BY_IDS)
    Result<List<InspectionPointOwner>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询巡检点
     */
    @RequestMapping(InspectionPointOwnerServiceProxy.QUERY_LIST)
    Result<List<InspectionPointOwner>> queryList(@RequestParam(name = "sample") InspectionPointOwnerVO sample);

    /**
     * 分页查询巡检点
     */
    @RequestMapping(InspectionPointOwnerServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InspectionPointOwner>> queryPagedList(@RequestParam(name = "sample") InspectionPointOwnerVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InspectionPointOwnerController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InspectionPointOwnerServiceProxy api() {
        return APIProxy.get(InspectionPointOwnerServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
