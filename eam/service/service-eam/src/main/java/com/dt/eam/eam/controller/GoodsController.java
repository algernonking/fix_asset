package com.dt.eam.eam.controller;

 
import java.util.List;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;


import com.dt.eam.proxy.eam.GoodsServiceProxy;
import com.dt.eam.domain.eam.meta.GoodsVOMeta;
import com.dt.eam.domain.eam.Goods;
import com.dt.eam.domain.eam.GoodsVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.eam.eam.service.IGoodsService;
import com.github.foxnic.springboot.api.annotations.NotNull;

/**
 * <p>
 * 资产物品表 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-06-12 11:21:24
*/

@Api(tags = "资产物品")
@ApiSort(0)
@RestController("EamGoodsController")
public class GoodsController {

	@Autowired
	private IGoodsService goodsService;

	
	/**
	 * 添加资产物品
	*/
	@ApiOperation(value = "添加资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CATEGORY_ID , value = "分类ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.BRAND_ID , value = "品牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = GoodsVOMeta.ID)
	@SentinelResource(value = GoodsServiceProxy.INSERT)
	@PostMapping(GoodsServiceProxy.INSERT)
	public Result<Goods> insert(GoodsVO goodsVO) {
		Result<Goods> result=new Result<>();
		boolean suc=goodsService.insert(goodsVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除资产物品
	*/
	@ApiOperation(value = "删除资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = GoodsVOMeta.ID)
	@SentinelResource(value = GoodsServiceProxy.DELETE)
	@PostMapping(GoodsServiceProxy.DELETE)
	public Result<Goods> deleteById(String id) {
		Result<Goods> result=new Result<>();
		boolean suc=goodsService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除资产物品 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = GoodsVOMeta.IDS)
	@SentinelResource(value = GoodsServiceProxy.BATCH_DELETE)
	@PostMapping(GoodsServiceProxy.BATCH_DELETE)
	public Result<Goods> deleteByIds(List<String> ids) {
		Result<Goods> result=new Result<>();
		boolean suc=goodsService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新资产物品
	*/
	@ApiOperation(value = "更新资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CATEGORY_ID , value = "分类ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.BRAND_ID , value = "品牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE , GoodsVOMeta.SEARCH_FIELD , GoodsVOMeta.SEARCH_VALUE , GoodsVOMeta.IDS } ) 
	@NotNull(name = GoodsVOMeta.ID)
	@SentinelResource(value = GoodsServiceProxy.UPDATE)
	@PostMapping(GoodsServiceProxy.UPDATE)
	public Result<Goods> update(GoodsVO goodsVO) {
		Result<Goods> result=new Result<>();
		boolean suc=goodsService.update(goodsVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存资产物品
	*/
	@ApiOperation(value = "保存资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CATEGORY_ID , value = "分类ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.BRAND_ID , value = "品牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE , GoodsVOMeta.SEARCH_FIELD , GoodsVOMeta.SEARCH_VALUE , GoodsVOMeta.IDS } )
	@NotNull(name = GoodsVOMeta.ID)
	@SentinelResource(value = GoodsServiceProxy.SAVE)
	@PostMapping(GoodsServiceProxy.SAVE)
	public Result<Goods> save(GoodsVO goodsVO) {
		Result<Goods> result=new Result<>();
		boolean suc=goodsService.save(goodsVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取资产物品
	*/
	@ApiOperation(value = "获取资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = GoodsVOMeta.ID)
	@SentinelResource(value = GoodsServiceProxy.GET_BY_ID)
	@PostMapping(GoodsServiceProxy.GET_BY_ID)
	public Result<Goods> getById(String id) {
		Result<Goods> result=new Result<>();
		Goods role=goodsService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询资产物品
	*/
	@ApiOperation(value = "查询资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CATEGORY_ID , value = "分类ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.BRAND_ID , value = "品牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE } )
	@SentinelResource(value = GoodsServiceProxy.QUERY_LIST)
	@PostMapping(GoodsServiceProxy.QUERY_LIST)
	public Result<List<Goods>> queryList(GoodsVO sample) {
		Result<List<Goods>> result=new Result<>();
		List<Goods> list=goodsService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产物品
	*/
	@ApiOperation(value = "分页查询资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CATEGORY_ID , value = "分类ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.PICTURE_ID , value = "物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MANUFACTURER_ID , value = "厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.BRAND_ID , value = "品牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.MODEL , value = "规格型号" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = GoodsServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(GoodsServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Goods>> queryPagedList(GoodsVO sample) {
		Result<PagedList<Goods>> result=new Result<>();
		PagedList<Goods> list=goodsService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}