package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.AssetStockGoodsIn;
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


import com.dt.platform.proxy.eam.AssetSoftwareServiceProxy;
import com.dt.platform.domain.eam.meta.AssetSoftwareVOMeta;
import com.dt.platform.domain.eam.AssetSoftware;
import com.dt.platform.domain.eam.AssetSoftwareVO;
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
import com.dt.platform.domain.eam.meta.AssetSoftwareMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.pcm.Catalog;
import com.dt.platform.domain.eam.Supplier;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetSoftwareService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 软件资产 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-04 19:59:02
*/

@Api(tags = "软件资产")
@ApiSort(0)
@RestController("EamAssetSoftwareController")
public class AssetSoftwareController extends SuperController {

	@Autowired
	private IAssetSoftwareService assetSoftwareService;


	/**
	 * 添加软件资产
	*/
	@ApiOperation(value = "添加软件资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574232023040786432"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NAME , value = "软件名称" , required = false , dataTypeClass=String.class , example = "测试"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CATEGORY_ID , value = "软件分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CODE , value = "软件编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOFTWARE_VERSION , value = "软件版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.COPYRIGHT_TYPE , value = "版权类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LICENSE_MODE , value = "许可方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.COST_PRICE , value = "成本" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.USE_ORGANIZATION_ID , value = "使用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOURCE_DETAIL , value = "来源明细" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_INFO , value = "授权信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_NUMBER , value = "授权数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_AVAILABLE_NUMBER , value = "可用数量" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_NUMBER_UNLIMIT , value = "无限授权" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_CODE , value = "授权码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_EXPIRATION_DATE , value = "授权到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_EXPIRATION_UNLIMIT , value = "永久授权" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEED_MAINTENANCE , value = "是否维保" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class , example = "2022-05-04 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.REGISTER_DATE , value = "登记时间" , required = false , dataTypeClass=Date.class , example = "2022-05-04 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CONTENT , value = "软件说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL4 , value = "标签4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetSoftwareServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareServiceProxy.INSERT)
	public Result insert(AssetSoftwareVO assetSoftwareVO) {
		Result result=assetSoftwareService.insert(assetSoftwareVO,false);
		return result;
	}



