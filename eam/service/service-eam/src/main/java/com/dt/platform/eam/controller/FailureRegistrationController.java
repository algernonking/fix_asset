package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.AssetRepair;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.hrm.Person;
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


import com.dt.platform.proxy.eam.FailureRegistrationServiceProxy;
import com.dt.platform.domain.eam.meta.FailureRegistrationVOMeta;
import com.dt.platform.domain.eam.FailureRegistration;
import com.dt.platform.domain.eam.FailureRegistrationVO;
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
import com.dt.platform.domain.eam.meta.FailureRegistrationMeta;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IFailureRegistrationService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 故障登记 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-28 16:13:08
*/

@Api(tags = "故障登记")
@ApiSort(0)
@RestController("EamFailureRegistrationController")
public class FailureRegistrationController extends SuperController {

	@Autowired
	private IFailureRegistrationService failureRegistrationService;


	/**
	 * 添加故障登记
	*/
	@ApiOperation(value = "添加故障登记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.TYPE , value = "故障类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.CONTENT , value = "故障说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = FailureRegistrationServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FailureRegistrationServiceProxy.INSERT)
	public Result insert(FailureRegistrationVO failureRegistrationVO) {
		Result result=failureRegistrationService.insert(failureRegistrationVO,false);
		return result;
	}



	/**
	 * 删除故障登记
	*/
	@ApiOperation(value = "删除故障登记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = FailureRegistrationVOMeta.ID)
	@SentinelResource(value = FailureRegistrationServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FailureRegistrationServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=failureRegistrationService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除故障登记 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除故障登记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FailureRegistrationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = FailureRegistrationVOMeta.IDS)
	@SentinelResource(value = FailureRegistrationServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FailureRegistrationServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=failureRegistrationService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新故障登记
	*/
	@ApiOperation(value = "更新故障登记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.TYPE , value = "故障类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.CONTENT , value = "故障说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { FailureRegistrationVOMeta.PAGE_INDEX , FailureRegistrationVOMeta.PAGE_SIZE , FailureRegistrationVOMeta.SEARCH_FIELD , FailureRegistrationVOMeta.FUZZY_FIELD , FailureRegistrationVOMeta.SEARCH_VALUE , FailureRegistrationVOMeta.DIRTY_FIELDS , FailureRegistrationVOMeta.SORT_FIELD , FailureRegistrationVOMeta.SORT_TYPE , FailureRegistrationVOMeta.IDS } )
	@NotNull(name = FailureRegistrationVOMeta.ID)
	@SentinelResource(value = FailureRegistrationServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FailureRegistrationServiceProxy.UPDATE)
	public Result update(FailureRegistrationVO failureRegistrationVO) {
		Result result=failureRegistrationService.update(failureRegistrationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存故障登记
	*/
	@ApiOperation(value = "保存故障登记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.TYPE , value = "故障类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.CONTENT , value = "故障说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { FailureRegistrationVOMeta.PAGE_INDEX , FailureRegistrationVOMeta.PAGE_SIZE , FailureRegistrationVOMeta.SEARCH_FIELD , FailureRegistrationVOMeta.FUZZY_FIELD , FailureRegistrationVOMeta.SEARCH_VALUE , FailureRegistrationVOMeta.DIRTY_FIELDS , FailureRegistrationVOMeta.SORT_FIELD , FailureRegistrationVOMeta.SORT_TYPE , FailureRegistrationVOMeta.IDS } )
	@NotNull(name = FailureRegistrationVOMeta.ID)
	@SentinelResource(value = FailureRegistrationServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FailureRegistrationServiceProxy.SAVE)
	public Result save(FailureRegistrationVO failureRegistrationVO) {
		Result result=failureRegistrationService.save(failureRegistrationVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取故障登记
	*/
	@ApiOperation(value = "获取故障登记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = FailureRegistrationVOMeta.ID)
	@SentinelResource(value = FailureRegistrationServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FailureRegistrationServiceProxy.GET_BY_ID)
	public Result<FailureRegistration> getById(String id) {
		Result<FailureRegistration> result=new Result<>();
		FailureRegistration failureRegistration=failureRegistrationService.getById(id);
		// join 关联的对象
		failureRegistrationService.dao().fill(failureRegistration)
			.with("originator")
			.with(FailureRegistrationMeta.TYPE_DICT)
			.execute();
		result.success(true).data(failureRegistration);
		return result;
	}


	/**
	 * 批量获取故障登记 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取故障登记")
		@ApiImplicitParams({
				@ApiImplicitParam(name = FailureRegistrationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = FailureRegistrationVOMeta.IDS)
		@SentinelResource(value = FailureRegistrationServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FailureRegistrationServiceProxy.GET_BY_IDS)
	public Result<List<FailureRegistration>> getByIds(List<String> ids) {
		Result<List<FailureRegistration>> result=new Result<>();
		List<FailureRegistration> list=failureRegistrationService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询故障登记
	*/
	@ApiOperation(value = "查询故障登记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.TYPE , value = "故障类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.CONTENT , value = "故障说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { FailureRegistrationVOMeta.PAGE_INDEX , FailureRegistrationVOMeta.PAGE_SIZE } )
	@SentinelResource(value = FailureRegistrationServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FailureRegistrationServiceProxy.QUERY_LIST)
	public Result<List<FailureRegistration>> queryList(FailureRegistrationVO sample) {
		Result<List<FailureRegistration>> result=new Result<>();
		List<FailureRegistration> list=failureRegistrationService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询故障登记
	*/
	@ApiOperation(value = "分页查询故障登记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.TYPE , value = "故障类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.CONTENT , value = "故障说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = FailureRegistrationVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = FailureRegistrationServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FailureRegistrationServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<FailureRegistration>> queryPagedList(FailureRegistrationVO sample) {
		Result<PagedList<FailureRegistration>> result=new Result<>();
		PagedList<FailureRegistration> list=failureRegistrationService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		failureRegistrationService.dao().fill(list)
			.with("originator")
			.with(FailureRegistrationMeta.TYPE_DICT)
			.execute();
		result.success(true).data(list);


		List<Employee> employees= CollectorUtil.collectList(list, FailureRegistration::getOriginator);
		failureRegistrationService.dao().join(employees, Person.class);
		return result;
	}


	/**
	 * 确认
	 */
	@ApiOperation(value = "确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = FailureRegistrationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = FailureRegistrationVOMeta.ID)
	@SentinelResource(value = FailureRegistrationServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(FailureRegistrationServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id) {
		return failureRegistrationService.confirmOperation(id);
	}


	/**
	 * 确认
	 * */
	@SentinelResource(value = FailureRegistrationServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(FailureRegistrationServiceProxy.CONFIRM_OPERATION)
	public void exportExcel(FailureRegistrationVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=failureRegistrationService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = FailureRegistrationServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(FailureRegistrationServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=failureRegistrationService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = FailureRegistrationServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(FailureRegistrationServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=failureRegistrationService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}