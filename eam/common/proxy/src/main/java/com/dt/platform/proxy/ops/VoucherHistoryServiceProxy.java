package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.VoucherHistory;
import com.dt.platform.domain.ops.VoucherHistoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 凭证记录  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-04 00:03:34
 */
@FeignClient(value = ServiceNames.OPS, contextId = VoucherHistoryServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface VoucherHistoryServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-voucher-history
     */
    public static final String API_CONTEXT_PATH = "ops-voucher-history";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加凭证记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除凭证记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除凭证记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新凭证记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存凭证记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个凭证记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个凭证记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询凭证记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询凭证记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出凭证记录数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载凭证记录导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入凭证记录数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加凭证记录
     */
    @RequestMapping(VoucherHistoryServiceProxy.INSERT)
    Result insert(@RequestParam(name = "voucherHistoryVO") VoucherHistoryVO voucherHistoryVO);

    /**
     * 删除凭证记录
     */
    @RequestMapping(VoucherHistoryServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除凭证记录
     */
    @RequestMapping(VoucherHistoryServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新凭证记录
     */
    @RequestMapping(VoucherHistoryServiceProxy.UPDATE)
    Result update(@RequestParam(name = "voucherHistoryVO") VoucherHistoryVO voucherHistoryVO);

    /**
     * 更新凭证记录
     */
    @RequestMapping(VoucherHistoryServiceProxy.SAVE)
    Result save(@RequestParam(name = "voucherHistoryVO") VoucherHistoryVO voucherHistoryVO);

    /**
     * 获取凭证记录
     */
    @RequestMapping(VoucherHistoryServiceProxy.GET_BY_ID)
    Result<VoucherHistory> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除凭证记录
     */
    @RequestMapping(VoucherHistoryServiceProxy.GET_BY_IDS)
    Result<List<VoucherHistory>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询凭证记录
     */
    @RequestMapping(VoucherHistoryServiceProxy.QUERY_LIST)
    Result<List<VoucherHistory>> queryList(@RequestParam(name = "sample") VoucherHistoryVO sample);

    /**
     * 分页查询凭证记录
     */
    @RequestMapping(VoucherHistoryServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<VoucherHistory>> queryPagedList(@RequestParam(name = "sample") VoucherHistoryVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.VoucherHistoryController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static VoucherHistoryServiceProxy api() {
        return APIProxy.get(VoucherHistoryServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
