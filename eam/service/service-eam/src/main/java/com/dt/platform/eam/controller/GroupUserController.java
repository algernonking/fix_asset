package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.EmployeePerson;
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


import com.dt.platform.proxy.eam.GroupUserServiceProxy;
import com.dt.platform.domain.eam.meta.GroupUserVOMeta;
import com.dt.platform.domain.eam.GroupUser;
import com.dt.platform.domain.eam.GroupUserVO;
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
import com.dt.platform.domain.eam.meta.GroupUserMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IGroupUserService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 班组成员 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-31 21:18:52
*/

@Api(tags = "班组成员")
@ApiSort(0)
@RestController("EamGroupUserController")
public class GroupUserController extends SuperController {

	@Autowired
	private IGroupUserService groupUserService;


	/**
	 * 添加班组成员
	*/
	@ApiOperation(value = "添加班组成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = GroupUserServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GroupUserServiceProxy.INSERT)
	public Result insert(GroupUserVO groupUserVO) {
		Result result=groupUserService.insert(groupUserVO,false);
		return result;
	}



	/**
	 * 删除班组成员
	*/
	@ApiOperation(value = "删除班组成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = GroupUserVOMeta.ID)
	@SentinelResource(value = GroupUserServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GroupUserServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=groupUserService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除班组成员 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除班组成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GroupUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = GroupUserVOMeta.IDS)
	@SentinelResource(value = GroupUserServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GroupUserServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=groupUserService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新班组成员
	*/
	@ApiOperation(value = "更新班组成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { GroupUserVOMeta.PAGE_INDEX , GroupUserVOMeta.PAGE_SIZE , GroupUserVOMeta.SEARCH_FIELD , GroupUserVOMeta.FUZZY_FIELD , GroupUserVOMeta.SEARCH_VALUE , GroupUserVOMeta.DIRTY_FIELDS , GroupUserVOMeta.SORT_FIELD , GroupUserVOMeta.SORT_TYPE , GroupUserVOMeta.IDS } )
	@NotNull(name = GroupUserVOMeta.ID)
	@SentinelResource(value = GroupUserServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GroupUserServiceProxy.UPDATE)
	public Result update(GroupUserVO groupUserVO) {
		Result result=groupUserService.update(groupUserVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存班组成员
	*/
	@ApiOperation(value = "保存班组成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GroupUserVOMeta.PAGE_INDEX , GroupUserVOMeta.PAGE_SIZE , GroupUserVOMeta.SEARCH_FIELD , GroupUserVOMeta.FUZZY_FIELD , GroupUserVOMeta.SEARCH_VALUE , GroupUserVOMeta.DIRTY_FIELDS , GroupUserVOMeta.SORT_FIELD , GroupUserVOMeta.SORT_TYPE , GroupUserVOMeta.IDS } )
	@NotNull(name = GroupUserVOMeta.ID)
	@SentinelResource(value = GroupUserServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GroupUserServiceProxy.SAVE)
	public Result save(GroupUserVO groupUserVO) {
		Result result=groupUserService.save(groupUserVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取班组成员
	*/
	@ApiOperation(value = "获取班组成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = GroupUserVOMeta.ID)
	@SentinelResource(value = GroupUserServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GroupUserServiceProxy.GET_BY_ID)
	public Result<GroupUser> getById(String id) {
		Result<GroupUser> result=new Result<>();
		GroupUser groupUser=groupUserService.getById(id);
		result.success(true).data(groupUser);
		return result;
	}


	/**
	 * 批量获取班组成员 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取班组成员")
		@ApiImplicitParams({
				@ApiImplicitParam(name = GroupUserVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = GroupUserVOMeta.IDS)
		@SentinelResource(value = GroupUserServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GroupUserServiceProxy.GET_BY_IDS)
	public Result<List<GroupUser>> getByIds(List<String> ids) {
		Result<List<GroupUser>> result=new Result<>();
		List<GroupUser> list=groupUserService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询班组成员
	*/
	@ApiOperation(value = "查询班组成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { GroupUserVOMeta.PAGE_INDEX , GroupUserVOMeta.PAGE_SIZE } )
	@SentinelResource(value = GroupUserServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GroupUserServiceProxy.QUERY_LIST)
	public Result<List<GroupUser>> queryList(GroupUserVO sample) {
		Result<List<GroupUser>> result=new Result<>();
		List<GroupUser> list=groupUserService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询班组成员
	*/
	@ApiOperation(value = "分页查询班组成员")
	@ApiImplicitParams({
		@ApiImplicitParam(name = GroupUserVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = GroupUserVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = GroupUserVOMeta.USER_ID , value = "人员" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = GroupUserServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GroupUserServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<GroupUser>> queryPagedList(GroupUserVO sample) {
		Result<PagedList<GroupUser>> result=new Result<>();
		PagedList<GroupUser> list=groupUserService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}

	/**
	 * 分页查询班组成员
	 */
	@ApiOperation(value = "")

	@ApiOperationSupport(order=9)
	@SentinelResource(value = GroupUserServiceProxy.QUERY_EMPLOYEE_PERSON , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(GroupUserServiceProxy.QUERY_EMPLOYEE_PERSON)
	public Result<List<EmployeePerson>> queryEmployeePerson(String  groupId) {
		Result<List<EmployeePerson>> result=new Result<>();
		List<EmployeePerson> list=groupUserService.queryEmployeePerson(groupId);
		result.success(true).data(list);
		return result;
	}

	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = GroupUserServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GroupUserServiceProxy.EXPORT_EXCEL)
	public void exportExcel(GroupUserVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=groupUserService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = GroupUserServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GroupUserServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=groupUserService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = GroupUserServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(GroupUserServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=groupUserService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}