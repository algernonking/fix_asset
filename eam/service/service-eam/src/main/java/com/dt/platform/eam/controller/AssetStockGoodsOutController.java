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


import com.dt.platform.proxy.eam.AssetStockGoodsOutServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStockGoodsOutVOMeta;
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
import com.dt.platform.domain.eam.meta.AssetStockGoodsOutMeta;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStockGoodsOutService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库存出库 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-22 20:46:11
*/

@Api(tags = "库存出库")
@ApiSort(0)
@RestController("EamAssetStockGoodsOutController")
public class AssetStockGoodsOutController extends SuperController {

	@Autowired
	private IAssetStockGoodsOutService assetStockGoodsOutService;


	/**
	 * 添加库存出库
	*/
	@ApiOperation(value = "添加库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.STOCK_TYPE , value = "出库所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_OWN_COMPANY_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_ORGANIZATION_ID , value = "领用部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_USER_ID , value = "领用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.POSITION_DETAIL , value = "出库位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.COLLECTION_DATE , value = "出库日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CONTENT , value = "出库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsOutServiceProxy.INSERT)
	public Result insert(AssetStockGoodsOutVO assetStockGoodsOutVO) {
		Result result=assetStockGoodsOutService.insert(assetStockGoodsOutVO,false);
		return result;
	}



	/**
	 * 删除库存出库
	*/
	@ApiOperation(value = "删除库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetStockGoodsOutVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsOutServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetStockGoodsOutService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除库存出库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetStockGoodsOutVOMeta.IDS)
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsOutServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetStockGoodsOutService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新库存出库
	*/
	@ApiOperation(value = "更新库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.STOCK_TYPE , value = "出库所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_OWN_COMPANY_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_ORGANIZATION_ID , value = "领用部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_USER_ID , value = "领用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.POSITION_DETAIL , value = "出库位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.COLLECTION_DATE , value = "出库日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CONTENT , value = "出库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetStockGoodsOutVOMeta.PAGE_INDEX , AssetStockGoodsOutVOMeta.PAGE_SIZE , AssetStockGoodsOutVOMeta.SEARCH_FIELD , AssetStockGoodsOutVOMeta.FUZZY_FIELD , AssetStockGoodsOutVOMeta.SEARCH_VALUE , AssetStockGoodsOutVOMeta.DIRTY_FIELDS , AssetStockGoodsOutVOMeta.SORT_FIELD , AssetStockGoodsOutVOMeta.SORT_TYPE , AssetStockGoodsOutVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsOutVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsOutServiceProxy.UPDATE)
	public Result update(AssetStockGoodsOutVO assetStockGoodsOutVO) {
		Result result=assetStockGoodsOutService.update(assetStockGoodsOutVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存库存出库
	*/
	@ApiOperation(value = "保存库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.STOCK_TYPE , value = "出库所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_OWN_COMPANY_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_ORGANIZATION_ID , value = "领用部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_USER_ID , value = "领用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.POSITION_DETAIL , value = "出库位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.COLLECTION_DATE , value = "出库日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CONTENT , value = "出库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsOutVOMeta.PAGE_INDEX , AssetStockGoodsOutVOMeta.PAGE_SIZE , AssetStockGoodsOutVOMeta.SEARCH_FIELD , AssetStockGoodsOutVOMeta.FUZZY_FIELD , AssetStockGoodsOutVOMeta.SEARCH_VALUE , AssetStockGoodsOutVOMeta.DIRTY_FIELDS , AssetStockGoodsOutVOMeta.SORT_FIELD , AssetStockGoodsOutVOMeta.SORT_TYPE , AssetStockGoodsOutVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsOutVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsOutServiceProxy.SAVE)
	public Result save(AssetStockGoodsOutVO assetStockGoodsOutVO) {
		Result result=assetStockGoodsOutService.save(assetStockGoodsOutVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取库存出库
	*/
	@ApiOperation(value = "获取库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetStockGoodsOutVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsOutServiceProxy.GET_BY_ID)
	public Result<AssetStockGoodsOut> getById(String id) {
		Result<AssetStockGoodsOut> result=new Result<>();
		AssetStockGoodsOut assetStockGoodsOut=assetStockGoodsOutService.getById(id);
		// join 关联的对象
		assetStockGoodsOutService.dao().fill(assetStockGoodsOut)
			.with("useOwnCompany")
			.with("useOrganization")
			.with("originator")
			.with("useUser")
			.with(AssetStockGoodsOutMeta.WAREHOUSE)
			.with(AssetStockGoodsOutMeta.STOCK_TYPE_DICT)
			.execute();
		result.success(true).data(assetStockGoodsOut);
		return result;
	}


	/**
	 * 批量获取库存出库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取库存出库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetStockGoodsOutVOMeta.IDS)
		@SentinelResource(value = AssetStockGoodsOutServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsOutServiceProxy.GET_BY_IDS)
	public Result<List<AssetStockGoodsOut>> getByIds(List<String> ids) {
		Result<List<AssetStockGoodsOut>> result=new Result<>();
		List<AssetStockGoodsOut> list=assetStockGoodsOutService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询库存出库
	*/
	@ApiOperation(value = "查询库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.STOCK_TYPE , value = "出库所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_OWN_COMPANY_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_ORGANIZATION_ID , value = "领用部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_USER_ID , value = "领用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.POSITION_DETAIL , value = "出库位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.COLLECTION_DATE , value = "出库日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CONTENT , value = "出库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsOutVOMeta.PAGE_INDEX , AssetStockGoodsOutVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsOutServiceProxy.QUERY_LIST)
	public Result<List<AssetStockGoodsOut>> queryList(AssetStockGoodsOutVO sample) {
		Result<List<AssetStockGoodsOut>> result=new Result<>();
		List<AssetStockGoodsOut> list=assetStockGoodsOutService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询库存出库
	*/
	@ApiOperation(value = "分页查询库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.STOCK_TYPE , value = "出库所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_OWN_COMPANY_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_ORGANIZATION_ID , value = "领用部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.USE_USER_ID , value = "领用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.POSITION_DETAIL , value = "出库位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.COLLECTION_DATE , value = "出库日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CONTENT , value = "出库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsOutServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetStockGoodsOut>> queryPagedList(AssetStockGoodsOutVO sample) {
		Result<PagedList<AssetStockGoodsOut>> result=new Result<>();
		PagedList<AssetStockGoodsOut> list=assetStockGoodsOutService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetStockGoodsOutService.dao().fill(list)
			.with("useOwnCompany")
			.with("useOrganization")
			.with("originator")
			.with("useUser")
			.with(AssetStockGoodsOutMeta.WAREHOUSE)
			.with(AssetStockGoodsOutMeta.STOCK_TYPE_DICT)
			.execute();

		List<Employee> originatorList= CollectorUtil.collectList(list, AssetStockGoodsOut::getOriginator);
		assetStockGoodsOutService.dao().join(originatorList, Person.class);

		List<Employee> useUserList= CollectorUtil.collectList(list, AssetStockGoodsOut::getUseUser);
		assetStockGoodsOutService.dao().join(useUserList, Person.class);

		result.success(true).data(list);

		return result;
	}



	/**
	 * 送审
	 * */
	@ApiOperation(value = "送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockGoodsOutVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsOutServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetStockGoodsOutService.forApproval(id);
	}


	/**
	 * 确认
	 * */
	@ApiOperation(value = "确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockGoodsOutVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsOutServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetStockGoodsOutService.confirmOperation(id);
	}


	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockGoodsOutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockGoodsOutVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsOutServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetStockGoodsOutService.revokeOperation(id);
	}


	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsOutServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return assetStockGoodsOutService.approve(approveVO);
	}




	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsOutServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetStockGoodsOutVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetStockGoodsOutService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetStockGoodsOutServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsOutServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetStockGoodsOutService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetStockGoodsOutServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsOutServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetStockGoodsOutService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}