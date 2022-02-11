#!/bin/sh
#
##############
logfile="/tmp/app.log"
curdate=`date`
echo "Time:$curdate">>$logfile
echo "process db" >>$logfile
appdbcnt=`mysqlshow -uroot -p$MYSQL_ROOT_PASSWORD|grep eam|wc -l`
if [ $appdbcnt -eq "0" ] ; then
   if [ -f "/tmp/eam.sql" ];then
        mysql -uroot -p$MYSQL_ROOT_PASSWORD <<EOF
        CREATE DATABASE IF NOT EXISTS eam default charset utf8 COLLATE utf8_general_ci;
        set names utf8;
        use eam;
        source /tmp/eam.sql
        source /tmp/next.sql
        source /tmp/eam.sql
EOF
   fi
else
    echo "db eam is exits"
fi

echo "hello2">>/tmp/action.log
cd /usr/local/bin/
sh startapp.sh
exit 0

docker run --name eam_base1 -t \
-e MYSQL_USER="eam" \
-e MYSQL_PASSWORD="eam_pwd" \
-e MYSQL_ROOT_PASSWORD=root_pwd \
-v /data/mysql:/var/lib/mysql  \
-p 3307:3306 \
-d docker.io/algernonking/dtmysql:base \
--character-set-server=utf8

dd=af7adc2e672b

docker cp docker-entrypoint.sh $dd:/usr/local/bin/
docker cp startapp.sh $dd:/usr/local/bin/
docker cp installdata.sh $dd:/tmp/
docker cp jdk8.tar.gz $dd:/tmp/



docker exec -it $dd /bin/bash
mkdir -p /opt/eam
mkdir -p /opt/java
chmod -R 777 /opt/
cd /docker-entrypoint-initdb.d;rm -rf installdata.sh ; mv /tmp/installdata.sh .;chmod +x installdata.sh

docker commit $dd docker.io/algernonking/eamapp:base
docker stop $dd;docker rm $dd


dd=24322ccd466e
docker cp  $dd:/tmp/jdk8.tar.gz .
docker cp  $dd:/usr/local/bin/docker-entrypoint.sh .

docker cp a $dd:/tmp/