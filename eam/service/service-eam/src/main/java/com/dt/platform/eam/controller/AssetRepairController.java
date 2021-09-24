package com.dt.platform.eam.controller;

 
import java.util.List;

import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.*;
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


import com.dt.platform.proxy.eam.AssetRepairServiceProxy;
import com.dt.platform.domain.eam.meta.AssetRepairVOMeta;
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
import com.dt.platform.domain.eam.meta.AssetRepairMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetRepairService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产报修 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:04:38
*/

@Api(tags = "资产报修")
@ApiSort(0)
@RestController("EamAssetRepairController")
public class AssetRepairController extends SuperController {

	@Autowired
	private IAssetRepairService assetRepairService;

	
	/**
	 * 添加资产报修
	*/
	@ApiOperation(value = "添加资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480483006776090624"),
		@ApiImplicitParam(name = AssetRepairVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetRepairVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetRepairVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetRepairVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetRepairVOMeta.ID)
	@NotNull(name = AssetRepairVOMeta.NAME)
	@SentinelResource(value = AssetRepairServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRepairServiceProxy.INSERT)
	public Result insert(AssetRepairVO assetRepairVO,String assetSelectedCode) {
		if(assetSelectedCode!=null||assetSelectedCode.length()>0){
			return assetRepairService.insert(assetRepairVO,assetSelectedCode);
		}else{
			return assetRepairService.insert(assetRepairVO);
		}
	}

	
	/**
	 * 删除资产报修
	*/
	@ApiOperation(value = "删除资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480483006776090624"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetRepairVOMeta.ID)
	@SentinelResource(value = AssetRepairServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRepairServiceProxy.DELETE)
	public Result deleteById(String id) {
		AssetRepair assetRepair=assetRepairService.getById(id);
		if(AssetHandleStatusEnum.COMPLETE.code().equals(assetRepair.getStatus())
				||AssetHandleStatusEnum.APPROVAL.code().equals(assetRepair.getStatus()) ){
			return ErrorDesc.failure().message("当前状态不允许删除");
		}
		Result result=assetRepairService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产报修 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRepairVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetRepairVOMeta.IDS)
	@SentinelResource(value = AssetRepairServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRepairServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetRepairService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产报修
	*/
	@ApiOperation(value = "更新资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480483006776090624"),
		@ApiImplicitParam(name = AssetRepairVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetRepairVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetRepairVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetRepairVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetRepairVOMeta.PAGE_INDEX , AssetRepairVOMeta.PAGE_SIZE , AssetRepairVOMeta.SEARCH_FIELD , AssetRepairVOMeta.FUZZY_FIELD , AssetRepairVOMeta.SEARCH_VALUE , AssetRepairVOMeta.SORT_FIELD , AssetRepairVOMeta.SORT_TYPE , AssetRepairVOMeta.IDS } ) 
	@NotNull(name = AssetRepairVOMeta.ID)
	@NotNull(name = AssetRepairVOMeta.NAME)
	@SentinelResource(value = AssetRepairServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRepairServiceProxy.UPDATE)
	public Result update(AssetRepairVO assetRepairVO) {

		AssetRepair assetRepair=assetRepairService.queryEntity(assetRepairVO);
		if(AssetHandleStatusEnum.COMPLETE.code().equals(assetRepair.getStatus())
			||AssetHandleStatusEnum.APPROVAL.code().equals(assetRepair.getStatus())){
			return ErrorDesc.failure().message("当前状态不允许修改");
		}

		Result result=assetRepairService.update(assetRepairVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产报修
	*/
	@ApiOperation(value = "保存资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480483006776090624"),
		@ApiImplicitParam(name = AssetRepairVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetRepairVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetRepairVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetRepairVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetRepairVOMeta.PAGE_INDEX , AssetRepairVOMeta.PAGE_SIZE , AssetRepairVOMeta.SEARCH_FIELD , AssetRepairVOMeta.FUZZY_FIELD , AssetRepairVOMeta.SEARCH_VALUE , AssetRepairVOMeta.SORT_FIELD , AssetRepairVOMeta.SORT_TYPE , AssetRepairVOMeta.IDS } )
	@NotNull(name = AssetRepairVOMeta.ID)
	@NotNull(name = AssetRepairVOMeta.NAME)
	@SentinelResource(value = AssetRepairServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRepairServiceProxy.SAVE)
	public Result save(AssetRepairVO assetRepairVO) {
		Result result=assetRepairService.save(assetRepairVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产报修
	*/
	@ApiOperation(value = "获取资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetRepairVOMeta.ID)
	@SentinelResource(value = AssetRepairServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRepairServiceProxy.GET_BY_ID)
	public Result<AssetRepair> getById(String id) {
		Result<AssetRepair> result=new Result<>();
		AssetRepair assetRepair=assetRepairService.getById(id);
		result.success(true).data(assetRepair);
		return result;
	}


	/**
	 * 批量删除资产报修 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产报修")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetRepairVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetRepairVOMeta.IDS)
		@SentinelResource(value = AssetRepairServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRepairServiceProxy.GET_BY_IDS)
	public Result<List<AssetRepair>> getByIds(List<String> ids) {
		Result<List<AssetRepair>> result=new Result<>();
		List<AssetRepair> list=assetRepairService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产报修
	*/
	@ApiOperation(value = "查询资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480483006776090624"),
		@ApiImplicitParam(name = AssetRepairVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetRepairVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetRepairVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetRepairVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetRepairVOMeta.PAGE_INDEX , AssetRepairVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetRepairServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRepairServiceProxy.QUERY_LIST)
	public Result<List<AssetRepair>> queryList(AssetRepairVO sample) {
		Result<List<AssetRepair>> result=new Result<>();
		List<AssetRepair> list=assetRepairService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产报修
	*/
	@ApiOperation(value = "分页查询资产报修")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRepairVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480483006776090624"),
		@ApiImplicitParam(name = AssetRepairVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetRepairVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.TYPE , value = "报修类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PLAN_FINISH_DATE , value = "计划完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.ACTUAL_FINISH_DATE , value = "实际完成日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.CONTENT , value = "报修内容" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetRepairVOMeta.REPORT_USER_ID , value = "报修人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRepairVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetRepairVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetRepairServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRepairServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetRepair>> queryPagedList(AssetRepairVO sample) {
		Result<PagedList<AssetRepair>> result=new Result<>();
		PagedList<AssetRepair> list=assetRepairService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetRepairServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetRepairServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetRepairVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetRepairService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetRepairServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetRepairServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetRepairService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetRepairServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetRepairServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetRepairService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}