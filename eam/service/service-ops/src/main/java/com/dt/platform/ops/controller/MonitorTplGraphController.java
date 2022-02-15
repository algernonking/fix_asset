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


import com.dt.platform.proxy.ops.MonitorTplGraphServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorTplGraphVOMeta;
import com.dt.platform.domain.ops.MonitorTplGraph;
import com.dt.platform.domain.ops.MonitorTplGraphVO;
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
import com.dt.platform.domain.ops.meta.MonitorTplGraphMeta;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplGraphItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorTplGraphService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 模版图形 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-13 20:48:53
*/

@Api(tags = "模版图形")
@ApiSort(0)
@RestController("OpsMonitorTplGraphController")
public class MonitorTplGraphController extends SuperController {

	@Autowired
	private IMonitorTplGraphService monitorTplGraphService;


	/**
	 * 添加模版图形
	*/
	@ApiOperation(value = "添加模版图形")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "CPU"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.TPL_CODE , value = "模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_WIDTH , value = "宽度" , required = false , dataTypeClass=Integer.class , example = "900"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_HEIGHT , value = "高度" , required = false , dataTypeClass=Integer.class , example = "200"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_TYPE , value = "图形类别" , required = false , dataTypeClass=String.class , example = "line"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.CONTENT , value = "图形设置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.DS , value = "数据来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "800"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorTplGraphServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphServiceProxy.INSERT)
	public Result insert(MonitorTplGraphVO monitorTplGraphVO) {
		Result result=monitorTplGraphService.insert(monitorTplGraphVO,false);
		return result;
	}



	/**
	 * 删除模版图形
	*/
	@ApiOperation(value = "删除模版图形")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorTplGraphVOMeta.ID)
	@SentinelResource(value = MonitorTplGraphServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorTplGraphService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除模版图形 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除模版图形")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorTplGraphVOMeta.IDS)
	@SentinelResource(value = MonitorTplGraphServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorTplGraphService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新模版图形
	*/
	@ApiOperation(value = "更新模版图形")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "CPU"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.TPL_CODE , value = "模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_WIDTH , value = "宽度" , required = false , dataTypeClass=Integer.class , example = "900"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_HEIGHT , value = "高度" , required = false , dataTypeClass=Integer.class , example = "200"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_TYPE , value = "图形类别" , required = false , dataTypeClass=String.class , example = "line"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.CONTENT , value = "图形设置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.DS , value = "数据来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "800"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorTplGraphVOMeta.PAGE_INDEX , MonitorTplGraphVOMeta.PAGE_SIZE , MonitorTplGraphVOMeta.SEARCH_FIELD , MonitorTplGraphVOMeta.FUZZY_FIELD , MonitorTplGraphVOMeta.SEARCH_VALUE , MonitorTplGraphVOMeta.DIRTY_FIELDS , MonitorTplGraphVOMeta.SORT_FIELD , MonitorTplGraphVOMeta.SORT_TYPE , MonitorTplGraphVOMeta.IDS } )
	@NotNull(name = MonitorTplGraphVOMeta.ID)
	@SentinelResource(value = MonitorTplGraphServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphServiceProxy.UPDATE)
	public Result update(MonitorTplGraphVO monitorTplGraphVO) {
		Result result=monitorTplGraphService.update(monitorTplGraphVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存模版图形
	*/
	@ApiOperation(value = "保存模版图形")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "CPU"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.TPL_CODE , value = "模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_WIDTH , value = "宽度" , required = false , dataTypeClass=Integer.class , example = "900"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_HEIGHT , value = "高度" , required = false , dataTypeClass=Integer.class , example = "200"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_TYPE , value = "图形类别" , required = false , dataTypeClass=String.class , example = "line"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.CONTENT , value = "图形设置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.DS , value = "数据来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "800"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorTplGraphVOMeta.PAGE_INDEX , MonitorTplGraphVOMeta.PAGE_SIZE , MonitorTplGraphVOMeta.SEARCH_FIELD , MonitorTplGraphVOMeta.FUZZY_FIELD , MonitorTplGraphVOMeta.SEARCH_VALUE , MonitorTplGraphVOMeta.DIRTY_FIELDS , MonitorTplGraphVOMeta.SORT_FIELD , MonitorTplGraphVOMeta.SORT_TYPE , MonitorTplGraphVOMeta.IDS } )
	@NotNull(name = MonitorTplGraphVOMeta.ID)
	@SentinelResource(value = MonitorTplGraphServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphServiceProxy.SAVE)
	public Result save(MonitorTplGraphVO monitorTplGraphVO) {
		Result result=monitorTplGraphService.save(monitorTplGraphVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取模版图形
	*/
	@ApiOperation(value = "获取模版图形")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorTplGraphVOMeta.ID)
	@SentinelResource(value = MonitorTplGraphServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphServiceProxy.GET_BY_ID)
	public Result<MonitorTplGraph> getById(String id) {
		Result<MonitorTplGraph> result=new Result<>();
		MonitorTplGraph monitorTplGraph=monitorTplGraphService.getById(id);
		// join 关联的对象
		monitorTplGraphService.dao().fill(monitorTplGraph)
			.with(MonitorTplGraphMeta.TPL)
			.execute();
		result.success(true).data(monitorTplGraph);
		return result;
	}


	/**
	 * 批量获取模版图形 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取模版图形")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorTplGraphVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorTplGraphVOMeta.IDS)
		@SentinelResource(value = MonitorTplGraphServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphServiceProxy.GET_BY_IDS)
	public Result<List<MonitorTplGraph>> getByIds(List<String> ids) {
		Result<List<MonitorTplGraph>> result=new Result<>();
		List<MonitorTplGraph> list=monitorTplGraphService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询模版图形
	*/
	@ApiOperation(value = "查询模版图形")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "CPU"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.TPL_CODE , value = "模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_WIDTH , value = "宽度" , required = false , dataTypeClass=Integer.class , example = "900"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_HEIGHT , value = "高度" , required = false , dataTypeClass=Integer.class , example = "200"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_TYPE , value = "图形类别" , required = false , dataTypeClass=String.class , example = "line"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.CONTENT , value = "图形设置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.DS , value = "数据来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "800"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorTplGraphVOMeta.PAGE_INDEX , MonitorTplGraphVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorTplGraphServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphServiceProxy.QUERY_LIST)
	public Result<List<MonitorTplGraph>> queryList(MonitorTplGraphVO sample) {
		Result<List<MonitorTplGraph>> result=new Result<>();
		List<MonitorTplGraph> list=monitorTplGraphService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询模版图形
	*/
	@ApiOperation(value = "分页查询模版图形")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "CPU"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.TPL_CODE , value = "模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_WIDTH , value = "宽度" , required = false , dataTypeClass=Integer.class , example = "900"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_HEIGHT , value = "高度" , required = false , dataTypeClass=Integer.class , example = "200"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_TYPE , value = "图形类别" , required = false , dataTypeClass=String.class , example = "line"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.CONTENT , value = "图形设置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.DS , value = "数据来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "800"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorTplGraphServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplGraphServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorTplGraph>> queryPagedList(MonitorTplGraphVO sample) {
		Result<PagedList<MonitorTplGraph>> result=new Result<>();
		PagedList<MonitorTplGraph> list=monitorTplGraphService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		monitorTplGraphService.dao().fill(list)
			.with(MonitorTplGraphMeta.TPL)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorTplGraphServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplGraphServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorTplGraphVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorTplGraphService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorTplGraphServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplGraphServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorTplGraphService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorTplGraphServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplGraphServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorTplGraphService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}