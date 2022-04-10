package com.dt.platform.datacenter.controller;


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


import com.dt.platform.proxy.datacenter.RackServiceProxy;
import com.dt.platform.domain.datacenter.meta.RackVOMeta;
import com.dt.platform.domain.datacenter.Rack;
import com.dt.platform.domain.datacenter.RackVO;
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
import com.dt.platform.domain.datacenter.meta.RackMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.datacenter.Area;
import com.dt.platform.domain.datacenter.Layer;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.datacenter.service.IRackService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 机柜 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-10 09:17:35
*/

@Api(tags = "机柜")
@ApiSort(0)
@RestController("DcRackController")
public class RackController extends SuperController {

	@Autowired
	private IRackService rackService;


	/**
	 * 添加机柜
	*/
	@ApiOperation(value = "添加机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565459579211616256"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "scattered"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "JJJ"),
		@ApiImplicitParam(name = RackVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "reserve"),
		@ApiImplicitParam(name = RackVOMeta.ENVIRONMENT , value = "环境" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackVOMeta.RACK_USED_TYPE , value = "使用分类" , required = false , dataTypeClass=String.class , example = "network"),
		@ApiImplicitParam(name = RackVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "565457749140312064"),
		@ApiImplicitParam(name = RackVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "565457784187916288"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CAPTICAL , value = "容量" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = RackVOMeta.U_POSTION_NUMBER , value = "U位数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RackVOMeta.PDU_NUMBER , value = "PDU数量" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.JUMPER_NUMBER , value = "跳线数" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.CONTRACT_POWER , value = "合同电力" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.EQUIPMENT_NUMBER , value = "设备数量" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = RackVOMeta.EXPIRE_DATE , value = "到期日期" , required = false , dataTypeClass=Date.class , example = "2022-04-14 12:00:00"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RackServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.INSERT)
	public Result insert(RackVO rackVO) {
		Result result=rackService.insert(rackVO,false);
		return result;
	}



	/**
	 * 删除机柜
	*/
	@ApiOperation(value = "删除机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565459579211616256")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RackVOMeta.ID)
	@SentinelResource(value = RackServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=rackService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除机柜 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RackVOMeta.IDS)
	@SentinelResource(value = RackServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=rackService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新机柜
	*/
	@ApiOperation(value = "更新机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565459579211616256"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "scattered"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "JJJ"),
		@ApiImplicitParam(name = RackVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "reserve"),
		@ApiImplicitParam(name = RackVOMeta.ENVIRONMENT , value = "环境" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackVOMeta.RACK_USED_TYPE , value = "使用分类" , required = false , dataTypeClass=String.class , example = "network"),
		@ApiImplicitParam(name = RackVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "565457749140312064"),
		@ApiImplicitParam(name = RackVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "565457784187916288"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CAPTICAL , value = "容量" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = RackVOMeta.U_POSTION_NUMBER , value = "U位数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RackVOMeta.PDU_NUMBER , value = "PDU数量" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.JUMPER_NUMBER , value = "跳线数" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.CONTRACT_POWER , value = "合同电力" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.EQUIPMENT_NUMBER , value = "设备数量" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = RackVOMeta.EXPIRE_DATE , value = "到期日期" , required = false , dataTypeClass=Date.class , example = "2022-04-14 12:00:00"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RackVOMeta.PAGE_INDEX , RackVOMeta.PAGE_SIZE , RackVOMeta.SEARCH_FIELD , RackVOMeta.FUZZY_FIELD , RackVOMeta.SEARCH_VALUE , RackVOMeta.DIRTY_FIELDS , RackVOMeta.SORT_FIELD , RackVOMeta.SORT_TYPE , RackVOMeta.IDS } )
	@NotNull(name = RackVOMeta.ID)
	@SentinelResource(value = RackServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.UPDATE)
	public Result update(RackVO rackVO) {
		Result result=rackService.update(rackVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存机柜
	*/
	@ApiOperation(value = "保存机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565459579211616256"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "scattered"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "JJJ"),
		@ApiImplicitParam(name = RackVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "reserve"),
		@ApiImplicitParam(name = RackVOMeta.ENVIRONMENT , value = "环境" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackVOMeta.RACK_USED_TYPE , value = "使用分类" , required = false , dataTypeClass=String.class , example = "network"),
		@ApiImplicitParam(name = RackVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "565457749140312064"),
		@ApiImplicitParam(name = RackVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "565457784187916288"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CAPTICAL , value = "容量" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = RackVOMeta.U_POSTION_NUMBER , value = "U位数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RackVOMeta.PDU_NUMBER , value = "PDU数量" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.JUMPER_NUMBER , value = "跳线数" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.CONTRACT_POWER , value = "合同电力" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.EQUIPMENT_NUMBER , value = "设备数量" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = RackVOMeta.EXPIRE_DATE , value = "到期日期" , required = false , dataTypeClass=Date.class , example = "2022-04-14 12:00:00"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RackVOMeta.PAGE_INDEX , RackVOMeta.PAGE_SIZE , RackVOMeta.SEARCH_FIELD , RackVOMeta.FUZZY_FIELD , RackVOMeta.SEARCH_VALUE , RackVOMeta.DIRTY_FIELDS , RackVOMeta.SORT_FIELD , RackVOMeta.SORT_TYPE , RackVOMeta.IDS } )
	@NotNull(name = RackVOMeta.ID)
	@SentinelResource(value = RackServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.SAVE)
	public Result save(RackVO rackVO) {
		Result result=rackService.save(rackVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取机柜
	*/
	@ApiOperation(value = "获取机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RackVOMeta.ID)
	@SentinelResource(value = RackServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.GET_BY_ID)
	public Result<Rack> getById(String id) {
		Result<Rack> result=new Result<>();
		Rack rack=rackService.getById(id);
		// join 关联的对象
		rackService.dao().fill(rack)
			.with(RackMeta.STATUS_DICT)
			.with(RackMeta.TYPE_DICT)
			.with(RackMeta.USED_TYPE_DICT)
			.with(RackMeta.ENVIRONMENT_DICT)
			.with(RackMeta.AREA)
			.with(RackMeta.LAYER)
			.execute();
		result.success(true).data(rack);
		return result;
	}


	/**
	 * 批量获取机柜 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取机柜")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RackVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RackVOMeta.IDS)
		@SentinelResource(value = RackServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.GET_BY_IDS)
	public Result<List<Rack>> getByIds(List<String> ids) {
		Result<List<Rack>> result=new Result<>();
		List<Rack> list=rackService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询机柜
	*/
	@ApiOperation(value = "查询机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565459579211616256"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "scattered"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "JJJ"),
		@ApiImplicitParam(name = RackVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "reserve"),
		@ApiImplicitParam(name = RackVOMeta.ENVIRONMENT , value = "环境" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackVOMeta.RACK_USED_TYPE , value = "使用分类" , required = false , dataTypeClass=String.class , example = "network"),
		@ApiImplicitParam(name = RackVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "565457749140312064"),
		@ApiImplicitParam(name = RackVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "565457784187916288"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CAPTICAL , value = "容量" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = RackVOMeta.U_POSTION_NUMBER , value = "U位数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RackVOMeta.PDU_NUMBER , value = "PDU数量" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.JUMPER_NUMBER , value = "跳线数" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.CONTRACT_POWER , value = "合同电力" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.EQUIPMENT_NUMBER , value = "设备数量" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = RackVOMeta.EXPIRE_DATE , value = "到期日期" , required = false , dataTypeClass=Date.class , example = "2022-04-14 12:00:00"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RackVOMeta.PAGE_INDEX , RackVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RackServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.QUERY_LIST)
	public Result<List<Rack>> queryList(RackVO sample) {
		Result<List<Rack>> result=new Result<>();
		List<Rack> list=rackService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询机柜
	*/
	@ApiOperation(value = "分页查询机柜")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RackVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "565459579211616256"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "scattered"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "JJJ"),
		@ApiImplicitParam(name = RackVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "reserve"),
		@ApiImplicitParam(name = RackVOMeta.ENVIRONMENT , value = "环境" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RackVOMeta.RACK_USED_TYPE , value = "使用分类" , required = false , dataTypeClass=String.class , example = "network"),
		@ApiImplicitParam(name = RackVOMeta.AREA_ID , value = "区域" , required = false , dataTypeClass=String.class , example = "565457749140312064"),
		@ApiImplicitParam(name = RackVOMeta.LAYER_ID , value = "层级" , required = false , dataTypeClass=String.class , example = "565457784187916288"),
		@ApiImplicitParam(name = RackVOMeta.RACK_CAPTICAL , value = "容量" , required = false , dataTypeClass=BigDecimal.class , example = "12.00"),
		@ApiImplicitParam(name = RackVOMeta.U_POSTION_NUMBER , value = "U位数量" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = RackVOMeta.PDU_NUMBER , value = "PDU数量" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.JUMPER_NUMBER , value = "跳线数" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.CONTRACT_POWER , value = "合同电力" , required = false , dataTypeClass=Integer.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.EQUIPMENT_NUMBER , value = "设备数量" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = RackVOMeta.EXPIRE_DATE , value = "到期日期" , required = false , dataTypeClass=Date.class , example = "2022-04-14 12:00:00"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABEL1 , value = "标签1" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_LABEL2 , value = "标签2" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = RackVOMeta.RACK_NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "121212"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RackServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RackServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Rack>> queryPagedList(RackVO sample) {
		Result<PagedList<Rack>> result=new Result<>();
		PagedList<Rack> list=rackService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		rackService.dao().fill(list)
			.with(RackMeta.STATUS_DICT)
			.with(RackMeta.TYPE_DICT)
			.with(RackMeta.USED_TYPE_DICT)
			.with(RackMeta.ENVIRONMENT_DICT)
			.with(RackMeta.AREA)
			.with(RackMeta.LAYER)
			.execute();
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RackServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RackServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RackVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=rackService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RackServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RackServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=rackService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = RackServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RackServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=rackService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}