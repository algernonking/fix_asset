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
            console.log('afterDataFill',data);
            console.log(laydate);
            var action=admin.getTempData('eam-asset-repair-form-data-form-action')
            if(action=="create"){
                laydate.render({
                    elem: '#planFinishDate',
                    format:"yyyy-MM-dd HH:mm:ss",
                    trigger:"click",
                    value:new Date()
                });

                //渲染 repairStatus 下拉字段
                fox.renderSelectBox({
                    el: "repairStatus",
                    radio: true,
                    filterable: false,
                    //转换数据
                    transform:function(data) {
                        //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                        var opts=[];
                        if(!data) return opts;
                        for (var i = 0; i < data.length; i++) {
                            if(i==0&&action=="create"){
                                opts.push({name:data[i].text,value:data[i].code,selected: true});
                            }else{
                                opts.push({name:data[i].text,value:data[i].code});
                            }

                        }
                        return opts;
                    }
                });


            }



        }
    }
    //
    window.pageExt={form:form,list:list};
});