package com.dt.platform.eam.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONArray;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.MaintainProject;
import com.dt.platform.domain.eam.MaintainProjectVO;
import com.dt.platform.domain.eam.meta.MaintainProjectMeta;
import com.dt.platform.domain.eam.meta.MaintainProjectVOMeta;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.eam.service.IMaintainProjectService;
import com.dt.platform.proxy.eam.AssetReportServiceProxy;
import com.dt.platform.proxy.eam.MaintainProjectServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.api.validate.annotations.NotNull;
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
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import  com.dt.platform.proxy.eam.MaintainReportServiceProxy;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 保养项目 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-03 21:20:24
*/

@Api(tags = "保养报表")
@ApiSort(0)
@RestController("MaintainReportController")
public class MaintainReportController extends SuperController {


    @Autowired
    private IAssetService assetService;

    @ApiOperation(value = "")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = MaintainReportServiceProxy.MAINTAIN_ITEM_REPORT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MaintainReportServiceProxy.MAINTAIN_ITEM_REPORT)
    public  Result<JSONArray> maintainItemReport() {
        Result<JSONArray> result=new Result<>();

        String sql="select b.name,count(1) cnt from eam_maintain_task a, eam_maintain_plan b where a.status='finish' and a.deleted='0'\n" +
                "and a.plan_id=b.id group by b.name\n";
        RcdSet rs=assetService.dao().query(sql);
        result.data(rs.toJSONArrayWithJSONObject());
        return result;
    }
}