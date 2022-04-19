package com.dt.platform.proxy.vehicle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.vehicle.Apply;
import com.dt.platform.domain.vehicle.ApplyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 车辆申请  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 19:49:05
 */
@FeignClient(value = ServiceNames.VEHICLE, contextId = ApplyServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ApplyServiceProxy {

    /**
     * 基础路径 , service-vehicle
     */
    public static final String API_BASIC_PATH = "service-vehicle";

    /**
     * API 上下文路径 , vehicle-apply
     */
    public static final String API_CONTEXT_PATH = "vehicle-apply";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 取消
     */
    public static final String CANCEL = API_PREFIX + "cancel";

    /**
     * 取消
     */
    public static final String CONFIRM = API_PREFIX + "confirm";

    /**
     * 取消
     */
    public static final String ACTION_RETURN = API_PREFIX + "action-return";

    /**
     * 添加车辆申请
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除车辆申请
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除车辆申请
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新车辆申请
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存车辆申请
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个车辆申请
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个车辆申请
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询车辆申请
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询车辆申请
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出车辆申请数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载车辆申请导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入车辆申请数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加车辆申请
     */
    @RequestMapping(ApplyServiceProxy.INSERT)
    Result insert(@RequestParam(name = "applyVO") ApplyVO applyVO);

    /**
     * 删除车辆申请
     */
    @RequestMapping(ApplyServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除车辆申请
     */
    @RequestMapping(ApplyServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新车辆申请
     */
    @RequestMapping(ApplyServiceProxy.UPDATE)
    Result update(@RequestParam(name = "applyVO") ApplyVO applyVO);

    /**
     * 更新车辆申请
     */
    @RequestMapping(ApplyServiceProxy.SAVE)
    Result save(@RequestParam(name = "applyVO") ApplyVO applyVO);

    /**
     * 获取车辆申请
     */
    @RequestMapping(ApplyServiceProxy.GET_BY_ID)
    Result<Apply> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个车辆申请
     */
    @RequestMapping(ApplyServiceProxy.GET_BY_IDS)
    Result<List<Apply>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询车辆申请
     */
    @RequestMapping(ApplyServiceProxy.QUERY_LIST)
    Result<List<Apply>> queryList(@RequestParam(name = "sample") ApplyVO sample);

    /**
     * 分页查询车辆申请
     */
    @RequestMapping(ApplyServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Apply>> queryPagedList(@RequestParam(name = "sample") ApplyVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.vehicle.controller.ApplyController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ApplyServiceProxy api() {
        return APIProxy.get(ApplyServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
