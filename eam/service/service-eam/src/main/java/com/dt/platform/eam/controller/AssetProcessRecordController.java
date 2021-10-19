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


import com.dt.platform.proxy.eam.AssetProcessRecordServiceProxy;
import com.dt.platform.domain.eam.meta.AssetProcessRecordVOMeta;
import com.dt.platform.domain.eam.AssetProcessRecord;
import com.dt.platform.domain.eam.AssetProcessRecordVO;
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
import com.dt.platform.domain.eam.meta.AssetProcessRecordMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetProcessRecordService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产处理记录 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-19 13:51:29
*/

@Api(tags = "资产处理记录")
@ApiSort(0)
@RestController("EamAssetProcessRecordController")
public class AssetProcessRecordController extends SuperController {

	@Autowired
	private IAssetProcessRecordService assetProcessRecordService;


	/**
	 * 添加资产处理记录
	*/
	@ApiOperation(value = "添加资产处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "502825997217824768"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class , example = "CHM202110102210818"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESS_TYPE , value = "操作类型" , required = false , dataTypeClass=String.class , example = "eam_asset_change_maintenance"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class , example = "【所属公司】由上海分公司变更为- 【资产分类】由服务器变更为- 【使用人员】由李方捷(2021001007)变更为- 【厂商】由-变更为戴尔有限公司 【物品档案】由-变更为121 【资产编号】由AS-5824106925变更为1212 【核对时间】由null变更为2021-10-21 "),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESS_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESSD_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class , example = "2021-10-19 12:51:00"),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetProcessRecordServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetProcessRecordServiceProxy.INSERT)
	public Result insert(AssetProcessRecordVO assetProcessRecordVO) {
		Result result=assetProcessRecordService.insert(assetProcessRecordVO);
		return result;
	}



	/**
	 * 删除资产处理记录
	*/
	@ApiOperation(value = "删除资产处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "502825997217824768")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetProcessRecordVOMeta.ID)
	@SentinelResource(value = AssetProcessRecordServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetProcessRecordServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetProcessRecordService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除资产处理记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetProcessRecordVOMeta.IDS)
	@SentinelResource(value = AssetProcessRecordServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetProcessRecordServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetProcessRecordService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新资产处理记录
	*/
	@ApiOperation(value = "更新资产处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "502825997217824768"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class , example = "CHM202110102210818"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESS_TYPE , value = "操作类型" , required = false , dataTypeClass=String.class , example = "eam_asset_change_maintenance"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class , example = "【所属公司】由上海分公司变更为- 【资产分类】由服务器变更为- 【使用人员】由李方捷(2021001007)变更为- 【厂商】由-变更为戴尔有限公司 【物品档案】由-变更为121 【资产编号】由AS-5824106925变更为1212 【核对时间】由null变更为2021-10-21 "),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESS_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESSD_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class , example = "2021-10-19 12:51:00"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetProcessRecordVOMeta.PAGE_INDEX , AssetProcessRecordVOMeta.PAGE_SIZE , AssetProcessRecordVOMeta.SEARCH_FIELD , AssetProcessRecordVOMeta.FUZZY_FIELD , AssetProcessRecordVOMeta.SEARCH_VALUE , AssetProcessRecordVOMeta.SORT_FIELD , AssetProcessRecordVOMeta.SORT_TYPE , AssetProcessRecordVOMeta.IDS } )
	@NotNull(name = AssetProcessRecordVOMeta.ID)
	@SentinelResource(value = AssetProcessRecordServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetProcessRecordServiceProxy.UPDATE)
	public Result update(AssetProcessRecordVO assetProcessRecordVO) {
		Result result=assetProcessRecordService.update(assetProcessRecordVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 保存资产处理记录
	*/
	@ApiOperation(value = "保存资产处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "502825997217824768"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class , example = "CHM202110102210818"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESS_TYPE , value = "操作类型" , required = false , dataTypeClass=String.class , example = "eam_asset_change_maintenance"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class , example = "【所属公司】由上海分公司变更为- 【资产分类】由服务器变更为- 【使用人员】由李方捷(2021001007)变更为- 【厂商】由-变更为戴尔有限公司 【物品档案】由-变更为121 【资产编号】由AS-5824106925变更为1212 【核对时间】由null变更为2021-10-21 "),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESS_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESSD_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class , example = "2021-10-19 12:51:00"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetProcessRecordVOMeta.PAGE_INDEX , AssetProcessRecordVOMeta.PAGE_SIZE , AssetProcessRecordVOMeta.SEARCH_FIELD , AssetProcessRecordVOMeta.FUZZY_FIELD , AssetProcessRecordVOMeta.SEARCH_VALUE , AssetProcessRecordVOMeta.SORT_FIELD , AssetProcessRecordVOMeta.SORT_TYPE , AssetProcessRecordVOMeta.IDS } )
	@NotNull(name = AssetProcessRecordVOMeta.ID)
	@SentinelResource(value = AssetProcessRecordServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetProcessRecordServiceProxy.SAVE)
	public Result save(AssetProcessRecordVO assetProcessRecordVO) {
		Result result=assetProcessRecordService.save(assetProcessRecordVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}


	/**
	 * 获取资产处理记录
	*/
	@ApiOperation(value = "获取资产处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetProcessRecordVOMeta.ID)
	@SentinelResource(value = AssetProcessRecordServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetProcessRecordServiceProxy.GET_BY_ID)
	public Result<AssetProcessRecord> getById(String id) {
		Result<AssetProcessRecord> result=new Result<>();
		AssetProcessRecord assetProcessRecord=assetProcessRecordService.getById(id);

		// join 关联的对象
		assetProcessRecordService.dao().fill(assetProcessRecord)
			.execute();

		result.success(true).data(assetProcessRecord);
		return result;
	}


	/**
	 * 批量获取资产处理记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取资产处理记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetProcessRecordVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetProcessRecordVOMeta.IDS)
		@SentinelResource(value = AssetProcessRecordServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetProcessRecordServiceProxy.GET_BY_IDS)
	public Result<List<AssetProcessRecord>> getByIds(List<String> ids) {
		Result<List<AssetProcessRecord>> result=new Result<>();
		List<AssetProcessRecord> list=assetProcessRecordService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询资产处理记录
	*/
	@ApiOperation(value = "查询资产处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "502825997217824768"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class , example = "CHM202110102210818"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESS_TYPE , value = "操作类型" , required = false , dataTypeClass=String.class , example = "eam_asset_change_maintenance"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class , example = "【所属公司】由上海分公司变更为- 【资产分类】由服务器变更为- 【使用人员】由李方捷(2021001007)变更为- 【厂商】由-变更为戴尔有限公司 【物品档案】由-变更为121 【资产编号】由AS-5824106925变更为1212 【核对时间】由null变更为2021-10-21 "),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESS_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESSD_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class , example = "2021-10-19 12:51:00"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetProcessRecordVOMeta.PAGE_INDEX , AssetProcessRecordVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetProcessRecordServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetProcessRecordServiceProxy.QUERY_LIST)
	public Result<List<AssetProcessRecord>> queryList(AssetProcessRecordVO sample) {
		Result<List<AssetProcessRecord>> result=new Result<>();
		List<AssetProcessRecord> list=assetProcessRecordService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询资产处理记录
	*/
	@ApiOperation(value = "分页查询资产处理记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "502825997217824768"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class , example = "CHM202110102210818"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESS_TYPE , value = "操作类型" , required = false , dataTypeClass=String.class , example = "eam_asset_change_maintenance"),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.CONTENT , value = "操作内容" , required = false , dataTypeClass=String.class , example = "【所属公司】由上海分公司变更为- 【资产分类】由服务器变更为- 【使用人员】由李方捷(2021001007)变更为- 【厂商】由-变更为戴尔有限公司 【物品档案】由-变更为121 【资产编号】由AS-5824106925变更为1212 【核对时间】由null变更为2021-10-21 "),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESS_USER_ID , value = "变更人" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetProcessRecordVOMeta.PROCESSD_TIME , value = "变更时间" , required = false , dataTypeClass=Date.class , example = "2021-10-19 12:51:00"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetProcessRecordServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetProcessRecordServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetProcessRecord>> queryPagedList(AssetProcessRecordVO sample) {
		Result<PagedList<AssetProcessRecord>> result=new Result<>();
		PagedList<AssetProcessRecord> list=assetProcessRecordService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());

		// join 关联的对象
		assetProcessRecordService.dao().fill(list)
			.execute();

		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetProcessRecordServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetProcessRecordServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetProcessRecordVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetProcessRecordService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetProcessRecordServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetProcessRecordServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetProcessRecordService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = AssetProcessRecordServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetProcessRecordServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetProcessRecordService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}