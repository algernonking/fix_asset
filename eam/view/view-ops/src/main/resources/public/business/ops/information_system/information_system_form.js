/**
 * 信息系统 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-15 18:34:43
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-ops/ops-information-system";

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
			admin.putTempData('ops-information-system-form-area', area);
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
	   
		//渲染 status 下拉字段
		fox.renderSelectBox({
			el: "status",
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
		//渲染 opsMethod 下拉字段
		fox.renderSelectBox({
			el: "opsMethod",
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
		//渲染 devMethod 下拉字段
		fox.renderSelectBox({
			el: "devMethod",
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
			elem: '#lastdrillDate',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click"
		});
		laydate.render({
			elem: '#onlineDate',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click"
		});
		laydate.render({
			elem: '#offlineDate',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click"
		});
		//渲染 grade 下拉字段
		fox.renderSelectBox({
			el: "grade",
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
	}
	
	/**
      * 填充表单数据
      */
	function fillFormData() {
		var formData = admin.getTempData('ops-information-system-form-data');

		//如果是新建
		if(!formData.id) {
			adjustPopup();
		}
		var fm=$('#data-form');
		if (formData) {
			fm[0].reset();
			form.val('data-form', formData);





			//设置  状态 设置下拉框勾选
			fox.setSelectValue4Dict("#status",formData.status,SELECT_STATUS_DATA);
			//设置  运维模式 设置下拉框勾选
			fox.setSelectValue4Dict("#opsMethod",formData.opsMethod,SELECT_OPSMETHOD_DATA);
			//设置  开发模式 设置下拉框勾选
			fox.setSelectValue4Dict("#devMethod",formData.devMethod,SELECT_DEVMETHOD_DATA);
			//设置  系统分级 设置下拉框勾选
			fox.setSelectValue4Dict("#grade",formData.grade,SELECT_GRADE_DATA);




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







			//获取 状态 下拉框的值
			data.field["status"]=xmSelect.get("#status",true).getValue("value");
			if(data.field["status"] && data.field["status"].length>0) {
				data.field["status"]=data.field["status"][0];
			}
			//获取 运维模式 下拉框的值
			data.field["opsMethod"]=xmSelect.get("#opsMethod",true).getValue("value");
			if(data.field["opsMethod"] && data.field["opsMethod"].length>0) {
				data.field["opsMethod"]=data.field["opsMethod"][0];
			}
			//获取 开发模式 下拉框的值
			data.field["devMethod"]=xmSelect.get("#devMethod",true).getValue("value");
			if(data.field["devMethod"] && data.field["devMethod"].length>0) {
				data.field["devMethod"]=data.field["devMethod"][0];
			}
			//获取 系统分级 下拉框的值
			data.field["grade"]=xmSelect.get("#grade",true).getValue("value");
			if(data.field["grade"] && data.field["grade"].length>0) {
				data.field["grade"]=data.field["grade"][0];
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
					var index=admin.getTempData('ops-information-system-form-data-popup-index');
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