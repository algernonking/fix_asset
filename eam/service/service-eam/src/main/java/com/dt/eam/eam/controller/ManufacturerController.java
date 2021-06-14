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


import com.dt.eam.proxy.eam.ManufacturerServiceProxy;
import com.dt.eam.domain.eam.meta.ManufacturerVOMeta;
import com.dt.eam.domain.eam.Manufacturer;
import com.dt.eam.domain.eam.ManufacturerVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.eam.eam.service.IManufacturerService;
import com.github.foxnic.springboot.api.annotations.NotNull;

/**
 * <p>
 * 生产厂商 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-06-12 14:21:18
*/

@Api(tags = "生产厂商")
@ApiSort(0)
@RestController("EamManufacturerController")
public class ManufacturerController {

	@Autowired
	private IManufacturerService manufacturerService;

	
	/**
	 * 添加生产厂商
	*/
	@ApiOperation(value = "添加生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ManufacturerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ManufacturerVOMeta.ID)
	@SentinelResource(value = ManufacturerServiceProxy.INSERT)
	@PostMapping(ManufacturerServiceProxy.INSERT)
	public Result<Manufacturer> insert(ManufacturerVO manufacturerVO) {
		Result<Manufacturer> result=new Result<>();
		boolean suc=manufacturerService.insert(manufacturerVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除生产厂商
	*/
	@ApiOperation(value = "删除生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ManufacturerVOMeta.ID)
	@SentinelResource(value = ManufacturerServiceProxy.DELETE)
	@PostMapping(ManufacturerServiceProxy.DELETE)
	public Result<Manufacturer> deleteById(String id) {
		Result<Manufacturer> result=new Result<>();
		boolean suc=manufacturerService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除生产厂商 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ManufacturerVOMeta.IDS)
	@SentinelResource(value = ManufacturerServiceProxy.BATCH_DELETE)
	@PostMapping(ManufacturerServiceProxy.BATCH_DELETE)
	public Result<Manufacturer> deleteByIds(List<String> ids) {
		Result<Manufacturer> result=new Result<>();
		boolean suc=manufacturerService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新生产厂商
	*/
	@ApiOperation(value = "更新生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ManufacturerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ManufacturerVOMeta.PAGE_INDEX , ManufacturerVOMeta.PAGE_SIZE , ManufacturerVOMeta.SEARCH_FIELD , ManufacturerVOMeta.SEARCH_VALUE , ManufacturerVOMeta.IDS } ) 
	@NotNull(name = ManufacturerVOMeta.ID)
	@SentinelResource(value = ManufacturerServiceProxy.UPDATE)
	@PostMapping(ManufacturerServiceProxy.UPDATE)
	public Result<Manufacturer> update(ManufacturerVO manufacturerVO) {
		Result<Manufacturer> result=new Result<>();
		boolean suc=manufacturerService.update(manufacturerVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存生产厂商
	*/
	@ApiOperation(value = "保存生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ManufacturerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ManufacturerVOMeta.PAGE_INDEX , ManufacturerVOMeta.PAGE_SIZE , ManufacturerVOMeta.SEARCH_FIELD , ManufacturerVOMeta.SEARCH_VALUE , ManufacturerVOMeta.IDS } )
	@NotNull(name = ManufacturerVOMeta.ID)
	@SentinelResource(value = ManufacturerServiceProxy.SAVE)
	@PostMapping(ManufacturerServiceProxy.SAVE)
	public Result<Manufacturer> save(ManufacturerVO manufacturerVO) {
		Result<Manufacturer> result=new Result<>();
		boolean suc=manufacturerService.save(manufacturerVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取生产厂商
	*/
	@ApiOperation(value = "获取生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ManufacturerVOMeta.ID)
	@SentinelResource(value = ManufacturerServiceProxy.GET_BY_ID)
	@PostMapping(ManufacturerServiceProxy.GET_BY_ID)
	public Result<Manufacturer> getById(String id) {
		Result<Manufacturer> result=new Result<>();
		Manufacturer role=manufacturerService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询生产厂商
	*/
	@ApiOperation(value = "查询生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ManufacturerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ManufacturerVOMeta.PAGE_INDEX , ManufacturerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ManufacturerServiceProxy.QUERY_LIST)
	@PostMapping(ManufacturerServiceProxy.QUERY_LIST)
	public Result<List<Manufacturer>> queryList(ManufacturerVO sample) {
		Result<List<Manufacturer>> result=new Result<>();
		List<Manufacturer> list=manufacturerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询生产厂商
	*/
	@ApiOperation(value = "分页查询生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ManufacturerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ManufacturerServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(ManufacturerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Manufacturer>> queryPagedList(ManufacturerVO sample) {
		Result<PagedList<Manufacturer>> result=new Result<>();
		PagedList<Manufacturer> list=manufacturerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}