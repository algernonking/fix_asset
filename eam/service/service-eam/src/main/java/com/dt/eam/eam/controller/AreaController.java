package com.dt.eam.eam.controller;

 
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


import com.dt.eam.proxy.eam.AreaServiceProxy;
import com.dt.eam.domain.eam.meta.AreaVOMeta;
import com.dt.eam.domain.eam.Area;
import com.dt.eam.domain.eam.AreaVO;
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
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.eam.eam.service.IAreaService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产存放区域 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-26 12:53:36
*/

@Api(tags = "资产存放区域")
@ApiSort(0)
@RestController("EamAreaController")
public class AreaController extends SuperController {

	@Autowired
	private IAreaService areaService;

	
	/**
	 * 添加资产存放区域
	*/
	@ApiOperation(value = "添加资产存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.AREA_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.AREA_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AreaVOMeta.ID)
	@SentinelResource(value = AreaServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.INSERT)
	public Result insert(AreaVO areaVO) {
		Result result=areaService.insert(areaVO);
		return result;
	}

	
	/**
	 * 删除资产存放区域
	*/
	@ApiOperation(value = "删除资产存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AreaVOMeta.ID)
	@SentinelResource(value = AreaServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=areaService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产存放区域 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AreaVOMeta.IDS)
	@SentinelResource(value = AreaServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=areaService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产存放区域
	*/
	@ApiOperation(value = "更新资产存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.AREA_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.AREA_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AreaVOMeta.PAGE_INDEX , AreaVOMeta.PAGE_SIZE , AreaVOMeta.SEARCH_FIELD , AreaVOMeta.SEARCH_VALUE , AreaVOMeta.SORT_FIELD , AreaVOMeta.SORT_TYPE , AreaVOMeta.IDS } ) 
	@NotNull(name = AreaVOMeta.ID)
	@SentinelResource(value = AreaServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.UPDATE)
	public Result update(AreaVO areaVO) {
		Result result=areaService.update(areaVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产存放区域
	*/
	@ApiOperation(value = "保存资产存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.AREA_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.AREA_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AreaVOMeta.PAGE_INDEX , AreaVOMeta.PAGE_SIZE , AreaVOMeta.SEARCH_FIELD , AreaVOMeta.SEARCH_VALUE , AreaVOMeta.SORT_FIELD , AreaVOMeta.SORT_TYPE , AreaVOMeta.IDS } )
	@NotNull(name = AreaVOMeta.ID)
	@SentinelResource(value = AreaServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.SAVE)
	public Result save(AreaVO areaVO) {
		Result result=areaService.save(areaVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产存放区域
	*/
	@ApiOperation(value = "获取资产存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AreaVOMeta.ID)
	@SentinelResource(value = AreaServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.GET_BY_ID)
	public Result<Area> getById(String id) {
		Result<Area> result=new Result<>();
		Area role=areaService.getById(id);
		result.success(true).data(role);
		return result;
	}


	/**
	 * 批量删除资产存放区域 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产存放区域")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AreaVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AreaVOMeta.IDS)
		@SentinelResource(value = AreaServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.GET_BY_IDS)
	public Result<List<Area>> getByIds(List<String> ids) {
		Result<List<Area>> result=new Result<>();
		List<Area> list=areaService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产存放区域
	*/
	@ApiOperation(value = "查询资产存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.AREA_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.AREA_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AreaVOMeta.PAGE_INDEX , AreaVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AreaServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.QUERY_LIST)
	public Result<List<Area>> queryList(AreaVO sample) {
		Result<List<Area>> result=new Result<>();
		List<Area> list=areaService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产存放区域
	*/
	@ApiOperation(value = "分页查询资产存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.AREA_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaVOMeta.AREA_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AreaServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Area>> queryPagedList(AreaVO sample) {
		Result<PagedList<Area>> result=new Result<>();
		PagedList<Area> list=areaService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AreaServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AreaServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AreaVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=areaService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AreaServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AreaServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=areaService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AreaServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AreaServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=areaService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}