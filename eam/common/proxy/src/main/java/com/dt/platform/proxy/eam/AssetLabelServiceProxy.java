package com.dt.platform.proxy.eam;

import com.dt.platform.domain.eam.AssetLabelTpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetLabel;
import com.dt.platform.domain.eam.AssetLabelVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产标签  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-21 07:16:58
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetLabelServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetLabelServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-label
     */
    public static final String API_CONTEXT_PATH = "eam-asset-label";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产标签
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产标签
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产标签
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产标签
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产标签
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产标签
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产标签
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产标签
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产标签
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出资产标签数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载资产标签导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入资产标签数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    public static final String QUERY_ASSET_LABEL = API_PREFIX + "query-asset-label";

    public static final String SAVE_ASSET_LABEL = API_PREFIX + "save-asset-label";

    public static final String SAVE_ASSET_LABEL_CUSTOM_TPL = API_PREFIX + "save-asset-label-custom-tpl";

    @RequestMapping(AssetLabelServiceProxy.QUERY_ASSET_LABEL)
    Result<AssetLabel> queryAssetLabel();

    @RequestMapping(AssetLabelServiceProxy.SAVE_ASSET_LABEL)
    Result saveAssetLabel(@RequestParam(name = "label") AssetLabel label);

    @RequestMapping(AssetLabelServiceProxy.SAVE_ASSET_LABEL_CUSTOM_TPL)
    Result saveAssetLabelCustomTpl(@RequestParam(name = "tpl") AssetLabelTpl tpl);

    /**
     * 添加资产标签
     */
    @RequestMapping(AssetLabelServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetLabelVO") AssetLabelVO assetLabelVO);

    /**
     * 删除资产标签
     */
    @RequestMapping(AssetLabelServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产标签
     */
    @RequestMapping(AssetLabelServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产标签
     */
    @RequestMapping(AssetLabelServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetLabelVO") AssetLabelVO assetLabelVO);

    /**
     * 更新资产标签
     */
    @RequestMapping(AssetLabelServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetLabelVO") AssetLabelVO assetLabelVO);

    /**
     * 获取资产标签
     */
    @RequestMapping(AssetLabelServiceProxy.GET_BY_ID)
    Result<AssetLabel> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个资产标签
     */
    @RequestMapping(AssetLabelServiceProxy.GET_BY_IDS)
    Result<List<AssetLabel>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产标签
     */
    @RequestMapping(AssetLabelServiceProxy.QUERY_LIST)
    Result<List<AssetLabel>> queryList(@RequestParam(name = "sample") AssetLabelVO sample);

    /**
     * 分页查询资产标签
     */
    @RequestMapping(AssetLabelServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetLabel>> queryPagedList(@RequestParam(name = "sample") AssetLabelVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetLabelController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetLabelServiceProxy api() {
        return APIProxy.get(AssetLabelServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
