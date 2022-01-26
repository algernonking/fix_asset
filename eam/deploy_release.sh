#!/bin.sh
#

release_dir="/tmp/eam_deploy"

hostname=`hostname`
cur_dir=$(cd `dirname $0`; pwd)
conf_file=$cur_dir/app.conf
jar_dir=`cat $conf_file|grep ${hostname}.jar_dir|awk -F "=" '{print $2}'`
deploy_dir=`cat $conf_file|grep ${hostname}.deploy_dir|awk -F "=" '{print $2}'`

if [[ -d $release_dir ]];then
  rm -rf $release_dir
fi
mkdir -p $release_dir



cd $release_dir
cp -r $deploy_dir/* .
cp -r $jar_dir/lib/* $release_dir/lib/
cp $jar_dir/wrapper-all-0.0.2.RELEASE.jar  $release_dir/eam.jar



tar -zcvf eam_release.tar.gz ./*
open .
exit 0










