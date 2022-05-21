package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetLabelPaper;
import com.dt.platform.domain.eam.AssetLabelPaperVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 纸张类型  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-20 21:19:26
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetLabelPaperServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetLabelPaperServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-label-paper
     */
    public static final String API_CONTEXT_PATH = "eam-asset-label-paper";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加纸张类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除纸张类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除纸张类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新纸张类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存纸张类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个纸张类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个纸张类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询纸张类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询纸张类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出纸张类型数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载纸张类型导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入纸张类型数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加纸张类型
     */
    @RequestMapping(AssetLabelPaperServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetLabelPaperVO") AssetLabelPaperVO assetLabelPaperVO);

    /**
     * 删除纸张类型
     */
    @RequestMapping(AssetLabelPaperServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除纸张类型
     */
    @RequestMapping(AssetLabelPaperServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新纸张类型
     */
    @RequestMapping(AssetLabelPaperServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetLabelPaperVO") AssetLabelPaperVO assetLabelPaperVO);

    /**
     * 更新纸张类型
     */
    @RequestMapping(AssetLabelPaperServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetLabelPaperVO") AssetLabelPaperVO assetLabelPaperVO);

    /**
     * 获取纸张类型
     */
    @RequestMapping(AssetLabelPaperServiceProxy.GET_BY_ID)
    Result<AssetLabelPaper> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个纸张类型
     */
    @RequestMapping(AssetLabelPaperServiceProxy.GET_BY_IDS)
    Result<List<AssetLabelPaper>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询纸张类型
     */
    @RequestMapping(AssetLabelPaperServiceProxy.QUERY_LIST)
    Result<List<AssetLabelPaper>> queryList(@RequestParam(name = "sample") AssetLabelPaperVO sample);

    /**
     * 分页查询纸张类型
     */
    @RequestMapping(AssetLabelPaperServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetLabelPaper>> queryPagedList(@RequestParam(name = "sample") AssetLabelPaperVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetLabelPaperController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetLabelPaperServiceProxy api() {
        return APIProxy.get(AssetLabelPaperServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
