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


import com.dt.platform.proxy.eam.InspectionGroupServiceProxy;
import com.dt.platform.domain.eam.meta.InspectionGroupVOMeta;
import com.dt.platform.domain.eam.InspectionGroup;
import com.dt.platform.domain.eam.InspectionGroupVO;
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
import com.dt.platform.domain.eam.meta.InspectionGroupMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInspectionGroupService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检班组 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-27 21:27:38
*/

@Api(tags = "巡检班组")
@ApiSort(0)
@RestController("EamInspectionGroupController")
public class InspectionGroupController extends SuperController {

	@Autowired
	private IInspectionGroupService inspectionGroupService;


	/**
	 * 添加巡检班组
	*/
	@ApiOperation(value = "添加巡检班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571667599155269632"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "班组1"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupVOMeta.OPER_USER , value = "成员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "班组2"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InspectionGroupServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupServiceProxy.INSERT)
	public Result insert(InspectionGroupVO inspectionGroupVO) {
		Result result=inspectionGroupService.insert(inspectionGroupVO,false);
		return result;
	}



	/**
	 * 删除巡检班组
	*/
	@ApiOperation(value = "删除巡检班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571667599155269632")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InspectionGroupVOMeta.ID)
	@SentinelResource(value = InspectionGroupServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inspectionGroupService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除巡检班组 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除巡检班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InspectionGroupVOMeta.IDS)
	@SentinelResource(value = InspectionGroupServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inspectionGroupService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新巡检班组
	*/
	@ApiOperation(value = "更新巡检班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571667599155269632"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "班组1"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupVOMeta.OPER_USER , value = "成员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "班组2"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InspectionGroupVOMeta.PAGE_INDEX , InspectionGroupVOMeta.PAGE_SIZE , InspectionGroupVOMeta.SEARCH_FIELD , InspectionGroupVOMeta.FUZZY_FIELD , InspectionGroupVOMeta.SEARCH_VALUE , InspectionGroupVOMeta.DIRTY_FIELDS , InspectionGroupVOMeta.SORT_FIELD , InspectionGroupVOMeta.SORT_TYPE , InspectionGroupVOMeta.IDS } )
	@NotNull(name = InspectionGroupVOMeta.ID)
	@SentinelResource(value = InspectionGroupServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupServiceProxy.UPDATE)
	public Result update(InspectionGroupVO inspectionGroupVO) {
		Result result=inspectionGroupService.update(inspectionGroupVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存巡检班组
	*/
	@ApiOperation(value = "保存巡检班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571667599155269632"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "班组1"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupVOMeta.OPER_USER , value = "成员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "班组2"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionGroupVOMeta.PAGE_INDEX , InspectionGroupVOMeta.PAGE_SIZE , InspectionGroupVOMeta.SEARCH_FIELD , InspectionGroupVOMeta.FUZZY_FIELD , InspectionGroupVOMeta.SEARCH_VALUE , InspectionGroupVOMeta.DIRTY_FIELDS , InspectionGroupVOMeta.SORT_FIELD , InspectionGroupVOMeta.SORT_TYPE , InspectionGroupVOMeta.IDS } )
	@NotNull(name = InspectionGroupVOMeta.ID)
	@SentinelResource(value = InspectionGroupServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupServiceProxy.SAVE)
	public Result save(InspectionGroupVO inspectionGroupVO) {
		Result result=inspectionGroupService.save(inspectionGroupVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取巡检班组
	*/
	@ApiOperation(value = "获取巡检班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InspectionGroupVOMeta.ID)
	@SentinelResource(value = InspectionGroupServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupServiceProxy.GET_BY_ID)
	public Result<InspectionGroup> getById(String id) {
		Result<InspectionGroup> result=new Result<>();
		InspectionGroup inspectionGroup=inspectionGroupService.getById(id);
		// join 关联的对象
		inspectionGroupService.dao().fill(inspectionGroup)
			.with("leader")
			.execute();
		result.success(true).data(inspectionGroup);
		return result;
	}


	/**
	 * 批量获取巡检班组 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取巡检班组")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InspectionGroupVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InspectionGroupVOMeta.IDS)
		@SentinelResource(value = InspectionGroupServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupServiceProxy.GET_BY_IDS)
	public Result<List<InspectionGroup>> getByIds(List<String> ids) {
		Result<List<InspectionGroup>> result=new Result<>();
		List<InspectionGroup> list=inspectionGroupService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询巡检班组
	*/
	@ApiOperation(value = "查询巡检班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571667599155269632"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "班组1"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupVOMeta.OPER_USER , value = "成员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "班组2"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InspectionGroupVOMeta.PAGE_INDEX , InspectionGroupVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InspectionGroupServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupServiceProxy.QUERY_LIST)
	public Result<List<InspectionGroup>> queryList(InspectionGroupVO sample) {
		Result<List<InspectionGroup>> result=new Result<>();
		List<InspectionGroup> list=inspectionGroupService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询巡检班组
	*/
	@ApiOperation(value = "分页查询巡检班组")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InspectionGroupVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "571667599155269632"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "班组1"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InspectionGroupVOMeta.LEADER_ID , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupVOMeta.OPER_USER , value = "成员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InspectionGroupVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "班组2"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InspectionGroupServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InspectionGroupServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InspectionGroup>> queryPagedList(InspectionGroupVO sample) {
		Result<PagedList<InspectionGroup>> result=new Result<>();
		PagedList<InspectionGroup> list=inspectionGroupService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		inspectionGroupService.dao().fill(list)
			.with("leader")
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InspectionGroupServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionGroupServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InspectionGroupVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inspectionGroupService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InspectionGroupServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionGroupServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inspectionGroupService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InspectionGroupServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InspectionGroupServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inspectionGroupService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}