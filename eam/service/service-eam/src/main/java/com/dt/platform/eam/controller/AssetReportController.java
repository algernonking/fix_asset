package com.dt.platform.eam.controller;
import com.dt.platform.eam.service.IAssetRepairService;
import com.dt.platform.eam.service.IAssetReportService;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "资产报表")
@ApiSort(0)
@RestController("AssetReportController")
public class AssetReportController extends SuperController {


    @Autowired
    private IAssetReportService assetReportService;


  //  private IAssetRepairService assetRepairService;

  //  private IAssetRepairService assetRepairService;
//    @Autowired
//    private IAssetRepairService assetRepairService;
//
//    @Autowired
//    private IAssetReportService assetReportService;




}
