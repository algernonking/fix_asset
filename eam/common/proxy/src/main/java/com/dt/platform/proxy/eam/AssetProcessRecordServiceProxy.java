package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetProcessRecord;
import com.dt.platform.domain.eam.AssetProcessRecordVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 资产处理记录  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:26:54
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetProcessRecordServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetProcessRecordServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-process-record
     */
    public static final String API_CONTEXT_PATH = "eam-asset-process-record";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加资产处理记录
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除资产处理记录
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除资产处理记录
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新资产处理记录
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存资产处理记录
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个资产处理记录
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个资产处理记录
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询资产处理记录
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询资产处理记录
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出资产处理记录数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载资产处理记录导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入资产处理记录数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加资产处理记录
     */
    @RequestMapping(AssetProcessRecordServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetProcessRecordVO") AssetProcessRecordVO assetProcessRecordVO);

    /**
     * 删除资产处理记录
     */
    @RequestMapping(AssetProcessRecordServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产处理记录
     */
    @RequestMapping(AssetProcessRecordServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新资产处理记录
     */
    @RequestMapping(AssetProcessRecordServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetProcessRecordVO") AssetProcessRecordVO assetProcessRecordVO);

    /**
     * 更新资产处理记录
     */
    @RequestMapping(AssetProcessRecordServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetProcessRecordVO") AssetProcessRecordVO assetProcessRecordVO);

    /**
     * 获取资产处理记录
     */
    @RequestMapping(AssetProcessRecordServiceProxy.GET_BY_ID)
    Result<AssetProcessRecord> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除资产处理记录
     */
    @RequestMapping(AssetProcessRecordServiceProxy.GET_BY_IDS)
    Result<List<AssetProcessRecord>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询资产处理记录
     */
    @RequestMapping(AssetProcessRecordServiceProxy.QUERY_LIST)
    Result<List<AssetProcessRecord>> queryList(@RequestParam(name = "sample") AssetProcessRecordVO sample);

    /**
     * 分页查询资产处理记录
     */
    @RequestMapping(AssetProcessRecordServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetProcessRecord>> queryPagedList(@RequestParam(name = "sample") AssetProcessRecordVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetProcessRecordController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetProcessRecordServiceProxy api() {
        return APIProxy.get(AssetProcessRecordServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
