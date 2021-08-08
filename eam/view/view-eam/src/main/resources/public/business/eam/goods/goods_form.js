/**
 * 物品档案 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-08 17:09:55
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-eam/eam-goods";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) { 	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
		//渲染表单组件
		renderFormFields();
		
		//填充表单数据
		fillFormData();
		
		//绑定提交事件
		bindButtonEvent();

		//调整窗口的高度与位置
		adjustPopup();
	}
	
	function adjustPopup() {
		setTimeout(function () {
			var body=$("body");
			var bodyHeight=body.height();
			var area=admin.changePopupArea(null,bodyHeight);
			admin.putTempData('eam-goods-form-area', area);
			window.adjustPopup=adjustPopup;
		},50);
	}
	
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		form.render();
	   
		//渲染 categoryId 下拉字段
		fox.renderSelectBox({
			el: "categoryId",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			toolbar: {show:true,showIcon:true,list:[ "ALL", "CLEAR","REVERSE"]},
			//转换数据
			searchField: "hierarchyName)", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].hierarchyName,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 manufacturerId 下拉字段
		fox.renderSelectBox({
			el: "manufacturerId",
			radio: true,
			filterable: false,
			toolbar: {show:true,showIcon:true,list:[ "ALL", "CLEAR","REVERSE"]},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].manufacturerName,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 brandId 下拉字段
		fox.renderSelectBox({
			el: "brandId",
			radio: true,
			filterable: false,
			toolbar: {show:true,showIcon:true,list:[ "ALL", "CLEAR","REVERSE"]},
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].brandName,value:data[i].id});
				}
				return opts;
			}
		});
	}
	
	/**
      * 填充表单数据
      */
	function fillFormData() {
		var formData = admin.getTempData('eam-goods-form-data');
		//如果是新建
		if(!formData.id) {
			adjustPopup();
		}
		var fm=$('#data-form');
		if (formData) {
			fm[0].reset();
			form.val('data-form', formData);


			//设置 资产分类 下拉框选中值
			var categoryIdSelect=xmSelect.get("#categoryId",true);
			var categoryIdOpionts=[];
			if (formData.category)	{
				categoryIdOpionts=categoryIdSelect.options.transform([formData.category]);
			}
			categoryIdSelect.setValue(categoryIdOpionts);
			//设置 生产厂商 下拉框选中值
			var manufacturerIdSelect=xmSelect.get("#manufacturerId",true);
			var manufacturerIdOpionts=[];
			if (formData.manufacturer)	{
				manufacturerIdOpionts=manufacturerIdSelect.options.transform([formData.manufacturer]);
			}
			manufacturerIdSelect.setValue(manufacturerIdOpionts);
			//设置 品牌 下拉框选中值
			var brandIdSelect=xmSelect.get("#brandId",true);
			var brandIdOpionts=[];
			if (formData.brand)	{
				brandIdOpionts=brandIdSelect.options.transform([formData.brand]);
			}
			brandIdSelect.setValue(brandIdOpionts);

	     	fm.attr('method', 'POST');
	     	renderFormFields();
		}
		
		//渐显效果
		fm.css("opacity","0.0");
        fm.css("display","");
        setTimeout(function (){
            fm.animate({
                opacity:'1.0'
            },100);
        },1);
        
	}
	
	/**
      * 保存数据，表单提交事件
      */
    function bindButtonEvent() {
    
	    form.on('submit(submit-button)', function (data) {
	    	//debugger;
	    	



			//获取 资产分类 下拉框的值
			data.field["categoryId"]=xmSelect.get("#categoryId",true).getValue("value");
			if(data.field["categoryId"] && data.field["categoryId"].length>0) {
				data.field["categoryId"]=data.field["categoryId"][0];
			}
			//获取 生产厂商 下拉框的值
			data.field["manufacturerId"]=xmSelect.get("#manufacturerId",true).getValue("value");
			if(data.field["manufacturerId"] && data.field["manufacturerId"].length>0) {
				data.field["manufacturerId"]=data.field["manufacturerId"][0];
			}
			//获取 品牌 下拉框的值
			data.field["brandId"]=xmSelect.get("#brandId",true).getValue("value");
			if(data.field["brandId"] && data.field["brandId"].length>0) {
				data.field["brandId"]=data.field["brandId"][0];
			}

	    	var api=moduleURL+"/"+(data.field.id?"update":"insert");
	        var task=setTimeout(function(){layer.load(2);},1000);
	        admin.request(api, data.field, function (data) {
	            clearTimeout(task);
			    layer.closeAll('loading');
	            if (data.success) {
	                layer.msg(data.message, {icon: 1, time: 500});
	                admin.finishPopupCenter();
	            } else {
	                layer.msg(data.message, {icon: 2, time: 1000});
	            }
	        }, "POST");
	        
	        return false;
	    });
	    
	    //关闭窗口
	    $("#cancel-button").click(function(){admin.closePopupCenter();});
	    
    }

}

layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select',
	foxnicUpload: 'upload/foxnic-upload'
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload'],function() {
	(new FormPage()).init(layui);
});