package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.eam.AssetScrap;
import com.dt.platform.domain.eam.AssetScrapVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产报废  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:04:21
*/

@FeignClient(value = ServiceNames.EAM, contextId = AssetScrapServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface AssetScrapServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-asset-scrap
	*/
	public static final String API_CONTEXT_PATH = "eam-asset-scrap";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加资产报废
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除资产报废
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除资产报废
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	
	/**
	 * 更新资产报废
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存资产报废
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个资产报废
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个资产报废
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询资产报废
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询资产报废
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出资产报废数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载资产报废导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入资产报废数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";


	/**
	 * 提交审批
	 */
	public static final String FOR_APPROVAL= API_PREFIX + "for-approval";

	/**
	 * 确认操作
	 */
	public static final String CONFIRM_OPERATION= API_PREFIX + "confirm-operation";


	/**
	 * 添加资产报废
	*/
	@RequestMapping(AssetScrapServiceProxy.INSERT)
	Result insert(AssetScrapVO assetScrapVO);
	
	/**
	 * 删除资产报废
	*/
	@RequestMapping(AssetScrapServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除资产报废
	*/
	@RequestMapping(AssetScrapServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新资产报废
	*/
	@RequestMapping(AssetScrapServiceProxy.UPDATE)
	Result update(AssetScrapVO assetScrapVO);
	
	/**
	 * 更新资产报废
	*/
	@RequestMapping(AssetScrapServiceProxy.SAVE)
	Result save(AssetScrapVO assetScrapVO);
	
	/**
	 * 获取资产报废
	*/
	@RequestMapping(AssetScrapServiceProxy.GET_BY_ID)
	Result<AssetScrap> getById(String id);

	/**
	 * 批量删除资产报废
	*/
	@RequestMapping(AssetScrapServiceProxy.GET_BY_IDS)
	Result<List<AssetScrap>> getByIds(List<String> ids);
	/**
	 * 查询资产报废
	*/
	@RequestMapping(AssetScrapServiceProxy.QUERY_LIST)
	Result<List<AssetScrap>> queryList(AssetScrapVO sample);
	
	/**
	 * 分页查询资产报废
	*/
	@RequestMapping(AssetScrapServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<AssetScrap>> queryPagedList(AssetScrapVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.AssetScrapController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static AssetScrapServiceProxy api() {
		return APIProxy.get(AssetScrapServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}