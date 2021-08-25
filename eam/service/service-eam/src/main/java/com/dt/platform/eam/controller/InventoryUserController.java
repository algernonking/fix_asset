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


import com.dt.platform.proxy.eam.InventoryUserServiceProxy;
import com.dt.platform.domain.eam.meta.InventoryUserVOMeta;
import com.dt.platform.domain.eam.InventoryUser;
import com.dt.platform.domain.eam.InventoryUserVO;
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
import com.dt.platform.domain.eam.meta.InventoryUserMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInventoryUserService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 盘点用户 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-24 19:49:02
*/

@Api(tags = "盘点用户")
@ApiSort(0)
@RestController("EamInventoryUserController")
public class InventoryUserController extends SuperController {

	@Autowired
	private IInventoryUserService inventoryUserService;

	
	/**
	 * 添加盘点用户
	*/
	@ApiOperation(value = "添加盘点用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.USER_ID , value = "盘点人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = InventoryUserVOMeta.ID)
	@SentinelResource(value = InventoryUserServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryUserServiceProxy.INSERT)
	public Result insert(InventoryUserVO inventoryUserVO) {
		Result result=inventoryUserService.insert(inventoryUserVO);
		return result;
	}

	
	/**
	 * 删除盘点用户
	*/
	@ApiOperation(value = "删除盘点用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InventoryUserVOMeta.ID)
	@SentinelResource(value = InventoryUserServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryUserServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inventoryUserService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除盘点用户 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除盘点用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InventoryUserVOMeta.IDS)
	@SentinelResource(value = InventoryUserServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryUserServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inventoryUserService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新盘点用户
	*/
	@ApiOperation(value = "更新盘点用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.USER_ID , value = "盘点人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InventoryUserVOMeta.PAGE_INDEX , InventoryUserVOMeta.PAGE_SIZE , InventoryUserVOMeta.SEARCH_FIELD , InventoryUserVOMeta.FUZZY_FIELD , InventoryUserVOMeta.SEARCH_VALUE , InventoryUserVOMeta.SORT_FIELD , InventoryUserVOMeta.SORT_TYPE , InventoryUserVOMeta.IDS } ) 
	@NotNull(name = InventoryUserVOMeta.ID)
	@SentinelResource(value = InventoryUserServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryUserServiceProxy.UPDATE)
	public Result update(InventoryUserVO inventoryUserVO) {
		Result result=inventoryUserService.update(inventoryUserVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存盘点用户
	*/
	@ApiOperation(value = "保存盘点用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.USER_ID , value = "盘点人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryUserVOMeta.PAGE_INDEX , InventoryUserVOMeta.PAGE_SIZE , InventoryUserVOMeta.SEARCH_FIELD , InventoryUserVOMeta.FUZZY_FIELD , InventoryUserVOMeta.SEARCH_VALUE , InventoryUserVOMeta.SORT_FIELD , InventoryUserVOMeta.SORT_TYPE , InventoryUserVOMeta.IDS } )
	@NotNull(name = InventoryUserVOMeta.ID)
	@SentinelResource(value = InventoryUserServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryUserServiceProxy.SAVE)
	public Result save(InventoryUserVO inventoryUserVO) {
		Result result=inventoryUserService.save(inventoryUserVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取盘点用户
	*/
	@ApiOperation(value = "获取盘点用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InventoryUserVOMeta.ID)
	@SentinelResource(value = InventoryUserServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryUserServiceProxy.GET_BY_ID)
	public Result<InventoryUser> getById(String id) {
		Result<InventoryUser> result=new Result<>();
		InventoryUser inventoryUser=inventoryUserService.getById(id);
		result.success(true).data(inventoryUser);
		return result;
	}


	/**
	 * 批量删除盘点用户 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除盘点用户")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InventoryUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InventoryUserVOMeta.IDS)
		@SentinelResource(value = InventoryUserServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryUserServiceProxy.GET_BY_IDS)
	public Result<List<InventoryUser>> getByIds(List<String> ids) {
		Result<List<InventoryUser>> result=new Result<>();
		List<InventoryUser> list=inventoryUserService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询盘点用户
	*/
	@ApiOperation(value = "查询盘点用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.USER_ID , value = "盘点人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryUserVOMeta.PAGE_INDEX , InventoryUserVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InventoryUserServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryUserServiceProxy.QUERY_LIST)
	public Result<List<InventoryUser>> queryList(InventoryUserVO sample) {
		Result<List<InventoryUser>> result=new Result<>();
		List<InventoryUser> list=inventoryUserService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询盘点用户
	*/
	@ApiOperation(value = "分页查询盘点用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.USER_ID , value = "盘点人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryUserVOMeta.NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InventoryUserServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryUserServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InventoryUser>> queryPagedList(InventoryUserVO sample) {
		Result<PagedList<InventoryUser>> result=new Result<>();
		PagedList<InventoryUser> list=inventoryUserService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InventoryUserServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryUserServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InventoryUserVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=inventoryUserService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InventoryUserServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryUserServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=inventoryUserService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = InventoryUserServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryUserServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=inventoryUserService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}