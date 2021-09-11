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
        knFunction:function (selected,obj){
            window.open("../search/search.html");
            console.log('knFunction',selected,obj);
        },

        reviewKnFunction:function (data){
            window.open("../search/knbaselook.html?id="+data.id);
            console.log('reviewKnFunction',data);
        }

    }

    var action=admin.getTempData('kn-content-form-data-form-action');
    function loadJs(url,callback){
        var script=document.createElement('script');
        script.type="text/javascript";
        if(typeof(callback)!="undefined"){
            if(script.readyState){
                script.onreadystatechange=function(){
                    if(script.readyState == "loaded" || script.readyState == "complete"){
                        script.onreadystatechange=null;
                        callback();
                    }
                }
            }else{
                script.onload=function(){
                    callback();
                }
            }
        }
        script.src=url;
        document.body.appendChild(script);
    }

    var editor;
    //表单页的扩展
    var form={

        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            console.log('afterDataFill',data,action);
            console.log("####",action);
            // if(action=="create") {
            //     setTimeout(function (){
            //         $('input[name=display]:first').prop("checked","true");
            //         $('input[name=contentType]:first').prop("checked","true");
            //         //设置第一个
            //         //渲染 categoryId 下拉字段
            //         fox.renderSelectBox({
            //             el: "categoryId",
            //             radio: true,
            //             filterable: true,
            //             clickClose:true,
            //             //转换数据
            //             searchField: "hierarchyName", //请自行调整用于搜索的字段名称
            //             extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
            //             transform: function(data) {
            //                 //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
            //                 var opts=[];
            //                 if(!data) return opts;
            //                 for (var i = 0; i < data.length; i++) {
            //                     if(!data[i]) continue;
            //                     if(i==0){
            //                         opts.push({name:data[i].hierarchyName,value:data[i].id,selected:true});
            //                     }else{
            //                         opts.push({name:data[i].hierarchyName,value:data[i].id});
            //                     }
            //                 }
            //                 return opts;
            //             }
            //         });
            //
            //         //渲染 gradeId 下拉字段
            //         fox.renderSelectBox({
            //             el: "gradeId",
            //             radio: true,
            //             clickClose:true,
            //             filterable: false,
            //             //转换数据
            //             transform: function(data) {
            //                 //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
            //                 var opts=[];
            //                 for (var i = 0; i < data.length; i++) {
            //                     if(!data[i]) continue;
            //                     if(i==0){
            //                         opts.push({name:data[i].text,value:data[i].code,selected:true});
            //
            //                     }else{
            //                         opts.push({name:data[i].text,value:data[i].code});
            //                     }
            //                 }
            //                 return opts;
            //             }
            //         });
            //     },500);
            // }

            //处理编辑区域
            $('#content').parent().html("<div id=\"content_editor\"></div>");
            //https://cdn.jsdelivr.net/npm/wangeditor@latest/dist/wangEditor.min.js
            //  var url="/assets/js/wangEditor.min.js";
            var url="wangEditor.min.js";
            console.log("111################");
            loadJs(url,function(){
                const E = window.wangEditor
                editor  = new E("#content_editor");
                editor.create()
                editor.txt.html(data.content);
                if(action=="view"){
                    editor.disable();
                }
            });

        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {





        },

        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            if(action=="create") {
                data.editor_id=EMPLOYEE_ID;
            }
            console.log("beforeSubmit",data);
            data.content=editor.txt.html();
            return true;
        }


    }
    //
    window.pageExt={form:form,list:list};
});