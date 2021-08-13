package com.dt.platform.ops.controller;

 
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


import com.dt.platform.proxy.ops.ServiceDetailServiceProxy;
import com.dt.platform.domain.ops.meta.ServiceDetailVOMeta;
import com.dt.platform.domain.ops.ServiceDetail;
import com.dt.platform.domain.ops.ServiceDetailVO;
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
import com.dt.platform.domain.ops.meta.ServiceDetailMeta;
import com.dt.platform.domain.ops.OpsService;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IServiceDetailService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 服务明细 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-13 10:07:07
*/

@Api(tags = "服务明细")
@ApiSort(0)
@RestController("OpsServiceDetailController")
public class ServiceDetailController extends SuperController {

	@Autowired
	private IServiceDetailService serviceDetailService;

	
	/**
	 * 添加服务明细
	*/
	@ApiOperation(value = "添加服务明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.SERVICE_ID , value = "服务ID" , required = false , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "11.2.0.4"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.PATCH , value = "补丁" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServiceDetailVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ServiceDetailVOMeta.ID)
	@SentinelResource(value = ServiceDetailServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceDetailServiceProxy.INSERT)
	public Result insert(ServiceDetailVO serviceDetailVO) {
		Result result=serviceDetailService.insert(serviceDetailVO);
		return result;
	}

	
	/**
	 * 删除服务明细
	*/
	@ApiOperation(value = "删除服务明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ServiceDetailVOMeta.ID)
	@SentinelResource(value = ServiceDetailServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceDetailServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=serviceDetailService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除服务明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除服务明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ServiceDetailVOMeta.IDS)
	@SentinelResource(value = ServiceDetailServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceDetailServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=serviceDetailService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新服务明细
	*/
	@ApiOperation(value = "更新服务明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.SERVICE_ID , value = "服务ID" , required = false , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "11.2.0.4"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.PATCH , value = "补丁" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServiceDetailVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ServiceDetailVOMeta.PAGE_INDEX , ServiceDetailVOMeta.PAGE_SIZE , ServiceDetailVOMeta.SEARCH_FIELD , ServiceDetailVOMeta.FUZZY_FIELD , ServiceDetailVOMeta.SEARCH_VALUE , ServiceDetailVOMeta.SORT_FIELD , ServiceDetailVOMeta.SORT_TYPE , ServiceDetailVOMeta.IDS } ) 
	@NotNull(name = ServiceDetailVOMeta.ID)
	@SentinelResource(value = ServiceDetailServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceDetailServiceProxy.UPDATE)
	public Result update(ServiceDetailVO serviceDetailVO) {
		Result result=serviceDetailService.update(serviceDetailVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存服务明细
	*/
	@ApiOperation(value = "保存服务明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.SERVICE_ID , value = "服务ID" , required = false , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "11.2.0.4"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.PATCH , value = "补丁" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServiceDetailVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServiceDetailVOMeta.PAGE_INDEX , ServiceDetailVOMeta.PAGE_SIZE , ServiceDetailVOMeta.SEARCH_FIELD , ServiceDetailVOMeta.FUZZY_FIELD , ServiceDetailVOMeta.SEARCH_VALUE , ServiceDetailVOMeta.SORT_FIELD , ServiceDetailVOMeta.SORT_TYPE , ServiceDetailVOMeta.IDS } )
	@NotNull(name = ServiceDetailVOMeta.ID)
	@SentinelResource(value = ServiceDetailServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceDetailServiceProxy.SAVE)
	public Result save(ServiceDetailVO serviceDetailVO) {
		Result result=serviceDetailService.save(serviceDetailVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取服务明细
	*/
	@ApiOperation(value = "获取服务明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ServiceDetailVOMeta.ID)
	@SentinelResource(value = ServiceDetailServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceDetailServiceProxy.GET_BY_ID)
	public Result<ServiceDetail> getById(String id) {
		Result<ServiceDetail> result=new Result<>();
		ServiceDetail serviceDetail=serviceDetailService.getById(id);
		// 关联出 服务 数据
		serviceDetailService.join(serviceDetail,ServiceDetailMeta.OPS_SERVICE);
		result.success(true).data(serviceDetail);
		return result;
	}


	/**
	 * 批量删除服务明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除服务明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ServiceDetailVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ServiceDetailVOMeta.IDS)
		@SentinelResource(value = ServiceDetailServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceDetailServiceProxy.GET_BY_IDS)
	public Result<List<ServiceDetail>> getByIds(List<String> ids) {
		Result<List<ServiceDetail>> result=new Result<>();
		List<ServiceDetail> list=serviceDetailService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询服务明细
	*/
	@ApiOperation(value = "查询服务明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.SERVICE_ID , value = "服务ID" , required = false , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "11.2.0.4"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.PATCH , value = "补丁" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServiceDetailVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ServiceDetailVOMeta.PAGE_INDEX , ServiceDetailVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ServiceDetailServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceDetailServiceProxy.QUERY_LIST)
	public Result<List<ServiceDetail>> queryList(ServiceDetailVO sample) {
		Result<List<ServiceDetail>> result=new Result<>();
		List<ServiceDetail> list=serviceDetailService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询服务明细
	*/
	@ApiOperation(value = "分页查询服务明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ServiceDetailVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "473626925345013760"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.SERVICE_ID , value = "服务ID" , required = false , dataTypeClass=String.class , example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "11.2.0.4"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.PATCH , value = "补丁" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = ServiceDetailVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ServiceDetailVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ServiceDetailServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ServiceDetailServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ServiceDetail>> queryPagedList(ServiceDetailVO sample) {
		Result<PagedList<ServiceDetail>> result=new Result<>();
		PagedList<ServiceDetail> list=serviceDetailService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 服务 数据
		serviceDetailService.join(list,ServiceDetailMeta.OPS_SERVICE);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ServiceDetailServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceDetailServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ServiceDetailVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=serviceDetailService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ServiceDetailServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceDetailServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=serviceDetailService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ServiceDetailServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ServiceDetailServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=serviceDetailService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}