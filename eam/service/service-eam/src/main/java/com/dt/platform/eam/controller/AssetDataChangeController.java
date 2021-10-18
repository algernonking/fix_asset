package com.dt.platform.eam.controller;


import java.util.ArrayList;
import java.util.List;

import com.dt.platform.constants.enums.eam.AssetAttributeDimensionEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetBorrowVOMeta;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
import org.github.foxnic.web.domain.changes.meta.ExampleOrderVOMeta;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.proxy.changes.ExampleOrderServiceProxy;
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


import com.dt.platform.proxy.eam.AssetDataChangeServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDataChangeVOMeta;
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
import com.dt.platform.domain.eam.meta.AssetDataChangeMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDataChangeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据变更 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-08 16:01:26
*/

@Api(tags = "数据变更")
@ApiSort(0)
@RestController("EamAssetDataChangeController")
public class AssetDataChangeController extends SuperController {

	@Autowired
	private IAssetDataChangeService assetDataChangeService;


	@Autowired
	private IAssetService assetService;
	/**
	 * 添加数据变更
	*/
	@ApiOperation(value = "添加数据变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_DATE , value = "变更日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetDataChangeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.INSERT)
	public Result insert(AssetDataChangeRecordVO assetDataChangeVO) {
		return assetDataChangeService.insertRecord(assetDataChangeVO);
	}



