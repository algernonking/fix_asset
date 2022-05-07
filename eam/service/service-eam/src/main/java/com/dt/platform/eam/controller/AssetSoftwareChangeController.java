package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.meta.AssetSoftwareMaintenanceVOMeta;
import com.dt.platform.proxy.eam.AssetSoftwareMaintenanceServiceProxy;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
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


import com.dt.platform.proxy.eam.AssetSoftwareChangeServiceProxy;
import com.dt.platform.domain.eam.meta.AssetSoftwareChangeVOMeta;
import com.dt.platform.domain.eam.AssetSoftwareChange;
import com.dt.platform.domain.eam.AssetSoftwareChangeVO;
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
import com.dt.platform.domain.eam.meta.AssetSoftwareChangeMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetSoftwareChangeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 软件变更 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-05 16:10:34
*/

@Api(tags = "软件变更")
@ApiSort(0)
@RestController("EamAssetSoftwareChangeController")
public class AssetSoftwareChangeController extends SuperController {

	@Autowired
	private IAssetSoftwareChangeService assetSoftwareChangeService;


	/**
	 * 添加软件变更
	*/
	@ApiOperation(value = "添加软件变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.NAME , value = "变更名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.CONTENT , value = "变更说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeServiceProxy.INSERT)
	public Result insert(AssetSoftwareChangeVO assetSoftwareChangeVO) {
		Result result=assetSoftwareChangeService.insert(assetSoftwareChangeVO,false);
		return result;
	}



	/**
	 * 删除软件变更
	*/
	@ApiOperation(value = "删除软件变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetSoftwareChangeVOMeta.ID)
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetSoftwareChangeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除软件变更 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除软件变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetSoftwareChangeVOMeta.IDS)
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetSoftwareChangeService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新软件变更
	*/
	@ApiOperation(value = "更新软件变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.NAME , value = "变更名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.CONTENT , value = "变更说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetSoftwareChangeVOMeta.PAGE_INDEX , AssetSoftwareChangeVOMeta.PAGE_SIZE , AssetSoftwareChangeVOMeta.SEARCH_FIELD , AssetSoftwareChangeVOMeta.FUZZY_FIELD , AssetSoftwareChangeVOMeta.SEARCH_VALUE , AssetSoftwareChangeVOMeta.DIRTY_FIELDS , AssetSoftwareChangeVOMeta.SORT_FIELD , AssetSoftwareChangeVOMeta.SORT_TYPE , AssetSoftwareChangeVOMeta.IDS } )
	@NotNull(name = AssetSoftwareChangeVOMeta.ID)
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeServiceProxy.UPDATE)
	public Result update(AssetSoftwareChangeVO assetSoftwareChangeVO) {
		Result result=assetSoftwareChangeService.update(assetSoftwareChangeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存软件变更
	*/
	@ApiOperation(value = "保存软件变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.NAME , value = "变更名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.CONTENT , value = "变更说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareChangeVOMeta.PAGE_INDEX , AssetSoftwareChangeVOMeta.PAGE_SIZE , AssetSoftwareChangeVOMeta.SEARCH_FIELD , AssetSoftwareChangeVOMeta.FUZZY_FIELD , AssetSoftwareChangeVOMeta.SEARCH_VALUE , AssetSoftwareChangeVOMeta.DIRTY_FIELDS , AssetSoftwareChangeVOMeta.SORT_FIELD , AssetSoftwareChangeVOMeta.SORT_TYPE , AssetSoftwareChangeVOMeta.IDS } )
	@NotNull(name = AssetSoftwareChangeVOMeta.ID)
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeServiceProxy.SAVE)
	public Result save(AssetSoftwareChangeVO assetSoftwareChangeVO) {
		Result result=assetSoftwareChangeService.save(assetSoftwareChangeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取软件变更
	*/
	@ApiOperation(value = "获取软件变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetSoftwareChangeVOMeta.ID)
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeServiceProxy.GET_BY_ID)
	public Result<AssetSoftwareChange> getById(String id) {
		Result<AssetSoftwareChange> result=new Result<>();
		AssetSoftwareChange assetSoftwareChange=assetSoftwareChangeService.getById(id);
		result.success(true).data(assetSoftwareChange);
		return result;
	}


	/**
	 * 批量获取软件变更 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取软件变更")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetSoftwareChangeVOMeta.IDS)
		@SentinelResource(value = AssetSoftwareChangeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeServiceProxy.GET_BY_IDS)
	public Result<List<AssetSoftwareChange>> getByIds(List<String> ids) {
		Result<List<AssetSoftwareChange>> result=new Result<>();
		List<AssetSoftwareChange> list=assetSoftwareChangeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询软件变更
	*/
	@ApiOperation(value = "查询软件变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.NAME , value = "变更名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.CONTENT , value = "变更说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareChangeVOMeta.PAGE_INDEX , AssetSoftwareChangeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeServiceProxy.QUERY_LIST)
	public Result<List<AssetSoftwareChange>> queryList(AssetSoftwareChangeVO sample) {
		Result<List<AssetSoftwareChange>> result=new Result<>();
		List<AssetSoftwareChange> list=assetSoftwareChangeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询软件变更
	*/
	@ApiOperation(value = "分页查询软件变更")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.NAME , value = "变更名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.CONTENT , value = "变更说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetSoftwareChange>> queryPagedList(AssetSoftwareChangeVO sample) {
		Result<PagedList<AssetSoftwareChange>> result=new Result<>();
		PagedList<AssetSoftwareChange> list=assetSoftwareChangeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}




	/**
	 * 送审
	 * */
	@ApiOperation(value = "送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareChangeVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareChangeServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetSoftwareChangeService.forApproval(id);
	}


	/**
	 * 确认
	 * */
	@ApiOperation(value = "确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareChangeVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareChangeServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetSoftwareChangeService.confirmOperation(id);
	}


	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetSoftwareChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetSoftwareChangeVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareChangeServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetSoftwareChangeService.revokeOperation(id);
	}


	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareChangeServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return assetSoftwareChangeService.approve(approveVO);
	}


	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareChangeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetSoftwareChangeVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetSoftwareChangeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetSoftwareChangeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareChangeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetSoftwareChangeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetSoftwareChangeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareChangeServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetSoftwareChangeService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}