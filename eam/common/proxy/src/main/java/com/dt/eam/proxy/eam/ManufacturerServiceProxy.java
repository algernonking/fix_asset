package com.dt.eam.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.eam.domain.eam.Manufacturer;
import com.dt.eam.domain.eam.ManufacturerVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.eam.proxy.EAMServiceNames;

/**
 * <p>
 * 生产厂商  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-25 12:37:09
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
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新生产厂商
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存生产厂商
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个生产厂商
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个生产厂商
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

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
	 * 下载生产厂商导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入生产厂商数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.INSERT)
	Result insert(ManufacturerVO manufacturerVO);
	
	/**
	 * 删除生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.UPDATE)
	Result update(ManufacturerVO manufacturerVO);
	
	/**
	 * 更新生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.SAVE)
	Result save(ManufacturerVO manufacturerVO);
	
	/**
	 * 获取生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.GET_BY_ID)
	Result<Manufacturer> getById(String id);

	/**
	 * 批量删除生产厂商
	*/
	@RequestMapping(ManufacturerServiceProxy.GET_BY_IDS)
	Result<List<Manufacturer>> getByIds(List<String> ids);
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