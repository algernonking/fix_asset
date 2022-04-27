update sys_config set value=concat('v=',date_format(now(), '%Y%m%d%h%i%s')) where code='system.cachekey';
commit;