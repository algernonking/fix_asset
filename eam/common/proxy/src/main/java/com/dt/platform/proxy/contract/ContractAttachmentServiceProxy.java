package com.dt.platform.proxy.contract;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.contract.ContractAttachment;
import com.dt.platform.domain.contract.ContractAttachmentVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 合同附件  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-28 15:44:51
 */
@FeignClient(value = ServiceNames.CONTRACT, contextId = ContractAttachmentServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ContractAttachmentServiceProxy {

    /**
     * 基础路径 , service-contract
     */
    public static final String API_BASIC_PATH = "service-contract";

    /**
     * API 上下文路径 , cont-contract-attachment
     */
    public static final String API_CONTEXT_PATH = "cont-contract-attachment";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加合同附件
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除合同附件
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除合同附件
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新合同附件
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存合同附件
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个合同附件
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个合同附件
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询合同附件
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询合同附件
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出合同附件数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载合同附件导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入合同附件数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加合同附件
     */
    @RequestMapping(ContractAttachmentServiceProxy.INSERT)
    Result insert(@RequestParam(name = "contractAttachmentVO") ContractAttachmentVO contractAttachmentVO);

    /**
     * 删除合同附件
     */
    @RequestMapping(ContractAttachmentServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除合同附件
     */
    @RequestMapping(ContractAttachmentServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新合同附件
     */
    @RequestMapping(ContractAttachmentServiceProxy.UPDATE)
    Result update(@RequestParam(name = "contractAttachmentVO") ContractAttachmentVO contractAttachmentVO);

    /**
     * 更新合同附件
     */
    @RequestMapping(ContractAttachmentServiceProxy.SAVE)
    Result save(@RequestParam(name = "contractAttachmentVO") ContractAttachmentVO contractAttachmentVO);

    /**
     * 获取合同附件
     */
    @RequestMapping(ContractAttachmentServiceProxy.GET_BY_ID)
    Result<ContractAttachment> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个合同附件
     */
    @RequestMapping(ContractAttachmentServiceProxy.GET_BY_IDS)
    Result<List<ContractAttachment>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询合同附件
     */
    @RequestMapping(ContractAttachmentServiceProxy.QUERY_LIST)
    Result<List<ContractAttachment>> queryList(@RequestParam(name = "sample") ContractAttachmentVO sample);

    /**
     * 分页查询合同附件
     */
    @RequestMapping(ContractAttachmentServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ContractAttachment>> queryPagedList(@RequestParam(name = "sample") ContractAttachmentVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.contract.controller.ContractAttachmentController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ContractAttachmentServiceProxy api() {
        return APIProxy.get(ContractAttachmentServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
