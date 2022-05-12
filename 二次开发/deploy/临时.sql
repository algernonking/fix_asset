
update sys_menu set css='fa fa-circle-o'  where type='page' and ( css is null or css='')


 create index ind1 on  ops_monitor_node_value_last(`node_id`,`monitor_tpl_code`,`indicator_code`,`record_time`);
 create index ind2 on  ops_monitor_node_value_last(`result_status`,`indicator_code`,`node_id`);
 create index ind3 on  ops_monitor_node_value_last (`indicator_code`,`record_time`);
 create index ind1 on  ops_monitor_node_value (`node_id`,`result_status`,`monitor_tpl_code`,`indicator_code`,`record_time`)

insert into ops_monitor_node_value select
uuid(), `node_id`, `monitor_tpl_code`, `result_status`, `result_message`, `indicator_code`, `hostname`, `os_datetime`, `boottime`, `os_verion`, `arch`, `cpu_number`, `cpu_free`, `cpu_sys`, `cpu_user`, `cpu_wait`, `cpu_idle`, `cpu_used`, `os_load`, `os_load5`, `os_load15`, `network_flow_up`, `network_flow_down`, `process_cnt`, `p_memory_size`, `v_memory_size`, `p_memory_used`, `v_memory_used`, `info`, `label1`, `label2`, `label3`, `code1`, `code2`, `code3`, `value_number1`, `value_number2`, `value_number3`, `value_str1`, `value_str2`, `value_str3`, `value_int1`, `value_int2`, `value_int3`, `list_label1`, `list_label2`, `list_label3`, `list_code1`, `list_code2`, `list_code3`, `list_value_number1`, `list_value_number2`, `list_value_number3`, `list_value_str1`, `list_value_str2`, `list_value_str3`, `list_value_int1`, `list_value_int2`, `list_value_int3`, `uid`, `is_connected`, `record_time`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`
 from ops_monitor_node_value_bak




 alter table ops_monitor_node_value_last drop index ind3;
 alter table ops_monitor_node_value_last drop index ind2;
 alter table ops_monitor_node_value_last drop index ind5;
 alter table ops_monitor_node_value_last drop index ind4;
 alter table ops_monitor_node_value_last drop index ind6;



create index ind1 on  ops_monitor_node_value_last(`node_id`,`monitor_tpl_code`,`indicator_code`,`record_time`);
create index ind2 on  ops_monitor_node_value_last(`result_status`,`indicator_code`,`node_id`);
create index ind3 on  ops_monitor_node_value_last (`indicator_code`,`record_time`);




create index ind1 on ops_monitor_node(node_enabled,type,status);
create index ind2 on ops_monitor_node(node_enabled,type);
create index ind6 on ops_monitor_node_value_last(node_id,result_status,monitor_tpl_code)
create index ind1 on ops_monitor_tpl_indicator(status,monitor_tpl_code)
tpl 表新政status 字段
alter table ops_monitor_node_value drop index ind1;
create index ind1 on ops_monitor_node_value (`node_id`,result_status,`monitor_tpl_code`,`indicator_code`,`record_time`)





delete from ops_monitor_node_value;
insert into ops_monitor_node_value select * from eam_demo.ops_monitor_node_value;




delete from hrm_person where deleted='1';
delete from hrm_employee where deleted='1';
delete from sys_user where deleted='1';


INSERT INTO `eam_asset_attribute_item` (`id`, `owner_code`, `attribute_id`, `dimension`, `required`, `layout_type`, `list_show`, `list_content`, `list_sort`, `form_show`, `layout_row`, `layout_column`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`)
VALUES
	(uuid(), 'asset_consumables_bill', 'ff016233-0f8a-11ec-ab08-00163e2e6a36', 'attribution', '0', '3', '1', '', 40, '1', 1, 2, '', '110588348101165911', '2021-11-25 18:28:25', '110588348101165911', '2021-11-25 18:34:33', 0, NULL, NULL, 3, 'T001'),
	(uuid(), 'asset_consumables_bill', '516317539765063680', 'attribution', '1', '3', '1', '', 50, '1', 2, 2, '', '110588348101165911', '2021-11-25 18:25:07', '110588348101165911', '2021-11-25 18:35:24', 0, NULL, NULL, 3, 'T001'),
	(uuid(), 'asset_consumables_bill', 'fff12037-0f8a-11ec-ab08-00163e2e6a36', 'attribution', '0', '1', '1', '', 100, '1', 4, 1, '', '110588348101165911', '2021-10-25 15:08:23', '110588348101165911', '2021-11-25 18:35:04', 0, NULL, NULL, 5, 'T001'),
	(uuid(), 'asset_consumables_bill', 'ff0f2f97-0f8a-11ec-ab08-00163e2e6a36', 'attribution', '1', '3', '1', '', 30, '1', 3, 1, '', '110588348101165911', '2021-10-25 15:06:45', '110588348101165911', '2021-11-25 18:34:16', 0, NULL, NULL, 4, 'T001'),
	(uuid(), 'asset_consumables_bill', 'fef3ab3e-0f8a-11ec-ab08-00163e2e6a36', 'attribution', '1', '3', '1', '', 10, '1', 2, 1, '', '110588348101165911', '2021-10-25 15:03:55', '110588348101165911', '2021-11-25 18:33:38', 0, NULL, NULL, 3, 'T001'),
	(uuid(), 'asset_consumables_bill', '00f152f2-0f8b-11ec-ab08-00163e2e6a36', 'attribution', '0', '3', '1', '', 110, '1', 3, 2, '', '110588348101165911', '2021-10-25 15:02:17', '110588348101165911', '2021-11-25 18:39:09', 0, NULL, NULL, 6, 'T001'),
	(uuid(), 'asset_consumables_bill', 'fe6a6910-0f8a-11ec-ab08-00163e2e6a36', 'attribution', '1', '3', '1', '', 20, '1', 1, 1, '', '110588348101165911', '2021-10-25 14:04:05', '110588348101165911', '2021-11-25 18:33:48', 0, NULL, NULL, 4, 'T001');



