package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetSoftware;
import com.dt.platform.domain.eam.AssetSoftwareVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 软件资产  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-04 19:59:02
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetSoftwareServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetSoftwareServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-software
     */
    public static final String API_CONTEXT_PATH = "eam-asset-software";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加软件资产
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除软件资产
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除软件资产
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新软件资产
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存软件资产
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个软件资产
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个软件资产
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询软件资产
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询软件资产
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出软件资产数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载软件资产导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入软件资产数据(Excel)
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


    public static final String QUERY_PAGED_LIST_BY_SELECTED = API_PREFIX + "query-paged-list-by-selected";

    public static final String QUERY_PAGED_LIST_BY_SELECT = API_PREFIX + "query-paged-list-by-select";

    public static final String ASSET_SELECTED = API_PREFIX + "asset-selected";


    /**
     * 添加软件资产
     */
    @RequestMapping(AssetSoftwareServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetSoftwareVO") AssetSoftwareVO assetSoftwareVO);

    /**
     * 删除软件资产
     */
    @RequestMapping(AssetSoftwareServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除软件资产
     */
    @RequestMapping(AssetSoftwareServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新软件资产
     */
    @RequestMapping(AssetSoftwareServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetSoftwareVO") AssetSoftwareVO assetSoftwareVO);

    /**
     * 更新软件资产
     */
    @RequestMapping(AssetSoftwareServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetSoftwareVO") AssetSoftwareVO assetSoftwareVO);

    /**
     * 获取软件资产
     */
    @RequestMapping(AssetSoftwareServiceProxy.GET_BY_ID)
    Result<AssetSoftware> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个软件资产
     */
    @RequestMapping(AssetSoftwareServiceProxy.GET_BY_IDS)
    Result<List<AssetSoftware>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询软件资产
     */
    @RequestMapping(AssetSoftwareServiceProxy.QUERY_LIST)
    Result<List<AssetSoftware>> queryList(@RequestParam(name = "sample") AssetSoftwareVO sample);

    /**
     * 分页查询软件资产
     */
    @RequestMapping(AssetSoftwareServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetSoftware>> queryPagedList(@RequestParam(name = "sample") AssetSoftwareVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetSoftwareController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetSoftwareServiceProxy api() {
        return APIProxy.get(AssetSoftwareServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
