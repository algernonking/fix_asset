/**
 * 资产设备数据 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-05 12:19:50
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-eam/eam-asset-ext-equipment";
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
					return value;
				}
			}
			var h=$(".search-bar").height();
			dataTable=fox.renderTable({
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
					,{ field: 'assetId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产') , templet: function (d) { return templet('assetId',d.assetId,d);}  }
					,{ field: 'equipmentCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备编号') , templet: function (d) { return templet('equipmentCode',d.equipmentCode,d);}  }
					,{ field: 'equipmentStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备状态') , templet: function (d) { return templet('equipmentStatus',d.equipmentStatus,d);}  }
					,{ field: 'equipmentIp', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备IP') , templet: function (d) { return templet('equipmentIp',d.equipmentIp,d);}  }
					,{ field: 'manageIp', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('管理IP') , templet: function (d) { return templet('manageIp',d.manageIp,d);}  }
					,{ field: 'equipmentCpu', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备CPU') , templet: function (d) { return templet('equipmentCpu',d.equipmentCpu,d);}  }
					,{ field: 'equipmentMemory', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备内存') , templet: function (d) { return templet('equipmentMemory',d.equipmentMemory,d);}  }
					,{ field: 'layerId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('层级') , templet: function (d) { return templet('layerId',d.layerId,d);}  }
					,{ field: 'areaId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('区域') , templet: function (d) { return templet('areaId',d.areaId,d);}  }
					,{ field: 'rackId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('机柜'), templet: function (d) { return templet('rackId',fox.joinLabel(d.rack,"rackName"),d);}}
					,{ field: 'rackUpNumber', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('机柜上位置') , templet: function (d) { return templet('rackUpNumber',d.rackUpNumber,d);}  }
					,{ field: 'rackDownNumber', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('机柜下位置') , templet: function (d) { return templet('rackDownNumber',d.rackDownNumber,d);}  }
					,{ field: 'pdu', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('PDU接口') , templet: function (d) { return templet('pdu',d.pdu,d);}  }
					,{ field: 'equipmentNotes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('备注') , templet: function (d) { return templet('equipmentNotes',d.equipmentNotes,d);}  }
					,{ field: 'equipmentDesc', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('描述') , templet: function (d) { return templet('equipmentDesc',d.equipmentDesc,d);}  }
					,{ field: 'createTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('创建时间'), templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime),d); }}
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
		value.equipmentIp={ value: $("#equipmentIp").val()};
		value.manageIp={ value: $("#manageIp").val()};
		value.rackId={ value: xmSelect.get("#rackId",true).getValue("value"), fillBy:"rack",field:"id", label:xmSelect.get("#rackId",true).getValue("nameStr") };
		value.equipmentNotes={ value: $("#equipmentNotes").val()};
		value.equipmentDesc={ value: $("#equipmentDesc").val()};
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

		//渲染 rackId 下拉字段
		fox.renderSelectBox({
			el: "rackId",
			radio: false,
			size: "small",
			filterable: false,
			toolbar: {show:true,showIcon:true,list:["CLEAR","REVERSE"]},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].rackName,value:data[i].id});
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
			admin.putTempData('eam-asset-ext-equipment-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('资产设备数据')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('资产设备数据')+fox.translate('吗？'), function (i) {
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
			admin.putTempData('eam-asset-ext-equipment-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('eam-asset-ext-equipment-form-data-form-action', "edit",true);
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
						admin.putTempData('eam-asset-ext-equipment-form-data-form-action', "view",true);
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

				top.layer.confirm(fox.translate('确定删除此')+fox.translate('资产设备数据')+fox.translate('吗？'), function (i) {
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
		var queryString="";
		if(data && data.id) queryString="?" + 'id=' + data.id;
		admin.putTempData('eam-asset-ext-equipment-form-data', data);
		var area=admin.getTempData('eam-asset-ext-equipment-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = (data && data.id) ? (fox.translate('修改')+fox.translate('资产设备数据')) : (fox.translate('添加')+fox.translate('资产设备数据'));
		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["85%",height+"px"],
			type: 2,
			id:"eam-asset-ext-equipment-form-data-win",
			content: '/business/eam/asset_ext_equipment/asset_ext_equipment_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('eam-asset-ext-equipment-form-data-popup-index', index);
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