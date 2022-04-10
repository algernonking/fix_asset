#!/bin/sh
#/bin/zsh -x  /Users/lank/IdeaProjectsnew/eam/eam/deploy.sh
#####################################################################
# Script Help:
#     sh deploy.sh full | incr
#
#####################################################################
####################### Configure  ##################################
JAVA=java
hostname=`hostname`
cur_dir=$(cd `dirname $0`; pwd)
conf_file=$cur_dir/app.conf
echo "cur_dir:$cur_dir";
echo "conf_file:$conf_file";

app_tar="app.tar"
hostname=`hostname`
cur_dir=$(cd `dirname $0`; pwd)
conf_file=$cur_dir/app.conf
jar_dir=`cat $conf_file|grep ${hostname}.jar_dir|awk -F "=" '{print $2}'`
ops_jar_dir=`cat $conf_file|grep ${hostname}.ops_jar_dir|awk -F "=" '{print $2}'`

echo "jar_dir:$jar_dir"
echo "cur_dir:$cur_dir";
echo "conf_file:$conf_file";

cd $jar_dir
if [[ -f app.jar ]];then
  rm -rf app.jar
fi

cp wrapper-all-0.0.2.RELEASE.jar app.jar

####################### Check #######################################
#default full
type=incr
full_content="./lib/* ./app.jar"
incr_content="./lib/service*.jar  ./lib/view*.jar ./lib/*nic*.jar"
content=$full_content

###生成远程执行文件
tmp_dir=`cat $conf_file|grep ${hostname}.ops_dir|awk -F "=" '{print $2}'`
ops_remotefile_recreate=1
ops_remotefile_recreate_file="$tmp_dir/deploy_app.sh"
ops_node_file_recreate=0
ops_node_file="$tmp_dir/ops.node"

if [[ -n $1 ]];then
	type=$1
fi

if [[ $type == "full" ]];then
	content=$full_content
else
	content=$incr_content
fi

if [[ ! -d $tmp_dir ]];then
	mkdir -p $tmp_dir
fi

if [[ ! -d $jar_dir ]];then
	echo "can't find $jar_dir"
	exit 1
fi
####################### Tar Tars ####################################
cd $jar_dir
if [[ -f $app_tar ]];then
	rm -rf $app_tar
fi
if [[ -f $tmp_dir/$app_tar ]];then
	rm -rf $tmp_dir/$app_tar
fi
echo "tar zcvf $app_tar $content"
tar zcvf $app_tar $content
mv $app_tar $tmp_dir
####################### Create Remote Runnning Script ###############
if [[ $ops_remotefile_recreate -eq 1 ]];then
	echo "">$ops_remotefile_recreate_file
	echo "UPLOAD sf=$tmp_dir/$app_tar         @@ dd=/tmp @@ df=app.tar"        >>$ops_remotefile_recreate_file
	echo "UPLOAD sf=$tmp_dir/deploy_eam.sh    @@ dd=/tmp @@ df=deploy_eam.sh"  >>$ops_remotefile_recreate_file
	echo "cd /tmp/"                           >>$ops_remotefile_recreate_file
	echo "sh deploy_eam.sh "                  >>$ops_remotefile_recreate_file
	echo "exit 0"												      >>$ops_remotefile_recreate_file
fi
####################### Create Base Node File ###############
if [[ $ops_node_file_recreate -eq 1 ]];then
	echo "39.105.191.22|22|root|123456|hostname=ops">$ops_node_file
fi
####################### Deploy ######################################
ops=$ops_jar_dir/ops.jar
echo "##########"
echo "$JAVA  -jar $ops -e action -n $ops_node_file -c $ops_remotefile_recreate_file">>/tmp/ops.log
$JAVA  -jar $ops -e action -n $ops_node_file -c $ops_remotefile_recreate_file
exit 0
