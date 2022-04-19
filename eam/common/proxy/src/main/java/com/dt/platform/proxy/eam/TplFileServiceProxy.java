package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.TplFile;
import com.dt.platform.domain.eam.TplFileVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 模板文件  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-09 12:26:05
 */
@FeignClient(value = ServiceNames.EAM, contextId = TplFileServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface TplFileServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-tpl-file
     */
    public static final String API_CONTEXT_PATH = "eam-tpl-file";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加模板文件
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除模板文件
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除模板文件
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新模板文件
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存模板文件
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个模板文件
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个模板文件
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询模板文件
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询模板文件
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出模板文件数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载模板文件导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入模板文件数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加模板文件
     */
    @RequestMapping(TplFileServiceProxy.INSERT)
    Result insert(@RequestParam(name = "tplFileVO") TplFileVO tplFileVO);

    /**
     * 删除模板文件
     */
    @RequestMapping(TplFileServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除模板文件
     */
    @RequestMapping(TplFileServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新模板文件
     */
    @RequestMapping(TplFileServiceProxy.UPDATE)
    Result update(@RequestParam(name = "tplFileVO") TplFileVO tplFileVO);

    /**
     * 更新模板文件
     */
    @RequestMapping(TplFileServiceProxy.SAVE)
    Result save(@RequestParam(name = "tplFileVO") TplFileVO tplFileVO);

    /**
     * 获取模板文件
     */
    @RequestMapping(TplFileServiceProxy.GET_BY_ID)
    Result<TplFile> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除模板文件
     */
    @RequestMapping(TplFileServiceProxy.GET_BY_IDS)
    Result<List<TplFile>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询模板文件
     */
    @RequestMapping(TplFileServiceProxy.QUERY_LIST)
    Result<List<TplFile>> queryList(@RequestParam(name = "sample") TplFileVO sample);

    /**
     * 分页查询模板文件
     */
    @RequestMapping(TplFileServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<TplFile>> queryPagedList(@RequestParam(name = "sample") TplFileVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.TplFileController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static TplFileServiceProxy api() {
        return APIProxy.get(TplFileServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
