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


import com.dt.platform.proxy.eam.InventoryPlanServiceProxy;
import com.dt.platform.domain.eam.meta.InventoryPlanVOMeta;
import com.dt.platform.domain.eam.InventoryPlan;
import com.dt.platform.domain.eam.InventoryPlanVO;
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
import com.dt.platform.domain.eam.meta.InventoryPlanMeta;
import com.dt.platform.domain.eam.Inventory;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInventoryPlanService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 盘点计划 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-03 10:30:37
*/

@Api(tags = "盘点计划")
@ApiSort(0)
@RestController("EamInventoryPlanController")
public class InventoryPlanController extends SuperController {

	@Autowired
	private IInventoryPlanService inventoryPlanService;


	/**
	 * 添加盘点计划
	*/
	@ApiOperation(value = "添加盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "529341603614035968"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "normal"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InventoryPlanServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.INSERT)
	public Result insert(InventoryPlanVO inventoryPlanVO) {
		Result result=inventoryPlanService.insert(inventoryPlanVO,false);
		return result;
	}



	/**
	 * 删除盘点计划
	*/
	@ApiOperation(value = "删除盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "529341603614035968")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InventoryPlanVOMeta.ID)
	@SentinelResource(value = InventoryPlanServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inventoryPlanService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除盘点计划 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InventoryPlanVOMeta.IDS)
	@SentinelResource(value = InventoryPlanServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inventoryPlanService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新盘点计划
	*/
	@ApiOperation(value = "更新盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "529341603614035968"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "normal"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InventoryPlanVOMeta.PAGE_INDEX , InventoryPlanVOMeta.PAGE_SIZE , InventoryPlanVOMeta.SEARCH_FIELD , InventoryPlanVOMeta.FUZZY_FIELD , InventoryPlanVOMeta.SEARCH_VALUE , InventoryPlanVOMeta.DIRTY_FIELDS , InventoryPlanVOMeta.SORT_FIELD , InventoryPlanVOMeta.SORT_TYPE , InventoryPlanVOMeta.IDS } )
	@NotNull(name = InventoryPlanVOMeta.ID)
	@SentinelResource(value = InventoryPlanServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.UPDATE)
	public Result update(InventoryPlanVO inventoryPlanVO) {
		Result result=inventoryPlanService.update(inventoryPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存盘点计划
	*/
	@ApiOperation(value = "保存盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "529341603614035968"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "normal"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryPlanVOMeta.PAGE_INDEX , InventoryPlanVOMeta.PAGE_SIZE , InventoryPlanVOMeta.SEARCH_FIELD , InventoryPlanVOMeta.FUZZY_FIELD , InventoryPlanVOMeta.SEARCH_VALUE , InventoryPlanVOMeta.DIRTY_FIELDS , InventoryPlanVOMeta.SORT_FIELD , InventoryPlanVOMeta.SORT_TYPE , InventoryPlanVOMeta.IDS } )
	@NotNull(name = InventoryPlanVOMeta.ID)
	@SentinelResource(value = InventoryPlanServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.SAVE)
	public Result save(InventoryPlanVO inventoryPlanVO) {
		Result result=inventoryPlanService.save(inventoryPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取盘点计划
	*/
	@ApiOperation(value = "获取盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InventoryPlanVOMeta.ID)
	@SentinelResource(value = InventoryPlanServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.GET_BY_ID)
	public Result<InventoryPlan> getById(String id) {
		Result<InventoryPlan> result=new Result<>();
		InventoryPlan inventoryPlan=inventoryPlanService.getById(id);
		// join 关联的对象
		inventoryPlanService.dao().fill(inventoryPlan)
			.with(InventoryPlanMeta.INVENTORY_PLAN_TYPE)
			.with(InventoryPlanMeta.INVENTORY)
			.execute();
		result.success(true).data(inventoryPlan);
		return result;
	}


	/**
	 * 批量获取盘点计划 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取盘点计划")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InventoryPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InventoryPlanVOMeta.IDS)
		@SentinelResource(value = InventoryPlanServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.GET_BY_IDS)
	public Result<List<InventoryPlan>> getByIds(List<String> ids) {
		Result<List<InventoryPlan>> result=new Result<>();
		List<InventoryPlan> list=inventoryPlanService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询盘点计划
	*/
	@ApiOperation(value = "查询盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "529341603614035968"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "normal"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryPlanVOMeta.PAGE_INDEX , InventoryPlanVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InventoryPlanServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.QUERY_LIST)
	public Result<List<InventoryPlan>> queryList(InventoryPlanVO sample) {
		Result<List<InventoryPlan>> result=new Result<>();
		List<InventoryPlan> list=inventoryPlanService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询盘点计划
	*/
	@ApiOperation(value = "分页查询盘点计划")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "529341603614035968"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NAME , value = "计划名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.PLAN_TYPE , value = "计划类型" , required = false , dataTypeClass=String.class , example = "normal"),
		@ApiImplicitParam(name = InventoryPlanVOMeta.TPL_ID , value = "模板" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InventoryPlanServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InventoryPlan>> queryPagedList(InventoryPlanVO sample) {
		Result<PagedList<InventoryPlan>> result=new Result<>();
		PagedList<InventoryPlan> list=inventoryPlanService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		inventoryPlanService.dao().fill(list)
			.with(InventoryPlanMeta.INVENTORY_PLAN_TYPE)
				.with(InventoryPlanMeta.INVENTORY)
			.execute();
		result.success(true).data(list);
		return result;
	}


	/**
	 * 获取盘点计划
	 */
	@ApiOperation(value = "应用模板")
	@ApiImplicitParams({
			@ApiImplicitParam(name = InventoryPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=9)
	@NotNull(name = InventoryPlanVOMeta.ID)
	@SentinelResource(value = InventoryPlanServiceProxy.APPLY_TPL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryPlanServiceProxy.APPLY_TPL)
	public Result applyTpl(String id) {
		return inventoryPlanService.applyTpl(id);
	}


	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InventoryPlanServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryPlanServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InventoryPlanVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inventoryPlanService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InventoryPlanServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryPlanServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inventoryPlanService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InventoryPlanServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryPlanServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inventoryPlanService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}