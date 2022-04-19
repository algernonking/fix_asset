package com.dt.platform.proxy.contract;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.contract.ContractSigner;
import com.dt.platform.domain.contract.ContractSignerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 合同签订方  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-20 16:55:10
 */
@FeignClient(value = ServiceNames.CONTRACT, contextId = ContractSignerServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface ContractSignerServiceProxy {

    /**
     * 基础路径 , service-contract
     */
    public static final String API_BASIC_PATH = "service-contract";

    /**
     * API 上下文路径 , cont-contract-signer
     */
    public static final String API_CONTEXT_PATH = "cont-contract-signer";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加合同签订方
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除合同签订方
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除合同签订方
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新合同签订方
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存合同签订方
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个合同签订方
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个合同签订方
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询合同签订方
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询合同签订方
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出合同签订方数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载合同签订方导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入合同签订方数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加合同签订方
     */
    @RequestMapping(ContractSignerServiceProxy.INSERT)
    Result insert(@RequestParam(name = "contractSignerVO") ContractSignerVO contractSignerVO);

    /**
     * 删除合同签订方
     */
    @RequestMapping(ContractSignerServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除合同签订方
     */
    @RequestMapping(ContractSignerServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新合同签订方
     */
    @RequestMapping(ContractSignerServiceProxy.UPDATE)
    Result update(@RequestParam(name = "contractSignerVO") ContractSignerVO contractSignerVO);

    /**
     * 更新合同签订方
     */
    @RequestMapping(ContractSignerServiceProxy.SAVE)
    Result save(@RequestParam(name = "contractSignerVO") ContractSignerVO contractSignerVO);

    /**
     * 获取合同签订方
     */
    @RequestMapping(ContractSignerServiceProxy.GET_BY_ID)
    Result<ContractSigner> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个合同签订方
     */
    @RequestMapping(ContractSignerServiceProxy.GET_BY_IDS)
    Result<List<ContractSigner>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询合同签订方
     */
    @RequestMapping(ContractSignerServiceProxy.QUERY_LIST)
    Result<List<ContractSigner>> queryList(@RequestParam(name = "sample") ContractSignerVO sample);

    /**
     * 分页查询合同签订方
     */
    @RequestMapping(ContractSignerServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<ContractSigner>> queryPagedList(@RequestParam(name = "sample") ContractSignerVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.contract.controller.ContractSignerController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static ContractSignerServiceProxy api() {
        return APIProxy.get(ContractSignerServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
