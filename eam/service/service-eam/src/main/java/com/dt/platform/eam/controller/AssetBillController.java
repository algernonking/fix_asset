package com.dt.platform.eam.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.util.PoitlIOUtils;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.eam.service.*;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dt.platform.proxy.eam.AssetBillServiceProxy;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 资产单据下载
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-07 14:32:58
 */
@Api(tags = "资产单据")
@ApiSort(0)
@RestController("EamAssetBillController")
public class AssetBillController extends SuperController {

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
    public void queryBorrowBills(List<String> ids,HttpServletResponse response) throws Exception {
        InputStream inputstream=tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_BORROW.code());
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("name","121212");
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(map);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"asset.docx"+"\"");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }

    @SentinelResource(value = AssetBillServiceProxy.QUERY_BORROW_BILL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_BORROW_BILL)
    public void queryBorrowBill(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_BORROW.code());
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("name","121212");
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(map);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"asset.docx"+"\"");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }

    @SentinelResource(value = AssetBillServiceProxy.QUERY_ALLOCATION_BILL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_ALLOCATION_BILL)
    public void queryAllocationBill(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_ALLOCATE.code());
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("name","121212");
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(map);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"asset.docx"+"\"");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }


    @SentinelResource(value = AssetBillServiceProxy.QUERY_COLLECTION_BILL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_COLLECTION_BILL)
    public void queryCollectionBill(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_COLLECTION.code());
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("name","121212");
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(map);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"asset.docx"+"\"");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }

    @SentinelResource(value = AssetBillServiceProxy.QUERY_COLLECTION_RETURN_BILL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_COLLECTION_RETURN_BILL)
    public void queryCollectionReturnBill(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_COLLECTION_RETURN.code());
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("name","121212");
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(map);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"asset.docx"+"\"");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }


    @SentinelResource(value = AssetBillServiceProxy.QUERY_REAPIR_BILL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_REAPIR_BILL)
    public void queryRepairBill(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_ALLOCATE.code());
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("name","121212");
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(map);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"asset.docx"+"\"");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }


    @SentinelResource(value = AssetBillServiceProxy.QUERY_SCRAP_BILL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_SCRAP_BILL)
    public void queryScrapBill(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_SCRAP.code());
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("name","121212");
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(map);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"asset.docx"+"\"");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }


    @SentinelResource(value = AssetBillServiceProxy.QUERY_ASSET_CARD , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_ASSET_CARD)
    public void queryAssetCard(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_CARD.code());
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("name","121212");
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(map);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"asset.docx"+"\"");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }


    @SentinelResource(value = AssetBillServiceProxy.QUERY_ASSET_CARDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_ASSET_CARDS)
    public void queryAssetCards(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_CARD.code());
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("name","121212");
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(map);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"asset.docx"+"\"");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }


    @SentinelResource(value = AssetBillServiceProxy.QUERY_ASSET_LABEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_ASSET_LABEL)
    public void queryAssetLabel(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_CODE.code());
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("name","121212");
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(map);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"asset.docx"+"\"");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }


    @SentinelResource(value = AssetBillServiceProxy.QUERY_ASSET_LABELS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_ASSET_LABELS)
    public void queryAssetLabels(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=tplFileService.getTplFileStreamByCode(CodeModuleEnum.EAM_ASSET_CODE.code());
        HashMap<String, Object> map=new HashMap<String, Object>();
        map.put("name","121212");
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(map);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition","attachment;filename=\""+"asset.docx"+"\"");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }


}
