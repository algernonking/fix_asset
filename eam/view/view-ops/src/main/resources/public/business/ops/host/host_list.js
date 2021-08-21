/**
 * 主机 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-21 10:04:08
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-ops/ops-host";
	var dataTable=null;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
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
			window.pageExt.list.beforeQuery && window.pageExt.list.beforeQuery(contitions);
			if(Object.keys(contitions).length>0) {
				ps = {searchField: "$composite", searchValue: JSON.stringify(contitions)};
			}

			var h=$(".search-bar").height();
			dataTable=fox.renderTable({
				elem: '#data-table',
				toolbar: '#toolbarTemplate',
				defaultToolbar: ['filter', 'print'],
				url: moduleURL +'/query-paged-list',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' },
					{ fixed: 'left',type:'checkbox' }
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('主键') }
					,{ field: 'systemId', align:"left",fixed:false,  hide:false, sort: false, title: fox.translate('信息系统'), templet: function (d) { return fox.joinLabel(d.infoSystem,"name");}}
					,{ field: 'hostType', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机类型'), templet:function (d){ return fox.getDictText(SELECT_HOSTTYPE_DATA,d.hostType);}}
					,{ field: 'status', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主机状态'), templet:function (d){ return fox.getEnumText(RADIO_STATUS_DATA,d.status);}}
					,{ field: 'hostName', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('名称') }
					,{ field: 'hostIp', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('物理IP') }
					,{ field: 'hostVip', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('虚拟VIP') }
					,{ field: 'environment', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('所在环境'), templet:function (d){ return fox.getDictText(SELECT_ENVIRONMENT_DATA,d.environment);}}
					,{ field: 'positionId', align:"left",fixed:false,  hide:false, sort: false, title: fox.translate('所在位置'), templet: function (d) { return fox.joinLabel(d.position,"name");}}
					,{ field: 'monitorStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('监控状态'), templet:function (d){ return fox.getEnumText(RADIO_MONITORSTATUS_DATA,d.monitorStatus);}}
					,{ field: 'directorUsername', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('负责人') }
					,{ field: 'hostMemory', align:"right",fixed:false,  hide:true, sort: true, title: fox.translate('内存') }
					,{ field: 'hostCpu', align:"right",fixed:false,  hide:true, sort: true, title: fox.translate('CPU') }
					,{ field: 'hostConf', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('其他配置') }
					,{ field: 'userOsAdmin', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('系统管理员') }
					,{ field: 'userDbAdmin', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('数据库管理员') }
					,{ field: 'userDbUsed', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('数据库使用用户') }
					,{ field: 'userAppUsed', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('应用使用用户') }
					,{ field: 'userOpsOper', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('运维操作用户') }
					,{ field: 'userOther', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('其他用户') }
					,{ field: 'passwordStrategyId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('改密策略'), templet:function (d){ return fox.getDictText(SELECT_PASSWORDSTRATEGYID_DATA,d.passwordStrategyId);}}
					,{ field: 'offlineTime', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('下线时间'), templet: function (d) { return fox.dateFormat(d.offlineTime); }}
					,{ field: 'onlineTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('上线时间'), templet: function (d) { return fox.dateFormat(d.onlineTime); }}
					,{ field: 'labels', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('标签') }
					,{ field: 'hostNotes', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('备注') }
					,{ field: 'createTime', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('创建时间'), templet: function (d) { return fox.dateFormat(d.createTime); }}
					,{ field: 'hostDbIds', align:"",fixed:false,  hide:false, sort: false, title: fox.translate('数据库'), templet: function (d) { return fox.joinLabel(d.hostDbList,"name");}}
					,{ field: 'hostMiddlewareIds', align:"",fixed:false,  hide:false, sort: false, title: fox.translate('中间件'), templet: function (d) { return fox.joinLabel(d.hostMiddlewareList,"name");}}
					,{ field: 'hostOsIds', align:"",fixed:false,  hide:false, sort: false, title: fox.translate('操作系统'), templet: function (d) { return fox.joinLabel(d.hostOsList,"name");}}
					,{ field: fox.translate('空白列'), align:"center", hide:false, sort: false, title: "",minWidth:8,width:8,unresize:true}
					,{ field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 160 }
				]],
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
    };

	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType) {
		var value = {};
		value.systemId={ value: xmSelect.get("#systemId",true).getValue("value"), fillBy:"infoSystem",field:"id", label:xmSelect.get("#systemId",true).getValue("nameStr") };
		value.status={ value: xmSelect.get("#status",true).getValue("value"), label:xmSelect.get("#status",true).getValue("nameStr")};
		value.hostName={ value: $("#hostName").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.hostIp={ value: $("#hostIp").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.hostVip={ value: $("#hostVip").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.environment={ value: xmSelect.get("#environment",true).getValue("value"), label:xmSelect.get("#environment",true).getValue("nameStr")};
		value.positionId={ value: xmSelect.get("#positionId",true).getValue("value"), fillBy:"position",field:"id", label:xmSelect.get("#positionId",true).getValue("nameStr") };
		value.labels={ value: $("#labels").val()};
		value.hostNotes={ value: $("#hostNotes").val()};
		value.hostDbIds={ value: xmSelect.get("#hostDbIds",true).getValue("value"), fillBy:"hostDbList",field:"id", label:xmSelect.get("#hostDbIds",true).getValue("nameStr") };
		value.hostMiddlewareIds={ value: xmSelect.get("#hostMiddlewareIds",true).getValue("value"), fillBy:"hostMiddlewareList",field:"id", label:xmSelect.get("#hostMiddlewareIds",true).getValue("nameStr") };
		value.hostOsIds={ value: xmSelect.get("#hostOsIds",true).getValue("value"), fillBy:"hostOsList",field:"id", label:xmSelect.get("#hostOsIds",true).getValue("nameStr") };
		window.pageExt.list.beforeQuery && window.pageExt.list.beforeQuery(value);
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
			switch(obj.event){
				case 'create':
					openCreateFrom();
					break;
				case 'batch-del':
					batchDelete();
					break;
				case 'other':
					break;
					//自定义头工具栏右侧图标 - 提示
				case 'LAYTABLE_TIPS':
					layer.alert('这是工具栏右侧自定义的一个图标按钮');
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
        function batchDelete() {
          
			var ids=getCheckedList("id");
            if(ids.length==0) {
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('主机')+"!");
            	return;
            }
            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('主机')+fox.translate('吗？'), function (i) {
				layer.close(i);
				layer.load(2);
                admin.request(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
                    layer.closeAll('loading');
                    if (data.success) {
                        layer.msg(data.message, {icon: 1, time: 500});
                        refreshTableData();
                    } else {
                        layer.msg(data.message, {icon: 2, time: 1500});
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
			} else if (layEvent === 'view') { // 修改
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
			
				layer.confirm(fox.translate('确定删除此')+fox.translate('主机')+fox.translate('吗？'), function (i) {
					layer.close(i);
					layer.load(2);
					admin.request(moduleURL+"/delete", { id : data.id }, function (data) {
						layer.closeAll('loading');
						if (data.success) {
							layer.msg(data.message, {icon: 1, time: 500});
							refreshTableData();
						} else {
							layer.msg(data.message, {icon: 2, time: 1500});
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
		var queryString="";
		if(data && data.id) queryString="?" + 'id=' + data.id;
		admin.putTempData('ops-host-form-data', data);
		var area=admin.getTempData('ops-host-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = (data && data.id) ? (fox.translate('修改')+fox.translate('主机')) : (fox.translate('添加')+fox.translate('主机'));
		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["1000px",height+"px"],
			type: 2,
			content: '/business/ops/host/host_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('ops-host-form-data-popup-index', index);
	};

};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new ListPage()).init(layui);
	},1);
});