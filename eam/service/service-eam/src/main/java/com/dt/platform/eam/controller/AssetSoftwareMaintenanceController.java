package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetStockGoodsInVOMeta;
import com.dt.platform.proxy.eam.AssetStockGoodsInServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
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


import com.dt.platform.proxy.eam.AssetSoftwareMaintenanceServiceProxy;
import com.dt.platform.domain.eam.meta.AssetSoftwareMaintenanceVOMeta;
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
import com.dt.platform.domain.eam.meta.AssetSoftwareMaintenanceMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetSoftwareMaintenanceService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 软件维保 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-05 16:44:03
*/

@Api(tags = "软件维保")
@ApiSort(0)
@RestController("EamAssetSoftwareMaintenanceController")
public class AssetSoftwareMaintenanceController extends SuperController {

	@Autowired
	private IAssetSoftwareMaintenanceService assetSoftwareMaintenanceService;


	/**
	 * 添加软件维保
	*/
	@ApiOperation(value = "添加软件维保")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574636732868198400"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.NAME , value = "维保名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "472013393872551936"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.USE_ORG_ID , value = "负责部门" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MANAGER_ID , value = "维保负责人" , required = false , dataTypeClass=String.class , example = "558321538131034112"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTACTS , value = "维保联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTACT_INFO , value = "联系信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_COST , value = "维保费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class , example = "2022-05-05 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class , example = "2022-05-05 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTENT , value = "维保说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceServiceProxy.INSERT)
	public Result insert(AssetSoftwareMaintenanceVO assetSoftwareMaintenanceVO) {
		Result result=assetSoftwareMaintenanceService.insert(assetSoftwareMaintenanceVO,false);
		return result;
	}



	/**
	 * 删除软件维保
	*/
	@ApiOperation(value = "删除软件维保")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574636732868198400")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetSoftwareMaintenanceVOMeta.ID)
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetSoftwareMaintenanceService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除软件维保 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除软件维保")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetSoftwareMaintenanceVOMeta.IDS)
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetSoftwareMaintenanceService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新软件维保
	*/
	@ApiOperation(value = "更新软件维保")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574636732868198400"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.NAME , value = "维保名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "472013393872551936"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.USE_ORG_ID , value = "负责部门" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MANAGER_ID , value = "维保负责人" , required = false , dataTypeClass=String.class , example = "558321538131034112"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTACTS , value = "维保联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTACT_INFO , value = "联系信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_COST , value = "维保费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class , example = "2022-05-05 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class , example = "2022-05-05 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTENT , value = "维保说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetSoftwareMaintenanceVOMeta.PAGE_INDEX , AssetSoftwareMaintenanceVOMeta.PAGE_SIZE , AssetSoftwareMaintenanceVOMeta.SEARCH_FIELD , AssetSoftwareMaintenanceVOMeta.FUZZY_FIELD , AssetSoftwareMaintenanceVOMeta.SEARCH_VALUE , AssetSoftwareMaintenanceVOMeta.DIRTY_FIELDS , AssetSoftwareMaintenanceVOMeta.SORT_FIELD , AssetSoftwareMaintenanceVOMeta.SORT_TYPE , AssetSoftwareMaintenanceVOMeta.IDS } )
	@NotNull(name = AssetSoftwareMaintenanceVOMeta.ID)
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceServiceProxy.UPDATE)
	public Result update(AssetSoftwareMaintenanceVO assetSoftwareMaintenanceVO) {
		Result result=assetSoftwareMaintenanceService.update(assetSoftwareMaintenanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存软件维保
	*/
	@ApiOperation(value = "保存软件维保")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574636732868198400"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.NAME , value = "维保名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "472013393872551936"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.USE_ORG_ID , value = "负责部门" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MANAGER_ID , value = "维保负责人" , required = false , dataTypeClass=String.class , example = "558321538131034112"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTACTS , value = "维保联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTACT_INFO , value = "联系信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_COST , value = "维保费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class , example = "2022-05-05 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class , example = "2022-05-05 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTENT , value = "维保说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareMaintenanceVOMeta.PAGE_INDEX , AssetSoftwareMaintenanceVOMeta.PAGE_SIZE , AssetSoftwareMaintenanceVOMeta.SEARCH_FIELD , AssetSoftwareMaintenanceVOMeta.FUZZY_FIELD , AssetSoftwareMaintenanceVOMeta.SEARCH_VALUE , AssetSoftwareMaintenanceVOMeta.DIRTY_FIELDS , AssetSoftwareMaintenanceVOMeta.SORT_FIELD , AssetSoftwareMaintenanceVOMeta.SORT_TYPE , AssetSoftwareMaintenanceVOMeta.IDS } )
	@NotNull(name = AssetSoftwareMaintenanceVOMeta.ID)
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceServiceProxy.SAVE)
	public Result save(AssetSoftwareMaintenanceVO assetSoftwareMaintenanceVO) {
		Result result=assetSoftwareMaintenanceService.save(assetSoftwareMaintenanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取软件维保
	*/
	@ApiOperation(value = "获取软件维保")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetSoftwareMaintenanceVOMeta.ID)
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceServiceProxy.GET_BY_ID)
	public Result<AssetSoftwareMaintenance> getById(String id) {
		Result<AssetSoftwareMaintenance> result=new Result<>();
		AssetSoftwareMaintenance assetSoftwareMaintenance=assetSoftwareMaintenanceService.getById(id);
		// join 关联的对象
		assetSoftwareMaintenanceService.dao().fill(assetSoftwareMaintenance)
			.with("useOrganization")
			.with("manager")
			.with("originator")
			.with(AssetSoftwareMaintenanceMeta.MAINTAINER)
			.execute();
		result.success(true).data(assetSoftwareMaintenance);
		return result;
	}


	/**
	 * 批量获取软件维保 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取软件维保")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetSoftwareMaintenanceVOMeta.IDS)
		@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceServiceProxy.GET_BY_IDS)
	public Result<List<AssetSoftwareMaintenance>> getByIds(List<String> ids) {
		Result<List<AssetSoftwareMaintenance>> result=new Result<>();
		List<AssetSoftwareMaintenance> list=assetSoftwareMaintenanceService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询软件维保
	*/
	@ApiOperation(value = "查询软件维保")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574636732868198400"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.NAME , value = "维保名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "472013393872551936"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.USE_ORG_ID , value = "负责部门" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MANAGER_ID , value = "维保负责人" , required = false , dataTypeClass=String.class , example = "558321538131034112"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTACTS , value = "维保联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTACT_INFO , value = "联系信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_COST , value = "维保费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class , example = "2022-05-05 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class , example = "2022-05-05 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTENT , value = "维保说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareMaintenanceVOMeta.PAGE_INDEX , AssetSoftwareMaintenanceVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceServiceProxy.QUERY_LIST)
	public Result<List<AssetSoftwareMaintenance>> queryList(AssetSoftwareMaintenanceVO sample) {
		Result<List<AssetSoftwareMaintenance>> result=new Result<>();
		List<AssetSoftwareMaintenance> list=assetSoftwareMaintenanceService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询软件维保
	*/
	@ApiOperation(value = "分页查询软件维保")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574636732868198400"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.NAME , value = "维保名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "472013393872551936"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.USE_ORG_ID , value = "负责部门" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MANAGER_ID , value = "维保负责人" , required = false , dataTypeClass=String.class , example = "558321538131034112"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTACTS , value = "维保联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTACT_INFO , value = "联系信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_COST , value = "维保费用" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class , example = "2022-05-05 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class , example = "2022-05-05 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.CONTENT , value = "维保说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetSoftwareMaintenance>> queryPagedList(AssetSoftwareMaintenanceVO sample) {
		Result<PagedList<AssetSoftwareMaintenance>> result=new Result<>();
		PagedList<AssetSoftwareMaintenance> list=assetSoftwareMaintenanceService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetSoftwareMaintenanceService.dao().fill(list)
			.with("useOrganization")
			.with("manager")
			.with("originator")
			.with(AssetSoftwareMaintenanceMeta.MAINTAINER)
			.execute();
		result.success(true).data(list);

		List<Employee> originatorList= CollectorUtil.collectList(list, AssetSoftwareMaintenance::getOriginator);
		assetSoftwareMaintenanceService.dao().join(originatorList, Person.class);

		List<Employee> managerList= CollectorUtil.collectList(list, AssetSoftwareMaintenance::getManager);
		assetSoftwareMaintenanceService.dao().join(managerList, Person.class);



		return result;
	}


	/**
	 * 送审
	 * */
	@ApiOperation(value = "送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareMaintenanceVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareMaintenanceServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetSoftwareMaintenanceService.forApproval(id);
	}


	/**
	 * 确认
	 * */
	@ApiOperation(value = "确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareMaintenanceVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareMaintenanceServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetSoftwareMaintenanceService.confirmOperation(id);
	}


	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareMaintenanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareMaintenanceVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareMaintenanceServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetSoftwareMaintenanceService.revokeOperation(id);
	}


	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareMaintenanceServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return assetSoftwareMaintenanceService.approve(approveVO);
	}




	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareMaintenanceServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetSoftwareMaintenanceVO  sample,HttpServletResponse response) throws Exception {
		try{

			//生成 Excel 数据
			ExcelWriter ew=assetSoftwareMaintenanceService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareMaintenanceServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetSoftwareMaintenanceService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetSoftwareMaintenanceServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareMaintenanceServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetSoftwareMaintenanceService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}