	/**
	 * 删除数据变更
	*/
	@ApiOperation(value = "删除数据变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@SentinelResource(value = AssetDataChangeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.DELETE)
	public Result deleteById(String id) {

		AssetDataChange assetDataChange=assetDataChangeService.getById(id);
		if(AssetHandleStatusEnum.CANCEL.code().equals(assetDataChange.getStatus())
				||AssetHandleStatusEnum.INCOMPLETE.code().equals(assetDataChange.getStatus()) ){
			Result result=assetDataChangeService.deleteByIdLogical(id);
			return result;
		}else{
			return ErrorDesc.failure().message("当前状态不允许删除");
		}

	}
	
	
	/**
	 * 批量删除数据变更 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetDataChangeVOMeta.IDS)
	@SentinelResource(value = AssetDataChangeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetDataChangeService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新数据变更
	*/
	@ApiOperation(value = "更新数据变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ASSET_CHANGE_ID , value = "资产变更" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_DATE , value = "变更日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),

	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetDataChangeVOMeta.PAGE_INDEX , AssetDataChangeVOMeta.PAGE_SIZE , AssetDataChangeVOMeta.SEARCH_FIELD , AssetDataChangeVOMeta.FUZZY_FIELD , AssetDataChangeVOMeta.SEARCH_VALUE , AssetDataChangeVOMeta.SORT_FIELD , AssetDataChangeVOMeta.SORT_TYPE , AssetDataChangeVOMeta.IDS } ) 
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@SentinelResource(value = AssetDataChangeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.UPDATE)
	public Result update(AssetDataChangeRecordVO assetDataChangeVO) {
		return assetDataChangeService.updateRecord(assetDataChangeVO);
	}


	/**
	 * 保存数据变更
	*/
	@ApiOperation(value = "保存数据变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ASSET_CHANGE_ID , value = "资产变更" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_DATE , value = "变更日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),

	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDataChangeVOMeta.PAGE_INDEX , AssetDataChangeVOMeta.PAGE_SIZE , AssetDataChangeVOMeta.SEARCH_FIELD , AssetDataChangeVOMeta.FUZZY_FIELD , AssetDataChangeVOMeta.SEARCH_VALUE , AssetDataChangeVOMeta.SORT_FIELD , AssetDataChangeVOMeta.SORT_TYPE , AssetDataChangeVOMeta.IDS } )
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@SentinelResource(value = AssetDataChangeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.SAVE)
	public Result save(AssetDataChangeVO assetDataChangeVO) {
		Result result=assetDataChangeService.save(assetDataChangeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取数据变更
	*/
	@ApiOperation(value = "获取数据变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@SentinelResource(value = AssetDataChangeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.GET_BY_ID)
	public Result<AssetDataChange> getById(String id) {

		assetDataChangeService.queryDataChange(id,AssetAttributeDimensionEnum.MAINTAINER.code());


		Result<AssetDataChange> result=new Result<>();
		AssetDataChange assetDataChange=assetDataChangeService.getById(id);
		// 关联出 制单人 数据
		assetDataChangeService.join(assetDataChange,AssetDataChangeMeta.ORIGINATOR);
		assetDataChangeService.join(assetDataChange,AssetDataChangeMeta.CHANGE_DATA);

		// 关联出 资产分类 数据
		assetService.join(assetDataChange.getChangeData(), AssetMeta.CATEGORY);
		// 关联出 物品档案 数据
		assetService.join(assetDataChange.getChangeData(),AssetMeta.GOODS);
		// 关联出 厂商 数据
		assetService.join(assetDataChange.getChangeData(),AssetMeta.MANUFACTURER);
		// 关联出 位置 数据
		assetService.join(assetDataChange.getChangeData(),AssetMeta.POSITION);
		// 关联出 仓库 数据
		assetService.join(assetDataChange.getChangeData(),AssetMeta.WAREHOUSE);
		// 关联出 来源 数据
		assetService.join(assetDataChange.getChangeData(),AssetMeta.SOURCE);
		// 关联出 维保商 数据
		assetService.join(assetDataChange.getChangeData(),AssetMeta.MAINTNAINER);
		// 关联出 财务分类 数据
		assetService.join(assetDataChange.getChangeData(),AssetMeta.CATEGORY_FINANCE);

		assetService.join(assetDataChange.getChangeData(),AssetMeta.RACK);

		// 关联出 供应商 数据
		assetService.join(assetDataChange.getChangeData(),AssetMeta.SUPPLIER);
		assetService.join(assetDataChange.getChangeData(),AssetMeta.SAFETY_LEVEL);
		assetService.join(assetDataChange.getChangeData(),AssetMeta.EQUIPMENT_ENVIRONMENT);
		assetService.join(assetDataChange.getChangeData(),AssetMeta.OWNER_COMPANY);
		assetService.join(assetDataChange.getChangeData(),AssetMeta.USE_ORGANIZATION);
		assetService.join(assetDataChange.getChangeData(),AssetMeta.MANAGER);
		assetService.join(assetDataChange.getChangeData(),AssetMeta.USE_USER);
		assetService.join(assetDataChange.getChangeData(),AssetMeta.ORIGINATOR);



		result.success(true).data(assetDataChange);
		return result;
	}


	/**
	 * 批量获取数据变更 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据变更")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetDataChangeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetDataChangeVOMeta.IDS)
		@SentinelResource(value = AssetDataChangeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.GET_BY_IDS)
	public Result<List<AssetDataChange>> getByIds(List<String> ids) {
		Result<List<AssetDataChange>> result=new Result<>();
		List<AssetDataChange> list=assetDataChangeService.getByIds(ids);

		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询数据变更
	*/
	@ApiOperation(value = "查询数据变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ASSET_CHANGE_ID , value = "资产变更" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_DATE , value = "变更日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "ces "),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class , example = "E001"),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDataChangeVOMeta.PAGE_INDEX , AssetDataChangeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetDataChangeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.QUERY_LIST)
	public Result<List<AssetDataChange>> queryList(AssetDataChangeVO sample) {
		Result<List<AssetDataChange>> result=new Result<>();
		List<AssetDataChange> list=assetDataChangeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询数据变更
	*/
	@ApiOperation(value = "分页查询数据变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ASSET_CHANGE_ID , value = "资产变更" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_DATE , value = "变更日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),

	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetDataChangeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetDataChange>> queryPagedList(AssetDataChangeVO sample) {
		Result<PagedList<AssetDataChange>> result=new Result<>();
		PagedList<AssetDataChange> list=assetDataChangeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		assetDataChangeService.join(list,AssetDataChangeMeta.ORIGINATOR);

		List<Employee> employees= CollectorUtil.collectList(list,AssetDataChange::getOriginator);
		assetDataChangeService.dao().join(employees, Person.class);


		assetDataChangeService.join(list,AssetDataChangeMeta.CHANGE_DATA);
		List<Asset> assetData= CollectorUtil.collectList(list,AssetDataChange::getChangeData);

		// 关联出 资产分类 数据
		assetService.join(assetData, AssetMeta.CATEGORY);
		// 关联出 物品档案 数据
		assetService.join(assetData,AssetMeta.GOODS);
		// 关联出 厂商 数据
		assetService.join(assetData,AssetMeta.MANUFACTURER);
		// 关联出 位置 数据
		assetService.join(assetData,AssetMeta.POSITION);
		// 关联出 仓库 数据
		assetService.join(assetData,AssetMeta.WAREHOUSE);
		// 关联出 来源 数据
		assetService.join(assetData,AssetMeta.SOURCE);
		// 关联出 维保商 数据
		assetService.join(assetData,AssetMeta.MAINTNAINER);
		// 关联出 财务分类 数据
		assetService.join(assetData,AssetMeta.CATEGORY_FINANCE);
		// 关联出 供应商 数据
		assetService.join(assetData,AssetMeta.SUPPLIER);
		assetService.join(assetData,AssetMeta.SAFETY_LEVEL);
		assetService.join(assetData,AssetMeta.EQUIPMENT_ENVIRONMENT);
		assetService.join(assetData,AssetMeta.OWNER_COMPANY);
		assetService.join(assetData,AssetMeta.USE_ORGANIZATION);
		assetService.join(assetData,AssetMeta.MANAGER);
		assetService.join(assetData,AssetMeta.USE_USER);
		assetService.join(assetData,AssetMeta.ORIGINATOR);
		result.success(true).data(list);
		return result;

	}

	/**
	 * 维度查询
	 */
	@ApiOperation(value = "维度查询")

	@ApiOperationSupport(order=9)
	@SentinelResource(value = AssetDataChangeServiceProxy.QUERY_DATA_CHANGE_DIMENSION_BY_CHANGE_TYPE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.QUERY_DATA_CHANGE_DIMENSION_BY_CHANGE_TYPE)
	public Result queryDataChangeDimensionByChangeType(String changeType) {
		Result result=new Result();
		result.success(true).data(assetDataChangeService.queryDataChangeDimensionByChangeType(changeType));
		return result;
	}

	/**
	 * 送审
	 * */
	@ApiOperation(value = "变更送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetDataChangeServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataChangeServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetDataChangeService.forApproval(id);
	}





	/**
	 * 确认
	 * */
	@ApiOperation(value = "变更确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetDataChangeServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataChangeServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetDataChangeService.confirmOperation(id);
	}


	/**
	 * 撤销
	 * */
	@ApiOperation(value = "变更撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetDataChangeServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataChangeServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetDataChangeService.revokeOperation(id);
	}


	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = AssetDataChangeServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataChangeServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return assetDataChangeService.approve(approveVO);
	}


	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetDataChangeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataChangeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetDataChangeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetDataChangeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetDataChangeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataChangeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetDataChangeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = AssetDataChangeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataChangeServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetDataChangeService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}