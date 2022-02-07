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


import com.dt.platform.proxy.ops.MonitorTplServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorTplVOMeta;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplVO;
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
import com.dt.platform.domain.ops.meta.MonitorTplMeta;
import com.dt.platform.domain.ops.MonitorTplType;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorTplService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 监控模版 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-07 13:14:35
*/

@Api(tags = "监控模版")
@ApiSort(0)
@RestController("OpsMonitorTplController")
public class MonitorTplController extends SuperController {

	@Autowired
	private IMonitorTplService monitorTplService;


	/**
	 * 添加监控模版
	*/
	@ApiOperation(value = "添加监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux监控模版"),
		@ApiImplicitParam(name = MonitorTplVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "tpl_host_linux"),
		@ApiImplicitParam(name = MonitorTplVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "Linux主机监控模版"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorTplServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplServiceProxy.INSERT)
	public Result insert(MonitorTplVO monitorTplVO) {
		Result result=monitorTplService.insert(monitorTplVO,false);
		return result;
	}



	/**
	 * 删除监控模版
	*/
	@ApiOperation(value = "删除监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorTplVOMeta.ID)
	@SentinelResource(value = MonitorTplServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorTplService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除监控模版 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorTplVOMeta.IDS)
	@SentinelResource(value = MonitorTplServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorTplService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新监控模版
	*/
	@ApiOperation(value = "更新监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux监控模版"),
		@ApiImplicitParam(name = MonitorTplVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "tpl_host_linux"),
		@ApiImplicitParam(name = MonitorTplVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "Linux主机监控模版"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorTplVOMeta.PAGE_INDEX , MonitorTplVOMeta.PAGE_SIZE , MonitorTplVOMeta.SEARCH_FIELD , MonitorTplVOMeta.FUZZY_FIELD , MonitorTplVOMeta.SEARCH_VALUE , MonitorTplVOMeta.DIRTY_FIELDS , MonitorTplVOMeta.SORT_FIELD , MonitorTplVOMeta.SORT_TYPE , MonitorTplVOMeta.IDS } )
	@NotNull(name = MonitorTplVOMeta.ID)
	@SentinelResource(value = MonitorTplServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplServiceProxy.UPDATE)
	public Result update(MonitorTplVO monitorTplVO) {
		Result result=monitorTplService.update(monitorTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存监控模版
	*/
	@ApiOperation(value = "保存监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux监控模版"),
		@ApiImplicitParam(name = MonitorTplVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "tpl_host_linux"),
		@ApiImplicitParam(name = MonitorTplVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "Linux主机监控模版"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorTplVOMeta.PAGE_INDEX , MonitorTplVOMeta.PAGE_SIZE , MonitorTplVOMeta.SEARCH_FIELD , MonitorTplVOMeta.FUZZY_FIELD , MonitorTplVOMeta.SEARCH_VALUE , MonitorTplVOMeta.DIRTY_FIELDS , MonitorTplVOMeta.SORT_FIELD , MonitorTplVOMeta.SORT_TYPE , MonitorTplVOMeta.IDS } )
	@NotNull(name = MonitorTplVOMeta.ID)
	@SentinelResource(value = MonitorTplServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplServiceProxy.SAVE)
	public Result save(MonitorTplVO monitorTplVO) {
		Result result=monitorTplService.save(monitorTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取监控模版
	*/
	@ApiOperation(value = "获取监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorTplVOMeta.ID)
	@SentinelResource(value = MonitorTplServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplServiceProxy.GET_BY_ID)
	public Result<MonitorTpl> getById(String id) {
		Result<MonitorTpl> result=new Result<>();
		MonitorTpl monitorTpl=monitorTplService.getById(id);
		// join 关联的对象
		monitorTplService.dao().fill(monitorTpl)
			.with(MonitorTplMeta.TPL_TYPE)
			.execute();
		result.success(true).data(monitorTpl);
		return result;
	}


	/**
	 * 批量获取监控模版 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取监控模版")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorTplVOMeta.IDS)
		@SentinelResource(value = MonitorTplServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplServiceProxy.GET_BY_IDS)
	public Result<List<MonitorTpl>> getByIds(List<String> ids) {
		Result<List<MonitorTpl>> result=new Result<>();
		List<MonitorTpl> list=monitorTplService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询监控模版
	*/
	@ApiOperation(value = "查询监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux监控模版"),
		@ApiImplicitParam(name = MonitorTplVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "tpl_host_linux"),
		@ApiImplicitParam(name = MonitorTplVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "Linux主机监控模版"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorTplVOMeta.PAGE_INDEX , MonitorTplVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorTplServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplServiceProxy.QUERY_LIST)
	public Result<List<MonitorTpl>> queryList(MonitorTplVO sample) {
		Result<List<MonitorTpl>> result=new Result<>();
		List<MonitorTpl> list=monitorTplService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询监控模版
	*/
	@ApiOperation(value = "分页查询监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "Linux监控模版"),
		@ApiImplicitParam(name = MonitorTplVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "tpl_host_linux"),
		@ApiImplicitParam(name = MonitorTplVOMeta.TYPE , value = "分类" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "Linux主机监控模版"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorTplServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorTplServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorTpl>> queryPagedList(MonitorTplVO sample) {
		Result<PagedList<MonitorTpl>> result=new Result<>();
		PagedList<MonitorTpl> list=monitorTplService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		monitorTplService.dao().fill(list)
			.with(MonitorTplMeta.TPL_TYPE)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorTplServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorTplVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorTplService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorTplServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorTplService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorTplServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorTplServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorTplService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}