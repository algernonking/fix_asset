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


import com.dt.platform.proxy.eam.ResidualStrategyServiceProxy;
import com.dt.platform.domain.eam.meta.ResidualStrategyVOMeta;
import com.dt.platform.domain.eam.ResidualStrategy;
import com.dt.platform.domain.eam.ResidualStrategyVO;
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
import com.dt.platform.domain.eam.meta.ResidualStrategyMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IResidualStrategyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 折旧策略 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-18 14:02:01
*/

@Api(tags = "折旧策略")
@ApiSort(0)
@RestController("EamResidualStrategyController")
public class ResidualStrategyController extends SuperController {

	@Autowired
	private IResidualStrategyService residualStrategyService;

	
	/**
	 * 添加折旧策略
	*/
	@ApiOperation(value = "添加折旧策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResidualStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "477868649709830144"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "平均折旧"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.STRATEGY_DESCRIBE , value = "策略描述" , required = false , dataTypeClass=String.class , example = "平均折旧"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.RESIDUALVALUE_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.DEPRECIATION_RATE , value = "折旧率" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.VALUE , value = "设置值" , required = false , dataTypeClass=String.class , example = "4"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "平均折旧"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ResidualStrategyVOMeta.ID)
	@SentinelResource(value = ResidualStrategyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResidualStrategyServiceProxy.INSERT)
	public Result insert(ResidualStrategyVO residualStrategyVO) {
		Result result=residualStrategyService.insert(residualStrategyVO);
		return result;
	}

	
	/**
	 * 删除折旧策略
	*/
	@ApiOperation(value = "删除折旧策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResidualStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "477868649709830144")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ResidualStrategyVOMeta.ID)
	@SentinelResource(value = ResidualStrategyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResidualStrategyServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=residualStrategyService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除折旧策略 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除折旧策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResidualStrategyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ResidualStrategyVOMeta.IDS)
	@SentinelResource(value = ResidualStrategyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResidualStrategyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=residualStrategyService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新折旧策略
	*/
	@ApiOperation(value = "更新折旧策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResidualStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "477868649709830144"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "平均折旧"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.STRATEGY_DESCRIBE , value = "策略描述" , required = false , dataTypeClass=String.class , example = "平均折旧"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.RESIDUALVALUE_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.DEPRECIATION_RATE , value = "折旧率" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.VALUE , value = "设置值" , required = false , dataTypeClass=String.class , example = "4"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "平均折旧"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ResidualStrategyVOMeta.PAGE_INDEX , ResidualStrategyVOMeta.PAGE_SIZE , ResidualStrategyVOMeta.SEARCH_FIELD , ResidualStrategyVOMeta.FUZZY_FIELD , ResidualStrategyVOMeta.SEARCH_VALUE , ResidualStrategyVOMeta.SORT_FIELD , ResidualStrategyVOMeta.SORT_TYPE , ResidualStrategyVOMeta.IDS } ) 
	@NotNull(name = ResidualStrategyVOMeta.ID)
	@SentinelResource(value = ResidualStrategyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResidualStrategyServiceProxy.UPDATE)
	public Result update(ResidualStrategyVO residualStrategyVO) {
		Result result=residualStrategyService.update(residualStrategyVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存折旧策略
	*/
	@ApiOperation(value = "保存折旧策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResidualStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "477868649709830144"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "平均折旧"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.STRATEGY_DESCRIBE , value = "策略描述" , required = false , dataTypeClass=String.class , example = "平均折旧"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.RESIDUALVALUE_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.DEPRECIATION_RATE , value = "折旧率" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.VALUE , value = "设置值" , required = false , dataTypeClass=String.class , example = "4"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "平均折旧"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ResidualStrategyVOMeta.PAGE_INDEX , ResidualStrategyVOMeta.PAGE_SIZE , ResidualStrategyVOMeta.SEARCH_FIELD , ResidualStrategyVOMeta.FUZZY_FIELD , ResidualStrategyVOMeta.SEARCH_VALUE , ResidualStrategyVOMeta.SORT_FIELD , ResidualStrategyVOMeta.SORT_TYPE , ResidualStrategyVOMeta.IDS } )
	@NotNull(name = ResidualStrategyVOMeta.ID)
	@SentinelResource(value = ResidualStrategyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResidualStrategyServiceProxy.SAVE)
	public Result save(ResidualStrategyVO residualStrategyVO) {
		Result result=residualStrategyService.save(residualStrategyVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取折旧策略
	*/
	@ApiOperation(value = "获取折旧策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResidualStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ResidualStrategyVOMeta.ID)
	@SentinelResource(value = ResidualStrategyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResidualStrategyServiceProxy.GET_BY_ID)
	public Result<ResidualStrategy> getById(String id) {
		Result<ResidualStrategy> result=new Result<>();
		ResidualStrategy residualStrategy=residualStrategyService.getById(id);
		result.success(true).data(residualStrategy);
		return result;
	}


	/**
	 * 批量删除折旧策略 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除折旧策略")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ResidualStrategyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ResidualStrategyVOMeta.IDS)
		@SentinelResource(value = ResidualStrategyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResidualStrategyServiceProxy.GET_BY_IDS)
	public Result<List<ResidualStrategy>> getByIds(List<String> ids) {
		Result<List<ResidualStrategy>> result=new Result<>();
		List<ResidualStrategy> list=residualStrategyService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询折旧策略
	*/
	@ApiOperation(value = "查询折旧策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResidualStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "477868649709830144"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "平均折旧"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.STRATEGY_DESCRIBE , value = "策略描述" , required = false , dataTypeClass=String.class , example = "平均折旧"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.RESIDUALVALUE_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.DEPRECIATION_RATE , value = "折旧率" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.VALUE , value = "设置值" , required = false , dataTypeClass=String.class , example = "4"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "平均折旧"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ResidualStrategyVOMeta.PAGE_INDEX , ResidualStrategyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ResidualStrategyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResidualStrategyServiceProxy.QUERY_LIST)
	public Result<List<ResidualStrategy>> queryList(ResidualStrategyVO sample) {
		Result<List<ResidualStrategy>> result=new Result<>();
		List<ResidualStrategy> list=residualStrategyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询折旧策略
	*/
	@ApiOperation(value = "分页查询折旧策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ResidualStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "477868649709830144"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "平均折旧"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.STRATEGY_DESCRIBE , value = "策略描述" , required = false , dataTypeClass=String.class , example = "平均折旧"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.RESIDUALVALUE_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.DEPRECIATION_RATE , value = "折旧率" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.VALUE , value = "设置值" , required = false , dataTypeClass=String.class , example = "4"),
		@ApiImplicitParam(name = ResidualStrategyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "平均折旧"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ResidualStrategyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ResidualStrategyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ResidualStrategy>> queryPagedList(ResidualStrategyVO sample) {
		Result<PagedList<ResidualStrategy>> result=new Result<>();
		PagedList<ResidualStrategy> list=residualStrategyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ResidualStrategyServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ResidualStrategyServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ResidualStrategyVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=residualStrategyService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ResidualStrategyServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ResidualStrategyServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=residualStrategyService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ResidualStrategyServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ResidualStrategyServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=residualStrategyService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}