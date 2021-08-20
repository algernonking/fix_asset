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
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;
import com.dt.platform.domain.datacenter.Rack;
import com.dt.platform.domain.eam.Asset;
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
 * 资产设备数据 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 09:41:37
*/

@Api(tags = "资产设备数据")
@ApiSort(0)
@RestController("EamAssetExtEquipmentController")
public class AssetExtEquipmentController extends SuperController {

	@Autowired
	private IAssetExtEquipmentService assetExtEquipmentService;

	
	/**
	 * 添加资产设备数据
	*/
	@ApiOperation(value = "添加资产设备数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479376433093804032"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class , example = "lk"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class , example = "m"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class , example = ";l"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class , example = "klj"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "k"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_DESC , value = "描述" , required = false , dataTypeClass=String.class , example = "lk"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "474323467634737152"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "473609718003138561"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_ID , value = "机柜" , required = false , dataTypeClass=String.class , example = "474323707775418368"),
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
	 * 删除资产设备数据
	*/
	@ApiOperation(value = "删除资产设备数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479376433093804032")
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
	 * 批量删除资产设备数据 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产设备数据")
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
	 * 更新资产设备数据
	*/
	@ApiOperation(value = "更新资产设备数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479376433093804032"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class , example = "lk"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class , example = "m"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class , example = ";l"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class , example = "klj"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "k"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_DESC , value = "描述" , required = false , dataTypeClass=String.class , example = "lk"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "474323467634737152"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "473609718003138561"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_ID , value = "机柜" , required = false , dataTypeClass=String.class , example = "474323707775418368"),
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
	 * 保存资产设备数据
	*/
	@ApiOperation(value = "保存资产设备数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479376433093804032"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class , example = "lk"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class , example = "m"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class , example = ";l"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class , example = "klj"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "k"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_DESC , value = "描述" , required = false , dataTypeClass=String.class , example = "lk"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "474323467634737152"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "473609718003138561"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_ID , value = "机柜" , required = false , dataTypeClass=String.class , example = "474323707775418368"),
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
	 * 获取资产设备数据
	*/
	@ApiOperation(value = "获取资产设备数据")
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
		// 关联出 区域 数据
		assetExtEquipmentService.join(assetExtEquipment,AssetExtEquipmentMeta.AREA);
		// 关联出 层级 数据
		assetExtEquipmentService.join(assetExtEquipment,AssetExtEquipmentMeta.LAYER);
		// 关联出 机柜 数据
		assetExtEquipmentService.join(assetExtEquipment,AssetExtEquipmentMeta.RACK);
		result.success(true).data(assetExtEquipment);
		return result;
	}


	/**
	 * 批量删除资产设备数据 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产设备数据")
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
	 * 查询资产设备数据
	*/
	@ApiOperation(value = "查询资产设备数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479376433093804032"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class , example = "lk"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class , example = "m"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class , example = ";l"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class , example = "klj"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "k"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_DESC , value = "描述" , required = false , dataTypeClass=String.class , example = "lk"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "474323467634737152"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "473609718003138561"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_ID , value = "机柜" , required = false , dataTypeClass=String.class , example = "474323707775418368"),
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
	 * 分页查询资产设备数据
	*/
	@ApiOperation(value = "分页查询资产设备数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "479376433093804032"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class , example = "lk"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class , example = "m"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class , example = ";l"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class , example = "klj"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "k"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.EQUIPMENT_DESC , value = "描述" , required = false , dataTypeClass=String.class , example = "lk"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "474323467634737152"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "473609718003138561"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_ID , value = "机柜" , required = false , dataTypeClass=String.class , example = "474323707775418368"),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_UP_POSITION_NUMBER , value = "机柜上位置编号" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetExtEquipmentVOMeta.RACK_DOWN_POSITION_NUMBER , value = "机柜下位置编号" , required = false , dataTypeClass=Integer.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetExtEquipmentServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetExtEquipmentServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetExtEquipment>> queryPagedList(AssetExtEquipmentVO sample) {
		Result<PagedList<AssetExtEquipment>> result=new Result<>();
		PagedList<AssetExtEquipment> list=assetExtEquipmentService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 区域 数据
		assetExtEquipmentService.join(list,AssetExtEquipmentMeta.AREA);
		// 关联出 层级 数据
		assetExtEquipmentService.join(list,AssetExtEquipmentMeta.LAYER);
		// 关联出 机柜 数据
		assetExtEquipmentService.join(list,AssetExtEquipmentMeta.RACK);
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