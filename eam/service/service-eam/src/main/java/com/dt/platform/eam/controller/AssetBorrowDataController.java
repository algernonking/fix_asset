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


import com.dt.platform.proxy.eam.AssetBorrowDataServiceProxy;
import com.dt.platform.domain.eam.meta.AssetBorrowDataVOMeta;
import com.dt.platform.domain.eam.AssetBorrowData;
import com.dt.platform.domain.eam.AssetBorrowDataVO;
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
import com.dt.platform.domain.eam.meta.AssetBorrowDataMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetBorrowDataService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产借用数据 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-22 13:16:03
*/

@Api(tags = "资产借用数据")
@ApiSort(0)
@RestController("EamAssetBorrowDataController")
public class AssetBorrowDataController extends SuperController {

	@Autowired
	private IAssetBorrowDataService assetBorrowDataService;

	
	/**
	 * 添加资产借用数据
	*/
	@ApiOperation(value = "添加资产借用数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ASSET_STATUS_BEFORE , value = "借前资产状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.USER_ID_BEFORE , value = "借前使用人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetBorrowDataVOMeta.ID)
	@SentinelResource(value = AssetBorrowDataServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowDataServiceProxy.INSERT)
	public Result insert(AssetBorrowDataVO assetBorrowDataVO) {
		Result result=assetBorrowDataService.insert(assetBorrowDataVO);
		return result;
	}

	
	/**
	 * 删除资产借用数据
	*/
	@ApiOperation(value = "删除资产借用数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetBorrowDataVOMeta.ID)
	@SentinelResource(value = AssetBorrowDataServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowDataServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetBorrowDataService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产借用数据 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产借用数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetBorrowDataVOMeta.IDS)
	@SentinelResource(value = AssetBorrowDataServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowDataServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetBorrowDataService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产借用数据
	*/
	@ApiOperation(value = "更新资产借用数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ASSET_STATUS_BEFORE , value = "借前资产状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.USER_ID_BEFORE , value = "借前使用人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetBorrowDataVOMeta.PAGE_INDEX , AssetBorrowDataVOMeta.PAGE_SIZE , AssetBorrowDataVOMeta.SEARCH_FIELD , AssetBorrowDataVOMeta.FUZZY_FIELD , AssetBorrowDataVOMeta.SEARCH_VALUE , AssetBorrowDataVOMeta.SORT_FIELD , AssetBorrowDataVOMeta.SORT_TYPE , AssetBorrowDataVOMeta.IDS } ) 
	@NotNull(name = AssetBorrowDataVOMeta.ID)
	@SentinelResource(value = AssetBorrowDataServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowDataServiceProxy.UPDATE)
	public Result update(AssetBorrowDataVO assetBorrowDataVO) {
		Result result=assetBorrowDataService.update(assetBorrowDataVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产借用数据
	*/
	@ApiOperation(value = "保存资产借用数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ASSET_STATUS_BEFORE , value = "借前资产状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.USER_ID_BEFORE , value = "借前使用人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetBorrowDataVOMeta.PAGE_INDEX , AssetBorrowDataVOMeta.PAGE_SIZE , AssetBorrowDataVOMeta.SEARCH_FIELD , AssetBorrowDataVOMeta.FUZZY_FIELD , AssetBorrowDataVOMeta.SEARCH_VALUE , AssetBorrowDataVOMeta.SORT_FIELD , AssetBorrowDataVOMeta.SORT_TYPE , AssetBorrowDataVOMeta.IDS } )
	@NotNull(name = AssetBorrowDataVOMeta.ID)
	@SentinelResource(value = AssetBorrowDataServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowDataServiceProxy.SAVE)
	public Result save(AssetBorrowDataVO assetBorrowDataVO) {
		Result result=assetBorrowDataService.save(assetBorrowDataVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产借用数据
	*/
	@ApiOperation(value = "获取资产借用数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetBorrowDataVOMeta.ID)
	@SentinelResource(value = AssetBorrowDataServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowDataServiceProxy.GET_BY_ID)
	public Result<AssetBorrowData> getById(String id) {
		Result<AssetBorrowData> result=new Result<>();
		AssetBorrowData assetBorrowData=assetBorrowDataService.getById(id);
		result.success(true).data(assetBorrowData);
		return result;
	}


	/**
	 * 批量删除资产借用数据 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产借用数据")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetBorrowDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetBorrowDataVOMeta.IDS)
		@SentinelResource(value = AssetBorrowDataServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowDataServiceProxy.GET_BY_IDS)
	public Result<List<AssetBorrowData>> getByIds(List<String> ids) {
		Result<List<AssetBorrowData>> result=new Result<>();
		List<AssetBorrowData> list=assetBorrowDataService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产借用数据
	*/
	@ApiOperation(value = "查询资产借用数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ASSET_STATUS_BEFORE , value = "借前资产状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.USER_ID_BEFORE , value = "借前使用人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetBorrowDataVOMeta.PAGE_INDEX , AssetBorrowDataVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetBorrowDataServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowDataServiceProxy.QUERY_LIST)
	public Result<List<AssetBorrowData>> queryList(AssetBorrowDataVO sample) {
		Result<List<AssetBorrowData>> result=new Result<>();
		List<AssetBorrowData> list=assetBorrowDataService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产借用数据
	*/
	@ApiOperation(value = "分页查询资产借用数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.ASSET_STATUS_BEFORE , value = "借前资产状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowDataVOMeta.USER_ID_BEFORE , value = "借前使用人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetBorrowDataServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowDataServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetBorrowData>> queryPagedList(AssetBorrowDataVO sample) {
		Result<PagedList<AssetBorrowData>> result=new Result<>();
		PagedList<AssetBorrowData> list=assetBorrowDataService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetBorrowDataServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetBorrowDataServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetBorrowDataVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetBorrowDataService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetBorrowDataServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetBorrowDataServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetBorrowDataService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetBorrowDataServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetBorrowDataServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetBorrowDataService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}