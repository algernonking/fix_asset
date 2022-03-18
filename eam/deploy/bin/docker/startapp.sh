#!/bin/sh
logfile="/tmp/app.log"
id>>$logfile
jdktar="jdk8.tar.gz"
cd /tmp
if [ -f "$jdktar" ];then
    echo "process jdk tar">>$logfile
    if [ -d "/opt/java" ];then
        echo "/opt/java exist">>$logfile
    else
         mkdir -p /opt/java
    fi
    cd /opt/java
    cp /tmp/$jdktar .
    tar xvf $jdktar
    rm -rf /opt/java/$jdktar
    cd /tmp
    rm -rf $jdktar
    echo "process jdk tar success">>$logfile
fi

apptar="eam_release.tar.gz"

cd /tmp
if [ -f "$apptar" ];then
    echo "process app tar">>$logfile
    if [ -d "/opt/eam" ];then
        echo "/opt/eam exist">>$logfile
    else
         mkdir -p /opt/eam
    fi
    mkdir -p /opt/eam
    if [ -d "/opt/eam" ];then
      echo "mkdir /opt/eam success">>$logfile
    else
      echo "mkdir /opt/eam failed">>$logfile
    fi
    cd /opt/eam
    cp /tmp/$apptar .
    if [ ! -f /opt/eam/eam.jar ];then
        tar xvf $apptar
    fi
    cd /tmp
    #rm -rf $apptar
    echo "process app tar success">>$logfile
fi

echo "process app start">>$logfile
cd /opt/eam
if [ -f "application_docker.yml" ];then
  rm -rf application.yml
  mv application_docker.yml application.yml
fi
datetime=`date "+%Y-%m-%d %H:%M:%S"`
echo "start to app,time:$datetime">>$logfile
nohup /opt/java/bin/java -Dloader.path=./lib/ -jar eam.jar --Dspring.config.location=application.yml 2>&1 &
exit 0
