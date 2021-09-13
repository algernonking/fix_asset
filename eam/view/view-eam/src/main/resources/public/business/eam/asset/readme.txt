	//渲染 categoryId 下拉字段
		var categorySelect = xmSelect.render({
			el: '#categoryId',
			prop: {
				name: 'name',
				value: 'id',
			},
			filterable: true,
			tree: {
				show: true,
				strict: true,
				expandedKeys: [ -1],
			},
			//处理方式
			on: function(data){
				if(data.isAdd){
					return data.change.slice(0, 1)
				}
			},
			//显示为text模式
			model: { label: { type: 'text' } },
			//单选模式
			radio: true,
			//选中关闭
			clickClose: true,
			height: 'auto',
			data:ASSET_CATEGORY_DATA
		})