package com.dt.platform.eam.controller;


import java.util.ArrayList;
import java.util.List;

import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetLabelMeta;
import com.dt.platform.domain.eam.meta.AssetLabelTplItemMeta;
import com.dt.platform.eam.service.IAssetLabelService;
import com.dt.platform.eam.service.IAssetLabelTplItemService;
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


import com.dt.platform.proxy.eam.AssetLabelTplServiceProxy;
import com.dt.platform.domain.eam.meta.AssetLabelTplVOMeta;
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
import com.dt.platform.domain.eam.meta.AssetLabelTplMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetLabelTplService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 标签模版 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-21 13:48:06
*/

@Api(tags = "标签模版")
@ApiSort(0)
@RestController("EamAssetLabelTplController")
public class AssetLabelTplController extends SuperController {

	@Autowired
	private IAssetLabelService assetLabelService;

	@Autowired
	private IAssetLabelTplService assetLabelTplService;

	@Autowired
	private IAssetLabelTplItemService assetLabelTplItemService;

	/**
	 * 添加标签模版
	*/
	@ApiOperation(value = "添加标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IS_CUSTOM , value = "是否自定义" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.COL_IDS , value = "字段" , required = false , dataTypeClass=String.class , example = "[1,2,3]"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "d"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_COL_ID , value = "图像" , required = false , dataTypeClass=String.class , example = "9"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_LABEL_SHOW , value = "图标显示" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.LABEL_FORMAT_CONTENT , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = AssetLabelTplServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplServiceProxy.INSERT)
	public Result insert(AssetLabelTplVO assetLabelTplVO) {
		Result result=assetLabelTplService.insert(assetLabelTplVO,false);
		return result;
	}



	/**
	 * 删除标签模版
	*/
	@ApiOperation(value = "删除标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetLabelTplVOMeta.ID)
	@SentinelResource(value = AssetLabelTplServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplServiceProxy.DELETE)
	public Result deleteById(String id) {
		AssetLabel label=assetLabelService.queryAssetLabel();

		if(label!=null&&label.getLabelTplId()!=null){
			if(label.getLabelTplId().equals(id)){
				return ErrorDesc.failureMessage("当前模版在使用中，不可删除");
			}
		}

		Result result=assetLabelTplService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除标签模版 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetLabelTplVOMeta.IDS)
	@SentinelResource(value = AssetLabelTplServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetLabelTplService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新标签模版
	*/
	@ApiOperation(value = "更新标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IS_CUSTOM , value = "是否自定义" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.COL_IDS , value = "字段" , required = false , dataTypeClass=String.class , example = "[1,2,3]"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "d"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_COL_ID , value = "图像" , required = false , dataTypeClass=String.class , example = "9"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_LABEL_SHOW , value = "图标显示" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.LABEL_FORMAT_CONTENT , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetLabelTplVOMeta.PAGE_INDEX , AssetLabelTplVOMeta.PAGE_SIZE , AssetLabelTplVOMeta.SEARCH_FIELD , AssetLabelTplVOMeta.FUZZY_FIELD , AssetLabelTplVOMeta.SEARCH_VALUE , AssetLabelTplVOMeta.DIRTY_FIELDS , AssetLabelTplVOMeta.SORT_FIELD , AssetLabelTplVOMeta.SORT_TYPE , AssetLabelTplVOMeta.IDS } )
	@NotNull(name = AssetLabelTplVOMeta.ID)
	@SentinelResource(value = AssetLabelTplServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplServiceProxy.UPDATE)
	public Result update(AssetLabelTplVO assetLabelTplVO) {
		Result result=assetLabelTplService.update(assetLabelTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存标签模版
	*/
	@ApiOperation(value = "保存标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IS_CUSTOM , value = "是否自定义" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.COL_IDS , value = "字段" , required = false , dataTypeClass=String.class , example = "[1,2,3]"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "d"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_COL_ID , value = "图像" , required = false , dataTypeClass=String.class , example = "9"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_LABEL_SHOW , value = "图标显示" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.LABEL_FORMAT_CONTENT , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetLabelTplVOMeta.PAGE_INDEX , AssetLabelTplVOMeta.PAGE_SIZE , AssetLabelTplVOMeta.SEARCH_FIELD , AssetLabelTplVOMeta.FUZZY_FIELD , AssetLabelTplVOMeta.SEARCH_VALUE , AssetLabelTplVOMeta.DIRTY_FIELDS , AssetLabelTplVOMeta.SORT_FIELD , AssetLabelTplVOMeta.SORT_TYPE , AssetLabelTplVOMeta.IDS } )
	@NotNull(name = AssetLabelTplVOMeta.ID)
	@SentinelResource(value = AssetLabelTplServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplServiceProxy.SAVE)
	public Result save(AssetLabelTplVO assetLabelTplVO) {
		Result result=assetLabelTplService.save(assetLabelTplVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取标签模版
	*/
	@ApiOperation(value = "获取标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetLabelTplVOMeta.ID)
	@SentinelResource(value = AssetLabelTplServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplServiceProxy.GET_BY_ID)
	public Result<AssetLabelTpl> getById(String id) {
		Result<AssetLabelTpl> result=new Result<>();
		AssetLabelTpl assetLabelTpl=assetLabelTplService.getById(id);
		result.success(true).data(assetLabelTpl);
		return result;
	}


	/**
	 * 批量获取标签模版 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取标签模版")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetLabelTplVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetLabelTplVOMeta.IDS)
		@SentinelResource(value = AssetLabelTplServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplServiceProxy.GET_BY_IDS)
	public Result<List<AssetLabelTpl>> getByIds(List<String> ids) {
		Result<List<AssetLabelTpl>> result=new Result<>();
		List<AssetLabelTpl> list=assetLabelTplService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询标签模版
	*/
	@ApiOperation(value = "查询标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IS_CUSTOM , value = "是否自定义" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.COL_IDS , value = "字段" , required = false , dataTypeClass=String.class , example = "[1,2,3]"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "d"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_COL_ID , value = "图像" , required = false , dataTypeClass=String.class , example = "9"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_LABEL_SHOW , value = "图标显示" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.LABEL_FORMAT_CONTENT , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetLabelTplVOMeta.PAGE_INDEX , AssetLabelTplVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetLabelTplServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplServiceProxy.QUERY_LIST)
	public Result<List<AssetLabelTpl>> queryList(AssetLabelTplVO sample) {
		Result<List<AssetLabelTpl>> result=new Result<>();
		List<AssetLabelTpl> list=assetLabelTplService.queryList(sample);
		assetLabelTplService.dao().fill(list)
				.with(AssetLabelTplMeta.ASSET_LABEL_ITEM_LIST).execute();
		List<List<AssetLabelTplItem>> itemList= CollectorUtil.collectList(list, AssetLabelTpl::getAssetLabelItemList);
		List<AssetLabelTplItem> items=itemList.stream().collect(ArrayList::new,ArrayList::addAll,ArrayList::addAll);
		assetLabelTplItemService.dao().fill(items).with(AssetLabelTplItemMeta.ASSET_LABEL_COL).execute();
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询标签模版
	*/
	@ApiOperation(value = "分页查询标签模版")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelTplVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IS_CUSTOM , value = "是否自定义" , required = false , dataTypeClass=String.class , example = "0"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.COL_IDS , value = "字段" , required = false , dataTypeClass=String.class , example = "[1,2,3]"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "d"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_COL_ID , value = "图像" , required = false , dataTypeClass=String.class , example = "9"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.IMAGE_LABEL_SHOW , value = "图标显示" , required = false , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.LABEL_FORMAT_CONTENT , value = "类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelTplVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetLabelTplServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelTplServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetLabelTpl>> queryPagedList(AssetLabelTplVO sample) {
		Result<PagedList<AssetLabelTpl>> result=new Result<>();
		PagedList<AssetLabelTpl> list=assetLabelTplService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetLabelTplServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelTplServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetLabelTplVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=assetLabelTplService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetLabelTplServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelTplServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=assetLabelTplService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = AssetLabelTplServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetLabelTplServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=assetLabelTplService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}