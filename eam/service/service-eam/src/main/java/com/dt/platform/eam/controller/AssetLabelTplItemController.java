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


import com.dt.platform.proxy.eam.AssetLabelTplItemServiceProxy;
import com.dt.platform.domain.eam.meta.AssetLabelTplItemVOMeta;
import com.dt.platform.domain.eam.AssetLabelTplItem;
import com.dt.platform.domain.eam.AssetLabelTplItemVO;
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
import com.dt.platform.domain.eam.meta.AssetLabelTplItemMeta;
import com.dt.platform.domain.eam.AssetLabelCol;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetLabelTplItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 标签模版 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-24 09:56:56
*/

@Api(tags = "标签模版")
@ApiSort(0)
@RestController("EamAssetLabelTplItemController")
public class AssetLabelTplItemController extends SuperController {

	@Autowired
	private IAssetLabelTplItemService assetLabelTplItemService;


	/**
	 * 添加标签模版
	*/
	@ApiOperation(value = "添加标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class , example = "t1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.COL_ID , value = "字段ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetLabelTplItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplItemServiceProxy.INSERT)
	public Result insert(AssetLabelTplItemVO assetLabelTplItemVO) {
		Result result=assetLabelTplItemService.insert(assetLabelTplItemVO,false);
		return result;
	}



	/**
	 * 删除标签模版
	*/
	@ApiOperation(value = "删除标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetLabelTplItemVOMeta.ID)
	@SentinelResource(value = AssetLabelTplItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetLabelTplItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除标签模版 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetLabelTplItemVOMeta.IDS)
	@SentinelResource(value = AssetLabelTplItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetLabelTplItemService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新标签模版
	*/
	@ApiOperation(value = "更新标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class , example = "t1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.COL_ID , value = "字段ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetLabelTplItemVOMeta.PAGE_INDEX , AssetLabelTplItemVOMeta.PAGE_SIZE , AssetLabelTplItemVOMeta.SEARCH_FIELD , AssetLabelTplItemVOMeta.FUZZY_FIELD , AssetLabelTplItemVOMeta.SEARCH_VALUE , AssetLabelTplItemVOMeta.DIRTY_FIELDS , AssetLabelTplItemVOMeta.SORT_FIELD , AssetLabelTplItemVOMeta.SORT_TYPE , AssetLabelTplItemVOMeta.IDS } )
	@NotNull(name = AssetLabelTplItemVOMeta.ID)
	@SentinelResource(value = AssetLabelTplItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplItemServiceProxy.UPDATE)
	public Result update(AssetLabelTplItemVO assetLabelTplItemVO) {
		Result result=assetLabelTplItemService.update(assetLabelTplItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存标签模版
	*/
	@ApiOperation(value = "保存标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class , example = "t1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.COL_ID , value = "字段ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetLabelTplItemVOMeta.PAGE_INDEX , AssetLabelTplItemVOMeta.PAGE_SIZE , AssetLabelTplItemVOMeta.SEARCH_FIELD , AssetLabelTplItemVOMeta.FUZZY_FIELD , AssetLabelTplItemVOMeta.SEARCH_VALUE , AssetLabelTplItemVOMeta.DIRTY_FIELDS , AssetLabelTplItemVOMeta.SORT_FIELD , AssetLabelTplItemVOMeta.SORT_TYPE , AssetLabelTplItemVOMeta.IDS } )
	@NotNull(name = AssetLabelTplItemVOMeta.ID)
	@SentinelResource(value = AssetLabelTplItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplItemServiceProxy.SAVE)
	public Result save(AssetLabelTplItemVO assetLabelTplItemVO) {
		Result result=assetLabelTplItemService.save(assetLabelTplItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取标签模版
	*/
	@ApiOperation(value = "获取标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetLabelTplItemVOMeta.ID)
	@SentinelResource(value = AssetLabelTplItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplItemServiceProxy.GET_BY_ID)
	public Result<AssetLabelTplItem> getById(String id) {
		Result<AssetLabelTplItem> result=new Result<>();
		AssetLabelTplItem assetLabelTplItem=assetLabelTplItemService.getById(id);
		result.success(true).data(assetLabelTplItem);
		return result;
	}


	/**
	 * 批量获取标签模版 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取标签模版")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetLabelTplItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetLabelTplItemVOMeta.IDS)
		@SentinelResource(value = AssetLabelTplItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplItemServiceProxy.GET_BY_IDS)
	public Result<List<AssetLabelTplItem>> getByIds(List<String> ids) {
		Result<List<AssetLabelTplItem>> result=new Result<>();
		List<AssetLabelTplItem> list=assetLabelTplItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询标签模版
	*/
	@ApiOperation(value = "查询标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class , example = "t1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.COL_ID , value = "字段ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetLabelTplItemVOMeta.PAGE_INDEX , AssetLabelTplItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetLabelTplItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplItemServiceProxy.QUERY_LIST)
	public Result<List<AssetLabelTplItem>> queryList(AssetLabelTplItemVO sample) {
		Result<List<AssetLabelTplItem>> result=new Result<>();
		List<AssetLabelTplItem> list=assetLabelTplItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询标签模版
	*/
	@ApiOperation(value = "分页查询标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class , example = "t1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.COL_ID , value = "字段ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplItemVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "1"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetLabelTplItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetLabelTplItem>> queryPagedList(AssetLabelTplItemVO sample) {
		Result<PagedList<AssetLabelTplItem>> result=new Result<>();
		PagedList<AssetLabelTplItem> list=assetLabelTplItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetLabelTplItemServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelTplItemServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetLabelTplItemVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetLabelTplItemService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetLabelTplItemServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelTplItemServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetLabelTplItemService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetLabelTplItemServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelTplItemServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetLabelTplItemService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}