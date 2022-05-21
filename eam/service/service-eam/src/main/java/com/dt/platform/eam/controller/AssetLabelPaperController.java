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


import com.dt.platform.proxy.eam.AssetLabelPaperServiceProxy;
import com.dt.platform.domain.eam.meta.AssetLabelPaperVOMeta;
import com.dt.platform.domain.eam.AssetLabelPaper;
import com.dt.platform.domain.eam.AssetLabelPaperVO;
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
import com.dt.platform.domain.eam.meta.AssetLabelPaperMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetLabelPaperService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 纸张类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-20 21:19:26
*/

@Api(tags = "纸张类型")
@ApiSort(0)
@RestController("EamAssetLabelPaperController")
public class AssetLabelPaperController extends SuperController {

	@Autowired
	private IAssetLabelPaperService assetLabelPaperService;


	/**
	 * 添加纸张类型
	*/
	@ApiOperation(value = "添加纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "标签专用纸"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.STATUS , value = "是否启用" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.COLUMN_NUMBER , value = "列数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetLabelPaperServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.INSERT)
	public Result insert(AssetLabelPaperVO assetLabelPaperVO) {
		Result result=assetLabelPaperService.insert(assetLabelPaperVO,false);
		return result;
	}



	/**
	 * 删除纸张类型
	*/
	@ApiOperation(value = "删除纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetLabelPaperVOMeta.ID)
	@SentinelResource(value = AssetLabelPaperServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetLabelPaperService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除纸张类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetLabelPaperVOMeta.IDS)
	@SentinelResource(value = AssetLabelPaperServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetLabelPaperService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新纸张类型
	*/
	@ApiOperation(value = "更新纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "标签专用纸"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.STATUS , value = "是否启用" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.COLUMN_NUMBER , value = "列数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetLabelPaperVOMeta.PAGE_INDEX , AssetLabelPaperVOMeta.PAGE_SIZE , AssetLabelPaperVOMeta.SEARCH_FIELD , AssetLabelPaperVOMeta.FUZZY_FIELD , AssetLabelPaperVOMeta.SEARCH_VALUE , AssetLabelPaperVOMeta.DIRTY_FIELDS , AssetLabelPaperVOMeta.SORT_FIELD , AssetLabelPaperVOMeta.SORT_TYPE , AssetLabelPaperVOMeta.IDS } )
	@NotNull(name = AssetLabelPaperVOMeta.ID)
	@SentinelResource(value = AssetLabelPaperServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.UPDATE)
	public Result update(AssetLabelPaperVO assetLabelPaperVO) {
		Result result=assetLabelPaperService.update(assetLabelPaperVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存纸张类型
	*/
	@ApiOperation(value = "保存纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "标签专用纸"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.STATUS , value = "是否启用" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.COLUMN_NUMBER , value = "列数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetLabelPaperVOMeta.PAGE_INDEX , AssetLabelPaperVOMeta.PAGE_SIZE , AssetLabelPaperVOMeta.SEARCH_FIELD , AssetLabelPaperVOMeta.FUZZY_FIELD , AssetLabelPaperVOMeta.SEARCH_VALUE , AssetLabelPaperVOMeta.DIRTY_FIELDS , AssetLabelPaperVOMeta.SORT_FIELD , AssetLabelPaperVOMeta.SORT_TYPE , AssetLabelPaperVOMeta.IDS } )
	@NotNull(name = AssetLabelPaperVOMeta.ID)
	@SentinelResource(value = AssetLabelPaperServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.SAVE)
	public Result save(AssetLabelPaperVO assetLabelPaperVO) {
		Result result=assetLabelPaperService.save(assetLabelPaperVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取纸张类型
	*/
	@ApiOperation(value = "获取纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetLabelPaperVOMeta.ID)
	@SentinelResource(value = AssetLabelPaperServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.GET_BY_ID)
	public Result<AssetLabelPaper> getById(String id) {
		Result<AssetLabelPaper> result=new Result<>();
		AssetLabelPaper assetLabelPaper=assetLabelPaperService.getById(id);
		result.success(true).data(assetLabelPaper);
		return result;
	}


	/**
	 * 批量获取纸张类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取纸张类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetLabelPaperVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetLabelPaperVOMeta.IDS)
		@SentinelResource(value = AssetLabelPaperServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.GET_BY_IDS)
	public Result<List<AssetLabelPaper>> getByIds(List<String> ids) {
		Result<List<AssetLabelPaper>> result=new Result<>();
		List<AssetLabelPaper> list=assetLabelPaperService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询纸张类型
	*/
	@ApiOperation(value = "查询纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "标签专用纸"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.STATUS , value = "是否启用" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.COLUMN_NUMBER , value = "列数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetLabelPaperVOMeta.PAGE_INDEX , AssetLabelPaperVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetLabelPaperServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.QUERY_LIST)
	public Result<List<AssetLabelPaper>> queryList(AssetLabelPaperVO sample) {
		Result<List<AssetLabelPaper>> result=new Result<>();
		List<AssetLabelPaper> list=assetLabelPaperService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询纸张类型
	*/
	@ApiOperation(value = "分页查询纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "标签专用纸"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.STATUS , value = "是否启用" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.COLUMN_NUMBER , value = "列数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetLabelPaperServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetLabelPaper>> queryPagedList(AssetLabelPaperVO sample) {
		Result<PagedList<AssetLabelPaper>> result=new Result<>();
		PagedList<AssetLabelPaper> list=assetLabelPaperService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetLabelPaperServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelPaperServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetLabelPaperVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetLabelPaperService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetLabelPaperServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelPaperServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetLabelPaperService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetLabelPaperServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelPaperServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetLabelPaperService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}