/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 08:26:48
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

    const moduleURL="/service-eam/eam-asset";
    var formAction=admin.getTempData('eam-asset-form-data-form-action');
    //列表页的扩展
    var list={

        assetVoucher:function (data){
            admin.putTempData("ownerId",data.id,true);
            var index = admin.popupCenter({
                title: "凭证条目",
                resize: false,
                id: 'hostVoucherWindow',
                area: ["80%", "600px"],
                type: 2,
                content: "/business/ops/voucher/voucher_list.html"
            });
        },
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
        highExportData:function(data,item){
            var categoryId;
            var assetCategorySelect= xmSelect.get('#categoryId',true);
            if(assetCategorySelect){
               categoryValue= assetCategorySelect.getValue();
               console.log("categoryValue:"+categoryValue);
               if(categoryValue&&categoryValue.length>0){
                    categoryId=categoryValue[0].id;
               }
            }
            var value = {};
            value.businessCode={ value: $("#businessCode").val()};
            value.assetCode={ value: $("#assetCode").val()};
            value.status={ value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr")};
            value.assetStatus={ value: xmSelect.get("#assetStatus",true).getValue("value"), label:xmSelect.get("#assetStatus",true).getValue("nameStr")};
            value.name={ value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
            value.manufacturerId={ value: xmSelect.get("#manufacturerId",true).getValue("value"), fillBy:"manufacturer",field:"id", label:xmSelect.get("#manufacturerId",true).getValue("nameStr") };
            value.model={ value: $("#model").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
            value.serialNumber={ value: $("#serialNumber").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
            value.ownCompanyId={ inputType:"button",value: $("#ownCompanyId").val(),fillBy:["ownerCompany","fullName"] ,label:$("#ownCompanyId-button").text()};
            value.useOrganizationId={ inputType:"button",value: $("#useOrganizationId").val(),fillBy:["useOrganization","fullName"] ,label:$("#useOrganizationId-button").text()};
            value.managerId={ inputType:"button",value: $("#managerId").val(),fillBy:["manager","name"] ,label:$("#managerId-button").text()};
            value.useUserId={ inputType:"button",value: $("#useUserId").val(),fillBy:["useUser","name"] ,label:$("#useUserId-button").text()};
            value.positionId={ value: xmSelect.get("#positionId",true).getValue("value"), fillBy:"position",field:"id", label:xmSelect.get("#positionId",true).getValue("nameStr") };
            value.sourceId={ value: xmSelect.get("#sourceId",true).getValue("value"), fillBy:"source",field:"code", label:xmSelect.get("#sourceId",true).getValue("nameStr") };
            value.purchaseDate={ begin: $("#purchaseDate-begin").val(), end: $("#purchaseDate-end").val() };
            value.assetNotes={ value: $("#assetNotes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
            var ps={searchField: "$composite", searchValue: JSON.stringify(value)};
            var downloadUrl="/service-eam/eam-asset/export-excel";
            if(categoryId){
                ps.categoryId=categoryId;
            }
            var task=setTimeout(function(){layer.load(2);},10);
            fox.submit(downloadUrl,ps,"post",function(){
                clearTimeout(task);
                layer.closeAll('loading');
                console.log("execute finish");
            });
        },

        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            if(!APPROVAL_REQUIRED){
                var toolHtml=document.getElementById("toolbarTemplate").innerHTML;
                toolHtml=toolHtml.replace(/lay-event="batchRevoke"/i, "style=\"display:none\"")
                toolHtml=toolHtml.replace(/lay-event="forBatchApproval"/i, "style=\"display:none\"")
                document.getElementById("toolbarTemplate").innerHTML=toolHtml;
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

        forBatchApproval:function(data,item){
            console.log("####",data,item)
            var api=moduleURL+"/for-batch-approval";
            admin.post(api,data,function (r){
                if (r.success) {
                    layer.msg(r.message, {icon: 1, time: 500});
                } else {
                    layer.msg(r.message, {icon: 2, time: 1000});
                }
            },{delayLoading:2000,elms:[$("#forBatchApproval-button")]});
        },
        batchRevokeOperation:function(data,item){
            var api=moduleURL+"/batch-revoke-operation";
            admin.post(api,data,function (r){
                if (r.success) {
                    layer.msg(r.message, {icon: 1, time: 500});
                } else {
                    layer.msg(r.message, {icon: 2, time: 1000});
                }
            },{delayLoading:2000,elms:[$("#batchRevoke-button")]});
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
            $("#ownCompanyId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});
            $("#useOrganizationId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});
            $("#managerId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});
            $("#useUserId-button").css({"border-color":"#eee","height": "38px","color": "rgba(0,0,0,.85)","border-style": "solid","background-color":"white","border-radius": "2px","border-width": "1px"});


            if( $("#attribution-tab-ct").find(".layui-form-item").length==0 ){
                $("#attribution-tab-ct").hide();
                $("#attribution-tab").hide();
            }
            if( $("#maintainer-tab-ct").find(".layui-form-item").length==0 ){
                $("#maintainer-tab-ct").hide();
                $("#maintainer-tab").hide();
            }
            if( $("#financial-tab-ct").find(".layui-form-item").length==0 ){
                $("#financial-tab-ct").hide();
                $("#financial-tab").hide();
            }
            if( $("#equipment-tab-ct").find(".layui-form-item").length==0 ){
                $("#equipment-tab-ct").hide();
                $("#equipment-tab").hide();
            }
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit")
        },
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            if($("#assetCode")){
                $("#assetCode").attr("disabled","disabled").css("background-color","#e6e6e6");
            }
            if(data&&data.id){
                setTimeout(function() {
                    var assetCategorySelect = xmSelect.get('#categoryId', true);
                    if (assetCategorySelect) {
                        assetCategorySelect.update({disabled: true})
                    }
                },500);
                if(!ASSET_DIRECT_UPDATE_MODE){
                    fox.lockForm($("#data-form"),true);
                }
                if("view"==formAction){
                    $('#data-form').find("input").attr('placeholder','');
                }
                if(data.purchaseDate&&data.purchaseDate.length>10){
                    data.purchaseDate= data.purchaseDate.substr(0,10);
                }
                if(data.productionDate&&data.productionDate.length>10){
                    data.productionDate= data.productionDate.substr(0,10);
                }
                if(data.maintenanceStartDate&&data.maintenanceStartDate.length>10){
                    data.maintenanceStartDate= data.maintenanceStartDate.substr(0,10);
                }
                if(data.maintenanceEndDate&&data.maintenanceEndDate.length>10){
                    data.maintenanceEndDate= data.maintenanceEndDate.substr(0,10);
                }
            }else{
                if(ASSET_DEFAULT_OWN_COMPANY&&ASSET_DEFAULT_OWN_COMPANY.id){

                    $('#ownCompanyId-button').find("span").each(function (index, e) {
                        $(e).html(ASSET_DEFAULT_OWN_COMPANY.fullName);
                        // var not_Btn=$(e).find("i");
                        // if(not_Btn.length>0){
                        //     var txt = $(e).text();
                        //     // if (txt && txt.length > 0 && txt.includes("选择")) {
                        //
                        //     //}
                        // }
                    })
                    $('#ownCompanyId').val(ASSET_DEFAULT_OWN_COMPANY.id);

                }
            }

            if(ASSET_STATUS_COLUMN_DISABLE){
                setTimeout(function(){
                    var assetStatusSelect= xmSelect.get('#assetStatus',true);
                    if(assetStatusSelect){
                        assetStatusSelect.update({disabled:true})
                    }
                },500)
            }

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
            //获取自定义数据
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