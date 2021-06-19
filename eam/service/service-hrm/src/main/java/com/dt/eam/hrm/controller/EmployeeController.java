package com.dt.eam.hrm.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.eam.domain.hrm.Employee;
import com.dt.eam.domain.hrm.EmployeeVO;
import com.dt.eam.domain.hrm.meta.EmployeeVOMeta;
import com.dt.eam.hrm.service.IEmployeeService;
import com.dt.eam.proxy.hrm.EmployeeServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 员工表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-10 13:23:34
*/

@Api(tags = "员工")
@ApiSort(0)
@RestController("HrmEmployeeController")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	
	/**
	 * 添加员工
	*/
	@ApiOperation(value = "添加员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = EmployeeVOMeta.ID)
	@SentinelResource(value = EmployeeServiceProxy.INSERT)
	@PostMapping(EmployeeServiceProxy.INSERT)
	public Result<Employee> insert(EmployeeVO employeeVO) {
		Result<Employee> result=new Result<>();
		boolean suc=employeeService.insert(employeeVO);
		result.success(suc);
		return result;
	}

	
	/**
	 * 删除员工
	*/
	@ApiOperation(value = "删除员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = EmployeeVOMeta.ID)
	@SentinelResource(value = EmployeeServiceProxy.DELETE)
	@PostMapping(EmployeeServiceProxy.DELETE)
	public Result<Employee> deleteById(String id) {
		Result<Employee> result=new Result<>();
		boolean suc=employeeService.deleteByIdPhysical(id);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 批量删除员工 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = EmployeeVOMeta.IDS)
	@SentinelResource(value = EmployeeServiceProxy.BATCH_DELETE)
	@PostMapping(EmployeeServiceProxy.BATCH_DELETE)
	public Result<Employee> deleteByIds(List<String> ids) {
		Result<Employee> result=new Result<>();
		boolean suc=employeeService.deleteByIdsLogical(ids);
		result.success(suc);
		return result;
	}
	
	/**
	 * 更新员工
	*/
	@ApiOperation(value = "更新员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { EmployeeVOMeta.PAGE_INDEX , EmployeeVOMeta.PAGE_SIZE , EmployeeVOMeta.SEARCH_FIELD , EmployeeVOMeta.SEARCH_VALUE , EmployeeVOMeta.IDS } ) 
	@NotNull(name = EmployeeVOMeta.ID)
	@SentinelResource(value = EmployeeServiceProxy.UPDATE)
	@PostMapping(EmployeeServiceProxy.UPDATE)
	public Result<Employee> update(EmployeeVO employeeVO) {
		Result<Employee> result=new Result<>();
		boolean suc=employeeService.update(employeeVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}
	
	
	/**
	 * 保存员工
	*/
	@ApiOperation(value = "保存员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { EmployeeVOMeta.PAGE_INDEX , EmployeeVOMeta.PAGE_SIZE , EmployeeVOMeta.SEARCH_FIELD , EmployeeVOMeta.SEARCH_VALUE , EmployeeVOMeta.IDS } )
	@NotNull(name = EmployeeVOMeta.ID)
	@SentinelResource(value = EmployeeServiceProxy.SAVE)
	@PostMapping(EmployeeServiceProxy.SAVE)
	public Result<Employee> save(EmployeeVO employeeVO) {
		Result<Employee> result=new Result<>();
		boolean suc=employeeService.save(employeeVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		return result;
	}

	
	/**
	 * 获取员工
	*/
	@ApiOperation(value = "获取员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = EmployeeVOMeta.ID)
	@SentinelResource(value = EmployeeServiceProxy.GET_BY_ID)
	@PostMapping(EmployeeServiceProxy.GET_BY_ID)
	public Result<Employee> getById(String id) {
		Result<Employee> result=new Result<>();
		Employee role=employeeService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询员工
	*/
	@ApiOperation(value = "查询员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { EmployeeVOMeta.PAGE_INDEX , EmployeeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = EmployeeServiceProxy.QUERY_LIST)
	@PostMapping(EmployeeServiceProxy.QUERY_LIST)
	public Result<List<Employee>> queryList(EmployeeVO sample) {
		Result<List<Employee>> result=new Result<>();
		List<Employee> list=employeeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询员工
	*/
	@ApiOperation(value = "分页查询员工")
	@ApiImplicitParams({
		@ApiImplicitParam(name = EmployeeVOMeta.ID , value = "ID" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = EmployeeServiceProxy.QUERY_PAGED_LIST)
	@PostMapping(EmployeeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Employee>> queryPagedList(EmployeeVO sample) {
		Result<PagedList<Employee>> result=new Result<>();
		PagedList<Employee> list=employeeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


}