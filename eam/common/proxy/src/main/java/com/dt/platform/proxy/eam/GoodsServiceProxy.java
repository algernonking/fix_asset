package com.dt.platform.proxy.eam;

import com.dt.platform.domain.eam.Goods;
import com.dt.platform.domain.eam.GoodsVO;
import com.dt.platform.proxy.EAMServiceNames;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import org.github.foxnic.web.proxy.FeignConfiguration;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 资产物品表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-19 20:16:33
*/

@FeignClient(value = EAMServiceNames.EAM, contextId = GoodsServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface GoodsServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-goods
	*/
	public static final String API_CONTEXT_PATH = "eam-goods";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加资产物品
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除资产物品
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 批量删除资产物品
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新资产物品
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存资产物品
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取资产物品
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询资产物品
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询资产物品
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出资产物品数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载资产物品导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入资产物品数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加资产物品
	*/
	@RequestMapping(GoodsServiceProxy.INSERT)
	Result<Goods> insert(GoodsVO goodsVO);
	
	/**
	 * 删除资产物品
	*/
	@RequestMapping(GoodsServiceProxy.DELETE)
	Result<Goods> deleteById(String id);
	
	
	/**
	 * 批量删除资产物品
	*/
	@RequestMapping(GoodsServiceProxy.BATCH_DELETE)
	Result<Goods> deleteByIds(List<String> id);
	
	/**
	 * 更新资产物品
	*/
	@RequestMapping(GoodsServiceProxy.UPDATE)
	Result<Goods> update(GoodsVO goodsVO);
	
	/**
	 * 更新资产物品
	*/
	@RequestMapping(GoodsServiceProxy.SAVE)
	Result<Goods> save(GoodsVO goodsVO);
	
	/**
	 * 获取资产物品
	*/
	@RequestMapping(GoodsServiceProxy.GET_BY_ID)
	Result<Goods> getById(String id);
	
	/**
	 * 查询资产物品
	*/
	@RequestMapping(GoodsServiceProxy.QUERY_LIST)
	Result<List<Goods>> queryList(GoodsVO sample);
	
	/**
	 * 分页查询资产物品
	*/
	@RequestMapping(GoodsServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Goods>> queryPagedList(GoodsVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.GoodsController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static GoodsServiceProxy api() {
		return APIProxy.get(GoodsServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}