package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.ops.HostPosition;
import com.dt.platform.domain.ops.HostPositionVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 主机位置  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-10 16:44:48
*/

@FeignClient(value = ServiceNames.OPS, contextId = HostPositionServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface HostPositionServiceProxy {
	
	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";
	
	/**
	 * API 上下文路径 , ops-host-position
	*/
	public static final String API_CONTEXT_PATH = "ops-host-position";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加主机位置
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除主机位置
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除主机位置
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	
	/**
	 * 更新主机位置
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存主机位置
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个主机位置
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个主机位置
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询主机位置
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询主机位置
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出主机位置数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载主机位置导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入主机位置数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加主机位置
	*/
	@RequestMapping(HostPositionServiceProxy.INSERT)
	Result insert(HostPositionVO hostPositionVO);
	
	/**
	 * 删除主机位置
	*/
	@RequestMapping(HostPositionServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除主机位置
	*/
	@RequestMapping(HostPositionServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新主机位置
	*/
	@RequestMapping(HostPositionServiceProxy.UPDATE)
	Result update(HostPositionVO hostPositionVO);
	
	/**
	 * 更新主机位置
	*/
	@RequestMapping(HostPositionServiceProxy.SAVE)
	Result save(HostPositionVO hostPositionVO);
	
	/**
	 * 获取主机位置
	*/
	@RequestMapping(HostPositionServiceProxy.GET_BY_ID)
	Result<HostPosition> getById(String id);

	/**
	 * 批量删除主机位置
	*/
	@RequestMapping(HostPositionServiceProxy.GET_BY_IDS)
	Result<List<HostPosition>> getByIds(List<String> ids);
	/**
	 * 查询主机位置
	*/
	@RequestMapping(HostPositionServiceProxy.QUERY_LIST)
	Result<List<HostPosition>> queryList(HostPositionVO sample);
	
	/**
	 * 分页查询主机位置
	*/
	@RequestMapping(HostPositionServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<HostPosition>> queryPagedList(HostPositionVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.HostPositionController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static HostPositionServiceProxy api() {
		return APIProxy.get(HostPositionServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}