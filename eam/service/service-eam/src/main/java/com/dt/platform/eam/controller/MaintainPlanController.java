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


import com.dt.platform.proxy.eam.MaintainPlanServiceProxy;
import com.dt.platform.domain.eam.meta.MaintainPlanVOMeta;
import com.dt.platform.domain.eam.MaintainPlan;
import com.dt.platform.domain.eam.MaintainPlanVO;
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
import com.dt.platform.domain.eam.meta.MaintainPlanMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.ActionCrontab;
import com.dt.platform.domain.eam.MaintainGroup;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IMaintainPlanService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 保养方案 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-05 09:51:44
*/

@Api(tags = "保养方案")
@ApiSort(0)
@RestController("EamMaintainPlanController")
public class MaintainPlanController extends SuperController {

	@Autowired
	private IMaintainPlanService maintainPlanService;


	/**
	 * 添加保养方案
	*/
	@ApiOperation(value = "添加保养方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585374391123054592"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "121"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.NAME , value = "方案名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.GROUP_ID , value = "执行班组" , required = false , dataTypeClass=String.class , example = "584133248423034880"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.CYCLE_METHOD , value = "循环方式" , required = false , dataTypeClass=String.class , example = "once"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.ACTION_CYCLE_ID , value = "保养周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.TOTAL_COST , value = "总工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.INFO , value = "方案说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = MaintainPlanServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.INSERT)
	public Result insert(MaintainPlanVO maintainPlanVO) {
		Result result=maintainPlanService.insert(maintainPlanVO,false);
		return result;
	}



