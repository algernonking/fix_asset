package com.dt.platform.contract.controller;

 
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


import com.dt.platform.proxy.contract.ContractCategoryServiceProxy;
import com.dt.platform.domain.contract.meta.ContractCategoryVOMeta;
import com.dt.platform.domain.contract.ContractCategory;
import com.dt.platform.domain.contract.ContractCategoryVO;
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
import com.dt.platform.domain.contract.meta.ContractCategoryMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.contract.service.IContractCategoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 合同分类 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 02:48:10
*/

@Api(tags = "合同分类")
@ApiSort(0)
@RestController("ContContractCategoryController")
public class ContractCategoryController extends SuperController {

	@Autowired
	private IContractCategoryService contractCategoryService;

	
	/**
	 * 添加合同分类
	*/
	@ApiOperation(value = "添加合同分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_FULLNAME , value = "具体名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = ContractCategoryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractCategoryServiceProxy.INSERT)
	public Result insert(ContractCategoryVO contractCategoryVO) {
		Result result=contractCategoryService.insert(contractCategoryVO);
		return result;
	}

	
	/**
	 * 删除合同分类
	*/
	@ApiOperation(value = "删除合同分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ContractCategoryVOMeta.ID)
	@SentinelResource(value = ContractCategoryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractCategoryServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=contractCategoryService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除合同分类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除合同分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ContractCategoryVOMeta.IDS)
	@SentinelResource(value = ContractCategoryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractCategoryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=contractCategoryService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新合同分类
	*/
	@ApiOperation(value = "更新合同分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_FULLNAME , value = "具体名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ContractCategoryVOMeta.PAGE_INDEX , ContractCategoryVOMeta.PAGE_SIZE , ContractCategoryVOMeta.SEARCH_FIELD , ContractCategoryVOMeta.FUZZY_FIELD , ContractCategoryVOMeta.SEARCH_VALUE , ContractCategoryVOMeta.SORT_FIELD , ContractCategoryVOMeta.SORT_TYPE , ContractCategoryVOMeta.IDS } ) 
	@NotNull(name = ContractCategoryVOMeta.ID)
	@SentinelResource(value = ContractCategoryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractCategoryServiceProxy.UPDATE)
	public Result update(ContractCategoryVO contractCategoryVO) {
		Result result=contractCategoryService.update(contractCategoryVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存合同分类
	*/
	@ApiOperation(value = "保存合同分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_FULLNAME , value = "具体名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractCategoryVOMeta.PAGE_INDEX , ContractCategoryVOMeta.PAGE_SIZE , ContractCategoryVOMeta.SEARCH_FIELD , ContractCategoryVOMeta.FUZZY_FIELD , ContractCategoryVOMeta.SEARCH_VALUE , ContractCategoryVOMeta.SORT_FIELD , ContractCategoryVOMeta.SORT_TYPE , ContractCategoryVOMeta.IDS } )
	@NotNull(name = ContractCategoryVOMeta.ID)
	@SentinelResource(value = ContractCategoryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractCategoryServiceProxy.SAVE)
	public Result save(ContractCategoryVO contractCategoryVO) {
		Result result=contractCategoryService.save(contractCategoryVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取合同分类
	*/
	@ApiOperation(value = "获取合同分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ContractCategoryVOMeta.ID)
	@SentinelResource(value = ContractCategoryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractCategoryServiceProxy.GET_BY_ID)
	public Result<ContractCategory> getById(String id) {
		Result<ContractCategory> result=new Result<>();
		ContractCategory contractCategory=contractCategoryService.getById(id);
		result.success(true).data(contractCategory);
		return result;
	}


	/**
	 * 批量获取合同分类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取合同分类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ContractCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ContractCategoryVOMeta.IDS)
		@SentinelResource(value = ContractCategoryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractCategoryServiceProxy.GET_BY_IDS)
	public Result<List<ContractCategory>> getByIds(List<String> ids) {
		Result<List<ContractCategory>> result=new Result<>();
		List<ContractCategory> list=contractCategoryService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询合同分类
	*/
	@ApiOperation(value = "查询合同分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_FULLNAME , value = "具体名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractCategoryVOMeta.PAGE_INDEX , ContractCategoryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ContractCategoryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractCategoryServiceProxy.QUERY_LIST)
	public Result<List<ContractCategory>> queryList(ContractCategoryVO sample) {
		Result<List<ContractCategory>> result=new Result<>();
		List<ContractCategory> list=contractCategoryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询合同分类
	*/
	@ApiOperation(value = "分页查询合同分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_FULLNAME , value = "具体名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ContractCategoryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractCategoryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ContractCategory>> queryPagedList(ContractCategoryVO sample) {
		Result<PagedList<ContractCategory>> result=new Result<>();
		PagedList<ContractCategory> list=contractCategoryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ContractCategoryServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractCategoryServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ContractCategoryVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=contractCategoryService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ContractCategoryServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractCategoryServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=contractCategoryService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = ContractCategoryServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractCategoryServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=contractCategoryService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}