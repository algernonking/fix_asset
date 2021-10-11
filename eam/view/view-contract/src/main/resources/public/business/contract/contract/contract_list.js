/**
 * 合同 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-11 22:39:06
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-contract/cont-contract";
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
					,{ field: 'id', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('合同名称') , templet: function (d) { return templet('name',d.name,d);}  }
					,{ field: 'code', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('合同编号') , templet: function (d) { return templet('code',d.code,d);}  }
					,{ field: 'state', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('合同状态') , templet: function (d) { return templet('state',d.state,d);}  }
					,{ field: 'fundStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资金状态') , templet: function (d) { return templet('fundStatus',d.fundStatus,d);}  }
					,{ field: 'categoryId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('合同类型') , templet: function (d) { return templet('categoryId',d.categoryId,d);}  }
					,{ field: 'identity', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('我方身份') , templet: function (d) { return templet('identity',d.identity,d);}  }
					,{ field: 'fundDirect', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资金流向') , templet: function (d) { return templet('fundDirect',d.fundDirect,d);}  }
					,{ field: 'money', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('金额') , templet: function (d) { return templet('money',d.money,d);}  }
					,{ field: 'allmoney', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('总金额') , templet: function (d) { return templet('allmoney',d.allmoney,d);}  }
					,{ field: 'userId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('承办人') , templet: function (d) { return templet('userId',d.userId,d);}  }
					,{ field: 'deptId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('承办人部门') , templet: function (d) { return templet('deptId',d.deptId,d);}  }
					,{ field: 'biddingId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('关联招标') , templet: function (d) { return templet('biddingId',d.biddingId,d);}  }
					,{ field: 'firstCompanyName', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('我方单位') , templet: function (d) { return templet('firstCompanyName',d.firstCompanyName,d);}  }
					,{ field: 'firstContacts', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('我方联系人') , templet: function (d) { return templet('firstContacts',d.firstContacts,d);}  }
					,{ field: 'firstContactInformation', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('我方联系方式') , templet: function (d) { return templet('firstContactInformation',d.firstContactInformation,d);}  }
					,{ field: 'relatedCompanyId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('对方单位') , templet: function (d) { return templet('relatedCompanyId',d.relatedCompanyId,d);}  }
					,{ field: 'relatedCompanyName', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('对方单位') , templet: function (d) { return templet('relatedCompanyName',d.relatedCompanyName,d);}  }
					,{ field: 'relatedContacts', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('对方单位联系人') , templet: function (d) { return templet('relatedContacts',d.relatedContacts,d);}  }
					,{ field: 'relatedContactInformation', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('对方单位联系方式') , templet: function (d) { return templet('relatedContactInformation',d.relatedContactInformation,d);}  }
					,{ field: 'supervisionUnit', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('监理单位') , templet: function (d) { return templet('supervisionUnit',d.supervisionUnit,d);}  }
					,{ field: 'supervisionContacts', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('监理人') , templet: function (d) { return templet('supervisionContacts',d.supervisionContacts,d);}  }
					,{ field: 'supervisionContactInformation', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('监理联系方式') , templet: function (d) { return templet('supervisionContactInformation',d.supervisionContactInformation,d);}  }
					,{ field: 'effectTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('生效时间'), templet: function (d) { return templet('effectTime',fox.dateFormat(d.effectTime,"yyyy-MM-dd HH:mm:ss"),d); }}
					,{ field: 'lostEffectTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('失效时间'), templet: function (d) { return templet('lostEffectTime',fox.dateFormat(d.lostEffectTime,"yyyy-MM-dd HH:mm:ss"),d); }}
					,{ field: 'endTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('结束时间'), templet: function (d) { return templet('endTime',fox.dateFormat(d.endTime,"yyyy-MM-dd HH:mm:ss"),d); }}
					,{ field: 'auditTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('签订时间'), templet: function (d) { return templet('auditTime',fox.dateFormat(d.auditTime,"yyyy-MM-dd HH:mm:ss"),d); }}
					,{ field: 'notes', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('备注') , templet: function (d) { return templet('notes',d.notes,d);}  }
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
		value.code={ inputType:"button",value: $("#code").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.state={ inputType:"button",value: $("#state").val()};
		value.fundStatus={ inputType:"button",value: $("#fundStatus").val()};
		value.firstCompanyName={ inputType:"button",value: $("#firstCompanyName").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.relatedCompanyId={ inputType:"button",value: $("#relatedCompanyId").val()};
		value.relatedCompanyName={ inputType:"button",value: $("#relatedCompanyName").val() ,fuzzy: true,valuePrefix:"",valueSuffix:" "};
		value.effectTime={ inputType:"date_input", value: $("#effectTime").val()};
		value.lostEffectTime={ inputType:"date_input", value: $("#lostEffectTime").val()};
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

		laydate.render({
			elem: '#effectTime',
			trigger:"click"
		});
		laydate.render({
			elem: '#lostEffectTime',
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
			admin.putTempData('cont-contract-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('合同')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('合同')+fox.translate('吗？'), function (i) {
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

			admin.putTempData('cont-contract-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						admin.putTempData('cont-contract-form-data-form-action', "edit",true);
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
						admin.putTempData('cont-contract-form-data-form-action', "view",true);
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

				top.layer.confirm(fox.translate('确定删除此')+fox.translate('合同')+fox.translate('吗？'), function (i) {
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
		var action=admin.getTempData('cont-contract-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString="?" + 'id=' + data.id;
		admin.putTempData('cont-contract-form-data', data);
		var area=admin.getTempData('cont-contract-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('合同');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["95%",height+"px"],
			type: 2,
			id:"cont-contract-form-data-win",
			content: '/business/contract/contract/contract_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('cont-contract-form-data-popup-index', index);
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