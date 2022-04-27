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


import com.dt.platform.proxy.eam.InspectionPointServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionPointVOMeta;
import com.dt.platform.domain.eam.InspectionPoint;
import com.dt.platform.domain.eam.InspectionPointVO;
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
import com.dt.platform.domain.eam.meta.InspectionPointMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionPointService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-27 07:28:39
*/

@Api(tags = "巡检点")
@ApiSort(0)
@RestController("EamInspectionPointController")
public class InspectionPointController extends SuperController {

	@Autowired
	private IInspectionPointService inspectionPointService;


	/**
	 * 添加巡检点
	*/
	@ApiOperation(value = "添加巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571598323383795712"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CONTENT , value = "巡检内容" , required = false , dataTypeClass=String.class , example = "巡检1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS , value = "位置" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LONGITUDE , value = "位置经度" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LATITUDE , value = "位置纬度" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InspectionPointServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointServiceProxy.INSERT)
	public Result insert(InspectionPointVO inspectionPointVO) {
		Result result=inspectionPointService.insert(inspectionPointVO,false);
		return result;
	}



	/**
	 * 删除巡检点
	*/
	@ApiOperation(value = "删除巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571598323383795712")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InspectionPointVOMeta.ID)
	@SentinelResource(value = InspectionPointServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inspectionPointService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检点 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InspectionPointVOMeta.IDS)
	@SentinelResource(value = InspectionPointServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inspectionPointService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新巡检点
	*/
	@ApiOperation(value = "更新巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571598323383795712"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CONTENT , value = "巡检内容" , required = false , dataTypeClass=String.class , example = "巡检1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS , value = "位置" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LONGITUDE , value = "位置经度" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LATITUDE , value = "位置纬度" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InspectionPointVOMeta.PAGE_INDEX , InspectionPointVOMeta.PAGE_SIZE , InspectionPointVOMeta.SEARCH_FIELD , InspectionPointVOMeta.FUZZY_FIELD , InspectionPointVOMeta.SEARCH_VALUE , InspectionPointVOMeta.DIRTY_FIELDS , InspectionPointVOMeta.SORT_FIELD , InspectionPointVOMeta.SORT_TYPE , InspectionPointVOMeta.IDS } )
	@NotNull(name = InspectionPointVOMeta.ID)
	@SentinelResource(value = InspectionPointServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointServiceProxy.UPDATE)
	public Result update(InspectionPointVO inspectionPointVO) {
		Result result=inspectionPointService.update(inspectionPointVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检点
	*/
	@ApiOperation(value = "保存巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571598323383795712"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CONTENT , value = "巡检内容" , required = false , dataTypeClass=String.class , example = "巡检1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS , value = "位置" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LONGITUDE , value = "位置经度" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LATITUDE , value = "位置纬度" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionPointVOMeta.PAGE_INDEX , InspectionPointVOMeta.PAGE_SIZE , InspectionPointVOMeta.SEARCH_FIELD , InspectionPointVOMeta.FUZZY_FIELD , InspectionPointVOMeta.SEARCH_VALUE , InspectionPointVOMeta.DIRTY_FIELDS , InspectionPointVOMeta.SORT_FIELD , InspectionPointVOMeta.SORT_TYPE , InspectionPointVOMeta.IDS } )
	@NotNull(name = InspectionPointVOMeta.ID)
	@SentinelResource(value = InspectionPointServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointServiceProxy.SAVE)
	public Result save(InspectionPointVO inspectionPointVO) {
		Result result=inspectionPointService.save(inspectionPointVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检点
	*/
	@ApiOperation(value = "获取巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InspectionPointVOMeta.ID)
	@SentinelResource(value = InspectionPointServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointServiceProxy.GET_BY_ID)
	public Result<InspectionPoint> getById(String id) {
		Result<InspectionPoint> result=new Result<>();
		InspectionPoint inspectionPoint=inspectionPointService.getById(id);
		result.success(true).data(inspectionPoint);
		return result;
	}


	/**
	 * 批量获取巡检点 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检点")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionPointVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InspectionPointVOMeta.IDS)
		@SentinelResource(value = InspectionPointServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointServiceProxy.GET_BY_IDS)
	public Result<List<InspectionPoint>> getByIds(List<String> ids) {
		Result<List<InspectionPoint>> result=new Result<>();
		List<InspectionPoint> list=inspectionPointService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检点
	*/
	@ApiOperation(value = "查询巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571598323383795712"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CONTENT , value = "巡检内容" , required = false , dataTypeClass=String.class , example = "巡检1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS , value = "位置" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LONGITUDE , value = "位置经度" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LATITUDE , value = "位置纬度" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionPointVOMeta.PAGE_INDEX , InspectionPointVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionPointServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointServiceProxy.QUERY_LIST)
	public Result<List<InspectionPoint>> queryList(InspectionPointVO sample) {
		Result<List<InspectionPoint>> result=new Result<>();
		List<InspectionPoint> list=inspectionPointService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检点
	*/
	@ApiOperation(value = "分页查询巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571598323383795712"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "巡检点1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InspectionPointVOMeta.CONTENT , value = "巡检内容" , required = false , dataTypeClass=String.class , example = "巡检1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS , value = "位置" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LONGITUDE , value = "位置经度" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.POS_LATITUDE , value = "位置纬度" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = InspectionPointVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InspectionPointServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionPoint>> queryPagedList(InspectionPointVO sample) {
		Result<PagedList<InspectionPoint>> result=new Result<>();
		PagedList<InspectionPoint> list=inspectionPointService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InspectionPointServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPointServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InspectionPointVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inspectionPointService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InspectionPointServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPointServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inspectionPointService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InspectionPointServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPointServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inspectionPointService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}