package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.ops.MonitorTplGraph;
import com.dt.platform.domain.ops.MonitorTplGraphVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 模版图形  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-13 20:48:53
*/

@FeignClient(value = ServiceNames.OPS, contextId = MonitorTplGraphServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface MonitorTplGraphServiceProxy {

	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";

	/**
	 * API 上下文路径 , ops-monitor-tpl-graph
	*/
	public static final String API_CONTEXT_PATH = "ops-monitor-tpl-graph";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加模版图形
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除模版图形
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除模版图形
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新模版图形
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存模版图形
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个模版图形
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个模版图形
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询模版图形
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询模版图形
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出模版图形数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载模版图形导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入模版图形数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加模版图形
	*/
	@RequestMapping(MonitorTplGraphServiceProxy.INSERT)
	Result insert(MonitorTplGraphVO monitorTplGraphVO);

	/**
	 * 删除模版图形
	*/
	@RequestMapping(MonitorTplGraphServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除模版图形
	*/
	@RequestMapping(MonitorTplGraphServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新模版图形
	*/
	@RequestMapping(MonitorTplGraphServiceProxy.UPDATE)
	Result update(MonitorTplGraphVO monitorTplGraphVO);

	/**
	 * 更新模版图形
	*/
	@RequestMapping(MonitorTplGraphServiceProxy.SAVE)
	Result save(MonitorTplGraphVO monitorTplGraphVO);

	/**
	 * 获取模版图形
	*/
	@RequestMapping(MonitorTplGraphServiceProxy.GET_BY_ID)
	Result<MonitorTplGraph> getById(String id);

	/**
	 * 获取多个模版图形
	*/
	@RequestMapping(MonitorTplGraphServiceProxy.GET_BY_IDS)
	Result<List<MonitorTplGraph>> getByIds(List<String> ids);
	/**
	 * 查询模版图形
	*/
	@RequestMapping(MonitorTplGraphServiceProxy.QUERY_LIST)
	Result<List<MonitorTplGraph>> queryList(MonitorTplGraphVO sample);

	/**
	 * 分页查询模版图形
	*/
	@RequestMapping(MonitorTplGraphServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<MonitorTplGraph>> queryPagedList(MonitorTplGraphVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.MonitorTplGraphController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static MonitorTplGraphServiceProxy api() {
		return APIProxy.get(MonitorTplGraphServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}