package com.dt.platform.relation.modules;

 
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.domain.eam.meta.AssetAttributeItemMeta;
import com.dt.platform.domain.eam.meta.AssetRepairMeta;
import com.dt.platform.domain.eam.meta.InventoryMeta;
import com.dt.platform.domain.vehicle.Apply;
import com.dt.platform.domain.vehicle.Maintenance;
import com.dt.platform.domain.vehicle.meta.ApplyMeta;
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import com.dt.platform.domain.vehicle.meta.MaintenanceMeta;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class VehicleRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupRelations();
		this.setupProperties();
		this.setupInfo();
		this.setupVehicleApply();
		this.setupVehicleMaintenance();
	}



	public void setupInfo() {
		// 关联字段
		//关联 所属公司
		this.property(InfoMeta.OWNER_COMPANY_PROP)
				.using(VehicleTables.VEHICLE_INFO.OWNER_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

		//关联 使用组织
		this.property(InfoMeta.USE_ORGANIZATION_PROP)
				.using(VehicleTables.VEHICLE_INFO.USE_ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

		this.property(InfoMeta.VEHICLE_TYPE_DICT_PROP)
				.using(VehicleTables.VEHICLE_INFO.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='vehicle_type'");

		this.property(InfoMeta.VEHICLE_STATUS_DICT_PROP)
				.using(VehicleTables.VEHICLE_INFO.VEHICLE_STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='vehicle_status'");

		//制单人
		this.property(InfoMeta.ORIGINATOR_PROP)
				.using(VehicleTables.VEHICLE_INFO.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(InfoMeta.USE_USER_PROP)
				.using(VehicleTables.VEHICLE_INFO.USE_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


//

	}

	public void setupVehicleApply() {
		// 关联字段
		this.property(ApplyMeta.USE_ORGANIZATION_PROP)
				.using(VehicleTables.VEHICLE_APPLY.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(ApplyMeta.RECEIVER_PROP)
				.using(VehicleTables.VEHICLE_APPLY.RECEIVER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(ApplyMeta.VEHICLE_INFO_LIST_PROP)
				.using(VehicleTables.VEHICLE_APPLY.ID ).join(VehicleTables.VEHICLE_A_SELECT_ITEM.HANDLE_ID)
				.using( VehicleTables.VEHICLE_A_SELECT_ITEM.ASSET_ID).join( VehicleTables.VEHICLE_INFO.ID);

	}

	public void setupVehicleMaintenance() {

		// 关联字段
		this.property(MaintenanceMeta.MAINTENANCE_DICT_PROP)
				.using(VehicleTables.VEHICLE_MAINTENANCE.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='vehicle_maintenance_type'");

		this.property(MaintenanceMeta.ORIGINATOR_PROP)
				.using(VehicleTables.VEHICLE_MAINTENANCE.ORIGINATOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(MaintenanceMeta.VEHICLE_INFO_LIST_PROP)
				.using(VehicleTables.VEHICLE_MAINTENANCE.ID ).join(VehicleTables.VEHICLE_M_SELECT_ITEM.HANDLE_ID)
				.using( VehicleTables.VEHICLE_M_SELECT_ITEM.ASSET_ID).join( VehicleTables.VEHICLE_INFO.ID);


	}


	public void setupProperties() {

	}

	private void setupRelations() {

	}

}
