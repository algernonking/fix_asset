package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.eam.Goods;
import com.dt.platform.domain.eam.GoodsVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 物品档案  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-18 14:34:27
*/

@FeignClient(value = ServiceNames.EAM, contextId = GoodsServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
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
	 * 添加物品档案
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除物品档案
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除物品档案
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新物品档案
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存物品档案
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个物品档案
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个物品档案
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询物品档案
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询物品档案
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出物品档案数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载物品档案导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入物品档案数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加物品档案
	*/
	@RequestMapping(GoodsServiceProxy.INSERT)
	Result insert(GoodsVO goodsVO);
	
	/**
	 * 删除物品档案
	*/
	@RequestMapping(GoodsServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除物品档案
	*/
	@RequestMapping(GoodsServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新物品档案
	*/
	@RequestMapping(GoodsServiceProxy.UPDATE)
	Result update(GoodsVO goodsVO);
	
	/**
	 * 更新物品档案
	*/
	@RequestMapping(GoodsServiceProxy.SAVE)
	Result save(GoodsVO goodsVO);
	
	/**
	 * 获取物品档案
	*/
	@RequestMapping(GoodsServiceProxy.GET_BY_ID)
	Result<Goods> getById(String id);

	/**
	 * 批量删除物品档案
	*/
	@RequestMapping(GoodsServiceProxy.GET_BY_IDS)
	Result<List<Goods>> getByIds(List<String> ids);
	/**
	 * 查询物品档案
	*/
	@RequestMapping(GoodsServiceProxy.QUERY_LIST)
	Result<List<Goods>> queryList(GoodsVO sample);
	
	/**
	 * 分页查询物品档案
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