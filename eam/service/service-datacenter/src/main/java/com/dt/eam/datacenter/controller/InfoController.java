package com.dt.eam.datacenter.controller;

 
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.eam.datacenter.service.IInfoService;
import com.dt.eam.domain.datacenter.Info;
import com.dt.eam.domain.datacenter.InfoVO;
import com.dt.eam.domain.datacenter.meta.InfoVOMeta;
import com.dt.eam.proxy.datacenter.InfoServiceProxy;
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

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 数据中心 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-07-21 09:05:52
*/

@Api(tags = "数据中心")
@ApiSort(0)
@RestController("DcInfoController")
public class InfoController extends SuperController {

	@Autowired
	private IInfoService infoService;

	@PostConstruct
	public void start()
	{
		System.out.println("");
	}
	
	/**
	 * 添加数据中心
	*/
	@ApiOperation(value = "添加数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = InfoVOMeta.DC_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "ww"),
		@ApiImplicitParam(name = InfoVOMeta.DC_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "22"),
		@ApiImplicitParam(name = InfoVOMeta.DC_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "2"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = InfoVOMeta.ID)
	@SentinelResource(value = InfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.INSERT)
	public Result insert(InfoVO infoVO) {
		Result result=infoService.insert(infoVO);
		return result;
	}

	
	/**
	 * 删除数据中心
	*/
	@ApiOperation(value = "删除数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InfoVOMeta.ID)
	@SentinelResource(value = InfoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=infoService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除数据中心 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InfoVOMeta.IDS)
	@SentinelResource(value = InfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=infoService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新数据中心
	*/
	@ApiOperation(value = "更新数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = InfoVOMeta.DC_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "ww"),
		@ApiImplicitParam(name = InfoVOMeta.DC_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "22"),
		@ApiImplicitParam(name = InfoVOMeta.DC_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "2"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InfoVOMeta.PAGE_INDEX , InfoVOMeta.PAGE_SIZE , InfoVOMeta.SEARCH_FIELD , InfoVOMeta.SEARCH_VALUE , InfoVOMeta.SORT_FIELD , InfoVOMeta.SORT_TYPE , InfoVOMeta.IDS } ) 
	@NotNull(name = InfoVOMeta.ID)
	@SentinelResource(value = InfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.UPDATE)
	public Result update(InfoVO infoVO) {
		Result result=infoService.update(infoVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存数据中心
	*/
	@ApiOperation(value = "保存数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = InfoVOMeta.DC_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "ww"),
		@ApiImplicitParam(name = InfoVOMeta.DC_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "22"),
		@ApiImplicitParam(name = InfoVOMeta.DC_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "2"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InfoVOMeta.PAGE_INDEX , InfoVOMeta.PAGE_SIZE , InfoVOMeta.SEARCH_FIELD , InfoVOMeta.SEARCH_VALUE , InfoVOMeta.SORT_FIELD , InfoVOMeta.SORT_TYPE , InfoVOMeta.IDS } )
	@NotNull(name = InfoVOMeta.ID)
	@SentinelResource(value = InfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.SAVE)
	public Result save(InfoVO infoVO) {
		Result result=infoService.save(infoVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取数据中心
	*/
	@ApiOperation(value = "获取数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InfoVOMeta.ID)
	@SentinelResource(value = InfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.GET_BY_ID)
	public Result<Info> getById(String id) {
		Result<Info> result=new Result<>();
		Info role=infoService.getById(id);
		result.success(true).data(role);
		return result;
	}


	/**
	 * 批量删除数据中心 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除数据中心")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InfoVOMeta.IDS)
		@SentinelResource(value = InfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.GET_BY_IDS)
	public Result<List<Info>> getByIds(List<String> ids) {
		Result<List<Info>> result=new Result<>();
		List<Info> list=infoService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询数据中心
	*/
	@ApiOperation(value = "查询数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = InfoVOMeta.DC_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "ww"),
		@ApiImplicitParam(name = InfoVOMeta.DC_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "22"),
		@ApiImplicitParam(name = InfoVOMeta.DC_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "2"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InfoVOMeta.PAGE_INDEX , InfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.QUERY_LIST)
	public Result<List<Info>> queryList(InfoVO sample) {
		Result<List<Info>> result=new Result<>();
		List<Info> list=infoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询数据中心
	*/
	@ApiOperation(value = "分页查询数据中心")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = InfoVOMeta.DC_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "ww"),
		@ApiImplicitParam(name = InfoVOMeta.DC_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "22"),
		@ApiImplicitParam(name = InfoVOMeta.DC_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "2"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Info>> queryPagedList(InfoVO sample) {
		Result<PagedList<Info>> result=new Result<>();
		PagedList<Info> list=infoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InfoServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InfoServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InfoVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=infoService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InfoServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InfoServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=infoService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = InfoServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InfoServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=infoService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}