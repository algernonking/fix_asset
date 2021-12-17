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


import com.dt.platform.proxy.eam.AssetDataPermissionsOrgServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDataPermissionsOrgVOMeta;
import com.dt.platform.domain.eam.AssetDataPermissionsOrg;
import com.dt.platform.domain.eam.AssetDataPermissionsOrgVO;
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
import com.dt.platform.domain.eam.meta.AssetDataPermissionsOrgMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDataPermissionsOrgService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 组织 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-12-16 15:24:09
*/

@Api(tags = "组织")
@ApiSort(0)
@RestController("EamAssetDataPermissionsOrgController")
public class AssetDataPermissionsOrgController extends SuperController {

	@Autowired
	private IAssetDataPermissionsOrgService assetDataPermissionsOrgService;


	/**
	 * 添加组织
	*/
	@ApiOperation(value = "添加组织")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.PERMISSION_ID , value = "权限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.VALUE , value = "值" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsOrgServiceProxy.INSERT)
	public Result insert(AssetDataPermissionsOrgVO assetDataPermissionsOrgVO) {
		Result result=assetDataPermissionsOrgService.insert(assetDataPermissionsOrgVO,false);
		return result;
	}



	/**
	 * 删除组织
	*/
	@ApiOperation(value = "删除组织")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetDataPermissionsOrgVOMeta.ID)
	@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsOrgServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetDataPermissionsOrgService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除组织 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除组织")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetDataPermissionsOrgVOMeta.IDS)
	@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsOrgServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetDataPermissionsOrgService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新组织
	*/
	@ApiOperation(value = "更新组织")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.PERMISSION_ID , value = "权限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.VALUE , value = "值" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetDataPermissionsOrgVOMeta.PAGE_INDEX , AssetDataPermissionsOrgVOMeta.PAGE_SIZE , AssetDataPermissionsOrgVOMeta.SEARCH_FIELD , AssetDataPermissionsOrgVOMeta.FUZZY_FIELD , AssetDataPermissionsOrgVOMeta.SEARCH_VALUE , AssetDataPermissionsOrgVOMeta.DIRTY_FIELDS , AssetDataPermissionsOrgVOMeta.SORT_FIELD , AssetDataPermissionsOrgVOMeta.SORT_TYPE , AssetDataPermissionsOrgVOMeta.IDS } )
	@NotNull(name = AssetDataPermissionsOrgVOMeta.ID)
	@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsOrgServiceProxy.UPDATE)
	public Result update(AssetDataPermissionsOrgVO assetDataPermissionsOrgVO) {
		Result result=assetDataPermissionsOrgService.update(assetDataPermissionsOrgVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存组织
	*/
	@ApiOperation(value = "保存组织")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.PERMISSION_ID , value = "权限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.VALUE , value = "值" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDataPermissionsOrgVOMeta.PAGE_INDEX , AssetDataPermissionsOrgVOMeta.PAGE_SIZE , AssetDataPermissionsOrgVOMeta.SEARCH_FIELD , AssetDataPermissionsOrgVOMeta.FUZZY_FIELD , AssetDataPermissionsOrgVOMeta.SEARCH_VALUE , AssetDataPermissionsOrgVOMeta.DIRTY_FIELDS , AssetDataPermissionsOrgVOMeta.SORT_FIELD , AssetDataPermissionsOrgVOMeta.SORT_TYPE , AssetDataPermissionsOrgVOMeta.IDS } )
	@NotNull(name = AssetDataPermissionsOrgVOMeta.ID)
	@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsOrgServiceProxy.SAVE)
	public Result save(AssetDataPermissionsOrgVO assetDataPermissionsOrgVO) {
		Result result=assetDataPermissionsOrgService.save(assetDataPermissionsOrgVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取组织
	*/
	@ApiOperation(value = "获取组织")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetDataPermissionsOrgVOMeta.ID)
	@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsOrgServiceProxy.GET_BY_ID)
	public Result<AssetDataPermissionsOrg> getById(String id) {
		Result<AssetDataPermissionsOrg> result=new Result<>();
		AssetDataPermissionsOrg assetDataPermissionsOrg=assetDataPermissionsOrgService.getById(id);
		result.success(true).data(assetDataPermissionsOrg);
		return result;
	}


	/**
	 * 批量获取组织 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取组织")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetDataPermissionsOrgVOMeta.IDS)
		@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsOrgServiceProxy.GET_BY_IDS)
	public Result<List<AssetDataPermissionsOrg>> getByIds(List<String> ids) {
		Result<List<AssetDataPermissionsOrg>> result=new Result<>();
		List<AssetDataPermissionsOrg> list=assetDataPermissionsOrgService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询组织
	*/
	@ApiOperation(value = "查询组织")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.PERMISSION_ID , value = "权限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.VALUE , value = "值" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDataPermissionsOrgVOMeta.PAGE_INDEX , AssetDataPermissionsOrgVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsOrgServiceProxy.QUERY_LIST)
	public Result<List<AssetDataPermissionsOrg>> queryList(AssetDataPermissionsOrgVO sample) {
		Result<List<AssetDataPermissionsOrg>> result=new Result<>();
		List<AssetDataPermissionsOrg> list=assetDataPermissionsOrgService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询组织
	*/
	@ApiOperation(value = "分页查询组织")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.PERMISSION_ID , value = "权限" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataPermissionsOrgVOMeta.VALUE , value = "值" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsOrgServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetDataPermissionsOrg>> queryPagedList(AssetDataPermissionsOrgVO sample) {
		Result<PagedList<AssetDataPermissionsOrg>> result=new Result<>();
		PagedList<AssetDataPermissionsOrg> list=assetDataPermissionsOrgService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataPermissionsOrgServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetDataPermissionsOrgVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetDataPermissionsOrgService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataPermissionsOrgServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetDataPermissionsOrgService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetDataPermissionsOrgServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataPermissionsOrgServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetDataPermissionsOrgService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}