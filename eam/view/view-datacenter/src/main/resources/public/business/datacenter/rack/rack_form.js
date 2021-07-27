/**
 * 机柜管理 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-27 09:19:34
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-datacenter/dc-rack";
	
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
			admin.putTempData('dc-rack-form-area', area);
			window.adjustPopup=adjustPopup;
		},50);
	}
	
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		form.render();
	   
		//渲染 dcId 下拉字段
		fox.renderSelectBox({
			el: "dcId",
			radio: true,
			filterable: true,
			toolbar: {show:true,showIcon:true,list:[ "ALL", "CLEAR","REVERSE"]},
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					//请自行调整此处字段的对应关系
					opts.push({name:data[i].name,value:data[i].id});
				}
				return opts;
			}
		});
	}
	
	/**
      * 填充表单数据
      */
	function fillFormData() {
		var formData = admin.getTempData('dc-rack-form-data');
		//如果是新建
		if(!formData.id) {
			adjustPopup();
		}
		var fm=$('#data-form');
		if (formData) {
			fm[0].reset();
			form.val('data-form', formData);


			//设置 数据中心 下拉框选中值
			var dcIdSelect=xmSelect.get("#dcId",true);
			var dcIdOpionts=[];
			if (formData.id)	{
				dcIdOpionts=dcIdSelect.options.transform([formData.id]);
			}
			dcIdSelect.setValue(dcIdOpionts);

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
	    	



			//获取 数据中心 下拉框的值
			data.field["dcId"]=xmSelect.get("#dcId",true).getValue("value");
			if(data.field["dcId"] && data.field["dcId"].length>0) {
				data.field["dcId"]=data.field["dcId"][0];
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