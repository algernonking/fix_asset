/**
 * 模版指标 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:39
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-ops/ops-monitor-tpl-indicator";
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
					,{ field: 'status', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('状态'), templet:function (d){ return templet('status',fox.getEnumText(SELECT_STATUS_DATA,d.status),d);}}
					,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('名称') , templet: function (d) { return templet('name',d.name,d);}  }
					,{ field: 'code', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('编码') , templet: function (d) { return templet('code',d.code,d);}  }
					,{ field: 'monitorTplCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('模版'), templet: function (d) { return templet('monitorTplCode' ,fox.joinLabel(d.tpl,"name"),d);}}
					,{ field: 'monitorMethod', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('监控方式'), templet:function (d){ return templet('monitorMethod',fox.getEnumText(SELECT_MONITORMETHOD_DATA,d.monitorMethod),d);}}
					,{ field: 'indicatorType', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('指标类型'), templet: function (d) { return templet('indicatorType' ,fox.joinLabel(d.monitorIndicatorType,"name"),d);}}
					,{ field: 'valueColumnRows', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('值行数'), templet:function (d){ return templet('valueColumnRows',fox.getEnumText(SELECT_VALUECOLUMNROWS_DATA,d.valueColumnRows),d);}}
					,{ field: 'valueColumnCols', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('值列数'), templet:function (d){ return templet('valueColumnCols',fox.getEnumText(SELECT_VALUECOLUMNCOLS_DATA,d.valueColumnCols),d);}}
					,{ field: 'valueColumnType', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('数值类型'), templet:function (d){ return templet('valueColumnType',fox.getEnumText(SELECT_VALUECOLUMNTYPE_DATA,d.valueColumnType),d);}}
					,{ field: 'valueColumn', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('数值字段') , templet: function (d) { return templet('valueColumn',d.valueColumn,d);}  }
					,{ field: 'valueColumnMap', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('数值字段映射') , templet: function (d) { return templet('valueColumnMap',d.valueColumnMap,d);}  }
					,{ field: 'valueColumnName', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('字段名称') , templet: function (d) { return templet('valueColumnName',d.valueColumnName,d);}  }
					,{ field: 'valueColumnDesc', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('字段描述') , templet: function (d) { return templet('valueColumnDesc',d.valueColumnDesc,d);}  }
					,{ field: 'timeOut', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('超时(秒)') , templet: function (d) { return templet('timeOut',d.timeOut,d);}  }
					,{ field: 'intervalTime', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('间隔时间(秒）') , templet: function (d) { return templet('intervalTime',d.intervalTime,d);}  }
					,{ field: 'dataKeepDay', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('数据保留天数') , templet: function (d) { return templet('dataKeepDay',d.dataKeepDay,d);}  }
					,{ field: 'command', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('命令') , templet: function (d) { return templet('command',d.command,d);}  }
					,{ field: 'snmpOid', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('snmp元数据') , templet: function (d) { return templet('snmpOid',d.snmpOid,d);}  }
					,{ field: 'label', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('标签') , templet: function (d) { return templet('label',d.label,d);}  }
					,{ field: 'itemSort', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('排序') , templet: function (d) { return templet('itemSort',d.itemSort,d);}  }
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
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType,reset) {
		function getSelectedValue(id,prop) { var xm=xmSelect.get(id,true); return xm==null ? null : xm.getValue(prop);}
		var value = {};
		value.id={ inputType:"button",value: $("#id").val()};
		value.status={ inputType:"select_box", value: getSelectedValue("#status","value"), label:getSelectedValue("#status","nameStr") };
		value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.code={ inputType:"button",value: $("#code").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.monitorTplCode={ inputType:"select_box", value: getSelectedValue("#monitorTplCode","value") ,fillBy:["tpl"]  , label:getSelectedValue("#monitorTplCode","nameStr") };
		value.monitorMethod={ inputType:"select_box", value: getSelectedValue("#monitorMethod","value"), label:getSelectedValue("#monitorMethod","nameStr") };
		value.indicatorType={ inputType:"select_box", value: getSelectedValue("#indicatorType","value") ,fillBy:["monitorIndicatorType"]  , label:getSelectedValue("#indicatorType","nameStr") };
		value.valueColumnRows={ inputType:"select_box", value: getSelectedValue("#valueColumnRows","value"), label:getSelectedValue("#valueColumnRows","nameStr") };
		value.valueColumnCols={ inputType:"select_box", value: getSelectedValue("#valueColumnCols","value"), label:getSelectedValue("#valueColumnCols","nameStr") };
		value.valueColumnType={ inputType:"select_box", value: getSelectedValue("#valueColumnType","value"), label:getSelectedValue("#valueColumnType","nameStr") };
		value.valueColumn={ inputType:"button",value: $("#valueColumn").val()};
		value.valueColumnMap={ inputType:"button",value: $("#valueColumnMap").val()};
		value.valueColumnName={ inputType:"button",value: $("#valueColumnName").val()};
		value.valueColumnDesc={ inputType:"button",value: $("#valueColumnDesc").val()};
		value.timeOut={ inputType:"number_input", value: $("#timeOut").val() };
		value.intervalTime={ inputType:"number_input", value: $("#intervalTime").val() };
		value.dataKeepDay={ inputType:"number_input", value: $("#dataKeepDay").val() };
		value.command={ inputType:"button",value: $("#command").val()};
		value.commandValue={ inputType:"button",value: $("#commandValue").val()};
		value.snmpOid={ inputType:"button",value: $("#snmpOid").val()};
		value.label={ inputType:"button",value: $("#label").val()};
		value.itemSort={ inputType:"number_input", value: $("#itemSort").val() };
		value.notes={ inputType:"button",value: $("#notes").val()};
		value.createTime={ inputType:"date_input", value: $("#createTime").val() ,matchType:"auto"};
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

		//渲染 status 下拉字段
		fox.renderSelectBox({
			el: "status",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("status",data.arr,data.change,data.isAdd);
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
		//渲染 monitorTplCode 下拉字段
		fox.renderSelectBox({
			el: "monitorTplCode",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("monitorTplCode",data.arr,data.change,data.isAdd);
				},1);
			},
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
					opts.push({data:data[i],name:data[i].name,value:data[i].code});
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
			admin.putTempData('ops-monitor-tpl-indicator-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('模版指标')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('模版指标')+fox.translate('吗？'), function (i) {
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

			admin.putTempData('ops-monitor-tpl-indicator-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('ops-monitor-tpl-indicator-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						 top.layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			} else if (layEvent === 'view') { // 查看
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('ops-monitor-tpl-indicator-form-data-form-action', "view",true);
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
				top.layer.confirm(fox.translate('确定删除此')+fox.translate('模版指标')+fox.translate('吗？'), function (i) {
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
		var action=admin.getTempData('ops-monitor-tpl-indicator-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString='id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('ops-monitor-tpl-indicator-form-data', data);
		var area=admin.getTempData('ops-monitor-tpl-indicator-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('模版指标');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["98%",height+"px"],
			type: 2,
			id:"ops-monitor-tpl-indicator-form-data-win",
			content: '/business/ops/monitor_tpl_indicator/monitor_tpl_indicator_form.html' + (queryString?("?"+queryString):""),
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