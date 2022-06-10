/**
 * 保养任务 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-06 19:49:26
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

    //模块基础路径
    const moduleURL="/service-eam/eam-maintain-task";
    var timestamp = Date.parse(new Date());
    var formAction=admin.getTempData('eam-maintain-task-form-data-form-action');
    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");
            var operHtml=document.getElementById("toolbarTemplate").innerHTML;
            operHtml=operHtml.replace(/lay-event="create"/i, "style=\"display:none\"")
            document.getElementById("toolbarTemplate").innerHTML=operHtml;
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
            //param.title="覆盖对话框标题";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 当下拉框别选择后触发
         * */
        onSelectBoxChanged:function(id,selected,changes,isAdd) {
            console.log('onSelectBoxChanged',id,selected,changes,isAdd);
        },
        /**
         * 当日期选择组件选择后触发
         * */
        onDatePickerChanged:function(id,value, date, endDate) {
            console.log('onDatePickerChanged',id,value, date, endDate);
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
                console.log(data[i]);
                if(data[i].status=="finish"||data[i].status=="cancel") {
                    fox.disableButton($('.ops-edit-button').filter("[data-id='" + data[i].id + "']"), true);
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
         * 表单页面打开时，追加更多的参数信息
         * */
        makeFormQueryString:function(data,queryString,action) {
            return queryString;
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
        taskCancel:function(selected,obj){
            //调用批量删除接口
            top.layer.confirm(fox.translate('确定取消已选中的')+fox.translate('保养任务')+fox.translate('吗？'), function (i) {
                admin.post(moduleURL+"/cancel", { ids: selected }, function (data) {
                    if (data.success) {
                        fox.showMessage(data);
                        window.module.refreshTableData();

                      //  refreshTableData();
                    } else {
                        fox.showMessage(data);
                    }
                });
            });
            console.log(selected,obj);
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
         * 表单初始化前调用 , 并传入表单数据
         * */
        beforeInit:function (action,data) {
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit")
            $("#planName").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#planInfo").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#planNotes").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#planStartTime").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#planTotalCost").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#assetCode").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#assetName").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#assetModel").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#assetSn").attr("disabled","disabled").css("background-color","#e6e6e6");
            $("#actTotalCost").attr("disabled","disabled").css("background-color","#e6e6e6");


        },
        /**
         * 窗口调节前
         * */
        beforeAdjustPopup:function () {
            console.log('beforeAdjustPopup');
            return true;
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
            var d=[];
            var e={};
            e.data={};
            e.data.id=data.groupId;
            d.push(e);
            setTimeout(function(){
                form.onSelectBoxChanged("groupId",d,d,true);
                },200);

            $("#assetStatus").find("xm-select").css("background-color","#e6e6e6");
            $("#planMaintainType").find("xm-select").css("background-color","#e6e6e6");
            $("#planCycleMethod").find("xm-select").css("background-color","#e6e6e6");
            var assetStatusSelect= xmSelect.get('#assetStatus',true);
            if(assetStatusSelect){
                assetStatusSelect.update({disabled:true})
            }
            var planMaintainTypeSelect= xmSelect.get('#planMaintainType',true);
            if(planMaintainTypeSelect){
                planMaintainTypeSelect.update({disabled:true})
            }
            var planCycleMethodSelect= xmSelect.get('#planCycleMethod',true);
            if(planCycleMethodSelect){
                planCycleMethodSelect.update({disabled:true})
            }
            var groupIdSelect= xmSelect.get('#groupId',true);
            if(groupIdSelect){
                groupIdSelect.update({disabled:true})
            }


            console.log('afterDataFill',data);
        },
        /**
         * 对话框打开之前调用，如果返回 null 则不打开对话框
         * */
        beforeDialog:function (param){
            //param.title="覆盖对话框标题";
            return param;
        },
        /**
         * 对话框回调，表单域以及按钮 会自动改变为选中的值，此处处理额外的逻辑即可
         * */
        afterDialog:function (param,result) {
            console.log('dialog',param,result);
        },
        /**
         * 当下拉框别选择后触发
         * */
        onSelectBoxChanged:function(id,selected,changes,isAdd) {
            console.log('onSelectBoxChanged',id,selected,changes,isAdd);
            //isAdd, 此次操作是新增还是删除
            if(id=="groupId"){
                if(isAdd&&changes.length>0){
                    var userSelect= xmSelect.get('#executorId',true);
                    console.log("userSelect",userSelect);
                    var item=changes[0];
                    admin.post("/service-eam/eam-group-user/query-employee-person", { groupId : item.data.id }, function (r) {
                        if (r.success) {
                            var d=[];
                            for (var i = 0; i < r.data.length; i++) {
                                d.push({name:r.data[i].name,value:r.data[i].employeeId});
                            }
                            userSelect.update({data:d})
                        } else {
                            fox.showMessage(r);
                        }
                    });
                }
            }
        },
        /**
         * 当日期选择组件选择后触发
         * */
        onDatePickerChanged:function(id,value, date, endDate) {
            console.log('onDatePickerChanged',id,value, date, endDate);
        },
        onRadioBoxChanged:function(id,data,checked) {
            console.log('onRadioChanged',id,data,checked);
        },
        onCheckBoxChanged:function(id,data,checked) {
            console.log('onCheckBoxChanged',id,data,checked);
        },

        /**
         * 在流程提交前处理表单数据
         * */
        processFormData4Bpm:function(processInstanceId,param,callback) {
            // 设置流程变量，并通过回调返回
            var variables={};
            // 此回调是必须的，否则流程提交会被中断
            callback(variables);
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);


            return true;
        },
        /**
         * 数据提交后窗口关闭前，如果返回 false，停止后续步骤的执行
         * */
        betweenFormSubmitAndClose:function (param,result) {
            console.log("betweenFormSubmitAndClose",result);
            return true;
        },
        /**
         * 数据提交后执行
         * */
        afterSubmit:function (param,result) {
            console.log("afterSubmitt",param,result);
        },

        /**
         *  加载 保养项目
         */
        maintainSelectList:function (ifr,win,data) {
            // debugger
            console.log("goodsSelectList",ifr,data);
            //设置 iframe 高度
            ifr.height("450px");
            var ownerId="";
            if(data&&data.id){
                ownerId=data.id;
            }
            var ownerType="eam_asset_maintain_task"
            var queryString="?pageType="+formAction+"&selectedCode="+timestamp+"&ownerId="+ownerId+"&ownerType="+ownerType;
            //设置地址
            win.location="/business/eam/maintain_task_project/maintain_task_project_selected_list.html"+queryString

        },
        /**
         * 文件上传组件回调
         *  event 类型包括：
         *  afterPreview ：文件选择后，未上传前触发；
         *  afterUpload ：文件上传后触发
         *  beforeRemove ：文件删除前触发
         *  afterRemove ：文件删除后触发
         * */
        onUploadEvent: function(e) {
            console.log("onUploadEvent",e);
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