package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.Safetylevel;
import com.dt.platform.domain.eam.SafetylevelVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 风险等级  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:28:10
 */
@FeignClient(value = ServiceNames.EAM, contextId = SafetylevelServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface SafetylevelServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-safetylevel
     */
    public static final String API_CONTEXT_PATH = "eam-safetylevel";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加风险等级
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除风险等级
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除风险等级
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新风险等级
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存风险等级
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个风险等级
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个风险等级
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询风险等级
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询风险等级
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出风险等级数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载风险等级导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入风险等级数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加风险等级
     */
    @RequestMapping(SafetylevelServiceProxy.INSERT)
    Result insert(@RequestParam(name = "safetylevelVO") SafetylevelVO safetylevelVO);

    /**
     * 删除风险等级
     */
    @RequestMapping(SafetylevelServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除风险等级
     */
    @RequestMapping(SafetylevelServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新风险等级
     */
    @RequestMapping(SafetylevelServiceProxy.UPDATE)
    Result update(@RequestParam(name = "safetylevelVO") SafetylevelVO safetylevelVO);

    /**
     * 更新风险等级
     */
    @RequestMapping(SafetylevelServiceProxy.SAVE)
    Result save(@RequestParam(name = "safetylevelVO") SafetylevelVO safetylevelVO);

    /**
     * 获取风险等级
     */
    @RequestMapping(SafetylevelServiceProxy.GET_BY_ID)
    Result<Safetylevel> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除风险等级
     */
    @RequestMapping(SafetylevelServiceProxy.GET_BY_IDS)
    Result<List<Safetylevel>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询风险等级
     */
    @RequestMapping(SafetylevelServiceProxy.QUERY_LIST)
    Result<List<Safetylevel>> queryList(@RequestParam(name = "sample") SafetylevelVO sample);

    /**
     * 分页查询风险等级
     */
    @RequestMapping(SafetylevelServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Safetylevel>> queryPagedList(@RequestParam(name = "sample") SafetylevelVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.SafetylevelController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static SafetylevelServiceProxy api() {
        return APIProxy.get(SafetylevelServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
