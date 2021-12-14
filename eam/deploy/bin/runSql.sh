#!/bin/sh
#
#
###############################################################
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
MYSQL=`cat $app_conf|grep -v "#"|grep MYSQL=|awk -F "=" '{print $2}'`
DATA_CLEAR=`cat $app_conf|grep -v "#"|grep DATA_CLEAR=|awk -F "=" '{print $2}'`
DB_NAME=`cat $app_conf|grep -v "#"|grep DB_NAME=|awk -F "=" '{print $2}'`
DB_HOST=`cat $app_conf|grep -v "#"|grep DB_HOST=|awk -F "=" '{print $2}'`
DB_USER=`cat $app_conf|grep -v "#"|grep DB_USER=|awk -F "=" '{print $2}'`
DB_PWD=`cat $app_conf|grep -v "#"|grep DB_PWD=|awk -F "=" '{print $2}'`

if [[ -n $1 ]];then
  echo "run sql file:$1";
else
  echo "Please input sql file path!"
  exit 1
fi
SQL=$1

if [[ ! -f $SQL ]];then
  echo "sql file path not exist!"
  exit 1
fi

$MYSQL -u$DB_USER -p$DB_PWD -h$DB_HOST $DB_NAME < $SQL

exit 0

