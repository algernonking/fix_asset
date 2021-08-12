/**
 * 主机 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-12 12:49:27
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-ops/ops-host";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) { 	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
		//渲染表单组件
		renderFormFields();
		
		//填充表单数据
		fillFormData();
		
		//绑定提交事件
		bindButtonEvent();

		//调整窗口的高度与位置
		adjustPopup();
	}

	/**
	 * 自动调节窗口高度
	 * */
	var adjustPopupTask=-1;
	function adjustPopup() {
		clearTimeout(adjustPopupTask);
		var scroll=$(".form-container").attr("scroll");
		if(scroll=='yes') return;
		adjustPopupTask=setTimeout(function () {
			var body=$("body");
			var bodyHeight=body.height();
			var footerHeight=$(".model-form-footer").height();
			var area=admin.changePopupArea(null,bodyHeight+footerHeight);
			admin.putTempData('ops-host-form-area', area);
			window.adjustPopup=adjustPopup;
			if(area.tooHeigh) {
				var windowHeight=area.iframeHeight;
				var finalHeight=windowHeight-footerHeight-16;
				//console.log("windowHeight="+windowHeight+',bodyHeight='+bodyHeight+",footerHeight="+footerHeight+",finalHeight="+finalHeight);
				$(".form-container").css("display","");
				$(".form-container").css("overflow-y","scroll");
				$(".form-container").css("height",finalHeight+"px");
				$(".form-container").attr("scroll","yes");
			}
		},250);
	}
	
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		fox.renderFormInputs(form);
	   
		//渲染 hostType 下拉字段
		fox.renderSelectBox({
			el: "hostType",
			radio: true,
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 environment 下拉字段
		fox.renderSelectBox({
			el: "environment",
			radio: true,
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 passwordStrategyId 下拉字段
		fox.renderSelectBox({
			el: "passwordStrategyId",
			radio: true,
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].text,value:data[i].code});
				}
				return opts;
			}
		});
		//渲染 hostDbIds 下拉字段
		fox.renderSelectBox({
			el: "hostDbIds",
			radio: false,
			filterable: true,
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
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
		//渲染 hostMiddlewareIds 下拉字段
		fox.renderSelectBox({
			el: "hostMiddlewareIds",
			radio: false,
			filterable: true,
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
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
		//渲染 hostOsIds 下拉字段
		fox.renderSelectBox({
			el: "hostOsIds",
			radio: false,
			filterable: true,
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
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
		//渲染 positionId 下拉字段
		fox.renderSelectBox({
			el: "positionId",
			radio: false,
			filterable: true,
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
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
		var formData = admin.getTempData('ops-host-form-data');
		//如果是新建
		if(!formData.id) {
			adjustPopup();
		}
		var fm=$('#data-form');
		if (formData) {
			fm[0].reset();
			form.val('data-form', formData);





			//设置  主机类型 设置下拉框勾选
			fox.setSelectValue4Dict("#hostType",formData.hostType,SELECT_HOSTTYPE_DATA);
			//设置  所在环境 设置下拉框勾选
			fox.setSelectValue4Dict("#environment",formData.environment,SELECT_ENVIRONMENT_DATA);
			//设置  改密策略 设置下拉框勾选
			fox.setSelectValue4Dict("#passwordStrategyId",formData.passwordStrategyId,SELECT_PASSWORDSTRATEGYID_DATA);
			//设置  数据库 设置下拉框勾选
			fox.setSelectValue4QueryApi("#hostDbIds",formData.host_db_list);
			//设置  中间件 设置下拉框勾选
			fox.setSelectValue4QueryApi("#hostMiddlewareIds",formData.host_middleware_list);
			//设置  操作系统 设置下拉框勾选
			fox.setSelectValue4QueryApi("#hostOsIds",formData.host_os_list);
			//设置  所在位置 设置下拉框勾选
			fox.setSelectValue4QueryApi("#positionId",formData.position);




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
			data.field = form.val("data-form");







			//获取 主机类型 下拉框的值
			data.field["hostType"]=xmSelect.get("#hostType",true).getValue("value");
			if(data.field["hostType"] && data.field["hostType"].length>0) {
				data.field["hostType"]=data.field["hostType"][0];
			}
			//获取 所在环境 下拉框的值
			data.field["environment"]=xmSelect.get("#environment",true).getValue("value");
			if(data.field["environment"] && data.field["environment"].length>0) {
				data.field["environment"]=data.field["environment"][0];
			}
			//获取 改密策略 下拉框的值
			data.field["passwordStrategyId"]=xmSelect.get("#passwordStrategyId",true).getValue("value");
			if(data.field["passwordStrategyId"] && data.field["passwordStrategyId"].length>0) {
				data.field["passwordStrategyId"]=data.field["passwordStrategyId"][0];
			}
			//获取 数据库 下拉框的值
			data.field["hostDbIds"]=xmSelect.get("#hostDbIds",true).getValue("value");
			//获取 中间件 下拉框的值
			data.field["hostMiddlewareIds"]=xmSelect.get("#hostMiddlewareIds",true).getValue("value");
			//获取 操作系统 下拉框的值
			data.field["hostOsIds"]=xmSelect.get("#hostOsIds",true).getValue("value");
			//获取 所在位置 下拉框的值
			data.field["positionId"]=xmSelect.get("#positionId",true).getValue("value");

			//校验表单
			if(!fox.formVerify("data-form",data,VALIDATE_CONFIG)) return;

	    	var api=moduleURL+"/"+(data.field.id?"update":"insert");
	        var task=setTimeout(function(){layer.load(2);},1000);
	        admin.request(api, data.field, function (data) {
	            clearTimeout(task);
			    layer.closeAll('loading');
	            if (data.success) {
	                layer.msg(data.message, {icon: 1, time: 500});
					var index=admin.getTempData('ops-host-form-data-popup-index');
	                admin.finishPopupCenter(index);
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
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate'],function() {
	(new FormPage()).init(layui);
});