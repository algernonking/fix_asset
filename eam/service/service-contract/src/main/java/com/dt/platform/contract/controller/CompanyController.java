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


import com.dt.platform.proxy.contract.CompanyServiceProxy;
import com.dt.platform.domain.contract.meta.CompanyVOMeta;
import com.dt.platform.domain.contract.Company;
import com.dt.platform.domain.contract.CompanyVO;
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
import com.dt.platform.domain.contract.meta.CompanyMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.contract.service.ICompanyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 单位 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 02:48:13
*/

@Api(tags = "单位")
@ApiSort(0)
@RestController("ContCompanyController")
public class CompanyController extends SuperController {

	@Autowired
	private ICompanyService companyService;

	
	/**
	 * 添加单位
	*/
	@ApiOperation(value = "添加单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485780633629495296"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "单位" , required = false , dataTypeClass=String.class , example = "杭州一服科技有限公司"),
		@ApiImplicitParam(name = CompanyVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CREDIT_CODE , value = "信用代码" , required = false , dataTypeClass=String.class , example = "34567y8u"),
		@ApiImplicitParam(name = CompanyVOMeta.PROFILE , value = "介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CompanyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.INSERT)
	public Result insert(CompanyVO companyVO) {
		Result result=companyService.insert(companyVO);
		return result;
	}

	
	/**
	 * 删除单位
	*/
	@ApiOperation(value = "删除单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485780633629495296")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CompanyVOMeta.ID)
	@SentinelResource(value = CompanyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=companyService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除单位 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CompanyVOMeta.IDS)
	@SentinelResource(value = CompanyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=companyService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新单位
	*/
	@ApiOperation(value = "更新单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485780633629495296"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "单位" , required = false , dataTypeClass=String.class , example = "杭州一服科技有限公司"),
		@ApiImplicitParam(name = CompanyVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CREDIT_CODE , value = "信用代码" , required = false , dataTypeClass=String.class , example = "34567y8u"),
		@ApiImplicitParam(name = CompanyVOMeta.PROFILE , value = "介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE , CompanyVOMeta.SEARCH_FIELD , CompanyVOMeta.FUZZY_FIELD , CompanyVOMeta.SEARCH_VALUE , CompanyVOMeta.SORT_FIELD , CompanyVOMeta.SORT_TYPE , CompanyVOMeta.IDS } ) 
	@NotNull(name = CompanyVOMeta.ID)
	@SentinelResource(value = CompanyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.UPDATE)
	public Result update(CompanyVO companyVO) {
		Result result=companyService.update(companyVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存单位
	*/
	@ApiOperation(value = "保存单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485780633629495296"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "单位" , required = false , dataTypeClass=String.class , example = "杭州一服科技有限公司"),
		@ApiImplicitParam(name = CompanyVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CREDIT_CODE , value = "信用代码" , required = false , dataTypeClass=String.class , example = "34567y8u"),
		@ApiImplicitParam(name = CompanyVOMeta.PROFILE , value = "介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE , CompanyVOMeta.SEARCH_FIELD , CompanyVOMeta.FUZZY_FIELD , CompanyVOMeta.SEARCH_VALUE , CompanyVOMeta.SORT_FIELD , CompanyVOMeta.SORT_TYPE , CompanyVOMeta.IDS } )
	@NotNull(name = CompanyVOMeta.ID)
	@SentinelResource(value = CompanyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.SAVE)
	public Result save(CompanyVO companyVO) {
		Result result=companyService.save(companyVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取单位
	*/
	@ApiOperation(value = "获取单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CompanyVOMeta.ID)
	@SentinelResource(value = CompanyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.GET_BY_ID)
	public Result<Company> getById(String id) {
		Result<Company> result=new Result<>();
		Company company=companyService.getById(id);
		result.success(true).data(company);
		return result;
	}


	/**
	 * 批量获取单位 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取单位")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CompanyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CompanyVOMeta.IDS)
		@SentinelResource(value = CompanyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.GET_BY_IDS)
	public Result<List<Company>> getByIds(List<String> ids) {
		Result<List<Company>> result=new Result<>();
		List<Company> list=companyService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询单位
	*/
	@ApiOperation(value = "查询单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485780633629495296"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "单位" , required = false , dataTypeClass=String.class , example = "杭州一服科技有限公司"),
		@ApiImplicitParam(name = CompanyVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CREDIT_CODE , value = "信用代码" , required = false , dataTypeClass=String.class , example = "34567y8u"),
		@ApiImplicitParam(name = CompanyVOMeta.PROFILE , value = "介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CompanyVOMeta.PAGE_INDEX , CompanyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CompanyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.QUERY_LIST)
	public Result<List<Company>> queryList(CompanyVO sample) {
		Result<List<Company>> result=new Result<>();
		List<Company> list=companyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询单位
	*/
	@ApiOperation(value = "分页查询单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485780633629495296"),
		@ApiImplicitParam(name = CompanyVOMeta.NAME , value = "单位" , required = false , dataTypeClass=String.class , example = "杭州一服科技有限公司"),
		@ApiImplicitParam(name = CompanyVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.CREDIT_CODE , value = "信用代码" , required = false , dataTypeClass=String.class , example = "34567y8u"),
		@ApiImplicitParam(name = CompanyVOMeta.PROFILE , value = "介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CompanyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CompanyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Company>> queryPagedList(CompanyVO sample) {
		Result<PagedList<Company>> result=new Result<>();
		PagedList<Company> list=companyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CompanyServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CompanyServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CompanyVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=companyService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CompanyServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CompanyServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=companyService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = CompanyServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CompanyServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=companyService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}