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


import com.dt.platform.proxy.eam.AssetSoftwareChangeDetailServiceProxy;
import com.dt.platform.domain.eam.meta.AssetSoftwareChangeDetailVOMeta;
import com.dt.platform.domain.eam.AssetSoftwareChangeDetail;
import com.dt.platform.domain.eam.AssetSoftwareChangeDetailVO;
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
import com.dt.platform.domain.eam.meta.AssetSoftwareChangeDetailMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.AssetSoftware;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetSoftwareChangeDetailService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 软件变更明细 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-05 15:05:44
*/

@Api(tags = "软件变更明细")
@ApiSort(0)
@RestController("EamAssetSoftwareChangeDetailController")
public class AssetSoftwareChangeDetailController extends SuperController {

	@Autowired
	private IAssetSoftwareChangeDetailService assetSoftwareChangeDetailService;


	/**
	 * 添加软件变更明细
	*/
	@ApiOperation(value = "添加软件变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.CHANGE_ID , value = "变更" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.SOFTWARE_ID , value = "软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.AFTER_SOFTWARE_ID , value = "变更前软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.BEFORE_SOFTWARE_ID , value = "变更后软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeDetailServiceProxy.INSERT)
	public Result insert(AssetSoftwareChangeDetailVO assetSoftwareChangeDetailVO) {
		Result result=assetSoftwareChangeDetailService.insert(assetSoftwareChangeDetailVO,false);
		return result;
	}



	/**
	 * 删除软件变更明细
	*/
	@ApiOperation(value = "删除软件变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetSoftwareChangeDetailVOMeta.ID)
	@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeDetailServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetSoftwareChangeDetailService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除软件变更明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除软件变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetSoftwareChangeDetailVOMeta.IDS)
	@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeDetailServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetSoftwareChangeDetailService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新软件变更明细
	*/
	@ApiOperation(value = "更新软件变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.CHANGE_ID , value = "变更" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.SOFTWARE_ID , value = "软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.AFTER_SOFTWARE_ID , value = "变更前软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.BEFORE_SOFTWARE_ID , value = "变更后软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetSoftwareChangeDetailVOMeta.PAGE_INDEX , AssetSoftwareChangeDetailVOMeta.PAGE_SIZE , AssetSoftwareChangeDetailVOMeta.SEARCH_FIELD , AssetSoftwareChangeDetailVOMeta.FUZZY_FIELD , AssetSoftwareChangeDetailVOMeta.SEARCH_VALUE , AssetSoftwareChangeDetailVOMeta.DIRTY_FIELDS , AssetSoftwareChangeDetailVOMeta.SORT_FIELD , AssetSoftwareChangeDetailVOMeta.SORT_TYPE , AssetSoftwareChangeDetailVOMeta.IDS } )
	@NotNull(name = AssetSoftwareChangeDetailVOMeta.ID)
	@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeDetailServiceProxy.UPDATE)
	public Result update(AssetSoftwareChangeDetailVO assetSoftwareChangeDetailVO) {
		Result result=assetSoftwareChangeDetailService.update(assetSoftwareChangeDetailVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存软件变更明细
	*/
	@ApiOperation(value = "保存软件变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.CHANGE_ID , value = "变更" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.SOFTWARE_ID , value = "软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.AFTER_SOFTWARE_ID , value = "变更前软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.BEFORE_SOFTWARE_ID , value = "变更后软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareChangeDetailVOMeta.PAGE_INDEX , AssetSoftwareChangeDetailVOMeta.PAGE_SIZE , AssetSoftwareChangeDetailVOMeta.SEARCH_FIELD , AssetSoftwareChangeDetailVOMeta.FUZZY_FIELD , AssetSoftwareChangeDetailVOMeta.SEARCH_VALUE , AssetSoftwareChangeDetailVOMeta.DIRTY_FIELDS , AssetSoftwareChangeDetailVOMeta.SORT_FIELD , AssetSoftwareChangeDetailVOMeta.SORT_TYPE , AssetSoftwareChangeDetailVOMeta.IDS } )
	@NotNull(name = AssetSoftwareChangeDetailVOMeta.ID)
	@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeDetailServiceProxy.SAVE)
	public Result save(AssetSoftwareChangeDetailVO assetSoftwareChangeDetailVO) {
		Result result=assetSoftwareChangeDetailService.save(assetSoftwareChangeDetailVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取软件变更明细
	*/
	@ApiOperation(value = "获取软件变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetSoftwareChangeDetailVOMeta.ID)
	@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeDetailServiceProxy.GET_BY_ID)
	public Result<AssetSoftwareChangeDetail> getById(String id) {
		Result<AssetSoftwareChangeDetail> result=new Result<>();
		AssetSoftwareChangeDetail assetSoftwareChangeDetail=assetSoftwareChangeDetailService.getById(id);
		result.success(true).data(assetSoftwareChangeDetail);
		return result;
	}


	/**
	 * 批量获取软件变更明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取软件变更明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetSoftwareChangeDetailVOMeta.IDS)
		@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeDetailServiceProxy.GET_BY_IDS)
	public Result<List<AssetSoftwareChangeDetail>> getByIds(List<String> ids) {
		Result<List<AssetSoftwareChangeDetail>> result=new Result<>();
		List<AssetSoftwareChangeDetail> list=assetSoftwareChangeDetailService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询软件变更明细
	*/
	@ApiOperation(value = "查询软件变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.CHANGE_ID , value = "变更" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.SOFTWARE_ID , value = "软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.AFTER_SOFTWARE_ID , value = "变更前软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.BEFORE_SOFTWARE_ID , value = "变更后软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetSoftwareChangeDetailVOMeta.PAGE_INDEX , AssetSoftwareChangeDetailVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeDetailServiceProxy.QUERY_LIST)
	public Result<List<AssetSoftwareChangeDetail>> queryList(AssetSoftwareChangeDetailVO sample) {
		Result<List<AssetSoftwareChangeDetail>> result=new Result<>();
		List<AssetSoftwareChangeDetail> list=assetSoftwareChangeDetailService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询软件变更明细
	*/
	@ApiOperation(value = "分页查询软件变更明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.CHANGE_ID , value = "变更" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.SOFTWARE_ID , value = "软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.AFTER_SOFTWARE_ID , value = "变更前软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.BEFORE_SOFTWARE_ID , value = "变更后软件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetSoftwareChangeDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetSoftwareChangeDetailServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetSoftwareChangeDetail>> queryPagedList(AssetSoftwareChangeDetailVO sample) {
		Result<PagedList<AssetSoftwareChangeDetail>> result=new Result<>();
		PagedList<AssetSoftwareChangeDetail> list=assetSoftwareChangeDetailService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());


		result.success(true).data(list);
		return result;
	}




	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareChangeDetailServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetSoftwareChangeDetailVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetSoftwareChangeDetailService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareChangeDetailServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetSoftwareChangeDetailService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetSoftwareChangeDetailServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetSoftwareChangeDetailServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetSoftwareChangeDetailService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}