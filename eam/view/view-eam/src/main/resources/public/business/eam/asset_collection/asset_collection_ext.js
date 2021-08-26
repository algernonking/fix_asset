layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select',
    foxnicUpload: 'upload/foxnic-upload'
})
//
layui.define(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','foxnicUpload'],function () {

    var admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
    table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,foxup=layui.foxnicUpload;

    var action=admin.getTempData('eam-asset-collection-form-data-form-action')

    //列表页的扩展
    var list={
        /**
         * 查询前调用
         * */
        beforeQuery:function (conditions) {
            console.log('beforeQuery',conditions);
        }
    }

    //表单页的扩展
    var form={
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
                $('#collectionDate').val(today);


            }else{
                if (data.originator.name){
                    $("#originatorId").attr("value", data.originator.name);
                }
            }




        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {

            console.log("beforeSubmit",data);
            //制单人处理
            if(action=="create"){
                data.originatorId=PERSON_ID;
            }

            return true;
        }


    }
    //
    window.pageExt={form:form,list:list};
});