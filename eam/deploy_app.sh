#!/bin.sh
#
#
#
#
mysql_pwd=`cat /opt/password.txt|tail -1`
/usr/bin/mysqldump -uroot -p$mysql_pwd -h127.0.0.1 eam > /tmp/full.sql
/usr/bin/mysql -uroot -p$mysql_pwd -h127.0.0.1<demo.sql
app_dir=/tmp/eam
if [[ ! -d $app_dir ]];then
  mkdir -p $app_dir
  mkdir $app_dir/log
  mkidr $app_dir/data
  mkidr $app_dir/tmp
fi
if [[ ! -d $app_dir ]];then
  exit 1
fi
cd $app_dir
rm -rf app.tar
rm -rf lib/*
cp /tmp/app.tar .
tar xvf app.tar
sleep 2
mkdir package
rm -rf package/*
cp wrapper-all-0.0.2.RELEASE.jar package/
cd package
unzip wrapper-all-0.0.2.RELEASE.jar BOOT-INF/classes/application.yml
sed -i "s/39.105.191.22:3306\/eam/127.0.0.1:3306\/eam_demo/g" BOOT-INF/classes/application.yml
sed -i "s/39.105.191.22:3306\/eam/127.0.0.1:3306\/eam_demo/g" BOOT-INF/classes/application.yml
zip -u wrapper-all-0.0.2.RELEASE.jar  BOOT-INF/classes/application.yml
cd ..
rm -rf app.jar
mv package/wrapper-all-0.0.2.RELEASE.jar app.jar
nohup sh run.sh restart &
exit 0