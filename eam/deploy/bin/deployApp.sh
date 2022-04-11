#!/bin/sh
#cron:
#   12 12 * * * sh /opt/eam/bin/deployAppDB.sh eam
########################################
curTime=`date +"%Y%m%d%H%M%S"`
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
app_dir=$cur_dir/..
db_name=eam


echo "#########start to deploy"
#db_user=root
#db_pwd=P@sswOracle123456
db_name=`cat $app_conf|grep -v "#"|grep DB_NAME=|awk -F "=" '{print $2}'`
app_port=`cat $app_conf|grep -v "#"|grep APP_WEB_PORT=|awk -F "=" '{print $2}'`
db_user=`cat $app_conf|grep -v "#"|grep DB_USER=|awk -F "=" '{print $2}'`
db_pwd=`cat $app_conf|grep DB_PWD=|awk -F "=" '{print $2}'`
db_port=`cat $app_conf|grep -v "#"|grep DB_PORT=|awk -F "=" '{print $2}'`
db_host=`cat $app_conf|grep -v "#"|grep DB_HOST=|awk -F "=" '{print $2}'`

if [[ -n $1 ]];then
  db_name=$1
fi

echo "app_port:$app_port"
echo "db_host:$db_host"
echo "db_port:$db_port"
echo "db_name:$db_name"
echo "db_user:$db_user"
echo "db_pwd:$db_pwd"

if [[ ! $db_user = "root" ]];then
  echo "db_user must be root,current value:$db_user"
  exit 1
fi


MYSQL=`cat $app_conf|grep -v "#"|grep MYSQL=|awk -F "=" '{print $2}'`
MYSQL_DUMP=`cat $app_conf|grep -v "#"|grep MYSQL_DUMP=|awk -F "=" '{print $2}'`
db_create_db_file=$app_dir/bin/deploy/sql/deployCreateDb.sql
db_sql_file=$app_dir/bin/deploy/sql/deployAppDbDataInit.sql
db_procedure_file=$app_dir/bin/deploy/sql/nextVal_root.sql
application_yml_tpl=$app_dir/bin/deploy/application.yml
application_yml=$app_dir/application.yml

#检查文件
if [[ ! -f "$db_sql_file" ]];then
  echo "Error|db sql file:$db_sql_file not exist"
  echo "deploy failed!"
  exit 1
fi

if [[ ! -f "$db_procedure_file" ]];then
  echo "Error|db procedure file:$db_procedure_file not exist"
  echo "deploy failed!"
  exit 1
fi

echo "#########start to create database"
echo "CREATE DATABASE $db_name DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;" > $db_create_db_file
db_cnt=`$MYSQL -u$db_user -p$db_pwd -e 'show databases;' 2>/dev/null|grep $db_name|wc -l `
if [[ $db_cnt -gt 0 ]];then
  echo "Error|db:$db_name exist!"
  echo "deploy failed!"
  exit 1
fi

$MYSQL -u$db_user -p$db_pwd -h$db_host  < $db_create_db_file  2>/dev/null
tab_cnt=`$MYSQL -u$db_user -p$db_pwd $db_name -e 'show tables' 2>/dev/null |wc -l`
echo "create database success,table count:$tab_cnt"

#load 表前做备份
echo "#########start to backup db"
$MYSQL_DUMP -u$db_user -p$db_pwd -h$db_host $db_name  > /tmp/db.sql  2>/dev/null

echo "#########start to load data"
$MYSQL -u$db_user -p$db_pwd -h$db_host $db_name < $db_sql_file  2>/dev/null
tab_cnt=`$MYSQL -u$db_user -p$db_pwd $db_name -e 'show tables' 2>/dev/null |wc -l`
echo "load tables success,table count:$tab_cnt"

echo "#########start to create procedure"
$MYSQL -u$db_user -p$db_pwd -h$db_host $db_name < $db_procedure_file  2>/dev/null

echo "#########start to create application.yml from $application_yml_tpl"
cat $application_yml_tpl>$application_yml
sed -i "s/APP_WEB_PORT/$app_port/g"     $application_yml
sed -i "s/APP_DB_PORT/$db_port/g"       $application_yml
sed -i "s/APP_DB_NAME/$db_name/g"       $application_yml
sed -i "s/APP_DB_USERNAME/$db_user/g"   $application_yml
sed -i "s/APP_DB_PASSWORD/$db_pwd/g"    $application_yml

exit 0