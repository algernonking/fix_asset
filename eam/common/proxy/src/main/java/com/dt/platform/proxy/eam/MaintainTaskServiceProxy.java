package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.MaintainTask;
import com.dt.platform.domain.eam.MaintainTaskVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 保养任务  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-06 21:41:15
 */
@FeignClient(value = ServiceNames.EAM, contextId = MaintainTaskServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface MaintainTaskServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-maintain-task
     */
    public static final String API_CONTEXT_PATH = "eam-maintain-task";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加保养任务
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除保养任务
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除保养任务
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新保养任务
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存保养任务
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个保养任务
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个保养任务
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询保养任务
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询保养任务
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出保养任务数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载保养任务导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入保养任务数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";


    public static final String BATCH_CANCEL = API_PREFIX + "batch-cancel";

    public static final String EXECUTE = API_PREFIX + "execute";

    public static final String CANCEL = API_PREFIX + "cancel";
    public static final String FINISH = API_PREFIX + "finish";


    /**
     * 添加保养任务
     */
    @RequestMapping(MaintainTaskServiceProxy.INSERT)
    Result insert(@RequestParam(name = "maintainTaskVO") MaintainTaskVO maintainTaskVO);

    /**
     * 删除保养任务
     */
    @RequestMapping(MaintainTaskServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除保养任务
     */
    @RequestMapping(MaintainTaskServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新保养任务
     */
    @RequestMapping(MaintainTaskServiceProxy.UPDATE)
    Result update(@RequestParam(name = "maintainTaskVO") MaintainTaskVO maintainTaskVO);

    /**
     * 更新保养任务
     */
    @RequestMapping(MaintainTaskServiceProxy.SAVE)
    Result save(@RequestParam(name = "maintainTaskVO") MaintainTaskVO maintainTaskVO);

    /**
     * 获取保养任务
     */
    @RequestMapping(MaintainTaskServiceProxy.GET_BY_ID)
    Result<MaintainTask> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个保养任务
     */
    @RequestMapping(MaintainTaskServiceProxy.GET_BY_IDS)
    Result<List<MaintainTask>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询保养任务
     */
    @RequestMapping(MaintainTaskServiceProxy.QUERY_LIST)
    Result<List<MaintainTask>> queryList(@RequestParam(name = "sample") MaintainTaskVO sample);

    /**
     * 分页查询保养任务
     */
    @RequestMapping(MaintainTaskServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<MaintainTask>> queryPagedList(@RequestParam(name = "sample") MaintainTaskVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.MaintainTaskController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static MaintainTaskServiceProxy api() {
        return APIProxy.get(MaintainTaskServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
