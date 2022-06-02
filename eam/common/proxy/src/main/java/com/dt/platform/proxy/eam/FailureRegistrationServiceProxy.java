package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.FailureRegistration;
import com.dt.platform.domain.eam.FailureRegistrationVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 故障登记  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-28 16:13:08
 */
@FeignClient(value = ServiceNames.EAM, contextId = FailureRegistrationServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface FailureRegistrationServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-failure-registration
     */
    public static final String API_CONTEXT_PATH = "eam-failure-registration";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加故障登记
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除故障登记
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除故障登记
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新故障登记
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存故障登记
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个故障登记
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个故障登记
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询故障登记
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询故障登记
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出故障登记数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载故障登记导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入故障登记数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 确认操作
     */
    public static final String CONFIRM_OPERATION = API_PREFIX + "confirm-operation";

    /**
     * 添加故障登记
     */
    @RequestMapping(FailureRegistrationServiceProxy.INSERT)
    Result insert(@RequestParam(name = "failureRegistrationVO") FailureRegistrationVO failureRegistrationVO);

    /**
     * 删除故障登记
     */
    @RequestMapping(FailureRegistrationServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除故障登记
     */
    @RequestMapping(FailureRegistrationServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新故障登记
     */
    @RequestMapping(FailureRegistrationServiceProxy.UPDATE)
    Result update(@RequestParam(name = "failureRegistrationVO") FailureRegistrationVO failureRegistrationVO);

    /**
     * 更新故障登记
     */
    @RequestMapping(FailureRegistrationServiceProxy.SAVE)
    Result save(@RequestParam(name = "failureRegistrationVO") FailureRegistrationVO failureRegistrationVO);

    /**
     * 获取故障登记
     */
    @RequestMapping(FailureRegistrationServiceProxy.GET_BY_ID)
    Result<FailureRegistration> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个故障登记
     */
    @RequestMapping(FailureRegistrationServiceProxy.GET_BY_IDS)
    Result<List<FailureRegistration>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询故障登记
     */
    @RequestMapping(FailureRegistrationServiceProxy.QUERY_LIST)
    Result<List<FailureRegistration>> queryList(@RequestParam(name = "sample") FailureRegistrationVO sample);

    /**
     * 分页查询故障登记
     */
    @RequestMapping(FailureRegistrationServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<FailureRegistration>> queryPagedList(@RequestParam(name = "sample") FailureRegistrationVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.FailureRegistrationController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static FailureRegistrationServiceProxy api() {
        return APIProxy.get(FailureRegistrationServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
