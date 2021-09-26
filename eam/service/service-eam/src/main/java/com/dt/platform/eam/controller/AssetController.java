package com.dt.platform.eam.controller;

 
import java.util.List;

import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.eam.service.IAssetItemService;
import com.dt.platform.eam.service.IOperateService;
import com.github.foxnic.sql.expr.ConditionExpr;
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


import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.dt.platform.domain.eam.meta.AssetVOMeta;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
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
import com.dt.platform.domain.eam.meta.AssetMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.CategoryFinance;
import org.github.foxnic.web.domain.pcm.Catalog;
import com.dt.platform.domain.eam.Goods;
import com.dt.platform.domain.eam.Manufacturer;
import com.dt.platform.domain.eam.Warehouse;
import org.github.foxnic.web.domain.hrm.Person;
import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.Maintainer;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 21:49:26
*/

@Api(tags = "资产")
@ApiSort(0)
@RestController("EamAssetController")
public class AssetController extends SuperController {

	@Autowired
	private IAssetService assetService;

	@Autowired
	private IAssetItemService assetItemService;

	@Autowired
	private IOperateService operateService;
	/**
	 * 添加资产
	*/
	@ApiOperation(value = "添加资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "489517168661102592"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_ID , value = "资产分类" , required = true , dataTypeClass=String.class , example = "486917781384597505"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_CODE , value = "分类编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BATCH_CODE , value = "批次编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_CODE , value = "资产编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SCRAP , value = "是否报废" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.GOODS_ID , value = "标准物品档案" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.NAME , value = "标准型号资产名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.MANUFACTURER_ID , value = "标准型号厂商" , required = false , dataTypeClass=String.class , example = "473623897560842240"),
		@ApiImplicitParam(name = AssetVOMeta.MODEL , value = "标准型号规格型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PICTURE_ID , value = "标准型号物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.UNIT , value = "标准型号计量单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
		@ApiImplicitParam(name = AssetVOMeta.SERIAL_NUMBER , value = "序列号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NUMBER , value = "资产数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetVOMeta.REMAIN_NUMBER , value = "剩余数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.RFID , value = "资产RFID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NOTES , value = "资产备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_NOTES , value = "维保备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CATEGORY_ID , value = "财务分类" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_RATE , value = "税额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.RESIDUALS_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.NAV_PRICE , value = "资产净值" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_STATUS , value = "设备状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_ID , value = "设备机柜" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_UP_NUMBER , value = "设备机柜上位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_DOWN_NUMBER , value = "设备机柜下位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetVOMeta.CATEGORY_ID)
	@SentinelResource(value = AssetServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.INSERT)
	public Result insert(AssetVO assetVO) {
		Result result=assetService.insert(assetVO);
		if(result.isSuccess()){
			 assetService.confirmOperation(assetVO.getId());
		}
		return result;
	}

	
	/**
	 * 删除资产
	*/
	@ApiOperation(value = "删除资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "489517168661102592"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetVOMeta.ID)
	@SentinelResource(value = AssetServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetVOMeta.IDS)
	@SentinelResource(value = AssetServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产
	*/
	@ApiOperation(value = "更新资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "489517168661102592"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_ID , value = "资产分类" , required = true , dataTypeClass=String.class , example = "486917781384597505"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_CODE , value = "分类编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BATCH_CODE , value = "批次编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_CODE , value = "资产编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SCRAP , value = "是否报废" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.GOODS_ID , value = "标准物品档案" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.NAME , value = "标准型号资产名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.MANUFACTURER_ID , value = "标准型号厂商" , required = false , dataTypeClass=String.class , example = "473623897560842240"),
		@ApiImplicitParam(name = AssetVOMeta.MODEL , value = "标准型号规格型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PICTURE_ID , value = "标准型号物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.UNIT , value = "标准型号计量单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
		@ApiImplicitParam(name = AssetVOMeta.SERIAL_NUMBER , value = "序列号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NUMBER , value = "资产数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetVOMeta.REMAIN_NUMBER , value = "剩余数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.RFID , value = "资产RFID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NOTES , value = "资产备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_NOTES , value = "维保备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CATEGORY_ID , value = "财务分类" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_RATE , value = "税额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.RESIDUALS_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.NAV_PRICE , value = "资产净值" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_STATUS , value = "设备状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_ID , value = "设备机柜" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_UP_NUMBER , value = "设备机柜上位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_DOWN_NUMBER , value = "设备机柜下位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetVOMeta.PAGE_INDEX , AssetVOMeta.PAGE_SIZE , AssetVOMeta.SEARCH_FIELD , AssetVOMeta.FUZZY_FIELD , AssetVOMeta.SEARCH_VALUE , AssetVOMeta.SORT_FIELD , AssetVOMeta.SORT_TYPE , AssetVOMeta.IDS } ) 
	@NotNull(name = AssetVOMeta.ID)
	@NotNull(name = AssetVOMeta.CATEGORY_ID)
	@SentinelResource(value = AssetServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.UPDATE)
	public Result update(AssetVO assetVO) {
		Result result=assetService.update(assetVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产
	*/
	@ApiOperation(value = "保存资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "489517168661102592"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_ID , value = "资产分类" , required = true , dataTypeClass=String.class , example = "486917781384597505"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_CODE , value = "分类编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BATCH_CODE , value = "批次编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_CODE , value = "资产编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SCRAP , value = "是否报废" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.GOODS_ID , value = "标准物品档案" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.NAME , value = "标准型号资产名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.MANUFACTURER_ID , value = "标准型号厂商" , required = false , dataTypeClass=String.class , example = "473623897560842240"),
		@ApiImplicitParam(name = AssetVOMeta.MODEL , value = "标准型号规格型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PICTURE_ID , value = "标准型号物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.UNIT , value = "标准型号计量单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
		@ApiImplicitParam(name = AssetVOMeta.SERIAL_NUMBER , value = "序列号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NUMBER , value = "资产数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetVOMeta.REMAIN_NUMBER , value = "剩余数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.RFID , value = "资产RFID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NOTES , value = "资产备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_NOTES , value = "维保备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CATEGORY_ID , value = "财务分类" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_RATE , value = "税额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.RESIDUALS_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.NAV_PRICE , value = "资产净值" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_STATUS , value = "设备状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_ID , value = "设备机柜" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_UP_NUMBER , value = "设备机柜上位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_DOWN_NUMBER , value = "设备机柜下位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetVOMeta.PAGE_INDEX , AssetVOMeta.PAGE_SIZE , AssetVOMeta.SEARCH_FIELD , AssetVOMeta.FUZZY_FIELD , AssetVOMeta.SEARCH_VALUE , AssetVOMeta.SORT_FIELD , AssetVOMeta.SORT_TYPE , AssetVOMeta.IDS } )
	@NotNull(name = AssetVOMeta.ID)
	@NotNull(name = AssetVOMeta.CATEGORY_ID)
	@SentinelResource(value = AssetServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.SAVE)
	public Result save(AssetVO assetVO) {
		Result result=assetService.save(assetVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产
	*/
	@ApiOperation(value = "获取资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetVOMeta.ID)
	@SentinelResource(value = AssetServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.GET_BY_ID)
	public Result<Asset> getById(String id) {
		Result<Asset> result=new Result<>();
		Asset asset=assetService.getById(id);
		// 关联出 资产分类 数据
		assetService.join(asset,AssetMeta.CATEGORY);
		// 关联出 物品档案 数据
		assetService.join(asset,AssetMeta.GOODS);
		// 关联出 厂商 数据
		assetService.join(asset,AssetMeta.MANUFACTURER);
		// 关联出 位置 数据
		assetService.join(asset,AssetMeta.POSITION);
		// 关联出 仓库 数据
		assetService.join(asset,AssetMeta.WAREHOUSE);
		// 关联出 来源 数据
		assetService.join(asset,AssetMeta.SOURCE);
		// 关联出 维保商 数据
		assetService.join(asset,AssetMeta.MAINTNAINER);
		// 关联出 财务分类 数据
		assetService.join(asset,AssetMeta.CATEGORY_FINANCE);
		// 关联出 供应商 数据
		assetService.join(asset,AssetMeta.SUPPLIER);


		assetService.join(asset,AssetMeta.OWNER_COMPANY);
		assetService.join(asset,AssetMeta.USE_ORGANIZATION);
		assetService.join(asset,AssetMeta.MANAGER);
		assetService.join(asset,AssetMeta.USE_USER);
		assetService.join(asset,AssetMeta.ORIGINATOR);
		result.success(true).data(asset);
		return result;
	}


	/**
	 * 批量删除资产 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetVOMeta.IDS)
		@SentinelResource(value = AssetServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.GET_BY_IDS)
	public Result<List<Asset>> getByIds(List<String> ids) {
		Result<List<Asset>> result=new Result<>();
		List<Asset> list=assetService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产
	*/
	@ApiOperation(value = "查询资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "489517168661102592"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_ID , value = "资产分类" , required = true , dataTypeClass=String.class , example = "486917781384597505"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_CODE , value = "分类编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BATCH_CODE , value = "批次编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_CODE , value = "资产编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SCRAP , value = "是否报废" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.GOODS_ID , value = "标准物品档案" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.NAME , value = "标准型号资产名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.MANUFACTURER_ID , value = "标准型号厂商" , required = false , dataTypeClass=String.class , example = "473623897560842240"),
		@ApiImplicitParam(name = AssetVOMeta.MODEL , value = "标准型号规格型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PICTURE_ID , value = "标准型号物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.UNIT , value = "标准型号计量单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
		@ApiImplicitParam(name = AssetVOMeta.SERIAL_NUMBER , value = "序列号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NUMBER , value = "资产数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetVOMeta.REMAIN_NUMBER , value = "剩余数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.RFID , value = "资产RFID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NOTES , value = "资产备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_NOTES , value = "维保备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CATEGORY_ID , value = "财务分类" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_RATE , value = "税额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.RESIDUALS_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.NAV_PRICE , value = "资产净值" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_STATUS , value = "设备状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_ID , value = "设备机柜" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_UP_NUMBER , value = "设备机柜上位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_DOWN_NUMBER , value = "设备机柜下位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetVOMeta.PAGE_INDEX , AssetVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.QUERY_LIST)
	public Result<List<Asset>> queryList(AssetVO sample) {
		Result<List<Asset>> result=new Result<>();
		List<Asset> list=assetService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产
	*/
	@ApiOperation(value = "分页查询资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "489517168661102592"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_ID , value = "资产分类" , required = true , dataTypeClass=String.class , example = "486917781384597505"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_CODE , value = "分类编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BATCH_CODE , value = "批次编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_CODE , value = "资产编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SCRAP , value = "是否报废" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.GOODS_ID , value = "标准物品档案" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.NAME , value = "标准型号资产名称" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.MANUFACTURER_ID , value = "标准型号厂商" , required = false , dataTypeClass=String.class , example = "473623897560842240"),
		@ApiImplicitParam(name = AssetVOMeta.MODEL , value = "标准型号规格型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PICTURE_ID , value = "标准型号物品图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.UNIT , value = "标准型号计量单位" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
		@ApiImplicitParam(name = AssetVOMeta.SERIAL_NUMBER , value = "序列号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NUMBER , value = "资产数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetVOMeta.REMAIN_NUMBER , value = "剩余数量" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.RFID , value = "资产RFID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NOTES , value = "资产备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_NOTES , value = "维保备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CATEGORY_ID , value = "财务分类" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_RATE , value = "税额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.RESIDUALS_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.NAV_PRICE , value = "资产净值" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = AssetVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_STATUS , value = "设备状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_ID , value = "设备机柜" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_UP_NUMBER , value = "设备机柜上位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_DOWN_NUMBER , value = "设备机柜下位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Asset>> queryPagedList(AssetVO sample) {
		Result<PagedList<Asset>> result=new Result<>();
		PagedList<Asset> list=assetService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 资产分类 数据
		assetService.join(list,AssetMeta.CATEGORY);
		// 关联出 物品档案 数据
		assetService.join(list,AssetMeta.GOODS);
		// 关联出 厂商 数据
		assetService.join(list,AssetMeta.MANUFACTURER);
		// 关联出 位置 数据
		assetService.join(list,AssetMeta.POSITION);
		// 关联出 仓库 数据
		assetService.join(list,AssetMeta.WAREHOUSE);
		// 关联出 来源 数据
		assetService.join(list,AssetMeta.SOURCE);
		// 关联出 维保商 数据
		assetService.join(list,AssetMeta.MAINTNAINER);
		// 关联出 财务分类 数据
		assetService.join(list,AssetMeta.CATEGORY_FINANCE);
		// 关联出 供应商 数据
		assetService.join(list,AssetMeta.SUPPLIER);

		assetService.join(list,AssetMeta.OWNER_COMPANY);
		assetService.join(list,AssetMeta.USE_ORGANIZATION);
		assetService.join(list,AssetMeta.MANAGER);
		assetService.join(list,AssetMeta.USE_USER);
		assetService.join(list,AssetMeta.ORIGINATOR);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产
	 */
	@ApiOperation(value = "分页查询资产")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "489517168661102592"),
			@ApiImplicitParam(name = AssetVOMeta.CATEGORY_ID , value = "资产分类" , required = true , dataTypeClass=String.class , example = "486917781384597505"),
			@ApiImplicitParam(name = AssetVOMeta.CATEGORY_CODE , value = "分类编码" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.BATCH_CODE , value = "批次编码" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.ASSET_CODE , value = "资产编号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.SCRAP , value = "是否报废" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.GOODS_ID , value = "标准物品档案" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.NAME , value = "标准型号资产名称" , required = false , dataTypeClass=String.class , example = "12"),
			@ApiImplicitParam(name = AssetVOMeta.MANUFACTURER_ID , value = "标准型号厂商" , required = false , dataTypeClass=String.class , example = "473623897560842240"),
			@ApiImplicitParam(name = AssetVOMeta.MODEL , value = "标准型号规格型号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.PICTURE_ID , value = "标准型号物品图片" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.UNIT , value = "标准型号计量单位" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
			@ApiImplicitParam(name = AssetVOMeta.SERIAL_NUMBER , value = "序列号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class , example = "1212"),
			@ApiImplicitParam(name = AssetVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
			@ApiImplicitParam(name = AssetVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.ASSET_NUMBER , value = "资产数量" , required = false , dataTypeClass=Integer.class , example = "1"),
			@ApiImplicitParam(name = AssetVOMeta.REMAIN_NUMBER , value = "剩余数量" , required = false , dataTypeClass=Integer.class , example = "1"),
			@ApiImplicitParam(name = AssetVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
			@ApiImplicitParam(name = AssetVOMeta.RFID , value = "资产RFID" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.ASSET_NOTES , value = "资产备注" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "12"),
			@ApiImplicitParam(name = AssetVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
			@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
			@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_NOTES , value = "维保备注" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CATEGORY_ID , value = "财务分类" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_RATE , value = "税额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.RESIDUALS_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.NAV_PRICE , value = "资产净值" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
			@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_STATUS , value = "设备状态" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.RACK_ID , value = "设备机柜" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.RACK_UP_NUMBER , value = "设备机柜上位置" , required = false , dataTypeClass=Integer.class),
			@ApiImplicitParam(name = AssetVOMeta.RACK_DOWN_NUMBER , value = "设备机柜下位置" , required = false , dataTypeClass=Integer.class),
			@ApiImplicitParam(name = AssetVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=9)
	@SentinelResource(value = AssetServiceProxy.QUERY_PAGED_LIST_BY_SELECT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.QUERY_PAGED_LIST_BY_SELECT)
	public Result<PagedList<Asset>> queryPagedListBySelect(AssetVO sample,String assetBussinessType,String assetOwnerId,String assetSelectedCode,String assetSearchContent) {


		Result<PagedList<Asset>> result=new Result<>();
		PagedList<Asset> list=assetService.queryPagedListBySelect(sample,assetBussinessType,assetOwnerId,assetSelectedCode,assetSearchContent);
		// 关联出 资产分类 数据
		assetService.join(list,AssetMeta.CATEGORY);
		// 关联出 物品档案 数据
		assetService.join(list,AssetMeta.GOODS);
		// 关联出 厂商 数据
		assetService.join(list,AssetMeta.MANUFACTURER);
		// 关联出 位置 数据
		assetService.join(list,AssetMeta.POSITION);
		// 关联出 来源 数据
		assetService.join(list,AssetMeta.SOURCE);
		// 关联出 维保商 数据
		assetService.join(list,AssetMeta.MAINTNAINER);
		// 关联出 供应商 数据
		assetService.join(list,AssetMeta.SUPPLIER);


		assetService.join(list,AssetMeta.OWNER_COMPANY);
		assetService.join(list,AssetMeta.USE_ORGANIZATION);
		assetService.join(list,AssetMeta.MANAGER);
		assetService.join(list,AssetMeta.USE_USER);
		assetService.join(list,AssetMeta.ORIGINATOR);


		result.success(true).data(list);
		return result;
	}



	/**
	 * 分页查询资产
	 */
	@ApiOperation(value = "分页查询资产")
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "489517168661102592"),
			@ApiImplicitParam(name = AssetVOMeta.CATEGORY_ID , value = "资产分类" , required = true , dataTypeClass=String.class , example = "486917781384597505"),
			@ApiImplicitParam(name = AssetVOMeta.CATEGORY_CODE , value = "分类编码" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.BATCH_CODE , value = "批次编码" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.ASSET_CODE , value = "资产编号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.ASSET_STATUS , value = "资产状态" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.SCRAP , value = "是否报废" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.GOODS_ID , value = "标准物品档案" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.NAME , value = "标准型号资产名称" , required = false , dataTypeClass=String.class , example = "12"),
			@ApiImplicitParam(name = AssetVOMeta.MANUFACTURER_ID , value = "标准型号厂商" , required = false , dataTypeClass=String.class , example = "473623897560842240"),
			@ApiImplicitParam(name = AssetVOMeta.MODEL , value = "标准型号规格型号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.PICTURE_ID , value = "标准型号物品图片" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.UNIT , value = "标准型号计量单位" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.SERVICE_LIFE , value = "使用期限" , required = false , dataTypeClass=BigDecimal.class , example = "1212.00"),
			@ApiImplicitParam(name = AssetVOMeta.SERIAL_NUMBER , value = "序列号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.OWN_COMPANY_ID , value = "所属公司" , required = false , dataTypeClass=String.class , example = "1212"),
			@ApiImplicitParam(name = AssetVOMeta.MANAGER_ID , value = "管理人员" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.USE_ORGANIZATION_ID , value = "使用公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
			@ApiImplicitParam(name = AssetVOMeta.USE_USER_ID , value = "使用人员" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.POSITION_ID , value = "存放位置" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.WAREHOUSE_ID , value = "仓库" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.SOURCE_ID , value = "来源" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.ASSET_NUMBER , value = "资产数量" , required = false , dataTypeClass=Integer.class , example = "1"),
			@ApiImplicitParam(name = AssetVOMeta.REMAIN_NUMBER , value = "剩余数量" , required = false , dataTypeClass=Integer.class , example = "1"),
			@ApiImplicitParam(name = AssetVOMeta.PURCHASE_DATE , value = "采购日期" , required = false , dataTypeClass=Date.class),
			@ApiImplicitParam(name = AssetVOMeta.RFID , value = "资产RFID" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.ASSET_NOTES , value = "资产备注" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "12"),
			@ApiImplicitParam(name = AssetVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
			@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
			@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_NOTES , value = "维保备注" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CATEGORY_ID , value = "财务分类" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_CODE , value = "财务编号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.SUPPLIER_ID , value = "资产供应商" , required = false , dataTypeClass=String.class , example = "[]"),
			@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_RATE , value = "税额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.TAXAMOUNT_PRICE , value = "含税金额" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.ORIGINAL_UNIT_PRICE , value = "资产原值(单价)" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.ACCUMULATED_DEPRECIATION , value = "累计折旧" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.RESIDUALS_RATE , value = "残值率" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.NAV_PRICE , value = "资产净值" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.PURCHASE_UNIT_PRICE , value = "采购单价" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
			@ApiImplicitParam(name = AssetVOMeta.ENTRY_TIME , value = "入账时间" , required = false , dataTypeClass=Date.class),
			@ApiImplicitParam(name = AssetVOMeta.FINANCIAL_NOTES , value = "财务备注" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CODE , value = "设备编号" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_STATUS , value = "设备状态" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_IP , value = "设备IP" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.MANAGE_IP , value = "管理IP" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CPU , value = "设备CPU" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_MEMORY , value = "设备内存" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.RACK_ID , value = "设备机柜" , required = false , dataTypeClass=String.class),
			@ApiImplicitParam(name = AssetVOMeta.RACK_UP_NUMBER , value = "设备机柜上位置" , required = false , dataTypeClass=Integer.class),
			@ApiImplicitParam(name = AssetVOMeta.RACK_DOWN_NUMBER , value = "设备机柜下位置" , required = false , dataTypeClass=Integer.class),
			@ApiImplicitParam(name = AssetVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=10)
	@SentinelResource(value = AssetServiceProxy.QUERY_PAGED_LIST_BY_SELECTED , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.QUERY_PAGED_LIST_BY_SELECTED)
	public Result<PagedList<Asset>> queryPagedListBySelected(AssetVO sample,String assetSelectedCode,String assetOwnerId,String dataType) {

		Result<PagedList<Asset>> result=new Result<>();
		PagedList<Asset> list=assetService.queryPagedListBySelected(sample,assetSelectedCode,assetOwnerId,dataType);
		// 关联出 资产分类 数据
		assetService.join(list,AssetMeta.CATEGORY);
		// 关联出 物品档案 数据
		assetService.join(list,AssetMeta.GOODS);
		// 关联出 厂商 数据
		assetService.join(list,AssetMeta.MANUFACTURER);
		// 关联出 位置 数据
		assetService.join(list,AssetMeta.POSITION);
		// 关联出 来源 数据
		assetService.join(list,AssetMeta.SOURCE);
		// 关联出 维保商 数据
		assetService.join(list,AssetMeta.MAINTNAINER);
		// 关联出 供应商 数据
		assetService.join(list,AssetMeta.SUPPLIER);

		assetService.join(list,AssetMeta.OWNER_COMPANY);
		assetService.join(list,AssetMeta.USE_ORGANIZATION);
		assetService.join(list,AssetMeta.MANAGER);
		assetService.join(list,AssetMeta.USE_USER);
		assetService.join(list,AssetMeta.ORIGINATOR);
		result.success(true).data(list);
		return result;
	}

	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}