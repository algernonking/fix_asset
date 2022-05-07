package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.AssetSoftwareChangeDetail;
import com.dt.platform.domain.eam.AssetSoftwareChangeDetailVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 软件变更明细  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-05 15:05:44
 */
@FeignClient(value = ServiceNames.EAM, contextId = AssetSoftwareChangeDetailServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface AssetSoftwareChangeDetailServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-asset-software-change-detail
     */
    public static final String API_CONTEXT_PATH = "eam-asset-software-change-detail";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加软件变更明细
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除软件变更明细
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除软件变更明细
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新软件变更明细
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存软件变更明细
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个软件变更明细
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个软件变更明细
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询软件变更明细
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询软件变更明细
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出软件变更明细数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载软件变更明细导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入软件变更明细数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加软件变更明细
     */
    @RequestMapping(AssetSoftwareChangeDetailServiceProxy.INSERT)
    Result insert(@RequestParam(name = "assetSoftwareChangeDetailVO") AssetSoftwareChangeDetailVO assetSoftwareChangeDetailVO);

    /**
     * 删除软件变更明细
     */
    @RequestMapping(AssetSoftwareChangeDetailServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除软件变更明细
     */
    @RequestMapping(AssetSoftwareChangeDetailServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新软件变更明细
     */
    @RequestMapping(AssetSoftwareChangeDetailServiceProxy.UPDATE)
    Result update(@RequestParam(name = "assetSoftwareChangeDetailVO") AssetSoftwareChangeDetailVO assetSoftwareChangeDetailVO);

    /**
     * 更新软件变更明细
     */
    @RequestMapping(AssetSoftwareChangeDetailServiceProxy.SAVE)
    Result save(@RequestParam(name = "assetSoftwareChangeDetailVO") AssetSoftwareChangeDetailVO assetSoftwareChangeDetailVO);

    /**
     * 获取软件变更明细
     */
    @RequestMapping(AssetSoftwareChangeDetailServiceProxy.GET_BY_ID)
    Result<AssetSoftwareChangeDetail> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个软件变更明细
     */
    @RequestMapping(AssetSoftwareChangeDetailServiceProxy.GET_BY_IDS)
    Result<List<AssetSoftwareChangeDetail>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询软件变更明细
     */
    @RequestMapping(AssetSoftwareChangeDetailServiceProxy.QUERY_LIST)
    Result<List<AssetSoftwareChangeDetail>> queryList(@RequestParam(name = "sample") AssetSoftwareChangeDetailVO sample);

    /**
     * 分页查询软件变更明细
     */
    @RequestMapping(AssetSoftwareChangeDetailServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<AssetSoftwareChangeDetail>> queryPagedList(@RequestParam(name = "sample") AssetSoftwareChangeDetailVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.AssetSoftwareChangeDetailController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static AssetSoftwareChangeDetailServiceProxy api() {
        return APIProxy.get(AssetSoftwareChangeDetailServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
