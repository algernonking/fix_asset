/**
 * 软件资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-05 06:04:13
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-eam/eam-asset-software";
	var dataTable=null;
	var sort=null;
	var timestamp = Date.parse(new Date());
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
				url: moduleURL +'/query-paged-list-by-selected',
				height: 'full-'+(h+28),
				limit: 50,
				where: ps,
				cols: [[
					{ fixed: 'left',type: 'numbers' },
					{ fixed: 'left',type:'checkbox'}
					,{ field: 'id', align:"left",fixed:false,  hide:true, sort: true  , title: fox.translate('主键') , templet: function (d) { return templet('id',d.id,d);}  }
					,{ field: 'businessCode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('业务编号') , templet: function (d) { return templet('businessCode',d.businessCode,d);}  }
				    ,{ field: 'name', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('软件名称') , templet: function (d) { return templet('name',d.name,d);}  }
					,{ field: 'categoryId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('软件分类'), templet: function (d) { return templet('categoryId' ,fox.joinLabel(d.category,"name"),d);}}
			//		,{ field: 'code', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('软件编号') , templet: function (d) { return templet('code',d.code,d);}  }
					,{ field: 'softwareVersion', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('软件版本') , templet: function (d) { return templet('softwareVersion',d.softwareVersion,d);}  }
			//		,{ field: 'copyrightType', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('版权类型'), templet: function (d) { return templet('copyrightType' ,fox.joinLabel(d.copyrightTypeDict,"label"),d);}}
				//	,{ field: 'licenseMode', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('许可模式'), templet: function (d) { return templet('licenseMode' ,fox.joinLabel(d.licenseModeDict,"label"),d);}}
				 	,{ field: 'authorizedNumber', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('授权数量') , templet: function (d) { return templet('authorizedNumber',d.authorizedNumber,d);}  }
					,{ field: 'authorizedAvailableNumber', align:"right",fixed:false,  hide:false, sort: true  , title: fox.translate('可用数量') , templet: function (d) { return templet('authorizedAvailableNumber',d.authorizedAvailableNumber,d);}  }
					,{ field: 'authorizedNumberUnlimit', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('无限授权'), templet:function (d){ return templet('authorizedNumberUnlimit',fox.getEnumText(RADIO_AUTHORIZEDNUMBERUNLIMIT_DATA,d.authorizedNumberUnlimit),d);}}
					,{ field: 'authorizationExpirationDate', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('授权到期时间') ,templet: function (d) { return templet('authorizationExpirationDate',fox.dateFormat(d.authorizationExpirationDate,"yyyy-MM-dd"),d); }  }
					,{ field: 'authorizationExpirationUnlimit', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('永久授权'), templet:function (d){ return templet('authorizationExpirationUnlimit',fox.getEnumText(RADIO_AUTHORIZATIONEXPIRATIONUNLIMIT_DATA,d.authorizationExpirationUnlimit),d);}}
				 //	,{ field: 'createTime', align:"right", fixed:false, hide:false, sort: true   ,title: fox.translate('创建时间') ,templet: function (d) { return templet('createTime',fox.dateFormat(d.createTime,"yyyy-MM-dd HH:mm:ss"),d); }  }
				//	,{ field: 'originatorId', align:"left",fixed:false,  hide:false, sort: true  , title: fox.translate('制单人') , templet: function (d) { return templet('originatorId',fox.getProperty(d,["originator","name"]),d);} }

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
					fox.renderFormInputs(form);
				} else {
					fox.showMessage(data);
				}
			});
		} else {
			context.update(data);
			fox.renderFormInputs(form);
		}
	}

	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType,reset) {
		function getSelectedValue(id,prop) { var xm=xmSelect.get(id,true); return xm==null ? null : xm.getValue(prop);}
		var value = {};
		value.businessCode={ inputType:"button",value: $("#businessCode").val()};
		value.status={ inputType:"select_box", value: getSelectedValue("#status","value"), label:getSelectedValue("#status","nameStr") };
		value.name={ inputType:"button",value: $("#name").val()};
		value.copyrightType={ inputType:"select_box", value: getSelectedValue("#copyrightType","value") ,fillBy:["copyrightTypeDict"]  , label:getSelectedValue("#copyrightType","nameStr") };
		value.licenseMode={ inputType:"select_box", value: getSelectedValue("#licenseMode","value") ,fillBy:["licenseModeDict"]  , label:getSelectedValue("#licenseMode","nameStr") };
		value.supplierId={ inputType:"select_box", value: getSelectedValue("#supplierId","value") ,fillBy:["supplier"]  , label:getSelectedValue("#supplierId","nameStr") };
		value.positionDetail={ inputType:"button",value: $("#positionDetail").val()};
		value.sourceId={ inputType:"select_box", value: getSelectedValue("#sourceId","value") ,fillBy:["source"]  , label:getSelectedValue("#sourceId","nameStr") };
		value.purchaseDate={ inputType:"date_input", begin: $("#purchaseDate-begin").val(), end: $("#purchaseDate-end").val() ,matchType:"auto" };
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
		//渲染 copyrightType 下拉字段
		fox.renderSelectBox({
			el: "copyrightType",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("copyrightType",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].label,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 licenseMode 下拉字段
		fox.renderSelectBox({
			el: "licenseMode",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("licenseMode",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].label,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 supplierId 下拉字段
		fox.renderSelectBox({
			el: "supplierId",
			radio: true,
			size: "small",
			filterable: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("supplierId",data.arr,data.change,data.isAdd);
				},1);
			},
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "supplierName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].supplierName,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 sourceId 下拉字段
		fox.renderSelectBox({
			el: "sourceId",
			radio: true,
			size: "small",
			filterable: false,
			on: function(data){
				setTimeout(function () {
					window.pageExt.list.onSelectBoxChanged && window.pageExt.list.onSelectBoxChanged("sourceId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].label,value:data[i].code});
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#purchaseDate-begin',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("purchaseDate",value, date, endDate);
				},1);
			}
		});
		laydate.render({
			elem: '#purchaseDate-end',
			trigger:"click",
			done: function(value, date, endDate) {
				setTimeout(function () {
					window.pageExt.list.onDatePickerChanged && window.pageExt.list.onDatePickerChanged("purchaseDate",value, date, endDate);
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
			admin.putTempData('eam-asset-software-form-data-form-action', "create",true);

			var queryString="?operType="+OPER_TYPE+"&pageType="+PAGE_TYPE+"&pid="+PID+"&selectedCode="+SELECTED_CODE;
			var top=2
			var index=admin.popupCenter({
				title: "选择资产",
				resize: false,
				offset: [top,null],
				area: ["95%","90%"],
				type: 2,
				id:"eam-asset-software-select-data-win",
				content: '/business/eam/asset_software/asset_software_select_list.html'+queryString,
				finish: function () {
					refreshTableData();
				}
			});
			admin.putTempData('eam-asset-software-select-data-popup-index', index);
            //showEditForm(data);
        };

        //批量删除按钮点击事件
        function batchDelete(selected) {

        	if(window.pageExt.list.beforeBatchDelete) {
				var doNext=window.pageExt.list.beforeBatchDelete(selected);
				if(!doNext) return;
			}

			var ids=getCheckedList("id");
            if(ids.length==0) {
				top.layer.msg(fox.translate('请选择需要删除的')+fox.translate('软件资产')+"!");
            	return;
            }
            //调用批量删除接口
			top.layer.confirm(fox.translate('确定删除已选中的')+fox.translate('软件资产')+fox.translate('吗？'), function (i) {
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

			admin.putTempData('eam-asset-software-form-data-form-action', "",true);
			if (layEvent === 'edit') { // 修改
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('eam-asset-software-form-data-form-action', "edit",true);

						//var queryString="?ownerType="+OWNER_TYPE+"&selectedCode="+SELECTED_CODE+"&ownerCode="+OWNER_CODE+"&ownerTmpId="+OWNER_TMP_ID+"&operType="+OPER_TYPE+"&pageType="+PAGE_TYPE;


						//showEditForm(data.data);
					} else {
						 fox.showMessage(data);
					}
				});
			}
			else if (layEvent === 'view') { // 查看
				admin.post(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					if(data.success) {
						admin.putTempData('eam-asset-software-form-data-form-action', "view",true);
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
				top.layer.confirm(fox.translate('确定删除此')+fox.translate('软件资产')+fox.translate('吗？'), function (i) {
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
			else if (layEvent === 'for-approval') { // 送审
				window.pageExt.list.forApproval(data);
			}
			else if (layEvent === 'confirm-data') { // 确认
				window.pageExt.list.confirmData(data);
			}
			else if (layEvent === 'revoke-data') { // 撤销
				window.pageExt.list.revokeData(data);
			}
			else if (layEvent === 'download-bill') { // 单据
				window.pageExt.list.downloadBill(data);
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
		var action=admin.getTempData('eam-asset-software-form-data-form-action');
		var queryString="";
		if(data && data.id) queryString='id=' + data.id;
		if(window.pageExt.list.makeFormQueryString) {
			queryString=window.pageExt.list.makeFormQueryString(data,queryString,action);
		}
		admin.putTempData('eam-asset-software-form-data', data);
		var area=admin.getTempData('eam-asset-software-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = fox.translate('软件资产');
		if(action=="create") title=fox.translate('添加')+title;
		else if(action=="edit") title=fox.translate('修改')+title;
		else if(action=="view") title=fox.translate('查看')+title;

		admin.popupCenter({
			title: title,
			resize: false,
			offset: [top,null],
			area: ["95%",height+"px"],
			type: 2,
			id:"eam-asset-software-form-data-win",
			content: '/business/eam/asset_software/asset_software_form.html' + (queryString?("?"+queryString):""),
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


	function getDataList(callback) {
		var tdata=table.cache['data-table'];
		var res=[];
		for(var i=0;i<tdata.length;i++) {
			res.push(tdata[i].id);
		}
		callback(res);
	}

	window.module={
		refreshTableData: refreshTableData,
		refreshRowData: refreshRowData,
		getCheckedList: getCheckedList,
		getDataList:getDataList
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