package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.ops.MonitorNodeValue;
import com.dt.platform.domain.ops.MonitorNodeValueVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 节点数值  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-31 06:06:04
*/

@FeignClient(value = ServiceNames.OPS, contextId = MonitorNodeValueServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface MonitorNodeValueServiceProxy {

	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";

	/**
	 * API 上下文路径 , ops-monitor-node-value
	*/
	public static final String API_CONTEXT_PATH = "ops-monitor-node-value";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加节点数值
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除节点数值
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除节点数值
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新节点数值
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存节点数值
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个节点数值
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个节点数值
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询节点数值
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询节点数值
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出节点数值数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载节点数值导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入节点数值数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加节点数值
	*/
	@RequestMapping(MonitorNodeValueServiceProxy.INSERT)
	Result insert(MonitorNodeValueVO monitorNodeValueVO);

	/**
	 * 删除节点数值
	*/
	@RequestMapping(MonitorNodeValueServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除节点数值
	*/
	@RequestMapping(MonitorNodeValueServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新节点数值
	*/
	@RequestMapping(MonitorNodeValueServiceProxy.UPDATE)
	Result update(MonitorNodeValueVO monitorNodeValueVO);

	/**
	 * 更新节点数值
	*/
	@RequestMapping(MonitorNodeValueServiceProxy.SAVE)
	Result save(MonitorNodeValueVO monitorNodeValueVO);

	/**
	 * 获取节点数值
	*/
	@RequestMapping(MonitorNodeValueServiceProxy.GET_BY_ID)
	Result<MonitorNodeValue> getById(String id);

	/**
	 * 获取多个节点数值
	*/
	@RequestMapping(MonitorNodeValueServiceProxy.GET_BY_IDS)
	Result<List<MonitorNodeValue>> getByIds(List<String> ids);
	/**
	 * 查询节点数值
	*/
	@RequestMapping(MonitorNodeValueServiceProxy.QUERY_LIST)
	Result<List<MonitorNodeValue>> queryList(MonitorNodeValueVO sample);

	/**
	 * 分页查询节点数值
	*/
	@RequestMapping(MonitorNodeValueServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<MonitorNodeValue>> queryPagedList(MonitorNodeValueVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.MonitorNodeValueController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static MonitorNodeValueServiceProxy api() {
		return APIProxy.get(MonitorNodeValueServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}