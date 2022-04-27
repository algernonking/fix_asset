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


import com.dt.platform.proxy.eam.InspectionPlanPointServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionPlanPointVOMeta;
import com.dt.platform.domain.eam.InspectionPlanPoint;
import com.dt.platform.domain.eam.InspectionPlanPointVO;
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
import com.dt.platform.domain.eam.meta.InspectionPlanPointMeta;
import com.dt.platform.domain.eam.InspectionPoint;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionPlanPointService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-27 07:34:35
*/

@Api(tags = "巡检点")
@ApiSort(0)
@RestController("EamInspectionPlanPointController")
public class InspectionPlanPointController extends SuperController {

	@Autowired
	private IInspectionPlanPointService inspectionPlanPointService;


	/**
	 * 添加巡检点
	*/
	@ApiOperation(value = "添加巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InspectionPlanPointServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanPointServiceProxy.INSERT)
	public Result insert(InspectionPlanPointVO inspectionPlanPointVO) {
		Result result=inspectionPlanPointService.insert(inspectionPlanPointVO,false);
		return result;
	}



	/**
	 * 删除巡检点
	*/
	@ApiOperation(value = "删除巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InspectionPlanPointVOMeta.ID)
	@SentinelResource(value = InspectionPlanPointServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanPointServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inspectionPlanPointService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检点 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InspectionPlanPointVOMeta.IDS)
	@SentinelResource(value = InspectionPlanPointServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanPointServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inspectionPlanPointService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新巡检点
	*/
	@ApiOperation(value = "更新巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InspectionPlanPointVOMeta.PAGE_INDEX , InspectionPlanPointVOMeta.PAGE_SIZE , InspectionPlanPointVOMeta.SEARCH_FIELD , InspectionPlanPointVOMeta.FUZZY_FIELD , InspectionPlanPointVOMeta.SEARCH_VALUE , InspectionPlanPointVOMeta.DIRTY_FIELDS , InspectionPlanPointVOMeta.SORT_FIELD , InspectionPlanPointVOMeta.SORT_TYPE , InspectionPlanPointVOMeta.IDS } )
	@NotNull(name = InspectionPlanPointVOMeta.ID)
	@SentinelResource(value = InspectionPlanPointServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanPointServiceProxy.UPDATE)
	public Result update(InspectionPlanPointVO inspectionPlanPointVO) {
		Result result=inspectionPlanPointService.update(inspectionPlanPointVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检点
	*/
	@ApiOperation(value = "保存巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionPlanPointVOMeta.PAGE_INDEX , InspectionPlanPointVOMeta.PAGE_SIZE , InspectionPlanPointVOMeta.SEARCH_FIELD , InspectionPlanPointVOMeta.FUZZY_FIELD , InspectionPlanPointVOMeta.SEARCH_VALUE , InspectionPlanPointVOMeta.DIRTY_FIELDS , InspectionPlanPointVOMeta.SORT_FIELD , InspectionPlanPointVOMeta.SORT_TYPE , InspectionPlanPointVOMeta.IDS } )
	@NotNull(name = InspectionPlanPointVOMeta.ID)
	@SentinelResource(value = InspectionPlanPointServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanPointServiceProxy.SAVE)
	public Result save(InspectionPlanPointVO inspectionPlanPointVO) {
		Result result=inspectionPlanPointService.save(inspectionPlanPointVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检点
	*/
	@ApiOperation(value = "获取巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InspectionPlanPointVOMeta.ID)
	@SentinelResource(value = InspectionPlanPointServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanPointServiceProxy.GET_BY_ID)
	public Result<InspectionPlanPoint> getById(String id) {
		Result<InspectionPlanPoint> result=new Result<>();
		InspectionPlanPoint inspectionPlanPoint=inspectionPlanPointService.getById(id);
		result.success(true).data(inspectionPlanPoint);
		return result;
	}


	/**
	 * 批量获取巡检点 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检点")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionPlanPointVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InspectionPlanPointVOMeta.IDS)
		@SentinelResource(value = InspectionPlanPointServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanPointServiceProxy.GET_BY_IDS)
	public Result<List<InspectionPlanPoint>> getByIds(List<String> ids) {
		Result<List<InspectionPlanPoint>> result=new Result<>();
		List<InspectionPlanPoint> list=inspectionPlanPointService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检点
	*/
	@ApiOperation(value = "查询巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionPlanPointVOMeta.PAGE_INDEX , InspectionPlanPointVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionPlanPointServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanPointServiceProxy.QUERY_LIST)
	public Result<List<InspectionPlanPoint>> queryList(InspectionPlanPointVO sample) {
		Result<List<InspectionPlanPoint>> result=new Result<>();
		List<InspectionPlanPoint> list=inspectionPlanPointService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检点
	*/
	@ApiOperation(value = "分页查询巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPlanPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InspectionPlanPointServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPlanPointServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionPlanPoint>> queryPagedList(InspectionPlanPointVO sample) {
		Result<PagedList<InspectionPlanPoint>> result=new Result<>();
		PagedList<InspectionPlanPoint> list=inspectionPlanPointService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InspectionPlanPointServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPlanPointServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InspectionPlanPointVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inspectionPlanPointService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InspectionPlanPointServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPlanPointServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inspectionPlanPointService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InspectionPlanPointServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPlanPointServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inspectionPlanPointService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}