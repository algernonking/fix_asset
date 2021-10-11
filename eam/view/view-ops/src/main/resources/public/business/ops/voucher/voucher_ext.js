/**
 * 凭证 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-02 17:10:00
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
         * 查询前调用
         * */
        beforeQuery:function (conditions) {
            console.log('beforeQuery',conditions);
            //获得缓存中的字典ID
            var ownerIdValue=admin.getTempData("ownerId");
            console.log("ownerIdValue",ownerIdValue);
            //设置固定的查询条件
            if(!conditions["ownerId"]) conditions["ownerId"]={};
            conditions["ownerId"].value=ownerIdValue;

            return true;
        },
        /**
         * 打开凭证条目窗口
         * */
        openHistoryVoucherWindow: function (data) {
            admin.putTempData("voucherId",data.id,true);
            var index = admin.popupCenter({
                title: "凭证历史条目",
                resize: false,
                id: 'hostVoucherHistoryWindow',
                area: ["80%", "600px"],
                type: 2,
                content: "/business/ops/voucher_history/voucher_history_list.html"
            });
        },

    }

    var form={


        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            console.log('afterDataFill',data);
            if(data&&data.id){
                var select_userCode= xmSelect.get('#userCode', true);
                var select_type= xmSelect.get('#type', true);
                select_userCode.update({ disabled: true });
                select_type.update({ disabled: true });
            }else{

                setTimeout(function(){

                    //渲染 type 下拉字段
                    fox.renderSelectBox({
                        el: "type",
                        radio: true,
                        filterable: true,
                        //转换数据
                        transform: function(data) {
                            //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                            var opts=[];
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
                    //渲染 userCode 下拉字段
                    fox.renderSelectBox({
                        el: "userCode",
                        radio: true,
                        filterable: true,
                        //转换数据
                        transform: function(data) {
                            //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                            var opts=[];
                            for (var i = 0; i < data.length; i++) {
                                if(!data[i]) continue;
                                if(i==0){
                                    opts.push({name:data[i].text,value:data[i].code,selected:true});
                                }else{
                                    opts.push({name:data[i].text,value:data[i].code});
                                }

                            }
                            return opts;
                        }
                    });

                },100)




            }


        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            var ownerIdValue=admin.getTempData("ownerId");
            console.log("ownerIdValue",ownerIdValue);
            if(ownerIdValue){
                data["ownerId"]=ownerIdValue;
            }
            console.log("beforeSubmit",data);
            return true;
        }
    }
    //
    window.pageExt={form:form,list:list};
});