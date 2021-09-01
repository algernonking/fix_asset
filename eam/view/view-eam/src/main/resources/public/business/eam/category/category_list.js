/**
 * 资产分类 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-07-31 06:43:11
 */


function ListPage() {
        

	var settings,admin,form,table,layer,util,fox,upload,xmSelect;
	//模块基础路径
	const moduleURL="/service-eam/eam-category";
	
	/**
      * 入口函数，初始化
      */
	this.init=function(layui) {
     	
     	admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload;

		table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

		var cfgs = {
			edit: {
				drag: {
					autoExpandTrigger: false,
					isCopy: false,
					isMove: false
				},
				enable: true,
				showRenameBtn: false
			},
			async: {
				enable: false,
				contentType:"application/json",
				dataFilter: nodeDatafilter
			},
			callback: {
				onRename : onNodeRename,
				beforeRemove : beforeNodeRemove,
				onDrop : onNodeDrop,
				onClick: onNodeClick
			},
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom
			},
			data:{
				key: {
					name: "categoryName"
				},
				simpleData: {
					enable: true,
					idKey: "id",
					pIdKey: "parentId",
					rootPId: 1
				}
			}
		};

		admin.request(moduleURL+"/query-list",{},function(r) {
			if(r.success) {
				menuTree=$.fn.zTree.init($("#menu-tree"), cfgs,r.data);
				var  tmp_nodes = menuTree.getNodes();
				for  ( var  i = 0; i < tmp_nodes.length; i++) {  //设置节点展开
					menuTree.expandNode(tmp_nodes[i],  true ,  false ,  true );
				}
			} else {
				admin.toast().error("获取数据失败",{time:1000,position:"right-bottom"});
			}
		});

		setTimeout(function(){
			var toolbarHeight=$("#toolbar")[0].clientHeight;
			var fullHeight=$(window).height();
			var fullWidth=$(window).width();
			var treeHeight=fullHeight-toolbarHeight-1;
			$("#tree-container").height(treeHeight);
			$("#form-view").height(fullHeight-6);
		},10);

		//bindSearchEvent();
     }


	var editingNode=null;
	function onNodeClick(event, treeId, treeNode) {
		console.log(treeNode);
		if(treeNode==null) return;
		editingNode=treeNode;

		$("#form-view")[0].contentWindow.loadFormData(treeNode.id);
	}

	function onNodeDrop(event, treeId, treeNodes, targetNode, moveType) {
		var ids=[];
		//移动节点
		if(moveType=="inner" || moveType=="prev" || moveType=="next") { // 调整节点顺序
			var parentNode=treeNodes[0].getParentNode();
			var siblings=null;
			var parentId=null;
			//非根节点
			if(parentNode!=null) {
				siblings=parentNode.children;
				parentId=parentNode.id;
			} else {
				//根节点
				siblings=[];
				var prev=null;
				var curr=treeNodes[0];
				while(true) {
					prev=curr.getPreNode();
					if(prev==null) break;
					curr=prev;
				}
				var next=null;
				while(true) {
					siblings.push(curr);
					next=curr.getNextNode();
					if(next==null) break;
					curr=next;
				}
			}
			for (var i = 0; i < siblings.length; i++) {
				ids.push(siblings[i].id);
			}
			saveHierarchy(ids,parentId);
		}  else {
			debugger;
		}
	}


	function saveHierarchy(ids,parentId) {
		admin.request(moduleURL+"/save-hierarchy",{"ids":ids,parentId:parentId},function(r) {
			if(r.success) {
				admin.toast().success("已调整",{time:1000,position:"right-bottom"});
			} else {
				admin.toast().error("调整失败",{time:1000,position:"right-bottom"});
			}
		});
	}

	function beforeNodeRemove(treeId, treeNode) {
		//debugger;
		layer.confirm('确定要删除['+treeNode.categoryName+']菜单吗?', function(index,a,c,d) {
			layer.close(index);
			admin.request(moduleURL+"/delete",{id:treeNode.id},function(r) {
				if(r.success) {
					admin.toast().success("菜单已删除",{time:1000,position:"right-bottom"});
					menuTree.removeNode(treeNode,false);
					if(treeNode.parentTId) {
						menuTree.selectNode({tId:treeNode.parentTId},false,true)
						onNodeClick(null,treeId,menuTree.getNodeByTId(treeNode.parentTId));
					}
				} else {
					admin.toast().error("删除失败 : "+r.message,{time:1000,position:"right-bottom",width:"300px"});
				}
			});
		});
		return false;
	}



	function onNodeRename (event, treeId, treeNode, isCancel) {
		admin.request(moduleURL+"/update",{id:treeNode.id,label:treeNode.name},function(r){
			if(r.success) {
				admin.toast().success("名称已更改",{time:1000,position:"right-bottom"});
				$("#form-view")[0].contentWindow.loadFormData(treeNode.id);
			} else {
				admin.toast().error("名称更改失败",{time:1000,position:"right-bottom"});
			}
		});
	}

	function nodeDatafilter(treeId, parentNode, childNodes) {
		//debugger;
		childNodes=childNodes.data;
		if (!childNodes) return null;
		for (var i=0, l=childNodes.length; i<l; i++) {

		}
		return childNodes;
	}

	function addHoverDom(treeId, treeNode) {
		if(!treeNode.isParent) return;
		var aObj = $("#" + treeNode.tId + "_a");
		if ($("#diyBtn_"+treeNode.id).length>0) return;
		//var editStr = "<span class='button icon01' id='diyBtn_" +treeNode.id+ "' title='"+treeNode.name+"' onfocus='this.blur();'></span>";
		var editStr = "<image tid='"+treeNode.tId+"' style='margin-top:2px' id='diyBtn_" +treeNode.id+ "' src='/assets/libs/zTree/images/refresh-16.png'  onfocus='this.blur();'/>"
		aObj.after(editStr);
		var btn = $("#diyBtn_"+treeNode.id);
		if (btn) btn.bind("click", function() {
			var it=$(this);
			var tid=it.attr("tid");
			var node=menuTree.getNodeByTId(tid);
			menuTree.reAsyncChildNodes(node,'refresh');
		});

	}


	function changeNodeName(id,name) {
		if(editingNode==null) return;
		if(editingNode.id!=id) return;
		editingNode.categoryName=name;
		menuTree.updateNode(editingNode);
	}
	window.changeNodeName=changeNodeName;

	function removeHoverDom(treeId, treeNode) {
		//if (treeNode.parentTId && treeNode.getParentNode().id!=1) return;
//			if (treeNode.id == 15) {
//				$("#diyBtn1_"+treeNode.id).unbind().remove();
//				$("#diyBtn2_"+treeNode.id).unbind().remove();
//			} else {
		$("#diyBtn_"+treeNode.id).unbind().remove();
//				$("#diyBtn_space_" +treeNode.id).unbind().remove();
//			}
	}
	/**
	 * 重置搜索框
	 */
	function resetSearchFields() {
		$('#search-field').val("");
		$('#search-input').val("");
		layui.form.render();
	}

	/**
	 * 绑定搜索框事件
	 */
	var nodeList

	function bindSearchEvent() {
		//回车键查询
		$("#search-input").keydown(function(event) {
			if(event.keyCode !=13) return;
			nodeList=menuTree.getNodesByParamFuzzy("name",$("#search-input").val());
			var sns=menuTree.getSelectedNodes();
			for( var i=0;i<sns.length;  i++) {
				menuTree.cancelSelectedNode(sns[i]);
			}
			for( var i=0;i<nodeList.length;  i++) {
				menuTree.selectNode(nodeList[i],true,true);
			}
		});

	}


	// 添加按钮点击事件
	$('#btn-add').click(function () {
		var nodes=menuTree.getSelectedNodes();
		//默认根节点
		var treeNode=null;
		if(nodes && nodes.length>0) {
			treeNode=nodes[0];
		}
		console.log("select",treeNode);
		admin.request(moduleURL+"/insert",{parentId:treeNode?treeNode.id:"0",categoryName:"新菜单"},function(r) {
			if(r.success) {
				admin.toast().success("菜单已创建",{time:1000,position:"right-bottom"});
				//debugger
				if(treeNode==null) {
					//debugger;
					menuTree.addNodes(null,{id:r.data.id,categoryName:r.data.categoryName});
					return;
				}
				var isLeaf=!treeNode.isParent;
				treeNode.isParent=true;
				menuTree.updateNode(treeNode)
				menuTree.addNodes(treeNode,{id:r.data.id,categoryName:r.data.categoryName,parentId:r.data.parentId});
			} else {
				admin.toast().error("新建菜单失败",{time:1000,position:"right-bottom"});
			}
		},"POST",true);
	});





};


layui.config({
	dir: layuiPath,
	base: '/module/'
}).extend({
	xmSelect: 'xm-select/xm-select'
}).use(['form', 'table', 'util', 'settings', 'upload','foxnic','xmSelect'],function() {
	(new ListPage()).init(layui);
});