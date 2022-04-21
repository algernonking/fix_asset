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


import com.dt.platform.proxy.eam.AssetStockGoodsTranferServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStockGoodsTranferVOMeta;
import com.dt.platform.domain.eam.AssetStockGoodsTranfer;
import com.dt.platform.domain.eam.AssetStockGoodsTranferVO;
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
import com.dt.platform.domain.eam.meta.AssetStockGoodsTranferMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStockGoodsTranferService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库存调拨 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 06:06:58
*/

@Api(tags = "库存调拨")
@ApiSort(0)
@RestController("EamAssetStockGoodsTranferController")
public class AssetStockGoodsTranferController extends SuperController {

	@Autowired
	private IAssetStockGoodsTranferService assetStockGoodsTranferService;


	/**
	 * 添加库存调拨
	*/
	@ApiOperation(value = "添加库存调拨")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetStockGoodsTranferServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsTranferServiceProxy.INSERT)
	public Result insert(AssetStockGoodsTranferVO assetStockGoodsTranferVO) {
		Result result=assetStockGoodsTranferService.insert(assetStockGoodsTranferVO,false);
		return result;
	}



	/**
	 * 删除库存调拨
	*/
	@ApiOperation(value = "删除库存调拨")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetStockGoodsTranferVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsTranferServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsTranferServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetStockGoodsTranferService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除库存调拨 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除库存调拨")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetStockGoodsTranferVOMeta.IDS)
	@SentinelResource(value = AssetStockGoodsTranferServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsTranferServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetStockGoodsTranferService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新库存调拨
	*/
	@ApiOperation(value = "更新库存调拨")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetStockGoodsTranferVOMeta.PAGE_INDEX , AssetStockGoodsTranferVOMeta.PAGE_SIZE , AssetStockGoodsTranferVOMeta.SEARCH_FIELD , AssetStockGoodsTranferVOMeta.FUZZY_FIELD , AssetStockGoodsTranferVOMeta.SEARCH_VALUE , AssetStockGoodsTranferVOMeta.DIRTY_FIELDS , AssetStockGoodsTranferVOMeta.SORT_FIELD , AssetStockGoodsTranferVOMeta.SORT_TYPE , AssetStockGoodsTranferVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsTranferVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsTranferServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsTranferServiceProxy.UPDATE)
	public Result update(AssetStockGoodsTranferVO assetStockGoodsTranferVO) {
		Result result=assetStockGoodsTranferService.update(assetStockGoodsTranferVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存库存调拨
	*/
	@ApiOperation(value = "保存库存调拨")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsTranferVOMeta.PAGE_INDEX , AssetStockGoodsTranferVOMeta.PAGE_SIZE , AssetStockGoodsTranferVOMeta.SEARCH_FIELD , AssetStockGoodsTranferVOMeta.FUZZY_FIELD , AssetStockGoodsTranferVOMeta.SEARCH_VALUE , AssetStockGoodsTranferVOMeta.DIRTY_FIELDS , AssetStockGoodsTranferVOMeta.SORT_FIELD , AssetStockGoodsTranferVOMeta.SORT_TYPE , AssetStockGoodsTranferVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsTranferVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsTranferServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsTranferServiceProxy.SAVE)
	public Result save(AssetStockGoodsTranferVO assetStockGoodsTranferVO) {
		Result result=assetStockGoodsTranferService.save(assetStockGoodsTranferVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取库存调拨
	*/
	@ApiOperation(value = "获取库存调拨")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetStockGoodsTranferVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsTranferServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsTranferServiceProxy.GET_BY_ID)
	public Result<AssetStockGoodsTranfer> getById(String id) {
		Result<AssetStockGoodsTranfer> result=new Result<>();
		AssetStockGoodsTranfer assetStockGoodsTranfer=assetStockGoodsTranferService.getById(id);
		result.success(true).data(assetStockGoodsTranfer);
		return result;
	}


	/**
	 * 批量获取库存调拨 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取库存调拨")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetStockGoodsTranferVOMeta.IDS)
		@SentinelResource(value = AssetStockGoodsTranferServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsTranferServiceProxy.GET_BY_IDS)
	public Result<List<AssetStockGoodsTranfer>> getByIds(List<String> ids) {
		Result<List<AssetStockGoodsTranfer>> result=new Result<>();
		List<AssetStockGoodsTranfer> list=assetStockGoodsTranferService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询库存调拨
	*/
	@ApiOperation(value = "查询库存调拨")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsTranferVOMeta.PAGE_INDEX , AssetStockGoodsTranferVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetStockGoodsTranferServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsTranferServiceProxy.QUERY_LIST)
	public Result<List<AssetStockGoodsTranfer>> queryList(AssetStockGoodsTranferVO sample) {
		Result<List<AssetStockGoodsTranfer>> result=new Result<>();
		List<AssetStockGoodsTranfer> list=assetStockGoodsTranferService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询库存调拨
	*/
	@ApiOperation(value = "分页查询库存调拨")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsTranferVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetStockGoodsTranferServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsTranferServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetStockGoodsTranfer>> queryPagedList(AssetStockGoodsTranferVO sample) {
		Result<PagedList<AssetStockGoodsTranfer>> result=new Result<>();
		PagedList<AssetStockGoodsTranfer> list=assetStockGoodsTranferService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetStockGoodsTranferServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsTranferServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetStockGoodsTranferVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetStockGoodsTranferService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetStockGoodsTranferServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsTranferServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetStockGoodsTranferService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetStockGoodsTranferServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsTranferServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetStockGoodsTranferService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}