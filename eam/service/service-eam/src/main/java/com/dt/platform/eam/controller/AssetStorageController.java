package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.AssetTranfer;
import com.dt.platform.domain.eam.meta.AssetTranferVOMeta;
import com.dt.platform.proxy.eam.AssetTranferServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
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


import com.dt.platform.proxy.eam.AssetStorageServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStorageVOMeta;
import com.dt.platform.domain.eam.AssetStorage;
import com.dt.platform.domain.eam.AssetStorageVO;
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
import com.dt.platform.domain.eam.meta.AssetStorageMeta;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStorageService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产入库 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-19 13:26:20
*/

@Api(tags = "资产入库")
@ApiSort(0)
@RestController("EamAssetStorageController")
public class AssetStorageController extends SuperController {

	@Autowired
	private IAssetStorageService assetStorageService;


	/**
	 * 添加资产入库
	*/
	@ApiOperation(value = "添加资产入库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.SUPPLIER_INFO , value = "供应商备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.OWN_COMPANY_ID , value = "归属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.MANAGER_USER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.LOCATION_NAME , value = "位置信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.CONTENT , value = "入库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.CUSTOM_DATA , value = "自定义数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetStorageServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStorageServiceProxy.INSERT)
	public Result insert(AssetStorageVO assetStorageVO) {
		Result result=assetStorageService.insert(assetStorageVO,false);
		return result;
	}



