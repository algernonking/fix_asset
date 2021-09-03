/**
 * 资产报废 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-25 12:54:00
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


    var action=admin.getTempData('eam-asset-scrap-form-data-form-action')

    //列表页的扩展
    var list={

    }

    //表单页的扩展
    var form={

        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            console.log('afterDataFill',data);
            //制单人处理
            $("#originatorId").attr("disabled","disabled").css("background-color","#e6e6e6");
            if(action=="create"){
                $("#originatorId").attr("value",PERSON_NAME );
                $("#originatorId").attr("userId",PERSON_ID);
                //领用日期处理
                var now = new Date();
                var day = ("0" + now.getDate()).slice(-2);
                var month = ("0" + (now.getMonth() + 1)).slice(-2);
                var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
                $('#scrapDate').val(today);

            }else{
                if (data.originator.name){
                    $("#originatorId").attr("value", data.originator.name);
                }
            }

        }

    }
    //
    window.pageExt={form:form,list:list};
});