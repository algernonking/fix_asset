#!/bin/sh
logfile="/tmp/app.log"
apptar="app_release.tar.gz"
MYSQL=/usr/bin/mysql
JAVA=/usr/local/java/bin/java
id>>$logfile
d=`date "+%Y-%m-%d %H:%M:%S"`
echo "################ Start App ###################">>$logfile
echo "docker start $d">>$logfile
cd /tmp
sleep 5
dbCnt=`$MYSQL -uroot -p$MYSQL_ROOT_PASSWORD -e "show databases"|grep app |wc -l`
if [ $dbCnt -eq 0 ];then
  #init database
  echo "start to init database">>$logfile
  sleep 10
  $MYSQL -uroot -p$MYSQL_ROOT_PASSWORD <<EOF
    CREATE DATABASE app DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
    set names utf8;
    use app;
    source /tmp/app.sql;
    source /tmp/nextVal.sql;
EOF
  rm -rf /tmp/app.sql
  #init app
  echo "sleep 5">>$logfile
  sleep 5
  echo "first run,create /opt/app">>$logfile
  mkdir /opt/app
  cd /opt/app
  cp /tmp/$apptar .
  tar xvf $apptar
  mkdir -p /opt/app/logs
  mkdir -p /opt/app/upload
  mkdir -p /opt/app/tmp
  mkdir -p /opt/app/data
  #modify password DOCKER_PASSWORD
  sed -i "s@DOCKER_PASSWORD@$MYSQL_ROOT_PASSWORD@g" /opt/app/application.yml
  YML_DB="app?useSSL"
  sed -i "s@eam?useSSL@$YML_DB@g" /opt/app/application.yml
fi
cd /opt/app
datetime=`date "+%Y-%m-%d %H:%M:%S"`
echo "start to app,time:$datetime">>$logfile
nohup $JAVA -noverify -Dfile.encoding=UTF-8 -Dloader.path=./lib/ -jar app.jar -dprocess_Mark=docker_app.jar_app --Dspring.config.location=/opt/app/application.yml 2>&1 &
echo "################ End App ###################\n">>$logfile
exit 0
