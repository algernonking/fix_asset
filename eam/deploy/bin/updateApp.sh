#!/bin/sh
#####################################################################
# Script Help:
#     sh updateEAM.sh
#         include:backup application jar
#         include(chose):database
#
#####################################################################

####################### Configure ###################################

cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
app_dir="${cur_dir}/.."
update_filename="update.tar"
MYSQL=`cat $app_conf|grep MYSQL=|awk -F "=" '{print $2}'`
MYSQL_DUMP=`cat $app_conf|grep MYSQL_DUMP=|awk -F "=" '{print $2}'`
MYSQL=`cat $app_conf|grep MYSQL=|awk -F "=" '{print $2}'`
DB_NAME=`cat $app_conf|grep DB_NAME=|awk -F "=" '{print $2}'`
DB_USER=`cat $app_conf|grep DB_USER=|awk -F "=" '{print $2}'`
DB_HOST=`cat $app_conf|grep DB_HOST=|awk -F "=" '{print $2}'`
DB_PWD=`cat $app_conf|grep DB_PWD=|awk -F "=" '{print $2}'`
####################### App Environment ############################
if [[ ! -d $app_dir ]];then
  echo "App_dir:$app_dir not exist"
  exit 1;
fi

cDir="$app_dir/data
$app_dir/logs
$app_dir/tmp
$app_dir/update
$app_dir/update/update
$app_dir/backup/dbdata
$app_dir/upload
$app_dir/upload/tpl/T001
"
for cdir in $cDir
do
  if [[ ! -d "$cdir" ]];then
     mkdir -p "$cdir"
  fi
done


if [[ ! -f "update/$update_filename" ]];then
  echo "Start to update application Failed,$update_filename not exist!";
  exit 1;
fi

##start to backup
cd $app_dir
sh backupAppDB.sh

echo "Start to backup application!"
curTime=`date +"%Y%m%d%H%M%S"`
tar zcvf eam_backup_${curTime}.tar.gz ./lib/* ./*.jar ./application.yml
if [[ ! -f "eam_backup_${curTime}.tar.gz" ]];then
  echo "Backup Application Failed!";
  exit 1;
fi
mv eam_backup_${curTime}.tar.gz backup/


echo "Start to update application!"
cd update
rm -rf update
mkdir update
mv $update_filename update
cd update
tar xvf $update_filename

#libs jars
echo "start to copy lib"
rm -rf $app_dir/lib/*
cp lib/* $app_dir/lib/

#eam.jar
eamJAR="eam.jar"
if [[ -f $eamJAR ]];then
  echo "start to copy $eamJAR"
  rm -rf  $app_dir/$eamJAR
  cp $eamJAR $app_dir/
  chmod +x $app_dir/$eamJAR
fi

#application.yml
confFile="application.yml"
if [[ -f $confFile ]];then
  echo "start to copy $confFile"
  rm -rf  $app_dir/$confFile
  cp $confFile $app_dir/
  chmod +x $app_dir/$confFile
fi

#eam.sh
eamActionScript="app.sh"
if [[ -f $eamActionScript ]];then
  echo "start to copy $eamActionScript"
  rm -rf  $app_dir/bin/$eamActionScript
  cp $eamActionScript $app_dir/bin/
  chmod +x $app_dir/bin/$eamActionScript
fi

#eamUpdate.sh
updateFileScript="updateApp.sh"
if [[ -f $updateFileScript ]];then
    echo "start to copy $updateFileScript"
  rm -rf  $app_dir/bin/$updateFileScript
  cp $updateFileScript $app_dir/bin/
  chmod +x $app_dir/bin/$updateFileScript
fi
echo "eam update success!"

sh $app_dir/bin/runSql.sh as

if [[ -f $app_dir/update/update/update.sql ]];then
  echo "update update.sql "
  sh $app_dir/bin/runSql.sh $app_dir/update/update/update.sql
fi

if [[ -f $ $app_dir/bin/sql/app_updateVersion.sql ]];then
  echo "update version"
  sh $app_dir/bin/runSql.sh $app_dir/bin/sql/app_updateVersion.sql
fi

exit 0
