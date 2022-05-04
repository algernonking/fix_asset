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


import com.dt.platform.proxy.eam.AssetDepreciationServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDepreciationVOMeta;
import com.dt.platform.domain.eam.AssetDepreciation;
import com.dt.platform.domain.eam.AssetDepreciationVO;
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
import com.dt.platform.domain.eam.meta.AssetDepreciationMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.pcm.Catalog;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDepreciationService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 折旧方案 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-03 14:39:47
*/

@Api(tags = "折旧方案")
@ApiSort(0)
@RestController("EamAssetDepreciationController")
public class AssetDepreciationController extends SuperController {

	@Autowired
	private IAssetDepreciationService assetDepreciationService;


	/**
	 * 添加折旧方案
	*/
	@ApiOperation(value = "添加折旧方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573537666012807168"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.NAME , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "方案一"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.METHOD , value = "折旧方式" , required = false , dataTypeClass=String.class , example = "average_age"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.PRE_RESIDUAL_RATE , value = "预计残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.FIRST_DEPRECIATION_DATE , value = "首次折旧时间" , required = false , dataTypeClass=String.class , example = "purchase_cur_month"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486918386278731776,486918387960647681,486918449189097473,486918029091803137,486918073320738816,486918122771582977,486918164815286273,501736778307207168,486918240887377921,501737031911604224,486918241663324161,486918242527350784,501737164271255553,501737200690397185,501737355338579969"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetDepreciationServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationServiceProxy.INSERT)
	public Result insert(AssetDepreciationVO assetDepreciationVO) {
		Result result=assetDepreciationService.insert(assetDepreciationVO,false);
		return result;
	}



