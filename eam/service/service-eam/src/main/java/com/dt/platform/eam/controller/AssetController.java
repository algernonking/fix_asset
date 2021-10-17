package com.dt.platform.eam.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.deepoove.poi.util.PoitlIOUtils;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.constants.enums.ops.OpsOperateEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.CatalogData;
import org.github.foxnic.web.proxy.pcm.CatalogServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.util.IdGenerator;
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

import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
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

	@Autowired
	private IAssetDataService assetDataService;

	@Autowired
	private IAssetCategoryService assetCategoryService;
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
		@ApiImplicitParam(name = AssetVOMeta.SAFETY_LEVEL_CODE , value = "安全等级" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_STATUS , value = "维保状态" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_LABEL , value = "设备标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CONF , value = "设备配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_ENVIRONMENT_CODE , value = "设备运行环境" , required = false , dataTypeClass=String.class),
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
	public Result insert(Asset assetVO) {
		String id= IDGenerator.getSnowflakeIdString();
		assetVO.setId(id);
		assetVO.setOwnerCode(AssetOwnerCodeEnum.ASSET.code());
		//先保存自定义属性
		if(assetVO.getPcmData()!=null&&assetVO.getPcmData().size()>0){
			CatalogData pcmData=new CatalogData();
			pcmData.setData(assetVO.getPcmData());
			pcmData.setOwnerId(id);
			pcmData.setCatalogId(assetVO.getCategoryId());
			pcmData.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
			Result pcmResult=CatalogServiceProxy.api().saveData(pcmData);
			if(!pcmResult.isSuccess()){
				return pcmResult;
			}
		}
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

		Asset data=assetService.getById(id);
		if(AssetHandleStatusEnum.CANCEL.code().equals(data.getStatus())
				||AssetHandleStatusEnum.INCOMPLETE.code().equals(data.getStatus()) ){
			Result result=assetService.deleteByIdLogical(id);
			return result;
		}else{
			return ErrorDesc.failureMessage("当前状态无法进行删除操作");
		}

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
		@ApiImplicitParam(name = AssetVOMeta.SAFETY_LEVEL_CODE , value = "安全等级" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_STATUS , value = "维保状态" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_LABEL , value = "设备标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CONF , value = "设备配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_ENVIRONMENT_CODE , value = "设备运行环境" , required = false , dataTypeClass=String.class),
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
	public Result update(Asset assetVO) {
		//保存自定义属性
		if(assetVO.getPcmData()!=null&&assetVO.getPcmData().size()>0){
			//删除原来
			String idValue=assetVO.getPcmData().get("id").toString();
			CatalogData pcmData=new CatalogData();
			pcmData.setId(idValue);
			pcmData.setData(assetVO.getPcmData());
			pcmData.setOwnerId(assetVO.getId());
			pcmData.setCatalogId(assetVO.getCategoryId());
			pcmData.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
			System.out.println("update pcm data:");
			System.out.println("getId:"+pcmData.getId());
			System.out.println("getOwnerId:"+pcmData.getOwnerId());
			System.out.println("getTenantId:"+pcmData.getTenantId());
			System.out.println("getCatalogId:"+pcmData.getCatalogId());
			System.out.println("getData:"+pcmData.getData());
			Result pcmResult=CatalogServiceProxy.api().saveData(pcmData);
			if(!pcmResult.isSuccess()){
				return pcmResult;
			}
		}
		Result result=assetService.update(assetVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产
	*/
	@ApiOperation(value = "保存资产")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "489517168661102592"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486917781384597505"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_CODE , value = "分类编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BATCH_CODE , value = "批次编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.SAFETY_LEVEL_CODE , value = "安全等级" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.PRODUCTION_DATE , value = "生产日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.RFID , value = "资产RFID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.LAST_VERIFICATION_DATE , value = "最近核对日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.PURPOSE , value = "用途" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NOTES , value = "资产备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_STATUS , value = "维保状态" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_LABEL , value = "设备标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CONF , value = "设备配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_ENVIRONMENT_CODE , value = "设备运行环境" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_SERIAL_NUMBER , value = "设备序列号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_ID , value = "设备机柜" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_UP_NUMBER , value = "设备机柜上位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_DOWN_NUMBER , value = "设备机柜下位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.INTERNAL_CONTROL_LABEL , value = "内部控制标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BILL_ID , value = "单据" , required = false , dataTypeClass=String.class),
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

		assetService.dao().fill(asset).with(AssetMeta.CATEGORY)
				.with(AssetMeta.GOODS)
				.with(AssetMeta.MANUFACTURER)
				.with(AssetMeta.POSITION)
				.with(AssetMeta.MAINTNAINER)
				.with(AssetMeta.SUPPLIER)
				.with(AssetMeta.SAFETY_LEVEL)
				.with(AssetMeta.EQUIPMENT_ENVIRONMENT)
				.with(AssetMeta.OWNER_COMPANY)
				.with(AssetMeta.USE_ORGANIZATION)
				.with(AssetMeta.MANAGER)
				.with(AssetMeta.USE_USER)
				.with(AssetMeta.ORIGINATOR)
				.with(AssetMeta.RACK)
				.execute();
		// 关联出 资产分类 数据
//		assetService.join(asset,AssetMeta.CATEGORY);
//		// 关联出 物品档案 数据
//		assetService.join(asset,AssetMeta.GOODS);
//		// 关联出 厂商 数据
//		assetService.join(asset,AssetMeta.MANUFACTURER);
//		// 关联出 位置 数据
//		assetService.join(asset,AssetMeta.POSITION);
//		// 关联出 仓库 数据
//		assetService.join(asset,AssetMeta.WAREHOUSE);
//		// 关联出 来源 数据
//		assetService.join(asset,AssetMeta.SOURCE);
//		// 关联出 维保商 数据
//		assetService.join(asset,AssetMeta.MAINTNAINER);
//		// 关联出 财务分类 数据
//		assetService.join(asset,AssetMeta.CATEGORY_FINANCE);
//		// 关联出 供应商 数据
//		assetService.join(asset,AssetMeta.SUPPLIER);
//		assetService.join(asset,AssetMeta.SAFETY_LEVEL);
//		assetService.join(asset,AssetMeta.EQUIPMENT_ENVIRONMENT);
//		assetService.join(asset,AssetMeta.OWNER_COMPANY);
//		assetService.join(asset,AssetMeta.USE_ORGANIZATION);
//		assetService.join(asset,AssetMeta.MANAGER);
//		assetService.join(asset,AssetMeta.USE_USER);
//		assetService.join(asset,AssetMeta.ORIGINATOR);

		//加载自定义数据
		asset.setCatalogAttribute(assetCategoryService.queryCatalogAttributeByAssetCategory(asset.getCategoryId()));
		asset.setExtData(assetService.getExtDataById(asset.getId(),asset.getCategoryId()));
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
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486917781384597505"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_CODE , value = "分类编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BATCH_CODE , value = "批次编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.SAFETY_LEVEL_CODE , value = "安全等级" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.PRODUCTION_DATE , value = "生产日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.RFID , value = "资产RFID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.LAST_VERIFICATION_DATE , value = "最近核对日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.PURPOSE , value = "用途" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NOTES , value = "资产备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_STATUS , value = "维保状态" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_LABEL , value = "设备标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CONF , value = "设备配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_ENVIRONMENT_CODE , value = "设备运行环境" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_SERIAL_NUMBER , value = "设备序列号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_ID , value = "设备机柜" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_UP_NUMBER , value = "设备机柜上位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_DOWN_NUMBER , value = "设备机柜下位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.INTERNAL_CONTROL_LABEL , value = "内部控制标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BILL_ID , value = "单据" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_ID , value = "资产分类" , required = false , dataTypeClass=String.class , example = "486917781384597505"),
		@ApiImplicitParam(name = AssetVOMeta.CATEGORY_CODE , value = "分类编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BATCH_CODE , value = "批次编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.OWNER_CODE , value = "归属" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.SAFETY_LEVEL_CODE , value = "安全等级" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.PRODUCTION_DATE , value = "生产日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.RFID , value = "资产RFID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.LAST_VERIFICATION_DATE , value = "最近核对日期" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetVOMeta.PURPOSE , value = "用途" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ASSET_NOTES , value = "资产备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.MAINTAINER_NAME , value = "维保厂商" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetVOMeta.MAINTENANCE_STATUS , value = "维保状态" , required = false , dataTypeClass=String.class),
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
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_LABEL , value = "设备标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_CONF , value = "设备配置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_ENVIRONMENT_CODE , value = "设备运行环境" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.EQUIPMENT_SERIAL_NUMBER , value = "设备序列号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_ID , value = "设备机柜" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_UP_NUMBER , value = "设备机柜上位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.RACK_DOWN_NUMBER , value = "设备机柜下位置" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.INTERNAL_CONTROL_LABEL , value = "内部控制标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.BILL_ID , value = "单据" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Asset>> queryPagedList(AssetVO sample) {

		Result<PagedList<Asset>> result=new Result<>();
		PagedList<Asset> list=assetService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		assetService.joinData(list);
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
		assetService.joinData(list);

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
		assetService.joinData(list);
		result.success(true).data(list);
		return result;
	}

	/**
	 * 批量送审
	 * */
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@NotNull(name = AssetVOMeta.IDS)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetServiceProxy.FOR_BATCH_APPROVAL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetServiceProxy.FOR_BATCH_APPROVAL)
	public Result forBatchApproval(List<String> ids)  {
		return assetService.forBatchApproval(ids);
	}

	/**
	 * 批量确认
	 * */
	@ApiImplicitParams({
			@ApiImplicitParam(name = AssetVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@NotNull(name = AssetVOMeta.IDS)
	@ApiOperationSupport(order=12)
	@SentinelResource(value = AssetServiceProxy.BATCH_CONFIRM_OPERATION , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetServiceProxy.BATCH_CONFIRM_OPERATION)
	public Result batchConfirmOperation(List<String> ids)  {
		return assetService.batchConfirmOperation(ids);
	}

	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetVO  sample,HttpServletResponse response,String categoryId) throws Exception {

		//生成 Excel 数据
		InputStream inputstream= assetService.buildExcelTemplate(categoryId);
		if(inputstream==null){
			return;
		}

		File f=assetDataService.saveTempFile(inputstream,"TMP_download_asset_data.xls");
		Map<String,Object> map= assetDataService.queryAssetMap(assetDataService.queryAssetPagedList(null,sample),categoryId);

		TemplateExportParams templateExportParams = new TemplateExportParams(f.getPath());
		templateExportParams.setScanAllsheet(true);
		Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("资产数据.xls", "UTF-8"))));
		response.setContentType("application/vnd.ms-excel");
		OutputStream out = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(out);
		workbook.write(bos);
		bos.flush();
		out.flush();
		PoitlIOUtils.closeQuietlyMulti(workbook, bos, out);


	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public Result exportExcelTemplate(HttpServletResponse response,String categoryId) throws Exception {
		//生成 Excel 模版
		//categoryId="497488128370540545";
		InputStream inputstream=assetService.buildExcelTemplate(categoryId);
		if(inputstream==null){
			return ErrorDesc.failure().message("获取模板文件失败");
		}
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("资产模板.xls", "UTF-8"))));
		response.setContentType("application/vnd.ms-excel");
		OutputStream out = response.getOutputStream();
		IOUtils.copy(inputstream,out);
		out.flush();
		return ErrorDesc.success();

		}




	@SentinelResource(value = AssetServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response,String dataType,String categoryId) throws Exception {

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

			boolean dataFill=false;
			if( (!StringUtil.isBlank(dataType))
					&& AssetDataImportProcessTypeEnum.DATA_FILL.code().equals(dataType) ){
					dataFill=true;
			}
			dataFill=true;
			List<ValidateResult> errors=assetService.importExcel(input,0,true,AssetOwnerCodeEnum.ASSET.code(),AssetOperateEnum.EAM_ASSET_INSERT.code(),dataFill);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				System.out.println("import Result:");
				for(int i=0;i<errors.size();i++){
					System.out.println(i+":"+errors.get(i).message);
				}
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}