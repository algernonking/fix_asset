package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.eam.AssetBorrowData;
import com.dt.platform.domain.eam.AssetBorrowDataVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产借用数据  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-19 21:42:06
*/

@FeignClient(value = ServiceNames.EAM, contextId = AssetBorrowDataServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface AssetBorrowDataServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-asset-borrow-data
	*/
	public static final String API_CONTEXT_PATH = "eam-asset-borrow-data";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加资产借用数据
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除资产借用数据
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除资产借用数据
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新资产借用数据
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存资产借用数据
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个资产借用数据
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个资产借用数据
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询资产借用数据
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询资产借用数据
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出资产借用数据数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载资产借用数据导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入资产借用数据数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加资产借用数据
	*/
	@RequestMapping(AssetBorrowDataServiceProxy.INSERT)
	Result insert(AssetBorrowDataVO assetBorrowDataVO);
	
	/**
	 * 删除资产借用数据
	*/
	@RequestMapping(AssetBorrowDataServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除资产借用数据
	*/
	@RequestMapping(AssetBorrowDataServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新资产借用数据
	*/
	@RequestMapping(AssetBorrowDataServiceProxy.UPDATE)
	Result update(AssetBorrowDataVO assetBorrowDataVO);
	
	/**
	 * 更新资产借用数据
	*/
	@RequestMapping(AssetBorrowDataServiceProxy.SAVE)
	Result save(AssetBorrowDataVO assetBorrowDataVO);
	
	/**
	 * 获取资产借用数据
	*/
	@RequestMapping(AssetBorrowDataServiceProxy.GET_BY_ID)
	Result<AssetBorrowData> getById(String id);

	/**
	 * 批量删除资产借用数据
	*/
	@RequestMapping(AssetBorrowDataServiceProxy.GET_BY_IDS)
	Result<List<AssetBorrowData>> getByIds(List<String> ids);
	/**
	 * 查询资产借用数据
	*/
	@RequestMapping(AssetBorrowDataServiceProxy.QUERY_LIST)
	Result<List<AssetBorrowData>> queryList(AssetBorrowDataVO sample);
	
	/**
	 * 分页查询资产借用数据
	*/
	@RequestMapping(AssetBorrowDataServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<AssetBorrowData>> queryPagedList(AssetBorrowDataVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.AssetBorrowDataController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static AssetBorrowDataServiceProxy api() {
		return APIProxy.get(AssetBorrowDataServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}