package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.Voucher;
import com.dt.platform.domain.ops.VoucherVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 凭证  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-03 21:36:08
 */
@FeignClient(value = ServiceNames.OPS, contextId = VoucherServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface VoucherServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-voucher
     */
    public static final String API_CONTEXT_PATH = "ops-voucher";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加凭证
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除凭证
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除凭证
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新凭证
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存凭证
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个凭证
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个凭证
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询凭证
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询凭证
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出凭证数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载凭证导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入凭证数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加凭证
     */
    @RequestMapping(VoucherServiceProxy.INSERT)
    Result insert(@RequestParam(name = "voucherVO") VoucherVO voucherVO);

    /**
     * 删除凭证
     */
    @RequestMapping(VoucherServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除凭证
     */
    @RequestMapping(VoucherServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新凭证
     */
    @RequestMapping(VoucherServiceProxy.UPDATE)
    Result update(@RequestParam(name = "voucherVO") VoucherVO voucherVO);

    /**
     * 更新凭证
     */
    @RequestMapping(VoucherServiceProxy.SAVE)
    Result save(@RequestParam(name = "voucherVO") VoucherVO voucherVO);

    /**
     * 获取凭证
     */
    @RequestMapping(VoucherServiceProxy.GET_BY_ID)
    Result<Voucher> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除凭证
     */
    @RequestMapping(VoucherServiceProxy.GET_BY_IDS)
    Result<List<Voucher>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询凭证
     */
    @RequestMapping(VoucherServiceProxy.QUERY_LIST)
    Result<List<Voucher>> queryList(@RequestParam(name = "sample") VoucherVO sample);

    /**
     * 分页查询凭证
     */
    @RequestMapping(VoucherServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Voucher>> queryPagedList(@RequestParam(name = "sample") VoucherVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.VoucherController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static VoucherServiceProxy api() {
        return APIProxy.get(VoucherServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
