package com.dt.platform.proxy.contract;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.contract.ContractPerformance;
import com.dt.platform.domain.contract.ContractPerformanceVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 合同履行情况表  控制器服务代理
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-28 14:20:20
*/

@FeignClient(value = ServiceNames.CONTRACT, contextId = ContractPerformanceServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ContractPerformanceServiceProxy {

	/**
	 * 基础路径 , service-contract
	*/
	public static final String API_BASIC_PATH = "service-contract";

	/**
	 * API 上下文路径 , cont-contract-performance
	*/
	public static final String API_CONTEXT_PATH = "cont-contract-performance";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加合同履行情况
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除合同履行情况
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除合同履行情况
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新合同履行情况
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存合同履行情况
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个合同履行情况
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个合同履行情况
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询合同履行情况
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询合同履行情况
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出合同履行情况数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载合同履行情况导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入合同履行情况数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加合同履行情况
	*/
	@RequestMapping(ContractPerformanceServiceProxy.INSERT)
	Result insert(ContractPerformanceVO contractPerformanceVO);

	/**
	 * 删除合同履行情况
	*/
	@RequestMapping(ContractPerformanceServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除合同履行情况
	*/
	@RequestMapping(ContractPerformanceServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新合同履行情况
	*/
	@RequestMapping(ContractPerformanceServiceProxy.UPDATE)
	Result update(ContractPerformanceVO contractPerformanceVO);

	/**
	 * 更新合同履行情况
	*/
	@RequestMapping(ContractPerformanceServiceProxy.SAVE)
	Result save(ContractPerformanceVO contractPerformanceVO);

	/**
	 * 获取合同履行情况
	*/
	@RequestMapping(ContractPerformanceServiceProxy.GET_BY_ID)
	Result<ContractPerformance> getById(String id);

	/**
	 * 获取多个合同履行情况
	*/
	@RequestMapping(ContractPerformanceServiceProxy.GET_BY_IDS)
	Result<List<ContractPerformance>> getByIds(List<String> ids);
	/**
	 * 查询合同履行情况
	*/
	@RequestMapping(ContractPerformanceServiceProxy.QUERY_LIST)
	Result<List<ContractPerformance>> queryList(ContractPerformanceVO sample);

	/**
	 * 分页查询合同履行情况
	*/
	@RequestMapping(ContractPerformanceServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<ContractPerformance>> queryPagedList(ContractPerformanceVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.contract.controller.ContractPerformanceController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ContractPerformanceServiceProxy api() {
		return APIProxy.get(ContractPerformanceServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}