package com.dt.platform.proxy.vehicle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.github.foxnic.web.proxy.api.APIProxy;
import org.github.foxnic.web.proxy.FeignConfiguration;

import org.springframework.cloud.openfeign.FeignClient;


import com.dt.platform.domain.vehicle.MSelectItem;
import com.dt.platform.domain.vehicle.MSelectItemVO;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.dt.platform.proxy.ServiceNames;

/**
 * <p>
 * 车辆数据  控制器服务代理
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 19:42:47
*/

@FeignClient(value = ServiceNames.VEHICLE, contextId = MSelectItemServiceProxy.API_CONTEXT_PATH , configuration = FeignConfiguration.class)
public interface MSelectItemServiceProxy {

	/**
	 * 基础路径 , service-vehicle
	*/
	public static final String API_BASIC_PATH = "service-vehicle";

	/**
	 * API 上下文路径 , vehicle-m-select-item
	*/
	public static final String API_CONTEXT_PATH = "vehicle-m-select-item";

	/**
	 * API 基础路径 , 由 API_BASIC_PATH 和 API_CONTEXT_PATH 两部分组成
	*/
	public static final String API_PREFIX = "/" + API_BASIC_PATH + "/"+API_CONTEXT_PATH+"/";

	/**
	 * 添加车辆数据
	 */
	public static final String INSERT = API_PREFIX + "insert";

;
	/**
	 * 删除车辆数据
	 */
	public static final String DELETE = API_PREFIX + "delete";

	/**
	 * 批量删除车辆数据
	 */
	public static final String DELETE_BY_IDS = API_PREFIX + "delete-by-ids";

	/**
	 * 更新车辆数据
	 */
	public static final String UPDATE = API_PREFIX + "update";


	/**
	 * 保存车辆数据
	 */
	public static final String SAVE = API_PREFIX + "save";

	/**
	 * 获取单个车辆数据
	 */
	public static final String GET_BY_ID = API_PREFIX + "get-by-id";

	/**
	 * 获取多个车辆数据
	 */
	public static final String GET_BY_IDS = API_PREFIX + "get-by-ids";

	/**
	 * 查询车辆数据
	 */
	public static final String QUERY_LIST = API_PREFIX + "query-list";

	/**
	 * 分页查询车辆数据
	 */
	public static final String QUERY_PAGED_LIST = API_PREFIX + "query-paged-list";

	/**
	 * 导出车辆数据数据(Excel)
	 */
	public static final String EXPORT_EXCEL = API_PREFIX + "export-excel";

	/**
	 * 下载车辆数据导入模版(Excel)
	 */
	public static final String EXPORT_EXCEL_TEMPLATE = API_PREFIX + "export-excel-template";

	/**
	 * 导入车辆数据数据(Excel)
	 */
	public static final String IMPORT_EXCEL = API_PREFIX + "import-excel";

	/**
	 * 添加车辆数据
	*/
	@RequestMapping(MSelectItemServiceProxy.INSERT)
	Result insert(MSelectItemVO mSelectItemVO);

	/**
	 * 删除车辆数据
	*/
	@RequestMapping(MSelectItemServiceProxy.DELETE)
	Result deleteById(String id);

	/**
	 * 批量删除车辆数据
	*/
	@RequestMapping(MSelectItemServiceProxy.DELETE_BY_IDS)
	Result deleteByIds(List<String> ids);

	/**
	 * 更新车辆数据
	*/
	@RequestMapping(MSelectItemServiceProxy.UPDATE)
	Result update(MSelectItemVO mSelectItemVO);

	/**
	 * 更新车辆数据
	*/
	@RequestMapping(MSelectItemServiceProxy.SAVE)
	Result save(MSelectItemVO mSelectItemVO);

	/**
	 * 获取车辆数据
	*/
	@RequestMapping(MSelectItemServiceProxy.GET_BY_ID)
	Result<MSelectItem> getById(String id);

	/**
	 * 获取多个车辆数据
	*/
	@RequestMapping(MSelectItemServiceProxy.GET_BY_IDS)
	Result<List<MSelectItem>> getByIds(List<String> ids);
	/**
	 * 查询车辆数据
	*/
	@RequestMapping(MSelectItemServiceProxy.QUERY_LIST)
	Result<List<MSelectItem>> queryList(MSelectItemVO sample);

	/**
	 * 分页查询车辆数据
	*/
	@RequestMapping(MSelectItemServiceProxy.QUERY_PAGED_LIST)
	Result<PagedList<MSelectItem>> queryPagedList(MSelectItemVO sample);


	/**
	 * 控制器类名
	 * */
	public static final String CONTROLLER_CLASS_NAME="com.dt.platform.vehicle.controller.MSelectItemController";

	/**
	 * 统一的调用接口，实现在单体应用和微服务应用下的无差异调用
	 * */
	public static MSelectItemServiceProxy api() {
		return APIProxy.get(MSelectItemServiceProxy.class,CONTROLLER_CLASS_NAME);
	}

}