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

    var action=admin.getTempData('kn-content-form-data-form-action');


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
            $('input[name=display]:first').prop("checked","true")
            $('input[name=contentType]:first').prop("checked","true")

            if(action=="create") {
                setTimeout(function (){
                    //渲染 categoryId 下拉字段
                    fox.renderSelectBox({
                        el: "categoryId",
                        radio: true,
                        filterable: true,
                        clickClose:true,
                        //转换数据
                        searchField: "hierarchyName", //请自行调整用于搜索的字段名称
                        extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
                        transform: function(data) {
                            //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                            var opts=[];
                            if(!data) return opts;
                            for (var i = 0; i < data.length; i++) {
                                if(!data[i]) continue;
                                if(i==0){
                                    opts.push({name:data[i].hierarchyName,value:data[i].id,selected:true});
                                }else{
                                    opts.push({name:data[i].hierarchyName,value:data[i].id});
                                }

                            }
                            return opts;
                        }
                    });

                    //渲染 gradeId 下拉字段
                    fox.renderSelectBox({
                        el: "gradeId",
                        radio: true,
                        clickClose:true,
                        filterable: false,
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
                },500);

            }

        }


    }
    //
    window.pageExt={form:form,list:list};
});