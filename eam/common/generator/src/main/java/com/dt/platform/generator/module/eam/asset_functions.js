
//[listFunction]
/**
 * 打开字典条窗口
 * */
function listFunction(data) {
    admin.putTempData("dictId",data.id,true);
    var index = admin.popupCenter({
        title: "条目",
        resize: false,
        id: 'dictItemsWindow',
        area: ["800px", "600px"],
        type: 2,
        content: "/business/system/dict_item/dict_item_list.html"
    });
}


//[beforeDataFill]
function beforeDataFill(data) {
    //$("#assetCode").prop("disabled",true);
    $("#assetCode").attr("readonly","readonly");
    //$("#warehouseId").hide();
    $("#assetCode").attr('placeholder','系统自动生成');
    console.log("beforeDataFill",data);
}


//[afterDataFill]
function afterDataFill(data) {
    console.log("afterDataFill"+data);
}

//beforeTableDataQuery
function beforeTableDataQuery(data) {
    console.log("afterDataFill"+data);
}