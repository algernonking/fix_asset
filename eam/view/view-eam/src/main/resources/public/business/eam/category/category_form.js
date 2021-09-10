/**
 * 资产分类 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-31 06:43:12
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-eam/eam-category";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) { 	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
		//渲染表单组件
		renderFormFields();

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
			admin.putTempData('eam-category-form-area', area);
			window.adjustPopup=adjustPopup;
		},50);
	}
	
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		form.render();
	   
	}
	
	/**
      * 填充表单数据
      */

	function fillFormData(formData) {


			var fm=$('#data-form');
			if (formData) {
				fm[0].reset();
				form.val('data-form', formData);
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

	// function fillFormData() {
	// 	var formData = admin.getTempData('eam-category-form-data');
	// 	// //如果是新建
	// 	// if(!formData.id) {
	// 	// 	adjustPopup();
	// 	// }
	// 	// var fm=$('#data-form');
	// 	// if (formData) {
	// 	// 	fm[0].reset();
	// 	// 	form.val('data-form', formData);
	//     //  	fm.attr('method', 'POST');
	//     //  	renderFormFields();
	// 	// }
	// 	//
	// 	// //渐显效果
	// 	// fm.css("opacity","0.0");
    //     // fm.css("display","");
    //     // setTimeout(function (){
    //     //     fm.animate({
    //     //         opacity:'1.0'
    //     //     },100);
    //     // },1);
    //
	// }

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
      * 保存数据，表单提交事件
      */
    function bindButtonEvent() {
    
	    form.on('submit(submit-button)', function (data) {
	    	//debugger;
			console.log('submit',data);
			if(data.field.id==""){
				layer.msg("请先选择", {icon: 2, time: 1000});
				return false;
			}

	    	var api=moduleURL+"/update";
	        var task=setTimeout(function(){layer.load(2);},1000);
	        admin.request(api, data.field, function (res) {
	            clearTimeout(task);
			    layer.closeAll('loading');
	            if (res.success) {
	            	if (parent){
						parent.changeNodeName(data.field.id,data.field.categoryName);
					}
	                layer.msg(res.message, {icon: 1, time: 500});
	            } else {
	                layer.msg(res.message, {icon: 2, time: 1000});
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
	xmSelect: 'xm-select/xm-select',
	foxnicUpload: 'upload/foxnic-upload'
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload'],function() {
	(new FormPage()).init(layui);
});