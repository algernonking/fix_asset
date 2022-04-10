#!/bin.sh
hostname=`hostname`
cur_dir=$(cd `dirname $0`; pwd)
conf_file=$cur_dir/app.conf
jar_dir=`cat $conf_file|grep ${hostname}.jar_dir|awk -F "=" '{print $2}'`
deploy_dir=`cat $conf_file|grep ${hostname}.deploy_dir|awk -F "=" '{print $2}'`

echo "jar_dir:$jar_dir"
echo "deploy_dir:$deploy_dir"

release_dir="/tmp/app_deploy"
if [[ -d $release_dir ]];then
  rm -rf $release_dir
fi
mkdir -p $release_dir
cd $release_dir
mkdir lib
cp -r $jar_dir/lib/*  $release_dir/lib/
cp $jar_dir/wrapper-all-0.0.2.RELEASE.jar  $release_dir/app.jar
tar -zcvf update.tar.gz ./*
open .
exit 0













