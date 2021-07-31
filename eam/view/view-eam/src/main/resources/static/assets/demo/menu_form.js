/**
 * 菜单 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-08 10:22:55
 */
 
function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	const moduleURL="/service-oauth/sys-menu";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) { 	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
		//渲染表单组件
		renderFormFields();

		//绑定提交事件
		bindSubmitEvent();
 
	}
	
	function loadFormData(id) {
		admin.request(moduleURL+"/get-by-id",{id:id},function(r) {
			if(r.success) {
				 fillFormData(r.data)
			} else {
				admin.toast().error("获取数据失败 : "+r.message,{time:1000,position:"right-bottom",width:"300px"});
			}
		});
	};
	
	window.loadFormData=loadFormData;
 
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		form.render();
		//渲染下拉字段
		fox.renderSelectBox({
			el: "pathResourceId",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			autoRow: true,
			valueDirection:"column",
			toolbar: {show:true,showIcon:true,list:[ "ALL", "CLEAR","REVERSE"]},
			//转换数据
			searchField: "name,url", //请自行调整用于搜索的字段名称
			extraParam: {type:"page"}, //额外的查询参数，Object 或是 返回 Object 的函数
			template({ item, sels, name, value }){
				return item.url  + '<span style="position: absolute; right: 10px; color: #8799a3">'+item.tableName+'</span>'
			},
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				//debugger;
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					//请自行调整此处字段的对应关系
					try {
						opts.push({name:data[i].url,value:data[i].id,url:data[i].url,tableName:data[i].tableName});
					} catch (e) {
						debugger
					}

				}
				return opts;
			}
		});

		//渲染 resourceIds 下拉字段
		fox.renderSelectBox({
			el: "resourceIds",
			radio: false,
			filterable: true,
			paging: true,
			pageRemote: true,
			autoRow: true,
			valueDirection:"column",
			toolbar: {show:true,showIcon:true,list:[ "ALL", "CLEAR","REVERSE"]},
			//转换数据
			searchField: "url,name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			template({ item, sels, name, value }){
				return '<div style="color: #8799a3">['+item.method+']&nbsp;</div>'+item.url  + '<span style="position: absolute; right: 10px; color: #8799a3">'+item.tableName+'</span>'
			},
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					//请自行调整此处字段的对应关系
					var txt= '['+data[i].method+'] '+data[i].url;
					opts.push({name:txt,value:data[i].id,url:data[i].url,tableName:data[i].tableName,method:data[i].method});
				}
				return opts;
			}
		});

	}
	
	/**
      * 填充表单数据
      */
	function fillFormData(formData) {
		//var formData = admin.getTempData('sys-menu-form-data');
		$('#data-form')[0].reset();
		if (formData) {
			form.val('data-form', formData);

			//设置 菜单路径的资源 下拉框选中值
			var pathResourceIdSelect=xmSelect.get("#pathResourceId",true);
			var pathResourceIdOpionts=[];
			if (formData.pathResourceId)	{
				pathResourceIdOpionts=pathResourceIdSelect.options.transform([formData.pathResource]);
			}
			pathResourceIdSelect.setValue(pathResourceIdOpionts);
			//设置 资源清单 下拉框选中值
			var resourceIdsSelect=xmSelect.get("#resourceIds",true);
			var resourceIdsOpionts=[];
			if (formData.resourceIds)	{
				resourceIdsOpionts=resourceIdsSelect.options.transform(formData.resources);
			}
			resourceIdsSelect.setValue(resourceIdsOpionts);

			if(!formData.css) formData.css="";
			$("#icon-button-el").attr("class",formData.css);
		}
		renderFormFields();
	}


	function processFormValues(values) {
		for (var id in values) {
			if($("#"+id).attr("type")=="checkbox") {
				if(values[id]=='on') values[id]=1;
				else values[id]=0;
			}
		}

		return values;
	}

	$("#icon-button").click(function(){
		admin.openIconDialog(function (css){
			//debugger;
			$("#css").val(css);
			$("#icon-button-el").attr("class",css);
		});
	});
	
	/**
      * 保存数据，表单提交事件
      */
    function bindSubmitEvent() {
    
	    form.on('submit(submit-button)', function (data) {

			//获取 菜单路径的资源 下拉框的值
			data.field["pathResourceId"]=xmSelect.get("#pathResourceId",true).getValue("value");
			//获取 资源清单 下拉框的值
			data.field["resourceIds"]=xmSelect.get("#resourceIds",true).getValue("value");
	    	//处理逻辑值
	    	var values=processFormValues(data.field);


			//获取 菜单路径的资源 下拉框的值
			data.field["pathResourceId"]=xmSelect.get("#pathResourceId",true).getValue("value");
			if(data.field["pathResourceId"] && data.field["pathResourceId"].length>0) {
				data.field["pathResourceId"]=data.field["pathResourceId"][0];
			}
			//获取 资源清单 下拉框的值
			data.field["resourceIds"]=xmSelect.get("#resourceIds",true).getValue("value");

	    	var api=moduleURL+"/"+(values.id?"update":"insert");
	        layer.load(2);
	        admin.request(api, data.field, function (data) {
	            layer.closeAll('loading');
	            if (data.success) {
	            	if(parent) {
	            		parent.chaneNodeName(values.id,values.label);
	            	}
	                layer.msg(data.message, {icon: 1, time: 500});
	            } else {
	                layer.msg(data.message, {icon: 2, time: 500});
	            }
	        }, "POST");
	        
	        return false;
	    });
	    
    }

}

layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util', 'settings', 'upload','foxnic','xmSelect'],function() {
	(new FormPage()).init(layui);
});