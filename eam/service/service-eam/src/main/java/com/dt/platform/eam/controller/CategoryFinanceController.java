package com.dt.platform.eam.controller;

 
import java.util.List;

import com.dt.platform.domain.eam.Category;
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


import com.dt.platform.proxy.eam.CategoryFinanceServiceProxy;
import com.dt.platform.domain.eam.meta.CategoryFinanceVOMeta;
import com.dt.platform.domain.eam.CategoryFinance;
import com.dt.platform.domain.eam.CategoryFinanceVO;
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
import com.dt.platform.domain.eam.meta.CategoryFinanceMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICategoryFinanceService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 财务分类 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-10 13:01:35
*/

@Api(tags = "财务分类")
@ApiSort(0)
@RestController("EamCategoryFinanceController")
public class CategoryFinanceController extends SuperController {

	@Autowired
	private ICategoryFinanceService categoryFinanceService;

	
	/**
	 * 添加财务分类
	*/
	@ApiOperation(value = "添加财务分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryFinanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.TENANT_ID , value = "租户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = CategoryFinanceVOMeta.ID)
	@SentinelResource(value = CategoryFinanceServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryFinanceServiceProxy.INSERT)
	public Result insert(CategoryFinanceVO categoryFinanceVO) {

		categoryFinanceVO.setSort(9999);
		if(StringUtil.isBlank(categoryFinanceVO.getParentId())) {
			categoryFinanceVO.setParentId("0");
		}
		Result result=categoryFinanceService.insert(categoryFinanceVO);
		if(result.success()) {
			CategoryFinance currentCategory=new CategoryFinance();
			currentCategory.setId(categoryFinanceVO.getId());
			if("0".equals(categoryFinanceVO.getParentId())){
				currentCategory.setHierarchy(categoryFinanceVO.getId());
				currentCategory.setHierarchyName(categoryFinanceVO.getCategoryName());
			}else{
				CategoryFinance parentCategory=categoryFinanceService.getById(categoryFinanceVO.getParentId());
				currentCategory.setHierarchy(parentCategory.getHierarchy()+"/"+categoryFinanceVO.getId());
				currentCategory.setHierarchyName(parentCategory.getHierarchyName()+"/"+categoryFinanceVO.getCategoryName());
			}
			categoryFinanceService.update(currentCategory,SaveMode.NOT_NULL_FIELDS);
			categoryFinanceVO.setHierarchy(currentCategory.getHierarchy());
			categoryFinanceVO.setHierarchyName(currentCategory.getHierarchyName());
			result.data(categoryFinanceVO);
		}

		return result;
	}

	
	/**
	 * 删除财务分类
	*/
	@ApiOperation(value = "删除财务分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryFinanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CategoryFinanceVOMeta.ID)
	@SentinelResource(value = CategoryFinanceServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryFinanceServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result< CategoryFinance> result=new Result<>();
		List<CategoryFinance> list=categoryFinanceService.queryList(CategoryFinance.create().setParentId(id));
		if(list.size()>0){
			result.success(false).message("请先删除下级节点");
		}else{
			return categoryFinanceService.deleteByIdLogical(id);
		}
		return result;

	}
	
	
	/**
	 * 批量删除财务分类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除财务分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryFinanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CategoryFinanceVOMeta.IDS)
	@SentinelResource(value = CategoryFinanceServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryFinanceServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=categoryFinanceService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新财务分类
	*/
	@ApiOperation(value = "更新财务分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryFinanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.TENANT_ID , value = "租户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CategoryFinanceVOMeta.PAGE_INDEX , CategoryFinanceVOMeta.PAGE_SIZE , CategoryFinanceVOMeta.SEARCH_FIELD , CategoryFinanceVOMeta.FUZZY_FIELD , CategoryFinanceVOMeta.SEARCH_VALUE , CategoryFinanceVOMeta.SORT_FIELD , CategoryFinanceVOMeta.SORT_TYPE , CategoryFinanceVOMeta.IDS } ) 
	@NotNull(name = CategoryFinanceVOMeta.ID)
	@SentinelResource(value = CategoryFinanceServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryFinanceServiceProxy.UPDATE)
	public Result update(CategoryFinanceVO categoryFinanceVO) {
		Result result=categoryFinanceService.update(categoryFinanceVO,SaveMode.NOT_NULL_FIELDS);
		if(result.isSuccess()){
			//更新分类名称
			return categoryFinanceService.updateHierarchy(categoryFinanceVO.getId());
		}
		return result;
	}
	
	
	/**
	 * 保存财务分类
	*/
	@ApiOperation(value = "保存财务分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryFinanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.TENANT_ID , value = "租户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CategoryFinanceVOMeta.PAGE_INDEX , CategoryFinanceVOMeta.PAGE_SIZE , CategoryFinanceVOMeta.SEARCH_FIELD , CategoryFinanceVOMeta.FUZZY_FIELD , CategoryFinanceVOMeta.SEARCH_VALUE , CategoryFinanceVOMeta.SORT_FIELD , CategoryFinanceVOMeta.SORT_TYPE , CategoryFinanceVOMeta.IDS } )
	@NotNull(name = CategoryFinanceVOMeta.ID)
	@SentinelResource(value = CategoryFinanceServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryFinanceServiceProxy.SAVE)
	public Result save(CategoryFinanceVO categoryFinanceVO) {
		Result result=categoryFinanceService.update(categoryFinanceVO,SaveMode.NOT_NULL_FIELDS);
		if(result.isSuccess()){
			//更新分类名称
			return categoryFinanceService.updateHierarchy(categoryFinanceVO.getId());
		}
		return result;


	}

	
	/**
	 * 获取财务分类
	*/
	@ApiOperation(value = "获取财务分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryFinanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CategoryFinanceVOMeta.ID)
	@SentinelResource(value = CategoryFinanceServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryFinanceServiceProxy.GET_BY_ID)
	public Result<CategoryFinance> getById(String id) {
		Result<CategoryFinance> result=new Result<>();
		CategoryFinance categoryFinance=categoryFinanceService.getById(id);
		result.success(true).data(categoryFinance);
		return result;
	}


	/**
	 * 批量删除财务分类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除财务分类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CategoryFinanceVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CategoryFinanceVOMeta.IDS)
		@SentinelResource(value = CategoryFinanceServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryFinanceServiceProxy.GET_BY_IDS)
	public Result<List<CategoryFinance>> getByIds(List<String> ids) {
		Result<List<CategoryFinance>> result=new Result<>();
		List<CategoryFinance> list=categoryFinanceService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询财务分类
	*/
	@ApiOperation(value = "查询财务分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryFinanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.TENANT_ID , value = "租户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CategoryFinanceVOMeta.PAGE_INDEX , CategoryFinanceVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CategoryFinanceServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryFinanceServiceProxy.QUERY_LIST)
	public Result<List<CategoryFinance>> queryList(CategoryFinanceVO sample) {
		Result<List<CategoryFinance>> result=new Result<>();
		List<CategoryFinance> list=categoryFinanceService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询财务分类
	*/
	@ApiOperation(value = "分页查询财务分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryFinanceVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryFinanceVOMeta.TENANT_ID , value = "租户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CategoryFinanceServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryFinanceServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CategoryFinance>> queryPagedList(CategoryFinanceVO sample) {
		Result<PagedList<CategoryFinance>> result=new Result<>();
		PagedList<CategoryFinance> list=categoryFinanceService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CategoryFinanceServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CategoryFinanceServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CategoryFinanceVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=categoryFinanceService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CategoryFinanceServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CategoryFinanceServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=categoryFinanceService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = CategoryFinanceServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CategoryFinanceServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=categoryFinanceService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}