package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.meta.AssetSoftwareVOMeta;
import com.dt.platform.proxy.eam.AssetSoftwareServiceProxy;
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


import com.dt.platform.proxy.eam.AssetSoftwareDistributeServiceProxy;
import com.dt.platform.domain.eam.meta.AssetSoftwareDistributeVOMeta;
import com.dt.platform.domain.eam.AssetSoftwareDistribute;
import com.dt.platform.domain.eam.AssetSoftwareDistributeVO;
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
import com.dt.platform.domain.eam.meta.AssetSoftwareDistributeMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetSoftware;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetSoftwareDistributeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 软件分发 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-04 20:10:32
*/

@Api(tags = "软件分发")
@ApiSort(0)
@RestController("EamAssetSoftwareDistributeController")
public class AssetSoftwareDistributeController extends SuperController {

	@Autowired
	private IAssetSoftwareDistributeService assetSoftwareDistributeService;


	/**
	 * 添加软件分发
	*/
	@ApiOperation(value = "添加软件分发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574323100137553920"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.USE_ORG_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.USE_USER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class , example = "2022-05-10 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ASSET_ID , value = "关联资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ASSET_SOFTWARE_ID , value = "软件资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeServiceProxy.INSERT)
	public Result insert(AssetSoftwareDistributeVO assetSoftwareDistributeVO) {
		Result result=assetSoftwareDistributeService.insert(assetSoftwareDistributeVO,false);
		return result;
	}



	/**
	 * 删除软件分发
	*/
	@ApiOperation(value = "删除软件分发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574323100137553920")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetSoftwareDistributeVOMeta.ID)
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetSoftwareDistributeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除软件分发 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除软件分发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetSoftwareDistributeVOMeta.IDS)
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetSoftwareDistributeService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新软件分发
	*/
	@ApiOperation(value = "更新软件分发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574323100137553920"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.USE_ORG_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.USE_USER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class , example = "2022-05-10 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ASSET_ID , value = "关联资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ASSET_SOFTWARE_ID , value = "软件资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetSoftwareDistributeVOMeta.PAGE_INDEX , AssetSoftwareDistributeVOMeta.PAGE_SIZE , AssetSoftwareDistributeVOMeta.SEARCH_FIELD , AssetSoftwareDistributeVOMeta.FUZZY_FIELD , AssetSoftwareDistributeVOMeta.SEARCH_VALUE , AssetSoftwareDistributeVOMeta.DIRTY_FIELDS , AssetSoftwareDistributeVOMeta.SORT_FIELD , AssetSoftwareDistributeVOMeta.SORT_TYPE , AssetSoftwareDistributeVOMeta.IDS } )
	@NotNull(name = AssetSoftwareDistributeVOMeta.ID)
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeServiceProxy.UPDATE)
	public Result update(AssetSoftwareDistributeVO assetSoftwareDistributeVO) {
		Result result=assetSoftwareDistributeService.update(assetSoftwareDistributeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存软件分发
	*/
	@ApiOperation(value = "保存软件分发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574323100137553920"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.USE_ORG_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.USE_USER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class , example = "2022-05-10 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ASSET_ID , value = "关联资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ASSET_SOFTWARE_ID , value = "软件资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareDistributeVOMeta.PAGE_INDEX , AssetSoftwareDistributeVOMeta.PAGE_SIZE , AssetSoftwareDistributeVOMeta.SEARCH_FIELD , AssetSoftwareDistributeVOMeta.FUZZY_FIELD , AssetSoftwareDistributeVOMeta.SEARCH_VALUE , AssetSoftwareDistributeVOMeta.DIRTY_FIELDS , AssetSoftwareDistributeVOMeta.SORT_FIELD , AssetSoftwareDistributeVOMeta.SORT_TYPE , AssetSoftwareDistributeVOMeta.IDS } )
	@NotNull(name = AssetSoftwareDistributeVOMeta.ID)
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeServiceProxy.SAVE)
	public Result save(AssetSoftwareDistributeVO assetSoftwareDistributeVO) {
		Result result=assetSoftwareDistributeService.save(assetSoftwareDistributeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取软件分发
	*/
	@ApiOperation(value = "获取软件分发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetSoftwareDistributeVOMeta.ID)
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeServiceProxy.GET_BY_ID)
	public Result<AssetSoftwareDistribute> getById(String id) {
		Result<AssetSoftwareDistribute> result=new Result<>();
		AssetSoftwareDistribute assetSoftwareDistribute=assetSoftwareDistributeService.getById(id);
		// join 关联的对象
		assetSoftwareDistributeService.dao().fill(assetSoftwareDistribute)
			.with("useOrganization")
			.with("useUser")
			.with("originator")
			.execute();
		assetSoftwareDistributeService.dao().join(assetSoftwareDistribute.getOriginator(), Person.class);
		assetSoftwareDistributeService.dao().join(assetSoftwareDistribute.getUseUser(), Person.class);

		result.success(true).data(assetSoftwareDistribute);
		return result;
	}


	/**
	 * 批量获取软件分发 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取软件分发")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetSoftwareDistributeVOMeta.IDS)
		@SentinelResource(value = AssetSoftwareDistributeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeServiceProxy.GET_BY_IDS)
	public Result<List<AssetSoftwareDistribute>> getByIds(List<String> ids) {
		Result<List<AssetSoftwareDistribute>> result=new Result<>();
		List<AssetSoftwareDistribute> list=assetSoftwareDistributeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询软件分发
	*/
	@ApiOperation(value = "查询软件分发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574323100137553920"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.USE_ORG_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.USE_USER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class , example = "2022-05-10 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ASSET_ID , value = "关联资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ASSET_SOFTWARE_ID , value = "软件资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareDistributeVOMeta.PAGE_INDEX , AssetSoftwareDistributeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeServiceProxy.QUERY_LIST)
	public Result<List<AssetSoftwareDistribute>> queryList(AssetSoftwareDistributeVO sample) {
		Result<List<AssetSoftwareDistribute>> result=new Result<>();
		List<AssetSoftwareDistribute> list=assetSoftwareDistributeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询软件分发
	*/
	@ApiOperation(value = "分页查询软件分发")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574323100137553920"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.USE_ORG_ID , value = "领用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.USE_USER_ID , value = "领用人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class , example = "2022-05-10 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ASSET_ID , value = "关联资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ASSET_SOFTWARE_ID , value = "软件资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetSoftwareDistribute>> queryPagedList(AssetSoftwareDistributeVO sample) {
		Result<PagedList<AssetSoftwareDistribute>> result=new Result<>();
		PagedList<AssetSoftwareDistribute> list=assetSoftwareDistributeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetSoftwareDistributeService.dao().fill(list)
			.with("useOrganization")
			.with("useUser")
			.with("originator")
			.execute();
		List<Employee> originatorList= CollectorUtil.collectList(list, AssetSoftwareDistribute::getOriginator);
		assetSoftwareDistributeService.dao().join(originatorList, Person.class);

		List<Employee> managerList= CollectorUtil.collectList(list, AssetSoftwareDistribute::getUseUser);
		assetSoftwareDistributeService.dao().join(managerList, Person.class);
		result.success(true).data(list);

		return result;
	}


	/**
	 * 送审
	 * */
	@ApiOperation(value = "送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareDistributeVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareDistributeServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetSoftwareDistributeService.forApproval(id);
	}


	/**
	 * 确认
	 * */
	@ApiOperation(value = "确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareDistributeVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareDistributeServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetSoftwareDistributeService.confirmOperation(id);
	}


	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareDistributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareDistributeVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareDistributeServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetSoftwareDistributeService.revokeOperation(id);
	}



	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareDistributeServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return assetSoftwareDistributeService.approve(approveVO);
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareDistributeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetSoftwareDistributeVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetSoftwareDistributeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareDistributeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetSoftwareDistributeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetSoftwareDistributeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareDistributeServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetSoftwareDistributeService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}