package com.dt.platform.proxy.eam;

import com.dt.platform.domain.eam.EmployeePerson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;
import com.dt.platform.domain.eam.GroupUser;
import com.dt.platform.domain.eam.GroupUserVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 班组成员  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-31 21:18:52
 */
@FeignClient(value = ServiceNames.EAM, contextId = GroupUserServiceProxy.API_CONTEXT_PATH, configuration = FeignConfiguration.class)
public interface GroupUserServiceProxy {

    /**
     * 基础路径 , service-eam
     */
    public static final String API_BASIC_PATH = "service-eam";

    /**
     * API 上下文路径 , eam-group-user
     */
    public static final String API_CONTEXT_PATH = "eam-group-user";

    /**
     * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
     */
    public static final String API_PREFIX = "/" + API_BASIC_PATH + "/" + API_CONTEXT_PATH + "/";

    /**
     * 添加班组成员
     */
    public static final String INSERT = API_PREFIX + "insert";

    /**
     * 删除班组成员
     */
    public static final String DELETE = API_PREFIX + "delete";

    /**
     * 批量删除班组成员
     */
    public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

    /**
     * 更新班组成员
     */
    public static final String UPDATE = API_PREFIX + "update";

    /**
     * 保存班组成员
     */
    public static final String SAVE = API_PREFIX + "save";

    /**
     * 获取单个班组成员
     */
    public static final String GET_BY_ID = API_PREFIX + "get-by-id";

    /**
     * 获取多个班组成员
     */
    public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

    /**
     * 查询班组成员
     */
    public static final String QUERY_LIST = API_PREFIX + "query-list";

    /**
     * 分页查询班组成员
     */
    public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

    /**
     * 导出班组成员数据(Excel)
     */
    public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

    /**
     * 下载班组成员导入模版(Excel)
     */
    public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

    /**
     * 导入班组成员数据(Excel)
     */
    public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

    /**
     *
     */
    public static final String QUERY_EMPLOYEE_PERSON = API_PREFIX + "query-employee-person";


    /**
     *
     */
    @RequestMapping(GroupUserServiceProxy.QUERY_EMPLOYEE_PERSON)
    Result<List<EmployeePerson>> queryEmployeePerson(String groupId);

    /**
     * 添加班组成员
     */
    @RequestMapping(GroupUserServiceProxy.INSERT)
    Result insert(@RequestParam(name = "groupUserVO") GroupUserVO groupUserVO);

    /**
     * 删除班组成员
     */
    @RequestMapping(GroupUserServiceProxy.DELETE)
    Result deleteById(@RequestParam(name = "id") String id);

    /**
     * 批量删除班组成员
     */
    @RequestMapping(GroupUserServiceProxy.DELETE_BY_IDS)
    Result deleteByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 更新班组成员
     */
    @RequestMapping(GroupUserServiceProxy.UPDATE)
    Result update(@RequestParam(name = "groupUserVO") GroupUserVO groupUserVO);

    /**
     * 更新班组成员
     */
    @RequestMapping(GroupUserServiceProxy.SAVE)
    Result save(@RequestParam(name = "groupUserVO") GroupUserVO groupUserVO);

    /**
     * 获取班组成员
     */
    @RequestMapping(GroupUserServiceProxy.GET_BY_ID)
    Result<GroupUser> getById(@RequestParam(name = "id") String id);

    /**
     * 获取多个班组成员
     */
    @RequestMapping(GroupUserServiceProxy.GET_BY_IDS)
    Result<List<GroupUser>> getByIds(@RequestParam(name = "ids") List<String> ids);

    /**
     * 查询班组成员
     */
    @RequestMapping(GroupUserServiceProxy.QUERY_LIST)
    Result<List<GroupUser>> queryList(@RequestParam(name = "sample") GroupUserVO sample);

    /**
     * 分页查询班组成员
     */
    @RequestMapping(GroupUserServiceProxy.QUERY_PAGED_LIST)
    Result<PagedList<GroupUser>> queryPagedList(@RequestParam(name = "sample") GroupUserVO sample);

    /**
     * 控制器类名
     */
    public static final String CONTROLLER_CLASS_NAME = "com.dt.platform.eam.controller.GroupUserController";

    /**
     * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
     */
    public static GroupUserServiceProxy api() {
        return APIProxy.get(GroupUserServiceProxy.class, CONTROLLER_CLASS_NAME);
    }
}
