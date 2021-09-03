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


import com.dt.platform.proxy.eam.AssetExtAttributionServiceProxy;
import com.dt.platform.domain.eam.meta.AssetExtAttributionVOMeta;
import com.dt.platform.domain.eam.AssetExtAttribution;
import com.dt.platform.domain.eam.AssetExtAttributionVO;
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
import com.dt.platform.domain.eam.meta.AssetExtAttributionMeta;
import com.dt.platform.domain.eam.Warehouse;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.Asset;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetExtAttributionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产归属数据 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-03 21:35:43
*/

@Api(tags = "资产归属数据")
@ApiSort(0)
@RestController("EamAssetExtAttributionController")
public class AssetExtAttributionController extends SuperController {

	@Autowired
	private IAssetExtAttributionService assetExtAttributionService;

	
	/**
	 * 添加资产归属数据
	*/
	@ApiOperation(value = "添加资产归属数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetExtAttributionVOMeta.ID)
	@SentinelResource(value = AssetExtAttributionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtAttributionServiceProxy.INSERT)
	public Result insert(AssetExtAttributionVO assetExtAttributionVO) {
		Result result=assetExtAttributionService.insert(assetExtAttributionVO);
		return result;
	}

	
	/**
	 * 删除资产归属数据
	*/
	@ApiOperation(value = "删除资产归属数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetExtAttributionVOMeta.ID)
	@SentinelResource(value = AssetExtAttributionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtAttributionServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetExtAttributionService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产归属数据 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产归属数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetExtAttributionVOMeta.IDS)
	@SentinelResource(value = AssetExtAttributionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtAttributionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetExtAttributionService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产归属数据
	*/
	@ApiOperation(value = "更新资产归属数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetExtAttributionVOMeta.PAGE_INDEX , AssetExtAttributionVOMeta.PAGE_SIZE , AssetExtAttributionVOMeta.SEARCH_FIELD , AssetExtAttributionVOMeta.FUZZY_FIELD , AssetExtAttributionVOMeta.SEARCH_VALUE , AssetExtAttributionVOMeta.SORT_FIELD , AssetExtAttributionVOMeta.SORT_TYPE , AssetExtAttributionVOMeta.IDS } ) 
	@NotNull(name = AssetExtAttributionVOMeta.ID)
	@SentinelResource(value = AssetExtAttributionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtAttributionServiceProxy.UPDATE)
	public Result update(AssetExtAttributionVO assetExtAttributionVO) {
		Result result=assetExtAttributionService.update(assetExtAttributionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产归属数据
	*/
	@ApiOperation(value = "保存资产归属数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetExtAttributionVOMeta.PAGE_INDEX , AssetExtAttributionVOMeta.PAGE_SIZE , AssetExtAttributionVOMeta.SEARCH_FIELD , AssetExtAttributionVOMeta.FUZZY_FIELD , AssetExtAttributionVOMeta.SEARCH_VALUE , AssetExtAttributionVOMeta.SORT_FIELD , AssetExtAttributionVOMeta.SORT_TYPE , AssetExtAttributionVOMeta.IDS } )
	@NotNull(name = AssetExtAttributionVOMeta.ID)
	@SentinelResource(value = AssetExtAttributionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtAttributionServiceProxy.SAVE)
	public Result save(AssetExtAttributionVO assetExtAttributionVO) {
		Result result=assetExtAttributionService.save(assetExtAttributionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产归属数据
	*/
	@ApiOperation(value = "获取资产归属数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetExtAttributionVOMeta.ID)
	@SentinelResource(value = AssetExtAttributionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtAttributionServiceProxy.GET_BY_ID)
	public Result<AssetExtAttribution> getById(String id) {
		Result<AssetExtAttribution> result=new Result<>();
		AssetExtAttribution assetExtAttribution=assetExtAttributionService.getById(id);
		// 关联出 存放位置 数据
		assetExtAttributionService.join(assetExtAttribution,AssetExtAttributionMeta.POSITION);
		// 关联出 仓库 数据
		assetExtAttributionService.join(assetExtAttribution,AssetExtAttributionMeta.WAREHOUSE);
		result.success(true).data(assetExtAttribution);
		return result;
	}


	/**
	 * 批量删除资产归属数据 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产归属数据")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetExtAttributionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetExtAttributionVOMeta.IDS)
		@SentinelResource(value = AssetExtAttributionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtAttributionServiceProxy.GET_BY_IDS)
	public Result<List<AssetExtAttribution>> getByIds(List<String> ids) {
		Result<List<AssetExtAttribution>> result=new Result<>();
		List<AssetExtAttribution> list=assetExtAttributionService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产归属数据
	*/
	@ApiOperation(value = "查询资产归属数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetExtAttributionVOMeta.PAGE_INDEX , AssetExtAttributionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetExtAttributionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtAttributionServiceProxy.QUERY_LIST)
	public Result<List<AssetExtAttribution>> queryList(AssetExtAttributionVO sample) {
		Result<List<AssetExtAttribution>> result=new Result<>();
		List<AssetExtAttribution> list=assetExtAttributionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产归属数据
	*/
	@ApiOperation(value = "分页查询资产归属数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtAttributionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetExtAttributionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtAttributionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetExtAttribution>> queryPagedList(AssetExtAttributionVO sample) {
		Result<PagedList<AssetExtAttribution>> result=new Result<>();
		PagedList<AssetExtAttribution> list=assetExtAttributionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 存放位置 数据
		assetExtAttributionService.join(list,AssetExtAttributionMeta.POSITION);
		// 关联出 仓库 数据
		assetExtAttributionService.join(list,AssetExtAttributionMeta.WAREHOUSE);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetExtAttributionServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtAttributionServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetExtAttributionVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetExtAttributionService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetExtAttributionServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtAttributionServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetExtAttributionService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetExtAttributionServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtAttributionServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetExtAttributionService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}