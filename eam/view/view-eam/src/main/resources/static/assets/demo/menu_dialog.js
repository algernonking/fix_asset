/**
 * 菜单 列表页 JS 脚本
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-06-08 10:22:55
 */


function ListPage() {

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-oauth/sys-menu";

	var menuTree;

	/**
	 * 入口函数，初始化
	 */
	this.init=function(layui) {

		admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;
		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

		var roleId=QueryString.GetValue('roleId');
		if(!roleId) roleId="";

		//debugger
		//form.render("check-mode");
		//form.render('checkbox');

		var cfgs = {
			edit: {
				enable: false
			},
			check: {
				enable: true,
				autoCheckTrigger: true
			},
			async: {
				enable: true,
				contentType:"application/json",
				url:moduleURL+"/query-nodes",
				autoParam:["id=parentId"],
				otherParam:{roleId:roleId,isLoadAllDescendants:1},
				dataFilter: nodeDatafilter
			},
			callback: {
				// onRename : onNodeRename,
				// beforeRemove : beforeNodeRemove,
				// onDrop : onNodeDrop,
				// onClick: onNodeClick
			},
			view: {
				// addHoverDom: addHoverDom,
				// removeHoverDom: removeHoverDom
			}
		};
		menuTree=$.fn.zTree.init($("#menu-tree"), cfgs);

		//树的关联选择控制
		form.on('checkbox(check-mode)', function (data) {
			if( data.elem.checked) {
				menuTree.setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
			} else {
				menuTree.setting.check.chkboxType = { "Y" : "", "N" : "" };
			}
		});




		setTimeout(function(){
			// debugger
			var toolbarHeight=$(".model-form-footer")[0].clientHeight;
			var fullHeight=$(window).height();
			var fullWidth=$(window).width();
			var treeHeight=fullHeight-1-toolbarHeight;
			$("#tree-container").height(treeHeight);
		},10);
	}



	function nodeDatafilter(treeId, parentNode, childNodes) {
		//debugger;
		childNodes=childNodes.data;
		if (!childNodes) return null;
		for (var i=0, l=childNodes.length; i<l; i++) {

		}
		return childNodes;
	}

	$("#sure-button").click(function () {
		var nodes=menuTree.getCheckedNodes(true);
		console.log(nodes);
		var menuIds=[];
		for (let i = 0; i <nodes.length ; i++) {
			menuIds.push(nodes[i].id);
		}
		admin.putTempData("selected-role-menu-ids",menuIds);
		admin.closePopupCenter();
	});

};


layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util', 'settings',  'upload','foxnic','xmSelect'],function() {
	(new ListPage()).init(layui);
});