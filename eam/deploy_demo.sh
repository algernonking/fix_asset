#!/bin/sh

hostname=`hostname`
cur_dir=$(cd `dirname $0`; pwd)
conf_file=$cur_dir/app.conf
echo "cur_dir:$cur_dir";
echo "conf_file:$conf_file";
ops_dir=`cat $conf_file|grep ${hostname}.ops_dir|awk -F "=" '{print $2}'`
rm -rf $ops_dir/deploy_app.sh
cp deploy_app.sh $ops_dir
sh deploy.sh full
exit 0