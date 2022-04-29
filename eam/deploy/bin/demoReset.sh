#!/bin/sh
#crontab
#	3 3 * * * sh /opt/script/eamDemoRestart.sh
#############################################
v=1.0.9
port=26788
####停止
docker stop eamapp;
docker rm eamapp;
docker run --name eamapp -it \
    -e MYSQL_ROOT_PASSWORD="root_pwd" \
    -v /demo/mysql:/var/lib/mysql  \
    -p 33306:3306 \
    -p 26788:8089 \
    -d docker.io/algernonking/eamapp:$v \
    --character-set-server=utf8
exit 0