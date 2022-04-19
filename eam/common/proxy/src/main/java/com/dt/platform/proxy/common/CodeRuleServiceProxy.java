package com.dt.platform.proxy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.common.CodeRule;
import com.dt.platform.domain.common.CodeRuleVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 编码规则  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:26:42
 */
@FeignClient(value = ServiceNames.COMMON, contextId = CodeRuleServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CodeRuleServiceProxy {

    /**
     * 基础路径 , service-common
     */
    public static final String API_BASIC_PATH = "service-common";

    /**
     * API 上下文路径 , sys-code-rule
     */
    public static final String API_CONTEXT_PATH = "sys-code-rule";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加编码规则
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除编码规则
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除编码规则
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新编码规则
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存编码规则
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个编码规则
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个编码规则
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询编码规则
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询编码规则
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出编码规则数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载编码规则导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入编码规则数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加编码规则
     */
    @RequestMapping(CodeRuleServiceProxy.INSERT)
    Result insert(@RequestParam(name = "codeRuleVO") CodeRuleVO codeRuleVO);

    /**
     * 删除编码规则
     */
    @RequestMapping(CodeRuleServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除编码规则
     */
    @RequestMapping(CodeRuleServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新编码规则
     */
    @RequestMapping(CodeRuleServiceProxy.UPDATE)
    Result update(@RequestParam(name = "codeRuleVO") CodeRuleVO codeRuleVO);

    /**
     * 更新编码规则
     */
    @RequestMapping(CodeRuleServiceProxy.SAVE)
    Result save(@RequestParam(name = "codeRuleVO") CodeRuleVO codeRuleVO);

    /**
     * 获取编码规则
     */
    @RequestMapping(CodeRuleServiceProxy.GET_BY_ID)
    Result<CodeRule> getById(@RequestParam(name = "id") String id);

    /**
     * 批量删除编码规则
     */
    @RequestMapping(CodeRuleServiceProxy.GET_BY_IDS)
    Result<List<CodeRule>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询编码规则
     */
    @RequestMapping(CodeRuleServiceProxy.QUERY_LIST)
    Result<List<CodeRule>> queryList(@RequestParam(name = "sample") CodeRuleVO sample);

    /**
     * 分页查询编码规则
     */
    @RequestMapping(CodeRuleServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CodeRule>> queryPagedList(@RequestParam(name = "sample") CodeRuleVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.common.controller.CodeRuleController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CodeRuleServiceProxy api() {
        return APIProxy.get(CodeRuleServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
