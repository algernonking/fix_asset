package com.dt.platform.proxy.knowledgebase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.knowledgebase.Content;
import com.dt.platform.domain.knowledgebase.ContentVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 知识库内容  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-15 18:35:01
*/

@FeignClient(value = ServiceNames.KNOWLEDGEBASE, contextId = ContentServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface ContentServiceProxy {
	
	/**
	 * 基础路径 , service-knowledgebase
	*/
	public static final String API_BASIC_PATH = "service-knowledgebase";
	
	/**
	 * API 上下文路径 , kn-content
	*/
	public static final String API_CONTEXT_PATH = "kn-content";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加知识库内容
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除知识库内容
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除知识库内容
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新知识库内容
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存知识库内容
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个知识库内容
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个知识库内容
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询知识库内容
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询知识库内容
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出知识库内容数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载知识库内容导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入知识库内容数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加知识库内容
	*/
	@RequestMapping(ContentServiceProxy.INSERT)
	Result insert(ContentVO contentVO);
	
	/**
	 * 删除知识库内容
	*/
	@RequestMapping(ContentServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除知识库内容
	*/
	@RequestMapping(ContentServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新知识库内容
	*/
	@RequestMapping(ContentServiceProxy.UPDATE)
	Result update(ContentVO contentVO);
	
	/**
	 * 更新知识库内容
	*/
	@RequestMapping(ContentServiceProxy.SAVE)
	Result save(ContentVO contentVO);
	
	/**
	 * 获取知识库内容
	*/
	@RequestMapping(ContentServiceProxy.GET_BY_ID)
	Result<Content> getById(String id);

	/**
	 * 批量删除知识库内容
	*/
	@RequestMapping(ContentServiceProxy.GET_BY_IDS)
	Result<List<Content>> getByIds(List<String> ids);
	/**
	 * 查询知识库内容
	*/
	@RequestMapping(ContentServiceProxy.QUERY_LIST)
	Result<List<Content>> queryList(ContentVO sample);
	
	/**
	 * 分页查询知识库内容
	*/
	@RequestMapping(ContentServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Content>> queryPagedList(ContentVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.knowledgebase.controller.ContentController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static ContentServiceProxy api() {
		return APIProxy.get(ContentServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}