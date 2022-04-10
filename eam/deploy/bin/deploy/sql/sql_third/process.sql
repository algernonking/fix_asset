

--#####存资产主表字段的配置,默认T001租户
--备份
--drop table eam_asset_attribute_2021_11_12;
--drop table eam_asset_attribute_item_2021_11_12;
create table eam_asset_attribute_2021_11_12 as select * from eam_asset_attribute where tenant_id='T001';
create table eam_asset_attribute_item_2021_11_12 as select * from eam_asset_attribute_item where attribute_id in ( select id from eam_asset_attribute where tenant_id='T001' and deleted='0');

--还原
delete from eam_asset_attribute;
delete from eam_asset_attribute_item;
commit;
insert into eam_asset_attribute select * from eam_asset_attribute_2021_11_12;
insert into eam_asset_attribute_item select * from eam_asset_attribute_item_2021_11_12;
commit;




--C1









