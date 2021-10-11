package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.eam.Operate;
import com.dt.platform.domain.eam.OperateVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 资产操作  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 20:02:16
*/

@FeignClient(value = ServiceNames.EAM, contextId = OperateServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface OperateServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-operate
	*/
	public static final String API_CONTEXT_PATH = "eam-operate";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加资产操作
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除资产操作
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除资产操作
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	
	/**
	 * 更新资产操作
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存资产操作
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个资产操作
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个资产操作
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询资产操作
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询资产操作
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出资产操作数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载资产操作导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入资产操作数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";


	/**
	 * 是否需要审批
	 */
	public static final String APPROVAL_REQUIRED = API_PREFIX + "approval-required";


	/**
	 * 资产更新判断
	 */
	public static final String QUERY_ASSET_DIRECT_UPDATE_MODE = API_PREFIX + "query-asset-direct-update-mode";


	/**
	 * 资产更新判断
	 */
	@RequestMapping(OperateServiceProxy.QUERY_ASSET_DIRECT_UPDATE_MODE)
	public Result queryAssetDirectUpdateMode();


	/**
	 * 是否需要审批
	 */
	@RequestMapping(OperateServiceProxy.APPROVAL_REQUIRED)
	public Result approvalRequired(String businessType);

	
	/**
	 * 添加资产操作
	*/
	@RequestMapping(OperateServiceProxy.INSERT)
	Result insert(OperateVO operateVO);
	
	/**
	 * 删除资产操作
	*/
	@RequestMapping(OperateServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除资产操作
	*/
	@RequestMapping(OperateServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新资产操作
	*/
	@RequestMapping(OperateServiceProxy.UPDATE)
	Result update(OperateVO operateVO);
	
	/**
	 * 更新资产操作
	*/
	@RequestMapping(OperateServiceProxy.SAVE)
	Result save(OperateVO operateVO);
	
	/**
	 * 获取资产操作
	*/
	@RequestMapping(OperateServiceProxy.GET_BY_ID)
	Result<Operate> getById(String id);

	/**
	 * 批量删除资产操作
	*/
	@RequestMapping(OperateServiceProxy.GET_BY_IDS)
	Result<List<Operate>> getByIds(List<String> ids);
	/**
	 * 查询资产操作
	*/
	@RequestMapping(OperateServiceProxy.QUERY_LIST)
	Result<List<Operate>> queryList(OperateVO sample);
	
	/**
	 * 分页查询资产操作
	*/
	@RequestMapping(OperateServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Operate>> queryPagedList(OperateVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.OperateController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static OperateServiceProxy api() {
		return APIProxy.get(OperateServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}