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

echo "###start to check java version 1.8"
java_version_cnt=`$JAVA -version 2>&1|grep 1.8 |wc -l`
java_version_cnt_ct=`$JAVA -version 2>&1|grep 1.8|head -1`
if [[ $java_version_cnt -gt 0 ]];then
   echo -e "   \033[31m java version [ $java_version_cnt_ct ] sucess! \033[0m"
else
   echo -e "   \033[31m java version [ $java_version_cnt_ct ] failed! \033[0m"
fi

echo "###start to check mysql command"
mysqlpath=`which $MYSQL 2>&1`
mysql_result="$?"
if [[ mysql_result -eq "1" ]];then
  echo -e "   \033[31m check mysql failed! \033[0m"
else
  echo -e "   \033[33m check mysql $mysqlpath success! \033[0m"
fi

echo "###start to check mysql version"
mysql_version_cnt=`$MYSQL --version|grep 5.7|head -1|wc -l`
mysql_version_cnt_ct=`$MYSQL --version|grep 5.7|head -1`
if [[ $mysql_version_cnt -gt 0 ]];then
  echo -e "   \033[31m check mysql version [$mysql_version_cnt_ct]  success! \033[0m"
else
  echo -e "   \033[33m check mysql version [$mysql_version_cnt_ct] failed! \033[0m"
fi

echo "###start to check mysql parameter lower_case_table_names"
mysql_pars_lower=`$MYSQL -u$DB_USER -p$DB_PWD -h$DB_HOST -e "show variables like '%lower_case_table_names%' " 2>/dev/null |grep lower_case_table_names |awk '{print $NF}'`
if [[ $mysql_pars_lower -eq 1 ]];then
  echo -e "   \033[31m check mysql parameter lower_case_table_names success! \033[0m"
else
  echo -e "   \033[31m check mysql parameter lower_case_table_names failed! \033[0m"
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
echo "modify application.yml using below info"
echo "url: jdbc:mysql://127.0.0.1:$DB_PORT/$DB_NAME?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&autoReconnect=true&allowPublicKeyRetrieval=true&tinyInt1isBit=false "
echo "username: $DB_USER"
echo "password: $DB_PWD"
mysql_ping_cnt=`$MYSQL_ADMIN -u$DB_USER -p$DB_PWD ping 2>&1|grep alive|wc -l`
if [[ $mysql_ping_cnt -gt 0 ]];then
  echo -e "   \033[33m check mysql connect,user $DB_USER success! \033[0m"
else
  echo -e "   \033[31m check mysql connect,user $DB_USER failed! \033[0m"
fi

echo "###start to check application.yml db connect info url"
yml_url_check=`cat $yml_file|grep -v "#"|grep "jdbc:mysql://127.0.0.1:$DB_PORT/$DB_NAME"|wc -l`
if [[ $yml_url_check -gt 0 ]];then
  echo -e "   \033[33m check application.yml db connect info url success! \033[0m"
else
  echo -e "   \033[31m check application.yml db connect info url failed! \033[0m"
fi

echo "###start to check application.yml db connect info username"
yml_user_check=`cat $yml_file|grep username|grep -v "#"|grep $DB_USER|wc -l`
if [[ $yml_user_check -gt 0 ]];then
  echo -e "   \033[33m check application.yml db connect info username success! \033[0m"
else
  echo -e "   \033[31m check application.yml db connect info username failed! \033[0m"
fi

echo "###start to check procedure nextVal"


echo "###start to check mysql connect from yml file"
#if [[ -f "$yml_file" ]];then
#  echo "db_user:$DB_USER"
#  echo "db_pwd:$DB_PWD"
#  sLine=`cat -n $yml_file |grep datasource|awk '{print $1}'`
#else
#   echo -e "   \033[31m check yml file not exist failed! \033[0m"
#fi
exit 0

mysql -uroot -pP@sswOracle123456 eam