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


import com.dt.platform.proxy.eam.PositionServiceProxy;
import com.dt.platform.domain.eam.meta.PositionVOMeta;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.PositionVO;
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
import com.dt.platform.domain.eam.meta.PositionMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IPositionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 存放位置 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-18 14:34:25
*/

@Api(tags = "存放位置")
@ApiSort(0)
@RestController("EamPositionController")
public class PositionController extends SuperController {

	@Autowired
	private IPositionService positionService;

	
	/**
	 * 添加存放位置
	*/
	@ApiOperation(value = "添加存放位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024500020445184"),
		@ApiImplicitParam(name = PositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "区域1"),
		@ApiImplicitParam(name = PositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = PositionVOMeta.ID)
	@SentinelResource(value = PositionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.INSERT)
	public Result insert(PositionVO positionVO) {
		Result result=positionService.insert(positionVO);
		return result;
	}

	
	/**
	 * 删除存放位置
	*/
	@ApiOperation(value = "删除存放位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024500020445184")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = PositionVOMeta.ID)
	@SentinelResource(value = PositionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=positionService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除存放位置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除存放位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = PositionVOMeta.IDS)
	@SentinelResource(value = PositionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=positionService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新存放位置
	*/
	@ApiOperation(value = "更新存放位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024500020445184"),
		@ApiImplicitParam(name = PositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "区域1"),
		@ApiImplicitParam(name = PositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { PositionVOMeta.PAGE_INDEX , PositionVOMeta.PAGE_SIZE , PositionVOMeta.SEARCH_FIELD , PositionVOMeta.FUZZY_FIELD , PositionVOMeta.SEARCH_VALUE , PositionVOMeta.SORT_FIELD , PositionVOMeta.SORT_TYPE , PositionVOMeta.IDS } ) 
	@NotNull(name = PositionVOMeta.ID)
	@SentinelResource(value = PositionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.UPDATE)
	public Result update(PositionVO positionVO) {
		Result result=positionService.update(positionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存存放位置
	*/
	@ApiOperation(value = "保存存放位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024500020445184"),
		@ApiImplicitParam(name = PositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "区域1"),
		@ApiImplicitParam(name = PositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PositionVOMeta.PAGE_INDEX , PositionVOMeta.PAGE_SIZE , PositionVOMeta.SEARCH_FIELD , PositionVOMeta.FUZZY_FIELD , PositionVOMeta.SEARCH_VALUE , PositionVOMeta.SORT_FIELD , PositionVOMeta.SORT_TYPE , PositionVOMeta.IDS } )
	@NotNull(name = PositionVOMeta.ID)
	@SentinelResource(value = PositionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.SAVE)
	public Result save(PositionVO positionVO) {
		Result result=positionService.save(positionVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取存放位置
	*/
	@ApiOperation(value = "获取存放位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = PositionVOMeta.ID)
	@SentinelResource(value = PositionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.GET_BY_ID)
	public Result<Position> getById(String id) {
		Result<Position> result=new Result<>();
		Position position=positionService.getById(id);
		result.success(true).data(position);
		return result;
	}


	/**
	 * 批量删除存放位置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除存放位置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PositionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = PositionVOMeta.IDS)
		@SentinelResource(value = PositionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.GET_BY_IDS)
	public Result<List<Position>> getByIds(List<String> ids) {
		Result<List<Position>> result=new Result<>();
		List<Position> list=positionService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询存放位置
	*/
	@ApiOperation(value = "查询存放位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024500020445184"),
		@ApiImplicitParam(name = PositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "区域1"),
		@ApiImplicitParam(name = PositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PositionVOMeta.PAGE_INDEX , PositionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PositionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.QUERY_LIST)
	public Result<List<Position>> queryList(PositionVO sample) {
		Result<List<Position>> result=new Result<>();
		List<Position> list=positionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询存放位置
	*/
	@ApiOperation(value = "分页查询存放位置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PositionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "472024500020445184"),
		@ApiImplicitParam(name = PositionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "区域1"),
		@ApiImplicitParam(name = PositionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = PositionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PositionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Position>> queryPagedList(PositionVO sample) {
		Result<PagedList<Position>> result=new Result<>();
		PagedList<Position> list=positionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = PositionServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PositionServiceProxy.EXPORT_EXCEL)
	public void exportExcel(PositionVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=positionService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = PositionServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PositionServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=positionService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = PositionServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(PositionServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=positionService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}