package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 监控模版  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-07 13:14:35
*/

@FeignClient(value = ServiceNames.OPS, contextId = MonitorTplServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface MonitorTplServiceProxy {

	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";

	/**
	 * API 上下文路径 , ops-monitor-tpl
	*/
	public static final String API_CONTEXT_PATH = "ops-monitor-tpl";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加监控模版
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除监控模版
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除监控模版
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新监控模版
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存监控模版
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个监控模版
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个监控模版
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询监控模版
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询监控模版
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出监控模版数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载监控模版导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入监控模版数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加监控模版
	*/
	@RequestMapping(MonitorTplServiceProxy.INSERT)
	Result insert(MonitorTplVO monitorTplVO);

	/**
	 * 删除监控模版
	*/
	@RequestMapping(MonitorTplServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除监控模版
	*/
	@RequestMapping(MonitorTplServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新监控模版
	*/
	@RequestMapping(MonitorTplServiceProxy.UPDATE)
	Result update(MonitorTplVO monitorTplVO);

	/**
	 * 更新监控模版
	*/
	@RequestMapping(MonitorTplServiceProxy.SAVE)
	Result save(MonitorTplVO monitorTplVO);

	/**
	 * 获取监控模版
	*/
	@RequestMapping(MonitorTplServiceProxy.GET_BY_ID)
	Result<MonitorTpl> getById(String id);

	/**
	 * 获取多个监控模版
	*/
	@RequestMapping(MonitorTplServiceProxy.GET_BY_IDS)
	Result<List<MonitorTpl>> getByIds(List<String> ids);
	/**
	 * 查询监控模版
	*/
	@RequestMapping(MonitorTplServiceProxy.QUERY_LIST)
	Result<List<MonitorTpl>> queryList(MonitorTplVO sample);

	/**
	 * 分页查询监控模版
	*/
	@RequestMapping(MonitorTplServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<MonitorTpl>> queryPagedList(MonitorTplVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.MonitorTplController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static MonitorTplServiceProxy api() {
		return APIProxy.get(MonitorTplServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}