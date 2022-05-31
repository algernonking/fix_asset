package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.CategoryFinance;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.lang.StringUtil;
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


import com.dt.platform.proxy.eam.RepairCategoryServiceProxy;
import com.dt.platform.domain.eam.meta.RepairCategoryVOMeta;
import com.dt.platform.domain.eam.RepairCategory;
import com.dt.platform.domain.eam.RepairCategoryVO;
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
import com.dt.platform.domain.eam.meta.RepairCategoryMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairCategoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 故障分类 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 14:35:56
*/

@Api(tags = "故障分类")
@ApiSort(0)
@RestController("EamRepairCategoryController")
public class RepairCategoryController extends SuperController {

	@Autowired
	private IRepairCategoryService repairCategoryService;


	/**
	 * 添加故障分类
	*/
	@ApiOperation(value = "添加故障分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.REPAIR_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.REPAIR_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RepairCategoryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryServiceProxy.INSERT)
	public Result insert(RepairCategoryVO repairCategoryVO) {
		repairCategoryVO.setSort(9999);
		repairCategoryVO.setRepairCode(IDGenerator.getSnowflakeIdString());
		repairCategoryVO.setRepairName("未设置");
		if(StringUtil.isBlank(repairCategoryVO.getParentId())) {
			repairCategoryVO.setParentId("0");
		}
		Result result=repairCategoryService.insert(repairCategoryVO);
		if(result.success()) {
			RepairCategory currentCategory=new RepairCategory();
			currentCategory.setId(repairCategoryVO.getId());
			if("0".equals(repairCategoryVO.getParentId())){
				currentCategory.setHierarchy(repairCategoryVO.getId());
				currentCategory.setHierarchyName(repairCategoryVO.getRepairName());
			}else{
				RepairCategory parentCategory=repairCategoryService.getById(repairCategoryVO.getParentId());
				currentCategory.setHierarchy(parentCategory.getHierarchy()+"/"+repairCategoryVO.getId());
				currentCategory.setHierarchyName(parentCategory.getHierarchyName()+"/"+repairCategoryVO.getRepairName());
			}
			repairCategoryService.update(currentCategory,SaveMode.NOT_NULL_FIELDS,false);
			repairCategoryVO.setHierarchy(currentCategory.getHierarchy());
			repairCategoryVO.setHierarchyName(currentCategory.getHierarchyName());
			result.data(repairCategoryVO);
		}
		return result;
	}



	/**
	 * 删除故障分类
	*/
	@ApiOperation(value = "删除故障分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RepairCategoryVOMeta.ID)
	@SentinelResource(value = RepairCategoryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result< RepairCategory> result=new Result<>();
		List<RepairCategory> list=repairCategoryService.queryList(RepairCategory.create().setParentId(id));
		if(list.size()>0){
			result.success(false).message("请先删除下级节点");
		}else{
			return  repairCategoryService.deleteByIdLogical(id);
		}
		return result;

	}


	/**
	 * 批量删除故障分类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除故障分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RepairCategoryVOMeta.IDS)
	@SentinelResource(value = RepairCategoryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=repairCategoryService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新故障分类
	*/
	@ApiOperation(value = "更新故障分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.REPAIR_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.REPAIR_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RepairCategoryVOMeta.PAGE_INDEX , RepairCategoryVOMeta.PAGE_SIZE , RepairCategoryVOMeta.SEARCH_FIELD , RepairCategoryVOMeta.FUZZY_FIELD , RepairCategoryVOMeta.SEARCH_VALUE , RepairCategoryVOMeta.DIRTY_FIELDS , RepairCategoryVOMeta.SORT_FIELD , RepairCategoryVOMeta.SORT_TYPE , RepairCategoryVOMeta.IDS } )
	@NotNull(name = RepairCategoryVOMeta.ID)
	@SentinelResource(value = RepairCategoryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryServiceProxy.UPDATE)
	public Result update(RepairCategoryVO repairCategoryVO) {
		Result result=repairCategoryService.update(repairCategoryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		if(result.isSuccess()){
			//更新分类名称
			return repairCategoryService.updateHierarchy(repairCategoryVO.getId());
		}
		return result;

	}


	/**
	 * 保存故障分类
	*/
	@ApiOperation(value = "保存故障分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.REPAIR_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.REPAIR_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairCategoryVOMeta.PAGE_INDEX , RepairCategoryVOMeta.PAGE_SIZE , RepairCategoryVOMeta.SEARCH_FIELD , RepairCategoryVOMeta.FUZZY_FIELD , RepairCategoryVOMeta.SEARCH_VALUE , RepairCategoryVOMeta.DIRTY_FIELDS , RepairCategoryVOMeta.SORT_FIELD , RepairCategoryVOMeta.SORT_TYPE , RepairCategoryVOMeta.IDS } )
	@NotNull(name = RepairCategoryVOMeta.ID)
	@SentinelResource(value = RepairCategoryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryServiceProxy.SAVE)
	public Result save(RepairCategoryVO repairCategoryVO) {
		Result result=repairCategoryService.update(repairCategoryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		if(result.isSuccess()){
			//更新分类名称
			return repairCategoryService.updateHierarchy(repairCategoryVO.getId());
		}
		return result;
	}


	/**
	 * 获取故障分类
	*/
	@ApiOperation(value = "获取故障分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RepairCategoryVOMeta.ID)
	@SentinelResource(value = RepairCategoryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryServiceProxy.GET_BY_ID)
	public Result<RepairCategory> getById(String id) {
		Result<RepairCategory> result=new Result<>();
		RepairCategory repairCategory=repairCategoryService.getById(id);
		result.success(true).data(repairCategory);
		return result;
	}


	/**
	 * 批量获取故障分类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取故障分类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepairCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RepairCategoryVOMeta.IDS)
		@SentinelResource(value = RepairCategoryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryServiceProxy.GET_BY_IDS)
	public Result<List<RepairCategory>> getByIds(List<String> ids) {
		Result<List<RepairCategory>> result=new Result<>();
		List<RepairCategory> list=repairCategoryService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询故障分类
	*/
	@ApiOperation(value = "查询故障分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.REPAIR_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.REPAIR_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairCategoryVOMeta.PAGE_INDEX , RepairCategoryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepairCategoryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryServiceProxy.QUERY_LIST)
	public Result<List<RepairCategory>> queryList(RepairCategoryVO sample) {
		Result<List<RepairCategory>> result=new Result<>();
		List<RepairCategory> list=repairCategoryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询故障分类
	*/
	@ApiOperation(value = "分页查询故障分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.REPAIR_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.REPAIR_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RepairCategoryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairCategoryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepairCategory>> queryPagedList(RepairCategoryVO sample) {
		Result<PagedList<RepairCategory>> result=new Result<>();
		PagedList<RepairCategory> list=repairCategoryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RepairCategoryServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairCategoryServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RepairCategoryVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=repairCategoryService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RepairCategoryServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairCategoryServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=repairCategoryService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = RepairCategoryServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairCategoryServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=repairCategoryService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}