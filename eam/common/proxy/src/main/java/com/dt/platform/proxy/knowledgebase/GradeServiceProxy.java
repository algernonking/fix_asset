package com.dt.platform.proxy.knowledgebase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.knowledgebase.Grade;
import com.dt.platform.domain.knowledgebase.GradeVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 知识分级  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-15 18:35:03
*/

@FeignClient(value = ServiceNames.KNOWLEDGEBASE, contextId = GradeServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface GradeServiceProxy {
	
	/**
	 * 基础路径 , service-knowledgebase
	*/
	public static final String API_BASIC_PATH = "service-knowledgebase";
	
	/**
	 * API 上下文路径 , kn-grade
	*/
	public static final String API_CONTEXT_PATH = "kn-grade";
	
	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";
	
	/**
	 * 添加知识分级
	 */
	public static final String INSERT = API_PREFIX + "insert";
	
	/**
	 * 删除知识分级
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除知识分级
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";
	;
	
	/**
	 * 更新知识分级
	 */
	public static final String UPDATE = API_PREFIX + "update";
	
	
	/**
	 * 保存知识分级
	 */
	public static final String SAVE = API_PREFIX + "save";
	
	/**
	 * 获取单个知识分级
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个知识分级
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";
	;

	/**
	 * 查询知识分级
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";
	
	/**
	 * 分页查询知识分级
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";
	
	/**
	 * 导出知识分级数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载知识分级导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";
	
	/**
	 * 导入知识分级数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";
	
	/**
	 * 添加知识分级
	*/
	@RequestMapping(GradeServiceProxy.INSERT)
	Result insert(GradeVO gradeVO);
	
	/**
	 * 删除知识分级
	*/
	@RequestMapping(GradeServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除知识分级
	*/
	@RequestMapping(GradeServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新知识分级
	*/
	@RequestMapping(GradeServiceProxy.UPDATE)
	Result update(GradeVO gradeVO);
	
	/**
	 * 更新知识分级
	*/
	@RequestMapping(GradeServiceProxy.SAVE)
	Result save(GradeVO gradeVO);
	
	/**
	 * 获取知识分级
	*/
	@RequestMapping(GradeServiceProxy.GET_BY_ID)
	Result<Grade> getById(String id);

	/**
	 * 批量删除知识分级
	*/
	@RequestMapping(GradeServiceProxy.GET_BY_IDS)
	Result<List<Grade>> getByIds(List<String> ids);
	/**
	 * 查询知识分级
	*/
	@RequestMapping(GradeServiceProxy.QUERY_LIST)
	Result<List<Grade>> queryList(GradeVO sample);
	
	/**
	 * 分页查询知识分级
	*/
	@RequestMapping(GradeServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<Grade>> queryPagedList(GradeVO sample);
	
	
	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.knowledgebase.controller.GradeController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static GradeServiceProxy api() {
		return APIProxy.get(GradeServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}