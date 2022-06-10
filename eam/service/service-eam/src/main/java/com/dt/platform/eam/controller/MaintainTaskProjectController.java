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


import com.dt.platform.proxy.eam.MaintainTaskProjectServiceProxy;
import com.dt.platform.domain.eam.meta.MaintainTaskProjectVOMeta;
import com.dt.platform.domain.eam.MaintainTaskProject;
import com.dt.platform.domain.eam.MaintainTaskProjectVO;
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
import com.dt.platform.domain.eam.meta.MaintainTaskProjectMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.meta.MaintainProjectMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IMaintainTaskProjectService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 保养项目 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-09 12:22:23
*/

@Api(tags = "保养项目")
@ApiSort(0)
@RestController("EamMaintainTaskProjectController")
public class MaintainTaskProjectController extends SuperController {

	@Autowired
	private IMaintainTaskProjectService maintainTaskProjectService;


	/**
	 * 添加保养项目
	*/
	@ApiOperation(value = "添加保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "586905635430334464"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_CODE , value = "项目编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NAME , value = "项目名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NOTES , value = "项目备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class , example = "2022-06-01 12:00:00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class , example = "2022-06-24 12:00:00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MaintainTaskProjectServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.INSERT)
	public Result insert(MaintainTaskProjectVO maintainTaskProjectVO) {
		Result result=maintainTaskProjectService.insert(maintainTaskProjectVO,false);
		return result;
	}



	/**
	 * 删除保养项目
	*/
	@ApiOperation(value = "删除保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "586905635430334464")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MaintainTaskProjectVOMeta.ID)
	@SentinelResource(value = MaintainTaskProjectServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=maintainTaskProjectService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除保养项目 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MaintainTaskProjectVOMeta.IDS)
	@SentinelResource(value = MaintainTaskProjectServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=maintainTaskProjectService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新保养项目
	*/
	@ApiOperation(value = "更新保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "586905635430334464"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_CODE , value = "项目编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NAME , value = "项目名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NOTES , value = "项目备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class , example = "2022-06-01 12:00:00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class , example = "2022-06-24 12:00:00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MaintainTaskProjectVOMeta.PAGE_INDEX , MaintainTaskProjectVOMeta.PAGE_SIZE , MaintainTaskProjectVOMeta.SEARCH_FIELD , MaintainTaskProjectVOMeta.FUZZY_FIELD , MaintainTaskProjectVOMeta.SEARCH_VALUE , MaintainTaskProjectVOMeta.DIRTY_FIELDS , MaintainTaskProjectVOMeta.SORT_FIELD , MaintainTaskProjectVOMeta.SORT_TYPE , MaintainTaskProjectVOMeta.IDS } )
	@NotNull(name = MaintainTaskProjectVOMeta.ID)
	@SentinelResource(value = MaintainTaskProjectServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.UPDATE)
	public Result update(MaintainTaskProjectVO maintainTaskProjectVO) {
		Result result=maintainTaskProjectService.update(maintainTaskProjectVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存保养项目
	*/
	@ApiOperation(value = "保存保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "586905635430334464"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_CODE , value = "项目编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NAME , value = "项目名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NOTES , value = "项目备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class , example = "2022-06-01 12:00:00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class , example = "2022-06-24 12:00:00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainTaskProjectVOMeta.PAGE_INDEX , MaintainTaskProjectVOMeta.PAGE_SIZE , MaintainTaskProjectVOMeta.SEARCH_FIELD , MaintainTaskProjectVOMeta.FUZZY_FIELD , MaintainTaskProjectVOMeta.SEARCH_VALUE , MaintainTaskProjectVOMeta.DIRTY_FIELDS , MaintainTaskProjectVOMeta.SORT_FIELD , MaintainTaskProjectVOMeta.SORT_TYPE , MaintainTaskProjectVOMeta.IDS } )
	@NotNull(name = MaintainTaskProjectVOMeta.ID)
	@SentinelResource(value = MaintainTaskProjectServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.SAVE)
	public Result save(MaintainTaskProjectVO maintainTaskProjectVO) {
		Result result=maintainTaskProjectService.save(maintainTaskProjectVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取保养项目
	*/
	@ApiOperation(value = "获取保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MaintainTaskProjectVOMeta.ID)
	@SentinelResource(value = MaintainTaskProjectServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.GET_BY_ID)
	public Result<MaintainTaskProject> getById(String id) {
		Result<MaintainTaskProject> result=new Result<>();
		MaintainTaskProject maintainTaskProject=maintainTaskProjectService.getById(id);
		// join 关联的对象
		maintainTaskProjectService.dao().fill(maintainTaskProject)
			.with(MaintainProjectMeta.MAINTAIN_TYPE_DICT)
			.execute();
		result.success(true).data(maintainTaskProject);
		return result;
	}


	/**
	 * 批量获取保养项目 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取保养项目")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MaintainTaskProjectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MaintainTaskProjectVOMeta.IDS)
		@SentinelResource(value = MaintainTaskProjectServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.GET_BY_IDS)
	public Result<List<MaintainTaskProject>> getByIds(List<String> ids) {
		Result<List<MaintainTaskProject>> result=new Result<>();
		List<MaintainTaskProject> list=maintainTaskProjectService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询保养项目
	*/
	@ApiOperation(value = "查询保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "586905635430334464"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_CODE , value = "项目编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NAME , value = "项目名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NOTES , value = "项目备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class , example = "2022-06-01 12:00:00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class , example = "2022-06-24 12:00:00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainTaskProjectVOMeta.PAGE_INDEX , MaintainTaskProjectVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaintainTaskProjectServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.QUERY_LIST)
	public Result<List<MaintainTaskProject>> queryList(MaintainTaskProjectVO sample) {
		Result<List<MaintainTaskProject>> result=new Result<>();
		List<MaintainTaskProject> list=maintainTaskProjectService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询保养项目
	*/
	@ApiOperation(value = "分页查询保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "586905635430334464"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_CODE , value = "项目编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NAME , value = "项目名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NOTES , value = "项目备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class , example = "2022-06-01 12:00:00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class , example = "2022-06-24 12:00:00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MaintainTaskProjectServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MaintainTaskProject>> queryPagedList(MaintainTaskProjectVO sample) {
		Result<PagedList<MaintainTaskProject>> result=new Result<>();
		PagedList<MaintainTaskProject> list=maintainTaskProjectService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		maintainTaskProjectService.dao().fill(list)
			.with(MaintainProjectMeta.MAINTAIN_TYPE_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MaintainTaskProjectServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainTaskProjectServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MaintainTaskProjectVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=maintainTaskProjectService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MaintainTaskProjectServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainTaskProjectServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=maintainTaskProjectService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MaintainTaskProjectServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainTaskProjectServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=maintainTaskProjectService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}