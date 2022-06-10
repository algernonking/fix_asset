#!/bin/sh
#2 2 * * * sh /opt/eam/bin/clearData.sh
cur_dir=$(cd `dirname $0`; pwd)
log_dir=$cur_dir/..
log_file=$log_dir/logs/clearData.log
#delete logs file
if [[ -d "$cur_dir/../logs" ]];then
  cd $cur_dir/../logs
  find ./ -mtime +30 -name "*.log" -exec rm -rf {} \;
  echo "delete $cur_dir/../logs file success">>$log_file
fi
#delete backup file
exit 0


