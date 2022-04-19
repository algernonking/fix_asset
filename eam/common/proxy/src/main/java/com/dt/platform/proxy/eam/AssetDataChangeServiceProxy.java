package com.dt.platform.proxy.eam;

import com.dt.platform.domain.eam.AssetDataChangeRecordVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetDataChange;
import com.dt.platform.domain.eam.AssetDataChangeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 数据变更  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-08 16:01:26
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetDataChangeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetDataChangeServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-data-change
     */
    public static final String API_CONTEXT_PATH = "eam-asset-data-change";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加数据变更
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除数据变更
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除数据变更
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新数据变更
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存数据变更
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个数据变更
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个数据变更
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询数据变更
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询数据变更
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出数据变更数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载数据变更导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入数据变更数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 提交审批
     */
    public static final String FOR_APPROVAL = API_PREFIX + "for-approval";

    /**
     * 审批
     */
    public static final String APPROVE = API_PREFIX + "approve";

    /**
     * 确认操作
     */
    public static final String CONFIRM_OPERATION = API_PREFIX + "confirm-operation";

    /**
     * 撤销操作
     */
    public static final String REVOKE_OPERATION = API_PREFIX + "revoke-operation";

    /**
     * 查询维度
     */
    public static final String QUERY_DATA_CHANGE_DIMENSION_BY_CHANGE_TYPE = API_PREFIX + "query-data-change-dimension-by-change-type";

    /**
     * 查询维度
     */
    @RequestMapping(AssetDataChangeServiceProxy.QUERY_DATA_CHANGE_DIMENSION_BY_CHANGE_TYPE)
    Result queryDataChangeDimensionByChangeType(@RequestParam(name = "changeType") String changeType);

    /**
     * 添加数据变更
     */
    @RequestMapping(AssetDataChangeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetDataChangeVO") AssetDataChangeRecordVO assetDataChangeVO);

    /**
     * 删除数据变更
     */
    @RequestMapping(AssetDataChangeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据变更
     */
    @RequestMapping(AssetDataChangeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新数据变更
     */
    @RequestMapping(AssetDataChangeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetDataChangeVO") AssetDataChangeRecordVO assetDataChangeVO);

    /**
     * 更新数据变更
     */
    @RequestMapping(AssetDataChangeServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetDataChangeVO") AssetDataChangeVO assetDataChangeVO);

    /**
     * 获取数据变更
     */
    @RequestMapping(AssetDataChangeServiceProxy.GET_BY_ID)
    Result<AssetDataChange> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除数据变更
     */
    @RequestMapping(AssetDataChangeServiceProxy.GET_BY_IDS)
    Result<List<AssetDataChange>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询数据变更
     */
    @RequestMapping(AssetDataChangeServiceProxy.QUERY_LIST)
    Result<List<AssetDataChange>> queryList(@RequestParam(name = "sample") AssetDataChangeVO sample);

    /**
     * 分页查询数据变更
     */
    @RequestMapping(AssetDataChangeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetDataChange>> queryPagedList(@RequestParam(name = "sample") AssetDataChangeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetDataChangeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetDataChangeServiceProxy api() {
        return APIProxy.get(AssetDataChangeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
