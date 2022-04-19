package com.dt.platform.proxy.eam;

import com.dt.platform.domain.eam.meta.AssetAttributeItemMeta;
import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetAttributeItem;
import com.dt.platform.domain.eam.AssetAttributeItemVO;
import java.util.HashMap;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 资产字段配置项  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-07 14:32:58
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetAttributeItemServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetAttributeItemServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-attribute-item
     */
    public static final String API_CONTEXT_PATH = "eam-asset-attribute-item";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产字段配置项
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产字段配置项
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产字段配置项
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产字段配置项
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产字段配置项
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产字段配置项
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产字段配置项
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产字段配置项
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产字段配置项
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 分页查询资产字段配置项
     */
    public static final String QUERY_FORM_COLUMN_BY_MODULE = API_PREFIX + "query-form-column-by-module";

    /**
     * 分页查询资产字段配置项
     */
    public static final String QUERY_LIST_COLUMN_BY_MODULE = API_PREFIX + "query-list-column-by-module";

    /**
     * 导出资产字段配置项数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载资产字段配置项导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入资产字段配置项数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加资产字段配置项
     */
    @RequestMapping(AssetAttributeItemServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetAttributeItemVO") AssetAttributeItemVO assetAttributeItemVO);

    /**
     * 删除资产字段配置项
     */
    @RequestMapping(AssetAttributeItemServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产字段配置项
     */
    @RequestMapping(AssetAttributeItemServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产字段配置项
     */
    @RequestMapping(AssetAttributeItemServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetAttributeItemVO") AssetAttributeItemVO assetAttributeItemVO);

    /**
     * 更新资产字段配置项
     */
    @RequestMapping(AssetAttributeItemServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetAttributeItemVO") AssetAttributeItemVO assetAttributeItemVO);

    /**
     * 获取资产字段配置项
     */
    @RequestMapping(AssetAttributeItemServiceProxy.GET_BY_ID)
    Result<AssetAttributeItem> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产字段配置项
     */
    @RequestMapping(AssetAttributeItemServiceProxy.GET_BY_IDS)
    Result<List<AssetAttributeItem>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产字段配置项
     */
    @RequestMapping(AssetAttributeItemServiceProxy.QUERY_LIST)
    Result<List<AssetAttributeItem>> queryList(@RequestParam(name = "sample") AssetAttributeItemVO sample);

    /**
     * 分页查询资产字段配置项
     */
    @RequestMapping(AssetAttributeItemServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetAttributeItem>> queryPagedList(@RequestParam(name = "sample") AssetAttributeItemVO sample);

    /**
     * 分页查询资产字段配置项
     */
    @RequestMapping(AssetAttributeItemServiceProxy.QUERY_FORM_COLUMN_BY_MODULE)
    Result<HashMap<String, List<AssetAttributeItem>>> queryFormColumnByModule(@RequestParam(name = "module") String module, @RequestParam(name = "dim") String dim);

    @RequestMapping(AssetAttributeItemServiceProxy.QUERY_LIST_COLUMN_BY_MODULE)
    Result<HashMap<String, List<AssetAttributeItem>>> queryListColumnByModule(@RequestParam(name = "module") String module, @RequestParam(name = "dim") String dim);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetAttributeItemController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetAttributeItemServiceProxy api() {
        return APIProxy.get(AssetAttributeItemServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
