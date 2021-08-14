/**
 * 数据库实例 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-14 14:29:34
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-ops/ops-db-instance";

	const disableCreateNew=false;
	const disableModify=false;
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
			admin.putTempData('ops-db-instance-form-area', area);
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
	   
		//渲染 hostId 下拉字段
		fox.renderSelectBox({
			el: "hostId",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			toolbar: {show:true,showIcon:true,list:[ "ALL", "CLEAR","REVERSE"]},
			//转换数据
			searchField: "hostName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].hostName,value:data[i].id});
				}
				return opts;
			}
		});
		//渲染 databaseId 下拉字段
		fox.renderSelectBox({
			el: "databaseId",
			radio: true,
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
		//渲染 logMethod 下拉字段
		fox.renderSelectBox({
			el: "logMethod",
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
		//渲染 backupType 下拉字段
		fox.renderSelectBox({
			el: "backupType",
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
		//渲染 backupStatus 下拉字段
		fox.renderSelectBox({
			el: "backupStatus",
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
		//渲染 backupMethod 下拉字段
		fox.renderSelectBox({
			el: "backupMethod",
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
		laydate.render({
			elem: '#backupTime',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click"
		});
	}
	
	/**
      * 填充表单数据
      */
	function fillFormData() {
		var formData = admin.getTempData('ops-db-instance-form-data');

		//如果是新建
		if(!formData.id) {
			adjustPopup();
		}
		var fm=$('#data-form');
		if (formData) {
			fm[0].reset();
			form.val('data-form', formData);





			//设置  主机 设置下拉框勾选
			fox.setSelectValue4QueryApi("#hostId",formData.host);
			//设置  数据库 设置下拉框勾选
			fox.setSelectValue4QueryApi("#databaseId",formData.database);
			//设置  日志模式 设置下拉框勾选
			fox.setSelectValue4Dict("#logMethod",formData.logMethod,SELECT_LOGMETHOD_DATA);
			//设置  备份状态 设置下拉框勾选
			fox.setSelectValue4Dict("#backupType",formData.backupType,SELECT_BACKUPTYPE_DATA);
			//设置  备份状态 设置下拉框勾选
			fox.setSelectValue4Dict("#backupStatus",formData.backupStatus,SELECT_BACKUPSTATUS_DATA);
			//设置  备份方式 设置下拉框勾选
			fox.setSelectValue4Dict("#backupMethod",formData.backupMethod,SELECT_BACKUPMETHOD_DATA);




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

        //
		if(disableModify) {
			fox.lockForm($("#data-form"),true);
		}



        
	}
	
	/**
      * 保存数据，表单提交事件
      */
    function bindButtonEvent() {
    
	    form.on('submit(submit-button)', function (data) {
	    	//debugger;
			data.field = form.val("data-form");







			//获取 主机 下拉框的值
			data.field["hostId"]=xmSelect.get("#hostId",true).getValue("value");
			if(data.field["hostId"] && data.field["hostId"].length>0) {
				data.field["hostId"]=data.field["hostId"][0];
			}
			//获取 数据库 下拉框的值
			data.field["databaseId"]=xmSelect.get("#databaseId",true).getValue("value");
			if(data.field["databaseId"] && data.field["databaseId"].length>0) {
				data.field["databaseId"]=data.field["databaseId"][0];
			}
			//获取 日志模式 下拉框的值
			data.field["logMethod"]=xmSelect.get("#logMethod",true).getValue("value");
			if(data.field["logMethod"] && data.field["logMethod"].length>0) {
				data.field["logMethod"]=data.field["logMethod"][0];
			}
			//获取 备份状态 下拉框的值
			data.field["backupType"]=xmSelect.get("#backupType",true).getValue("value");
			if(data.field["backupType"] && data.field["backupType"].length>0) {
				data.field["backupType"]=data.field["backupType"][0];
			}
			//获取 备份状态 下拉框的值
			data.field["backupStatus"]=xmSelect.get("#backupStatus",true).getValue("value");
			if(data.field["backupStatus"] && data.field["backupStatus"].length>0) {
				data.field["backupStatus"]=data.field["backupStatus"][0];
			}
			//获取 备份方式 下拉框的值
			data.field["backupMethod"]=xmSelect.get("#backupMethod",true).getValue("value");
			if(data.field["backupMethod"] && data.field["backupMethod"].length>0) {
				data.field["backupMethod"]=data.field["backupMethod"][0];
			}

			//校验表单
			if(!fox.formVerify("data-form",data,VALIDATE_CONFIG)) return;

	    	var api=moduleURL+"/"+(data.field.id?"update":"insert");
	        var task=setTimeout(function(){layer.load(2);},1000);
	        admin.request(api, data.field, function (data) {
	            clearTimeout(task);
			    layer.closeAll('loading');
	            if (data.success) {
	                layer.msg(data.message, {icon: 1, time: 500});
					var index=admin.getTempData('ops-db-instance-form-data-popup-index');
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