/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 21:49:28
 */


layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select',
    foxnicUpload: 'upload/foxnic-upload'
})
//
layui.define(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','foxnicUpload','dropdown'],function () {

    var admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate,dropdown=layui.dropdown;
    table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,foxup=layui.foxnicUpload;

    //列表页的扩展
    var list={
        assetDataChange:function (data){
            var queryString="?assetId="+data.id;
            var index=admin.popupCenter({
                title: "变更明细",
                resize: false,
                offset: [15,null],
                area: ["95%","80%"],
                type: 2,
                id:"eam-asset-data-change-detail-form-data-win",
                content: '/business/eam/asset_process_record/asset_process_record_list.html' + queryString,
                finish: function () {
                    refreshTableData();
                }
            });
            admin.putTempData('eam-asset-data-change-form-data-popup-index', index);
        },
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");
        },
        afterSearchInputReady: function() {
            console.log("list:afterSearchInputReady");
        },
        /**
         * 对话框之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            param.title="组织/人员选择对话框";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
            // debugger;
            window.module.refreshTableData();
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            param.title="组织/人员选择对话框";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 查询前调用
         * @param conditions 复合查询条件
         * @param param 请求参数
         * @param location 调用的代码位置
         * */
        beforeQuery:function (conditions,param,location) {
            console.log('beforeQuery',conditions,param,location);
            return true;
        },
        /**
         * 查询结果渲染后调用
         * */
        afterQuery : function (data) {

            function formatRackData(data,cap,rackuuid){
                var result={};
                var ctime=Date.now();
                var successdata=[];
                var successdata2=[];
                var faileddata=[];
                for(var i=0;i<data.length;i++){
                    var obj=data[i];
                    if(!data[i].frame){
                        data[i].result="frame不存在"
                        faileddata.push(data[i]);
                        continue;
                    }
                    var frame=data[i].frame.split("-");
                    if(frame.length!=2){
                        data[i].result="frame格式出错"
                        faileddata.push(data[i]);
                        continue;
                    }
                    var framest=frame[0];
                    var frameet=frame[1];
                    // console.log(framest+","+frameet+"|",parseInt(framest)+","+parseInt(frameet));
                    //frame错误判断
                    if(isNaN(framest)|| isNaN(frameet)||framest>frameet||framest>cap){
                        // console.log("failed")
                        data[i].result="frame格式出错"
                        faileddata.push(data[i]);
                        continue;
                    }
                    data[i].framest=parseInt(framest);
                    data[i].frameet=parseInt(frameet);
                    data[i].framediff=parseInt(frameet)-parseInt(framest);
                    successdata.push(data[i]);
                }
                //继续判断
                for(var i=0;i<successdata.length;i++){
                    var obj=successdata[i];
                    var flag="success";
                    for(var j=0;j<successdata.length;j++){
                        var matchobj=successdata[j];
                        if(obj.id==matchobj.id){
                            continue;
                        }
                        var a=obj.framest;
                        var b=obj.frameet;
                        var c=matchobj.framest;
                        var d=matchobj.frameet;
                        if(b<c||a>d){
                        }else{
                            flag="failed";
                            break;
                        }
                    }
                    console.log(a+","+b+","+c+","+d+",flag:"+flag+","+obj.id+matchobj.id);
                    if(flag=="success"){
                        successdata2.push(successdata[i])
                    }else{
                        successdata[i].result="frame冲突";
                        faileddata.push(successdata[i])
                    }
                }
                var noobj="<tr name=\"nonedevice\" id=\""+ctime+"f#SEQ#\">\n" +
                    "                    <td class=\"no-padding bg-light-blue\">#SEQ#</td>\n" +
                    "                    <td class=\"no-padding\"></td>\n" +
                    "                    <td class=\"no-padding bg-light-blue\">#SEQ#</td>\n" +
                    "                    <td class=\"no-padding\"></td>\n" +
                    "                    <td class=\"no-padding\"></td>\n" +
                    "                    <td class=\"no-padding\"></td>\n" +
                    "                    <td class=\"no-padding\"></td>\n" +
                    "                    <td class=\"no-padding\"></td>\n" +
                    "                    <td class=\"no-padding no-print\"></td>\n" +
                    "                </tr>";
                //显示html
                var htmltbbody="  <thead>\n" +
                    "                <tr class=\"active\">\n" +
                    "                    <th style=\"width:2%\" class=\"bg-light-blue\">U</th>\n" +
                    "                    <th style=\"text-align:center;width:16%\" class=\"bg-light-blue\">"+rackuuid+"</th>\n" +
                    "                    <th style=\"width:2%\" class=\"bg-light-blue\">U</th>\n" +
                    "                    <th style=\"text-align:center;\">状态</th>\n" +
                    "                    <th style=\"text-align:center;\">IP地址</th>\n" +
                    "                    <th style=\"text-align:center;\">设备SN号</th>\n" +
                    "                    <th style=\"text-align:center;\">设备型号</th>\n" +
                    "                    <th style=\"text-align:center;\">运行环境</th>\n" +
                    "                    <th style=\"text-align:center;\" class=\"no-print\">操作</th>\n" +
                    "                </tr>\n" +
                    "                </thead> <tbody>"
                var htmltr=[];
                //初始化机柜
                for(var i=0;i<cap;i++){
                    var u="";
                    if(i>9){u=i;}else{u="0"+i;}
                    htmltr.push(noobj.replace(new RegExp("#SEQ#","gm"),u));
                }
                //放置设备
                for(var i=0;i<successdata2.length;i++){
                    var assets=successdata2[i];
                    var s=assets.framest;
                    var e=assets.frameet;
                    var d=e-s+1;
                    var u="";
                    if(e>9){u=e;}else{u="0"+e;}
                    var rowspan="";
                    if(d>0){
                        rowspan="rowspan=\""+d+"\"";
                    }
                    var devhtml="<tr name=\"hasdevice\" class=\"danger\">\n" +
                        "                    <td style=\"vertical-align: middle;\" class=\"no-padding bg-light-blue\">"+u+"</td>\n" +
                        "                    <td style=\"vertical-align: middle;\" "+rowspan+" class=\"no-padding\"><a href=\"/detail/online-95/\">"+assets.code+"</a></td>\n" +
                        "                    <td style=\"vertical-align: middle;\" class=\"no-padding bg-light-blue\">"+u+"</td>\n" +
                        "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding\">"+assets.statusName+"</td>\n" +
                        "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding\"><span>"+assets.ip+"</span></td>\n" +
                        "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding\">"+assets.sn+"</td>\n" +
                        "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding\">"+assets.name+"/"+assets.model+"</td>\n" +
                        "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding\">"+assets.env+"</td>\n" +
                        "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding no-print\"><a href=\"/update/online-95/\"></a></td>\n" +
                        "                </tr>";
                    console.log("before")
                    console.log(htmltr[e])
                    htmltr[e]=devhtml;
                    console.log("after")
                    console.log(htmltr[e])
                    if(d>1){
                        for(var j=1;j<d;j++){
                            var ii=e-j;
                            var uu="";
                            if(ii>9){uu=ii;}else{uu="0"+ii;}
                            var devhtml2="<tr name=\"hasdevice\" class=\"danger\">\n" +
                                "                    <td style=\"vertical-align: middle;\" class=\"no-padding bg-light-blue\">"+uu+"</td>\n" +
                                "                    <td style=\"vertical-align: middle;\" class=\"no-padding bg-light-blue\">"+uu+"</td>\n" +
                                "                </tr>";
                            console.log("AAAbefore")
                            console.log(htmltr[ii])
                            htmltr[ii]=devhtml2;
                            console.log("AAAafter")
                            console.log(htmltr[ii])

                        }
                    }
                }
                for(var i=htmltr.length-1;i>0;i--){
                    htmltbbody=htmltbbody+htmltr[i];
                }
                htmltbbody=htmltbbody+"<tr>\n" +
                    "                    <td class=\"no-padding bg-light-blue\">-1</td>\n" +
                    "                    <td class=\"no-padding bg-light-blue\"></td>\n" +
                    "                    <td class=\"no-padding bg-light-blue\">-1</td>\n" +
                    "                     <td class=\"no-padding\"></td><td class=\"no-padding\"></td><td class=\"no-padding\"></td><td class=\"no-padding\"></td><td class=\"no-padding\"></td><td class=\"no-padding no-print\"></td>\n" +
                    "                </tr>\n" +
                    "                </tbody>";
                var htmltable="<table id=\"rack-detail\" style=\"text-align:center;margin:0; padding:0;\" class=\"table table-bordered text-center nowarp table-condensed\">"+htmltbbody+"</table>";
                result.htmltable=htmltable;
                result.falied=faileddata;
                result.success=successdata2;
                return result;
            }
            var rk="";
            var tmpArr=[];
            for(var i=0;i<data.length;i++){
                var o=data[i];
                if(i==0){
                    if(o.rack){
                        rk=o.rack.rackName;
                    }
                }
                var obj={};
                obj.ip=o.equipmentIp;
                if(o.assetStatus){
                    if(o.assetStatus=="idle"){
                        obj.statusName="闲置"
                    }else if(o.assetStatus=="using"){
                        obj.statusName="使用"
                    }else{
                        obj.statusName=o.assetStatus;
                    }
                }
                obj.name=o.name;
                obj.code=o.assetCode;
                obj.model=o.model;
                if(o.equipmentEnvironment){
                    obj.env=o.equipmentEnvironment.label;
                }
                obj.sn=o.serialNumber
                if(o.rackDownNumber&&o.rackUpNumber){
                    //  obj.frame=o.rackDownNumber+"-"+rackUpNumber;
                    obj.frame=o.rackUpNumber+"-"+o.rackDownNumber;
                }
                tmpArr.push(obj);
            }
            console.log(tmpArr);
            var htmltab= formatRackData(tmpArr,45,rk);
            var html=htmltab.htmltable;
            $("#rackTabShow").html(html);
            console.log(htmltab);

        },
        /**
         * 进一步转换 list 数据
         * */
        templet:function (field,value,r) {
            if(value==null) return "";
            return value;
        },
        /**
         * 在新建或编辑窗口打开前调用，若返回 false 则不继续执行后续操作
         * */
        beforeEdit:function (data) {
            console.log('beforeEdit',data);
            return true;
        },
        /**
         * 单行删除前调用，若返回false则不执行后续操作
         * */
        beforeSingleDelete:function (data) {
            console.log('beforeSingleDelete',data);
            return true;
        },
        afterSingleDelete:function (data){
            console.log('beforeSingleDelete',data);
            return true;
        },
        /**
         * 批量删除前调用，若返回false则不执行后续操作
         * */
        beforeBatchDelete:function (selected) {
            console.log('beforeBatchDelete',selected);
            return true;
        },
        /**
         * 批量删除后调用，若返回false则不执行后续操作
         * */
        afterBatchDelete:function (data) {
            console.log('afterBatchDelete',data);
            return true;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
        },
        /**
         * 末尾执行
         */
        ending:function() {

        }
    }

    //表单页的扩展
    var form={
        /**
         * 表单初始化前调用
         * */
        beforeInit:function () {
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit")
        },
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            console.log('beforeDataFill',data);
        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            console.log('afterDataFill',data);
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            param.title="组织/人员选择对话框";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
            return true;
        },
        /**
         * 数据提交后执行
         * */
        afterSubmit:function (param,result) {
            console.log("afterSubmitt",param,result);
        },

        /**
         * 末尾执行
         */
        ending:function() {

        }
    }
    //
    window.pageExt={form:form,list:list};
});