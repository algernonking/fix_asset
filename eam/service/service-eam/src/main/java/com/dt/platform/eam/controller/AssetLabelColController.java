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


import com.dt.platform.proxy.eam.AssetLabelColServiceProxy;
import com.dt.platform.domain.eam.meta.AssetLabelColVOMeta;
import com.dt.platform.domain.eam.AssetLabelCol;
import com.dt.platform.domain.eam.AssetLabelColVO;
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
import com.dt.platform.domain.eam.meta.AssetLabelColMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetLabelColService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 标签字段 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-20 21:16:59
*/

@Api(tags = "标签字段")
@ApiSort(0)
@RestController("EamAssetLabelColController")
public class AssetLabelColController extends SuperController {

	@Autowired
	private IAssetLabelColService assetLabelColService;


	/**
	 * 添加标签字段
	*/
	@ApiOperation(value = "添加标签字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.COL_VALUE , value = "字段" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.COL_NAME , value = "字段名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.IS_IMAGE , value = "是否图像" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.IMAGE_TYPE , value = "图像类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetLabelColServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelColServiceProxy.INSERT)
	public Result insert(AssetLabelColVO assetLabelColVO) {
		Result result=assetLabelColService.insert(assetLabelColVO,false);
		return result;
	}



	/**
	 * 删除标签字段
	*/
	@ApiOperation(value = "删除标签字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetLabelColVOMeta.ID)
	@SentinelResource(value = AssetLabelColServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelColServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetLabelColService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除标签字段 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除标签字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelColVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetLabelColVOMeta.IDS)
	@SentinelResource(value = AssetLabelColServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelColServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetLabelColService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新标签字段
	*/
	@ApiOperation(value = "更新标签字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.COL_VALUE , value = "字段" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.COL_NAME , value = "字段名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.IS_IMAGE , value = "是否图像" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.IMAGE_TYPE , value = "图像类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetLabelColVOMeta.PAGE_INDEX , AssetLabelColVOMeta.PAGE_SIZE , AssetLabelColVOMeta.SEARCH_FIELD , AssetLabelColVOMeta.FUZZY_FIELD , AssetLabelColVOMeta.SEARCH_VALUE , AssetLabelColVOMeta.DIRTY_FIELDS , AssetLabelColVOMeta.SORT_FIELD , AssetLabelColVOMeta.SORT_TYPE , AssetLabelColVOMeta.IDS } )
	@NotNull(name = AssetLabelColVOMeta.ID)
	@SentinelResource(value = AssetLabelColServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelColServiceProxy.UPDATE)
	public Result update(AssetLabelColVO assetLabelColVO) {
		Result result=assetLabelColService.update(assetLabelColVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存标签字段
	*/
	@ApiOperation(value = "保存标签字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.COL_VALUE , value = "字段" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.COL_NAME , value = "字段名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.IS_IMAGE , value = "是否图像" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.IMAGE_TYPE , value = "图像类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetLabelColVOMeta.PAGE_INDEX , AssetLabelColVOMeta.PAGE_SIZE , AssetLabelColVOMeta.SEARCH_FIELD , AssetLabelColVOMeta.FUZZY_FIELD , AssetLabelColVOMeta.SEARCH_VALUE , AssetLabelColVOMeta.DIRTY_FIELDS , AssetLabelColVOMeta.SORT_FIELD , AssetLabelColVOMeta.SORT_TYPE , AssetLabelColVOMeta.IDS } )
	@NotNull(name = AssetLabelColVOMeta.ID)
	@SentinelResource(value = AssetLabelColServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelColServiceProxy.SAVE)
	public Result save(AssetLabelColVO assetLabelColVO) {
		Result result=assetLabelColService.save(assetLabelColVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取标签字段
	*/
	@ApiOperation(value = "获取标签字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetLabelColVOMeta.ID)
	@SentinelResource(value = AssetLabelColServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelColServiceProxy.GET_BY_ID)
	public Result<AssetLabelCol> getById(String id) {
		Result<AssetLabelCol> result=new Result<>();
		AssetLabelCol assetLabelCol=assetLabelColService.getById(id);
		result.success(true).data(assetLabelCol);
		return result;
	}


	/**
	 * 批量获取标签字段 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取标签字段")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetLabelColVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetLabelColVOMeta.IDS)
		@SentinelResource(value = AssetLabelColServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelColServiceProxy.GET_BY_IDS)
	public Result<List<AssetLabelCol>> getByIds(List<String> ids) {
		Result<List<AssetLabelCol>> result=new Result<>();
		List<AssetLabelCol> list=assetLabelColService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询标签字段
	*/
	@ApiOperation(value = "查询标签字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.COL_VALUE , value = "字段" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.COL_NAME , value = "字段名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.IS_IMAGE , value = "是否图像" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.IMAGE_TYPE , value = "图像类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetLabelColVOMeta.PAGE_INDEX , AssetLabelColVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetLabelColServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelColServiceProxy.QUERY_LIST)
	public Result<List<AssetLabelCol>> queryList(AssetLabelColVO sample) {
		Result<List<AssetLabelCol>> result=new Result<>();
		List<AssetLabelCol> list=assetLabelColService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询标签字段
	*/
	@ApiOperation(value = "分页查询标签字段")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelColVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.COL_VALUE , value = "字段" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.COL_NAME , value = "字段名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.IS_IMAGE , value = "是否图像" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.IMAGE_TYPE , value = "图像类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelColVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetLabelColServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelColServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetLabelCol>> queryPagedList(AssetLabelColVO sample) {
		Result<PagedList<AssetLabelCol>> result=new Result<>();
		PagedList<AssetLabelCol> list=assetLabelColService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetLabelColServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelColServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetLabelColVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetLabelColService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetLabelColServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelColServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetLabelColService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetLabelColServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelColServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetLabelColService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}