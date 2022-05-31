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


import com.dt.platform.proxy.eam.RepairOrderAcceptanceServiceProxy;
import com.dt.platform.domain.eam.meta.RepairOrderAcceptanceVOMeta;
import com.dt.platform.domain.eam.RepairOrderAcceptance;
import com.dt.platform.domain.eam.RepairOrderAcceptanceVO;
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
import com.dt.platform.domain.eam.meta.RepairOrderAcceptanceMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.RepairOrder;
import com.dt.platform.domain.eam.RepairOrderAct;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.RepairCategoryTpl;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairOrderAcceptanceService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 维修验收 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-31 16:44:14
*/

@Api(tags = "维修验收")
@ApiSort(0)
@RestController("EamRepairOrderAcceptanceController")
public class RepairOrderAcceptanceController extends SuperController {

	@Autowired
	private IRepairOrderAcceptanceService repairOrderAcceptanceService;


	/**
	 * 添加维修验收
	*/
	@ApiOperation(value = "添加维修验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORDER_ID , value = "申请单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORDER_ACT_ID , value = "维修单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.RESULT_TYPE , value = "维修结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ACCEPTER_ID , value = "验收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.CATEGORY_TPL_ID , value = "实际故障" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ACTUAL_COST , value = "实际花费" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.FINISH_TIME , value = "完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.NOTES , value = "维修备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RepairOrderAcceptanceServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderAcceptanceServiceProxy.INSERT)
	public Result insert(RepairOrderAcceptanceVO repairOrderAcceptanceVO) {
		Result result=repairOrderAcceptanceService.insert(repairOrderAcceptanceVO,false);
		return result;
	}



	/**
	 * 删除维修验收
	*/
	@ApiOperation(value = "删除维修验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RepairOrderAcceptanceVOMeta.ID)
	@SentinelResource(value = RepairOrderAcceptanceServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderAcceptanceServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=repairOrderAcceptanceService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除维修验收 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除维修验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RepairOrderAcceptanceVOMeta.IDS)
	@SentinelResource(value = RepairOrderAcceptanceServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderAcceptanceServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=repairOrderAcceptanceService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新维修验收
	*/
	@ApiOperation(value = "更新维修验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORDER_ID , value = "申请单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORDER_ACT_ID , value = "维修单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.RESULT_TYPE , value = "维修结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ACCEPTER_ID , value = "验收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.CATEGORY_TPL_ID , value = "实际故障" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ACTUAL_COST , value = "实际花费" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.FINISH_TIME , value = "完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.NOTES , value = "维修备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RepairOrderAcceptanceVOMeta.PAGE_INDEX , RepairOrderAcceptanceVOMeta.PAGE_SIZE , RepairOrderAcceptanceVOMeta.SEARCH_FIELD , RepairOrderAcceptanceVOMeta.FUZZY_FIELD , RepairOrderAcceptanceVOMeta.SEARCH_VALUE , RepairOrderAcceptanceVOMeta.DIRTY_FIELDS , RepairOrderAcceptanceVOMeta.SORT_FIELD , RepairOrderAcceptanceVOMeta.SORT_TYPE , RepairOrderAcceptanceVOMeta.IDS } )
	@NotNull(name = RepairOrderAcceptanceVOMeta.ID)
	@SentinelResource(value = RepairOrderAcceptanceServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderAcceptanceServiceProxy.UPDATE)
	public Result update(RepairOrderAcceptanceVO repairOrderAcceptanceVO) {
		Result result=repairOrderAcceptanceService.update(repairOrderAcceptanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存维修验收
	*/
	@ApiOperation(value = "保存维修验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORDER_ID , value = "申请单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORDER_ACT_ID , value = "维修单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.RESULT_TYPE , value = "维修结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ACCEPTER_ID , value = "验收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.CATEGORY_TPL_ID , value = "实际故障" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ACTUAL_COST , value = "实际花费" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.FINISH_TIME , value = "完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.NOTES , value = "维修备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairOrderAcceptanceVOMeta.PAGE_INDEX , RepairOrderAcceptanceVOMeta.PAGE_SIZE , RepairOrderAcceptanceVOMeta.SEARCH_FIELD , RepairOrderAcceptanceVOMeta.FUZZY_FIELD , RepairOrderAcceptanceVOMeta.SEARCH_VALUE , RepairOrderAcceptanceVOMeta.DIRTY_FIELDS , RepairOrderAcceptanceVOMeta.SORT_FIELD , RepairOrderAcceptanceVOMeta.SORT_TYPE , RepairOrderAcceptanceVOMeta.IDS } )
	@NotNull(name = RepairOrderAcceptanceVOMeta.ID)
	@SentinelResource(value = RepairOrderAcceptanceServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderAcceptanceServiceProxy.SAVE)
	public Result save(RepairOrderAcceptanceVO repairOrderAcceptanceVO) {
		Result result=repairOrderAcceptanceService.save(repairOrderAcceptanceVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取维修验收
	*/
	@ApiOperation(value = "获取维修验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RepairOrderAcceptanceVOMeta.ID)
	@SentinelResource(value = RepairOrderAcceptanceServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderAcceptanceServiceProxy.GET_BY_ID)
	public Result<RepairOrderAcceptance> getById(String id) {
		Result<RepairOrderAcceptance> result=new Result<>();
		RepairOrderAcceptance repairOrderAcceptance=repairOrderAcceptanceService.getById(id);
		// join 关联的对象
		repairOrderAcceptanceService.dao().fill(repairOrderAcceptance)
			.with("originator")
			.with("accepter")
			.with(RepairOrderAcceptanceMeta.RESULT_TYPE_DICT)
			.with(RepairOrderAcceptanceMeta.CATEGORY_TPL)
			.execute();
		result.success(true).data(repairOrderAcceptance);
		return result;
	}


	/**
	 * 批量获取维修验收 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取维修验收")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RepairOrderAcceptanceVOMeta.IDS)
		@SentinelResource(value = RepairOrderAcceptanceServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderAcceptanceServiceProxy.GET_BY_IDS)
	public Result<List<RepairOrderAcceptance>> getByIds(List<String> ids) {
		Result<List<RepairOrderAcceptance>> result=new Result<>();
		List<RepairOrderAcceptance> list=repairOrderAcceptanceService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询维修验收
	*/
	@ApiOperation(value = "查询维修验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORDER_ID , value = "申请单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORDER_ACT_ID , value = "维修单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.RESULT_TYPE , value = "维修结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ACCEPTER_ID , value = "验收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.CATEGORY_TPL_ID , value = "实际故障" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ACTUAL_COST , value = "实际花费" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.FINISH_TIME , value = "完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.NOTES , value = "维修备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairOrderAcceptanceVOMeta.PAGE_INDEX , RepairOrderAcceptanceVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepairOrderAcceptanceServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderAcceptanceServiceProxy.QUERY_LIST)
	public Result<List<RepairOrderAcceptance>> queryList(RepairOrderAcceptanceVO sample) {
		Result<List<RepairOrderAcceptance>> result=new Result<>();
		List<RepairOrderAcceptance> list=repairOrderAcceptanceService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询维修验收
	*/
	@ApiOperation(value = "分页查询维修验收")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORDER_ID , value = "申请单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORDER_ACT_ID , value = "维修单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.RESULT_TYPE , value = "维修结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ACCEPTER_ID , value = "验收人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.CATEGORY_TPL_ID , value = "实际故障" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ACTUAL_COST , value = "实际花费" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.FINISH_TIME , value = "完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.NOTES , value = "维修备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderAcceptanceVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RepairOrderAcceptanceServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderAcceptanceServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepairOrderAcceptance>> queryPagedList(RepairOrderAcceptanceVO sample) {
		Result<PagedList<RepairOrderAcceptance>> result=new Result<>();
		PagedList<RepairOrderAcceptance> list=repairOrderAcceptanceService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		repairOrderAcceptanceService.dao().fill(list)
			.with("originator")
			.with("accepter")
			.with(RepairOrderAcceptanceMeta.RESULT_TYPE_DICT)
			.with(RepairOrderAcceptanceMeta.CATEGORY_TPL)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RepairOrderAcceptanceServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderAcceptanceServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RepairOrderAcceptanceVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=repairOrderAcceptanceService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RepairOrderAcceptanceServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderAcceptanceServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=repairOrderAcceptanceService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = RepairOrderAcceptanceServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderAcceptanceServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=repairOrderAcceptanceService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}