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


import com.dt.platform.proxy.eam.RepairUrgencyServiceProxy;
import com.dt.platform.domain.eam.meta.RepairUrgencyVOMeta;
import com.dt.platform.domain.eam.RepairUrgency;
import com.dt.platform.domain.eam.RepairUrgencyVO;
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
import com.dt.platform.domain.eam.meta.RepairUrgencyMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairUrgencyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 紧急程度 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 07:51:13
*/

@Api(tags = "紧急程度")
@ApiSort(0)
@RestController("EamRepairUrgencyController")
public class RepairUrgencyController extends SuperController {

	@Autowired
	private IRepairUrgencyService repairUrgencyService;


	/**
	 * 添加紧急程度
	*/
	@ApiOperation(value = "添加紧急程度")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairUrgencyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RepairUrgencyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairUrgencyServiceProxy.INSERT)
	public Result insert(RepairUrgencyVO repairUrgencyVO) {
		Result result=repairUrgencyService.insert(repairUrgencyVO,false);
		return result;
	}



	/**
	 * 删除紧急程度
	*/
	@ApiOperation(value = "删除紧急程度")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairUrgencyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RepairUrgencyVOMeta.ID)
	@SentinelResource(value = RepairUrgencyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairUrgencyServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=repairUrgencyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除紧急程度 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除紧急程度")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairUrgencyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RepairUrgencyVOMeta.IDS)
	@SentinelResource(value = RepairUrgencyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairUrgencyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=repairUrgencyService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新紧急程度
	*/
	@ApiOperation(value = "更新紧急程度")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairUrgencyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RepairUrgencyVOMeta.PAGE_INDEX , RepairUrgencyVOMeta.PAGE_SIZE , RepairUrgencyVOMeta.SEARCH_FIELD , RepairUrgencyVOMeta.FUZZY_FIELD , RepairUrgencyVOMeta.SEARCH_VALUE , RepairUrgencyVOMeta.DIRTY_FIELDS , RepairUrgencyVOMeta.SORT_FIELD , RepairUrgencyVOMeta.SORT_TYPE , RepairUrgencyVOMeta.IDS } )
	@NotNull(name = RepairUrgencyVOMeta.ID)
	@SentinelResource(value = RepairUrgencyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairUrgencyServiceProxy.UPDATE)
	public Result update(RepairUrgencyVO repairUrgencyVO) {
		Result result=repairUrgencyService.update(repairUrgencyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存紧急程度
	*/
	@ApiOperation(value = "保存紧急程度")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairUrgencyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairUrgencyVOMeta.PAGE_INDEX , RepairUrgencyVOMeta.PAGE_SIZE , RepairUrgencyVOMeta.SEARCH_FIELD , RepairUrgencyVOMeta.FUZZY_FIELD , RepairUrgencyVOMeta.SEARCH_VALUE , RepairUrgencyVOMeta.DIRTY_FIELDS , RepairUrgencyVOMeta.SORT_FIELD , RepairUrgencyVOMeta.SORT_TYPE , RepairUrgencyVOMeta.IDS } )
	@NotNull(name = RepairUrgencyVOMeta.ID)
	@SentinelResource(value = RepairUrgencyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairUrgencyServiceProxy.SAVE)
	public Result save(RepairUrgencyVO repairUrgencyVO) {
		Result result=repairUrgencyService.save(repairUrgencyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取紧急程度
	*/
	@ApiOperation(value = "获取紧急程度")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairUrgencyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RepairUrgencyVOMeta.ID)
	@SentinelResource(value = RepairUrgencyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairUrgencyServiceProxy.GET_BY_ID)
	public Result<RepairUrgency> getById(String id) {
		Result<RepairUrgency> result=new Result<>();
		RepairUrgency repairUrgency=repairUrgencyService.getById(id);
		result.success(true).data(repairUrgency);
		return result;
	}


	/**
	 * 批量获取紧急程度 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取紧急程度")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepairUrgencyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RepairUrgencyVOMeta.IDS)
		@SentinelResource(value = RepairUrgencyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairUrgencyServiceProxy.GET_BY_IDS)
	public Result<List<RepairUrgency>> getByIds(List<String> ids) {
		Result<List<RepairUrgency>> result=new Result<>();
		List<RepairUrgency> list=repairUrgencyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询紧急程度
	*/
	@ApiOperation(value = "查询紧急程度")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairUrgencyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairUrgencyVOMeta.PAGE_INDEX , RepairUrgencyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepairUrgencyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairUrgencyServiceProxy.QUERY_LIST)
	public Result<List<RepairUrgency>> queryList(RepairUrgencyVO sample) {
		Result<List<RepairUrgency>> result=new Result<>();
		List<RepairUrgency> list=repairUrgencyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询紧急程度
	*/
	@ApiOperation(value = "分页查询紧急程度")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairUrgencyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RepairUrgencyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RepairUrgencyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairUrgencyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepairUrgency>> queryPagedList(RepairUrgencyVO sample) {
		Result<PagedList<RepairUrgency>> result=new Result<>();
		PagedList<RepairUrgency> list=repairUrgencyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RepairUrgencyServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairUrgencyServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RepairUrgencyVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=repairUrgencyService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RepairUrgencyServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairUrgencyServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=repairUrgencyService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = RepairUrgencyServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairUrgencyServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=repairUrgencyService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}