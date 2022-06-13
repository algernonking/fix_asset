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


import com.dt.platform.proxy.eam.InspectionPointOwnerServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionPointOwnerVOMeta;
import com.dt.platform.domain.eam.InspectionPointOwner;
import com.dt.platform.domain.eam.InspectionPointOwnerVO;
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
import com.dt.platform.domain.eam.meta.InspectionPointOwnerMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionPointOwnerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-11 17:33:04
*/

@Api(tags = "巡检点")
@ApiSort(0)
@RestController("EamInspectionPointOwnerController")
public class InspectionPointOwnerController extends SuperController {

	@Autowired
	private IInspectionPointOwnerService inspectionPointOwnerService;


	/**
	 * 添加巡检点
	*/
	@ApiOperation(value = "添加巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.OWNER_ID , value = "巡检计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InspectionPointOwnerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.INSERT)
	public Result insert(InspectionPointOwnerVO inspectionPointOwnerVO) {
		Result result=inspectionPointOwnerService.insert(inspectionPointOwnerVO,false);
		return result;
	}



	/**
	 * 删除巡检点
	*/
	@ApiOperation(value = "删除巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InspectionPointOwnerVOMeta.ID)
	@SentinelResource(value = InspectionPointOwnerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inspectionPointOwnerService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检点 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InspectionPointOwnerVOMeta.IDS)
	@SentinelResource(value = InspectionPointOwnerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inspectionPointOwnerService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新巡检点
	*/
	@ApiOperation(value = "更新巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.OWNER_ID , value = "巡检计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InspectionPointOwnerVOMeta.PAGE_INDEX , InspectionPointOwnerVOMeta.PAGE_SIZE , InspectionPointOwnerVOMeta.SEARCH_FIELD , InspectionPointOwnerVOMeta.FUZZY_FIELD , InspectionPointOwnerVOMeta.SEARCH_VALUE , InspectionPointOwnerVOMeta.DIRTY_FIELDS , InspectionPointOwnerVOMeta.SORT_FIELD , InspectionPointOwnerVOMeta.SORT_TYPE , InspectionPointOwnerVOMeta.IDS } )
	@NotNull(name = InspectionPointOwnerVOMeta.ID)
	@SentinelResource(value = InspectionPointOwnerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.UPDATE)
	public Result update(InspectionPointOwnerVO inspectionPointOwnerVO) {
		Result result=inspectionPointOwnerService.update(inspectionPointOwnerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检点
	*/
	@ApiOperation(value = "保存巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.OWNER_ID , value = "巡检计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionPointOwnerVOMeta.PAGE_INDEX , InspectionPointOwnerVOMeta.PAGE_SIZE , InspectionPointOwnerVOMeta.SEARCH_FIELD , InspectionPointOwnerVOMeta.FUZZY_FIELD , InspectionPointOwnerVOMeta.SEARCH_VALUE , InspectionPointOwnerVOMeta.DIRTY_FIELDS , InspectionPointOwnerVOMeta.SORT_FIELD , InspectionPointOwnerVOMeta.SORT_TYPE , InspectionPointOwnerVOMeta.IDS } )
	@NotNull(name = InspectionPointOwnerVOMeta.ID)
	@SentinelResource(value = InspectionPointOwnerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.SAVE)
	public Result save(InspectionPointOwnerVO inspectionPointOwnerVO) {
		Result result=inspectionPointOwnerService.save(inspectionPointOwnerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检点
	*/
	@ApiOperation(value = "获取巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InspectionPointOwnerVOMeta.ID)
	@SentinelResource(value = InspectionPointOwnerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.GET_BY_ID)
	public Result<InspectionPointOwner> getById(String id) {
		Result<InspectionPointOwner> result=new Result<>();
		InspectionPointOwner inspectionPointOwner=inspectionPointOwnerService.getById(id);
		result.success(true).data(inspectionPointOwner);
		return result;
	}


	/**
	 * 批量获取巡检点 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检点")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionPointOwnerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InspectionPointOwnerVOMeta.IDS)
		@SentinelResource(value = InspectionPointOwnerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.GET_BY_IDS)
	public Result<List<InspectionPointOwner>> getByIds(List<String> ids) {
		Result<List<InspectionPointOwner>> result=new Result<>();
		List<InspectionPointOwner> list=inspectionPointOwnerService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检点
	*/
	@ApiOperation(value = "查询巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.OWNER_ID , value = "巡检计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionPointOwnerVOMeta.PAGE_INDEX , InspectionPointOwnerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionPointOwnerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.QUERY_LIST)
	public Result<List<InspectionPointOwner>> queryList(InspectionPointOwnerVO sample) {
		Result<List<InspectionPointOwner>> result=new Result<>();
		List<InspectionPointOwner> list=inspectionPointOwnerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检点
	*/
	@ApiOperation(value = "分页查询巡检点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.OWNER_ID , value = "巡检计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.POINT_ID , value = "巡检点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionPointOwnerVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InspectionPointOwnerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionPointOwnerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionPointOwner>> queryPagedList(InspectionPointOwnerVO sample) {
		Result<PagedList<InspectionPointOwner>> result=new Result<>();
		PagedList<InspectionPointOwner> list=inspectionPointOwnerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InspectionPointOwnerServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPointOwnerServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InspectionPointOwnerVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inspectionPointOwnerService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InspectionPointOwnerServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPointOwnerServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inspectionPointOwnerService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InspectionPointOwnerServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionPointOwnerServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inspectionPointOwnerService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}