ALTER TABLE eam_asset ADD chs_type varchar(50)  DEFAULT NULL COMMENT '变更类型';
ALTER TABLE eam_asset ADD chs_status varchar(50)  DEFAULT NULL COMMENT '变更状态';
ALTER TABLE eam_asset ADD chs_version varchar(50)  DEFAULT NULL COMMENT '变更版本号';
ALTER TABLE eam_asset ADD change_instance_id varchar(50)  DEFAULT NULL COMMENT '变更ID';
ALTER TABLE eam_asset ADD summary               varchar(500)  DEFAULT NULL COMMENT '流程概要';
ALTER TABLE eam_asset ADD latest_approver_id    varchar(50)  DEFAULT NULL COMMENT '最后审批人账户ID';
ALTER TABLE eam_asset ADD latest_approver_name  varchar(50)  DEFAULT NULL COMMENT '最后审批人姓名';
ALTER TABLE eam_asset ADD next_approver_ids     varchar(512) DEFAULT NULL COMMENT '下一节点审批人';
ALTER TABLE eam_asset ADD next_approver_names   varchar(512)  DEFAULT NULL COMMENT '下一个审批节点审批人姓名，用逗号隔开';
ALTER TABLE eam_asset ADD approval_opinion   varchar(500)  DEFAULT NULL COMMENT '审批意见';


select * from sys_resourze where deleted='1'

select * from sys_menu where authority='08-bff8dc9da6-fa0d'

select distinct access_type from sys_resourze


select b.* from sys_menu_resource a,sys_resourze b where menu_id='498890640633892865' and a.resource_id=b.id


update sys_resourze c set c.access_type='LOGIN' where c.id in (
select id from aa
)


drop table aa;

select * from aa
create table aa as
select b.id from sys_menu_resource a,sys_resourze b where menu_id='498890640633892865' and a.resource_id=b.id








