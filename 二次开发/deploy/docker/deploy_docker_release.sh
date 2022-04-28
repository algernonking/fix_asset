#!/bin/sh
curversion=1.0.9
appdockerfile="eamDockerFile"
if [ ! -f "app.sql" ];then
    echo "app.sql not exist"
    exit 1
fi

if [ ! -f "app_release.tar.gz" ];then
    echo "app_release.tar.gz not exist"
    exit 1
fi

if [ ! -f "nextVal.sql" ];then
    echo "nextVal.sql not exist"
    exit 1
fi

########################生成数据库dockerfile####################
echo "">appdockerfile
echo "FROM docker.io/algernonking/eam_app_base:v1 ">>appdockerfile
echo "MAINTAINER lank                             ">>appdockerfile
echo "RUN chmod 777 /opt                          ">>appdockerfile
echo "RUN rm -rf /tmp/app.log                     ">>appdockerfile
echo "RUN rm -rf /tmp/app.sql                     ">>appdockerfile
echo "RUN rm -rf /tmp/nextVal.sql                 ">>appdockerfile
echo "RUN rm -rf /tmp/app_release.tar.gz          ">>appdockerfile
echo "COPY app.sql /tmp/                          ">>appdockerfile
echo "COPY nextVal.sql /tmp/                      ">>appdockerfile
echo "COPY app_release.tar.gz /tmp/               ">>appdockerfile
echo "RUN chmod +x /usr/local/bin/startapp.sh     ">>appdockerfile
echo "RUN chmod +x /usr/local/bin/docker-entrypoint.sh ">>appdockerfile
echo "EXPOSE 3306                                 ">>appdockerfile
echo "EXPOSE 8089                                 ">>appdockerfile
echo "CMD [ \"/usr/local/bin/startapp.sh\" ]      ">>appdockerfile
docker build -f appdockerfile  -t docker.io/algernonking/eamapp:$curversion .
echo "docker push docker.io/algernonking/eamapp:$curversion"
exit 0









