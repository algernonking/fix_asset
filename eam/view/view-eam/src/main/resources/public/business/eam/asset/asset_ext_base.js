/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-02 13:48:32
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
        /**
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");
        },
        /**
         * 查询前调用
         * */
        beforeQuery:function (conditions) {
            console.log('beforeQuery',conditions);
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
        other:function(){

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
            return true;
        },
        /**
         *  加载 基本信息
         */
        loadBaseInfoIframe:function (ifr,win,data) {
            // debugger
            console.log("loadBaseInfoIframe",ifr,data);
            //设置 iframe 高度
            ifr.parents(".layui-tab").height("550px");
            ifr.height("500px");
            //设置参数
            admin.putTempData("eam-asset-form-data",data,true);
            //设置地址
            win.location="/business/eam/asset/asset_form.html";
        },



        /**
         *  加载 维保信息
         */
        loadMaintainerIframe:function (ifr,win,data) {
            // debugger
            console.log("loadMaintainerIframe",ifr,data);
            //设置 iframe 高度
            ifr.parents(".layui-tab").height("550px");
            ifr.height("500px");
            //设置参数
            admin.putTempData("eam-asset-ext-maintainer-form-data",data,true);
            //设置地址
            win.location="/business/eam/asset_ext_maintainer/asset_ext_maintainer_form.html";
        },


        /**
         *  加载 财务信息
         */
        loadFinancialIframe:function (ifr,win,data) {
            // debugger
            console.log("loadFinancialIframe",ifr,data);
            //设置 iframe 高度
            ifr.parents(".layui-tab").height("550px");
            ifr.height("500px");
            //设置参数
            admin.putTempData("eam-asset-ext-financial-form-data",data,true);
            //设置地址
            win.location="/business/eam/asset_ext_financial/asset_ext_financial_form.html";
        },


        other:function(){

        }
    }
    //
    window.pageExt={form:form,list:list};
});