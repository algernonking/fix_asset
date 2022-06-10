package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.MaintainProjectSelect;
import com.dt.platform.domain.eam.MaintainProjectSelectVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 项目  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-07 06:54:18
 */
@FeignClient(value = ServiceNames.EAM, contextId = MaintainProjectSelectServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MaintainProjectSelectServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-maintain-project-select
     */
    public static final String API_CONTEXT_PATH = "eam-maintain-project-select";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加项目
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除项目
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除项目
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新项目
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存项目
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个项目
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个项目
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询项目
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询项目
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出项目数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载项目导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入项目数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加项目
     */
    @RequestMapping(MaintainProjectSelectServiceProxy.INSERT)
    Result insert(@RequestParam(name = "maintainProjectSelectVO") MaintainProjectSelectVO maintainProjectSelectVO);

    /**
     * 删除项目
     */
    @RequestMapping(MaintainProjectSelectServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除项目
     */
    @RequestMapping(MaintainProjectSelectServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新项目
     */
    @RequestMapping(MaintainProjectSelectServiceProxy.UPDATE)
    Result update(@RequestParam(name = "maintainProjectSelectVO") MaintainProjectSelectVO maintainProjectSelectVO);

    /**
     * 更新项目
     */
    @RequestMapping(MaintainProjectSelectServiceProxy.SAVE)
    Result save(@RequestParam(name = "maintainProjectSelectVO") MaintainProjectSelectVO maintainProjectSelectVO);

    /**
     * 获取项目
     */
    @RequestMapping(MaintainProjectSelectServiceProxy.GET_BY_ID)
    Result<MaintainProjectSelect> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个项目
     */
    @RequestMapping(MaintainProjectSelectServiceProxy.GET_BY_IDS)
    Result<List<MaintainProjectSelect>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询项目
     */
    @RequestMapping(MaintainProjectSelectServiceProxy.QUERY_LIST)
    Result<List<MaintainProjectSelect>> queryList(@RequestParam(name = "sample") MaintainProjectSelectVO sample);

    /**
     * 分页查询项目
     */
    @RequestMapping(MaintainProjectSelectServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MaintainProjectSelect>> queryPagedList(@RequestParam(name = "sample") MaintainProjectSelectVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.MaintainProjectSelectController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MaintainProjectSelectServiceProxy api() {
        return APIProxy.get(MaintainProjectSelectServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
