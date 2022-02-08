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


import com.dt.platform.proxy.ops.MonitorNodeTplItemServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeTplItemVOMeta;
import com.dt.platform.domain.ops.MonitorNodeTplItem;
import com.dt.platform.domain.ops.MonitorNodeTplItemVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeTplItemMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeTplItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点监控模版 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:55
*/

@Api(tags = "节点监控模版")
@ApiSort(0)
@RestController("OpsMonitorNodeTplItemController")
public class MonitorNodeTplItemController extends SuperController {

	@Autowired
	private IMonitorNodeTplItemService monitorNodeTplItemService;


	/**
	 * 添加节点监控模版
	*/
	@ApiOperation(value = "添加节点监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.TPL_CODE , value = "模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_script"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MonitorNodeTplItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTplItemServiceProxy.INSERT)
	public Result insert(MonitorNodeTplItemVO monitorNodeTplItemVO) {
		Result result=monitorNodeTplItemService.insert(monitorNodeTplItemVO,false);
		return result;
	}



	/**
	 * 删除节点监控模版
	*/
	@ApiOperation(value = "删除节点监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MonitorNodeTplItemVOMeta.ID)
	@SentinelResource(value = MonitorNodeTplItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTplItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=monitorNodeTplItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除节点监控模版 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除节点监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MonitorNodeTplItemVOMeta.IDS)
	@SentinelResource(value = MonitorNodeTplItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTplItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=monitorNodeTplItemService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新节点监控模版
	*/
	@ApiOperation(value = "更新节点监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.TPL_CODE , value = "模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_script"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MonitorNodeTplItemVOMeta.PAGE_INDEX , MonitorNodeTplItemVOMeta.PAGE_SIZE , MonitorNodeTplItemVOMeta.SEARCH_FIELD , MonitorNodeTplItemVOMeta.FUZZY_FIELD , MonitorNodeTplItemVOMeta.SEARCH_VALUE , MonitorNodeTplItemVOMeta.DIRTY_FIELDS , MonitorNodeTplItemVOMeta.SORT_FIELD , MonitorNodeTplItemVOMeta.SORT_TYPE , MonitorNodeTplItemVOMeta.IDS } )
	@NotNull(name = MonitorNodeTplItemVOMeta.ID)
	@SentinelResource(value = MonitorNodeTplItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTplItemServiceProxy.UPDATE)
	public Result update(MonitorNodeTplItemVO monitorNodeTplItemVO) {
		Result result=monitorNodeTplItemService.update(monitorNodeTplItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存节点监控模版
	*/
	@ApiOperation(value = "保存节点监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.TPL_CODE , value = "模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_script"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeTplItemVOMeta.PAGE_INDEX , MonitorNodeTplItemVOMeta.PAGE_SIZE , MonitorNodeTplItemVOMeta.SEARCH_FIELD , MonitorNodeTplItemVOMeta.FUZZY_FIELD , MonitorNodeTplItemVOMeta.SEARCH_VALUE , MonitorNodeTplItemVOMeta.DIRTY_FIELDS , MonitorNodeTplItemVOMeta.SORT_FIELD , MonitorNodeTplItemVOMeta.SORT_TYPE , MonitorNodeTplItemVOMeta.IDS } )
	@NotNull(name = MonitorNodeTplItemVOMeta.ID)
	@SentinelResource(value = MonitorNodeTplItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTplItemServiceProxy.SAVE)
	public Result save(MonitorNodeTplItemVO monitorNodeTplItemVO) {
		Result result=monitorNodeTplItemService.save(monitorNodeTplItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取节点监控模版
	*/
	@ApiOperation(value = "获取节点监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MonitorNodeTplItemVOMeta.ID)
	@SentinelResource(value = MonitorNodeTplItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTplItemServiceProxy.GET_BY_ID)
	public Result<MonitorNodeTplItem> getById(String id) {
		Result<MonitorNodeTplItem> result=new Result<>();
		MonitorNodeTplItem monitorNodeTplItem=monitorNodeTplItemService.getById(id);
		result.success(true).data(monitorNodeTplItem);
		return result;
	}


	/**
	 * 批量获取节点监控模版 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取节点监控模版")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MonitorNodeTplItemVOMeta.IDS)
		@SentinelResource(value = MonitorNodeTplItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTplItemServiceProxy.GET_BY_IDS)
	public Result<List<MonitorNodeTplItem>> getByIds(List<String> ids) {
		Result<List<MonitorNodeTplItem>> result=new Result<>();
		List<MonitorNodeTplItem> list=monitorNodeTplItemService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询节点监控模版
	*/
	@ApiOperation(value = "查询节点监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.TPL_CODE , value = "模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_script"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MonitorNodeTplItemVOMeta.PAGE_INDEX , MonitorNodeTplItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MonitorNodeTplItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTplItemServiceProxy.QUERY_LIST)
	public Result<List<MonitorNodeTplItem>> queryList(MonitorNodeTplItemVO sample) {
		Result<List<MonitorNodeTplItem>> result=new Result<>();
		List<MonitorNodeTplItem> list=monitorNodeTplItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询节点监控模版
	*/
	@ApiOperation(value = "分页查询节点监控模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.NODE_ID , value = "节点" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = MonitorNodeTplItemVOMeta.TPL_CODE , value = "模版" , required = false , dataTypeClass=String.class , example = "tpl_host_linux_script"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MonitorNodeTplItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MonitorNodeTplItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MonitorNodeTplItem>> queryPagedList(MonitorNodeTplItemVO sample) {
		Result<PagedList<MonitorNodeTplItem>> result=new Result<>();
		PagedList<MonitorNodeTplItem> list=monitorNodeTplItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MonitorNodeTplItemServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeTplItemServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MonitorNodeTplItemVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=monitorNodeTplItemService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MonitorNodeTplItemServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeTplItemServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=monitorNodeTplItemService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MonitorNodeTplItemServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MonitorNodeTplItemServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=monitorNodeTplItemService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}