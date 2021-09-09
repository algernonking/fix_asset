package com.dt.platform.datacenter.controller;

 
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


import com.dt.platform.proxy.datacenter.LayerServiceProxy;
import com.dt.platform.domain.datacenter.meta.LayerVOMeta;
import com.dt.platform.domain.datacenter.Layer;
import com.dt.platform.domain.datacenter.LayerVO;
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
import com.dt.platform.domain.datacenter.meta.LayerMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.datacenter.service.ILayerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 层级 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-09 12:25:55
*/

@Api(tags = "层级")
@ApiSort(0)
@RestController("DcLayerController")
public class LayerController extends SuperController {

	@Autowired
	private ILayerService layerService;

	
	/**
	 * 添加层级
	*/
	@ApiOperation(value = "添加层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473609699250405376"),
		@ApiImplicitParam(name = LayerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "4楼"),
		@ApiImplicitParam(name = LayerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = LayerVOMeta.ID)
	@SentinelResource(value = LayerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LayerServiceProxy.INSERT)
	public Result insert(LayerVO layerVO) {
		Result result=layerService.insert(layerVO);
		return result;
	}

	
	/**
	 * 删除层级
	*/
	@ApiOperation(value = "删除层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473609699250405376")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = LayerVOMeta.ID)
	@SentinelResource(value = LayerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LayerServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=layerService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除层级 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LayerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = LayerVOMeta.IDS)
	@SentinelResource(value = LayerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LayerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=layerService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新层级
	*/
	@ApiOperation(value = "更新层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473609699250405376"),
		@ApiImplicitParam(name = LayerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "4楼"),
		@ApiImplicitParam(name = LayerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { LayerVOMeta.PAGE_INDEX , LayerVOMeta.PAGE_SIZE , LayerVOMeta.SEARCH_FIELD , LayerVOMeta.FUZZY_FIELD , LayerVOMeta.SEARCH_VALUE , LayerVOMeta.SORT_FIELD , LayerVOMeta.SORT_TYPE , LayerVOMeta.IDS } ) 
	@NotNull(name = LayerVOMeta.ID)
	@SentinelResource(value = LayerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LayerServiceProxy.UPDATE)
	public Result update(LayerVO layerVO) {
		Result result=layerService.update(layerVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存层级
	*/
	@ApiOperation(value = "保存层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473609699250405376"),
		@ApiImplicitParam(name = LayerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "4楼"),
		@ApiImplicitParam(name = LayerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { LayerVOMeta.PAGE_INDEX , LayerVOMeta.PAGE_SIZE , LayerVOMeta.SEARCH_FIELD , LayerVOMeta.FUZZY_FIELD , LayerVOMeta.SEARCH_VALUE , LayerVOMeta.SORT_FIELD , LayerVOMeta.SORT_TYPE , LayerVOMeta.IDS } )
	@NotNull(name = LayerVOMeta.ID)
	@SentinelResource(value = LayerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LayerServiceProxy.SAVE)
	public Result save(LayerVO layerVO) {
		Result result=layerService.save(layerVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取层级
	*/
	@ApiOperation(value = "获取层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = LayerVOMeta.ID)
	@SentinelResource(value = LayerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LayerServiceProxy.GET_BY_ID)
	public Result<Layer> getById(String id) {
		Result<Layer> result=new Result<>();
		Layer layer=layerService.getById(id);
		result.success(true).data(layer);
		return result;
	}


	/**
	 * 批量删除层级 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除层级")
		@ApiImplicitParams({
				@ApiImplicitParam(name = LayerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = LayerVOMeta.IDS)
		@SentinelResource(value = LayerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LayerServiceProxy.GET_BY_IDS)
	public Result<List<Layer>> getByIds(List<String> ids) {
		Result<List<Layer>> result=new Result<>();
		List<Layer> list=layerService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询层级
	*/
	@ApiOperation(value = "查询层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473609699250405376"),
		@ApiImplicitParam(name = LayerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "4楼"),
		@ApiImplicitParam(name = LayerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { LayerVOMeta.PAGE_INDEX , LayerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = LayerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LayerServiceProxy.QUERY_LIST)
	public Result<List<Layer>> queryList(LayerVO sample) {
		Result<List<Layer>> result=new Result<>();
		List<Layer> list=layerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询层级
	*/
	@ApiOperation(value = "分页查询层级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LayerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473609699250405376"),
		@ApiImplicitParam(name = LayerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "4楼"),
		@ApiImplicitParam(name = LayerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = LayerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LayerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Layer>> queryPagedList(LayerVO sample) {
		Result<PagedList<Layer>> result=new Result<>();
		PagedList<Layer> list=layerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = LayerServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(LayerServiceProxy.EXPORT_EXCEL)
	public void exportExcel(LayerVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=layerService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = LayerServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(LayerServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=layerService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = LayerServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(LayerServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=layerService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}