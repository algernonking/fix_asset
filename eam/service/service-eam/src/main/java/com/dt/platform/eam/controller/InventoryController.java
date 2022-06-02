package com.dt.platform.eam.controller;


import java.util.ArrayList;
import java.util.List;

import com.dt.platform.domain.eam.*;
import com.dt.platform.eam.service.IAssetService;
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


import com.dt.platform.proxy.eam.InventoryServiceProxy;
import com.dt.platform.domain.eam.meta.InventoryVOMeta;
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
import com.dt.platform.domain.eam.meta.InventoryMeta;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInventoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产盘点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-20 13:23:35
*/

@Api(tags = "资产盘点")
@ApiSort(0)
@RestController("EamInventoryController")
public class InventoryController extends SuperController {

	@Autowired
	private IInventoryService inventoryService;

	@Autowired
	private IAssetService assetService;
	/**
	 * 添加资产盘点
	*/
	@ApiOperation(value = "添加资产盘点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "514089040971042816"),
		@ApiImplicitParam(name = InventoryVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_CODE , value = "业务编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWNER_CODE , value = "所属" , required = false , dataTypeClass=String.class , example = "inventory"),
		@ApiImplicitParam(name = InventoryVOMeta.STATUS , value = "业务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.NAME , value = "盘点名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_STATUS , value = "盘点状态" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.DATA_STATUS , value = "数据状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.ALL_EMPLOYEE , value = "全员盘点" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = InventoryVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_START_DATE , value = "购置开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_END_DATE , value = "购置结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.START_TIME , value = "盘点开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.FINISH_TIME , value = "盘点结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PLAN_ID , value = "计划编号" , required = false , dataTypeClass=String.class),

	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InventoryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.INSERT)
	public Result insert(InventoryVO inventoryVO) {
		Result result=inventoryService.insert(inventoryVO,false);
		return result;
	}



	/**
	 * 删除资产盘点
	*/
	@ApiOperation(value = "删除资产盘点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "514089040971042816"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InventoryVOMeta.ID)
	@SentinelResource(value = InventoryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inventoryService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产盘点 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产盘点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InventoryVOMeta.IDS)
	@SentinelResource(value = InventoryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inventoryService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新资产盘点
	*/
	@ApiOperation(value = "更新资产盘点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "514089040971042816"),
		@ApiImplicitParam(name = InventoryVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_CODE , value = "业务编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWNER_CODE , value = "所属" , required = false , dataTypeClass=String.class , example = "inventory"),
		@ApiImplicitParam(name = InventoryVOMeta.STATUS , value = "业务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.NAME , value = "盘点名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_STATUS , value = "盘点状态" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.DATA_STATUS , value = "数据状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.ALL_EMPLOYEE , value = "全员盘点" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = InventoryVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_START_DATE , value = "购置开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_END_DATE , value = "购置结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.START_TIME , value = "盘点开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.FINISH_TIME , value = "盘点结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PLAN_ID , value = "计划编号" , required = false , dataTypeClass=String.class),

	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InventoryVOMeta.PAGE_INDEX , InventoryVOMeta.PAGE_SIZE , InventoryVOMeta.SEARCH_FIELD , InventoryVOMeta.FUZZY_FIELD , InventoryVOMeta.SEARCH_VALUE , InventoryVOMeta.DIRTY_FIELDS , InventoryVOMeta.SORT_FIELD , InventoryVOMeta.SORT_TYPE , InventoryVOMeta.IDS } )
	@NotNull(name = InventoryVOMeta.ID)
	@SentinelResource(value = InventoryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.UPDATE)
	public Result update(InventoryVO inventoryVO) {
		Result result=inventoryService.update(inventoryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存资产盘点
	*/
	@ApiOperation(value = "保存资产盘点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "514089040971042816"),
		@ApiImplicitParam(name = InventoryVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_CODE , value = "业务编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWNER_CODE , value = "所属" , required = false , dataTypeClass=String.class , example = "inventory"),
		@ApiImplicitParam(name = InventoryVOMeta.STATUS , value = "业务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.NAME , value = "盘点名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_STATUS , value = "盘点状态" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.DATA_STATUS , value = "数据状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.ALL_EMPLOYEE , value = "全员盘点" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = InventoryVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_START_DATE , value = "购置开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_END_DATE , value = "购置结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.START_TIME , value = "盘点开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.FINISH_TIME , value = "盘点结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PLAN_ID , value = "计划编号" , required = false , dataTypeClass=String.class),

	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryVOMeta.PAGE_INDEX , InventoryVOMeta.PAGE_SIZE , InventoryVOMeta.SEARCH_FIELD , InventoryVOMeta.FUZZY_FIELD , InventoryVOMeta.SEARCH_VALUE , InventoryVOMeta.DIRTY_FIELDS , InventoryVOMeta.SORT_FIELD , InventoryVOMeta.SORT_TYPE , InventoryVOMeta.IDS } )
	@NotNull(name = InventoryVOMeta.ID)
	@SentinelResource(value = InventoryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.SAVE)
	public Result save(InventoryVO inventoryVO) {
		Result result=inventoryService.save(inventoryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取资产盘点
	*/
	@ApiOperation(value = "获取资产盘点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InventoryVOMeta.ID)
	@SentinelResource(value = InventoryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.GET_BY_ID)
	public Result<Inventory> getById(String id) {
		Result<Inventory> result=new Result<>();
		Inventory inventory=inventoryService.getById(id);
		// join 关联的对象
		inventoryService.dao().fill(inventory)
			.with(InventoryMeta.INVENTORY_ASSET_INFO_LIST)
			.with(InventoryMeta.MANAGER)
			.with(InventoryMeta.ORIGINATOR)
			.with(InventoryMeta.DIRECTOR)
			.with(InventoryMeta.INVENTORY_USER)
			.with(InventoryMeta.CATEGORY)
			.with(InventoryMeta.WAREHOUSE)
			.with(InventoryMeta.POSITION)
			.execute();

		inventoryService.dao().join(inventory.getDirector(), Person.class);
		inventoryService.dao().join(inventory.getManager(), Person.class);
		inventoryService.dao().join(inventory.getOriginator(), Person.class);
		inventoryService.dao().join(inventory.getInventoryUser(), Person.class);

		result.success(true).data(inventory);
		return result;
	}


	/**
	 * 批量获取资产盘点 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产盘点")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InventoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InventoryVOMeta.IDS)
		@SentinelResource(value = InventoryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.GET_BY_IDS)
	public Result<List<Inventory>> getByIds(List<String> ids) {
		Result<List<Inventory>> result=new Result<>();
		List<Inventory> list=inventoryService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产盘点
	*/
	@ApiOperation(value = "查询资产盘点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "514089040971042816"),
		@ApiImplicitParam(name = InventoryVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_CODE , value = "业务编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWNER_CODE , value = "所属" , required = false , dataTypeClass=String.class , example = "inventory"),
		@ApiImplicitParam(name = InventoryVOMeta.STATUS , value = "业务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.NAME , value = "盘点名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_STATUS , value = "盘点状态" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.DATA_STATUS , value = "数据状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.ALL_EMPLOYEE , value = "全员盘点" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = InventoryVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_START_DATE , value = "购置开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_END_DATE , value = "购置结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.START_TIME , value = "盘点开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.FINISH_TIME , value = "盘点结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PLAN_ID , value = "计划编号" , required = false , dataTypeClass=String.class),

	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryVOMeta.PAGE_INDEX , InventoryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InventoryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.QUERY_LIST)
	public Result<List<Inventory>> queryList(InventoryVO sample) {
		Result<List<Inventory>> result=new Result<>();
		List<Inventory> list=inventoryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产盘点
	*/
	@ApiOperation(value = "分页查询资产盘点")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "514089040971042816"),
		@ApiImplicitParam(name = InventoryVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_CODE , value = "业务编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWNER_CODE , value = "所属" , required = false , dataTypeClass=String.class , example = "inventory"),
		@ApiImplicitParam(name = InventoryVOMeta.STATUS , value = "业务状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.NAME , value = "盘点名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_STATUS , value = "盘点状态" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.DATA_STATUS , value = "数据状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.ALL_EMPLOYEE , value = "全员盘点" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = InventoryVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_START_DATE , value = "购置开始日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_END_DATE , value = "购置结束日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.START_TIME , value = "盘点开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.FINISH_TIME , value = "盘点结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PLAN_ID , value = "计划编号" , required = false , dataTypeClass=String.class),

	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InventoryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Inventory>> queryPagedList(InventoryVO sample) {
		Result<PagedList<Inventory>> result=new Result<>();



		PagedList<Inventory> list=inventoryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		inventoryService.dao().fill(list)
			.with(InventoryMeta.INVENTORY_ASSET_INFO_LIST)
			.with(InventoryMeta.MANAGER)
			.with(InventoryMeta.ORIGINATOR)
			.with(InventoryMeta.INVENTORY_USER)
			.with(InventoryMeta.DIRECTOR)
			.with(InventoryMeta.CATEGORY)
			.with(InventoryMeta.WAREHOUSE)
			.with(InventoryMeta.POSITION)
			.execute();



		List<List<Employee>> managerList= CollectorUtil.collectList(list.getList(), Inventory::getManager);
		List<Employee> managers=managerList.stream().collect(ArrayList::new,ArrayList::addAll,ArrayList::addAll);
		inventoryService.dao().join(managers, Person.class);

		List<Employee> originator= CollectorUtil.collectList(list.getList(),Inventory::getOriginator);
		inventoryService.dao().join(originator, Person.class);

		List<List<Employee>> usersList= CollectorUtil.collectList(list.getList(), Inventory::getInventoryUser);
		List<Employee> users=usersList.stream().collect(ArrayList::new,ArrayList::addAll,ArrayList::addAll);
		inventoryService.dao().join(users, Person.class);

		List<List<Employee>> directorList= CollectorUtil.collectList(list.getList(), Inventory::getDirector);
		List<Employee> directors=directorList.stream().collect(ArrayList::new,ArrayList::addAll,ArrayList::addAll);
		inventoryService.dao().join(directors, Person.class);

		result.success(true).data(list);
		return result;
	}



	/**
	 *	盘点开始
	 */
	@ApiOperation(value = "盘点开始")
	@ApiImplicitParams({
			@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=9)
	@SentinelResource(value = InventoryServiceProxy.START, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.START)
	public Result start(String id) {
		Result result=inventoryService.start(id);
		return result;
	}


	/**
	 *	盘点取消
	 */
	@ApiOperation(value = "盘点取消")
	@ApiImplicitParams({
			@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=10)
	@SentinelResource(value = InventoryServiceProxy.CANCEL, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.CANCEL)
	public Result cancel(String id) {
		Result result=inventoryService.cancel(id);
		return result;
	}


	/**
	 *	盘点结束
	 */
	@ApiOperation(value = "盘点结束")
	@ApiImplicitParams({
			@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=11)
	@SentinelResource(value = InventoryServiceProxy.FINISH, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.FINISH)
	public Result finish(String id) {
		Result result=inventoryService.finish(id);
		return result;
	}


	/**
	 *	数据同步
	 */
	@ApiOperation(value = "数据同步")
	@ApiImplicitParams({
			@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=12)
	@SentinelResource(value = InventoryServiceProxy.DATA_SYNC, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.DATA_SYNC)
	public Result dataSync(String id) {
		Result result=inventoryService.dataSync(id);
		return result;
	}

	/**
	 *	盘点
	 */
	@ApiOperation(value = "盘点")
	@ApiImplicitParams({
			@ApiImplicitParam(name = InventoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
			@ApiImplicitParam(name = "assetId" , value = "资产" , required = true , dataTypeClass=String.class , example = "1"),
			@ApiImplicitParam(name = "action" , value = "动作" , required = true , dataTypeClass=String.class , example = "loss")
	})
	@ApiOperationSupport(order=13)
	@SentinelResource(value = InventoryServiceProxy.INVENTORY_ASSET, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryServiceProxy.INVENTORY_ASSET)
	public Result inventoryAsset(String id,String assetId,String action,String notes) {
		Result result=inventoryService.inventoryAsset(id,assetId,action,notes);
		return result;
	}


	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InventoryServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InventoryVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inventoryService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InventoryServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inventoryService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InventoryServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inventoryService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}