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
            $("#assetCode").attr("readonly","readonly");
            $("#assetCode").attr('placeholder','系统自动生成');
        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            console.log('afterDataFill',data);
            var action=admin.getTempData('eam-asset-form-data-form-action')
            var as=admin.getTempData('eam-asset-form-data');
            console.log(admin);
            console.log(as);
            var categoryselectdisabled=true;
            if(action=="create"){
                categoryselectdisabled=false;
            }

            //分类
            fox.renderSelectBox({
                el: "categoryId",
                radio: true,
                disabled:categoryselectdisabled,
                filterable: true,
                paging: true,
                pageRemote: true,
                //转换数据
                searchField: "hierarchyName", //请自行调整用于搜索的字段名称
                on:function(data){
                    if(data.change.length>0){
                        $("#serviceLife").val(data.change[0].serviceLife);
                    }
                }
                ,transform: function(data) {
                    var opts=[];
                    if(!data) return opts;
                    for (var i = 0; i < data.length; i++) {
                        if(!data[i]) continue;
                        if(i==0&&action=="create"){
                            opts.push({name:data[i].hierarchyName,value:data[i].id,serviceLife:data[i].serviceLife, selected: true});
                        }else{
                            opts.push({name:data[i].hierarchyName,value:data[i].id,serviceLife:data[i].serviceLife});
                        }
                    }
                    return opts;
                }
            })

            //渲染 sourceId 下拉字段
            fox.renderSelectBox({
                el: "sourceId",
                radio: true,
                filterable: false,
                transform: function(data) {
                    var opts=[];
                    for (var i = 0; i < data.length; i++) {
                        if(!data[i]) continue;
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





    //
    window.pageExt={form:form,list:list};
});