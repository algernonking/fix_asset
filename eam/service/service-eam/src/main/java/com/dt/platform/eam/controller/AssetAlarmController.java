package com.dt.platform.eam.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.eam.service.IAssetAlarmService;
import com.dt.platform.proxy.eam.AssetAlarmServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "资产告警")
@ApiSort(0)
@RestController("AssetAlarmController")
public class AssetAlarmController extends SuperController {

    @Autowired
    IAssetAlarmService assetAlarmService;


    @ApiOperation(value = "资产借用过期数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = AssetAlarmServiceProxy.QUERY_BORROW_EXPIRATION_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetAlarmServiceProxy.QUERY_BORROW_EXPIRATION_DATA)
    public Result queryBorrowExpirationData(AssetVO sample) {
        Result<PagedList<Asset>> result=new Result<>();
        PagedList<Asset> list= assetAlarmService.queryBorrowAlarmData(sample,sample.getPageSize(),sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }


    @ApiOperation(value = "资产领用过期数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = AssetAlarmServiceProxy.QUERY_COLLECTION_EXPIRATION_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetAlarmServiceProxy.QUERY_COLLECTION_EXPIRATION_DATA)
    public Result queryCollectionExpirationData(AssetVO sample) {
        Result<PagedList<Asset>> result=new Result<>();
        PagedList<Asset> list= assetAlarmService.queryCollectionAlarmData(sample,sample.getPageSize(),sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }


    @ApiOperation(value = "资产维保过期数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = AssetAlarmServiceProxy.QUERY_MAINTENANCE_EXPIRATION_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(AssetAlarmServiceProxy.QUERY_MAINTENANCE_EXPIRATION_DATA)
    public Result queryMaintenanceExpirationData(AssetVO sample) {
        Result<PagedList<Asset>> result=new Result<>();
        PagedList<Asset> list= assetAlarmService.queryMaintenanceAlarmData(sample,sample.getPageSize(),sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }




}
