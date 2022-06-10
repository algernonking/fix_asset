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


import com.dt.platform.proxy.eam.MaintainProjectSelectServiceProxy;
import com.dt.platform.domain.eam.meta.MaintainProjectSelectVOMeta;
import com.dt.platform.domain.eam.MaintainProjectSelect;
import com.dt.platform.domain.eam.MaintainProjectSelectVO;
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
import com.dt.platform.domain.eam.meta.MaintainProjectSelectMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IMaintainProjectSelectService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 项目 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-07 06:54:18
*/

@Api(tags = "项目")
@ApiSort(0)
@RestController("EamMaintainProjectSelectController")
public class MaintainProjectSelectController extends SuperController {

	@Autowired
	private IMaintainProjectSelectService maintainProjectSelectService;


	/**
	 * 添加项目
	*/
	@ApiOperation(value = "添加项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.PROJECT_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.OWNER_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MaintainProjectSelectServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectSelectServiceProxy.INSERT)
	public Result insert(MaintainProjectSelectVO maintainProjectSelectVO) {
		Result result=maintainProjectSelectService.insert(maintainProjectSelectVO,false);
		return result;
	}



	/**
	 * 删除项目
	*/
	@ApiOperation(value = "删除项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MaintainProjectSelectVOMeta.ID)
	@SentinelResource(value = MaintainProjectSelectServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectSelectServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=maintainProjectSelectService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除项目 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MaintainProjectSelectVOMeta.IDS)
	@SentinelResource(value = MaintainProjectSelectServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectSelectServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=maintainProjectSelectService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新项目
	*/
	@ApiOperation(value = "更新项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.PROJECT_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.OWNER_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MaintainProjectSelectVOMeta.PAGE_INDEX , MaintainProjectSelectVOMeta.PAGE_SIZE , MaintainProjectSelectVOMeta.SEARCH_FIELD , MaintainProjectSelectVOMeta.FUZZY_FIELD , MaintainProjectSelectVOMeta.SEARCH_VALUE , MaintainProjectSelectVOMeta.DIRTY_FIELDS , MaintainProjectSelectVOMeta.SORT_FIELD , MaintainProjectSelectVOMeta.SORT_TYPE , MaintainProjectSelectVOMeta.IDS } )
	@NotNull(name = MaintainProjectSelectVOMeta.ID)
	@SentinelResource(value = MaintainProjectSelectServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectSelectServiceProxy.UPDATE)
	public Result update(MaintainProjectSelectVO maintainProjectSelectVO) {
		Result result=maintainProjectSelectService.update(maintainProjectSelectVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存项目
	*/
	@ApiOperation(value = "保存项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.PROJECT_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.OWNER_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainProjectSelectVOMeta.PAGE_INDEX , MaintainProjectSelectVOMeta.PAGE_SIZE , MaintainProjectSelectVOMeta.SEARCH_FIELD , MaintainProjectSelectVOMeta.FUZZY_FIELD , MaintainProjectSelectVOMeta.SEARCH_VALUE , MaintainProjectSelectVOMeta.DIRTY_FIELDS , MaintainProjectSelectVOMeta.SORT_FIELD , MaintainProjectSelectVOMeta.SORT_TYPE , MaintainProjectSelectVOMeta.IDS } )
	@NotNull(name = MaintainProjectSelectVOMeta.ID)
	@SentinelResource(value = MaintainProjectSelectServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectSelectServiceProxy.SAVE)
	public Result save(MaintainProjectSelectVO maintainProjectSelectVO) {
		Result result=maintainProjectSelectService.save(maintainProjectSelectVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取项目
	*/
	@ApiOperation(value = "获取项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MaintainProjectSelectVOMeta.ID)
	@SentinelResource(value = MaintainProjectSelectServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectSelectServiceProxy.GET_BY_ID)
	public Result<MaintainProjectSelect> getById(String id) {
		Result<MaintainProjectSelect> result=new Result<>();
		MaintainProjectSelect maintainProjectSelect=maintainProjectSelectService.getById(id);
		result.success(true).data(maintainProjectSelect);
		return result;
	}


	/**
	 * 批量获取项目 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取项目")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MaintainProjectSelectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MaintainProjectSelectVOMeta.IDS)
		@SentinelResource(value = MaintainProjectSelectServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectSelectServiceProxy.GET_BY_IDS)
	public Result<List<MaintainProjectSelect>> getByIds(List<String> ids) {
		Result<List<MaintainProjectSelect>> result=new Result<>();
		List<MaintainProjectSelect> list=maintainProjectSelectService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询项目
	*/
	@ApiOperation(value = "查询项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.PROJECT_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.OWNER_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainProjectSelectVOMeta.PAGE_INDEX , MaintainProjectSelectVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaintainProjectSelectServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectSelectServiceProxy.QUERY_LIST)
	public Result<List<MaintainProjectSelect>> queryList(MaintainProjectSelectVO sample) {
		Result<List<MaintainProjectSelect>> result=new Result<>();
		List<MaintainProjectSelect> list=maintainProjectSelectService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询项目
	*/
	@ApiOperation(value = "分页查询项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.PROJECT_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.OWNER_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectSelectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MaintainProjectSelectServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectSelectServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MaintainProjectSelect>> queryPagedList(MaintainProjectSelectVO sample) {
		Result<PagedList<MaintainProjectSelect>> result=new Result<>();
		PagedList<MaintainProjectSelect> list=maintainProjectSelectService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MaintainProjectSelectServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainProjectSelectServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MaintainProjectSelectVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=maintainProjectSelectService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MaintainProjectSelectServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainProjectSelectServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=maintainProjectSelectService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MaintainProjectSelectServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainProjectSelectServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=maintainProjectSelectService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}