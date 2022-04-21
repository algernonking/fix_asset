/**
 * 存放位置 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 12:47:14
 */


function ListPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect;
    //模块基础路径
    const moduleURL="/service-ops/ops-statistics";
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
                defaultToolbar: ['filter', 'print','exports',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
                url: moduleURL +'/query-node-collect-data?nodeId='+NODE_ID,
                height: 'full-'+(h+28),
                limit: 10000,
                page:false,
                where: ps,
                cols: [[
                    { fixed: 'left',type: 'numbers' },
                    // { fixed: 'left',type:'checkbox' },
                    { field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('ID') , templet: function (d) { return templet('id',d.id,d);}  }
                    ,{ field: 'nodeIp', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机IP') , templet: function (d) { return templet('nodeIp',d.nodeIp,d);}  }
                    ,{ field: 'nodeNameShow', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机名称') , templet: function (d) { return templet('nodeNameShow',d.nodeNameShow,d);}  }
                    ,{ field: 'monitorTplCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('监控模板') , templet: function (d) { return templet('monitorTplCode',d.monitorTplCode,d);}  }
                    ,{ field: 'indicatorName', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('指标名称') , templet: function (d) { return templet('indicatorName',d.indicatorName,d);}  }
                    ,{ field: 'indicatorCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('指标编码') , templet: function (d) { return templet('indicatorCode',d.indicatorCode,d);}  }
                    ,{ field: 'valueColumnName', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('结果描述') , templet: function (d) { return templet('valueColumnName',d.valueColumnName,d);}  }
                    ,{ field: 'value', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('结果数据') , templet: function (d) { return templet('value',d.value,d);}  }
                   // ,{ field: 'recordTime', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('最新记录') , templet: function (d) { return templet('recordTime',d.recordTime,d);}  }
                   // ,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}

                    // ,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
                ]],
                parseData:function(res){
                    return {
                        "code": res.code == "00" ? 0 : -1, //解析接口状态
                        "msg": res.message, //解析提示文本
                        "count": res.data.nodeCollectDataList.length, //解析数据长度
                        "data": res.data.nodeCollectDataList //解析数据列表
                    };
                },
                done: function (data) {
                    window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
                footer : {

                }
            };
            window.pageExt.list.beforeTableRender && window.pageExt.list.beforeTableRender(tableConfig);
            dataTable=fox.renderTable(tableConfig);
            //绑定排序事件
            table.on('sort(data-table)', function(obj){
                refreshTableData(obj.field,obj.type);
            });
            window.pageExt.list.afterTableRender && window.pageExt.list.afterTableRender();
        }
        setTimeout(renderTableInternal,1);
    };

    /**
     * 刷新表格数据
     */
    function refreshTableData(sortField,sortType,reset) {
        var value = {};
        value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:""};
        value.notes={ inputType:"button",value: $("#notes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:""};
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

    function initSearchFields() {
        fox.switchSearchRow(1);
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
            fox.switchSearchRow(1,function (ex){
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
                case 'refresh-data':
                    refreshTableData();
                    break;
                case 'other':
                    break;
            };
        });


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

            admin.putTempData('eam-position-form-data-form-action', "",true);
            if (layEvent === 'view') { // 查看
                //延迟显示加载动画，避免界面闪动
                var task=setTimeout(function(){layer.load(2);},1000);
                admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
                    clearTimeout(task);
                    layer.closeAll('loading');
                    if(data.success) {
                        admin.putTempData('eam-report-form-data-form-action', "view",true);
                        showEditForm(data.data);
                    } else {
                        layer.msg(data.message, {icon: 1, time: 1500});
                    }
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
        var action=admin.getTempData('eam-report-form-data-form-action');
        var queryString="";
        if(data && data.id) queryString="?" + 'id=' + data.id;
        admin.putTempData('eam-report-form-data', data);
        var area=admin.getTempData('eam-report-form-area');
        var height= (area && area.height) ? area.height : ($(window).height()*0.6);
        var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
        var title = fox.translate('存放位置');
        if(action=="create") title=fox.translate('添加')+title;
        else if(action=="edit") title=fox.translate('修改')+title;
        else if(action=="view") title=fox.translate('查看')+title;

        var index=admin.popupCenter({
            title: title,
            resize: false,
            offset: [top,null],
            area: ["500px",height+"px"],
            type: 2,
            id:"eam-report-form-data-win",
            content: '/business/eam/position/position_form.html' + queryString,
            finish: function () {
                refreshTableData();
            }
        });
        admin.putTempData('eam-report-form-data-popup-index', index);
    };

    window.module={
        refreshTableData: refreshTableData,
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