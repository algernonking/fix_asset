/**
 * 信息系统 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 12:15:14
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-ops/ops-information-system";
	var dataTable=null;
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
					{ fixed: 'left',type:'checkbox' }
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'pid', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('父节点') , templet: function (d) { return templet('pid',d.pid,d);}  }
					,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('名称') , templet: function (d) { return templet('name',d.name,d);}  }
					,{ field: 'profile', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('介绍') , templet: function (d) { return templet('profile',d.profile,d);}  }
					,{ field: 'status', align:"left", fixed:false, hide:false, sort: true, title: fox.translate('状态'), templet:function (d){ return templet('status',fox.getDictText(RADIO_STATUS_DATA,d.status),d);}}
					,{ field: 'opsMethod', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('运维模式'), templet:function (d){ return templet('opsMethod',fox.getDictText(SELECT_OPSMETHOD_DATA,d.opsMethod),d);}}
					,{ field: 'devMethod', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('开发模式'), templet:function (d){ return templet('devMethod',fox.getDictText(SELECT_DEVMETHOD_DATA,d.devMethod),d);}}
					,{ field: 'technicalContact', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('技术联系人') , templet: function (d) { return templet('technicalContact',d.technicalContact,d);}  }
					,{ field: 'businessContact', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('业务联系人') , templet: function (d) { return templet('businessContact',d.businessContact,d);}  }
					,{ field: 'belongOrgId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('所属公司/部门') , templet: function (d) { return templet('belongOrgId',fox.getProperty(d,["belongOrganization","fullName"]),d);} }
					,{ field: 'lastdrillDate', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('演练时间'), templet: function (d) { return templet('lastdrillDate',fox.dateFormat(d.lastdrillDate),d); }}
					,{ field: 'onlineDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('上线时间'), templet: function (d) { return templet('onlineDate',fox.dateFormat(d.onlineDate),d); }}
					,{ field: 'offlineDate', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('下线时间'), templet: function (d) { return templet('offlineDate',fox.dateFormat(d.offlineDate),d); }}
					,{ field: 'osInfo', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('操作系统') , templet: function (d) { return templet('osInfo',d.osInfo,d);}  }
					,{ field: 'dbInfo', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('数据库') , templet: function (d) { return templet('dbInfo',d.dbInfo,d);}  }
					,{ field: 'appInfo', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('应用') , templet: function (d) { return templet('appInfo',d.appInfo,d);}  }
					,{ field: 'grade', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('系统分级'), templet:function (d){ return templet('grade',fox.getDictText(SELECT_GRADE_DATA,d.grade),d);}}
					,{ field: 'rto', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('RTO') , templet: function (d) { return templet('rto',d.rto,d);}  }
					,{ field: 'rpo', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('RPO') , templet: function (d) { return templet('rpo',d.rpo,d);}  }
					,{ field: 'hardwareInfo', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('硬件信息') , templet: function (d) { return templet('hardwareInfo',d.hardwareInfo,d);}  }
					,{ field: 'backupInfo', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('备份信息') , templet: function (d) { return templet('backupInfo',d.backupInfo,d);}  }
					,{ field: 'sameplaceBacupInfo', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('本地备份') , templet: function (d) { return templet('sameplaceBacupInfo',d.sameplaceBacupInfo,d);}  }
					,{ field: 'diffplaceBackupInfo', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('异地备份') , templet: function (d) { return templet('diffplaceBackupInfo',d.diffplaceBackupInfo,d);}  }
					,{ field: 'archMethod', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('归档模式') , templet: function (d) { return templet('archMethod',d.archMethod,d);}  }
					,{ field: 'labels', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('标签') , templet: function (d) { return templet('labels',d.labels,d);}  }
					,{ field: 'notes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('备注') , templet: function (d) { return templet('notes',d.notes,d);}  }
					,{ field: 'voucherIds', align:"",fixed:false,  hide:false, sort: false, title: fox.translate('用户凭证'), templet: function (d) { return templet('voucherIds',fox.joinLabel(d.voucherList,"voucher"),d);}}
					,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 290 }
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
	function refreshTableData(sortField,sortType) {
		var value = {};
		value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.status={ inputType:"radio_box", value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr")};
		value.technicalContact={ inputType:"button",value: $("#technicalContact").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.businessContact={ inputType:"button",value: $("#businessContact").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.belongOrgId={ inputType:"button",value: $("#belongOrgId").val(),fillBy:["belongOrganization","fullName"] ,label:$("#belongOrgId-button").text()};
		value.grade={ inputType:"select_box", value: xmSelect.get("#grade",true).getValue("value"), label:xmSelect.get("#grade",true).getValue("nameStr")};
		value.labels={ inputType:"button",value: $("#labels").val()};
		value.notes={ inputType:"button",value: $("#notes").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		var ps={searchField:"$composite"};
		if(window.pageExt.list.beforeQuery){
			if(!window.pageExt.list.beforeQuery(value,ps,"refresh")) return;
		}
		ps.searchValue=JSON.stringify(value);
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

		//渲染 status 搜索框
		fox.renderSelectBox({
			el: "status",
			size: "small",
			radio: false,
			//toolbar: {show:true,showIcon:true,list:["CLEAR","REVERSE"]},
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
		//渲染 grade 下拉字段
		fox.renderSelectBox({
			el: "grade",
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

		// 请选择组织节点对话框
		$("#belongOrgId-button").click(function(){
			var belongOrgIdDialogOptions={
				field:"belongOrgId",
				inputEl:$("#belongOrgId"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param);}
			};
			fox.chooseOrgNode(belongOrgIdDialogOptions);
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
			admin.putTempData('ops-information-system-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('信息系统')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('信息系统')+fox.translate('吗？'), function (i) {
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

			admin.putTempData('ops-information-system-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('ops-information-system-form-data-form-action', "edit",true);
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
						admin.putTempData('ops-information-system-form-data-form-action', "view",true);
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

				top.layer.confirm(fox.translate('确定删除此')+fox.translate('信息系统')+fox.translate('吗？'), function (i) {
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
			else if (layEvent === 'open-system-voucher-window') { // 凭证
				window.pageExt.list.openSystemVoucherWindow(data);
			}
			else if (layEvent === 'open-host-window') { // 主机
				window.pageExt.list.openHostWindow(data);
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
		var action=admin.getTempData('ops-information-system-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString="?" + 'id=' + data.id;
		admin.putTempData('ops-information-system-form-data', data);
		var area=admin.getTempData('ops-information-system-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('信息系统');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["90%",height+"px"],
			type: 2,
			id:"ops-information-system-form-data-win",
			content: '/business/ops/information_system/information_system_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('ops-information-system-form-data-popup-index', index);
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