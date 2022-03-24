Version 1.0.8
ALTER TABLE `eam_asset_repair` ADD `report_user_name` VARCHAR(500)  NULL  DEFAULT NULL  COMMENT '报修人'  AFTER `report_user_id`;
--update eam_asset_repair set report_user_name=report_user_id;
