--表
select
    #t.*,
    concat("alter table ",table_name," collate = utf8mb4_general_ci;")
from information_schema.TABLES t where table_schema='eam'
                                   and TABLE_COLLATION<>'utf8mb4_general_ci'
                                   and TABLE_NAME not like 'act%'
                                   and TABLE_NAME not like 'sys_%'


--列
select
    concat('alter table ',table_name,' modify column ',column_name,' ',data_type,'(',character_maximum_length,')',' character set utf8mb4 collate utf8mb4_general_ci  COMMENT  \'',column_comment,'\' ;')
from columns where  table_schema='eam'
               and (column_type like 'varchar%' or column_type in ('longtext','text','mediumtext','tinytext'))
               and collation_name<>'utf8mb4_general_ci'
               and table_name not like 'act%'
               and TABLE_NAME not like 'sys_%'
