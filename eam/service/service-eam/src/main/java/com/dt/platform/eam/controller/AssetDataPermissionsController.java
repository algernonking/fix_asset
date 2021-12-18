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


import com.dt.platform.proxy.eam.AssetDataPermissionsServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDataPermissionsVOMeta;
import com.dt.platform.domain.eam.AssetDataPermissions;
import com.dt.platform.domain.eam.AssetDataPermissionsVO;
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
import com.dt.platform.domain.eam.meta.AssetDataPermissionsMeta;
import org.github.foxnic.web.domain.system.BusiRole;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.eam.Position;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDataPermissionsService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产数据权限 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-12-18 08:47:50
*/

@Api(tags = "资产数据权限")
@ApiSort(0)
@RestController("EamAssetDataPermissionsController")
public class AssetDataPermissionsController extends SuperController {

	@Autowired
	private IAssetDataPermissionsService assetDataPermissionsService;


	/**
	 * 添加资产数据权限
	*/
	@ApiOperation(value = "添加资产数据权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "523894324979568640"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "资产全局数据角色"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.STATUS , value = "权限状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CODE , value = "权限编码" , required = false , dataTypeClass=String.class , example = "data_perm_1"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ROLE_CODE , value = "业务角色" , required = false , dataTypeClass=String.class , example = "eam_data_perm_default"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_AUTHORITY_ENABLE , value = "组织权限状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_LOCAL_ENABLE , value = "本组织激活" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_CASCADE_ENABLE , value = "组织级联状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CATALOG_AUTHORITY_ENABLE , value = "分类权限状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CATALOG_CASCADE_ENABLE , value = "分类级联状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.POSITION_AUTHORITY_ENABLE , value = "位置权限状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.PRIORITY , value = "优先级" , required = false , dataTypeClass=Integer.class , example = "100"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetDataPermissionsServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsServiceProxy.INSERT)
	public Result insert(AssetDataPermissionsVO assetDataPermissionsVO) {
		Result result=assetDataPermissionsService.insert(assetDataPermissionsVO,false);
		return result;
	}



	/**
	 * 删除资产数据权限
	*/
	@ApiOperation(value = "删除资产数据权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "523894324979568640")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetDataPermissionsVOMeta.ID)
	@SentinelResource(value = AssetDataPermissionsServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetDataPermissionsService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产数据权限 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产数据权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetDataPermissionsVOMeta.IDS)
	@SentinelResource(value = AssetDataPermissionsServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetDataPermissionsService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新资产数据权限
	*/
	@ApiOperation(value = "更新资产数据权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "523894324979568640"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "资产全局数据角色"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.STATUS , value = "权限状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CODE , value = "权限编码" , required = false , dataTypeClass=String.class , example = "data_perm_1"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ROLE_CODE , value = "业务角色" , required = false , dataTypeClass=String.class , example = "eam_data_perm_default"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_AUTHORITY_ENABLE , value = "组织权限状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_LOCAL_ENABLE , value = "本组织激活" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_CASCADE_ENABLE , value = "组织级联状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CATALOG_AUTHORITY_ENABLE , value = "分类权限状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CATALOG_CASCADE_ENABLE , value = "分类级联状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.POSITION_AUTHORITY_ENABLE , value = "位置权限状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.PRIORITY , value = "优先级" , required = false , dataTypeClass=Integer.class , example = "100"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetDataPermissionsVOMeta.PAGE_INDEX , AssetDataPermissionsVOMeta.PAGE_SIZE , AssetDataPermissionsVOMeta.SEARCH_FIELD , AssetDataPermissionsVOMeta.FUZZY_FIELD , AssetDataPermissionsVOMeta.SEARCH_VALUE , AssetDataPermissionsVOMeta.DIRTY_FIELDS , AssetDataPermissionsVOMeta.SORT_FIELD , AssetDataPermissionsVOMeta.SORT_TYPE , AssetDataPermissionsVOMeta.IDS } )
	@NotNull(name = AssetDataPermissionsVOMeta.ID)
	@SentinelResource(value = AssetDataPermissionsServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsServiceProxy.UPDATE)
	public Result update(AssetDataPermissionsVO assetDataPermissionsVO) {
		Result result=assetDataPermissionsService.update(assetDataPermissionsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存资产数据权限
	*/
	@ApiOperation(value = "保存资产数据权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "523894324979568640"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "资产全局数据角色"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.STATUS , value = "权限状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CODE , value = "权限编码" , required = false , dataTypeClass=String.class , example = "data_perm_1"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ROLE_CODE , value = "业务角色" , required = false , dataTypeClass=String.class , example = "eam_data_perm_default"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_AUTHORITY_ENABLE , value = "组织权限状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_LOCAL_ENABLE , value = "本组织激活" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_CASCADE_ENABLE , value = "组织级联状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CATALOG_AUTHORITY_ENABLE , value = "分类权限状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CATALOG_CASCADE_ENABLE , value = "分类级联状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.POSITION_AUTHORITY_ENABLE , value = "位置权限状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.PRIORITY , value = "优先级" , required = false , dataTypeClass=Integer.class , example = "100"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDataPermissionsVOMeta.PAGE_INDEX , AssetDataPermissionsVOMeta.PAGE_SIZE , AssetDataPermissionsVOMeta.SEARCH_FIELD , AssetDataPermissionsVOMeta.FUZZY_FIELD , AssetDataPermissionsVOMeta.SEARCH_VALUE , AssetDataPermissionsVOMeta.DIRTY_FIELDS , AssetDataPermissionsVOMeta.SORT_FIELD , AssetDataPermissionsVOMeta.SORT_TYPE , AssetDataPermissionsVOMeta.IDS } )
	@NotNull(name = AssetDataPermissionsVOMeta.ID)
	@SentinelResource(value = AssetDataPermissionsServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsServiceProxy.SAVE)
	public Result save(AssetDataPermissionsVO assetDataPermissionsVO) {
		Result result=assetDataPermissionsService.save(assetDataPermissionsVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取资产数据权限
	*/
	@ApiOperation(value = "获取资产数据权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetDataPermissionsVOMeta.ID)
	@SentinelResource(value = AssetDataPermissionsServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsServiceProxy.GET_BY_ID)
	public Result<AssetDataPermissions> getById(String id) {
		Result<AssetDataPermissions> result=new Result<>();
		AssetDataPermissions assetDataPermissions=assetDataPermissionsService.getById(id);
		// join 关联的对象
		assetDataPermissionsService.dao().fill(assetDataPermissions)
			.with("organization")
			.with(AssetDataPermissionsMeta.BUSI_ROLE)
			.with(AssetDataPermissionsMeta.POSITION)
			.with(AssetDataPermissionsMeta.CATEGORY)
			.execute();
		result.success(true).data(assetDataPermissions);
		return result;
	}


	/**
	 * 批量获取资产数据权限 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产数据权限")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetDataPermissionsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetDataPermissionsVOMeta.IDS)
		@SentinelResource(value = AssetDataPermissionsServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsServiceProxy.GET_BY_IDS)
	public Result<List<AssetDataPermissions>> getByIds(List<String> ids) {
		Result<List<AssetDataPermissions>> result=new Result<>();
		List<AssetDataPermissions> list=assetDataPermissionsService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产数据权限
	*/
	@ApiOperation(value = "查询资产数据权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "523894324979568640"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "资产全局数据角色"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.STATUS , value = "权限状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CODE , value = "权限编码" , required = false , dataTypeClass=String.class , example = "data_perm_1"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ROLE_CODE , value = "业务角色" , required = false , dataTypeClass=String.class , example = "eam_data_perm_default"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_AUTHORITY_ENABLE , value = "组织权限状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_LOCAL_ENABLE , value = "本组织激活" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_CASCADE_ENABLE , value = "组织级联状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CATALOG_AUTHORITY_ENABLE , value = "分类权限状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CATALOG_CASCADE_ENABLE , value = "分类级联状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.POSITION_AUTHORITY_ENABLE , value = "位置权限状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.PRIORITY , value = "优先级" , required = false , dataTypeClass=Integer.class , example = "100"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDataPermissionsVOMeta.PAGE_INDEX , AssetDataPermissionsVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetDataPermissionsServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsServiceProxy.QUERY_LIST)
	public Result<List<AssetDataPermissions>> queryList(AssetDataPermissionsVO sample) {
		Result<List<AssetDataPermissions>> result=new Result<>();
		List<AssetDataPermissions> list=assetDataPermissionsService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产数据权限
	*/
	@ApiOperation(value = "分页查询资产数据权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "523894324979568640"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "资产全局数据角色"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.STATUS , value = "权限状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class , example = "asset"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CODE , value = "权限编码" , required = false , dataTypeClass=String.class , example = "data_perm_1"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ROLE_CODE , value = "业务角色" , required = false , dataTypeClass=String.class , example = "eam_data_perm_default"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_AUTHORITY_ENABLE , value = "组织权限状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_LOCAL_ENABLE , value = "本组织激活" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.ORG_CASCADE_ENABLE , value = "组织级联状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CATALOG_AUTHORITY_ENABLE , value = "分类权限状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.CATALOG_CASCADE_ENABLE , value = "分类级联状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.POSITION_AUTHORITY_ENABLE , value = "位置权限状态" , required = false , dataTypeClass=String.class , example = "disable"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.PRIORITY , value = "优先级" , required = false , dataTypeClass=Integer.class , example = "100"),
		@ApiImplicitParam(name = AssetDataPermissionsVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetDataPermissionsServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataPermissionsServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetDataPermissions>> queryPagedList(AssetDataPermissionsVO sample) {
		Result<PagedList<AssetDataPermissions>> result=new Result<>();
		PagedList<AssetDataPermissions> list=assetDataPermissionsService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetDataPermissionsService.dao().fill(list)
			.with("organization")
			.with(AssetDataPermissionsMeta.BUSI_ROLE)
			.with(AssetDataPermissionsMeta.POSITION)
			.with(AssetDataPermissionsMeta.CATEGORY)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetDataPermissionsServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataPermissionsServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetDataPermissionsVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetDataPermissionsService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetDataPermissionsServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataPermissionsServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetDataPermissionsService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetDataPermissionsServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataPermissionsServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetDataPermissionsService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}