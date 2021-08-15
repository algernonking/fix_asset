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


import com.dt.platform.proxy.eam.AssetExtFinancialServiceProxy;
import com.dt.platform.domain.eam.meta.AssetExtFinancialVOMeta;
import com.dt.platform.domain.eam.AssetExtFinancial;
import com.dt.platform.domain.eam.AssetExtFinancialVO;
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
import com.dt.platform.domain.eam.meta.AssetExtFinancialMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.Supplier;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetExtFinancialService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产财务 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-15 19:33:09
*/

@Api(tags = "资产财务")
@ApiSort(0)
@RestController("EamAssetExtFinancialController")
public class AssetExtFinancialController extends SuperController {

	@Autowired
	private IAssetExtFinancialService assetExtFinancialService;

	
	/**
	 * 添加资产财务
	*/
	@ApiOperation(value = "添加资产财务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TYPE_ID , value = "财务分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SOURCE_DETAIL , value = "来源详情" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_NUMBER , value = "资产数量" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TAXAMOUNT_RATE , value = "税额" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.RESIDUALS_RATE , value = "残值率" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.NAV_PRICE , value = "资产净值" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SERVICE_LIFE , value = "使用期限(月)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.STORAGE_TIME , value = "入库时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.MANAGEMENT_ORGANIZATION_ID , value = "管理组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetExtFinancialVOMeta.ID)
	@NotNull(name = AssetExtFinancialVOMeta.ASSET_NUMBER)
	@NotNull(name = AssetExtFinancialVOMeta.TAXAMOUNT_RATE)
	@NotNull(name = AssetExtFinancialVOMeta.TAXAMOUNT_PRICE)
	@NotNull(name = AssetExtFinancialVOMeta.ORIGINAL_UNIT_PRICE)
	@NotNull(name = AssetExtFinancialVOMeta.ACCUMULATED_DEPRECIATION)
	@NotNull(name = AssetExtFinancialVOMeta.RESIDUALS_RATE)
	@NotNull(name = AssetExtFinancialVOMeta.NAV_PRICE)
	@SentinelResource(value = AssetExtFinancialServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtFinancialServiceProxy.INSERT)
	public Result insert(AssetExtFinancialVO assetExtFinancialVO) {
		Result result=assetExtFinancialService.insert(assetExtFinancialVO);
		return result;
	}

	
	/**
	 * 删除资产财务
	*/
	@ApiOperation(value = "删除资产财务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetExtFinancialVOMeta.ID)
	@SentinelResource(value = AssetExtFinancialServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtFinancialServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetExtFinancialService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产财务 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产财务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetExtFinancialVOMeta.IDS)
	@SentinelResource(value = AssetExtFinancialServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtFinancialServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetExtFinancialService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产财务
	*/
	@ApiOperation(value = "更新资产财务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TYPE_ID , value = "财务分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SOURCE_DETAIL , value = "来源详情" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_NUMBER , value = "资产数量" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TAXAMOUNT_RATE , value = "税额" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.RESIDUALS_RATE , value = "残值率" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.NAV_PRICE , value = "资产净值" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SERVICE_LIFE , value = "使用期限(月)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.STORAGE_TIME , value = "入库时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.MANAGEMENT_ORGANIZATION_ID , value = "管理组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetExtFinancialVOMeta.PAGE_INDEX , AssetExtFinancialVOMeta.PAGE_SIZE , AssetExtFinancialVOMeta.SEARCH_FIELD , AssetExtFinancialVOMeta.FUZZY_FIELD , AssetExtFinancialVOMeta.SEARCH_VALUE , AssetExtFinancialVOMeta.SORT_FIELD , AssetExtFinancialVOMeta.SORT_TYPE , AssetExtFinancialVOMeta.IDS } ) 
	@NotNull(name = AssetExtFinancialVOMeta.ID)
	@NotNull(name = AssetExtFinancialVOMeta.ASSET_NUMBER)
	@NotNull(name = AssetExtFinancialVOMeta.TAXAMOUNT_RATE)
	@NotNull(name = AssetExtFinancialVOMeta.TAXAMOUNT_PRICE)
	@NotNull(name = AssetExtFinancialVOMeta.ORIGINAL_UNIT_PRICE)
	@NotNull(name = AssetExtFinancialVOMeta.ACCUMULATED_DEPRECIATION)
	@NotNull(name = AssetExtFinancialVOMeta.RESIDUALS_RATE)
	@NotNull(name = AssetExtFinancialVOMeta.NAV_PRICE)
	@SentinelResource(value = AssetExtFinancialServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtFinancialServiceProxy.UPDATE)
	public Result update(AssetExtFinancialVO assetExtFinancialVO) {
		Result result=assetExtFinancialService.update(assetExtFinancialVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产财务
	*/
	@ApiOperation(value = "保存资产财务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TYPE_ID , value = "财务分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SOURCE_DETAIL , value = "来源详情" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_NUMBER , value = "资产数量" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TAXAMOUNT_RATE , value = "税额" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.RESIDUALS_RATE , value = "残值率" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.NAV_PRICE , value = "资产净值" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SERVICE_LIFE , value = "使用期限(月)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.STORAGE_TIME , value = "入库时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.MANAGEMENT_ORGANIZATION_ID , value = "管理组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetExtFinancialVOMeta.PAGE_INDEX , AssetExtFinancialVOMeta.PAGE_SIZE , AssetExtFinancialVOMeta.SEARCH_FIELD , AssetExtFinancialVOMeta.FUZZY_FIELD , AssetExtFinancialVOMeta.SEARCH_VALUE , AssetExtFinancialVOMeta.SORT_FIELD , AssetExtFinancialVOMeta.SORT_TYPE , AssetExtFinancialVOMeta.IDS } )
	@NotNull(name = AssetExtFinancialVOMeta.ID)
	@NotNull(name = AssetExtFinancialVOMeta.ASSET_NUMBER)
	@NotNull(name = AssetExtFinancialVOMeta.TAXAMOUNT_RATE)
	@NotNull(name = AssetExtFinancialVOMeta.TAXAMOUNT_PRICE)
	@NotNull(name = AssetExtFinancialVOMeta.ORIGINAL_UNIT_PRICE)
	@NotNull(name = AssetExtFinancialVOMeta.ACCUMULATED_DEPRECIATION)
	@NotNull(name = AssetExtFinancialVOMeta.RESIDUALS_RATE)
	@NotNull(name = AssetExtFinancialVOMeta.NAV_PRICE)
	@SentinelResource(value = AssetExtFinancialServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtFinancialServiceProxy.SAVE)
	public Result save(AssetExtFinancialVO assetExtFinancialVO) {
		Result result=assetExtFinancialService.save(assetExtFinancialVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产财务
	*/
	@ApiOperation(value = "获取资产财务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetExtFinancialVOMeta.ID)
	@SentinelResource(value = AssetExtFinancialServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtFinancialServiceProxy.GET_BY_ID)
	public Result<AssetExtFinancial> getById(String id) {
		Result<AssetExtFinancial> result=new Result<>();
		AssetExtFinancial assetExtFinancial=assetExtFinancialService.getById(id);
		// 关联出 供应商 数据
		assetExtFinancialService.join(assetExtFinancial,AssetExtFinancialMeta.SUPPLIER);
		result.success(true).data(assetExtFinancial);
		return result;
	}


	/**
	 * 批量删除资产财务 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产财务")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetExtFinancialVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetExtFinancialVOMeta.IDS)
		@SentinelResource(value = AssetExtFinancialServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtFinancialServiceProxy.GET_BY_IDS)
	public Result<List<AssetExtFinancial>> getByIds(List<String> ids) {
		Result<List<AssetExtFinancial>> result=new Result<>();
		List<AssetExtFinancial> list=assetExtFinancialService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产财务
	*/
	@ApiOperation(value = "查询资产财务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TYPE_ID , value = "财务分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SOURCE_DETAIL , value = "来源详情" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_NUMBER , value = "资产数量" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TAXAMOUNT_RATE , value = "税额" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.RESIDUALS_RATE , value = "残值率" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.NAV_PRICE , value = "资产净值" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SERVICE_LIFE , value = "使用期限(月)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.STORAGE_TIME , value = "入库时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.MANAGEMENT_ORGANIZATION_ID , value = "管理组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetExtFinancialVOMeta.PAGE_INDEX , AssetExtFinancialVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetExtFinancialServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtFinancialServiceProxy.QUERY_LIST)
	public Result<List<AssetExtFinancial>> queryList(AssetExtFinancialVO sample) {
		Result<List<AssetExtFinancial>> result=new Result<>();
		List<AssetExtFinancial> list=assetExtFinancialService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产财务
	*/
	@ApiOperation(value = "分页查询资产财务")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TYPE_ID , value = "财务分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SOURCE_DETAIL , value = "来源详情" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ASSET_NUMBER , value = "资产数量" , required = true , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TAXAMOUNT_RATE , value = "税额" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.RESIDUALS_RATE , value = "残值率" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.NAV_PRICE , value = "资产净值" , required = true , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.SERVICE_LIFE , value = "使用期限(月)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.STORAGE_TIME , value = "入库时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.MANAGEMENT_ORGANIZATION_ID , value = "管理组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtFinancialVOMeta.NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetExtFinancialServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtFinancialServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetExtFinancial>> queryPagedList(AssetExtFinancialVO sample) {
		Result<PagedList<AssetExtFinancial>> result=new Result<>();
		PagedList<AssetExtFinancial> list=assetExtFinancialService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 供应商 数据
		assetExtFinancialService.join(list,AssetExtFinancialMeta.SUPPLIER);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetExtFinancialServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtFinancialServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetExtFinancialVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetExtFinancialService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetExtFinancialServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtFinancialServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetExtFinancialService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetExtFinancialServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtFinancialServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetExtFinancialService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}