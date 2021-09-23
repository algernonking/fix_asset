/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 15:27:32
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	var assetListColumn;
	//模块基础路径
	const moduleURL="/service-eam/eam-asset";
	var dataTable=null;
	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {

		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;
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
			if(window.pageExt.list.beforeQuery){
				window.pageExt.list.beforeQuery(contitions);
			}
			if(Object.keys(contitions).length>0) {
				ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};
			}
			var templet=window.pageExt.list.templet;
			if(templet==null) {
				templet=function(field,value,row) {
					if(value==null) return "";
					return value;
				}
			}
			var h=$(".search-bar").height();
			var COL_ALL_DATA= assetListColumn.getColumnList(templet);
			console.log(COL_ALL_DATA);

			var oper={ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 };
			COL_DATA=[
				{ fixed: 'left',type: 'numbers' },
				{ fixed: 'left',type:'checkbox' }
			]
			for(var i=0;i<ATTRIBUTE_LIST_DATA.length;i++){
				COL_DATA.push(COL_ALL_DATA[ATTRIBUTE_LIST_DATA[i].attribute.code])
			}
			COL_DATA.push(oper)

			dataTable=fox.renderTable({
				elem: '#data-table',
				toolbar: '#toolbarTemplate',
				defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [COL_DATA],
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
						}
					}:false
				}
			});
			//绑定排序事件
			table.on('sort(data-table)', function(obj){
				refreshTableData(obj.field,obj.type);
			});



		}
		setTimeout(renderTableInternal,1);

		if(window.pageExt.list.afterRenderTable){
			window.pageExt.list.afterRenderTable();
		}
	};

	/**
	 * 刷新表格数据
	 */
	function refreshTableData(sortField,sortType) {
		console.log(1)
		var value = {};
		value.businessCode={ value: $("#businessCode").val()};
		value.status={ value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr")};
		value.assetCode={ value: $("#assetCode").val()};
		value.assetStatus={ value: xmSelect.get("#assetStatus",true).getValue("value"), label:xmSelect.get("#assetStatus",true).getValue("nameStr")};
		value.name={ value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.manufacturerId={ value: xmSelect.get("#manufacturerId",true).getValue("value"), fillBy:"manufacturer",field:"id", label:xmSelect.get("#manufacturerId",true).getValue("nameStr") };
		value.model={ value: $("#model").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.serialNumber={ value: $("#serialNumber").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.ownCompanyId={ value: $("#ownCompanyId").val()};
		value.useOrganizationId={ value: $("#useOrganizationId").val()};
		value.useUserId={ value: $("#useUserId").val()};
		value.positionId={ value: xmSelect.get("#positionId",true).getValue("value"), fillBy:"position",field:"id", label:xmSelect.get("#positionId",true).getValue("nameStr") };
		value.sourceId={ value: xmSelect.get("#sourceId",true).getValue("value"), fillBy:"source",field:"code", label:xmSelect.get("#sourceId",true).getValue("nameStr") };
		value.purchaseDate={ begin: $("#purchaseDate-begin").val(), end: $("#purchaseDate-end").val() };
		value.assetNotes={ value: $("#assetNotes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		if(window.pageExt.list.beforeQuery){
			if(!window.pageExt.list.beforeQuery(value)) return;
		}
		var ps={searchField: "$composite", searchValue: JSON.stringify(value)};
		if(sortField) {
			ps.sortField=sortField;
			ps.sortType=sortType;
		}
		table.reload('data-table', { where : ps });
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
			refreshTableData();
		});

		// 搜索按钮点击事件
		$('#search-button').click(function () {
			refreshTableData();
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

	window.pageExt.list.ending && window.pageExt.list.ending();

};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new ListPage()).init(layui);
	},1);
});