package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-16 15:36:22
*/

@FeignClient(value = ServiceNames.EAM, contextId = AssetServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface AssetServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-asset
	*/
	public static final String API_CONTEXT_PATH = "eam-asset";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加资产
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除资产
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除资产
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新资产
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存资产
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个资产
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个资产
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询资产
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询资产
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出资产数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载资产导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入资产数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加资产
	*/
	@RequestMapping(AssetServiceProxy.INSERT)
	Result insert(AssetVO assetVO);
	
	/**
	 * 删除资产
	*/
	@RequestMapping(AssetServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除资产
	*/
	@RequestMapping(AssetServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新资产
	*/
	@RequestMapping(AssetServiceProxy.UPDATE)
	Result update(AssetVO assetVO);
	
	/**
	 * 更新资产
	*/
	@RequestMapping(AssetServiceProxy.SAVE)
	Result save(AssetVO assetVO);
	
	/**
	 * 获取资产
	*/
	@RequestMapping(AssetServiceProxy.GET_BY_ID)
	Result<Asset> getById(String id);

	/**
	 * 批量删除资产
	*/
	@RequestMapping(AssetServiceProxy.GET_BY_IDS)
	Result<List<Asset>> getByIds(List<String> ids);
	/**
	 * 查询资产
	*/
	@RequestMapping(AssetServiceProxy.QUERY_LIST)
	Result<List<Asset>> queryList(AssetVO sample);
	
	/**
	 * 分页查询资产
	*/
	@RequestMapping(AssetServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Asset>> queryPagedList(AssetVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.AssetController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static AssetServiceProxy api() {
		return APIProxy.get(AssetServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}