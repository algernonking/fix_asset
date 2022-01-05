package com.dt.platform.eam.controller;


import java.util.ArrayList;
import java.util.List;

import com.dt.platform.domain.eam.Inventory;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.eam.meta.InventoryMeta;
import com.dt.platform.eam.service.IAssetService;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
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


import com.dt.platform.proxy.eam.InventoryAssetServiceProxy;
import com.dt.platform.domain.eam.meta.InventoryAssetVOMeta;
import com.dt.platform.domain.eam.InventoryAsset;
import com.dt.platform.domain.eam.InventoryAssetVO;
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
import com.dt.platform.domain.eam.meta.InventoryAssetMeta;
import com.dt.platform.domain.eam.Asset;

import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInventoryAssetService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 盘点明细 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-05 12:58:04
*/

@Api(tags = "盘点明细")
@ApiSort(0)
@RestController("EamInventoryAssetController")
public class InventoryAssetController extends SuperController {

	@Autowired
	private IInventoryAssetService inventoryAssetService;

	@Autowired
	private IAssetService assetService;

	/**
	 * 添加盘点明细
	*/
	@ApiOperation(value = "添加盘点明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "66476b1b-6dd0-11ec-bf3e-00163e1b60a7"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class , example = "531058564924444672"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "loss"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "518094137103220736"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.OPER_EMPL_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryAssetVOMeta.OPER_DATE , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryAssetVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InventoryAssetServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryAssetServiceProxy.INSERT)
	public Result insert(InventoryAssetVO inventoryAssetVO) {
		Result result=inventoryAssetService.insert(inventoryAssetVO,false);
		return result;
	}



	/**
	 * 删除盘点明细
	*/
	@ApiOperation(value = "删除盘点明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "66476b1b-6dd0-11ec-bf3e-00163e1b60a7")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InventoryAssetVOMeta.ID)
	@SentinelResource(value = InventoryAssetServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryAssetServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=inventoryAssetService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除盘点明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除盘点明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryAssetVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InventoryAssetVOMeta.IDS)
	@SentinelResource(value = InventoryAssetServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryAssetServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=inventoryAssetService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新盘点明细
	*/
	@ApiOperation(value = "更新盘点明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "66476b1b-6dd0-11ec-bf3e-00163e1b60a7"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class , example = "531058564924444672"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "loss"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "518094137103220736"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.OPER_EMPL_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryAssetVOMeta.OPER_DATE , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryAssetVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InventoryAssetVOMeta.PAGE_INDEX , InventoryAssetVOMeta.PAGE_SIZE , InventoryAssetVOMeta.SEARCH_FIELD , InventoryAssetVOMeta.FUZZY_FIELD , InventoryAssetVOMeta.SEARCH_VALUE , InventoryAssetVOMeta.DIRTY_FIELDS , InventoryAssetVOMeta.SORT_FIELD , InventoryAssetVOMeta.SORT_TYPE , InventoryAssetVOMeta.IDS } )
	@NotNull(name = InventoryAssetVOMeta.ID)
	@SentinelResource(value = InventoryAssetServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryAssetServiceProxy.UPDATE)
	public Result update(InventoryAssetVO inventoryAssetVO) {
		Result result=inventoryAssetService.update(inventoryAssetVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存盘点明细
	*/
	@ApiOperation(value = "保存盘点明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "66476b1b-6dd0-11ec-bf3e-00163e1b60a7"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class , example = "531058564924444672"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "loss"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "518094137103220736"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.OPER_EMPL_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryAssetVOMeta.OPER_DATE , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryAssetVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryAssetVOMeta.PAGE_INDEX , InventoryAssetVOMeta.PAGE_SIZE , InventoryAssetVOMeta.SEARCH_FIELD , InventoryAssetVOMeta.FUZZY_FIELD , InventoryAssetVOMeta.SEARCH_VALUE , InventoryAssetVOMeta.DIRTY_FIELDS , InventoryAssetVOMeta.SORT_FIELD , InventoryAssetVOMeta.SORT_TYPE , InventoryAssetVOMeta.IDS } )
	@NotNull(name = InventoryAssetVOMeta.ID)
	@SentinelResource(value = InventoryAssetServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryAssetServiceProxy.SAVE)
	public Result save(InventoryAssetVO inventoryAssetVO) {
		Result result=inventoryAssetService.save(inventoryAssetVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取盘点明细
	*/
	@ApiOperation(value = "获取盘点明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InventoryAssetVOMeta.ID)
	@SentinelResource(value = InventoryAssetServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryAssetServiceProxy.GET_BY_ID)
	public Result<InventoryAsset> getById(String id) {
		Result<InventoryAsset> result=new Result<>();
		InventoryAsset inventoryAsset=inventoryAssetService.getById(id);
		// join 关联的对象
		inventoryAssetService.dao().fill(inventoryAsset)
				.with(InventoryAssetMeta.ASSET)
				.with(InventoryAssetMeta.OPERATER)
				.execute();

		assetService.dao().fill(inventoryAsset.getAsset()).with(AssetMeta.CATEGORY)
				.with(AssetMeta.CATEGORY_FINANCE)
				.with(AssetMeta.GOODS)
				.with(AssetMeta.MANUFACTURER)
				.with(AssetMeta.POSITION)
				.with(AssetMeta.MAINTNAINER)
				.with(AssetMeta.SUPPLIER)
				.with(AssetMeta.OWNER_COMPANY)
				.with(AssetMeta.USE_ORGANIZATION)
				.with(AssetMeta.MANAGER)
				.with(AssetMeta.USE_USER)
				.with(AssetMeta.ORIGINATOR)
				.with(AssetMeta.RACK)
				.with(AssetMeta.SOURCE)
				.with(AssetMeta.SAFETY_LEVEL)
				.with(AssetMeta.EQUIPMENT_ENVIRONMENT)
				.with(AssetMeta.ASSET_MAINTENANCE_STATUS)
				.execute();

		inventoryAssetService.dao().join(inventoryAsset.getOperater(), Person.class);
		result.success(true).data(inventoryAsset);
		return result;
	}


	/**
	 * 批量获取盘点明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取盘点明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InventoryAssetVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InventoryAssetVOMeta.IDS)
		@SentinelResource(value = InventoryAssetServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryAssetServiceProxy.GET_BY_IDS)
	public Result<List<InventoryAsset>> getByIds(List<String> ids) {
		Result<List<InventoryAsset>> result=new Result<>();
		List<InventoryAsset> list=inventoryAssetService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询盘点明细
	*/
	@ApiOperation(value = "查询盘点明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "66476b1b-6dd0-11ec-bf3e-00163e1b60a7"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class , example = "531058564924444672"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "loss"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "518094137103220736"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.OPER_EMPL_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryAssetVOMeta.OPER_DATE , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryAssetVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InventoryAssetVOMeta.PAGE_INDEX , InventoryAssetVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InventoryAssetServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryAssetServiceProxy.QUERY_LIST)
	public Result<List<InventoryAsset>> queryList(InventoryAssetVO sample) {
		Result<List<InventoryAsset>> result=new Result<>();
		List<InventoryAsset> list=inventoryAssetService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询盘点明细
	*/
	@ApiOperation(value = "分页查询盘点明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InventoryAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "66476b1b-6dd0-11ec-bf3e-00163e1b60a7"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.INVENTORY_ID , value = "盘点" , required = false , dataTypeClass=String.class , example = "531058564924444672"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "loss"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "518094137103220736"),
		@ApiImplicitParam(name = InventoryAssetVOMeta.OPER_EMPL_ID , value = "员工" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InventoryAssetVOMeta.OPER_DATE , value = "操作时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InventoryAssetVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InventoryAssetServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InventoryAssetServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InventoryAsset>> queryPagedList(InventoryAssetVO sample) {
		Result<PagedList<InventoryAsset>> result=new Result<>();
		PagedList<InventoryAsset> list=inventoryAssetService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		inventoryAssetService.dao().fill(list)
				.with(InventoryAssetMeta.OPERATER)
				.with(InventoryAssetMeta.ASSET)
				.execute();


		List<Employee> operList= CollectorUtil.collectList(list.getList(), InventoryAsset::getOperater);
		inventoryAssetService.dao().join(operList, Person.class);

		List<Asset> assetList= CollectorUtil.collectList(list.getList(), InventoryAsset::getAsset);
		assetService.joinData(assetList);

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InventoryAssetServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryAssetServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InventoryAssetVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=inventoryAssetService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InventoryAssetServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryAssetServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=inventoryAssetService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InventoryAssetServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InventoryAssetServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=inventoryAssetService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}