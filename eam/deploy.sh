#!/bin/sh
#/bin/zsh -x  /Users/lank/IdeaProjectsnew/eam/eam/deploy.sh
#####################################################################
# Script Help:
#     sh deploy.sh full | incr
#
#####################################################################
####################### Configure  ##################################
JAVA=java

jar_dir="/Users/lank/IdeaProjectsnew/eam/eam/wrapper/wrapper-all/target"
app_tar="app.tar"

####################### Check #######################################
#default full
type=incr
full_content="./lib/* ./*.jar"
incr_content="./lib/service*.jar  ./lib/view*.jar ./lib/*nic*.jar"
content=$full_content

###生成远程执行文件
tmp_dir="/Users/lank/tmp"
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
demo_sql=$tmp_dir/demo.sql
echo "use eam_demo;">$demo_sql
echo "source full.sql;">>$demo_sql
if [[ $ops_remotefile_recreate -eq 1 ]];then
	echo "">$ops_remotefile_recreate_file
	echo "UPLOAD sf=$tmp_dir/$app_tar  @@ dd=/tmp @@ df=app.tar"  >>$ops_remotefile_recreate_file
	echo "UPLOAD sf=$demo_sql          @@ dd=/tmp @@ df=demo.sql" >>$ops_remotefile_recreate_file
	echo "/usr/bin/mysqldump -uroot -proot_pwd -h127.0.0.1 eam>/tmp/full.sql"					>>$ops_remotefile_recreate_file
	echo "/usr/bin/mysql -uroot -proot_pwd -h127.0.0.1         <demo.sql"				    	>>$ops_remotefile_recreate_file
	echo "app_dir=/tmp/eam"										>>$ops_remotefile_recreate_file
	echo "mkdir -p \$app_dir"									>>$ops_remotefile_recreate_file
	echo "cd \$app_dir"		    								>>$ops_remotefile_recreate_file
	echo "rm -rf app.tar"										  >>$ops_remotefile_recreate_file
	echo "cp /tmp/app.tar ."                  >>$ops_remotefile_recreate_file
	if [[ $type == "full" ]];then
	    echo "rm -rf lib/*"                   >>$ops_remotefile_recreate_file
	fi
	echo "tar xvf app.tar"										>>$ops_remotefile_recreate_file
	echo "sleep 2"										        >>$ops_remotefile_recreate_file
	echo "cd \$app_dir"		    								>>$ops_remotefile_recreate_file
	echo "mkdir package                        ">>$ops_remotefile_recreate_file
  echo "rm -rf package/*                    ">>$ops_remotefile_recreate_file
	echo "cp wrapper-all-0.0.2.RELEASE.jar package/  ">>$ops_remotefile_recreate_file
	echo "cd package  ">>$ops_remotefile_recreate_file
	echo "unzip wrapper-all-0.0.2.RELEASE.jar BOOT-INF/classes/application.yml ">>$ops_remotefile_recreate_file
  echo "sed -i \"s/39.105.191.22:3306\/eam/127.0.0.1:3306\/eam_demo/g\" BOOT-INF/classes/application.yml ">>$ops_remotefile_recreate_file
  echo "zip -u wrapper-all-0.0.2.RELEASE.jar  BOOT-INF/classes/application.yml ">>$ops_remotefile_recreate_file
  echo "cd .. ">>$ops_remotefile_recreate_file
  echo "rm -rf app.jar ">>$ops_remotefile_recreate_file
  echo "mv package/wrapper-all-0.0.2.RELEASE.jar app.jar ">>$ops_remotefile_recreate_file
	echo "nohup sh run.sh restart &"					>>$ops_remotefile_recreate_file
	echo "exit 0"												      >>$ops_remotefile_recreate_file
fi

####################### Create Base Node File ###############
if [[ $ops_node_file_recreate -eq 1 ]];then
	echo "39.105.191.22|22|root|123456|hostname=ops">$ops_node_file
fi
####################### Deploy ######################################
ops=/Users/lank/IdeaProjectsnew/eam/eam/ops.jar
echo "$JAVA  -jar $ops -e action -n $ops_node_file -c $ops_remotefile_recreate_file">>/tmp/ops.log
$JAVA  -jar $ops -e action -n $ops_node_file -c $ops_remotefile_recreate_file
exit 0
