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


import com.dt.platform.proxy.ops.VoucherHistoryServiceProxy;
import com.dt.platform.domain.ops.meta.VoucherHistoryVOMeta;
import com.dt.platform.domain.ops.VoucherHistory;
import com.dt.platform.domain.ops.VoucherHistoryVO;
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
import com.dt.platform.domain.ops.meta.VoucherHistoryMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IVoucherHistoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 凭证记录 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-04 00:03:34
*/

@Api(tags = "凭证记录")
@ApiSort(0)
@RestController("OpsVoucherHistoryController")
public class VoucherHistoryController extends SuperController {

	@Autowired
	private IVoucherHistoryService voucherHistoryService;

	
	/**
	 * 添加凭证记录
	*/
	@ApiOperation(value = "添加凭证记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherHistoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486324711886688256"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.VOUCHER_ID , value = "凭证" , required = false , dataTypeClass=String.class , example = "486324684015538176"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.USER_CODE , value = "用户" , required = false , dataTypeClass=String.class , example = "db2inst1"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "1212asfadf"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = VoucherHistoryVOMeta.ID)
	@SentinelResource(value = VoucherHistoryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherHistoryServiceProxy.INSERT)
	public Result insert(VoucherHistoryVO voucherHistoryVO) {
		Result result=voucherHistoryService.insert(voucherHistoryVO);
		return result;
	}

	
	/**
	 * 删除凭证记录
	*/
	@ApiOperation(value = "删除凭证记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherHistoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486324711886688256")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = VoucherHistoryVOMeta.ID)
	@SentinelResource(value = VoucherHistoryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherHistoryServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=voucherHistoryService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除凭证记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除凭证记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherHistoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = VoucherHistoryVOMeta.IDS)
	@SentinelResource(value = VoucherHistoryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherHistoryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=voucherHistoryService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新凭证记录
	*/
	@ApiOperation(value = "更新凭证记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherHistoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486324711886688256"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.VOUCHER_ID , value = "凭证" , required = false , dataTypeClass=String.class , example = "486324684015538176"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.USER_CODE , value = "用户" , required = false , dataTypeClass=String.class , example = "db2inst1"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "1212asfadf"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { VoucherHistoryVOMeta.PAGE_INDEX , VoucherHistoryVOMeta.PAGE_SIZE , VoucherHistoryVOMeta.SEARCH_FIELD , VoucherHistoryVOMeta.FUZZY_FIELD , VoucherHistoryVOMeta.SEARCH_VALUE , VoucherHistoryVOMeta.SORT_FIELD , VoucherHistoryVOMeta.SORT_TYPE , VoucherHistoryVOMeta.IDS } ) 
	@NotNull(name = VoucherHistoryVOMeta.ID)
	@SentinelResource(value = VoucherHistoryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherHistoryServiceProxy.UPDATE)
	public Result update(VoucherHistoryVO voucherHistoryVO) {
		Result result=voucherHistoryService.update(voucherHistoryVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存凭证记录
	*/
	@ApiOperation(value = "保存凭证记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherHistoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486324711886688256"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.VOUCHER_ID , value = "凭证" , required = false , dataTypeClass=String.class , example = "486324684015538176"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.USER_CODE , value = "用户" , required = false , dataTypeClass=String.class , example = "db2inst1"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "1212asfadf"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VoucherHistoryVOMeta.PAGE_INDEX , VoucherHistoryVOMeta.PAGE_SIZE , VoucherHistoryVOMeta.SEARCH_FIELD , VoucherHistoryVOMeta.FUZZY_FIELD , VoucherHistoryVOMeta.SEARCH_VALUE , VoucherHistoryVOMeta.SORT_FIELD , VoucherHistoryVOMeta.SORT_TYPE , VoucherHistoryVOMeta.IDS } )
	@NotNull(name = VoucherHistoryVOMeta.ID)
	@SentinelResource(value = VoucherHistoryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherHistoryServiceProxy.SAVE)
	public Result save(VoucherHistoryVO voucherHistoryVO) {
		Result result=voucherHistoryService.save(voucherHistoryVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取凭证记录
	*/
	@ApiOperation(value = "获取凭证记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherHistoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = VoucherHistoryVOMeta.ID)
	@SentinelResource(value = VoucherHistoryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherHistoryServiceProxy.GET_BY_ID)
	public Result<VoucherHistory> getById(String id) {
		Result<VoucherHistory> result=new Result<>();
		VoucherHistory voucherHistory=voucherHistoryService.getById(id);
		result.success(true).data(voucherHistory);
		return result;
	}


	/**
	 * 批量删除凭证记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除凭证记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = VoucherHistoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = VoucherHistoryVOMeta.IDS)
		@SentinelResource(value = VoucherHistoryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherHistoryServiceProxy.GET_BY_IDS)
	public Result<List<VoucherHistory>> getByIds(List<String> ids) {
		Result<List<VoucherHistory>> result=new Result<>();
		List<VoucherHistory> list=voucherHistoryService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询凭证记录
	*/
	@ApiOperation(value = "查询凭证记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherHistoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486324711886688256"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.VOUCHER_ID , value = "凭证" , required = false , dataTypeClass=String.class , example = "486324684015538176"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.USER_CODE , value = "用户" , required = false , dataTypeClass=String.class , example = "db2inst1"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "1212asfadf"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VoucherHistoryVOMeta.PAGE_INDEX , VoucherHistoryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = VoucherHistoryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherHistoryServiceProxy.QUERY_LIST)
	public Result<List<VoucherHistory>> queryList(VoucherHistoryVO sample) {
		Result<List<VoucherHistory>> result=new Result<>();
		List<VoucherHistory> list=voucherHistoryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询凭证记录
	*/
	@ApiOperation(value = "分页查询凭证记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherHistoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486324711886688256"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.VOUCHER_ID , value = "凭证" , required = false , dataTypeClass=String.class , example = "486324684015538176"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.USER_CODE , value = "用户" , required = false , dataTypeClass=String.class , example = "db2inst1"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.VOUCHER , value = "凭证" , required = false , dataTypeClass=String.class , example = "1212asfadf"),
		@ApiImplicitParam(name = VoucherHistoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = VoucherHistoryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherHistoryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<VoucherHistory>> queryPagedList(VoucherHistoryVO sample) {
		Result<PagedList<VoucherHistory>> result=new Result<>();
		PagedList<VoucherHistory> list=voucherHistoryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = VoucherHistoryServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(VoucherHistoryServiceProxy.EXPORT_EXCEL)
	public void exportExcel(VoucherHistoryVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=voucherHistoryService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = VoucherHistoryServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(VoucherHistoryServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=voucherHistoryService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = VoucherHistoryServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(VoucherHistoryServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=voucherHistoryService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}