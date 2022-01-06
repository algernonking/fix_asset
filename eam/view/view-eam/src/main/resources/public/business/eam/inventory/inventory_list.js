/**
 * 资产盘点 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-01-05 19:34:13
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-eam/eam-inventory";
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
				defaultToolbar: ['filter', 'print',{title: '刷新数据',layEvent: 'refresh-data',icon: 'layui-icon-refresh-3'}],
				url: moduleURL +'/query-paged-list',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' },
					{ fixed: 'left',type:'checkbox'}
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'type', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('类型') , templet: function (d) { return templet('type',d.type,d);}  }
					,{ field: 'businessCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('业务编码') , templet: function (d) { return templet('businessCode',d.businessCode,d);}  }
					//,{ field: 'ownerCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('所属') , templet: function (d) { return templet('ownerCode',d.ownerCode,d);}  }
					,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('盘点名称') , templet: function (d) { return templet('name',d.name,d);}  }
					,{ field: 'inventoryStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('盘点状态'), templet:function (d){ return templet('inventoryStatus',fox.getEnumText(SELECT_INVENTORYSTATUS_DATA,d.inventoryStatus),d);}}
					,{ field: 'dataStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('数据状态'), templet:function (d){ return templet('dataStatus',fox.getEnumText(SELECT_DATASTATUS_DATA,d.dataStatus),d);}}
					,{ field: 'allEmployee', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('全员盘点'), templet:function (d){ return templet('allEmployee',fox.getEnumText(SELECT_ALLEMPLOYEE_DATA,d.allEmployee),d);}}
					,{ field: 'assetStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产状态'), templet:function (d){ return templet('assetStatus',fox.getEnumText(SELECT_ASSETSTATUS_DATA,d.assetStatus),d);}}
				//	,{ field: 'categoryId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产分类') , templet: function (d) { return templet('categoryId',d.categoryId,d);}  }
					,{ field: 'purchaseStartDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('购置开始日期') ,templet: function (d) { return templet('purchaseStartDate',fox.dateFormat(d.purchaseStartDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'purchaseEndDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('购置结束日期') ,templet: function (d) { return templet('purchaseEndDate',fox.dateFormat(d.purchaseEndDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'startTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('盘点开始时间') ,templet: function (d) { return templet('startTime',fox.dateFormat(d.startTime,"yyyy-MM-dd"),d); }  }
					,{ field: 'finishTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('盘点结束时间') ,templet: function (d) { return templet('finishTime',fox.dateFormat(d.finishTime,"yyyy-MM-dd"),d); }  }
					,{ field: 'businessDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('业务日期') ,templet: function (d) { return templet('businessDate',fox.dateFormat(d.businessDate,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'notes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('备注') , templet: function (d) { return templet('notes',d.notes,d);}  }
				//	,{ field: 'planId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('计划编号') , templet: function (d) { return templet('planId',d.planId,d);}  }
					,{ field: 'createTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('创建时间') ,templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'warehouseIds', align:"",fixed:false,  hide:false, sort: true, title: fox.translate('仓库'), templet: function (d) { return templet('warehouseIds' ,fox.joinLabel(d.warehouse,"warehouseName"),d);}}
					,{ field: 'positionIds', align:"",fixed:false,  hide:false, sort: true, title: fox.translate('位置'), templet: function (d) { return templet('positionIds' ,fox.joinLabel(d.position,"name"),d);}}
					,{ field: 'categoryIds', align:"",fixed:false,  hide:false, sort: false, title: fox.translate('资产分类'), templet: function (d) { return templet('categoryIds' ,fox.joinLabel(d.category,"name"),d);}}
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
		value.businessCode={ inputType:"button",value: $("#businessCode").val()};
		value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.inventoryStatus={ inputType:"select_box", value: xmSelect.get("#inventoryStatus",true).getValue("value"), label:xmSelect.get("#inventoryStatus",true).getValue("nameStr") };
		value.businessDate={ inputType:"date_input", begin: $("#businessDate-begin").val(), end: $("#businessDate-end").val() ,matchType:"auto" };
		value.notes={ inputType:"button",value: $("#notes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
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

		fox.switchSearchRow(2);

		//渲染 inventoryStatus 下拉字段
		fox.renderSelectBox({
			el: "inventoryStatus",
			radio: false,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("inventoryStatus",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({data:data[i],name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#businessDate-begin',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("businessDate",value, date, endDate);
				},1);
			}
		});
		laydate.render({
			elem: '#businessDate-end',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("businessDate",value, date, endDate);
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
				case 'tool-inventory-start':
					window.pageExt.list.inventoryStart && window.pageExt.list.inventoryStart(selected,obj);
					break;
				case 'tool-inventory-finish':
					window.pageExt.list.inventoryFinish && window.pageExt.list.inventoryFinish(selected,obj);
					break;
				case 'tool-inventory-cancel':
					window.pageExt.list.inventoryCancel && window.pageExt.list.inventoryCancel(selected,obj);
					break;
				case 'tool-inventory-data-sync':
					window.pageExt.list.inventoryDataSync && window.pageExt.list.inventoryDataSync(selected,obj);
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
			admin.putTempData('eam-inventory-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('资产盘点')+"!");
				return;
			}
			//调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('资产盘点')+fox.translate('吗？'), function (i) {
				admin.post(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
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

			if(window.pageExt.list.beforeRowOperationEvent) {
				var doNext=window.pageExt.list.beforeRowOperationEvent(data,obj);
				if(!doNext) return;
			}

			admin.putTempData('eam-inventory-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('eam-inventory-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						top.layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			} else if (layEvent === 'view') { // 查看
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('eam-inventory-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						top.layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			}
			else if (layEvent === 'del') { // 删除

				if(window.pageExt.list.beforeSingleDelete) {
					var doNext=window.pageExt.list.beforeSingleDelete(data);
					if(!doNext) return;
				}
				top.layer.confirm(fox.translate('确定删除此')+fox.translate('资产盘点')+fox.translate('吗？'), function (i) {
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
			else if (layEvent === 'inventory-detail') { // 明细

				var top=2
				var index=admin.popupCenter({
					title: "盘点明细",
					resize: false,
					offset: [top,null],
					area: ["95%","90%"],
					type: 2,
					id:"eam-asset-inventory-data",
					content: '/business/eam/inventory_asset/inventory_asset_list.html?inventoryId='+data.id,
					finish: function () {
						console.log('11');
					}
				});
				admin.putTempData('eam-asset-inventory-data-popup-index', index);


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
		var action=admin.getTempData('eam-inventory-form-data-form-action');
		var queryString="ownerCode="+OWNER_CODE;
		if(data && data.id) queryString=queryString+'&id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('eam-inventory-form-data', data);
		var area=admin.getTempData('eam-inventory-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('资产盘点');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["85%",height+"px"],
			type: 2,
			id:"eam-inventory-form-data-win",
			content: '/business/eam/inventory/inventory_form.html' + (queryString?("?"+queryString):""),
			finish: function () {
				refreshTableData();
			}
		});
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