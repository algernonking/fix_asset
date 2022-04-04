/**
 * 车辆信息 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 17:59:09
 */


function ListPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect;
    //模块基础路径
    const moduleURL="/service-vehicle/vehicle-info";
    var dataTable=null;
    var sort=null;
    var TABLE_IDS=["-1"];
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {

        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;

        if(window.pageExt.list.beforeInit) {
            window.pageExt.list.beforeInit();
        }
        //渲染表格
        renderTable();
        //初始化搜索输入框组件
        initSearchFields();
        //绑定搜索框事件
        bindSearchEvent();
        //绑定按钮事件
        bindButtonEvent();
        //绑定行操作按钮事件
        bindRowOperationEvent();
    }



    /**
     * 渲染表格
     */
    function renderTable() {
        $(window).resize(function() {
            fox.adjustSearchElement();
        });
        fox.adjustSearchElement();
        //
        function renderTableInternal() {
            var ps={searchField: "$composite"};
            var contitions={};
            // if(window.pageExt.list.beforeQuery){
            //     window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
            // }
            if(IDS.length>0){
                contitions.id={inputType:"select_box",value:IDS,lable:""};
                TABLE_IDS=IDS;
            }else{
                contitions.id={inputType:"select_box",value:TABLE_IDS,lable:""};
                TABLE_IDS=IDS;
            }
            ps.searchValue=JSON.stringify(contitions);
            var templet=window.pageExt.list.templet;
            if(templet==null) {
                templet=function(field,value,row) {
                    if(value==null) return "";
                    return value;
                }
            }



            var h=$(".search-bar").height();
            var tableConfig={
                elem: '#data-table',
                toolbar: '#toolbarTemplate',
                defaultToolbar: [],
                url: moduleURL +'/query-paged-list',
                height: 'full-'+(h+28),
                limit: 50,
                where: ps,
                cols: [[
                    { fixed: 'left',type: 'numbers' },
                    { fixed: 'left',type:'checkbox'}
                    ,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
                    ,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('名称') , templet: function (d) { return templet('name',d.name,d);}  }
                    ,{ field: 'vehicleStatus', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('车辆状态'), templet: function (d) { return templet('vehicleStatus' ,fox.joinLabel(d.vehicleStatusDict,"label"),d);}}
                    ,{ field: 'type', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('车辆类型'), templet: function (d) { return templet('type' ,fox.joinLabel(d.vehicleTypeDict,"label"),d);}}
                    ,{ field: 'code', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('车牌号') , templet: function (d) { return templet('code',d.code,d);}  }
                    ,{ field: 'model', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('品牌型号') , templet: function (d) { return templet('model',d.model,d);}  }
                    ,{ field: 'registrant', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('登记人') , templet: function (d) { return templet('registrant',d.registrant,d);}  }
                    ,{ field: 'ownerOrgId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('所属组织') , templet: function (d) { return templet('ownerOrgId',fox.getProperty(d,["ownerCompany","fullName"]),d);} }
                    ,{ field: 'useOrgId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('使用部门') , templet: function (d) { return templet('useOrgId',fox.getProperty(d,["useOrganization","fullName"]),d);} }
                    ,{ field: 'useUserId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('使用人') , templet: function (d) { return templet('useUserId',fox.getProperty(d,["useUser","name"]),d);} }
                     ,{ field: 'drivingLicense', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('行驶证') , templet: function (d) { return templet('drivingLicense',d.drivingLicense,d);}  }
                    ,{ field: 'kilometers', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('公里数') , templet: function (d) { return templet('kilometers',d.kilometers,d);}  }
                     ,{ field: 'insuranceExpireDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('保险到期') ,templet: function (d) { return templet('insuranceExpireDate',fox.dateFormat(d.insuranceExpireDate,"yyyy-MM-dd"),d); }  }
                     ,{ field: 'positionDetail', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('存放位置') , templet: function (d) { return templet('positionDetail',d.positionDetail,d);}  }
                    ,{ field: 'notes', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('备注') , templet: function (d) { return templet('notes',d.notes,d);}  }
                    ,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
                    ,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
                ]],
                done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
                footer : {
                }
            };
            window.pageExt.list.beforeTableRender && window.pageExt.list.beforeTableRender(tableConfig);
            dataTable=fox.renderTable(tableConfig);
            //绑定排序事件
            table.on('sort(data-table)', function(obj){
                refreshTableData(obj.sortField,obj.type);
            });
            window.pageExt.list.afterTableRender && window.pageExt.list.afterTableRender();
        }
        setTimeout(renderTableInternal,1);
    };

    /**
     * 刷新单号数据
     * */
    function refreshRowData(data,remote) {
        var context=dataTable.getDataRowContext( { id : data.id } );
        if(context==null) return;
        if(remote) {
            admin.post(moduleURL+"/get-by-id", { id : data.id }, function (r) {
                if (r.success) {
                    data = r.data;
                    context.update(data);
                } else {
                    fox.showMessage(data);
                }
            });
        } else {
            context.update(data);
        }
    }

    /**
     * 刷新表格数据
     */
    function refreshTableData(sortField,sortType,reset) {
        function getSelectedValue(id,prop) { var xm=xmSelect.get(id,true); return xm==null ? null : xm.getValue(prop);}
        var value = {};
        // value.id={ inputType:"button",value: $("#id").val()};
         var ps={searchField:"$composite"};
        if(window.pageExt.list.beforeQuery){
            if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
        }
        ps.searchValue=JSON.stringify(value);
        if(sortField) {
            ps.sortField=sortField;
            ps.sortType=sortType;
            sort={ field : sortField,type : sortType} ;
        } else {
            if(sort) {
                ps.sortField=sort.field;
                ps.sortType=sort.type;
            }
        }
        if(reset) {
            table.reload('data-table', { where : ps , page:{ curr:1 } });
        } else {
            table.reload('data-table', { where : ps });
        }
    }



    /**
     * 获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
     */
    function getCheckedList(field) {
        var checkStatus = table.checkStatus('data-table');
        var data = checkStatus.data;
        if(!field) return data;
        for(var i=0;i<data.length;i++) data[i]=data[i][field];
        return data;
    }

    /**
     * 重置搜索框
     */
    function resetSearchFields() {
        $('#search-field').val("");
        $('#search-input').val("");
        layui.form.render();
    }

    function initSearchFields() {

        fox.renderSearchInputs();
        window.pageExt.list.afterSearchInputReady && window.pageExt.list.afterSearchInputReady();
    }

    /**
     * 绑定搜索框事件
     */
    function bindSearchEvent() {
        //回车键查询
        $(".search-input").keydown(function(event) {
            if(event.keyCode !=13) return;
            refreshTableData(null,null,true);
        });

        // 搜索按钮点击事件
        $('#search-button').click(function () {
            refreshTableData(null,null,true);
        });

        // 搜索按钮点击事件
        $('#search-button-advance').click(function () {
            fox.switchSearchRow(2,function (ex){
                if(ex=="1") {
                    $('#search-button-advance span').text("关闭");
                } else {
                    $('#search-button-advance span').text("更多");
                }
            });
        });

    }

    /**
     * 绑定按钮事件
     */
    function bindButtonEvent() {

        //头工具栏事件
        table.on('toolbar(data-table)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            var selected=getCheckedList("id");
            if(window.pageExt.list.beforeToolBarButtonEvent) {
                var doNext=window.pageExt.list.beforeToolBarButtonEvent(selected,obj);
                if(!doNext) return;
            }
            switch(obj.event){
                case 'create':
                    openCreateFrom();
                    break;
                case 'batch-del':
                    batchDelete(selected);
                    break;
                case 'refresh-data':
                    refreshTableData();
                    break;
                case 'other':
                    break;
            };
        });


        //添加按钮点击事件
        function openCreateFrom() {
            //设置新增是初始化数据
            var data={};
            admin.putTempData('vehicle-info-form-data-form-action', "create",true);
            showEditForm(data);
        };

        //批量删除按钮点击事件
        function batchDelete(selected) {

            if(window.pageExt.list.beforeBatchDelete) {
                var doNext=window.pageExt.list.beforeBatchDelete(selected);
                if(!doNext) return;
            }

            var ids=getCheckedList("id");
            if(ids.length==0) {
                top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('车辆信息')+"!");
                return;
            }
            //调用批量删除接口
            top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('车辆信息')+fox.translate('吗？'), function (i) {
                admin.post(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
                    if (data.success) {
                        if(window.pageExt.list.afterBatchDelete) {
                            var doNext=window.pageExt.list.afterBatchDelete(data);
                            if(!doNext) return;
                        }
                        fox.showMessage(data);
                        refreshTableData();
                    } else {
                        fox.showMessage(data);
                    }
                });
            });
        }
    }

    /**
     * 绑定行操作按钮事件
     */
    function bindRowOperationEvent() {
        // 工具条点击事件
        table.on('tool(data-table)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;

            if(window.pageExt.list.beforeRowOperationEvent) {
                var doNext=window.pageExt.list.beforeRowOperationEvent(data,obj);
                if(!doNext) return;
            }

            admin.putTempData('vehicle-info-form-data-form-action', "",true);
             if (layEvent === 'del') { // 删除
                if(window.pageExt.list.beforeSingleDelete) {
                    var doNext=window.pageExt.list.beforeSingleDelete(data);
                    if(!doNext) return;
                }
                top.layer.confirm(fox.translate('确定删除此')+fox.translate('车辆信息')+fox.translate('吗？'), function (i) {
                    top.layer.close(i);
                    var dIds= [];
                    console.log("TABLE_IDS",TABLE_IDS);
                    for(var i=0;i<TABLE_IDS.length;i++){
                        if(TABLE_IDS[i]==data.id){
                            continue;
                        }else{
                            dIds.push(TABLE_IDS[i]);
                        }
                    }
                    reSearchData(dIds);
                });
            }
        });

    };

    function getCheckedData(){
        if(TABLE_IDS.length==1){
           if(TABLE_IDS[0]=="-1"){
               var p=[]
               return p;
           }else{
               return TABLE_IDS
           }
        }else{
            return TABLE_IDS
        }
    }

    function reSearchData(ids){
        console.log("reSearch",ids);
        var ps={searchField:"$composite"};
        if(ids==null||ids.length==0){
            ids=[];
            ids.push("-1");
        }
        var value={};
        TABLE_IDS=ids;
        value.id={inputType:"select_box",value:ids,lable:""};
        ps.searchValue=JSON.stringify(value);
        table.reload('data-table', { where : ps , page:{ curr:1 } });
    }
    /**
     * 打开编辑窗口
     */
    function showEditForm(data) {
        if(window.pageExt.list.beforeEdit) {
            var doNext=window.pageExt.list.beforeEdit(data);
            if(!doNext) return;
        }
        var action=admin.getTempData('vehicle-info-form-data-form-action');
        var queryString="";
        if(data && data.id) queryString='id=' + data.id;
        if(window.pageExt.list.makeFormQueryString) {
            queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
        }
        admin.putTempData('vehicle-info-list-data', data);
        var area=admin.getTempData('vehicle-info-form-area');
        var height= (area && area.height) ? area.height : ($(window).height()*0.6);

        var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
        var title = fox.translate('车辆信息');
        if(action=="create") title=fox.translate('添加')+title;
        else if(action=="edit") title=fox.translate('修改')+title;
        else if(action=="view") title=fox.translate('查看')+title;
        var tIds="";
        console.log("TABLE_IDS",TABLE_IDS);
        for(var i=0;i<TABLE_IDS.length;i++){
            if(i==0){
                tIds=TABLE_IDS[i];
            }else{
                tIds=tIds+","+ TABLE_IDS[i];
            }
        }
        var q="?type="+TYPE+"&ids="+tIds;
        console.log("ids",q);
        admin.popupCenter({
            title: title,
            resize: false,
            offset: [top,null],
            area: ["98%","95%"],
            type: 2,
            id:"vehicle-info-form-data-win",
            content: '/business/vehicle/info/select_info_list.html'+q ,
            finish: function () {
                var ids=admin.getTempData('vehicle-info-list-data');
                for(var i=0;i<TABLE_IDS.length;i++){
                    ids.push(TABLE_IDS[i]);
                }
                reSearchData(ids);
            }
        });
    };

    window.module={
        getCheckedData: getCheckedData,
        reSearchData:reSearchData,
        refreshTableData: refreshTableData,
        refreshRowData: refreshRowData,
        getCheckedList: getCheckedList
    };

    window.pageExt.list.ending && window.pageExt.list.ending();

};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {
    var task=setInterval(function (){
        if(!window["pageExt"]) return;
        clearInterval(task);
        (new ListPage()).init(layui);
    },1);
});