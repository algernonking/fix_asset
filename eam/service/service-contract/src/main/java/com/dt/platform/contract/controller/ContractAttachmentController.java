package com.dt.platform.contract.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.contract.service.IContractAttachmentService;
import com.dt.platform.domain.contract.ContractAttachment;
import com.dt.platform.domain.contract.ContractAttachmentVO;
import com.dt.platform.domain.contract.meta.ContractAttachmentVOMeta;
import com.dt.platform.proxy.contract.ContractAttachmentServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 合同附件 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-28 15:44:51
*/

@Api(tags = "合同附件")
@ApiSort(0)
@RestController("ContContractAttachmentController")
public class ContractAttachmentController extends SuperController {

	@Autowired
	private IContractAttachmentService contractAttachmentService;

	/**
	 * 添加合同附件
	*/
	@ApiOperation(value = "添加合同附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractAttachmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "528210765681786880"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.OWNER_ID , value = "所有者ID" , required = false , dataTypeClass=String.class , example = "525341591175434240"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.OWNER_TYPE , value = "所有者类型" , required = false , dataTypeClass=String.class , example = "contract"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.TYPE , value = "附件类型" , required = false , dataTypeClass=String.class , example = "contract_text"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.FILE_ID , value = "文件ID" , required = false , dataTypeClass=String.class , example = "528210749042982912"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.NAME , value = "附件名称" , required = false , dataTypeClass=String.class , example = "胡云"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "wu "),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ContractAttachmentServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractAttachmentServiceProxy.INSERT)
	public Result insert(ContractAttachmentVO contractAttachmentVO) {
		Result result=contractAttachmentService.insert(contractAttachmentVO,false);
		return result;
	}



	/**
	 * 删除合同附件
	*/
	@ApiOperation(value = "删除合同附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractAttachmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "528210765681786880")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ContractAttachmentVOMeta.ID)
	@SentinelResource(value = ContractAttachmentServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractAttachmentServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=contractAttachmentService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除合同附件 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除合同附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractAttachmentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ContractAttachmentVOMeta.IDS)
	@SentinelResource(value = ContractAttachmentServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractAttachmentServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=contractAttachmentService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新合同附件
	*/
	@ApiOperation(value = "更新合同附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractAttachmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "528210765681786880"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.OWNER_ID , value = "所有者ID" , required = false , dataTypeClass=String.class , example = "525341591175434240"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.OWNER_TYPE , value = "所有者类型" , required = false , dataTypeClass=String.class , example = "contract"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.TYPE , value = "附件类型" , required = false , dataTypeClass=String.class , example = "contract_text"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.FILE_ID , value = "文件ID" , required = false , dataTypeClass=String.class , example = "528210749042982912"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.NAME , value = "附件名称" , required = false , dataTypeClass=String.class , example = "胡云"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "wu "),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ContractAttachmentVOMeta.PAGE_INDEX , ContractAttachmentVOMeta.PAGE_SIZE , ContractAttachmentVOMeta.SEARCH_FIELD , ContractAttachmentVOMeta.FUZZY_FIELD , ContractAttachmentVOMeta.SEARCH_VALUE , ContractAttachmentVOMeta.DIRTY_FIELDS , ContractAttachmentVOMeta.SORT_FIELD , ContractAttachmentVOMeta.SORT_TYPE , ContractAttachmentVOMeta.IDS } )
	@NotNull(name = ContractAttachmentVOMeta.ID)
	@SentinelResource(value = ContractAttachmentServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractAttachmentServiceProxy.UPDATE)
	public Result update(ContractAttachmentVO contractAttachmentVO) {
		Result result=contractAttachmentService.update(contractAttachmentVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存合同附件
	*/
	@ApiOperation(value = "保存合同附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractAttachmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "528210765681786880"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.OWNER_ID , value = "所有者ID" , required = false , dataTypeClass=String.class , example = "525341591175434240"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.OWNER_TYPE , value = "所有者类型" , required = false , dataTypeClass=String.class , example = "contract"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.TYPE , value = "附件类型" , required = false , dataTypeClass=String.class , example = "contract_text"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.FILE_ID , value = "文件ID" , required = false , dataTypeClass=String.class , example = "528210749042982912"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.NAME , value = "附件名称" , required = false , dataTypeClass=String.class , example = "胡云"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "wu "),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractAttachmentVOMeta.PAGE_INDEX , ContractAttachmentVOMeta.PAGE_SIZE , ContractAttachmentVOMeta.SEARCH_FIELD , ContractAttachmentVOMeta.FUZZY_FIELD , ContractAttachmentVOMeta.SEARCH_VALUE , ContractAttachmentVOMeta.DIRTY_FIELDS , ContractAttachmentVOMeta.SORT_FIELD , ContractAttachmentVOMeta.SORT_TYPE , ContractAttachmentVOMeta.IDS } )
	@NotNull(name = ContractAttachmentVOMeta.ID)
	@SentinelResource(value = ContractAttachmentServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractAttachmentServiceProxy.SAVE)
	public Result save(ContractAttachmentVO contractAttachmentVO) {
		Result result=contractAttachmentService.save(contractAttachmentVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取合同附件
	*/
	@ApiOperation(value = "获取合同附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractAttachmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ContractAttachmentVOMeta.ID)
	@SentinelResource(value = ContractAttachmentServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractAttachmentServiceProxy.GET_BY_ID)
	public Result<ContractAttachment> getById(String id) {
		Result<ContractAttachment> result=new Result<>();
		ContractAttachment contractAttachment=contractAttachmentService.getById(id);
		result.success(true).data(contractAttachment);
		return result;
	}


	/**
	 * 批量获取合同附件 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取合同附件")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ContractAttachmentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ContractAttachmentVOMeta.IDS)
		@SentinelResource(value = ContractAttachmentServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractAttachmentServiceProxy.GET_BY_IDS)
	public Result<List<ContractAttachment>> getByIds(List<String> ids) {
		Result<List<ContractAttachment>> result=new Result<>();
		List<ContractAttachment> list=contractAttachmentService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询合同附件
	*/
	@ApiOperation(value = "查询合同附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractAttachmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "528210765681786880"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.OWNER_ID , value = "所有者ID" , required = false , dataTypeClass=String.class , example = "525341591175434240"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.OWNER_TYPE , value = "所有者类型" , required = false , dataTypeClass=String.class , example = "contract"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.TYPE , value = "附件类型" , required = false , dataTypeClass=String.class , example = "contract_text"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.FILE_ID , value = "文件ID" , required = false , dataTypeClass=String.class , example = "528210749042982912"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.NAME , value = "附件名称" , required = false , dataTypeClass=String.class , example = "胡云"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "wu "),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractAttachmentVOMeta.PAGE_INDEX , ContractAttachmentVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ContractAttachmentServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractAttachmentServiceProxy.QUERY_LIST)
	public Result<List<ContractAttachment>> queryList(ContractAttachmentVO sample) {
		Result<List<ContractAttachment>> result=new Result<>();
		List<ContractAttachment> list=contractAttachmentService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询合同附件
	*/
	@ApiOperation(value = "分页查询合同附件")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractAttachmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "528210765681786880"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.OWNER_ID , value = "所有者ID" , required = false , dataTypeClass=String.class , example = "525341591175434240"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.OWNER_TYPE , value = "所有者类型" , required = false , dataTypeClass=String.class , example = "contract"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.TYPE , value = "附件类型" , required = false , dataTypeClass=String.class , example = "contract_text"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.FILE_ID , value = "文件ID" , required = false , dataTypeClass=String.class , example = "528210749042982912"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.NAME , value = "附件名称" , required = false , dataTypeClass=String.class , example = "胡云"),
		@ApiImplicitParam(name = ContractAttachmentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "wu "),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ContractAttachmentServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractAttachmentServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ContractAttachment>> queryPagedList(ContractAttachmentVO sample) {
		Result<PagedList<ContractAttachment>> result=new Result<>();
		PagedList<ContractAttachment> list=contractAttachmentService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ContractAttachmentServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractAttachmentServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ContractAttachmentVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=contractAttachmentService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ContractAttachmentServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractAttachmentServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=contractAttachmentService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = ContractAttachmentServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractAttachmentServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=contractAttachmentService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}