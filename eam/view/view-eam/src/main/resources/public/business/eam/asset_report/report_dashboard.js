/**
 * 存放位置 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-12 12:47:14
 */

function ListPage() {
    var settings,admin,table,layer,util,fox,upload,xmSelect,echarts;

    const moduleURL="/service-eam/eam-asset-report";
    //模块基础路径
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {
        admin = layui.admin,settings = layui.settings,upload = layui.upload,laydate= layui.laydate;
        table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect,dropdown=layui.dropdown;;
        echarts=layui.echarts;
        var assetCata = echarts.init(document.getElementById('assetCata'));
        var assetStatusPie = echarts.init(document.getElementById('assetStatusPie'));
        var ownerAssetPie = echarts.init(document.getElementById('ownerAssetPie'));
        var posAssetPie = echarts.init(document.getElementById('posAssetPie'));
        var task=setTimeout(function(){layer.load(2);},1000);
        admin.request(moduleURL+"/dashboard", {}, function (data) {
            clearTimeout(task);
            console.log("FWdata",data);
            layer.closeAll('loading');
            if(data.success){
                var assetData=data.data;
                $("#assetOriginalUnitPrice").html(assetData.assetData.assetOriginalUnitPrice);
                $("#assetCnt").html(assetData.assetData.assetCnt);
                $("#assetCleanCnt").html(assetData.assetData.assetCleanCnt);
                $("#assetRepairCnt").html(assetData.assetData.assetRepairCnt);
                $("#maintenanceEndCnt").html(assetData.assetData.maintenanceEndCnt);
                var html="<tr>\n" +
                    "<th>资产状态</th>\n" +
                    "<th>数量</th>\n" +
                    "<th>金额</th>\n" +
                    "</tr>";
                for(var i=0;i<assetData.assetStatusData.length;i++){
                    html=html+" <tr>\n" +
                        "    <td>"+assetData.assetStatusData[i].name+"</td>\n" +
                        "    <td>"+assetData.assetStatusData[i].cnt+"</td>\n" +
                        "    <td>"+assetData.assetStatusData[i].assetOriginalUnitPrice+"</td>\n" +
                        "  </tr>"
                }
                $("#assetStatus").html(html);

                var optionchart = {
                    title: {
                        text: '资产分类'
                    },
                    tooltip: {},
                    legend: {
                        data: ['数量']
                    },
                    xAxis: {
                        data: assetData.catalogNameData
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        name: '数量',
                        type: 'bar', //柱状
                        data:assetData.catalogCountData,
                        label:{
                            normal:{
                                show:true,
                                position:"top",
                            }
                        },
                        itemStyle: {
                            normal: { //柱子颜色
                                color: 'blue'
                            }
                        },
                    }]
                };
                assetCata.setOption(optionchart, true);

                assetStatusPie.setOption({
                    series : [
                        {
                            name: '资产状态占比',
                            type: 'pie',    // 设置图表类型为饼图
                            radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                            label:{
                              normal:{
                                  show:true,
                                  formatter:'{b}:{c}({d}%)'
                              }
                            },
                            data:assetData.assetStatusPieData
                        }
                    ]
                })

                ownerAssetPie.setOption({
                    title:{
                        text:"资产所属公司",
                        show:true,
                        textStyle:{
                            fontSize:20
                        }
                    },
                    series : [
                        {
                            name: '所属公司占比',
                            type: 'pie',    // 设置图表类型为饼图
                            radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                            label:{
                                normal:{
                                    show:true,
                                    formatter:'{b}:{c}({d}%)'
                                }
                            },
                            data:assetData.ownerAssetPieData
                        }
                    ]
                })

                posAssetPie.setOption({
                    title:{
                        text:"存放位置占比",
                        show:true,
                        textStyle:{
                            fontSize:20
                        }
                    },
                    series : [
                        {
                            name: '资产存放位置',
                            type: 'pie',    // 设置图表类型为饼图
                            radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
                            label:{
                                normal:{
                                    show:true,
                                    formatter:'{b}:{c}({d}%)'
                                }
                            },
                            data:assetData.posAssetPieData
                        }
                    ]
                })



            }else{
                alert("获取数据失败!");
            }


        });




    }

};


layui.use(['echarts', 'util', 'settings','admin'],function() {
    var task=setInterval(function (){
        if(!window["pageExt"]) return;
        clearInterval(task);
        (new ListPage()).init(layui);
    },1);
});