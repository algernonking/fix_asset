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


import com.dt.platform.proxy.eam.MaintainerServiceProxy;
import com.dt.platform.domain.eam.meta.MaintainerVOMeta;
import com.dt.platform.domain.eam.Maintainer;
import com.dt.platform.domain.eam.MaintainerVO;
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
import com.dt.platform.domain.eam.meta.MaintainerMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IMaintainerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 维保厂商 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-11 14:38:52
*/

@Api(tags = "维保厂商")
@ApiSort(0)
@RestController("EamMaintainerController")
public class MaintainerController extends SuperController {

	@Autowired
	private IMaintainerService maintainerService;

	
	/**
	 * 添加维保厂商
	*/
	@ApiOperation(value = "添加维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471599404445335552"),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "华为科技有限公司"),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = MaintainerVOMeta.ID)
	@SentinelResource(value = MaintainerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainerServiceProxy.INSERT)
	public Result insert(MaintainerVO maintainerVO) {
		Result result=maintainerService.insert(maintainerVO);
		return result;
	}

	
	/**
	 * 删除维保厂商
	*/
	@ApiOperation(value = "删除维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471599404445335552")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = MaintainerVOMeta.ID)
	@SentinelResource(value = MaintainerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainerServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=maintainerService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除维保厂商 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = MaintainerVOMeta.IDS)
	@SentinelResource(value = MaintainerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=maintainerService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新维保厂商
	*/
	@ApiOperation(value = "更新维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471599404445335552"),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "华为科技有限公司"),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { MaintainerVOMeta.PAGE_INDEX , MaintainerVOMeta.PAGE_SIZE , MaintainerVOMeta.SEARCH_FIELD , MaintainerVOMeta.FUZZY_FIELD , MaintainerVOMeta.SEARCH_VALUE , MaintainerVOMeta.SORT_FIELD , MaintainerVOMeta.SORT_TYPE , MaintainerVOMeta.IDS } ) 
	@NotNull(name = MaintainerVOMeta.ID)
	@SentinelResource(value = MaintainerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainerServiceProxy.UPDATE)
	public Result update(MaintainerVO maintainerVO) {
		Result result=maintainerService.update(maintainerVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存维保厂商
	*/
	@ApiOperation(value = "保存维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471599404445335552"),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "华为科技有限公司"),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainerVOMeta.PAGE_INDEX , MaintainerVOMeta.PAGE_SIZE , MaintainerVOMeta.SEARCH_FIELD , MaintainerVOMeta.FUZZY_FIELD , MaintainerVOMeta.SEARCH_VALUE , MaintainerVOMeta.SORT_FIELD , MaintainerVOMeta.SORT_TYPE , MaintainerVOMeta.IDS } )
	@NotNull(name = MaintainerVOMeta.ID)
	@SentinelResource(value = MaintainerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainerServiceProxy.SAVE)
	public Result save(MaintainerVO maintainerVO) {
		Result result=maintainerService.save(maintainerVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取维保厂商
	*/
	@ApiOperation(value = "获取维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = MaintainerVOMeta.ID)
	@SentinelResource(value = MaintainerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainerServiceProxy.GET_BY_ID)
	public Result<Maintainer> getById(String id) {
		Result<Maintainer> result=new Result<>();
		Maintainer maintainer=maintainerService.getById(id);
		result.success(true).data(maintainer);
		return result;
	}


	/**
	 * 批量删除维保厂商 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除维保厂商")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MaintainerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = MaintainerVOMeta.IDS)
		@SentinelResource(value = MaintainerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainerServiceProxy.GET_BY_IDS)
	public Result<List<Maintainer>> getByIds(List<String> ids) {
		Result<List<Maintainer>> result=new Result<>();
		List<Maintainer> list=maintainerService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询维保厂商
	*/
	@ApiOperation(value = "查询维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471599404445335552"),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "华为科技有限公司"),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainerVOMeta.PAGE_INDEX , MaintainerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaintainerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainerServiceProxy.QUERY_LIST)
	public Result<List<Maintainer>> queryList(MaintainerVO sample) {
		Result<List<Maintainer>> result=new Result<>();
		List<Maintainer> list=maintainerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询维保厂商
	*/
	@ApiOperation(value = "分页查询维保厂商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "471599404445335552"),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "华为科技有限公司"),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = MaintainerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Maintainer>> queryPagedList(MaintainerVO sample) {
		Result<PagedList<Maintainer>> result=new Result<>();
		PagedList<Maintainer> list=maintainerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = MaintainerServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainerServiceProxy.EXPORT_EXCEL)
	public void exportExcel(MaintainerVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=maintainerService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = MaintainerServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainerServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=maintainerService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = MaintainerServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(MaintainerServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=maintainerService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}