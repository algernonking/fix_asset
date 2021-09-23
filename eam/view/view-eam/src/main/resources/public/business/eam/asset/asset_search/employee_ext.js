/**
 * 员工 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-26 17:22:30
 * @version
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

    var lockedType, lockedId;

    //列表页的扩展
    var list={
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");
        },
        /**
         * 查询前调用
         * @param conditions 复合查询条件
         * @param param 请求参数
         * */
        beforeQuery:function (conditions,param,location) {
            //debugger
            console.log('beforeQuery',conditions,param);
            if(lockedType=="pos") {
                param.positionId=lockedId;
            }
            if(lockedType=="com" || lockedType=="dept") {
                param.orgId=lockedId;
            }
            return true;
        },
        afterQuery:function (){
            if(!lockedType) {
                fox.disableButton($("#add-button"),true);
            }
            if(lockedType=="dept" || lockedType=="com") {
                fox.disableButton($("#add-button"),true);
            }
            if(lockedType=="pos") {
                fox.disableButton($("#add-button"),false);
            }

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
        /**
         * 批量删除前调用，若返回false则不执行后续操作
         * */
        beforeBatchDelete:function (selected) {
            console.log('beforeBatchDelete',selected);
            return true;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
        },
        createUser:function (data){
            admin.request(api, data, function (data) {
                clearTimeout(task);
                layer.closeAll('loading');
                if (data.success) {
                    layer.msg(data.message, {icon: 1, time: 500});
                    var index=admin.getTempData('hrm-employee-form-data-popup-index');
                    admin.finishPopupCenter(index);
                } else {
                    layer.msg(data.message, {icon: 2, time: 1000});
                }
            }, "POST");
        },
        lockRange:function (type,id) {
            debugger
            lockedType=type;
            lockedId=id;
            admin.putTempData("lockedPositionId",null,true);
            if(lockedType=="pos") {
                admin.putTempData("lockedPositionId",lockedId,true);
            }
            window.module.refreshTableData();
        },
        /**
         * 末尾执行
         */
        ending:function() {
            window.module.lockRange=this.lockRange;
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
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
            debugger;
            data.positionId= admin.getTempData("lockedPositionId");;
            return true;
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