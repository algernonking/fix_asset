/**
 * 数据库实例 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-25 16:15:14
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

    }

    var action=admin.getTempData('ops-db-instance-form-data-form-action')

    //表单页的扩展
    var form={


        /**
         * 表单数据填充后
         * */
        afterDataFill:function (data) {
            console.log('afterDataFill',data);

            if(action=="create"){
                fox.renderSelectBox({
                    el: "databaseId",
                    radio: true,
                    clickClose:true,
                    filterable: false,
                    pageRemote:false,
                    //转换数据
                    searchField: "name", //请自行调整用于搜索的字段名称
                    extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
                    transform: function(data) {
                        //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                        var opts=[];
                        if(!data) return opts;
                        for (var i = 0; i < data.length; i++) {
                            if(!data[i]) continue;
                            opts.push({name:data[i].name,value:data[i].id});
                        }
                        return opts;
                    }
                });
                //渲染 hostId 下拉字段
                setTimeout(function (){
                    fox.renderSelectBox({
                        el: "hostId",
                        radio: true,
                        clickClose:true,
                        filterable: true,
                        paging: true,
                        pageRemote: true,
                        //转换数据
                        on:function(data){
                            console.log(data);
                           // var arr = data.arr;
                            //change, 此次选择变化的数据,数组
                            var change = data.change;
                            //isAdd, 此次操作是新增还是删除
                            var isAdd = data.isAdd;
                            if(isAdd&&change.length>0){
                                var databaseSelect= xmSelect.get('#databaseId',true);
                                var item=change[0];
                                var dbList=item.hostDbList;
                                var dbdata=[];
                                if(item.hostDbList){
                                    for(var i=0;i<dbList.length;i++){
                                        if(i==0){
                                            dbdata.push({name:dbList[i].name,value:dbList[i].id,selected:true});
                                        }else{
                                            dbdata.push({name:dbList[i].name,value:dbList[i].id});
                                        }
                                    }
                                    databaseSelect.update({data:dbdata});
                                }

                            }
                        },
                        searchField: "hostName", //请自行调整用于搜索的字段名称
                        extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
                        transform: function(data) {
                            var opts=[];
                            if(!data) return opts;
                            for (var i = 0; i < data.length; i++) {
                                if(!data[i]) continue;
                                opts.push({name:data[i].hostName+"(IP:"+data[i].hostIp+"-数量:"+data[i].hostDbList.length+")",value:data[i].id,hostDbList:data[i].hostDbList});
                            }
                            return opts;
                        }
                    });

                },500);
            }else{
                //enableHoverFirst
                var databaseSelect= xmSelect.get('#databaseId',true);
                databaseSelect.update({disabled:true})
                var hostSelect= xmSelect.get('#hostId',true);
                hostSelect.update({disabled:true})
            }



        },
        /**
         * 数据提交前，如果返回 false，停止后续步骤的执行
         * */
        beforeSubmit:function (data) {
            console.log("beforeSubmit",data);
            return true;
        },

        other:function(){

        }
    }
    //
    window.pageExt={form:form,list:list};
});