package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.SupplierVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 供应商  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-21 15:46:14
*/

@FeignClient(value = ServiceNames.EAM, contextId = SupplierServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface SupplierServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-supplier
	*/
	public static final String API_CONTEXT_PATH = "eam-supplier";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加供应商
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除供应商
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除供应商
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新供应商
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存供应商
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个供应商
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个供应商
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询供应商
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询供应商
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出供应商数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载供应商导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入供应商数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加供应商
	*/
	@RequestMapping(SupplierServiceProxy.INSERT)
	Result insert(SupplierVO supplierVO);
	
	/**
	 * 删除供应商
	*/
	@RequestMapping(SupplierServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除供应商
	*/
	@RequestMapping(SupplierServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新供应商
	*/
	@RequestMapping(SupplierServiceProxy.UPDATE)
	Result update(SupplierVO supplierVO);
	
	/**
	 * 更新供应商
	*/
	@RequestMapping(SupplierServiceProxy.SAVE)
	Result save(SupplierVO supplierVO);
	
	/**
	 * 获取供应商
	*/
	@RequestMapping(SupplierServiceProxy.GET_BY_ID)
	Result<Supplier> getById(String id);

	/**
	 * 批量删除供应商
	*/
	@RequestMapping(SupplierServiceProxy.GET_BY_IDS)
	Result<List<Supplier>> getByIds(List<String> ids);
	/**
	 * 查询供应商
	*/
	@RequestMapping(SupplierServiceProxy.QUERY_LIST)
	Result<List<Supplier>> queryList(SupplierVO sample);
	
	/**
	 * 分页查询供应商
	*/
	@RequestMapping(SupplierServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Supplier>> queryPagedList(SupplierVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.SupplierController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static SupplierServiceProxy api() {
		return APIProxy.get(SupplierServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}