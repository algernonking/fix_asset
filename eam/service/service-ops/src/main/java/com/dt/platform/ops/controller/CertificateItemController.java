package com.dt.platform.ops.controller;


import java.util.List;

import com.github.foxnic.commons.collection.CollectorUtil;
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


import com.dt.platform.proxy.ops.CertificateItemServiceProxy;
import com.dt.platform.domain.ops.meta.CertificateItemVOMeta;
import com.dt.platform.domain.ops.CertificateItem;
import com.dt.platform.domain.ops.CertificateItemVO;
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
import com.dt.platform.domain.ops.meta.CertificateItemMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICertificateItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 证书 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-14 21:45:38
*/

@Api(tags = "证书")
@ApiSort(0)
@RestController("OpsCertificateItemController")
public class CertificateItemController extends SuperController {

	@Autowired
	private ICertificateItemService certificateItemService;


	/**
	 * 添加证书
	*/
	@ApiOperation(value = "添加证书项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.CERTIFICATE_ID , value = "证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.END_DATE , value = "到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.PUBLIC_KEY , value = "公钥" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.PRIVATE_KEY , value = "私钥" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CertificateItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateItemServiceProxy.INSERT)
	public Result insert(CertificateItemVO certificateItemVO) {
		Result result=certificateItemService.insert(certificateItemVO,false);
		return result;
	}



	/**
	 * 删除证书
	*/
	@ApiOperation(value = "删除证书项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CertificateItemVOMeta.ID)
	@SentinelResource(value = CertificateItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=certificateItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除证书 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CertificateItemVOMeta.IDS)
	@SentinelResource(value = CertificateItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=certificateItemService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新证书
	*/
	@ApiOperation(value = "更新证书项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.CERTIFICATE_ID , value = "证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.END_DATE , value = "到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.PUBLIC_KEY , value = "公钥" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.PRIVATE_KEY , value = "私钥" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CertificateItemVOMeta.PAGE_INDEX , CertificateItemVOMeta.PAGE_SIZE , CertificateItemVOMeta.SEARCH_FIELD , CertificateItemVOMeta.FUZZY_FIELD , CertificateItemVOMeta.SEARCH_VALUE , CertificateItemVOMeta.DIRTY_FIELDS , CertificateItemVOMeta.SORT_FIELD , CertificateItemVOMeta.SORT_TYPE , CertificateItemVOMeta.IDS } )
	@NotNull(name = CertificateItemVOMeta.ID)
	@SentinelResource(value = CertificateItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateItemServiceProxy.UPDATE)
	public Result update(CertificateItemVO certificateItemVO) {
		Result result=certificateItemService.update(certificateItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存证书
	*/
	@ApiOperation(value = "保存证书项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.CERTIFICATE_ID , value = "证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.END_DATE , value = "到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.PUBLIC_KEY , value = "公钥" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.PRIVATE_KEY , value = "私钥" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CertificateItemVOMeta.PAGE_INDEX , CertificateItemVOMeta.PAGE_SIZE , CertificateItemVOMeta.SEARCH_FIELD , CertificateItemVOMeta.FUZZY_FIELD , CertificateItemVOMeta.SEARCH_VALUE , CertificateItemVOMeta.DIRTY_FIELDS , CertificateItemVOMeta.SORT_FIELD , CertificateItemVOMeta.SORT_TYPE , CertificateItemVOMeta.IDS } )
	@NotNull(name = CertificateItemVOMeta.ID)
	@SentinelResource(value = CertificateItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateItemServiceProxy.SAVE)
	public Result save(CertificateItemVO certificateItemVO) {
		Result result=certificateItemService.save(certificateItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取证书
	*/
	@ApiOperation(value = "获取证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CertificateItemVOMeta.ID)
	@SentinelResource(value = CertificateItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateItemServiceProxy.GET_BY_ID)
	public Result<CertificateItem> getById(String id) {
		Result<CertificateItem> result=new Result<>();
		CertificateItem certificateItem=certificateItemService.getById(id);
		// join 关联的对象
		certificateItemService.dao().fill(certificateItem)
			.with("operUser")
			.execute();

		certificateItemService.dao().join(certificateItem.getOperUser() , Person.class);
		result.success(true).data(certificateItem);
		return result;
	}


	/**
	 * 批量获取证书 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取证书")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CertificateItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CertificateItemVOMeta.IDS)
		@SentinelResource(value = CertificateItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateItemServiceProxy.GET_BY_IDS)
	public Result<List<CertificateItem>> getByIds(List<String> ids) {
		Result<List<CertificateItem>> result=new Result<>();
		List<CertificateItem> list=certificateItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询证书
	*/
	@ApiOperation(value = "查询证书项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.CERTIFICATE_ID , value = "证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.END_DATE , value = "到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.PUBLIC_KEY , value = "公钥" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.PRIVATE_KEY , value = "私钥" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CertificateItemVOMeta.PAGE_INDEX , CertificateItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CertificateItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateItemServiceProxy.QUERY_LIST)
	public Result<List<CertificateItem>> queryList(CertificateItemVO sample) {
		Result<List<CertificateItem>> result=new Result<>();
		List<CertificateItem> list=certificateItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询证书
	*/
	@ApiOperation(value = "分页查询证书项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.CERTIFICATE_ID , value = "证书" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.END_DATE , value = "到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.PUBLIC_KEY , value = "公钥" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.PRIVATE_KEY , value = "私钥" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.OPER_USER_ID , value = "操作人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateItemVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CertificateItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CertificateItem>> queryPagedList(CertificateItemVO sample) {
		Result<PagedList<CertificateItem>> result=new Result<>();
		PagedList<CertificateItem> list=certificateItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		certificateItemService.dao().fill(list)
			.with("operUser")
			.execute();
		List<Employee> operUser= CollectorUtil.collectList(list.getList(), CertificateItem::getOperUser);
		certificateItemService.dao().join(operUser, Person.class);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CertificateItemServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificateItemServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CertificateItemVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=certificateItemService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CertificateItemServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificateItemServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=certificateItemService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = CertificateItemServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificateItemServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=certificateItemService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}