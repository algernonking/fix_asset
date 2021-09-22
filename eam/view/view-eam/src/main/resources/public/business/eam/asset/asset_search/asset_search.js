/**
 * 菜单 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-08 10:22:55
 */


function ListPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect;


    this.init=function(layui) {

        admin = layui.admin, settings = layui.settings, form = layui.form, upload = layui.upload;
        table = layui.table, layer = layui.layer, util = layui.util, fox = layui.foxnic, xmSelect = layui.xmSelect;

        admin.putTempData('eam-asset-list-data-btn-controller', {
            addButton: "hide",
            deleteButton: "hide",
            opsEditButton: "hide",
            opsDeleteButton: "hide"
        }, true);
    }


};


layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util', 'settings',  'upload','foxnic','xmSelect',"dropdown"],function() {
    (new ListPage()).init(layui);
});