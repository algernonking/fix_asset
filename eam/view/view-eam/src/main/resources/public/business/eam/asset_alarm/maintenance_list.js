/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 15:27:32
 */


layui.config({
    dir: layuiPath,
    base: '/module/'
}).extend({
    xmSelect: 'xm-select/xm-select',
    foxnicUpload: 'upload/foxnic-upload',
})

function ListPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect;
    var assetListColumn;
    //模块基础路径
    const moduleURL="/service-eam/eam-asset";
    var dataTable=null;
    var sort=null;
    var now = new Date();
    var day = ("0" + now.getDate()).slice(-2);
    var month = ("0" + (now.getMonth() + 1)).slice(-2);
    var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
    //  $('#onlineTime').val(today);

    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {

        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;
        assetListColumn=layui.assetListColumn;

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
        function renderTableInternal() {
            var ps={};
            var contitions={};
            contitions.status={ value:"complete"};
            contitions.maintenanceEndDate={ begin: today, end: ""};
            if(Object.keys(contitions).length>0) {
                ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};
            }
            var templet=function(field,value,row) {
                if(value==null) return "";
                return value;
            }
            var h=$(".search-bar").height();
            var COL_ALL_DATA= assetListColumn.getColumnList(templet);

            var oper={ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 };
            COL_DATA=[
                { fixed: 'left',type: 'numbers' },
                { fixed: 'left',type:'checkbox' }
            ]
            COL_DATA.push(COL_ALL_DATA["maintenance_end_date"]);
            for(var i=0;i<ATTRIBUTE_LIST_DATA.length;i++){
                if(ATTRIBUTE_LIST_DATA[i].attribute.code=="status"
                  || ATTRIBUTE_LIST_DATA[i].attribute.code=="maintenance_end_date"  ){
                    continue
                }
                COL_DATA.push(COL_ALL_DATA[ATTRIBUTE_LIST_DATA[i].attribute.code])
            }

            COL_DATA.push(oper)
            dataTable=fox.renderTable({
                elem: '#data-table',
                toolbar: '#toolbarTemplate',
                defaultToolbar: ['filter', 'print','exports',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
                url: moduleURL +'/query-paged-list',
                height: 'full-'+(h+28),
                limit: 50,
                where: ps,
                cols: [COL_DATA],
                done: function (data) { },
                footer : {
                }
            });
            //绑定排序事件
            table.on('sort(data-table)', function(obj){
                refreshTableData(obj.field,obj.type);
            });
        }
        setTimeout(renderTableInternal,1);

    };

    /**
     * 刷新表格数据
     */
    function refreshTableData(sortField,sortType,reset) {
        var value = {};
      //  value.businessCode={ value: $("#businessCode").val()};
   //     value.assetCode={ value: $("#assetCode").val(),fuzzy: true,valuePrefix:"",valueSuffix:" "};
        value.status={ value:"complete"};
        value.assetStatus={ value: xmSelect.get("#assetStatus",true).getValue("value"), label:xmSelect.get("#assetStatus",true).getValue("nameStr")};
        value.maintenanceEndDate={ begin: $("#maintenanceEndDate-begin").val(), end: $("#maintenanceEndDate-end").val() };
        var ps={searchField: "$composite", searchValue: JSON.stringify(value)};

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

        //渲染 assetStatus 下拉字段
        fox.renderSelectBox({
            el: "assetStatus",
            radio: false,
            size: "small",
            filterable: false,
            //转换数据
            transform:function(data) {
                //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                var opts=[];
                if(!data) return opts;
                for (var i = 0; i < data.length; i++) {
                    opts.push({name:data[i].text,value:data[i].code});
                }
                return opts;
            }
        });

        laydate.render({
            elem: '#maintenanceEndDate-begin',
            trigger:"click"
        });
        laydate.render({
            elem: '#maintenanceEndDate-end',
            trigger:"click"
        });
        $('#maintenanceEndDate-begin').val(today);
        fox.renderSearchInputs();

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
            admin.putTempData('eam-asset-form-data-form-action', "",true);
            if (layEvent === 'view') { // 修改
                //延迟显示加载动画，避免界面闪动
                var task=setTimeout(function(){layer.load(2);},1000);
                admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
                    clearTimeout(task);
                    layer.closeAll('loading');
                    if(data.success) {
                        admin.putTempData('eam-asset-form-data-form-action', "view",true);
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

        var action=admin.getTempData('eam-asset-form-data-form-action');
        var queryString="?pageType=base";
        if(data && data.id) queryString=queryString+"&" + 'id=' + data.id;

        admin.putTempData('eam-asset-form-data', data);
        var area=admin.getTempData('eam-asset-form-area');
        var height= (area && area.height) ? area.height : ($(window).height()*0.6);
        var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
        var index=admin.popupCenter({
            title: "查看",
            resize: false,
            offset: [top,null],
            area: ["95%",height+"px"],
            type: 2,
            id:"eam-asset-form-data-win",
            content: '/business/eam/asset/asset_info_form.html' + queryString,
            finish: function () {
                refreshTableData();templet
            }
        });
        admin.putTempData('eam-asset-form-data-popup-index', index);
    };

    window.module={
        refreshTableData: refreshTableData,
        getCheckedList: getCheckedList
    };

};


layui.use(['form', 'table', 'util', 'settings','admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {
    var task=setInterval(function (){
        clearInterval(task);
        (new ListPage()).init(layui);
    },1);
});