package com.dt.platform.eam.controller;


import java.util.ArrayList;
import java.util.List;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSONArray;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.AssetStockGoodsOwnerEnum;
import com.dt.platform.constants.enums.eam.AssetStockTypeEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.proxy.eam.AssetReportServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.hrm.Person;
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


import com.dt.platform.proxy.eam.GoodsStockServiceProxy;
import com.dt.platform.domain.eam.meta.GoodsStockVOMeta;
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
import com.dt.platform.domain.eam.meta.GoodsStockMeta;
import java.math.BigDecimal;

import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.meta.GoodsMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IGoodsStockService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库存物品 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-21 11:41:53
*/

@Api(tags = "库存物品")
@ApiSort(0)
@RestController("EamGoodsStockController")
public class GoodsStockController extends SuperController {

	@Autowired
	private IGoodsStockService goodsStockService;


	/**
	 * 添加库存物品
	*/
	@ApiOperation(value = "添加库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569477481375989760"),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_TMP_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_TYPE , value = "所属类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "479383892382449664"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = GoodsStockVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class , example = "服务器"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class , example = "服务器model"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CODE , value = "物品编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BAR_CODE , value = "物品条码" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BRAND_ID , value = "品牌商标" , required = false , dataTypeClass=String.class , example = "569147035945533440"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT_PRICE , value = "默认单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "台"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MIN , value = "安全库存下限" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MAX , value = "安全库存上限" , required = false , dataTypeClass=BigDecimal.class , example = "500"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_SECURITY , value = "安全库存" , required = false , dataTypeClass=BigDecimal.class , example = "200"),
		@ApiImplicitParam(name = GoodsStockVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.USE_ORG_ID , value = "使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SUPPLIER_NAME , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.GOODS_ID , value = "物品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_IN_NUMBER , value = "入库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_CUR_NUMBER , value = "当前库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.STORAGE_DATE , value = "入库时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = GoodsStockServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.INSERT)
	public Result insert(GoodsStockVO goodsStockVO) {
		Result result=goodsStockService.insert(goodsStockVO,false);
		return result;
	}



	/**
	 * 删除库存物品
	*/
	@ApiOperation(value = "删除库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569477481375989760")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = GoodsStockVOMeta.ID)
	@SentinelResource(value = GoodsStockServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=goodsStockService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除库存物品 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = GoodsStockVOMeta.IDS)
	@SentinelResource(value = GoodsStockServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=goodsStockService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新库存物品
	*/
	@ApiOperation(value = "更新库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569477481375989760"),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_TMP_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_TYPE , value = "所属类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "479383892382449664"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = GoodsStockVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class , example = "服务器"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class , example = "服务器model"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CODE , value = "物品编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BAR_CODE , value = "物品条码" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BRAND_ID , value = "品牌商标" , required = false , dataTypeClass=String.class , example = "569147035945533440"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT_PRICE , value = "默认单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "台"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MIN , value = "安全库存下限" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MAX , value = "安全库存上限" , required = false , dataTypeClass=BigDecimal.class , example = "500"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_SECURITY , value = "安全库存" , required = false , dataTypeClass=BigDecimal.class , example = "200"),
		@ApiImplicitParam(name = GoodsStockVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.USE_ORG_ID , value = "使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SUPPLIER_NAME , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.GOODS_ID , value = "物品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_IN_NUMBER , value = "入库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_CUR_NUMBER , value = "当前库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.STORAGE_DATE , value = "入库时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { GoodsStockVOMeta.PAGE_INDEX , GoodsStockVOMeta.PAGE_SIZE , GoodsStockVOMeta.SEARCH_FIELD , GoodsStockVOMeta.FUZZY_FIELD , GoodsStockVOMeta.SEARCH_VALUE , GoodsStockVOMeta.DIRTY_FIELDS , GoodsStockVOMeta.SORT_FIELD , GoodsStockVOMeta.SORT_TYPE , GoodsStockVOMeta.IDS } )
	@NotNull(name = GoodsStockVOMeta.ID)
	@SentinelResource(value = GoodsStockServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.UPDATE)
	public Result update(GoodsStockVO goodsStockVO) {
		Result result=goodsStockService.update(goodsStockVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存库存物品
	*/
	@ApiOperation(value = "保存库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569477481375989760"),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_TMP_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_TYPE , value = "所属类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "479383892382449664"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = GoodsStockVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class , example = "服务器"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class , example = "服务器model"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CODE , value = "物品编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BAR_CODE , value = "物品条码" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BRAND_ID , value = "品牌商标" , required = false , dataTypeClass=String.class , example = "569147035945533440"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT_PRICE , value = "默认单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "台"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MIN , value = "安全库存下限" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MAX , value = "安全库存上限" , required = false , dataTypeClass=BigDecimal.class , example = "500"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_SECURITY , value = "安全库存" , required = false , dataTypeClass=BigDecimal.class , example = "200"),
		@ApiImplicitParam(name = GoodsStockVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.USE_ORG_ID , value = "使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SUPPLIER_NAME , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.GOODS_ID , value = "物品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_IN_NUMBER , value = "入库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_CUR_NUMBER , value = "当前库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.STORAGE_DATE , value = "入库时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GoodsStockVOMeta.PAGE_INDEX , GoodsStockVOMeta.PAGE_SIZE , GoodsStockVOMeta.SEARCH_FIELD , GoodsStockVOMeta.FUZZY_FIELD , GoodsStockVOMeta.SEARCH_VALUE , GoodsStockVOMeta.DIRTY_FIELDS , GoodsStockVOMeta.SORT_FIELD , GoodsStockVOMeta.SORT_TYPE , GoodsStockVOMeta.IDS } )
	@NotNull(name = GoodsStockVOMeta.ID)
	@SentinelResource(value = GoodsStockServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.SAVE)
	public Result save(GoodsStockVO goodsStockVO) {
		Result result=goodsStockService.save(goodsStockVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}



	/**
	 * 获取库存物品
	*/
	@ApiOperation(value = "获取库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = GoodsStockVOMeta.ID)
	@SentinelResource(value = GoodsStockServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.GET_BY_ID)
	public Result<GoodsStock> getById(String id) {
		Result<GoodsStock> result=new Result<>();
		GoodsStock goodsStock=goodsStockService.getById(id);
		// join 关联的对象
		goodsStockService.dao().fill(goodsStock)
			.with("ownerCompany")
			.with("useOrganization")
			.with("manager")
			.with("originator")
				.with(GoodsStockMeta.CATEGORY)
			.with(GoodsStockMeta.GOODS)
			.with(GoodsStockMeta.SOURCE)
			.with(GoodsStockMeta.WAREHOUSE)
			.with(GoodsMeta.CATEGORY)
			.with(GoodsStockMeta.BRAND)
			.with(GoodsMeta.MANUFACTURER)
			.execute();
		result.success(true).data(goodsStock);
		return result;
	}


	/**
	 * 批量获取库存物品 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取库存物品")
		@ApiImplicitParams({
				@ApiImplicitParam(name = GoodsStockVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = GoodsStockVOMeta.IDS)
		@SentinelResource(value = GoodsStockServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.GET_BY_IDS)
	public Result<List<GoodsStock>> getByIds(List<String> ids) {
		Result<List<GoodsStock>> result=new Result<>();

		List<GoodsStock> list=goodsStockService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询库存物品
	*/
	@ApiOperation(value = "查询库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569477481375989760"),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_TMP_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_TYPE , value = "所属类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "479383892382449664"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = GoodsStockVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class , example = "服务器"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class , example = "服务器model"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CODE , value = "物品编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BAR_CODE , value = "物品条码" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BRAND_ID , value = "品牌商标" , required = false , dataTypeClass=String.class , example = "569147035945533440"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT_PRICE , value = "默认单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "台"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MIN , value = "安全库存下限" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MAX , value = "安全库存上限" , required = false , dataTypeClass=BigDecimal.class , example = "500"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_SECURITY , value = "安全库存" , required = false , dataTypeClass=BigDecimal.class , example = "200"),
		@ApiImplicitParam(name = GoodsStockVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.USE_ORG_ID , value = "使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SUPPLIER_NAME , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.GOODS_ID , value = "物品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_IN_NUMBER , value = "入库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_CUR_NUMBER , value = "当前库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.STORAGE_DATE , value = "入库时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GoodsStockVOMeta.PAGE_INDEX , GoodsStockVOMeta.PAGE_SIZE } )
	@SentinelResource(value = GoodsStockServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.QUERY_LIST)
	public Result<List<GoodsStock>> queryList(GoodsStockVO sample) {
		Result<List<GoodsStock>> result=new Result<>();
		List<GoodsStock> list=goodsStockService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询库存物品
	*/
	@ApiOperation(value = "分页查询库存物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsStockVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "569477481375989760"),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_TMP_ID , value = "所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWNER_TYPE , value = "所属类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "479383892382449664"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = GoodsStockVOMeta.NAME , value = "物品名称" , required = false , dataTypeClass=String.class , example = "服务器"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class , example = "服务器model"),
		@ApiImplicitParam(name = GoodsStockVOMeta.CODE , value = "物品编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BAR_CODE , value = "物品条码" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = GoodsStockVOMeta.BRAND_ID , value = "品牌商标" , required = false , dataTypeClass=String.class , example = "569147035945533440"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT_PRICE , value = "默认单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.UNIT , value = "计量单位" , required = false , dataTypeClass=String.class , example = "台"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MIN , value = "安全库存下限" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_MAX , value = "安全库存上限" , required = false , dataTypeClass=BigDecimal.class , example = "500"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_SECURITY , value = "安全库存" , required = false , dataTypeClass=BigDecimal.class , example = "200"),
		@ApiImplicitParam(name = GoodsStockVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.BATCH_CODE , value = "批次号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.USE_ORG_ID , value = "使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SUPPLIER_NAME , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.GOODS_ID , value = "物品" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_IN_NUMBER , value = "入库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.STOCK_CUR_NUMBER , value = "当前库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.AMOUNT , value = "总金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = GoodsStockVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.STORAGE_DATE , value = "入库时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsStockVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = GoodsStockServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<GoodsStock>> queryPagedList(GoodsStockVO sample) {
		Result<PagedList<GoodsStock>> result=new Result<>();
		PagedList<GoodsStock> list=goodsStockService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		goodsStockService.dao().fill(list)
			.with("ownerCompany")
			.with("useOrganization")
			.with("manager")
			.with("originator")
				.with(GoodsStockMeta.CATEGORY)
			.with(GoodsStockMeta.GOODS)
			.with(GoodsStockMeta.SOURCE)
			.with(GoodsStockMeta.WAREHOUSE)
			.with(GoodsMeta.CATEGORY)
			.with(GoodsStockMeta.BRAND)
			.with(GoodsMeta.MANUFACTURER)
			.execute();
		result.success(true).data(list);


		List<Employee> originatorList= CollectorUtil.collectList(list, GoodsStock::getOriginator);
		goodsStockService.dao().join(originatorList, Person.class);

		return result;
	}

	@ApiOperationSupport(order=9)
	@SentinelResource(value = GoodsStockServiceProxy.QUERY_PAGED_LIST_BY_SELECTED , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.QUERY_PAGED_LIST_BY_SELECTED)
	public Result<PagedList<GoodsStock>> queryPagedListBySelected(GoodsStockVO sample,String operType,String dataType) {
		Result<PagedList<GoodsStock>> result=new Result<>();

		PagedList<GoodsStock> list=goodsStockService.queryPagedListBySelected(sample,operType,dataType);
		// join 关联的对象
		goodsStockService.dao().fill(list)
				.with("ownerCompany")
				.with("useOrganization")
				.with("manager")
				.with("originator")
				.with(GoodsStockMeta.CATEGORY)
				.with(GoodsStockMeta.GOODS)
				.with(GoodsStockMeta.SOURCE)
				.with(GoodsStockMeta.WAREHOUSE)
				.with(GoodsMeta.CATEGORY)
				.with(GoodsStockMeta.BRAND)
				.with(GoodsMeta.MANUFACTURER)
				.execute();
		List<Employee> originatorList= CollectorUtil.collectList(list, GoodsStock::getOriginator);
		goodsStockService.dao().join(originatorList, Person.class);

		result.success(true).data(list);
		return result;
	}


	@ApiOperationSupport(order=9)
	@SentinelResource(value = GoodsStockServiceProxy.QUERY_PAGED_LIST_BY_SELECT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.QUERY_PAGED_LIST_BY_SELECT)
	public Result<PagedList<GoodsStock>> queryPagedListBySelect(GoodsStockVO sample,String assetSearcbContent) {
		Result<PagedList<GoodsStock>> result=new Result<>();
		PagedList<GoodsStock> list=goodsStockService.queryPagedListBySelect(sample,assetSearcbContent);
		// join 关联的对象
		goodsStockService.dao().fill(list)
				.with("ownerCompany")
				.with("useOrganization")
				.with("manager")
				.with("originator")
				.with(GoodsStockMeta.CATEGORY)
				.with(GoodsStockMeta.GOODS)
				.with(GoodsStockMeta.SOURCE)
				.with(GoodsStockMeta.WAREHOUSE)
				.with(GoodsMeta.CATEGORY)
				.with(GoodsStockMeta.BRAND)
				.with(GoodsMeta.MANUFACTURER)
				.execute();
		List<Employee> originatorList= CollectorUtil.collectList(list, GoodsStock::getOriginator);
		goodsStockService.dao().join(originatorList, Person.class);

		result.success(true).data(list);
		return result;
	}


	@ApiOperationSupport(order=5 ,  ignoreParameters = { GoodsStockVOMeta.PAGE_INDEX , GoodsStockVOMeta.PAGE_SIZE , GoodsStockVOMeta.SEARCH_FIELD , GoodsStockVOMeta.FUZZY_FIELD , GoodsStockVOMeta.SEARCH_VALUE , GoodsStockVOMeta.DIRTY_FIELDS , GoodsStockVOMeta.SORT_FIELD , GoodsStockVOMeta.SORT_TYPE , GoodsStockVOMeta.IDS } )
	@SentinelResource(value = GoodsStockServiceProxy.SAVE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.SAVE_BY_IDS)
	public Result saveByIds(List<String> ids,String selectedCode,String ownerTmpId,String ownerType,String operType) {

		for(String id:ids){
			GoodsStockVO e=new GoodsStockVO();
			e.setOwnerCode(AssetStockGoodsOwnerEnum.STOCK.code());
			e.setOwnerType(ownerType);
			if(AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_IN.code().equals(operType)||AssetOperateEnum.EAM_ASSET_STOCK_GOODS_IN.code().equals(operType)){
				//直接物品
				e.setGoodsId(id);
			}else{
				//获取的是库存数据,再次查询获取物品
				GoodsStock goods=goodsStockService.getById(id);
				if(goods!=null){
					e.setGoodsId(goods.getGoodsId());
				}
			}
			e.setRealStockId(id);
			if(!StringUtil.isBlank(ownerTmpId)){
				e.setOwnerTmpId(ownerTmpId);
			}
			e.setSelectedCode(selectedCode);
			goodsStockService.insert(e,false);

		}
		return ErrorDesc.success();
	}



	@ApiOperation(value = "组织资产数据")
	@ApiOperationSupport(order=1)
	@SentinelResource(value = GoodsStockServiceProxy.QUERY_GOODS_STOCK_REAL_ALL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsStockServiceProxy.QUERY_GOODS_STOCK_REAL_ALL)
	public Result queryGoodsStockRealAll(GoodsStockVO goodsStockVO) {

		Result<PagedList<GoodsStock>> result=new Result<>();
		PagedList<GoodsStock> list= goodsStockService.queryGoodsStockRealAll(goodsStockVO);
		// join 关联的对象
		goodsStockService.dao().fill(list)
				.with("ownerCompany")
				.with("useOrganization")
				.with("manager")
				.with("originator")
				.with(GoodsStockMeta.CATEGORY)
				.with(GoodsStockMeta.GOODS)
				.with(GoodsStockMeta.SOURCE)
				.with(GoodsStockMeta.WAREHOUSE)
				.with(GoodsMeta.CATEGORY)
				.with(GoodsStockMeta.BRAND)
				.with(GoodsMeta.MANUFACTURER)
				.execute();
		result.success(true).data(list);
		return result;
	}


	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = GoodsStockServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GoodsStockServiceProxy.EXPORT_EXCEL)
	public void exportExcel(GoodsStockVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=goodsStockService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = GoodsStockServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GoodsStockServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=goodsStockService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}




	@SentinelResource(value = GoodsStockServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GoodsStockServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=goodsStockService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}