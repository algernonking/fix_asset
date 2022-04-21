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


import com.dt.platform.proxy.eam.AssetStockGoodsAdjustServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStockGoodsAdjustVOMeta;
import com.dt.platform.domain.eam.AssetStockGoodsAdjust;
import com.dt.platform.domain.eam.AssetStockGoodsAdjustVO;
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
import com.dt.platform.domain.eam.meta.AssetStockGoodsAdjustMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStockGoodsAdjustService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库存调整 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 06:06:07
*/

@Api(tags = "库存调整")
@ApiSort(0)
@RestController("EamAssetStockGoodsAdjustController")
public class AssetStockGoodsAdjustController extends SuperController {

	@Autowired
	private IAssetStockGoodsAdjustService assetStockGoodsAdjustService;


	/**
	 * 添加库存调整
	*/
	@ApiOperation(value = "添加库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.INSERT)
	public Result insert(AssetStockGoodsAdjustVO assetStockGoodsAdjustVO) {
		Result result=assetStockGoodsAdjustService.insert(assetStockGoodsAdjustVO,false);
		return result;
	}



	/**
	 * 删除库存调整
	*/
	@ApiOperation(value = "删除库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetStockGoodsAdjustVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetStockGoodsAdjustService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除库存调整 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetStockGoodsAdjustVOMeta.IDS)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetStockGoodsAdjustService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新库存调整
	*/
	@ApiOperation(value = "更新库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetStockGoodsAdjustVOMeta.PAGE_INDEX , AssetStockGoodsAdjustVOMeta.PAGE_SIZE , AssetStockGoodsAdjustVOMeta.SEARCH_FIELD , AssetStockGoodsAdjustVOMeta.FUZZY_FIELD , AssetStockGoodsAdjustVOMeta.SEARCH_VALUE , AssetStockGoodsAdjustVOMeta.DIRTY_FIELDS , AssetStockGoodsAdjustVOMeta.SORT_FIELD , AssetStockGoodsAdjustVOMeta.SORT_TYPE , AssetStockGoodsAdjustVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsAdjustVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.UPDATE)
	public Result update(AssetStockGoodsAdjustVO assetStockGoodsAdjustVO) {
		Result result=assetStockGoodsAdjustService.update(assetStockGoodsAdjustVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存库存调整
	*/
	@ApiOperation(value = "保存库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsAdjustVOMeta.PAGE_INDEX , AssetStockGoodsAdjustVOMeta.PAGE_SIZE , AssetStockGoodsAdjustVOMeta.SEARCH_FIELD , AssetStockGoodsAdjustVOMeta.FUZZY_FIELD , AssetStockGoodsAdjustVOMeta.SEARCH_VALUE , AssetStockGoodsAdjustVOMeta.DIRTY_FIELDS , AssetStockGoodsAdjustVOMeta.SORT_FIELD , AssetStockGoodsAdjustVOMeta.SORT_TYPE , AssetStockGoodsAdjustVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsAdjustVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.SAVE)
	public Result save(AssetStockGoodsAdjustVO assetStockGoodsAdjustVO) {
		Result result=assetStockGoodsAdjustService.save(assetStockGoodsAdjustVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取库存调整
	*/
	@ApiOperation(value = "获取库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetStockGoodsAdjustVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.GET_BY_ID)
	public Result<AssetStockGoodsAdjust> getById(String id) {
		Result<AssetStockGoodsAdjust> result=new Result<>();
		AssetStockGoodsAdjust assetStockGoodsAdjust=assetStockGoodsAdjustService.getById(id);
		result.success(true).data(assetStockGoodsAdjust);
		return result;
	}


	/**
	 * 批量获取库存调整 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取库存调整")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetStockGoodsAdjustVOMeta.IDS)
		@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.GET_BY_IDS)
	public Result<List<AssetStockGoodsAdjust>> getByIds(List<String> ids) {
		Result<List<AssetStockGoodsAdjust>> result=new Result<>();
		List<AssetStockGoodsAdjust> list=assetStockGoodsAdjustService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询库存调整
	*/
	@ApiOperation(value = "查询库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsAdjustVOMeta.PAGE_INDEX , AssetStockGoodsAdjustVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.QUERY_LIST)
	public Result<List<AssetStockGoodsAdjust>> queryList(AssetStockGoodsAdjustVO sample) {
		Result<List<AssetStockGoodsAdjust>> result=new Result<>();
		List<AssetStockGoodsAdjust> list=assetStockGoodsAdjustService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询库存调整
	*/
	@ApiOperation(value = "分页查询库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetStockGoodsAdjust>> queryPagedList(AssetStockGoodsAdjustVO sample) {
		Result<PagedList<AssetStockGoodsAdjust>> result=new Result<>();
		PagedList<AssetStockGoodsAdjust> list=assetStockGoodsAdjustService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetStockGoodsAdjustVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetStockGoodsAdjustService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetStockGoodsAdjustService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetStockGoodsAdjustService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}