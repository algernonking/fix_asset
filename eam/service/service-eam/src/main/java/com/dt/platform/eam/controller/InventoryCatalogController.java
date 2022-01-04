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


import com.dt.platform.proxy.eam.InventoryCatalogServiceProxy;
import com.dt.platform.domain.eam.meta.InventoryCatalogVOMeta;
import com.dt.platform.domain.eam.InventoryCatalog;
import com.dt.platform.domain.eam.InventoryCatalogVO;
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
import com.dt.platform.domain.eam.meta.InventoryCatalogMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInventoryCatalogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 盘点分类 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-04 10:56:47
*/

@Api(tags = "盘点分类")
@ApiSort(0)
@RestController("EamInventoryCatalogController")
public class InventoryCatalogController extends SuperController {

	@Autowired
	private IInventoryCatalogService inventoryCatalogService;


	/**
	 * 添加盘点分类
	*/
	@ApiOperation(value = "添加盘点分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.VALUE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InventoryCatalogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryCatalogServiceProxy.INSERT)
	public Result insert(InventoryCatalogVO inventoryCatalogVO) {
		Result result=inventoryCatalogService.insert(inventoryCatalogVO,false);
		return result;
	}



	/**
	 * 删除盘点分类
	*/
	@ApiOperation(value = "删除盘点分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InventoryCatalogVOMeta.ID)
	@SentinelResource(value = InventoryCatalogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryCatalogServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inventoryCatalogService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除盘点分类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除盘点分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryCatalogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InventoryCatalogVOMeta.IDS)
	@SentinelResource(value = InventoryCatalogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryCatalogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inventoryCatalogService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新盘点分类
	*/
	@ApiOperation(value = "更新盘点分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.VALUE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InventoryCatalogVOMeta.PAGE_INDEX , InventoryCatalogVOMeta.PAGE_SIZE , InventoryCatalogVOMeta.SEARCH_FIELD , InventoryCatalogVOMeta.FUZZY_FIELD , InventoryCatalogVOMeta.SEARCH_VALUE , InventoryCatalogVOMeta.DIRTY_FIELDS , InventoryCatalogVOMeta.SORT_FIELD , InventoryCatalogVOMeta.SORT_TYPE , InventoryCatalogVOMeta.IDS } )
	@NotNull(name = InventoryCatalogVOMeta.ID)
	@SentinelResource(value = InventoryCatalogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryCatalogServiceProxy.UPDATE)
	public Result update(InventoryCatalogVO inventoryCatalogVO) {
		Result result=inventoryCatalogService.update(inventoryCatalogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存盘点分类
	*/
	@ApiOperation(value = "保存盘点分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.VALUE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryCatalogVOMeta.PAGE_INDEX , InventoryCatalogVOMeta.PAGE_SIZE , InventoryCatalogVOMeta.SEARCH_FIELD , InventoryCatalogVOMeta.FUZZY_FIELD , InventoryCatalogVOMeta.SEARCH_VALUE , InventoryCatalogVOMeta.DIRTY_FIELDS , InventoryCatalogVOMeta.SORT_FIELD , InventoryCatalogVOMeta.SORT_TYPE , InventoryCatalogVOMeta.IDS } )
	@NotNull(name = InventoryCatalogVOMeta.ID)
	@SentinelResource(value = InventoryCatalogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryCatalogServiceProxy.SAVE)
	public Result save(InventoryCatalogVO inventoryCatalogVO) {
		Result result=inventoryCatalogService.save(inventoryCatalogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取盘点分类
	*/
	@ApiOperation(value = "获取盘点分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InventoryCatalogVOMeta.ID)
	@SentinelResource(value = InventoryCatalogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryCatalogServiceProxy.GET_BY_ID)
	public Result<InventoryCatalog> getById(String id) {
		Result<InventoryCatalog> result=new Result<>();
		InventoryCatalog inventoryCatalog=inventoryCatalogService.getById(id);
		result.success(true).data(inventoryCatalog);
		return result;
	}


	/**
	 * 批量获取盘点分类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取盘点分类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InventoryCatalogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InventoryCatalogVOMeta.IDS)
		@SentinelResource(value = InventoryCatalogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryCatalogServiceProxy.GET_BY_IDS)
	public Result<List<InventoryCatalog>> getByIds(List<String> ids) {
		Result<List<InventoryCatalog>> result=new Result<>();
		List<InventoryCatalog> list=inventoryCatalogService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询盘点分类
	*/
	@ApiOperation(value = "查询盘点分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.VALUE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryCatalogVOMeta.PAGE_INDEX , InventoryCatalogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InventoryCatalogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryCatalogServiceProxy.QUERY_LIST)
	public Result<List<InventoryCatalog>> queryList(InventoryCatalogVO sample) {
		Result<List<InventoryCatalog>> result=new Result<>();
		List<InventoryCatalog> list=inventoryCatalogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询盘点分类
	*/
	@ApiOperation(value = "分页查询盘点分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryCatalogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.VALUE , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryCatalogVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InventoryCatalogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryCatalogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InventoryCatalog>> queryPagedList(InventoryCatalogVO sample) {
		Result<PagedList<InventoryCatalog>> result=new Result<>();
		PagedList<InventoryCatalog> list=inventoryCatalogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InventoryCatalogServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryCatalogServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InventoryCatalogVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inventoryCatalogService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InventoryCatalogServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryCatalogServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inventoryCatalogService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InventoryCatalogServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryCatalogServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inventoryCatalogService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}