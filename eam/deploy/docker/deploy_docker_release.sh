#!/bin/sh
#
curversion=1.0.7
appdockerfile="eamDockerFile"
if [ ! -f "eam.sql" ];then
    echo "eam.sql not exist"
    exit 1
fi

if [ ! -f "next.sql" ];then
    echo "next.sql not exist"
    exit 1
fi

if [ ! -f "eam_release.tar.gz" ];then
    echo "eam_release.tar.gz not exist"
    exit 1
fi

########################生成数据库dockerfile####################
echo "">appdockerfile
echo "FROM docker.io/algernonking/eamapp:base     ">>appdockerfile
echo "MAINTAINER lank                             ">>appdockerfile
echo "RUN chmod 777 /opt                          ">>appdockerfile
echo "RUN rm -rf /tmp/app.log                     ">>appdockerfile
echo "RUN rm -rf /tmp/eam.sql                     ">>appdockerfile
echo "RUN rm -rf /tmp/next.sql                    ">>appdockerfile
echo "RUN rm -rf /tmp/eam_release.tar.gz          ">>appdockerfile
echo "RUN rm -rf /usr/local/bin/startapp.sh       ">>appdockerfile
#echo "RUN rm -rf /usr/local/bin/docker-entrypoint.sh  ">>appdockerfile
echo "COPY eam.sql /tmp/                          ">>appdockerfile
echo "COPY next.sql /tmp/                         ">>appdockerfile
echo "COPY eam_release.tar.gz /tmp/               ">>appdockerfile
echo "COPY startapp.sh /usr/local/bin/            ">>appdockerfile
#echo "COPY docker-entrypoint.sh /usr/local/bin/   ">>appdockerfile
echo "RUN chmod +x /usr/local/bin/startapp.sh     ">>appdockerfile
echo "RUN chmod +x /usr/local/bin/docker-entrypoint.sh ">>appdockerfile
echo "EXPOSE 3306                                 ">>appdockerfile
echo "EXPOSE 8089                                 ">>appdockerfile
echo "CMD [ \"/usr/local/bin/startapp.sh\" ]      ">>appdockerfile
docker build -f appdockerfile  -t docker.io/algernonking/eamapp:$curversion .
#docker push docker.io/algernonking/eamapp:$curversion
exit 0

########################################################
docker run --name eamapp -t \
-e MYSQL_USER="eam" \
-e MYSQL_PASSWORD="eam_pwd" \
-e MYSQL_ROOT_PASSWORD="root_pwd" \
-v /d/mysql:/var/lib/mysql  \
-p 3307:3306 \
-p 8089:8089 \
-d docker.io/algernonking/eamapp:1.0.1 \
--character-set-server=utf8


docker run --user 0 --name eamapp -t \
    -e MYSQL_USER="eam" \
    -e MYSQL_PASSWORD="eam_pwd" \
    -e MYSQL_ROOT_PASSWORD="root_pwd" \
    -v /eam/mysql:/var/lib/mysql  \
    -v /eam/app:/opt \
    --privileged=true \
    -p 3307:3306 \
    -p 26788:8089 \
    -d docker.io/algernonking/eamapp:1.0.6 \
    --character-set-server=utf8

docker exec -it a82d30157be2 /bin/bash







