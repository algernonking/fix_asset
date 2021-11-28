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


import com.dt.platform.proxy.eam.AssetStockCollectionServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStockCollectionVOMeta;
import com.dt.platform.domain.eam.AssetStockCollection;
import com.dt.platform.domain.eam.AssetStockCollectionVO;
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
import com.dt.platform.domain.eam.meta.AssetStockCollectionMeta;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.meta.AssetCollectionMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStockCollectionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产领用 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-28 19:53:37
*/

@Api(tags = "资产领用")
@ApiSort(0)
@RestController("EamAssetStockCollectionController")
public class AssetStockCollectionController extends SuperController {

	@Autowired
	private IAssetStockCollectionService assetStockCollectionService;


	/**
	 * 添加资产领用
	*/
	@ApiOperation(value = "添加资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetStockCollectionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockCollectionServiceProxy.INSERT)
	public Result insert(AssetStockCollectionVO assetStockCollectionVO) {
		Result result=assetStockCollectionService.insert(assetStockCollectionVO,false);
		return result;
	}



	/**
	 * 删除资产领用
	*/
	@ApiOperation(value = "删除资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetStockCollectionVOMeta.ID)
	@SentinelResource(value = AssetStockCollectionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockCollectionServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetStockCollectionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产领用 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetStockCollectionVOMeta.IDS)
	@SentinelResource(value = AssetStockCollectionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockCollectionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetStockCollectionService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新资产领用
	*/
	@ApiOperation(value = "更新资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetStockCollectionVOMeta.PAGE_INDEX , AssetStockCollectionVOMeta.PAGE_SIZE , AssetStockCollectionVOMeta.SEARCH_FIELD , AssetStockCollectionVOMeta.FUZZY_FIELD , AssetStockCollectionVOMeta.SEARCH_VALUE , AssetStockCollectionVOMeta.DIRTY_FIELDS , AssetStockCollectionVOMeta.SORT_FIELD , AssetStockCollectionVOMeta.SORT_TYPE , AssetStockCollectionVOMeta.IDS } )
	@NotNull(name = AssetStockCollectionVOMeta.ID)
	@SentinelResource(value = AssetStockCollectionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockCollectionServiceProxy.UPDATE)
	public Result update(AssetStockCollectionVO assetStockCollectionVO) {
		Result result=assetStockCollectionService.update(assetStockCollectionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存资产领用
	*/
	@ApiOperation(value = "保存资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockCollectionVOMeta.PAGE_INDEX , AssetStockCollectionVOMeta.PAGE_SIZE , AssetStockCollectionVOMeta.SEARCH_FIELD , AssetStockCollectionVOMeta.FUZZY_FIELD , AssetStockCollectionVOMeta.SEARCH_VALUE , AssetStockCollectionVOMeta.DIRTY_FIELDS , AssetStockCollectionVOMeta.SORT_FIELD , AssetStockCollectionVOMeta.SORT_TYPE , AssetStockCollectionVOMeta.IDS } )
	@NotNull(name = AssetStockCollectionVOMeta.ID)
	@SentinelResource(value = AssetStockCollectionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockCollectionServiceProxy.SAVE)
	public Result save(AssetStockCollectionVO assetStockCollectionVO) {
		Result result=assetStockCollectionService.save(assetStockCollectionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取资产领用
	*/
	@ApiOperation(value = "获取资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetStockCollectionVOMeta.ID)
	@SentinelResource(value = AssetStockCollectionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockCollectionServiceProxy.GET_BY_ID)
	public Result<AssetStockCollection> getById(String id) {
		Result<AssetStockCollection> result=new Result<>();
		AssetStockCollection assetStockCollection=assetStockCollectionService.getById(id);
		// join 关联的对象
		assetStockCollectionService.dao().fill(assetStockCollection)
			.with("originator")
			.with("useOrganization")
			.with("useUser")
			.with(AssetCollectionMeta.POSITION)
			.execute();
		result.success(true).data(assetStockCollection);
		return result;
	}


	/**
	 * 批量获取资产领用 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产领用")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetStockCollectionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetStockCollectionVOMeta.IDS)
		@SentinelResource(value = AssetStockCollectionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockCollectionServiceProxy.GET_BY_IDS)
	public Result<List<AssetStockCollection>> getByIds(List<String> ids) {
		Result<List<AssetStockCollection>> result=new Result<>();
		List<AssetStockCollection> list=assetStockCollectionService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产领用
	*/
	@ApiOperation(value = "查询资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStockCollectionVOMeta.PAGE_INDEX , AssetStockCollectionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetStockCollectionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockCollectionServiceProxy.QUERY_LIST)
	public Result<List<AssetStockCollection>> queryList(AssetStockCollectionVO sample) {
		Result<List<AssetStockCollection>> result=new Result<>();
		List<AssetStockCollection> list=assetStockCollectionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产领用
	*/
	@ApiOperation(value = "分页查询资产领用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.OWNER_CODE , value = "库存所属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.USE_ORGANIZATION_ID , value = "领用后公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.POSITION_ID , value = "领用后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.COLLECTION_DATE , value = "领用日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.CONTENT , value = "领用说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStockCollectionVOMeta.SELECTED_CODE , value = "选择数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetStockCollectionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStockCollectionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetStockCollection>> queryPagedList(AssetStockCollectionVO sample) {
		Result<PagedList<AssetStockCollection>> result=new Result<>();
		PagedList<AssetStockCollection> list=assetStockCollectionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetStockCollectionService.dao().fill(list)
			.with("originator")
			.with("useOrganization")
			.with("useUser")
			.with(AssetCollectionMeta.POSITION)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetStockCollectionServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockCollectionServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetStockCollectionVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetStockCollectionService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetStockCollectionServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockCollectionServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetStockCollectionService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetStockCollectionServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStockCollectionServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetStockCollectionService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}