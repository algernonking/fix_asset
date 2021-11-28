package com.dt.platform.eam.service;


import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetDataChange;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import org.apache.poi.ss.formula.functions.T;

import java.io.InputStream;
import java.util.List;

/**
 * <p>
 * 变更明细 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-09 12:26:14
*/

public interface IAssetBillService extends ISuperService<Asset> {


	/**
	 * 插入实体
	 * @param ids 单据ID
	 * @return
	 * */
	public Result queryBorrowBills(List<T> ids);


	/**
	 * 插入实体
	 * @param ids 单据ID
	 * @return
	 * */
	public Result queryCollectionBills(List<T> ids);


	/**
	 * 插入实体
	 * @param ids 单据ID
	 * @return
	 * */
	public Result queryCollectionReturnBills(List<T> ids);

	/**
	 * 插入实体
	 * @param ids 单据ID
	 * @return
	 * */
	public Result queryCollectionScrapBills(List<T> ids);

	/**
	 * 插入实体
	 * @param ids 单据ID
	 * @return
	 * */
	public Result queryCollectionRepairBills(List<T> ids);

	/**
	 * 插入实体
	 * @param ids 单据ID
	 * @return
	 * */
	public Result queryCollectionAllocationBills(List<T> ids);



}