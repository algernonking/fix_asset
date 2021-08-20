package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.eam.AssetCollectionReturn;
import com.dt.platform.domain.eam.AssetCollectionReturnVO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.dt.platform.eam.service.IAssetCollectionReturnService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 资产退库 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 16:13:05
*/


@Service("EamAssetCollectionReturnService")
public class AssetCollectionReturnServiceImpl extends SuperService<AssetCollectionReturn> implements IAssetCollectionReturnService {
	
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
	private AssetItemServiceImpl assetItemServiceImpl;

	
	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}
	
	/**
	 * 插入实体
	 * @param assetCollectionReturn 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(AssetCollectionReturn assetCollectionReturn) {
		Result r=super.insert(assetCollectionReturn);
		//保存关系
		if(r.success()) {
			assetItemServiceImpl.saveRelation(assetCollectionReturn.getId(), assetCollectionReturn.getAssetIds());
		}
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param assetCollectionReturnList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetCollectionReturn> assetCollectionReturnList) {
		return super.insertList(assetCollectionReturnList);
	}
	
	
	/**
	 * 按主键删除 资产退库
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetCollectionReturn assetCollectionReturn = new AssetCollectionReturn();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetCollectionReturn.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetCollectionReturn);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产退库
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetCollectionReturn assetCollectionReturn = new AssetCollectionReturn();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetCollectionReturn.setId(id);
		assetCollectionReturn.setDeleted(dao.getDBTreaty().getTrueValue());
		assetCollectionReturn.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetCollectionReturn.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetCollectionReturn,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetCollectionReturn 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(AssetCollectionReturn assetCollectionReturn , SaveMode mode) {
		Result r=super.update(assetCollectionReturn , mode);
		//保存关系
		if(r.success()) {
			assetItemServiceImpl.saveRelation(assetCollectionReturn.getId(), assetCollectionReturn.getAssetIds());
		}
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param assetCollectionReturnList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetCollectionReturn> assetCollectionReturnList , SaveMode mode) {
		return super.updateList(assetCollectionReturnList , mode);
	}
	
	
	/**
	 * 按主键更新字段 资产退库
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
	 * 按主键获取 资产退库
	 *
	 * @param id 主键
	 * @return AssetCollectionReturn 数据对象
	 */
	public AssetCollectionReturn getById(String id) {
		AssetCollectionReturn sample = new AssetCollectionReturn();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetCollectionReturn> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetCollectionReturn> queryList(AssetCollectionReturn sample) {
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
	public PagedList<AssetCollectionReturn> queryPagedList(AssetCollectionReturn sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetCollectionReturn> queryPagedList(AssetCollectionReturn sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param assetCollectionReturn 数据对象
	 * @return 判断结果
	 */
	public Result<AssetCollectionReturn> checkExists(AssetCollectionReturn assetCollectionReturn) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(assetCollectionReturn, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(AssetCollectionReturn sample) {
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