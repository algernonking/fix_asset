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

    var formatDateTime = function (date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? ('0' + m) : m;
        var d = date.getDate();
        d = d < 10 ? ('0' + d) : d;
        var h = date.getHours();
        h=h < 10 ? ('0' + h) : h;
        var minute = date.getMinutes();
        minute = minute < 10 ? ('0' + minute) : minute;
        var second=date.getSeconds();
        second=second < 10 ? ('0' + second) : second;
        return y + '-' + m + '-' + d+' '+h+':'+minute;
    };
    var lineOption= {
        legend: {
            orient: 'horizontal',
            show:true,
            type:'plain',
            bottom:0,
            data:[],
        },
        grid: {
            x:80,
            backgroundColor: 'rgba(0,0,0,0)',
            borderWidth: 1,
            borderColor: '#ccc'
        },

        title:{
            x: 'center',
            show:true,
            text:"",
            textStyle:{
                fontSize: 15,
            }
        },
        tooltip: {
            trigger: 'axis',
            position:pt=>{
                return [pt[0],'10%']
            }
        },
        xAxis: {
            type: 'time',
            // splitNumber: 13,
            axisLabel: {
                formatter: function(value, index) {
                    return formatDateTime(new Date(value));
                }
            },
            boundaryGap: false
        },
        yAxis: {
            type: 'value',
            splitLine:{ show:true}
        },
        series: []
    };
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {
        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;
        echarts=layui.echarts;

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

        searchData();
    }

    function searchData(){
        var ps={};
        ps.nodeId=NODE_ID;
        ps.sdate="";
        ps.edate="";
        ps.day=5;
        var stime=$("#sTime-begin").val();
        var etime=$("#sTime-end").val();
        if(stime!=""&&stime.length==10){
            ps.sdate=stime+" 00:00";
        }
        if(etime!=""&&etime.length==10){
            ps.edate=etime+" 00:00";
        }
        var task=setTimeout(function(){layer.load(2);},1000);
        admin.post("/service-ops/ops-statistics/query-node-collect-data-graph", ps, function (data) {
           clearTimeout(task);
           layer.closeAll('loading');
            if (data.success) {
                var tplData=data.data.tplData;
                for(var i=0;i<tplData.length;i++){
                    var graphData=tplData[i];
                    for(var j=0;j<graphData.length;j++){
                        if(j==0){
                            var html="";
                            $("#chartList").html(html);
                        }
                        var gData=graphData[j];
                        var graphType=gData.graphInfo.graphType;
                        if(graphType=="line"){
                            var gid="graph"+gData.graphInfo.id;
                            var html="<div id=\""+gid+"\" style=\"width:100%;height:300px;margin-top:20px;padding-top:20px\"></div>";
                            $("#chartList").append(html);
                            lineOption.legend.data=gData.legendData;
                            lineOption.title.text=gData.graphInfo.name;
                            lineOption.series=gData.seriesData;
                            var gChart = echarts.init(document.getElementById(gid));
                            gChart.setOption(lineOption, true);
                        }

                    }
                }
            } else {
            }
        });

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
                limit: 50,
                page:false,
                where: ps,
                cols: [[
                    { fixed: 'left',type: 'numbers' },
                    // { fixed: 'left',type:'checkbox' },
                    { field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('ID') , templet: function (d) { return templet('id',d.id,d);}  }
                    ,{ field: 'nodeIp', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机IP') , templet: function (d) { return templet('nodeIp',d.nodeIp,d);}  }
                    ,{ field: 'nodeNameShow', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机名称') , templet: function (d) { return templet('nodeNameShow',d.nodeNameShow,d);}  }
                    ,{ field: 'monitorTplCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('监控模板') , templet: function (d) { return templet('monitorTplCode',d.monitorTplCode,d);}  }
                    ,{ field: 'indicatorNme', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('指标名称') , templet: function (d) { return templet('indicatorName',d.indicatorName,d);}  }
                    ,{ field: 'indicatorCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('指标编码') , templet: function (d) { return templet('indicatorCode',d.indicatorCode,d);}  }
                    ,{ field: 'valueColumnName', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('结果描述') , templet: function (d) { return templet('valueColumnName',d.valueColumnName,d);}  }
                    ,{ field: 'value', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('结果数据') , templet: function (d) { return templet('value',d.value,d);}  }
                    ,{ field: 'recordTime', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('最新记录') , templet: function (d) { return templet('recordTime',d.recordTime,d);}  }
                    ,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}

                    // ,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
                ]],
                parseData:function(res){
                    console.log("parese res:",res);
                    return {
                        "code": res.code == "00" ? 0 : -1, //解析接口状态
                        "msg": res.message, //解析提示文本
                        "count": res.data.nodeCollectDataList.length, //解析数据长度
                        "data": res.data.nodeCollectDataList //解析数据列表
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
        searchData();
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

    function getRecentDay(day){
        var today = new Date();
        var targetday_milliseconds=today.getTime() + 1000*60*60*24*day;
        today.setTime(targetday_milliseconds);
        var tYear = today.getFullYear();
        var tMonth = today.getMonth();
        var tDate = today.getDate();
        tMonth = doHandleMonth(tMonth + 1);
        tDate = doHandleMonth(tDate);
        return tYear+"-"+tMonth+"-"+tDate;
    }
    function doHandleMonth(month){
        var m = month;
        if(month.toString().length == 1){
            m = "0" + month;
        }
        return m;
    }

    function initSearchFields() {
        fox.switchSearchRow(1);


        var start=laydate.render({
            elem: '#sTime-begin',
            max:0,
            value:getRecentDay(-1),
            trigger:"click",
            done:function(value,date) {
                if (value && (value > $("#sTime-end").val())) {
                     $("#end_date").val("");
                }
                end.config.min = {
                    year: date.year,
                    month: date.month - 1,
                    date: date.date,
                };
            }

        });
        var end=laydate.render({
            elem: '#sTime-end',
            // max:1,
            value: getRecentDay(1),
            trigger:"click",
            done:function(value,date) {
                start.config.max = {
                    year: date.year,
                    month: date.month - 1,
                    date: date.date,
                }
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

        fox.renderSearchInputs();

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