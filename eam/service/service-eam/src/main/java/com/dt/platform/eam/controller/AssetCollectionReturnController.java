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


import com.dt.platform.proxy.eam.AssetCollectionReturnServiceProxy;
import com.dt.platform.domain.eam.meta.AssetCollectionReturnVOMeta;
import com.dt.platform.domain.eam.AssetCollectionReturn;
import com.dt.platform.domain.eam.AssetCollectionReturnVO;
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
import com.dt.platform.domain.eam.meta.AssetCollectionReturnMeta;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.Asset;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetCollectionReturnService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产退库 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-21 08:43:57
*/

@Api(tags = "资产退库")
@ApiSort(0)
@RestController("EamAssetCollectionReturnController")
public class AssetCollectionReturnController extends SuperController {

	@Autowired
	private IAssetCollectionReturnService assetCollectionReturnService;

	
	/**
	 * 添加资产退库
	*/
	@ApiOperation(value = "添加资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667671264768000"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.RETURN_DATE , value = "退库日期" , required = false , dataTypeClass=Date.class , example = "2021-08-02 12:00:00"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.USER_ORGANIZATION_ID , value = "退库后公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.POSITION_ID , value = "退库后位置" , required = false , dataTypeClass=String.class , example = "473623769873645568"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.CONTENT , value = "退库说明" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetCollectionReturnVOMeta.ID)
	@NotNull(name = AssetCollectionReturnVOMeta.NAME)
	@SentinelResource(value = AssetCollectionReturnServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionReturnServiceProxy.INSERT)
	public Result insert(AssetCollectionReturnVO assetCollectionReturnVO) {
		Result result=assetCollectionReturnService.insert(assetCollectionReturnVO);
		return result;
	}

	
	/**
	 * 删除资产退库
	*/
	@ApiOperation(value = "删除资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667671264768000")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetCollectionReturnVOMeta.ID)
	@SentinelResource(value = AssetCollectionReturnServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionReturnServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetCollectionReturnService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产退库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetCollectionReturnVOMeta.IDS)
	@SentinelResource(value = AssetCollectionReturnServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionReturnServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetCollectionReturnService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产退库
	*/
	@ApiOperation(value = "更新资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667671264768000"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.RETURN_DATE , value = "退库日期" , required = false , dataTypeClass=Date.class , example = "2021-08-02 12:00:00"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.USER_ORGANIZATION_ID , value = "退库后公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.POSITION_ID , value = "退库后位置" , required = false , dataTypeClass=String.class , example = "473623769873645568"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.CONTENT , value = "退库说明" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetCollectionReturnVOMeta.PAGE_INDEX , AssetCollectionReturnVOMeta.PAGE_SIZE , AssetCollectionReturnVOMeta.SEARCH_FIELD , AssetCollectionReturnVOMeta.FUZZY_FIELD , AssetCollectionReturnVOMeta.SEARCH_VALUE , AssetCollectionReturnVOMeta.SORT_FIELD , AssetCollectionReturnVOMeta.SORT_TYPE , AssetCollectionReturnVOMeta.IDS } ) 
	@NotNull(name = AssetCollectionReturnVOMeta.ID)
	@NotNull(name = AssetCollectionReturnVOMeta.NAME)
	@SentinelResource(value = AssetCollectionReturnServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionReturnServiceProxy.UPDATE)
	public Result update(AssetCollectionReturnVO assetCollectionReturnVO) {
		Result result=assetCollectionReturnService.update(assetCollectionReturnVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产退库
	*/
	@ApiOperation(value = "保存资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667671264768000"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.RETURN_DATE , value = "退库日期" , required = false , dataTypeClass=Date.class , example = "2021-08-02 12:00:00"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.USER_ORGANIZATION_ID , value = "退库后公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.POSITION_ID , value = "退库后位置" , required = false , dataTypeClass=String.class , example = "473623769873645568"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.CONTENT , value = "退库说明" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetCollectionReturnVOMeta.PAGE_INDEX , AssetCollectionReturnVOMeta.PAGE_SIZE , AssetCollectionReturnVOMeta.SEARCH_FIELD , AssetCollectionReturnVOMeta.FUZZY_FIELD , AssetCollectionReturnVOMeta.SEARCH_VALUE , AssetCollectionReturnVOMeta.SORT_FIELD , AssetCollectionReturnVOMeta.SORT_TYPE , AssetCollectionReturnVOMeta.IDS } )
	@NotNull(name = AssetCollectionReturnVOMeta.ID)
	@NotNull(name = AssetCollectionReturnVOMeta.NAME)
	@SentinelResource(value = AssetCollectionReturnServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionReturnServiceProxy.SAVE)
	public Result save(AssetCollectionReturnVO assetCollectionReturnVO) {
		Result result=assetCollectionReturnService.save(assetCollectionReturnVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产退库
	*/
	@ApiOperation(value = "获取资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetCollectionReturnVOMeta.ID)
	@SentinelResource(value = AssetCollectionReturnServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionReturnServiceProxy.GET_BY_ID)
	public Result<AssetCollectionReturn> getById(String id) {
		Result<AssetCollectionReturn> result=new Result<>();
		AssetCollectionReturn assetCollectionReturn=assetCollectionReturnService.getById(id);
		// 关联出 存放位置 数据
		assetCollectionReturnService.join(assetCollectionReturn,AssetCollectionReturnMeta.POSITION);
		result.success(true).data(assetCollectionReturn);
		return result;
	}


	/**
	 * 批量删除资产退库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产退库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetCollectionReturnVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetCollectionReturnVOMeta.IDS)
		@SentinelResource(value = AssetCollectionReturnServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionReturnServiceProxy.GET_BY_IDS)
	public Result<List<AssetCollectionReturn>> getByIds(List<String> ids) {
		Result<List<AssetCollectionReturn>> result=new Result<>();
		List<AssetCollectionReturn> list=assetCollectionReturnService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产退库
	*/
	@ApiOperation(value = "查询资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667671264768000"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.RETURN_DATE , value = "退库日期" , required = false , dataTypeClass=Date.class , example = "2021-08-02 12:00:00"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.USER_ORGANIZATION_ID , value = "退库后公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.POSITION_ID , value = "退库后位置" , required = false , dataTypeClass=String.class , example = "473623769873645568"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.CONTENT , value = "退库说明" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetCollectionReturnVOMeta.PAGE_INDEX , AssetCollectionReturnVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetCollectionReturnServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionReturnServiceProxy.QUERY_LIST)
	public Result<List<AssetCollectionReturn>> queryList(AssetCollectionReturnVO sample) {
		Result<List<AssetCollectionReturn>> result=new Result<>();
		List<AssetCollectionReturn> list=assetCollectionReturnService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产退库
	*/
	@ApiOperation(value = "分页查询资产退库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "480667671264768000"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.BUSINESS_CODE , value = "业务编号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.PROC_ID , value = "流程" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.NAME , value = "业务名称" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.STATUS , value = "办理状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.RETURN_DATE , value = "退库日期" , required = false , dataTypeClass=Date.class , example = "2021-08-02 12:00:00"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.USER_ORGANIZATION_ID , value = "退库后公司/部门" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.POSITION_ID , value = "退库后位置" , required = false , dataTypeClass=String.class , example = "473623769873645568"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.POSITION_DETAIL , value = "详细位置" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.CONTENT , value = "退库说明" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.ORIGINATOR_ID , value = "制单人" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = AssetCollectionReturnVOMeta.BUSINESS_DATE , value = "业务日期" , required = false , dataTypeClass=Date.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetCollectionReturnServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetCollectionReturnServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetCollectionReturn>> queryPagedList(AssetCollectionReturnVO sample) {
		Result<PagedList<AssetCollectionReturn>> result=new Result<>();
		PagedList<AssetCollectionReturn> list=assetCollectionReturnService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 存放位置 数据
		assetCollectionReturnService.join(list,AssetCollectionReturnMeta.POSITION);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetCollectionReturnServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionReturnServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetCollectionReturnVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetCollectionReturnService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetCollectionReturnServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionReturnServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetCollectionReturnService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetCollectionReturnServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetCollectionReturnServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetCollectionReturnService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}