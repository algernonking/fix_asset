package com.dt.platform.knowledgebase.controller;

 
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


import com.dt.platform.proxy.knowledgebase.GradeServiceProxy;
import com.dt.platform.domain.knowledgebase.meta.GradeVOMeta;
import com.dt.platform.domain.knowledgebase.Grade;
import com.dt.platform.domain.knowledgebase.GradeVO;
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
import com.dt.platform.domain.knowledgebase.meta.GradeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.knowledgebase.service.IGradeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 知识分级 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-14 17:46:17
*/

@Api(tags = "知识分级")
@ApiSort(0)
@RestController("KnGradeController")
public class GradeController extends SuperController {

	@Autowired
	private IGradeService gradeService;

	
	/**
	 * 添加知识分级
	*/
	@ApiOperation(value = "添加知识分级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478981334048440320"),
		@ApiImplicitParam(name = GradeVOMeta.CODE , value = "编号" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = GradeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "一级"),
		@ApiImplicitParam(name = GradeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = GradeVOMeta.ID)
	@SentinelResource(value = GradeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GradeServiceProxy.INSERT)
	public Result insert(GradeVO gradeVO) {
		Result result=gradeService.insert(gradeVO);
		return result;
	}

	
	/**
	 * 删除知识分级
	*/
	@ApiOperation(value = "删除知识分级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478981334048440320")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = GradeVOMeta.ID)
	@SentinelResource(value = GradeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GradeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=gradeService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除知识分级 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除知识分级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GradeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = GradeVOMeta.IDS)
	@SentinelResource(value = GradeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GradeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=gradeService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新知识分级
	*/
	@ApiOperation(value = "更新知识分级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478981334048440320"),
		@ApiImplicitParam(name = GradeVOMeta.CODE , value = "编号" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = GradeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "一级"),
		@ApiImplicitParam(name = GradeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { GradeVOMeta.PAGE_INDEX , GradeVOMeta.PAGE_SIZE , GradeVOMeta.SEARCH_FIELD , GradeVOMeta.FUZZY_FIELD , GradeVOMeta.SEARCH_VALUE , GradeVOMeta.SORT_FIELD , GradeVOMeta.SORT_TYPE , GradeVOMeta.IDS } ) 
	@NotNull(name = GradeVOMeta.ID)
	@SentinelResource(value = GradeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GradeServiceProxy.UPDATE)
	public Result update(GradeVO gradeVO) {
		Result result=gradeService.update(gradeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存知识分级
	*/
	@ApiOperation(value = "保存知识分级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478981334048440320"),
		@ApiImplicitParam(name = GradeVOMeta.CODE , value = "编号" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = GradeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "一级"),
		@ApiImplicitParam(name = GradeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GradeVOMeta.PAGE_INDEX , GradeVOMeta.PAGE_SIZE , GradeVOMeta.SEARCH_FIELD , GradeVOMeta.FUZZY_FIELD , GradeVOMeta.SEARCH_VALUE , GradeVOMeta.SORT_FIELD , GradeVOMeta.SORT_TYPE , GradeVOMeta.IDS } )
	@NotNull(name = GradeVOMeta.ID)
	@SentinelResource(value = GradeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GradeServiceProxy.SAVE)
	public Result save(GradeVO gradeVO) {
		Result result=gradeService.save(gradeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取知识分级
	*/
	@ApiOperation(value = "获取知识分级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = GradeVOMeta.ID)
	@SentinelResource(value = GradeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GradeServiceProxy.GET_BY_ID)
	public Result<Grade> getById(String id) {
		Result<Grade> result=new Result<>();
		Grade grade=gradeService.getById(id);
		result.success(true).data(grade);
		return result;
	}


	/**
	 * 批量删除知识分级 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除知识分级")
		@ApiImplicitParams({
				@ApiImplicitParam(name = GradeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = GradeVOMeta.IDS)
		@SentinelResource(value = GradeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GradeServiceProxy.GET_BY_IDS)
	public Result<List<Grade>> getByIds(List<String> ids) {
		Result<List<Grade>> result=new Result<>();
		List<Grade> list=gradeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询知识分级
	*/
	@ApiOperation(value = "查询知识分级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478981334048440320"),
		@ApiImplicitParam(name = GradeVOMeta.CODE , value = "编号" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = GradeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "一级"),
		@ApiImplicitParam(name = GradeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GradeVOMeta.PAGE_INDEX , GradeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = GradeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GradeServiceProxy.QUERY_LIST)
	public Result<List<Grade>> queryList(GradeVO sample) {
		Result<List<Grade>> result=new Result<>();
		List<Grade> list=gradeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询知识分级
	*/
	@ApiOperation(value = "分页查询知识分级")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GradeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "478981334048440320"),
		@ApiImplicitParam(name = GradeVOMeta.CODE , value = "编号" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = GradeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "一级"),
		@ApiImplicitParam(name = GradeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = GradeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GradeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Grade>> queryPagedList(GradeVO sample) {
		Result<PagedList<Grade>> result=new Result<>();
		PagedList<Grade> list=gradeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = GradeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GradeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(GradeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=gradeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = GradeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GradeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=gradeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = GradeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GradeServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=gradeService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}