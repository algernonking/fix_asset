package com.dt.eam.proxy.eam;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.eam.domain.eam.Manufacturer;
import com.dt.eam.domain.eam.ManufacturerVO;
import com.github.foxnic.springboot.api.proxy.APIProxy;
import com.dt.eam.proxy.EAMServiceNames;

/**
 * <p>
 * 生产厂商  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-06-12 14:21:18
*/

@FeignClient(value = EAMServiceNames.EAM, contextId = ManufacturerServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ManufacturerServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-manufacturer
	*/
	public static final String API_CONTEXT_PATH = "eam-manufacturer";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加生产厂商
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除生产厂商
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 批量删除生产厂商
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新生产厂商
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存生产厂商
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取生产厂商
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询生产厂商
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询生产厂商
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出生产厂商数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";
	
	/**
	 * 导入生产厂商数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.INSERT)
	Result<Manufacturer> insert(ManufacturerVO manufacturerVO);
	
	/**
	 * 删除生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.DELETE)
	Result<Manufacturer> deleteById(String id);
	
	
	/**
	 * 批量删除生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.BATCH_DELETE)
	Result<Manufacturer> deleteByIds(List<String> id);
	
	/**
	 * 更新生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.UPDATE)
	Result<Manufacturer> update(ManufacturerVO manufacturerVO);
	
	/**
	 * 更新生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.SAVE)
	Result<Manufacturer> save(ManufacturerVO manufacturerVO);
	
	/**
	 * 获取生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.GET_BY_ID)
	Result<Manufacturer> getById(String id);
	
	/**
	 * 查询生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.QUERY_LIST)
	Result<List<Manufacturer>> queryList(ManufacturerVO sample);
	
	/**
	 * 分页查询生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Manufacturer>> queryPagedList(ManufacturerVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.eam.eam.controller.ManufacturerController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ManufacturerServiceProxy api() {
		return APIProxy.get(ManufacturerServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}