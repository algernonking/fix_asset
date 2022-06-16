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


import com.dt.platform.proxy.ops.CertificateServiceProxy;
import com.dt.platform.domain.ops.meta.CertificateVOMeta;
import com.dt.platform.domain.ops.Certificate;
import com.dt.platform.domain.ops.CertificateVO;
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
import com.dt.platform.domain.ops.meta.CertificateMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.ops.CertificateType;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICertificateService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 证书 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-14 21:47:25
*/

@Api(tags = "证书")
@ApiSort(0)
@RestController("OpsCertificateController")
public class CertificateController extends SuperController {

	@Autowired
	private ICertificateService certificateService;


	/**
	 * 添加证书
	*/
	@ApiOperation(value = "添加证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.PROJECT , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateVOMeta.END_DATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CertificateServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.INSERT)
	public Result insert(CertificateVO certificateVO) {
		Result result=certificateService.insert(certificateVO,false);
		return result;
	}



	/**
	 * 删除证书
	*/
	@ApiOperation(value = "删除证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CertificateVOMeta.ID)
	@SentinelResource(value = CertificateServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=certificateService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除证书 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CertificateVOMeta.IDS)
	@SentinelResource(value = CertificateServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=certificateService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新证书
	*/
	@ApiOperation(value = "更新证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.PROJECT , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateVOMeta.END_DATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CertificateVOMeta.PAGE_INDEX , CertificateVOMeta.PAGE_SIZE , CertificateVOMeta.SEARCH_FIELD , CertificateVOMeta.FUZZY_FIELD , CertificateVOMeta.SEARCH_VALUE , CertificateVOMeta.DIRTY_FIELDS , CertificateVOMeta.SORT_FIELD , CertificateVOMeta.SORT_TYPE , CertificateVOMeta.IDS } )
	@NotNull(name = CertificateVOMeta.ID)
	@SentinelResource(value = CertificateServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.UPDATE)
	public Result update(CertificateVO certificateVO) {
		Result result=certificateService.update(certificateVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存证书
	*/
	@ApiOperation(value = "保存证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.PROJECT , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateVOMeta.END_DATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CertificateVOMeta.PAGE_INDEX , CertificateVOMeta.PAGE_SIZE , CertificateVOMeta.SEARCH_FIELD , CertificateVOMeta.FUZZY_FIELD , CertificateVOMeta.SEARCH_VALUE , CertificateVOMeta.DIRTY_FIELDS , CertificateVOMeta.SORT_FIELD , CertificateVOMeta.SORT_TYPE , CertificateVOMeta.IDS } )
	@NotNull(name = CertificateVOMeta.ID)
	@SentinelResource(value = CertificateServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.SAVE)
	public Result save(CertificateVO certificateVO) {
		Result result=certificateService.save(certificateVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取证书
	*/
	@ApiOperation(value = "获取证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CertificateVOMeta.ID)
	@SentinelResource(value = CertificateServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.GET_BY_ID)
	public Result<Certificate> getById(String id) {
		Result<Certificate> result=new Result<>();
		Certificate certificate=certificateService.getById(id);
		// join 关联的对象
		certificateService.dao().fill(certificate)
			.with("originator")
				.with(CertificateMeta.CERTIFICATE_POSITION)
				.with(CertificateMeta.CERTIFICATE_TYPE)
			.execute();

		certificateService.dao().join(certificate.getOriginator(), Person.class);
		result.success(true).data(certificate);
		return result;
	}


	/**
	 * 批量获取证书 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取证书")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CertificateVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CertificateVOMeta.IDS)
		@SentinelResource(value = CertificateServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.GET_BY_IDS)
	public Result<List<Certificate>> getByIds(List<String> ids) {
		Result<List<Certificate>> result=new Result<>();
		List<Certificate> list=certificateService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询证书
	*/
	@ApiOperation(value = "查询证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.PROJECT , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateVOMeta.END_DATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CertificateVOMeta.PAGE_INDEX , CertificateVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CertificateServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.QUERY_LIST)
	public Result<List<Certificate>> queryList(CertificateVO sample) {
		Result<List<Certificate>> result=new Result<>();
		List<Certificate> list=certificateService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询证书
	*/
	@ApiOperation(value = "分页查询证书")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.PROJECT , value = "项目" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.START_DATE , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateVOMeta.END_DATE , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CertificateVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CertificateServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Certificate>> queryPagedList(CertificateVO sample) {
		Result<PagedList<Certificate>> result=new Result<>();
		PagedList<Certificate> list=certificateService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		certificateService.dao().fill(list)
			.with("originator")
				.with(CertificateMeta.CERTIFICATE_POSITION)
				.with(CertificateMeta.CERTIFICATE_TYPE)
			.execute();
		List<Employee> originator= CollectorUtil.collectList(list.getList(), Certificate::getOriginator);
		certificateService.dao().join(originator, Person.class);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CertificateServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificateServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CertificateVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=certificateService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CertificateServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificateServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=certificateService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = CertificateServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificateServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=certificateService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}