/**
 * 信息系统 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-11 22:38:24
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-ops/ops-information-system";

	var disableCreateNew=false;
	var disableModify=false;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

		//如果没有修改和保存权限，
		if( !admin.checkAuth(AUTH_PREFIX+":update") && !admin.checkAuth(AUTH_PREFIX+":save")) {
			disableModify=true;
		}
		if(admin.getTempData('ops-information-system-form-data-form-action')=="view") {
			disableModify=true;
		}

		if(window.pageExt.form.beforeInit) {
			window.pageExt.form.beforeInit();
		}

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
			if(area==null) return;
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
				var defaultValues="".split(",");
				var defaultIndexs="".split(",");
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
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
				var defaultValues="".split(",");
				var defaultIndexs="".split(",");
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
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
				var defaultValues="".split(",");
				var defaultIndexs="".split(",");
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		laydate.render({
			elem: '#lastdrillDate',
			format:"yyyy-MM-dd",
			trigger:"click"
		});
		laydate.render({
			elem: '#onlineDate',
			format:"yyyy-MM-dd",
			trigger:"click"
		});
		laydate.render({
			elem: '#offlineDate',
			format:"yyyy-MM-dd",
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
				var defaultValues="".split(",");
				var defaultIndexs="".split(",");
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		//渲染 voucherIds 下拉字段
		fox.renderSelectBox({
			el: "voucherIds",
			radio: false,
			filterable: true,
			//转换数据
			searchField: "voucher", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues="".split(",");
				var defaultIndexs="".split(",");
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].voucher,value:data[i].user_code,selected:(defaultValues.indexOf(data[i].user_code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
	}

	/**
      * 填充表单数据
      */
	function fillFormData(formData) {
		if(!formData) {
			formData = admin.getTempData('ops-information-system-form-data');
		}

		window.pageExt.form.beforeDataFill && window.pageExt.form.beforeDataFill(formData);

		var hasData=true;
		//如果是新建
		if(!formData || !formData.id) {
			adjustPopup();
			hasData=false;
		}
		var fm=$('#data-form');
		if (hasData) {
			fm[0].reset();
			form.val('data-form', formData);




			//设置 演练时间 显示复选框勾选
			if(formData["lastdrillDate"]) {
				$("#lastdrillDate").val(fox.dateFormat(formData["lastdrillDate"],"yyyy-MM-dd"));
			}
			//设置 上线时间 显示复选框勾选
			if(formData["onlineDate"]) {
				$("#onlineDate").val(fox.dateFormat(formData["onlineDate"],"yyyy-MM-dd"));
			}
			//设置 下线时间 显示复选框勾选
			if(formData["offlineDate"]) {
				$("#offlineDate").val(fox.dateFormat(formData["offlineDate"],"yyyy-MM-dd"));
			}


			//设置  状态 设置下拉框勾选
			fox.setSelectValue4QueryApi("#status",formData.infoSystemStatus);
			//设置  运维模式 设置下拉框勾选
			fox.setSelectValue4QueryApi("#opsMethod",formData.infoSystemOpsMethod);
			//设置  开发模式 设置下拉框勾选
			fox.setSelectValue4QueryApi("#devMethod",formData.infoSystemDevMethod);
			//设置  系统分级 设置下拉框勾选
			fox.setSelectValue4QueryApi("#grade",formData.infoSystemGrade);

			//处理fillBy

			//
	     	fm.attr('method', 'POST');
	     	fox.fillDialogButtons();
	     	renderFormFields();

			window.pageExt.form.afterDataFill && window.pageExt.form.afterDataFill(formData);

		}

		//渐显效果
		fm.css("opacity","0.0");
        fm.css("display","");
        setTimeout(function (){
            fm.animate({
                opacity:'1.0'
            },100);
        },1);

        //禁用编辑
		if((hasData && disableModify) || (!hasData &&disableCreateNew)) {
			fox.lockForm($("#data-form"),true);
			$("#submit-button").hide();
			$("#cancel-button").css("margin-right","15px")
		} else {
			$("#submit-button").show();
			$("#cancel-button").css("margin-right","0px")
		}

		//调用 iframe 加载过程
		var formIfrs=$(".form-iframe");
		for (var i = 0; i < formIfrs.length; i++) {
			var jsFn=$(formIfrs[i]).attr("js-fn");
			if(window.pageExt.form){
				jsFn=window.pageExt.form[jsFn];
				jsFn && jsFn($(formIfrs[i]),$(formIfrs[i])[0].contentWindow,formData);
			}
		}

	}

	function getFormData() {
		var data=form.val("data-form");



		//获取 状态 下拉框的值
		data["status"]=fox.getSelectedValue("status",false);
		//获取 运维模式 下拉框的值
		data["opsMethod"]=fox.getSelectedValue("opsMethod",false);
		//获取 开发模式 下拉框的值
		data["devMethod"]=fox.getSelectedValue("devMethod",false);
		//获取 系统分级 下拉框的值
		data["grade"]=fox.getSelectedValue("grade",false);

		return data;
	}

	function verifyForm(data) {
		return fox.formVerify("data-form",data,VALIDATE_CONFIG)
	}

	function saveForm(param) {
		var api=moduleURL+"/"+(param.id?"update":"insert");
		var task=setTimeout(function(){layer.load(2);},1000);
		admin.request(api, param, function (data) {
			clearTimeout(task);
			layer.closeAll('loading');
			if (data.success) {
				layer.msg(data.message, {icon: 1, time: 500});
				var index=admin.getTempData('ops-information-system-form-data-popup-index');
				admin.finishPopupCenter(index);
			} else {
				layer.msg(data.message, {icon: 2, time: 1000});
			}
			window.pageExt.form.afterSubmit && window.pageExt.form.afterSubmit(param,data);
		}, "POST");
	}

	/**
      * 保存数据，表单提交事件
      */
    function bindButtonEvent() {

	    form.on('submit(submit-button)', function (data) {
	    	//debugger;
			data.field = getFormData();

			if(window.pageExt.form.beforeSubmit) {
				var doNext=window.pageExt.form.beforeSubmit(data.field);
				if(!doNext) return ;
			}
			//校验表单
			if(!verifyForm(data.field)) return;

			saveForm(data.field);
	        return false;
	    });

		// 请选择组织节点对话框
		$("#belongOrgId-button").click(function(){
			var belongOrgIdDialogOptions={
				field:"belongOrgId",
				formData:getFormData(),
				inputEl:$("#belongOrgId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param,result){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param,result);}
			};
			fox.chooseOrgNode(belongOrgIdDialogOptions);
		});

	    //关闭窗口
	    $("#cancel-button").click(function(){admin.closePopupCenter();});

    }

    window.module={
		getFormData: getFormData,
		verifyForm: verifyForm,
		saveForm: saveForm,
		fillFormData: fillFormData,
		adjustPopup: adjustPopup
	};

	window.pageExt.form.ending && window.pageExt.form.ending();

}

layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','foxnicUpload','laydate'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new FormPage()).init(layui);
	},1);
});