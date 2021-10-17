package com.dt.platform.proxy.contract;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.contract.ContractCategory;
import com.dt.platform.domain.contract.ContractCategoryVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 合同分类  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-17 07:48:34
*/

@FeignClient(value = ServiceNames.CONTRACT, contextId = ContractCategoryServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ContractCategoryServiceProxy {

	/**
	 * 基础路径 , service-contract
	*/
	public static final String API_BASIC_PATH = "service-contract";

	/**
	 * API 上下文路径 , cont-contract-category
	*/
	public static final String API_CONTEXT_PATH = "cont-contract-category";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加合同分类
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除合同分类
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除合同分类
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新合同分类
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存合同分类
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个合同分类
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个合同分类
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询合同分类
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询合同分类
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出合同分类数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载合同分类导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入合同分类数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加合同分类
	*/
	@RequestMapping(ContractCategoryServiceProxy.INSERT)
	Result insert(ContractCategoryVO contractCategoryVO);

	/**
	 * 删除合同分类
	*/
	@RequestMapping(ContractCategoryServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除合同分类
	*/
	@RequestMapping(ContractCategoryServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新合同分类
	*/
	@RequestMapping(ContractCategoryServiceProxy.UPDATE)
	Result update(ContractCategoryVO contractCategoryVO);

	/**
	 * 更新合同分类
	*/
	@RequestMapping(ContractCategoryServiceProxy.SAVE)
	Result save(ContractCategoryVO contractCategoryVO);

	/**
	 * 获取合同分类
	*/
	@RequestMapping(ContractCategoryServiceProxy.GET_BY_ID)
	Result<ContractCategory> getById(String id);

	/**
	 * 批量删除合同分类
	*/
	@RequestMapping(ContractCategoryServiceProxy.GET_BY_IDS)
	Result<List<ContractCategory>> getByIds(List<String> ids);
	/**
	 * 查询合同分类
	*/
	@RequestMapping(ContractCategoryServiceProxy.QUERY_LIST)
	Result<List<ContractCategory>> queryList(ContractCategoryVO sample);

	/**
	 * 分页查询合同分类
	*/
	@RequestMapping(ContractCategoryServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<ContractCategory>> queryPagedList(ContractCategoryVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.contract.controller.ContractCategoryController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ContractCategoryServiceProxy api() {
		return APIProxy.get(ContractCategoryServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}