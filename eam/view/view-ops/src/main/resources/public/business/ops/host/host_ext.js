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

    //列表页的扩展
    var list={

        /**
         * 查询前调用
         * */
        beforeQuery:function (conditions) {
            //获得缓存中的字典ID
            console.log("############################# start")
            var systemIdValue=admin.getTempData("systemId");
            console.log("conditions",conditions);
            console.log("systemIdValue",systemIdValue)

            if(systemIdValue){
                if(!conditions["systemId"]) {
                    conditions["systemId"]={value:[]};
                }
                conditions["systemId"].value.push(systemIdValue);
            }
            console.log("############################# end")
            return true;
        },
        exportHost:function (select,obj){
            console.log('download',select,obj);
            var downloadUrl="/service-ops/ops-data/export-host";
            fox.submit(downloadUrl);
        },
        /**
         * 打开凭证条目窗口
         * */
        openHostVoucherWindow: function (data) {
            admin.putTempData("ownerId",data.id,true);
            var index = admin.popupCenter({
                title: data.hostName+"的凭证条目",
                resize: false,
                id: 'hostVoucherWindow',
                area: ["80%", "600px"],
                type: 2,
                content: "/business/ops/voucher/voucher_list.html"
            });
        }
    }
    var action=admin.getTempData('ops-host-form-data-form-action')
    //表单页的扩展
    var form={
        /**
         * 表单数据填充后
         * */
        beforeDataFill:function (data) {
            //时间
            if(data.offlineTime&&data.offlineTime.length>10){
                data.offlineTime= data.offlineTime.substr(0,10);
            }
            if(data.onlineTime&&data.onlineTime.length>10){
                data.onlineTime= data.onlineTime.substr(0,10);
            }
            if(action=="create"){
                //上线日期处理
                setTimeout(function(){
                    var now = new Date();
                    var day = ("0" + now.getDate()).slice(-2);
                    var month = ("0" + (now.getMonth() + 1)).slice(-2);
                    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
                    $('#onlineTime').val(today);
                },100)
            }
            console.log('beforeDataFill',data);
        }
    }
    window.pageExt={form:form,list:list};
});