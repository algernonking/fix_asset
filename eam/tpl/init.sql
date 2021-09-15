



delete from sys_file where id like 'T001_%';
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_1','eam_asset_repair.docx','/tpl/T001/eam_asset_repair.docx',10000,'application/doc','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_2','eam_asset_borrow.docx','/tpl/T001/eam_asset_borrow.docx',10000,'application/doc','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_3','eam_asset_collection.docx','/tpl/T001/eam_asset_collection.docx',10000,'application/doc','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_4','eam_asset_collection_return.docx','/tpl/T001/eam_asset_collection_return.docx',10000,'application/doc','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_5','eam_asset_allocate.docx','/tpl/T001/eam_asset_allocate.docx',10000,'application/doc','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_6','eam_asset_code.docx','/tpl/T001/eam_asset_code.docx',10000,'application/doc','docx');
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_7','eam_asset_card.docx','/tpl/T001/eam_asset_card.docx',10000,'application/doc','docx');



delete from eam_tpl_file where tenant_id='T001' and code in ('eam_asset_code','eam_asset_borrow','eam_asset_collection_return','eam_asset_repair','eam_asset_card','eam_asset_collection','eam_asset_tranfer','eam_asset_allocate');
insert into eam_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_1','bill_docx','资产报修','eam_asset_repair','T001_1','T001');
insert into eam_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_2','bill_docx','资产借用','eam_asset_borrow','T001_2','T001');
insert into eam_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_3','bill_docx','资产领用','eam_asset_collection','T001_3','T001');
insert into eam_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_4','bill_docx','资产领用退库','eam_asset_collection_return','T001_4','T001');
insert into eam_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_5','bill_docx','资产调拨','eam_asset_allocate','T001_5','T001');
insert into eam_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_6','bill_docx','资产编码','eam_asset_code','T001_6','T001');
insert into eam_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_7','bill_docx','资产编卡片','eam_asset_card','T001_7','T001');
insert into eam_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_8','bill_docx','资产转移','eam_asset_tranfer','T001_8','T001');