INSERT INTO `eam_asset_attribute_item` (`id`, `owner_code`, `attribute_id`, `dimension`, `required`, `layout_type`, `list_show`, `list_content`, `list_sort`, `form_show`, `layout_row`, `layout_column`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`)
VALUES
	(uuid(), 'asset_select', 'fef3ab3e-0f8a-11ec-ab08-00163e2e6a36', 'attribution', 1, 3, 1, '', 40, 1, 1, 1, '', '110588348101165911', '2021-09-13 05:53:25', '110588348101165911', '2021-09-13 08:47:23', 0, NULL, NULL, 2, 'T001'),
	(uuid(), 'asset_select', 'fec153bc-0f8a-11ec-ab08-00163e2e6a36', 'attribution', 1, 3, 1, '', 30, 1, 1, -7, '', '110588348101165911', '2021-09-13 05:53:51', '110588348101165911', '2021-09-13 08:47:07', 0, NULL, NULL, 4, 'T001'),
	(uuid(), 'asset_select', '00f152f2-0f8b-11ec-ab08-00163e2e6a36', 'attribution', 1, 3, 1, '', 110, 1, 1, 1, '', '110588348101165911', '2021-09-13 05:54:24', '110588348101165911', '2021-09-13 08:52:22', 0, NULL, NULL, 2, 'T001'),
	(uuid(), 'asset_select', 'fe6a6910-0f8a-11ec-ab08-00163e2e6a36', 'attribution', 1, 3, 1, '', 20, 1, 1, 1, '', '110588348101165911', '2021-09-13 05:54:48', '110588348101165911', '2021-09-13 08:46:57', 0, NULL, NULL, 2, 'T001'),
	(uuid(), 'asset_select', 'ff0f2f97-0f8a-11ec-ab08-00163e2e6a36', 'attribution', 1, 3, 1, '5', 50, 1, 1, 1, '', '110588348101165911', '2021-09-13 05:55:12', '110588348101165911', '2021-09-13 08:47:56', 0, NULL, NULL, 2, 'T001'),
	(uuid(), 'asset_select', 'ff50d42e-0f8a-11ec-ab08-00163e2e6a36', 'attribution', 1, 3, 1, '', 80, 1, 1, 1, '', '110588348101165911', '2021-09-13 05:55:40', '110588348101165911', '2021-09-13 08:51:40', 0, NULL, NULL, 2, 'T001'),
	(uuid(), 'asset_select', 'ff7d033c-0f8a-11ec-ab08-00163e2e6a36', 'attribution', 1, 3, 1, '', 100, 1, 1, 1, '', '110588348101165911', '2021-09-13 05:55:59', '110588348101165911', '2021-09-13 08:52:09', 0, NULL, NULL, 2, 'T001'),
	(uuid(), 'asset_select', 'ff67a298-0f8a-11ec-ab08-00163e2e6a36', 'attribution', 1, 3, 1, '', 90, 1, -5, -3, '', '110588348101165911', '2021-09-13 05:56:19', '110588348101165911', '2021-09-13 08:51:54', 0, NULL, NULL, 2, 'T001'),
	(uuid(), 'asset_select', 'ff73d4e5-0f8a-11ec-ab08-00163e2e6a36', 'attribution', 1, 3, 1, '70', 70, 1, 1, 1, '', '110588348101165911', '2021-09-13 05:56:49', '110588348101165911', '2021-09-13 08:51:20', 0, NULL, NULL, 4, 'T001'),
	(uuid(), 'asset_select', 'ff4319f6-0f8a-11ec-ab08-00163e2e6a36', 'attribution', 1, 3, 1, '', 60, 1, 1, -3, '', '110588348101165911', '2021-09-13 05:57:13', '110588348101165911', '2021-09-13 08:49:00', 0, NULL, NULL, 2, 'T001'),
	(uuid(), 'asset_select', 'feb39672-0f8a-11ec-ab08-00163e2e6a36', 'attribution', 1, 3, 1, '', 10, 1, 1, 1, '', '110588348101165911', '2021-09-13 05:57:37', '110588348101165911', '2021-09-13 08:46:05', 0, NULL, NULL, 3, 'T001');




SELECT
     CONCAT(' ALTER TABLE  eam.',TABLE_NAME,' modify ',' ',COLUMN_NAME,' ',COLUMN_TYPE,'     CHARACTER SET utf8mb4 collate utf8mb4_general_ci  comment ''',column_comment,'''; ') sql2
     -- , t.*
    FROM
    information_schema.columns t
WHERE
    TABLE_SCHEMA = 'eam'
    and  DATA_TYPE='varchar'
    and collation_name='utf8_general_ci'



update eam_supplier set tenant_id='T001';




	   List<Host> hosts= CollectorUtil.collectList(list,DbInstance::getHost);
		dbInstanceService.dao().join(hosts, HostMeta.INFO_SYSTEM);
		result.success(true).data(list);

INSERT INTO `ops_service_info` (`id`, `group_id`, `service_category_id`, `name`)VALUES (uuid(), 'os', '473621743190147072', 'Redhat 7.8');



INSERT INTO `eam_asset_attribute` (`id`, `code`, `label`) VALUES (uuid(), '1', '1');

cat a|awk '{print $1 " " $NF}'|awk -F ',' '{print $1}'|awk '{print "INSERT INTO `INSERT INTO `eam_asset_attribute` (`id`, `code`, `label`) VALUES (uuid(),"$1 " " $2 ")"}'


cat aaa|awk '{print "INSERT INTO `INSERT INTO `eam_asset_attribute` (`id`, `code`, `label`) VALUES (uuid(),"$1 ", " $2 ")"}'


update eam_asset_attribute_item  b set dimension=(select dimension from eam_asset_attribute a where a.id=b.attribute_id)




INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL, 'mcs', 'mcs', 9999);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL, 'cms', 'cms', 9999);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL, 'ftp', 'ftp', 9999);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL, 'app', 'app', 9999);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL, 'mysql', 'mysql', 9999);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL, 'admin', 'admin', 9999);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL, 'administrator', 'administrator', 9999);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL, 'opsuser', 'opsuser', 9999);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL, 'tomcat', 'tomcat', 9999);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL, 'was', 'was', 9999);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL, 'weblogic', 'weblogic', 9999);

INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '26', 'ops_user_voucher', NULL,  'administrator@vsphere.local', 'administrator@vsphere.local', 9999);


INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '19', 'ops_host_type', NULL, 'ops', '运维系统', 9999);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`) VALUES(uuid(), '19', 'ops_host_type', NULL, 'analyze', '分析系统', 9999);

ops_host_type


--租户表设置
select distinct  concat('update ', table_name ,' set tenant_id=\'T001\'; ')   from     information_schema.columns where column_name='TENANT_ID' and ( table_name like 'cont%' or table_name like 'eam%'
or table_name  like 'ops%' or table_name  like 'kn%'   or table_name  like 'dc%')