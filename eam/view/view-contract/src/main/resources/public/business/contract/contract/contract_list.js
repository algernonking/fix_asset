/**
 * 合同 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-12-20 16:12:42
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-contract/cont-contract";
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
					,{ field: 'contractNo', align:"left",fixed:true,  hide:false, sort: true, title: fox.translate('合同编号') , templet: function (d) { return templet('contractNo',d.contractNo,d);}  }
					,{ field: 'title', align:"left",fixed:true,  hide:false, sort: true, title: fox.translate('合同抬头') , templet: function (d) { return templet('title',d.title,d);}  }
					,{ field: 'type', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('合同类型'), templet:function (d){ return templet('type',fox.getEnumText(SELECT_TYPE_DATA,d.type),d);}}
					,{ field: 'catalogCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('合同分类'), templet:function (d){ return templet('catalogCode',fox.getDictText(SELECT_CATALOGCODE_DATA,d.catalogCode),d);}}
					,{ field: 'signingDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('签订日期') ,templet: function (d) { return templet('signingDate',fox.dateFormat(d.signingDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'contractStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('合同状态'), templet:function (d){ return templet('contractStatus',fox.getEnumText(SELECT_CONTRACTSTATUS_DATA,d.contractStatus),d);}}
					,{ field: 'departmentId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('归属部门') , templet: function (d) { return templet('departmentId',d.departmentId,d);}  }
					,{ field: 'fundingStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资金状态'), templet:function (d){ return templet('fundingStatus',fox.getEnumText(SELECT_FUNDINGSTATUS_DATA,d.fundingStatus),d);}}
					,{ field: 'effectiveDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('生效日期') ,templet: function (d) { return templet('effectiveDate',fox.dateFormat(d.effectiveDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'parentId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('上级合同ID') , templet: function (d) { return templet('parentId',d.parentId,d);}  }
					,{ field: 'deliverables', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('交付物') , templet: function (d) { return templet('deliverables',d.deliverables,d);}  }
					,{ field: 'deliveryLocation', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('交付地') , templet: function (d) { return templet('deliveryLocation',d.deliveryLocation,d);}  }
					,{ field: 'amount', align:"right",fixed:false,  hide:true, sort: true, title: fox.translate('合同金额') , templet: function (d) { return templet('amount',d.amount,d);}  }
					,{ field: 'summary', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('摘要信息') , templet: function (d) { return templet('summary',d.summary,d);}  }
					,{ field: 'endDate', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('结束日期') ,templet: function (d) { return templet('endDate',fox.dateFormat(d.endDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'expirationDate', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('失效日期') ,templet: function (d) { return templet('expirationDate',fox.dateFormat(d.expirationDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'fundingDirection', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('资金流向'), templet:function (d){ return templet('fundingDirection',fox.getDictText(SELECT_FUNDINGDIRECTION_DATA,d.fundingDirection),d);}}
					,{ field: 'createTime', align:"right", fixed:false, hide:true, sort: true, title: fox.translate('创建时间') ,templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
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
		value.contractNo={ inputType:"button",value: $("#contractNo").val()};
		value.title={ inputType:"button",value: $("#title").val()};
		value.contractStatus={ inputType:"select_box", value: xmSelect.get("#contractStatus",true).getValue("value"), label:xmSelect.get("#contractStatus",true).getValue("nameStr") };
		value.signingDate={ inputType:"date_input", value: $("#signingDate").val() ,matchType:"auto"};
		value.effectiveDate={ inputType:"date_input", value: $("#effectiveDate").val() ,matchType:"auto"};
		value.departmentId={ inputType:"button",value: $("#departmentId").val(),label:$("#departmentId-button").text() };
		value.fundingStatus={ inputType:"select_box", value: xmSelect.get("#fundingStatus",true).getValue("value"), label:xmSelect.get("#fundingStatus",true).getValue("nameStr") };
		value.catalogCode={ inputType:"select_box", value: xmSelect.get("#catalogCode",true).getValue("value"), label:xmSelect.get("#catalogCode",true).getValue("nameStr") };
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

		//渲染 contractStatus 下拉字段
		fox.renderSelectBox({
			el: "contractStatus",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("contractStatus",data.arr,data.change,data.isAdd);
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
			elem: '#signingDate',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("signingDate",value, date, endDate);
				},1);
			}
		});
		laydate.render({
			elem: '#effectiveDate',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("effectiveDate",value, date, endDate);
				},1);
			}
		});
		//渲染 fundingStatus 下拉字段
		fox.renderSelectBox({
			el: "fundingStatus",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("fundingStatus",data.arr,data.change,data.isAdd);
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
		//渲染 catalogCode 下拉字段
		fox.renderSelectBox({
			el: "catalogCode",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("catalogCode",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].text,value:data[i].code});
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

		// 请选择组织节点对话框
		$("#departmentId-button").click(function(){
			var departmentIdDialogOptions={
				field:"departmentId",
				inputEl:$("#departmentId"),
				buttonEl:$(this),
				single:false,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				prepose:function(param){ return window.pageExt.list.beforeDialog && window.pageExt.list.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.list.afterDialog && window.pageExt.list.afterDialog(param,result);}
			};
			fox.chooseOrgNode(departmentIdDialogOptions);
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

			admin.putTempData('cont-contract-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('cont-contract-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						 top.layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
			} else if (layEvent === 'view') { // 查看
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('cont-contract-form-data-form-action', "view",true);
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
			else if(obj.event === 'ops-more'){
				//更多下拉菜单
				dropdown.render({
					elem: this
					,show: true //外部事件触发即显示
					,data: [{"id":"subs","title":"子合同"},{"id":"addi","title":"附加协议"}]
					,click: function(menu, othis){
						if(menu.perm && !admin.checkAuth(menu.perm)) {
							top.layer.msg(fox.translate('缺少操作权限'), {icon: 2, time: 1500});
							return;
						}
						window.pageExt.list.moreAction && window.pageExt.list.moreAction(menu,data, othis);
					}
					,align: 'right'
					,style: 'box-shadow: 1px 1px 10px rgb(0 0 0 / 12%);'
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

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["800px",height+"px"],
			type: 2,
			id:"cont-contract-form-data-win",
			content: '/business/contract/contract/contract_form.html' + queryString,
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