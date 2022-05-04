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


import com.dt.platform.proxy.eam.AssetSoftwareDistributeDataServiceProxy;
import com.dt.platform.domain.eam.meta.AssetSoftwareDistributeDataVOMeta;
import com.dt.platform.domain.eam.AssetSoftwareDistributeData;
import com.dt.platform.domain.eam.AssetSoftwareDistributeDataVO;
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
import com.dt.platform.domain.eam.meta.AssetSoftwareDistributeDataMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetSoftwareDistributeDataService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 软件分发项 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-05 06:25:01
*/

@Api(tags = "软件分发项")
@ApiSort(0)
@RestController("EamAssetSoftwareDistributeDataController")
public class AssetSoftwareDistributeDataController extends SuperController {

	@Autowired
	private IAssetSoftwareDistributeDataService assetSoftwareDistributeDataService;


	/**
	 * 添加软件分发项
	*/
	@ApiOperation(value = "添加软件分发项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.DISTRIBUTE_ID , value = "软件分发" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.AUTHORIZED_NUMBER , value = "授权数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.AUTHORIZED_INFO , value = "授权信息" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeDataServiceProxy.INSERT)
	public Result insert(AssetSoftwareDistributeDataVO assetSoftwareDistributeDataVO) {
		Result result=assetSoftwareDistributeDataService.insert(assetSoftwareDistributeDataVO,false);
		return result;
	}



	/**
	 * 删除软件分发项
	*/
	@ApiOperation(value = "删除软件分发项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetSoftwareDistributeDataVOMeta.ID)
	@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeDataServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetSoftwareDistributeDataService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除软件分发项 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除软件分发项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetSoftwareDistributeDataVOMeta.IDS)
	@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeDataServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetSoftwareDistributeDataService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新软件分发项
	*/
	@ApiOperation(value = "更新软件分发项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.DISTRIBUTE_ID , value = "软件分发" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.AUTHORIZED_NUMBER , value = "授权数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.AUTHORIZED_INFO , value = "授权信息" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetSoftwareDistributeDataVOMeta.PAGE_INDEX , AssetSoftwareDistributeDataVOMeta.PAGE_SIZE , AssetSoftwareDistributeDataVOMeta.SEARCH_FIELD , AssetSoftwareDistributeDataVOMeta.FUZZY_FIELD , AssetSoftwareDistributeDataVOMeta.SEARCH_VALUE , AssetSoftwareDistributeDataVOMeta.DIRTY_FIELDS , AssetSoftwareDistributeDataVOMeta.SORT_FIELD , AssetSoftwareDistributeDataVOMeta.SORT_TYPE , AssetSoftwareDistributeDataVOMeta.IDS } )
	@NotNull(name = AssetSoftwareDistributeDataVOMeta.ID)
	@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeDataServiceProxy.UPDATE)
	public Result update(AssetSoftwareDistributeDataVO assetSoftwareDistributeDataVO) {
		Result result=assetSoftwareDistributeDataService.update(assetSoftwareDistributeDataVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存软件分发项
	*/
	@ApiOperation(value = "保存软件分发项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.DISTRIBUTE_ID , value = "软件分发" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.AUTHORIZED_NUMBER , value = "授权数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.AUTHORIZED_INFO , value = "授权信息" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareDistributeDataVOMeta.PAGE_INDEX , AssetSoftwareDistributeDataVOMeta.PAGE_SIZE , AssetSoftwareDistributeDataVOMeta.SEARCH_FIELD , AssetSoftwareDistributeDataVOMeta.FUZZY_FIELD , AssetSoftwareDistributeDataVOMeta.SEARCH_VALUE , AssetSoftwareDistributeDataVOMeta.DIRTY_FIELDS , AssetSoftwareDistributeDataVOMeta.SORT_FIELD , AssetSoftwareDistributeDataVOMeta.SORT_TYPE , AssetSoftwareDistributeDataVOMeta.IDS } )
	@NotNull(name = AssetSoftwareDistributeDataVOMeta.ID)
	@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeDataServiceProxy.SAVE)
	public Result save(AssetSoftwareDistributeDataVO assetSoftwareDistributeDataVO) {
		Result result=assetSoftwareDistributeDataService.save(assetSoftwareDistributeDataVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取软件分发项
	*/
	@ApiOperation(value = "获取软件分发项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetSoftwareDistributeDataVOMeta.ID)
	@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeDataServiceProxy.GET_BY_ID)
	public Result<AssetSoftwareDistributeData> getById(String id) {
		Result<AssetSoftwareDistributeData> result=new Result<>();
		AssetSoftwareDistributeData assetSoftwareDistributeData=assetSoftwareDistributeDataService.getById(id);
		result.success(true).data(assetSoftwareDistributeData);
		return result;
	}


	/**
	 * 批量获取软件分发项 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取软件分发项")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetSoftwareDistributeDataVOMeta.IDS)
		@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeDataServiceProxy.GET_BY_IDS)
	public Result<List<AssetSoftwareDistributeData>> getByIds(List<String> ids) {
		Result<List<AssetSoftwareDistributeData>> result=new Result<>();
		List<AssetSoftwareDistributeData> list=assetSoftwareDistributeDataService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询软件分发项
	*/
	@ApiOperation(value = "查询软件分发项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.DISTRIBUTE_ID , value = "软件分发" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.AUTHORIZED_NUMBER , value = "授权数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.AUTHORIZED_INFO , value = "授权信息" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareDistributeDataVOMeta.PAGE_INDEX , AssetSoftwareDistributeDataVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeDataServiceProxy.QUERY_LIST)
	public Result<List<AssetSoftwareDistributeData>> queryList(AssetSoftwareDistributeDataVO sample) {
		Result<List<AssetSoftwareDistributeData>> result=new Result<>();
		List<AssetSoftwareDistributeData> list=assetSoftwareDistributeDataService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询软件分发项
	*/
	@ApiOperation(value = "分页查询软件分发项")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.DISTRIBUTE_ID , value = "软件分发" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.AUTHORIZED_NUMBER , value = "授权数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetSoftwareDistributeDataVOMeta.AUTHORIZED_INFO , value = "授权信息" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareDistributeDataServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetSoftwareDistributeData>> queryPagedList(AssetSoftwareDistributeDataVO sample) {
		Result<PagedList<AssetSoftwareDistributeData>> result=new Result<>();
		PagedList<AssetSoftwareDistributeData> list=assetSoftwareDistributeDataService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareDistributeDataServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetSoftwareDistributeDataVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetSoftwareDistributeDataService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareDistributeDataServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetSoftwareDistributeDataService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetSoftwareDistributeDataServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareDistributeDataServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetSoftwareDistributeDataService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}