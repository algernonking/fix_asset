package com.dt.platform.eam.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.util.PoitlIOUtils;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.github.foxnic.commons.bean.BeanUtil;
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
import java.net.URLEncoder;
import java.util.HashMap;
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
@RestController("EamAssetBillController")
public class AssetBillController extends SuperController {


    @Autowired
    private IAssetBorrowService assetBorrowService;

    @Autowired
    private IAssetAllocationService assetAllocationService;

    @Autowired
    private IAssetCollectionService assetCollectionService;

    @Autowired
    private IAssetService assetService;

    @Autowired
    private IAssetCollectionReturnService assetCollectionReturnService;

    @Autowired
    private IAssetRepairService assetRepairService;

    @Autowired
    private IAssetScrapService assetScrapService;

    @SentinelResource(value = AssetBillServiceProxy.QUERY_ASSET_TRANSFER_BILL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_ASSET_TRANSFER_BILL)
    public void queryTransferBill(List<String> ids,HttpServletResponse response) throws Exception {
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_BORROW.code());
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

    @SentinelResource(value = AssetBillServiceProxy.QUERY_ASSET_TRANSFER_BILLS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_ASSET_TRANSFER_BILLS)
    public void queryTransferBills(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_BORROW.code());
        Map<String, Object> data=new HashMap<String, Object>();
        AssetBorrow billdata=assetBorrowService.getById(id);
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("转移单据-"+billdata.getBusinessCode()+".docx", "UTF-8"))));
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }


    @SentinelResource(value = AssetBillServiceProxy.QUERY_BORROW_BILLS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_BORROW_BILLS)
    public void queryBorrowBills(List<String> ids,HttpServletResponse response) throws Exception {
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_BORROW.code());
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
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_BORROW.code());
        Map<String, Object> data=new HashMap<String, Object>();
        AssetBorrow billdata=assetBorrowService.getById(id);
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("借用单据-"+billdata.getBusinessCode()+".docx", "UTF-8"))));
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
        InputStream inputstream= TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_ALLOCATE.code());
        Map<String, Object> data=new HashMap<String, Object>();
        AssetAllocation billdata=assetAllocationService.getById(id);
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("调拨单据-"+billdata.getBusinessCode()+".docx", "UTF-8"))));
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }

    @SentinelResource(value = AssetBillServiceProxy.QUERY_ALLOCATION_BILLS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_ALLOCATION_BILLS)
    public void queryAllocationBills(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_ALLOCATE.code());
        Map<String, Object> data=new HashMap<String, Object>();
        AssetAllocation billdata=assetAllocationService.getById(id);
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("调拨单据-"+billdata.getBusinessCode()+".docx", "UTF-8"))));
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
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_COLLECTION.code());
        AssetCollection billdata=assetCollectionService.getById(id);
        System.out.println(billdata);
        Map<String,Object> data=new HashMap<String,Object>();
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("领用单据-"+billdata.getBusinessCode()+".docx", "UTF-8"))));
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }

    @SentinelResource(value = AssetBillServiceProxy.QUERY_COLLECTION_BILLS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_COLLECTION_BILLS)
    public void queryCollectionBills(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_COLLECTION.code());
        AssetCollection billdata=assetCollectionService.getById(id);
        Map<String,Object> data=new HashMap<String,Object>();
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("领用单据-"+billdata.getBusinessCode()+".docx", "UTF-8"))));
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
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_COLLECTION_RETURN.code());
        AssetCollectionReturn billdata=assetCollectionReturnService.getById(id);
        Map<String,Object> data=new HashMap<String,Object>();
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("领用退库单据-"+billdata.getBusinessCode()+".docx", "UTF-8"))));
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }

    @SentinelResource(value = AssetBillServiceProxy.QUERY_COLLECTION_RETURN_BILLS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_COLLECTION_RETURN_BILLS)
    public void queryCollectionReturnBills(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_COLLECTION_RETURN.code());
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
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_ALLOCATE.code());
        AssetRepair billdata=assetRepairService.getById(id);
        Map<String,Object> data=new HashMap<String,Object>();
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("维修单据-"+billdata.getBusinessCode()+".docx", "UTF-8"))));
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }

    @SentinelResource(value = AssetBillServiceProxy.QUERY_REAPIR_BILLS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_REAPIR_BILLS)
    public void queryRepairBills(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_ALLOCATE.code());
        AssetRepair billdata=assetRepairService.getById(id);
        Map<String,Object> data=new HashMap<String,Object>();
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("维修单据-"+billdata.getBusinessCode()+".docx", "UTF-8"))));
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
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_SCRAP.code());
        AssetScrap billdata=assetScrapService.getById(id);
        Map<String,Object> data=new HashMap<String,Object>();
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("报废单据-"+billdata.getBusinessCode()+".docx", "UTF-8"))));
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        template.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(template, bos, out);
    }

    @SentinelResource(value = AssetBillServiceProxy.QUERY_SCRAP_BILLS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @RequestMapping(AssetBillServiceProxy.QUERY_SCRAP_BILLS)
    public void queryScrapBills(String id,HttpServletResponse response) throws Exception {
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_ASSET_SCRAP.code());
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
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_DOWNLOAD_ASSET_CARD.code());
        Asset billdata=assetService.getById(id);
        Map<String,Object> data=new HashMap<String,Object>();
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("资产卡片-"+billdata.getAssetCode()+".docx", "UTF-8"))));
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
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_DOWNLOAD_ASSET_CARD.code());
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
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_DOWNLOAD_ASSET_LABEl.code());
        Asset billdata=assetService.getById(id);
        Map<String,Object> data=new HashMap<String,Object>();
        data=BeanUtil.toMap(billdata);
        System.out.println(data.toString());
        XWPFTemplate template = XWPFTemplate.compile(inputstream).render(data);
        response.setContentType("application/msword");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("资产标签-"+billdata.getAssetCode()+".docx", "UTF-8"))));
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
        InputStream inputstream=TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_DOWNLOAD_ASSET_LABEl.code());
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
