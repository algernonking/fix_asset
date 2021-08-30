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


import com.dt.platform.proxy.eam.AssetScrapServiceProxy;
import com.dt.platform.domain.eam.meta.AssetScrapVOMeta;
import com.dt.platform.domain.eam.AssetScrap;
import com.dt.platform.domain.eam.AssetScrapVO;
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
import com.dt.platform.domain.eam.meta.AssetScrapMeta;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Person;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetScrapService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产报废 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-29 12:15:15
*/

@Api(tags = "资产报废")
@ApiSort(0)
@RestController("EamAssetScrapController")
public class AssetScrapController extends SuperController {

	@Autowired
	private IAssetScrapService assetScrapService;

	
	/**
	 * 添加资产报废
	*/
	@ApiOperation(value = "添加资产报废")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScrapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.SCRAP_DATE , value = "报废时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.CONTENT , value = "报废说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.CLEAN_STATUS , value = "是否清理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetScrapVOMeta.ID)
	@NotNull(name = AssetScrapVOMeta.NAME)
	@SentinelResource(value = AssetScrapServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScrapServiceProxy.INSERT)
	public Result insert(AssetScrapVO assetScrapVO) {
		Result result=assetScrapService.insert(assetScrapVO);
		return result;
	}

	
	/**
	 * 删除资产报废
	*/
	@ApiOperation(value = "删除资产报废")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScrapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetScrapVOMeta.ID)
	@SentinelResource(value = AssetScrapServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScrapServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetScrapService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产报废 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产报废")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScrapVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetScrapVOMeta.IDS)
	@SentinelResource(value = AssetScrapServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScrapServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetScrapService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产报废
	*/
	@ApiOperation(value = "更新资产报废")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScrapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.SCRAP_DATE , value = "报废时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.CONTENT , value = "报废说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.CLEAN_STATUS , value = "是否清理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetScrapVOMeta.PAGE_INDEX , AssetScrapVOMeta.PAGE_SIZE , AssetScrapVOMeta.SEARCH_FIELD , AssetScrapVOMeta.FUZZY_FIELD , AssetScrapVOMeta.SEARCH_VALUE , AssetScrapVOMeta.SORT_FIELD , AssetScrapVOMeta.SORT_TYPE , AssetScrapVOMeta.IDS } ) 
	@NotNull(name = AssetScrapVOMeta.ID)
	@NotNull(name = AssetScrapVOMeta.NAME)
	@SentinelResource(value = AssetScrapServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScrapServiceProxy.UPDATE)
	public Result update(AssetScrapVO assetScrapVO) {
		Result result=assetScrapService.update(assetScrapVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产报废
	*/
	@ApiOperation(value = "保存资产报废")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScrapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.SCRAP_DATE , value = "报废时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.CONTENT , value = "报废说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.CLEAN_STATUS , value = "是否清理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetScrapVOMeta.PAGE_INDEX , AssetScrapVOMeta.PAGE_SIZE , AssetScrapVOMeta.SEARCH_FIELD , AssetScrapVOMeta.FUZZY_FIELD , AssetScrapVOMeta.SEARCH_VALUE , AssetScrapVOMeta.SORT_FIELD , AssetScrapVOMeta.SORT_TYPE , AssetScrapVOMeta.IDS } )
	@NotNull(name = AssetScrapVOMeta.ID)
	@NotNull(name = AssetScrapVOMeta.NAME)
	@SentinelResource(value = AssetScrapServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScrapServiceProxy.SAVE)
	public Result save(AssetScrapVO assetScrapVO) {
		Result result=assetScrapService.save(assetScrapVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产报废
	*/
	@ApiOperation(value = "获取资产报废")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScrapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetScrapVOMeta.ID)
	@SentinelResource(value = AssetScrapServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScrapServiceProxy.GET_BY_ID)
	public Result<AssetScrap> getById(String id) {
		Result<AssetScrap> result=new Result<>();
		AssetScrap assetScrap=assetScrapService.getById(id);
		result.success(true).data(assetScrap);
		return result;
	}


	/**
	 * 批量删除资产报废 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产报废")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetScrapVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetScrapVOMeta.IDS)
		@SentinelResource(value = AssetScrapServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScrapServiceProxy.GET_BY_IDS)
	public Result<List<AssetScrap>> getByIds(List<String> ids) {
		Result<List<AssetScrap>> result=new Result<>();
		List<AssetScrap> list=assetScrapService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产报废
	*/
	@ApiOperation(value = "查询资产报废")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScrapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.SCRAP_DATE , value = "报废时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.CONTENT , value = "报废说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.CLEAN_STATUS , value = "是否清理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetScrapVOMeta.PAGE_INDEX , AssetScrapVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetScrapServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScrapServiceProxy.QUERY_LIST)
	public Result<List<AssetScrap>> queryList(AssetScrapVO sample) {
		Result<List<AssetScrap>> result=new Result<>();
		List<AssetScrap> list=assetScrapService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产报废
	*/
	@ApiOperation(value = "分页查询资产报废")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetScrapVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.SCRAP_DATE , value = "报废时间" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.CONTENT , value = "报废说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.CLEAN_STATUS , value = "是否清理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetScrapVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetScrapServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetScrapServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetScrap>> queryPagedList(AssetScrapVO sample) {
		Result<PagedList<AssetScrap>> result=new Result<>();
		PagedList<AssetScrap> list=assetScrapService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetScrapServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetScrapServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetScrapVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetScrapService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetScrapServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetScrapServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetScrapService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetScrapServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetScrapServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetScrapService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}