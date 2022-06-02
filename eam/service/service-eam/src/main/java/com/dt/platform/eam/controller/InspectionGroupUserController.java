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


import com.dt.platform.proxy.eam.InspectionGroupUserServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionGroupUserVOMeta;
import com.dt.platform.domain.eam.InspectionGroupUser;
import com.dt.platform.domain.eam.InspectionGroupUserVO;
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
import com.dt.platform.domain.eam.meta.InspectionGroupUserMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionGroupUserService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 班组人员 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 13:29:26
*/

@Api(tags = "班组人员")
@ApiSort(0)
@RestController("EamInspectionGroupUserController")
public class InspectionGroupUserController extends SuperController {

	@Autowired
	private IInspectionGroupUserService inspectionGroupUserService;


	/**
	 * 添加班组人员
	*/
	@ApiOperation(value = "添加班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InspectionGroupUserServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupUserServiceProxy.INSERT)
	public Result insert(InspectionGroupUserVO inspectionGroupUserVO) {
		Result result=inspectionGroupUserService.insert(inspectionGroupUserVO,false);
		return result;
	}



	/**
	 * 删除班组人员
	*/
	@ApiOperation(value = "删除班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InspectionGroupUserVOMeta.ID)
	@SentinelResource(value = InspectionGroupUserServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupUserServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inspectionGroupUserService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除班组人员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InspectionGroupUserVOMeta.IDS)
	@SentinelResource(value = InspectionGroupUserServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupUserServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inspectionGroupUserService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新班组人员
	*/
	@ApiOperation(value = "更新班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InspectionGroupUserVOMeta.PAGE_INDEX , InspectionGroupUserVOMeta.PAGE_SIZE , InspectionGroupUserVOMeta.SEARCH_FIELD , InspectionGroupUserVOMeta.FUZZY_FIELD , InspectionGroupUserVOMeta.SEARCH_VALUE , InspectionGroupUserVOMeta.DIRTY_FIELDS , InspectionGroupUserVOMeta.SORT_FIELD , InspectionGroupUserVOMeta.SORT_TYPE , InspectionGroupUserVOMeta.IDS } )
	@NotNull(name = InspectionGroupUserVOMeta.ID)
	@SentinelResource(value = InspectionGroupUserServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupUserServiceProxy.UPDATE)
	public Result update(InspectionGroupUserVO inspectionGroupUserVO) {
		Result result=inspectionGroupUserService.update(inspectionGroupUserVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存班组人员
	*/
	@ApiOperation(value = "保存班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionGroupUserVOMeta.PAGE_INDEX , InspectionGroupUserVOMeta.PAGE_SIZE , InspectionGroupUserVOMeta.SEARCH_FIELD , InspectionGroupUserVOMeta.FUZZY_FIELD , InspectionGroupUserVOMeta.SEARCH_VALUE , InspectionGroupUserVOMeta.DIRTY_FIELDS , InspectionGroupUserVOMeta.SORT_FIELD , InspectionGroupUserVOMeta.SORT_TYPE , InspectionGroupUserVOMeta.IDS } )
	@NotNull(name = InspectionGroupUserVOMeta.ID)
	@SentinelResource(value = InspectionGroupUserServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupUserServiceProxy.SAVE)
	public Result save(InspectionGroupUserVO inspectionGroupUserVO) {
		Result result=inspectionGroupUserService.save(inspectionGroupUserVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取班组人员
	*/
	@ApiOperation(value = "获取班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InspectionGroupUserVOMeta.ID)
	@SentinelResource(value = InspectionGroupUserServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupUserServiceProxy.GET_BY_ID)
	public Result<InspectionGroupUser> getById(String id) {
		Result<InspectionGroupUser> result=new Result<>();
		InspectionGroupUser inspectionGroupUser=inspectionGroupUserService.getById(id);
		result.success(true).data(inspectionGroupUser);
		return result;
	}


	/**
	 * 批量获取班组人员 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取班组人员")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionGroupUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InspectionGroupUserVOMeta.IDS)
		@SentinelResource(value = InspectionGroupUserServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupUserServiceProxy.GET_BY_IDS)
	public Result<List<InspectionGroupUser>> getByIds(List<String> ids) {
		Result<List<InspectionGroupUser>> result=new Result<>();
		List<InspectionGroupUser> list=inspectionGroupUserService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询班组人员
	*/
	@ApiOperation(value = "查询班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionGroupUserVOMeta.PAGE_INDEX , InspectionGroupUserVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionGroupUserServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupUserServiceProxy.QUERY_LIST)
	public Result<List<InspectionGroupUser>> queryList(InspectionGroupUserVO sample) {
		Result<List<InspectionGroupUser>> result=new Result<>();
		List<InspectionGroupUser> list=inspectionGroupUserService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询班组人员
	*/
	@ApiOperation(value = "分页查询班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InspectionGroupUserServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupUserServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionGroupUser>> queryPagedList(InspectionGroupUserVO sample) {
		Result<PagedList<InspectionGroupUser>> result=new Result<>();
		PagedList<InspectionGroupUser> list=inspectionGroupUserService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InspectionGroupUserServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionGroupUserServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InspectionGroupUserVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inspectionGroupUserService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InspectionGroupUserServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionGroupUserServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inspectionGroupUserService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InspectionGroupUserServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionGroupUserServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inspectionGroupUserService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}