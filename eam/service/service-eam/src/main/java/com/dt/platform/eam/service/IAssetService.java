package com.dt.platform.eam.service;


import com.alibaba.fastjson.JSONArray;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.domain.eam.AssetExtData;
import com.dt.platform.domain.eam.meta.AssetBorrowMeta;
import com.dt.platform.proxy.eam.AssetBorrowServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.entity.Entity;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.dao.entity.ISuperService;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import java.io.InputStream;
import java.util.Map;

import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.expr.SQL;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.data.SaveMode;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
import org.github.foxnic.web.domain.changes.ProcessStartVO;

/**
 * <p>
 * 资产 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-20 21:49:26
*/

public interface IAssetService extends ISuperService<Asset> {

	HashMap<String,List<SQL>> parseAssetChangeRecordWithChangeAsset(List<Asset> assetBefore, HashMap<String, Object> changeMap,String businessCode,String operType,String notes);

	Result joinData(List<Asset> list);

	Result startProcess(ProcessStartVO startVO);

	Result approve(ProcessApproveVO approveVO);


	List<Map<String, Object>> getBills(List<String> ids);


	/**
	 * 按主键获取 资产
	 * @param owner 主键
	 * @return List<JSONArray>
	 */
	JSONArray queryAssetStatusList(String owner);

	/**
	 * 按主键获取 资产
	 * @param id 主键
	 * @param categoryId 资产分类
	 * @return Asset 数据对象
	 */
	AssetExtData getExtDataById(String id, String categoryId);

	/**
	 * 批量送审
	 * @param ids 主键清单
	 * @return 是否成功
	 * */
	Result forBatchApproval(List<String> ids);



	/**
	 * 批量撤销
	 * @param ids 主键清单
	 * @return 是否成功
	 * */
	Result batchRevokeOperation(List<String> ids );


	/**
	 * 批量确认
	 * @param ids 主键清单
	 * @return 是否成功
	 * */
	Result batchConfirmOperation(List<String> ids ,String businessCode);

	/**
	 * 插入实体
	 * @param businessType 业务类型
	 * @param assetIds 资产
	 * @return 插入是否成功
	 * */
	Result checkAssetDataForBusinessAction(String businessType,List<String> assetIds);


	/**
	 * 插入实体
	 * @param asset 实体数据
	 * @return 插入是否成功
	 * */
	Result insert(Asset asset);
 
	/**
	 * 批量插入实体，事务内
	 * @param assetList 实体数据清单
	 * @return 插入是否成功
	 * */
	Result insertList(List<Asset> assetList);
	
	
		
	/**
	 * 按主键删除 资产
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	Result deleteByIdPhysical(String id);
	
	/**
	 * 按主键删除 资产
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	Result deleteByIdLogical(String id);
	
	/**
	 * 批量物理删除，仅支持单字段主键表
	 * @param ids 主键清单
	 * @return 是否删除成功
	 * */
	<T> Result deleteByIdsPhysical(List<T> ids);
	
	/**
	 * 批量逻辑删除，仅支持单字段主键表
	 * @param ids 主键清单
	 * @return 是否删除成功
	 * */
	<T> Result deleteByIdsLogical(List<T> ids);
	
		
	/**
	 * 按主键更新字段 资产
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	boolean update(DBField field,Object value , String id);
	
	/**
	 * 更新实体
	 * @param asset 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result update(Asset asset , SaveMode mode);
	
	
	/**
	 * 更新实体集，事务内
	 * @param assetList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result updateList(List<Asset> assetList, SaveMode mode);
	
	/**
	 * 保存实体，如果主键值不为 null，则更新，否则插入
	 * @param asset 实体数据
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result save(Asset asset , SaveMode mode);
	
	/**
	 * 保存实体，如果主键值不为null，则更新，否则插入
	 * @param assetList 实体数据清单
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	Result saveList(List<Asset> assetList , SaveMode mode);
	
	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param asset  实体对象
	 * @param field  字段清单，至少指定一个
	 * @return 是否已经存在
	 * */
	boolean checkExists(Asset asset,DBField... field);
 
		
	/**
	 * 按主键获取 资产
	 *
	 * @param id 主键
	 * @return Asset 数据对象
	 */
	Asset getById(String id);
		
	/**
	 * 检查实体中的数据字段是否已经存在
	 * @param ids  主键清单
	 * @return 实体集
	 * */
	List<Asset> getByIds(List<String> ids);

	/**
	 * 检查 角色 是否已经存在
	 *
	 * @param asset 数据对象
	 * @return 判断结果
	 */
	Result<Asset> checkExists(Asset asset);

	/**
	 * 根据实体数构建默认的条件表达式，字符串使用模糊匹配
	 * @param sample 数据样例
	 * @return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(Asset sample);
	
	/**
	 * 根据实体数构建默认的条件表达式, 字符串是否使用模糊匹配
	 * @param sample 数据样例
	 * @param tableAliase 数据表别名
	 * 	@return ConditionExpr 条件表达式
	 * */
	ConditionExpr buildQueryCondition(Asset sample,String tableAliase);

	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	List<Asset> queryList(Asset sample);
 
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<Asset> queryList(Asset sample,ConditionExpr condition,OrderBy orderBy);
	
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	List<Asset> queryList(Asset sample,OrderBy orderBy);
	
	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 * @param sample  查询条件
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	List<Asset> queryList(Asset sample,ConditionExpr condition);
	
	/**
	 * 查询单个实体
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	Asset queryEntity(Asset sample);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	PagedList<Asset> queryPagedList(Asset sample,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<Asset> queryPagedList(Asset sample,ConditionExpr condition,OrderBy orderBy,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param condition  其它条件
	 * @return 查询结果
	 * */
	PagedList<Asset> queryPagedList(Asset sample,ConditionExpr condition,int pageSize,int pageIndex);
	
	/**
	 * 分页查询实体集
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @param orderBy  排序
	 * @return 查询结果
	 * */
	PagedList<Asset> queryPagedList(Asset sample,OrderBy orderBy,int pageSize,int pageIndex);


	PagedList<Asset> queryPagedListBySelected(AssetVO sample,String assetSelectedCode,String assetOwnerId,String dataType);

	PagedList<Asset> queryPagedListBySelect(AssetVO sample,String assetBusinessType,String assetOwnerId,String assetSelectedCode,String assetSearchContent);

	/**
	 * 查询指定字段的数据清单
	 * @param <T> 元素类型
	 * @param field 字段
	 * @param type 元素类型
	 * @param condition 条件表达式
	 * @return 列数据
	 * */
	<T> List<T> queryValues(DBField field,Class<T> type, ConditionExpr condition);
 
	/**
	 * 查询指定字段的数据清单
	 * @param <T> 元素类型
	 * @param field 字段
	 * @param type 元素类型
	 * @param condition 条件表达式
	 * @param ps 参数清单
	 * @return 列数据
	 * */
	<T> List<T> queryValues(DBField field, Class<T> type, String condition,Object... ps);

	/**
	 * 导出 Excel
	 * */
	ExcelWriter exportExcel(Asset sample);

	/**
	 * 导出用于数据导入的 Excel 模版
	 * */
	ExcelWriter  exportExcelTemplate();

	/**
	 * @return   ExcelStructure
	 * */
	ExcelStructure buildExcelStructure(InputStream inputStream,String code);


	InputStream buildExcelTemplate(String categoryId,String code);

	/**
	 * 导入 Excel 数据
	 * @return  错误信息，成功时返回 null
	 * */
	List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch,String owner,boolean dataType,String code,String selectedCode);

 
}