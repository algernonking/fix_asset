/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-05 15:17:43
 */


function ListPage() {
        
	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-eam/eam-asset";
	
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
                { field: 'id', align:"left", hide:false, sort: true, title: fox.translate('主键')} ,
                { field: 'busiCode', align:"left", hide:false, sort: true, title: fox.translate('单据编号')} ,
                { field: 'status', align:"left", hide:false, sort: true, title: fox.translate('资产状态')} ,
                { field: 'assetCode', align:"left", hide:false, sort: true, title: fox.translate('资产编号')} ,
                { field: 'categoryId', align:"left", hide:false, sort: true, title: fox.translate('分类ID')} ,
                { field: 'goodsId', align:"left", hide:false, sort: true, title: fox.translate('标准型号ID')} ,
                { field: 'name', align:"left", hide:false, sort: true, title: fox.translate('标准型号资产名称')} ,
                { field: 'manufacturerId', align:"left", hide:false, sort: true, title: fox.translate('标准型号厂商')} ,
                { field: 'brandId', align:"left", hide:false, sort: true, title: fox.translate('标准型号品牌')} ,
                { field: 'model', align:"left", hide:false, sort: true, title: fox.translate('标准型号规格型号')} ,
                { field: 'pictureId', align:"left", hide:false, sort: true, title: fox.translate('标准型号物品图片')} ,
                { field: 'unit', align:"left", hide:false, sort: true, title: fox.translate('标准型号计量单位')} ,
                { field: 'unitPrice', align:"right", hide:false, sort: true, title: fox.translate('标准型号单价')} ,
                { field: 'rfid', align:"left", hide:false, sort: true, title: fox.translate('资产RFID')} ,
                { field: 'assetNumber', align:"right", hide:false, sort: true, title: fox.translate('资产数量')} ,
                { field: 'batchNumber', align:"left", hide:false, sort: true, title: fox.translate('批次号如果来自库存建议填写库存单据')} ,
                { field: 'sn', align:"left", hide:false, sort: true, title: fox.translate('资产序列号')} ,
                { field: 'sourceId', align:"left", hide:false, sort: true, title: fox.translate('来源')} ,
                { field: 'sourceDetail', align:"left", hide:false, sort: true, title: fox.translate('来源详情')} ,
                { field: 'areaId', align:"left", hide:false, sort: true, title: fox.translate('存放区域')} ,
                { field: 'placeDetail', align:"left", hide:false, sort: true, title: fox.translate('存放地点')} ,
                { field: 'userId', align:"left", hide:false, sort: true, title: fox.translate('使用人员')} ,
				{ field: 'productionDate', align:"right", hide:false, sort: true, title: fox.translate('生产日期'), templet: function (d) { return fox.dateFormat(d.productionDate); }} ,
				{ field: 'storageTime', align:"right", hide:false, sort: true, title: fox.translate('入库时间'), templet: function (d) { return fox.dateFormat(d.storageTime); }} ,
                { field: 'display', align:"left", hide:false, sort: true, title: fox.translate('是否显示(显示:1')} ,
                { field: 'assetsNotes', align:"left", hide:false, sort: true, title: fox.translate('备注')} ,
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
		value.id={ value: $("#id").val() };
		value.busiCode={ value: $("#busiCode").val() };
		value.status={ value: $("#status").val() };
		value.assetCode={ value: $("#assetCode").val() };
		value.categoryId={ value: $("#categoryId").val() };
		value.goodsId={ value: $("#goodsId").val() };
		value.name={ value: $("#name").val() };
		value.manufacturerId={ value: $("#manufacturerId").val() };
		value.brandId={ value: $("#brandId").val() };
		value.model={ value: $("#model").val() };
		value.pictureId={ value: $("#pictureId").val() };
		value.unit={ value: $("#unit").val() };
		value.unitPrice={ value: $("#unitPrice").val() };
		value.rfid={ value: $("#rfid").val() };
		value.assetNumber={ value: $("#assetNumber").val() };
		value.batchNumber={ value: $("#batchNumber").val() };
		value.sn={ value: $("#sn").val() };
		value.sourceId={ value: $("#sourceId").val() };
		value.sourceDetail={ value: $("#sourceDetail").val() };
		value.areaId={ value: $("#areaId").val() };
		value.placeDetail={ value: $("#placeDetail").val() };
		value.userId={ value: $("#userId").val() };
		value.productionDate={ begin: $("#productionDate-begin").val(), end: $("#productionDate-end").val() };
		value.storageTime={ begin: $("#storageTime-begin").val(), end: $("#storageTime-end").val() };
		value.display={ value: $("#display").val() };
		value.assetsNotes={ value: $("#assetsNotes").val() };
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
			laydate.render({
				elem: '#productionDate-begin'
			});
			laydate.render({
				elem: '#productionDate-end'
			});
			laydate.render({
				elem: '#storageTime-begin'
			});
			laydate.render({
				elem: '#storageTime-end'
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
            	layer.msg(fox.translate('请选择需要删除的')+fox.translate('资产')+"!");
            	return;
            }
            //调用批量删除接口
			layer.confirm(fox.translate('确定删除已选中的')+fox.translate('资产')+fox.translate('吗？'), function (i) {
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
			
				layer.confirm(fox.translate('确定删除此')+fox.translate('资产')+fox.translate('吗？'), function (i) {
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
		admin.putTempData('eam-asset-form-data', data);
		var area=admin.getTempData('eam-asset-form-area');
		var height= (area && area.height) ? area.height : ($(window).height()*0.6);
		var top= (area && area.top) ? area.top : (($(window).height()-height)/2);
		var title = (data && data.id) ? (fox.translate('修改')+fox.translate('资产')) : (fox.translate('添加')+fox.translate('资产'));
		admin.popupCenter({
			title: title,
			resize: true,
			offset: [top,null],
			area: ["500px",height+"px"],
			type: 2,
			content: '/business/eam/asset/asset_form.html' + queryString,
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