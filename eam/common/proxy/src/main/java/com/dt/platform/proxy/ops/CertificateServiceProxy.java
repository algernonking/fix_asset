package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.ops.Certificate;
import com.dt.platform.domain.ops.CertificateVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 证书  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-14 21:47:25
 */
@FeignClient(value = ServiceNames.OPS, contextId = CertificateServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface CertificateServiceProxy {

    /**
     * 基础路径 , service-ops
     */
    public static final String API_BASIC_PATH = "service-ops";

    /**
     * API 上下文路径 , ops-certificate
     */
    public static final String API_CONTEXT_PATH = "ops-certificate";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加证书
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除证书
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除证书
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新证书
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存证书
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个证书
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个证书
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询证书
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询证书
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出证书数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载证书导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入证书数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加证书
     */
    @RequestMapping(CertificateServiceProxy.INSERT)
    Result insert(@RequestParam(name = "certificateVO") CertificateVO certificateVO);

    /**
     * 删除证书
     */
    @RequestMapping(CertificateServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除证书
     */
    @RequestMapping(CertificateServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新证书
     */
    @RequestMapping(CertificateServiceProxy.UPDATE)
    Result update(@RequestParam(name = "certificateVO") CertificateVO certificateVO);

    /**
     * 更新证书
     */
    @RequestMapping(CertificateServiceProxy.SAVE)
    Result save(@RequestParam(name = "certificateVO") CertificateVO certificateVO);

    /**
     * 获取证书
     */
    @RequestMapping(CertificateServiceProxy.GET_BY_ID)
    Result<Certificate> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个证书
     */
    @RequestMapping(CertificateServiceProxy.GET_BY_IDS)
    Result<List<Certificate>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询证书
     */
    @RequestMapping(CertificateServiceProxy.QUERY_LIST)
    Result<List<Certificate>> queryList(@RequestParam(name = "sample") CertificateVO sample);

    /**
     * 分页查询证书
     */
    @RequestMapping(CertificateServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<Certificate>> queryPagedList(@RequestParam(name = "sample") CertificateVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.ops.controller.CertificateController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static CertificateServiceProxy api() {
        return APIProxy.get(CertificateServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
