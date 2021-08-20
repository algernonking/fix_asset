package com.dt.platform.eam.service.impl;


import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dt.platform.domain.eam.AssetBorrowReturn;
import com.dt.platform.domain.eam.AssetBorrowReturnVO;
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
import com.dt.platform.eam.service.IAssetBorrowReturnService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;

/**
 * <p>
 * 资产借用归还 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-20 09:25:30
*/


@Service("EamAssetBorrowReturnService")
public class AssetBorrowReturnServiceImpl extends SuperService<AssetBorrowReturn> implements IAssetBorrowReturnService {
	
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
	
	/**
	 * 插入实体
	 * @param assetBorrowReturn 实体数据
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetBorrowReturn assetBorrowReturn) {
		Result r=super.insert(assetBorrowReturn);
		return r;
	}
	
	/**
	 * 批量插入实体，事务内
	 * @param assetBorrowReturnList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetBorrowReturn> assetBorrowReturnList) {
		return super.insertList(assetBorrowReturnList);
	}
	
	
	/**
	 * 按主键删除 资产借用归还
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetBorrowReturn assetBorrowReturn = new AssetBorrowReturn();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetBorrowReturn.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetBorrowReturn);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 资产借用归还
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetBorrowReturn assetBorrowReturn = new AssetBorrowReturn();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetBorrowReturn.setId(id);
		assetBorrowReturn.setDeleted(dao.getDBTreaty().getTrueValue());
		assetBorrowReturn.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetBorrowReturn.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetBorrowReturn,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetBorrowReturn 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetBorrowReturn assetBorrowReturn , SaveMode mode) {
		Result r=super.update(assetBorrowReturn , mode);
		return r;
	}
	
	/**
	 * 更新实体集，事务内
	 * @param assetBorrowReturnList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetBorrowReturn> assetBorrowReturnList , SaveMode mode) {
		return super.updateList(assetBorrowReturnList , mode);
	}
	
	
	/**
	 * 按主键更新字段 资产借用归还
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
	 * 按主键获取 资产借用归还
	 *
	 * @param id 主键
	 * @return AssetBorrowReturn 数据对象
	 */
	public AssetBorrowReturn getById(String id) {
		AssetBorrowReturn sample = new AssetBorrowReturn();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetBorrowReturn> getByIds(List<String> ids) {
		return new ArrayList<>(getByIdsMap(ids).values());
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * 
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetBorrowReturn> queryList(AssetBorrowReturn sample) {
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
	public PagedList<AssetBorrowReturn> queryPagedList(AssetBorrowReturn sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetBorrowReturn> queryPagedList(AssetBorrowReturn sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}
	
	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param assetBorrowReturn 数据对象
	 * @return 判断结果
	 */
	public Result<AssetBorrowReturn> checkExists(AssetBorrowReturn assetBorrowReturn) {
		//TDOD 此处添加判断段的代码
		//boolean exists=this.checkExists(assetBorrowReturn, SYS_ROLE.NAME);
		//return exists;
		return ErrorDesc.success();
	}

	@Override
	public ExcelWriter exportExcel(AssetBorrowReturn sample) {
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