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


import com.dt.platform.proxy.eam.AssetExtMaintainerServiceProxy;
import com.dt.platform.domain.eam.meta.AssetExtMaintainerVOMeta;
import com.dt.platform.domain.eam.AssetExtMaintainer;
import com.dt.platform.domain.eam.AssetExtMaintainerVO;
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
import com.dt.platform.domain.eam.meta.AssetExtMaintainerMeta;
import com.dt.platform.domain.eam.Maintainer;
import com.dt.platform.domain.eam.Asset;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetExtMaintainerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产维保数据 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-29 12:15:48
*/

@Api(tags = "资产维保数据")
@ApiSort(0)
@RestController("EamAssetExtMaintainerController")
public class AssetExtMaintainerController extends SuperController {

	@Autowired
	private IAssetExtMaintainerService assetExtMaintainerService;

	
	/**
	 * 添加资产维保数据
	*/
	@ApiOperation(value = "添加资产维保数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479361938078302208"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "472013393872551936"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_START_TIME , value = "维保开始时间" , required = false , dataTypeClass=Date.class , example = "2021-08-04 12:00:00"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_END_TIME , value = "维保到期时间" , required = false , dataTypeClass=Date.class , example = "2021-08-15 12:00:00"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_DESCRIPTION , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetExtMaintainerVOMeta.ID)
	@SentinelResource(value = AssetExtMaintainerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtMaintainerServiceProxy.INSERT)
	public Result insert(AssetExtMaintainerVO assetExtMaintainerVO) {
		Result result=assetExtMaintainerService.insert(assetExtMaintainerVO);
		return result;
	}

	
	/**
	 * 删除资产维保数据
	*/
	@ApiOperation(value = "删除资产维保数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479361938078302208")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetExtMaintainerVOMeta.ID)
	@SentinelResource(value = AssetExtMaintainerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtMaintainerServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetExtMaintainerService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产维保数据 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产维保数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetExtMaintainerVOMeta.IDS)
	@SentinelResource(value = AssetExtMaintainerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtMaintainerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetExtMaintainerService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产维保数据
	*/
	@ApiOperation(value = "更新资产维保数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479361938078302208"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "472013393872551936"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_START_TIME , value = "维保开始时间" , required = false , dataTypeClass=Date.class , example = "2021-08-04 12:00:00"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_END_TIME , value = "维保到期时间" , required = false , dataTypeClass=Date.class , example = "2021-08-15 12:00:00"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_DESCRIPTION , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetExtMaintainerVOMeta.PAGE_INDEX , AssetExtMaintainerVOMeta.PAGE_SIZE , AssetExtMaintainerVOMeta.SEARCH_FIELD , AssetExtMaintainerVOMeta.FUZZY_FIELD , AssetExtMaintainerVOMeta.SEARCH_VALUE , AssetExtMaintainerVOMeta.SORT_FIELD , AssetExtMaintainerVOMeta.SORT_TYPE , AssetExtMaintainerVOMeta.IDS } ) 
	@NotNull(name = AssetExtMaintainerVOMeta.ID)
	@SentinelResource(value = AssetExtMaintainerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtMaintainerServiceProxy.UPDATE)
	public Result update(AssetExtMaintainerVO assetExtMaintainerVO) {
		Result result=assetExtMaintainerService.update(assetExtMaintainerVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产维保数据
	*/
	@ApiOperation(value = "保存资产维保数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479361938078302208"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "472013393872551936"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_START_TIME , value = "维保开始时间" , required = false , dataTypeClass=Date.class , example = "2021-08-04 12:00:00"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_END_TIME , value = "维保到期时间" , required = false , dataTypeClass=Date.class , example = "2021-08-15 12:00:00"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_DESCRIPTION , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetExtMaintainerVOMeta.PAGE_INDEX , AssetExtMaintainerVOMeta.PAGE_SIZE , AssetExtMaintainerVOMeta.SEARCH_FIELD , AssetExtMaintainerVOMeta.FUZZY_FIELD , AssetExtMaintainerVOMeta.SEARCH_VALUE , AssetExtMaintainerVOMeta.SORT_FIELD , AssetExtMaintainerVOMeta.SORT_TYPE , AssetExtMaintainerVOMeta.IDS } )
	@NotNull(name = AssetExtMaintainerVOMeta.ID)
	@SentinelResource(value = AssetExtMaintainerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtMaintainerServiceProxy.SAVE)
	public Result save(AssetExtMaintainerVO assetExtMaintainerVO) {
		Result result=assetExtMaintainerService.save(assetExtMaintainerVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产维保数据
	*/
	@ApiOperation(value = "获取资产维保数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetExtMaintainerVOMeta.ID)
	@SentinelResource(value = AssetExtMaintainerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtMaintainerServiceProxy.GET_BY_ID)
	public Result<AssetExtMaintainer> getById(String id) {
		Result<AssetExtMaintainer> result=new Result<>();
		AssetExtMaintainer assetExtMaintainer=assetExtMaintainerService.getById(id);
		// 关联出 维保商 数据
		assetExtMaintainerService.join(assetExtMaintainer,AssetExtMaintainerMeta.MAINTNAINER);
		result.success(true).data(assetExtMaintainer);
		return result;
	}


	/**
	 * 批量删除资产维保数据 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产维保数据")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetExtMaintainerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetExtMaintainerVOMeta.IDS)
		@SentinelResource(value = AssetExtMaintainerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtMaintainerServiceProxy.GET_BY_IDS)
	public Result<List<AssetExtMaintainer>> getByIds(List<String> ids) {
		Result<List<AssetExtMaintainer>> result=new Result<>();
		List<AssetExtMaintainer> list=assetExtMaintainerService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产维保数据
	*/
	@ApiOperation(value = "查询资产维保数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479361938078302208"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "472013393872551936"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_START_TIME , value = "维保开始时间" , required = false , dataTypeClass=Date.class , example = "2021-08-04 12:00:00"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_END_TIME , value = "维保到期时间" , required = false , dataTypeClass=Date.class , example = "2021-08-15 12:00:00"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_DESCRIPTION , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetExtMaintainerVOMeta.PAGE_INDEX , AssetExtMaintainerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetExtMaintainerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtMaintainerServiceProxy.QUERY_LIST)
	public Result<List<AssetExtMaintainer>> queryList(AssetExtMaintainerVO sample) {
		Result<List<AssetExtMaintainer>> result=new Result<>();
		List<AssetExtMaintainer> list=assetExtMaintainerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产维保数据
	*/
	@ApiOperation(value = "分页查询资产维保数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479361938078302208"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "472013393872551936"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_START_TIME , value = "维保开始时间" , required = false , dataTypeClass=Date.class , example = "2021-08-04 12:00:00"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_END_TIME , value = "维保到期时间" , required = false , dataTypeClass=Date.class , example = "2021-08-15 12:00:00"),
		@ApiImplicitParam(name = AssetExtMaintainerVOMeta.MAINTENANCE_DESCRIPTION , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetExtMaintainerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtMaintainerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetExtMaintainer>> queryPagedList(AssetExtMaintainerVO sample) {
		Result<PagedList<AssetExtMaintainer>> result=new Result<>();
		PagedList<AssetExtMaintainer> list=assetExtMaintainerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 维保商 数据
		assetExtMaintainerService.join(list,AssetExtMaintainerMeta.MAINTNAINER);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetExtMaintainerServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtMaintainerServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetExtMaintainerVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetExtMaintainerService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetExtMaintainerServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtMaintainerServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetExtMaintainerService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetExtMaintainerServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtMaintainerServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetExtMaintainerService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}