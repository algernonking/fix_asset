package com.dt.platform.proxy.eam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.eam.BaseStation;
import com.dt.platform.domain.eam.BaseStationVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * rfid基站  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-03 15:24:02
*/

@FeignClient(value = ServiceNames.EAM, contextId = BaseStationServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface BaseStationServiceProxy {

	/**
	 * 基础路径 , service-eam
	*/
	public static final String API_BASIC_PATH = "service-eam";

	/**
	 * API 上下文路径 , rfid-base-station
	*/
	public static final String API_CONTEXT_PATH = "rfid-base-station";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加rfid基站
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除rfid基站
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除rfid基站
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新rfid基站
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存rfid基站
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个rfid基站
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个rfid基站
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询rfid基站
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询rfid基站
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出rfid基站数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载rfid基站导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入rfid基站数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加rfid基站
	*/
	@RequestMapping(BaseStationServiceProxy.INSERT)
	Result insert(BaseStationVO baseStationVO);

	/**
	 * 删除rfid基站
	*/
	@RequestMapping(BaseStationServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除rfid基站
	*/
	@RequestMapping(BaseStationServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新rfid基站
	*/
	@RequestMapping(BaseStationServiceProxy.UPDATE)
	Result update(BaseStationVO baseStationVO);

	/**
	 * 更新rfid基站
	*/
	@RequestMapping(BaseStationServiceProxy.SAVE)
	Result save(BaseStationVO baseStationVO);

	/**
	 * 获取rfid基站
	*/
	@RequestMapping(BaseStationServiceProxy.GET_BY_ID)
	Result<BaseStation> getById(String id);

	/**
	 * 批量删除rfid基站
	*/
	@RequestMapping(BaseStationServiceProxy.GET_BY_IDS)
	Result<List<BaseStation>> getByIds(List<String> ids);
	/**
	 * 查询rfid基站
	*/
	@RequestMapping(BaseStationServiceProxy.QUERY_LIST)
	Result<List<BaseStation>> queryList(BaseStationVO sample);

	/**
	 * 分页查询rfid基站
	*/
	@RequestMapping(BaseStationServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<BaseStation>> queryPagedList(BaseStationVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.eam.controller.BaseStationController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static BaseStationServiceProxy api() {
		return APIProxy.get(BaseStationServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}