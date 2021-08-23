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


import com.dt.platform.proxy.eam.AssetBorrowReturnServiceProxy;
import com.dt.platform.domain.eam.meta.AssetBorrowReturnVOMeta;
import com.dt.platform.domain.eam.AssetBorrowReturn;
import com.dt.platform.domain.eam.AssetBorrowReturnVO;
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
import com.dt.platform.domain.eam.meta.AssetBorrowReturnMeta;
import com.dt.platform.domain.eam.Asset;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetBorrowReturnService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产借用归还 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-22 13:16:02
*/

@Api(tags = "资产借用归还")
@ApiSort(0)
@RestController("EamAssetBorrowReturnController")
public class AssetBorrowReturnController extends SuperController {

	@Autowired
	private IAssetBorrowReturnService assetBorrowReturnService;

	
	/**
	 * 添加资产借用归还
	*/
	@ApiOperation(value = "添加资产借用归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BORROW_ID , value = "借用单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.RETURN_DATE , value = "归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.CONTENT , value = "归还说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetBorrowReturnVOMeta.ID)
	@SentinelResource(value = AssetBorrowReturnServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.INSERT)
	public Result insert(AssetBorrowReturnVO assetBorrowReturnVO) {
		Result result=assetBorrowReturnService.insert(assetBorrowReturnVO);
		return result;
	}

	
	/**
	 * 删除资产借用归还
	*/
	@ApiOperation(value = "删除资产借用归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetBorrowReturnVOMeta.ID)
	@SentinelResource(value = AssetBorrowReturnServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetBorrowReturnService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产借用归还 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产借用归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetBorrowReturnVOMeta.IDS)
	@SentinelResource(value = AssetBorrowReturnServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetBorrowReturnService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产借用归还
	*/
	@ApiOperation(value = "更新资产借用归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BORROW_ID , value = "借用单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.RETURN_DATE , value = "归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.CONTENT , value = "归还说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetBorrowReturnVOMeta.PAGE_INDEX , AssetBorrowReturnVOMeta.PAGE_SIZE , AssetBorrowReturnVOMeta.SEARCH_FIELD , AssetBorrowReturnVOMeta.FUZZY_FIELD , AssetBorrowReturnVOMeta.SEARCH_VALUE , AssetBorrowReturnVOMeta.SORT_FIELD , AssetBorrowReturnVOMeta.SORT_TYPE , AssetBorrowReturnVOMeta.IDS } ) 
	@NotNull(name = AssetBorrowReturnVOMeta.ID)
	@SentinelResource(value = AssetBorrowReturnServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.UPDATE)
	public Result update(AssetBorrowReturnVO assetBorrowReturnVO) {
		Result result=assetBorrowReturnService.update(assetBorrowReturnVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产借用归还
	*/
	@ApiOperation(value = "保存资产借用归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BORROW_ID , value = "借用单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.RETURN_DATE , value = "归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.CONTENT , value = "归还说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetBorrowReturnVOMeta.PAGE_INDEX , AssetBorrowReturnVOMeta.PAGE_SIZE , AssetBorrowReturnVOMeta.SEARCH_FIELD , AssetBorrowReturnVOMeta.FUZZY_FIELD , AssetBorrowReturnVOMeta.SEARCH_VALUE , AssetBorrowReturnVOMeta.SORT_FIELD , AssetBorrowReturnVOMeta.SORT_TYPE , AssetBorrowReturnVOMeta.IDS } )
	@NotNull(name = AssetBorrowReturnVOMeta.ID)
	@SentinelResource(value = AssetBorrowReturnServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.SAVE)
	public Result save(AssetBorrowReturnVO assetBorrowReturnVO) {
		Result result=assetBorrowReturnService.save(assetBorrowReturnVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产借用归还
	*/
	@ApiOperation(value = "获取资产借用归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetBorrowReturnVOMeta.ID)
	@SentinelResource(value = AssetBorrowReturnServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.GET_BY_ID)
	public Result<AssetBorrowReturn> getById(String id) {
		Result<AssetBorrowReturn> result=new Result<>();
		AssetBorrowReturn assetBorrowReturn=assetBorrowReturnService.getById(id);
		result.success(true).data(assetBorrowReturn);
		return result;
	}


	/**
	 * 批量删除资产借用归还 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产借用归还")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetBorrowReturnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetBorrowReturnVOMeta.IDS)
		@SentinelResource(value = AssetBorrowReturnServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.GET_BY_IDS)
	public Result<List<AssetBorrowReturn>> getByIds(List<String> ids) {
		Result<List<AssetBorrowReturn>> result=new Result<>();
		List<AssetBorrowReturn> list=assetBorrowReturnService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产借用归还
	*/
	@ApiOperation(value = "查询资产借用归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BORROW_ID , value = "借用单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.RETURN_DATE , value = "归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.CONTENT , value = "归还说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetBorrowReturnVOMeta.PAGE_INDEX , AssetBorrowReturnVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetBorrowReturnServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.QUERY_LIST)
	public Result<List<AssetBorrowReturn>> queryList(AssetBorrowReturnVO sample) {
		Result<List<AssetBorrowReturn>> result=new Result<>();
		List<AssetBorrowReturn> list=assetBorrowReturnService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产借用归还
	*/
	@ApiOperation(value = "分页查询资产借用归还")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.BORROW_ID , value = "借用单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.RETURN_DATE , value = "归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.CONTENT , value = "归还说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetBorrowReturnServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowReturnServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetBorrowReturn>> queryPagedList(AssetBorrowReturnVO sample) {
		Result<PagedList<AssetBorrowReturn>> result=new Result<>();
		PagedList<AssetBorrowReturn> list=assetBorrowReturnService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetBorrowReturnServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetBorrowReturnServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetBorrowReturnVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetBorrowReturnService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetBorrowReturnServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetBorrowReturnServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetBorrowReturnService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetBorrowReturnServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetBorrowReturnServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetBorrowReturnService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}