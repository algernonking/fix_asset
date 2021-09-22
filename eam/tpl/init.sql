

/* 初始化文件 */
/* EAM */
delete from sys_file where id like 'T001_eam_%';
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_1','eam_asset_repair.docx','/tpl/T001/eam_asset_repair.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_2','eam_asset_borrow.docx','/tpl/T001/eam_asset_borrow.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_3','eam_asset_collection.docx','/tpl/T001/eam_asset_collection.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_4','eam_asset_collection_return.docx','/tpl/T001/eam_asset_collection_return.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_5','eam_asset_allocate.docx','/tpl/T001/eam_asset_allocate.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_6','eam_asset_code.docx','/tpl/T001/eam_asset_code.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_7','eam_asset_card.docx','/tpl/T001/eam_asset_card.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_8','eam_asset_tranfer.docx','/tpl/T001/eam_asset_tranfer',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_9','eam_download_asset.docx','/tpl/T001/eam_download_asset.xls',10000,'application/octet-stream','xls');

delete from sys_tpl_file where tenant_id='T001' and code in ('eam_asset_code','eam_asset_borrow','eam_asset_collection_return','eam_asset_repair','eam_asset_card','eam_asset_collection','eam_asset_tranfer','eam_asset_allocate','eam_download_asset');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_1','eam_bill_docx','资产报修','eam_asset_repair','T001_eam_1','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_2','eam_bill_docx','资产借用','eam_asset_borrow','T001_eam_2','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_3','eam_bill_docx','资产领用','eam_asset_collection','T001_eam_3','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_4','eam_bill_docx','资产领用退库','eam_asset_collection_return','T001_eam_4','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_5','eam_bill_docx','资产调拨','eam_asset_allocate','T001_eam_5','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_6','eam_bill_docx','资产编码','eam_asset_code','T001_eam_6','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_7','eam_bill_docx','资产编卡片','eam_asset_card','T001_eam_7','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_8','eam_bill_docx','资产转移','eam_asset_tranfer','T001_eam_8','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_9','eam_asset_excel','资产数据下载','eam_download_asset','T001_eam_9','T001');






/* OPS */
delete from sys_file where id like 'T001_ops_%';
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_ops_1','ops_download_host.xls','/tpl/T001/ops_download_host.xls',10000,'application/octet-stream','xls');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_ops_2','ops_download_database_inst.xls','/tpl/T001/ops_download_database_inst.xls',10000,'application/octet-stream','xls');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_ops_3','ops_download_information_system.xls','/tpl/T001/ops_download_information_system.xls',10000,'application/octet-stream','xls');

delete from sys_tpl_file where tenant_id='T001' and code in ('ops_download_host','ops_download_database_inst','ops_download_information_system');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_ops_1','ops','主机数据下载','ops_download_host','T001_ops_1','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_ops_2','ops','数据库数据下载','ops_download_database_inst','T001_ops_2','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_ops_3','ops','信息系统数据下载','ops_download_information_system','T001_ops_3','T001');




/* CONT */
delete from sys_file where id like 'T001_cont_%';
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_cont_1','cont_download_info.xls','/tpl/T001/cont_download_info.xls',10000,'application/octet-stream','xls');

delete from sys_tpl_file where tenant_id='T001' and code in ('cont_download_info');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_cont_1','cont','合同下载','cont_download_info','T001_cont_1','T001');

