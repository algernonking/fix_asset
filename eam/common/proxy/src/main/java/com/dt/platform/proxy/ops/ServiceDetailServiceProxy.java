package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.ops.ServiceDetail;
import com.dt.platform.domain.ops.ServiceDetailVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 服务明细  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-13 21:59:31
*/

@FeignClient(value = ServiceNames.OPS, contextId = ServiceDetailServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ServiceDetailServiceProxy {
	
	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";
	
	/**
	 * API 上下文路径 , ops-service-detail
	*/
	public static final String API_CONTEXT_PATH = "ops-service-detail";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加服务明细
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除服务明细
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除服务明细
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新服务明细
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存服务明细
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个服务明细
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个服务明细
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询服务明细
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询服务明细
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出服务明细数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载服务明细导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入服务明细数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加服务明细
	*/
	@RequestMapping(ServiceDetailServiceProxy.INSERT)
	Result insert(ServiceDetailVO serviceDetailVO);
	
	/**
	 * 删除服务明细
	*/
	@RequestMapping(ServiceDetailServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除服务明细
	*/
	@RequestMapping(ServiceDetailServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新服务明细
	*/
	@RequestMapping(ServiceDetailServiceProxy.UPDATE)
	Result update(ServiceDetailVO serviceDetailVO);
	
	/**
	 * 更新服务明细
	*/
	@RequestMapping(ServiceDetailServiceProxy.SAVE)
	Result save(ServiceDetailVO serviceDetailVO);
	
	/**
	 * 获取服务明细
	*/
	@RequestMapping(ServiceDetailServiceProxy.GET_BY_ID)
	Result<ServiceDetail> getById(String id);

	/**
	 * 批量删除服务明细
	*/
	@RequestMapping(ServiceDetailServiceProxy.GET_BY_IDS)
	Result<List<ServiceDetail>> getByIds(List<String> ids);
	/**
	 * 查询服务明细
	*/
	@RequestMapping(ServiceDetailServiceProxy.QUERY_LIST)
	Result<List<ServiceDetail>> queryList(ServiceDetailVO sample);
	
	/**
	 * 分页查询服务明细
	*/
	@RequestMapping(ServiceDetailServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<ServiceDetail>> queryPagedList(ServiceDetailVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.ServiceDetailController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ServiceDetailServiceProxy api() {
		return APIProxy.get(ServiceDetailServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}