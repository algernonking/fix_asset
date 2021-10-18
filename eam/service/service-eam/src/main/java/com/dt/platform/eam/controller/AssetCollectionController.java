package com.dt.platform.eam.controller;

 
import java.util.List;

import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetBorrowVOMeta;
import com.dt.platform.proxy.eam.AssetAllocationServiceProxy;
import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
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


import com.dt.platform.proxy.eam.AssetCollectionServiceProxy;
import com.dt.platform.domain.eam.meta.AssetCollectionVOMeta;
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
import com.dt.platform.domain.eam.meta.AssetCollectionMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetCollectionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产领用 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 17:00:01
*/

@Api(tags = "资产领用")
@ApiSort(0)
@RestController("EamAssetCollectionController")
public class AssetCollectionController extends SuperController {

	@Autowired
	private IAssetCollectionService assetCollectionService;

	
	/**
	 * 添加资产领用
	*/
	@ApiOperation(value = "添加资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480482454377865216"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class , example = "asdf"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class , example = "2021-08-09 12:00:00"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class , example = "asf"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetCollectionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.INSERT)
	public Result insert(AssetCollectionVO assetCollectionVO){
			return assetCollectionService.insert(assetCollectionVO);
	}

	
	/**
	 * 删除资产领用
	*/
	@ApiOperation(value = "删除资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480482454377865216"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetCollectionVOMeta.ID)
	@SentinelResource(value = AssetCollectionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.DELETE)
	public Result deleteById(String id) {

		AssetCollection assetCollection=assetCollectionService.getById(id);
		if(AssetHandleStatusEnum.CANCEL.code().equals(assetCollection.getStatus())
				||AssetHandleStatusEnum.INCOMPLETE.code().equals(assetCollection.getStatus()) ){

			Result result=assetCollectionService.deleteByIdLogical(id);return result;

		}else{
			return ErrorDesc.failure().message("当前状态不允许删除");
		}

	}
	
	
	/**
	 * 批量删除资产领用 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetCollectionVOMeta.IDS)
	@SentinelResource(value = AssetCollectionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetCollectionService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产领用
	*/
	@ApiOperation(value = "更新资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480482454377865216"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class , example = "asdf"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class , example = "2021-08-09 12:00:00"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class , example = "asf"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetCollectionVOMeta.PAGE_INDEX , AssetCollectionVOMeta.PAGE_SIZE , AssetCollectionVOMeta.SEARCH_FIELD , AssetCollectionVOMeta.FUZZY_FIELD , AssetCollectionVOMeta.SEARCH_VALUE , AssetCollectionVOMeta.SORT_FIELD , AssetCollectionVOMeta.SORT_TYPE , AssetCollectionVOMeta.IDS } ) 
	@NotNull(name = AssetCollectionVOMeta.ID)
	@SentinelResource(value = AssetCollectionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.UPDATE)
	public Result update(AssetCollectionVO assetCollectionVO) {
		AssetCollection assetCollection=assetCollectionService.getById(assetCollectionVO.getId());
		if(AssetHandleStatusEnum.COMPLETE.code().equals(assetCollection.getStatus())
		 ||AssetHandleStatusEnum.APPROVAL.code().equals(assetCollection.getStatus())){
			return ErrorDesc.failure().message("当前状态不允许修改");
		}
		Result result=assetCollectionService.update(assetCollectionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产领用
	*/
	@ApiOperation(value = "保存资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480482454377865216"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class , example = "asdf"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class , example = "2021-08-09 12:00:00"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class , example = "asf"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetCollectionVOMeta.PAGE_INDEX , AssetCollectionVOMeta.PAGE_SIZE , AssetCollectionVOMeta.SEARCH_FIELD , AssetCollectionVOMeta.FUZZY_FIELD , AssetCollectionVOMeta.SEARCH_VALUE , AssetCollectionVOMeta.SORT_FIELD , AssetCollectionVOMeta.SORT_TYPE , AssetCollectionVOMeta.IDS } )
	@NotNull(name = AssetCollectionVOMeta.ID)
	@SentinelResource(value = AssetCollectionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.SAVE)
	public Result save(AssetCollectionVO assetCollectionVO) {
		Result result=assetCollectionService.save(assetCollectionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产领用
	*/
	@ApiOperation(value = "获取资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetCollectionVOMeta.ID)
	@SentinelResource(value = AssetCollectionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.GET_BY_ID)
	public Result<AssetCollection> getById(String id) {
		Result<AssetCollection> result=new Result<>();
		AssetCollection assetCollection=assetCollectionService.getById(id);
		// 关联出 领用后公司/部门 数据
		assetCollectionService.join(assetCollection,AssetCollectionMeta.USE_ORGANIZATION);
		// 关联出 使用人员 数据
		assetCollectionService.join(assetCollection,AssetCollectionMeta.USE_USER);
		// 关联出 存放位置 数据
		assetCollectionService.join(assetCollection,AssetCollectionMeta.POSITION);
		// 关联出 制单人 数据
		assetCollectionService.join(assetCollection,AssetCollectionMeta.ORIGINATOR);
		result.success(true).data(assetCollection);
		return result;
	}


	/**
	 * 批量删除资产领用 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产领用")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetCollectionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetCollectionVOMeta.IDS)
		@SentinelResource(value = AssetCollectionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.GET_BY_IDS)
	public Result<List<AssetCollection>> getByIds(List<String> ids) {
		Result<List<AssetCollection>> result=new Result<>();
		List<AssetCollection> list=assetCollectionService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产领用
	*/
	@ApiOperation(value = "查询资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480482454377865216"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class , example = "asdf"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class , example = "2021-08-09 12:00:00"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class , example = "asf"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetCollectionVOMeta.PAGE_INDEX , AssetCollectionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetCollectionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.QUERY_LIST)
	public Result<List<AssetCollection>> queryList(AssetCollectionVO sample) {
		Result<List<AssetCollection>> result=new Result<>();
		List<AssetCollection> list=assetCollectionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产领用
	*/
	@ApiOperation(value = "分页查询资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480482454377865216"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class , example = "asdf"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class , example = "2021-08-09 12:00:00"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class , example = "asf"),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetCollectionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetCollection>> queryPagedList(AssetCollectionVO sample) {
		Result<PagedList<AssetCollection>> result=new Result<>();
		PagedList<AssetCollection> list=assetCollectionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 领用后公司/部门 数据
		assetCollectionService.join(list,AssetCollectionMeta.USE_ORGANIZATION);
		// 关联出 使用人员 数据
		assetCollectionService.join(list,AssetCollectionMeta.USE_USER);
		// 关联出 存放位置 数据
		assetCollectionService.join(list,AssetCollectionMeta.POSITION);
		// 关联出 制单人 数据
		assetCollectionService.join(list,AssetCollectionMeta.ORIGINATOR);


		List<Employee> employees= CollectorUtil.collectList(list,AssetCollection::getOriginator);
		List<Employee> useUsers= CollectorUtil.collectList(list,AssetCollection::getUseUser);
		assetCollectionService.dao().join(employees, Person.class);
		assetCollectionService.dao().join(useUsers, Person.class);

		result.success(true).data(list);
		return result;
	}

	/**
	 * 领用送审
	 * */
	@ApiOperation(value = "领用送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetCollectionVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetCollectionServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetCollectionService.forApproval(id);
	}


	/**
	 * 确认
	 * */
	@ApiOperation(value = "领用确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetCollectionVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetCollectionServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetCollectionService.confirmOperation(id);
	}


	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetCollectionVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetCollectionServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetCollectionService.revokeOperation(id);
	}


	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = AssetCollectionServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return assetCollectionService.approve(approveVO);
	}


	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetCollectionServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetCollectionVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetCollectionService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetCollectionServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetCollectionService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetCollectionServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetCollectionService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}