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


import com.dt.platform.proxy.eam.AssetHandleServiceProxy;
import com.dt.platform.domain.eam.meta.AssetHandleVOMeta;
import com.dt.platform.domain.eam.AssetHandle;
import com.dt.platform.domain.eam.AssetHandleVO;
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
import com.dt.platform.domain.eam.meta.AssetHandleMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetHandleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产处置 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-22 21:47:49
*/

@Api(tags = "资产处置")
@ApiSort(0)
@RestController("EamAssetHandleController")
public class AssetHandleController extends SuperController {

	@Autowired
	private IAssetHandleService assetHandleService;


	/**
	 * 添加资产处置
	*/
	@ApiOperation(value = "添加资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.TYPE , value = "处置类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.HANDLE_NUMBER , value = "处置数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.HANDLE_DATE , value = "处理日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PLAN_FINISH_DATE , value = "计划完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ACTUAL_FINISH_DATE , value = "实际完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CRD_ACTION , value = "修改标记" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetHandleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.INSERT)
	public Result insert(AssetHandleVO assetHandleVO) {
		Result result=assetHandleService.insert(assetHandleVO);
		return result;
	}



	/**
	 * 删除资产处置
	*/
	@ApiOperation(value = "删除资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetHandleVOMeta.ID)
	@SentinelResource(value = AssetHandleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetHandleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产处置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetHandleVOMeta.IDS)
	@SentinelResource(value = AssetHandleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetHandleService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新资产处置
	*/
	@ApiOperation(value = "更新资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.TYPE , value = "处置类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.HANDLE_NUMBER , value = "处置数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.HANDLE_DATE , value = "处理日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PLAN_FINISH_DATE , value = "计划完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ACTUAL_FINISH_DATE , value = "实际完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CRD_ACTION , value = "修改标记" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetHandleVOMeta.PAGE_INDEX , AssetHandleVOMeta.PAGE_SIZE , AssetHandleVOMeta.SEARCH_FIELD , AssetHandleVOMeta.FUZZY_FIELD , AssetHandleVOMeta.SEARCH_VALUE , AssetHandleVOMeta.SORT_FIELD , AssetHandleVOMeta.SORT_TYPE , AssetHandleVOMeta.IDS } )
	@NotNull(name = AssetHandleVOMeta.ID)
	@SentinelResource(value = AssetHandleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.UPDATE)
	public Result update(AssetHandleVO assetHandleVO) {
		Result result=assetHandleService.update(assetHandleVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存资产处置
	*/
	@ApiOperation(value = "保存资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.TYPE , value = "处置类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.HANDLE_NUMBER , value = "处置数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.HANDLE_DATE , value = "处理日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PLAN_FINISH_DATE , value = "计划完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ACTUAL_FINISH_DATE , value = "实际完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CRD_ACTION , value = "修改标记" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetHandleVOMeta.PAGE_INDEX , AssetHandleVOMeta.PAGE_SIZE , AssetHandleVOMeta.SEARCH_FIELD , AssetHandleVOMeta.FUZZY_FIELD , AssetHandleVOMeta.SEARCH_VALUE , AssetHandleVOMeta.SORT_FIELD , AssetHandleVOMeta.SORT_TYPE , AssetHandleVOMeta.IDS } )
	@NotNull(name = AssetHandleVOMeta.ID)
	@SentinelResource(value = AssetHandleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.SAVE)
	public Result save(AssetHandleVO assetHandleVO) {
		Result result=assetHandleService.save(assetHandleVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取资产处置
	*/
	@ApiOperation(value = "获取资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetHandleVOMeta.ID)
	@SentinelResource(value = AssetHandleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.GET_BY_ID)
	public Result<AssetHandle> getById(String id) {
		Result<AssetHandle> result=new Result<>();
		AssetHandle assetHandle=assetHandleService.getById(id);

		// join 关联的对象
		assetHandleService.dao().fill(assetHandle)
			.execute();

		result.success(true).data(assetHandle);
		return result;
	}


	/**
	 * 批量获取资产处置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产处置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetHandleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetHandleVOMeta.IDS)
		@SentinelResource(value = AssetHandleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.GET_BY_IDS)
	public Result<List<AssetHandle>> getByIds(List<String> ids) {
		Result<List<AssetHandle>> result=new Result<>();
		List<AssetHandle> list=assetHandleService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产处置
	*/
	@ApiOperation(value = "查询资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.TYPE , value = "处置类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.HANDLE_NUMBER , value = "处置数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.HANDLE_DATE , value = "处理日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PLAN_FINISH_DATE , value = "计划完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ACTUAL_FINISH_DATE , value = "实际完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CRD_ACTION , value = "修改标记" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetHandleVOMeta.PAGE_INDEX , AssetHandleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetHandleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.QUERY_LIST)
	public Result<List<AssetHandle>> queryList(AssetHandleVO sample) {
		Result<List<AssetHandle>> result=new Result<>();
		List<AssetHandle> list=assetHandleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产处置
	*/
	@ApiOperation(value = "分页查询资产处置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetHandleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.TYPE , value = "处置类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CONTENT , value = "内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.HANDLE_NUMBER , value = "处置数量" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.HANDLE_DATE , value = "处理日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PLAN_FINISH_DATE , value = "计划完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ACTUAL_FINISH_DATE , value = "实际完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.CRD_ACTION , value = "修改标记" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetHandleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetHandleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetHandleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetHandle>> queryPagedList(AssetHandleVO sample) {
		Result<PagedList<AssetHandle>> result=new Result<>();
		PagedList<AssetHandle> list=assetHandleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		assetHandleService.dao().fill(list)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetHandleServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetHandleServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetHandleVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetHandleService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetHandleServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetHandleServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetHandleService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = AssetHandleServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetHandleServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetHandleService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}