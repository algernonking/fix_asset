package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetStorage;
import com.dt.platform.domain.eam.AssetStorageVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产入库  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-19 13:26:20
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetStorageServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetStorageServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-storage
     */
    public static final String API_CONTEXT_PATH = "eam-asset-storage";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产入库
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产入库
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产入库
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产入库
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产入库
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产入库
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产入库
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产入库
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产入库
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出资产入库数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载资产入库导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入资产入库数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 审批
     */
    public static final String APPROVE = API_PREFIX + "approve";

    /**
     * 提交审批
     */
    public static final String FOR_APPROVAL = API_PREFIX + "for-approval";

    /**
     * 确认操作
     */
    public static final String CONFIRM_OPERATION = API_PREFIX + "confirm-operation";

    /**
     * 撤销操作
     */
    public static final String REVOKE_OPERATION = API_PREFIX + "revoke-operation";

    /**
     * 添加资产入库
     */
    @RequestMapping(AssetStorageServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetStorageVO") AssetStorageVO assetStorageVO);

    /**
     * 删除资产入库
     */
    @RequestMapping(AssetStorageServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产入库
     */
    @RequestMapping(AssetStorageServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产入库
     */
    @RequestMapping(AssetStorageServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetStorageVO") AssetStorageVO assetStorageVO);

    /**
     * 更新资产入库
     */
    @RequestMapping(AssetStorageServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetStorageVO") AssetStorageVO assetStorageVO);

    /**
     * 获取资产入库
     */
    @RequestMapping(AssetStorageServiceProxy.GET_BY_ID)
    Result<AssetStorage> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个资产入库
     */
    @RequestMapping(AssetStorageServiceProxy.GET_BY_IDS)
    Result<List<AssetStorage>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产入库
     */
    @RequestMapping(AssetStorageServiceProxy.QUERY_LIST)
    Result<List<AssetStorage>> queryList(@RequestParam(name = "sample") AssetStorageVO sample);

    /**
     * 分页查询资产入库
     */
    @RequestMapping(AssetStorageServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetStorage>> queryPagedList(@RequestParam(name = "sample") AssetStorageVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetStorageController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetStorageServiceProxy api() {
        return APIProxy.get(AssetStorageServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
