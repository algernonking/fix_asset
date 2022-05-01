package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.service.IGoodsStockService;
import com.dt.platform.proxy.eam.AssetStockGoodsOutServiceProxy;
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


import com.dt.platform.proxy.eam.AssetStockGoodsAdjustServiceProxy;
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

import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStockGoodsAdjustService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库存调整 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-24 12:15:09
*/

@Api(tags = "库存调整")
@ApiSort(0)
@RestController("EamAssetStockGoodsAdjustController")
public class AssetStockGoodsAdjustController extends SuperController {

	@Autowired
	private IAssetStockGoodsAdjustService assetStockGoodsAdjustService;


	@Autowired
	private IGoodsStockService goodsStockService;

	/**
	 * 添加库存调整
	*/
	@ApiOperation(value = "添加库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CONTENT , value = "调整说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.INSERT)
	public Result insert(AssetStockGoodsAdjustVO assetStockGoodsAdjustVO) {
		Result result=assetStockGoodsAdjustService.insert(assetStockGoodsAdjustVO,false);
		return result;
	}



	/**
	 * 删除库存调整
	*/
	@ApiOperation(value = "删除库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetStockGoodsAdjustVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetStockGoodsAdjustService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除库存调整 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetStockGoodsAdjustVOMeta.IDS)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetStockGoodsAdjustService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新库存调整
	*/
	@ApiOperation(value = "更新库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CONTENT , value = "调整说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetStockGoodsAdjustVOMeta.PAGE_INDEX , AssetStockGoodsAdjustVOMeta.PAGE_SIZE , AssetStockGoodsAdjustVOMeta.SEARCH_FIELD , AssetStockGoodsAdjustVOMeta.FUZZY_FIELD , AssetStockGoodsAdjustVOMeta.SEARCH_VALUE , AssetStockGoodsAdjustVOMeta.DIRTY_FIELDS , AssetStockGoodsAdjustVOMeta.SORT_FIELD , AssetStockGoodsAdjustVOMeta.SORT_TYPE , AssetStockGoodsAdjustVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsAdjustVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.UPDATE)
	public Result update(AssetStockGoodsAdjustVO assetStockGoodsAdjustVO) {
		Result result=assetStockGoodsAdjustService.update(assetStockGoodsAdjustVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存库存调整
	*/
	@ApiOperation(value = "保存库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CONTENT , value = "调整说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsAdjustVOMeta.PAGE_INDEX , AssetStockGoodsAdjustVOMeta.PAGE_SIZE , AssetStockGoodsAdjustVOMeta.SEARCH_FIELD , AssetStockGoodsAdjustVOMeta.FUZZY_FIELD , AssetStockGoodsAdjustVOMeta.SEARCH_VALUE , AssetStockGoodsAdjustVOMeta.DIRTY_FIELDS , AssetStockGoodsAdjustVOMeta.SORT_FIELD , AssetStockGoodsAdjustVOMeta.SORT_TYPE , AssetStockGoodsAdjustVOMeta.IDS } )
	@NotNull(name = AssetStockGoodsAdjustVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.SAVE)
	public Result save(AssetStockGoodsAdjustVO assetStockGoodsAdjustVO) {
		Result result=assetStockGoodsAdjustService.save(assetStockGoodsAdjustVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取库存调整
	*/
	@ApiOperation(value = "获取库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetStockGoodsAdjustVOMeta.ID)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.GET_BY_ID)
	public Result<AssetStockGoodsAdjust> getById(String id) {
		Result<AssetStockGoodsAdjust> result=new Result<>();
		AssetStockGoodsAdjust assetStockGoodsAdjust=assetStockGoodsAdjustService.getById(id);
		// join 关联的对象
		assetStockGoodsAdjustService.dao().fill(assetStockGoodsAdjust)
			.with("originator")
			.with(AssetStockGoodsAdjustMeta.WAREHOUSE)
			.execute();

		assetStockGoodsAdjustService.dao().join(assetStockGoodsAdjust.getOriginator(), Person.class);


		GoodsStockVO vo=new GoodsStockVO();
		vo.setPageIndex(1);
		vo.setPageSize(1000);
		vo.setOwnerTmpId(id);
		PagedList<GoodsStock> list=goodsStockService.queryPagedListBySelected(vo,"","reset");
		goodsStockService.dao().fill(list)
				.with("ownerCompany")
				.with("useOrganization")
				.with("manager")
				.with("originator")
				.with(GoodsStockMeta.CATEGORY)
				.with(GoodsStockMeta.GOODS)
				.with(GoodsStockMeta.SOURCE)
				.with(GoodsStockMeta.WAREHOUSE)
				.with(GoodsMeta.CATEGORY)
				.with(GoodsStockMeta.BRAND)
				.with(GoodsMeta.MANUFACTURER)
				.execute();
		assetStockGoodsAdjust.setGoodsList(list.getList());


		result.success(true).data(assetStockGoodsAdjust);
		return result;
	}


	/**
	 * 批量获取库存调整 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取库存调整")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetStockGoodsAdjustVOMeta.IDS)
		@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.GET_BY_IDS)
	public Result<List<AssetStockGoodsAdjust>> getByIds(List<String> ids) {
		Result<List<AssetStockGoodsAdjust>> result=new Result<>();
		List<AssetStockGoodsAdjust> list=assetStockGoodsAdjustService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询库存调整
	*/
	@ApiOperation(value = "查询库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CONTENT , value = "调整说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockGoodsAdjustVOMeta.PAGE_INDEX , AssetStockGoodsAdjustVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.QUERY_LIST)
	public Result<List<AssetStockGoodsAdjust>> queryList(AssetStockGoodsAdjustVO sample) {
		Result<List<AssetStockGoodsAdjust>> result=new Result<>();
		List<AssetStockGoodsAdjust> list=assetStockGoodsAdjustService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询库存调整
	*/
	@ApiOperation(value = "分页查询库存调整")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.OWNER_TYPE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CONTENT , value = "调整说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockGoodsAdjustServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetStockGoodsAdjust>> queryPagedList(AssetStockGoodsAdjustVO sample) {
		Result<PagedList<AssetStockGoodsAdjust>> result=new Result<>();
		PagedList<AssetStockGoodsAdjust> list=assetStockGoodsAdjustService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetStockGoodsAdjustService.dao().fill(list)
			.with("originator")
			.with(AssetStockGoodsAdjustMeta.WAREHOUSE)
			.execute();

		List<Employee> originatorList= CollectorUtil.collectList(list, AssetStockGoodsAdjust::getOriginator);
		assetStockGoodsAdjustService.dao().join(originatorList, Person.class);


		result.success(true).data(list);
		return result;
	}

	/**
	 * 送审
	 * */
	@ApiOperation(value = "送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockGoodsAdjustVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetStockGoodsAdjustService.forApproval(id);
	}


	/**
	 * 确认
	 * */
	@ApiOperation(value = "确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockGoodsAdjustVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetStockGoodsAdjustService.confirmOperation(id);
	}


	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockGoodsAdjustVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockGoodsAdjustVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetStockGoodsAdjustService.revokeOperation(id);
	}


	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return assetStockGoodsAdjustService.approve(approveVO);
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetStockGoodsAdjustVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetStockGoodsAdjustService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetStockGoodsAdjustService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetStockGoodsAdjustServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockGoodsAdjustServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetStockGoodsAdjustService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}