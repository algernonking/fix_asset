package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.BrandDemo;
import com.dt.platform.domain.eam.BrandDemoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 品牌  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-01 19:16:13
 */
@FeignClient(value = ServiceNames.EAM, contextId = BrandDemoServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface BrandDemoServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-brand-demo
     */
    public static final String API_CONTEXT_PATH = "eam-brand-demo";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加品牌
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除品牌
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除品牌
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新品牌
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存品牌
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个品牌
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个品牌
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询品牌
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询品牌
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出品牌数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载品牌导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入品牌数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加品牌
     */
    @RequestMapping(BrandDemoServiceProxy.INSERT)
    Result insert(@RequestParam(name = "brandDemoVO") BrandDemoVO brandDemoVO);

    /**
     * 删除品牌
     */
    @RequestMapping(BrandDemoServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除品牌
     */
    @RequestMapping(BrandDemoServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新品牌
     */
    @RequestMapping(BrandDemoServiceProxy.UPDATE)
    Result update(@RequestParam(name = "brandDemoVO") BrandDemoVO brandDemoVO);

    /**
     * 更新品牌
     */
    @RequestMapping(BrandDemoServiceProxy.SAVE)
    Result save(@RequestParam(name = "brandDemoVO") BrandDemoVO brandDemoVO);

    /**
     * 获取品牌
     */
    @RequestMapping(BrandDemoServiceProxy.GET_BY_ID)
    Result<BrandDemo> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除品牌
     */
    @RequestMapping(BrandDemoServiceProxy.GET_BY_IDS)
    Result<List<BrandDemo>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询品牌
     */
    @RequestMapping(BrandDemoServiceProxy.QUERY_LIST)
    Result<List<BrandDemo>> queryList(@RequestParam(name = "sample") BrandDemoVO sample);

    /**
     * 分页查询品牌
     */
    @RequestMapping(BrandDemoServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<BrandDemo>> queryPagedList(@RequestParam(name = "sample") BrandDemoVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.BrandDemoController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static BrandDemoServiceProxy api() {
        return APIProxy.get(BrandDemoServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
