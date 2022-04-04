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

            if(window.pageExt.list.beforeQuery){
                window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
            }
            ps.searchValue=JSON.stringify(contitions);
            ps.businessType=TYPE;
            if(IDS!=null&&IDS.length>0){
                var str=""
                for(var i=0;i<IDS.length;i++){
                    if(i==0){
                        str=IDS[i];
                    }else{
                        str=str+","+IDS[i];
                    }
                }
                ps.selectIds=str;
            }
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
                defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
                url: moduleURL +'/query-paged-select-list',
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
                    ,{ field: 'engineNumber', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('发动机号') , templet: function (d) { return templet('engineNumber',d.engineNumber,d);}  }
                    ,{ field: 'frameNumber', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('车架号') , templet: function (d) { return templet('frameNumber',d.frameNumber,d);}  }
                    ,{ field: 'drivingLicense', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('行驶证') , templet: function (d) { return templet('drivingLicense',d.drivingLicense,d);}  }
                    ,{ field: 'kilometers', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('公里数') , templet: function (d) { return templet('kilometers',d.kilometers,d);}  }
                    ,{ field: 'insuranceCompany', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('保险公司') , templet: function (d) { return templet('insuranceCompany',d.insuranceCompany,d);}  }
                    ,{ field: 'licensingTime', align:"right", fixed:false, hide:true, sort: true   ,title: fox.translate('上牌时间') ,templet: function (d) { return templet('licensingTime',fox.dateFormat(d.licensingTime,"yyyy-MM-dd"),d); }  }
                    ,{ field: 'insuranceExpireDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('保险到期') ,templet: function (d) { return templet('insuranceExpireDate',fox.dateFormat(d.insuranceExpireDate,"yyyy-MM-dd"),d); }  }
                    ,{ field: 'scrapTime', align:"right", fixed:false, hide:true, sort: true   ,title: fox.translate('报废时间') ,templet: function (d) { return templet('scrapTime',fox.dateFormat(d.scrapTime,"yyyy-MM-dd"),d); }  }
                    ,{ field: 'positionDetail', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('存放位置') , templet: function (d) { return templet('positionDetail',d.positionDetail,d);}  }
                    ,{ field: 'notes', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('备注') , templet: function (d) { return templet('notes',d.notes,d);}  }
                    ,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
                    ,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
                ]],
                done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
                footer : {
                    exportExcel : admin.checkAuth(AUTH_PREFIX+":export"),
                    importExcel : admin.checkAuth(AUTH_PREFIX+":import")?{
                        params : {} ,
                        callback : function(r) {
                            if(r.success) {
                                layer.msg(fox.translate('数据导入成功')+"!");
                            } else {
                                layer.msg(fox.translate('数据导入失败')+"!");
                            }
                            // 是否执行后续逻辑：错误提示
                            return false;
                        }
                    }:false
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
        value.id={ inputType:"button",value: $("#id").val()};
        value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.vehicleStatus={ inputType:"select_box", value: getSelectedValue("#vehicleStatus","value") ,fillBy:["vehicleStatusDict"]  , label:getSelectedValue("#vehicleStatus","nameStr") };
        value.type={ inputType:"select_box", value: getSelectedValue("#type","value") ,fillBy:["vehicleTypeDict"]  , label:getSelectedValue("#type","nameStr") };
        value.code={ inputType:"button",value: $("#code").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.model={ inputType:"button",value: $("#model").val()};
        value.registrant={ inputType:"button",value: $("#registrant").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.ownerOrgId={ inputType:"button",value: $("#ownerOrgId").val(),fillBy:["ownerCompany","fullName"] ,label:$("#ownerOrgId-button").text() };
        value.useOrgId={ inputType:"button",value: $("#useOrgId").val(),fillBy:["useOrganization","fullName"] ,label:$("#useOrgId-button").text() };
        value.useUserId={ inputType:"button",value: $("#useUserId").val(),fillBy:["useUser","name"] ,label:$("#useUserId-button").text() };
        value.color={ inputType:"button",value: $("#color").val()};
        value.engineNumber={ inputType:"button",value: $("#engineNumber").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.frameNumber={ inputType:"button",value: $("#frameNumber").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.drivingLicense={ inputType:"button",value: $("#drivingLicense").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.kilometers={ inputType:"number_input", value: $("#kilometers").val() };
        value.rescueMoney={ inputType:"number_input", value: $("#rescueMoney").val() };
        value.commercialInsuranceMoney={ inputType:"number_input", value: $("#commercialInsuranceMoney").val() };
        value.insuranceCompany={ inputType:"button",value: $("#insuranceCompany").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.licensingTime={ inputType:"date_input", begin: $("#licensingTime-begin").val(), end: $("#licensingTime-end").val() ,matchType:"auto" };
        value.insuranceExpireDate={ inputType:"date_input", begin: $("#insuranceExpireDate-begin").val(), end: $("#insuranceExpireDate-end").val() ,matchType:"auto" };
        value.scrapTime={ inputType:"date_input", begin: $("#scrapTime-begin").val(), end: $("#scrapTime-end").val() ,matchType:"auto" };
        value.positionDetail={ inputType:"button",value: $("#positionDetail").val()};
        value.pictures={ inputType:"button",value: $("#pictures").val()};
        value.originatorId={ inputType:"button",value: $("#originatorId").val()};
        value.notes={ inputType:"button",value: $("#notes").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
        value.createTime={ inputType:"date_input", value: $("#createTime").val() ,matchType:"auto"};
        var ps={searchField:"$composite"};
        if(window.pageExt.list.beforeQuery){
            if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
        }
        ps.selectIds=[];
        ps.searchValue=JSON.stringify(value);
        ps.businessType=TYPE;

        if(IDS!=null&&IDS.length>0){
            var str=""
            for(var i=0;i<IDS.length;i++){
                if(i==0){
                    str=IDS[i];
                }else{
                    str=str+","+IDS[i];
                }
            }
            ps.selectIds=str;
        }


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

        fox.switchSearchRow(2);

        //渲染 vehicleStatus 下拉字段
        fox.renderSelectBox({
            el: "vehicleStatus",
            radio: true,
            size: "small",
            filterable: false,
            on: function(data){
                setTimeout(function () {
                    window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("vehicleStatus",data.arr,data.change,data.isAdd);
                },1);
            },
            //转换数据
            transform: function(data) {
                //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                var opts=[];
                if(!data) return opts;
                for (var i = 0; i < data.length; i++) {
                    if(!data[i]) continue;
                    opts.push({data:data[i],name:data[i].label,value:data[i].code});
                }
                return opts;
            }
        });
        //渲染 type 下拉字段
        fox.renderSelectBox({
            el: "type",
            radio: true,
            size: "small",
            filterable: false,
            on: function(data){
                setTimeout(function () {
                    window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("type",data.arr,data.change,data.isAdd);
                },1);
            },
            //转换数据
            transform: function(data) {
                //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                var opts=[];
                if(!data) return opts;
                for (var i = 0; i < data.length; i++) {
                    if(!data[i]) continue;
                    opts.push({data:data[i],name:data[i].label,value:data[i].code});
                }
                return opts;
            }
        });
        laydate.render({
            elem: '#insuranceExpireDate-begin',
            trigger:"click",
            done: function(value, date, endDate) {
                setTimeout(function () {
                    window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("insuranceExpireDate",value, date, endDate);
                },1);
            }
        });
        laydate.render({
            elem: '#insuranceExpireDate-end',
            trigger:"click",
            done: function(value, date, endDate) {
                setTimeout(function () {
                    window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("insuranceExpireDate",value, date, endDate);
                },1);
            }
        });
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



        //批量删除按钮点击事件
        function batchDelete(selected) {
            if(window.pageExt.list.beforeBatchDelete) {
                var doNext=window.pageExt.list.beforeBatchDelete(selected);
                if(!doNext) return;
            }
            var ids=getCheckedList("id");
            if(ids.length==0) {
                top.layer.msg(fox.translate('请选择需要的')+fox.translate('车辆信息')+"!");
                return;
            }
            //调用批量删除接口
            top.layer.confirm(fox.translate('确定已选中的')+fox.translate('车辆信息')+fox.translate('吗？'), function (i) {
                console.log(ids);
                top.layer.close(i);
                admin.putTempData('vehicle-info-list-data',ids);
                admin.finishPopupCenterById('vehicle-info-form-data-win');
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
            if (layEvent === 'edit') { // 修改
                admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
                    if(data.success) {
                        admin.putTempData('vehicle-info-form-data-form-action', "edit",true);
                        showEditForm(data.data);
                    } else {
                        fox.showMessage(data);
                    }
                });
            } else if (layEvent === 'view') { // 查看
                admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
                    if(data.success) {
                        admin.putTempData('vehicle-info-form-data-form-action', "view",true);
                        showEditForm(data.data);
                    } else {
                        fox.showMessage(data);
                    }
                });
            }
            else if (layEvent === 'del') { // 删除

                if(window.pageExt.list.beforeSingleDelete) {
                    var doNext=window.pageExt.list.beforeSingleDelete(data);
                    if(!doNext) return;
                }
                top.layer.confirm(fox.translate('确定删除此')+fox.translate('车辆信息')+fox.translate('吗？'), function (i) {
                    top.layer.close(i);

                    top.layer.load(2);
                    admin.request(moduleURL+"/delete", { id : data.id }, function (data) {
                        top.layer.closeAll('loading');
                        if (data.success) {
                            if(window.pageExt.list.afterSingleDelete) {
                                var doNext=window.pageExt.list.afterSingleDelete(data);
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

        });

    };

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
        admin.putTempData('vehicle-info-form-data', data);
        var area=admin.getTempData('vehicle-info-form-area');
        var height= (area && area.height) ? area.height : ($(window).height()*0.6);
        var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
        var title = fox.translate('车辆信息');
        if(action=="create") title=fox.translate('添加')+title;
        else if(action=="edit") title=fox.translate('修改')+title;
        else if(action=="view") title=fox.translate('查看')+title;

        admin.popupCenter({
            title: title,
            resize: false,
            offset: [top,null],
            area: ["98%",height+"px"],
            type: 2,
            id:"vehicle-info-form-data-win",
            content: '/business/vehicle/info/info_form.html' + (queryString?("?"+queryString):""),
            finish: function () {
                if(action=="create") {
                    refreshTableData();
                }
                if(action=="edit") {
                    false?refreshTableData():refreshRowData(data,true);
                }
            }
        });
    };

    window.module={
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