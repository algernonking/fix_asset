layui.define([],
    function (exports) {
        function getColumnList(templet) {
            var COL_ALL_DATA={
                 category_id:{ field: 'categoryId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产分类'), templet: function (d) { return templet('categoryId',fox.joinLabel(d.category,"name"),d);}}
                ,category_code:{ field: 'categoryCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('分类编码') , templet: function (d) { return templet('categoryCode',d.categoryCode,d);}  }
                ,business_code:{ field: 'businessCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('业务编号') , templet: function (d) { return templet('businessCode',d.businessCode,d);}  }
                ,proc_id:{ field: 'procId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('流程') , templet: function (d) { return templet('procId',d.procId,d);}  }
                ,status:{ field: 'status', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('办理状态'), templet:function (d){ return templet('status',fox.getEnumText(SELECT_STATUS_DATA,d.status),d);}}
                ,batch_code:{ field: 'batchCode', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('批次编码') , templet: function (d) { return templet('batchCode',d.batchCode,d);}  }
                ,asset_code:{ field: 'assetCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产编号') , templet: function (d) { return templet('assetCode',d.assetCode,d);}  }
                ,asset_status:{ field: 'assetStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产状态'), templet:function (d){ return templet('assetStatus',fox.getEnumText(SELECT_ASSETSTATUS_DATA,d.assetStatus),d);}}
                ,goods_id:{ field: 'goodsId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('物品档案'), templet: function (d) { return templet('goodsId',fox.joinLabel(d.goods,"name"),d);}}
                ,name:{ field: 'name', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('名称') , templet: function (d) { return templet('name',d.name,d);}  }
                ,manufacturer_id:{ field: 'manufacturerId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('厂商'), templet: function (d) { return templet('manufacturerId',fox.joinLabel(d.manufacturer,"manufacturerName"),d);}}
                ,model:{ field: 'model', align:"left",fixed:false, hide:false, sort: true, title: fox.translate('规格型号') , templet: function (d) { return templet('model',d.model,d);}  }
                ,unit:{ field: 'unit', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('计量单位') , templet: function (d) { return templet('unit',d.unit,d);}  }
                ,service_life:{ field: 'serviceLife', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('使用期限') , templet: function (d) { return templet('serviceLife',d.serviceLife,d);}  }
                ,serial_number:{ field: 'serialNumber', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('序列号') , templet: function (d) { return templet('serialNumber',d.serialNumber,d);}  }
                ,own_company_id:{ field: 'ownCompanyId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('所属公司') , templet: function (d) { return templet('ownCompanyId',fox.getProperty(d,["ownerCompany","fullName"]),d);} }
                ,manager_id:{ field: 'managerId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('管理人员') , templet: function (d) { return templet('managerId',fox.getProperty(d,["manager","nameAndBadge"]),d);} }
                ,use_organization_id:{ field: 'useOrganizationId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('使用公司/部门') , templet: function (d) { return templet('useOrganizationId',fox.getProperty(d,["useOrganization","fullName"]),d);} }
                ,use_user_id:{ field: 'useUserId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('使用人员') , templet: function (d) { return templet('useUserId',fox.getProperty(d,["useUser","nameAndBadge"]),d);} }
                ,originator_id:{ field: 'originatorId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('制单人') , templet: function (d) { return templet('originatorId',fox.getProperty(d,["originator","nameAndBadge"]),d);} }
                ,position_id:{ field: 'positionId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('位置'), templet: function (d) { return templet('positionId',fox.joinLabel(d.position,"name"),d);}}
                ,position_detail:{ field: 'positionDetail', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('详细位置') , templet: function (d) { return templet('positionDetail',d.positionDetail,d);}  }
                ,warehouse_id:{ field: 'warehouseId', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('仓库'), templet: function (d) { return templet('warehouseId',fox.joinLabel(d.warehouse,"warehouseName"),d);}}
                ,source_id:{ field: 'sourceId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('来源'), templet: function (d) { return templet('sourceId',fox.joinLabel(d.source,"label"),d);}}
                ,asset_number:{ field: 'assetNumber', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('资产数量') , templet: function (d) { return templet('assetNumber',d.assetNumber,d);}  }
                ,remain_number:{ field: 'remainNumber', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('剩余数量') , templet: function (d) { return templet('remainNumber',d.remainNumber,d);}  }
                ,purchase_date:{ field: 'purchaseDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('采购日期'), templet: function (d) { return templet('purchaseDate',fox.dateFormat(d.purchaseDate,"yyyy-MM-dd"),d); }}
                ,production_date:{ field: 'productionDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('生产日期'), templet: function (d) { return templet('purchaseDate',fox.dateFormat(d.productionDate,"yyyy-MM-dd"),d); }}
                ,rfid:{ field: 'rfid', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产RFID') , templet: function (d) { return templet('rfid',d.rfid,d);}  }
                ,asset_notes:{ field: 'assetNotes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('资产备注') , templet: function (d) { return templet('assetNotes',d.assetNotes,d);}  }
                ,maintainer_id:{ field: 'maintainerId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('维保商'), templet: function (d) { return templet('maintainerId',fox.joinLabel(d.maintnainer,"maintainerName"),d);}}
                ,maintainer_name:{ field: 'maintainerName', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('维保厂商') , templet: function (d) { return templet('maintainerName',d.maintainerName,d);}  }
                ,maintenance_status:{ field: 'maintenanceStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('维保状态'), templet:function (d){ return templet('maintenanceStatus',fox.getEnumText(SELECT_MAINTENANCESTATUS_DATA,d.maintenanceStatus),d);}}
                ,contacts:{ field: 'contacts', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('联系人') , templet: function (d) { return templet('contacts',d.contacts,d);}  }
                ,contact_information: { field: 'contactInformation', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('联系方式') , templet: function (d) { return templet('contactInformation',d.contactInformation,d);}  }
                ,director: { field: 'director', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('负责人') , templet: function (d) { return templet('director',d.director,d);}  }
                ,maintenance_start_date:{ field: 'maintenanceStartDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('维保开始时间'), templet: function (d) { return templet('maintenanceStartDate',fox.dateFormat(d.maintenanceStartDate,"yyyy-MM-dd"),d); }}
                ,maintenance_end_date:{ field: 'maintenanceEndDate', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('维保到期时间'), templet: function (d) { return templet('maintenanceEndDate',fox.dateFormat(d.maintenanceEndDate,"yyyy-MM-dd"),d); }}
                ,maintenance_notes:{ field: 'maintenanceNotes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('维保备注') , templet: function (d) { return templet('maintenanceNotes',d.maintenanceNotes,d);}  }
                ,financial_category_id:{ field: 'financialCategoryId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('财务分类'), templet: function (d) { return templet('financialCategoryId',fox.joinLabel(d.categoryFinance,"hierarchyName"),d);}}
                ,financial_code:{ field: 'financialCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('财务编号') , templet: function (d) { return templet('financialCode',d.financialCode,d);}  }
                ,supplier_id:{ field: 'supplierId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('供应商'), templet: function (d) { return templet('supplierId',fox.joinLabel(d.supplier,"supplierName"),d);}}
                ,taxamount_rate:{ field: 'taxamountRate', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('税额') , templet: function (d) { return templet('taxamountRate',d.taxamountRate,d);}  }
                ,taxamount_price:{ field: 'taxamountPrice', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('含税金额') , templet: function (d) { return templet('taxamountPrice',d.taxamountPrice,d);}  }
                ,original_unit_price:{ field: 'originalUnitPrice', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('资产原值(单价)') , templet: function (d) { return templet('originalUnitPrice',d.originalUnitPrice,d);}  }
                ,accumulated_depreciation:{ field: 'accumulatedDepreciation', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('累计折旧') , templet: function (d) { return templet('accumulatedDepreciation',d.accumulatedDepreciation,d);}  }
                ,residuals_rate:{ field: 'residualsRate', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('残值率') , templet: function (d) { return templet('residualsRate',d.residualsRate,d);}  }
                ,nav_price:{ field: 'navPrice', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('资产净值') , templet: function (d) { return templet('navPrice',d.navPrice,d);}  }
                ,purchase_unit_price:{ field: 'purchaseUnitPrice', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('采购单价') , templet: function (d) { return templet('purchaseUnitPrice',d.purchaseUnitPrice,d);}  }
                ,entryTime:{ field: 'entryTime', align:"right", fixed:false, hide:false, sort: true, title: fox.translate('入账时间'), templet: function (d) { return templet('entryTime',fox.dateFormat(d.entryTime),d); }}
                ,financial_notes:{ field: 'financialNotes', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('财务备注') , templet: function (d) { return templet('financialNotes',d.financialNotes,d);}  }
                ,label:{ field: 'label', align:"left",fixed:false,  hide:true, sort: true, title: fox.translate('标签') , templet: function (d) { return templet('label',d.label,d);}  }
                ,safety_level_code:{ field: 'safetyLevelCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('安全等级'), templet: function (d) { return templet('safetyLevelCode',fox.joinLabel(d.safetyLevel,"label"),d);}}
                ,equipment_code:{ field: 'equipmentCode', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备编号') , templet: function (d) { return templet('equipmentCode',d.equipmentCode,d);}  }
                ,equipment_status:{ field: 'equipmentStatus', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备状态'), templet:function (d){ return templet('equipmentStatus',fox.getEnumText(SELECT_EQUIPMENTSTATUS_DATA,d.equipmentStatus),d);}}
                ,equipment_ip:{ field: 'equipmentIp', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备IP') , templet: function (d) { return templet('equipmentIp',d.equipmentIp,d);}  }
                ,equipment_cpu:{ field: 'equipmentCpu', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备CPU') , templet: function (d) { return templet('equipmentCpu',d.equipmentCpu,d);}  }
                ,equipment_memory:{ field: 'equipmentMemory', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备内存') , templet: function (d) { return templet('equipmentMemory',d.equipmentMemory,d);}  }
                ,equipment_label:{ field: 'equipmentLabel', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备标签') , templet: function (d) { return templet('equipmentLabel',d.equipmentLabel,d);}  }
                ,equipment_conf:{ field: 'equipmentConf', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('设备配置') , templet: function (d) { return templet('equipmentConf',d.equipmentConf,d);}  }
                ,rack_id:{ field: 'rackId', align:"left",fixed:false,  hide:false, sort: true, title: fox.translate('机柜'), templet: function (d) { return templet('rackId',fox.joinLabel(d.rack,"rackName"),d);}}
                ,rack_up_number:{ field: 'rackUpNumber', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('设备机柜上位置') , templet: function (d) { return templet('rackUpNumber',d.rackUpNumber,d);}  }
                ,rack_down_number:{ field: 'rackDownNumber', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('设备机柜下位置') , templet: function (d) { return templet('rackDownNumber',d.rackDownNumber,d);}  }
                ,purpose:{ field: 'purpose', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('资产用途') , templet: function (d) { return templet('purpose',d.purpose,d);}  }
                ,equipment_serial_number:{ field: 'equipmentSerialNumber', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('设备序列') , templet: function (d) { return templet('equipmentSerialNumber',d.equipmentSerialNumber,d);}  }
                ,last_verification_date:{ field: 'lastVerificationDate', align:"right",fixed:false,  hide:false, sort: true, title: fox.translate('核对日期') , templet: function (d) { return templet('lastVerificationDate',fox.dateFormat(d.lastVerificationDate,"yyyy-MM-dd"),d); }}

            }
            return COL_ALL_DATA;
        }

        function filterColumnList(data){
            var COL_ALL_DAT= getColumnList();
        }
        var assetListColumn = {
            getColumnList:getColumnList,
            filterColumnList:filterColumnList
        }
        exports('assetListColumn', assetListColumn);
    });