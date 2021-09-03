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


import com.dt.platform.proxy.ops.WorkorderCategoryServiceProxy;
import com.dt.platform.domain.ops.meta.WorkorderCategoryVOMeta;
import com.dt.platform.domain.ops.WorkorderCategory;
import com.dt.platform.domain.ops.WorkorderCategoryVO;
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
import com.dt.platform.domain.ops.meta.WorkorderCategoryMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IWorkorderCategoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 工单类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-03 21:14:40
*/

@Api(tags = "工单类型")
@ApiSort(0)
@RestController("WorkorderCategoryController")
public class WorkorderCategoryController extends SuperController {

	@Autowired
	private IWorkorderCategoryService workorderCategoryService;

	
	/**
	 * 添加工单类型
	*/
	@ApiOperation(value = "添加工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = WorkorderCategoryVOMeta.ID)
	@SentinelResource(value = WorkorderCategoryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderCategoryServiceProxy.INSERT)
	public Result insert(WorkorderCategoryVO workorderCategoryVO) {
		Result result=workorderCategoryService.insert(workorderCategoryVO);
		return result;
	}

	
	/**
	 * 删除工单类型
	*/
	@ApiOperation(value = "删除工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = WorkorderCategoryVOMeta.ID)
	@SentinelResource(value = WorkorderCategoryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderCategoryServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=workorderCategoryService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除工单类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = WorkorderCategoryVOMeta.IDS)
	@SentinelResource(value = WorkorderCategoryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderCategoryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=workorderCategoryService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新工单类型
	*/
	@ApiOperation(value = "更新工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { WorkorderCategoryVOMeta.PAGE_INDEX , WorkorderCategoryVOMeta.PAGE_SIZE , WorkorderCategoryVOMeta.SEARCH_FIELD , WorkorderCategoryVOMeta.FUZZY_FIELD , WorkorderCategoryVOMeta.SEARCH_VALUE , WorkorderCategoryVOMeta.SORT_FIELD , WorkorderCategoryVOMeta.SORT_TYPE , WorkorderCategoryVOMeta.IDS } ) 
	@NotNull(name = WorkorderCategoryVOMeta.ID)
	@SentinelResource(value = WorkorderCategoryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderCategoryServiceProxy.UPDATE)
	public Result update(WorkorderCategoryVO workorderCategoryVO) {
		Result result=workorderCategoryService.update(workorderCategoryVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存工单类型
	*/
	@ApiOperation(value = "保存工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { WorkorderCategoryVOMeta.PAGE_INDEX , WorkorderCategoryVOMeta.PAGE_SIZE , WorkorderCategoryVOMeta.SEARCH_FIELD , WorkorderCategoryVOMeta.FUZZY_FIELD , WorkorderCategoryVOMeta.SEARCH_VALUE , WorkorderCategoryVOMeta.SORT_FIELD , WorkorderCategoryVOMeta.SORT_TYPE , WorkorderCategoryVOMeta.IDS } )
	@NotNull(name = WorkorderCategoryVOMeta.ID)
	@SentinelResource(value = WorkorderCategoryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderCategoryServiceProxy.SAVE)
	public Result save(WorkorderCategoryVO workorderCategoryVO) {
		Result result=workorderCategoryService.save(workorderCategoryVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取工单类型
	*/
	@ApiOperation(value = "获取工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = WorkorderCategoryVOMeta.ID)
	@SentinelResource(value = WorkorderCategoryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderCategoryServiceProxy.GET_BY_ID)
	public Result<WorkorderCategory> getById(String id) {
		Result<WorkorderCategory> result=new Result<>();
		WorkorderCategory workorderCategory=workorderCategoryService.getById(id);
		result.success(true).data(workorderCategory);
		return result;
	}


	/**
	 * 批量删除工单类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除工单类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = WorkorderCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = WorkorderCategoryVOMeta.IDS)
		@SentinelResource(value = WorkorderCategoryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderCategoryServiceProxy.GET_BY_IDS)
	public Result<List<WorkorderCategory>> getByIds(List<String> ids) {
		Result<List<WorkorderCategory>> result=new Result<>();
		List<WorkorderCategory> list=workorderCategoryService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询工单类型
	*/
	@ApiOperation(value = "查询工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { WorkorderCategoryVOMeta.PAGE_INDEX , WorkorderCategoryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = WorkorderCategoryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderCategoryServiceProxy.QUERY_LIST)
	public Result<List<WorkorderCategory>> queryList(WorkorderCategoryVO sample) {
		Result<List<WorkorderCategory>> result=new Result<>();
		List<WorkorderCategory> list=workorderCategoryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询工单类型
	*/
	@ApiOperation(value = "分页查询工单类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkorderCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = WorkorderCategoryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkorderCategoryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<WorkorderCategory>> queryPagedList(WorkorderCategoryVO sample) {
		Result<PagedList<WorkorderCategory>> result=new Result<>();
		PagedList<WorkorderCategory> list=workorderCategoryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = WorkorderCategoryServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(WorkorderCategoryServiceProxy.EXPORT_EXCEL)
	public void exportExcel(WorkorderCategoryVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=workorderCategoryService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = WorkorderCategoryServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(WorkorderCategoryServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=workorderCategoryService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = WorkorderCategoryServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(WorkorderCategoryServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=workorderCategoryService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}