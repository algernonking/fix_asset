package com.dt.eam.hrm.controller;

 
import java.util.List;

import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.springboot.mvc.Result;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;


import com.dt.eam.proxy.hrm.CompanyServiceProxy;
import com.dt.eam.domain.hrm.meta.CompanyVOMeta;
import com.dt.eam.domain.hrm.Company;
import com.dt.eam.domain.hrm.CompanyVO;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.eam.hrm.service.ICompanyService;
import com.github.foxnic.springboot.api.annotations.NotNull;

/**
 * <p>
 * 公司表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-10 13:27:47
*/

@Api(tags = "公司")
@ApiSort(0)
@RestController("HrmCompanyController")
public class CompanyController {

	@Autowired
	private ICompanyService companyService;

	
	/**
	 * 添加公司
	*/
	@ApiOperation(value = "添加公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.SOCIAL_CREDIT_CODE , value = "社会信用代码" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = CompanyVOMeta.ID)
	@SentinelResource(value = CompanyServiceProxy.INSERT)
	@PostMapping(CompanyServiceProxy.INSERT)
	public Result<Company> insert(CompanyVO companyVO) {
		Result<Company> result=new Result<>();
		boolean suc=companyService.insert(companyVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除公司
	*/
	@ApiOperation(value = "删除公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CompanyVOMeta.ID)
	@SentinelResource(value = CompanyServiceProxy.DELETE)
	@PostMapping(CompanyServiceProxy.DELETE)
	public Result<Company> deleteById(String id) {
		Result<Company> result=new Result<>();
		boolean suc=companyService.deleteByIdLogical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除公司 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CompanyVOMeta.IDS)
	@SentinelResource(value = CompanyServiceProxy.BATCH_DELETE)
	@PostMapping(CompanyServiceProxy.BATCH_DELETE)
	public Result<Company> deleteByIds(List<String> ids) {
		Result<Company> result=new Result<>();
		boolean suc=companyService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新公司
	*/
	@ApiOperation(value = "更新公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.SOCIAL_CREDIT_CODE , value = "社会信用代码" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE , CompanyVOMeta.SEARCH_FIELD , CompanyVOMeta.SEARCH_VALUE , CompanyVOMeta.IDS } ) 
	@NotNull(name = CompanyVOMeta.ID)
	@SentinelResource(value = CompanyServiceProxy.UPDATE)
	@PostMapping(CompanyServiceProxy.UPDATE)
	public Result<Company> update(CompanyVO companyVO) {
		Result<Company> result=new Result<>();
		boolean suc=companyService.update(companyVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存公司
	*/
	@ApiOperation(value = "保存公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.SOCIAL_CREDIT_CODE , value = "社会信用代码" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE , CompanyVOMeta.SEARCH_FIELD , CompanyVOMeta.SEARCH_VALUE , CompanyVOMeta.IDS } )
	@NotNull(name = CompanyVOMeta.ID)
	@SentinelResource(value = CompanyServiceProxy.SAVE)
	@PostMapping(CompanyServiceProxy.SAVE)
	public Result<Company> save(CompanyVO companyVO) {
		Result<Company> result=new Result<>();
		boolean suc=companyService.save(companyVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取公司
	*/
	@ApiOperation(value = "获取公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CompanyVOMeta.ID)
	@SentinelResource(value = CompanyServiceProxy.GET_BY_ID)
	@PostMapping(CompanyServiceProxy.GET_BY_ID)
	public Result<Company> getById(String id) {
		Result<Company> result=new Result<>();
		Company role=companyService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询公司
	*/
	@ApiOperation(value = "查询公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.SOCIAL_CREDIT_CODE , value = "社会信用代码" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CompanyServiceProxy.QUERY_LIST)
	@PostMapping(CompanyServiceProxy.QUERY_LIST)
	public Result<List<Company>> queryList(CompanyVO sample) {
		Result<List<Company>> result=new Result<>();
		List<Company> list=companyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询公司
	*/
	@ApiOperation(value = "分页查询公司")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "公司名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.SOCIAL_CREDIT_CODE , value = "社会信用代码" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CompanyServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(CompanyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Company>> queryPagedList(CompanyVO sample) {
		Result<PagedList<Company>> result=new Result<>();
		PagedList<Company> list=companyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}