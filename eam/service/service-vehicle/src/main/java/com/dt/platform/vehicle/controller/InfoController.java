package com.dt.platform.vehicle.controller;


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


import com.dt.platform.proxy.vehicle.InfoServiceProxy;
import com.dt.platform.domain.vehicle.meta.InfoVOMeta;
import com.dt.platform.domain.vehicle.Info;
import com.dt.platform.domain.vehicle.InfoVO;
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
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.vehicle.service.IInfoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆信息 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-01 21:16:00
*/

@Api(tags = "车辆信息")
@ApiSort(0)
@RestController("VehicleInfoController")
public class InfoController extends SuperController {

	@Autowired
	private IInfoService infoService;


	/**
	 * 添加车辆信息
	*/
	@ApiOperation(value = "添加车辆信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.REGISTRANT , value = "车牌号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.TYPE , value = "车辆类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.CODE , value = "登记人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.MODEL , value = "品牌型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.ENGINE_NUMBER , value = "发动机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.FRAME_NUMBER , value = "车架号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.DRIVING_LICENSE , value = "行驶证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.KILOMETERS , value = "公里数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.RESCUE_MONEY , value = "抢险(元)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.COMMERCIAL_INSURANCE_MONEY , value = "商业险(元)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_COMPANY , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.LICENSING_TIME , value = "上牌时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InfoVOMeta.SCRAP_TIME , value = "报废时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InfoVOMeta.POSITION_DETAIL , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.PICTURES , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.INSERT)
	public Result insert(InfoVO infoVO) {
		Result result=infoService.insert(infoVO,false);
		return result;
	}



	/**
	 * 删除车辆信息
	*/
	@ApiOperation(value = "删除车辆信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InfoVOMeta.ID)
	@SentinelResource(value = InfoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=infoService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆信息 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InfoVOMeta.IDS)
	@SentinelResource(value = InfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=infoService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新车辆信息
	*/
	@ApiOperation(value = "更新车辆信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.REGISTRANT , value = "车牌号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.TYPE , value = "车辆类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.CODE , value = "登记人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.MODEL , value = "品牌型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.ENGINE_NUMBER , value = "发动机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.FRAME_NUMBER , value = "车架号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.DRIVING_LICENSE , value = "行驶证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.KILOMETERS , value = "公里数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.RESCUE_MONEY , value = "抢险(元)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.COMMERCIAL_INSURANCE_MONEY , value = "商业险(元)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_COMPANY , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.LICENSING_TIME , value = "上牌时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InfoVOMeta.SCRAP_TIME , value = "报废时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InfoVOMeta.POSITION_DETAIL , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.PICTURES , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InfoVOMeta.PAGE_INDEX , InfoVOMeta.PAGE_SIZE , InfoVOMeta.SEARCH_FIELD , InfoVOMeta.FUZZY_FIELD , InfoVOMeta.SEARCH_VALUE , InfoVOMeta.DIRTY_FIELDS , InfoVOMeta.SORT_FIELD , InfoVOMeta.SORT_TYPE , InfoVOMeta.IDS } )
	@NotNull(name = InfoVOMeta.ID)
	@SentinelResource(value = InfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.UPDATE)
	public Result update(InfoVO infoVO) {
		Result result=infoService.update(infoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆信息
	*/
	@ApiOperation(value = "保存车辆信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.REGISTRANT , value = "车牌号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.TYPE , value = "车辆类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.CODE , value = "登记人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.MODEL , value = "品牌型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.ENGINE_NUMBER , value = "发动机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.FRAME_NUMBER , value = "车架号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.DRIVING_LICENSE , value = "行驶证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.KILOMETERS , value = "公里数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.RESCUE_MONEY , value = "抢险(元)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.COMMERCIAL_INSURANCE_MONEY , value = "商业险(元)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_COMPANY , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.LICENSING_TIME , value = "上牌时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InfoVOMeta.SCRAP_TIME , value = "报废时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InfoVOMeta.POSITION_DETAIL , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.PICTURES , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InfoVOMeta.PAGE_INDEX , InfoVOMeta.PAGE_SIZE , InfoVOMeta.SEARCH_FIELD , InfoVOMeta.FUZZY_FIELD , InfoVOMeta.SEARCH_VALUE , InfoVOMeta.DIRTY_FIELDS , InfoVOMeta.SORT_FIELD , InfoVOMeta.SORT_TYPE , InfoVOMeta.IDS } )
	@NotNull(name = InfoVOMeta.ID)
	@SentinelResource(value = InfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.SAVE)
	public Result save(InfoVO infoVO) {
		Result result=infoService.save(infoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆信息
	*/
	@ApiOperation(value = "获取车辆信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InfoVOMeta.ID)
	@SentinelResource(value = InfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.GET_BY_ID)
	public Result<Info> getById(String id) {
		Result<Info> result=new Result<>();
		Info info=infoService.getById(id);
		result.success(true).data(info);
		return result;
	}


	/**
	 * 批量获取车辆信息 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆信息")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InfoVOMeta.IDS)
		@SentinelResource(value = InfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.GET_BY_IDS)
	public Result<List<Info>> getByIds(List<String> ids) {
		Result<List<Info>> result=new Result<>();
		List<Info> list=infoService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆信息
	*/
	@ApiOperation(value = "查询车辆信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.REGISTRANT , value = "车牌号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.TYPE , value = "车辆类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.CODE , value = "登记人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.MODEL , value = "品牌型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.ENGINE_NUMBER , value = "发动机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.FRAME_NUMBER , value = "车架号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.DRIVING_LICENSE , value = "行驶证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.KILOMETERS , value = "公里数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.RESCUE_MONEY , value = "抢险(元)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.COMMERCIAL_INSURANCE_MONEY , value = "商业险(元)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_COMPANY , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.LICENSING_TIME , value = "上牌时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InfoVOMeta.SCRAP_TIME , value = "报废时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InfoVOMeta.POSITION_DETAIL , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.PICTURES , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InfoVOMeta.PAGE_INDEX , InfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.QUERY_LIST)
	public Result<List<Info>> queryList(InfoVO sample) {
		Result<List<Info>> result=new Result<>();
		List<Info> list=infoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆信息
	*/
	@ApiOperation(value = "分页查询车辆信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.REGISTRANT , value = "车牌号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.TYPE , value = "车辆类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.CODE , value = "登记人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.MODEL , value = "品牌型号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.COLOR , value = "颜色" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.ENGINE_NUMBER , value = "发动机号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.FRAME_NUMBER , value = "车架号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.DRIVING_LICENSE , value = "行驶证" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.KILOMETERS , value = "公里数" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.RESCUE_MONEY , value = "抢险(元)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.COMMERCIAL_INSURANCE_MONEY , value = "商业险(元)" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = InfoVOMeta.INSURANCE_COMPANY , value = "保险公司" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.LICENSING_TIME , value = "上牌时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InfoVOMeta.SCRAP_TIME , value = "报废时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InfoVOMeta.POSITION_DETAIL , value = "位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.PICTURES , value = "图片" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Info>> queryPagedList(InfoVO sample) {
		Result<PagedList<Info>> result=new Result<>();
		PagedList<Info> list=infoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InfoServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InfoServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InfoVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=infoService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InfoServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InfoServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=infoService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = InfoServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InfoServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=infoService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}