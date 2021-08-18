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


import com.dt.platform.proxy.eam.AssetItemServiceProxy;
import com.dt.platform.domain.eam.meta.AssetItemVOMeta;
import com.dt.platform.domain.eam.AssetItem;
import com.dt.platform.domain.eam.AssetItemVO;
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
import com.dt.platform.domain.eam.meta.AssetItemMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-18 11:52:56
*/

@Api(tags = "资产")
@ApiSort(0)
@RestController("EamAssetItemController")
public class AssetItemController extends SuperController {

	@Autowired
	private IAssetItemService assetItemService;

	
	/**
	 * 添加资产
	*/
	@ApiOperation(value = "添加资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetItemVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetItemVOMeta.ID)
	@NotNull(name = AssetItemVOMeta.ASSET_ID)
	@SentinelResource(value = AssetItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetItemServiceProxy.INSERT)
	public Result insert(AssetItemVO assetItemVO) {
		Result result=assetItemService.insert(assetItemVO);
		return result;
	}

	
	/**
	 * 删除资产
	*/
	@ApiOperation(value = "删除资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetItemVOMeta.ID)
	@SentinelResource(value = AssetItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetItemService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetItemVOMeta.IDS)
	@SentinelResource(value = AssetItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetItemService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产
	*/
	@ApiOperation(value = "更新资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetItemVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetItemVOMeta.PAGE_INDEX , AssetItemVOMeta.PAGE_SIZE , AssetItemVOMeta.SEARCH_FIELD , AssetItemVOMeta.FUZZY_FIELD , AssetItemVOMeta.SEARCH_VALUE , AssetItemVOMeta.SORT_FIELD , AssetItemVOMeta.SORT_TYPE , AssetItemVOMeta.IDS } ) 
	@NotNull(name = AssetItemVOMeta.ID)
	@NotNull(name = AssetItemVOMeta.ASSET_ID)
	@SentinelResource(value = AssetItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetItemServiceProxy.UPDATE)
	public Result update(AssetItemVO assetItemVO) {
		Result result=assetItemService.update(assetItemVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产
	*/
	@ApiOperation(value = "保存资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetItemVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetItemVOMeta.PAGE_INDEX , AssetItemVOMeta.PAGE_SIZE , AssetItemVOMeta.SEARCH_FIELD , AssetItemVOMeta.FUZZY_FIELD , AssetItemVOMeta.SEARCH_VALUE , AssetItemVOMeta.SORT_FIELD , AssetItemVOMeta.SORT_TYPE , AssetItemVOMeta.IDS } )
	@NotNull(name = AssetItemVOMeta.ID)
	@NotNull(name = AssetItemVOMeta.ASSET_ID)
	@SentinelResource(value = AssetItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetItemServiceProxy.SAVE)
	public Result save(AssetItemVO assetItemVO) {
		Result result=assetItemService.save(assetItemVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产
	*/
	@ApiOperation(value = "获取资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetItemVOMeta.ID)
	@SentinelResource(value = AssetItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetItemServiceProxy.GET_BY_ID)
	public Result<AssetItem> getById(String id) {
		Result<AssetItem> result=new Result<>();
		AssetItem assetItem=assetItemService.getById(id);
		result.success(true).data(assetItem);
		return result;
	}


	/**
	 * 批量删除资产 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetItemVOMeta.IDS)
		@SentinelResource(value = AssetItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetItemServiceProxy.GET_BY_IDS)
	public Result<List<AssetItem>> getByIds(List<String> ids) {
		Result<List<AssetItem>> result=new Result<>();
		List<AssetItem> list=assetItemService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产
	*/
	@ApiOperation(value = "查询资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetItemVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetItemVOMeta.PAGE_INDEX , AssetItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetItemServiceProxy.QUERY_LIST)
	public Result<List<AssetItem>> queryList(AssetItemVO sample) {
		Result<List<AssetItem>> result=new Result<>();
		List<AssetItem> list=assetItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产
	*/
	@ApiOperation(value = "分页查询资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetItemVOMeta.ASSET_ID , value = "资产" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetItem>> queryPagedList(AssetItemVO sample) {
		Result<PagedList<AssetItem>> result=new Result<>();
		PagedList<AssetItem> list=assetItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetItemServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetItemServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetItemVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetItemService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetItemServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetItemServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetItemService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetItemServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetItemServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetItemService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}