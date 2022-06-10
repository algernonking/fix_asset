package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.MaintainProject;
import com.dt.platform.domain.eam.MaintainProjectVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 保养项目  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-03 21:20:24
 */
@FeignClient(value = ServiceNames.EAM, contextId = MaintainProjectServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MaintainProjectServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-maintain-project
     */
    public static final String API_CONTEXT_PATH = "eam-maintain-project";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加保养项目
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除保养项目
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除保养项目
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新保养项目
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存保养项目
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个保养项目
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个保养项目
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询保养项目
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询保养项目
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出保养项目数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载保养项目导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入保养项目数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     *
     */

    public static final String QUERY_PAGED_LIST_BY_SELECTED = API_PREFIX + "query-paged-list-by-selected";
    /**
     *
     */
    public static final String QUERY_PAGED_LIST_BY_SELECT = API_PREFIX + "query-paged-list-by-select";


    public static final String SELECTED = API_PREFIX + "selected";



    /**
     * 添加保养项目
     */
    @RequestMapping(MaintainProjectServiceProxy.INSERT)
    Result insert(@RequestParam(name = "maintainProjectVO") MaintainProjectVO maintainProjectVO);

    /**
     * 删除保养项目
     */
    @RequestMapping(MaintainProjectServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除保养项目
     */
    @RequestMapping(MaintainProjectServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新保养项目
     */
    @RequestMapping(MaintainProjectServiceProxy.UPDATE)
    Result update(@RequestParam(name = "maintainProjectVO") MaintainProjectVO maintainProjectVO);

    /**
     * 更新保养项目
     */
    @RequestMapping(MaintainProjectServiceProxy.SAVE)
    Result save(@RequestParam(name = "maintainProjectVO") MaintainProjectVO maintainProjectVO);

    /**
     * 获取保养项目
     */
    @RequestMapping(MaintainProjectServiceProxy.GET_BY_ID)
    Result<MaintainProject> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个保养项目
     */
    @RequestMapping(MaintainProjectServiceProxy.GET_BY_IDS)
    Result<List<MaintainProject>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询保养项目
     */
    @RequestMapping(MaintainProjectServiceProxy.QUERY_LIST)
    Result<List<MaintainProject>> queryList(@RequestParam(name = "sample") MaintainProjectVO sample);

    /**
     * 分页查询保养项目
     */
    @RequestMapping(MaintainProjectServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MaintainProject>> queryPagedList(@RequestParam(name = "sample") MaintainProjectVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.MaintainProjectController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MaintainProjectServiceProxy api() {
        return APIProxy.get(MaintainProjectServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
