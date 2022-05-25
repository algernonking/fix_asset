package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.CodePart;
import com.dt.platform.domain.eam.CodePartVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 编码字段  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 21:06:36
 */
@FeignClient(value = ServiceNames.EAM, contextId = CodePartServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CodePartServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-code-part
     */
    public static final String API_CONTEXT_PATH = "eam-code-part";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加编码字段
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除编码字段
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除编码字段
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新编码字段
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存编码字段
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个编码字段
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个编码字段
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询编码字段
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询编码字段
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出编码字段数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载编码字段导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入编码字段数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加编码字段
     */
    @RequestMapping(CodePartServiceProxy.INSERT)
    Result insert(@RequestParam(name = "codePartVO") CodePartVO codePartVO);

    /**
     * 删除编码字段
     */
    @RequestMapping(CodePartServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除编码字段
     */
    @RequestMapping(CodePartServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新编码字段
     */
    @RequestMapping(CodePartServiceProxy.UPDATE)
    Result update(@RequestParam(name = "codePartVO") CodePartVO codePartVO);

    /**
     * 更新编码字段
     */
    @RequestMapping(CodePartServiceProxy.SAVE)
    Result save(@RequestParam(name = "codePartVO") CodePartVO codePartVO);

    /**
     * 获取编码字段
     */
    @RequestMapping(CodePartServiceProxy.GET_BY_ID)
    Result<CodePart> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个编码字段
     */
    @RequestMapping(CodePartServiceProxy.GET_BY_IDS)
    Result<List<CodePart>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询编码字段
     */
    @RequestMapping(CodePartServiceProxy.QUERY_LIST)
    Result<List<CodePart>> queryList(@RequestParam(name = "sample") CodePartVO sample);

    /**
     * 分页查询编码字段
     */
    @RequestMapping(CodePartServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CodePart>> queryPagedList(@RequestParam(name = "sample") CodePartVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.CodePartController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CodePartServiceProxy api() {
        return APIProxy.get(CodePartServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
