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


import com.dt.platform.proxy.eam.InspectionRouteServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionRouteVOMeta;
import com.dt.platform.domain.eam.InspectionRoute;
import com.dt.platform.domain.eam.InspectionRouteVO;
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
import com.dt.platform.domain.eam.meta.InspectionRouteMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionRouteService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检路径 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 14:02:52
*/

@Api(tags = "巡检路径")
@ApiSort(0)
@RestController("EamInspectionRouteController")
public class InspectionRouteController extends SuperController {

	@Autowired
	private IInspectionRouteService inspectionRouteService;


	/**
	 * 添加巡检路径
	*/
	@ApiOperation(value = "添加巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584743523325050880"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NAME , value = "路径" , required = false , dataTypeClass=String.class , example = "默认路线"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InspectionRouteServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.INSERT)
	public Result insert(InspectionRouteVO inspectionRouteVO) {
		Result result=inspectionRouteService.insert(inspectionRouteVO,false);
		return result;
	}



	/**
	 * 删除巡检路径
	*/
	@ApiOperation(value = "删除巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584743523325050880")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InspectionRouteVOMeta.ID)
	@SentinelResource(value = InspectionRouteServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inspectionRouteService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检路径 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InspectionRouteVOMeta.IDS)
	@SentinelResource(value = InspectionRouteServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inspectionRouteService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新巡检路径
	*/
	@ApiOperation(value = "更新巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584743523325050880"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NAME , value = "路径" , required = false , dataTypeClass=String.class , example = "默认路线"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InspectionRouteVOMeta.PAGE_INDEX , InspectionRouteVOMeta.PAGE_SIZE , InspectionRouteVOMeta.SEARCH_FIELD , InspectionRouteVOMeta.FUZZY_FIELD , InspectionRouteVOMeta.SEARCH_VALUE , InspectionRouteVOMeta.DIRTY_FIELDS , InspectionRouteVOMeta.SORT_FIELD , InspectionRouteVOMeta.SORT_TYPE , InspectionRouteVOMeta.IDS } )
	@NotNull(name = InspectionRouteVOMeta.ID)
	@SentinelResource(value = InspectionRouteServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.UPDATE)
	public Result update(InspectionRouteVO inspectionRouteVO) {
		Result result=inspectionRouteService.update(inspectionRouteVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检路径
	*/
	@ApiOperation(value = "保存巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584743523325050880"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NAME , value = "路径" , required = false , dataTypeClass=String.class , example = "默认路线"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionRouteVOMeta.PAGE_INDEX , InspectionRouteVOMeta.PAGE_SIZE , InspectionRouteVOMeta.SEARCH_FIELD , InspectionRouteVOMeta.FUZZY_FIELD , InspectionRouteVOMeta.SEARCH_VALUE , InspectionRouteVOMeta.DIRTY_FIELDS , InspectionRouteVOMeta.SORT_FIELD , InspectionRouteVOMeta.SORT_TYPE , InspectionRouteVOMeta.IDS } )
	@NotNull(name = InspectionRouteVOMeta.ID)
	@SentinelResource(value = InspectionRouteServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.SAVE)
	public Result save(InspectionRouteVO inspectionRouteVO) {
		Result result=inspectionRouteService.save(inspectionRouteVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检路径
	*/
	@ApiOperation(value = "获取巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InspectionRouteVOMeta.ID)
	@SentinelResource(value = InspectionRouteServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.GET_BY_ID)
	public Result<InspectionRoute> getById(String id) {
		Result<InspectionRoute> result=new Result<>();
		InspectionRoute inspectionRoute=inspectionRouteService.getById(id);
		result.success(true).data(inspectionRoute);
		return result;
	}


	/**
	 * 批量获取巡检路径 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检路径")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionRouteVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InspectionRouteVOMeta.IDS)
		@SentinelResource(value = InspectionRouteServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.GET_BY_IDS)
	public Result<List<InspectionRoute>> getByIds(List<String> ids) {
		Result<List<InspectionRoute>> result=new Result<>();
		List<InspectionRoute> list=inspectionRouteService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检路径
	*/
	@ApiOperation(value = "查询巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584743523325050880"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NAME , value = "路径" , required = false , dataTypeClass=String.class , example = "默认路线"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionRouteVOMeta.PAGE_INDEX , InspectionRouteVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionRouteServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.QUERY_LIST)
	public Result<List<InspectionRoute>> queryList(InspectionRouteVO sample) {
		Result<List<InspectionRoute>> result=new Result<>();
		List<InspectionRoute> list=inspectionRouteService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检路径
	*/
	@ApiOperation(value = "分页查询巡检路径")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionRouteVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584743523325050880"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NAME , value = "路径" , required = false , dataTypeClass=String.class , example = "默认路线"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = InspectionRouteVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InspectionRouteServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionRouteServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionRoute>> queryPagedList(InspectionRouteVO sample) {
		Result<PagedList<InspectionRoute>> result=new Result<>();
		PagedList<InspectionRoute> list=inspectionRouteService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InspectionRouteServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionRouteServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InspectionRouteVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inspectionRouteService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InspectionRouteServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionRouteServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inspectionRouteService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InspectionRouteServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionRouteServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inspectionRouteService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}