package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.ActionCrontab;
import com.dt.platform.domain.eam.ActionCrontabVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 执行动作  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-03 21:08:22
 */
@FeignClient(value = ServiceNames.EAM, contextId = ActionCrontabServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ActionCrontabServiceProxy {


    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-action-crontab
     */
    public static final String API_CONTEXT_PATH = "eam-action-crontab";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加执行动作
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除执行动作
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除执行动作
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新执行动作
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存执行动作
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个执行动作
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个执行动作
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询执行动作
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询执行动作
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出执行动作数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载执行动作导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入执行动作数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";


    public static final String GET_BY_OWNER_ID = API_PREFIX + "get-by-owner-id";

    /**
     * 添加执行动作
     */
    @RequestMapping(ActionCrontabServiceProxy.INSERT)
    Result insert(@RequestParam(name = "actionCrontabVO") ActionCrontabVO actionCrontabVO);

    /**
     * 删除执行动作
     */
    @RequestMapping(ActionCrontabServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除执行动作
     */
    @RequestMapping(ActionCrontabServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新执行动作
     */
    @RequestMapping(ActionCrontabServiceProxy.UPDATE)
    Result update(@RequestParam(name = "actionCrontabVO") ActionCrontabVO actionCrontabVO);

    /**
     * 更新执行动作
     */
    @RequestMapping(ActionCrontabServiceProxy.SAVE)
    Result save(@RequestParam(name = "actionCrontabVO") ActionCrontabVO actionCrontabVO);

    /**
     * 获取执行动作
     */
    @RequestMapping(ActionCrontabServiceProxy.GET_BY_ID)
    Result<ActionCrontab> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个执行动作
     */
    @RequestMapping(ActionCrontabServiceProxy.GET_BY_IDS)
    Result<List<ActionCrontab>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询执行动作
     */
    @RequestMapping(ActionCrontabServiceProxy.QUERY_LIST)
    Result<List<ActionCrontab>> queryList(@RequestParam(name = "sample") ActionCrontabVO sample);

    /**
     * 分页查询执行动作
     */
    @RequestMapping(ActionCrontabServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ActionCrontab>> queryPagedList(@RequestParam(name = "sample") ActionCrontabVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.ActionCrontabController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ActionCrontabServiceProxy api() {
        return APIProxy.get(ActionCrontabServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
