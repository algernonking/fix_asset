package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.eam.AssetStockGoodsAdjust;
import com.dt.platform.domain.eam.AssetStockGoodsAdjustVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 库存调整  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-19 10:15:41
*/

@FeignClient(value = ServiceNames.EAM, contextId = AssetStockGoodsAdjustServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface AssetStockGoodsAdjustServiceProxy {

	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";

	/**
	 * API 上下文路径 , eam-asset-stock-goods-adjust
	*/
	public static final String API_CONTEXT_PATH = "eam-asset-stock-goods-adjust";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加库存调整
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除库存调整
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除库存调整
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新库存调整
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存库存调整
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个库存调整
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个库存调整
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询库存调整
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询库存调整
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出库存调整数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载库存调整导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入库存调整数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加库存调整
	*/
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.INSERT)
	Result insert(AssetStockGoodsAdjustVO assetStockGoodsAdjustVO);

	/**
	 * 删除库存调整
	*/
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除库存调整
	*/
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新库存调整
	*/
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.UPDATE)
	Result update(AssetStockGoodsAdjustVO assetStockGoodsAdjustVO);

	/**
	 * 更新库存调整
	*/
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.SAVE)
	Result save(AssetStockGoodsAdjustVO assetStockGoodsAdjustVO);

	/**
	 * 获取库存调整
	*/
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.GET_BY_ID)
	Result<AssetStockGoodsAdjust> getById(String id);

	/**
	 * 获取多个库存调整
	*/
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.GET_BY_IDS)
	Result<List<AssetStockGoodsAdjust>> getByIds(List<String> ids);
	/**
	 * 查询库存调整
	*/
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.QUERY_LIST)
	Result<List<AssetStockGoodsAdjust>> queryList(AssetStockGoodsAdjustVO sample);

	/**
	 * 分页查询库存调整
	*/
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<AssetStockGoodsAdjust>> queryPagedList(AssetStockGoodsAdjustVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.AssetStockGoodsAdjustController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static AssetStockGoodsAdjustServiceProxy api() {
		return APIProxy.get(AssetStockGoodsAdjustServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}