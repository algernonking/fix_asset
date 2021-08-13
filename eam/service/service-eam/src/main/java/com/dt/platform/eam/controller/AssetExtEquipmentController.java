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


import com.dt.platform.proxy.eam.AssetExtEquipmentServiceProxy;
import com.dt.platform.domain.eam.meta.AssetExtEquipmentVOMeta;
import com.dt.platform.domain.eam.AssetExtEquipment;
import com.dt.platform.domain.eam.AssetExtEquipmentVO;
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
import com.dt.platform.domain.eam.meta.AssetExtEquipmentMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetExtEquipmentService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 设备属性扩展 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-13 11:05:39
*/

@Api(tags = "设备属性扩展")
@ApiSort(0)
@RestController("EamAssetExtEquipmentController")
public class AssetExtEquipmentController extends SuperController {

	@Autowired
	private IAssetExtEquipmentService assetExtEquipmentService;

	
	/**
	 * 添加设备属性扩展
	*/
	@ApiOperation(value = "添加设备属性扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ASSET_ID , value = "资产ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_ID , value = "机柜ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_UP_POSITION_NUMBER , value = "机柜上位置编号" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_DOWN_POSITION_NUMBER , value = "机柜下位置编号" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetExtEquipmentVOMeta.ID)
	@SentinelResource(value = AssetExtEquipmentServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtEquipmentServiceProxy.INSERT)
	public Result insert(AssetExtEquipmentVO assetExtEquipmentVO) {
		Result result=assetExtEquipmentService.insert(assetExtEquipmentVO);
		return result;
	}

	
	/**
	 * 删除设备属性扩展
	*/
	@ApiOperation(value = "删除设备属性扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetExtEquipmentVOMeta.ID)
	@SentinelResource(value = AssetExtEquipmentServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtEquipmentServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetExtEquipmentService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除设备属性扩展 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除设备属性扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetExtEquipmentVOMeta.IDS)
	@SentinelResource(value = AssetExtEquipmentServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtEquipmentServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetExtEquipmentService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新设备属性扩展
	*/
	@ApiOperation(value = "更新设备属性扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ASSET_ID , value = "资产ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_ID , value = "机柜ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_UP_POSITION_NUMBER , value = "机柜上位置编号" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_DOWN_POSITION_NUMBER , value = "机柜下位置编号" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetExtEquipmentVOMeta.PAGE_INDEX , AssetExtEquipmentVOMeta.PAGE_SIZE , AssetExtEquipmentVOMeta.SEARCH_FIELD , AssetExtEquipmentVOMeta.FUZZY_FIELD , AssetExtEquipmentVOMeta.SEARCH_VALUE , AssetExtEquipmentVOMeta.SORT_FIELD , AssetExtEquipmentVOMeta.SORT_TYPE , AssetExtEquipmentVOMeta.IDS } ) 
	@NotNull(name = AssetExtEquipmentVOMeta.ID)
	@SentinelResource(value = AssetExtEquipmentServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtEquipmentServiceProxy.UPDATE)
	public Result update(AssetExtEquipmentVO assetExtEquipmentVO) {
		Result result=assetExtEquipmentService.update(assetExtEquipmentVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存设备属性扩展
	*/
	@ApiOperation(value = "保存设备属性扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ASSET_ID , value = "资产ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_ID , value = "机柜ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_UP_POSITION_NUMBER , value = "机柜上位置编号" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_DOWN_POSITION_NUMBER , value = "机柜下位置编号" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetExtEquipmentVOMeta.PAGE_INDEX , AssetExtEquipmentVOMeta.PAGE_SIZE , AssetExtEquipmentVOMeta.SEARCH_FIELD , AssetExtEquipmentVOMeta.FUZZY_FIELD , AssetExtEquipmentVOMeta.SEARCH_VALUE , AssetExtEquipmentVOMeta.SORT_FIELD , AssetExtEquipmentVOMeta.SORT_TYPE , AssetExtEquipmentVOMeta.IDS } )
	@NotNull(name = AssetExtEquipmentVOMeta.ID)
	@SentinelResource(value = AssetExtEquipmentServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtEquipmentServiceProxy.SAVE)
	public Result save(AssetExtEquipmentVO assetExtEquipmentVO) {
		Result result=assetExtEquipmentService.save(assetExtEquipmentVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取设备属性扩展
	*/
	@ApiOperation(value = "获取设备属性扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetExtEquipmentVOMeta.ID)
	@SentinelResource(value = AssetExtEquipmentServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtEquipmentServiceProxy.GET_BY_ID)
	public Result<AssetExtEquipment> getById(String id) {
		Result<AssetExtEquipment> result=new Result<>();
		AssetExtEquipment assetExtEquipment=assetExtEquipmentService.getById(id);
		result.success(true).data(assetExtEquipment);
		return result;
	}


	/**
	 * 批量删除设备属性扩展 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除设备属性扩展")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetExtEquipmentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetExtEquipmentVOMeta.IDS)
		@SentinelResource(value = AssetExtEquipmentServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtEquipmentServiceProxy.GET_BY_IDS)
	public Result<List<AssetExtEquipment>> getByIds(List<String> ids) {
		Result<List<AssetExtEquipment>> result=new Result<>();
		List<AssetExtEquipment> list=assetExtEquipmentService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询设备属性扩展
	*/
	@ApiOperation(value = "查询设备属性扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ASSET_ID , value = "资产ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_ID , value = "机柜ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_UP_POSITION_NUMBER , value = "机柜上位置编号" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_DOWN_POSITION_NUMBER , value = "机柜下位置编号" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetExtEquipmentVOMeta.PAGE_INDEX , AssetExtEquipmentVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetExtEquipmentServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtEquipmentServiceProxy.QUERY_LIST)
	public Result<List<AssetExtEquipment>> queryList(AssetExtEquipmentVO sample) {
		Result<List<AssetExtEquipment>> result=new Result<>();
		List<AssetExtEquipment> list=assetExtEquipmentService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询设备属性扩展
	*/
	@ApiOperation(value = "分页查询设备属性扩展")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ASSET_ID , value = "资产ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_DESC , value = "描述" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_ID , value = "机柜ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_UP_POSITION_NUMBER , value = "机柜上位置编号" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_DOWN_POSITION_NUMBER , value = "机柜下位置编号" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetExtEquipmentServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtEquipmentServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetExtEquipment>> queryPagedList(AssetExtEquipmentVO sample) {
		Result<PagedList<AssetExtEquipment>> result=new Result<>();
		PagedList<AssetExtEquipment> list=assetExtEquipmentService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetExtEquipmentServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtEquipmentServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetExtEquipmentVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetExtEquipmentService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetExtEquipmentServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtEquipmentServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetExtEquipmentService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetExtEquipmentServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetExtEquipmentServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetExtEquipmentService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}