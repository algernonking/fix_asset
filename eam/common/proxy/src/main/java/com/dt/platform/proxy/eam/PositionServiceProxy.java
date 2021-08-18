package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.PositionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 存放位置  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-18 14:34:25
*/

@FeignClient(value = ServiceNames.EAM, contextId = PositionServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface PositionServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-position
	*/
	public static final String API_CONTEXT_PATH = "eam-position";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加存放位置
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除存放位置
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除存放位置
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新存放位置
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存存放位置
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个存放位置
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个存放位置
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询存放位置
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询存放位置
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出存放位置数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载存放位置导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入存放位置数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加存放位置
	*/
	@RequestMapping(PositionServiceProxy.INSERT)
	Result insert(PositionVO positionVO);
	
	/**
	 * 删除存放位置
	*/
	@RequestMapping(PositionServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除存放位置
	*/
	@RequestMapping(PositionServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新存放位置
	*/
	@RequestMapping(PositionServiceProxy.UPDATE)
	Result update(PositionVO positionVO);
	
	/**
	 * 更新存放位置
	*/
	@RequestMapping(PositionServiceProxy.SAVE)
	Result save(PositionVO positionVO);
	
	/**
	 * 获取存放位置
	*/
	@RequestMapping(PositionServiceProxy.GET_BY_ID)
	Result<Position> getById(String id);

	/**
	 * 批量删除存放位置
	*/
	@RequestMapping(PositionServiceProxy.GET_BY_IDS)
	Result<List<Position>> getByIds(List<String> ids);
	/**
	 * 查询存放位置
	*/
	@RequestMapping(PositionServiceProxy.QUERY_LIST)
	Result<List<Position>> queryList(PositionVO sample);
	
	/**
	 * 分页查询存放位置
	*/
	@RequestMapping(PositionServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Position>> queryPagedList(PositionVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.PositionController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static PositionServiceProxy api() {
		return APIProxy.get(PositionServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}