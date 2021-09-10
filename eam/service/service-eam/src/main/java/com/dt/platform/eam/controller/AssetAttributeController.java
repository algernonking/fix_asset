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


import com.dt.platform.proxy.eam.AssetAttributeServiceProxy;
import com.dt.platform.domain.eam.meta.AssetAttributeVOMeta;
import com.dt.platform.domain.eam.AssetAttribute;
import com.dt.platform.domain.eam.AssetAttributeVO;
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
import com.dt.platform.domain.eam.meta.AssetAttributeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetAttributeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资产字段配置 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-10 11:59:58
*/

@Api(tags = "资产字段配置")
@ApiSort(0)
@RestController("EamAssetAttributeController")
public class AssetAttributeController extends SuperController {

	@Autowired
	private IAssetAttributeService assetAttributeService;

	
	/**
	 * 添加资产字段配置
	*/
	@ApiOperation(value = "添加资产字段配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "000b5919-0f8b-11ec-ab08-00163e2e6a36"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.CODE , value = "字段编码" , required = false , dataTypeClass=String.class , example = "maintainer_name"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.LABEL , value = "字段名称" , required = false , dataTypeClass=String.class , example = "维保厂商"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.LABEL_NOTES , value = "标签备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.DIMENSION , value = "所属维度" , required = false , dataTypeClass=String.class , example = "maintainer"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.REQUIRED , value = "是否必选" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.REQUIRED_MODIFY , value = "是否修改" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.COMPONENT_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class , example = "text_input"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.COMPONENT_CONTENT , value = "组件内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.TENANT_ID , value = "租户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = AssetAttributeVOMeta.ID)
	@SentinelResource(value = AssetAttributeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetAttributeServiceProxy.INSERT)
	public Result insert(AssetAttributeVO assetAttributeVO) {
		Result result=assetAttributeService.insert(assetAttributeVO);
		return result;
	}

	
	/**
	 * 删除资产字段配置
	*/
	@ApiOperation(value = "删除资产字段配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "000b5919-0f8b-11ec-ab08-00163e2e6a36")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = AssetAttributeVOMeta.ID)
	@SentinelResource(value = AssetAttributeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetAttributeServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=assetAttributeService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资产字段配置 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资产字段配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetAttributeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = AssetAttributeVOMeta.IDS)
	@SentinelResource(value = AssetAttributeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetAttributeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=assetAttributeService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资产字段配置
	*/
	@ApiOperation(value = "更新资产字段配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "000b5919-0f8b-11ec-ab08-00163e2e6a36"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.CODE , value = "字段编码" , required = false , dataTypeClass=String.class , example = "maintainer_name"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.LABEL , value = "字段名称" , required = false , dataTypeClass=String.class , example = "维保厂商"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.LABEL_NOTES , value = "标签备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.DIMENSION , value = "所属维度" , required = false , dataTypeClass=String.class , example = "maintainer"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.REQUIRED , value = "是否必选" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.REQUIRED_MODIFY , value = "是否修改" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.COMPONENT_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class , example = "text_input"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.COMPONENT_CONTENT , value = "组件内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.TENANT_ID , value = "租户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { AssetAttributeVOMeta.PAGE_INDEX , AssetAttributeVOMeta.PAGE_SIZE , AssetAttributeVOMeta.SEARCH_FIELD , AssetAttributeVOMeta.FUZZY_FIELD , AssetAttributeVOMeta.SEARCH_VALUE , AssetAttributeVOMeta.SORT_FIELD , AssetAttributeVOMeta.SORT_TYPE , AssetAttributeVOMeta.IDS } ) 
	@NotNull(name = AssetAttributeVOMeta.ID)
	@SentinelResource(value = AssetAttributeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetAttributeServiceProxy.UPDATE)
	public Result update(AssetAttributeVO assetAttributeVO) {
		Result result=assetAttributeService.update(assetAttributeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资产字段配置
	*/
	@ApiOperation(value = "保存资产字段配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "000b5919-0f8b-11ec-ab08-00163e2e6a36"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.CODE , value = "字段编码" , required = false , dataTypeClass=String.class , example = "maintainer_name"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.LABEL , value = "字段名称" , required = false , dataTypeClass=String.class , example = "维保厂商"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.LABEL_NOTES , value = "标签备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.DIMENSION , value = "所属维度" , required = false , dataTypeClass=String.class , example = "maintainer"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.REQUIRED , value = "是否必选" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.REQUIRED_MODIFY , value = "是否修改" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.COMPONENT_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class , example = "text_input"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.COMPONENT_CONTENT , value = "组件内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.TENANT_ID , value = "租户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetAttributeVOMeta.PAGE_INDEX , AssetAttributeVOMeta.PAGE_SIZE , AssetAttributeVOMeta.SEARCH_FIELD , AssetAttributeVOMeta.FUZZY_FIELD , AssetAttributeVOMeta.SEARCH_VALUE , AssetAttributeVOMeta.SORT_FIELD , AssetAttributeVOMeta.SORT_TYPE , AssetAttributeVOMeta.IDS } )
	@NotNull(name = AssetAttributeVOMeta.ID)
	@SentinelResource(value = AssetAttributeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetAttributeServiceProxy.SAVE)
	public Result save(AssetAttributeVO assetAttributeVO) {
		Result result=assetAttributeService.save(assetAttributeVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资产字段配置
	*/
	@ApiOperation(value = "获取资产字段配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = AssetAttributeVOMeta.ID)
	@SentinelResource(value = AssetAttributeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetAttributeServiceProxy.GET_BY_ID)
	public Result<AssetAttribute> getById(String id) {
		Result<AssetAttribute> result=new Result<>();
		AssetAttribute assetAttribute=assetAttributeService.getById(id);
		result.success(true).data(assetAttribute);
		return result;
	}


	/**
	 * 批量删除资产字段配置 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资产字段配置")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetAttributeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = AssetAttributeVOMeta.IDS)
		@SentinelResource(value = AssetAttributeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetAttributeServiceProxy.GET_BY_IDS)
	public Result<List<AssetAttribute>> getByIds(List<String> ids) {
		Result<List<AssetAttribute>> result=new Result<>();
		List<AssetAttribute> list=assetAttributeService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资产字段配置
	*/
	@ApiOperation(value = "查询资产字段配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "000b5919-0f8b-11ec-ab08-00163e2e6a36"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.CODE , value = "字段编码" , required = false , dataTypeClass=String.class , example = "maintainer_name"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.LABEL , value = "字段名称" , required = false , dataTypeClass=String.class , example = "维保厂商"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.LABEL_NOTES , value = "标签备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.DIMENSION , value = "所属维度" , required = false , dataTypeClass=String.class , example = "maintainer"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.REQUIRED , value = "是否必选" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.REQUIRED_MODIFY , value = "是否修改" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.COMPONENT_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class , example = "text_input"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.COMPONENT_CONTENT , value = "组件内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.TENANT_ID , value = "租户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetAttributeVOMeta.PAGE_INDEX , AssetAttributeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetAttributeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetAttributeServiceProxy.QUERY_LIST)
	public Result<List<AssetAttribute>> queryList(AssetAttributeVO sample) {
		Result<List<AssetAttribute>> result=new Result<>();
		List<AssetAttribute> list=assetAttributeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资产字段配置
	*/
	@ApiOperation(value = "分页查询资产字段配置")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "000b5919-0f8b-11ec-ab08-00163e2e6a36"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.CODE , value = "字段编码" , required = false , dataTypeClass=String.class , example = "maintainer_name"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.LABEL , value = "字段名称" , required = false , dataTypeClass=String.class , example = "维保厂商"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.LABEL_NOTES , value = "标签备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.DIMENSION , value = "所属维度" , required = false , dataTypeClass=String.class , example = "maintainer"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.REQUIRED , value = "是否必选" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.REQUIRED_MODIFY , value = "是否修改" , required = false , dataTypeClass=Integer.class , example = "0"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.COMPONENT_TYPE , value = "组件类型" , required = false , dataTypeClass=String.class , example = "text_input"),
		@ApiImplicitParam(name = AssetAttributeVOMeta.COMPONENT_CONTENT , value = "组件内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetAttributeVOMeta.TENANT_ID , value = "租户" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = AssetAttributeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetAttributeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetAttribute>> queryPagedList(AssetAttributeVO sample) {
		Result<PagedList<AssetAttribute>> result=new Result<>();
		PagedList<AssetAttribute> list=assetAttributeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = AssetAttributeServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetAttributeServiceProxy.EXPORT_EXCEL)
	public void exportExcel(AssetAttributeVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=assetAttributeService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = AssetAttributeServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetAttributeServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=assetAttributeService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = AssetAttributeServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(AssetAttributeServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=assetAttributeService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}