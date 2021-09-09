package com.dt.platform.eam.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.io.StreamUtil;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.dt.platform.proxy.eam.AssetBillServiceProxy;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资产单据下载
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-07 14:32:58
 */
@Api(tags = "资产单据")
@ApiSort(0)
@RestController("EAMAssetBillReport")

public class AssetBillReport extends SuperController {

    @Autowired
    private ITplFileService tplFileService;

    @Autowired
    private IAssetBorrowService assetBorrowService;

    @Autowired
    private IAssetCollectionService assetCollectionService;

    @Autowired
    private IAssetCollectionReturnService assetCollectionReturnService;

    @Autowired
    private IAssetRepairService assetRepairService;

    @Autowired
    private IAssetScrapService assetScrapService;

    @SentinelResource(value = AssetBillServiceProxy.QUERY_BORROW_BILLS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_BORROW_BILLS)
    public void queryBorrowBills(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

        tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_BORROW.code());


    }




}
