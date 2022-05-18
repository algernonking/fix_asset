package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.LicenceSwitch;
import com.dt.platform.domain.common.LicenceSwitchVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 版本切换  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-16 16:21:28
 */
@FeignClient(value = ServiceNames.COMMON, contextId = LicenceSwitchServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface LicenceSwitchServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-licence-switch
     */
    public static final String API_CONTEXT_PATH = "sys-licence-switch";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加版本切换
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除版本切换
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除版本切换
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新版本切换
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存版本切换
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个版本切换
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个版本切换
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询版本切换
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询版本切换
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 版本激活
     */
    public static final String SWITCH_ENABLE = API_PREFIX + "switch-enable";

    /**
     * 导出版本切换数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载版本切换导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入版本切换数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加版本切换
     */
    @RequestMapping(LicenceSwitchServiceProxy.INSERT)
    Result insert(@RequestParam(name = "licenceSwitchVO") LicenceSwitchVO licenceSwitchVO);

    /**
     * 删除版本切换
     */
    @RequestMapping(LicenceSwitchServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除版本切换
     */
    @RequestMapping(LicenceSwitchServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新版本切换
     */
    @RequestMapping(LicenceSwitchServiceProxy.UPDATE)
    Result update(@RequestParam(name = "licenceSwitchVO") LicenceSwitchVO licenceSwitchVO);

    /**
     * 更新版本切换
     */
    @RequestMapping(LicenceSwitchServiceProxy.SAVE)
    Result save(@RequestParam(name = "licenceSwitchVO") LicenceSwitchVO licenceSwitchVO);

    /**
     * 获取版本切换
     */
    @RequestMapping(LicenceSwitchServiceProxy.GET_BY_ID)
    Result<LicenceSwitch> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个版本切换
     */
    @RequestMapping(LicenceSwitchServiceProxy.GET_BY_IDS)
    Result<List<LicenceSwitch>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询版本切换
     */
    @RequestMapping(LicenceSwitchServiceProxy.QUERY_LIST)
    Result<List<LicenceSwitch>> queryList(@RequestParam(name = "sample") LicenceSwitchVO sample);

    /**
     * 分页查询版本切换
     */
    @RequestMapping(LicenceSwitchServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<LicenceSwitch>> queryPagedList(@RequestParam(name = "sample") LicenceSwitchVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.LicenceSwitchController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static LicenceSwitchServiceProxy api() {
        return APIProxy.get(LicenceSwitchServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
