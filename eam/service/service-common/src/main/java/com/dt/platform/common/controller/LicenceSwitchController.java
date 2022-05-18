package com.dt.platform.common.controller;


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


import com.dt.platform.proxy.common.LicenceSwitchServiceProxy;
import com.dt.platform.domain.common.meta.LicenceSwitchVOMeta;
import com.dt.platform.domain.common.LicenceSwitch;
import com.dt.platform.domain.common.LicenceSwitchVO;
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
import com.dt.platform.domain.common.meta.LicenceSwitchMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.ILicenceSwitchService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 版本切换 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-16 16:21:28
*/

@Api(tags = "版本切换")
@ApiSort(0)
@RestController("SysLicenceSwitchController")
public class LicenceSwitchController extends SuperController {

	@Autowired
	private ILicenceSwitchService licenceSwitchService;


	/**
	 * 添加版本切换
	*/
	@ApiOperation(value = "添加版本切换")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.LICENCE_TAB , value = "许可版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ACTION_CONTENT , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = LicenceSwitchServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LicenceSwitchServiceProxy.INSERT)
	public Result insert(LicenceSwitchVO licenceSwitchVO) {
		Result result=licenceSwitchService.insert(licenceSwitchVO,false);
		return result;
	}



	/**
	 * 删除版本切换
	*/
	@ApiOperation(value = "删除版本切换")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = LicenceSwitchVOMeta.ID)
	@SentinelResource(value = LicenceSwitchServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LicenceSwitchServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=licenceSwitchService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除版本切换 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除版本切换")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LicenceSwitchVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = LicenceSwitchVOMeta.IDS)
	@SentinelResource(value = LicenceSwitchServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LicenceSwitchServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=licenceSwitchService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新版本切换
	*/
	@ApiOperation(value = "更新版本切换")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.LICENCE_TAB , value = "许可版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ACTION_CONTENT , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { LicenceSwitchVOMeta.PAGE_INDEX , LicenceSwitchVOMeta.PAGE_SIZE , LicenceSwitchVOMeta.SEARCH_FIELD , LicenceSwitchVOMeta.FUZZY_FIELD , LicenceSwitchVOMeta.SEARCH_VALUE , LicenceSwitchVOMeta.DIRTY_FIELDS , LicenceSwitchVOMeta.SORT_FIELD , LicenceSwitchVOMeta.SORT_TYPE , LicenceSwitchVOMeta.IDS } )
	@NotNull(name = LicenceSwitchVOMeta.ID)
	@SentinelResource(value = LicenceSwitchServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LicenceSwitchServiceProxy.UPDATE)
	public Result update(LicenceSwitchVO licenceSwitchVO) {
		Result result=licenceSwitchService.update(licenceSwitchVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存版本切换
	*/
	@ApiOperation(value = "保存版本切换")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.LICENCE_TAB , value = "许可版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ACTION_CONTENT , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { LicenceSwitchVOMeta.PAGE_INDEX , LicenceSwitchVOMeta.PAGE_SIZE , LicenceSwitchVOMeta.SEARCH_FIELD , LicenceSwitchVOMeta.FUZZY_FIELD , LicenceSwitchVOMeta.SEARCH_VALUE , LicenceSwitchVOMeta.DIRTY_FIELDS , LicenceSwitchVOMeta.SORT_FIELD , LicenceSwitchVOMeta.SORT_TYPE , LicenceSwitchVOMeta.IDS } )
	@NotNull(name = LicenceSwitchVOMeta.ID)
	@SentinelResource(value = LicenceSwitchServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LicenceSwitchServiceProxy.SAVE)
	public Result save(LicenceSwitchVO licenceSwitchVO) {
		Result result=licenceSwitchService.save(licenceSwitchVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取版本切换
	*/
	@ApiOperation(value = "获取版本切换")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = LicenceSwitchVOMeta.ID)
	@SentinelResource(value = LicenceSwitchServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LicenceSwitchServiceProxy.GET_BY_ID)
	public Result<LicenceSwitch> getById(String id) {
		Result<LicenceSwitch> result=new Result<>();
		LicenceSwitch licenceSwitch=licenceSwitchService.getById(id);
		result.success(true).data(licenceSwitch);
		return result;
	}


	/**
	 * 批量获取版本切换 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取版本切换")
		@ApiImplicitParams({
				@ApiImplicitParam(name = LicenceSwitchVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = LicenceSwitchVOMeta.IDS)
		@SentinelResource(value = LicenceSwitchServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LicenceSwitchServiceProxy.GET_BY_IDS)
	public Result<List<LicenceSwitch>> getByIds(List<String> ids) {
		Result<List<LicenceSwitch>> result=new Result<>();
		List<LicenceSwitch> list=licenceSwitchService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询版本切换
	*/
	@ApiOperation(value = "查询版本切换")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.LICENCE_TAB , value = "许可版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ACTION_CONTENT , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { LicenceSwitchVOMeta.PAGE_INDEX , LicenceSwitchVOMeta.PAGE_SIZE } )
	@SentinelResource(value = LicenceSwitchServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LicenceSwitchServiceProxy.QUERY_LIST)
	public Result<List<LicenceSwitch>> queryList(LicenceSwitchVO sample) {
		Result<List<LicenceSwitch>> result=new Result<>();
		List<LicenceSwitch> list=licenceSwitchService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询版本切换
	*/
	@ApiOperation(value = "分页查询版本切换")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.LICENCE_TAB , value = "许可版本" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.ACTION_CONTENT , value = "动作" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = LicenceSwitchVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = LicenceSwitchServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LicenceSwitchServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<LicenceSwitch>> queryPagedList(LicenceSwitchVO sample) {
		Result<PagedList<LicenceSwitch>> result=new Result<>();
		PagedList<LicenceSwitch> list=licenceSwitchService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询版本切换
	 */
	@ApiOperation(value = "切换")
	@ApiImplicitParams({
			@ApiImplicitParam(name = LicenceSwitchVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
 	})
	@ApiOperationSupport(order=9)
	@SentinelResource(value = LicenceSwitchServiceProxy.SWITCH_ENABLE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LicenceSwitchServiceProxy.SWITCH_ENABLE)
	public Result switchEnable(String id) {
		return licenceSwitchService.switchEnable(id);
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = LicenceSwitchServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(LicenceSwitchServiceProxy.EXPORT_EXCEL)
	public void exportExcel(LicenceSwitchVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=licenceSwitchService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = LicenceSwitchServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(LicenceSwitchServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=licenceSwitchService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = LicenceSwitchServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(LicenceSwitchServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=licenceSwitchService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}