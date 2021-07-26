package com.dt.platform.datacenter.controller;

 
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.datacenter.service.IDcInfoService;
import com.dt.platform.domain.datacenter.DcInfo;
import com.dt.platform.domain.datacenter.DcInfoVO;
import com.dt.platform.domain.datacenter.meta.DcInfoVOMeta;
import com.dt.platform.proxy.datacenter.DcInfoServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据中心 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-26 15:14:29
*/

@Api(tags = "数据中心")
@ApiSort(0)
@RestController("DcInfoController")
public class DcInfoController extends SuperController {

	@Autowired
	private IDcInfoService dcInfoService;

	
	/**
	 * 添加数据中心
	*/
	@ApiOperation(value = "添加数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DcInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "ww"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "22"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "2"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = DcInfoVOMeta.ID)
	@SentinelResource(value = DcInfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DcInfoServiceProxy.INSERT)
	public Result insert(DcInfoVO dcInfoVO) {
		Result result=dcInfoService.insert(dcInfoVO);
		return result;
	}

	
	/**
	 * 删除数据中心
	*/
	@ApiOperation(value = "删除数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DcInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = DcInfoVOMeta.ID)
	@SentinelResource(value = DcInfoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DcInfoServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=dcInfoService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除数据中心 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DcInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = DcInfoVOMeta.IDS)
	@SentinelResource(value = DcInfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DcInfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=dcInfoService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新数据中心
	*/
	@ApiOperation(value = "更新数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DcInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "ww"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "22"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "2"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { DcInfoVOMeta.PAGE_INDEX , DcInfoVOMeta.PAGE_SIZE , DcInfoVOMeta.SEARCH_FIELD , DcInfoVOMeta.SEARCH_VALUE , DcInfoVOMeta.SORT_FIELD , DcInfoVOMeta.SORT_TYPE , DcInfoVOMeta.IDS } ) 
	@NotNull(name = DcInfoVOMeta.ID)
	@SentinelResource(value = DcInfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DcInfoServiceProxy.UPDATE)
	public Result update(DcInfoVO dcInfoVO) {
		Result result=dcInfoService.update(dcInfoVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存数据中心
	*/
	@ApiOperation(value = "保存数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DcInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "ww"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "22"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "2"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DcInfoVOMeta.PAGE_INDEX , DcInfoVOMeta.PAGE_SIZE , DcInfoVOMeta.SEARCH_FIELD , DcInfoVOMeta.SEARCH_VALUE , DcInfoVOMeta.SORT_FIELD , DcInfoVOMeta.SORT_TYPE , DcInfoVOMeta.IDS } )
	@NotNull(name = DcInfoVOMeta.ID)
	@SentinelResource(value = DcInfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DcInfoServiceProxy.SAVE)
	public Result save(DcInfoVO dcInfoVO) {
		Result result=dcInfoService.save(dcInfoVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取数据中心
	*/
	@ApiOperation(value = "获取数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DcInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = DcInfoVOMeta.ID)
	@SentinelResource(value = DcInfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DcInfoServiceProxy.GET_BY_ID)
	public Result<DcInfo> getById(String id) {
		Result<DcInfo> result=new Result<>();
		DcInfo role=dcInfoService.getById(id);
		result.success(true).data(role);
		return result;
	}


	/**
	 * 批量删除数据中心 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除数据中心")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DcInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = DcInfoVOMeta.IDS)
		@SentinelResource(value = DcInfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DcInfoServiceProxy.GET_BY_IDS)
	public Result<List<DcInfo>> getByIds(List<String> ids) {
		Result<List<DcInfo>> result=new Result<>();
		List<DcInfo> list=dcInfoService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询数据中心
	*/
	@ApiOperation(value = "查询数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DcInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "ww"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "22"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "2"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DcInfoVOMeta.PAGE_INDEX , DcInfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DcInfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DcInfoServiceProxy.QUERY_LIST)
	public Result<List<DcInfo>> queryList(DcInfoVO sample) {
		Result<List<DcInfo>> result=new Result<>();
		List<DcInfo> list=dcInfoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询数据中心
	*/
	@ApiOperation(value = "分页查询数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DcInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "ww"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "22"),
		@ApiImplicitParam(name = DcInfoVOMeta.DC_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "2"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = DcInfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DcInfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DcInfo>> queryPagedList(DcInfoVO sample) {
		Result<PagedList<DcInfo>> result=new Result<>();
		PagedList<DcInfo> list=dcInfoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = DcInfoServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(DcInfoServiceProxy.EXPORT_EXCEL)
	public void exportExcel(DcInfoVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=dcInfoService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = DcInfoServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(DcInfoServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=dcInfoService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = DcInfoServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(DcInfoServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=dcInfoService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}