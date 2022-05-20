/**
 * 资产 列表页 JS 脚本
 * @author 金杰 , maillank@qq.com
 * @since 2021-10-26 15:27:48
 */

function FormPage() {

    var settings,admin,form,table,layer,util,fox,upload,xmSelect,foxup;
    const moduleURL="/service-eam/eam-asset-item";
    var action=null;
    var disableCreateNew=false;
    var disableModify=false;
    /**
     * 入口函数，初始化
     */
    this.init=function(layui) {
        admin = layui.admin,settings = layui.settings,form = layui.form,upload = layui.upload,foxup=layui.foxnicUpload;
        laydate = layui.laydate,table = layui.table,layer = layui.layer,util = layui.util,fox = layui.foxnic,xmSelect = layui.xmSelect;

        action=admin.getTempData('eam-asset-item-form-data-form-action');
        //如果没有修改和保存权限
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

    }

    /**
     * 渲染表单组件
     */
    function renderFormFields() {


    }

    /**
     * 填充表单数据
     */
    function fillFormData(formData) {


    }

    function getFormData() {

    }

    function verifyForm(data) {

    }

    function saveForm(param) {
        alert(1);

    }

    /**
     * 保存数据，表单提交事件
     */
    function bindButtonEvent() {
        form.on('submit(submit-button)', function (data) {

            var ct=luckysheet.getLuckysheetfile()[0];
            console.log(ct);
            var ps={};
            var api="/service-eam/eam-asset-data/batch-import-asset-by-lucky-sheet";
            ps.content=JSON.stringify(ct.data);
            var btn=$('.asset-submit-button');
            top.layer.confirm(fox.translate('确定进行该操作吗？'), function (i) {
                top.layer.close(i);
                admin.post(api, ps, function (r) {
                    if (r.success) {
                        top.layer.msg("保存成功", {time: 1000});
                        admin.finishPopupCenterById('eam-asset-data-batch-insert-data-win');
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
                }, {delayLoading: 1000, elms: [btn]});
            });
            console.log(data);

        });

        //关闭窗口
        $("#cancel-button").click(function(){admin.finishPopupCenterById("eam-asset-item-form-data-win");});

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