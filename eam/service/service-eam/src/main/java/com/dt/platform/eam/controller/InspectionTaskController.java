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


import com.dt.platform.proxy.eam.InspectionTaskServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionTaskVOMeta;
import com.dt.platform.domain.eam.InspectionTask;
import com.dt.platform.domain.eam.InspectionTaskVO;
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
import com.dt.platform.domain.eam.meta.InspectionTaskMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.InspectionPlan;
import com.dt.platform.domain.eam.InspectionPoint;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.InspectionGroup;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionTaskService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检任务 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-10 07:34:05
*/

@Api(tags = "巡检任务")
@ApiSort(0)
@RestController("EamInspectionTaskController")
public class InspectionTaskController extends SuperController {

	@Autowired
	private IInspectionTaskService inspectionTaskService;


	/**
	 * 添加巡检任务
	*/
	@ApiOperation(value = "添加巡检任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_ID , value = "巡检计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.TASK_STATUS , value = "任务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_CODE , value = "巡检编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_NAME , value = "巡检名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_INSPECTION_METHOD , value = "巡检顺序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_COMPLETION_TIME , value = "时间要求" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_NOTES , value = "巡检备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.GROUP_ID , value = "巡检班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.EXECUTOR_ID , value = "执行人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_START_TIME , value = "应开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_START_TIME , value = "实际开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_FINISH_TIME , value = "实际完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_TOTAL_COST , value = "实际工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.CONTENT , value = "任务反馈" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InspectionTaskServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskServiceProxy.INSERT)
	public Result insert(InspectionTaskVO inspectionTaskVO) {
		Result result=inspectionTaskService.insert(inspectionTaskVO,false);
		return result;
	}



	/**
	 * 删除巡检任务
	*/
	@ApiOperation(value = "删除巡检任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InspectionTaskVOMeta.ID)
	@SentinelResource(value = InspectionTaskServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inspectionTaskService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检任务 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InspectionTaskVOMeta.IDS)
	@SentinelResource(value = InspectionTaskServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inspectionTaskService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新巡检任务
	*/
	@ApiOperation(value = "更新巡检任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_ID , value = "巡检计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.TASK_STATUS , value = "任务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_CODE , value = "巡检编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_NAME , value = "巡检名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_INSPECTION_METHOD , value = "巡检顺序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_COMPLETION_TIME , value = "时间要求" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_NOTES , value = "巡检备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.GROUP_ID , value = "巡检班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.EXECUTOR_ID , value = "执行人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_START_TIME , value = "应开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_START_TIME , value = "实际开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_FINISH_TIME , value = "实际完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_TOTAL_COST , value = "实际工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.CONTENT , value = "任务反馈" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InspectionTaskVOMeta.PAGE_INDEX , InspectionTaskVOMeta.PAGE_SIZE , InspectionTaskVOMeta.SEARCH_FIELD , InspectionTaskVOMeta.FUZZY_FIELD , InspectionTaskVOMeta.SEARCH_VALUE , InspectionTaskVOMeta.DIRTY_FIELDS , InspectionTaskVOMeta.SORT_FIELD , InspectionTaskVOMeta.SORT_TYPE , InspectionTaskVOMeta.IDS } )
	@NotNull(name = InspectionTaskVOMeta.ID)
	@SentinelResource(value = InspectionTaskServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskServiceProxy.UPDATE)
	public Result update(InspectionTaskVO inspectionTaskVO) {
		Result result=inspectionTaskService.update(inspectionTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检任务
	*/
	@ApiOperation(value = "保存巡检任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_ID , value = "巡检计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.TASK_STATUS , value = "任务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_CODE , value = "巡检编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_NAME , value = "巡检名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_INSPECTION_METHOD , value = "巡检顺序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_COMPLETION_TIME , value = "时间要求" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_NOTES , value = "巡检备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.GROUP_ID , value = "巡检班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.EXECUTOR_ID , value = "执行人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_START_TIME , value = "应开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_START_TIME , value = "实际开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_FINISH_TIME , value = "实际完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_TOTAL_COST , value = "实际工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.CONTENT , value = "任务反馈" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionTaskVOMeta.PAGE_INDEX , InspectionTaskVOMeta.PAGE_SIZE , InspectionTaskVOMeta.SEARCH_FIELD , InspectionTaskVOMeta.FUZZY_FIELD , InspectionTaskVOMeta.SEARCH_VALUE , InspectionTaskVOMeta.DIRTY_FIELDS , InspectionTaskVOMeta.SORT_FIELD , InspectionTaskVOMeta.SORT_TYPE , InspectionTaskVOMeta.IDS } )
	@NotNull(name = InspectionTaskVOMeta.ID)
	@SentinelResource(value = InspectionTaskServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskServiceProxy.SAVE)
	public Result save(InspectionTaskVO inspectionTaskVO) {
		Result result=inspectionTaskService.save(inspectionTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检任务
	*/
	@ApiOperation(value = "获取巡检任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InspectionTaskVOMeta.ID)
	@SentinelResource(value = InspectionTaskServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskServiceProxy.GET_BY_ID)
	public Result<InspectionTask> getById(String id) {
		Result<InspectionTask> result=new Result<>();
		InspectionTask inspectionTask=inspectionTaskService.getById(id);
		// join 关联的对象
		inspectionTaskService.dao().fill(inspectionTask)
			.with(InspectionTaskMeta.INSPECTION_GROUP)
			.execute();
		result.success(true).data(inspectionTask);
		return result;
	}


	/**
	 * 批量获取巡检任务 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检任务")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InspectionTaskVOMeta.IDS)
		@SentinelResource(value = InspectionTaskServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskServiceProxy.GET_BY_IDS)
	public Result<List<InspectionTask>> getByIds(List<String> ids) {
		Result<List<InspectionTask>> result=new Result<>();
		List<InspectionTask> list=inspectionTaskService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检任务
	*/
	@ApiOperation(value = "查询巡检任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_ID , value = "巡检计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.TASK_STATUS , value = "任务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_CODE , value = "巡检编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_NAME , value = "巡检名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_INSPECTION_METHOD , value = "巡检顺序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_COMPLETION_TIME , value = "时间要求" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_NOTES , value = "巡检备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.GROUP_ID , value = "巡检班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.EXECUTOR_ID , value = "执行人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_START_TIME , value = "应开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_START_TIME , value = "实际开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_FINISH_TIME , value = "实际完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_TOTAL_COST , value = "实际工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.CONTENT , value = "任务反馈" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionTaskVOMeta.PAGE_INDEX , InspectionTaskVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionTaskServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskServiceProxy.QUERY_LIST)
	public Result<List<InspectionTask>> queryList(InspectionTaskVO sample) {
		Result<List<InspectionTask>> result=new Result<>();
		List<InspectionTask> list=inspectionTaskService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检任务
	*/
	@ApiOperation(value = "分页查询巡检任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_ID , value = "巡检计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.TASK_STATUS , value = "任务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_CODE , value = "巡检编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_NAME , value = "巡检名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_INSPECTION_METHOD , value = "巡检顺序" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_COMPLETION_TIME , value = "时间要求" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_NOTES , value = "巡检备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.GROUP_ID , value = "巡检班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.EXECUTOR_ID , value = "执行人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.PLAN_START_TIME , value = "应开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_START_TIME , value = "实际开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_FINISH_TIME , value = "实际完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.ACT_TOTAL_COST , value = "实际工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.CONTENT , value = "任务反馈" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InspectionTaskServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionTask>> queryPagedList(InspectionTaskVO sample) {
		Result<PagedList<InspectionTask>> result=new Result<>();
		PagedList<InspectionTask> list=inspectionTaskService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		inspectionTaskService.dao().fill(list)
			.with(InspectionTaskMeta.INSPECTION_GROUP)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InspectionTaskServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionTaskServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InspectionTaskVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inspectionTaskService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InspectionTaskServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionTaskServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inspectionTaskService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InspectionTaskServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionTaskServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inspectionTaskService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}