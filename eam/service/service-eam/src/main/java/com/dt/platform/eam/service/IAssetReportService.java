package com.dt.platform.eam.service;

import com.alibaba.fastjson.JSONArray;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetRepair;
import com.github.foxnic.dao.entity.ISuperService;

public interface IAssetReportService extends ISuperService<Asset> {


      JSONArray queryOrganizationData(Asset sample);

      JSONArray queryCategoryData(Asset sample);

}
