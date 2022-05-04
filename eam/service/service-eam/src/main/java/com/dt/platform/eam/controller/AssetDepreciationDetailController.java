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


import com.dt.platform.proxy.eam.AssetDepreciationDetailServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDepreciationDetailVOMeta;
import com.dt.platform.domain.eam.AssetDepreciationDetail;
import com.dt.platform.domain.eam.AssetDepreciationDetailVO;
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
import com.dt.platform.domain.eam.meta.AssetDepreciationDetailMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetDepreciation;
import com.dt.platform.domain.eam.AssetDepreciationOper;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDepreciationDetailService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 折旧明细 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-03 22:05:32
*/

@Api(tags = "折旧明细")
@ApiSort(0)
@RestController("EamAssetDepreciationDetailController")
public class AssetDepreciationDetailController extends SuperController {

	@Autowired
	private IAssetDepreciationDetailService assetDepreciationDetailService;


	/**
	 * 添加折旧明细
	*/
	@ApiOperation(value = "添加折旧明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573976353204862976"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.OPER_ID , value = "折旧操作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "572681609443016704"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DETAIL_ID_SOURCE , value = "折旧前" , required = false , dataTypeClass=String.class , example = "573976352709935104"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DETAIL_ID_TARGET , value = "折旧后" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.CUR_PRICE , value = "当前净值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.BEFORE_PRICE , value = "折旧前净值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.AFTER_PRICE , value = "折旧后净值" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetDepreciationDetailServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationDetailServiceProxy.INSERT)
	public Result insert(AssetDepreciationDetailVO assetDepreciationDetailVO) {
		Result result=assetDepreciationDetailService.insert(assetDepreciationDetailVO,false);
		return result;
	}



	/**
	 * 删除折旧明细
	*/
	@ApiOperation(value = "删除折旧明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573976353204862976")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetDepreciationDetailVOMeta.ID)
	@SentinelResource(value = AssetDepreciationDetailServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationDetailServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetDepreciationDetailService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除折旧明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除折旧明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetDepreciationDetailVOMeta.IDS)
	@SentinelResource(value = AssetDepreciationDetailServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationDetailServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetDepreciationDetailService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新折旧明细
	*/
	@ApiOperation(value = "更新折旧明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573976353204862976"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.OPER_ID , value = "折旧操作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "572681609443016704"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DETAIL_ID_SOURCE , value = "折旧前" , required = false , dataTypeClass=String.class , example = "573976352709935104"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DETAIL_ID_TARGET , value = "折旧后" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.CUR_PRICE , value = "当前净值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.BEFORE_PRICE , value = "折旧前净值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.AFTER_PRICE , value = "折旧后净值" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetDepreciationDetailVOMeta.PAGE_INDEX , AssetDepreciationDetailVOMeta.PAGE_SIZE , AssetDepreciationDetailVOMeta.SEARCH_FIELD , AssetDepreciationDetailVOMeta.FUZZY_FIELD , AssetDepreciationDetailVOMeta.SEARCH_VALUE , AssetDepreciationDetailVOMeta.DIRTY_FIELDS , AssetDepreciationDetailVOMeta.SORT_FIELD , AssetDepreciationDetailVOMeta.SORT_TYPE , AssetDepreciationDetailVOMeta.IDS } )
	@NotNull(name = AssetDepreciationDetailVOMeta.ID)
	@SentinelResource(value = AssetDepreciationDetailServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationDetailServiceProxy.UPDATE)
	public Result update(AssetDepreciationDetailVO assetDepreciationDetailVO) {
		Result result=assetDepreciationDetailService.update(assetDepreciationDetailVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存折旧明细
	*/
	@ApiOperation(value = "保存折旧明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573976353204862976"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.OPER_ID , value = "折旧操作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "572681609443016704"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DETAIL_ID_SOURCE , value = "折旧前" , required = false , dataTypeClass=String.class , example = "573976352709935104"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DETAIL_ID_TARGET , value = "折旧后" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.CUR_PRICE , value = "当前净值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.BEFORE_PRICE , value = "折旧前净值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.AFTER_PRICE , value = "折旧后净值" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDepreciationDetailVOMeta.PAGE_INDEX , AssetDepreciationDetailVOMeta.PAGE_SIZE , AssetDepreciationDetailVOMeta.SEARCH_FIELD , AssetDepreciationDetailVOMeta.FUZZY_FIELD , AssetDepreciationDetailVOMeta.SEARCH_VALUE , AssetDepreciationDetailVOMeta.DIRTY_FIELDS , AssetDepreciationDetailVOMeta.SORT_FIELD , AssetDepreciationDetailVOMeta.SORT_TYPE , AssetDepreciationDetailVOMeta.IDS } )
	@NotNull(name = AssetDepreciationDetailVOMeta.ID)
	@SentinelResource(value = AssetDepreciationDetailServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationDetailServiceProxy.SAVE)
	public Result save(AssetDepreciationDetailVO assetDepreciationDetailVO) {
		Result result=assetDepreciationDetailService.save(assetDepreciationDetailVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取折旧明细
	*/
	@ApiOperation(value = "获取折旧明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetDepreciationDetailVOMeta.ID)
	@SentinelResource(value = AssetDepreciationDetailServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationDetailServiceProxy.GET_BY_ID)
	public Result<AssetDepreciationDetail> getById(String id) {
		Result<AssetDepreciationDetail> result=new Result<>();
		AssetDepreciationDetail assetDepreciationDetail=assetDepreciationDetailService.getById(id);
		// join 关联的对象
		assetDepreciationDetailService.dao().fill(assetDepreciationDetail)
			.with(AssetDepreciationDetailMeta.ASSET_DEPRECIATION)
			.with(AssetDepreciationDetailMeta.ASSET_DEPRECIATION_OPER)
			.with(AssetDepreciationDetailMeta.ASSET)
			.with(AssetDepreciationDetailMeta.ASSET_SOURCE)
			.with(AssetDepreciationDetailMeta.ASSET_TARGET)
			.execute();
		result.success(true).data(assetDepreciationDetail);
		return result;
	}


	/**
	 * 批量获取折旧明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取折旧明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetDepreciationDetailVOMeta.IDS)
		@SentinelResource(value = AssetDepreciationDetailServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationDetailServiceProxy.GET_BY_IDS)
	public Result<List<AssetDepreciationDetail>> getByIds(List<String> ids) {
		Result<List<AssetDepreciationDetail>> result=new Result<>();
		List<AssetDepreciationDetail> list=assetDepreciationDetailService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询折旧明细
	*/
	@ApiOperation(value = "查询折旧明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573976353204862976"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.OPER_ID , value = "折旧操作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "572681609443016704"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DETAIL_ID_SOURCE , value = "折旧前" , required = false , dataTypeClass=String.class , example = "573976352709935104"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DETAIL_ID_TARGET , value = "折旧后" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.CUR_PRICE , value = "当前净值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.BEFORE_PRICE , value = "折旧前净值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.AFTER_PRICE , value = "折旧后净值" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDepreciationDetailVOMeta.PAGE_INDEX , AssetDepreciationDetailVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetDepreciationDetailServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationDetailServiceProxy.QUERY_LIST)
	public Result<List<AssetDepreciationDetail>> queryList(AssetDepreciationDetailVO sample) {
		Result<List<AssetDepreciationDetail>> result=new Result<>();
		List<AssetDepreciationDetail> list=assetDepreciationDetailService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询折旧明细
	*/
	@ApiOperation(value = "分页查询折旧明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573976353204862976"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.OPER_ID , value = "折旧操作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "572681609443016704"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DETAIL_ID_SOURCE , value = "折旧前" , required = false , dataTypeClass=String.class , example = "573976352709935104"),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.DETAIL_ID_TARGET , value = "折旧后" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.CUR_PRICE , value = "当前净值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.BEFORE_PRICE , value = "折旧前净值" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationDetailVOMeta.AFTER_PRICE , value = "折旧后净值" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetDepreciationDetailServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationDetailServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetDepreciationDetail>> queryPagedList(AssetDepreciationDetailVO sample) {
		Result<PagedList<AssetDepreciationDetail>> result=new Result<>();
		PagedList<AssetDepreciationDetail> list=assetDepreciationDetailService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetDepreciationDetailService.dao().fill(list)
			.with(AssetDepreciationDetailMeta.ASSET_DEPRECIATION)
			.with(AssetDepreciationDetailMeta.ASSET_DEPRECIATION_OPER)
			.with(AssetDepreciationDetailMeta.ASSET)
			.with(AssetDepreciationDetailMeta.ASSET_SOURCE)
			.with(AssetDepreciationDetailMeta.ASSET_TARGET)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetDepreciationDetailServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationDetailServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetDepreciationDetailVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetDepreciationDetailService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetDepreciationDetailServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationDetailServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetDepreciationDetailService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetDepreciationDetailServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationDetailServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetDepreciationDetailService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}