/**
 * 主机 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:28:35
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-ops/ops-host";
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
					,{ field: 'systemId', align:"left",fixed:false,  hide:false, sort: false, title: fox.translate('信息系统'), templet: function (d) { return templet('systemId' ,fox.joinLabel(d.infoSystem,"name"),d);}}
					,{ field: 'hostType', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机类型'), templet:function (d){ return templet('hostType',fox.getDictText(SELECT_HOSTTYPE_DATA,d.hostType),d);}}
					,{ field: 'status', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机状态'), templet:function (d){ return templet('status',fox.getEnumText(RADIO_STATUS_DATA,d.status),d);}}
					,{ field: 'hostName', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('名称') , templet: function (d) { return templet('hostName',d.hostName,d);}  }
					,{ field: 'hostIp', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('物理IP') , templet: function (d) { return templet('hostIp',d.hostIp,d);}  }
					,{ field: 'hostVip', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('虚拟VIP') , templet: function (d) { return templet('hostVip',d.hostVip,d);}  }
					,{ field: 'environment', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('所在环境'), templet:function (d){ return templet('environment',fox.getDictText(SELECT_ENVIRONMENT_DATA,d.environment),d);}}
					,{ field: 'positionId', align:"left",fixed:false,  hide:false, sort: false, title: fox.translate('所在位置'), templet: function (d) { return templet('positionId' ,fox.joinLabel(d.position,"name"),d);}}
					,{ field: 'monitorStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('监控状态'), templet:function (d){ return templet('monitorStatus',fox.getEnumText(RADIO_MONITORSTATUS_DATA,d.monitorStatus),d);}}
					,{ field: 'directorUsername', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('负责人') , templet: function (d) { return templet('directorUsername',d.directorUsername,d);}  }
					,{ field: 'hostMemory', align:"right",fixed:false,  hide:true, sort: true, title: fox.translate('内存') , templet: function (d) { return templet('hostMemory',d.hostMemory,d);}  }
					,{ field: 'hostCpu', align:"right",fixed:false,  hide:true, sort: true, title: fox.translate('CPU') , templet: function (d) { return templet('hostCpu',d.hostCpu,d);}  }
					,{ field: 'hostConf', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('其他配置') , templet: function (d) { return templet('hostConf',d.hostConf,d);}  }
					,{ field: 'userOsAdmin', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('系统管理员') , templet: function (d) { return templet('userOsAdmin',d.userOsAdmin,d);}  }
					,{ field: 'userDbAdmin', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('数据库管理员') , templet: function (d) { return templet('userDbAdmin',d.userDbAdmin,d);}  }
					,{ field: 'userDbUsed', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('数据库使用用户') , templet: function (d) { return templet('userDbUsed',d.userDbUsed,d);}  }
					,{ field: 'userAppUsed', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('应用使用用户') , templet: function (d) { return templet('userAppUsed',d.userAppUsed,d);}  }
					,{ field: 'userOpsOper', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('运维操作用户') , templet: function (d) { return templet('userOpsOper',d.userOpsOper,d);}  }
					,{ field: 'userOther', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('其他用户') , templet: function (d) { return templet('userOther',d.userOther,d);}  }
					,{ field: 'passwordStrategyId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('改密策略'), templet:function (d){ return templet('passwordStrategyId',fox.getDictText(SELECT_PASSWORDSTRATEGYID_DATA,d.passwordStrategyId),d);}}
					,{ field: 'hostBackupMethod', align:"left",fixed:false,  hide:false, sort: false, title: fox.translate('备份方式'), templet: function (d) { return templet('hostBackupMethod' ,fox.joinLabel(d.backupMethod,"label"),d);}}
					,{ field: 'hostBackupInfo', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('备份情况') , templet: function (d) { return templet('hostBackupInfo',d.hostBackupInfo,d);}  }
					,{ field: 'offlineTime', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('下线时间'), templet: function (d) { return templet('offlineTime',fox.dateFormat(d.offlineTime,"yyyy-MM-dd"),d); }}
					,{ field: 'onlineTime', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('上线时间'), templet: function (d) { return templet('onlineTime',fox.dateFormat(d.onlineTime,"yyyy-MM-dd"),d); }}
					,{ field: 'labels', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('标签') , templet: function (d) { return templet('labels',d.labels,d);}  }
					,{ field: 'hostNotes', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('备注') , templet: function (d) { return templet('hostNotes',d.hostNotes,d);}  }
					,{ field: 'createTime', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('创建时间'), templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime,"yyyy-MM-dd HH:mm:ss"),d); }}
					,{ field: 'hostDbIds', align:"",fixed:false,  hide:false, sort: false, title: fox.translate('数据库'), templet: function (d) { return templet('hostDbIds' ,fox.joinLabel(d.hostDbList,"name"),d);}}
					,{ field: 'hostMiddlewareIds', align:"",fixed:false,  hide:false, sort: false, title: fox.translate('中间件'), templet: function (d) { return templet('hostMiddlewareIds' ,fox.joinLabel(d.hostMiddlewareList,"name"),d);}}
					,{ field: 'hostOsIds', align:"",fixed:false,  hide:false, sort: false, title: fox.translate('操作系统'), templet: function (d) { return templet('hostOsIds' ,fox.joinLabel(d.hostOsList,"name"),d);}}
					,{ field: 'voucherIds', align:"",fixed:false,  hide:false, sort: false, title: fox.translate('用户凭证'), templet: function (d) { return templet('voucherIds' ,fox.joinLabel(d.voucherList,"voucher"),d);}}
					,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 250 }
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
		value.systemId={ inputType:"select_box", value: xmSelect.get("#systemId",true).getValue("value") ,fillBy:["infoSystem"]  , label:xmSelect.get("#systemId",true).getValue("nameStr") };
		value.status={ inputType:"radio_box", value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr") };
		value.hostName={ inputType:"button",value: $("#hostName").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.hostIp={ inputType:"button",value: $("#hostIp").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.hostVip={ inputType:"button",value: $("#hostVip").val() ,fuzzy: true,valuePrefix:"",valueSuffix:"" };
		value.environment={ inputType:"select_box", value: xmSelect.get("#environment",true).getValue("value"), label:xmSelect.get("#environment",true).getValue("nameStr") };
		value.positionId={ inputType:"select_box", value: xmSelect.get("#positionId",true).getValue("value") ,fillBy:["position"]  , label:xmSelect.get("#positionId",true).getValue("nameStr") };
		value.labels={ inputType:"button",value: $("#labels").val()};
		value.hostNotes={ inputType:"button",value: $("#hostNotes").val()};
		value.hostDbIds={ inputType:"select_box", value: xmSelect.get("#hostDbIds",true).getValue("value") ,fillBy:["hostDbList"]  , label:xmSelect.get("#hostDbIds",true).getValue("nameStr") };
		value.hostMiddlewareIds={ inputType:"select_box", value: xmSelect.get("#hostMiddlewareIds",true).getValue("value") ,fillBy:["hostMiddlewareList"]  , label:xmSelect.get("#hostMiddlewareIds",true).getValue("nameStr") };
		value.hostOsIds={ inputType:"select_box", value: xmSelect.get("#hostOsIds",true).getValue("value") ,fillBy:["hostOsList"]  , label:xmSelect.get("#hostOsIds",true).getValue("nameStr") };
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

		//渲染 systemId 下拉字段
		fox.renderSelectBox({
			el: "systemId",
			radio: false,
			size: "small",
			filterable: true,
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
		//渲染 status 搜索框
		fox.renderSelectBox({
			el: "status",
			size: "small",
			radio: false,
			//toolbar: {show:true,showIcon:true,list:["CLEAR","REVERSE"]},
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
		//渲染 environment 下拉字段
		fox.renderSelectBox({
			el: "environment",
			radio: false,
			size: "small",
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].text,value:data[i].code});
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
		//渲染 hostDbIds 下拉字段
		fox.renderSelectBox({
			el: "hostDbIds",
			radio: false,
			size: "small",
			filterable: true,
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
		//渲染 hostMiddlewareIds 下拉字段
		fox.renderSelectBox({
			el: "hostMiddlewareIds",
			radio: false,
			size: "small",
			filterable: true,
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
		//渲染 hostOsIds 下拉字段
		fox.renderSelectBox({
			el: "hostOsIds",
			radio: false,
			size: "small",
			filterable: true,
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
				case 'tool-export-host':
					window.pageExt.list.exportHost && window.pageExt.list.exportHost(selected,obj);
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
			admin.putTempData('ops-host-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('主机')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('主机')+fox.translate('吗？'), function (i) {
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

			if(window.pageExt.list.beforeRowOperationEvent) {
				var doNext=window.pageExt.list.beforeRowOperationEvent(data,obj);
				if(!doNext) return;
			}

			admin.putTempData('ops-host-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('ops-host-form-data-form-action', "edit",true);
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
						admin.putTempData('ops-host-form-data-form-action', "view",true);
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

				top.layer.confirm(fox.translate('确定删除此')+fox.translate('主机')+fox.translate('吗？'), function (i) {
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
			else if (layEvent === 'open-host-voucher-window') { // 凭证
				window.pageExt.list.openHostVoucherWindow(data);
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
		var action=admin.getTempData('ops-host-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString="?" + 'id=' + data.id;
		admin.putTempData('ops-host-form-data', data);
		var area=admin.getTempData('ops-host-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('主机');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["98%",height+"px"],
			type: 2,
			id:"ops-host-form-data-win",
			content: '/business/ops/host/host_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('ops-host-form-data-popup-index', index);
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