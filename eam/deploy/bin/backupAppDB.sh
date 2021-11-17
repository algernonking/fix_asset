#!/bin/sh
#cron:
#   12 12 * * * sh /opt/eam/bin/backupAppDB.sh
########################################
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
MYSQL=`cat $app_conf|grep MYSQL=|awk -F "=" '{print $2}'`
MYSQL_DUMP=`cat $app_conf|grep MYSQL_DUMP=|awk -F "=" '{print $2}'`
MYSQL=`cat $app_conf|grep MYSQL=|awk -F "=" '{print $2}'`
DB_NAME=`cat $app_conf|grep DB_NAME=|awk -F "=" '{print $2}'`
DB_USER=`cat $app_conf|grep DB_USER=|awk -F "=" '{print $2}'`
DB_HOST=`cat $app_conf|grep DB_HOST=|awk -F "=" '{print $2}'`
DB_PWD=`cat $app_conf|grep DB_PWD=|awk -F "=" '{print $2}'`


BACKUP_DIR=`cat $app_conf|grep BACKUP_DIR=|awk -F "=" '{print $2}'`
TODAY=`date +%Y%m%d_%H`

if [[ ! -d $BACKUP_DIR ]];then
  echo "backup dir not exist."
  exit 1
fi

cd $BACKUP_DIR
$MYSQL_DUMP -u$DB_USER -p$DB_PWD -h$DB_HOST $DB_NAME  > eam.sql
tar zcvf eam_backup_$TODAY.tar.gz  ./eam.sql
exit 0

