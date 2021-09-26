package com.dt.platform.ops.controller;

 
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


import com.dt.platform.proxy.ops.InformationSystemServiceProxy;
import com.dt.platform.domain.ops.meta.InformationSystemVOMeta;
import com.dt.platform.domain.ops.InformationSystem;
import com.dt.platform.domain.ops.InformationSystemVO;
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
import com.dt.platform.domain.ops.meta.InformationSystemMeta;
import com.dt.platform.domain.ops.Voucher;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IInformationSystemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 信息系统 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 12:15:03
*/

@Api(tags = "信息系统")
@ApiSort(0)
@RestController("OpsInformationSystemController")
public class InformationSystemController extends SuperController {

	@Autowired
	private IInformationSystemService informationSystemService;

	
	/**
	 * 添加信息系统
	*/
	@ApiOperation(value = "添加信息系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InformationSystemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "491353803505799168"),
		@ApiImplicitParam(name = InformationSystemVOMeta.PID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = InformationSystemVOMeta.PROFILE , value = "介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.STATUS , value = "当前状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = InformationSystemVOMeta.OPS_METHOD , value = "运维模式" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.DEV_METHOD , value = "开发模式" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.TECHNICAL_CONTACT , value = "技术联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BUSINESS_CONTACT , value = "业务联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BELONG_ORG_ID , value = "所属公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.LASTDRILL_DATE , value = "最后一次演练" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.ONLINE_DATE , value = "上线时间" , required = false , dataTypeClass=Date.class , example = "2021-09-17 12:00:00"),
		@ApiImplicitParam(name = InformationSystemVOMeta.OFFLINE_DATE , value = "下线时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.OS_INFO , value = "操作系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.DB_INFO , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.APP_INFO , value = "应用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.GRADE , value = "等级" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.RTO , value = "RTO" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.RPO , value = "RPO" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.HARDWARE_INFO , value = "硬件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BACKUP_INFO , value = "备份信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.SAMEPLACE_BACUP_INFO , value = "本地备份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.DIFFPLACE_BACKUP_INFO , value = "异地备份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.ARCH_METHOD , value = "归档模式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@SentinelResource(value = InformationSystemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InformationSystemServiceProxy.INSERT)
	public Result insert(InformationSystemVO informationSystemVO) {
		Result result=informationSystemService.insert(informationSystemVO);
		return result;
	}

	
	/**
	 * 删除信息系统
	*/
	@ApiOperation(value = "删除信息系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InformationSystemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "491353803505799168")
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = InformationSystemVOMeta.ID)
	@SentinelResource(value = InformationSystemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InformationSystemServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=informationSystemService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除信息系统 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除信息系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InformationSystemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = InformationSystemVOMeta.IDS)
	@SentinelResource(value = InformationSystemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InformationSystemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=informationSystemService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新信息系统
	*/
	@ApiOperation(value = "更新信息系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InformationSystemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "491353803505799168"),
		@ApiImplicitParam(name = InformationSystemVOMeta.PID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = InformationSystemVOMeta.PROFILE , value = "介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.STATUS , value = "当前状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = InformationSystemVOMeta.OPS_METHOD , value = "运维模式" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.DEV_METHOD , value = "开发模式" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.TECHNICAL_CONTACT , value = "技术联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BUSINESS_CONTACT , value = "业务联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BELONG_ORG_ID , value = "所属公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.LASTDRILL_DATE , value = "最后一次演练" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.ONLINE_DATE , value = "上线时间" , required = false , dataTypeClass=Date.class , example = "2021-09-17 12:00:00"),
		@ApiImplicitParam(name = InformationSystemVOMeta.OFFLINE_DATE , value = "下线时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.OS_INFO , value = "操作系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.DB_INFO , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.APP_INFO , value = "应用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.GRADE , value = "等级" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.RTO , value = "RTO" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.RPO , value = "RPO" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.HARDWARE_INFO , value = "硬件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BACKUP_INFO , value = "备份信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.SAMEPLACE_BACUP_INFO , value = "本地备份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.DIFFPLACE_BACKUP_INFO , value = "异地备份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.ARCH_METHOD , value = "归档模式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { InformationSystemVOMeta.PAGE_INDEX , InformationSystemVOMeta.PAGE_SIZE , InformationSystemVOMeta.SEARCH_FIELD , InformationSystemVOMeta.FUZZY_FIELD , InformationSystemVOMeta.SEARCH_VALUE , InformationSystemVOMeta.SORT_FIELD , InformationSystemVOMeta.SORT_TYPE , InformationSystemVOMeta.IDS } ) 
	@NotNull(name = InformationSystemVOMeta.ID)
	@SentinelResource(value = InformationSystemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InformationSystemServiceProxy.UPDATE)
	public Result update(InformationSystemVO informationSystemVO) {
		Result result=informationSystemService.update(informationSystemVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存信息系统
	*/
	@ApiOperation(value = "保存信息系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InformationSystemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "491353803505799168"),
		@ApiImplicitParam(name = InformationSystemVOMeta.PID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = InformationSystemVOMeta.PROFILE , value = "介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.STATUS , value = "当前状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = InformationSystemVOMeta.OPS_METHOD , value = "运维模式" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.DEV_METHOD , value = "开发模式" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.TECHNICAL_CONTACT , value = "技术联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BUSINESS_CONTACT , value = "业务联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BELONG_ORG_ID , value = "所属公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.LASTDRILL_DATE , value = "最后一次演练" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.ONLINE_DATE , value = "上线时间" , required = false , dataTypeClass=Date.class , example = "2021-09-17 12:00:00"),
		@ApiImplicitParam(name = InformationSystemVOMeta.OFFLINE_DATE , value = "下线时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.OS_INFO , value = "操作系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.DB_INFO , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.APP_INFO , value = "应用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.GRADE , value = "等级" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.RTO , value = "RTO" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.RPO , value = "RPO" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.HARDWARE_INFO , value = "硬件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BACKUP_INFO , value = "备份信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.SAMEPLACE_BACUP_INFO , value = "本地备份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.DIFFPLACE_BACKUP_INFO , value = "异地备份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.ARCH_METHOD , value = "归档模式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InformationSystemVOMeta.PAGE_INDEX , InformationSystemVOMeta.PAGE_SIZE , InformationSystemVOMeta.SEARCH_FIELD , InformationSystemVOMeta.FUZZY_FIELD , InformationSystemVOMeta.SEARCH_VALUE , InformationSystemVOMeta.SORT_FIELD , InformationSystemVOMeta.SORT_TYPE , InformationSystemVOMeta.IDS } )
	@NotNull(name = InformationSystemVOMeta.ID)
	@SentinelResource(value = InformationSystemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InformationSystemServiceProxy.SAVE)
	public Result save(InformationSystemVO informationSystemVO) {
		Result result=informationSystemService.save(informationSystemVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取信息系统
	*/
	@ApiOperation(value = "获取信息系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InformationSystemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = InformationSystemVOMeta.ID)
	@SentinelResource(value = InformationSystemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InformationSystemServiceProxy.GET_BY_ID)
	public Result<InformationSystem> getById(String id) {
		Result<InformationSystem> result=new Result<>();
		InformationSystem informationSystem=informationSystemService.getById(id);
		// 关联出 所属公司/部门 数据
		informationSystemService.join(informationSystem,InformationSystemMeta.BELONG_ORGANIZATION);
		// 关联出 用户凭证 数据
		informationSystemService.join(informationSystem,InformationSystemMeta.VOUCHER_LIST);
		result.success(true).data(informationSystem);
		return result;
	}


	/**
	 * 批量删除信息系统 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除信息系统")
		@ApiImplicitParams({
				@ApiImplicitParam(name = InformationSystemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = InformationSystemVOMeta.IDS)
		@SentinelResource(value = InformationSystemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InformationSystemServiceProxy.GET_BY_IDS)
	public Result<List<InformationSystem>> getByIds(List<String> ids) {
		Result<List<InformationSystem>> result=new Result<>();
		List<InformationSystem> list=informationSystemService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询信息系统
	*/
	@ApiOperation(value = "查询信息系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InformationSystemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "491353803505799168"),
		@ApiImplicitParam(name = InformationSystemVOMeta.PID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = InformationSystemVOMeta.PROFILE , value = "介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.STATUS , value = "当前状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = InformationSystemVOMeta.OPS_METHOD , value = "运维模式" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.DEV_METHOD , value = "开发模式" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.TECHNICAL_CONTACT , value = "技术联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BUSINESS_CONTACT , value = "业务联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BELONG_ORG_ID , value = "所属公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.LASTDRILL_DATE , value = "最后一次演练" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.ONLINE_DATE , value = "上线时间" , required = false , dataTypeClass=Date.class , example = "2021-09-17 12:00:00"),
		@ApiImplicitParam(name = InformationSystemVOMeta.OFFLINE_DATE , value = "下线时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.OS_INFO , value = "操作系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.DB_INFO , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.APP_INFO , value = "应用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.GRADE , value = "等级" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.RTO , value = "RTO" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.RPO , value = "RPO" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.HARDWARE_INFO , value = "硬件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BACKUP_INFO , value = "备份信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.SAMEPLACE_BACUP_INFO , value = "本地备份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.DIFFPLACE_BACKUP_INFO , value = "异地备份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.ARCH_METHOD , value = "归档模式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { InformationSystemVOMeta.PAGE_INDEX , InformationSystemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = InformationSystemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InformationSystemServiceProxy.QUERY_LIST)
	public Result<List<InformationSystem>> queryList(InformationSystemVO sample) {
		Result<List<InformationSystem>> result=new Result<>();
		List<InformationSystem> list=informationSystemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询信息系统
	*/
	@ApiOperation(value = "分页查询信息系统")
	@ApiImplicitParams({
		@ApiImplicitParam(name = InformationSystemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "491353803505799168"),
		@ApiImplicitParam(name = InformationSystemVOMeta.PID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "121212"),
		@ApiImplicitParam(name = InformationSystemVOMeta.PROFILE , value = "介绍" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.STATUS , value = "当前状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = InformationSystemVOMeta.OPS_METHOD , value = "运维模式" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.DEV_METHOD , value = "开发模式" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.TECHNICAL_CONTACT , value = "技术联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BUSINESS_CONTACT , value = "业务联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BELONG_ORG_ID , value = "所属公司/部门" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.LASTDRILL_DATE , value = "最后一次演练" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.ONLINE_DATE , value = "上线时间" , required = false , dataTypeClass=Date.class , example = "2021-09-17 12:00:00"),
		@ApiImplicitParam(name = InformationSystemVOMeta.OFFLINE_DATE , value = "下线时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.OS_INFO , value = "操作系统" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.DB_INFO , value = "数据库" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.APP_INFO , value = "应用" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.GRADE , value = "等级" , required = false , dataTypeClass=String.class , example = "[]"),
		@ApiImplicitParam(name = InformationSystemVOMeta.RTO , value = "RTO" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.RPO , value = "RPO" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.HARDWARE_INFO , value = "硬件信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.BACKUP_INFO , value = "备份信息" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.SAMEPLACE_BACUP_INFO , value = "本地备份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.DIFFPLACE_BACKUP_INFO , value = "异地备份" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.ARCH_METHOD , value = "归档模式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.LABELS , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = InformationSystemVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = InformationSystemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(InformationSystemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<InformationSystem>> queryPagedList(InformationSystemVO sample) {
		Result<PagedList<InformationSystem>> result=new Result<>();
		PagedList<InformationSystem> list=informationSystemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// 关联出 所属公司/部门 数据
		informationSystemService.join(list,InformationSystemMeta.BELONG_ORGANIZATION);
		// 关联出 用户凭证 数据
		informationSystemService.join(list,InformationSystemMeta.VOUCHER_LIST);
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = InformationSystemServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InformationSystemServiceProxy.EXPORT_EXCEL)
	public void exportExcel(InformationSystemVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=informationSystemService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = InformationSystemServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InformationSystemServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=informationSystemService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}



	@SentinelResource(value = InformationSystemServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(InformationSystemServiceProxy.IMPORT_EXCEL)
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

		List<ValidateResult> errors=informationSystemService.importExcel(input,0,true);
		if(errors==null || errors.isEmpty()) {
			return ErrorDesc.success();
		} else {
			return ErrorDesc.failure().message("导入失败").data(errors);
		}
	}


}