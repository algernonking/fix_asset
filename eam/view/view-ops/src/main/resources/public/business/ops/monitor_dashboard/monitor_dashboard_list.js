/**
 * 存放位置 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 12:47:14
 */

function ListPage() {
    var settings,admin,table,layer,util,fox,upload,xmSelect,echarts;

    const moduleURL="/service-ops/ops-statistics";
    //模块基础路径
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {
        admin = layui.admin,settings = layui.settings,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;

        echarts=layui.echarts;

        // var assetCata = echarts.init(document.getElementById('assetCata'));
        // var assetStatusPie = echarts.init(document.getElementById('assetStatusPie'));
        admin.request("/service-ops/ops-statistics/query-node-statistics", {}, function (data) {
            if(data.success){
                var nodeStatistics=data.data.nodeStatistics;
                for(var i=0;i<nodeStatistics.length;i++){
                    var item=nodeStatistics[i];
                    var code=item.code;
                    if(code=="os"){
                        $("#osCnt").html(item.cnt);
                    }else if(code=="db"){
                        $("#dbCnt").html(item.cnt);
                    }else if(code=="mid"){
                        $("#midCnt").html(item.cnt);
                    }else if(code=="network"){
                        $("#networkCnt").html(item.cnt);
                    }
                }
            }else{
                alert("获取数据失败!");
            }
        });

        //top数据
        var topPs={};
        var list=[];
        list.push("os_load");
        list.push("os_cpu_used");
        list.push("fs_used");
        list.push("os_p_memory_used");
        // list.push("os_net_flow_up");
        // list.push("os_net_flow_down");
        topPs.topList=list;
        topPs.top=5;
        topPs.day=5;
        var task=setTimeout(function(){layer.load(2);},1000);
        admin.request("/service-ops/ops-statistics/query-node-host-top-data", topPs, function (data) {
            clearTimeout(task);
            layer.closeAll('loading');
            if(data.success){
                var dataLoad=data.data.osLoad;
                var dataCpu=data.data.osCpuUsed;
                var dataFs=data.data.osFs;
                var dataMemoryUsed=data.data.osPMemoryUsed;
                var dataFlowUp=data.data.osNetFlowUp;
                var dataFlowDown=data.data.osNetFlowDown;
                var cpuhtml="<tr>\n" +
                    "<th>主机名称</th>\n" +
                    "<th>CPU使用率</th>\n" +
                    "</tr>";
                for(var i=0;i<dataCpu.length;i++){
                        cpuhtml=cpuhtml+"<tr>\n" +
                        "    <td>"+dataCpu[i].nodeNameShow+"_"+dataCpu[i].nodeIp+"</td>\n" +
                        "    <td>"+dataCpu[i].cpuUsed+"%</td>\n" +
                        "  </tr>"
                }
                $("#dataCpu").html(cpuhtml);

                var loadhtml="<tr>\n" +
                    "<th>主机名称</th>\n" +
                    "<th>系统负载</th>\n" +
                    "</tr>";
                for(var i=0;i<dataLoad.length;i++){
                    loadhtml=loadhtml+"<tr>\n" +
                        "    <td>"+dataLoad[i].nodeNameShow+"_"+dataLoad[i].nodeIp+"</td>\n" +
                        "    <td>"+dataLoad[i].osLoad+"</td>\n" +
                        "  </tr>"
                }
                $("#dataLoad").html(loadhtml);

                var memhtml="<tr>\n" +
                    "<th>主机名称</th>\n" +
                    "<th>内存使用率</th>\n" +
                    "</tr>";
                for(var i=0;i<dataMemoryUsed.length;i++){
                    memhtml=memhtml+"<tr>\n" +
                        "    <td>"+dataMemoryUsed[i].nodeNameShow+"_"+dataMemoryUsed[i].nodeIp+"</td>\n" +
                        "    <td>"+dataMemoryUsed[i].pMemoryUsed+"%</td>\n" +
                        "  </tr>"
                }
                $("#dataMem").html(memhtml);


                var fshtml="<tr>\n" +
                    "<th>主机名称</th>\n" +
                    "<th>挂载点</th>\n" +
                    "<th>使用率</th>\n" +
                    "</tr>";
                for(var i=0;i<dataMemoryUsed.length;i++){
                    fshtml=fshtml+"<tr>\n" +
                        "    <td>"+dataFs[i].nodeNameShow+"_"+dataFs[i].nodeIp+"</td>\n" +
                        "    <td>"+dataFs[i].fsName+"</td>\n" +
                        "    <td>"+dataFs[i].pct+"%</td>\n" +
                        "  </tr>"
                }
                $("#dataFs").html(fshtml);


            }else{
                alert("获取数据失败!");
            }
        });


        //var task=setTimeout(function(){layer.load(2);},1000);
        // admin.request(moduleURL+"/dashboard", {}, function (data) {
        //     clearTimeout(task);
        //     layer.closeAll('loading');
        //     if(data.success){
        //         var assetData=data.data;
        //         $("#assetOriginalUnitPrice").html(assetData.assetData.assetOriginalUnitPrice);
        //         $("#assetCnt").html(assetData.assetData.assetCnt);
        //         $("#assetCleanCnt").html(assetData.assetData.assetCleanCnt);
        //         $("#assetRepairCnt").html(assetData.assetData.assetRepairCnt);
        //
        //         var html="<tr>\n" +
        //             "<th>资产状态</th>\n" +
        //             "<th>数量</th>\n" +
        //             "<th>金额</th>\n" +
        //             "</tr>";
        //         for(var i=0;i<assetData.assetStatusData.length;i++){
        //             html=html+" <tr>\n" +
        //                 "    <td>"+assetData.assetStatusData[i].name+"</td>\n" +
        //                 "    <td>"+assetData.assetStatusData[i].cnt+"</td>\n" +
        //                 "    <td>"+assetData.assetStatusData[i].assetOriginalUnitPrice+"</td>\n" +
        //                 "  </tr>"
        //         }
        //
        //         $("#assetStatus").html(html);
        //
        //
        //         var optionchart = {
        //             title: {
        //                 text: '资产分类'
        //             },
        //             tooltip: {},
        //             legend: {
        //                 data: ['数量']
        //             },
        //             xAxis: {
        //                 data: assetData.catalogNameData
        //             },
        //             yAxis: {
        //                 type: 'value'
        //             },
        //             series: [{
        //                 name: '数量',
        //                 type: 'bar', //柱状
        //                 data:assetData.catalogCountData,
        //                 label:{
        //                     normal:{
        //                         show:true,
        //                         position:"top",
        //                     }
        //                 },
        //                 itemStyle: {
        //                     normal: { //柱子颜色
        //                         color: 'blue'
        //                     }
        //                 },
        //             }]
        //         };
        //         assetCata.setOption(optionchart, true);
        //
        //         assetStatusPie.setOption({
        //             series : [
        //                 {
        //                     name: '资产状态占比',
        //                     type: 'pie',    // 设置图表类型为饼图
        //                     radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
        //                     label:{
        //                         normal:{
        //                             show:true,
        //                             formatter:'{b}:{c}({d}%)'
        //                         }
        //                     },
        //                     data:assetData.assetStatusPieData
        //                 }
        //             ]
        //         })
        //
        //     }else{
        //         alert("获取数据失败!");
        //     }
        //
        //
        // });
        //



    }

};


layui.use(['echarts', 'util', 'settings','admin'],function() {
    var task=setInterval(function (){
        if(!window["pageExt"]) return;
        clearInterval(task);
        (new ListPage()).init(layui);
    },1);
});