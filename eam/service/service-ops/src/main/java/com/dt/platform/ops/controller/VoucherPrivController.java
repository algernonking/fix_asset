package com.dt.platform.ops.controller;

 
import java.util.*;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.dt.platform.constants.enums.DictEnum;
import com.dt.platform.constants.enums.common.StatusValidEnum;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.domain.system.meta.DictItemVOMeta;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
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


import com.dt.platform.proxy.ops.VoucherPrivServiceProxy;
import com.dt.platform.domain.ops.meta.VoucherPrivVOMeta;
import com.dt.platform.domain.ops.VoucherPriv;
import com.dt.platform.domain.ops.VoucherPrivVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;

import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.ops.meta.VoucherPrivMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IVoucherPrivService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 凭证权限 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-05 12:20:11
*/

@Api(tags = "凭证权限")
@ApiSort(0)
@RestController("OpsVoucherPrivController")
public class VoucherPrivController extends SuperController {

	@Autowired
	private IVoucherPrivService voucherPrivService;



	/**
	 * 添加凭证权限
	*/
	@ApiOperation(value = "添加凭证权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherPrivVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486554803770494976"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.TYPE , value = "凭证类别" , required = false , dataTypeClass=String.class , example = "app"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.EMPL_ID , value = "用户" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = VoucherPrivVOMeta.ID)
	@NotNull(name = VoucherPrivVOMeta.TYPE)
	@NotNull(name = VoucherPrivVOMeta.EMPL_ID)
	@NotNull(name = VoucherPrivVOMeta.STATUS)
	@SentinelResource(value = VoucherPrivServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherPrivServiceProxy.INSERT)
	public Result insert(VoucherPrivVO voucherPrivVO) {
		Result result=voucherPrivService.insert(voucherPrivVO);
		return result;
	}

	
	/**
	 * 删除凭证权限
	*/
	@ApiOperation(value = "删除凭证权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherPrivVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486554803770494976"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = VoucherPrivVOMeta.ID)
	@SentinelResource(value = VoucherPrivServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherPrivServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=voucherPrivService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除凭证权限 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除凭证权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherPrivVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = VoucherPrivVOMeta.IDS)
	@SentinelResource(value = VoucherPrivServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherPrivServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=voucherPrivService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新凭证权限
	*/
	@ApiOperation(value = "更新凭证权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherPrivVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486554803770494976"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.TYPE , value = "凭证类别" , required = false , dataTypeClass=String.class , example = "app"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.EMPL_ID , value = "用户" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { VoucherPrivVOMeta.PAGE_INDEX , VoucherPrivVOMeta.PAGE_SIZE , VoucherPrivVOMeta.SEARCH_FIELD , VoucherPrivVOMeta.FUZZY_FIELD , VoucherPrivVOMeta.SEARCH_VALUE , VoucherPrivVOMeta.SORT_FIELD , VoucherPrivVOMeta.SORT_TYPE , VoucherPrivVOMeta.IDS } ) 
	@NotNull(name = VoucherPrivVOMeta.ID)
	@NotNull(name = VoucherPrivVOMeta.TYPE)
	@NotNull(name = VoucherPrivVOMeta.EMPL_ID)
	@NotNull(name = VoucherPrivVOMeta.STATUS)
	@SentinelResource(value = VoucherPrivServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherPrivServiceProxy.UPDATE)
	public Result update(VoucherPrivVO voucherPrivVO) {
		Result result=voucherPrivService.update(voucherPrivVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存凭证权限
	*/
	@ApiOperation(value = "保存凭证权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherPrivVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486554803770494976"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.TYPE , value = "凭证类别" , required = false , dataTypeClass=String.class , example = "app"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.EMPL_ID , value = "用户" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VoucherPrivVOMeta.PAGE_INDEX , VoucherPrivVOMeta.PAGE_SIZE , VoucherPrivVOMeta.SEARCH_FIELD , VoucherPrivVOMeta.FUZZY_FIELD , VoucherPrivVOMeta.SEARCH_VALUE , VoucherPrivVOMeta.SORT_FIELD , VoucherPrivVOMeta.SORT_TYPE , VoucherPrivVOMeta.IDS } )
	@NotNull(name = VoucherPrivVOMeta.ID)
	@NotNull(name = VoucherPrivVOMeta.TYPE)
	@NotNull(name = VoucherPrivVOMeta.EMPL_ID)
	@NotNull(name = VoucherPrivVOMeta.STATUS)
	@SentinelResource(value = VoucherPrivServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherPrivServiceProxy.SAVE)
	public Result save(VoucherPrivVO voucherPrivVO) {
		Result result=voucherPrivService.save(voucherPrivVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取凭证权限
	*/
	@ApiOperation(value = "获取凭证权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherPrivVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = VoucherPrivVOMeta.ID)
	@SentinelResource(value = VoucherPrivServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherPrivServiceProxy.GET_BY_ID)
	public Result<VoucherPriv> getById(String id) {
		Result<VoucherPriv> result=new Result<>();
		VoucherPriv voucherPriv=voucherPrivService.getById(id);
		voucherPrivService.join(voucherPriv,VoucherPrivMeta.EMPLOYEE);
		result.success(true).data(voucherPriv);
		return result;
	}




	/**
	 * 批量删除凭证权限 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除凭证权限")
		@ApiImplicitParams({
				@ApiImplicitParam(name = VoucherPrivVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = VoucherPrivVOMeta.IDS)
		@SentinelResource(value = VoucherPrivServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherPrivServiceProxy.GET_BY_IDS)
	public Result<List<VoucherPriv>> getByIds(List<String> ids) {
		Result<List<VoucherPriv>> result=new Result<>();
		List<VoucherPriv> list=voucherPrivService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询凭证权限
	*/
	@ApiOperation(value = "查询凭证权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherPrivVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486554803770494976"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.TYPE , value = "凭证类别" , required = false , dataTypeClass=String.class , example = "app"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.EMPL_ID , value = "用户" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VoucherPrivVOMeta.PAGE_INDEX , VoucherPrivVOMeta.PAGE_SIZE } )
	@SentinelResource(value = VoucherPrivServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherPrivServiceProxy.QUERY_LIST)
	public Result<List<VoucherPriv>> queryList(VoucherPrivVO sample) {
		Result<List<VoucherPriv>> result=new Result<>();
		List<VoucherPriv> list=voucherPrivService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	/**
	 * 查询凭证权限
	 */
	@ApiOperation(value = "查询凭证类型")
	@ApiOperationSupport(order=5 ,  ignoreParameters = { VoucherPrivVOMeta.PAGE_INDEX , VoucherPrivVOMeta.PAGE_SIZE } )
	@SentinelResource(value = VoucherPrivServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherPrivServiceProxy.QUERY_TYPE_LIST)
	public Result<List<DictItem>> queryVoucherTypeList() {
		Result<List<DictItem>> result=new Result<>();

		List<DictItem> list =new ArrayList<>();
		String employeeId=this.getSessionUser().getUser().getActivatedEmployeeId();
		//如果用户不存在
		if(employeeId==null||"".equals(employeeId)){
			result.success(true).data(list);
			return result;
		}

		VoucherPriv vpQuery=new VoucherPriv();
		vpQuery.setEmplId(employeeId);
		vpQuery.setStatus(StatusValidEnum.VALID.code());
		VoucherPriv vpData=voucherPrivService.queryEntity(vpQuery);
		if(vpData==null||"[]".equals(vpData.getType())||StringUtil.isBlank(vpData.getType())){
			result.success(true).data(list);
			return result;
		}

		String type=vpData.getType();
		DictItemVO diVo=new DictItemVO();
		diVo.setDictCode(DictEnum.OPS_VOUCHER_TYPE.code());
		Result<List<DictItem>> dictItem_result=DictItemServiceProxy.api().queryList(diVo);
		if(!dictItem_result.isSuccess()){
			return dictItem_result;
		}
		Map<String,String> map=new HashMap<>();
	 	String[] typeArr=type.split(",");
	 	for(String t:typeArr){
	 		map.put(t,t);
		}

		List<DictItem> dictItem_list=dictItem_result.getData();
		for(int i=0;i<dictItem_list.size();i++){
			String tempType=dictItem_list.get(i).getCode();
			System.out.println("tempType:"+tempType+",type:"+type);
			if(map.containsKey(tempType)){
				list.add(dictItem_list.get(i));
			}
		}
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询凭证权限
	*/
	@ApiOperation(value = "分页查询凭证权限")
	@ApiImplicitParams({
		@ApiImplicitParam(name = VoucherPrivVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "486554803770494976"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.TYPE , value = "凭证类别" , required = false , dataTypeClass=String.class , example = "app"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.EMPL_ID , value = "用户" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = VoucherPrivVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "valid"),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = VoucherPrivServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(VoucherPrivServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<VoucherPriv>> queryPagedList(VoucherPrivVO sample) {
		Result<PagedList<VoucherPriv>> result=new Result<>();
		PagedList<VoucherPriv> list=voucherPrivService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		voucherPrivService.join(list,VoucherPrivMeta.EMPLOYEE);

		List<Employee> employees= CollectorUtil.collectList(list, VoucherPriv::getEmployee);
		voucherPrivService.dao().join(employees, Person.class);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = VoucherPrivServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(VoucherPrivServiceProxy.EXPORT_EXCEL)
	public void exportExcel(VoucherPrivVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=voucherPrivService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = VoucherPrivServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(VoucherPrivServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=voucherPrivService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = VoucherPrivServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(VoucherPrivServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=voucherPrivService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}