	/**
	 * 删除折旧方案
	*/
	@ApiOperation(value = "删除折旧方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573537666012807168")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetDepreciationVOMeta.ID)
	@SentinelResource(value = AssetDepreciationServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetDepreciationService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除折旧方案 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除折旧方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetDepreciationVOMeta.IDS)
	@SentinelResource(value = AssetDepreciationServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetDepreciationService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新折旧方案
	*/
	@ApiOperation(value = "更新折旧方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573537666012807168"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.NAME , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "方案一"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.METHOD , value = "折旧方式" , required = false , dataTypeClass=String.class , example = "average_age"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.PRE_RESIDUAL_RATE , value = "预计残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.FIRST_DEPRECIATION_DATE , value = "首次折旧时间" , required = false , dataTypeClass=String.class , example = "purchase_cur_month"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486918386278731776,486918387960647681,486918449189097473,486918029091803137,486918073320738816,486918122771582977,486918164815286273,501736778307207168,486918240887377921,501737031911604224,486918241663324161,486918242527350784,501737164271255553,501737200690397185,501737355338579969"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetDepreciationVOMeta.PAGE_INDEX , AssetDepreciationVOMeta.PAGE_SIZE , AssetDepreciationVOMeta.SEARCH_FIELD , AssetDepreciationVOMeta.FUZZY_FIELD , AssetDepreciationVOMeta.SEARCH_VALUE , AssetDepreciationVOMeta.DIRTY_FIELDS , AssetDepreciationVOMeta.SORT_FIELD , AssetDepreciationVOMeta.SORT_TYPE , AssetDepreciationVOMeta.IDS } )
	@NotNull(name = AssetDepreciationVOMeta.ID)
	@SentinelResource(value = AssetDepreciationServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationServiceProxy.UPDATE)
	public Result update(AssetDepreciationVO assetDepreciationVO) {
		Result result=assetDepreciationService.update(assetDepreciationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存折旧方案
	*/
	@ApiOperation(value = "保存折旧方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573537666012807168"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.NAME , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "方案一"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.METHOD , value = "折旧方式" , required = false , dataTypeClass=String.class , example = "average_age"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.PRE_RESIDUAL_RATE , value = "预计残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.FIRST_DEPRECIATION_DATE , value = "首次折旧时间" , required = false , dataTypeClass=String.class , example = "purchase_cur_month"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486918386278731776,486918387960647681,486918449189097473,486918029091803137,486918073320738816,486918122771582977,486918164815286273,501736778307207168,486918240887377921,501737031911604224,486918241663324161,486918242527350784,501737164271255553,501737200690397185,501737355338579969"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDepreciationVOMeta.PAGE_INDEX , AssetDepreciationVOMeta.PAGE_SIZE , AssetDepreciationVOMeta.SEARCH_FIELD , AssetDepreciationVOMeta.FUZZY_FIELD , AssetDepreciationVOMeta.SEARCH_VALUE , AssetDepreciationVOMeta.DIRTY_FIELDS , AssetDepreciationVOMeta.SORT_FIELD , AssetDepreciationVOMeta.SORT_TYPE , AssetDepreciationVOMeta.IDS } )
	@NotNull(name = AssetDepreciationVOMeta.ID)
	@SentinelResource(value = AssetDepreciationServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationServiceProxy.SAVE)
	public Result save(AssetDepreciationVO assetDepreciationVO) {
		Result result=assetDepreciationService.save(assetDepreciationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取折旧方案
	*/
	@ApiOperation(value = "获取折旧方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetDepreciationVOMeta.ID)
	@SentinelResource(value = AssetDepreciationServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationServiceProxy.GET_BY_ID)
	public Result<AssetDepreciation> getById(String id) {
		Result<AssetDepreciation> result=new Result<>();
		AssetDepreciation assetDepreciation=assetDepreciationService.getById(id);
		// join 关联的对象
		assetDepreciationService.dao().fill(assetDepreciation)
			.with(AssetDepreciationMeta.CATEGORY)
			.execute();
		result.success(true).data(assetDepreciation);
		return result;
	}


	/**
	 * 批量获取折旧方案 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取折旧方案")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetDepreciationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetDepreciationVOMeta.IDS)
		@SentinelResource(value = AssetDepreciationServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationServiceProxy.GET_BY_IDS)
	public Result<List<AssetDepreciation>> getByIds(List<String> ids) {
		Result<List<AssetDepreciation>> result=new Result<>();
		List<AssetDepreciation> list=assetDepreciationService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询折旧方案
	*/
	@ApiOperation(value = "查询折旧方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573537666012807168"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.NAME , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "方案一"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.METHOD , value = "折旧方式" , required = false , dataTypeClass=String.class , example = "average_age"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.PRE_RESIDUAL_RATE , value = "预计残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.FIRST_DEPRECIATION_DATE , value = "首次折旧时间" , required = false , dataTypeClass=String.class , example = "purchase_cur_month"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486918386278731776,486918387960647681,486918449189097473,486918029091803137,486918073320738816,486918122771582977,486918164815286273,501736778307207168,486918240887377921,501737031911604224,486918241663324161,486918242527350784,501737164271255553,501737200690397185,501737355338579969"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDepreciationVOMeta.PAGE_INDEX , AssetDepreciationVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetDepreciationServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationServiceProxy.QUERY_LIST)
	public Result<List<AssetDepreciation>> queryList(AssetDepreciationVO sample) {
		Result<List<AssetDepreciation>> result=new Result<>();
		List<AssetDepreciation> list=assetDepreciationService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询折旧方案
	*/
	@ApiOperation(value = "分页查询折旧方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "573537666012807168"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.NAME , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "方案一"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.METHOD , value = "折旧方式" , required = false , dataTypeClass=String.class , example = "average_age"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.PRE_RESIDUAL_RATE , value = "预计残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.FIRST_DEPRECIATION_DATE , value = "首次折旧时间" , required = false , dataTypeClass=String.class , example = "purchase_cur_month"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486918386278731776,486918387960647681,486918449189097473,486918029091803137,486918073320738816,486918122771582977,486918164815286273,501736778307207168,486918240887377921,501737031911604224,486918241663324161,486918242527350784,501737164271255553,501737200690397185,501737355338579969"),
		@ApiImplicitParam(name = AssetDepreciationVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetDepreciationServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetDepreciation>> queryPagedList(AssetDepreciationVO sample) {
		Result<PagedList<AssetDepreciation>> result=new Result<>();
		PagedList<AssetDepreciation> list=assetDepreciationService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetDepreciationService.dao().fill(list)
			.with(AssetDepreciationMeta.CATEGORY)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetDepreciationServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetDepreciationVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetDepreciationService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetDepreciationServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetDepreciationService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetDepreciationServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetDepreciationService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}