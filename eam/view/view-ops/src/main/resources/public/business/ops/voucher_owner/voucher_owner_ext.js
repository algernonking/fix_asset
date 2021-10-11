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


    var action=admin.getTempData('ops-voucher-owner-form-data-form-action');

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
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {

            if(data&&data.id){
                var select_categoryCode= xmSelect.get('#categoryCode', true);
                select_categoryCode.update({ disabled: true });
            }else{
                setTimeout(function(){
                    //渲染 categoryCode 下拉字段
                    fox.renderSelectBox({
                        el: "categoryCode",
                        radio: true,
                        filterable: false,
                        //转换数据
                        transform: function(data) {
                            //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                            var opts=[];
                            if(!data) return opts;
                            for (var i = 0; i < data.length; i++) {
                                if(!data[i]) continue;
                                if(i==0){
                                    opts.push({name:data[i].label,value:data[i].code,selected:true});
                                }else{
                                    opts.push({name:data[i].label,value:data[i].code});
                                }

                            }
                            return opts;
                        }
                    });

                },100)

            }


        },
    }


    //
    window.pageExt={form:form,list:list};
});