package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.ops.OpsService;
import com.dt.platform.domain.ops.OpsServiceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 服务类型  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-30 22:39:21
*/

@FeignClient(value = ServiceNames.OPS, contextId = OpsServiceServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface OpsServiceServiceProxy {
	
	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";
	
	/**
	 * API 上下文路径 , ops-service
	*/
	public static final String API_CONTEXT_PATH = "ops-service";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加服务类型
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除服务类型
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除服务类型
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新服务类型
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存服务类型
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个服务类型
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个服务类型
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询服务类型
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询服务类型
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出服务类型数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载服务类型导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入服务类型数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加服务类型
	*/
	@RequestMapping(OpsServiceServiceProxy.INSERT)
	Result insert(OpsServiceVO opsServiceVO);
	
	/**
	 * 删除服务类型
	*/
	@RequestMapping(OpsServiceServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除服务类型
	*/
	@RequestMapping(OpsServiceServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新服务类型
	*/
	@RequestMapping(OpsServiceServiceProxy.UPDATE)
	Result update(OpsServiceVO opsServiceVO);
	
	/**
	 * 更新服务类型
	*/
	@RequestMapping(OpsServiceServiceProxy.SAVE)
	Result save(OpsServiceVO opsServiceVO);
	
	/**
	 * 获取服务类型
	*/
	@RequestMapping(OpsServiceServiceProxy.GET_BY_ID)
	Result<OpsService> getById(String id);

	/**
	 * 批量删除服务类型
	*/
	@RequestMapping(OpsServiceServiceProxy.GET_BY_IDS)
	Result<List<OpsService>> getByIds(List<String> ids);
	/**
	 * 查询服务类型
	*/
	@RequestMapping(OpsServiceServiceProxy.QUERY_LIST)
	Result<List<OpsService>> queryList(OpsServiceVO sample);
	
	/**
	 * 分页查询服务类型
	*/
	@RequestMapping(OpsServiceServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<OpsService>> queryPagedList(OpsServiceVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.OpsServiceController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static OpsServiceServiceProxy api() {
		return APIProxy.get(OpsServiceServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}