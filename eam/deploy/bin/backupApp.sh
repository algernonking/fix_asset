#!/bin/sh
#cron:
#   12 12 * * * sh /opt/eam/bin/backupAppDB.sh
########################################
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
app_dir=$cur_dir/..
backup_dir=$app_dir/backup/app
curTime=`date +"%Y%m%d%H%M%S"`
BACKUP_DIR_CNT=`cat $app_conf|grep -v "#"|grep BACKUP_DIR=|awk -F "=" '{print $2}'|wc -l`

if [[ $BACKUP_DIR_CNT -gt 0 ]];then
  dir=`cat $app_conf|grep -v "#"|grep BACKUP_DIR=|awk -F "=" '{print $2}'`
  backup_dir=$dir/app
fi

if [[ ! -d $backup_dir ]];then
  mkdir -p $backup_dir
fi

if [[ ! -d $backup_dir ]];then
  echo "backup dir $backup_dir not exist";
  exit 1
fi

echo "Start to backup application!"
cd $app_dir
backupfile=eam_backup_${curTime}.tar.gz
tar zcvf $backupfile ./lib/* ./*.jar ./application.yml
if [[ ! -f "eam_backup_${curTime}.tar.gz" ]];then
  echo "Backup Application Failed!";
  exit 1;
fi
echo "backup dir:$backup_dir/$backupfile,success!"
mv $backupfile $backup_dir/

exit 0

