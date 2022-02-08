/**
 * 节点主机 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:45
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-ops/ops-monitor-node-host";
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
					,{ field: 'nodeId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('节点') , templet: function (d) { return templet('nodeId',d.nodeId,d);}  }
					,{ field: 'hostname', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('主机名称') ,templet: function (d) { return templet('hostname',fox.dateFormat(d.hostname,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'boottime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('启动时间') ,templet: function (d) { return templet('boottime',fox.dateFormat(d.boottime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'osVerion', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('系统') , templet: function (d) { return templet('osVerion',d.osVerion,d);}  }
					,{ field: 'arch', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('架构') , templet: function (d) { return templet('arch',d.arch,d);}  }
					,{ field: 'cpu', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('CPU数量') , templet: function (d) { return templet('cpu',d.cpu,d);}  }
					,{ field: 'cpuFre', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('CPU主频') , templet: function (d) { return templet('cpuFre',d.cpuFre,d);}  }
					,{ field: 'memory', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('内存(M)') , templet: function (d) { return templet('memory',d.memory,d);}  }
					,{ field: 'cpuSys', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('cpuSys') , templet: function (d) { return templet('cpuSys',d.cpuSys,d);}  }
					,{ field: 'cpuUser', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('cpuUser') , templet: function (d) { return templet('cpuUser',d.cpuUser,d);}  }
					,{ field: 'cpuWait', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('cpuWait') , templet: function (d) { return templet('cpuWait',d.cpuWait,d);}  }
					,{ field: 'cpuIdle', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('CPU空闲旅') , templet: function (d) { return templet('cpuIdle',d.cpuIdle,d);}  }
					,{ field: 'cpuUsed', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('CPU使用率') , templet: function (d) { return templet('cpuUsed',d.cpuUsed,d);}  }
					,{ field: 'osLoad', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('系统负载') , templet: function (d) { return templet('osLoad',d.osLoad,d);}  }
					,{ field: 'osLoad5', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('系统负载5') , templet: function (d) { return templet('osLoad5',d.osLoad5,d);}  }
					,{ field: 'osLoad15', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('系统负载15') , templet: function (d) { return templet('osLoad15',d.osLoad15,d);}  }
					,{ field: 'memoryUsed', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('内存使用率') , templet: function (d) { return templet('memoryUsed',d.memoryUsed,d);}  }
					,{ field: 'vmemoryUsed', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('虚拟内存使用率') , templet: function (d) { return templet('vmemoryUsed',d.vmemoryUsed,d);}  }
					,{ field: 'networkFlowUp', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('上行流量') , templet: function (d) { return templet('networkFlowUp',d.networkFlowUp,d);}  }
					,{ field: 'networkFlowDown', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('下流量') , templet: function (d) { return templet('networkFlowDown',d.networkFlowDown,d);}  }
					,{ field: 'processCnt', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('连接数') , templet: function (d) { return templet('processCnt',d.processCnt,d);}  }
					,{ field: 'pMemoryUsed', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('内存') , templet: function (d) { return templet('pMemoryUsed',d.pMemoryUsed,d);}  }
					,{ field: 'vMemoryUsed', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('虚拟内存') , templet: function (d) { return templet('vMemoryUsed',d.vMemoryUsed,d);}  }
					,{ field: 'info', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('信息') , templet: function (d) { return templet('info',d.info,d);}  }
					,{ field: 'recordTime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('记录时间') ,templet: function (d) { return templet('recordTime',fox.dateFormat(d.recordTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
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
		value.nodeId={ inputType:"button",value: $("#nodeId").val()};
		value.hostname={ inputType:"date_input", value: $("#hostname").val() ,matchType:"auto"};
		value.boottime={ inputType:"date_input", value: $("#boottime").val() ,matchType:"auto"};
		value.osVerion={ inputType:"button",value: $("#osVerion").val()};
		value.arch={ inputType:"button",value: $("#arch").val()};
		value.cpu={ inputType:"number_input", value: $("#cpu").val() };
		value.cpuFre={ inputType:"number_input", value: $("#cpuFre").val() };
		value.memory={ inputType:"number_input", value: $("#memory").val() };
		value.cpuSys={ inputType:"number_input", value: $("#cpuSys").val() };
		value.cpuUser={ inputType:"number_input", value: $("#cpuUser").val() };
		value.cpuWait={ inputType:"number_input", value: $("#cpuWait").val() };
		value.cpuIdle={ inputType:"number_input", value: $("#cpuIdle").val() };
		value.cpuUsed={ inputType:"number_input", value: $("#cpuUsed").val() };
		value.osLoad={ inputType:"number_input", value: $("#osLoad").val() };
		value.osLoad5={ inputType:"number_input", value: $("#osLoad5").val() };
		value.osLoad15={ inputType:"number_input", value: $("#osLoad15").val() };
		value.memoryUsed={ inputType:"number_input", value: $("#memoryUsed").val() };
		value.vmemoryUsed={ inputType:"number_input", value: $("#vmemoryUsed").val() };
		value.networkFlowUp={ inputType:"number_input", value: $("#networkFlowUp").val() };
		value.networkFlowDown={ inputType:"number_input", value: $("#networkFlowDown").val() };
		value.processCnt={ inputType:"number_input", value: $("#processCnt").val() };
		value.pMemoryUsed={ inputType:"number_input", value: $("#pMemoryUsed").val() };
		value.vMemoryUsed={ inputType:"number_input", value: $("#vMemoryUsed").val() };
		value.info={ inputType:"button",value: $("#info").val()};
		value.recordTime={ inputType:"date_input", value: $("#recordTime").val() ,matchType:"auto"};
		value.notes={ inputType:"button",value: $("#notes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
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
			admin.putTempData('ops-monitor-node-host-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('节点主机')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('节点主机')+fox.translate('吗？'), function (i) {
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

			admin.putTempData('ops-monitor-node-host-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('ops-monitor-node-host-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						 top.layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			} else if (layEvent === 'view') { // 查看
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('ops-monitor-node-host-form-data-form-action', "view",true);
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
				top.layer.confirm(fox.translate('确定删除此')+fox.translate('节点主机')+fox.translate('吗？'), function (i) {
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
		var action=admin.getTempData('ops-monitor-node-host-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString='id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('ops-monitor-node-host-form-data', data);
		var area=admin.getTempData('ops-monitor-node-host-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('节点主机');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["800px",height+"px"],
			type: 2,
			id:"ops-monitor-node-host-form-data-win",
			content: '/business/ops/monitor_node_host/monitor_node_host_form.html' + (queryString?("?"+queryString):""),
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