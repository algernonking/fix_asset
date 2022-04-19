package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.ApproveConfigure;
import com.dt.platform.domain.eam.ApproveConfigureVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 资产审批配置  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:27:16
 */
@FeignClient(value = ServiceNames.EAM, contextId = ApproveConfigureServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ApproveConfigureServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-approve-configure
     */
    public static final String API_CONTEXT_PATH = "eam-approve-configure";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产审批配置
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产审批配置
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产审批配置
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产审批配置
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产审批配置
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产审批配置
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产审批配置
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产审批配置
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产审批配置
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出资产审批配置数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载资产审批配置导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入资产审批配置数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加资产审批配置
     */
    @RequestMapping(ApproveConfigureServiceProxy.INSERT)
    Result insert(@RequestParam(name = "approveConfigureVO") ApproveConfigureVO approveConfigureVO);

    /**
     * 删除资产审批配置
     */
    @RequestMapping(ApproveConfigureServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产审批配置
     */
    @RequestMapping(ApproveConfigureServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产审批配置
     */
    @RequestMapping(ApproveConfigureServiceProxy.UPDATE)
    Result update(@RequestParam(name = "approveConfigureVO") ApproveConfigureVO approveConfigureVO);

    /**
     * 更新资产审批配置
     */
    @RequestMapping(ApproveConfigureServiceProxy.SAVE)
    Result save(@RequestParam(name = "approveConfigureVO") ApproveConfigureVO approveConfigureVO);

    /**
     * 获取资产审批配置
     */
    @RequestMapping(ApproveConfigureServiceProxy.GET_BY_ID)
    Result<ApproveConfigure> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产审批配置
     */
    @RequestMapping(ApproveConfigureServiceProxy.GET_BY_IDS)
    Result<List<ApproveConfigure>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产审批配置
     */
    @RequestMapping(ApproveConfigureServiceProxy.QUERY_LIST)
    Result<List<ApproveConfigure>> queryList(@RequestParam(name = "sample") ApproveConfigureVO sample);

    /**
     * 分页查询资产审批配置
     */
    @RequestMapping(ApproveConfigureServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ApproveConfigure>> queryPagedList(@RequestParam(name = "sample") ApproveConfigureVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.ApproveConfigureController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ApproveConfigureServiceProxy api() {
        return APIProxy.get(ApproveConfigureServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
