package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetDepreciationOper;
import com.dt.platform.domain.eam.AssetDepreciationOperVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 折旧操作  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-03 09:03:39
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDepreciationOperServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetDepreciationOperServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-depreciation-oper
     */
    public static final String API_CONTEXT_PATH = "eam-asset-depreciation-oper";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加折旧操作
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除折旧操作
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除折旧操作
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新折旧操作
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存折旧操作
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个折旧操作
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个折旧操作
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询折旧操作
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询折旧操作
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出折旧操作数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载折旧操作导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入折旧操作数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加折旧操作
     */
    @RequestMapping(AssetDepreciationOperServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetDepreciationOperVO") AssetDepreciationOperVO assetDepreciationOperVO);

    /**
     * 删除折旧操作
     */
    @RequestMapping(AssetDepreciationOperServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除折旧操作
     */
    @RequestMapping(AssetDepreciationOperServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新折旧操作
     */
    @RequestMapping(AssetDepreciationOperServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetDepreciationOperVO") AssetDepreciationOperVO assetDepreciationOperVO);

    /**
     * 更新折旧操作
     */
    @RequestMapping(AssetDepreciationOperServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetDepreciationOperVO") AssetDepreciationOperVO assetDepreciationOperVO);

    /**
     * 获取折旧操作
     */
    @RequestMapping(AssetDepreciationOperServiceProxy.GET_BY_ID)
    Result<AssetDepreciationOper> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个折旧操作
     */
    @RequestMapping(AssetDepreciationOperServiceProxy.GET_BY_IDS)
    Result<List<AssetDepreciationOper>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询折旧操作
     */
    @RequestMapping(AssetDepreciationOperServiceProxy.QUERY_LIST)
    Result<List<AssetDepreciationOper>> queryList(@RequestParam(name = "sample") AssetDepreciationOperVO sample);

    /**
     * 分页查询折旧操作
     */
    @RequestMapping(AssetDepreciationOperServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetDepreciationOper>> queryPagedList(@RequestParam(name = "sample") AssetDepreciationOperVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetDepreciationOperController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetDepreciationOperServiceProxy api() {
        return APIProxy.get(AssetDepreciationOperServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
