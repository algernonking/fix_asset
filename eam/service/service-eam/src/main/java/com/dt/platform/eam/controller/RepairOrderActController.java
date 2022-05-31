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


import com.dt.platform.proxy.eam.RepairOrderActServiceProxy;
import com.dt.platform.domain.eam.meta.RepairOrderActVOMeta;
import com.dt.platform.domain.eam.RepairOrderAct;
import com.dt.platform.domain.eam.RepairOrderActVO;
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
import com.dt.platform.domain.eam.meta.RepairOrderActMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.RepairOrder;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.RepairGroup;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairOrderActService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 维修工单 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-31 14:52:53
*/

@Api(tags = "维修工单")
@ApiSort(0)
@RestController("EamRepairOrderActController")
public class RepairOrderActController extends SuperController {

	@Autowired
	private IRepairOrderActService repairOrderActService;


	/**
	 * 添加维修工单
	*/
	@ApiOperation(value = "添加维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584022872884772864"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.ORDER_ID , value = "申请单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.GROUP_ID , value = "维修班组" , required = false , dataTypeClass=String.class , example = "583634707950862336"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.EXECUTOR_ID , value = "执行人" , required = false , dataTypeClass=String.class , example = "576130520052662272"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.REPAIR_COST , value = "维修费用" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.FINISH_TIME , value = "完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.NOTES , value = "维修备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RepairOrderActServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderActServiceProxy.INSERT)
	public Result insert(RepairOrderActVO repairOrderActVO) {
		Result result=repairOrderActService.insert(repairOrderActVO,false);
		return result;
	}



	/**
	 * 删除维修工单
	*/
	@ApiOperation(value = "删除维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584022872884772864")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RepairOrderActVOMeta.ID)
	@SentinelResource(value = RepairOrderActServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderActServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=repairOrderActService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除维修工单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RepairOrderActVOMeta.IDS)
	@SentinelResource(value = RepairOrderActServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderActServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=repairOrderActService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新维修工单
	*/
	@ApiOperation(value = "更新维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584022872884772864"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.ORDER_ID , value = "申请单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.GROUP_ID , value = "维修班组" , required = false , dataTypeClass=String.class , example = "583634707950862336"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.EXECUTOR_ID , value = "执行人" , required = false , dataTypeClass=String.class , example = "576130520052662272"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.REPAIR_COST , value = "维修费用" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.FINISH_TIME , value = "完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.NOTES , value = "维修备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RepairOrderActVOMeta.PAGE_INDEX , RepairOrderActVOMeta.PAGE_SIZE , RepairOrderActVOMeta.SEARCH_FIELD , RepairOrderActVOMeta.FUZZY_FIELD , RepairOrderActVOMeta.SEARCH_VALUE , RepairOrderActVOMeta.DIRTY_FIELDS , RepairOrderActVOMeta.SORT_FIELD , RepairOrderActVOMeta.SORT_TYPE , RepairOrderActVOMeta.IDS } )
	@NotNull(name = RepairOrderActVOMeta.ID)
	@SentinelResource(value = RepairOrderActServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderActServiceProxy.UPDATE)
	public Result update(RepairOrderActVO repairOrderActVO) {
		Result result=repairOrderActService.update(repairOrderActVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存维修工单
	*/
	@ApiOperation(value = "保存维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584022872884772864"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.ORDER_ID , value = "申请单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.GROUP_ID , value = "维修班组" , required = false , dataTypeClass=String.class , example = "583634707950862336"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.EXECUTOR_ID , value = "执行人" , required = false , dataTypeClass=String.class , example = "576130520052662272"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.REPAIR_COST , value = "维修费用" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.FINISH_TIME , value = "完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.NOTES , value = "维修备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairOrderActVOMeta.PAGE_INDEX , RepairOrderActVOMeta.PAGE_SIZE , RepairOrderActVOMeta.SEARCH_FIELD , RepairOrderActVOMeta.FUZZY_FIELD , RepairOrderActVOMeta.SEARCH_VALUE , RepairOrderActVOMeta.DIRTY_FIELDS , RepairOrderActVOMeta.SORT_FIELD , RepairOrderActVOMeta.SORT_TYPE , RepairOrderActVOMeta.IDS } )
	@NotNull(name = RepairOrderActVOMeta.ID)
	@SentinelResource(value = RepairOrderActServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderActServiceProxy.SAVE)
	public Result save(RepairOrderActVO repairOrderActVO) {
		Result result=repairOrderActService.save(repairOrderActVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取维修工单
	*/
	@ApiOperation(value = "获取维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RepairOrderActVOMeta.ID)
	@SentinelResource(value = RepairOrderActServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderActServiceProxy.GET_BY_ID)
	public Result<RepairOrderAct> getById(String id) {
		Result<RepairOrderAct> result=new Result<>();
		RepairOrderAct repairOrderAct=repairOrderActService.getById(id);
		// join 关联的对象
		repairOrderActService.dao().fill(repairOrderAct)
			.with(RepairOrderActMeta.REPAIR_GROUP)
			.with(RepairOrderActMeta.EXECUTOR)
			.execute();
		result.success(true).data(repairOrderAct);
		return result;
	}


	/**
	 * 批量获取维修工单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取维修工单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepairOrderActVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RepairOrderActVOMeta.IDS)
		@SentinelResource(value = RepairOrderActServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderActServiceProxy.GET_BY_IDS)
	public Result<List<RepairOrderAct>> getByIds(List<String> ids) {
		Result<List<RepairOrderAct>> result=new Result<>();
		List<RepairOrderAct> list=repairOrderActService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询维修工单
	*/
	@ApiOperation(value = "查询维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584022872884772864"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.ORDER_ID , value = "申请单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.GROUP_ID , value = "维修班组" , required = false , dataTypeClass=String.class , example = "583634707950862336"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.EXECUTOR_ID , value = "执行人" , required = false , dataTypeClass=String.class , example = "576130520052662272"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.REPAIR_COST , value = "维修费用" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.FINISH_TIME , value = "完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.NOTES , value = "维修备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairOrderActVOMeta.PAGE_INDEX , RepairOrderActVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepairOrderActServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderActServiceProxy.QUERY_LIST)
	public Result<List<RepairOrderAct>> queryList(RepairOrderActVO sample) {
		Result<List<RepairOrderAct>> result=new Result<>();
		List<RepairOrderAct> list=repairOrderActService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询维修工单
	*/
	@ApiOperation(value = "分页查询维修工单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairOrderActVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584022872884772864"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.ORDER_ID , value = "申请单" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.REPAIR_STATUS , value = "维修状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.GROUP_ID , value = "维修班组" , required = false , dataTypeClass=String.class , example = "583634707950862336"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.EXECUTOR_ID , value = "执行人" , required = false , dataTypeClass=String.class , example = "576130520052662272"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.REPAIR_COST , value = "维修费用" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = RepairOrderActVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.FINISH_TIME , value = "完成时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.NOTES , value = "维修备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.PICTURE_ID , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairOrderActVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RepairOrderActServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairOrderActServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepairOrderAct>> queryPagedList(RepairOrderActVO sample) {
		Result<PagedList<RepairOrderAct>> result=new Result<>();
		PagedList<RepairOrderAct> list=repairOrderActService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		repairOrderActService.dao().fill(list)
			.with(RepairOrderActMeta.REPAIR_GROUP)
			.with(RepairOrderActMeta.EXECUTOR)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RepairOrderActServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderActServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RepairOrderActVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=repairOrderActService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RepairOrderActServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderActServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=repairOrderActService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = RepairOrderActServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairOrderActServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=repairOrderActService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}