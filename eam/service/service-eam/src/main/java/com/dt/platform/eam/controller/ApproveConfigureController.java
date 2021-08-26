package com.dt.platform.eam.controller;

 
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


import com.dt.platform.proxy.eam.ApproveConfigureServiceProxy;
import com.dt.platform.domain.eam.meta.ApproveConfigureVOMeta;
import com.dt.platform.domain.eam.ApproveConfigure;
import com.dt.platform.domain.eam.ApproveConfigureVO;
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
import com.dt.platform.domain.eam.meta.ApproveConfigureMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IApproveConfigureService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产审批配置 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-25 21:22:14
*/

@Api(tags = "资产审批配置")
@ApiSort(0)
@RestController("EamApproveConfigureController")
public class ApproveConfigureController extends SuperController {

	@Autowired
	private IApproveConfigureService approveConfigureService;

	
	/**
	 * 添加资产审批配置
	*/
	@ApiOperation(value = "添加资产审批配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ApproveConfigureVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "资产借用"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.APPROVAL_TYPE , value = "审批类型" , required = true , dataTypeClass=String.class , example = "borrow"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.APPROVAL_STATUS , value = "审批状态" , required = true , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ApproveConfigureVOMeta.ID)
	@NotNull(name = ApproveConfigureVOMeta.APPROVAL_TYPE)
	@NotNull(name = ApproveConfigureVOMeta.APPROVAL_STATUS)
	@SentinelResource(value = ApproveConfigureServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ApproveConfigureServiceProxy.INSERT)
	public Result insert(ApproveConfigureVO approveConfigureVO) {
		Result result=approveConfigureService.insert(approveConfigureVO);
		return result;
	}

	
	/**
	 * 删除资产审批配置
	*/
	@ApiOperation(value = "删除资产审批配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ApproveConfigureVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ApproveConfigureVOMeta.ID)
	@SentinelResource(value = ApproveConfigureServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ApproveConfigureServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=approveConfigureService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产审批配置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产审批配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ApproveConfigureVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ApproveConfigureVOMeta.IDS)
	@SentinelResource(value = ApproveConfigureServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ApproveConfigureServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=approveConfigureService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产审批配置
	*/
	@ApiOperation(value = "更新资产审批配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ApproveConfigureVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "资产借用"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.APPROVAL_TYPE , value = "审批类型" , required = true , dataTypeClass=String.class , example = "borrow"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.APPROVAL_STATUS , value = "审批状态" , required = true , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ApproveConfigureVOMeta.PAGE_INDEX , ApproveConfigureVOMeta.PAGE_SIZE , ApproveConfigureVOMeta.SEARCH_FIELD , ApproveConfigureVOMeta.FUZZY_FIELD , ApproveConfigureVOMeta.SEARCH_VALUE , ApproveConfigureVOMeta.SORT_FIELD , ApproveConfigureVOMeta.SORT_TYPE , ApproveConfigureVOMeta.IDS } ) 
	@NotNull(name = ApproveConfigureVOMeta.ID)
	@NotNull(name = ApproveConfigureVOMeta.APPROVAL_TYPE)
	@NotNull(name = ApproveConfigureVOMeta.APPROVAL_STATUS)
	@SentinelResource(value = ApproveConfigureServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ApproveConfigureServiceProxy.UPDATE)
	public Result update(ApproveConfigureVO approveConfigureVO) {
		Result result=approveConfigureService.update(approveConfigureVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产审批配置
	*/
	@ApiOperation(value = "保存资产审批配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ApproveConfigureVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "资产借用"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.APPROVAL_TYPE , value = "审批类型" , required = true , dataTypeClass=String.class , example = "borrow"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.APPROVAL_STATUS , value = "审批状态" , required = true , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ApproveConfigureVOMeta.PAGE_INDEX , ApproveConfigureVOMeta.PAGE_SIZE , ApproveConfigureVOMeta.SEARCH_FIELD , ApproveConfigureVOMeta.FUZZY_FIELD , ApproveConfigureVOMeta.SEARCH_VALUE , ApproveConfigureVOMeta.SORT_FIELD , ApproveConfigureVOMeta.SORT_TYPE , ApproveConfigureVOMeta.IDS } )
	@NotNull(name = ApproveConfigureVOMeta.ID)
	@NotNull(name = ApproveConfigureVOMeta.APPROVAL_TYPE)
	@NotNull(name = ApproveConfigureVOMeta.APPROVAL_STATUS)
	@SentinelResource(value = ApproveConfigureServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ApproveConfigureServiceProxy.SAVE)
	public Result save(ApproveConfigureVO approveConfigureVO) {
		Result result=approveConfigureService.save(approveConfigureVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产审批配置
	*/
	@ApiOperation(value = "获取资产审批配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ApproveConfigureVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ApproveConfigureVOMeta.ID)
	@SentinelResource(value = ApproveConfigureServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ApproveConfigureServiceProxy.GET_BY_ID)
	public Result<ApproveConfigure> getById(String id) {
		Result<ApproveConfigure> result=new Result<>();
		ApproveConfigure approveConfigure=approveConfigureService.getById(id);
		result.success(true).data(approveConfigure);
		return result;
	}


	/**
	 * 批量删除资产审批配置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产审批配置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ApproveConfigureVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ApproveConfigureVOMeta.IDS)
		@SentinelResource(value = ApproveConfigureServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ApproveConfigureServiceProxy.GET_BY_IDS)
	public Result<List<ApproveConfigure>> getByIds(List<String> ids) {
		Result<List<ApproveConfigure>> result=new Result<>();
		List<ApproveConfigure> list=approveConfigureService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产审批配置
	*/
	@ApiOperation(value = "查询资产审批配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ApproveConfigureVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "资产借用"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.APPROVAL_TYPE , value = "审批类型" , required = true , dataTypeClass=String.class , example = "borrow"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.APPROVAL_STATUS , value = "审批状态" , required = true , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ApproveConfigureVOMeta.PAGE_INDEX , ApproveConfigureVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ApproveConfigureServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ApproveConfigureServiceProxy.QUERY_LIST)
	public Result<List<ApproveConfigure>> queryList(ApproveConfigureVO sample) {
		Result<List<ApproveConfigure>> result=new Result<>();
		List<ApproveConfigure> list=approveConfigureService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产审批配置
	*/
	@ApiOperation(value = "分页查询资产审批配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ApproveConfigureVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "资产借用"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.APPROVAL_TYPE , value = "审批类型" , required = true , dataTypeClass=String.class , example = "borrow"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.APPROVAL_STATUS , value = "审批状态" , required = true , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ApproveConfigureVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ApproveConfigureServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ApproveConfigureServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ApproveConfigure>> queryPagedList(ApproveConfigureVO sample) {
		Result<PagedList<ApproveConfigure>> result=new Result<>();
		PagedList<ApproveConfigure> list=approveConfigureService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ApproveConfigureServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ApproveConfigureServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ApproveConfigureVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=approveConfigureService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ApproveConfigureServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ApproveConfigureServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=approveConfigureService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ApproveConfigureServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ApproveConfigureServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=approveConfigureService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}