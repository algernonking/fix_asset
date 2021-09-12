package com.dt.platform.contract.controller;

 
import java.util.List;

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


import com.dt.platform.proxy.contract.ContractServiceProxy;
import com.dt.platform.domain.contract.meta.ContractVOMeta;
import com.dt.platform.domain.contract.Contract;
import com.dt.platform.domain.contract.ContractVO;
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
import com.dt.platform.domain.contract.meta.ContractMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.contract.service.IContractService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 合同 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:05:32
*/

@Api(tags = "合同")
@ApiSort(0)
@RestController("ContContractController")
public class ContractController extends SuperController {

	@Autowired
	private IContractService contractService;

	
	/**
	 * 添加合同
	*/
	@ApiOperation(value = "添加合同")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.NAME , value = "合同名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.CODE , value = "合同编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.STATE , value = "合同状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FUND_STATUS , value = "资金状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.CATEGORY_ID , value = "合同类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.IDENTITY , value = "我方身份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FUND_DIRECT , value = "资金流向" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.MONEY , value = "金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractVOMeta.ALLMONEY , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractVOMeta.USER_ID , value = "承办人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.DEPT_ID , value = "承办人部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.BIDDING_ID , value = "关联招标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_COMPANY_NAME , value = "我方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_CONTACTS , value = "我方联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_CONTACT_INFORMATION , value = "我方联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_COMPANY_ID , value = "对方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_COMPANY_NAME , value = "对方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_CONTACTS , value = "对方单位联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_CONTACT_INFORMATION , value = "对方单位联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_UNIT , value = "监理单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_CONTACTS , value = "监理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_CONTACT_INFORMATION , value = "监理联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.EFFECT_TIME , value = "生效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.LOST_EFFECT_TIME , value = "失效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.AUDIT_TIME , value = "签订时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ContractVOMeta.ID)
	@SentinelResource(value = ContractServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractServiceProxy.INSERT)
	public Result insert(ContractVO contractVO) {
		Result result=contractService.insert(contractVO);
		return result;
	}

	
	/**
	 * 删除合同
	*/
	@ApiOperation(value = "删除合同")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ContractVOMeta.ID)
	@SentinelResource(value = ContractServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=contractService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除合同 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除合同")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ContractVOMeta.IDS)
	@SentinelResource(value = ContractServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=contractService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新合同
	*/
	@ApiOperation(value = "更新合同")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.NAME , value = "合同名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.CODE , value = "合同编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.STATE , value = "合同状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FUND_STATUS , value = "资金状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.CATEGORY_ID , value = "合同类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.IDENTITY , value = "我方身份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FUND_DIRECT , value = "资金流向" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.MONEY , value = "金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractVOMeta.ALLMONEY , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractVOMeta.USER_ID , value = "承办人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.DEPT_ID , value = "承办人部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.BIDDING_ID , value = "关联招标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_COMPANY_NAME , value = "我方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_CONTACTS , value = "我方联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_CONTACT_INFORMATION , value = "我方联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_COMPANY_ID , value = "对方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_COMPANY_NAME , value = "对方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_CONTACTS , value = "对方单位联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_CONTACT_INFORMATION , value = "对方单位联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_UNIT , value = "监理单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_CONTACTS , value = "监理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_CONTACT_INFORMATION , value = "监理联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.EFFECT_TIME , value = "生效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.LOST_EFFECT_TIME , value = "失效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.AUDIT_TIME , value = "签订时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ContractVOMeta.PAGE_INDEX , ContractVOMeta.PAGE_SIZE , ContractVOMeta.SEARCH_FIELD , ContractVOMeta.FUZZY_FIELD , ContractVOMeta.SEARCH_VALUE , ContractVOMeta.SORT_FIELD , ContractVOMeta.SORT_TYPE , ContractVOMeta.IDS } ) 
	@NotNull(name = ContractVOMeta.ID)
	@SentinelResource(value = ContractServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractServiceProxy.UPDATE)
	public Result update(ContractVO contractVO) {
		Result result=contractService.update(contractVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存合同
	*/
	@ApiOperation(value = "保存合同")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.NAME , value = "合同名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.CODE , value = "合同编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.STATE , value = "合同状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FUND_STATUS , value = "资金状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.CATEGORY_ID , value = "合同类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.IDENTITY , value = "我方身份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FUND_DIRECT , value = "资金流向" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.MONEY , value = "金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractVOMeta.ALLMONEY , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractVOMeta.USER_ID , value = "承办人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.DEPT_ID , value = "承办人部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.BIDDING_ID , value = "关联招标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_COMPANY_NAME , value = "我方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_CONTACTS , value = "我方联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_CONTACT_INFORMATION , value = "我方联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_COMPANY_ID , value = "对方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_COMPANY_NAME , value = "对方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_CONTACTS , value = "对方单位联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_CONTACT_INFORMATION , value = "对方单位联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_UNIT , value = "监理单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_CONTACTS , value = "监理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_CONTACT_INFORMATION , value = "监理联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.EFFECT_TIME , value = "生效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.LOST_EFFECT_TIME , value = "失效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.AUDIT_TIME , value = "签订时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractVOMeta.PAGE_INDEX , ContractVOMeta.PAGE_SIZE , ContractVOMeta.SEARCH_FIELD , ContractVOMeta.FUZZY_FIELD , ContractVOMeta.SEARCH_VALUE , ContractVOMeta.SORT_FIELD , ContractVOMeta.SORT_TYPE , ContractVOMeta.IDS } )
	@NotNull(name = ContractVOMeta.ID)
	@SentinelResource(value = ContractServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractServiceProxy.SAVE)
	public Result save(ContractVO contractVO) {
		Result result=contractService.save(contractVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取合同
	*/
	@ApiOperation(value = "获取合同")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ContractVOMeta.ID)
	@SentinelResource(value = ContractServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractServiceProxy.GET_BY_ID)
	public Result<Contract> getById(String id) {
		Result<Contract> result=new Result<>();
		Contract contract=contractService.getById(id);
		result.success(true).data(contract);
		return result;
	}


	/**
	 * 批量删除合同 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除合同")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ContractVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ContractVOMeta.IDS)
		@SentinelResource(value = ContractServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractServiceProxy.GET_BY_IDS)
	public Result<List<Contract>> getByIds(List<String> ids) {
		Result<List<Contract>> result=new Result<>();
		List<Contract> list=contractService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询合同
	*/
	@ApiOperation(value = "查询合同")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.NAME , value = "合同名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.CODE , value = "合同编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.STATE , value = "合同状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FUND_STATUS , value = "资金状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.CATEGORY_ID , value = "合同类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.IDENTITY , value = "我方身份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FUND_DIRECT , value = "资金流向" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.MONEY , value = "金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractVOMeta.ALLMONEY , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractVOMeta.USER_ID , value = "承办人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.DEPT_ID , value = "承办人部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.BIDDING_ID , value = "关联招标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_COMPANY_NAME , value = "我方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_CONTACTS , value = "我方联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_CONTACT_INFORMATION , value = "我方联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_COMPANY_ID , value = "对方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_COMPANY_NAME , value = "对方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_CONTACTS , value = "对方单位联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_CONTACT_INFORMATION , value = "对方单位联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_UNIT , value = "监理单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_CONTACTS , value = "监理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_CONTACT_INFORMATION , value = "监理联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.EFFECT_TIME , value = "生效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.LOST_EFFECT_TIME , value = "失效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.AUDIT_TIME , value = "签订时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractVOMeta.PAGE_INDEX , ContractVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ContractServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractServiceProxy.QUERY_LIST)
	public Result<List<Contract>> queryList(ContractVO sample) {
		Result<List<Contract>> result=new Result<>();
		List<Contract> list=contractService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询合同
	*/
	@ApiOperation(value = "分页查询合同")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.NAME , value = "合同名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.CODE , value = "合同编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.STATE , value = "合同状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FUND_STATUS , value = "资金状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.CATEGORY_ID , value = "合同类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.IDENTITY , value = "我方身份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FUND_DIRECT , value = "资金流向" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.MONEY , value = "金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractVOMeta.ALLMONEY , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractVOMeta.USER_ID , value = "承办人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.DEPT_ID , value = "承办人部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.BIDDING_ID , value = "关联招标" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_COMPANY_NAME , value = "我方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_CONTACTS , value = "我方联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.FIRST_CONTACT_INFORMATION , value = "我方联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_COMPANY_ID , value = "对方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_COMPANY_NAME , value = "对方单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_CONTACTS , value = "对方单位联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.RELATED_CONTACT_INFORMATION , value = "对方单位联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_UNIT , value = "监理单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_CONTACTS , value = "监理人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.SUPERVISION_CONTACT_INFORMATION , value = "监理联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.EFFECT_TIME , value = "生效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.LOST_EFFECT_TIME , value = "失效时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.AUDIT_TIME , value = "签订时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ContractServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Contract>> queryPagedList(ContractVO sample) {
		Result<PagedList<Contract>> result=new Result<>();
		PagedList<Contract> list=contractService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ContractServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ContractVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=contractService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ContractServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=contractService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ContractServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=contractService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}