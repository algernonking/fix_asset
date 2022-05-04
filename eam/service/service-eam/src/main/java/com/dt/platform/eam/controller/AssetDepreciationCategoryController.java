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


import com.dt.platform.proxy.eam.AssetDepreciationCategoryServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDepreciationCategoryVOMeta;
import com.dt.platform.domain.eam.AssetDepreciationCategory;
import com.dt.platform.domain.eam.AssetDepreciationCategoryVO;
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
import com.dt.platform.domain.eam.meta.AssetDepreciationCategoryMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDepreciationCategoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 折旧分类 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-03 14:33:28
*/

@Api(tags = "折旧分类")
@ApiSort(0)
@RestController("EamAssetDepreciationCategoryController")
public class AssetDepreciationCategoryController extends SuperController {

	@Autowired
	private IAssetDepreciationCategoryService assetDepreciationCategoryService;


	/**
	 * 添加折旧分类
	*/
	@ApiOperation(value = "添加折旧分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573877824906072064"),
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "573537666012807168"),
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486918386278731776"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetDepreciationCategoryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCategoryServiceProxy.INSERT)
	public Result insert(AssetDepreciationCategoryVO assetDepreciationCategoryVO) {
		Result result=assetDepreciationCategoryService.insert(assetDepreciationCategoryVO,false);
		return result;
	}



	/**
	 * 删除折旧分类
	*/
	@ApiOperation(value = "删除折旧分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573877824906072064")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetDepreciationCategoryVOMeta.ID)
	@SentinelResource(value = AssetDepreciationCategoryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCategoryServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetDepreciationCategoryService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除折旧分类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除折旧分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetDepreciationCategoryVOMeta.IDS)
	@SentinelResource(value = AssetDepreciationCategoryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCategoryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetDepreciationCategoryService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新折旧分类
	*/
	@ApiOperation(value = "更新折旧分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573877824906072064"),
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "573537666012807168"),
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486918386278731776"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetDepreciationCategoryVOMeta.PAGE_INDEX , AssetDepreciationCategoryVOMeta.PAGE_SIZE , AssetDepreciationCategoryVOMeta.SEARCH_FIELD , AssetDepreciationCategoryVOMeta.FUZZY_FIELD , AssetDepreciationCategoryVOMeta.SEARCH_VALUE , AssetDepreciationCategoryVOMeta.DIRTY_FIELDS , AssetDepreciationCategoryVOMeta.SORT_FIELD , AssetDepreciationCategoryVOMeta.SORT_TYPE , AssetDepreciationCategoryVOMeta.IDS } )
	@NotNull(name = AssetDepreciationCategoryVOMeta.ID)
	@SentinelResource(value = AssetDepreciationCategoryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCategoryServiceProxy.UPDATE)
	public Result update(AssetDepreciationCategoryVO assetDepreciationCategoryVO) {
		Result result=assetDepreciationCategoryService.update(assetDepreciationCategoryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存折旧分类
	*/
	@ApiOperation(value = "保存折旧分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573877824906072064"),
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "573537666012807168"),
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486918386278731776"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDepreciationCategoryVOMeta.PAGE_INDEX , AssetDepreciationCategoryVOMeta.PAGE_SIZE , AssetDepreciationCategoryVOMeta.SEARCH_FIELD , AssetDepreciationCategoryVOMeta.FUZZY_FIELD , AssetDepreciationCategoryVOMeta.SEARCH_VALUE , AssetDepreciationCategoryVOMeta.DIRTY_FIELDS , AssetDepreciationCategoryVOMeta.SORT_FIELD , AssetDepreciationCategoryVOMeta.SORT_TYPE , AssetDepreciationCategoryVOMeta.IDS } )
	@NotNull(name = AssetDepreciationCategoryVOMeta.ID)
	@SentinelResource(value = AssetDepreciationCategoryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCategoryServiceProxy.SAVE)
	public Result save(AssetDepreciationCategoryVO assetDepreciationCategoryVO) {
		Result result=assetDepreciationCategoryService.save(assetDepreciationCategoryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取折旧分类
	*/
	@ApiOperation(value = "获取折旧分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetDepreciationCategoryVOMeta.ID)
	@SentinelResource(value = AssetDepreciationCategoryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCategoryServiceProxy.GET_BY_ID)
	public Result<AssetDepreciationCategory> getById(String id) {
		Result<AssetDepreciationCategory> result=new Result<>();
		AssetDepreciationCategory assetDepreciationCategory=assetDepreciationCategoryService.getById(id);
		result.success(true).data(assetDepreciationCategory);
		return result;
	}


	/**
	 * 批量获取折旧分类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取折旧分类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetDepreciationCategoryVOMeta.IDS)
		@SentinelResource(value = AssetDepreciationCategoryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCategoryServiceProxy.GET_BY_IDS)
	public Result<List<AssetDepreciationCategory>> getByIds(List<String> ids) {
		Result<List<AssetDepreciationCategory>> result=new Result<>();
		List<AssetDepreciationCategory> list=assetDepreciationCategoryService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询折旧分类
	*/
	@ApiOperation(value = "查询折旧分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573877824906072064"),
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "573537666012807168"),
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486918386278731776"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDepreciationCategoryVOMeta.PAGE_INDEX , AssetDepreciationCategoryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetDepreciationCategoryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCategoryServiceProxy.QUERY_LIST)
	public Result<List<AssetDepreciationCategory>> queryList(AssetDepreciationCategoryVO sample) {
		Result<List<AssetDepreciationCategory>> result=new Result<>();
		List<AssetDepreciationCategory> list=assetDepreciationCategoryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询折旧分类
	*/
	@ApiOperation(value = "分页查询折旧分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573877824906072064"),
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "573537666012807168"),
		@ApiImplicitParam(name = AssetDepreciationCategoryVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486918386278731776"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetDepreciationCategoryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCategoryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetDepreciationCategory>> queryPagedList(AssetDepreciationCategoryVO sample) {
		Result<PagedList<AssetDepreciationCategory>> result=new Result<>();
		PagedList<AssetDepreciationCategory> list=assetDepreciationCategoryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetDepreciationCategoryServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationCategoryServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetDepreciationCategoryVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetDepreciationCategoryService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetDepreciationCategoryServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationCategoryServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetDepreciationCategoryService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetDepreciationCategoryServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationCategoryServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetDepreciationCategoryService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}