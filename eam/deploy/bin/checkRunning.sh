#!/bin/sh
#cron:
#   0 */1 * * * sh /opt/eam/bin/checkRunning.sh
checkfile="/tmp/checkEamRunning.log"
cur_dir=$(cd `dirname $0`; pwd)
d=`date`
echo "$d">>$checkfile
c=`curl --connect-timeout 5 -m 20 http://eam-demo.rainbooow.com:26788/login.html|wc -l`
if [[ $c -lt 30 ]];then
  cd $cur_dir/..
  echo "check failed,go to restart!">>$checkfile
  sh eamRestart.sh
else
  echo "check success!">>$checkfile
fi
exit 0
