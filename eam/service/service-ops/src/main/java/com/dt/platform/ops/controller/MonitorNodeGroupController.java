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


import com.dt.platform.proxy.ops.MonitorNodeGroupServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeGroupVOMeta;
import com.dt.platform.domain.ops.MonitorNodeGroup;
import com.dt.platform.domain.ops.MonitorNodeGroupVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeGroupMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeGroupService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点分组 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:15:00
*/

@Api(tags = "节点分组")
@ApiSort(0)
@RestController("OpsMonitorNodeGroupController")
public class MonitorNodeGroupController extends SuperController {

	@Autowired
	private IMonitorNodeGroupService monitorNodeGroupService;


	/**
	 * 添加节点分组
	*/
	@ApiOperation(value = "添加节点分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "543027008297238528"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux分组"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "Linux分组"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorNodeGroupServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeGroupServiceProxy.INSERT)
	public Result insert(MonitorNodeGroupVO monitorNodeGroupVO) {
		Result result=monitorNodeGroupService.insert(monitorNodeGroupVO,false);
		return result;
	}



	/**
	 * 删除节点分组
	*/
	@ApiOperation(value = "删除节点分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "543027008297238528")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorNodeGroupVOMeta.ID)
	@SentinelResource(value = MonitorNodeGroupServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeGroupServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorNodeGroupService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除节点分组 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除节点分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorNodeGroupVOMeta.IDS)
	@SentinelResource(value = MonitorNodeGroupServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeGroupServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorNodeGroupService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新节点分组
	*/
	@ApiOperation(value = "更新节点分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "543027008297238528"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux分组"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "Linux分组"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorNodeGroupVOMeta.PAGE_INDEX , MonitorNodeGroupVOMeta.PAGE_SIZE , MonitorNodeGroupVOMeta.SEARCH_FIELD , MonitorNodeGroupVOMeta.FUZZY_FIELD , MonitorNodeGroupVOMeta.SEARCH_VALUE , MonitorNodeGroupVOMeta.DIRTY_FIELDS , MonitorNodeGroupVOMeta.SORT_FIELD , MonitorNodeGroupVOMeta.SORT_TYPE , MonitorNodeGroupVOMeta.IDS } )
	@NotNull(name = MonitorNodeGroupVOMeta.ID)
	@SentinelResource(value = MonitorNodeGroupServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeGroupServiceProxy.UPDATE)
	public Result update(MonitorNodeGroupVO monitorNodeGroupVO) {
		Result result=monitorNodeGroupService.update(monitorNodeGroupVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存节点分组
	*/
	@ApiOperation(value = "保存节点分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "543027008297238528"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux分组"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "Linux分组"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeGroupVOMeta.PAGE_INDEX , MonitorNodeGroupVOMeta.PAGE_SIZE , MonitorNodeGroupVOMeta.SEARCH_FIELD , MonitorNodeGroupVOMeta.FUZZY_FIELD , MonitorNodeGroupVOMeta.SEARCH_VALUE , MonitorNodeGroupVOMeta.DIRTY_FIELDS , MonitorNodeGroupVOMeta.SORT_FIELD , MonitorNodeGroupVOMeta.SORT_TYPE , MonitorNodeGroupVOMeta.IDS } )
	@NotNull(name = MonitorNodeGroupVOMeta.ID)
	@SentinelResource(value = MonitorNodeGroupServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeGroupServiceProxy.SAVE)
	public Result save(MonitorNodeGroupVO monitorNodeGroupVO) {
		Result result=monitorNodeGroupService.save(monitorNodeGroupVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取节点分组
	*/
	@ApiOperation(value = "获取节点分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorNodeGroupVOMeta.ID)
	@SentinelResource(value = MonitorNodeGroupServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeGroupServiceProxy.GET_BY_ID)
	public Result<MonitorNodeGroup> getById(String id) {
		Result<MonitorNodeGroup> result=new Result<>();
		MonitorNodeGroup monitorNodeGroup=monitorNodeGroupService.getById(id);
		result.success(true).data(monitorNodeGroup);
		return result;
	}


	/**
	 * 批量获取节点分组 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取节点分组")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorNodeGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorNodeGroupVOMeta.IDS)
		@SentinelResource(value = MonitorNodeGroupServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeGroupServiceProxy.GET_BY_IDS)
	public Result<List<MonitorNodeGroup>> getByIds(List<String> ids) {
		Result<List<MonitorNodeGroup>> result=new Result<>();
		List<MonitorNodeGroup> list=monitorNodeGroupService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询节点分组
	*/
	@ApiOperation(value = "查询节点分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "543027008297238528"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux分组"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "Linux分组"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeGroupVOMeta.PAGE_INDEX , MonitorNodeGroupVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorNodeGroupServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeGroupServiceProxy.QUERY_LIST)
	public Result<List<MonitorNodeGroup>> queryList(MonitorNodeGroupVO sample) {
		Result<List<MonitorNodeGroup>> result=new Result<>();
		List<MonitorNodeGroup> list=monitorNodeGroupService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询节点分组
	*/
	@ApiOperation(value = "分页查询节点分组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "543027008297238528"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux分组"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "Linux分组"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorNodeGroupServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeGroupServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorNodeGroup>> queryPagedList(MonitorNodeGroupVO sample) {
		Result<PagedList<MonitorNodeGroup>> result=new Result<>();
		PagedList<MonitorNodeGroup> list=monitorNodeGroupService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorNodeGroupServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeGroupServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorNodeGroupVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorNodeGroupService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorNodeGroupServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeGroupServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorNodeGroupService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorNodeGroupServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeGroupServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorNodeGroupService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}