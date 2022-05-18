版本维护



delete from eam.sys_busi_role where 1=1;
insert into eam.sys_busi_role select * from eam_c1.sys_busi_role;

delete from eam.sys_busi_role_member where 1=1;
insert into eam.sys_busi_role_member select * from eam_c1.sys_busi_role_member;

delete from eam.sys_resourze where 1=1;
insert into eam.sys_resourze select * from eam_c1.sys_resourze;



delete from eam.sys_menu where 1=1;
insert into eam.sys_menu select * from eam_c1.sys_menu;


delete from eam.sys_menu_resource where 1=1;
insert into eam.sys_menu_resource select * from eam_c1.sys_menu_resource;



delete from eam.dp_rule where 1=1;
insert into eam.dp_rule select * from eam_c1.dp_rule;


delete from eam.dp_rule_range where 1=1;
insert into eam.dp_rule_range select * from eam_c1.dp_rule_range;


delete from eam.dp_rule_condition where 1=1;
insert into eam.dp_rule_condition select * from eam_c1.dp_rule_condition;