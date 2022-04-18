package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.meta.AssetScrapVOMeta;
import com.dt.platform.proxy.eam.AssetScrapServiceProxy;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
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


import com.dt.platform.proxy.eam.AssetStockDeliverServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStockDeliverVOMeta;
import com.dt.platform.domain.eam.AssetStockDeliver;
import com.dt.platform.domain.eam.AssetStockDeliverVO;
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
import com.dt.platform.domain.eam.meta.AssetStockDeliverMeta;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStockDeliverService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库存出库 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-17 19:24:29
*/

@Api(tags = "库存出库")
@ApiSort(0)
@RestController("EamAssetStockDeliverController")
public class AssetStockDeliverController extends SuperController {

	@Autowired
	private IAssetStockDeliverService assetStockDeliverService;


	/**
	 * 添加库存出库
	*/
	@ApiOperation(value = "添加库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568150166721265664"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_STATUS , value = "出库状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_TYPE , value = "出库类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_DATE , value = "出货日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVING_COMPANY_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVING_ORG_ID , value = "领用部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.SHIPPER_NAME , value = "出货人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.CONTENT , value = "出库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetStockDeliverServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockDeliverServiceProxy.INSERT)
	public Result insert(AssetStockDeliverVO assetStockDeliverVO) {
		Result result=assetStockDeliverService.insert(assetStockDeliverVO,false);
		return result;
	}



