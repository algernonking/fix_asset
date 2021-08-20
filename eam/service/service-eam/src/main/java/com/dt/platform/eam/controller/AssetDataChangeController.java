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


import com.dt.platform.proxy.eam.AssetDataChangeServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDataChangeVOMeta;
import com.dt.platform.domain.eam.AssetDataChange;
import com.dt.platform.domain.eam.AssetDataChangeVO;
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
import com.dt.platform.domain.eam.meta.AssetDataChangeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDataChangeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 变更明细 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 16:12:51
*/

@Api(tags = "变更明细")
@ApiSort(0)
@RestController("EamAssetDataChangeController")
public class AssetDataChangeController extends SuperController {

	@Autowired
	private IAssetDataChangeService assetDataChangeService;

	
	/**
	 * 添加变更明细
	*/
	@ApiOperation(value = "添加变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.BUSINESS_CODE , value = "变更号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CONTENT , value = "变更内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@SentinelResource(value = AssetDataChangeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.INSERT)
	public Result insert(AssetDataChangeVO assetDataChangeVO) {
		Result result=assetDataChangeService.insert(assetDataChangeVO);
		return result;
	}

	
	/**
	 * 删除变更明细
	*/
	@ApiOperation(value = "删除变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@SentinelResource(value = AssetDataChangeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetDataChangeService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除变更明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetDataChangeVOMeta.IDS)
	@SentinelResource(value = AssetDataChangeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetDataChangeService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新变更明细
	*/
	@ApiOperation(value = "更新变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.BUSINESS_CODE , value = "变更号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CONTENT , value = "变更内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetDataChangeVOMeta.PAGE_INDEX , AssetDataChangeVOMeta.PAGE_SIZE , AssetDataChangeVOMeta.SEARCH_FIELD , AssetDataChangeVOMeta.FUZZY_FIELD , AssetDataChangeVOMeta.SEARCH_VALUE , AssetDataChangeVOMeta.SORT_FIELD , AssetDataChangeVOMeta.SORT_TYPE , AssetDataChangeVOMeta.IDS } ) 
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@SentinelResource(value = AssetDataChangeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.UPDATE)
	public Result update(AssetDataChangeVO assetDataChangeVO) {
		Result result=assetDataChangeService.update(assetDataChangeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存变更明细
	*/
	@ApiOperation(value = "保存变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.BUSINESS_CODE , value = "变更号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CONTENT , value = "变更内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDataChangeVOMeta.PAGE_INDEX , AssetDataChangeVOMeta.PAGE_SIZE , AssetDataChangeVOMeta.SEARCH_FIELD , AssetDataChangeVOMeta.FUZZY_FIELD , AssetDataChangeVOMeta.SEARCH_VALUE , AssetDataChangeVOMeta.SORT_FIELD , AssetDataChangeVOMeta.SORT_TYPE , AssetDataChangeVOMeta.IDS } )
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@SentinelResource(value = AssetDataChangeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.SAVE)
	public Result save(AssetDataChangeVO assetDataChangeVO) {
		Result result=assetDataChangeService.save(assetDataChangeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取变更明细
	*/
	@ApiOperation(value = "获取变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetDataChangeVOMeta.ID)
	@SentinelResource(value = AssetDataChangeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.GET_BY_ID)
	public Result<AssetDataChange> getById(String id) {
		Result<AssetDataChange> result=new Result<>();
		AssetDataChange assetDataChange=assetDataChangeService.getById(id);
		result.success(true).data(assetDataChange);
		return result;
	}


	/**
	 * 批量删除变更明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除变更明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetDataChangeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetDataChangeVOMeta.IDS)
		@SentinelResource(value = AssetDataChangeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.GET_BY_IDS)
	public Result<List<AssetDataChange>> getByIds(List<String> ids) {
		Result<List<AssetDataChange>> result=new Result<>();
		List<AssetDataChange> list=assetDataChangeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询变更明细
	*/
	@ApiOperation(value = "查询变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.BUSINESS_CODE , value = "变更号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CONTENT , value = "变更内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDataChangeVOMeta.PAGE_INDEX , AssetDataChangeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetDataChangeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.QUERY_LIST)
	public Result<List<AssetDataChange>> queryList(AssetDataChangeVO sample) {
		Result<List<AssetDataChange>> result=new Result<>();
		List<AssetDataChange> list=assetDataChangeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询变更明细
	*/
	@ApiOperation(value = "分页查询变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.BUSINESS_CODE , value = "变更号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.TYPE , value = "变更类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CONTENT , value = "变更内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDataChangeVOMeta.CHANGE_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetDataChangeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDataChangeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetDataChange>> queryPagedList(AssetDataChangeVO sample) {
		Result<PagedList<AssetDataChange>> result=new Result<>();
		PagedList<AssetDataChange> list=assetDataChangeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetDataChangeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataChangeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetDataChangeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetDataChangeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetDataChangeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataChangeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetDataChangeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetDataChangeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDataChangeServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetDataChangeService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}