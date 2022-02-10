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
                url: moduleURL +'/query-node-host-resource-list',
                height: 'full-'+(h+28),
                limit: 50,
                page:false,
                where: ps,
                cols: [[
                    { fixed: 'left',type: 'numbers' },
                    { fixed: 'left',type:'checkbox' },
                    { field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('ID') , templet: function (d) { return templet('id',d.id,d);}  }
                    ,{ field: 'nodeIp', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机IP') , templet: function (d) { return templet('nodeIp',d.nodeIp,d);}  }
                    ,{ field: 'nodeNameShow', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机名称') , templet: function (d) { return templet('nodeNameShow',d.nodeNameShow,d);}  }
                    ,{ field: 'dataOsConnected', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机状态') , templet: function (d) { return templet('dataOsConnected',d.dataOsConnected,d);}  }
                    ,{ field: 'dataOsCpuNumber', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('CPU数量') , templet: function (d) { return templet('dataOsCpuNumber',d.dataOsCpuNumber,d);}  }
                    ,{ field: 'dataOsLoad', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('负载') , templet: function (d) { return templet('dataOsLoad',d.dataOsLoad,d);}  }
                    ,{ field: 'dataPMemorySize', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('物理内存大小(M)') , templet: function (d) { return templet('dataPMemorySize',d.dataPMemorySize,d);}  }
                    ,{ field: 'dataPMemoryUsed', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('物理内存使用率(%)') , templet: function (d) { return templet('dataPMemoryUsed',d.dataPMemoryUsed,d);}  }
                    ,{ field: 'dataOsNetInterfaceFlowUp', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('上行流量(KB/s)') , templet: function (d) { return templet('dataOsNetInterfaceFlowUp',d.dataOsNetInterfaceFlowUp,d);}  }
                    ,{ field: 'dataOsNetInterfaceFlowDown', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('下行流量(KB/s)') , templet: function (d) { return templet('dataOsNetInterfaceFlowDown',d.dataOsNetInterfaceFlowDown,d);}  }
                    ,{ field: 'dataProcessCnt', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('连接数') , templet: function (d) { return templet('dataProcessCnt',d.dataProcessCnt,d);}  }
                    ,{ field: 'dataHostname', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机名') , templet: function (d) { return templet('dataHostname',d.dataHostname,d);}  }
                    ,{ field: 'dataMaxRecordTime', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('更新时间') , templet: function (d) { return templet('dataMaxRecordTime',d.dataMaxRecordTime,d);}  }
                    ,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
                    ,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
                ]],
                parseData:function(res){
                    console.log("parese res:",res);
                    return {
                        "code": res.code == "00" ? 0 : -1, //解析接口状态
                        "msg": res.message, //解析提示文本
                        "count": res.data.nodeHostList.length, //解析数据长度
                        "data": res.data.nodeHostList //解析数据列表
                    };
                },
                done: function (data) {
                    console.log("done data",data)
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
            console.log("nodeData:",data);
            if(window.pageExt.list.beforeRowOperationEvent) {
                var doNext=window.pageExt.list.beforeRowOperationEvent(data,obj);
                if(!doNext) return;
            }
            if (layEvent === 'view') { // 查看
                //延迟显示加载动画，避免界面闪动
                var d={}
                d.nodeId=data.id;
                console.log(d);
                showEditForm(d);
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

        admin.putTempData('eam-report-form-data', data);
        var area=admin.getTempData('eam-report-form-area');
        var height= (area && area.height) ? area.height : ($(window).height()*0.6);
        var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
        var title = fox.translate('最新数据');

        top=8;
        var index=admin.popupCenter({
            title: title,
            resize: false,
            offset: [top,null],
            area: ["95%","95%"],
            type: 2,
            id:"eam-report-form-data-win",
            content: '/business/ops/monitor_node_resource/monitor_node_collect_data.html?nodeId=' + data.nodeId,
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