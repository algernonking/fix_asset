package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;

import com.dt.platform.domain.eam.AssetAttributeItemVO;
import com.dt.platform.proxy.eam.AssetAttributeItemServiceProxy;
import com.github.foxnic.dao.data.RcdSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.eam.AssetAttribute;
import com.dt.platform.domain.eam.AssetAttributeVO;
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
import com.dt.platform.eam.service.IAssetAttributeService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 资产字段配置 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-08 16:54:30
*/


@Service("EamAssetAttributeService")
public class AssetAttributeServiceImpl extends SuperService<AssetAttribute> implements IAssetAttributeService {



	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }


	
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}


	@Override
	public List<AssetAttribute> queryAttributeOwnerList(String owner,String itemOwner){
		String tenantId=dao.getDBTreaty().getActivedTenantId().toString();
		String sql="select * from eam_asset_attribute where\n" +
				"tenant_id='"+tenantId+"' and deleted=0 and owner= ? and id not in (\n" +
				"select a.attribute_id from eam_asset_attribute_item a,eam_asset_attribute b \n" +
				"where a.owner_code=? and a.deleted=0 and a.deleted=0 and b.owner= ? and a.tenant_id='"+tenantId+"' and b.tenant_id='"+tenantId+"'\n" +
				"and a.attribute_id=b.id\n" +
				")";
		RcdSet idsRs=dao.query(sql,owner,itemOwner,owner);
		List<AssetAttribute> list=idsRs.toEntityList(AssetAttribute.class);
		return list;
	}


	/**
	 * 插入实体
	 * @param assetAttribute 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetAttribute assetAttribute) {
		Result r=super.insert(assetAttribute);
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param assetAttributeList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetAttribute> assetAttributeList) {
		return super.insertList(assetAttributeList);
	}
	
	
	/**
	 * 按主键删除 资产字段配置
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetAttribute assetAttribute = new AssetAttribute();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetAttribute.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetAttribute);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产字段配置
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetAttribute assetAttribute = new AssetAttribute();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetAttribute.setId(id);
		assetAttribute.setDeleted(dao.getDBTreaty().getTrueValue());
		assetAttribute.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetAttribute.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetAttribute,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetAttribute 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetAttribute assetAttribute , SaveMode mode) {
		Result r=super.update(assetAttribute , mode);
//		if(r.success()){
//			AssetAttributeItemVO update=new AssetAttributeItemVO();
//			update.setAttributeId(assetAttribute.getId());
//			update.setDimension(assetAttribute.getDimension());
//			AssetAttributeItemServiceProxy.api().update(update);
//		}
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param assetAttributeList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetAttribute> assetAttributeList , SaveMode mode) {
		return super.updateList(assetAttributeList , mode);
	}
	
	
	/**
	 * 按主键更新字段 资产字段配置
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
	 * 按主键获取 资产字段配置
	 *
	 * @param id 主键
	 * @return AssetAttribute 数据对象
	 */
	public AssetAttribute getById(String id) {
		AssetAttribute sample = new AssetAttribute();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetAttribute> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetAttribute> queryList(AssetAttribute sample) {
		return super.queryList(sample);
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
	public PagedList<AssetAttribute> queryPagedList(AssetAttribute sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetAttribute> queryPagedList(AssetAttribute sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param assetAttribute 数据对象
	 * @return 判断结果
	 */
	public Result<AssetAttribute> checkExists(AssetAttribute assetAttribute) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(assetAttribute, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(AssetAttribute sample) {
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