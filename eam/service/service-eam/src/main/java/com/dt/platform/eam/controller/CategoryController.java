package com.dt.platform.eam.controller;

 
import java.util.List;

import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.RoleMenu;
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


import com.dt.platform.proxy.eam.CategoryServiceProxy;
import com.dt.platform.domain.eam.meta.CategoryVOMeta;
import com.dt.platform.domain.eam.Category;
import com.dt.platform.domain.eam.CategoryVO;
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
import com.dt.platform.domain.eam.meta.CategoryMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICategoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产分类 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-31 12:16:02
*/

@Api(tags = "资产分类")
@ApiSort(0)
@RestController("EamCategoryController")
public class CategoryController extends SuperController {

	@Autowired
	private ICategoryService categoryService;

	
	/**
	 * 添加资产分类
	*/
	@ApiOperation(value = "添加资产分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.PARENT_ID , value = "父节点" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.SORT , value = "sort" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CategoryVOMeta.HIERARCHY , value = "节点路径" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NOTES , value = "备注" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = CategoryVOMeta.ID)
	@NotNull(name = CategoryVOMeta.PARENT_ID)
	@NotNull(name = CategoryVOMeta.HIERARCHY)
	@NotNull(name = CategoryVOMeta.HIERARCHY_NAME)
	@NotNull(name = CategoryVOMeta.NOTES)
	@SentinelResource(value = CategoryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryServiceProxy.INSERT)
	public Result insert(CategoryVO categoryVO) {
		categoryVO.setSort(9999);
		if(StringUtil.isBlank(categoryVO.getParentId())) {
			categoryVO.setParentId("0");
		}
		Result result=categoryService.insert(categoryVO);
		if(result.success()) {
			Category currentCategory=new Category();
			currentCategory.setId(categoryVO.getId());
			if("0".equals(categoryVO.getParentId())){
				currentCategory.setHierarchy(categoryVO.getId());
				currentCategory.setHierarchyName(categoryVO.getCategoryName());
			}else{
				Category parentCategory=categoryService.getById(categoryVO.getParentId());
				currentCategory.setHierarchy(parentCategory.getHierarchy()+"/"+categoryVO.getId());
				currentCategory.setHierarchyName(parentCategory.getHierarchyName()+"/"+categoryVO.getCategoryName());
			}
			categoryService.update(currentCategory,SaveMode.NOT_NULL_FIELDS);
			categoryVO.setHierarchy(currentCategory.getHierarchy());
			categoryVO.setHierarchyName(currentCategory.getHierarchyName());
			result.data(categoryVO);
		}
		return result;
	}

	
	/**
	 * 删除资产分类
	*/
	@ApiOperation(value = "删除资产分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = CategoryVOMeta.ID)
	@SentinelResource(value = CategoryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result< Category> result=new Result<>();
		List<Category> list=categoryService.queryList(Category.create().setParentId(id));
		if(list.size()>0){
			result.success(false).message("请先删除下级节点");
		}else{
			return categoryService.deleteByIdLogical(id);
		}
		return result;
	}
	/**
	 * 批量删除资产分类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = CategoryVOMeta.IDS)
	@SentinelResource(value = CategoryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=categoryService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产分类
	*/
	@ApiOperation(value = "更新资产分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.PARENT_ID , value = "父节点" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.SORT , value = "sort" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CategoryVOMeta.HIERARCHY , value = "节点路径" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NOTES , value = "备注" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { CategoryVOMeta.PAGE_INDEX , CategoryVOMeta.PAGE_SIZE , CategoryVOMeta.SEARCH_FIELD , CategoryVOMeta.FUZZY_FIELD , CategoryVOMeta.SEARCH_VALUE , CategoryVOMeta.SORT_FIELD , CategoryVOMeta.SORT_TYPE , CategoryVOMeta.IDS } ) 
	@NotNull(name = CategoryVOMeta.ID)
	@NotNull(name = CategoryVOMeta.PARENT_ID)
	@NotNull(name = CategoryVOMeta.HIERARCHY)
	@NotNull(name = CategoryVOMeta.HIERARCHY_NAME)
	@NotNull(name = CategoryVOMeta.NOTES)
	@SentinelResource(value = CategoryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryServiceProxy.UPDATE)
	public Result update(CategoryVO categoryVO) {

		Result result=categoryService.update(categoryVO,SaveMode.NOT_NULL_FIELDS);
		if(result.isSuccess()){
			//更新分类名称
			return categoryService.updateHierarchy(categoryVO.getId());
		}
		return result;
	}
	
	
	/**
	 * 保存资产分类
	*/
	@ApiOperation(value = "保存资产分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.PARENT_ID , value = "父节点" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.SORT , value = "sort" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CategoryVOMeta.HIERARCHY , value = "节点路径" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NOTES , value = "备注" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CategoryVOMeta.PAGE_INDEX , CategoryVOMeta.PAGE_SIZE , CategoryVOMeta.SEARCH_FIELD , CategoryVOMeta.FUZZY_FIELD , CategoryVOMeta.SEARCH_VALUE , CategoryVOMeta.SORT_FIELD , CategoryVOMeta.SORT_TYPE , CategoryVOMeta.IDS } )
	@NotNull(name = CategoryVOMeta.ID)
	@NotNull(name = CategoryVOMeta.PARENT_ID)
	@NotNull(name = CategoryVOMeta.HIERARCHY)
	@NotNull(name = CategoryVOMeta.HIERARCHY_NAME)
	@NotNull(name = CategoryVOMeta.NOTES)
	@SentinelResource(value = CategoryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryServiceProxy.SAVE)
	public Result save(CategoryVO categoryVO) {
		Result result=categoryService.save(categoryVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产分类
	*/
	@ApiOperation(value = "获取资产分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = CategoryVOMeta.ID)
	@SentinelResource(value = CategoryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryServiceProxy.GET_BY_ID)
	public Result<Category> getById(String id) {
		Result<Category> result=new Result<>();
		Category category=categoryService.getById(id);
		result.success(true).data(category);
		return result;
	}


	/**
	 * 批量删除资产分类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产分类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = CategoryVOMeta.IDS)
		@SentinelResource(value = CategoryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryServiceProxy.GET_BY_IDS)
	public Result<List<Category>> getByIds(List<String> ids) {
		Result<List<Category>> result=new Result<>();
		List<Category> list=categoryService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产分类
	*/
	@ApiOperation(value = "查询资产分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.PARENT_ID , value = "父节点" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.SORT , value = "sort" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CategoryVOMeta.HIERARCHY , value = "节点路径" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NOTES , value = "备注" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CategoryVOMeta.PAGE_INDEX , CategoryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CategoryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryServiceProxy.QUERY_LIST)
	public Result<List<Category>> queryList(CategoryVO sample) {
		Result<List<Category>> result=new Result<>();
		List<Category> list=categoryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产分类
	*/
	@ApiOperation(value = "分页查询资产分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_FULLNAME , value = "全称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.PARENT_ID , value = "父节点" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.SORT , value = "sort" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CategoryVOMeta.HIERARCHY , value = "节点路径" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NOTES , value = "备注" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = CategoryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CategoryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Category>> queryPagedList(CategoryVO sample) {
		Result<PagedList<Category>> result=new Result<>();
		PagedList<Category> list=categoryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = CategoryServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CategoryServiceProxy.EXPORT_EXCEL)
	public void exportExcel(CategoryVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=categoryService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = CategoryServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CategoryServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=categoryService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = CategoryServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(CategoryServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=categoryService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}