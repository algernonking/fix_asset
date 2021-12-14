#!/bin/sh
#cron:
#   12 12 * * * sh /opt/eam/bin/backupAppDB.sh
########################################
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
app_dir=$cur_dir/..
backup_dir=$app_dir/backup/db
MYSQL=`cat $app_conf|grep -v "#"|grep MYSQL=|awk -F "=" '{print $2}'`
MYSQL_DUMP=`cat $app_conf|grep -v "#"|grep MYSQL_DUMP=|awk -F "=" '{print $2}'`
DB_NAME=`cat $app_conf|grep -v "#"|grep DB_NAME=|awk -F "=" '{print $2}'`
DB_USER=`cat $app_conf|grep -v "#"|grep DB_USER=|awk -F "=" '{print $2}'`
DB_HOST=`cat $app_conf|grep -v "#"|grep DB_HOST=|awk -F "=" '{print $2}'`
DB_PWD=`cat $app_conf|grep DB_PWD=|awk -F "=" '{print $2}'`
TODAY=`date +%Y%m%d_%H_%M_%S`
BACKUP_DIR_CNT=`cat $app_conf|grep -v "#"|grep BACKUP_DIR=|awk -F "=" '{print $2}'|wc -l`

if [[ $BACKUP_DIR_CNT -gt 0 ]];then
  dir=`cat $app_conf|grep -v "#"|grep BACKUP_DIR=|awk -F "=" '{print $2}'`
  backup_dir=$dir/db
fi

if [[ ! -d $backup_dir ]];then
  mkdir -p $backup_dir
fi

if [[ ! -d $backup_dir ]];then
  echo "backup dir $backup_dir not exist";
  exit 1
fi

dbname=`echo $DB_NAME`
if [ $1 ];then
  echo "set dbname:$1"
  dbname=$1
fi
file=${dbname}_backup_$TODAY.tar.gz
echo "start to backup,dbname:$dbname,file:$backup_dir/$file"
cd $backup_dir
$MYSQL_DUMP -u$DB_USER -p$DB_PWD -h$DB_HOST $dbname  > db.sql
tar zcvf $file  ./db.sql

exit 0

