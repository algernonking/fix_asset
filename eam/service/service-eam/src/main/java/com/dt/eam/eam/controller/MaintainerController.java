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


import com.dt.eam.proxy.eam.MaintainerServiceProxy;
import com.dt.eam.domain.eam.meta.MaintainerVOMeta;
import com.dt.eam.domain.eam.Maintainer;
import com.dt.eam.domain.eam.MaintainerVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.eam.eam.service.IMaintainerService;
import com.github.foxnic.springboot.api.annotations.NotNull;

/**
 * <p>
 * 维保厂商 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-06-12 14:21:18
*/

@Api(tags = "维保厂商")
@ApiSort(0)
@RestController("EamMaintainerController")
public class MaintainerController {

	@Autowired
	private IMaintainerService maintainerService;

	
	/**
	 * 添加维保厂商
	*/
	@ApiOperation(value = "添加维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = MaintainerVOMeta.ID)
	@SentinelResource(value = MaintainerServiceProxy.INSERT)
	@PostMapping(MaintainerServiceProxy.INSERT)
	public Result<Maintainer> insert(MaintainerVO maintainerVO) {
		Result<Maintainer> result=new Result<>();
		boolean suc=maintainerService.insert(maintainerVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除维保厂商
	*/
	@ApiOperation(value = "删除维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MaintainerVOMeta.ID)
	@SentinelResource(value = MaintainerServiceProxy.DELETE)
	@PostMapping(MaintainerServiceProxy.DELETE)
	public Result<Maintainer> deleteById(String id) {
		Result<Maintainer> result=new Result<>();
		boolean suc=maintainerService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除维保厂商 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MaintainerVOMeta.IDS)
	@SentinelResource(value = MaintainerServiceProxy.BATCH_DELETE)
	@PostMapping(MaintainerServiceProxy.BATCH_DELETE)
	public Result<Maintainer> deleteByIds(List<String> ids) {
		Result<Maintainer> result=new Result<>();
		boolean suc=maintainerService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新维保厂商
	*/
	@ApiOperation(value = "更新维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MaintainerVOMeta.PAGE_INDEX , MaintainerVOMeta.PAGE_SIZE , MaintainerVOMeta.SEARCH_FIELD , MaintainerVOMeta.SEARCH_VALUE , MaintainerVOMeta.IDS } ) 
	@NotNull(name = MaintainerVOMeta.ID)
	@SentinelResource(value = MaintainerServiceProxy.UPDATE)
	@PostMapping(MaintainerServiceProxy.UPDATE)
	public Result<Maintainer> update(MaintainerVO maintainerVO) {
		Result<Maintainer> result=new Result<>();
		boolean suc=maintainerService.update(maintainerVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存维保厂商
	*/
	@ApiOperation(value = "保存维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainerVOMeta.PAGE_INDEX , MaintainerVOMeta.PAGE_SIZE , MaintainerVOMeta.SEARCH_FIELD , MaintainerVOMeta.SEARCH_VALUE , MaintainerVOMeta.IDS } )
	@NotNull(name = MaintainerVOMeta.ID)
	@SentinelResource(value = MaintainerServiceProxy.SAVE)
	@PostMapping(MaintainerServiceProxy.SAVE)
	public Result<Maintainer> save(MaintainerVO maintainerVO) {
		Result<Maintainer> result=new Result<>();
		boolean suc=maintainerService.save(maintainerVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取维保厂商
	*/
	@ApiOperation(value = "获取维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MaintainerVOMeta.ID)
	@SentinelResource(value = MaintainerServiceProxy.GET_BY_ID)
	@PostMapping(MaintainerServiceProxy.GET_BY_ID)
	public Result<Maintainer> getById(String id) {
		Result<Maintainer> result=new Result<>();
		Maintainer role=maintainerService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询维保厂商
	*/
	@ApiOperation(value = "查询维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainerVOMeta.PAGE_INDEX , MaintainerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaintainerServiceProxy.QUERY_LIST)
	@PostMapping(MaintainerServiceProxy.QUERY_LIST)
	public Result<List<Maintainer>> queryList(MaintainerVO sample) {
		Result<List<Maintainer>> result=new Result<>();
		List<Maintainer> list=maintainerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询维保厂商
	*/
	@ApiOperation(value = "分页查询维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MaintainerServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(MaintainerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Maintainer>> queryPagedList(MaintainerVO sample) {
		Result<PagedList<Maintainer>> result=new Result<>();
		PagedList<Maintainer> list=maintainerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}