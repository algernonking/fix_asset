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


import com.dt.platform.proxy.eam.RepairGroupUserServiceProxy;
import com.dt.platform.domain.eam.meta.RepairGroupUserVOMeta;
import com.dt.platform.domain.eam.RepairGroupUser;
import com.dt.platform.domain.eam.RepairGroupUserVO;
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
import com.dt.platform.domain.eam.meta.RepairGroupUserMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairGroupUserService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 班组人员 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 13:29:30
*/

@Api(tags = "班组人员")
@ApiSort(0)
@RestController("EamRepairGroupUserController")
public class RepairGroupUserController extends SuperController {

	@Autowired
	private IRepairGroupUserService repairGroupUserService;


	/**
	 * 添加班组人员
	*/
	@ApiOperation(value = "添加班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairGroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairGroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RepairGroupUserServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairGroupUserServiceProxy.INSERT)
	public Result insert(RepairGroupUserVO repairGroupUserVO) {
		Result result=repairGroupUserService.insert(repairGroupUserVO,false);
		return result;
	}



	/**
	 * 删除班组人员
	*/
	@ApiOperation(value = "删除班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RepairGroupUserVOMeta.ID)
	@SentinelResource(value = RepairGroupUserServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairGroupUserServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=repairGroupUserService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除班组人员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairGroupUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RepairGroupUserVOMeta.IDS)
	@SentinelResource(value = RepairGroupUserServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairGroupUserServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=repairGroupUserService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新班组人员
	*/
	@ApiOperation(value = "更新班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairGroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairGroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RepairGroupUserVOMeta.PAGE_INDEX , RepairGroupUserVOMeta.PAGE_SIZE , RepairGroupUserVOMeta.SEARCH_FIELD , RepairGroupUserVOMeta.FUZZY_FIELD , RepairGroupUserVOMeta.SEARCH_VALUE , RepairGroupUserVOMeta.DIRTY_FIELDS , RepairGroupUserVOMeta.SORT_FIELD , RepairGroupUserVOMeta.SORT_TYPE , RepairGroupUserVOMeta.IDS } )
	@NotNull(name = RepairGroupUserVOMeta.ID)
	@SentinelResource(value = RepairGroupUserServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairGroupUserServiceProxy.UPDATE)
	public Result update(RepairGroupUserVO repairGroupUserVO) {
		Result result=repairGroupUserService.update(repairGroupUserVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存班组人员
	*/
	@ApiOperation(value = "保存班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairGroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairGroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairGroupUserVOMeta.PAGE_INDEX , RepairGroupUserVOMeta.PAGE_SIZE , RepairGroupUserVOMeta.SEARCH_FIELD , RepairGroupUserVOMeta.FUZZY_FIELD , RepairGroupUserVOMeta.SEARCH_VALUE , RepairGroupUserVOMeta.DIRTY_FIELDS , RepairGroupUserVOMeta.SORT_FIELD , RepairGroupUserVOMeta.SORT_TYPE , RepairGroupUserVOMeta.IDS } )
	@NotNull(name = RepairGroupUserVOMeta.ID)
	@SentinelResource(value = RepairGroupUserServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairGroupUserServiceProxy.SAVE)
	public Result save(RepairGroupUserVO repairGroupUserVO) {
		Result result=repairGroupUserService.save(repairGroupUserVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取班组人员
	*/
	@ApiOperation(value = "获取班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RepairGroupUserVOMeta.ID)
	@SentinelResource(value = RepairGroupUserServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairGroupUserServiceProxy.GET_BY_ID)
	public Result<RepairGroupUser> getById(String id) {
		Result<RepairGroupUser> result=new Result<>();
		RepairGroupUser repairGroupUser=repairGroupUserService.getById(id);
		result.success(true).data(repairGroupUser);
		return result;
	}


	/**
	 * 批量获取班组人员 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取班组人员")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepairGroupUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RepairGroupUserVOMeta.IDS)
		@SentinelResource(value = RepairGroupUserServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairGroupUserServiceProxy.GET_BY_IDS)
	public Result<List<RepairGroupUser>> getByIds(List<String> ids) {
		Result<List<RepairGroupUser>> result=new Result<>();
		List<RepairGroupUser> list=repairGroupUserService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询班组人员
	*/
	@ApiOperation(value = "查询班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairGroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairGroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairGroupUserVOMeta.PAGE_INDEX , RepairGroupUserVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepairGroupUserServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairGroupUserServiceProxy.QUERY_LIST)
	public Result<List<RepairGroupUser>> queryList(RepairGroupUserVO sample) {
		Result<List<RepairGroupUser>> result=new Result<>();
		List<RepairGroupUser> list=repairGroupUserService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询班组人员
	*/
	@ApiOperation(value = "分页查询班组人员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairGroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairGroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairGroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RepairGroupUserServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairGroupUserServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepairGroupUser>> queryPagedList(RepairGroupUserVO sample) {
		Result<PagedList<RepairGroupUser>> result=new Result<>();
		PagedList<RepairGroupUser> list=repairGroupUserService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RepairGroupUserServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairGroupUserServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RepairGroupUserVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=repairGroupUserService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RepairGroupUserServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairGroupUserServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=repairGroupUserService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = RepairGroupUserServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairGroupUserServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=repairGroupUserService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}