package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.MaintainTaskProject;
import com.dt.platform.domain.eam.MaintainTaskProjectVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 保养项目  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-09 12:22:23
 */
@FeignClient(value = ServiceNames.EAM, contextId = MaintainTaskProjectServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MaintainTaskProjectServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-maintain-task-project
     */
    public static final String API_CONTEXT_PATH = "eam-maintain-task-project";

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
     * 添加保养项目
     */
    @RequestMapping(MaintainTaskProjectServiceProxy.INSERT)
    Result insert(@RequestParam(name = "maintainTaskProjectVO") MaintainTaskProjectVO maintainTaskProjectVO);

    /**
     * 删除保养项目
     */
    @RequestMapping(MaintainTaskProjectServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除保养项目
     */
    @RequestMapping(MaintainTaskProjectServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新保养项目
     */
    @RequestMapping(MaintainTaskProjectServiceProxy.UPDATE)
    Result update(@RequestParam(name = "maintainTaskProjectVO") MaintainTaskProjectVO maintainTaskProjectVO);

    /**
     * 更新保养项目
     */
    @RequestMapping(MaintainTaskProjectServiceProxy.SAVE)
    Result save(@RequestParam(name = "maintainTaskProjectVO") MaintainTaskProjectVO maintainTaskProjectVO);

    /**
     * 获取保养项目
     */
    @RequestMapping(MaintainTaskProjectServiceProxy.GET_BY_ID)
    Result<MaintainTaskProject> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个保养项目
     */
    @RequestMapping(MaintainTaskProjectServiceProxy.GET_BY_IDS)
    Result<List<MaintainTaskProject>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询保养项目
     */
    @RequestMapping(MaintainTaskProjectServiceProxy.QUERY_LIST)
    Result<List<MaintainTaskProject>> queryList(@RequestParam(name = "sample") MaintainTaskProjectVO sample);

    /**
     * 分页查询保养项目
     */
    @RequestMapping(MaintainTaskProjectServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MaintainTaskProject>> queryPagedList(@RequestParam(name = "sample") MaintainTaskProjectVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.MaintainTaskProjectController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MaintainTaskProjectServiceProxy api() {
        return APIProxy.get(MaintainTaskProjectServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
