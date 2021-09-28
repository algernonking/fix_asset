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
                id:"eam-asset-data-change-form-data-win",
                content: '/business/eam/asset_data_change/asset_data_change_list.html' + queryString,
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

            if(data.id){
                setTimeout(function(){
                    var assetCategorySelect= xmSelect.get('#categoryId',true);
                    if(assetCategorySelect){
                        assetCategorySelect.update({disabled:true})
                    }

                    var goodsSelect= xmSelect.get('#goodsId',true);
                    if(goodsSelect){
                        goodsSelect.update({disabled:true})
                    }

                    var manufacturerIdSelect= xmSelect.get('#manufacturerId',true);
                    if(manufacturerIdSelect){
                        manufacturerIdSelect.update({disabled:true})
                    }

                    var maintainerIdSelect= xmSelect.get('#maintainerId',true);
                    if(maintainerIdSelect){
                        maintainerIdSelect.update({disabled:true})
                    }


                    var warehouseIdSelect= xmSelect.get('#warehouseId',true);
                    if(warehouseIdSelect){
                        warehouseIdSelect.update({disabled:true})
                    }

                    var positionIdSelect= xmSelect.get('#positionId',true);
                    if(positionIdSelect){
                        positionIdSelect.update({disabled:true})
                    }

                    var sourceIdSelect= xmSelect.get('#sourceId',true);
                    if(sourceIdSelect){
                        sourceIdSelect.update({disabled:true})
                    }

                    var financialCategoryIdSelect= xmSelect.get('#financialCategoryId',true);
                    if(financialCategoryIdSelect){
                        console.log(89898989,financialCategoryIdSelect)
                        financialCategoryIdSelect.update({disabled:true})
                    }

                    var supplierSelect= xmSelect.get('#supplierId',true);
                    if(supplierSelect){
                        console.log(89898989,supplierSelect)
                        supplierSelect.update({disabled:true})
                    }



                    //列出下面不能编辑的清单
                    if($("#businessCode")){
                        $("#businessCode").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }
                    if($("#batchCode")){
                        $("#businessCode").attr("batchCode","disabled").css("background-color","#e6e6e6");
                    }
                    if($("#name")){
                        $("#name").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }
                    if($("#model")){
                        $("#model").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }
                    if($("#unit")){
                        $("#unit").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }
                    if($("#serviceLife")){
                        $("#serviceLife").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#serialNumber")){
                        $("#serialNumber").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#positionDetail")){
                        $("#positionDetail").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }
                    if($("#purchaseDate")){
                        $("#purchaseDate").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#assetNotes")){
                        $("#assetNotes").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#contacts")){
                        $("#contacts").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#director")){
                        $("#director").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#label")){
                        $("#label").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#financialNotes")){
                        $("#financialNotes").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }


                    if($("#maintenanceNotes")){
                        $("#maintenanceNotes").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }


                    if($("#maintenanceStartDate")){
                        $("#maintenanceStartDate").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#maintenanceEndDate")){
                        $("#maintenanceEndDate").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }


                    if($("#contactInformation")){
                        $("#contactInformation").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }


                    if($("#maintainerName")){
                        $("#maintainerName").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#ownCompanyId-button")){

                        $("#ownCompanyId-button").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#managerId-button")){
                        $("#managerId-button").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }


                    if($("#useOrganizationId-button")){
                        $("#useOrganizationId-button").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#useUserId-button")){
                        $("#useUserId-button").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }


                    if($("#pictureId-button")){
                        $("#pictureId-button").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#attach-button")){
                        $("#attach-button").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }


                    if($("#financialCode")){
                        $("#financialCode").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#originalUnitPrice")){
                        $("#originalUnitPrice").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }

                    if($("#purchaseUnitPrice")){
                        $("#purchaseUnitPrice").attr("disabled","disabled").css("background-color","#e6e6e6");
                    }




                },320)


            }


            setTimeout(function(){
                var assetStatusSelect= xmSelect.get('#assetStatus',true);
                if(assetStatusSelect){
                    assetStatusSelect.update({disabled:true})
                }
            },500)


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