	/**
	 * 删除资产入库
	*/
	@ApiOperation(value = "删除资产入库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetStorageVOMeta.ID)
	@SentinelResource(value = AssetStorageServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStorageServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetStorageService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产入库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产入库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStorageVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetStorageVOMeta.IDS)
	@SentinelResource(value = AssetStorageServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStorageServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetStorageService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新资产入库
	*/
	@ApiOperation(value = "更新资产入库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.SUPPLIER_INFO , value = "供应商备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.OWN_COMPANY_ID , value = "归属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.MANAGER_USER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.LOCATION_NAME , value = "位置信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.CONTENT , value = "入库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.CUSTOM_DATA , value = "自定义数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetStorageVOMeta.PAGE_INDEX , AssetStorageVOMeta.PAGE_SIZE , AssetStorageVOMeta.SEARCH_FIELD , AssetStorageVOMeta.FUZZY_FIELD , AssetStorageVOMeta.SEARCH_VALUE , AssetStorageVOMeta.DIRTY_FIELDS , AssetStorageVOMeta.SORT_FIELD , AssetStorageVOMeta.SORT_TYPE , AssetStorageVOMeta.IDS } )
	@NotNull(name = AssetStorageVOMeta.ID)
	@SentinelResource(value = AssetStorageServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStorageServiceProxy.UPDATE)
	public Result update(AssetStorageVO assetStorageVO) {
		Result result=assetStorageService.update(assetStorageVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存资产入库
	*/
	@ApiOperation(value = "保存资产入库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.SUPPLIER_INFO , value = "供应商备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.OWN_COMPANY_ID , value = "归属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.MANAGER_USER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.LOCATION_NAME , value = "位置信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.CONTENT , value = "入库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.CUSTOM_DATA , value = "自定义数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStorageVOMeta.PAGE_INDEX , AssetStorageVOMeta.PAGE_SIZE , AssetStorageVOMeta.SEARCH_FIELD , AssetStorageVOMeta.FUZZY_FIELD , AssetStorageVOMeta.SEARCH_VALUE , AssetStorageVOMeta.DIRTY_FIELDS , AssetStorageVOMeta.SORT_FIELD , AssetStorageVOMeta.SORT_TYPE , AssetStorageVOMeta.IDS } )
	@NotNull(name = AssetStorageVOMeta.ID)
	@SentinelResource(value = AssetStorageServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStorageServiceProxy.SAVE)
	public Result save(AssetStorageVO assetStorageVO) {
		Result result=assetStorageService.save(assetStorageVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取资产入库
	*/
	@ApiOperation(value = "获取资产入库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetStorageVOMeta.ID)
	@SentinelResource(value = AssetStorageServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStorageServiceProxy.GET_BY_ID)
	public Result<AssetStorage> getById(String id) {
		Result<AssetStorage> result=new Result<>();
		AssetStorage assetStorage=assetStorageService.getById(id);
		// join 关联的对象
		assetStorageService.dao().fill(assetStorage)
			.with("originator")
				.with("ownerCompany")
				.with(AssetStorageMeta.SUPPLIER)
			.with("useUser")
			.execute();

		assetStorageService.dao().join(assetStorage.getOriginator(), Person.class);
		assetStorageService.dao().join(assetStorage.getManagerUser(), Person.class);

		result.success(true).data(assetStorage);
		return result;
	}


	/**
	 * 批量获取资产入库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产入库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetStorageVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetStorageVOMeta.IDS)
		@SentinelResource(value = AssetStorageServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStorageServiceProxy.GET_BY_IDS)
	public Result<List<AssetStorage>> getByIds(List<String> ids) {
		Result<List<AssetStorage>> result=new Result<>();
		List<AssetStorage> list=assetStorageService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产入库
	*/
	@ApiOperation(value = "查询资产入库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.SUPPLIER_INFO , value = "供应商备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.OWN_COMPANY_ID , value = "归属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.MANAGER_USER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.LOCATION_NAME , value = "位置信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.CONTENT , value = "入库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.CUSTOM_DATA , value = "自定义数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetStorageVOMeta.PAGE_INDEX , AssetStorageVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetStorageServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStorageServiceProxy.QUERY_LIST)
	public Result<List<AssetStorage>> queryList(AssetStorageVO sample) {
		Result<List<AssetStorage>> result=new Result<>();
		List<AssetStorage> list=assetStorageService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产入库
	*/
	@ApiOperation(value = "分页查询资产入库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.NAME , value = "业务名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.SUPPLIER_ID , value = "供应商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.SUPPLIER_INFO , value = "供应商备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.OWN_COMPANY_ID , value = "归属公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.MANAGER_USER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.LOCATION_NAME , value = "位置信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.CONTENT , value = "入库说明" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetStorageVOMeta.CUSTOM_DATA , value = "自定义数据" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetStorageServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetStorageServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetStorage>> queryPagedList(AssetStorageVO sample) {
		Result<PagedList<AssetStorage>> result=new Result<>();
		PagedList<AssetStorage> list=assetStorageService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetStorageService.dao().fill(list)
				.with("ownerCompany")
				.with(AssetStorageMeta.SUPPLIER)
			.with("originator")
			.with("useUser")
			.execute();


		List<Employee> managers= CollectorUtil.collectList(list, AssetStorage::getManagerUser);
		assetStorageService.dao().join(managers, Person.class);

		List<Employee> originators= CollectorUtil.collectList(list,AssetStorage::getOriginator);
		assetStorageService.dao().join(originators, Person.class);

		result.success(true).data(list);
		return result;
	}


	/**
	 * 转移送审
	 * */
	@ApiOperation(value = "送审")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStorageVOMeta.ID)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetStorageServiceProxy.FOR_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStorageServiceProxy.FOR_APPROVAL)
	public Result forApproval(String id)  {
		return assetStorageService.forApproval(id);
	}



	/**
	 * 确认
	 * */
	@ApiOperation(value = "确认")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStorageVOMeta.ID)
	@ApiOperationSupport(order=13)
	@SentinelResource(value = AssetStorageServiceProxy.CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStorageServiceProxy.CONFIRM_OPERATION)
	public Result confirmOperation(String id)  {
		return assetStorageService.confirmOperation(id);
	}



	/**
	 * 撤销
	 * */
	@ApiOperation(value = "撤销")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetStorageVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@NotNull(name = AssetStorageVOMeta.ID)
	@ApiOperationSupport(order=14)
	@SentinelResource(value = AssetStorageServiceProxy.REVOKE_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStorageServiceProxy.REVOKE_OPERATION)
	public Result revokeOperation(String id)  {
		return assetStorageService.revokeOperation(id);
	}

	/**
	 * 审批
	 * */
	@ApiOperation(value = "审批")
	@ApiOperationSupport(order=15)
	@SentinelResource(value = AssetStorageServiceProxy.APPROVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStorageServiceProxy.APPROVE)
	public Result approve(ProcessApproveVO approveVO)  {
		return assetStorageService.approve(approveVO);
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetStorageServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStorageServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetStorageVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetStorageService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetStorageServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStorageServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetStorageService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetStorageServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetStorageServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetStorageService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}