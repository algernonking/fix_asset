-- login config
update sys_config set value=0 where code='system.login.captcha.any';
update sys_config set value='{account:"",password:"",captcha:""}'  where code='system.login.default';

-- disable
-- 功能演示
update sys_menu set hidden=1 where id='495201409763901440';
-- 工单
update sys_menu set hidden=1 where id='472358185009676289';
-- 合同管理
update sys_menu set hidden=1 where id='474157822892834817';
-- 回收站
update sys_menu set hidden=1 where id='473612721665867776';


