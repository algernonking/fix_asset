#!/bin/sh
logfile="/tmp/app.log"
jdktar="jdk8.tar.gz"
cd /tmp
if [ -f "$jdktar" ];then
    echo "process jdk tar">>$logfile
    mkdir -p /opt/java
    cd /opt/java
    cp /tmp/$jdktar .
    tar xvf $jdktar
    rm -rf /opt/java/$jdktar
    echo "process jdk tar success">>$logfile
fi

apptar="eam_release.tar.gz"
cd /tmp
if [ -f "$apptar" ];then
    echo "process app tar">>$logfile
    mkdir -p /opt/eam
    cd /opt/eam
    cp /tmp/$apptar .
    tar xvf $apptar
    echo "process app tar success">>$logfile
fi

echo "process app start">>$logfile
cd /opt/eam
if [ -f "application_docker.yml" ];then
  rm -rf application.yml
  mv application_docker.yml application.yml
fi
nohup /opt/java/bin/java -Dloader.path=./lib/ -jar eam.jar --Dspring.config.location=application.yml 2>&1 &
exit 0
