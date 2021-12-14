#!/bin/sh
#####################################################################
# Script Help:
#     sh eam.sh start|stop|restart
#
#####################################################################
####################### Configure ###################################
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
app_dir=$cur_dir/..
app_log=$app_dir/logs
app_log_file=$app_log/app.log

app_name=`cat $app_conf|grep -v "#"|grep APP_NAME=|awk -F "=" '{print $2}'`
####################### Java Environment ############################
JAVA=`cat $app_conf|grep -v "#"|grep JAVA=|awk -F "=" '{print $2}'`
#java_Xmx="-Xmx1024m"
java_Xmx=""
####################### App Environment ############################
if [[ ! -d $app_dir ]];then
  echo "App_dir:$app_dir not exist"
  exit 1;
fi

cDir="$app_dir/data
$app_dir/logs
$app_dir/tmp
$app_dir/update
$app_dir/backup/dbdata
$app_dir/upload
$app_dir/upload/tpl/T001
"
for cdir in $cDir
do
  if [[ ! -d "$cdir" ]];then
     mkdir -p "$cdir"
  fi
done
####################### Parameter ####################################
app_process_mark="wctuihw_$app_name"
action=start
if [[ -n $1 ]];then
  action=$1
fi
###########
#which $JAVA
javaChk=$?
if [[ $javaChk -ne 0 ]];then
  echo "Java not found!"
  exit 1
fi
#######################Function start stop ... #######################
env(){
  if [[ ! -d $app_dir ]];then
      mkdir -p $app_dir
  fi
  if [[ ! -d $app_log ]];then
      mkdir -p $app_log
  fi
}

start(){
  env
  echo "Action Start"
  cd $app_dir
  pidcnt=`ps -ef|grep java|grep $app_process_mark|grep -v grep |awk '{print $2}'|wc -l`
  if [[ $pidcnt -ge 1 ]];then
    echo "Process is already running,please first stop it."
  else
    nohup $JAVA  -Dloader.path=./lib/ $java_Xmx -jar $app_name -dprocess_Mark=$app_process_mark --Dspring.config.location=$app_dir/application.yml>$app_log_file 2>&1 &
    sleep 3
    pidlist2=`ps -ef|grep java|grep $app_process_mark|grep -v grep |awk '{print $2}'`
    pidcnt2=`ps -ef|grep java|grep $app_process_mark|grep -v grep |awk '{print $2}'|wc -l`
    if [[ $pidcnt2 -ge 1 ]];then
        echo "process start success,pid:$pidlist2"
    fi
  fi
}

stop(){
  echo "Action Stop"
  pidlist=`ps -ef|grep java|grep $app_process_mark|grep -v grep |awk '{print $2}'`
  pidcnt=`ps -ef|grep java|grep $app_process_mark|grep -v grep |awk '{print $2}'|wc -l`
  if [[ $pidcnt -ge 1 ]];then
      echo "running process number:$pidcnt"
      for pid in $pidlist
      do
          echo "start to kill process,pid:$pid"
          kill -9 $pid
      done
      echo "process stop success!"
  else
      echo "not found running process."
  fi
}

restart(){
  stop
  sleep 2
  start
}

status(){
  echo "Action Status"
  pidlist=`ps -ef|grep java|grep $app_process_mark|grep -v grep |awk '{print $2}'`
  pidcnt=`ps -ef|grep java|grep $app_process_mark|grep -v grep |awk '{print $2}'|wc -l`
  if [[ $pidcnt -ge 1 ]];then
    echo "process is running,pid:$pidlist"
  else
    echo "process is not running"
  fi
}

help(){
    echo "Help:"
    echo "  sh run.sh start|stop|status|restart"
}
#zip wrapper-all-0.0.2.RELEASE.jar BOOT-INF/classes/application.yml
######################## Main ########################################
if [[ $action == "start" ]];then
  start
elif [[ $action == "stop" ]];then
  stop
elif [[ $action == "restart" ]];then
  restart
elif [[ $action == "status" ]];then
  status
else
  echo "Run Command Error.";
  help
  exit 1
fi

exit 0



