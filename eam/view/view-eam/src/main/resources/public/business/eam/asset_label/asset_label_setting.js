/**
 * 资产标签 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-20 20:59:20
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-eam/eam-asset-label";
	var dataTable=null;
	var sort=null;
	var cardArr=[];
	var curTplId="";
	var labelData={};
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {

     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;

		if(window.pageExt.list.beforeInit) {
			window.pageExt.list.beforeInit();
		}
     	//渲染表格
     	renderTable();
		//初始化搜索输入框组件
		initSearchFields();
		//绑定搜索框事件
		bindSearchEvent();
		//绑定按钮事件
		bindButtonEvent();
		//绑定行操作按钮事件
    	bindRowOperationEvent();
     }


	$("#cust").click(function(){

		alert("未正确配置");
		return 1
		var queryString=""
		var index=admin.popupCenter({
			title: "自定义标签",
			resize: false,
			offset: [15,null],
			area: ["98%","98%"],
			type: 2,
			id:"eam-asset-label-custom-win",
			content: '/business/eam/asset_label/asset_label_setting.html' + queryString,
			finish: function () {
			}
		});
		admin.putTempData('eam-asset-label-custom-popup-index', index);
	});







	function renderLabelHtml(obj){
		console.log("renderLabelHtml",obj);
		var selClass="area-hide";
		var delClass="";
		if(obj.isCustom=="0"){
			delClass="area-hide";
		}

//////////////////////////////////////////////////////////////////////
		var txmPic="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAqAAAAB+CAYAAAD7l6OzAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyhpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTQ1IDc5LjE2MzQ5OSwgMjAxOC8wOC8xMy0xNjo0MDoyMiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6Q0Y5RENDMTEyQjBEMTFFQUEzREU4RDU5MkFEMzMzQjAiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6Q0Y5RENDMTAyQjBEMTFFQUEzREU4RDU5MkFEMzMzQjAiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTkgKE1hY2ludG9zaCkiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo2Q0I3MTk3RDJBQTkxMUVBQTNERThENTkyQUQzMzNCMCIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo2Q0I3MTk3RTJBQTkxMUVBQTNERThENTkyQUQzMzNCMCIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PjjQHPEAAAJgSURBVHja7NbBCoUgEEDRof//Jz/NaNmihTGoI+eAm3i8ZEq6ERF9ZLXWovf+Ws+1kd9/raz/GV0z9p8x58z7jj7HU+ez2xyy9rPTe1X93K08X9XnXOU5et/WzTPze33i96LKefmznysAAGAiAQoAgAAFAECAAgCAAAUAQIACAIAABQBAgAIAIEABAECAAgAgQAEAQIACACBAAQBAgAIAIEABABCgAAAgQAEAEKAAACBAAQAQoAAAIEABABCgAAAIUAAAEKAAAAhQAAAQoAAACFAAAAQoAAAIUAAABCgAAAhQAAAEKAAACFAAAAQoAAACFAAABCgAAAIUAAAEKAAAAhQAAAQoAAACFAAAAQoAAAIUAAABCgAAAhQAAAEKAAACFAAAAQoAgAAFAAABCgCAAAUAAAEKAIAABQBAgAIAgAAFAECAAgCAAAUAQIACAIAABQBAgAIAIEABAECAAgAgQAEAQIACACBAAQBAgAIAIEABABCgAAAgQAEAEKAAACBAAQAQoAAACFAjAABAgAIAIEABAECAAgAgQAEAQIACACBAAQAQoAAAIEABABCgAAAgQAEAEKAAACBAAQAQoAAACFAAABCgAAAIUAAAEKAAAAhQAAAQoAAACFAAAAQoAAAIUAAABCgAAAhQAAAEKAAAAhQAAAQoAAACFAAABCgAAAIUAAAEKAAAAhQAAAEKAAACFAAAAQoAAAIUAAABCgAAAhQAAAEKAIAABQAAAQoAgAAFAAABCgCAAAUAAAEKAIAABQBAgAIAgAAFAECAAgCAAAUAQIACACBAAQBghluAAQBcAt8nVhdygAAAAABJRU5ErkJggg==";
		var rwmPic="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQAAAAEACAYAAABccqhmAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyhpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTQ1IDc5LjE2MzQ5OSwgMjAxOC8wOC8xMy0xNjo0MDoyMiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTkgKE1hY2ludG9zaCkiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6Q0Y5RENDMTgyQjBEMTFFQUEzREU4RDU5MkFEMzMzQjAiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6Q0Y5RENDMTkyQjBEMTFFQUEzREU4RDU5MkFEMzMzQjAiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDpDRjlEQ0MxNjJCMEQxMUVBQTNERThENTkyQUQzMzNCMCIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDpDRjlEQ0MxNzJCMEQxMUVBQTNERThENTkyQUQzMzNCMCIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/Pg4S3ggAABHVSURBVHja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";
		var pic;
		var picAddCss=""
		if(obj.imageShow&&obj.imageShow=="1"){
			if(obj.imageType=="txm"){
				pic=txmPic;
			}else{
				pic=rwmPic;
				picAddCss="style=\"width:80px;height:80px\"";
			}
		}
		var picHtml="";
		picHtml="                         <tr>\n" +
			"                                        <td colspan=\"2\" class=\"text-center\">\n" +
			"                                         <img class=\"barcode-style\" "+picAddCss+" src=\""+pic+"\">"
		picHtml=picHtml+"									 <div class=\"img-bottom-barcode\">barcode</div>\n"

		picHtml=picHtml+"                               </td>\n" +
			"                                    </tr>\n"
//////////////////////////////////////////////////////////////////////

		var trListHtml=""

		var html="   <div onclick=\"event.stopPropagation();cardClick('"+obj.id+"')\" id=\"cd"+obj.id+"\" class=\"op-block showCard relative\">\n" +
			"                        <div style=\"border: 1px solid #000;\">\n" +
			"                            <table cellspacing=\"0\" >\n" +
			"                                <tbody>\n"
		//填充上面图片
		if(obj.imagePosition=="u"){
			html=html+picHtml
		}

		//填充中间图片
		var list=obj.assetLabelItemList;
		if(list&&list.length>0){
			for(var i=0;i<list.length;i++){
				var col=list[i];
				var label=""
				if(col&&col.assetLabelCol&&col.assetLabelCol.colName){
					label=col.assetLabelCol.colName;
				}
				trListHtml=trListHtml+"            <tr>\n" +
					"                                        <td width=\"30\">"+label+"</td>\n" +
					"                                        <td width=\"70\">XXXXXX</td>\n" +
					"                                    </tr>\n";
			}
		}
		html=html+trListHtml
		//填充下方图片
		if(obj.imagePosition=="d"){
			html=html+picHtml
		}

		html=html+"                           </tbody>\n" +
			"                            </table>\n" +
			"                        </div>\n" +
			"                        <div id=\"cdSel"+obj.id+"\" class=\""+selClass+"\">\n" +
			"                            <div class=\"selected-point color-primary \"><i class=\"fa fa-check-circle\"></i></div>\n" +
			"                        </div>\n" +
			"                        <a class=\"cursor-pointer "+delClass+"\" onclick=\"event.stopPropagation();deleteLabel('"+obj.id+"')\">\n" +
			"                            <div class=\"absolute delete-custom-button-style\"><i class=\"fa fa-times\"></i></div>\n" +
			"                        </a>\n" +
			"                    </div>"

		return html;
	}

	window.cardClick=function(value){
		for(var i=0;i<cardArr.length;i++){
			$("#cdSel"+cardArr[i].id).removeClass("area-hide");
			$("#cdSel"+cardArr[i].id).addClass("area-hide");
		}
		curTplId=value;
		$("#cdSel"+value).removeClass("area-hide");

	}

	window.deleteLabel=function(value){
		console.log(value);
		var api="/service-eam/eam-asset-label-tpl/delete";
		top.layer.confirm(fox.translate('确定进行删除本模版吗？'), function (i) {
			top.layer.close(i);
			admin.post(api, {id:value}, function (r) {
				if (r.success) {
					top.layer.msg("操作成功", {time: 1000});
				} else {
					var errs = [];
					if (r.errors) {
						for (var i = 0; i < r.errors.length; i++) {
							if (errs.indexOf(r.errors[i].message) == -1) {
								errs.push(r.errors[i].message);
							}
						}
						top.layer.msg(errs.join("<br>"), {time: 2000});
					} else {
						top.layer.msg(r.message, {time: 2000});
					}
				}
			}, {delayLoading: 1000, elms: []});
		});


	}


	/**
      * 渲染表格
      */
    function renderTable() {


		admin.post("/service-eam/eam-asset-label-tpl/query-list", {}, function (data) {
			if (data.success) {
				cardArr=data.data;
				var html="";
				for(var i=0;i<cardArr.length;i++){
					console.log("####"+i)
					var h="<div class=\"card\" style=\"margin-left: 0%; width: 33.3333%;\">"
					var card=renderLabelHtml(cardArr[i]);
					h=h+card+"</div>";
					html=html+h;
				}
				$("#cardList").html(html);

				admin.post("/service-eam/eam-asset-label/query-asset-label", {}, function (res) {
					if (res.success) {
						labelData=res.data;
						$("#labelWidth").val(labelData.labelWidth);
						$("#labelHeight").val(labelData.labelHeight);
						var radio = document.getElementsByName("paperTypeId");
						var radioLength = radio.length;
						for (var i = 0; i < radioLength; i++) {
							if(labelData.paperTypeId == radio[i].value){
								$(radio[i]).next().click();
							}
						}
						if(labelData.labelTplId){
							curTplId=labelData.labelTplId;
							$("#cdSel"+labelData.labelTplId).removeClass("area-hide");
						}
					} else {
						fox.showMessage(res);
					}
				}, {delayLoading:1000,elms:[]});



			} else {
				fox.showMessage(data);
			}

		}, {delayLoading:1000,elms:[]});




    };

	/**
	 * 刷新单号数据
	 * */
	function refreshRowData(data,remote) {

	}

	/**
      * 刷新表格数据
      */
	function refreshTableData(sortField,sortType,reset) {

	}


	/**
	  * 获得已经选中行的数据,不传入 field 时，返回所有选中的记录，指定 field 时 返回指定的字段集合
	  */
	function getCheckedList(field) {

	}

	/**
	 * 重置搜索框
	 */
	function resetSearchFields() {

	}

	function initSearchFields() {

	}

	/**
	 * 绑定搜索框事件
	 */
	function bindSearchEvent() {

	}

	/**
	 * 绑定按钮事件
	  */
	function bindButtonEvent() {
		form.on('submit(submit-button)', function (data) {
			console.log(data);
			 var ps=data.field;
			 ps.labelTplId=curTplId;
			var api="/service-eam/eam-asset-label/save-asset-label";
			top.layer.confirm(fox.translate('是否保存当前资产标签配置？'), function (i) {
				top.layer.close(i);
				admin.post(api, ps, function (r) {
					if (r.success) {
						top.layer.msg("操作成功", {time: 1000});
					} else {
						var errs = [];
						if (r.errors) {
							for (var i = 0; i < r.errors.length; i++) {
								if (errs.indexOf(r.errors[i].message) == -1) {
									errs.push(r.errors[i].message);
								}
							}
							top.layer.msg(errs.join("<br>"), {time: 2000});
						} else {
							top.layer.msg(r.message, {time: 2000});
						}
					}
				}, {delayLoading: 1000, elms: []});
			});
			 return false;
		});

	}

    /**
     * 绑定行操作按钮事件
     */
    function bindRowOperationEvent() {

    };

    /**
     * 打开编辑窗口
     */
	function showEditForm(data) {

	};

	window.module={
		refreshTableData: refreshTableData,
		refreshRowData: refreshRowData,
		getCheckedList: getCheckedList
	};

	window.pageExt.list.ending && window.pageExt.list.ending();

};


layui.use(['form', 'table', 'util', 'settings', 'admin', 'upload','foxnic','xmSelect','laydate','dropdown'],function() {
	var task=setInterval(function (){
		if(!window["pageExt"]) return;
		clearInterval(task);
		(new ListPage()).init(layui);
	},1);
});