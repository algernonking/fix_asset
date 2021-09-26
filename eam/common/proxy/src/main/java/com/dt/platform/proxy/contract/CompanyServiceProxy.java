package com.dt.platform.proxy.contract;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.contract.Company;
import com.dt.platform.domain.contract.CompanyVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 单位  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 11:17:15
*/

@FeignClient(value = ServiceNames.CONTRACT, contextId = CompanyServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface CompanyServiceProxy {
	
	/**
	 * 基础路径 , service-contract
	*/
	public static final String API_BASIC_PATH = "service-contract";
	
	/**
	 * API 上下文路径 , cont-company
	*/
	public static final String API_CONTEXT_PATH = "cont-company";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加单位
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除单位
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除单位
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	
	/**
	 * 更新单位
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存单位
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个单位
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个单位
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询单位
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询单位
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出单位数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载单位导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入单位数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加单位
	*/
	@RequestMapping(CompanyServiceProxy.INSERT)
	Result insert(CompanyVO companyVO);
	
	/**
	 * 删除单位
	*/
	@RequestMapping(CompanyServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除单位
	*/
	@RequestMapping(CompanyServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新单位
	*/
	@RequestMapping(CompanyServiceProxy.UPDATE)
	Result update(CompanyVO companyVO);
	
	/**
	 * 更新单位
	*/
	@RequestMapping(CompanyServiceProxy.SAVE)
	Result save(CompanyVO companyVO);
	
	/**
	 * 获取单位
	*/
	@RequestMapping(CompanyServiceProxy.GET_BY_ID)
	Result<Company> getById(String id);

	/**
	 * 批量删除单位
	*/
	@RequestMapping(CompanyServiceProxy.GET_BY_IDS)
	Result<List<Company>> getByIds(List<String> ids);
	/**
	 * 查询单位
	*/
	@RequestMapping(CompanyServiceProxy.QUERY_LIST)
	Result<List<Company>> queryList(CompanyVO sample);
	
	/**
	 * 分页查询单位
	*/
	@RequestMapping(CompanyServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Company>> queryPagedList(CompanyVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.contract.controller.CompanyController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static CompanyServiceProxy api() {
		return APIProxy.get(CompanyServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}