	/**
	 * 删除保养方案
	*/
	@ApiOperation(value = "删除保养方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585374391123054592")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MaintainPlanVOMeta.ID)
	@SentinelResource(value = MaintainPlanServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=maintainPlanService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除保养方案 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除保养方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MaintainPlanVOMeta.IDS)
	@SentinelResource(value = MaintainPlanServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=maintainPlanService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新保养方案
	*/
	@ApiOperation(value = "更新保养方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585374391123054592"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "121"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.NAME , value = "方案名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.GROUP_ID , value = "执行班组" , required = false , dataTypeClass=String.class , example = "584133248423034880"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.CYCLE_METHOD , value = "循环方式" , required = false , dataTypeClass=String.class , example = "once"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.ACTION_CYCLE_ID , value = "保养周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.TOTAL_COST , value = "总工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.INFO , value = "方案说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MaintainPlanVOMeta.PAGE_INDEX , MaintainPlanVOMeta.PAGE_SIZE , MaintainPlanVOMeta.SEARCH_FIELD , MaintainPlanVOMeta.FUZZY_FIELD , MaintainPlanVOMeta.SEARCH_VALUE , MaintainPlanVOMeta.DIRTY_FIELDS , MaintainPlanVOMeta.SORT_FIELD , MaintainPlanVOMeta.SORT_TYPE , MaintainPlanVOMeta.IDS } )
	@NotNull(name = MaintainPlanVOMeta.ID)
	@SentinelResource(value = MaintainPlanServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.UPDATE)
	public Result update(MaintainPlanVO maintainPlanVO) {
		Result result=maintainPlanService.update(maintainPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存保养方案
	*/
	@ApiOperation(value = "保存保养方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585374391123054592"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "121"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.NAME , value = "方案名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.GROUP_ID , value = "执行班组" , required = false , dataTypeClass=String.class , example = "584133248423034880"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.CYCLE_METHOD , value = "循环方式" , required = false , dataTypeClass=String.class , example = "once"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.ACTION_CYCLE_ID , value = "保养周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.TOTAL_COST , value = "总工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.INFO , value = "方案说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainPlanVOMeta.PAGE_INDEX , MaintainPlanVOMeta.PAGE_SIZE , MaintainPlanVOMeta.SEARCH_FIELD , MaintainPlanVOMeta.FUZZY_FIELD , MaintainPlanVOMeta.SEARCH_VALUE , MaintainPlanVOMeta.DIRTY_FIELDS , MaintainPlanVOMeta.SORT_FIELD , MaintainPlanVOMeta.SORT_TYPE , MaintainPlanVOMeta.IDS } )
	@NotNull(name = MaintainPlanVOMeta.ID)
	@SentinelResource(value = MaintainPlanServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.SAVE)
	public Result save(MaintainPlanVO maintainPlanVO) {
		Result result=maintainPlanService.save(maintainPlanVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取保养方案
	*/
	@ApiOperation(value = "获取保养方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MaintainPlanVOMeta.ID)
	@SentinelResource(value = MaintainPlanServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.GET_BY_ID)
	public Result<MaintainPlan> getById(String id) {
		Result<MaintainPlan> result=new Result<>();
		MaintainPlan maintainPlan=maintainPlanService.getById(id);
		// join 关联的对象
		maintainPlanService.dao().fill(maintainPlan)
			.with("originator")
			.with(MaintainPlanMeta.MAINTAIN_TYPE_DICT)
			.with(MaintainPlanMeta.MAINTAIN_GROUP)
				.with(MaintainPlanMeta.ACTION_CRONTAB)
			.execute();
		result.success(true).data(maintainPlan);
		return result;
	}


	/**
	 * 批量获取保养方案 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取保养方案")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MaintainPlanVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MaintainPlanVOMeta.IDS)
		@SentinelResource(value = MaintainPlanServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.GET_BY_IDS)
	public Result<List<MaintainPlan>> getByIds(List<String> ids) {
		Result<List<MaintainPlan>> result=new Result<>();
		List<MaintainPlan> list=maintainPlanService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询保养方案
	*/
	@ApiOperation(value = "查询保养方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585374391123054592"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "121"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.NAME , value = "方案名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.GROUP_ID , value = "执行班组" , required = false , dataTypeClass=String.class , example = "584133248423034880"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.CYCLE_METHOD , value = "循环方式" , required = false , dataTypeClass=String.class , example = "once"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.ACTION_CYCLE_ID , value = "保养周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.TOTAL_COST , value = "总工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.INFO , value = "方案说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainPlanVOMeta.PAGE_INDEX , MaintainPlanVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaintainPlanServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.QUERY_LIST)
	public Result<List<MaintainPlan>> queryList(MaintainPlanVO sample) {
		Result<List<MaintainPlan>> result=new Result<>();
		List<MaintainPlan> list=maintainPlanService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询保养方案
	*/
	@ApiOperation(value = "分页查询保养方案")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "585374391123054592"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.CODE , value = "编号" , required = false , dataTypeClass=String.class , example = "121"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.NAME , value = "方案名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.GROUP_ID , value = "执行班组" , required = false , dataTypeClass=String.class , example = "584133248423034880"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.CYCLE_METHOD , value = "循环方式" , required = false , dataTypeClass=String.class , example = "once"),
		@ApiImplicitParam(name = MaintainPlanVOMeta.ACTION_CYCLE_ID , value = "保养周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.TOTAL_COST , value = "总工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.INFO , value = "方案说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainPlanVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MaintainPlanServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MaintainPlan>> queryPagedList(MaintainPlanVO sample) {
		Result<PagedList<MaintainPlan>> result=new Result<>();
		PagedList<MaintainPlan> list=maintainPlanService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		maintainPlanService.dao().fill(list)
			.with("originator")
			.with(MaintainPlanMeta.MAINTAIN_TYPE_DICT)
			.with(MaintainPlanMeta.MAINTAIN_GROUP)
			.execute();
		result.success(true).data(list);
		return result;
	}


	/**
	 *启动
	 */
	@ApiOperation(value = "启动")
	@ApiImplicitParams({
			@ApiImplicitParam(name = MaintainPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=9)
	@NotNull(name = MaintainPlanVOMeta.ID)
	@SentinelResource(value = MaintainPlanServiceProxy.START , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.START)
	public Result start(String id) {
		return maintainPlanService.start(id);
	}


	/**
	 *停止
	 */
	@ApiOperation(value = "停止")
	@ApiImplicitParams({
			@ApiImplicitParam(name = MaintainPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=10)
	@NotNull(name = MaintainPlanVOMeta.ID)
	@SentinelResource(value = MaintainPlanServiceProxy.STOP , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.STOP)
	public Result stop(String id) {
		return maintainPlanService.stop(id);
	}

	/**
	 *执行
	 */
	@ApiOperation(value = "执行")
	@ApiImplicitParams({
			@ApiImplicitParam(name = MaintainPlanVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=11)
	@NotNull(name = MaintainPlanVOMeta.ID)
	@SentinelResource(value = MaintainPlanServiceProxy.EXECUTE, blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainPlanServiceProxy.EXECUTE)
	public Result execute(String id) {
		return maintainPlanService.execute(id);
	}




	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MaintainPlanServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainPlanServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MaintainPlanVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=maintainPlanService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MaintainPlanServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainPlanServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=maintainPlanService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = MaintainPlanServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainPlanServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=maintainPlanService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}