package com.dt.platform.eam.service;

import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetScrap;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.entity.ISuperService;

public interface IAssetAlarmService extends ISuperService<Asset> {


    Result report();

}
