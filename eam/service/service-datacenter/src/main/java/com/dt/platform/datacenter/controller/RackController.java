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


import com.dt.platform.proxy.datacenter.RackServiceProxy;
import com.dt.platform.domain.datacenter.meta.RackVOMeta;
import com.dt.platform.domain.datacenter.Rack;
import com.dt.platform.domain.datacenter.RackVO;
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
import com.dt.platform.domain.datacenter.meta.RackMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.datacenter.service.IRackService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 机柜 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-17 16:25:19
*/

@Api(tags = "机柜")
@ApiSort(0)
@RestController("DcRackController")
public class RackController extends SuperController {

	@Autowired
	private IRackService rackService;

	
	/**
	 * 添加机柜
	*/
	@ApiOperation(value = "添加机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473612259805888512"),
		@ApiImplicitParam(name = RackVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "473609613774684160"),
		@ApiImplicitParam(name = RackVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "473609718003138561"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "01"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "01"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CAPTICAL , value = "容量" , required = false , dataTypeClass=BigDecimal.class , example = "50.00"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackVOMeta.RACK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = RackVOMeta.ID)
	@SentinelResource(value = RackServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.INSERT)
	public Result insert(RackVO rackVO) {
		Result result=rackService.insert(rackVO);
		return result;
	}

	
	/**
	 * 删除机柜
	*/
	@ApiOperation(value = "删除机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473612259805888512")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RackVOMeta.ID)
	@SentinelResource(value = RackServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=rackService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除机柜 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RackVOMeta.IDS)
	@SentinelResource(value = RackServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=rackService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新机柜
	*/
	@ApiOperation(value = "更新机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473612259805888512"),
		@ApiImplicitParam(name = RackVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "473609613774684160"),
		@ApiImplicitParam(name = RackVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "473609718003138561"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "01"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "01"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CAPTICAL , value = "容量" , required = false , dataTypeClass=BigDecimal.class , example = "50.00"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackVOMeta.RACK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RackVOMeta.PAGE_INDEX , RackVOMeta.PAGE_SIZE , RackVOMeta.SEARCH_FIELD , RackVOMeta.FUZZY_FIELD , RackVOMeta.SEARCH_VALUE , RackVOMeta.SORT_FIELD , RackVOMeta.SORT_TYPE , RackVOMeta.IDS } ) 
	@NotNull(name = RackVOMeta.ID)
	@SentinelResource(value = RackServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.UPDATE)
	public Result update(RackVO rackVO) {
		Result result=rackService.update(rackVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存机柜
	*/
	@ApiOperation(value = "保存机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473612259805888512"),
		@ApiImplicitParam(name = RackVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "473609613774684160"),
		@ApiImplicitParam(name = RackVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "473609718003138561"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "01"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "01"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CAPTICAL , value = "容量" , required = false , dataTypeClass=BigDecimal.class , example = "50.00"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackVOMeta.RACK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RackVOMeta.PAGE_INDEX , RackVOMeta.PAGE_SIZE , RackVOMeta.SEARCH_FIELD , RackVOMeta.FUZZY_FIELD , RackVOMeta.SEARCH_VALUE , RackVOMeta.SORT_FIELD , RackVOMeta.SORT_TYPE , RackVOMeta.IDS } )
	@NotNull(name = RackVOMeta.ID)
	@SentinelResource(value = RackServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.SAVE)
	public Result save(RackVO rackVO) {
		Result result=rackService.save(rackVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取机柜
	*/
	@ApiOperation(value = "获取机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RackVOMeta.ID)
	@SentinelResource(value = RackServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.GET_BY_ID)
	public Result<Rack> getById(String id) {
		Result<Rack> result=new Result<>();
		Rack rack=rackService.getById(id);
		// 关联出 区域 数据
		rackService.join(rack,RackMeta.AREA);
		// 关联出 层级 数据
		rackService.join(rack,RackMeta.LAYER);
		result.success(true).data(rack);
		return result;
	}


	/**
	 * 批量删除机柜 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除机柜")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RackVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RackVOMeta.IDS)
		@SentinelResource(value = RackServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.GET_BY_IDS)
	public Result<List<Rack>> getByIds(List<String> ids) {
		Result<List<Rack>> result=new Result<>();
		List<Rack> list=rackService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询机柜
	*/
	@ApiOperation(value = "查询机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473612259805888512"),
		@ApiImplicitParam(name = RackVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "473609613774684160"),
		@ApiImplicitParam(name = RackVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "473609718003138561"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "01"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "01"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CAPTICAL , value = "容量" , required = false , dataTypeClass=BigDecimal.class , example = "50.00"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackVOMeta.RACK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RackVOMeta.PAGE_INDEX , RackVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RackServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.QUERY_LIST)
	public Result<List<Rack>> queryList(RackVO sample) {
		Result<List<Rack>> result=new Result<>();
		List<Rack> list=rackService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询机柜
	*/
	@ApiOperation(value = "分页查询机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473612259805888512"),
		@ApiImplicitParam(name = RackVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "473609613774684160"),
		@ApiImplicitParam(name = RackVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "473609718003138561"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "01"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "01"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CAPTICAL , value = "容量" , required = false , dataTypeClass=BigDecimal.class , example = "50.00"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackVOMeta.RACK_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RackServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Rack>> queryPagedList(RackVO sample) {
		Result<PagedList<Rack>> result=new Result<>();
		PagedList<Rack> list=rackService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 区域 数据
		rackService.join(list,RackMeta.AREA);
		// 关联出 层级 数据
		rackService.join(list,RackMeta.LAYER);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RackServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RackServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RackVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=rackService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RackServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RackServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=rackService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = RackServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RackServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=rackService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}