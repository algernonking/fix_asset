package com.dt.platform.eam.controller;


import java.util.List;

import com.dt.platform.domain.eam.RepairOrder;
import com.github.foxnic.commons.collection.CollectorUtil;
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


import com.dt.platform.proxy.eam.RepairRuleServiceProxy;
import com.dt.platform.domain.eam.meta.RepairRuleVOMeta;
import com.dt.platform.domain.eam.RepairRule;
import com.dt.platform.domain.eam.RepairRuleVO;
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
import com.dt.platform.domain.eam.meta.RepairRuleMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.RepairGroup;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IRepairRuleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 分单规则 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-02 09:22:52
*/

@Api(tags = "分单规则")
@ApiSort(0)
@RestController("EamRepairRuleController")
public class RepairRuleController extends SuperController {

	@Autowired
	private IRepairRuleService repairRuleService;


	/**
	 * 添加分单规则
	*/
	@ApiOperation(value = "添加分单规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584673109706014720"),
		@ApiImplicitParam(name = RepairRuleVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = RepairRuleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = RepairRuleVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class , example = "583634707950862336"),
		@ApiImplicitParam(name = RepairRuleVOMeta.USER_ID , value = "成员" , required = false , dataTypeClass=String.class , example = "558321538131034112"),
		@ApiImplicitParam(name = RepairRuleVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = RepairRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = RepairRuleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleServiceProxy.INSERT)
	public Result insert(RepairRuleVO repairRuleVO) {
		Result result=repairRuleService.insert(repairRuleVO,false);
		return result;
	}



