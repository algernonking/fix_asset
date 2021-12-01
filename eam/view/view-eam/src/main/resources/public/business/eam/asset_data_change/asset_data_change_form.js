/**
 * 数据变更 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-08 16:01:33
 */

function FormPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
	const moduleURL="/service-eam/eam-asset-data-change";

	var disableCreateNew=false;
	var disableModify=false;
	var action=null;
	var categorySelect;
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
		laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

		action=admin.getTempData('eam-asset-data-change-form-data-form-action');
		//如果没有修改和保存权限，
		if( !admin.checkAuth(AUTH_PREFIX+":update") && !admin.checkAuth(AUTH_PREFIX+":save")) {
			disableModify=true;
		}
		if(action=="view") {
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
			admin.putTempData('eam-asset-data-change-form-area', area);
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


		//渲染 categoryId 下拉字段
		categorySelect = xmSelect.render({
			el: '#categoryId',
			prop: {
				name: 'name',
				value: 'id',
			},
			filterable: true,
			tree: {
				showFolderIcon: true,
				show: true,
				strict: false,
				expandedKeys: [ -1],
			},
			//处理方式
			on: function(data){
				if(data.isAdd){
					var result=data.change.slice(0, 1);
					var ps={}
					if(result.length==1){
						ps={categoryId:result[0].id}
					}
					return result;
				}

			},
			//显示为text模式
			model: { label: { type: 'text' } },
			//单选模式
			radio: true,
			//选中关闭
			clickClose: true,
			height: '450px',
			data:ASSET_CATEGORY_DATA
		})
		//渲染 status 下拉字段
		fox.renderSelectBox({
			el: "status",
			radio: true,
			filterable: false,
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({name:data[i].text,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});

		//渲染 sourceId 下拉字段
		fox.renderSelectBox({
			el: "sourceId",
			radio: true,
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});

		//渲染 assetStatus 下拉字段
		fox.renderSelectBox({
			el: "assetStatus",
			radio: true,
			filterable: false,
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({name:data[i].text,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});


		//渲染 goodsId 下拉字段
		fox.renderSelectBox({
			el: "goodsId",
			radio: true,
			paging: true,
			pageRemote: true,
			filterable: true,
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		//渲染 manufacturerId 下拉字段
		fox.renderSelectBox({
			el: "manufacturerId",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "manufacturerName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].manufacturerName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});

		foxup.render({
			el:"attach",
			maxFileCount: 1,
			displayFileName: true,
			accept: "file",
			afterPreview:function(elId,index,fileId,upload){
				adjustPopup();
			},
			afterUpload:function (result,index,upload) {
				console.log("文件上传后回调")
			},
			beforeRemove:function (elId,fileId,index,upload) {
				console.log("文件删除前回调");
				return true;
			},
			afterRemove:function (elId,fileId,index,upload) {
				adjustPopup();
			}
		});

		foxup.render({
			el:"pictureId",
			maxFileCount: 1,
			displayFileName: false,
			accept: "image",
			acceptMime:'image/*',
			exts:'png|jpg|bmp|gif|jpeg',
			afterPreview:function(elId,index,fileId,upload){
				adjustPopup();
			},
			afterUpload:function (result,index,upload) {
				console.log("文件上传后回调")
			},
			beforeRemove:function (elId,fileId,index,upload) {
				console.log("文件删除前回调");
				return true;
			},
			afterRemove:function (elId,fileId,index,upload) {
				adjustPopup();
			}
		});


		//渲染 positionId 下拉字段
		fox.renderSelectBox({
			el: "positionId",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "name", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].name,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		//渲染 warehouseId 下拉字段
		fox.renderSelectBox({
			el: "warehouseId",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "warehouseName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].warehouseName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});




		//渲染 maintainerId 下拉字段
		fox.renderSelectBox({
			el: "maintainerId",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "maintainerName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].maintainerName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});

		//渲染 safetyLevelCode 下拉字段
		fox.renderSelectBox({
			el: "safetyLevelCode",
			radio: true,
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});
		//渲染 maintenanceStatus 下拉字段
		fox.renderSelectBox({
			el: "maintenanceStatus",
			radio: true,
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});

		//渲染 equipmentStatus 下拉字段
		fox.renderSelectBox({
			el: "equipmentStatus",
			radio: true,
			filterable: false,
			//转换数据
			transform:function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					opts.push({name:data[i].text,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});

		//渲染 equipmentEnvironmentCode 下拉字段
		fox.renderSelectBox({
			el: "equipmentEnvironmentCode",
			radio: true,
			filterable: false,
			//转换数据
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].label,value:data[i].code,selected:(defaultValues.indexOf(data[i].code)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});



		//渲染 financialCategoryId 下拉字段
		fox.renderSelectBox({
			el: "financialCategoryId",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "hierarchyName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].hierarchyName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});

		//渲染 supplierId 下拉字段
		fox.renderSelectBox({
			el: "supplierId",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			on: function(data){
				setTimeout(function () {
					window.pageExt.form.onSelectBoxChanged && window.pageExt.form.onSelectBoxChanged("supplierId",data.arr,data.change,data.isAdd);
				},1);
			},
			//转换数据
			searchField: "supplierName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues = "".split(",");
					defaultIndexs = "".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({data:data[i],name:data[i].supplierName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});

		//渲染 rackId 下拉字段
		fox.renderSelectBox({
			el: "rackId",
			radio: true,
			filterable: true,
			paging: true,
			pageRemote: true,
			//转换数据
			searchField: "rackName", //请自行调整用于搜索的字段名称
			extraParam: {}, //额外的查询参数，Object 或是 返回 Object 的函数
			transform: function(data) {
				//要求格式 :[{name: '水果', value: 1},{name: '蔬菜', value: 2}]
				var defaultValues=[],defaultIndexs=[];
				if(action=="create") {
					defaultValues="".split(",");
					defaultIndexs="".split(",");
				}
				var opts=[];
				if(!data) return opts;
				for (var i = 0; i < data.length; i++) {
					if(!data[i]) continue;
					opts.push({name:data[i].rackName,value:data[i].id,selected:(defaultValues.indexOf(data[i].id)!=-1 || defaultIndexs.indexOf(""+i)!=-1)});
				}
				return opts;
			}
		});


		laydate.render({
			elem: '#entryTime',
			format:"yyyy-MM-dd HH:mm:ss",
			trigger:"click"
		});

		laydate.render({
			elem: '#productionDate',
			format:"yyyy-MM-dd",
			trigger:"click"
		});

		laydate.render({
			elem: '#purchaseDate',
			format:"yyyy-MM-dd",
			trigger:"click"
		});

		laydate.render({
			elem: '#maintenanceStartDate',
			format:"yyyy-MM-dd",
			trigger:"click"
		});
		laydate.render({
			elem: '#maintenanceEndDate',
			format:"yyyy-MM-dd",
			trigger:"click"
		});

		laydate.render({
			elem: '#lastVerificationDate',
			format:"yyyy-MM-dd",
			trigger:"click"
		});

		laydate.render({
			elem: '#registerDate',
			format:"yyyy-MM-dd",
			trigger:"click"
		});

	}

	/**
      * 填充表单数据
      */
	function fillFormData(formData) {
		if(!formData) {
			formData = admin.getTempData('eam-asset-data-change-form-data');
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




			//设置 图片 显示附件
			if($("#pictureId").val()) {
				foxup.fill("pictureId",$("#pictureId").val());
			} else {
				adjustPopup();
			}
			//设置 附件 显示附件
			if($("#attach").val()) {
				foxup.fill("attach",$("#attach").val());
			} else {
				adjustPopup();
			}

			//设置 采购日期 显示复选框勾选
			if(formData["purchaseDate"]) {
				$("#purchaseDate").val(fox.dateFormat(formData["purchaseDate"],"yyyy-MM-dd"));
			}
			//设置 开始时间 显示复选框勾选
			if(formData["maintenanceStartDate"]) {
				$("#maintenanceStartDate").val(fox.dateFormat(formData["maintenanceStartDate"],"yyyy-MM-dd"));
			}
			//设置 结束时间 显示复选框勾选
			if(formData["maintenanceEndDate"]) {
				$("#maintenanceEndDate").val(fox.dateFormat(formData["maintenanceEndDate"],"yyyy-MM-dd"));
			}
			//设置 入账时间 显示复选框勾选
			if(formData["entryTime"]) {
				$("#entryTime").val(fox.dateFormat(formData["entryTime"],"yyyy-MM-dd HH:mm:ss"));
			}

			//设置 结束时间 显示复选框勾选
			if(formData["lastVerificationDate"]) {
				$("#lastVerificationDate").val(fox.dateFormat(formData["lastVerificationDate"],"yyyy-MM-dd"));
			}
			//设置 生产日期 显示复选框勾选
			if(formData["productionDate"]) {
				$("#productionDate").val(fox.dateFormat(formData["productionDate"],"yyyy-MM-dd"));
			}
			//设置 生产日期 显示复选框勾选
			if(formData["registerDate"]) {
				$("#registerDate").val(fox.dateFormat(formData["registerDate"],"yyyy-MM-dd"));
			}


			fox.setSelectValue4Enum("#status",formData.status,SELECT_STATUS_DATA);
			//设置  资产状态 设置下拉框勾选
			fox.setSelectValue4Enum("#assetStatus",formData.assetStatus,SELECT_ASSETSTATUS_DATA);

			//设置  设备状态 设置下拉框勾选
			fox.setSelectValue4QueryApi("#maintenanceStatus",formData.assetMaintenanceStatus);

			//设置  物品档案 设置下拉框勾选
			fox.setSelectValue4QueryApi("#goodsId",formData.goods);
			//设置  厂商 设置下拉框勾选
			fox.setSelectValue4QueryApi("#manufacturerId",formData.manufacturer);
			//设置  位置 设置下拉框勾选
			fox.setSelectValue4QueryApi("#positionId",formData.position);
			//设置  仓库 设置下拉框勾选
			fox.setSelectValue4QueryApi("#warehouseId",formData.warehouse);
			//设置  来源 设置下拉框勾选
			fox.setSelectValue4QueryApi("#sourceId",formData.source);
			//设置  维保商 设置下拉框勾选
			fox.setSelectValue4QueryApi("#maintainerId",formData.maintnainer);
			//设置  财务分类 设置下拉框勾选
			fox.setSelectValue4QueryApi("#financialCategoryId",formData.categoryFinance);
			//设置  供应商 设置下拉框勾选
			fox.setSelectValue4QueryApi("#supplierId",formData.supplier);

			//设置  安全等级 设置下拉框勾选
			fox.setSelectValue4QueryApi("#safetyLevelCode",formData.safetyLevel);
			//处理fillBy

			//设置  运行环境 设置下拉框勾选
			fox.setSelectValue4QueryApi("#equipmentEnvironmentCode",formData.equipmentEnvironment);

			//设置  机柜 设置下拉框勾选
			fox.setSelectValue4QueryApi("#rackId",formData.rack);

			setTimeout(function(){
				if(categorySelect){
					if(formData.category&&formData.category.id){
						categorySelect.setValue(formData.category.id.split(","));
					}
				//	categorySelect.update({disabled:true})
				}
			},150)


			//设置 变更日期 显示复选框勾选
			if(formData["changeDate"]) {
				$("#changeDate").val(fox.dateFormat(formData["changeDate"],"yyyy-MM-dd"));
			}

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




		//获取 资产分类 下拉框的值
		data["categoryId"]=fox.getSelectedValue("categoryId",false);
		//获取 办理状态 下拉框的值
		data["status"]=fox.getSelectedValue("status",false);


		//获取 资产状态 下拉框的值
		data["assetStatus"]=fox.getSelectedValue("assetStatus",false);
		if(!data["assetStatus"]){
			data["assetStatus"]="";
		}

		//获取 物品档案 下拉框的值
		data["goodsId"]=fox.getSelectedValue("goodsId",false);
		if(!data["goodsId"]){
			data["goodsId"]="";
		}


		//获取 厂商 下拉框的值
		data["manufacturerId"]=fox.getSelectedValue("manufacturerId",false);
		if(!data["manufacturerId"]){
			data["manufacturerId"]="";
		}

		//获取 位置 下拉框的值
		data["positionId"]=fox.getSelectedValue("positionId",false);
		if(!data["positionId"]){
			data["positionId"]="";
		}


		//获取 仓库 下拉框的值
		data["warehouseId"]=fox.getSelectedValue("warehouseId",false);
		if(!data["warehouseId"]){
			data["warehouseId"]="";
		}


		//获取 来源 下拉框的值
		data["sourceId"]=fox.getSelectedValue("sourceId",false);
		if(!data["sourceId"]){
			data["sourceId"]="";
		}

		//获取 维保商 下拉框的值
		data["maintainerId"]=fox.getSelectedValue("maintainerId",false);
		if(!data["maintainerId"]){
			data["maintainerId"]="";
		}

		//获取 财务分类 下拉框的值
		data["financialCategoryId"]=fox.getSelectedValue("financialCategoryId",false);
		if(!data["financialCategoryId"]){
			data["financialCategoryId"]="";
		}

		//获取 供应商 下拉框的值
		data["supplierId"]=fox.getSelectedValue("supplierId",false);
		if(!data["supplierId"]){
			data["supplierId"]="";
		}


		data["equipmentStatus"]=fox.getSelectedValue("equipmentStatus",false);
		if(!data["equipmentStatus"]){
			data["equipmentStatus"]="";
		}

		data["maintenanceStatus"]=fox.getSelectedValue("maintenanceStatus",false);
		if(!data["maintenanceStatus"]){
			data["maintenanceStatus"]="";
		}

		data["safetyLevelCode"]=fox.getSelectedValue("safetyLevelCode",false);
		if(!data["safetyLevelCode"]){
			data["safetyLevelCode"]="";
		}

		data["equipmentEnvironmentCode"]=fox.getSelectedValue("equipmentEnvironmentCode",false);
		if(!data["equipmentEnvironmentCode"]){
			data["equipmentEnvironmentCode"]="";
		}

		data["rackId"]=fox.getSelectedValue("rackId",false);
		if(!data["rackId"]){
			data["rackId"]="";
		}


		return data;
	}

	function verifyForm(data) {
		return fox.formVerify("data-form",data,VALIDATE_CONFIG)
	}

	function saveForm(param) {
		param.changeType=CHANGE_TYPE;
		var api=moduleURL+"/"+(param.id?"update":"insert");
		admin.post(api,param,function (r){
			if (r.success) {
				layer.msg(r.message, {icon: 1, time: 500});
				var index=admin.getTempData('eam-asset-data-change-form-data-popup-index');
				admin.finishPopupCenter(index);
			} else {
				layer.msg(r.message, {icon: 2, time: 1000});
			}
			window.pageExt.form.afterSubmit && window.pageExt.form.afterSubmit(param,r);
		},{delayLoading:1000,elms:[$('submit-button')]});


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

		// 请选择公司对话框
		$("#ownCompanyId-button").click(function(){
			var ownCompanyIdDialogOptions={
				field:"ownCompanyId",
				formData:getFormData(),
				inputEl:$("#ownCompanyId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"com",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseOrgNode(ownCompanyIdDialogOptions);
		});
		// 请选择人员对话框
		$("#managerId-button").click(function(){
			var managerIdDialogOptions={
				field:"managerId",
				formData:getFormData(),
				inputEl:$("#managerId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseEmployee(managerIdDialogOptions);
		});
		// 请选择组织节点对话框
		$("#useOrganizationId-button").click(function(){
			var useOrganizationIdDialogOptions={
				field:"useOrganizationId",
				formData:getFormData(),
				inputEl:$("#useOrganizationId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"org",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseOrgNode(useOrganizationIdDialogOptions);
		});
		// 请选择人员对话框
		$("#useUserId-button").click(function(){
			var useUserIdDialogOptions={
				field:"useUserId",
				formData:getFormData(),
				inputEl:$("#useUserId"),
				buttonEl:$(this),
				single:true,
				//限制浏览的范围，指定根节点 id 或 code ，优先匹配ID
				root: "",
				targetType:"emp",
				prepose:function(param){ return window.pageExt.form.beforeDialog && window.pageExt.form.beforeDialog(param);},
				callback:function(param){ window.pageExt.form.afterDialog && window.pageExt.form.afterDialog(param);}
			};
			fox.chooseEmployee(useUserIdDialogOptions);
		});



		//关闭窗口
	    $("#cancel-button").click(function(){
	    	console.log("close")

	    	admin.closePopupCenter();
	    });

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