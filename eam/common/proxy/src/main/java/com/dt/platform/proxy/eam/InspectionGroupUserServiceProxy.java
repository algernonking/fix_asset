package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.InspectionGroupUser;
import com.dt.platform.domain.eam.InspectionGroupUserVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 班组人员  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 13:29:26
 */
@FeignClient(value = ServiceNames.EAM, contextId = InspectionGroupUserServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface InspectionGroupUserServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-inspection-group-user
     */
    public static final String API_CONTEXT_PATH = "eam-inspection-group-user";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加班组人员
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除班组人员
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除班组人员
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新班组人员
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存班组人员
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个班组人员
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个班组人员
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询班组人员
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询班组人员
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出班组人员数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载班组人员导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入班组人员数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     * 添加班组人员
     */
    @RequestMapping(InspectionGroupUserServiceProxy.INSERT)
    Result insert(@RequestParam(name = "inspectionGroupUserVO") InspectionGroupUserVO inspectionGroupUserVO);

    /**
     * 删除班组人员
     */
    @RequestMapping(InspectionGroupUserServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除班组人员
     */
    @RequestMapping(InspectionGroupUserServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新班组人员
     */
    @RequestMapping(InspectionGroupUserServiceProxy.UPDATE)
    Result update(@RequestParam(name = "inspectionGroupUserVO") InspectionGroupUserVO inspectionGroupUserVO);

    /**
     * 更新班组人员
     */
    @RequestMapping(InspectionGroupUserServiceProxy.SAVE)
    Result save(@RequestParam(name = "inspectionGroupUserVO") InspectionGroupUserVO inspectionGroupUserVO);

    /**
     * 获取班组人员
     */
    @RequestMapping(InspectionGroupUserServiceProxy.GET_BY_ID)
    Result<InspectionGroupUser> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个班组人员
     */
    @RequestMapping(InspectionGroupUserServiceProxy.GET_BY_IDS)
    Result<List<InspectionGroupUser>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询班组人员
     */
    @RequestMapping(InspectionGroupUserServiceProxy.QUERY_LIST)
    Result<List<InspectionGroupUser>> queryList(@RequestParam(name = "sample") InspectionGroupUserVO sample);

    /**
     * 分页查询班组人员
     */
    @RequestMapping(InspectionGroupUserServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<InspectionGroupUser>> queryPagedList(@RequestParam(name = "sample") InspectionGroupUserVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.InspectionGroupUserController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static InspectionGroupUserServiceProxy api() {
        return APIProxy.get(InspectionGroupUserServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
