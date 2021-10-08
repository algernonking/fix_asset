#!/bin/sh
#####################################################################
# Script Help:
#     sh run.sh start|stop|restart
#
#####################################################################
####################### Java Environment ############################
JAVA=java


####################### Configure ###################################
app_name="app.jar"
app_dir=/tmp/eam
app_log=$app_dir/log
app_log_file=$app_log/app.log

####################### Parameter ####################################
app_process_mark="welcome_come_to_use_it"
action=start
if [[ -n $1 ]];then
  action=$1
fi
###########
which $JAVA
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
    nohup $JAVA  -Dloader.path=./lib/ -Xmx512m -jar $app_name -dprocess_Mark=$app_process_mark  >$app_log_file 2>&1 &
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



