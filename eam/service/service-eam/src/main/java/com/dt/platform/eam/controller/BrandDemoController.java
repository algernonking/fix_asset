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


import com.dt.platform.proxy.eam.BrandDemoServiceProxy;
import com.dt.platform.domain.eam.meta.BrandDemoVOMeta;
import com.dt.platform.domain.eam.BrandDemo;
import com.dt.platform.domain.eam.BrandDemoVO;
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
import com.dt.platform.domain.eam.meta.BrandDemoMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IBrandDemoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 品牌 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-01 19:16:14
*/

@Api(tags = "品牌")
@ApiSort(0)
@RestController("EamBrandDemoController")
public class BrandDemoController extends SuperController {

	@Autowired
	private IBrandDemoService brandDemoService;


	/**
	 * 添加品牌
	*/
	@ApiOperation(value = "添加品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = BrandDemoVOMeta.BRAND_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BrandDemoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = BrandDemoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BrandDemoServiceProxy.INSERT)
	public Result insert(BrandDemoVO brandDemoVO) {
		Result result=brandDemoService.insert(brandDemoVO);
		return result;
	}



	/**
	 * 删除品牌
	*/
	@ApiOperation(value = "删除品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = BrandDemoVOMeta.ID)
	@SentinelResource(value = BrandDemoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BrandDemoServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=brandDemoService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除品牌 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandDemoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = BrandDemoVOMeta.IDS)
	@SentinelResource(value = BrandDemoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BrandDemoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=brandDemoService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新品牌
	*/
	@ApiOperation(value = "更新品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = BrandDemoVOMeta.BRAND_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BrandDemoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { BrandDemoVOMeta.PAGE_INDEX , BrandDemoVOMeta.PAGE_SIZE , BrandDemoVOMeta.SEARCH_FIELD , BrandDemoVOMeta.FUZZY_FIELD , BrandDemoVOMeta.SEARCH_VALUE , BrandDemoVOMeta.SORT_FIELD , BrandDemoVOMeta.SORT_TYPE , BrandDemoVOMeta.IDS } )
	@NotNull(name = BrandDemoVOMeta.ID)
	@SentinelResource(value = BrandDemoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BrandDemoServiceProxy.UPDATE)
	public Result update(BrandDemoVO brandDemoVO) {
		Result result=brandDemoService.update(brandDemoVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存品牌
	*/
	@ApiOperation(value = "保存品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = BrandDemoVOMeta.BRAND_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BrandDemoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BrandDemoVOMeta.PAGE_INDEX , BrandDemoVOMeta.PAGE_SIZE , BrandDemoVOMeta.SEARCH_FIELD , BrandDemoVOMeta.FUZZY_FIELD , BrandDemoVOMeta.SEARCH_VALUE , BrandDemoVOMeta.SORT_FIELD , BrandDemoVOMeta.SORT_TYPE , BrandDemoVOMeta.IDS } )
	@NotNull(name = BrandDemoVOMeta.ID)
	@SentinelResource(value = BrandDemoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BrandDemoServiceProxy.SAVE)
	public Result save(BrandDemoVO brandDemoVO) {
		Result result=brandDemoService.save(brandDemoVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取品牌
	*/
	@ApiOperation(value = "获取品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = BrandDemoVOMeta.ID)
	@SentinelResource(value = BrandDemoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BrandDemoServiceProxy.GET_BY_ID)
	public Result<BrandDemo> getById(String id) {
		Result<BrandDemo> result=new Result<>();
		BrandDemo brandDemo=brandDemoService.getById(id);

		// join 关联的对象
		brandDemoService.dao().fill(brandDemo)
			.execute();

		result.success(true).data(brandDemo);
		return result;
	}


	/**
	 * 批量获取品牌 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取品牌")
		@ApiImplicitParams({
				@ApiImplicitParam(name = BrandDemoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = BrandDemoVOMeta.IDS)
		@SentinelResource(value = BrandDemoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BrandDemoServiceProxy.GET_BY_IDS)
	public Result<List<BrandDemo>> getByIds(List<String> ids) {
		Result<List<BrandDemo>> result=new Result<>();
		List<BrandDemo> list=brandDemoService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询品牌
	*/
	@ApiOperation(value = "查询品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = BrandDemoVOMeta.BRAND_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BrandDemoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BrandDemoVOMeta.PAGE_INDEX , BrandDemoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = BrandDemoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BrandDemoServiceProxy.QUERY_LIST)
	public Result<List<BrandDemo>> queryList(BrandDemoVO sample) {
		Result<List<BrandDemo>> result=new Result<>();
		List<BrandDemo> list=brandDemoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询品牌
	*/
	@ApiOperation(value = "分页查询品牌")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BrandDemoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = BrandDemoVOMeta.BRAND_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BrandDemoVOMeta.SORT , value = "排序" , required = false , dataTypeClass=BigDecimal.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = BrandDemoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BrandDemoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<BrandDemo>> queryPagedList(BrandDemoVO sample) {
		Result<PagedList<BrandDemo>> result=new Result<>();
		PagedList<BrandDemo> list=brandDemoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		brandDemoService.dao().fill(list)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = BrandDemoServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(BrandDemoServiceProxy.EXPORT_EXCEL)
	public void exportExcel(BrandDemoVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=brandDemoService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = BrandDemoServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(BrandDemoServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=brandDemoService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = BrandDemoServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(BrandDemoServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=brandDemoService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}