	/**
	 * 删除库存出库
	*/
	@ApiOperation(value = "删除库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568150166721265664")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetStockDeliverVOMeta.ID)
	@SentinelResource(value = AssetStockDeliverServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockDeliverServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetStockDeliverService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除库存出库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetStockDeliverVOMeta.IDS)
	@SentinelResource(value = AssetStockDeliverServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockDeliverServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetStockDeliverService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新库存出库
	*/
	@ApiOperation(value = "更新库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568150166721265664"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_STATUS , value = "出库状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_TYPE , value = "出库类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_DATE , value = "出货日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVING_COMPANY_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVING_ORG_ID , value = "领用部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.SHIPPER_NAME , value = "出货人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.CONTENT , value = "出库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetStockDeliverVOMeta.PAGE_INDEX , AssetStockDeliverVOMeta.PAGE_SIZE , AssetStockDeliverVOMeta.SEARCH_FIELD , AssetStockDeliverVOMeta.FUZZY_FIELD , AssetStockDeliverVOMeta.SEARCH_VALUE , AssetStockDeliverVOMeta.DIRTY_FIELDS , AssetStockDeliverVOMeta.SORT_FIELD , AssetStockDeliverVOMeta.SORT_TYPE , AssetStockDeliverVOMeta.IDS } )
	@NotNull(name = AssetStockDeliverVOMeta.ID)
	@SentinelResource(value = AssetStockDeliverServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockDeliverServiceProxy.UPDATE)
	public Result update(AssetStockDeliverVO assetStockDeliverVO) {
		Result result=assetStockDeliverService.update(assetStockDeliverVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存库存出库
	*/
	@ApiOperation(value = "保存库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568150166721265664"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_STATUS , value = "出库状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_TYPE , value = "出库类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_DATE , value = "出货日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVING_COMPANY_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVING_ORG_ID , value = "领用部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.SHIPPER_NAME , value = "出货人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.CONTENT , value = "出库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockDeliverVOMeta.PAGE_INDEX , AssetStockDeliverVOMeta.PAGE_SIZE , AssetStockDeliverVOMeta.SEARCH_FIELD , AssetStockDeliverVOMeta.FUZZY_FIELD , AssetStockDeliverVOMeta.SEARCH_VALUE , AssetStockDeliverVOMeta.DIRTY_FIELDS , AssetStockDeliverVOMeta.SORT_FIELD , AssetStockDeliverVOMeta.SORT_TYPE , AssetStockDeliverVOMeta.IDS } )
	@NotNull(name = AssetStockDeliverVOMeta.ID)
	@SentinelResource(value = AssetStockDeliverServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockDeliverServiceProxy.SAVE)
	public Result save(AssetStockDeliverVO assetStockDeliverVO) {
		Result result=assetStockDeliverService.save(assetStockDeliverVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取库存出库
	*/
	@ApiOperation(value = "获取库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetStockDeliverVOMeta.ID)
	@SentinelResource(value = AssetStockDeliverServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockDeliverServiceProxy.GET_BY_ID)
	public Result<AssetStockDeliver> getById(String id) {
		Result<AssetStockDeliver> result=new Result<>();
		AssetStockDeliver assetStockDeliver=assetStockDeliverService.getById(id);
		// join 关联的对象
		assetStockDeliverService.dao().fill(assetStockDeliver)
			.with("receivingCompany")
			.with("receivingOrg")
			.with("originator")
			.with("receiver")
			.execute();
		result.success(true).data(assetStockDeliver);
		return result;
	}


	/**
	 * 批量获取库存出库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取库存出库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetStockDeliverVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetStockDeliverVOMeta.IDS)
		@SentinelResource(value = AssetStockDeliverServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockDeliverServiceProxy.GET_BY_IDS)
	public Result<List<AssetStockDeliver>> getByIds(List<String> ids) {
		Result<List<AssetStockDeliver>> result=new Result<>();
		List<AssetStockDeliver> list=assetStockDeliverService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询库存出库
	*/
	@ApiOperation(value = "查询库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568150166721265664"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_STATUS , value = "出库状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_TYPE , value = "出库类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_DATE , value = "出货日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVING_COMPANY_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVING_ORG_ID , value = "领用部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.SHIPPER_NAME , value = "出货人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.CONTENT , value = "出库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockDeliverVOMeta.PAGE_INDEX , AssetStockDeliverVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetStockDeliverServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockDeliverServiceProxy.QUERY_LIST)
	public Result<List<AssetStockDeliver>> queryList(AssetStockDeliverVO sample) {
		Result<List<AssetStockDeliver>> result=new Result<>();
		List<AssetStockDeliver> list=assetStockDeliverService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询库存出库
	*/
	@ApiOperation(value = "分页查询库存出库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "568150166721265664"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_STATUS , value = "出库状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_TYPE , value = "出库类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.DELIVER_DATE , value = "出货日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVING_COMPANY_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVING_ORG_ID , value = "领用部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.RECEIVER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.SHIPPER_NAME , value = "出货人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.CONTENT , value = "出库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockDeliverVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetStockDeliverServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockDeliverServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetStockDeliver>> queryPagedList(AssetStockDeliverVO sample) {
		Result<PagedList<AssetStockDeliver>> result=new Result<>();
		PagedList<AssetStockDeliver> list=assetStockDeliverService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetStockDeliverService.dao().fill(list)
			.with("receivingCompany")
			.with("receivingOrg")
			.with("originator")
			.with("receiver")
			.execute();
		result.success(true).data(list);
		return result;
	}

	/**
	 * 送审
	 * */
	@ApiOperation(value = "送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockDeliverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockDeliverVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetStockDeliverServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockDeliverServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetStockDeliverService.forApproval(id);
	}


	/**
	 * 确认
	 * */
	@ApiOperation(value = "确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockDeliverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockDeliverVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetStockDeliverServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockDeliverServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetStockDeliverService.confirmOperation(id);
	}


	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStockDeliverVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStockDeliverVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetStockDeliverServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockDeliverServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetStockDeliverService.revokeOperation(id);
	}


	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = AssetStockDeliverServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockDeliverServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return assetStockDeliverService.approve(approveVO);
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetStockDeliverServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockDeliverServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetStockDeliverVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetStockDeliverService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetStockDeliverServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockDeliverServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetStockDeliverService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetStockDeliverServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockDeliverServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetStockDeliverService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}