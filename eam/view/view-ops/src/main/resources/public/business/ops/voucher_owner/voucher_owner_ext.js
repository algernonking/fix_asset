/**
 * 所属凭证 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-02 22:16:34
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
         * 打开凭证条目窗口
         * */
        openHostVoucherWindow: function (data) {
            admin.putTempData("ownerId",data.id,true);
            var index = admin.popupCenter({
                title: data.name+"的凭证条目",
                resize: false,
                id: 'hostVoucherWindow',
                area: ["80%", "600px"],
                type: 2,
                content: "/business/ops/voucher/voucher_list.html"
            });
        },

    }

    //表单页的扩展
    var form={

    }
    //
    window.pageExt={form:form,list:list};
});