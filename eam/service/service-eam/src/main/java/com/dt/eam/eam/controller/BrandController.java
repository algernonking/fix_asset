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


import com.dt.eam.proxy.eam.BrandServiceProxy;
import com.dt.eam.domain.eam.meta.BrandVOMeta;
import com.dt.eam.domain.eam.Brand;
import com.dt.eam.domain.eam.BrandVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.eam.eam.service.IBrandService;
import com.github.foxnic.springboot.api.annotations.NotNull;

/**
 * <p>
 * 品牌表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-10 14:30:18
*/

@Api(tags = "品牌")
@ApiSort(0)
@RestController("EamBrandController")
public class BrandController {

	@Autowired
	private IBrandService brandService;

	
	/**
	 * 添加品牌
	*/
	@ApiOperation(value = "添加品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NK"),
		@ApiImplicitParam(name = BrandVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "诺基亚"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = BrandVOMeta.ID)
	@SentinelResource(value = BrandServiceProxy.INSERT)
	@PostMapping(BrandServiceProxy.INSERT)
	public Result<Brand> insert(BrandVO brandVO) {
		Result<Brand> result=new Result<>();
		boolean suc=brandService.insert(brandVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除品牌
	*/
	@ApiOperation(value = "删除品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NK")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = BrandVOMeta.ID)
	@SentinelResource(value = BrandServiceProxy.DELETE)
	@PostMapping(BrandServiceProxy.DELETE)
	public Result<Brand> deleteById(String id) {
		Result<Brand> result=new Result<>();
		boolean suc=brandService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除品牌 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = BrandVOMeta.IDS)
	@SentinelResource(value = BrandServiceProxy.BATCH_DELETE)
	@PostMapping(BrandServiceProxy.BATCH_DELETE)
	public Result<Brand> deleteByIds(List<String> ids) {
		Result<Brand> result=new Result<>();
		boolean suc=brandService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新品牌
	*/
	@ApiOperation(value = "更新品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NK"),
		@ApiImplicitParam(name = BrandVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "诺基亚"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { BrandVOMeta.PAGE_INDEX , BrandVOMeta.PAGE_SIZE , BrandVOMeta.SEARCH_FIELD , BrandVOMeta.SEARCH_VALUE , BrandVOMeta.IDS } ) 
	@NotNull(name = BrandVOMeta.ID)
	@SentinelResource(value = BrandServiceProxy.UPDATE)
	@PostMapping(BrandServiceProxy.UPDATE)
	public Result<Brand> update(BrandVO brandVO) {
		Result<Brand> result=new Result<>();
		boolean suc=brandService.update(brandVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存品牌
	*/
	@ApiOperation(value = "保存品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NK"),
		@ApiImplicitParam(name = BrandVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "诺基亚"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BrandVOMeta.PAGE_INDEX , BrandVOMeta.PAGE_SIZE , BrandVOMeta.SEARCH_FIELD , BrandVOMeta.SEARCH_VALUE , BrandVOMeta.IDS } )
	@NotNull(name = BrandVOMeta.ID)
	@SentinelResource(value = BrandServiceProxy.SAVE)
	@PostMapping(BrandServiceProxy.SAVE)
	public Result<Brand> save(BrandVO brandVO) {
		Result<Brand> result=new Result<>();
		boolean suc=brandService.save(brandVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取品牌
	*/
	@ApiOperation(value = "获取品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = BrandVOMeta.ID)
	@SentinelResource(value = BrandServiceProxy.GET_BY_ID)
	@PostMapping(BrandServiceProxy.GET_BY_ID)
	public Result<Brand> getById(String id) {
		Result<Brand> result=new Result<>();
		Brand role=brandService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询品牌
	*/
	@ApiOperation(value = "查询品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NK"),
		@ApiImplicitParam(name = BrandVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "诺基亚"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BrandVOMeta.PAGE_INDEX , BrandVOMeta.PAGE_SIZE } )
	@SentinelResource(value = BrandServiceProxy.QUERY_LIST)
	@PostMapping(BrandServiceProxy.QUERY_LIST)
	public Result<List<Brand>> queryList(BrandVO sample) {
		Result<List<Brand>> result=new Result<>();
		List<Brand> list=brandService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询品牌
	*/
	@ApiOperation(value = "分页查询品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "NK"),
		@ApiImplicitParam(name = BrandVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "诺基亚"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = BrandServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(BrandServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Brand>> queryPagedList(BrandVO sample) {
		Result<PagedList<Brand>> result=new Result<>();
		PagedList<Brand> list=brandService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}