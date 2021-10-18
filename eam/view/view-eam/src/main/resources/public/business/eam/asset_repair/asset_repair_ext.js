/**
 * 资产报修 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-07 17:49:53
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
    const moduleURL="/service-eam/eam-asset-repair";

    var timestamp = Date.parse(new Date());
    var formAction=admin.getTempData('eam-asset-scrap-form-data-form-action');

    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            if(APPROVAL_REQUIRED){
                var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                operHtml=operHtml.replace(/lay-event="confirm-data"/i, "style=\"display:none\"")
                document.getElementById("tableOperationTemplate").innerHTML=operHtml;
            }else{
                var operHtml=document.getElementById("tableOperationTemplate").innerHTML;
                operHtml=operHtml.replace(/lay-event="revoke-data"/i, "style=\"display:none\"")
                operHtml=operHtml.replace(/lay-event="for-approval"/i, "style=\"display:none\"")
                document.getElementById("tableOperationTemplate").innerHTML=operHtml;
            }
            console.log("list:beforeInit");
        },
        /**
         * 表格渲染前调用
         * @param cfg 表格配置参数
         * */
        beforeTableRender:function (cfg){
            console.log("list:beforeTableRender",cfg);
        },
        /**
         * 表格渲染后调用
         * */
        afterTableRender :function (){

        },
        afterSearchInputReady: function() {
            console.log("list:afterSearchInputReady");
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            param.title="覆盖对话框标题";
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
            for (var i = 0; i < data.length; i++) {
                //如果审批中或审批通过的不允许编辑
                if(data[i].status=="complete") {
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="incomplete"){
                    // fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="deny"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="approval"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    // fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }else if(data[i].status=="cancel"){
                    fox.disableButton($('.ops-delete-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.for-approval-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.confirm-data-button').filter("[data-id='" + data[i].id + "']"), true);
                    fox.disableButton($('.revoke-data-button').filter("[data-id='" + data[i].id + "']"), true);
                }
            }

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
         * 工具栏按钮事件前调用，如果返回 false 则不执行后续代码
         * */
        beforeToolBarButtonEvent:function (selected,obj) {
            console.log('beforeToolBarButtonEvent',selected,obj);
            return true;
        },
        /**
         * 列表操作栏按钮事件前调用，如果返回 false 则不执行后续代码
         * */
        beforeRowOperationEvent:function (data,obj) {
            console.log('beforeRowOperationEvent',data,obj);
            return true;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
        },
        downloadBill:function (data){
            console.log('downloadBill',data);
            var downloadUrl="/service-eam/eam-asset-bill/query-scrap-bill";
            fox.submit(downloadUrl,{id:data.id});
        },
        confirmData:function (item){
            var btn=$('.confirm-data-button').filter("[data-id='" + item.id + "']");
            var api=moduleURL+"/confirm-operation";
            admin.post(api,{id:item.id},function (r){
                if(r.success) {
                    top.layer.msg("已确认",{time:1000});
                    window.module.refreshTableData();
                } else {
                    var errs=[];
                    for (var i = 0; i < r.errors.length; i++) {
                        if(errs.indexOf(r.errors[i].message)==-1) {
                            errs.push(r.errors[i].message);
                        }
                    }
                    top.layer.msg(errs.join("<br>"),{time:2000});
                }
            },{delayLoading:2000,elms:[btn]});

        },
        forApproval:function (item){
            var btn=$('.for-approval-button').filter("[data-id='" + item.id + "']");
            var api=moduleURL+"/for-approval";
            admin.post(api,{id:item.id},function (r){
                if (r.success) {
                    layer.msg(r.message, {icon: 1, time: 500});
                    window.module.refreshTableData();
                } else {
                    var errs=[];
                    for (var i = 0; i < r.errors.length; i++) {
                        if(errs.indexOf(r.errors[i].message)==-1) {
                            errs.push(r.errors[i].message);
                        }
                    }
                    top.layer.msg(errs.join("<br>"),{time:2000});
                }
            },{delayLoading:2000,elms:[btn]});
        },
        revokeData:function (item){
            var btn=$('.revoke-data-button').filter("[data-id='" + item.id + "']");
            var api= moduleURL + "/revoke-operation";
            admin.post(api,{id:item.id},function (r){
                if(r.success) {
                    top.layer.msg("已撤销",{time:1000});
                    window.module.refreshTableData();
                } else {
                    var errs=[];
                    for (var i = 0; i < r.errors.length; i++) {
                        if(errs.indexOf(r.errors[i].message)==-1) {
                            errs.push(r.errors[i].message);
                        }
                    }
                    top.layer.msg(errs.join("<br>"),{time:2000});
                }
            },{delayLoading:2000,elms:[btn]});
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
            setTimeout(function(){
                var repairStatusSelect= xmSelect.get('#repairStatus',true);
                if(repairStatusSelect){
                    repairStatusSelect.update({disabled:true})
                }
            },150)

            console.log('beforeDataFill',data);
        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            if(data&&data.id){
                window.module.adjustPopup();
            }
            console.log('afterDataFill',data);
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            param.title="覆盖对话框标题";
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
            var dataListSize=$(".form-iframe")[0].contentWindow.module.getDataListSize();
            if(dataListSize==0){
                layer.msg("请选择资产数据", {icon: 2, time: 1000});
                return false;
            }
            data.selectedCode=timestamp;
            return true;
        },
        /**
         * 数据提交后执行
         * */
        afterSubmit:function (param,result) {

            console.log("afterSubmitt",param,result);
        },

        /**
         *  加载 资产列表
         */
        assetSelectList:function (ifr,win,data) {
            console.log("assetSelectList",ifr,data);
            //设置 iframe 高度
            ifr.height("450px");
            //设置地址
            var data={};
            data.searchContent={};
            data.assetSelectedCode=timestamp;
            data.assetBusinessType=BILL_TYPE
            data.action=formAction;
            if(BILL_ID==null)BILL_ID="";
            data.assetOwnerId=BILL_ID;
            admin.putTempData('eam-asset-selected-data'+timestamp,data,true);
            admin.putTempData('eam-asset-selected-action'+timestamp,formAction,true);
            win.location="/business/eam/asset/asset_selected_list.html?assetSelectedCode="+timestamp;

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