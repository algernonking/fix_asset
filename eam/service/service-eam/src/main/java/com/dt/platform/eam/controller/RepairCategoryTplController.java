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


import com.dt.platform.proxy.eam.RepairCategoryTplServiceProxy;
import com.dt.platform.domain.eam.meta.RepairCategoryTplVOMeta;
import com.dt.platform.domain.eam.RepairCategoryTpl;
import com.dt.platform.domain.eam.RepairCategoryTplVO;
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
import com.dt.platform.domain.eam.meta.RepairCategoryTplMeta;
import com.dt.platform.domain.eam.RepairCategory;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairCategoryTplService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 故障模版 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 17:42:23
*/

@Api(tags = "故障模版")
@ApiSort(0)
@RestController("EamRepairCategoryTplController")
public class RepairCategoryTplController extends SuperController {

	@Autowired
	private IRepairCategoryTplService repairCategoryTplService;


	/**
	 * 添加故障模版
	*/
	@ApiOperation(value = "添加故障模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583710499342909440"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.CATEGORY_ID , value = "故障类型" , required = false , dataTypeClass=String.class , example = "583677634362212353"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.CODE , value = "故障编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.NAME , value = "故障内容" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.REPAIR_SOLUTION , value = "故障方案" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.COST_TIME , value = "标准耗时" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RepairCategoryTplServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryTplServiceProxy.INSERT)
	public Result insert(RepairCategoryTplVO repairCategoryTplVO) {
		Result result=repairCategoryTplService.insert(repairCategoryTplVO,false);
		return result;
	}



	/**
	 * 删除故障模版
	*/
	@ApiOperation(value = "删除故障模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583710499342909440")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RepairCategoryTplVOMeta.ID)
	@SentinelResource(value = RepairCategoryTplServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryTplServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=repairCategoryTplService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除故障模版 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除故障模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RepairCategoryTplVOMeta.IDS)
	@SentinelResource(value = RepairCategoryTplServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryTplServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=repairCategoryTplService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新故障模版
	*/
	@ApiOperation(value = "更新故障模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583710499342909440"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.CATEGORY_ID , value = "故障类型" , required = false , dataTypeClass=String.class , example = "583677634362212353"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.CODE , value = "故障编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.NAME , value = "故障内容" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.REPAIR_SOLUTION , value = "故障方案" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.COST_TIME , value = "标准耗时" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RepairCategoryTplVOMeta.PAGE_INDEX , RepairCategoryTplVOMeta.PAGE_SIZE , RepairCategoryTplVOMeta.SEARCH_FIELD , RepairCategoryTplVOMeta.FUZZY_FIELD , RepairCategoryTplVOMeta.SEARCH_VALUE , RepairCategoryTplVOMeta.DIRTY_FIELDS , RepairCategoryTplVOMeta.SORT_FIELD , RepairCategoryTplVOMeta.SORT_TYPE , RepairCategoryTplVOMeta.IDS } )
	@NotNull(name = RepairCategoryTplVOMeta.ID)
	@SentinelResource(value = RepairCategoryTplServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryTplServiceProxy.UPDATE)
	public Result update(RepairCategoryTplVO repairCategoryTplVO) {
		Result result=repairCategoryTplService.update(repairCategoryTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存故障模版
	*/
	@ApiOperation(value = "保存故障模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583710499342909440"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.CATEGORY_ID , value = "故障类型" , required = false , dataTypeClass=String.class , example = "583677634362212353"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.CODE , value = "故障编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.NAME , value = "故障内容" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.REPAIR_SOLUTION , value = "故障方案" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.COST_TIME , value = "标准耗时" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairCategoryTplVOMeta.PAGE_INDEX , RepairCategoryTplVOMeta.PAGE_SIZE , RepairCategoryTplVOMeta.SEARCH_FIELD , RepairCategoryTplVOMeta.FUZZY_FIELD , RepairCategoryTplVOMeta.SEARCH_VALUE , RepairCategoryTplVOMeta.DIRTY_FIELDS , RepairCategoryTplVOMeta.SORT_FIELD , RepairCategoryTplVOMeta.SORT_TYPE , RepairCategoryTplVOMeta.IDS } )
	@NotNull(name = RepairCategoryTplVOMeta.ID)
	@SentinelResource(value = RepairCategoryTplServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryTplServiceProxy.SAVE)
	public Result save(RepairCategoryTplVO repairCategoryTplVO) {
		Result result=repairCategoryTplService.save(repairCategoryTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取故障模版
	*/
	@ApiOperation(value = "获取故障模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RepairCategoryTplVOMeta.ID)
	@SentinelResource(value = RepairCategoryTplServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryTplServiceProxy.GET_BY_ID)
	public Result<RepairCategoryTpl> getById(String id) {
		Result<RepairCategoryTpl> result=new Result<>();
		RepairCategoryTpl repairCategoryTpl=repairCategoryTplService.getById(id);
		// join 关联的对象
		repairCategoryTplService.dao().fill(repairCategoryTpl)
			.with(RepairCategoryTplMeta.CATEGORY)
			.execute();
		result.success(true).data(repairCategoryTpl);
		return result;
	}


	/**
	 * 批量获取故障模版 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取故障模版")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepairCategoryTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RepairCategoryTplVOMeta.IDS)
		@SentinelResource(value = RepairCategoryTplServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryTplServiceProxy.GET_BY_IDS)
	public Result<List<RepairCategoryTpl>> getByIds(List<String> ids) {
		Result<List<RepairCategoryTpl>> result=new Result<>();
		List<RepairCategoryTpl> list=repairCategoryTplService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询故障模版
	*/
	@ApiOperation(value = "查询故障模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583710499342909440"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.CATEGORY_ID , value = "故障类型" , required = false , dataTypeClass=String.class , example = "583677634362212353"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.CODE , value = "故障编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.NAME , value = "故障内容" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.REPAIR_SOLUTION , value = "故障方案" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.COST_TIME , value = "标准耗时" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairCategoryTplVOMeta.PAGE_INDEX , RepairCategoryTplVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepairCategoryTplServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryTplServiceProxy.QUERY_LIST)
	public Result<List<RepairCategoryTpl>> queryList(RepairCategoryTplVO sample) {
		Result<List<RepairCategoryTpl>> result=new Result<>();
		List<RepairCategoryTpl> list=repairCategoryTplService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询故障模版
	*/
	@ApiOperation(value = "分页查询故障模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "583710499342909440"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.CATEGORY_ID , value = "故障类型" , required = false , dataTypeClass=String.class , example = "583677634362212353"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.CODE , value = "故障编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.NAME , value = "故障内容" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.REPAIR_SOLUTION , value = "故障方案" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.COST_TIME , value = "标准耗时" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.ATTACH_ID , value = "附件" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RepairCategoryTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RepairCategoryTplServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryTplServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepairCategoryTpl>> queryPagedList(RepairCategoryTplVO sample) {
		Result<PagedList<RepairCategoryTpl>> result=new Result<>();
		PagedList<RepairCategoryTpl> list=repairCategoryTplService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		repairCategoryTplService.dao().fill(list)
			.with(RepairCategoryTplMeta.CATEGORY)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RepairCategoryTplServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairCategoryTplServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RepairCategoryTplVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=repairCategoryTplService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RepairCategoryTplServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairCategoryTplServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=repairCategoryTplService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = RepairCategoryTplServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairCategoryTplServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=repairCategoryTplService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}