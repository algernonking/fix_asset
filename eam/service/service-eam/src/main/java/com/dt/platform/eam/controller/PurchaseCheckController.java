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


import com.dt.platform.proxy.eam.PurchaseCheckServiceProxy;
import com.dt.platform.domain.eam.meta.PurchaseCheckVOMeta;
import com.dt.platform.domain.eam.PurchaseCheck;
import com.dt.platform.domain.eam.PurchaseCheckVO;
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
import com.dt.platform.domain.eam.meta.PurchaseCheckMeta;
import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.PurchaseApply;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.PurchaseOrder;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IPurchaseCheckService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 采购验收 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-16 23:19:16
*/

@Api(tags = "采购验收")
@ApiSort(0)
@RestController("EamPurchaseCheckController")
public class PurchaseCheckController extends SuperController {

	@Autowired
	private IPurchaseCheckService purchaseCheckService;


	/**
	 * 添加采购验收
	*/
	@ApiOperation(value = "添加采购验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.APPLY_ID , value = "采购申请" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CODE , value = "验收单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_ORG_ID , value = "验收部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_USER_NAME , value = "验收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.RECEIVE_DATE , value = "到货日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_DATE , value = "验收时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_INFORMATION , value = "验收信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = PurchaseCheckServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseCheckServiceProxy.INSERT)
	public Result insert(PurchaseCheckVO purchaseCheckVO) {
		Result result=purchaseCheckService.insert(purchaseCheckVO,false);
		return result;
	}



	/**
	 * 删除采购验收
	*/
	@ApiOperation(value = "删除采购验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = PurchaseCheckVOMeta.ID)
	@SentinelResource(value = PurchaseCheckServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseCheckServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=purchaseCheckService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除采购验收 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除采购验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseCheckVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = PurchaseCheckVOMeta.IDS)
	@SentinelResource(value = PurchaseCheckServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseCheckServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=purchaseCheckService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新采购验收
	*/
	@ApiOperation(value = "更新采购验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.APPLY_ID , value = "采购申请" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CODE , value = "验收单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_ORG_ID , value = "验收部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_USER_NAME , value = "验收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.RECEIVE_DATE , value = "到货日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_DATE , value = "验收时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_INFORMATION , value = "验收信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { PurchaseCheckVOMeta.PAGE_INDEX , PurchaseCheckVOMeta.PAGE_SIZE , PurchaseCheckVOMeta.SEARCH_FIELD , PurchaseCheckVOMeta.FUZZY_FIELD , PurchaseCheckVOMeta.SEARCH_VALUE , PurchaseCheckVOMeta.DIRTY_FIELDS , PurchaseCheckVOMeta.SORT_FIELD , PurchaseCheckVOMeta.SORT_TYPE , PurchaseCheckVOMeta.IDS } )
	@NotNull(name = PurchaseCheckVOMeta.ID)
	@SentinelResource(value = PurchaseCheckServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseCheckServiceProxy.UPDATE)
	public Result update(PurchaseCheckVO purchaseCheckVO) {
		Result result=purchaseCheckService.update(purchaseCheckVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存采购验收
	*/
	@ApiOperation(value = "保存采购验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.APPLY_ID , value = "采购申请" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CODE , value = "验收单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_ORG_ID , value = "验收部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_USER_NAME , value = "验收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.RECEIVE_DATE , value = "到货日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_DATE , value = "验收时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_INFORMATION , value = "验收信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PurchaseCheckVOMeta.PAGE_INDEX , PurchaseCheckVOMeta.PAGE_SIZE , PurchaseCheckVOMeta.SEARCH_FIELD , PurchaseCheckVOMeta.FUZZY_FIELD , PurchaseCheckVOMeta.SEARCH_VALUE , PurchaseCheckVOMeta.DIRTY_FIELDS , PurchaseCheckVOMeta.SORT_FIELD , PurchaseCheckVOMeta.SORT_TYPE , PurchaseCheckVOMeta.IDS } )
	@NotNull(name = PurchaseCheckVOMeta.ID)
	@SentinelResource(value = PurchaseCheckServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseCheckServiceProxy.SAVE)
	public Result save(PurchaseCheckVO purchaseCheckVO) {
		Result result=purchaseCheckService.save(purchaseCheckVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取采购验收
	*/
	@ApiOperation(value = "获取采购验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = PurchaseCheckVOMeta.ID)
	@SentinelResource(value = PurchaseCheckServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseCheckServiceProxy.GET_BY_ID)
	public Result<PurchaseCheck> getById(String id) {
		Result<PurchaseCheck> result=new Result<>();
		PurchaseCheck purchaseCheck=purchaseCheckService.getById(id);
		// join 关联的对象
		purchaseCheckService.dao().fill(purchaseCheck)
			.with("checkOrg")
			.with(PurchaseCheckMeta.SUPPLIER)
			.with(PurchaseCheckMeta.PURCHASE_APPLY)
			.execute();
		result.success(true).data(purchaseCheck);
		return result;
	}


	/**
	 * 批量获取采购验收 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取采购验收")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PurchaseCheckVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = PurchaseCheckVOMeta.IDS)
		@SentinelResource(value = PurchaseCheckServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseCheckServiceProxy.GET_BY_IDS)
	public Result<List<PurchaseCheck>> getByIds(List<String> ids) {
		Result<List<PurchaseCheck>> result=new Result<>();
		List<PurchaseCheck> list=purchaseCheckService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询采购验收
	*/
	@ApiOperation(value = "查询采购验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.APPLY_ID , value = "采购申请" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CODE , value = "验收单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_ORG_ID , value = "验收部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_USER_NAME , value = "验收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.RECEIVE_DATE , value = "到货日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_DATE , value = "验收时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_INFORMATION , value = "验收信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PurchaseCheckVOMeta.PAGE_INDEX , PurchaseCheckVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PurchaseCheckServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseCheckServiceProxy.QUERY_LIST)
	public Result<List<PurchaseCheck>> queryList(PurchaseCheckVO sample) {
		Result<List<PurchaseCheck>> result=new Result<>();
		List<PurchaseCheck> list=purchaseCheckService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询采购验收
	*/
	@ApiOperation(value = "分页查询采购验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.APPLY_ID , value = "采购申请" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CODE , value = "验收单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_ORG_ID , value = "验收部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_USER_NAME , value = "验收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.RECEIVE_DATE , value = "到货日期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_DATE , value = "验收时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.CHECK_INFORMATION , value = "验收信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PurchaseCheckVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = PurchaseCheckServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PurchaseCheckServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PurchaseCheck>> queryPagedList(PurchaseCheckVO sample) {
		Result<PagedList<PurchaseCheck>> result=new Result<>();
		PagedList<PurchaseCheck> list=purchaseCheckService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		purchaseCheckService.dao().fill(list)
			.with("checkOrg")
			.with(PurchaseCheckMeta.SUPPLIER)
			.with(PurchaseCheckMeta.PURCHASE_APPLY)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = PurchaseCheckServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseCheckServiceProxy.EXPORT_EXCEL)
	public void exportExcel(PurchaseCheckVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=purchaseCheckService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = PurchaseCheckServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseCheckServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=purchaseCheckService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = PurchaseCheckServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PurchaseCheckServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=purchaseCheckService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}