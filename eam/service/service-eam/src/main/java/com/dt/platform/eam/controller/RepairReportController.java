package com.dt.platform.eam.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONArray;
import com.dt.platform.domain.eam.RepairGroup;
import com.dt.platform.domain.eam.RepairGroupVO;
import com.dt.platform.domain.eam.meta.InspectionGroupMeta;
import com.dt.platform.domain.eam.meta.RepairGroupMeta;
import com.dt.platform.domain.eam.meta.RepairGroupVOMeta;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.eam.service.IRepairGroupService;
import com.dt.platform.proxy.eam.MaintainReportServiceProxy;
import com.dt.platform.proxy.eam.RepairGroupServiceProxy;
import com.dt.platform.proxy.eam.RepairReportServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 维修班组 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-30 12:58:15
*/

@Api(tags = "维修报表")
@ApiSort(0)
@RestController("RepairReportController")
public class RepairReportController extends SuperController {

    @Autowired
    private IAssetService assetService;


    @ApiOperation(value = "")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = RepairReportServiceProxy.GROUP_REPORT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(RepairReportServiceProxy.GROUP_REPORT)
    public  Result<JSONArray> groupReport() {
        Result<JSONArray> result=new Result<>();
        String sql="select c.id,c.name ,count(1) order_cnt from eam_repair_order a,eam_repair_order_act b ,eam_repair_group c where a.repair_status='finish' and a.deleted='0'\n" +
                "and a.id=b.order_id and c.id=b.group_id\n" +
                "group by c.id,c.name";
        RcdSet rs=assetService.dao().query(sql);
        result.data(rs.toJSONArrayWithJSONObject());
        return result;
    }
}