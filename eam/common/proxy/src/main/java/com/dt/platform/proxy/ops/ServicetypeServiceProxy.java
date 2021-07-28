package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.ops.Servicetype;
import com.dt.platform.domain.ops.ServicetypeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.EAMServiceNames;

/**
 * <p>
 * 服务种类  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-27 15:03:54
*/

@FeignClient(value = EAMServiceNames.OPS, contextId = ServicetypeServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ServicetypeServiceProxy {
	
	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";
	
	/**
	 * API 上下文路径 , ops-servicetype
	*/
	public static final String API_CONTEXT_PATH = "ops-servicetype";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加服务种类
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除服务种类
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除服务种类
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新服务种类
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存服务种类
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个服务种类
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个服务种类
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询服务种类
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询服务种类
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出服务种类数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载服务种类导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入服务种类数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加服务种类
	*/
	@RequestMapping(ServicetypeServiceProxy.INSERT)
	Result insert(ServicetypeVO servicetypeVO);
	
	/**
	 * 删除服务种类
	*/
	@RequestMapping(ServicetypeServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除服务种类
	*/
	@RequestMapping(ServicetypeServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新服务种类
	*/
	@RequestMapping(ServicetypeServiceProxy.UPDATE)
	Result update(ServicetypeVO servicetypeVO);
	
	/**
	 * 更新服务种类
	*/
	@RequestMapping(ServicetypeServiceProxy.SAVE)
	Result save(ServicetypeVO servicetypeVO);
	
	/**
	 * 获取服务种类
	*/
	@RequestMapping(ServicetypeServiceProxy.GET_BY_ID)
	Result<Servicetype> getById(String id);

	/**
	 * 批量删除服务种类
	*/
	@RequestMapping(ServicetypeServiceProxy.GET_BY_IDS)
	Result<List<Servicetype>> getByIds(List<String> ids);
	/**
	 * 查询服务种类
	*/
	@RequestMapping(ServicetypeServiceProxy.QUERY_LIST)
	Result<List<Servicetype>> queryList(ServicetypeVO sample);
	
	/**
	 * 分页查询服务种类
	*/
	@RequestMapping(ServicetypeServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Servicetype>> queryPagedList(ServicetypeVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.ServicetypeController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ServicetypeServiceProxy api() {
		return APIProxy.get(ServicetypeServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}