package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetDepreciationDetail;
import com.dt.platform.domain.eam.AssetDepreciationDetailVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 折旧明细  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-03 22:05:32
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDepreciationDetailServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetDepreciationDetailServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-depreciation-detail
     */
    public static final String API_CONTEXT_PATH = "eam-asset-depreciation-detail";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加折旧明细
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除折旧明细
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除折旧明细
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新折旧明细
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存折旧明细
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个折旧明细
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个折旧明细
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询折旧明细
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询折旧明细
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出折旧明细数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载折旧明细导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入折旧明细数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加折旧明细
     */
    @RequestMapping(AssetDepreciationDetailServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetDepreciationDetailVO") AssetDepreciationDetailVO assetDepreciationDetailVO);

    /**
     * 删除折旧明细
     */
    @RequestMapping(AssetDepreciationDetailServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除折旧明细
     */
    @RequestMapping(AssetDepreciationDetailServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新折旧明细
     */
    @RequestMapping(AssetDepreciationDetailServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetDepreciationDetailVO") AssetDepreciationDetailVO assetDepreciationDetailVO);

    /**
     * 更新折旧明细
     */
    @RequestMapping(AssetDepreciationDetailServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetDepreciationDetailVO") AssetDepreciationDetailVO assetDepreciationDetailVO);

    /**
     * 获取折旧明细
     */
    @RequestMapping(AssetDepreciationDetailServiceProxy.GET_BY_ID)
    Result<AssetDepreciationDetail> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个折旧明细
     */
    @RequestMapping(AssetDepreciationDetailServiceProxy.GET_BY_IDS)
    Result<List<AssetDepreciationDetail>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询折旧明细
     */
    @RequestMapping(AssetDepreciationDetailServiceProxy.QUERY_LIST)
    Result<List<AssetDepreciationDetail>> queryList(@RequestParam(name = "sample") AssetDepreciationDetailVO sample);

    /**
     * 分页查询折旧明细
     */
    @RequestMapping(AssetDepreciationDetailServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetDepreciationDetail>> queryPagedList(@RequestParam(name = "sample") AssetDepreciationDetailVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetDepreciationDetailController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetDepreciationDetailServiceProxy api() {
        return APIProxy.get(AssetDepreciationDetailServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
