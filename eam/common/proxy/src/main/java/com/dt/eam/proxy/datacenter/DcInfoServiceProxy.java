package com.dt.eam.proxy.datacenter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.eam.domain.datacenter.DcInfo;
import com.dt.eam.domain.datacenter.DcInfoVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.eam.proxy.EAMServiceNames;

/**
 * <p>
 * 数据中心  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-26 15:14:29
*/

@FeignClient(value = EAMServiceNames.DATACENTER, contextId = DcInfoServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface DcInfoServiceProxy {
	
	/**
	 * 基础路径 , service-datacenter
	*/
	public static final String API_BASIC_PATH = "service-datacenter";
	
	/**
	 * API 上下文路径 , dc-info
	*/
	public static final String API_CONTEXT_PATH = "dc-info";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加数据中心
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除数据中心
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除数据中心
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新数据中心
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存数据中心
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个数据中心
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个数据中心
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询数据中心
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询数据中心
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出数据中心数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载数据中心导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入数据中心数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加数据中心
	*/
	@RequestMapping(DcInfoServiceProxy.INSERT)
	Result insert(DcInfoVO dcInfoVO);
	
	/**
	 * 删除数据中心
	*/
	@RequestMapping(DcInfoServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除数据中心
	*/
	@RequestMapping(DcInfoServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新数据中心
	*/
	@RequestMapping(DcInfoServiceProxy.UPDATE)
	Result update(DcInfoVO dcInfoVO);
	
	/**
	 * 更新数据中心
	*/
	@RequestMapping(DcInfoServiceProxy.SAVE)
	Result save(DcInfoVO dcInfoVO);
	
	/**
	 * 获取数据中心
	*/
	@RequestMapping(DcInfoServiceProxy.GET_BY_ID)
	Result<DcInfo> getById(String id);

	/**
	 * 批量删除数据中心
	*/
	@RequestMapping(DcInfoServiceProxy.GET_BY_IDS)
	Result<List<DcInfo>> getByIds(List<String> ids);
	/**
	 * 查询数据中心
	*/
	@RequestMapping(DcInfoServiceProxy.QUERY_LIST)
	Result<List<DcInfo>> queryList(DcInfoVO sample);
	
	/**
	 * 分页查询数据中心
	*/
	@RequestMapping(DcInfoServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<DcInfo>> queryPagedList(DcInfoVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.eam.datacenter.controller.DcInfoController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static DcInfoServiceProxy api() {
		return APIProxy.get(DcInfoServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}