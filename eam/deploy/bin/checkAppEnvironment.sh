#!/bin/sh

cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
app_dir=$cur_dir/..
yml_file=$cur_dir/../application.yml

APP_NAME=`cat $app_conf|grep -v "#"|grep APP_NAME=|awk -F "=" '{print $2}'`
JAVA=`cat $app_conf|grep -v "#"|grep JAVA=|awk -F "=" '{print $2}'`
MYSQL=`cat $app_conf|grep -v "#"|grep MYSQL=|awk -F "=" '{print $2}'`
MYSQL_DUMP=`cat $app_conf|grep -v "#"|grep MYSQL_DUMP=|awk -F "=" '{print $2}'`
MYSQL_ADMIN=`cat $app_conf|grep -v "#"|grep MYSQL_ADMIN=|awk -F "=" '{print $2}'`
DB_HOST=`cat $app_conf|grep -v "#"|grep DB_HOST=|awk -F "=" '{print $2}'`
DB_PORT=`cat $app_conf|grep -v "#"|grep DB_PORT=|awk -F "=" '{print $2}'`
DB_NAME=`cat $app_conf|grep -v "#"|grep DB_NAME=|awk -F "=" '{print $2}'`
DB_USER=`cat $app_conf|grep -v "#"|grep DB_USER=|awk -F "=" '{print $2}'`
DB_PWD=`cat $app_conf|grep -v "#"|grep DB_PWD=|awk -F "=" '{print $2}'`

echo "###start to check application.yml exist"
if [[ -f "$yml_file" ]];then
  echo -e "   \033[33m check $yml_file exist success! \033[0m"
else
  echo -e "   \033[31m check $yml_file exist failed! \033[0m"
fi

if [[ -f "$yml_file" ]];then
  upload_dir=`cat $yml_file |grep linux|grep -v fox|grep -v txt|tail -1|awk -F ":" '{print $NF}'|sed 's/ //g'`
  echo "###start to check upload directory exist"
  if [[ -d $upload_dir ]];then
      echo -e "   \033[33m check upload_dir $upload_dir exist success! \033[0m"
  else
      echo -e "   \033[31m check upload_dir $upload_dir exist failed! \033[0m"
  fi
fi

echo "###start to check app jar exist"
if [[ -f "$app_dir/$APP_NAME" ]];then
  echo -e "   \033[33m check app $app_dir/$APP_NAME exist success! \033[0m"
else
  echo -e "   \033[31m check app $app_dir/$APP_NAME exist failed! \033[0m"
fi

echo "###start to check java command"
jpath=`which $JAVA 2>&1`
java_result="$?"
if [[ $java_result -eq "1" ]];then
  echo -e "   \033[31m check java failed! \033[0m"
else
  echo -e "   \033[33m check java $jpath success! \033[0m"
fi

echo "###start to check mysql command"
mysqlpath=`which $MYSQL 2>&1`
mysql_result="$?"
if [[ mysql_result -eq "1" ]];then
  echo -e "   \033[31m check mysql failed! \033[0m"
else
  echo -e "   \033[33m check mysql $mysqlpath success! \033[0m"
fi

echo "###start to check mysql_dump command"
mysqldumppath=`which $MYSQL_DUMP  2>&1`
mysqldump_result="$?"
if [[ mysqldump_result -eq "1" ]];then
  echo -e "   \033[31m check mysqldump failed! \033[0m"
else
  echo -e "   \033[33m check mysqldump $mysqldumppath success! \033[0m"
fi

echo "###start to check mysql_admin command"
mysqladminpath=`which $MYSQL_ADMIN  2>&1`
mysqladmin_result="$?"
if [[ mysqladmin_result -eq "1" ]];then
  echo -e "   \033[31m check mysqladmin failed! \033[0m"
else
  echo -e "   \033[33m check mysqladmin $mysqladminpath success! \033[0m"
fi

echo "###start to check mysql listen port $DB_PORT"
portCnt=`netstat -ant|grep LISTEN| netstat -ant|grep LISTEN|grep $DB_PORT|wc -l`
if [[ $portCnt -lt 1 ]];then
  echo -e "   \033[31m check mysql port $DB_PORT failed! \033[0m"
else
  echo -e "   \033[33m check mysql port $DB_PORT success! \033[0m"
fi

echo "###start to check mysql connect from app.conf"
echo "db_host:$DB_HOST"
echo "db_user:$DB_USER"
echo "db_pwd:$DB_PWD"
mysql_ping_cnt=`$MYSQL_ADMIN -u$DB_USER -p$DB_PWD ping 2>&1|grep alive|wc -l`
if [[ $mysql_ping_cnt -gt 0 ]];then
  echo -e "   \033[33m check mysql connect,user $DB_USER success! \033[0m"
else
  echo -e "   \033[31m check mysql connect,user $DB_USER failed! \033[0m"
fi

#echo "###start to check mysql connect from yml file"
#if [[ -f "$yml_file" ]];then
#  echo "db_user:$DB_USER"
#  echo "db_pwd:$DB_PWD"
#  sLine=`cat -n $yml_file |grep datasource|awk '{print $1}'`
#else
#   echo -e "   \033[31m check yml file not exist failed! \033[0m"
#fi
exit 0