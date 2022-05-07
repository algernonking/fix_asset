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


import com.dt.platform.proxy.eam.AssetSoftwareMaintenanceDetailServiceProxy;
import com.dt.platform.domain.eam.meta.AssetSoftwareMaintenanceDetailVOMeta;
import com.dt.platform.domain.eam.AssetSoftwareMaintenanceDetail;
import com.dt.platform.domain.eam.AssetSoftwareMaintenanceDetailVO;
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
import com.dt.platform.domain.eam.meta.AssetSoftwareMaintenanceDetailMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetSoftwareMaintenanceDetailService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 软件维保明细 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-07 06:34:37
*/

@Api(tags = "软件维保明细")
@ApiSort(0)
@RestController("EamAssetSoftwareMaintenanceDetailController")
public class AssetSoftwareMaintenanceDetailController extends SuperController {

	@Autowired
	private IAssetSoftwareMaintenanceDetailService assetSoftwareMaintenanceDetailService;


	/**
	 * 添加软件维保明细
	*/
	@ApiOperation(value = "添加软件维保明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "575076211424763904"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.MAINTENANCE_ID , value = "变更" , required = false , dataTypeClass=String.class , example = "574704806673776640"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.SOFTWARE_ID , value = "软件信息" , required = false , dataTypeClass=String.class , example = "574828713917546496"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceDetailServiceProxy.INSERT)
	public Result insert(AssetSoftwareMaintenanceDetailVO assetSoftwareMaintenanceDetailVO) {
		Result result=assetSoftwareMaintenanceDetailService.insert(assetSoftwareMaintenanceDetailVO,false);
		return result;
	}



	/**
	 * 删除软件维保明细
	*/
	@ApiOperation(value = "删除软件维保明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "575076211424763904")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetSoftwareMaintenanceDetailVOMeta.ID)
	@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceDetailServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetSoftwareMaintenanceDetailService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除软件维保明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除软件维保明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetSoftwareMaintenanceDetailVOMeta.IDS)
	@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceDetailServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetSoftwareMaintenanceDetailService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新软件维保明细
	*/
	@ApiOperation(value = "更新软件维保明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "575076211424763904"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.MAINTENANCE_ID , value = "变更" , required = false , dataTypeClass=String.class , example = "574704806673776640"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.SOFTWARE_ID , value = "软件信息" , required = false , dataTypeClass=String.class , example = "574828713917546496"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetSoftwareMaintenanceDetailVOMeta.PAGE_INDEX , AssetSoftwareMaintenanceDetailVOMeta.PAGE_SIZE , AssetSoftwareMaintenanceDetailVOMeta.SEARCH_FIELD , AssetSoftwareMaintenanceDetailVOMeta.FUZZY_FIELD , AssetSoftwareMaintenanceDetailVOMeta.SEARCH_VALUE , AssetSoftwareMaintenanceDetailVOMeta.DIRTY_FIELDS , AssetSoftwareMaintenanceDetailVOMeta.SORT_FIELD , AssetSoftwareMaintenanceDetailVOMeta.SORT_TYPE , AssetSoftwareMaintenanceDetailVOMeta.IDS } )
	@NotNull(name = AssetSoftwareMaintenanceDetailVOMeta.ID)
	@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceDetailServiceProxy.UPDATE)
	public Result update(AssetSoftwareMaintenanceDetailVO assetSoftwareMaintenanceDetailVO) {
		Result result=assetSoftwareMaintenanceDetailService.update(assetSoftwareMaintenanceDetailVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存软件维保明细
	*/
	@ApiOperation(value = "保存软件维保明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "575076211424763904"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.MAINTENANCE_ID , value = "变更" , required = false , dataTypeClass=String.class , example = "574704806673776640"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.SOFTWARE_ID , value = "软件信息" , required = false , dataTypeClass=String.class , example = "574828713917546496"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareMaintenanceDetailVOMeta.PAGE_INDEX , AssetSoftwareMaintenanceDetailVOMeta.PAGE_SIZE , AssetSoftwareMaintenanceDetailVOMeta.SEARCH_FIELD , AssetSoftwareMaintenanceDetailVOMeta.FUZZY_FIELD , AssetSoftwareMaintenanceDetailVOMeta.SEARCH_VALUE , AssetSoftwareMaintenanceDetailVOMeta.DIRTY_FIELDS , AssetSoftwareMaintenanceDetailVOMeta.SORT_FIELD , AssetSoftwareMaintenanceDetailVOMeta.SORT_TYPE , AssetSoftwareMaintenanceDetailVOMeta.IDS } )
	@NotNull(name = AssetSoftwareMaintenanceDetailVOMeta.ID)
	@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceDetailServiceProxy.SAVE)
	public Result save(AssetSoftwareMaintenanceDetailVO assetSoftwareMaintenanceDetailVO) {
		Result result=assetSoftwareMaintenanceDetailService.save(assetSoftwareMaintenanceDetailVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取软件维保明细
	*/
	@ApiOperation(value = "获取软件维保明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetSoftwareMaintenanceDetailVOMeta.ID)
	@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceDetailServiceProxy.GET_BY_ID)
	public Result<AssetSoftwareMaintenanceDetail> getById(String id) {
		Result<AssetSoftwareMaintenanceDetail> result=new Result<>();
		AssetSoftwareMaintenanceDetail assetSoftwareMaintenanceDetail=assetSoftwareMaintenanceDetailService.getById(id);
		result.success(true).data(assetSoftwareMaintenanceDetail);
		return result;
	}


	/**
	 * 批量获取软件维保明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取软件维保明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetSoftwareMaintenanceDetailVOMeta.IDS)
		@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceDetailServiceProxy.GET_BY_IDS)
	public Result<List<AssetSoftwareMaintenanceDetail>> getByIds(List<String> ids) {
		Result<List<AssetSoftwareMaintenanceDetail>> result=new Result<>();
		List<AssetSoftwareMaintenanceDetail> list=assetSoftwareMaintenanceDetailService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询软件维保明细
	*/
	@ApiOperation(value = "查询软件维保明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "575076211424763904"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.MAINTENANCE_ID , value = "变更" , required = false , dataTypeClass=String.class , example = "574704806673776640"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.SOFTWARE_ID , value = "软件信息" , required = false , dataTypeClass=String.class , example = "574828713917546496"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareMaintenanceDetailVOMeta.PAGE_INDEX , AssetSoftwareMaintenanceDetailVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceDetailServiceProxy.QUERY_LIST)
	public Result<List<AssetSoftwareMaintenanceDetail>> queryList(AssetSoftwareMaintenanceDetailVO sample) {
		Result<List<AssetSoftwareMaintenanceDetail>> result=new Result<>();
		List<AssetSoftwareMaintenanceDetail> list=assetSoftwareMaintenanceDetailService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询软件维保明细
	*/
	@ApiOperation(value = "分页查询软件维保明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "575076211424763904"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.MAINTENANCE_ID , value = "变更" , required = false , dataTypeClass=String.class , example = "574704806673776640"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.SOFTWARE_ID , value = "软件信息" , required = false , dataTypeClass=String.class , example = "574828713917546496"),
		@ApiImplicitParam(name = AssetSoftwareMaintenanceDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareMaintenanceDetailServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetSoftwareMaintenanceDetail>> queryPagedList(AssetSoftwareMaintenanceDetailVO sample) {
		Result<PagedList<AssetSoftwareMaintenanceDetail>> result=new Result<>();
		PagedList<AssetSoftwareMaintenanceDetail> list=assetSoftwareMaintenanceDetailService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareMaintenanceDetailServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetSoftwareMaintenanceDetailVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetSoftwareMaintenanceDetailService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareMaintenanceDetailServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetSoftwareMaintenanceDetailService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetSoftwareMaintenanceDetailServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareMaintenanceDetailServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetSoftwareMaintenanceDetailService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}