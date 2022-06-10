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


import com.dt.platform.proxy.eam.MaintainProjectServiceProxy;
import com.dt.platform.domain.eam.meta.MaintainProjectVOMeta;
import com.dt.platform.domain.eam.MaintainProject;
import com.dt.platform.domain.eam.MaintainProjectVO;
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
import com.dt.platform.domain.eam.meta.MaintainProjectMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.ActionCrontab;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IMaintainProjectService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 保养项目 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-03 21:20:24
*/

@Api(tags = "保养项目")
@ApiSort(0)
@RestController("MaintainProjectController")
public class MaintainProjectController extends SuperController {

	@Autowired
	private IMaintainProjectService maintainProjectService;


	/**
	 * 添加保养项目
	*/
	@ApiOperation(value = "添加保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585209383214907392"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.CODE , value = "项目编号" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.ACTION_CYCLE_ID , value = "保养周期" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MaintainProjectServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.INSERT)
	public Result insert(MaintainProjectVO maintainProjectVO) {
		Result result=maintainProjectService.insert(maintainProjectVO,false);
		return result;
	}



	/**
	 * 删除保养项目
	*/
	@ApiOperation(value = "删除保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585209383214907392")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MaintainProjectVOMeta.ID)
	@SentinelResource(value = MaintainProjectServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=maintainProjectService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除保养项目 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MaintainProjectVOMeta.IDS)
	@SentinelResource(value = MaintainProjectServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=maintainProjectService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新保养项目
	*/
	@ApiOperation(value = "更新保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585209383214907392"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.CODE , value = "项目编号" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.ACTION_CYCLE_ID , value = "保养周期" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MaintainProjectVOMeta.PAGE_INDEX , MaintainProjectVOMeta.PAGE_SIZE , MaintainProjectVOMeta.SEARCH_FIELD , MaintainProjectVOMeta.FUZZY_FIELD , MaintainProjectVOMeta.SEARCH_VALUE , MaintainProjectVOMeta.DIRTY_FIELDS , MaintainProjectVOMeta.SORT_FIELD , MaintainProjectVOMeta.SORT_TYPE , MaintainProjectVOMeta.IDS } )
	@NotNull(name = MaintainProjectVOMeta.ID)
	@SentinelResource(value = MaintainProjectServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.UPDATE)
	public Result update(MaintainProjectVO maintainProjectVO) {
		Result result=maintainProjectService.update(maintainProjectVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存保养项目
	*/
	@ApiOperation(value = "保存保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585209383214907392"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.CODE , value = "项目编号" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.ACTION_CYCLE_ID , value = "保养周期" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainProjectVOMeta.PAGE_INDEX , MaintainProjectVOMeta.PAGE_SIZE , MaintainProjectVOMeta.SEARCH_FIELD , MaintainProjectVOMeta.FUZZY_FIELD , MaintainProjectVOMeta.SEARCH_VALUE , MaintainProjectVOMeta.DIRTY_FIELDS , MaintainProjectVOMeta.SORT_FIELD , MaintainProjectVOMeta.SORT_TYPE , MaintainProjectVOMeta.IDS } )
	@NotNull(name = MaintainProjectVOMeta.ID)
	@SentinelResource(value = MaintainProjectServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.SAVE)
	public Result save(MaintainProjectVO maintainProjectVO) {
		Result result=maintainProjectService.save(maintainProjectVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取保养项目
	*/
	@ApiOperation(value = "获取保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MaintainProjectVOMeta.ID)
	@SentinelResource(value = MaintainProjectServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.GET_BY_ID)
	public Result<MaintainProject> getById(String id) {
		Result<MaintainProject> result=new Result<>();
		MaintainProject maintainProject=maintainProjectService.getById(id);
		// join 关联的对象
		maintainProjectService.dao().fill(maintainProject)
			.with(MaintainProjectMeta.MAINTAIN_TYPE_DICT)
				.with(MaintainProjectMeta.ACTION_CRONTAB)
			.execute();
		result.success(true).data(maintainProject);
		return result;
	}


	/**
	 * 批量获取保养项目 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取保养项目")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MaintainProjectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MaintainProjectVOMeta.IDS)
		@SentinelResource(value = MaintainProjectServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.GET_BY_IDS)
	public Result<List<MaintainProject>> getByIds(List<String> ids) {
		Result<List<MaintainProject>> result=new Result<>();
		List<MaintainProject> list=maintainProjectService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询保养项目
	*/
	@ApiOperation(value = "查询保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585209383214907392"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.CODE , value = "项目编号" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.ACTION_CYCLE_ID , value = "保养周期" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainProjectVOMeta.PAGE_INDEX , MaintainProjectVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaintainProjectServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.QUERY_LIST)
	public Result<List<MaintainProject>> queryList(MaintainProjectVO sample) {
		Result<List<MaintainProject>> result=new Result<>();
		List<MaintainProject> list=maintainProjectService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询保养项目
	*/
	@ApiOperation(value = "分页查询保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585209383214907392"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.CODE , value = "项目编号" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.BASE_COST , value = "标准工时(小时)" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.ACTION_CYCLE_ID , value = "保养周期" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = MaintainProjectVOMeta.ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MaintainProjectServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MaintainProject>> queryPagedList(MaintainProjectVO sample) {
		Result<PagedList<MaintainProject>> result=new Result<>();
		PagedList<MaintainProject> list=maintainProjectService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		maintainProjectService.dao().fill(list)
			.with(MaintainProjectMeta.MAINTAIN_TYPE_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}

	/**
	 * 分页查询保养项目
	 */
	@ApiOperation(value = "分页查询保养项目")
	@ApiImplicitParams({
	})
	@ApiOperationSupport(order=10)
	@SentinelResource(value = MaintainProjectServiceProxy.QUERY_PAGED_LIST_BY_SELECT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.QUERY_PAGED_LIST_BY_SELECT)
	public Result<PagedList<MaintainProject>> queryPagedList(MaintainProjectVO sample,String ownerId,String ownerType) {
		Result<PagedList<MaintainProject>> result=new Result<>();
		PagedList<MaintainProject> list=maintainProjectService.queryPagedListBySelect(sample,ownerId,ownerType);
		// join 关联的对象
		maintainProjectService.dao().fill(list)
				.with(MaintainProjectMeta.MAINTAIN_TYPE_DICT)
				.execute();
		result.success(true).data(list);
		return result;
	}

	/**
	 * 分页查询保养项目
	 */
	@ApiOperation(value = "分页查询保养项目")
	@ApiImplicitParams({
	})
	@ApiOperationSupport(order=11)
	@SentinelResource(value = MaintainProjectServiceProxy.QUERY_PAGED_LIST_BY_SELECTED , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.QUERY_PAGED_LIST_BY_SELECTED)
	public Result<PagedList<MaintainProject>> queryPagedListBySelected(MaintainProjectVO sample,String ownerId,String ownerType) {
		Result<PagedList<MaintainProject>> result=new Result<>();
		PagedList<MaintainProject> list=maintainProjectService.queryPagedListBySelected(sample,ownerId,ownerType);
		// join 关联的对象
		maintainProjectService.dao().fill(list)
				.with(MaintainProjectMeta.MAINTAIN_TYPE_DICT)
				.execute();
		result.success(true).data(list);
		return result;
	}

	/**
	 * 分页查询保养项目
	 */
	@ApiOperation(value = "分页查询保养项目")
	@ApiImplicitParams({
	})
	@ApiOperationSupport(order=12)
	@SentinelResource(value = MaintainProjectServiceProxy.SELECTED , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainProjectServiceProxy.SELECTED)
	public Result se(List<String> ids,String ownerId,String selectedCode) {
		return maintainProjectService.selected(ids,ownerId,selectedCode);
	}


	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MaintainProjectServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainProjectServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MaintainProjectVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=maintainProjectService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MaintainProjectServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainProjectServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=maintainProjectService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MaintainProjectServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainProjectServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=maintainProjectService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}