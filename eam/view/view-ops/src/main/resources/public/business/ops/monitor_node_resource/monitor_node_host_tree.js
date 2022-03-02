/**
 * 存放位置 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 12:47:18
 */


function ListPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect;
    //模块基础路径
    const moduleURL="/service-ops/ops-statistics";
    var menuTree;
    var dataTable=null;
    var sort=null;
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {
        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;
        if(window.pageExt.list.beforeInit) {
            window.pageExt.list.beforeInit();
        }


        var cfgs = {
            edit: {
                drag: {
                    autoExpandTrigger: false,
                    isCopy: false,
                    isMove: false
                },
                enable: false,
                showRenameBtn: false
            },
            async: {
                enable: false,
                contentType:"application/json",
                dataFilter: nodeDatafilter
            },
            callback: {
                onRename : null,
                onDrop : null,
                beforeRemove : null,
                onClick: onNodeClick
            },
            view: {
              //  addHoverDom: addHoverDom,
              //  removeHoverDom: removeHoverDom
            },
            data:{
                key: {
                    name: "name"
                },
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "parentId",
                    rootPId: 1
                }
            }
        };

        admin.request(moduleURL+"/query-node-tree-resource-list",{},function(r) {
            if(r.success) {
                menuTree=$.fn.zTree.init($("#menu-tree"), cfgs,r.data);
                var  tmp_nodes = menuTree.getNodes();
                for  ( var  i = 0; i < tmp_nodes.length; i++) {  //设置节点展开
                   // menuTree.expandNode(tmp_nodes[i],  true ,  false ,  true );
                }
            } else {
                admin.toast().error("获取数据失败",{time:1000,position:"right-bottom"});
            }
        });

        setTimeout(function(){
          //  var toolbarHeight=$("#toolbar")[0].clientHeight;
            var fullHeight=$(window).height();
            var fullWidth=$(window).width();
            var treeHeight=fullHeight-20-1;
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

        if(treeNode.type=="group"){
            return 0;
        }
        console.log("treeNode:",treeNode);
        $("#chartList")[0].contentWindow.showNodeData(treeNode.id);
    }


    function nodeDatafilter(treeId, parentNode, childNodes) {
        //debugger;
        childNodes=childNodes.data;
        if (!childNodes) return null;
        for (var i=0, l=childNodes.length; i<l; i++) {

        }
        return childNodes;
    }



    /**
     * 绑定搜索框事件
     */
    var nodeList




    window.module={
        // refreshTableData: refreshTableData,
        // getCheckedList: getCheckedList
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