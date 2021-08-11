package com.dt.platform.ops.controller;

 
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


import com.dt.platform.proxy.ops.WorkorderTypeServiceProxy;
import com.dt.platform.domain.ops.meta.WorkorderTypeVOMeta;
import com.dt.platform.domain.ops.WorkorderType;
import com.dt.platform.domain.ops.WorkorderTypeVO;
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
import com.dt.platform.domain.ops.meta.WorkorderTypeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IWorkorderTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 工单类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-11 21:30:42
*/

@Api(tags = "工单类型")
@ApiSort(0)
@RestController("WorkorderTypeController")
public class WorkorderTypeController extends SuperController {

	@Autowired
	private IWorkorderTypeService workorderTypeService;

	
	/**
	 * 添加工单类型
	*/
	@ApiOperation(value = "添加工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = WorkorderTypeVOMeta.ID)
	@SentinelResource(value = WorkorderTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderTypeServiceProxy.INSERT)
	public Result insert(WorkorderTypeVO workorderTypeVO) {
		Result result=workorderTypeService.insert(workorderTypeVO);
		return result;
	}

	
	/**
	 * 删除工单类型
	*/
	@ApiOperation(value = "删除工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = WorkorderTypeVOMeta.ID)
	@SentinelResource(value = WorkorderTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=workorderTypeService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除工单类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = WorkorderTypeVOMeta.IDS)
	@SentinelResource(value = WorkorderTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=workorderTypeService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新工单类型
	*/
	@ApiOperation(value = "更新工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { WorkorderTypeVOMeta.PAGE_INDEX , WorkorderTypeVOMeta.PAGE_SIZE , WorkorderTypeVOMeta.SEARCH_FIELD , WorkorderTypeVOMeta.FUZZY_FIELD , WorkorderTypeVOMeta.SEARCH_VALUE , WorkorderTypeVOMeta.SORT_FIELD , WorkorderTypeVOMeta.SORT_TYPE , WorkorderTypeVOMeta.IDS } ) 
	@NotNull(name = WorkorderTypeVOMeta.ID)
	@SentinelResource(value = WorkorderTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderTypeServiceProxy.UPDATE)
	public Result update(WorkorderTypeVO workorderTypeVO) {
		Result result=workorderTypeService.update(workorderTypeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存工单类型
	*/
	@ApiOperation(value = "保存工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { WorkorderTypeVOMeta.PAGE_INDEX , WorkorderTypeVOMeta.PAGE_SIZE , WorkorderTypeVOMeta.SEARCH_FIELD , WorkorderTypeVOMeta.FUZZY_FIELD , WorkorderTypeVOMeta.SEARCH_VALUE , WorkorderTypeVOMeta.SORT_FIELD , WorkorderTypeVOMeta.SORT_TYPE , WorkorderTypeVOMeta.IDS } )
	@NotNull(name = WorkorderTypeVOMeta.ID)
	@SentinelResource(value = WorkorderTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderTypeServiceProxy.SAVE)
	public Result save(WorkorderTypeVO workorderTypeVO) {
		Result result=workorderTypeService.save(workorderTypeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取工单类型
	*/
	@ApiOperation(value = "获取工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = WorkorderTypeVOMeta.ID)
	@SentinelResource(value = WorkorderTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderTypeServiceProxy.GET_BY_ID)
	public Result<WorkorderType> getById(String id) {
		Result<WorkorderType> result=new Result<>();
		WorkorderType workorderType=workorderTypeService.getById(id);
		result.success(true).data(workorderType);
		return result;
	}


	/**
	 * 批量删除工单类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除工单类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = WorkorderTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = WorkorderTypeVOMeta.IDS)
		@SentinelResource(value = WorkorderTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderTypeServiceProxy.GET_BY_IDS)
	public Result<List<WorkorderType>> getByIds(List<String> ids) {
		Result<List<WorkorderType>> result=new Result<>();
		List<WorkorderType> list=workorderTypeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询工单类型
	*/
	@ApiOperation(value = "查询工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { WorkorderTypeVOMeta.PAGE_INDEX , WorkorderTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = WorkorderTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderTypeServiceProxy.QUERY_LIST)
	public Result<List<WorkorderType>> queryList(WorkorderTypeVO sample) {
		Result<List<WorkorderType>> result=new Result<>();
		List<WorkorderType> list=workorderTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询工单类型
	*/
	@ApiOperation(value = "分页查询工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderTypeVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = WorkorderTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<WorkorderType>> queryPagedList(WorkorderTypeVO sample) {
		Result<PagedList<WorkorderType>> result=new Result<>();
		PagedList<WorkorderType> list=workorderTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = WorkorderTypeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(WorkorderTypeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(WorkorderTypeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=workorderTypeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = WorkorderTypeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(WorkorderTypeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=workorderTypeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = WorkorderTypeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(WorkorderTypeServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=workorderTypeService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}