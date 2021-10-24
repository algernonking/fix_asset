package com.dt.platform.eam.service;

import com.alibaba.fastjson.JSONArray;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetScrap;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.ISuperService;

public interface IAssetAlarmService extends ISuperService<Asset> {




    PagedList<Asset> queryAlarmData(Asset sample,int pageSize,int pageIndex);

    JSONArray queryBorrowAlarmData(Asset sample,int pageSize,int pageIndex);

    PagedList<Asset> queryMaintenanceAlarmData(Asset sample,int pageSize,int pageIndex);

    PagedList<Asset> queryCollectionAlarmData(Asset sample,int pageSize,int pageIndex);

    public JSONArray queryAssetSerialNumberUnique();

}
