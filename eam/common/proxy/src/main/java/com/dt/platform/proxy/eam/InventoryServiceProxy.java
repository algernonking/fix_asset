package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.eam.Inventory;
import com.dt.platform.domain.eam.InventoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产盘点  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-20 13:23:35
*/

@FeignClient(value = ServiceNames.EAM, contextId = InventoryServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface InventoryServiceProxy {

	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";

	/**
	 * API 上下文路径 , eam-inventory
	*/
	public static final String API_CONTEXT_PATH = "eam-inventory";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加资产盘点
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除资产盘点
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除资产盘点
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新资产盘点
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存资产盘点
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个资产盘点
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个资产盘点
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询资产盘点
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询资产盘点
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出资产盘点数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载资产盘点导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入资产盘点数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 盘点开始
	 */
	public static final String START = API_PREFIX + "start";

	/**
	 * 盘点结束
	 */
	public static final String FINISH = API_PREFIX + "finish";

	/**
	 * 盘点取消
	 */
	public static final String CANCEL = API_PREFIX + "cancel";

	/**
	 * 同步数据
	 */
	public static final String DATA_SYNC = API_PREFIX + "data-sync";

	/**
	 * 盘点资产
	 */
	public static final String INVENTORY_ASSET = API_PREFIX + "inventory-asset";



	/**
	 * 添加资产盘点
	*/
	@RequestMapping(InventoryServiceProxy.INSERT)
	Result insert(InventoryVO inventoryVO);

	/**
	 * 删除资产盘点
	*/
	@RequestMapping(InventoryServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除资产盘点
	*/
	@RequestMapping(InventoryServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新资产盘点
	*/
	@RequestMapping(InventoryServiceProxy.UPDATE)
	Result update(InventoryVO inventoryVO);

	/**
	 * 更新资产盘点
	*/
	@RequestMapping(InventoryServiceProxy.SAVE)
	Result save(InventoryVO inventoryVO);

	/**
	 * 获取资产盘点
	*/
	@RequestMapping(InventoryServiceProxy.GET_BY_ID)
	Result<Inventory> getById(String id);

	/**
	 * 批量删除资产盘点
	*/
	@RequestMapping(InventoryServiceProxy.GET_BY_IDS)
	Result<List<Inventory>> getByIds(List<String> ids);
	/**
	 * 查询资产盘点
	*/
	@RequestMapping(InventoryServiceProxy.QUERY_LIST)
	Result<List<Inventory>> queryList(InventoryVO sample);

	/**
	 * 分页查询资产盘点
	*/
	@RequestMapping(InventoryServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Inventory>> queryPagedList(InventoryVO sample);



	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.InventoryController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static InventoryServiceProxy api() {
		return APIProxy.get(InventoryServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}