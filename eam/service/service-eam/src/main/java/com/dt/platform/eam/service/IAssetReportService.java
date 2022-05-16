package com.dt.platform.eam.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.eam.Asset;
import com.github.foxnic.api.transter.Result;
import com.dt.platform.domain.eam.AssetRepair;
import com.github.foxnic.dao.entity.ISuperService;

public interface IAssetReportService extends ISuperService<Asset> {


      JSONArray queryOrganizationData(Asset sample);

      JSONArray queryOwnCompanyData(Asset sample);

      JSONArray queryCategoryData(Asset sample);

      JSONArray queryCategoryStatusData(Asset sample);

      Result<JSONObject> dashboard();

}
