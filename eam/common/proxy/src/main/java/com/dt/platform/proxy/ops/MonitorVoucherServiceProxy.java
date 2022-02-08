package com.dt.platform.proxy.ops;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.ops.MonitorVoucher;
import com.dt.platform.domain.ops.MonitorVoucherVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 监控凭证  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:58
*/

@FeignClient(value = ServiceNames.OPS, contextId = MonitorVoucherServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface MonitorVoucherServiceProxy {

	/**
	 * 基础路径 , service-ops
	*/
	public static final String API_BASIC_PATH = "service-ops";

	/**
	 * API 上下文路径 , ops-monitor-voucher
	*/
	public static final String API_CONTEXT_PATH = "ops-monitor-voucher";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加监控凭证
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除监控凭证
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除监控凭证
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新监控凭证
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存监控凭证
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个监控凭证
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个监控凭证
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询监控凭证
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询监控凭证
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出监控凭证数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载监控凭证导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入监控凭证数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加监控凭证
	*/
	@RequestMapping(MonitorVoucherServiceProxy.INSERT)
	Result insert(MonitorVoucherVO monitorVoucherVO);

	/**
	 * 删除监控凭证
	*/
	@RequestMapping(MonitorVoucherServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除监控凭证
	*/
	@RequestMapping(MonitorVoucherServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新监控凭证
	*/
	@RequestMapping(MonitorVoucherServiceProxy.UPDATE)
	Result update(MonitorVoucherVO monitorVoucherVO);

	/**
	 * 更新监控凭证
	*/
	@RequestMapping(MonitorVoucherServiceProxy.SAVE)
	Result save(MonitorVoucherVO monitorVoucherVO);

	/**
	 * 获取监控凭证
	*/
	@RequestMapping(MonitorVoucherServiceProxy.GET_BY_ID)
	Result<MonitorVoucher> getById(String id);

	/**
	 * 获取多个监控凭证
	*/
	@RequestMapping(MonitorVoucherServiceProxy.GET_BY_IDS)
	Result<List<MonitorVoucher>> getByIds(List<String> ids);
	/**
	 * 查询监控凭证
	*/
	@RequestMapping(MonitorVoucherServiceProxy.QUERY_LIST)
	Result<List<MonitorVoucher>> queryList(MonitorVoucherVO sample);

	/**
	 * 分页查询监控凭证
	*/
	@RequestMapping(MonitorVoucherServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<MonitorVoucher>> queryPagedList(MonitorVoucherVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.ops.controller.MonitorVoucherController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static MonitorVoucherServiceProxy api() {
		return APIProxy.get(MonitorVoucherServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}