/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 21:49:29
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-eam/eam-asset";
	const selectmoduleURL="/service-eam/eam-asset-selected-data";
	var dataTable=null;

	var assetListColumn;
	var searchContent_categoryId;
	var selectedListAction;
	var billdata;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;
		assetListColumn=layui.assetListColumn;
		selectedListAction=admin.getTempData('eam-asset-select-action'+ASSET_SELECTED_CODE);
		billdata=admin.getTempData('eam-asset-select-data'+ASSET_SELECTED_CODE);
		console.log("asset baseinfo billdata:",billdata);

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
			console.log("billdata",billdata);
			contitions.status={ value: "complete", label:"完成"};

			if(window.pageExt.list.beforeQuery){
				window.pageExt.list.beforeQuery(contitions,ps,"tableInit");
			}
			if(Object.keys(contitions).length>0) {
				ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};

			}
			ps.assetSelectedCode=ASSET_SELECTED_CODE;
			ps.assetBussinessType=billdata.assetBusinessType;
			ps.assetOwnerId=billdata.assetOwnerId;
			var templet=window.pageExt.list.templet;
			if(templet==null) {
				templet=function(field,value,row) {
					if(value==null) return "";
					return value;
				}
			}
			var h=$(".search-bar").height();
			console.log("full-",h+50,ps)

			var COL_ALL_DATA= assetListColumn.getColumnList(templet);
			var COL_DATA=[{ fixed: 'left',type: 'numbers' },{ fixed: 'left',type:'checkbox' }]
			for(var i=0;i<ATTRIBUTE_LIST_DATA.length;i++){
				COL_DATA.push(COL_ALL_DATA[ATTRIBUTE_LIST_DATA[i].attribute.code])
			}
			dataTable=fox.renderTable({
				elem: '#data-table',
				toolbar: '#toolbarTemplate',
				defaultToolbar: ['filter',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list-by-select',
				height: 'full-'+(h+120),
				limit: 50,
				limits:['50','100','500','1000','5000'],
				where: ps,
				cols: [COL_DATA],
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

	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType,reset) {
		var value = {};

		value.businessCode={ value: $("#businessCode").val()};
		value.assetCode={ value: $("#assetCode").val()};
		//value.status={ value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr")};
		value.assetStatus={ value: xmSelect.get("#assetStatus",true).getValue("value"), label:xmSelect.get("#assetStatus",true).getValue("nameStr")};
		value.name={ value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.manufacturerId={ value: xmSelect.get("#manufacturerId",true).getValue("value"), fillBy:"manufacturer",field:"id", label:xmSelect.get("#manufacturerId",true).getValue("nameStr") };
		value.model={ value: $("#model").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.serialNumber={ value: $("#serialNumber").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};

		value.ownCompanyId={ inputType:"button",value: $("#ownCompanyId").val(),fillBy:["ownerCompany","fullName"] ,label:$("#ownCompanyId-button").text()};
		value.useOrganizationId={ inputType:"button",value: $("#useOrganizationId").val(),fillBy:["useOrganization","fullName"] ,label:$("#useOrganizationId-button").text()};

		value.managerId={ inputType:"button",value: $("#managerId").val(),fillBy:["manager","name"] ,label:$("#managerId-button").text()};
		value.useUserId={ inputType:"button",value: $("#useUserId").val(),fillBy:["useUser","name"] ,label:$("#useUserId-button").text()};

		value.positionId={ value: xmSelect.get("#positionId",true).getValue("value"), fillBy:"position",field:"id", label:xmSelect.get("#positionId",true).getValue("nameStr") };
		value.sourceId={ value: xmSelect.get("#sourceId",true).getValue("value"), fillBy:"source",field:"code", label:xmSelect.get("#sourceId",true).getValue("nameStr") };
		value.purchaseDate={ begin: $("#purchaseDate-begin").val(), end: $("#purchaseDate-end").val() };
		value.assetNotes={ value: $("#assetNotes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};


		value.status={ value:"complete", label:"完成"};
		var ps={searchField:"$composite"};
		if(window.pageExt.list.beforeQuery){
			if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
		}


		if(searchContent_categoryId){
			if(value.categoryId){
				delete value.categoryId ;
			}
			ps.categoryId=searchContent_categoryId;
		}
		ps.assetSelectedCode=ASSET_SELECTED_CODE;
		ps.assetBussinessType=billdata.assetBusinessType;
		ps.assetOwnerId=billdata.assetOwnerId;
		ps.searchValue=JSON.stringify(value);
		if(sortField) {
			ps.sortField=sortField;
			ps.sortType=sortType;
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
		for(var i=0;i<data.length;i++) {
			if(field){
				data[i]=data[i][field];
			}else{
				data[i]=data[i];
			}
		}
		return data;
	}



	function searchCategory(categoryId){
		searchContent_categoryId=categoryId;
		refreshTableData()
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

    function saveSelectData(callback){
    	var postData=billdata;
		postData.assetSelectedCode=ASSET_SELECTED_CODE;
    	postData.ids=getCheckedList("id");


		if(postData.ids.length==0){
			top.layer.msg("请选择资产", {icon: 2, time: 1500});
			return;
		}

		var api=selectmoduleURL+"/save-by-ids";
		admin.post(api,postData,function (r){
			if (r.success) {
				callback(postData.ids);
				layer.msg(r.message, {icon: 1, time: 500});
			} else {
				layer.msg(r.message, {icon: 2, time: 1000});
			}
		},{delayLoading:2000,elms:[]});
		// var task=setTimeout(function(){layer.load(2);},1000);
		// admin.request(api, postData, function (data) {
		// 	clearTimeout(task);
		// 	layer.closeAll('loading');
		// 	if (data.success) {
		// 		callback(postData.ids);
		// 		layer.msg(data.message, {icon: 1, time: 500});
		// 	} else {
		// 		layer.msg(data.message, {icon: 2, time: 1000});
		// 	}
		// }, "POST");

	}
    /**
     * 打开编辑窗口
     */
	function showEditForm(data) {
		if(window.pageExt.list.beforeEdit) {
			var doNext=window.pageExt.list.beforeEdit(data);
			if(!doNext) return;
		}
		var action=admin.getTempData('eam-asset-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString="?" + 'id=' + data.id;
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
			content: '/business/eam/asset/asset_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('eam-asset-form-data-popup-index', index);
	};

	window.module={
		searchCategory:searchCategory,
		refreshTableData: refreshTableData,
		getCheckedList: getCheckedList,
		saveSelectData:saveSelectData
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