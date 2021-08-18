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


import com.dt.platform.proxy.eam.AssetReturnServiceProxy;
import com.dt.platform.domain.eam.meta.AssetReturnVOMeta;
import com.dt.platform.domain.eam.AssetReturn;
import com.dt.platform.domain.eam.AssetReturnVO;
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
import com.dt.platform.domain.eam.meta.AssetReturnMeta;
import com.dt.platform.domain.eam.Position;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetReturnService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产退库 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-18 11:55:22
*/

@Api(tags = "资产退库")
@ApiSort(0)
@RestController("EamAssetReturnController")
public class AssetReturnController extends SuperController {

	@Autowired
	private IAssetReturnService assetReturnService;

	
	/**
	 * 添加资产退库
	*/
	@ApiOperation(value = "添加资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.RETURN_DATE , value = "退库日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.USER_ORGANIZATION_ID , value = "退库使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.POSITION_ID , value = "退库后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.CONTENT , value = "退库说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetReturnVOMeta.ID)
	@NotNull(name = AssetReturnVOMeta.NAME)
	@SentinelResource(value = AssetReturnServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetReturnServiceProxy.INSERT)
	public Result insert(AssetReturnVO assetReturnVO) {
		Result result=assetReturnService.insert(assetReturnVO);
		return result;
	}

	
	/**
	 * 删除资产退库
	*/
	@ApiOperation(value = "删除资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetReturnVOMeta.ID)
	@SentinelResource(value = AssetReturnServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetReturnServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetReturnService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产退库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetReturnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetReturnVOMeta.IDS)
	@SentinelResource(value = AssetReturnServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetReturnServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetReturnService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产退库
	*/
	@ApiOperation(value = "更新资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.RETURN_DATE , value = "退库日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.USER_ORGANIZATION_ID , value = "退库使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.POSITION_ID , value = "退库后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.CONTENT , value = "退库说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetReturnVOMeta.PAGE_INDEX , AssetReturnVOMeta.PAGE_SIZE , AssetReturnVOMeta.SEARCH_FIELD , AssetReturnVOMeta.FUZZY_FIELD , AssetReturnVOMeta.SEARCH_VALUE , AssetReturnVOMeta.SORT_FIELD , AssetReturnVOMeta.SORT_TYPE , AssetReturnVOMeta.IDS } ) 
	@NotNull(name = AssetReturnVOMeta.ID)
	@NotNull(name = AssetReturnVOMeta.NAME)
	@SentinelResource(value = AssetReturnServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetReturnServiceProxy.UPDATE)
	public Result update(AssetReturnVO assetReturnVO) {
		Result result=assetReturnService.update(assetReturnVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产退库
	*/
	@ApiOperation(value = "保存资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.RETURN_DATE , value = "退库日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.USER_ORGANIZATION_ID , value = "退库使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.POSITION_ID , value = "退库后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.CONTENT , value = "退库说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetReturnVOMeta.PAGE_INDEX , AssetReturnVOMeta.PAGE_SIZE , AssetReturnVOMeta.SEARCH_FIELD , AssetReturnVOMeta.FUZZY_FIELD , AssetReturnVOMeta.SEARCH_VALUE , AssetReturnVOMeta.SORT_FIELD , AssetReturnVOMeta.SORT_TYPE , AssetReturnVOMeta.IDS } )
	@NotNull(name = AssetReturnVOMeta.ID)
	@NotNull(name = AssetReturnVOMeta.NAME)
	@SentinelResource(value = AssetReturnServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetReturnServiceProxy.SAVE)
	public Result save(AssetReturnVO assetReturnVO) {
		Result result=assetReturnService.save(assetReturnVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产退库
	*/
	@ApiOperation(value = "获取资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetReturnVOMeta.ID)
	@SentinelResource(value = AssetReturnServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetReturnServiceProxy.GET_BY_ID)
	public Result<AssetReturn> getById(String id) {
		Result<AssetReturn> result=new Result<>();
		AssetReturn assetReturn=assetReturnService.getById(id);
		result.success(true).data(assetReturn);
		return result;
	}


	/**
	 * 批量删除资产退库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产退库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetReturnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetReturnVOMeta.IDS)
		@SentinelResource(value = AssetReturnServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetReturnServiceProxy.GET_BY_IDS)
	public Result<List<AssetReturn>> getByIds(List<String> ids) {
		Result<List<AssetReturn>> result=new Result<>();
		List<AssetReturn> list=assetReturnService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产退库
	*/
	@ApiOperation(value = "查询资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.RETURN_DATE , value = "退库日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.USER_ORGANIZATION_ID , value = "退库使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.POSITION_ID , value = "退库后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.CONTENT , value = "退库说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetReturnVOMeta.PAGE_INDEX , AssetReturnVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetReturnServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetReturnServiceProxy.QUERY_LIST)
	public Result<List<AssetReturn>> queryList(AssetReturnVO sample) {
		Result<List<AssetReturn>> result=new Result<>();
		List<AssetReturn> list=assetReturnService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产退库
	*/
	@ApiOperation(value = "分页查询资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.RETURN_DATE , value = "退库日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.USER_ORGANIZATION_ID , value = "退库使用组织" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.POSITION_ID , value = "退库后位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetReturnVOMeta.CONTENT , value = "退库说明" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetReturnServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetReturnServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetReturn>> queryPagedList(AssetReturnVO sample) {
		Result<PagedList<AssetReturn>> result=new Result<>();
		PagedList<AssetReturn> list=assetReturnService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetReturnServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetReturnServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetReturnVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetReturnService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetReturnServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetReturnServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetReturnService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetReturnServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetReturnServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetReturnService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}