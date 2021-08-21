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


import com.dt.platform.proxy.eam.AssetChangeDataServiceProxy;
import com.dt.platform.domain.eam.meta.AssetChangeDataVOMeta;
import com.dt.platform.domain.eam.AssetChangeData;
import com.dt.platform.domain.eam.AssetChangeDataVO;
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
import com.dt.platform.domain.eam.meta.AssetChangeDataMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetChangeDataService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 变更明细 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 11:53:55
*/

@Api(tags = "变更明细")
@ApiSort(0)
@RestController("EamAssetChangeDataController")
public class AssetChangeDataController extends SuperController {

	@Autowired
	private IAssetChangeDataService assetChangeDataService;

	
	/**
	 * 添加变更明细
	*/
	@ApiOperation(value = "添加变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.BUSINESS_CODE , value = "变更号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CONTENT , value = "变更内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CHANGE_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CHANGE_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetChangeDataVOMeta.ID)
	@SentinelResource(value = AssetChangeDataServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetChangeDataServiceProxy.INSERT)
	public Result insert(AssetChangeDataVO assetChangeDataVO) {
		Result result=assetChangeDataService.insert(assetChangeDataVO);
		return result;
	}

	
	/**
	 * 删除变更明细
	*/
	@ApiOperation(value = "删除变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetChangeDataVOMeta.ID)
	@SentinelResource(value = AssetChangeDataServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetChangeDataServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetChangeDataService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除变更明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetChangeDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetChangeDataVOMeta.IDS)
	@SentinelResource(value = AssetChangeDataServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetChangeDataServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetChangeDataService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新变更明细
	*/
	@ApiOperation(value = "更新变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.BUSINESS_CODE , value = "变更号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CONTENT , value = "变更内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CHANGE_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CHANGE_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetChangeDataVOMeta.PAGE_INDEX , AssetChangeDataVOMeta.PAGE_SIZE , AssetChangeDataVOMeta.SEARCH_FIELD , AssetChangeDataVOMeta.FUZZY_FIELD , AssetChangeDataVOMeta.SEARCH_VALUE , AssetChangeDataVOMeta.SORT_FIELD , AssetChangeDataVOMeta.SORT_TYPE , AssetChangeDataVOMeta.IDS } ) 
	@NotNull(name = AssetChangeDataVOMeta.ID)
	@SentinelResource(value = AssetChangeDataServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetChangeDataServiceProxy.UPDATE)
	public Result update(AssetChangeDataVO assetChangeDataVO) {
		Result result=assetChangeDataService.update(assetChangeDataVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存变更明细
	*/
	@ApiOperation(value = "保存变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.BUSINESS_CODE , value = "变更号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CONTENT , value = "变更内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CHANGE_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CHANGE_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetChangeDataVOMeta.PAGE_INDEX , AssetChangeDataVOMeta.PAGE_SIZE , AssetChangeDataVOMeta.SEARCH_FIELD , AssetChangeDataVOMeta.FUZZY_FIELD , AssetChangeDataVOMeta.SEARCH_VALUE , AssetChangeDataVOMeta.SORT_FIELD , AssetChangeDataVOMeta.SORT_TYPE , AssetChangeDataVOMeta.IDS } )
	@NotNull(name = AssetChangeDataVOMeta.ID)
	@SentinelResource(value = AssetChangeDataServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetChangeDataServiceProxy.SAVE)
	public Result save(AssetChangeDataVO assetChangeDataVO) {
		Result result=assetChangeDataService.save(assetChangeDataVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取变更明细
	*/
	@ApiOperation(value = "获取变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetChangeDataVOMeta.ID)
	@SentinelResource(value = AssetChangeDataServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetChangeDataServiceProxy.GET_BY_ID)
	public Result<AssetChangeData> getById(String id) {
		Result<AssetChangeData> result=new Result<>();
		AssetChangeData assetChangeData=assetChangeDataService.getById(id);
		result.success(true).data(assetChangeData);
		return result;
	}


	/**
	 * 批量删除变更明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除变更明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetChangeDataVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetChangeDataVOMeta.IDS)
		@SentinelResource(value = AssetChangeDataServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetChangeDataServiceProxy.GET_BY_IDS)
	public Result<List<AssetChangeData>> getByIds(List<String> ids) {
		Result<List<AssetChangeData>> result=new Result<>();
		List<AssetChangeData> list=assetChangeDataService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询变更明细
	*/
	@ApiOperation(value = "查询变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.BUSINESS_CODE , value = "变更号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CONTENT , value = "变更内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CHANGE_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CHANGE_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetChangeDataVOMeta.PAGE_INDEX , AssetChangeDataVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetChangeDataServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetChangeDataServiceProxy.QUERY_LIST)
	public Result<List<AssetChangeData>> queryList(AssetChangeDataVO sample) {
		Result<List<AssetChangeData>> result=new Result<>();
		List<AssetChangeData> list=assetChangeDataService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询变更明细
	*/
	@ApiOperation(value = "分页查询变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.BUSINESS_CODE , value = "变更号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CONTENT , value = "变更内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CHANGE_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetChangeDataVOMeta.CHANGE_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetChangeDataServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetChangeDataServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetChangeData>> queryPagedList(AssetChangeDataVO sample) {
		Result<PagedList<AssetChangeData>> result=new Result<>();
		PagedList<AssetChangeData> list=assetChangeDataService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetChangeDataServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetChangeDataServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetChangeDataVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetChangeDataService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetChangeDataServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetChangeDataServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetChangeDataService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetChangeDataServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetChangeDataServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetChangeDataService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}