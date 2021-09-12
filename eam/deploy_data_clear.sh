#!/bin.sh
#清除数据不考虑租户
#
#
clear_sql="/tmp/cleardata.sql"
mysql_pwd=`cat /opt/password.txt|tail -1`
tenant=1
tenant_id="T001"
tenant_sql=" "

if [[ $tenant -eq 1 ]];then
  tenant_sql=" and tenant_id='${tenant_id}' ";
fi
echo $tenant_sql
echo "-- start"                                                        >$clear_sql
echo "-- clear kn"                                                    >>$clear_sql
echo "delete from kn_content where 1=1 $tenant_sql; "                 >>$clear_sql

echo "-- clear ops">>$clear_sql
echo "delete from ops_host where 1=1 $tenant_sql; "                   >>$clear_sql
echo "delete from ops_host_db where 1=1 $tenant_sql; "                >>$clear_sql
echo "delete from ops_host_mid where 1=1 $tenant_sql; "               >>$clear_sql
echo "delete from ops_host_os where 1=1 $tenant_sql; "                >>$clear_sql
echo "delete from ops_information_system where 1=1 $tenant_sql; "     >>$clear_sql
echo "delete from ops_db_instance where 1=1 $tenant_sql; "            >>$clear_sql
echo "delete from ops_voucher where 1=1 $tenant_sql; "                >>$clear_sql
echo "delete from ops_voucher_history where 1=1 $tenant_sql; "        >>$clear_sql
echo "delete from ops_voucher_owner where 1=1 $tenant_sql; "          >>$clear_sql
echo "delete from ops_voucher_priv where 1=1 $tenant_sql; "           >>$clear_sql

echo "-- eam"                                                         >>$clear_sql
echo "delete from eam_asset where 1=1 $tenant_sql; "                  >>$clear_sql
echo "delete from eam_asset_item where 1=1 $tenant_sql; "             >>$clear_sql
echo "delete from eam_warehouse where 1=1 $tenant_sql; "              >>$clear_sql
echo "delete from eam_asset_repair where 1=1 $tenant_sql; "           >>$clear_sql
echo "delete from eam_asset_scrap where 1=1 $tenant_sql; "            >>$clear_sql
echo "delete from eam_asset_allocation where 1=1 $tenant_sql; "       >>$clear_sql
echo "delete from eam_asset_borrow where 1=1 $tenant_sql; "           >>$clear_sql
echo "delete from eam_asset_borrow_data where 1=1 $tenant_sql; "      >>$clear_sql
echo "delete from eam_asset_collection where 1=1 $tenant_sql; "       >>$clear_sql
echo "delete from eam_asset_collection_return where 1=1 $tenant_sql;" >>$clear_sql
echo "delete from eam_asset_handle where 1=1 $tenant_sql;"            >>$clear_sql

eam_asset_scrap
echo "-- dc"                                                          >>$clear_sql


echo "-- cont"                                                        >>$clear_sql
echo "delete from cont_company where 1=1 $tenant_sql; "               >>$clear_sql
echo "delete from cont_contract where 1=1 $tenant_sql; "              >>$clear_sql
echo "delete from cont_contract_fund where 1=1 $tenant_sql; "         >>$clear_sql
echo "delete from cont_contract_invoice where 1=1 $tenant_sql; "      >>$clear_sql

echo "-- end"                                                         >>$clear_sql




