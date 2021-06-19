package com.dt.eam.eam.controller;

 
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


import com.dt.eam.proxy.eam.GoodsServiceProxy;
import com.dt.eam.domain.eam.meta.GoodsVOMeta;
import com.dt.eam.domain.eam.Goods;
import com.dt.eam.domain.eam.GoodsVO;
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
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.eam.eam.service.IGoodsService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产物品表 接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-19 20:16:33
*/

@Api(tags = "资产物品")
@ApiSort(0)
@RestController("EamGoodsController")
public class GoodsController extends SuperController {

	@Autowired
	private IGoodsService goodsService;

	
	/**
	 * 添加资产物品
	*/
	@ApiOperation(value = "添加资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = GoodsVOMeta.ID)
	@SentinelResource(value = GoodsServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.INSERT)
	public Result<Goods> insert(GoodsVO goodsVO) {
		Result<Goods> result=new Result<>();
		boolean suc=goodsService.insert(goodsVO);
		result.success(suc);
		if(!suc) result.message("数据插入失败");
		return result;
	}

	
	/**
	 * 删除资产物品
	*/
	@ApiOperation(value = "删除资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = GoodsVOMeta.ID)
	@SentinelResource(value = GoodsServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.DELETE)
	public Result<Goods> deleteById(String id) {
		Result<Goods> result=new Result<>();
		boolean suc=goodsService.deleteByIdLogical(id);
		result.success(suc);
		if(!suc) result.message("数据删除失败");
		return result;
	}
	
	
	/**
	 * 批量删除资产物品 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = GoodsVOMeta.IDS)
	@SentinelResource(value = GoodsServiceProxy.BATCH_DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.BATCH_DELETE)
	public Result<Goods> deleteByIds(List<String> ids) {
		Result<Goods> result=new Result<>();
		boolean suc=goodsService.deleteByIdsLogical(ids);
		result.success(suc);
		if(!suc) result.message("数据删除失败");
		return result;
	}
	
	/**
	 * 更新资产物品
	*/
	@ApiOperation(value = "更新资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE , GoodsVOMeta.SEARCH_FIELD , GoodsVOMeta.SEARCH_VALUE , GoodsVOMeta.SORT_FIELD , GoodsVOMeta.SORT_TYPE , GoodsVOMeta.IDS } ) 
	@NotNull(name = GoodsVOMeta.ID)
	@SentinelResource(value = GoodsServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.UPDATE)
	public Result<Goods> update(GoodsVO goodsVO) {
		Result<Goods> result=new Result<>();
		boolean suc=goodsService.update(goodsVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		if(!suc) result.message("数据更新失败");
		return result;
	}
	
	
	/**
	 * 保存资产物品
	*/
	@ApiOperation(value = "保存资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE , GoodsVOMeta.SEARCH_FIELD , GoodsVOMeta.SEARCH_VALUE , GoodsVOMeta.SORT_FIELD , GoodsVOMeta.SORT_TYPE , GoodsVOMeta.IDS } )
	@NotNull(name = GoodsVOMeta.ID)
	@SentinelResource(value = GoodsServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.SAVE)
	public Result<Goods> save(GoodsVO goodsVO) {
		Result<Goods> result=new Result<>();
		boolean suc=goodsService.save(goodsVO,SaveMode.NOT_NULL_FIELDS);
		result.success(suc);
		if(!suc) result.message("数据保存失败");
		return result;
	}

	
	/**
	 * 获取资产物品
	*/
	@ApiOperation(value = "获取资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = GoodsVOMeta.ID)
	@SentinelResource(value = GoodsServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.GET_BY_ID)
	public Result<Goods> getById(String id) {
		Result<Goods> result=new Result<>();
		Goods role=goodsService.getById(id);
		result.success(true).data(role);
		return result;
	}

	
	/**
	 * 查询资产物品
	*/
	@ApiOperation(value = "查询资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GoodsVOMeta.PAGE_INDEX , GoodsVOMeta.PAGE_SIZE } )
	@SentinelResource(value = GoodsServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.QUERY_LIST)
	public Result<List<Goods>> queryList(GoodsVO sample) {
		Result<List<Goods>> result=new Result<>();
		List<Goods> list=goodsService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产物品
	*/
	@ApiOperation(value = "分页查询资产物品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GoodsVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GoodsVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = GoodsServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GoodsServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Goods>> queryPagedList(GoodsVO sample) {
		Result<PagedList<Goods>> result=new Result<>();
		PagedList<Goods> list=goodsService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = GoodsServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GoodsServiceProxy.EXPORT_EXCEL)
	public void exportExcel(GoodsVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=goodsService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = GoodsServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GoodsServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=goodsService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = GoodsServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GoodsServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=goodsService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}