	/**
	 * 删除分单规则
	*/
	@ApiOperation(value = "删除分单规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584673109706014720")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = RepairRuleVOMeta.ID)
	@SentinelResource(value = RepairRuleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=repairRuleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除分单规则 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除分单规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = RepairRuleVOMeta.IDS)
	@SentinelResource(value = RepairRuleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=repairRuleService.deleteByIdsLogical(ids);
		return result;
	}

	/**
	 * 更新分单规则
	*/
	@ApiOperation(value = "更新分单规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584673109706014720"),
		@ApiImplicitParam(name = RepairRuleVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = RepairRuleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = RepairRuleVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class , example = "583634707950862336"),
		@ApiImplicitParam(name = RepairRuleVOMeta.USER_ID , value = "成员" , required = false , dataTypeClass=String.class , example = "558321538131034112"),
		@ApiImplicitParam(name = RepairRuleVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = RepairRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { RepairRuleVOMeta.PAGE_INDEX , RepairRuleVOMeta.PAGE_SIZE , RepairRuleVOMeta.SEARCH_FIELD , RepairRuleVOMeta.FUZZY_FIELD , RepairRuleVOMeta.SEARCH_VALUE , RepairRuleVOMeta.DIRTY_FIELDS , RepairRuleVOMeta.SORT_FIELD , RepairRuleVOMeta.SORT_TYPE , RepairRuleVOMeta.IDS } )
	@NotNull(name = RepairRuleVOMeta.ID)
	@SentinelResource(value = RepairRuleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleServiceProxy.UPDATE)
	public Result update(RepairRuleVO repairRuleVO) {
		Result result=repairRuleService.update(repairRuleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存分单规则
	*/
	@ApiOperation(value = "保存分单规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584673109706014720"),
		@ApiImplicitParam(name = RepairRuleVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = RepairRuleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = RepairRuleVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class , example = "583634707950862336"),
		@ApiImplicitParam(name = RepairRuleVOMeta.USER_ID , value = "成员" , required = false , dataTypeClass=String.class , example = "558321538131034112"),
		@ApiImplicitParam(name = RepairRuleVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = RepairRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairRuleVOMeta.PAGE_INDEX , RepairRuleVOMeta.PAGE_SIZE , RepairRuleVOMeta.SEARCH_FIELD , RepairRuleVOMeta.FUZZY_FIELD , RepairRuleVOMeta.SEARCH_VALUE , RepairRuleVOMeta.DIRTY_FIELDS , RepairRuleVOMeta.SORT_FIELD , RepairRuleVOMeta.SORT_TYPE , RepairRuleVOMeta.IDS } )
	@NotNull(name = RepairRuleVOMeta.ID)
	@SentinelResource(value = RepairRuleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleServiceProxy.SAVE)
	public Result save(RepairRuleVO repairRuleVO) {
		Result result=repairRuleService.save(repairRuleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取分单规则
	*/
	@ApiOperation(value = "获取分单规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = RepairRuleVOMeta.ID)
	@SentinelResource(value = RepairRuleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleServiceProxy.GET_BY_ID)
	public Result<RepairRule> getById(String id) {
		Result<RepairRule> result=new Result<>();
		RepairRule repairRule=repairRuleService.getById(id);
		// join 关联的对象
		repairRuleService.dao().fill(repairRule)
			.with(RepairRuleMeta.REPAIR_GROUP)
			.with(RepairRuleMeta.USER)
			.execute();

		repairRuleService.dao().join(repairRule.getUser(), Person.class);

		result.success(true).data(repairRule);
		return result;
	}


	/**
	 * 批量获取分单规则 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取分单规则")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RepairRuleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = RepairRuleVOMeta.IDS)
		@SentinelResource(value = RepairRuleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleServiceProxy.GET_BY_IDS)
	public Result<List<RepairRule>> getByIds(List<String> ids) {
		Result<List<RepairRule>> result=new Result<>();
		List<RepairRule> list=repairRuleService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询分单规则
	*/
	@ApiOperation(value = "查询分单规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584673109706014720"),
		@ApiImplicitParam(name = RepairRuleVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = RepairRuleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = RepairRuleVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class , example = "583634707950862336"),
		@ApiImplicitParam(name = RepairRuleVOMeta.USER_ID , value = "成员" , required = false , dataTypeClass=String.class , example = "558321538131034112"),
		@ApiImplicitParam(name = RepairRuleVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = RepairRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RepairRuleVOMeta.PAGE_INDEX , RepairRuleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RepairRuleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleServiceProxy.QUERY_LIST)
	public Result<List<RepairRule>> queryList(RepairRuleVO sample) {
		Result<List<RepairRule>> result=new Result<>();
		List<RepairRule> list=repairRuleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询分单规则
	*/
	@ApiOperation(value = "分页查询分单规则")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RepairRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "584673109706014720"),
		@ApiImplicitParam(name = RepairRuleVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = RepairRuleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = RepairRuleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = RepairRuleVOMeta.GROUP_ID , value = "班组" , required = false , dataTypeClass=String.class , example = "583634707950862336"),
		@ApiImplicitParam(name = RepairRuleVOMeta.USER_ID , value = "成员" , required = false , dataTypeClass=String.class , example = "558321538131034112"),
		@ApiImplicitParam(name = RepairRuleVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = RepairRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = RepairRuleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RepairRuleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<RepairRule>> queryPagedList(RepairRuleVO sample) {
		Result<PagedList<RepairRule>> result=new Result<>();
		PagedList<RepairRule> list=repairRuleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		repairRuleService.dao().fill(list)
			.with(RepairRuleMeta.REPAIR_GROUP)
			.with(RepairRuleMeta.USER)
			.execute();

		List<Employee> userList= CollectorUtil.collectList(list.getList(), RepairRule::getUser);
		repairRuleService.dao().join(userList, Person.class);


		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = RepairRuleServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairRuleServiceProxy.EXPORT_EXCEL)
	public void exportExcel(RepairRuleVO  sample,HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 数据
			ExcelWriter ew=repairRuleService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response,ew.getWorkBook(),ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = RepairRuleServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairRuleServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
		try{
			//生成 Excel 模版
			ExcelWriter ew=repairRuleService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		} catch (Exception e) {
			DownloadUtil.writeDownloadError(response,e);
		}
	}



	@SentinelResource(value = RepairRuleServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(RepairRuleServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=repairRuleService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}