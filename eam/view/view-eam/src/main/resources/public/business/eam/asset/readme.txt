height=800;
		var index=admin.popupCenter({
			title: title,
			resize: false,
			offset: ['30px'],
			area: ["95%",height+"px"],
			type: 2,
			id:"eam-asset-form-data-win",
			content: '/business/eam/asset/asset_form_base.html' + queryString,
			finish: function () {
				refreshTableData();
			}
		});
		admin.putTempData('eam-asset-form-data-popup-index', index);