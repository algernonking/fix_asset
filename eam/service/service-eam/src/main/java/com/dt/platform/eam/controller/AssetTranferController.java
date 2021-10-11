package com.dt.platform.eam.controller;

 
import java.util.List;

import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetScrapVOMeta;
import com.dt.platform.domain.ops.meta.InformationSystemMeta;
import com.dt.platform.proxy.eam.AssetScrapServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
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


import com.dt.platform.proxy.eam.AssetTranferServiceProxy;
import com.dt.platform.domain.eam.meta.AssetTranferVOMeta;
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
import com.dt.platform.domain.eam.meta.AssetTranferMeta;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetTranferService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产转移 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-19 07:31:48
*/

@Api(tags = "资产转移")
@ApiSort(0)
@RestController("EamAssetTranferController")
public class AssetTranferController extends SuperController {

	@Autowired
	private IAssetTranferService assetTranferService;

	
	/**
	 * 添加资产转移
	*/
	@ApiOperation(value = "添加资产转移")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480668065630007296"),
		@ApiImplicitParam(name = AssetTranferVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.OUT_USE_ORGANIZATION_ID , value = "调出使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.IN_USE_ORGANIZATION_ID , value = "调入使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.MANAGER_ID , value = "调入管理员" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.POSITION_DETAIL , value = "位置详情" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.CONTENT , value = "转移说明" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetTranferVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetTranferServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetTranferServiceProxy.INSERT)
	public Result insert(AssetTranferVO assetTranferVO,String assetSelectedCode) {
		if(!StringUtil.isBlank(assetSelectedCode)){
			return assetTranferService.insert(assetTranferVO,assetSelectedCode);
		}else{
			return assetTranferService.insert(assetTranferVO);
		}
	}

	
	/**
	 * 删除资产转移
	*/
	@ApiOperation(value = "删除资产转移")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480668065630007296"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetTranferVOMeta.ID)
	@SentinelResource(value = AssetTranferServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetTranferServiceProxy.DELETE)
	public Result deleteById(String id) {
		AssetTranfer assetTranfer=assetTranferService.getById(id);
		if(AssetHandleStatusEnum.CANCEL.code().equals(assetTranfer.getStatus())
				||AssetHandleStatusEnum.INCOMPLETE.code().equals(assetTranfer.getStatus()) ){
			Result result=assetTranferService.deleteByIdLogical(id);
			return result;
		}else{
			return ErrorDesc.failure().message("当前状态不允许删除");
		}



	}
	
	
	/**
	 * 批量删除资产转移 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产转移")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetTranferVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetTranferVOMeta.IDS)
	@SentinelResource(value = AssetTranferServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetTranferServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetTranferService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产转移
	*/
	@ApiOperation(value = "更新资产转移")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480668065630007296"),
		@ApiImplicitParam(name = AssetTranferVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.OUT_USE_ORGANIZATION_ID , value = "调出使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.IN_USE_ORGANIZATION_ID , value = "调入使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.MANAGER_ID , value = "调入管理员" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.POSITION_DETAIL , value = "位置详情" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.CONTENT , value = "转移说明" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetTranferVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetTranferVOMeta.PAGE_INDEX , AssetTranferVOMeta.PAGE_SIZE , AssetTranferVOMeta.SEARCH_FIELD , AssetTranferVOMeta.FUZZY_FIELD , AssetTranferVOMeta.SEARCH_VALUE , AssetTranferVOMeta.SORT_FIELD , AssetTranferVOMeta.SORT_TYPE , AssetTranferVOMeta.IDS } ) 
	@NotNull(name = AssetTranferVOMeta.ID)
	@SentinelResource(value = AssetTranferServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetTranferServiceProxy.UPDATE)
	public Result update(AssetTranferVO assetTranferVO) {
		AssetTranfer assetTranfer=assetTranferService.getById(assetTranferVO.getId());
		if(AssetHandleStatusEnum.COMPLETE.code().equals(assetTranfer.getStatus())
		||AssetHandleStatusEnum.APPROVAL.code().equals(assetTranfer.getStatus())){
			return ErrorDesc.failure().message("当前状态不允许修改");
		}
		Result result=assetTranferService.update(assetTranferVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产转移
	*/
	@ApiOperation(value = "保存资产转移")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480668065630007296"),
		@ApiImplicitParam(name = AssetTranferVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.OUT_USE_ORGANIZATION_ID , value = "调出使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.IN_USE_ORGANIZATION_ID , value = "调入使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.MANAGER_ID , value = "调入管理员" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.POSITION_DETAIL , value = "位置详情" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.CONTENT , value = "转移说明" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetTranferVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetTranferVOMeta.PAGE_INDEX , AssetTranferVOMeta.PAGE_SIZE , AssetTranferVOMeta.SEARCH_FIELD , AssetTranferVOMeta.FUZZY_FIELD , AssetTranferVOMeta.SEARCH_VALUE , AssetTranferVOMeta.SORT_FIELD , AssetTranferVOMeta.SORT_TYPE , AssetTranferVOMeta.IDS } )
	@NotNull(name = AssetTranferVOMeta.ID)
	@SentinelResource(value = AssetTranferServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetTranferServiceProxy.SAVE)
	public Result save(AssetTranferVO assetTranferVO) {
		Result result=assetTranferService.save(assetTranferVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产转移
	*/
	@ApiOperation(value = "获取资产转移")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetTranferVOMeta.ID)
	@SentinelResource(value = AssetTranferServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetTranferServiceProxy.GET_BY_ID)
	public Result<AssetTranfer> getById(String id) {
		Result<AssetTranfer> result=new Result<>();
		AssetTranfer assetTranfer=assetTranferService.getById(id);
		// 关联出 调出使用公司/部门 数据
		assetTranferService.join(assetTranfer,AssetTranferMeta.OUT_USE_ORGANIZATION);
		// 关联出 调入使用公司/部门 数据
		assetTranferService.join(assetTranfer,AssetTranferMeta.IN_USE_ORGANIZATION);
		// 关联出 存放位置 数据
		assetTranferService.join(assetTranfer,AssetTranferMeta.POSITION);

		assetTranferService.join(assetTranfer,AssetTranferMeta.ORIGINATOR);

		assetTranferService.join(assetTranfer,AssetTranferMeta.MANAGER);

		assetTranferService.join(assetTranfer,AssetTranferMeta.USE_USER);
		result.success(true).data(assetTranfer);
		return result;
	}



	/**
	 * 批量删除资产转移 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产转移")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetTranferVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetTranferVOMeta.IDS)
		@SentinelResource(value = AssetTranferServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetTranferServiceProxy.GET_BY_IDS)
	public Result<List<AssetTranfer>> getByIds(List<String> ids) {
		Result<List<AssetTranfer>> result=new Result<>();
		List<AssetTranfer> list=assetTranferService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产转移
	*/
	@ApiOperation(value = "查询资产转移")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480668065630007296"),
		@ApiImplicitParam(name = AssetTranferVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.OUT_USE_ORGANIZATION_ID , value = "调出使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.IN_USE_ORGANIZATION_ID , value = "调入使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.MANAGER_ID , value = "调入管理员" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.POSITION_DETAIL , value = "位置详情" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.CONTENT , value = "转移说明" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetTranferVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetTranferVOMeta.PAGE_INDEX , AssetTranferVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetTranferServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetTranferServiceProxy.QUERY_LIST)
	public Result<List<AssetTranfer>> queryList(AssetTranferVO sample) {
		Result<List<AssetTranfer>> result=new Result<>();
		List<AssetTranfer> list=assetTranferService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产转移
	*/
	@ApiOperation(value = "分页查询资产转移")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480668065630007296"),
		@ApiImplicitParam(name = AssetTranferVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.OUT_USE_ORGANIZATION_ID , value = "调出使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.IN_USE_ORGANIZATION_ID , value = "调入使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.MANAGER_ID , value = "调入管理员" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetTranferVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.POSITION_DETAIL , value = "位置详情" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.CONTENT , value = "转移说明" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetTranferVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetTranferVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetTranferServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetTranferServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetTranfer>> queryPagedList(AssetTranferVO sample) {
		Result<PagedList<AssetTranfer>> result=new Result<>();
		PagedList<AssetTranfer> list=assetTranferService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 调出使用公司/部门 数据
		assetTranferService.join(list,AssetTranferMeta.OUT_USE_ORGANIZATION);
		// 关联出 调入使用公司/部门 数据
		assetTranferService.join(list,AssetTranferMeta.IN_USE_ORGANIZATION);
		// 关联出 存放位置 数据
		assetTranferService.join(list,AssetTranferMeta.POSITION);


		assetTranferService.join(list,AssetTranferMeta.ORIGINATOR);

		assetTranferService.join(list,AssetTranferMeta.MANAGER);

		assetTranferService.join(list,AssetTranferMeta.USE_USER);


		List<Employee> employees= CollectorUtil.collectList(list,AssetTranfer::getOriginator);
		assetTranferService.dao().join(employees, Person.class);

		List<Employee> useusers= CollectorUtil.collectList(list,AssetTranfer::getUseUser);
		assetTranferService.dao().join(useusers, Person.class);

		List<Employee> managers= CollectorUtil.collectList(list,AssetTranfer::getManager);
		assetTranferService.dao().join(managers, Person.class);


		result.success(true).data(list);
		return result;
	}




	/**
	 * 转移送审
	 * */
	@ApiOperation(value = "转移送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetTranferVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetTranferServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetTranferServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetTranferService.forApproval(id);
	}



	/**
	 * 确认
	 * */
	@ApiOperation(value = "转移确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetTranferVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetTranferServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetTranferServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetTranferService.confirmOperation(id);
	}



	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetTranferVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetTranferVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetTranferServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetTranferServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetTranferService.revokeOperation(id);
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetTranferServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetTranferServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetTranferVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetTranferService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetTranferServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetTranferServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetTranferService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetTranferServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetTranferServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetTranferService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}