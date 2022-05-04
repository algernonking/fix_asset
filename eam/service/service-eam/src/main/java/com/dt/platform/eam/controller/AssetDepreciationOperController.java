package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.*;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.hrm.Person;
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


import com.dt.platform.proxy.eam.AssetDepreciationOperServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDepreciationOperVOMeta;
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
import com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDepreciationOperService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 折旧操作 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-03 14:47:45
*/

@Api(tags = "折旧操作")
@ApiSort(0)
@RestController("EamAssetDepreciationOperController")
public class AssetDepreciationOperController extends SuperController {

	@Autowired
	private IAssetDepreciationOperService assetDepreciationOperService;


	/**
	 * 添加折旧操作
	*/
	@ApiOperation(value = "添加折旧操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.CONTENT , value = "折旧内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.EXECUTION_START_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.EXECUTION_END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetDepreciationOperServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.INSERT)
	public Result insert(AssetDepreciationOperVO assetDepreciationOperVO) {
		Result result=assetDepreciationOperService.insert(assetDepreciationOperVO,false);
		return result;
	}



	/**
	 * 删除折旧操作
	*/
	@ApiOperation(value = "删除折旧操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetDepreciationOperVOMeta.ID)
	@SentinelResource(value = AssetDepreciationOperServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetDepreciationOperService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除折旧操作 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除折旧操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetDepreciationOperVOMeta.IDS)
	@SentinelResource(value = AssetDepreciationOperServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetDepreciationOperService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新折旧操作
	*/
	@ApiOperation(value = "更新折旧操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.CONTENT , value = "折旧内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.EXECUTION_START_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.EXECUTION_END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetDepreciationOperVOMeta.PAGE_INDEX , AssetDepreciationOperVOMeta.PAGE_SIZE , AssetDepreciationOperVOMeta.SEARCH_FIELD , AssetDepreciationOperVOMeta.FUZZY_FIELD , AssetDepreciationOperVOMeta.SEARCH_VALUE , AssetDepreciationOperVOMeta.DIRTY_FIELDS , AssetDepreciationOperVOMeta.SORT_FIELD , AssetDepreciationOperVOMeta.SORT_TYPE , AssetDepreciationOperVOMeta.IDS } )
	@NotNull(name = AssetDepreciationOperVOMeta.ID)
	@SentinelResource(value = AssetDepreciationOperServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.UPDATE)
	public Result update(AssetDepreciationOperVO assetDepreciationOperVO) {
		Result result=assetDepreciationOperService.update(assetDepreciationOperVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存折旧操作
	*/
	@ApiOperation(value = "保存折旧操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.CONTENT , value = "折旧内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.EXECUTION_START_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.EXECUTION_END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDepreciationOperVOMeta.PAGE_INDEX , AssetDepreciationOperVOMeta.PAGE_SIZE , AssetDepreciationOperVOMeta.SEARCH_FIELD , AssetDepreciationOperVOMeta.FUZZY_FIELD , AssetDepreciationOperVOMeta.SEARCH_VALUE , AssetDepreciationOperVOMeta.DIRTY_FIELDS , AssetDepreciationOperVOMeta.SORT_FIELD , AssetDepreciationOperVOMeta.SORT_TYPE , AssetDepreciationOperVOMeta.IDS } )
	@NotNull(name = AssetDepreciationOperVOMeta.ID)
	@SentinelResource(value = AssetDepreciationOperServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.SAVE)
	public Result save(AssetDepreciationOperVO assetDepreciationOperVO) {
		Result result=assetDepreciationOperService.save(assetDepreciationOperVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取折旧操作
	*/
	@ApiOperation(value = "获取折旧操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetDepreciationOperVOMeta.ID)
	@SentinelResource(value = AssetDepreciationOperServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.GET_BY_ID)
	public Result<AssetDepreciationOper> getById(String id) {
		Result<AssetDepreciationOper> result=new Result<>();
		AssetDepreciationOper assetDepreciationOper=assetDepreciationOperService.getById(id);
		// join 关联的对象
		assetDepreciationOperService.dao().fill(assetDepreciationOper)
			.with("originator")
			.with(AssetDepreciationOperMeta.ASSET_DEPRECIATION)
			.execute();
		result.success(true).data(assetDepreciationOper);
		return result;
	}


	/**
	 * 批量获取折旧操作 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取折旧操作")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetDepreciationOperVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetDepreciationOperVOMeta.IDS)
		@SentinelResource(value = AssetDepreciationOperServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.GET_BY_IDS)
	public Result<List<AssetDepreciationOper>> getByIds(List<String> ids) {
		Result<List<AssetDepreciationOper>> result=new Result<>();
		List<AssetDepreciationOper> list=assetDepreciationOperService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询折旧操作
	*/
	@ApiOperation(value = "查询折旧操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.CONTENT , value = "折旧内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.EXECUTION_START_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.EXECUTION_END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDepreciationOperVOMeta.PAGE_INDEX , AssetDepreciationOperVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetDepreciationOperServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.QUERY_LIST)
	public Result<List<AssetDepreciationOper>> queryList(AssetDepreciationOperVO sample) {
		Result<List<AssetDepreciationOper>> result=new Result<>();
		List<AssetDepreciationOper> list=assetDepreciationOperService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询折旧操作
	*/
	@ApiOperation(value = "分页查询折旧操作")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.CONTENT , value = "折旧内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.EXECUTION_START_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.EXECUTION_END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetDepreciationOperServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetDepreciationOper>> queryPagedList(AssetDepreciationOperVO sample) {
		Result<PagedList<AssetDepreciationOper>> result=new Result<>();
		PagedList<AssetDepreciationOper> list=assetDepreciationOperService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetDepreciationOperService.dao().fill(list)
			.with("originator")
			.with(AssetDepreciationOperMeta.ASSET_DEPRECIATION)
			.execute();
		List<Employee> originatorList= CollectorUtil.collectList(list, AssetDepreciationOper::getOriginator);
		assetDepreciationOperService.dao().join(originatorList, Person.class);

		result.success(true).data(list);
		return result;
	}



	/**
	 *
	 */
	@ApiOperation(value = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=9)
	@NotNull(name = AssetDepreciationOperVOMeta.ID)
	@SentinelResource(value = AssetDepreciationOperServiceProxy.SYNCDATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.SYNCDATA)
	public Result syncData(String id) {
		return assetDepreciationOperService.syncData(id);
	}


	/**
	 *
	 */
	@ApiOperation(value = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=10)
	@NotNull(name = AssetDepreciationOperVOMeta.ID)
	@SentinelResource(value = AssetDepreciationOperServiceProxy.ROLLBACK , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.ROLLBACK)
	public Result rollback(String id) {
		return assetDepreciationOperService.rollback(id);
	}

	/**
	 *
	 */
	@ApiOperation(value = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=11)
	@NotNull(name = AssetDepreciationOperVOMeta.ID)
	@SentinelResource(value = AssetDepreciationOperServiceProxy.START , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.START)
	public Result start(String id) {
		return assetDepreciationOperService.start(id);
	}

	/**
	 *
	 */
	@ApiOperation(value = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetDepreciationOperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=12)
	@NotNull(name = AssetDepreciationOperVOMeta.ID)
	@SentinelResource(value = AssetDepreciationOperServiceProxy.EXECUTE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationOperServiceProxy.EXECUTE)
	public Result execute(String id) {
		return assetDepreciationOperService.execute(id);
	}
	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetDepreciationOperServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationOperServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetDepreciationOperVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetDepreciationOperService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetDepreciationOperServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationOperServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetDepreciationOperService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetDepreciationOperServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetDepreciationOperServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetDepreciationOperService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}