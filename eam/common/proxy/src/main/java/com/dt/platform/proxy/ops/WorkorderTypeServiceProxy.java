package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.ops.WorkorderType;
import com.dt.platform.domain.ops.WorkorderTypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 工单类型  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-11 21:30:42
*/

@FeignClient(value = ServiceNames.OPS, contextId = WorkorderTypeServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface WorkorderTypeServiceProxy {
	
	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";
	
	/**
	 * API 上下文路径 , workorder-type
	*/
	public static final String API_CONTEXT_PATH = "workorder-type";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加工单类型
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除工单类型
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除工单类型
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新工单类型
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存工单类型
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个工单类型
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个工单类型
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询工单类型
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询工单类型
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出工单类型数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载工单类型导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入工单类型数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加工单类型
	*/
	@RequestMapping(WorkorderTypeServiceProxy.INSERT)
	Result insert(WorkorderTypeVO workorderTypeVO);
	
	/**
	 * 删除工单类型
	*/
	@RequestMapping(WorkorderTypeServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除工单类型
	*/
	@RequestMapping(WorkorderTypeServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新工单类型
	*/
	@RequestMapping(WorkorderTypeServiceProxy.UPDATE)
	Result update(WorkorderTypeVO workorderTypeVO);
	
	/**
	 * 更新工单类型
	*/
	@RequestMapping(WorkorderTypeServiceProxy.SAVE)
	Result save(WorkorderTypeVO workorderTypeVO);
	
	/**
	 * 获取工单类型
	*/
	@RequestMapping(WorkorderTypeServiceProxy.GET_BY_ID)
	Result<WorkorderType> getById(String id);

	/**
	 * 批量删除工单类型
	*/
	@RequestMapping(WorkorderTypeServiceProxy.GET_BY_IDS)
	Result<List<WorkorderType>> getByIds(List<String> ids);
	/**
	 * 查询工单类型
	*/
	@RequestMapping(WorkorderTypeServiceProxy.QUERY_LIST)
	Result<List<WorkorderType>> queryList(WorkorderTypeVO sample);
	
	/**
	 * 分页查询工单类型
	*/
	@RequestMapping(WorkorderTypeServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<WorkorderType>> queryPagedList(WorkorderTypeVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.WorkorderTypeController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static WorkorderTypeServiceProxy api() {
		return APIProxy.get(WorkorderTypeServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}