	/**
	 * 删除软件资产
	*/
	@ApiOperation(value = "删除软件资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574232023040786432")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetSoftwareVOMeta.ID)
	@SentinelResource(value = AssetSoftwareServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetSoftwareService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除软件资产 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除软件资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetSoftwareVOMeta.IDS)
	@SentinelResource(value = AssetSoftwareServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetSoftwareService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新软件资产
	*/
	@ApiOperation(value = "更新软件资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574232023040786432"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NAME , value = "软件名称" , required = false , dataTypeClass=String.class , example = "测试"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CATEGORY_ID , value = "软件分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CODE , value = "软件编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOFTWARE_VERSION , value = "软件版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.COPYRIGHT_TYPE , value = "版权类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LICENSE_MODE , value = "许可方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.COST_PRICE , value = "成本" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.USE_ORGANIZATION_ID , value = "使用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOURCE_DETAIL , value = "来源明细" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_INFO , value = "授权信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_NUMBER , value = "授权数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_AVAILABLE_NUMBER , value = "可用数量" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_NUMBER_UNLIMIT , value = "无限授权" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_CODE , value = "授权码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_EXPIRATION_DATE , value = "授权到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_EXPIRATION_UNLIMIT , value = "永久授权" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEED_MAINTENANCE , value = "是否维保" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class , example = "2022-05-04 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.REGISTER_DATE , value = "登记时间" , required = false , dataTypeClass=Date.class , example = "2022-05-04 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CONTENT , value = "软件说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL4 , value = "标签4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetSoftwareVOMeta.PAGE_INDEX , AssetSoftwareVOMeta.PAGE_SIZE , AssetSoftwareVOMeta.SEARCH_FIELD , AssetSoftwareVOMeta.FUZZY_FIELD , AssetSoftwareVOMeta.SEARCH_VALUE , AssetSoftwareVOMeta.DIRTY_FIELDS , AssetSoftwareVOMeta.SORT_FIELD , AssetSoftwareVOMeta.SORT_TYPE , AssetSoftwareVOMeta.IDS } )
	@NotNull(name = AssetSoftwareVOMeta.ID)
	@SentinelResource(value = AssetSoftwareServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareServiceProxy.UPDATE)
	public Result update(AssetSoftwareVO assetSoftwareVO) {
		Result result=assetSoftwareService.update(assetSoftwareVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存软件资产
	*/
	@ApiOperation(value = "保存软件资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574232023040786432"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NAME , value = "软件名称" , required = false , dataTypeClass=String.class , example = "测试"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CATEGORY_ID , value = "软件分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CODE , value = "软件编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOFTWARE_VERSION , value = "软件版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.COPYRIGHT_TYPE , value = "版权类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LICENSE_MODE , value = "许可方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.COST_PRICE , value = "成本" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.USE_ORGANIZATION_ID , value = "使用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOURCE_DETAIL , value = "来源明细" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_INFO , value = "授权信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_NUMBER , value = "授权数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_AVAILABLE_NUMBER , value = "可用数量" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_NUMBER_UNLIMIT , value = "无限授权" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_CODE , value = "授权码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_EXPIRATION_DATE , value = "授权到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_EXPIRATION_UNLIMIT , value = "永久授权" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEED_MAINTENANCE , value = "是否维保" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class , example = "2022-05-04 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.REGISTER_DATE , value = "登记时间" , required = false , dataTypeClass=Date.class , example = "2022-05-04 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CONTENT , value = "软件说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL4 , value = "标签4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareVOMeta.PAGE_INDEX , AssetSoftwareVOMeta.PAGE_SIZE , AssetSoftwareVOMeta.SEARCH_FIELD , AssetSoftwareVOMeta.FUZZY_FIELD , AssetSoftwareVOMeta.SEARCH_VALUE , AssetSoftwareVOMeta.DIRTY_FIELDS , AssetSoftwareVOMeta.SORT_FIELD , AssetSoftwareVOMeta.SORT_TYPE , AssetSoftwareVOMeta.IDS } )
	@NotNull(name = AssetSoftwareVOMeta.ID)
	@SentinelResource(value = AssetSoftwareServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareServiceProxy.SAVE)
	public Result save(AssetSoftwareVO assetSoftwareVO) {
		Result result=assetSoftwareService.save(assetSoftwareVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取软件资产
	*/
	@ApiOperation(value = "获取软件资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetSoftwareVOMeta.ID)
	@SentinelResource(value = AssetSoftwareServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareServiceProxy.GET_BY_ID)
	public Result<AssetSoftware> getById(String id) {
		Result<AssetSoftware> result=new Result<>();
		AssetSoftware assetSoftware=assetSoftwareService.getById(id);
		// join 关联的对象
		assetSoftwareService.dao().fill(assetSoftware)
			.with("ownerCompany")
			.with("useOrganization")
			.with("manager")
			.with("originator")
			.with(AssetSoftwareMeta.CATEGORY)
			.with(AssetSoftwareMeta.SUPPLIER)
			.with(AssetSoftwareMeta.SOURCE)
			.with(AssetSoftwareMeta.COPYRIGHT_TYPE_DICT)
			.with(AssetSoftwareMeta.LICENSE_MODE_DICT)
			.execute();
		assetSoftwareService.dao().join(assetSoftware.getOriginator(), Person.class);
		assetSoftwareService.dao().join(assetSoftware.getManager(), Person.class);

		result.success(true).data(assetSoftware);
		return result;
	}


	/**
	 * 批量获取软件资产 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取软件资产")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetSoftwareVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetSoftwareVOMeta.IDS)
		@SentinelResource(value = AssetSoftwareServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareServiceProxy.GET_BY_IDS)
	public Result<List<AssetSoftware>> getByIds(List<String> ids) {
		Result<List<AssetSoftware>> result=new Result<>();
		List<AssetSoftware> list=assetSoftwareService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询软件资产
	*/
	@ApiOperation(value = "查询软件资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574232023040786432"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NAME , value = "软件名称" , required = false , dataTypeClass=String.class , example = "测试"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CATEGORY_ID , value = "软件分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CODE , value = "软件编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOFTWARE_VERSION , value = "软件版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.COPYRIGHT_TYPE , value = "版权类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LICENSE_MODE , value = "许可方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.COST_PRICE , value = "成本" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.USE_ORGANIZATION_ID , value = "使用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOURCE_DETAIL , value = "来源明细" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_INFO , value = "授权信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_NUMBER , value = "授权数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_AVAILABLE_NUMBER , value = "可用数量" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_NUMBER_UNLIMIT , value = "无限授权" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_CODE , value = "授权码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_EXPIRATION_DATE , value = "授权到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_EXPIRATION_UNLIMIT , value = "永久授权" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEED_MAINTENANCE , value = "是否维保" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class , example = "2022-05-04 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.REGISTER_DATE , value = "登记时间" , required = false , dataTypeClass=Date.class , example = "2022-05-04 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CONTENT , value = "软件说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL4 , value = "标签4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareVOMeta.PAGE_INDEX , AssetSoftwareVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetSoftwareServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareServiceProxy.QUERY_LIST)
	public Result<List<AssetSoftware>> queryList(AssetSoftwareVO sample) {
		Result<List<AssetSoftware>> result=new Result<>();
		List<AssetSoftware> list=assetSoftwareService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询软件资产
	*/
	@ApiOperation(value = "分页查询软件资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "574232023040786432"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NAME , value = "软件名称" , required = false , dataTypeClass=String.class , example = "测试"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CATEGORY_ID , value = "软件分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CODE , value = "软件编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOFTWARE_VERSION , value = "软件版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.COPYRIGHT_TYPE , value = "版权类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LICENSE_MODE , value = "许可方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.COST_PRICE , value = "成本" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.USE_ORGANIZATION_ID , value = "使用公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MANAGER_ID , value = "管理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SOURCE_DETAIL , value = "来源明细" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_INFO , value = "授权信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_NUMBER , value = "授权数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_AVAILABLE_NUMBER , value = "可用数量" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZED_NUMBER_UNLIMIT , value = "无限授权" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_CODE , value = "授权码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_EXPIRATION_DATE , value = "授权到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.AUTHORIZATION_EXPIRATION_UNLIMIT , value = "永久授权" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEED_MAINTENANCE , value = "是否维保" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.PURCHASE_DATE , value = "购置日期" , required = false , dataTypeClass=Date.class , example = "2022-05-04 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.REGISTER_DATE , value = "登记时间" , required = false , dataTypeClass=Date.class , example = "2022-05-04 12:00:00"),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CONTENT , value = "软件说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL3 , value = "标签3" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LABEL4 , value = "标签4" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_STATUS , value = "变更状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHS_VERSION , value = "变更版本号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.CHANGE_INSTANCE_ID , value = "变更ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.SUMMARY , value = "流程概要" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LATEST_APPROVER_ID , value = "最后审批人账户ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.LATEST_APPROVER_NAME , value = "最后审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEXT_APPROVER_IDS , value = "下一节点审批人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.NEXT_APPROVER_NAMES , value = "下一个审批节点审批人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareVOMeta.APPROVAL_OPINION , value = "审批意见" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetSoftwareServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetSoftware>> queryPagedList(AssetSoftwareVO sample) {
		Result<PagedList<AssetSoftware>> result=new Result<>();
		PagedList<AssetSoftware> list=assetSoftwareService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetSoftwareService.dao().fill(list)
			.with("ownerCompany")
			.with("useOrganization")
			.with("manager")
			.with("originator")
			.with(AssetSoftwareMeta.CATEGORY)
			.with(AssetSoftwareMeta.SUPPLIER)
			.with(AssetSoftwareMeta.SOURCE)
			.with(AssetSoftwareMeta.COPYRIGHT_TYPE_DICT)
			.with(AssetSoftwareMeta.LICENSE_MODE_DICT)
			.execute();
		List<Employee> originatorList= CollectorUtil.collectList(list, AssetSoftware::getOriginator);
		assetSoftwareService.dao().join(originatorList, Person.class);

		List<Employee> managerList= CollectorUtil.collectList(list, AssetSoftware::getManager);
		assetSoftwareService.dao().join(managerList, Person.class);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 送审
	 * */
	@ApiOperation(value = "送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetSoftwareServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetSoftwareService.forApproval(id);
	}


	/**
	 * 确认
	 * */
	@ApiOperation(value = "确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetSoftwareServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetSoftwareService.confirmOperation(id);
	}


	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetSoftwareServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetSoftwareService.revokeOperation(id);
	}



	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = AssetSoftwareServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return assetSoftwareService.approve(approveVO);
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetSoftwareServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetSoftwareVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetSoftwareService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetSoftwareServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetSoftwareService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetSoftwareServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetSoftwareService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}