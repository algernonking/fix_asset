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


import com.dt.platform.proxy.eam.AssetCollectionServiceProxy;
import com.dt.platform.domain.eam.meta.AssetCollectionVOMeta;
import com.dt.platform.domain.eam.AssetCollection;
import com.dt.platform.domain.eam.AssetCollectionVO;
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
import com.dt.platform.domain.eam.meta.AssetCollectionMeta;
import com.dt.platform.domain.eam.Position;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetCollectionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产领用 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-18 11:57:45
*/

@Api(tags = "资产领用")
@ApiSort(0)
@RestController("EamAssetCollectionController")
public class AssetCollectionController extends SuperController {

	@Autowired
	private IAssetCollectionService assetCollectionService;

	
	/**
	 * 添加资产领用
	*/
	@ApiOperation(value = "添加资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ACTUAL_COLLECTION_DATE , value = "实际领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USER_ORGANIZATION_ID , value = "领用后使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetCollectionVOMeta.ID)
	@NotNull(name = AssetCollectionVOMeta.NAME)
	@SentinelResource(value = AssetCollectionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.INSERT)
	public Result insert(AssetCollectionVO assetCollectionVO) {
		Result result=assetCollectionService.insert(assetCollectionVO);
		return result;
	}

	
	/**
	 * 删除资产领用
	*/
	@ApiOperation(value = "删除资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetCollectionVOMeta.ID)
	@SentinelResource(value = AssetCollectionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetCollectionService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产领用 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetCollectionVOMeta.IDS)
	@SentinelResource(value = AssetCollectionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetCollectionService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产领用
	*/
	@ApiOperation(value = "更新资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ACTUAL_COLLECTION_DATE , value = "实际领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USER_ORGANIZATION_ID , value = "领用后使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetCollectionVOMeta.PAGE_INDEX , AssetCollectionVOMeta.PAGE_SIZE , AssetCollectionVOMeta.SEARCH_FIELD , AssetCollectionVOMeta.FUZZY_FIELD , AssetCollectionVOMeta.SEARCH_VALUE , AssetCollectionVOMeta.SORT_FIELD , AssetCollectionVOMeta.SORT_TYPE , AssetCollectionVOMeta.IDS } ) 
	@NotNull(name = AssetCollectionVOMeta.ID)
	@NotNull(name = AssetCollectionVOMeta.NAME)
	@SentinelResource(value = AssetCollectionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.UPDATE)
	public Result update(AssetCollectionVO assetCollectionVO) {
		Result result=assetCollectionService.update(assetCollectionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产领用
	*/
	@ApiOperation(value = "保存资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ACTUAL_COLLECTION_DATE , value = "实际领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USER_ORGANIZATION_ID , value = "领用后使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetCollectionVOMeta.PAGE_INDEX , AssetCollectionVOMeta.PAGE_SIZE , AssetCollectionVOMeta.SEARCH_FIELD , AssetCollectionVOMeta.FUZZY_FIELD , AssetCollectionVOMeta.SEARCH_VALUE , AssetCollectionVOMeta.SORT_FIELD , AssetCollectionVOMeta.SORT_TYPE , AssetCollectionVOMeta.IDS } )
	@NotNull(name = AssetCollectionVOMeta.ID)
	@NotNull(name = AssetCollectionVOMeta.NAME)
	@SentinelResource(value = AssetCollectionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.SAVE)
	public Result save(AssetCollectionVO assetCollectionVO) {
		Result result=assetCollectionService.save(assetCollectionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产领用
	*/
	@ApiOperation(value = "获取资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetCollectionVOMeta.ID)
	@SentinelResource(value = AssetCollectionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.GET_BY_ID)
	public Result<AssetCollection> getById(String id) {
		Result<AssetCollection> result=new Result<>();
		AssetCollection assetCollection=assetCollectionService.getById(id);
		// 关联出 存放位置 数据
		assetCollectionService.join(assetCollection,AssetCollectionMeta.POSITION);
		result.success(true).data(assetCollection);
		return result;
	}


	/**
	 * 批量删除资产领用 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产领用")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetCollectionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetCollectionVOMeta.IDS)
		@SentinelResource(value = AssetCollectionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.GET_BY_IDS)
	public Result<List<AssetCollection>> getByIds(List<String> ids) {
		Result<List<AssetCollection>> result=new Result<>();
		List<AssetCollection> list=assetCollectionService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产领用
	*/
	@ApiOperation(value = "查询资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ACTUAL_COLLECTION_DATE , value = "实际领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USER_ORGANIZATION_ID , value = "领用后使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetCollectionVOMeta.PAGE_INDEX , AssetCollectionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetCollectionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.QUERY_LIST)
	public Result<List<AssetCollection>> queryList(AssetCollectionVO sample) {
		Result<List<AssetCollection>> result=new Result<>();
		List<AssetCollection> list=assetCollectionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产领用
	*/
	@ApiOperation(value = "分页查询资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.ACTUAL_COLLECTION_DATE , value = "实际领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USER_ORGANIZATION_ID , value = "领用后使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetCollectionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetCollection>> queryPagedList(AssetCollectionVO sample) {
		Result<PagedList<AssetCollection>> result=new Result<>();
		PagedList<AssetCollection> list=assetCollectionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 存放位置 数据
		assetCollectionService.join(list,AssetCollectionMeta.POSITION);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetCollectionServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetCollectionVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetCollectionService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetCollectionServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetCollectionService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetCollectionServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetCollectionService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}