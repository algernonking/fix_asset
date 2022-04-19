package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.InformationSystem;
import com.dt.platform.domain.ops.InformationSystemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 信息系统  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 12:15:03
 */
@FeignClient(value = ServiceNames.OPS, contextId = InformationSystemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InformationSystemServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-information-system
     */
    public static final String API_CONTEXT_PATH = "ops-information-system";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加信息系统
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除信息系统
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除信息系统
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新信息系统
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存信息系统
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个信息系统
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个信息系统
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询信息系统
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询信息系统
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出信息系统数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载信息系统导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入信息系统数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加信息系统
     */
    @RequestMapping(InformationSystemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "informationSystemVO") InformationSystemVO informationSystemVO);

    /**
     * 删除信息系统
     */
    @RequestMapping(InformationSystemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除信息系统
     */
    @RequestMapping(InformationSystemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新信息系统
     */
    @RequestMapping(InformationSystemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "informationSystemVO") InformationSystemVO informationSystemVO);

    /**
     * 更新信息系统
     */
    @RequestMapping(InformationSystemServiceProxy.SAVE)
    Result save(@RequestParam(name = "informationSystemVO") InformationSystemVO informationSystemVO);

    /**
     * 获取信息系统
     */
    @RequestMapping(InformationSystemServiceProxy.GET_BY_ID)
    Result<InformationSystem> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除信息系统
     */
    @RequestMapping(InformationSystemServiceProxy.GET_BY_IDS)
    Result<List<InformationSystem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询信息系统
     */
    @RequestMapping(InformationSystemServiceProxy.QUERY_LIST)
    Result<List<InformationSystem>> queryList(@RequestParam(name = "sample") InformationSystemVO sample);

    /**
     * 分页查询信息系统
     */
    @RequestMapping(InformationSystemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InformationSystem>> queryPagedList(@RequestParam(name = "sample") InformationSystemVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.InformationSystemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InformationSystemServiceProxy api() {
        return APIProxy.get(InformationSystemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
