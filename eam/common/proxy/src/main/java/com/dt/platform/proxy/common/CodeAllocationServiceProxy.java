package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.CodeAllocation;
import com.dt.platform.domain.common.CodeAllocationVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 编码分配  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:26:32
 */
@FeignClient(value = ServiceNames.COMMON, contextId = CodeAllocationServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CodeAllocationServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-code-allocation
     */
    public static final String API_CONTEXT_PATH = "sys-code-allocation";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加编码分配
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除编码分配
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除编码分配
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新编码分配
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存编码分配
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个编码分配
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个编码分配
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询编码分配
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询编码分配
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出编码分配数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载编码分配导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入编码分配数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加编码分配
     */
    @RequestMapping(CodeAllocationServiceProxy.INSERT)
    Result insert(@RequestParam(name = "codeAllocationVO") CodeAllocationVO codeAllocationVO);

    /**
     * 删除编码分配
     */
    @RequestMapping(CodeAllocationServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除编码分配
     */
    @RequestMapping(CodeAllocationServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新编码分配
     */
    @RequestMapping(CodeAllocationServiceProxy.UPDATE)
    Result update(@RequestParam(name = "codeAllocationVO") CodeAllocationVO codeAllocationVO);

    /**
     * 更新编码分配
     */
    @RequestMapping(CodeAllocationServiceProxy.SAVE)
    Result save(@RequestParam(name = "codeAllocationVO") CodeAllocationVO codeAllocationVO);

    /**
     * 获取编码分配
     */
    @RequestMapping(CodeAllocationServiceProxy.GET_BY_ID)
    Result<CodeAllocation> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除编码分配
     */
    @RequestMapping(CodeAllocationServiceProxy.GET_BY_IDS)
    Result<List<CodeAllocation>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询编码分配
     */
    @RequestMapping(CodeAllocationServiceProxy.QUERY_LIST)
    Result<List<CodeAllocation>> queryList(@RequestParam(name = "sample") CodeAllocationVO sample);

    /**
     * 分页查询编码分配
     */
    @RequestMapping(CodeAllocationServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CodeAllocation>> queryPagedList(@RequestParam(name = "sample") CodeAllocationVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.CodeAllocationController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CodeAllocationServiceProxy api() {
        return APIProxy.get(CodeAllocationServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
