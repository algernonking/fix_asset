package com.dt.platform.eam.controller;
import com.dt.platform.eam.service.IAssetAlarmService;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

@Api(tags = "资产告警")
@ApiSort(0)
@RestController("AssetAlarmController")
public class AssetAlarmController extends SuperController {

    @Autowired
    IAssetAlarmService assetAlarmService;




}
