/**
 * 编码分配 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-08 12:19:34
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-common/sys-code-allocation";
	
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
			admin.putTempData('sys-code-allocation-form-area', area);
			window.adjustPopup=adjustPopup;
		},50);
	}
	
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		form.render();
	   
		//渲染 module 下拉字段
		fox.renderSelectBox({
			el: "module",
			radio: true,
			filterable: false,
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({name:data[i].undefiled,value:data[i].undefiled});
				}
				return opts;
			}
		});
		//渲染 ruleId 下拉字段
		fox.renderSelectBox({
			el: "ruleId",
			radio: true,
			filterable: false,
			//转换数据
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
	}
	
	/**
      * 填充表单数据
      */
	function fillFormData() {
		var formData = admin.getTempData('sys-code-allocation-form-data');
		//如果是新建
		if(!formData.id) {
			adjustPopup();
		}
		var fm=$('#data-form');
		if (formData) {
			fm[0].reset();
			form.val('data-form', formData);


			//设置 业务模块 下拉框选中值
			var moduleSelect=xmSelect.get("#module",true);
			var moduleOpionts=[];
			if (formData.undefined)	{
				moduleOpionts=moduleSelect.options.transform([formData.undefined]);
			}
			moduleSelect.setValue(moduleOpionts);
			//设置 编码规则 下拉框选中值
			var ruleIdSelect=xmSelect.get("#ruleId",true);
			var ruleIdOpionts=[];
			if (formData.rule)	{
				ruleIdOpionts=ruleIdSelect.options.transform([formData.rule]);
			}
			ruleIdSelect.setValue(ruleIdOpionts);

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
	    	



			//获取 业务模块 下拉框的值
			data.field["module"]=xmSelect.get("#module",true).getValue("value");
			if(data.field["module"] && data.field["module"].length>0) {
				data.field["module"]=data.field["module"][0];
			}
			//获取 编码规则 下拉框的值
			data.field["ruleId"]=xmSelect.get("#ruleId",true).getValue("value");
			if(data.field["ruleId"] && data.field["ruleId"].length>0) {
				data.field["ruleId"]=data.field["ruleId"][0];
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