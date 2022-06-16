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


import com.dt.platform.proxy.ops.CertificatePositionServiceProxy;
import com.dt.platform.domain.ops.meta.CertificatePositionVOMeta;
import com.dt.platform.domain.ops.CertificatePosition;
import com.dt.platform.domain.ops.CertificatePositionVO;
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
import com.dt.platform.domain.ops.meta.CertificatePositionMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICertificatePositionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 证书位置 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-15 06:06:31
*/

@Api(tags = "证书位置")
@ApiSort(0)
@RestController("OpsCertificatePositionController")
public class CertificatePositionController extends SuperController {

	@Autowired
	private ICertificatePositionService certificatePositionService;


	/**
	 * 添加证书位置
	*/
	@ApiOperation(value = "添加证书位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificatePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificatePositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificatePositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = CertificatePositionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificatePositionServiceProxy.INSERT)
	public Result insert(CertificatePositionVO certificatePositionVO) {
		Result result=certificatePositionService.insert(certificatePositionVO,false);
		return result;
	}



	/**
	 * 删除证书位置
	*/
	@ApiOperation(value = "删除证书位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificatePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CertificatePositionVOMeta.ID)
	@SentinelResource(value = CertificatePositionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificatePositionServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=certificatePositionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除证书位置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除证书位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificatePositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CertificatePositionVOMeta.IDS)
	@SentinelResource(value = CertificatePositionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificatePositionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=certificatePositionService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新证书位置
	*/
	@ApiOperation(value = "更新证书位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificatePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificatePositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificatePositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CertificatePositionVOMeta.PAGE_INDEX , CertificatePositionVOMeta.PAGE_SIZE , CertificatePositionVOMeta.SEARCH_FIELD , CertificatePositionVOMeta.FUZZY_FIELD , CertificatePositionVOMeta.SEARCH_VALUE , CertificatePositionVOMeta.DIRTY_FIELDS , CertificatePositionVOMeta.SORT_FIELD , CertificatePositionVOMeta.SORT_TYPE , CertificatePositionVOMeta.IDS } )
	@NotNull(name = CertificatePositionVOMeta.ID)
	@SentinelResource(value = CertificatePositionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificatePositionServiceProxy.UPDATE)
	public Result update(CertificatePositionVO certificatePositionVO) {
		Result result=certificatePositionService.update(certificatePositionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存证书位置
	*/
	@ApiOperation(value = "保存证书位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificatePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificatePositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificatePositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CertificatePositionVOMeta.PAGE_INDEX , CertificatePositionVOMeta.PAGE_SIZE , CertificatePositionVOMeta.SEARCH_FIELD , CertificatePositionVOMeta.FUZZY_FIELD , CertificatePositionVOMeta.SEARCH_VALUE , CertificatePositionVOMeta.DIRTY_FIELDS , CertificatePositionVOMeta.SORT_FIELD , CertificatePositionVOMeta.SORT_TYPE , CertificatePositionVOMeta.IDS } )
	@NotNull(name = CertificatePositionVOMeta.ID)
	@SentinelResource(value = CertificatePositionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificatePositionServiceProxy.SAVE)
	public Result save(CertificatePositionVO certificatePositionVO) {
		Result result=certificatePositionService.save(certificatePositionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取证书位置
	*/
	@ApiOperation(value = "获取证书位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificatePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CertificatePositionVOMeta.ID)
	@SentinelResource(value = CertificatePositionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificatePositionServiceProxy.GET_BY_ID)
	public Result<CertificatePosition> getById(String id) {
		Result<CertificatePosition> result=new Result<>();
		CertificatePosition certificatePosition=certificatePositionService.getById(id);
		result.success(true).data(certificatePosition);
		return result;
	}


	/**
	 * 批量获取证书位置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取证书位置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CertificatePositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CertificatePositionVOMeta.IDS)
		@SentinelResource(value = CertificatePositionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificatePositionServiceProxy.GET_BY_IDS)
	public Result<List<CertificatePosition>> getByIds(List<String> ids) {
		Result<List<CertificatePosition>> result=new Result<>();
		List<CertificatePosition> list=certificatePositionService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询证书位置
	*/
	@ApiOperation(value = "查询证书位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificatePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificatePositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificatePositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CertificatePositionVOMeta.PAGE_INDEX , CertificatePositionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CertificatePositionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificatePositionServiceProxy.QUERY_LIST)
	public Result<List<CertificatePosition>> queryList(CertificatePositionVO sample) {
		Result<List<CertificatePosition>> result=new Result<>();
		List<CertificatePosition> list=certificatePositionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询证书位置
	*/
	@ApiOperation(value = "分页查询证书位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CertificatePositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificatePositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CertificatePositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CertificatePositionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CertificatePositionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CertificatePosition>> queryPagedList(CertificatePositionVO sample) {
		Result<PagedList<CertificatePosition>> result=new Result<>();
		PagedList<CertificatePosition> list=certificatePositionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CertificatePositionServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificatePositionServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CertificatePositionVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=certificatePositionService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CertificatePositionServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificatePositionServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=certificatePositionService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = CertificatePositionServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CertificatePositionServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=certificatePositionService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}