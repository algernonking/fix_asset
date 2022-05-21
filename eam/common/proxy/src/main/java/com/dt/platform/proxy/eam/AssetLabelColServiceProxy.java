package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetLabelCol;
import com.dt.platform.domain.eam.AssetLabelColVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 标签字段  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-20 21:16:59
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetLabelColServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetLabelColServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-label-col
     */
    public static final String API_CONTEXT_PATH = "eam-asset-label-col";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加标签字段
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除标签字段
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除标签字段
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新标签字段
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存标签字段
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个标签字段
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个标签字段
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询标签字段
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询标签字段
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出标签字段数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载标签字段导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入标签字段数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加标签字段
     */
    @RequestMapping(AssetLabelColServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetLabelColVO") AssetLabelColVO assetLabelColVO);

    /**
     * 删除标签字段
     */
    @RequestMapping(AssetLabelColServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除标签字段
     */
    @RequestMapping(AssetLabelColServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新标签字段
     */
    @RequestMapping(AssetLabelColServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetLabelColVO") AssetLabelColVO assetLabelColVO);

    /**
     * 更新标签字段
     */
    @RequestMapping(AssetLabelColServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetLabelColVO") AssetLabelColVO assetLabelColVO);

    /**
     * 获取标签字段
     */
    @RequestMapping(AssetLabelColServiceProxy.GET_BY_ID)
    Result<AssetLabelCol> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个标签字段
     */
    @RequestMapping(AssetLabelColServiceProxy.GET_BY_IDS)
    Result<List<AssetLabelCol>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询标签字段
     */
    @RequestMapping(AssetLabelColServiceProxy.QUERY_LIST)
    Result<List<AssetLabelCol>> queryList(@RequestParam(name = "sample") AssetLabelColVO sample);

    /**
     * 分页查询标签字段
     */
    @RequestMapping(AssetLabelColServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetLabelCol>> queryPagedList(@RequestParam(name = "sample") AssetLabelColVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetLabelColController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetLabelColServiceProxy api() {
        return APIProxy.get(AssetLabelColServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
