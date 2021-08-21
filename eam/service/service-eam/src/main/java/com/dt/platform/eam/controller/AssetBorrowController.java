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


import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.dt.platform.domain.eam.meta.AssetBorrowVOMeta;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.domain.eam.AssetBorrowVO;
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
import com.dt.platform.domain.eam.meta.AssetBorrowMeta;
import com.dt.platform.domain.eam.Asset;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetBorrowService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产借用 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-21 19:03:40
*/

@Api(tags = "资产借用")
@ApiSort(0)
@RestController("EamAssetBorrowController")
public class AssetBorrowController extends SuperController {

	@Autowired
	private IAssetBorrowService assetBorrowService;

	
	/**
	 * 添加资产借用
	*/
	@ApiOperation(value = "添加资产借用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667504641847296"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BORROWER_ID , value = "借用人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BORROW_TIME , value = "借出时间" , required = false , dataTypeClass=Date.class , example = "2021-08-14 12:00:00"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.PLAN_RETURN_DATE , value = "预计归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.CONTENT , value = "借出说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetBorrowVOMeta.ID)
	@NotNull(name = AssetBorrowVOMeta.NAME)
	@SentinelResource(value = AssetBorrowServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowServiceProxy.INSERT)
	public Result insert(AssetBorrowVO assetBorrowVO) {
		Result result=assetBorrowService.insert(assetBorrowVO);
		return result;
	}

	
	/**
	 * 删除资产借用
	*/
	@ApiOperation(value = "删除资产借用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667504641847296")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetBorrowVOMeta.ID)
	@SentinelResource(value = AssetBorrowServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetBorrowService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产借用 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产借用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetBorrowVOMeta.IDS)
	@SentinelResource(value = AssetBorrowServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetBorrowService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产借用
	*/
	@ApiOperation(value = "更新资产借用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667504641847296"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BORROWER_ID , value = "借用人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BORROW_TIME , value = "借出时间" , required = false , dataTypeClass=Date.class , example = "2021-08-14 12:00:00"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.PLAN_RETURN_DATE , value = "预计归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.CONTENT , value = "借出说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetBorrowVOMeta.PAGE_INDEX , AssetBorrowVOMeta.PAGE_SIZE , AssetBorrowVOMeta.SEARCH_FIELD , AssetBorrowVOMeta.FUZZY_FIELD , AssetBorrowVOMeta.SEARCH_VALUE , AssetBorrowVOMeta.SORT_FIELD , AssetBorrowVOMeta.SORT_TYPE , AssetBorrowVOMeta.IDS } ) 
	@NotNull(name = AssetBorrowVOMeta.ID)
	@NotNull(name = AssetBorrowVOMeta.NAME)
	@SentinelResource(value = AssetBorrowServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowServiceProxy.UPDATE)
	public Result update(AssetBorrowVO assetBorrowVO) {
		Result result=assetBorrowService.update(assetBorrowVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产借用
	*/
	@ApiOperation(value = "保存资产借用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667504641847296"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BORROWER_ID , value = "借用人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BORROW_TIME , value = "借出时间" , required = false , dataTypeClass=Date.class , example = "2021-08-14 12:00:00"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.PLAN_RETURN_DATE , value = "预计归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.CONTENT , value = "借出说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetBorrowVOMeta.PAGE_INDEX , AssetBorrowVOMeta.PAGE_SIZE , AssetBorrowVOMeta.SEARCH_FIELD , AssetBorrowVOMeta.FUZZY_FIELD , AssetBorrowVOMeta.SEARCH_VALUE , AssetBorrowVOMeta.SORT_FIELD , AssetBorrowVOMeta.SORT_TYPE , AssetBorrowVOMeta.IDS } )
	@NotNull(name = AssetBorrowVOMeta.ID)
	@NotNull(name = AssetBorrowVOMeta.NAME)
	@SentinelResource(value = AssetBorrowServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowServiceProxy.SAVE)
	public Result save(AssetBorrowVO assetBorrowVO) {
		Result result=assetBorrowService.save(assetBorrowVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产借用
	*/
	@ApiOperation(value = "获取资产借用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetBorrowVOMeta.ID)
	@SentinelResource(value = AssetBorrowServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowServiceProxy.GET_BY_ID)
	public Result<AssetBorrow> getById(String id) {
		Result<AssetBorrow> result=new Result<>();
		AssetBorrow assetBorrow=assetBorrowService.getById(id);
		result.success(true).data(assetBorrow);
		return result;
	}


	/**
	 * 批量删除资产借用 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产借用")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetBorrowVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetBorrowVOMeta.IDS)
		@SentinelResource(value = AssetBorrowServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowServiceProxy.GET_BY_IDS)
	public Result<List<AssetBorrow>> getByIds(List<String> ids) {
		Result<List<AssetBorrow>> result=new Result<>();
		List<AssetBorrow> list=assetBorrowService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产借用
	*/
	@ApiOperation(value = "查询资产借用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667504641847296"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BORROWER_ID , value = "借用人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BORROW_TIME , value = "借出时间" , required = false , dataTypeClass=Date.class , example = "2021-08-14 12:00:00"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.PLAN_RETURN_DATE , value = "预计归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.CONTENT , value = "借出说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetBorrowVOMeta.PAGE_INDEX , AssetBorrowVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetBorrowServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowServiceProxy.QUERY_LIST)
	public Result<List<AssetBorrow>> queryList(AssetBorrowVO sample) {
		Result<List<AssetBorrow>> result=new Result<>();
		List<AssetBorrow> list=assetBorrowService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产借用
	*/
	@ApiOperation(value = "分页查询资产借用")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetBorrowVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667504641847296"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BORROWER_ID , value = "借用人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BORROW_TIME , value = "借出时间" , required = false , dataTypeClass=Date.class , example = "2021-08-14 12:00:00"),
		@ApiImplicitParam(name = AssetBorrowVOMeta.PLAN_RETURN_DATE , value = "预计归还时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.CONTENT , value = "借出说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetBorrowVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetBorrowServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetBorrowServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetBorrow>> queryPagedList(AssetBorrowVO sample) {
		Result<PagedList<AssetBorrow>> result=new Result<>();
		PagedList<AssetBorrow> list=assetBorrowService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetBorrowServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetBorrowServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetBorrowVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetBorrowService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetBorrowServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetBorrowServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetBorrowService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetBorrowServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetBorrowServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetBorrowService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}