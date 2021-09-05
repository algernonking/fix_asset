package com.dt.platform.ops.controller;

 
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.domain.ops.VoucherPriv;
import com.dt.platform.ops.service.IVoucherPrivService;
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


import com.dt.platform.proxy.ops.VoucherOwnerServiceProxy;
import com.dt.platform.domain.ops.meta.VoucherOwnerVOMeta;
import com.dt.platform.domain.ops.VoucherOwner;
import com.dt.platform.domain.ops.VoucherOwnerVO;
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
import com.dt.platform.domain.ops.meta.VoucherOwnerMeta;
import com.dt.platform.domain.ops.Voucher;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IVoucherOwnerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 所属凭证 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-03 10:34:20
*/

@Api(tags = "所属凭证")
@ApiSort(0)
@RestController("OpsVoucherOwnerController")
public class VoucherOwnerController extends SuperController {

	@Autowired
	private IVoucherOwnerService voucherOwnerService;

	@Autowired
	private IVoucherPrivService voucherPrivService;
	
	/**
	 * 添加所属凭证
	*/
	@ApiOperation(value = "添加所属凭证")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485941502510379008"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.CATEGORY_CODE , value = "类别" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "测试"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "略"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = VoucherOwnerVOMeta.ID)
	@SentinelResource(value = VoucherOwnerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherOwnerServiceProxy.INSERT)
	public Result insert(VoucherOwnerVO voucherOwnerVO) {

		String employeeId=this.getSessionUser().getUser().getActivatedEmployeeId();
		Result verify_result=voucherPrivService.verifyUserPermissions(voucherOwnerVO.getCategoryCode(),employeeId);
		if(!verify_result.isSuccess()){
			return verify_result;
		}
		Result result=voucherOwnerService.insert(voucherOwnerVO);

		return result;
	}

	
	/**
	 * 删除所属凭证
	*/
	@ApiOperation(value = "删除所属凭证")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485941502510379008"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = VoucherOwnerVOMeta.ID)
	@SentinelResource(value = VoucherOwnerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherOwnerServiceProxy.DELETE)
	public Result deleteById(String id) {

		VoucherOwner voucherOwner=voucherOwnerService.getById(id);
		String employeeId=this.getSessionUser().getUser().getActivatedEmployeeId();
		Result verify_result=voucherPrivService.verifyUserPermissions(voucherOwner.getCategoryCode(),employeeId);
		if(!verify_result.isSuccess()){
			return verify_result;
		}
	 

		Result result=voucherOwnerService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除所属凭证 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除所属凭证")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherOwnerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = VoucherOwnerVOMeta.IDS)
	@SentinelResource(value = VoucherOwnerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherOwnerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=voucherOwnerService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新所属凭证
	*/
	@ApiOperation(value = "更新所属凭证")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485941502510379008"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.CATEGORY_CODE , value = "类别" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "q'w"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "驱蚊器无安抚"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { VoucherOwnerVOMeta.PAGE_INDEX , VoucherOwnerVOMeta.PAGE_SIZE , VoucherOwnerVOMeta.SEARCH_FIELD , VoucherOwnerVOMeta.FUZZY_FIELD , VoucherOwnerVOMeta.SEARCH_VALUE , VoucherOwnerVOMeta.SORT_FIELD , VoucherOwnerVOMeta.SORT_TYPE , VoucherOwnerVOMeta.IDS } ) 
	@NotNull(name = VoucherOwnerVOMeta.ID)
	@SentinelResource(value = VoucherOwnerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherOwnerServiceProxy.UPDATE)
	public Result update(VoucherOwnerVO voucherOwnerVO) {
		Result result=voucherOwnerService.update(voucherOwnerVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存所属凭证
	*/
	@ApiOperation(value = "保存所属凭证")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485941502510379008"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.CATEGORY_CODE , value = "类别" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "q'w"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "驱蚊器无安抚"),
 })
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VoucherOwnerVOMeta.PAGE_INDEX , VoucherOwnerVOMeta.PAGE_SIZE , VoucherOwnerVOMeta.SEARCH_FIELD , VoucherOwnerVOMeta.FUZZY_FIELD , VoucherOwnerVOMeta.SEARCH_VALUE , VoucherOwnerVOMeta.SORT_FIELD , VoucherOwnerVOMeta.SORT_TYPE , VoucherOwnerVOMeta.IDS } )
	@NotNull(name = VoucherOwnerVOMeta.ID)
	@SentinelResource(value = VoucherOwnerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherOwnerServiceProxy.SAVE)
	public Result save(VoucherOwnerVO voucherOwnerVO) {
		Result result=voucherOwnerService.save(voucherOwnerVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取所属凭证
	*/
	@ApiOperation(value = "获取所属凭证")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = VoucherOwnerVOMeta.ID)
	@SentinelResource(value = VoucherOwnerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherOwnerServiceProxy.GET_BY_ID)
	public Result<VoucherOwner> getById(String id) {
		VoucherOwner voucherOwner=voucherOwnerService.getById(id);
		String employeeId=this.getSessionUser().getUser().getActivatedEmployeeId();
		Result verify_result=voucherPrivService.verifyUserPermissions(voucherOwner.getCategoryCode(),employeeId);
		if(!verify_result.isSuccess()){
			return verify_result;
		}
		Result<VoucherOwner> result=new Result<>();
		// 关联出 用户凭证 数据
		voucherOwnerService.join(voucherOwner,VoucherOwnerMeta.VOUCHER_LIST);
		result.success(true).data(voucherOwner);
		return result;
	}


	/**
	 * 批量删除所属凭证 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除所属凭证")
		@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485941502510379008"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.CATEGORY_CODE , value = "类别" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "q'w"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "驱蚊器无安抚"),
				@ApiImplicitParam(name = VoucherOwnerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = VoucherOwnerVOMeta.IDS)
		@SentinelResource(value = VoucherOwnerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherOwnerServiceProxy.GET_BY_IDS)
	public Result<List<VoucherOwner>> getByIds(List<String> ids) {
		Result<List<VoucherOwner>> result=new Result<>();
		List<VoucherOwner> list=voucherOwnerService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询所属凭证
	*/
	@ApiOperation(value = "查询所属凭证")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485941502510379008"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.CATEGORY_CODE , value = "类别" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "q'w"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "驱蚊器无安抚"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VoucherOwnerVOMeta.PAGE_INDEX , VoucherOwnerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = VoucherOwnerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherOwnerServiceProxy.QUERY_LIST)
	public Result<List<VoucherOwner>> queryList(VoucherOwnerVO sample) {
		Result<List<VoucherOwner>> result=new Result<>();
		List<VoucherOwner> list=voucherOwnerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询所属凭证
	*/
	@ApiOperation(value = "分页查询所属凭证")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherOwnerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "485941502510379008"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.CATEGORY_CODE , value = "类别" , required = false , dataTypeClass=String.class , example = "os"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "q'w"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.POSITION , value = "位置" , required = false , dataTypeClass=String.class , example = "192.168.1.1"),
		@ApiImplicitParam(name = VoucherOwnerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "驱蚊器无安抚"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = VoucherOwnerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherOwnerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<VoucherOwner>> queryPagedList(VoucherOwnerVO sample) {
		Result<PagedList<VoucherOwner>> result=new Result<>();
		String employeeId=this.getSessionUser().getUser().getActivatedEmployeeId();
		ConditionExpr condition=new ConditionExpr();
		VoucherPriv vp=new VoucherPriv();
		vp.setStatus(StatusValidEnum.VALID.code());
		vp.setEmplId(employeeId);
		VoucherPriv vp_data=voucherPrivService.queryEntity(vp);
		if(vp_data==null){
			condition.and("id=?","0");
		}else{
			JSONArray obj= JSONArray.parseArray(vp_data.getType());
			List<String> items=new ArrayList<>();
			for (int i=0;i<obj.size();i++){
				items.add(obj.getString(i));
			}
			if(items.size()>0){
				condition.andIn("category_code",items);
			}else{
				condition.and("id=?","0");
			}

		}
		PagedList<VoucherOwner> list=voucherOwnerService.queryPagedList(sample,condition,sample.getPageSize(),sample.getPageIndex());
		// 关联出 用户凭证 数据
		voucherOwnerService.join(list,VoucherOwnerMeta.VOUCHER_LIST);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = VoucherOwnerServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(VoucherOwnerServiceProxy.EXPORT_EXCEL)
	public void exportExcel(VoucherOwnerVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=voucherOwnerService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = VoucherOwnerServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(VoucherOwnerServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=voucherOwnerService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = VoucherOwnerServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(VoucherOwnerServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=voucherOwnerService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}