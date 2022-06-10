package com.dt.platform.eam.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONArray;
import com.dt.platform.domain.eam.InspectionPlan;
import com.dt.platform.domain.eam.InspectionPlanVO;
import com.dt.platform.domain.eam.meta.InspectionPlanMeta;
import com.dt.platform.domain.eam.meta.InspectionPlanVOMeta;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.eam.service.IInspectionPlanService;
import com.dt.platform.proxy.eam.InspectionPlanServiceProxy;
import com.dt.platform.proxy.eam.InspectionReportServiceProxy;
import com.dt.platform.proxy.eam.MaintainReportServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.dao.data.PagedList;
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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 巡检计划 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-06 21:18:33
*/

@Api(tags = "巡检计划")
@ApiSort(0)
@RestController("InspectionReportController")
public class InspectionReportController extends SuperController {


    @Autowired
    private IAssetService assetService;


    @ApiOperation(value = "")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = InspectionReportServiceProxy.INSPECTION_POINT_REPORT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(InspectionReportServiceProxy.INSPECTION_POINT_REPORT)
    public  Result<JSONArray> inspectionPointReport() {
        Result<JSONArray> result=new Result<>();


        return result;
    }

}