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


import com.dt.platform.proxy.eam.InspectionTaskPointServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionTaskPointVOMeta;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import com.dt.platform.domain.eam.InspectionTaskPointVO;
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
import com.dt.platform.domain.eam.meta.InspectionTaskPointMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionTaskPointService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-10 07:20:13
*/

@Api(tags = "巡检点")
@ApiSort(0)
@RestController("EamInspectionTaskPointController")
public class InspectionTaskPointController extends SuperController {

	@Autowired
	private IInspectionTaskPointService inspectionTaskPointService;


	/**
	 * 添加巡检点
	*/
	@ApiOperation(value = "添加巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InspectionTaskPointServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointServiceProxy.INSERT)
	public Result insert(InspectionTaskPointVO inspectionTaskPointVO) {
		Result result=inspectionTaskPointService.insert(inspectionTaskPointVO,false);
		return result;
	}



	/**
	 * 删除巡检点
	*/
	@ApiOperation(value = "删除巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InspectionTaskPointVOMeta.ID)
	@SentinelResource(value = InspectionTaskPointServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inspectionTaskPointService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检点 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InspectionTaskPointVOMeta.IDS)
	@SentinelResource(value = InspectionTaskPointServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inspectionTaskPointService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新巡检点
	*/
	@ApiOperation(value = "更新巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InspectionTaskPointVOMeta.PAGE_INDEX , InspectionTaskPointVOMeta.PAGE_SIZE , InspectionTaskPointVOMeta.SEARCH_FIELD , InspectionTaskPointVOMeta.FUZZY_FIELD , InspectionTaskPointVOMeta.SEARCH_VALUE , InspectionTaskPointVOMeta.DIRTY_FIELDS , InspectionTaskPointVOMeta.SORT_FIELD , InspectionTaskPointVOMeta.SORT_TYPE , InspectionTaskPointVOMeta.IDS } )
	@NotNull(name = InspectionTaskPointVOMeta.ID)
	@SentinelResource(value = InspectionTaskPointServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointServiceProxy.UPDATE)
	public Result update(InspectionTaskPointVO inspectionTaskPointVO) {
		Result result=inspectionTaskPointService.update(inspectionTaskPointVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检点
	*/
	@ApiOperation(value = "保存巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionTaskPointVOMeta.PAGE_INDEX , InspectionTaskPointVOMeta.PAGE_SIZE , InspectionTaskPointVOMeta.SEARCH_FIELD , InspectionTaskPointVOMeta.FUZZY_FIELD , InspectionTaskPointVOMeta.SEARCH_VALUE , InspectionTaskPointVOMeta.DIRTY_FIELDS , InspectionTaskPointVOMeta.SORT_FIELD , InspectionTaskPointVOMeta.SORT_TYPE , InspectionTaskPointVOMeta.IDS } )
	@NotNull(name = InspectionTaskPointVOMeta.ID)
	@SentinelResource(value = InspectionTaskPointServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointServiceProxy.SAVE)
	public Result save(InspectionTaskPointVO inspectionTaskPointVO) {
		Result result=inspectionTaskPointService.save(inspectionTaskPointVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检点
	*/
	@ApiOperation(value = "获取巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InspectionTaskPointVOMeta.ID)
	@SentinelResource(value = InspectionTaskPointServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointServiceProxy.GET_BY_ID)
	public Result<InspectionTaskPoint> getById(String id) {
		Result<InspectionTaskPoint> result=new Result<>();
		InspectionTaskPoint inspectionTaskPoint=inspectionTaskPointService.getById(id);
		result.success(true).data(inspectionTaskPoint);
		return result;
	}


	/**
	 * 批量获取巡检点 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检点")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionTaskPointVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InspectionTaskPointVOMeta.IDS)
		@SentinelResource(value = InspectionTaskPointServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointServiceProxy.GET_BY_IDS)
	public Result<List<InspectionTaskPoint>> getByIds(List<String> ids) {
		Result<List<InspectionTaskPoint>> result=new Result<>();
		List<InspectionTaskPoint> list=inspectionTaskPointService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检点
	*/
	@ApiOperation(value = "查询巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionTaskPointVOMeta.PAGE_INDEX , InspectionTaskPointVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionTaskPointServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointServiceProxy.QUERY_LIST)
	public Result<List<InspectionTaskPoint>> queryList(InspectionTaskPointVO sample) {
		Result<List<InspectionTaskPoint>> result=new Result<>();
		List<InspectionTaskPoint> list=inspectionTaskPointService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检点
	*/
	@ApiOperation(value = "分页查询巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionTaskPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InspectionTaskPointServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionTaskPointServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionTaskPoint>> queryPagedList(InspectionTaskPointVO sample) {
		Result<PagedList<InspectionTaskPoint>> result=new Result<>();
		PagedList<InspectionTaskPoint> list=inspectionTaskPointService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InspectionTaskPointServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionTaskPointServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InspectionTaskPointVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inspectionTaskPointService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InspectionTaskPointServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionTaskPointServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inspectionTaskPointService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InspectionTaskPointServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionTaskPointServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inspectionTaskPointService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}