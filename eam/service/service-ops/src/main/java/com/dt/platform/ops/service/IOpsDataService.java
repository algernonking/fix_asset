package com.dt.platform.ops.service;


import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetVO;
import com.dt.platform.domain.ops.*;
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
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 主机 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:06:42
*/

public interface IOpsDataService extends ISuperService<Host> {



	Result verifyISRecord(Rcd rcd, HashMap<String,HashMap<String,String>> matchMap, boolean filldata);


	Result verifyHostRecord(Rcd rcd, HashMap<String,HashMap<String,String>> matchMap, boolean filldata);


	String getMapKey(HashMap<String,String> map, String value);

	HashMap<String,String> queryUseOrganizationNodes();


	List<Host> queryHostList(HostVO sample);

	Map<String, Object> queryHostMap(List<Host> list);



	List<InformationSystem> queryInformationSystemList(InformationSystemVO sample);

	Map<String, Object> queryInformationSystemMap(List<InformationSystem> list);



	List<DbInstance> queryDatabaseInstanceList(DbInstanceVO sample);

	Map<String, Object> queryDatabaseInstanceMap(List<DbInstance>  list);

	File saveTempFile(InputStream is, String fileName);









}