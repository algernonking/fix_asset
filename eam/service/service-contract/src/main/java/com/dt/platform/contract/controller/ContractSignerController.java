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


import com.dt.platform.proxy.contract.ContractSignerServiceProxy;
import com.dt.platform.domain.contract.meta.ContractSignerVOMeta;
import com.dt.platform.domain.contract.ContractSigner;
import com.dt.platform.domain.contract.ContractSignerVO;
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
import com.dt.platform.domain.contract.meta.ContractSignerMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.contract.service.IContractSignerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 合同签订方 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-08 17:04:16
*/

@Api(tags = "合同签订方")
@ApiSort(0)
@RestController("ContContractSignerController")
public class ContractSignerController extends SuperController {

	@Autowired
	private IContractSignerService contractSignerService;


	/**
	 * 添加合同签订方
	*/
	@ApiOperation(value = "添加合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTRACT_ID , value = "合同ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.SORT , value = "显示顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.TYPE , value = "签订方类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.IDENTITY_CDOE , value = "唯一代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.LANDLINE_NUMBER , value = "座机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.FAX_NUMBER , value = "传真号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PERSON , value = "联系人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PHONE , value = "联系人手机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ContractSignerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.INSERT)
	public Result insert(ContractSignerVO contractSignerVO) {
		Result result=contractSignerService.insert(contractSignerVO,false);
		return result;
	}



	/**
	 * 删除合同签订方
	*/
	@ApiOperation(value = "删除合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ContractSignerVOMeta.ID)
	@SentinelResource(value = ContractSignerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=contractSignerService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除合同签订方 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ContractSignerVOMeta.IDS)
	@SentinelResource(value = ContractSignerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=contractSignerService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新合同签订方
	*/
	@ApiOperation(value = "更新合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTRACT_ID , value = "合同ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.SORT , value = "显示顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.TYPE , value = "签订方类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.IDENTITY_CDOE , value = "唯一代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.LANDLINE_NUMBER , value = "座机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.FAX_NUMBER , value = "传真号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PERSON , value = "联系人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PHONE , value = "联系人手机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ContractSignerVOMeta.PAGE_INDEX , ContractSignerVOMeta.PAGE_SIZE , ContractSignerVOMeta.SEARCH_FIELD , ContractSignerVOMeta.FUZZY_FIELD , ContractSignerVOMeta.SEARCH_VALUE , ContractSignerVOMeta.DIRTY_FIELDS , ContractSignerVOMeta.SORT_FIELD , ContractSignerVOMeta.SORT_TYPE , ContractSignerVOMeta.IDS } )
	@NotNull(name = ContractSignerVOMeta.ID)
	@SentinelResource(value = ContractSignerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.UPDATE)
	public Result update(ContractSignerVO contractSignerVO) {
		Result result=contractSignerService.update(contractSignerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存合同签订方
	*/
	@ApiOperation(value = "保存合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTRACT_ID , value = "合同ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.SORT , value = "显示顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.TYPE , value = "签订方类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.IDENTITY_CDOE , value = "唯一代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.LANDLINE_NUMBER , value = "座机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.FAX_NUMBER , value = "传真号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PERSON , value = "联系人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PHONE , value = "联系人手机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractSignerVOMeta.PAGE_INDEX , ContractSignerVOMeta.PAGE_SIZE , ContractSignerVOMeta.SEARCH_FIELD , ContractSignerVOMeta.FUZZY_FIELD , ContractSignerVOMeta.SEARCH_VALUE , ContractSignerVOMeta.DIRTY_FIELDS , ContractSignerVOMeta.SORT_FIELD , ContractSignerVOMeta.SORT_TYPE , ContractSignerVOMeta.IDS } )
	@NotNull(name = ContractSignerVOMeta.ID)
	@SentinelResource(value = ContractSignerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.SAVE)
	public Result save(ContractSignerVO contractSignerVO) {
		Result result=contractSignerService.save(contractSignerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取合同签订方
	*/
	@ApiOperation(value = "获取合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ContractSignerVOMeta.ID)
	@SentinelResource(value = ContractSignerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.GET_BY_ID)
	public Result<ContractSigner> getById(String id) {
		Result<ContractSigner> result=new Result<>();
		ContractSigner contractSigner=contractSignerService.getById(id);
		result.success(true).data(contractSigner);
		return result;
	}


	/**
	 * 批量获取合同签订方 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取合同签订方")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ContractSignerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ContractSignerVOMeta.IDS)
		@SentinelResource(value = ContractSignerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.GET_BY_IDS)
	public Result<List<ContractSigner>> getByIds(List<String> ids) {
		Result<List<ContractSigner>> result=new Result<>();
		List<ContractSigner> list=contractSignerService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询合同签订方
	*/
	@ApiOperation(value = "查询合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTRACT_ID , value = "合同ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.SORT , value = "显示顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.TYPE , value = "签订方类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.IDENTITY_CDOE , value = "唯一代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.LANDLINE_NUMBER , value = "座机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.FAX_NUMBER , value = "传真号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PERSON , value = "联系人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PHONE , value = "联系人手机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractSignerVOMeta.PAGE_INDEX , ContractSignerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ContractSignerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.QUERY_LIST)
	public Result<List<ContractSigner>> queryList(ContractSignerVO sample) {
		Result<List<ContractSigner>> result=new Result<>();
		List<ContractSigner> list=contractSignerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询合同签订方
	*/
	@ApiOperation(value = "分页查询合同签订方")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractSignerVOMeta.ID , value = "id" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTRACT_ID , value = "合同ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.SORT , value = "显示顺序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ALIAS , value = "别名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.TYPE , value = "签订方类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.IDENTITY_CDOE , value = "唯一代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.LANDLINE_NUMBER , value = "座机号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.FAX_NUMBER , value = "传真号码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PERSON , value = "联系人姓名" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.CONTACT_PHONE , value = "联系人手机" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractSignerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ContractSignerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractSignerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ContractSigner>> queryPagedList(ContractSignerVO sample) {
		Result<PagedList<ContractSigner>> result=new Result<>();
		PagedList<ContractSigner> list=contractSignerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ContractSignerServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractSignerServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ContractSignerVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=contractSignerService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ContractSignerServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractSignerServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=contractSignerService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = ContractSignerServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractSignerServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=contractSignerService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}