package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.CodeRegister;
import com.dt.platform.domain.common.CodeRegisterVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 业务编码  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:26:22
 */
@FeignClient(value = ServiceNames.COMMON, contextId = CodeRegisterServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CodeRegisterServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-code-register
     */
    public static final String API_CONTEXT_PATH = "sys-code-register";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加业务编码
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除业务编码
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除业务编码
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新业务编码
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存业务编码
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个业务编码
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个业务编码
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询业务编码
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询业务编码
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出业务编码数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载业务编码导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入业务编码数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加业务编码
     */
    @RequestMapping(CodeRegisterServiceProxy.INSERT)
    Result insert(@RequestParam(name = "codeRegisterVO") CodeRegisterVO codeRegisterVO);

    /**
     * 删除业务编码
     */
    @RequestMapping(CodeRegisterServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除业务编码
     */
    @RequestMapping(CodeRegisterServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新业务编码
     */
    @RequestMapping(CodeRegisterServiceProxy.UPDATE)
    Result update(@RequestParam(name = "codeRegisterVO") CodeRegisterVO codeRegisterVO);

    /**
     * 更新业务编码
     */
    @RequestMapping(CodeRegisterServiceProxy.SAVE)
    Result save(@RequestParam(name = "codeRegisterVO") CodeRegisterVO codeRegisterVO);

    /**
     * 获取业务编码
     */
    @RequestMapping(CodeRegisterServiceProxy.GET_BY_ID)
    Result<CodeRegister> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除业务编码
     */
    @RequestMapping(CodeRegisterServiceProxy.GET_BY_IDS)
    Result<List<CodeRegister>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询业务编码
     */
    @RequestMapping(CodeRegisterServiceProxy.QUERY_LIST)
    Result<List<CodeRegister>> queryList(@RequestParam(name = "sample") CodeRegisterVO sample);

    /**
     * 分页查询业务编码
     */
    @RequestMapping(CodeRegisterServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CodeRegister>> queryPagedList(@RequestParam(name = "sample") CodeRegisterVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.CodeRegisterController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CodeRegisterServiceProxy api() {
        return APIProxy.get(CodeRegisterServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
