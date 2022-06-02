package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.RepairGroup;
import com.dt.platform.domain.eam.RepairGroupVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 维修班组  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 12:58:15
 */
@FeignClient(value = ServiceNames.EAM, contextId = RepairGroupServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface RepairGroupServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-repair-group
     */
    public static final String API_CONTEXT_PATH = "eam-repair-group";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加维修班组
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除维修班组
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除维修班组
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新维修班组
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存维修班组
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个维修班组
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个维修班组
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询维修班组
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询维修班组
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出维修班组数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载维修班组导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入维修班组数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加维修班组
     */
    @RequestMapping(RepairGroupServiceProxy.INSERT)
    Result insert(@RequestParam(name = "repairGroupVO") RepairGroupVO repairGroupVO);

    /**
     * 删除维修班组
     */
    @RequestMapping(RepairGroupServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除维修班组
     */
    @RequestMapping(RepairGroupServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新维修班组
     */
    @RequestMapping(RepairGroupServiceProxy.UPDATE)
    Result update(@RequestParam(name = "repairGroupVO") RepairGroupVO repairGroupVO);

    /**
     * 更新维修班组
     */
    @RequestMapping(RepairGroupServiceProxy.SAVE)
    Result save(@RequestParam(name = "repairGroupVO") RepairGroupVO repairGroupVO);

    /**
     * 获取维修班组
     */
    @RequestMapping(RepairGroupServiceProxy.GET_BY_ID)
    Result<RepairGroup> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个维修班组
     */
    @RequestMapping(RepairGroupServiceProxy.GET_BY_IDS)
    Result<List<RepairGroup>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询维修班组
     */
    @RequestMapping(RepairGroupServiceProxy.QUERY_LIST)
    Result<List<RepairGroup>> queryList(@RequestParam(name = "sample") RepairGroupVO sample);

    /**
     * 分页查询维修班组
     */
    @RequestMapping(RepairGroupServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<RepairGroup>> queryPagedList(@RequestParam(name = "sample") RepairGroupVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.RepairGroupController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static RepairGroupServiceProxy api() {
        return APIProxy.get(RepairGroupServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
