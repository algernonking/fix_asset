/**
 * 车辆维修保养 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-02 06:01:08
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-vehicle/vehicle-maintenance";
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
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'businessCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('业务编号') , templet: function (d) { return templet('businessCode',d.businessCode,d);}  }
					,{ field: 'procId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('流程') , templet: function (d) { return templet('procId',d.procId,d);}  }
					,{ field: 'status', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('办理状态') , templet: function (d) { return templet('status',d.status,d);}  }
					,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('业务名称') , templet: function (d) { return templet('name',d.name,d);}  }
					,{ field: 'repairStatus', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('维修状态') , templet: function (d) { return templet('repairStatus',d.repairStatus,d);}  }
					,{ field: 'type', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('报修类型') , templet: function (d) { return templet('type',d.type,d);}  }
					,{ field: 'planFinishDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('计划完成日期') ,templet: function (d) { return templet('planFinishDate',fox.dateFormat(d.planFinishDate,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'actualFinishDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('实际完成日期') ,templet: function (d) { return templet('actualFinishDate',fox.dateFormat(d.actualFinishDate,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'cost', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('费用') , templet: function (d) { return templet('cost',d.cost,d);}  }
					,{ field: 'content', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('报修内容') , templet: function (d) { return templet('content',d.content,d);}  }
					,{ field: 'reportUserId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('报修人') , templet: function (d) { return templet('reportUserId',d.reportUserId,d);}  }
					,{ field: 'reportUserName', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('报修人') , templet: function (d) { return templet('reportUserName',d.reportUserName,d);}  }
					,{ field: 'pictureId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('图片') , templet: function (d) { return templet('pictureId',d.pictureId,d);}  }
					,{ field: 'originatorId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('制单人') , templet: function (d) { return templet('originatorId',d.originatorId,d);}  }
					,{ field: 'businessDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('业务日期') ,templet: function (d) { return templet('businessDate',fox.dateFormat(d.businessDate,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'createTime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('创建时间') ,templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
					,{ field: 'selectedCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('选择数据') , templet: function (d) { return templet('selectedCode',d.selectedCode,d);}  }
					,{ field: 'code', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('code') , templet: function (d) { return templet('code',d.code,d);}  }
					,{ field: 'registrant', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('registrant') , templet: function (d) { return templet('registrant',d.registrant,d);}  }
					,{ field: 'engineNumber', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('engine_number') , templet: function (d) { return templet('engineNumber',d.engineNumber,d);}  }
					,{ field: 'frameNumber', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('frame_number') , templet: function (d) { return templet('frameNumber',d.frameNumber,d);}  }
					,{ field: 'drivingLicense', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('driving_license') , templet: function (d) { return templet('drivingLicense',d.drivingLicense,d);}  }
					,{ field: 'notes', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('notes') , templet: function (d) { return templet('notes',d.notes,d);}  }
					,{ field: 'insuranceCompany', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('insurance_company') , templet: function (d) { return templet('insuranceCompany',d.insuranceCompany,d);}  }
					,{ field: 'licensingTime', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('licensing_time') , templet: function (d) { return templet('licensingTime',d.licensingTime,d);}  }
					,{ field: 'model', align:"",fixed:false,  hide:false, sort: false  , title: fox.translate('model') , templet: function (d) { return templet('model',d.model,d);}  }
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
	 * 刷新单号数据
	 * */
	function refreshRowData(data,remote) {
		var context=dataTable.getDataRowContext( { id : data.id } );
		if(context==null) return;
		if(remote) {
			admin.post(moduleURL+"/get-by-id", { id : data.id }, function (r) {
				if (r.success) {
					data = r.data;
					context.update(data);
				} else {
					fox.showMessage(data);
				}
			});
		} else {
			context.update(data);
		}
	}

	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType,reset) {
		function getSelectedValue(id,prop) { var xm=xmSelect.get(id,true); return xm==null ? null : xm.getValue(prop);}
		var value = {};
		value.id={ inputType:"button",value: $("#id").val()};
		value.businessCode={ inputType:"button",value: $("#businessCode").val()};
		value.procId={ inputType:"button",value: $("#procId").val()};
		value.status={ inputType:"button",value: $("#status").val()};
		value.name={ inputType:"button",value: $("#name").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.repairStatus={ inputType:"button",value: $("#repairStatus").val()};
		value.type={ inputType:"button",value: $("#type").val()};
		value.planFinishDate={ inputType:"date_input", value: $("#planFinishDate").val() ,matchType:"auto"};
		value.actualFinishDate={ inputType:"date_input", value: $("#actualFinishDate").val() ,matchType:"auto"};
		value.cost={ inputType:"number_input", value: $("#cost").val() };
		value.content={ inputType:"button",value: $("#content").val()};
		value.reportUserId={ inputType:"button",value: $("#reportUserId").val()};
		value.reportUserName={ inputType:"button",value: $("#reportUserName").val()};
		value.pictureId={ inputType:"button",value: $("#pictureId").val()};
		value.originatorId={ inputType:"button",value: $("#originatorId").val()};
		value.businessDate={ inputType:"date_input", value: $("#businessDate").val() ,matchType:"auto"};
		value.createTime={ inputType:"date_input", value: $("#createTime").val() ,matchType:"auto"};
		value.selectedCode={ inputType:"button",value: $("#selectedCode").val()};
		value.code={ inputType:"button",value: $("#code").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.registrant={ inputType:"button",value: $("#registrant").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.engineNumber={ inputType:"button",value: $("#engineNumber").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.frameNumber={ inputType:"button",value: $("#frameNumber").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.drivingLicense={ inputType:"button",value: $("#drivingLicense").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.notes={ inputType:"button",value: $("#notes").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.insuranceCompany={ inputType:"button",value: $("#insuranceCompany").val() ,fuzzy: true,splitValue:false,valuePrefix:"",valueSuffix:"" };
		value.licensingTime={ inputType:"button",value: $("#licensingTime").val()};
		value.model={ inputType:"button",value: $("#model").val()};
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
			admin.putTempData('vehicle-maintenance-form-data-form-action', "create",true);
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
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('车辆维修保养')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('车辆维修保养')+fox.translate('吗？'), function (i) {
                admin.post(moduleURL+"/delete-by-ids", { ids: ids }, function (data) {
                    if (data.success) {
						if(window.pageExt.list.afterBatchDelete) {
							var doNext=window.pageExt.list.afterBatchDelete(data);
							if(!doNext) return;
						}
						fox.showMessage(data);
                        refreshTableData();
                    } else {
						fox.showMessage(data);
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

			admin.putTempData('vehicle-maintenance-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('vehicle-maintenance-form-data-form-action', "edit",true);
						showEditForm(data.data);
					} else {
						 fox.showMessage(data);
					}
				});
			} else if (layEvent === 'view') { // 查看
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('vehicle-maintenance-form-data-form-action', "view",true);
						showEditForm(data.data);
					} else {
						fox.showMessage(data);
					}
				});
			}
			else if (layEvent === 'del') { // 删除

				if(window.pageExt.list.beforeSingleDelete) {
					var doNext=window.pageExt.list.beforeSingleDelete(data);
					if(!doNext) return;
				}
				top.layer.confirm(fox.translate('确定删除此')+fox.translate('车辆维修保养')+fox.translate('吗？'), function (i) {
					top.layer.close(i);

					top.layer.load(2);
					admin.request(moduleURL+"/delete", { id : data.id }, function (data) {
						top.layer.closeAll('loading');
						if (data.success) {
							if(window.pageExt.list.afterSingleDelete) {
								var doNext=window.pageExt.list.afterSingleDelete(data);
								if(!doNext) return;
							}
							fox.showMessage(data);
							refreshTableData();
						} else {
							fox.showMessage(data);
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
		var action=admin.getTempData('vehicle-maintenance-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString='id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('vehicle-maintenance-form-data', data);
		var area=admin.getTempData('vehicle-maintenance-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('车辆维修保养');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["98%",height+"px"],
			type: 2,
			id:"vehicle-maintenance-form-data-win",
			content: '/business/vehicle/maintenance/maintenance_form.html' + (queryString?("?"+queryString):""),
			finish: function () {
				if(action=="create") {
					refreshTableData();
				}
				if(action=="edit") {
					false?refreshTableData():refreshRowData(data,true);
				}
			}
		});
	};

	window.module={
		refreshTableData: refreshTableData,
		refreshRowData: refreshRowData,
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