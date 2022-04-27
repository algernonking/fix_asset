package com.dt.platform.eam.controller;


import java.util.List;

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


import com.dt.platform.proxy.eam.InspectionPlanServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionPlanVOMeta;
import com.dt.platform.domain.eam.InspectionPlan;
import com.dt.platform.domain.eam.InspectionPlanVO;
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
import com.dt.platform.domain.eam.meta.InspectionPlanMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.InspectionGroup;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.InspectionPlanPoint;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionPlanService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检计划 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-27 12:06:50
*/

@Api(tags = "巡检计划")
@ApiSort(0)
@RestController("EamInspectionPlanController")
public class InspectionPlanController extends SuperController {

	@Autowired
	private IInspectionPlanService inspectionPlanService;


	/**
	 * 添加巡检计划
	*/
	@ApiOperation(value = "添加巡检计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_CODE , value = "计划编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.START_DATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.END_DATE , value = "截止日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.INSPECTION_METHOD , value = "巡检顺序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.INSPECTION_TYPE , value = "巡检类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.COMPLETION_TIME , value = "时间要求" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.OVERTIME_METHOD , value = "超时处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InspectionPlanServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanServiceProxy.INSERT)
	public Result insert(InspectionPlanVO inspectionPlanVO) {
		Result result=inspectionPlanService.insert(inspectionPlanVO,false);
		return result;
	}



	/**
	 * 删除巡检计划
	*/
	@ApiOperation(value = "删除巡检计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InspectionPlanVOMeta.ID)
	@SentinelResource(value = InspectionPlanServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inspectionPlanService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检计划 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InspectionPlanVOMeta.IDS)
	@SentinelResource(value = InspectionPlanServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inspectionPlanService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新巡检计划
	*/
	@ApiOperation(value = "更新巡检计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_CODE , value = "计划编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.START_DATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.END_DATE , value = "截止日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.INSPECTION_METHOD , value = "巡检顺序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.INSPECTION_TYPE , value = "巡检类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.COMPLETION_TIME , value = "时间要求" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.OVERTIME_METHOD , value = "超时处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InspectionPlanVOMeta.PAGE_INDEX , InspectionPlanVOMeta.PAGE_SIZE , InspectionPlanVOMeta.SEARCH_FIELD , InspectionPlanVOMeta.FUZZY_FIELD , InspectionPlanVOMeta.SEARCH_VALUE , InspectionPlanVOMeta.DIRTY_FIELDS , InspectionPlanVOMeta.SORT_FIELD , InspectionPlanVOMeta.SORT_TYPE , InspectionPlanVOMeta.IDS } )
	@NotNull(name = InspectionPlanVOMeta.ID)
	@SentinelResource(value = InspectionPlanServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanServiceProxy.UPDATE)
	public Result update(InspectionPlanVO inspectionPlanVO) {
		Result result=inspectionPlanService.update(inspectionPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检计划
	*/
	@ApiOperation(value = "保存巡检计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_CODE , value = "计划编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.START_DATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.END_DATE , value = "截止日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.INSPECTION_METHOD , value = "巡检顺序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.INSPECTION_TYPE , value = "巡检类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.COMPLETION_TIME , value = "时间要求" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.OVERTIME_METHOD , value = "超时处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionPlanVOMeta.PAGE_INDEX , InspectionPlanVOMeta.PAGE_SIZE , InspectionPlanVOMeta.SEARCH_FIELD , InspectionPlanVOMeta.FUZZY_FIELD , InspectionPlanVOMeta.SEARCH_VALUE , InspectionPlanVOMeta.DIRTY_FIELDS , InspectionPlanVOMeta.SORT_FIELD , InspectionPlanVOMeta.SORT_TYPE , InspectionPlanVOMeta.IDS } )
	@NotNull(name = InspectionPlanVOMeta.ID)
	@SentinelResource(value = InspectionPlanServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanServiceProxy.SAVE)
	public Result save(InspectionPlanVO inspectionPlanVO) {
		Result result=inspectionPlanService.save(inspectionPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检计划
	*/
	@ApiOperation(value = "获取巡检计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InspectionPlanVOMeta.ID)
	@SentinelResource(value = InspectionPlanServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanServiceProxy.GET_BY_ID)
	public Result<InspectionPlan> getById(String id) {
		Result<InspectionPlan> result=new Result<>();
		InspectionPlan inspectionPlan=inspectionPlanService.getById(id);
		// join 关联的对象
		inspectionPlanService.dao().fill(inspectionPlan)
			.with(InspectionPlanMeta.INSPECTION_GROUP)
			.with(InspectionPlanMeta.INSPECTION_TYPE_DICT)
			.execute();
		result.success(true).data(inspectionPlan);
		return result;
	}


	/**
	 * 批量获取巡检计划 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检计划")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InspectionPlanVOMeta.IDS)
		@SentinelResource(value = InspectionPlanServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanServiceProxy.GET_BY_IDS)
	public Result<List<InspectionPlan>> getByIds(List<String> ids) {
		Result<List<InspectionPlan>> result=new Result<>();
		List<InspectionPlan> list=inspectionPlanService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检计划
	*/
	@ApiOperation(value = "查询巡检计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_CODE , value = "计划编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.START_DATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.END_DATE , value = "截止日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.INSPECTION_METHOD , value = "巡检顺序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.INSPECTION_TYPE , value = "巡检类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.COMPLETION_TIME , value = "时间要求" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.OVERTIME_METHOD , value = "超时处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionPlanVOMeta.PAGE_INDEX , InspectionPlanVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionPlanServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanServiceProxy.QUERY_LIST)
	public Result<List<InspectionPlan>> queryList(InspectionPlanVO sample) {
		Result<List<InspectionPlan>> result=new Result<>();
		List<InspectionPlan> list=inspectionPlanService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检计划
	*/
	@ApiOperation(value = "分页查询巡检计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_CODE , value = "计划编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.START_DATE , value = "开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.END_DATE , value = "截止日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.INSPECTION_METHOD , value = "巡检顺序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.INSPECTION_TYPE , value = "巡检类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.COMPLETION_TIME , value = "时间要求" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.OVERTIME_METHOD , value = "超时处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InspectionPlanServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionPlan>> queryPagedList(InspectionPlanVO sample) {
		Result<PagedList<InspectionPlan>> result=new Result<>();
		PagedList<InspectionPlan> list=inspectionPlanService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		inspectionPlanService.dao().fill(list)
			.with(InspectionPlanMeta.INSPECTION_GROUP)
			.with(InspectionPlanMeta.INSPECTION_TYPE_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InspectionPlanServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPlanServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InspectionPlanVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inspectionPlanService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InspectionPlanServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPlanServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inspectionPlanService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InspectionPlanServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPlanServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inspectionPlanService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}