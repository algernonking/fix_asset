

/* 初始化文件 */
/* EAM */
delete from sys_file where id like 'T001_eam_%';
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_1','eam_asset_repair.docx','/tpl/T001/eam_asset_repair.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_2','eam_asset_borrow.docx','/tpl/T001/eam_asset_borrow.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_3','eam_asset_collection.docx','/tpl/T001/eam_asset_collection.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_4','eam_asset_collection_return.docx','/tpl/T001/eam_asset_collection_return.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_5','eam_asset_allocate.docx','/tpl/T001/eam_asset_allocate.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_6','eam_asset_label.docx','/tpl/T001/eam_asset_label.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_7','eam_asset_card.docx','/tpl/T001/eam_asset_card.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_8','eam_asset_tranfer.docx','/tpl/T001/eam_asset_tranfer.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_9','eam_download_asset.xls','/tpl/T001/eam_download_asset.xls',10000,'application/octet-stream','xls');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_10','eam_download_scrap.docx','/tpl/T001/eam_asset_scrap.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_11','eam_asset_register.docx','/tpl/T001/eam_asset_register.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_12','eam_asset_stock_goods_in.docx','/tpl/T001/eam_asset_stock_goods_in.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_13','eam_asset_stock_goods_out.docx','/tpl/T001/eam_asset_stock_goods_out.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_14','eam_asset_stock_goods_tranfer.docx','/tpl/T001/eam_asset_stock_goods_tranfer.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_15','eam_asset_stock_goods_adjust.docx','/tpl/T001/eam_asset_stock_goods_adjust.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_16','eam_asset_consumables_goods_in.docx','/tpl/T001/eam_asset_consumables_goods_in.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_17','eam_asset_consumables_goods_out.docx','/tpl/T001/eam_asset_consumables_goods_out.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_18','eam_asset_consumables_goods_tranfer.docx','/tpl/T001/eam_asset_consumables_goods_tranfer.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_19','eam_asset_consumables_goods_adjust.docx','/tpl/T001/eam_asset_consumables_goods_adjust.docx',10000,'application/octet-stream','docx');

insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_20','eam_asset_part_goods_in.docx','/tpl/T001/eam_asset_part_goods_in.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_21','eam_asset_part_goods_out.docx','/tpl/T001/eam_asset_part_goods_out.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_22','eam_asset_part_goods_tranfer.docx','/tpl/T001/eam_asset_part_goods_tranfer.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_23','eam_asset_part_goods_adjust.docx','/tpl/T001/eam_asset_part_goods_adjust.docx',10000,'application/octet-stream','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_24','eam_batch_upload_asset.xls','/tpl/T001/eam_batch_upload_asset.xls',10000,'application/octet-stream','xls');

delete from sys_tpl_file where tenant_id='T001' and type in ('eam_bill_docx','eam_asset_excel');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_1','eam_bill_docx','资产报修','eam_download_asset_repair_bill','T001_eam_1','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_2','eam_bill_docx','资产借用','eam_download_asset_borrow_bill','T001_eam_2','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_3','eam_bill_docx','资产领用','eam_download_asset_collection_bill','T001_eam_3','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_4','eam_bill_docx','资产领用退库','eam_download_asset_collection_return_bill','T001_eam_4','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_5','eam_bill_docx','资产调拨','eam_download_asset_allocate_bill','T001_eam_5','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_6','eam_bill_docx','资产标签','eam_download_asset_label','T001_eam_6','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_7','eam_bill_docx','资产编卡片','eam_download_asset_card','T001_eam_7','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_8','eam_bill_docx','资产转移','eam_download_asset_tranfer_bill','T001_eam_8','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_9','eam_asset_excel','资产数据下载','eam_download_asset','T001_eam_9','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_10','eam_bill_docx','资产报废','eam_download_asset_scrap_bill','T001_eam_10','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_11','eam_bill_docx','资产登记','eam_download_asset_register_bill','T001_eam_11','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_12','eam_bill_docx','库存物品入库','eam_download_asset_stock_goods_in_bill','T001_eam_12','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_13','eam_bill_docx','库存物品出库','eam_download_asset_stock_goods_out_bill','T001_eam_13','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_14','eam_bill_docx','库存物品转移','eam_download_asset_stock_goods_tranfer_bill','T001_eam_14','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_15','eam_bill_docx','库存物品调整','eam_download_asset_stock_goods_adjust_bill','T001_eam_15','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_16','eam_bill_docx','耗材物品入库','eam_download_asset_consumables_goods_in_bill','T001_eam_16','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_17','eam_bill_docx','耗材物品出库','eam_download_asset_consumables_goods_out_bill','T001_eam_17','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_18','eam_bill_docx','耗材物品转移','eam_download_asset_consumables_goods_tranfer_bill','T001_eam_18','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_19','eam_bill_docx','耗材物品调整','eam_download_asset_consumables_goods_adjust_bill','T001_eam_19','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_20','eam_bill_docx','备件物品入库','eam_download_asset_part_goods_in_bill','T001_eam_20','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_21','eam_bill_docx','备件物品出库','eam_download_asset_part_goods_out_bill','T001_eam_21','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_22','eam_bill_docx','备件物品转移','eam_download_asset_part_goods_tranfer_bill','T001_eam_22','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_23','eam_bill_docx','备件物品调整','eam_download_asset_part_goods_adjust_bill','T001_eam_23','T001');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_24','eam_asset_excel','资产数据上传','eam_batch_upload_asset','T001_eam_24','T001');


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

