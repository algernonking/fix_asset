package com.dt.platform.vehicle.controller;


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


import com.dt.platform.proxy.vehicle.MSelectItemServiceProxy;
import com.dt.platform.domain.vehicle.meta.MSelectItemVOMeta;
import com.dt.platform.domain.vehicle.MSelectItem;
import com.dt.platform.domain.vehicle.MSelectItemVO;
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
import com.dt.platform.domain.vehicle.meta.MSelectItemMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.vehicle.service.IMSelectItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆数据 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 19:42:47
*/

@Api(tags = "车辆数据")
@ApiSort(0)
@RestController("VehicleMSelectItemController")
public class MSelectItemController extends SuperController {

	@Autowired
	private IMSelectItemService mSelectItemService;


	/**
	 * 添加车辆数据
	*/
	@ApiOperation(value = "添加车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MSelectItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.INSERT)
	public Result insert(MSelectItemVO mSelectItemVO) {
		Result result=mSelectItemService.insert(mSelectItemVO,false);
		return result;
	}



	/**
	 * 删除车辆数据
	*/
	@ApiOperation(value = "删除车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MSelectItemVOMeta.ID)
	@SentinelResource(value = MSelectItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=mSelectItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆数据 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MSelectItemVOMeta.IDS)
	@SentinelResource(value = MSelectItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=mSelectItemService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新车辆数据
	*/
	@ApiOperation(value = "更新车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MSelectItemVOMeta.PAGE_INDEX , MSelectItemVOMeta.PAGE_SIZE , MSelectItemVOMeta.SEARCH_FIELD , MSelectItemVOMeta.FUZZY_FIELD , MSelectItemVOMeta.SEARCH_VALUE , MSelectItemVOMeta.DIRTY_FIELDS , MSelectItemVOMeta.SORT_FIELD , MSelectItemVOMeta.SORT_TYPE , MSelectItemVOMeta.IDS } )
	@NotNull(name = MSelectItemVOMeta.ID)
	@SentinelResource(value = MSelectItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.UPDATE)
	public Result update(MSelectItemVO mSelectItemVO) {
		Result result=mSelectItemService.update(mSelectItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆数据
	*/
	@ApiOperation(value = "保存车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MSelectItemVOMeta.PAGE_INDEX , MSelectItemVOMeta.PAGE_SIZE , MSelectItemVOMeta.SEARCH_FIELD , MSelectItemVOMeta.FUZZY_FIELD , MSelectItemVOMeta.SEARCH_VALUE , MSelectItemVOMeta.DIRTY_FIELDS , MSelectItemVOMeta.SORT_FIELD , MSelectItemVOMeta.SORT_TYPE , MSelectItemVOMeta.IDS } )
	@NotNull(name = MSelectItemVOMeta.ID)
	@SentinelResource(value = MSelectItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.SAVE)
	public Result save(MSelectItemVO mSelectItemVO) {
		Result result=mSelectItemService.save(mSelectItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆数据
	*/
	@ApiOperation(value = "获取车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MSelectItemVOMeta.ID)
	@SentinelResource(value = MSelectItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.GET_BY_ID)
	public Result<MSelectItem> getById(String id) {
		Result<MSelectItem> result=new Result<>();
		MSelectItem mSelectItem=mSelectItemService.getById(id);
		result.success(true).data(mSelectItem);
		return result;
	}


	/**
	 * 批量获取车辆数据 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆数据")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MSelectItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MSelectItemVOMeta.IDS)
		@SentinelResource(value = MSelectItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.GET_BY_IDS)
	public Result<List<MSelectItem>> getByIds(List<String> ids) {
		Result<List<MSelectItem>> result=new Result<>();
		List<MSelectItem> list=mSelectItemService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆数据
	*/
	@ApiOperation(value = "查询车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MSelectItemVOMeta.PAGE_INDEX , MSelectItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MSelectItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.QUERY_LIST)
	public Result<List<MSelectItem>> queryList(MSelectItemVO sample) {
		Result<List<MSelectItem>> result=new Result<>();
		List<MSelectItem> list=mSelectItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆数据
	*/
	@ApiOperation(value = "分页查询车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MSelectItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MSelectItem>> queryPagedList(MSelectItemVO sample) {
		Result<PagedList<MSelectItem>> result=new Result<>();
		PagedList<MSelectItem> list=mSelectItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MSelectItemServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MSelectItemServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MSelectItemVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=mSelectItemService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MSelectItemServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MSelectItemServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=mSelectItemService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MSelectItemServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MSelectItemServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=mSelectItemService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}