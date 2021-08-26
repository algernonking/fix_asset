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
            var action=admin.getTempData('ops-host-form-data-form-action')

            laydate.render({
                elem: '#onlineTime',
                format:"yyyy-MM-dd",
                trigger:"click"
            });

            if(action=="create"){
                //上线日期处理
                var now = new Date();
                var day = ("0" + now.getDate()).slice(-2);
                var month = ("0" + (now.getMonth() + 1)).slice(-2);
                var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
                $('#onlineTime').val(today);



                //渲染 environment 下拉字段
                fox.renderSelectBox({
                    el: "environment",
                    radio: true,
                    filterable: false,
                    //转换数据
                    transform: function(data) {
                        //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                        var opts=[];
                        for (var i = 0; i < data.length; i++) {
                            if(!data[i]) continue;
                            if(i==0){
                                opts.push({name:data[i].text,value:data[i].code,selected: true});
                            }else{
                                opts.push({name:data[i].text,value:data[i].code});
                            }
                        }
                        return opts;
                    }
                });
                $('input[name=status]:first').prop("checked","true")
                $('input[name=monitorStatus]:first').prop("checked","true")

                fox.renderSelectBox({
                    el: "hostType",
                    radio: true,
                    filterable: true,
                    //转换数据
                    transform: function(data) {
                        //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                        var opts=[];
                        for (var i = 0; i < data.length; i++) {
                            if(!data[i]) continue;
                            if(i==0){
                                opts.push({name:data[i].text,value:data[i].code,selected: true});
                            }else{
                                opts.push({name:data[i].text,value:data[i].code});
                            }
                        }
                        return opts;
                    }
                });
            }


            console.log('afterDataFill',data);
        }
    }
    //
    window.pageExt={form:form,list:list};
});