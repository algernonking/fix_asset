/**
 * 资产字段配置项 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-13 04:57:59
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
         * 列表页初始化前调用
         * */
        beforeInit:function () {
            console.log("list:beforeInit");
        },
        afterSearchInputReady: function() {
            console.log("list:afterSearchInputReady");
        },
        /**
         * 查询前调用
         * */
        beforeQuery:function (conditions,location) {
            console.log('beforeQuery',conditions);
            return true;
        },
        /**
         * 查询结果渲染后调用
         * */
        afterQuery : function (data) {

        },
        /**
         * 进一步转换 list 数据
         * */
        templet:function (field,value,r) {
            if(value==null) return "";
            return value;
        },
        /**
         * 在新建或编辑窗口打开前调用，若返回 false 则不继续执行后续操作
         * */
        beforeEdit:function (data) {
            console.log('beforeEdit',data);
            return true;
        },
        /**
         * 单行删除前调用，若返回false则不执行后续操作
         * */
        beforeSingleDelete:function (data) {
            console.log('beforeSingleDelete',data);
            return true;
        },
        afterSingleDelete:function (data){
            console.log('beforeSingleDelete',data);
            return true;
        },
        /**
         * 批量删除前调用，若返回false则不执行后续操作
         * */
        beforeBatchDelete:function (selected) {
            console.log('beforeBatchDelete',selected);
            return true;
        },
        /**
         * 批量删除后调用，若返回false则不执行后续操作
         * */
        afterBatchDelete:function (data) {
            console.log('afterBatchDelete',data);
            return true;
        },
        /**
         * 表格右侧操作列更多按钮事件
         * */
        moreAction:function (menu,data, it){
            console.log('moreAction',menu,data,it);
        },
        /**
         * 末尾执行
         */
        ending:function() {

        }
    }

    //表单页的扩展
    var form={
        /**
         * 表单初始化前调用
         * */
        beforeInit:function () {
            //获取参数，并调整下拉框查询用的URL
            //var companyId=admin.getTempData("companyId");
            //fox.setSelectBoxUrl("employeeId","/service-hrm/hrm-employee/query-paged-list?companyId="+companyId);
            console.log("form:beforeInit")
        },
        /**
         * 表单数据填充前
         * */
        beforeDataFill:function (data) {
            console.log('beforeDataFill',data);
            if(data&&data.id){
                setTimeout(function (){
                    var ownerCodeSelect= xmSelect.get('#ownerCode',true);
                    ownerCodeSelect.update({disabled:true})
                    var attributeIdSelect= xmSelect.get('#attributeId',true);
                    attributeIdSelect.update({disabled:true})
                },100);
            }else{

                setTimeout(function (){
                    //渲染 ownerCode 下拉字段
                    fox.renderSelectBox({
                        el: "ownerCode",
                        radio: true,
                        filterable: false,
                        //转换数据
                        on:function(data){
                            //change, 此次选择变化的数据,数组
                            var change = data.change;
                            //isAdd, 此次操作是新增还是删除
                            var isAdd = data.isAdd;
                            var attributeIdSelect= xmSelect.get('#attributeId',true);
                            if(isAdd){
                                var item=change[0];
                                var ps={owner:"asset",itemOwner:item.value};
                                $("#attributeId").attr("data","/service-eam/eam-asset-attribute/query-attribute-owner-list?owner=asset&itemOwner="+item.value);
                                admin.request("/service-eam/eam-asset-attribute/query-attribute-owner-list", ps, function (data) {
                                    if (data.success) {
                                        var attributeData=[];
                                        for(var i=0;i<data.data.length;i++){
                                            attributeData.push({name:data.data[i].label,value:data.data[i].code,link:true})
                                        }
                                        setTimeout(function (){
                                            attributeIdSelect.update({data:attributeData});
                                        },500);
                                    } else {
                                    }
                                }, "POST");
                            }else{
                                attributeIdSelect.update({data:[]});
                            }
                        },
                        //转换数据
                        transform:function(data) {
                            //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                            var defaultValues=[],defaultIndexs=[];
                             defaultValues="".split(",");
                             defaultIndexs="".split(",");
                            var opts=[];
                            if(!data) return opts;
                            for (var i = 0; i < data.length; i++) {
                                opts.push({name:data[i].text,value:data[i].code});
                            }
                            return opts;
                        }
                    });


                    //渲染 attributeId 下拉字段
                    fox.renderSelectBox({
                        el: "attributeId",
                        radio: true,
                        filterable: true,
                        //转换数据
                        searchField: "label", //请自行调整用于搜索的字段名称
                        extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数

                        transform: function(data) {
                            //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                            var defaultValues=[],defaultIndexs=[];

                            defaultValues="".split(",");
                            defaultIndexs="".split(",");

                            var opts=[];
                            if(!data) return opts;
                            for (var i = 0; i < data.length; i++) {
                                if(!data[i]) continue;
                                opts.push({name:data[i].label,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
                            }
                            return opts;
                        }
                    });


                },100);



            }
        },
        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            console.log('afterDataFill',data);
        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
            return true;
        },
        /**
         * 末尾执行
         */
        ending:function() {

        }
    }
    //
    window.pageExt={form:form,list:list};
});