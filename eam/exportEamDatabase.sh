#!/bin/sh
#downloadUrl:
#     http://assets.rainbooow.com/upload/sql.tar.gz
today=`date +%Y%m%d`
sqldata=/tmp/eam_db_${today}.sql
mysql_pwd=`cat /opt/password.txt|tail -1`
/usr/bin/mysqldump -uroot -p$mysql_pwd -h127.0.0.1 eam  > $sqldata
if [[ -f $sqldata ]];then
  cd /tmp
  tar zcvf sql.tar.gz $sqldata
  rm -rf $sqldata
  rm -rf /opt/tomcat/tomcat_shopprod/webapps/upload/sql.tar.gz
  cp sql.tar.gz /opt/tomcat/tomcat_shopprod/webapps/upload
fi
exit 0

