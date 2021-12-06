#!/bin.sh
#
############################################
app_dir=/opt/eam
if [[ ! -d $app_dir ]];then
  exit 1
fi
demo_sql="/tmp/demo.sql"
app_conf="${app_dir}/bin/app.conf"
MYSQL=`cat $app_conf|grep MYSQL=|awk -F "=" '{print $2}'`
MYSQL_DUMP=`cat $app_conf|grep MYSQL_DUMP=|awk -F "=" '{print $2}'`
MYSQL=`cat $app_conf|grep MYSQL=|awk -F "=" '{print $2}'`
DB_NAME=`cat $app_conf|grep DB_NAME=|awk -F "=" '{print $2}'`
DB_USER=`cat $app_conf|grep DB_USER=|awk -F "=" '{print $2}'`
DB_HOST=`cat $app_conf|grep DB_HOST=|awk -F "=" '{print $2}'`
DB_PWD=`cat $app_conf|grep DB_PWD=|awk -F "=" '{print $2}'`
#create demo.sql
$MYSQL_DUMP -u$DB_USER -p$DB_PWD -h$DB_HOST eam  > $demo_sql
$MYSQL -u$DB_USER -p$DB_PWD -h$DB_HOST eam_demo < $demo_sql
if [[ -f $app_dir/update/update.tar ]];then
  rm -rf $app_dir/update/update.tar
fi
cp /tmp/app.tar $app_dir/update/update.tar
cd $app_dir
sh bin/updateApp.sh
sleep 2
sh eamRestart.sh
exit 0
