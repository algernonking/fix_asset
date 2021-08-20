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


import com.dt.platform.proxy.eam.AssetExtSoftwareServiceProxy;
import com.dt.platform.domain.eam.meta.AssetExtSoftwareVOMeta;
import com.dt.platform.domain.eam.AssetExtSoftware;
import com.dt.platform.domain.eam.AssetExtSoftwareVO;
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
import com.dt.platform.domain.eam.meta.AssetExtSoftwareMeta;
import com.dt.platform.domain.eam.Asset;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetExtSoftwareService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产软件数据 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 16:44:05
*/

@Api(tags = "资产软件数据")
@ApiSort(0)
@RestController("EamAssetExtSoftwareController")
public class AssetExtSoftwareController extends SuperController {

	@Autowired
	private IAssetExtSoftwareService assetExtSoftwareService;

	
	/**
	 * 添加资产软件数据
	*/
	@ApiOperation(value = "添加资产软件数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.DISTRIBUTION_MODE , value = "发行方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetExtSoftwareVOMeta.ID)
	@SentinelResource(value = AssetExtSoftwareServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtSoftwareServiceProxy.INSERT)
	public Result insert(AssetExtSoftwareVO assetExtSoftwareVO) {
		Result result=assetExtSoftwareService.insert(assetExtSoftwareVO);
		return result;
	}

	
	/**
	 * 删除资产软件数据
	*/
	@ApiOperation(value = "删除资产软件数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetExtSoftwareVOMeta.ID)
	@SentinelResource(value = AssetExtSoftwareServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtSoftwareServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetExtSoftwareService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产软件数据 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产软件数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetExtSoftwareVOMeta.IDS)
	@SentinelResource(value = AssetExtSoftwareServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtSoftwareServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetExtSoftwareService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产软件数据
	*/
	@ApiOperation(value = "更新资产软件数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.DISTRIBUTION_MODE , value = "发行方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetExtSoftwareVOMeta.PAGE_INDEX , AssetExtSoftwareVOMeta.PAGE_SIZE , AssetExtSoftwareVOMeta.SEARCH_FIELD , AssetExtSoftwareVOMeta.FUZZY_FIELD , AssetExtSoftwareVOMeta.SEARCH_VALUE , AssetExtSoftwareVOMeta.SORT_FIELD , AssetExtSoftwareVOMeta.SORT_TYPE , AssetExtSoftwareVOMeta.IDS } ) 
	@NotNull(name = AssetExtSoftwareVOMeta.ID)
	@SentinelResource(value = AssetExtSoftwareServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtSoftwareServiceProxy.UPDATE)
	public Result update(AssetExtSoftwareVO assetExtSoftwareVO) {
		Result result=assetExtSoftwareService.update(assetExtSoftwareVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产软件数据
	*/
	@ApiOperation(value = "保存资产软件数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.DISTRIBUTION_MODE , value = "发行方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetExtSoftwareVOMeta.PAGE_INDEX , AssetExtSoftwareVOMeta.PAGE_SIZE , AssetExtSoftwareVOMeta.SEARCH_FIELD , AssetExtSoftwareVOMeta.FUZZY_FIELD , AssetExtSoftwareVOMeta.SEARCH_VALUE , AssetExtSoftwareVOMeta.SORT_FIELD , AssetExtSoftwareVOMeta.SORT_TYPE , AssetExtSoftwareVOMeta.IDS } )
	@NotNull(name = AssetExtSoftwareVOMeta.ID)
	@SentinelResource(value = AssetExtSoftwareServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtSoftwareServiceProxy.SAVE)
	public Result save(AssetExtSoftwareVO assetExtSoftwareVO) {
		Result result=assetExtSoftwareService.save(assetExtSoftwareVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产软件数据
	*/
	@ApiOperation(value = "获取资产软件数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetExtSoftwareVOMeta.ID)
	@SentinelResource(value = AssetExtSoftwareServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtSoftwareServiceProxy.GET_BY_ID)
	public Result<AssetExtSoftware> getById(String id) {
		Result<AssetExtSoftware> result=new Result<>();
		AssetExtSoftware assetExtSoftware=assetExtSoftwareService.getById(id);
		result.success(true).data(assetExtSoftware);
		return result;
	}


	/**
	 * 批量删除资产软件数据 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产软件数据")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetExtSoftwareVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetExtSoftwareVOMeta.IDS)
		@SentinelResource(value = AssetExtSoftwareServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtSoftwareServiceProxy.GET_BY_IDS)
	public Result<List<AssetExtSoftware>> getByIds(List<String> ids) {
		Result<List<AssetExtSoftware>> result=new Result<>();
		List<AssetExtSoftware> list=assetExtSoftwareService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产软件数据
	*/
	@ApiOperation(value = "查询资产软件数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.DISTRIBUTION_MODE , value = "发行方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetExtSoftwareVOMeta.PAGE_INDEX , AssetExtSoftwareVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetExtSoftwareServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtSoftwareServiceProxy.QUERY_LIST)
	public Result<List<AssetExtSoftware>> queryList(AssetExtSoftwareVO sample) {
		Result<List<AssetExtSoftware>> result=new Result<>();
		List<AssetExtSoftware> list=assetExtSoftwareService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产软件数据
	*/
	@ApiOperation(value = "分页查询资产软件数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.DISTRIBUTION_MODE , value = "发行方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtSoftwareVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetExtSoftwareServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtSoftwareServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetExtSoftware>> queryPagedList(AssetExtSoftwareVO sample) {
		Result<PagedList<AssetExtSoftware>> result=new Result<>();
		PagedList<AssetExtSoftware> list=assetExtSoftwareService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetExtSoftwareServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtSoftwareServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetExtSoftwareVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetExtSoftwareService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetExtSoftwareServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtSoftwareServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetExtSoftwareService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetExtSoftwareServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtSoftwareServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetExtSoftwareService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}