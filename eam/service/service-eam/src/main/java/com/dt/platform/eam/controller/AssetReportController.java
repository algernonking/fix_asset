package com.dt.platform.eam.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.eam.service.IAssetRepairService;
import com.dt.platform.eam.service.IAssetReportService;
import com.dt.platform.proxy.eam.AssetReportServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "资产报表")
@ApiSort(0)
@RestController("AssetReportController")
public class AssetReportController extends SuperController {



    @Autowired
    private IAssetReportService assetReportService;

    @ApiOperation(value = "组织资产数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = AssetReportServiceProxy.QUERY_ORGANIZATION_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.QUERY_ORGANIZATION_DATA)
    public Result<JSONArray> queryOrganizationData(Asset sample) {
        Result<JSONArray> result=new Result<>();
        result.success(true).data(assetReportService.queryOrganizationData(sample));
        return result;
    }



    @ApiOperation(value = "分类资产数据")
    @ApiOperationSupport(order=2)
    @SentinelResource(value = AssetReportServiceProxy.QUERY_CATEGORY_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.QUERY_CATEGORY_DATA)
    public  Result<JSONArray> queryCategoryData(Asset sample) {
        Result<JSONArray> result=new Result<>();
        result.success(true).data(assetReportService.queryCategoryData(sample));
        return result;
    }


    @ApiOperation(value = "面板数据")
    @ApiOperationSupport(order=3)
    @SentinelResource(value = AssetReportServiceProxy.DASHBOARD , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetReportServiceProxy.DASHBOARD)
    public  Result<JSONObject> dashBoard() {
        Result<JSONObject> result=new Result<>();
        return assetReportService.dashboard();
    }


}
