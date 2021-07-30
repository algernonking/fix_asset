package com.dt.platform.datacenter.controller;

 
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


import com.dt.platform.proxy.datacenter.RackAreaServiceProxy;
import com.dt.platform.domain.datacenter.meta.RackAreaVOMeta;
import com.dt.platform.domain.datacenter.RackArea;
import com.dt.platform.domain.datacenter.RackAreaVO;
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
import com.dt.platform.domain.datacenter.meta.RackAreaMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.datacenter.service.IRackAreaService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 机柜区域 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-30 16:39:10
*/

@Api(tags = "机柜区域")
@ApiSort(0)
@RestController("DcRackAreaController")
public class RackAreaController extends SuperController {

	@Autowired
	private IRackAreaService rackAreaService;

	
	/**
	 * 添加机柜区域
	*/
	@ApiOperation(value = "添加机柜区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackAreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.POSITION , value = "区域" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = RackAreaVOMeta.ID)
	@SentinelResource(value = RackAreaServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackAreaServiceProxy.INSERT)
	public Result insert(RackAreaVO rackAreaVO) {
		Result result=rackAreaService.insert(rackAreaVO);
		return result;
	}

	
	/**
	 * 删除机柜区域
	*/
	@ApiOperation(value = "删除机柜区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackAreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RackAreaVOMeta.ID)
	@SentinelResource(value = RackAreaServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackAreaServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=rackAreaService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除机柜区域 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除机柜区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackAreaVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RackAreaVOMeta.IDS)
	@SentinelResource(value = RackAreaServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackAreaServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=rackAreaService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新机柜区域
	*/
	@ApiOperation(value = "更新机柜区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackAreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.POSITION , value = "区域" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RackAreaVOMeta.PAGE_INDEX , RackAreaVOMeta.PAGE_SIZE , RackAreaVOMeta.SEARCH_FIELD , RackAreaVOMeta.FUZZY_FIELD , RackAreaVOMeta.SEARCH_VALUE , RackAreaVOMeta.SORT_FIELD , RackAreaVOMeta.SORT_TYPE , RackAreaVOMeta.IDS } ) 
	@NotNull(name = RackAreaVOMeta.ID)
	@SentinelResource(value = RackAreaServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackAreaServiceProxy.UPDATE)
	public Result update(RackAreaVO rackAreaVO) {
		Result result=rackAreaService.update(rackAreaVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存机柜区域
	*/
	@ApiOperation(value = "保存机柜区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackAreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.POSITION , value = "区域" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RackAreaVOMeta.PAGE_INDEX , RackAreaVOMeta.PAGE_SIZE , RackAreaVOMeta.SEARCH_FIELD , RackAreaVOMeta.FUZZY_FIELD , RackAreaVOMeta.SEARCH_VALUE , RackAreaVOMeta.SORT_FIELD , RackAreaVOMeta.SORT_TYPE , RackAreaVOMeta.IDS } )
	@NotNull(name = RackAreaVOMeta.ID)
	@SentinelResource(value = RackAreaServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackAreaServiceProxy.SAVE)
	public Result save(RackAreaVO rackAreaVO) {
		Result result=rackAreaService.save(rackAreaVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取机柜区域
	*/
	@ApiOperation(value = "获取机柜区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackAreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RackAreaVOMeta.ID)
	@SentinelResource(value = RackAreaServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackAreaServiceProxy.GET_BY_ID)
	public Result<RackArea> getById(String id) {
		Result<RackArea> result=new Result<>();
		RackArea rackArea=rackAreaService.getById(id);
		result.success(true).data(rackArea);
		return result;
	}


	/**
	 * 批量删除机柜区域 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除机柜区域")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RackAreaVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RackAreaVOMeta.IDS)
		@SentinelResource(value = RackAreaServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackAreaServiceProxy.GET_BY_IDS)
	public Result<List<RackArea>> getByIds(List<String> ids) {
		Result<List<RackArea>> result=new Result<>();
		List<RackArea> list=rackAreaService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询机柜区域
	*/
	@ApiOperation(value = "查询机柜区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackAreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.POSITION , value = "区域" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RackAreaVOMeta.PAGE_INDEX , RackAreaVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RackAreaServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackAreaServiceProxy.QUERY_LIST)
	public Result<List<RackArea>> queryList(RackAreaVO sample) {
		Result<List<RackArea>> result=new Result<>();
		List<RackArea> list=rackAreaService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询机柜区域
	*/
	@ApiOperation(value = "分页查询机柜区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackAreaVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.POSITION , value = "区域" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackAreaVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RackAreaServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackAreaServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RackArea>> queryPagedList(RackAreaVO sample) {
		Result<PagedList<RackArea>> result=new Result<>();
		PagedList<RackArea> list=rackAreaService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RackAreaServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RackAreaServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RackAreaVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=rackAreaService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RackAreaServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RackAreaServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=rackAreaService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = RackAreaServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RackAreaServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=rackAreaService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}