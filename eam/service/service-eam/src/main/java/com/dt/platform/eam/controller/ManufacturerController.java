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


import com.dt.platform.proxy.eam.ManufacturerServiceProxy;
import com.dt.platform.domain.eam.meta.ManufacturerVOMeta;
import com.dt.platform.domain.eam.Manufacturer;
import com.dt.platform.domain.eam.ManufacturerVO;
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
import com.dt.platform.domain.eam.meta.ManufacturerMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IManufacturerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 生产厂商 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 11:16:15
*/

@Api(tags = "生产厂商")
@ApiSort(0)
@RestController("EamManufacturerController")
public class ManufacturerController extends SuperController {

	@Autowired
	private IManufacturerService manufacturerService;

	
	/**
	 * 添加生产厂商
	*/
	@ApiOperation(value = "添加生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = ManufacturerVOMeta.MANUFACTURER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "华为公司"),
		@ApiImplicitParam(name = ManufacturerVOMeta.LOCATION , value = "所在地" , required = false , dataTypeClass=String.class , example = "中国"),
		@ApiImplicitParam(name = ManufacturerVOMeta.MANUFACTURER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ManufacturerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ManufacturerServiceProxy.INSERT)
	public Result insert(ManufacturerVO manufacturerVO) {
		Result result=manufacturerService.insert(manufacturerVO);
		return result;
	}

	
	/**
	 * 删除生产厂商
	*/
	@ApiOperation(value = "删除生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669992140570624")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ManufacturerVOMeta.ID)
	@SentinelResource(value = ManufacturerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ManufacturerServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=manufacturerService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除生产厂商 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ManufacturerVOMeta.IDS)
	@SentinelResource(value = ManufacturerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ManufacturerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=manufacturerService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新生产厂商
	*/
	@ApiOperation(value = "更新生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = ManufacturerVOMeta.MANUFACTURER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "华为公司"),
		@ApiImplicitParam(name = ManufacturerVOMeta.LOCATION , value = "所在地" , required = false , dataTypeClass=String.class , example = "中国"),
		@ApiImplicitParam(name = ManufacturerVOMeta.MANUFACTURER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ManufacturerVOMeta.PAGE_INDEX , ManufacturerVOMeta.PAGE_SIZE , ManufacturerVOMeta.SEARCH_FIELD , ManufacturerVOMeta.FUZZY_FIELD , ManufacturerVOMeta.SEARCH_VALUE , ManufacturerVOMeta.SORT_FIELD , ManufacturerVOMeta.SORT_TYPE , ManufacturerVOMeta.IDS } ) 
	@NotNull(name = ManufacturerVOMeta.ID)
	@SentinelResource(value = ManufacturerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ManufacturerServiceProxy.UPDATE)
	public Result update(ManufacturerVO manufacturerVO) {
		Result result=manufacturerService.update(manufacturerVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存生产厂商
	*/
	@ApiOperation(value = "保存生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = ManufacturerVOMeta.MANUFACTURER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "华为公司"),
		@ApiImplicitParam(name = ManufacturerVOMeta.LOCATION , value = "所在地" , required = false , dataTypeClass=String.class , example = "中国"),
		@ApiImplicitParam(name = ManufacturerVOMeta.MANUFACTURER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ManufacturerVOMeta.PAGE_INDEX , ManufacturerVOMeta.PAGE_SIZE , ManufacturerVOMeta.SEARCH_FIELD , ManufacturerVOMeta.FUZZY_FIELD , ManufacturerVOMeta.SEARCH_VALUE , ManufacturerVOMeta.SORT_FIELD , ManufacturerVOMeta.SORT_TYPE , ManufacturerVOMeta.IDS } )
	@NotNull(name = ManufacturerVOMeta.ID)
	@SentinelResource(value = ManufacturerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ManufacturerServiceProxy.SAVE)
	public Result save(ManufacturerVO manufacturerVO) {
		Result result=manufacturerService.save(manufacturerVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取生产厂商
	*/
	@ApiOperation(value = "获取生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ManufacturerVOMeta.ID)
	@SentinelResource(value = ManufacturerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ManufacturerServiceProxy.GET_BY_ID)
	public Result<Manufacturer> getById(String id) {
		Result<Manufacturer> result=new Result<>();
		Manufacturer manufacturer=manufacturerService.getById(id);
		result.success(true).data(manufacturer);
		return result;
	}


	/**
	 * 批量删除生产厂商 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除生产厂商")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ManufacturerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ManufacturerVOMeta.IDS)
		@SentinelResource(value = ManufacturerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ManufacturerServiceProxy.GET_BY_IDS)
	public Result<List<Manufacturer>> getByIds(List<String> ids) {
		Result<List<Manufacturer>> result=new Result<>();
		List<Manufacturer> list=manufacturerService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询生产厂商
	*/
	@ApiOperation(value = "查询生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = ManufacturerVOMeta.MANUFACTURER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "华为公司"),
		@ApiImplicitParam(name = ManufacturerVOMeta.LOCATION , value = "所在地" , required = false , dataTypeClass=String.class , example = "中国"),
		@ApiImplicitParam(name = ManufacturerVOMeta.MANUFACTURER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ManufacturerVOMeta.PAGE_INDEX , ManufacturerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ManufacturerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ManufacturerServiceProxy.QUERY_LIST)
	public Result<List<Manufacturer>> queryList(ManufacturerVO sample) {
		Result<List<Manufacturer>> result=new Result<>();
		List<Manufacturer> list=manufacturerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询生产厂商
	*/
	@ApiOperation(value = "分页查询生产厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ManufacturerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669992140570624"),
		@ApiImplicitParam(name = ManufacturerVOMeta.MANUFACTURER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "华为公司"),
		@ApiImplicitParam(name = ManufacturerVOMeta.LOCATION , value = "所在地" , required = false , dataTypeClass=String.class , example = "中国"),
		@ApiImplicitParam(name = ManufacturerVOMeta.MANUFACTURER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ManufacturerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ManufacturerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Manufacturer>> queryPagedList(ManufacturerVO sample) {
		Result<PagedList<Manufacturer>> result=new Result<>();
		PagedList<Manufacturer> list=manufacturerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ManufacturerServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ManufacturerServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ManufacturerVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=manufacturerService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ManufacturerServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ManufacturerServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=manufacturerService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ManufacturerServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ManufacturerServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=manufacturerService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}