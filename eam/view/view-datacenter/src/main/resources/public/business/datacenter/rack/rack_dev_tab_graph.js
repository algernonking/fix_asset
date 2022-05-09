/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 21:49:29
 */


function ListPage() {

    var assetListColumn,settings,admin,form,table,layer,util,fox,upload,xmSelect;
    //模块基础路径
    const moduleURL="/service-eam/eam-asset";
    var dataTable=null;
    var sort=null;

    var searchContent_useOrganizationId;
    var searchContent_belongOrganizationId;
    var searchContent_categoryId;
    var searchContent_positionId;

    var rackId="none";
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {

        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;
        assetListColumn=layui.assetListColumn;
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



    function formatRackData(data,cap,rackuuid){
        var result={};
        var ctime=Date.now();
        var successdata=[];
        var successdata2=[];
        var faileddata=[];
        for(var i=0;i<data.length;i++){
            var obj=data[i];
            if(angular.isUndefined(data[i].frame)){
                data[i].result="frame不存在"
                faileddata.push(data[i]);
                continue;
            }
            var frame=data[i].frame.split("-");
            if(frame.length!=2){
                data[i].result="frame格式出错"
                faileddata.push(data[i]);
                continue;
            }
            var framest=frame[0];
            var frameet=frame[1];
            // console.log(framest+","+frameet+"|",parseInt(framest)+","+parseInt(frameet));
            //frame错误判断
            if(isNaN(framest)|| isNaN(frameet)||framest>frameet||framest>cap){
                // console.log("failed")
                data[i].result="frame格式出错"
                faileddata.push(data[i]);
                continue;
            }
            data[i].framest=parseInt(framest);
            data[i].frameet=parseInt(frameet);
            data[i].framediff=parseInt(frameet)-parseInt(framest);
            successdata.push(data[i]);
        }
        //继续判断
        for(var i=0;i<successdata.length;i++){
            var obj=successdata[i];
            var flag="success";
            for(var j=0;j<successdata.length;j++){
                var matchobj=successdata[j];
                if(obj.id==matchobj.id){
                    continue;
                }
                var a=obj.framest;
                var b=obj.frameet;
                var c=matchobj.framest;
                var d=matchobj.frameet;
                if(b<c||a>d){
                }else{
                    flag="failed";
                    break;
                }
            }
            console.log(a+","+b+","+c+","+d+",flag:"+flag+","+obj.id+matchobj.id);
            if(flag=="success"){
                successdata2.push(successdata[i])
            }else{
                successdata[i].result="frame冲突";
                faileddata.push(successdata[i])
            }
        }
        var noobj="<tr name=\"nonedevice\" id=\""+ctime+"f#SEQ#\">\n" +
            "                    <td class=\"no-padding bg-light-blue\">#SEQ#</td>\n" +
            "                    <td class=\"no-padding\"></td>\n" +
            "                    <td class=\"no-padding bg-light-blue\">#SEQ#</td>\n" +
            "                    <td class=\"no-padding\"></td>\n" +
            "                    <td class=\"no-padding\"></td>\n" +
            "                    <td class=\"no-padding\"></td>\n" +
            "                    <td class=\"no-padding\"></td>\n" +
            "                    <td class=\"no-padding\"></td>\n" +
            "                    <td class=\"no-padding no-print\"></td>\n" +
            "                </tr>";
        //显示html
        var htmltbbody="  <thead>\n" +
            "                <tr class=\"active\">\n" +
            "                    <th style=\"width:2%\" class=\"bg-light-blue\">U</th>\n" +
            "                    <th style=\"text-align:center;width:16%\" class=\"bg-light-blue\">"+rackuuid+"</th>\n" +
            "                    <th style=\"width:2%\" class=\"bg-light-blue\">U</th>\n" +
            "                    <th style=\"text-align:center;\">状态</th>\n" +
            "                    <th style=\"text-align:center;\">IP地址</th>\n" +
            "                    <th style=\"text-align:center;\">设备SN号</th>\n" +
            "                    <th style=\"text-align:center;\">设备型号</th>\n" +
            "                    <th style=\"text-align:center;\">运行环境</th>\n" +
            "                    <th style=\"text-align:center;\" class=\"no-print\">操作</th>\n" +
            "                </tr>\n" +
            "                </thead> <tbody>"
        var htmltr=[];
        //初始化机柜
        for(var i=0;i<cap;i++){
            var u="";
            if(i>9){u=i;}else{u="0"+i;}
            htmltr.push(noobj.replace(new RegExp("#SEQ#","gm"),u));
        }
        //放置设备
        for(var i=0;i<successdata2.length;i++){
            var assets=successdata2[i];
            var s=assets.framest;
            var e=assets.frameet;
            var d=e-s+1;
            var u="";
            if(e>9){u=e;}else{u="0"+e;}
            var rowspan="";
            if(d>0){
                rowspan="rowspan=\""+d+"\"";
            }
            var devhtml="<tr name=\"hasdevice\" class=\"danger\">\n" +
                "                    <td style=\"vertical-align: middle;\" class=\"no-padding bg-light-blue\">"+u+"</td>\n" +
                "                    <td style=\"vertical-align: middle;\" "+rowspan+" class=\"no-padding\"><a href=\"/detail/online-95/\">"+assets.uuid+"</a></td>\n" +
                "                    <td style=\"vertical-align: middle;\" class=\"no-padding bg-light-blue\">"+u+"</td>\n" +
                "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding\">"+assets.recyclestr+"</td>\n" +
                "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding\"><span>"+assets.ip+"</span></td>\n" +
                "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding\">"+assets.sn+"</td>\n" +
                "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding\">"+assets.name+"/"+assets.model+"</td>\n" +
                "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding\">"+assets.envstr+"</td>\n" +
                "                    <td style=\"vertical-align: middle;\" "+rowspan+"  class=\"no-padding no-print\"><a href=\"/update/online-95/\"></a></td>\n" +
                "                </tr>";
            console.log("before")
            console.log(htmltr[e])
            htmltr[e]=devhtml;
            console.log("after")
            console.log(htmltr[e])
            if(d>1){
                for(var j=1;j<d;j++){
                    var ii=e-j;
                    var uu="";
                    if(ii>9){uu=ii;}else{uu="0"+ii;}
                    var devhtml2="<tr name=\"hasdevice\" class=\"danger\">\n" +
                        "                    <td style=\"vertical-align: middle;\" class=\"no-padding bg-light-blue\">"+uu+"</td>\n" +
                        "                    <td style=\"vertical-align: middle;\" class=\"no-padding bg-light-blue\">"+uu+"</td>\n" +
                        "                </tr>";
                    console.log("AAAbefore")
                    console.log(htmltr[ii])
                    htmltr[ii]=devhtml2;
                    console.log("AAAafter")
                    console.log(htmltr[ii])

                }
            }
        }
        for(var i=htmltr.length-1;i>0;i--){
            htmltbbody=htmltbbody+htmltr[i];
        }
        htmltbbody=htmltbbody+"<tr>\n" +
            "                    <td class=\"no-padding bg-light-blue\">-1</td>\n" +
            "                    <td class=\"no-padding bg-light-blue\"></td>\n" +
            "                    <td class=\"no-padding bg-light-blue\">-1</td>\n" +
            "                     <td class=\"no-padding\"></td><td class=\"no-padding\"></td><td class=\"no-padding\"></td><td class=\"no-padding\"></td><td class=\"no-padding\"></td><td class=\"no-padding no-print\"></td>\n" +
            "                </tr>\n" +
            "                </tbody>";
        var htmltable="<table id=\"rack-detail\" style=\"text-align:center;margin:0; padding:0;\" class=\"table table-bordered text-center nowarp table-condensed\">"+htmltbbody+"</table>";
        result.htmltable=htmltable;
        result.falied=faileddata;
        result.success=successdata2;
        return result;
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

            var ps={};

            var contitions={};
            contitions.status={ value: "complete", label:"完成"};
            if(window.pageExt.list.beforeQuery){
                window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
            }

            if(Object.keys(contitions).length>0) {
                ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};
            }
            ps.rackId=rackId;
            ps.ownerCode=OWNER_CODE;
            var templet=window.pageExt.list.templet;
            if(templet==null) {
                templet=function(field,value,row) {
                    if(value==null) return "";
                    return value;
                }
            }

            var h=$(".search-bar").height();
            var COL_ALL_DATA= assetListColumn.getColumnList(templet);
            var COL_DATA=[{ fixed: 'left',type: 'numbers' },{ fixed: 'left',type:'checkbox'}];
            for(var i=0;i<ATTRIBUTE_LIST_DATA.length;i++){
                COL_DATA.push(COL_ALL_DATA[ATTRIBUTE_LIST_DATA[i].attribute.code])
            }
            var oper={ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 };
            COL_DATA.push(oper)
            dataTable=fox.renderTable({
                elem: '#data-table',
                toolbar: '#toolbarTemplate',
                defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
                url: moduleURL +'/query-paged-list',
                height: 'full-'+(h+28),
                limit: 50,
                where: ps,
                cols: [[
                    // 	{ fixed: 'left',type: 'numbers' },
                    //		{ fixed: 'left',type:'checkbox'}
                    //	,{ field: 'categoryId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产分类'), templet: function (d) { return templet('categoryId' ,fox.joinLabel(d.category,"name"),d);}}
                    { field: 'status', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('办理状态'), templet:function (d){ return templet('status',fox.getEnumText(SELECT_STATUS_DATA,d.status),d);}}
                    ,{ field: 'assetCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产编号') , templet: function (d) { return templet('assetCode',d.assetCode,d);}  }
                    ,{ field: 'assetStatus', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('资产状态'), templet:function (d){ return templet('assetStatus',fox.getEnumText(SELECT_ASSETSTATUS_DATA,d.assetStatus),d);}}
                    ,{ field: 'model', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('规格型号') , templet: function (d) { return templet('model',d.model,d);}  }
                    ,{ field: 'equipmentIp', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备IP') , templet: function (d) { return templet('equipmentIp',d.equipmentIp,d);}  }
                    ,{ field: 'manageIp', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('管理IP') , templet: function (d) { return templet('manageIp',d.manageIp,d);}  }
                    ,{ field: 'equipmentCpu', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备CPU') , templet: function (d) { return templet('equipmentCpu',d.equipmentCpu,d);}  }
                    ,{ field: 'equipmentMemory', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备内存') , templet: function (d) { return templet('equipmentMemory',d.equipmentMemory,d);}  }
                    //	,{ field: 'equipmentLabel', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备标签') , templet: function (d) { return templet('equipmentLabel',d.equipmentLabel,d);}  }
                    //	,{ field: 'equipmentConf', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备配置') , templet: function (d) { return templet('equipmentConf',d.equipmentConf,d);}  }
                    //	,{ field: 'equipmentEnvironmentCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('运行环境'), templet: function (d) { return templet('equipmentEnvironmentCode' ,fox.joinLabel(d.equipmentEnvironment,"label"),d);}}
                    //	,{ field: 'equipmentSerialNumber', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('设备序列号') , templet: function (d) { return templet('equipmentSerialNumber',d.equipmentSerialNumber,d);}  }
                    //	,{ field: 'rackId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('机柜'), templet: function (d) { return templet('rackId' ,fox.joinLabel(d.rack,"rackName"),d);}}
                    ,{ field: 'rackUpNumber', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('设备机柜上位置') , templet: function (d) { return templet('rackUpNumber',d.rackUpNumber,d);}  }
                    ,{ field: 'rackDownNumber', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('设备机柜下位置') , templet: function (d) { return templet('rackDownNumber',d.rackDownNumber,d);}  }
                ]],
                done: function (data) { window.pageExt.list.afterQuery && window.pageExt.list.afterQuery(data); },
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


    function getSearchCondition(){
        var value = {};



        // value.businessCode={ inputType:"button",value: $("#businessCode").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
        //
        // //value.businessCode={ inputType:"button",value: $("#businessCode").val()};
        // value.status={ inputType:"select_box", value:"complete", label:"完成"};
        // value.assetCode={ inputType:"button",value: $("#assetCode").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
        // value.assetStatus={ inputType:"select_box", value: xmSelect.get("#assetStatus",true).getValue("value"), label:xmSelect.get("#assetStatus",true).getValue("nameStr")};
        // value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
        // value.manufacturerId={ inputType:"select_box", value: xmSelect.get("#manufacturerId",true).getValue("value") ,fillBy:["manufacturer"]  ,label:xmSelect.get("#manufacturerId",true).getValue("nameStr") };
        // value.model={ inputType:"button",value: $("#model").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
        // value.serialNumber={ inputType:"button",value: $("#serialNumber").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
        // value.ownCompanyId={ inputType:"button",value: $("#ownCompanyId").val(),fillBy:["ownerCompany","fullName"] ,label:$("#ownCompanyId-button").text() };
        // value.managerId={ inputType:"button",value: $("#managerId").val(),fillBy:["manager","name"] ,label:$("#managerId-button").text() };
        // value.useOrganizationId={ inputType:"button",value: $("#useOrganizationId").val(),fillBy:["useOrganization","fullName"] ,label:$("#useOrganizationId-button").text() };
        // value.useUserId={ inputType:"button",value: $("#useUserId").val(),fillBy:["useUser","name"] ,label:$("#useUserId-button").text() };
        // value.positionId={ inputType:"select_box", value: xmSelect.get("#positionId",true).getValue("value") ,fillBy:["position"]  ,label:xmSelect.get("#positionId",true).getValue("nameStr") };
        // // value.sourceId={ inputType:"select_box", value: xmSelect.get("#sourceId",true).getValue("value") ,fillBy:["source"]  ,label:xmSelect.get("#sourceId",true).getValue("nameStr") };
        // value.purchaseDate={ inputType:"date_input", begin: $("#purchaseDate-begin").val(), end: $("#purchaseDate-end").val() };
        // //  value.assetNotes={ inputType:"button",value: $("#assetNotes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
        // value.maintainerId={ inputType:"select_box", value: xmSelect.get("#maintainerId",true).getValue("value") ,fillBy:["maintnainer"]  ,label:xmSelect.get("#maintainerId",true).getValue("nameStr") };


        return value;
    }
    /**
     * 刷新表格数据
     */
    function refreshTableData(sortField,sortType,reset) {

        var value=getSearchCondition();
        var ps={searchField:"$composite"};
        if(window.pageExt.list.beforeQuery){
            if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
        }
        if(searchContent_useOrganizationId){
            if(value.useOrganizationId){
                delete value.useOrganizationId ;
            }
            ps.useOrganizationId=searchContent_useOrganizationId;
        }

        if(searchContent_belongOrganizationId){
            if(value.ownCompanyId){
                delete value.ownCompanyId ;
            }
            ps.ownCompanyId=searchContent_belongOrganizationId;
        }


        if(searchContent_categoryId){
            if(value.categoryId){
                delete value.categoryId ;
            }
            ps.categoryId=searchContent_categoryId;
        }

        if(searchContent_positionId){
            value.positionId={value:searchContent_positionId, fillBy:"position", label:xmSelect.get("#positionId",true).getValue("nameStr") };
        }
        ps.rackId=rackId;
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
        ps.ownerCode=OWNER_CODE;
        if(reset) {
            table.reload('data-table', { where : ps , page:{ curr:1 } });
        } else {
            table.reload('data-table', { where : ps });
        }
    }


    function searchUseOrganization(useOrganizationId){
        searchContent_useOrganizationId=useOrganizationId;
        refreshTableData()
    }
    function searchBelongOrganization(belongOrganizationId){
        searchContent_belongOrganizationId=belongOrganizationId;
        refreshTableData()
    }


    function searchCategory(categoryId){
        searchContent_categoryId=categoryId;
        refreshTableData()
    }

    function searchPosition(positionId){
        searchContent_positionId=positionId;
        refreshTableData()
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

        //渲染 status 下拉字段
        fox.renderSelectBox({
            el: "status",
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
        //渲染 manufacturerId 下拉字段
        fox.renderSelectBox({
            el: "manufacturerId",
            radio: false,
            size: "small",
            filterable: true,
            //转换数据
            searchField: "manufacturerName", //请自行调整用于搜索的字段名称
            extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
            transform: function(data) {
                //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                var opts=[];
                if(!data) return opts;
                for (var i = 0; i < data.length; i++) {
                    if(!data[i]) continue;
                    opts.push({name:data[i].manufacturerName,value:data[i].id});
                }
                return opts;
            }
        });
        //渲染 positionId 下拉字段
        fox.renderSelectBox({
            el: "positionId",
            radio: false,
            size: "small",
            filterable: true,
            paging: true,
            pageRemote: true,
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
        //渲染 sourceId 下拉字段
        fox.renderSelectBox({
            el: "sourceId",
            radio: false,
            size: "small",
            filterable: false,
            //转换数据
            transform: function(data) {
                //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                var opts=[];
                if(!data) return opts;
                for (var i = 0; i < data.length; i++) {
                    if(!data[i]) continue;
                    opts.push({name:data[i].label,value:data[i].code});
                }
                return opts;
            }
        });
        laydate.render({
            elem: '#purchaseDate-begin',
            trigger:"click"
        });
        laydate.render({
            elem: '#purchaseDate-end',
            trigger:"click"
        });
        //渲染 maintainerId 下拉字段
        fox.renderSelectBox({
            el: "maintainerId",
            radio: false,
            size: "small",
            filterable: true,
            //转换数据
            searchField: "maintainerName", //请自行调整用于搜索的字段名称
            extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
            transform: function(data) {
                //要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
                var opts=[];
                if(!data) return opts;
                for (var i = 0; i < data.length; i++) {
                    if(!data[i]) continue;
                    opts.push({name:data[i].maintainerName,value:data[i].id});
                }
                return opts;
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

        // 请选择公司对话框
        $("#ownCompanyId-button").click(function(){
            var ownCompanyIdDialogOptions={
                field:"ownCompanyId",
                inputEl:$("#ownCompanyId"),
                buttonEl:$(this),
                single:true,
                //限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
                root: "",
                targetType:"com",
                prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
                callback:function(param){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param);}
            };
            fox.chooseOrgNode(ownCompanyIdDialogOptions);
        });
        // 请选择组织节点对话框
        $("#useOrganizationId-button").click(function(){
            var useOrganizationIdDialogOptions={
                field:"useOrganizationId",
                inputEl:$("#useOrganizationId"),
                buttonEl:$(this),
                single:true,
                //限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
                root: "",
                targetType:"org",
                prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
                callback:function(param){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param);}
            };
            fox.chooseOrgNode(useOrganizationIdDialogOptions);
        });
        // 请选择人员对话框
        $("#useUserId-button").click(function(){
            var useUserIdDialogOptions={
                field:"useUserId",
                inputEl:$("#useUserId"),
                buttonEl:$(this),
                single:true,
                //限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
                root: "",
                targetType:"emp",
                prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
                callback:function(param){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param);}
            };
            fox.chooseEmployee(useUserIdDialogOptions);
        });

        // 请选择人员对话框
        $("#managerId-button").click(function(){
            var managerIdDialogOptions={
                field:"managerId",
                inputEl:$("#managerId"),
                buttonEl:$(this),
                single:true,
                //限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
                root: "",
                targetType:"emp",
                prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
                callback:function(param){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param);}
            };
            fox.chooseEmployee(managerIdDialogOptions);
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
            admin.putTempData('eam-asset-form-data-form-action', "create",true);
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
                top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('资产')+"!");
                return;
            }
            //调用批量删除接口
            top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('资产')+fox.translate('吗？'), function (i) {
                top.layer.close(i);
                top.layer.load(2);
                admin.request(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
                    top.layer.closeAll('loading');
                    if (data.success) {
                        if(window.pageExt.list.afterBatchDelete) {
                            var doNext=window.pageExt.list.afterBatchDelete(data);
                            if(!doNext) return;
                        }
                        top.layer.msg(data.message, {icon: 1, time: 500});
                        refreshTableData();
                    } else {
                        top.layer.msg(data.message, {icon: 2, time: 1500});
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
            admin.putTempData('eam-asset-form-data-form-action', "",true);
            if (layEvent === 'edit') { // 修改
                //延迟显示加载动画，避免界面闪动
                var task=setTimeout(function(){layer.load(2);},1000);
                admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
                    clearTimeout(task);
                    layer.closeAll('loading');
                    if(data.success) {
                        admin.putTempData('eam-asset-form-data-form-action', "edit",true);
                        showEditForm(data.data);
                    } else {
                        layer.msg(data.message, {icon: 1, time: 1500});
                    }
                });
            } else if (layEvent === 'view') { // 查看
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
            else if (layEvent === 'del') { // 删除

                if(window.pageExt.list.beforeSingleDelete) {
                    var doNext=window.pageExt.list.beforeSingleDelete(data);
                    if(!doNext) return;
                }

                top.layer.confirm(fox.translate('确定删除此')+fox.translate('资产')+fox.translate('吗？'), function (i) {
                    top.layer.close(i);

                    top.layer.load(2);
                    admin.request(moduleURL+"/delete", { id : data.id }, function (data) {
                        top.layer.closeAll('loading');
                        if (data.success) {
                            if(window.pageExt.list.afterSingleDelete) {
                                var doNext=window.pageExt.list.afterSingleDelete(data);
                                if(!doNext) return;
                            }
                            top.layer.msg(data.message, {icon: 1, time: 500});
                            refreshTableData();
                        } else {
                            top.layer.msg(data.message, {icon: 2, time: 1500});
                        }
                    });
                });

            }
            else if (layEvent === 'asset-data-change') { // 变更
                window.pageExt.list.assetDataChange(data);
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
        var action=admin.getTempData('eam-asset-form-data-form-action');
        var queryString="?pageType=base";
        if(data && data.id) queryString=queryString+"&" + 'id=' + data.id;
        admin.putTempData('eam-asset-form-data', data);
        var area=admin.getTempData('eam-asset-form-area');
        var height= (area && area.height) ? area.height : ($(window).height()*0.6);
        var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
        var title = fox.translate('资产');
        if(action=="create") title=fox.translate('添加')+title;
        else if(action=="edit") title=fox.translate('修改')+title;
        else if(action=="view") title=fox.translate('查看')+title;

        var index=admin.popupCenter({
            title: title,
            resize: false,
            offset: [top,null],
            area: ["95%",height+"px"],
            type: 2,
            id:"eam-asset-form-data-win",
            content: '/business/eam/asset/asset_info_form.html' + queryString,
            finish: function () {
                refreshTableData();
            }
        });
        admin.putTempData('eam-asset-form-data-popup-index', index);
    };

    function showNodeData(nodeId,showType){
        //	refreshTableData();
        //	console.log("Event",nodeId);
        rackId=nodeId
        refreshTableData();

        if(showType=='rack'){

        }
    }

    window.showNodeData=showNodeData;
    window.module={
        searchUseOrganization:searchUseOrganization,
        searchBelongOrganization:searchBelongOrganization,
        searchCategory:searchCategory,
        searchPosition:searchPosition,
        refreshTableData: refreshTableData,
        getCheckedList: getCheckedList,
        showNodeData:showNodeData,
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