package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.CertificateType;
import com.dt.platform.domain.ops.CertificateTypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 证书类型  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-14 20:37:29
 */
@FeignClient(value = ServiceNames.OPS, contextId = CertificateTypeServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CertificateTypeServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-certificate-type
     */
    public static final String API_CONTEXT_PATH = "ops-certificate-type";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加证书类型
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除证书类型
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除证书类型
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新证书类型
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存证书类型
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个证书类型
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个证书类型
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询证书类型
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询证书类型
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出证书类型数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载证书类型导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入证书类型数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加证书类型
     */
    @RequestMapping(CertificateTypeServiceProxy.INSERT)
    Result insert(@RequestParam(name = "certificateTypeVO") CertificateTypeVO certificateTypeVO);

    /**
     * 删除证书类型
     */
    @RequestMapping(CertificateTypeServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除证书类型
     */
    @RequestMapping(CertificateTypeServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新证书类型
     */
    @RequestMapping(CertificateTypeServiceProxy.UPDATE)
    Result update(@RequestParam(name = "certificateTypeVO") CertificateTypeVO certificateTypeVO);

    /**
     * 更新证书类型
     */
    @RequestMapping(CertificateTypeServiceProxy.SAVE)
    Result save(@RequestParam(name = "certificateTypeVO") CertificateTypeVO certificateTypeVO);

    /**
     * 获取证书类型
     */
    @RequestMapping(CertificateTypeServiceProxy.GET_BY_ID)
    Result<CertificateType> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个证书类型
     */
    @RequestMapping(CertificateTypeServiceProxy.GET_BY_IDS)
    Result<List<CertificateType>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询证书类型
     */
    @RequestMapping(CertificateTypeServiceProxy.QUERY_LIST)
    Result<List<CertificateType>> queryList(@RequestParam(name = "sample") CertificateTypeVO sample);

    /**
     * 分页查询证书类型
     */
    @RequestMapping(CertificateTypeServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<CertificateType>> queryPagedList(@RequestParam(name = "sample") CertificateTypeVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.CertificateTypeController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CertificateTypeServiceProxy api() {
        return APIProxy.get(CertificateTypeServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
