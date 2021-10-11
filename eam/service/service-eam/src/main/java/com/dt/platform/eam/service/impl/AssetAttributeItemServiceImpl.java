package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.StatusShowHideEnum;
import com.dt.platform.constants.enums.eam.AssetAttributeLayoutTypeEnum;
import com.dt.platform.constants.enums.eam.AssetAttributeListStatusEnum;
import com.dt.platform.constants.enums.eam.AssetAttributeOwnerEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetAttribute;
import com.dt.platform.domain.eam.meta.AssetAttributeItemMeta;
import com.dt.platform.eam.service.IAssetAttributeService;
import com.dt.platform.proxy.eam.AssetAttributeItemServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.eam.AssetAttributeItem;
import com.dt.platform.domain.eam.AssetAttributeItemVO;

import java.util.HashMap;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.excel.ExcelStructure;
import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.sql.expr.Select;
import java.util.ArrayList;
import com.dt.platform.eam.service.IAssetAttributeItemService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 资产字段配置项 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-07 14:32:57
*/


@Service("EamAssetAttributeItemService")
public class AssetAttributeItemServiceImpl extends SuperService<AssetAttributeItem> implements IAssetAttributeItemService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }


	@Autowired
	IAssetAttributeService assetAttributeService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}


	/**
	 * 插入实体
	 * @param assetAttributeItem 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetAttributeItem assetAttributeItem) {
		AssetAttribute assetAttribute =  assetAttributeService.getById(assetAttributeItem.getAttributeId());
		if(assetAttribute.getRequiredModify().equals("0")){
			if(!assetAttribute.getRequired().equals(assetAttributeItem.getRequired())){
				String requiredStr="可选";
				if(assetAttribute.getRequired().equals("1")) {
					requiredStr="必选";
				}
				return ErrorDesc.failure().message("当前属性字段必选属性不允许修改,设置为:" +requiredStr);
			}
		}
		Result r=super.insert(assetAttributeItem);
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param assetAttributeItemList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetAttributeItem> assetAttributeItemList) {
		return super.insertList(assetAttributeItemList);
	}
	
	
	/**
	 * 按主键删除 资产字段配置项
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetAttributeItem assetAttributeItem = new AssetAttributeItem();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetAttributeItem.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetAttributeItem);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产字段配置项
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetAttributeItem assetAttributeItem = new AssetAttributeItem();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetAttributeItem.setId(id);
		assetAttributeItem.setDeleted(dao.getDBTreaty().getTrueValue());
		assetAttributeItem.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetAttributeItem.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetAttributeItem,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 更新实体
	 * @param assetAttributeItem 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetAttributeItem assetAttributeItem , SaveMode mode) {
		AssetAttribute assetAttribute =  assetAttributeService.getById(assetAttributeItem.getAttributeId());
		if(assetAttribute.getRequiredModify().equals("0")){
			if(!assetAttribute.getRequired().equals(assetAttributeItem.getRequired())){
				String requiredStr="可选";
				if(assetAttribute.getRequired().equals("1")) {
					requiredStr="必选";
				}
				return ErrorDesc.failure().message("当前属性字段必选属性不允许修改,设置为:" +requiredStr);
			}
		}
		Result r=super.update(assetAttributeItem , mode);
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param assetAttributeItemList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetAttributeItem> assetAttributeItemList , SaveMode mode) {
		return super.updateList(assetAttributeItemList , mode);
	}
	
	
	/**
	 * 按主键更新字段 资产字段配置项
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	} 
	
	
	/**
	 * 按主键获取 资产字段配置项
	 *
	 * @param id 主键
	 * @return AssetAttributeItem 数据对象
	 */
	public AssetAttributeItem getById(String id) {
		AssetAttributeItem sample = new AssetAttributeItem();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}


	@Override
	public List<AssetAttributeItem> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}




	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetAttributeItem> queryList(AssetAttributeItem sample) {
		return super.queryList(sample);
	}



	private void printList(List<AssetAttributeItem> list,String type){
		System.out.println("type:"+type+",total:"+list.size());
		for(int i=0;i<list.size();i++){
			System.out.println("itemId:"+list.get(i).getId()+ ",dimension:"+list.get(i).getDimension()+",code:"+list.get(i).getAttribute().getCode());
		}
	}


	@Override
	public HashMap<String, List<AssetAttributeItem>> queryListColumnByModule(String module,String dim) {

		HashMap<String, List<AssetAttributeItem>> result=new HashMap<String, List<AssetAttributeItem>>();
		AssetAttributeItemVO attributeitemList=new AssetAttributeItemVO();
		String key="attributeListData";
		attributeitemList.setOwnerCode(module);
		attributeitemList.setListShow(StatusShowHideEnum.SHOW.code());
		if(!StringUtil.isBlank(dim)){
			attributeitemList.setDimension(dim);
		}
		List<AssetAttributeItem> attributeItemsListData= queryList(attributeitemList,OrderBy.byAsc("list_sort"));
		join(attributeItemsListData,AssetAttributeItemMeta.ATTRIBUTE);
		result.put(key,attributeItemsListData);
		return result;
	}
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param module  查询条件
	 * @return 查询结果
	 * */
	@Override
	public HashMap<String, List<AssetAttributeItem>> queryFormColumnByModule(String module,String dim) {

		HashMap<String, List<AssetAttributeItem>> result=new HashMap<String, List<AssetAttributeItem>>();
		AssetAttributeItemVO attributeitem=new AssetAttributeItemVO();
		attributeitem.setOwnerCode(module);
		if(!StringUtil.isBlank(dim)){
			attributeitem.setDimension(dim);
		}
		//三栏数据
		attributeitem.setLayoutType(AssetAttributeLayoutTypeEnum.THREE.code());
		attributeitem.setFormShow(StatusShowHideEnum.SHOW.code());
		attributeitem.setLayoutColumn(1);
		List<AssetAttributeItem> attributeItemsData3ColumnOneList=queryList(attributeitem,OrderBy.byAsc("layout_row"));
		join(attributeItemsData3ColumnOneList,AssetAttributeItemMeta.ATTRIBUTE);

		attributeitem.setLayoutColumn(2);
		List<AssetAttributeItem> attributeItemsData3ColumnTwoList=queryList(attributeitem,OrderBy.byAsc("layout_row"));
		join(attributeItemsData3ColumnTwoList,AssetAttributeItemMeta.ATTRIBUTE);

		attributeitem.setLayoutColumn(3);
		List<AssetAttributeItem> attributeItemsData3ColumnThreeList= queryList(attributeitem,OrderBy.byAsc("layout_row"));
		join(attributeItemsData3ColumnThreeList,AssetAttributeItemMeta.ATTRIBUTE);

		result.put("attributeData3Column1",attributeItemsData3ColumnOneList);
		result.put("attributeData3Column2",attributeItemsData3ColumnTwoList);
		result.put("attributeData3Column3",attributeItemsData3ColumnThreeList);
		printList(attributeItemsData3ColumnOneList,"three-1");
		printList(attributeItemsData3ColumnTwoList,"three-2");
		printList(attributeItemsData3ColumnThreeList,"three-3");

		//二栏数据
		attributeitem.setLayoutType(AssetAttributeLayoutTypeEnum.TWO.code());
		attributeitem.setFormShow(StatusShowHideEnum.SHOW.code());
		attributeitem.setLayoutColumn(1);
		List<AssetAttributeItem> attributeItemsData2ColumnOneList=queryList(attributeitem,OrderBy.byAsc("layout_row"));
		join(attributeItemsData2ColumnOneList,AssetAttributeItemMeta.ATTRIBUTE);

		attributeitem.setLayoutColumn(2);
		List<AssetAttributeItem> attributeItemsData2ColumnTwoList=queryList(attributeitem,OrderBy.byAsc("layout_row"));
		join(attributeItemsData2ColumnTwoList,AssetAttributeItemMeta.ATTRIBUTE);

		result.put("attributeData2Column1",attributeItemsData2ColumnOneList);
		result.put("attributeData2Column2",attributeItemsData2ColumnTwoList);
		printList(attributeItemsData2ColumnOneList,"two-1");
		printList(attributeItemsData2ColumnTwoList,"two-2");

		//单栏数据
		attributeitem.setLayoutType(AssetAttributeLayoutTypeEnum.ONE.code());
		attributeitem.setFormShow(StatusShowHideEnum.SHOW.code());
		attributeitem.setLayoutColumn(1);
		List<AssetAttributeItem> attributeItemsData1ColumnOneList= queryList(attributeitem,OrderBy.byAsc("layout_row"));
		join(attributeItemsData1ColumnOneList,AssetAttributeItemMeta.ATTRIBUTE);
		result.put("attributeData1Column1",attributeItemsData1ColumnOneList);
		printList(attributeItemsData1ColumnOneList,"one-1");


		//所有列表数据
		AssetAttributeItemVO attributeitemList=new AssetAttributeItemVO();
		attributeitemList.setOwnerCode(module);
		attributeitemList.setListShow(StatusShowHideEnum.SHOW.code());
		List<AssetAttributeItem> attributeItemsListData= queryList(attributeitemList,OrderBy.byAsc("list_sort"));
		join(attributeItemsListData,AssetAttributeItemMeta.ATTRIBUTE);
		result.put("attributeListData",attributeItemsListData);

		return result;
	}


	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<AssetAttributeItem> queryPagedList(AssetAttributeItem sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}
	
	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<AssetAttributeItem> queryPagedList(AssetAttributeItem sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param assetAttributeItem 数据对象
	 * @return 判断结果
	 */
	public Result<AssetAttributeItem> checkExists(AssetAttributeItem assetAttributeItem) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(assetAttributeItem, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public List<AssetAttributeItem> queryListForForm(AssetAttributeItem sample) {
		List<AssetAttributeItem> list=this.queryList(sample);
		dao.join(list, AssetAttributeItemMeta.ATTRIBUTE);
		return list;
	}

	@Override
	public ExcelWriter exportExcel(AssetAttributeItem sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
	}

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}