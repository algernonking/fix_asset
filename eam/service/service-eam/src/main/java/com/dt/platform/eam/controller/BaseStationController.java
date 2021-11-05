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


import com.dt.platform.proxy.eam.BaseStationServiceProxy;
import com.dt.platform.domain.eam.meta.BaseStationVOMeta;
import com.dt.platform.domain.eam.BaseStation;
import com.dt.platform.domain.eam.BaseStationVO;
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
import com.dt.platform.domain.eam.meta.BaseStationMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.Position;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IBaseStationService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * rfid基站 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-03 15:24:02
*/

@Api(tags = "rfid基站")
@ApiSort(0)
@RestController("RfidBaseStationController")
public class BaseStationController extends SuperController {

	@Autowired
	private IBaseStationService baseStationService;


	/**
	 * 添加rfid基站
	*/
	@ApiOperation(value = "添加rfid基站")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BaseStationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "508285659077672960"),
		@ApiImplicitParam(name = BaseStationVOMeta.AREA_ID , value = "区域主键" , required = false , dataTypeClass=String.class , example = "508223910764875777"),
		@ApiImplicitParam(name = BaseStationVOMeta.NAME , value = "基站名称" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = BaseStationVOMeta.LONGITUDE , value = "经度" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = BaseStationVOMeta.LATITUDE , value = "纬度" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = BaseStationVOMeta.DEVICE_ID , value = "设备ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = BaseStationVOMeta.DEVICE_TYPE , value = "设备类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BaseStationVOMeta.IS_ON_LINE , value = "是否在线" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = BaseStationVOMeta.WORK_TYPE , value = "工作类型" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = BaseStationServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BaseStationServiceProxy.INSERT)
	public Result insert(BaseStationVO baseStationVO) {
		Result result=baseStationService.insert(baseStationVO);
		return result;
	}



	/**
	 * 删除rfid基站
	*/
	@ApiOperation(value = "删除rfid基站")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BaseStationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "508285659077672960")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = BaseStationVOMeta.ID)
	@SentinelResource(value = BaseStationServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BaseStationServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=baseStationService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除rfid基站 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除rfid基站")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BaseStationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = BaseStationVOMeta.IDS)
	@SentinelResource(value = BaseStationServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BaseStationServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=baseStationService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新rfid基站
	*/
	@ApiOperation(value = "更新rfid基站")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BaseStationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "508285659077672960"),
		@ApiImplicitParam(name = BaseStationVOMeta.AREA_ID , value = "区域主键" , required = false , dataTypeClass=String.class , example = "508223910764875777"),
		@ApiImplicitParam(name = BaseStationVOMeta.NAME , value = "基站名称" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = BaseStationVOMeta.LONGITUDE , value = "经度" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = BaseStationVOMeta.LATITUDE , value = "纬度" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = BaseStationVOMeta.DEVICE_ID , value = "设备ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = BaseStationVOMeta.DEVICE_TYPE , value = "设备类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BaseStationVOMeta.IS_ON_LINE , value = "是否在线" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = BaseStationVOMeta.WORK_TYPE , value = "工作类型" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { BaseStationVOMeta.PAGE_INDEX , BaseStationVOMeta.PAGE_SIZE , BaseStationVOMeta.SEARCH_FIELD , BaseStationVOMeta.FUZZY_FIELD , BaseStationVOMeta.SEARCH_VALUE , BaseStationVOMeta.SORT_FIELD , BaseStationVOMeta.SORT_TYPE , BaseStationVOMeta.IDS } )
	@NotNull(name = BaseStationVOMeta.ID)
	@SentinelResource(value = BaseStationServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BaseStationServiceProxy.UPDATE)
	public Result update(BaseStationVO baseStationVO) {
		Result result=baseStationService.update(baseStationVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存rfid基站
	*/
	@ApiOperation(value = "保存rfid基站")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BaseStationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "508285659077672960"),
		@ApiImplicitParam(name = BaseStationVOMeta.AREA_ID , value = "区域主键" , required = false , dataTypeClass=String.class , example = "508223910764875777"),
		@ApiImplicitParam(name = BaseStationVOMeta.NAME , value = "基站名称" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = BaseStationVOMeta.LONGITUDE , value = "经度" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = BaseStationVOMeta.LATITUDE , value = "纬度" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = BaseStationVOMeta.DEVICE_ID , value = "设备ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = BaseStationVOMeta.DEVICE_TYPE , value = "设备类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BaseStationVOMeta.IS_ON_LINE , value = "是否在线" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = BaseStationVOMeta.WORK_TYPE , value = "工作类型" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BaseStationVOMeta.PAGE_INDEX , BaseStationVOMeta.PAGE_SIZE , BaseStationVOMeta.SEARCH_FIELD , BaseStationVOMeta.FUZZY_FIELD , BaseStationVOMeta.SEARCH_VALUE , BaseStationVOMeta.SORT_FIELD , BaseStationVOMeta.SORT_TYPE , BaseStationVOMeta.IDS } )
	@NotNull(name = BaseStationVOMeta.ID)
	@SentinelResource(value = BaseStationServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BaseStationServiceProxy.SAVE)
	public Result save(BaseStationVO baseStationVO) {
		Result result=baseStationService.save(baseStationVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取rfid基站
	*/
	@ApiOperation(value = "获取rfid基站")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BaseStationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = BaseStationVOMeta.ID)
	@SentinelResource(value = BaseStationServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BaseStationServiceProxy.GET_BY_ID)
	public Result<BaseStation> getById(String id) {
		Result<BaseStation> result=new Result<>();
		BaseStation baseStation=baseStationService.getById(id);

		// join 关联的对象
		baseStationService.dao().fill(baseStation)
			.with(BaseStationMeta.DEVICE_AREA)
			.execute();

		result.success(true).data(baseStation);
		return result;
	}


	/**
	 * 批量获取rfid基站 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取rfid基站")
		@ApiImplicitParams({
				@ApiImplicitParam(name = BaseStationVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = BaseStationVOMeta.IDS)
		@SentinelResource(value = BaseStationServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BaseStationServiceProxy.GET_BY_IDS)
	public Result<List<BaseStation>> getByIds(List<String> ids) {
		Result<List<BaseStation>> result=new Result<>();
		List<BaseStation> list=baseStationService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询rfid基站
	*/
	@ApiOperation(value = "查询rfid基站")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BaseStationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "508285659077672960"),
		@ApiImplicitParam(name = BaseStationVOMeta.AREA_ID , value = "区域主键" , required = false , dataTypeClass=String.class , example = "508223910764875777"),
		@ApiImplicitParam(name = BaseStationVOMeta.NAME , value = "基站名称" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = BaseStationVOMeta.LONGITUDE , value = "经度" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = BaseStationVOMeta.LATITUDE , value = "纬度" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = BaseStationVOMeta.DEVICE_ID , value = "设备ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = BaseStationVOMeta.DEVICE_TYPE , value = "设备类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BaseStationVOMeta.IS_ON_LINE , value = "是否在线" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = BaseStationVOMeta.WORK_TYPE , value = "工作类型" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BaseStationVOMeta.PAGE_INDEX , BaseStationVOMeta.PAGE_SIZE } )
	@SentinelResource(value = BaseStationServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BaseStationServiceProxy.QUERY_LIST)
	public Result<List<BaseStation>> queryList(BaseStationVO sample) {
		Result<List<BaseStation>> result=new Result<>();
		List<BaseStation> list=baseStationService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询rfid基站
	*/
	@ApiOperation(value = "分页查询rfid基站")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BaseStationVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "508285659077672960"),
		@ApiImplicitParam(name = BaseStationVOMeta.AREA_ID , value = "区域主键" , required = false , dataTypeClass=String.class , example = "508223910764875777"),
		@ApiImplicitParam(name = BaseStationVOMeta.NAME , value = "基站名称" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = BaseStationVOMeta.LONGITUDE , value = "经度" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = BaseStationVOMeta.LATITUDE , value = "纬度" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = BaseStationVOMeta.DEVICE_ID , value = "设备ID" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = BaseStationVOMeta.DEVICE_TYPE , value = "设备类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BaseStationVOMeta.IS_ON_LINE , value = "是否在线" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = BaseStationVOMeta.WORK_TYPE , value = "工作类型" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = BaseStationServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BaseStationServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<BaseStation>> queryPagedList(BaseStationVO sample) {
		Result<PagedList<BaseStation>> result=new Result<>();
		PagedList<BaseStation> list=baseStationService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		baseStationService.dao().fill(list)
			.with(BaseStationMeta.DEVICE_AREA)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = BaseStationServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(BaseStationServiceProxy.EXPORT_EXCEL)
	public void exportExcel(BaseStationVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=baseStationService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = BaseStationServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(BaseStationServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=baseStationService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = BaseStationServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(BaseStationServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=baseStationService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}