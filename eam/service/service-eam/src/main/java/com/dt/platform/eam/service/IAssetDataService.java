package com.dt.platform.eam.service;


import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.domain.eam.Goods;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.domain.pcm.CatalogData;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 物品档案 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:04:55
*/

public interface IAssetDataService extends ISuperService<Asset> {


	HashMap<String,String> queryDictItemDataByDictCode(String dictCode);

	String getMapKey(HashMap<String,String> map,String value);

	Result verifyAssetRecord(Rcd rcd,HashMap<String,HashMap<String,String>> matchMap, boolean filldata);


	Result<CatalogData> verifyAssetExtColumnRecord(Rcd rcd, List<CatalogAttribute> attributeList, boolean filldata);

	HashMap<String,String> queryAssetCategoryNodes(String type);

	HashMap<String,String> queryOrganizationNodes(String type);


	Result batchImportAsset(String content,String selectedCode);

	Result<JSONObject> queryBatchImportAssetLuckysheetConf(String oper,int row);

	/**
	 * 插入实体
	 * @param ids 资产数据
	 * @param asset 资产实体
	 * @return 结果
	 * */
	PagedList<Asset> queryAssetPagedList(List<String> ids,AssetVO asset);



	/**
	 * 插入实体
	 * @param list 资产数据
	 * @return 结果
	 * */
	Map<String, Object> queryAssetMap(PagedList<Asset> list,String categoryId);

	/**
	 * 插入实体
	 * @param is 输入文件流
	 * @param fileName 输出文件名
	 * @return 结果
	 * */
	File saveTempFile(InputStream is, String fileName);

}