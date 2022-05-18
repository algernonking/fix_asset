CREATE TABLE `sys_profile`  (
                                `id` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
                                `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
                                `activated` int(4) NULL DEFAULT NULL COMMENT '是否激活',
                                `notes` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
                                `load_order` int(6) NULL DEFAULT NULL COMMENT '加载的顺序',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

INSERT INTO `sys_profile` (`id`, `name`, `activated`, `notes`, `load_order`) VALUES ('default', '默认', 1, '默认 Profile 请勿删除', 0);
INSERT INTO `sys_profile` (`id`, `name`, `activated`, `notes`, `load_order`) VALUES ('profile@GuoYIE', 'GuoYIE', 1, NULL, 1);




INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`) VALUES ('sys_config_catalog', 0, '系统配置分类', 'sys_config_catalog', 'system', NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`) VALUES ('sys_config_catalog_001', 'sys_config_catalog', 'sys_config_catalog', NULL, 'system', '系统配置', 9999, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`) VALUES ('sys_config_catalog_002', 'sys_config_catalog', 'sys_config_catalog', NULL, 'htm', '组织人事', 9999, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1);


ALTER TABLE `sys_config`
    ADD COLUMN `profile_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Profile,Profile Id ' AFTER `version`,
    ADD COLUMN `catalog_code` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类代码,关联 sys_config_catalog 数据字典' AFTER `profile_id`;

update sys_config set profile_id='default' , catalog_code='system';



ALTER TABLE `sys_config`
    ADD COLUMN `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主键';

update sys_config set id=code;

ALTER TABLE `sys_config`
    DROP PRIMARY KEY;


ALTER TABLE `sys_config`
    MODIFY COLUMN `id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键' AFTER `catalog_code`,
    ADD PRIMARY KEY (`id`);

ALTER TABLE `sys_config`
    ADD UNIQUE INDEX `uk`(`code`, `profile_id`);