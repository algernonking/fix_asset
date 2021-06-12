package com.dt.eam.proxy.eam;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.eam.domain.eam.Maintainer;
import com.dt.eam.domain.eam.MaintainerVO;
import com.github.foxnic.springboot.api.proxy.APIProxy;
import com.dt.eam.proxy.EAMServiceNames;

/**
 * <p>
 * 维保厂商  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-06-12 14:21:18
*/

@FeignClient(value = EAMServiceNames.EAM, contextId = MaintainerServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface MaintainerServiceProxy {
	
	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";
	
	/**
	 * API 上下文路径 , eam-maintainer
	*/
	public static final String API_CONTEXT_PATH = "eam-maintainer";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加维保厂商
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除维保厂商
	 */
	public static final String DELETE = API_PREFIX + "delete";
	
	
	/**
	 * 批量删除维保厂商
	 */
	public static final String BATCH_DELETE = API_PREFIX + "batch-delete";
	
	
	/**
	 * 更新维保厂商
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存维保厂商
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取维保厂商
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";
	
	/**
	 * 查询维保厂商
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询维保厂商
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出维保厂商数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";
	
	/**
	 * 导入维保厂商数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加维保厂商
	*/
	@RequestMapping(MaintainerServiceProxy.INSERT)
	Result<Maintainer> insert(MaintainerVO maintainerVO);
	
	/**
	 * 删除维保厂商
	*/
	@RequestMapping(MaintainerServiceProxy.DELETE)
	Result<Maintainer> deleteById(String id);
	
	
	/**
	 * 批量删除维保厂商
	*/
	@RequestMapping(MaintainerServiceProxy.BATCH_DELETE)
	Result<Maintainer> deleteByIds(List<String> id);
	
	/**
	 * 更新维保厂商
	*/
	@RequestMapping(MaintainerServiceProxy.UPDATE)
	Result<Maintainer> update(MaintainerVO maintainerVO);
	
	/**
	 * 更新维保厂商
	*/
	@RequestMapping(MaintainerServiceProxy.SAVE)
	Result<Maintainer> save(MaintainerVO maintainerVO);
	
	/**
	 * 获取维保厂商
	*/
	@RequestMapping(MaintainerServiceProxy.GET_BY_ID)
	Result<Maintainer> getById(String id);
	
	/**
	 * 查询维保厂商
	*/
	@RequestMapping(MaintainerServiceProxy.QUERY_LIST)
	Result<List<Maintainer>> queryList(MaintainerVO sample);
	
	/**
	 * 分页查询维保厂商
	*/
	@RequestMapping(MaintainerServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Maintainer>> queryPagedList(MaintainerVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.eam.eam.controller.MaintainerController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static MaintainerServiceProxy api() {
		return APIProxy.get(MaintainerServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}