#!/bin/sh
#############################################
v=1.0.9

###install app
docker stop eamapp_0001;
docker rm eamapp_0001;
docker run --name eamapp_0001 -it \
    -e MYSQL_ROOT_PASSWORD="root_pwd" \
    -v /data/mysql:/var/lib/mysql  \
    -p 13306:3306 \
    -p 8090:8089 \
    -d docker.io/algernonking/eamapp:$v \
    --character-set-server=utf8
exit 0



