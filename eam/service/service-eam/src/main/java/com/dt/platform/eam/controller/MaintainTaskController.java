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


import com.dt.platform.proxy.eam.MaintainTaskServiceProxy;
import com.dt.platform.domain.eam.meta.MaintainTaskVOMeta;
import com.dt.platform.domain.eam.MaintainTask;
import com.dt.platform.domain.eam.MaintainTaskVO;
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
import com.dt.platform.domain.eam.meta.MaintainTaskMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IMaintainTaskService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 保养任务 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 20:23:22
*/

@Api(tags = "保养任务")
@ApiSort(0)
@RestController("EamMaintainTaskController")
public class MaintainTaskController extends SuperController {

	@Autowired
	private IMaintainTaskService maintainTaskService;


	/**
	 * 添加保养任务
	*/
	@ApiOperation(value = "添加保养任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MaintainTaskServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskServiceProxy.INSERT)
	public Result insert(MaintainTaskVO maintainTaskVO) {
		Result result=maintainTaskService.insert(maintainTaskVO,false);
		return result;
	}



	/**
	 * 删除保养任务
	*/
	@ApiOperation(value = "删除保养任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MaintainTaskVOMeta.ID)
	@SentinelResource(value = MaintainTaskServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=maintainTaskService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除保养任务 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除保养任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MaintainTaskVOMeta.IDS)
	@SentinelResource(value = MaintainTaskServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=maintainTaskService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新保养任务
	*/
	@ApiOperation(value = "更新保养任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MaintainTaskVOMeta.PAGE_INDEX , MaintainTaskVOMeta.PAGE_SIZE , MaintainTaskVOMeta.SEARCH_FIELD , MaintainTaskVOMeta.FUZZY_FIELD , MaintainTaskVOMeta.SEARCH_VALUE , MaintainTaskVOMeta.DIRTY_FIELDS , MaintainTaskVOMeta.SORT_FIELD , MaintainTaskVOMeta.SORT_TYPE , MaintainTaskVOMeta.IDS } )
	@NotNull(name = MaintainTaskVOMeta.ID)
	@SentinelResource(value = MaintainTaskServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskServiceProxy.UPDATE)
	public Result update(MaintainTaskVO maintainTaskVO) {
		Result result=maintainTaskService.update(maintainTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存保养任务
	*/
	@ApiOperation(value = "保存保养任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainTaskVOMeta.PAGE_INDEX , MaintainTaskVOMeta.PAGE_SIZE , MaintainTaskVOMeta.SEARCH_FIELD , MaintainTaskVOMeta.FUZZY_FIELD , MaintainTaskVOMeta.SEARCH_VALUE , MaintainTaskVOMeta.DIRTY_FIELDS , MaintainTaskVOMeta.SORT_FIELD , MaintainTaskVOMeta.SORT_TYPE , MaintainTaskVOMeta.IDS } )
	@NotNull(name = MaintainTaskVOMeta.ID)
	@SentinelResource(value = MaintainTaskServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskServiceProxy.SAVE)
	public Result save(MaintainTaskVO maintainTaskVO) {
		Result result=maintainTaskService.save(maintainTaskVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取保养任务
	*/
	@ApiOperation(value = "获取保养任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MaintainTaskVOMeta.ID)
	@SentinelResource(value = MaintainTaskServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskServiceProxy.GET_BY_ID)
	public Result<MaintainTask> getById(String id) {
		Result<MaintainTask> result=new Result<>();
		MaintainTask maintainTask=maintainTaskService.getById(id);
		result.success(true).data(maintainTask);
		return result;
	}


	/**
	 * 批量获取保养任务 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取保养任务")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MaintainTaskVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MaintainTaskVOMeta.IDS)
		@SentinelResource(value = MaintainTaskServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskServiceProxy.GET_BY_IDS)
	public Result<List<MaintainTask>> getByIds(List<String> ids) {
		Result<List<MaintainTask>> result=new Result<>();
		List<MaintainTask> list=maintainTaskService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询保养任务
	*/
	@ApiOperation(value = "查询保养任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainTaskVOMeta.PAGE_INDEX , MaintainTaskVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaintainTaskServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskServiceProxy.QUERY_LIST)
	public Result<List<MaintainTask>> queryList(MaintainTaskVO sample) {
		Result<List<MaintainTask>> result=new Result<>();
		List<MaintainTask> list=maintainTaskService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询保养任务
	*/
	@ApiOperation(value = "分页查询保养任务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MaintainTaskServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MaintainTask>> queryPagedList(MaintainTaskVO sample) {
		Result<PagedList<MaintainTask>> result=new Result<>();
		PagedList<MaintainTask> list=maintainTaskService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MaintainTaskServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainTaskServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MaintainTaskVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=maintainTaskService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MaintainTaskServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainTaskServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=maintainTaskService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MaintainTaskServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainTaskServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=maintainTaskService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}