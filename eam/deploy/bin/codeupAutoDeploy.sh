#!/bin/sh

app_dir=/opt/eam
if [[ ! -d $app_dir ]];then
  exit 1
fi
demo_sql="/tmp/codeDb.sql"
app_conf="${app_dir}/bin/app.conf"
MYSQL=`cat $app_conf|grep MYSQL=|awk -F "=" '{print $2}'`
MYSQL_DUMP=`cat $app_conf|grep MYSQL_DUMP=|awk -F "=" '{print $2}'`
MYSQL=`cat $app_conf|grep MYSQL=|awk -F "=" '{print $2}'`
DB_NAME=`cat $app_conf|grep DB_NAME=|awk -F "=" '{print $2}'`
DB_USER=`cat $app_conf|grep DB_USER=|awk -F "=" '{print $2}'`
DB_HOST=`cat $app_conf|grep DB_HOST=|awk -F "=" '{print $2}'`
DB_PWD=`cat $app_conf|grep DB_PWD=|awk -F "=" '{print $2}'`
#create demo.sql
$MYSQL_DUMP -u$DB_USER -p$DB_PWD -h$DB_HOST eam  > $demo_sql
$MYSQL -u$DB_USER -p$DB_PWD -h$DB_HOST eam_demo < $demo_sql

#覆盖
upfile=/home/admin/app/update.tar.gz
if [[ -f "/home/admin/app/eam.jar" ]];then
  rm -rf "/home/admin/app/eam.jar"
fi
if [[ -f "/home/admin/app/update.tar.gz" ]];then
  rm -rf "/home/admin/app/update.tar.gz"
fi
cd /home/admin/app/
tar xvf package.tgz
mv eam.jar update.tar.gz

cd /opt/eam/update
if [[ -f $$upfile ]];then
  rm -rf $upfile
fi
cp $upfile .

cd /opt/eam/bin
sh updateApp.sh

cd /opt/eam
sh appRestart.sh

sh /mn/exportEAM.sh

#最新编译包
cd /opt/eam
rm -rf eam.tar.gz
echo "java -noverify -Dfile.encoding=UTF-8 -Dloader.path=./lib/ -jar app.jar --Dspring.config.location=./application.yml">startCommand.txt
rm -rf eam.tar.gz
sed 's/Oracle/Eam/g' application.yml >application_copy.yml
tar zcvf eam.tar.gz startCommand.txt app.jar application_copy.yml ./lib/*
if [[ -f /opt/tomcat/tomcat_shopprod/webapps/upload/eam.tar.gz ]];then
  rm -rf /opt/tomcat/tomcat_shopprod/webapps/upload/eam.tar.gz
fi
cp eam.tar.gz /opt/tomcat/tomcat_shopprod/webapps/upload/
exit 0



