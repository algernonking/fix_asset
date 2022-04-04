package com.dt.platform.vehicle.controller;


import java.util.List;

import com.dt.platform.domain.vehicle.meta.ApplyMeta;
import com.dt.platform.domain.vehicle.meta.ApplyVOMeta;
import com.dt.platform.proxy.vehicle.ApplyServiceProxy;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.vehicle.MaintenanceServiceProxy;
import com.dt.platform.domain.vehicle.meta.MaintenanceVOMeta;
import com.dt.platform.domain.vehicle.Maintenance;
import com.dt.platform.domain.vehicle.MaintenanceVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.vehicle.meta.MaintenanceMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.vehicle.Info;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.vehicle.service.IMaintenanceService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆维修保养 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 19:58:39
*/

@Api(tags = "车辆维修保养")
@ApiSort(0)
@RestController("VehicleMaintenanceController")
public class MaintenanceController extends SuperController {

	@Autowired
	private IMaintenanceService maintenanceService;


	/**
	 * 添加车辆维修保养
	*/
	@ApiOperation(value = "添加车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "562630687803314176"),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class , example = "Insurance"),
		@ApiImplicitParam(name = MaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class , example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = MaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
		@ApiImplicitParam(name = MaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "562630674318626816"),
		@ApiImplicitParam(name = MaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MaintenanceServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.INSERT)
	public Result insert(MaintenanceVO maintenanceVO) {
		Result result=maintenanceService.insert(maintenanceVO,false);
		return result;
	}



	/**
	 * 删除车辆维修保养
	*/
	@ApiOperation(value = "删除车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "562630687803314176")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MaintenanceVOMeta.ID)
	@SentinelResource(value = MaintenanceServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=maintenanceService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆维修保养 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MaintenanceVOMeta.IDS)
	@SentinelResource(value = MaintenanceServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=maintenanceService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新车辆维修保养
	*/
	@ApiOperation(value = "更新车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "562630687803314176"),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class , example = "Insurance"),
		@ApiImplicitParam(name = MaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class , example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = MaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
		@ApiImplicitParam(name = MaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "562630674318626816"),
		@ApiImplicitParam(name = MaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MaintenanceVOMeta.PAGE_INDEX , MaintenanceVOMeta.PAGE_SIZE , MaintenanceVOMeta.SEARCH_FIELD , MaintenanceVOMeta.FUZZY_FIELD , MaintenanceVOMeta.SEARCH_VALUE , MaintenanceVOMeta.DIRTY_FIELDS , MaintenanceVOMeta.SORT_FIELD , MaintenanceVOMeta.SORT_TYPE , MaintenanceVOMeta.IDS } )
	@NotNull(name = MaintenanceVOMeta.ID)
	@SentinelResource(value = MaintenanceServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.UPDATE)
	public Result update(MaintenanceVO maintenanceVO) {
		Result result=maintenanceService.update(maintenanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆维修保养
	*/
	@ApiOperation(value = "保存车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "562630687803314176"),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class , example = "Insurance"),
		@ApiImplicitParam(name = MaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class , example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = MaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
		@ApiImplicitParam(name = MaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "562630674318626816"),
		@ApiImplicitParam(name = MaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintenanceVOMeta.PAGE_INDEX , MaintenanceVOMeta.PAGE_SIZE , MaintenanceVOMeta.SEARCH_FIELD , MaintenanceVOMeta.FUZZY_FIELD , MaintenanceVOMeta.SEARCH_VALUE , MaintenanceVOMeta.DIRTY_FIELDS , MaintenanceVOMeta.SORT_FIELD , MaintenanceVOMeta.SORT_TYPE , MaintenanceVOMeta.IDS } )
	@NotNull(name = MaintenanceVOMeta.ID)
	@SentinelResource(value = MaintenanceServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.SAVE)
	public Result save(MaintenanceVO maintenanceVO) {
		Result result=maintenanceService.save(maintenanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆维修保养
	*/
	@ApiOperation(value = "获取车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MaintenanceVOMeta.ID)
	@SentinelResource(value = MaintenanceServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.GET_BY_ID)
	public Result<Maintenance> getById(String id) {
		Result<Maintenance> result=new Result<>();
		Maintenance maintenance=maintenanceService.getById(id);
		// join 关联的对象
		maintenanceService.dao().fill(maintenance)
			.with(MaintenanceMeta.MAINTENANCE_DICT)
				.with(ApplyMeta.VEHICLE_INFO_LIST)
			.execute();
		result.success(true).data(maintenance);
		return result;
	}


	/**
	 * 批量获取车辆维修保养 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆维修保养")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MaintenanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MaintenanceVOMeta.IDS)
		@SentinelResource(value = MaintenanceServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.GET_BY_IDS)
	public Result<List<Maintenance>> getByIds(List<String> ids) {
		Result<List<Maintenance>> result=new Result<>();
		List<Maintenance> list=maintenanceService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆维修保养
	*/
	@ApiOperation(value = "查询车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "562630687803314176"),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class , example = "Insurance"),
		@ApiImplicitParam(name = MaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class , example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = MaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
		@ApiImplicitParam(name = MaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "562630674318626816"),
		@ApiImplicitParam(name = MaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintenanceVOMeta.PAGE_INDEX , MaintenanceVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaintenanceServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.QUERY_LIST)
	public Result<List<Maintenance>> queryList(MaintenanceVO sample) {
		Result<List<Maintenance>> result=new Result<>();
		List<Maintenance> list=maintenanceService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆维修保养
	*/
	@ApiOperation(value = "分页查询车辆维修保养")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "562630687803314176"),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class , example = "Insurance"),
		@ApiImplicitParam(name = MaintenanceVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class , example = "2022-03-29 12:00:00"),
		@ApiImplicitParam(name = MaintenanceVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.COST , value = "费用" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
		@ApiImplicitParam(name = MaintenanceVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.REPORT_USER_NAME , value = "报修人" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintenanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class , example = "562630674318626816"),
		@ApiImplicitParam(name = MaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintenanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MaintenanceServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Maintenance>> queryPagedList(MaintenanceVO sample) {
		Result<PagedList<Maintenance>> result=new Result<>();
		PagedList<Maintenance> list=maintenanceService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		maintenanceService.dao().fill(list)
			.with(MaintenanceMeta.MAINTENANCE_DICT)
				.with(ApplyMeta.VEHICLE_INFO_LIST)
			.execute();
		result.success(true).data(list);
		return result;
	}


	/**
	 * 确认车辆申请
	 */
	@ApiOperation(value = "确认车辆申请")
	@ApiImplicitParams({
			@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "562620443333234688")
	})
	@ApiOperationSupport(order=9)
	@NotNull(name = MaintenanceVOMeta.ID)
	@SentinelResource(value = MaintenanceServiceProxy.CONFIRM , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.CONFIRM)
	public Result confirm(String id) {
		Result result=maintenanceService.confirm(id);
		return result;
	}

	/**
	 * 取消车辆申请
	 */
	@ApiOperation(value = "取消车辆申请")
	@ApiImplicitParams({
			@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "562620443333234688")
	})
	@ApiOperationSupport(order=10)
	@NotNull(name = MaintenanceVOMeta.ID)
	@SentinelResource(value = MaintenanceServiceProxy.CANCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.CANCEL)
	public Result cancel(String id) {
		Result result=maintenanceService.cancel(id);
		return result;
	}


	/**
	 * 取消车辆申请
	 */
	@ApiOperation(value = "取消车辆申请")
	@ApiImplicitParams({
			@ApiImplicitParam(name = MaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "562620443333234688")
	})
	@ApiOperationSupport(order=10)
	@NotNull(name = MaintenanceVOMeta.ID)
	@SentinelResource(value = MaintenanceServiceProxy.FINISH , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintenanceServiceProxy.FINISH)
	public Result finish(String id) {
		Result result=maintenanceService.finish(id);
		return result;
	}


	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MaintenanceServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintenanceServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MaintenanceVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=maintenanceService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MaintenanceServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintenanceServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=maintenanceService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MaintenanceServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintenanceServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

		//获得上传的文件
		Map<String, MultipartFile> map = request.getFileMap();
		InputStream input=null;
		for (MultipartFile mf : map.values()) {
			input=StreamUtil.bytes2input(mf.getBytes());
			break;
		}

		if(input==null) {
			return ErrorDesc.failure().message("缺少上传的文件");
		}

		List<ValidateResult> errors=maintenanceService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}