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


import com.dt.platform.proxy.eam.SafetylevelServiceProxy;
import com.dt.platform.domain.eam.meta.SafetylevelVOMeta;
import com.dt.platform.domain.eam.Safetylevel;
import com.dt.platform.domain.eam.SafetylevelVO;
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
import com.dt.platform.domain.eam.meta.SafetylevelMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ISafetylevelService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 风险等级表 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-14 16:47:34
*/

@Api(tags = "风险等级")
@ApiSort(0)
@RestController("EamSafetylevelController")
public class SafetylevelController extends SuperController {

	@Autowired
	private ISafetylevelService safetylevelService;

	
	/**
	 * 添加风险等级
	*/
	@ApiOperation(value = "添加风险等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SafetylevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669964785319936"),
		@ApiImplicitParam(name = SafetylevelVOMeta.SAFETY_CODE , value = "风险等级编码" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = SafetylevelVOMeta.SAFETY_NAME , value = "风险等级" , required = false , dataTypeClass=String.class , example = "2级"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = SafetylevelVOMeta.ID)
	@SentinelResource(value = SafetylevelServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SafetylevelServiceProxy.INSERT)
	public Result insert(SafetylevelVO safetylevelVO) {
		Result result=safetylevelService.insert(safetylevelVO);
		return result;
	}

	
	/**
	 * 删除风险等级
	*/
	@ApiOperation(value = "删除风险等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SafetylevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669964785319936")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = SafetylevelVOMeta.ID)
	@SentinelResource(value = SafetylevelServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SafetylevelServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=safetylevelService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除风险等级 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除风险等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SafetylevelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = SafetylevelVOMeta.IDS)
	@SentinelResource(value = SafetylevelServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SafetylevelServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=safetylevelService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新风险等级
	*/
	@ApiOperation(value = "更新风险等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SafetylevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669964785319936"),
		@ApiImplicitParam(name = SafetylevelVOMeta.SAFETY_CODE , value = "风险等级编码" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = SafetylevelVOMeta.SAFETY_NAME , value = "风险等级" , required = false , dataTypeClass=String.class , example = "2级"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { SafetylevelVOMeta.PAGE_INDEX , SafetylevelVOMeta.PAGE_SIZE , SafetylevelVOMeta.SEARCH_FIELD , SafetylevelVOMeta.FUZZY_FIELD , SafetylevelVOMeta.SEARCH_VALUE , SafetylevelVOMeta.SORT_FIELD , SafetylevelVOMeta.SORT_TYPE , SafetylevelVOMeta.IDS } ) 
	@NotNull(name = SafetylevelVOMeta.ID)
	@SentinelResource(value = SafetylevelServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SafetylevelServiceProxy.UPDATE)
	public Result update(SafetylevelVO safetylevelVO) {
		Result result=safetylevelService.update(safetylevelVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存风险等级
	*/
	@ApiOperation(value = "保存风险等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SafetylevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669964785319936"),
		@ApiImplicitParam(name = SafetylevelVOMeta.SAFETY_CODE , value = "风险等级编码" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = SafetylevelVOMeta.SAFETY_NAME , value = "风险等级" , required = false , dataTypeClass=String.class , example = "2级"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SafetylevelVOMeta.PAGE_INDEX , SafetylevelVOMeta.PAGE_SIZE , SafetylevelVOMeta.SEARCH_FIELD , SafetylevelVOMeta.FUZZY_FIELD , SafetylevelVOMeta.SEARCH_VALUE , SafetylevelVOMeta.SORT_FIELD , SafetylevelVOMeta.SORT_TYPE , SafetylevelVOMeta.IDS } )
	@NotNull(name = SafetylevelVOMeta.ID)
	@SentinelResource(value = SafetylevelServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SafetylevelServiceProxy.SAVE)
	public Result save(SafetylevelVO safetylevelVO) {
		Result result=safetylevelService.save(safetylevelVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取风险等级
	*/
	@ApiOperation(value = "获取风险等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SafetylevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = SafetylevelVOMeta.ID)
	@SentinelResource(value = SafetylevelServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SafetylevelServiceProxy.GET_BY_ID)
	public Result<Safetylevel> getById(String id) {
		Result<Safetylevel> result=new Result<>();
		Safetylevel safetylevel=safetylevelService.getById(id);
		result.success(true).data(safetylevel);
		return result;
	}


	/**
	 * 批量删除风险等级 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除风险等级")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SafetylevelVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = SafetylevelVOMeta.IDS)
		@SentinelResource(value = SafetylevelServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SafetylevelServiceProxy.GET_BY_IDS)
	public Result<List<Safetylevel>> getByIds(List<String> ids) {
		Result<List<Safetylevel>> result=new Result<>();
		List<Safetylevel> list=safetylevelService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询风险等级
	*/
	@ApiOperation(value = "查询风险等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SafetylevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669964785319936"),
		@ApiImplicitParam(name = SafetylevelVOMeta.SAFETY_CODE , value = "风险等级编码" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = SafetylevelVOMeta.SAFETY_NAME , value = "风险等级" , required = false , dataTypeClass=String.class , example = "2级"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SafetylevelVOMeta.PAGE_INDEX , SafetylevelVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SafetylevelServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SafetylevelServiceProxy.QUERY_LIST)
	public Result<List<Safetylevel>> queryList(SafetylevelVO sample) {
		Result<List<Safetylevel>> result=new Result<>();
		List<Safetylevel> list=safetylevelService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询风险等级
	*/
	@ApiOperation(value = "分页查询风险等级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SafetylevelVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471669964785319936"),
		@ApiImplicitParam(name = SafetylevelVOMeta.SAFETY_CODE , value = "风险等级编码" , required = false , dataTypeClass=String.class , example = "2"),
		@ApiImplicitParam(name = SafetylevelVOMeta.SAFETY_NAME , value = "风险等级" , required = false , dataTypeClass=String.class , example = "2级"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = SafetylevelServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SafetylevelServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Safetylevel>> queryPagedList(SafetylevelVO sample) {
		Result<PagedList<Safetylevel>> result=new Result<>();
		PagedList<Safetylevel> list=safetylevelService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = SafetylevelServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SafetylevelServiceProxy.EXPORT_EXCEL)
	public void exportExcel(SafetylevelVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=safetylevelService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = SafetylevelServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SafetylevelServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=safetylevelService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = SafetylevelServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(SafetylevelServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=safetylevelService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}