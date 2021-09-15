package com.dt.platform.ops.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.deepoove.poi.util.PoitlIOUtils;
import com.dt.platform.domain.ops.HostVO;
import com.dt.platform.domain.ops.meta.HostVOMeta;
import com.dt.platform.ops.service.IOpsDataService;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dt.platform.proxy.ops.OpsDataServiceProxy;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 主机 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:06:49
*/

@Api(tags = "运维服务")
@ApiSort(0)
@RestController("OpsDataController")
public class OpsDataController extends SuperController {

    @Autowired
    IOpsDataService opsDatService;

    /**
     * 导出主机
     */
    @ApiOperation(value = "导出主机")
    @ApiImplicitParams({
            @ApiImplicitParam(name = HostVOMeta.SYSTEM_ID , value = "信息系统" , required = false , dataTypeClass=String.class , example = "478693133681430528"),
            @ApiImplicitParam(name = HostVOMeta.HOST_TYPE , value = "主机类型" , required = false , dataTypeClass=String.class , example = "business"),
            @ApiImplicitParam(name = HostVOMeta.STATUS , value = "主机状态" , required = false , dataTypeClass=String.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.HOST_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "ERP系统"),
            @ApiImplicitParam(name = HostVOMeta.HOST_IP , value = "物理IP" , required = false , dataTypeClass=String.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.HOST_VIP , value = "虚拟VIP" , required = false , dataTypeClass=String.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.ENVIRONMENT , value = "运行环境" , required = false , dataTypeClass=String.class , example = "[]"),
            @ApiImplicitParam(name = HostVOMeta.POSITION_ID , value = "位置" , required = false , dataTypeClass=String.class , example = "[]"),
            @ApiImplicitParam(name = HostVOMeta.MONITOR_STATUS , value = "监控状态" , required = false , dataTypeClass=String.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.DIRECTOR_USERNAME , value = "负责人" , required = false , dataTypeClass=String.class),
            @ApiImplicitParam(name = HostVOMeta.HOST_MEMORY , value = "内存" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.HOST_CPU , value = "CPU" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.HOST_CONF , value = "其他配置" , required = false , dataTypeClass=String.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.USER_OS_ADMIN , value = "系统管理员" , required = false , dataTypeClass=String.class),
            @ApiImplicitParam(name = HostVOMeta.USER_DB_ADMIN , value = "数据库管理员" , required = false , dataTypeClass=String.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.USER_DB_USED , value = "数据库使用用户" , required = false , dataTypeClass=String.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.USER_APP_USED , value = "应用使用用户" , required = false , dataTypeClass=String.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.USER_OPS_OPER , value = "运维操作用户" , required = false , dataTypeClass=String.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.USER_OTHER , value = "其他用户" , required = false , dataTypeClass=String.class , example = "1"),
            @ApiImplicitParam(name = HostVOMeta.PASSWORD_STRATEGY_ID , value = "改密策略" , required = false , dataTypeClass=String.class , example = "ops"),
            @ApiImplicitParam(name = HostVOMeta.OFFLINE_TIME , value = "下线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-13 12:00:00"),
            @ApiImplicitParam(name = HostVOMeta.ONLINE_TIME , value = "上线时间" , required = false , dataTypeClass=Date.class , example = "2021-08-14 12:00:00"),
            @ApiImplicitParam(name = HostVOMeta.ARCH , value = "是否归档" , required = false , dataTypeClass=String.class , example = "0"),
            @ApiImplicitParam(name = HostVOMeta.LABELS , value = "标签" , required = false , dataTypeClass=String.class),
            @ApiImplicitParam(name = HostVOMeta.HOST_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
    })
    @ApiOperationSupport(order=1)
    @SentinelResource(value = OpsDataServiceProxy.EXPORT_HOST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(OpsDataServiceProxy.EXPORT_HOST)
    public Result exportHost(HostVO sample, HttpServletResponse response) throws Exception {
        String code="ops_download_host";
        InputStream inputstream= TplFileServiceProxy.api().getTplFileStreamByCode(code);
        if(inputstream==null){
            return  ErrorDesc.failure().message("获取模板文件失败");
        }

        File f=opsDatService.saveTempFile(inputstream,"TMP_"+code+".xls");
        System.out.println(f.getPath());
        Map<String,Object> map= opsDatService.queryHostMap(sample);
        TemplateExportParams templateExportParams = new TemplateExportParams(f.getPath());
        Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("主机列表.xls", "UTF-8"))));
        response.setContentType("application/vnd.ms-excel");
        OutputStream out = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(out);
        workbook.write(bos);
        bos.flush();
        out.flush();
        PoitlIOUtils.closeQuietlyMulti(workbook, bos, out);
        return ErrorDesc.success();

    }


}