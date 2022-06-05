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


import com.dt.platform.proxy.eam.RepairRuleItemServiceProxy;
import com.dt.platform.domain.eam.meta.RepairRuleItemVOMeta;
import com.dt.platform.domain.eam.RepairRuleItem;
import com.dt.platform.domain.eam.RepairRuleItemVO;
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
import com.dt.platform.domain.eam.meta.RepairRuleItemMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairRuleItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 规则单 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 07:24:13
*/

@Api(tags = "规则单")
@ApiSort(0)
@RestController("EamRepairRuleItemController")
public class RepairRuleItemController extends SuperController {

	@Autowired
	private IRepairRuleItemService repairRuleItemService;


	/**
	 * 添加规则单
	*/
	@ApiOperation(value = "添加规则单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleItemVOMeta.RULE_ID , value = "转发规则" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleItemVOMeta.CATEGORY_TPL_ID , value = "故障内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RepairRuleItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleItemServiceProxy.INSERT)
	public Result insert(RepairRuleItemVO repairRuleItemVO) {
		Result result=repairRuleItemService.insert(repairRuleItemVO,false);
		return result;
	}



	/**
	 * 删除规则单
	*/
	@ApiOperation(value = "删除规则单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RepairRuleItemVOMeta.ID)
	@SentinelResource(value = RepairRuleItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=repairRuleItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除规则单 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除规则单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RepairRuleItemVOMeta.IDS)
	@SentinelResource(value = RepairRuleItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=repairRuleItemService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新规则单
	*/
	@ApiOperation(value = "更新规则单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleItemVOMeta.RULE_ID , value = "转发规则" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleItemVOMeta.CATEGORY_TPL_ID , value = "故障内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RepairRuleItemVOMeta.PAGE_INDEX , RepairRuleItemVOMeta.PAGE_SIZE , RepairRuleItemVOMeta.SEARCH_FIELD , RepairRuleItemVOMeta.FUZZY_FIELD , RepairRuleItemVOMeta.SEARCH_VALUE , RepairRuleItemVOMeta.DIRTY_FIELDS , RepairRuleItemVOMeta.SORT_FIELD , RepairRuleItemVOMeta.SORT_TYPE , RepairRuleItemVOMeta.IDS } )
	@NotNull(name = RepairRuleItemVOMeta.ID)
	@SentinelResource(value = RepairRuleItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleItemServiceProxy.UPDATE)
	public Result update(RepairRuleItemVO repairRuleItemVO) {
		Result result=repairRuleItemService.update(repairRuleItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存规则单
	*/
	@ApiOperation(value = "保存规则单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleItemVOMeta.RULE_ID , value = "转发规则" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleItemVOMeta.CATEGORY_TPL_ID , value = "故障内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairRuleItemVOMeta.PAGE_INDEX , RepairRuleItemVOMeta.PAGE_SIZE , RepairRuleItemVOMeta.SEARCH_FIELD , RepairRuleItemVOMeta.FUZZY_FIELD , RepairRuleItemVOMeta.SEARCH_VALUE , RepairRuleItemVOMeta.DIRTY_FIELDS , RepairRuleItemVOMeta.SORT_FIELD , RepairRuleItemVOMeta.SORT_TYPE , RepairRuleItemVOMeta.IDS } )
	@NotNull(name = RepairRuleItemVOMeta.ID)
	@SentinelResource(value = RepairRuleItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleItemServiceProxy.SAVE)
	public Result save(RepairRuleItemVO repairRuleItemVO) {
		Result result=repairRuleItemService.save(repairRuleItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取规则单
	*/
	@ApiOperation(value = "获取规则单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RepairRuleItemVOMeta.ID)
	@SentinelResource(value = RepairRuleItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleItemServiceProxy.GET_BY_ID)
	public Result<RepairRuleItem> getById(String id) {
		Result<RepairRuleItem> result=new Result<>();
		RepairRuleItem repairRuleItem=repairRuleItemService.getById(id);
		result.success(true).data(repairRuleItem);
		return result;
	}


	/**
	 * 批量获取规则单 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取规则单")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepairRuleItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RepairRuleItemVOMeta.IDS)
		@SentinelResource(value = RepairRuleItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleItemServiceProxy.GET_BY_IDS)
	public Result<List<RepairRuleItem>> getByIds(List<String> ids) {
		Result<List<RepairRuleItem>> result=new Result<>();
		List<RepairRuleItem> list=repairRuleItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询规则单
	*/
	@ApiOperation(value = "查询规则单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleItemVOMeta.RULE_ID , value = "转发规则" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleItemVOMeta.CATEGORY_TPL_ID , value = "故障内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairRuleItemVOMeta.PAGE_INDEX , RepairRuleItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepairRuleItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleItemServiceProxy.QUERY_LIST)
	public Result<List<RepairRuleItem>> queryList(RepairRuleItemVO sample) {
		Result<List<RepairRuleItem>> result=new Result<>();
		List<RepairRuleItem> list=repairRuleItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询规则单
	*/
	@ApiOperation(value = "分页查询规则单")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleItemVOMeta.RULE_ID , value = "转发规则" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleItemVOMeta.CATEGORY_TPL_ID , value = "故障内容" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RepairRuleItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepairRuleItem>> queryPagedList(RepairRuleItemVO sample) {
		Result<PagedList<RepairRuleItem>> result=new Result<>();
		PagedList<RepairRuleItem> list=repairRuleItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RepairRuleItemServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairRuleItemServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RepairRuleItemVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=repairRuleItemService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RepairRuleItemServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairRuleItemServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=repairRuleItemService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = RepairRuleItemServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairRuleItemServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=repairRuleItemService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}