/**
 * 维保厂商 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-06-12 14:21:18
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	const moduleURL="/service-eam/eam-maintainer";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) { 	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;
		
		//渲染表单组件
		renderFormFields();
		
		//填充表单数据
		fillFormData();
		
		//绑定提交事件
		bindSubmitEvent();
		
		//调整窗口的高度与位置
		adjustPopup();
		
	}
	
	function adjustPopup() {
		var height=document.body.clientHeight+58;
		admin.changePopupArea(null,height);
		admin.putTempData('eam-maintainer-form-area', {height:height});
	}
	
	/**
      * 渲染表单组件
      */
	function renderFormFields() {
		form.render();
	    //渲染图片字段
	}
	
	/**
      * 填充表单数据
      */
	function fillFormData() {
		var formData = admin.getTempData('eam-maintainer-form-data');
		if (formData) {
			$('#data-form')[0].reset();
			form.val('data-form', formData);
	     	//设置并显示图片
	     	$('#data-form').attr('method', 'POST');
		}
	}
	
	/**
      * 保存数据，表单提交事件
      */
    function bindSubmitEvent() {
    
	    form.on('submit(submit-button)', function (data) {
	    	//debugger;
	    	
	    	//处理逻辑值
	    	
	    	var api=moduleURL+"/"+(data.field.id?"update":"insert");
	        layer.load(2);
	        admin.request(api, data.field, function (data) {
	            layer.closeAll('loading');
	            if (data.success) {
	                layer.msg(data.message, {icon: 1, time: 500});
	                admin.finishPopupCenter();
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
}).use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect'],function() {
	(new FormPage()).init(layui);
});