package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.ServiceInfoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 服务  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 16:44:35
*/

@FeignClient(value = ServiceNames.OPS, contextId = ServiceInfoServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ServiceInfoServiceProxy {
	
	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";
	
	/**
	 * API 上下文路径 , ops-service-info
	*/
	public static final String API_CONTEXT_PATH = "ops-service-info";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加服务
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除服务
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除服务
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新服务
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存服务
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个服务
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个服务
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询服务
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询服务
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出服务数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载服务导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入服务数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加服务
	*/
	@RequestMapping(ServiceInfoServiceProxy.INSERT)
	Result insert(ServiceInfoVO serviceInfoVO);
	
	/**
	 * 删除服务
	*/
	@RequestMapping(ServiceInfoServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除服务
	*/
	@RequestMapping(ServiceInfoServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新服务
	*/
	@RequestMapping(ServiceInfoServiceProxy.UPDATE)
	Result update(ServiceInfoVO serviceInfoVO);
	
	/**
	 * 更新服务
	*/
	@RequestMapping(ServiceInfoServiceProxy.SAVE)
	Result save(ServiceInfoVO serviceInfoVO);
	
	/**
	 * 获取服务
	*/
	@RequestMapping(ServiceInfoServiceProxy.GET_BY_ID)
	Result<ServiceInfo> getById(String id);

	/**
	 * 批量删除服务
	*/
	@RequestMapping(ServiceInfoServiceProxy.GET_BY_IDS)
	Result<List<ServiceInfo>> getByIds(List<String> ids);
	/**
	 * 查询服务
	*/
	@RequestMapping(ServiceInfoServiceProxy.QUERY_LIST)
	Result<List<ServiceInfo>> queryList(ServiceInfoVO sample);
	
	/**
	 * 分页查询服务
	*/
	@RequestMapping(ServiceInfoServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<ServiceInfo>> queryPagedList(ServiceInfoVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.ServiceInfoController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ServiceInfoServiceProxy api() {
		return APIProxy.get(ServiceInfoServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}