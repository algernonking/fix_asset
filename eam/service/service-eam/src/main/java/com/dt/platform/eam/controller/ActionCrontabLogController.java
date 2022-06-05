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


import com.dt.platform.proxy.eam.ActionCrontabLogServiceProxy;
import com.dt.platform.domain.eam.meta.ActionCrontabLogVOMeta;
import com.dt.platform.domain.eam.ActionCrontabLog;
import com.dt.platform.domain.eam.ActionCrontabLogVO;
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
import com.dt.platform.domain.eam.meta.ActionCrontabLogMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IActionCrontabLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 日志 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-03 20:31:05
*/

@Api(tags = "日志")
@ApiSort(0)
@RestController("EamActionCrontabLogController")
public class ActionCrontabLogController extends SuperController {

	@Autowired
	private IActionCrontabLogService actionCrontabLogService;


	/**
	 * 添加日志
	*/
	@ApiOperation(value = "添加日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.CRONTAB_ID , value = "crontab" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.EXECUTION_RESULT , value = "执行结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ActionCrontabLogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ActionCrontabLogServiceProxy.INSERT)
	public Result insert(ActionCrontabLogVO actionCrontabLogVO) {
		Result result=actionCrontabLogService.insert(actionCrontabLogVO,false);
		return result;
	}



	/**
	 * 删除日志
	*/
	@ApiOperation(value = "删除日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ActionCrontabLogVOMeta.ID)
	@SentinelResource(value = ActionCrontabLogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ActionCrontabLogServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=actionCrontabLogService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ActionCrontabLogVOMeta.IDS)
	@SentinelResource(value = ActionCrontabLogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ActionCrontabLogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=actionCrontabLogService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新日志
	*/
	@ApiOperation(value = "更新日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.CRONTAB_ID , value = "crontab" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.EXECUTION_RESULT , value = "执行结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ActionCrontabLogVOMeta.PAGE_INDEX , ActionCrontabLogVOMeta.PAGE_SIZE , ActionCrontabLogVOMeta.SEARCH_FIELD , ActionCrontabLogVOMeta.FUZZY_FIELD , ActionCrontabLogVOMeta.SEARCH_VALUE , ActionCrontabLogVOMeta.DIRTY_FIELDS , ActionCrontabLogVOMeta.SORT_FIELD , ActionCrontabLogVOMeta.SORT_TYPE , ActionCrontabLogVOMeta.IDS } )
	@NotNull(name = ActionCrontabLogVOMeta.ID)
	@SentinelResource(value = ActionCrontabLogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ActionCrontabLogServiceProxy.UPDATE)
	public Result update(ActionCrontabLogVO actionCrontabLogVO) {
		Result result=actionCrontabLogService.update(actionCrontabLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存日志
	*/
	@ApiOperation(value = "保存日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.CRONTAB_ID , value = "crontab" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.EXECUTION_RESULT , value = "执行结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ActionCrontabLogVOMeta.PAGE_INDEX , ActionCrontabLogVOMeta.PAGE_SIZE , ActionCrontabLogVOMeta.SEARCH_FIELD , ActionCrontabLogVOMeta.FUZZY_FIELD , ActionCrontabLogVOMeta.SEARCH_VALUE , ActionCrontabLogVOMeta.DIRTY_FIELDS , ActionCrontabLogVOMeta.SORT_FIELD , ActionCrontabLogVOMeta.SORT_TYPE , ActionCrontabLogVOMeta.IDS } )
	@NotNull(name = ActionCrontabLogVOMeta.ID)
	@SentinelResource(value = ActionCrontabLogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ActionCrontabLogServiceProxy.SAVE)
	public Result save(ActionCrontabLogVO actionCrontabLogVO) {
		Result result=actionCrontabLogService.save(actionCrontabLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取日志
	*/
	@ApiOperation(value = "获取日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ActionCrontabLogVOMeta.ID)
	@SentinelResource(value = ActionCrontabLogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ActionCrontabLogServiceProxy.GET_BY_ID)
	public Result<ActionCrontabLog> getById(String id) {
		Result<ActionCrontabLog> result=new Result<>();
		ActionCrontabLog actionCrontabLog=actionCrontabLogService.getById(id);
		result.success(true).data(actionCrontabLog);
		return result;
	}


	/**
	 * 批量获取日志 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取日志")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ActionCrontabLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ActionCrontabLogVOMeta.IDS)
		@SentinelResource(value = ActionCrontabLogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ActionCrontabLogServiceProxy.GET_BY_IDS)
	public Result<List<ActionCrontabLog>> getByIds(List<String> ids) {
		Result<List<ActionCrontabLog>> result=new Result<>();
		List<ActionCrontabLog> list=actionCrontabLogService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询日志
	*/
	@ApiOperation(value = "查询日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.CRONTAB_ID , value = "crontab" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.EXECUTION_RESULT , value = "执行结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ActionCrontabLogVOMeta.PAGE_INDEX , ActionCrontabLogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ActionCrontabLogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ActionCrontabLogServiceProxy.QUERY_LIST)
	public Result<List<ActionCrontabLog>> queryList(ActionCrontabLogVO sample) {
		Result<List<ActionCrontabLog>> result=new Result<>();
		List<ActionCrontabLog> list=actionCrontabLogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询日志
	*/
	@ApiOperation(value = "分页查询日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.CRONTAB_ID , value = "crontab" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.EXECUTION_RESULT , value = "执行结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ActionCrontabLogVOMeta.RECORD_TIME , value = "记录时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ActionCrontabLogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ActionCrontabLogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ActionCrontabLog>> queryPagedList(ActionCrontabLogVO sample) {
		Result<PagedList<ActionCrontabLog>> result=new Result<>();
		PagedList<ActionCrontabLog> list=actionCrontabLogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ActionCrontabLogServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ActionCrontabLogServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ActionCrontabLogVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=actionCrontabLogService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ActionCrontabLogServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ActionCrontabLogServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=actionCrontabLogService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = ActionCrontabLogServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ActionCrontabLogServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=actionCrontabLogService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}