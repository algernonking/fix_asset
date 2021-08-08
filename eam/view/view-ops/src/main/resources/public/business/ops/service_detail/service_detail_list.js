/**
 * 服务明细 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-08 17:10:08
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-ops/ops-service-detail";
	
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
     
		fox.renderTable({
			elem: '#data-table',
            url: moduleURL +'/query-paged-list',
		 	height: 'full-78',
		 	limit: 50,
			cols: [[
				{  fixed: 'left',type: 'numbers' },
			 	{  fixed: 'left',type:'checkbox' },
                { field: 'id', align:"left", hide:true, sort: true, title: fox.translate('主键')} ,
				{ field: 'serviceId', align:"left", hide:false, sort: true, title: fox.translate('服务'), templet: function (d) { return fox.joinLabel(d.opsService,"serviceName");}} ,
                { field: 'name', align:"left", hide:false, sort: true, title: fox.translate('名称')} ,
                { field: 'patch', align:"left", hide:false, sort: true, title: fox.translate('补丁')} ,
                { field: 'notes', align:"left", hide:false, sort: true, title: fox.translate('备注')} ,
                { field: 'sort', align:"right", hide:false, sort: true, title: fox.translate('排序')} ,
				{ field: 'createTime', align:"right", hide:false, sort: true, title: fox.translate('创建时间'), templet: function (d) { return fox.dateFormat(d.createTime); }} ,
                { field: 'row-ops', fixed: 'right', align: 'center', toolbar: '#tableOperationTemplate', title: fox.translate('操作'), width: 125 }
            ]]
	 		,footer : {
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
    };
     
	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType) {
		var value = {};
		value.serviceId={ value: xmSelect.get("#serviceId",true).getValue("value") };
		value.name={ value: $("#name").val() ,fuzzy: true };
		value.patch={ value: $("#patch").val() ,fuzzy: true };
		value.notes={ value: $("#notes").val() ,fuzzy: true };
		var ps={searchField: "$composite", searchValue: JSON.stringify(value),sortField: sortField,sortType: sortType};
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
		//渲染 serviceId 下拉字段
		fox.renderSelectBox({
			el: "serviceId",
			radio: true,
			size: "small",
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].serviceName,value:data[i].id});
				}
				return opts;
			}
		});
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
	}
	
	/**
	 * 绑定按钮事件
	  */
	function bindButtonEvent() {
	
		//添加按钮点击事件
        $('#add-button').click(function () {
        	//设置新增是初始化数据
        	var data={};
            showEditForm(data);
        });
		
        //批量删除按钮点击事件
        $('#delete-button').click(function () {
          
			var ids=getCheckedList("id");
            if(ids.length==0) {
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('服务明细')+"!");
            	return;
            }
            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('服务明细')+fox.translate('吗？'), function (i) {
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
        });
	}
     
    /**
     * 绑定行操作按钮事件
     */
    function bindRowOperationEvent() {
		// 工具条点击事件
		table.on('tool(data-table)', function (obj) {
			var data = obj.data;
			var layEvent = obj.event;
	
			if (layEvent === 'edit') { // 修改
				//延迟显示加载动画，避免界面闪动
				var task=setTimeout(function(){layer.load(2);},1000);
				admin.request(moduleURL+"/get-by-id", { id : data.id }, function (data) {
					clearTimeout(task);
					layer.closeAll('loading');
					if(data.success) {
						 showEditForm(data.data);
					} else {
						 layer.msg(data.message, {icon: 1, time: 1500});
					}
				});
				
			} else if (layEvent === 'del') { // 删除
			
				layer.confirm(fox.translate('确定删除此')+fox.translate('服务明细')+fox.translate('吗？'), function (i) {
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
		admin.putTempData('ops-service-detail-form-data', data);
		var area=admin.getTempData('ops-service-detail-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = (data && data.id) ? (fox.translate('修改')+fox.translate('服务明细')) : (fox.translate('添加')+fox.translate('服务明细'));
		admin.popupCenter({
			title: title,
			resize: true,
			offset: [top,null],
			area: ["500px",height+"px"],
			type: 2,
			content: '/business/ops/service_detail/service_detail_form.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
	};

};


layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate'],function() {
	(new ListPage()).init(layui);
});