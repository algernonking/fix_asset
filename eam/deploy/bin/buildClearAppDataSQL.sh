#!/bin/sh
#
###############################################################
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
MYSQL=`cat $app_conf|grep -v "#"|grep MYSQL=|awk -F "=" '{print $2}'`
DATA_CLEAR=`cat $app_conf|grep -v "#"|grep DATA_CLEAR=|awk -F "=" '{print $2}'`
DB_NAME=`cat $app_conf|grep -v "#"|grep DB_NAME=|awk -F "=" '{print $2}'`
DB_USER=`cat $app_conf|grep -v "#"|grep DB_USER=|awk -F "=" '{print $2}'`
DB_HOST=`cat $app_conf|grep -v "#"|grep DB_HOST=|awk -F "=" '{print $2}'`
DB_PWD=`cat $app_conf|grep DB_PWD=|awk -F "=" '{print $2}'`

clear_sql="$cur_dir/sql/eam_cleardata.sql"
tenant=1
tenant_id="T001"
tenant_sql=" "

echo "DB_NAME:$DB_NAME"
echo "DB_USER:$DB_USER"
echo "DB_HOST:$DB_HOST"
echo "SQL_PATH:$clear_sql"
if [[ $DATA_CLEAR -ne 1 ]];then
  echo "data clear setting is $DATA_CLEAR,can't clear it."
  exit 1
fi

if [[ $tenant -eq 1 ]];then
  tenant_sql=" and tenant_id='${tenant_id}' ";
fi

echo "">$clear_sql
echo "-- start"                                                       >>$clear_sql
echo "-- clear kn"                                                    >>$clear_sql
echo "delete from kn_content where 1=1 $tenant_sql; "                 >>$clear_sql

echo "-- clear ops">>$clear_sql
echo "delete from ops_host where 1=1 $tenant_sql; "                   >>$clear_sql
echo "delete from ops_host_db where 1=1 ; "                           >>$clear_sql
echo "delete from ops_host_mid where 1=1; "                           >>$clear_sql
echo "delete from ops_host_os where 1=1; "                            >>$clear_sql
echo "delete from ops_information_system where 1=1 $tenant_sql; "     >>$clear_sql
echo "delete from ops_db_instance where 1=1 $tenant_sql; "            >>$clear_sql
echo "delete from ops_voucher where 1=1 $tenant_sql; "                >>$clear_sql
echo "delete from ops_voucher_history where 1=1 $tenant_sql; "        >>$clear_sql
echo "delete from ops_voucher_owner where 1=1 $tenant_sql; "          >>$clear_sql
echo "delete from ops_voucher_priv where 1=1 $tenant_sql; "           >>$clear_sql

echo "-- eam"                                                         >>$clear_sql
echo "delete from eam_warehouse where 1=1 $tenant_sql; "              >>$clear_sql
echo "delete from eam_asset where 1=1 $tenant_sql; "                  >>$clear_sql
echo "delete from eam_asset_item where 1=1; "                         >>$clear_sql
echo "delete from eam_asset_batch where 1=1;"                         >>$clear_sql
echo "delete from eam_asset_process_record where 1=1;"                >>$clear_sql
echo "delete from eam_asset_selected_data where 1=1 $tenant_sql;"     >>$clear_sql
echo "delete from eam_asset_data_change where 1=1 $tenant_sql;"       >>$clear_sql

echo "delete from eam_asset_repair where 1=1 $tenant_sql; "           >>$clear_sql
echo "delete from eam_asset_scrap where 1=1 $tenant_sql; "            >>$clear_sql
echo "delete from eam_asset_allocation where 1=1 $tenant_sql; "       >>$clear_sql
echo "delete from eam_asset_borrow where 1=1 $tenant_sql; "           >>$clear_sql
echo "delete from eam_asset_borrow_return where 1=1; "                >>$clear_sql
echo "delete from eam_asset_collection where 1=1 $tenant_sql; "       >>$clear_sql
echo "delete from eam_asset_collection_return where 1=1 $tenant_sql;" >>$clear_sql
echo "delete from eam_asset_handle where 1=1 $tenant_sql;"            >>$clear_sql
echo "delete from eam_asset_tranfer where 1=1 $tenant_sql;"           >>$clear_sql

echo "-- inventory"                                                   >>$clear_sql
echo "delete from eam_inventory where 1=1 $tenant_sql;"               >>$clear_sql
echo "delete from eam_inventory_asset where 1=1 ;"                    >>$clear_sql
echo "delete from eam_inventory_director where 1=1 ;"                 >>$clear_sql
echo "delete from eam_inventory_manager where 1=1 ;"                  >>$clear_sql
echo "delete from eam_inventory_user where 1=1 ;"                     >>$clear_sql


echo "-- stock"                                                       >>$clear_sql
echo "delete from eam_stock where 1=1 $tenant_sql;"                   >>$clear_sql
echo "delete from eam_asset_stock_collection where 1=1;"              >>$clear_sql

echo "-- dc"                                                          >>$clear_sql
#echo "delete from dc_area where 1=1 $tenant_sql;"                     >>$clear_sql
#echo "delete from dc_layer where 1=1 $tenant_sql;"                    >>$clear_sql
#echo "delete from dc_rack where 1=1 $tenant_sql;"                     >>$clear_sql

echo "-- cont"                                                        >>$clear_sql
echo "delete from cont_company where 1=1 $tenant_sql; "               >>$clear_sql
echo "delete from cont_contract where 1=1 $tenant_sql; "              >>$clear_sql
echo "delete from cont_contract_fund where 1=1 $tenant_sql; "         >>$clear_sql
echo "delete from cont_contract_invoice where 1=1 $tenant_sql; "      >>$clear_sql


echo "delete from hrm_person where deleted='1';" >>$clear_sql
echo "delete from hrm_employee where deleted='1';" >>$clear_sql
echo "delete from sys_user where deleted='1';" >>$clear_sql


echo "-- logic delete"
echo "delete from dp_rule where deleted='1';     "                     >>$clear_sql
echo "delete from dp_rule_condition where deleted='1';  "              >>$clear_sql
echo "delete from dp_rule_range where deleted='1';   "                 >>$clear_sql
echo "delete from dp_rule_condition where id in (select id from (select id from dp_rule_condition where range_id not in (select id from dp_rule_range) )t);  " >>$clear_sql
echo "delete from dp_rule_condition where id in (select id from (select id from dp_rule_condition where rule_id not in (select id from dp_rule) )t);  "        >>$clear_sql


echo "-- end"                                                         >>$clear_sql



echo "-- commit"                                                      >>$clear_sql


exit 0



delete from eam_asset where 1=1      ;
delete from eam_asset_item where 1=1 ;
delete from eam_asset_repair where 1=1  ;
delete from eam_asset_scrap where 1=1      ;
delete from eam_asset_allocation where 1=1;
delete from eam_asset_borrow where 1=1 ;
delete from eam_asset_borrow_data  ;
delete from eam_asset_collection  ;
delete from eam_asset_collection_return ;
delete from eam_asset_handle where 1=1  ;


