package com.dt.platform.ops.controller;


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


import com.dt.platform.proxy.ops.CertificateTypeServiceProxy;
import com.dt.platform.domain.ops.meta.CertificateTypeVOMeta;
import com.dt.platform.domain.ops.CertificateType;
import com.dt.platform.domain.ops.CertificateTypeVO;
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
import com.dt.platform.domain.ops.meta.CertificateTypeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICertificateTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 证书类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-14 20:37:29
*/

@Api(tags = "证书类型")
@ApiSort(0)
@RestController("OpsCertificateTypeController")
public class CertificateTypeController extends SuperController {

	@Autowired
	private ICertificateTypeService certificateTypeService;


	/**
	 * 添加证书类型
	*/
	@ApiOperation(value = "添加证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CertificateTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.INSERT)
	public Result insert(CertificateTypeVO certificateTypeVO) {
		Result result=certificateTypeService.insert(certificateTypeVO,false);
		return result;
	}



	/**
	 * 删除证书类型
	*/
	@ApiOperation(value = "删除证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CertificateTypeVOMeta.ID)
	@SentinelResource(value = CertificateTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=certificateTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除证书类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CertificateTypeVOMeta.IDS)
	@SentinelResource(value = CertificateTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=certificateTypeService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新证书类型
	*/
	@ApiOperation(value = "更新证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CertificateTypeVOMeta.PAGE_INDEX , CertificateTypeVOMeta.PAGE_SIZE , CertificateTypeVOMeta.SEARCH_FIELD , CertificateTypeVOMeta.FUZZY_FIELD , CertificateTypeVOMeta.SEARCH_VALUE , CertificateTypeVOMeta.DIRTY_FIELDS , CertificateTypeVOMeta.SORT_FIELD , CertificateTypeVOMeta.SORT_TYPE , CertificateTypeVOMeta.IDS } )
	@NotNull(name = CertificateTypeVOMeta.ID)
	@SentinelResource(value = CertificateTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.UPDATE)
	public Result update(CertificateTypeVO certificateTypeVO) {
		Result result=certificateTypeService.update(certificateTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存证书类型
	*/
	@ApiOperation(value = "保存证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CertificateTypeVOMeta.PAGE_INDEX , CertificateTypeVOMeta.PAGE_SIZE , CertificateTypeVOMeta.SEARCH_FIELD , CertificateTypeVOMeta.FUZZY_FIELD , CertificateTypeVOMeta.SEARCH_VALUE , CertificateTypeVOMeta.DIRTY_FIELDS , CertificateTypeVOMeta.SORT_FIELD , CertificateTypeVOMeta.SORT_TYPE , CertificateTypeVOMeta.IDS } )
	@NotNull(name = CertificateTypeVOMeta.ID)
	@SentinelResource(value = CertificateTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.SAVE)
	public Result save(CertificateTypeVO certificateTypeVO) {
		Result result=certificateTypeService.save(certificateTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取证书类型
	*/
	@ApiOperation(value = "获取证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CertificateTypeVOMeta.ID)
	@SentinelResource(value = CertificateTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.GET_BY_ID)
	public Result<CertificateType> getById(String id) {
		Result<CertificateType> result=new Result<>();
		CertificateType certificateType=certificateTypeService.getById(id);
		result.success(true).data(certificateType);
		return result;
	}


	/**
	 * 批量获取证书类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取证书类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CertificateTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CertificateTypeVOMeta.IDS)
		@SentinelResource(value = CertificateTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.GET_BY_IDS)
	public Result<List<CertificateType>> getByIds(List<String> ids) {
		Result<List<CertificateType>> result=new Result<>();
		List<CertificateType> list=certificateTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询证书类型
	*/
	@ApiOperation(value = "查询证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CertificateTypeVOMeta.PAGE_INDEX , CertificateTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CertificateTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.QUERY_LIST)
	public Result<List<CertificateType>> queryList(CertificateTypeVO sample) {
		Result<List<CertificateType>> result=new Result<>();
		List<CertificateType> list=certificateTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询证书类型
	*/
	@ApiOperation(value = "分页查询证书类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificateTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificateTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CertificateTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificateTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CertificateType>> queryPagedList(CertificateTypeVO sample) {
		Result<PagedList<CertificateType>> result=new Result<>();
		PagedList<CertificateType> list=certificateTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CertificateTypeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificateTypeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CertificateTypeVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=certificateTypeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CertificateTypeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificateTypeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=certificateTypeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = CertificateTypeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificateTypeServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=certificateTypeService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}