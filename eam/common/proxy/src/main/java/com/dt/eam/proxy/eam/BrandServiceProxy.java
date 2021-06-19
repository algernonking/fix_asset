package com.dt.eam.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.eam.domain.eam.Brand;
import com.dt.eam.domain.eam.BrandVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.eam.proxy.EAMServiceNames;

/**
 * <p>
 * 品牌表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-19 20:16:31
*/

@FeignClient(value = EAMServiceNames.EAM, contextId = BrandServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface BrandServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-brand
	*/
	public static final String API_CONTEXT_PATH = "eam-brand";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加品牌
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除品牌
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 批量删除品牌
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新品牌
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存品牌
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取品牌
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询品牌
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询品牌
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出品牌数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载品牌导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入品牌数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加品牌
	*/
	@RequestMapping(BrandServiceProxy.INSERT)
	Result<Brand> insert(BrandVO brandVO);
	
	/**
	 * 删除品牌
	*/
	@RequestMapping(BrandServiceProxy.DELETE)
	Result<Brand> deleteById(String id);
	
	
	/**
	 * 批量删除品牌
	*/
	@RequestMapping(BrandServiceProxy.BATCH_DELETE)
	Result<Brand> deleteByIds(List<String> id);
	
	/**
	 * 更新品牌
	*/
	@RequestMapping(BrandServiceProxy.UPDATE)
	Result<Brand> update(BrandVO brandVO);
	
	/**
	 * 更新品牌
	*/
	@RequestMapping(BrandServiceProxy.SAVE)
	Result<Brand> save(BrandVO brandVO);
	
	/**
	 * 获取品牌
	*/
	@RequestMapping(BrandServiceProxy.GET_BY_ID)
	Result<Brand> getById(String id);
	
	/**
	 * 查询品牌
	*/
	@RequestMapping(BrandServiceProxy.QUERY_LIST)
	Result<List<Brand>> queryList(BrandVO sample);
	
	/**
	 * 分页查询品牌
	*/
	@RequestMapping(BrandServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Brand>> queryPagedList(BrandVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.eam.eam.controller.BrandController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static BrandServiceProxy api() {
		return APIProxy.get(BrandServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}