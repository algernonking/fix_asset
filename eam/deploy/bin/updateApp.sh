#!/bin/sh
#####################################################################
# Script Help:
#     sh updateApp.sh
#         include:backup application jar
#         include(chose):database
#
#####################################################################
####################### Configure ###################################
cur_dir=$(cd `dirname $0`; pwd)
app_conf="${cur_dir}/app.conf"
app_dir="${cur_dir}/.."
update_filename="update.tar.gz"
MYSQL=`cat $app_conf|grep -v "#"|grep MYSQL=|awk -F "=" '{print $2}'`
MYSQL_DUMP=`cat $app_conf|grep -v "#"|grep MYSQL_DUMP=|awk -F "=" '{print $2}'`
MYSQL=`cat $app_conf|grep -v "#"|grep MYSQL=|awk -F "=" '{print $2}'`
DB_NAME=`cat $app_conf|grep -v "#"|grep DB_NAME=|awk -F "=" '{print $2}'`
DB_USER=`cat $app_conf|grep -v "#"|grep DB_USER=|awk -F "=" '{print $2}'`
DB_HOST=`cat $app_conf|grep -v "#"|grep DB_HOST=|awk -F "=" '{print $2}'`
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

if [[ ! -f "${app_dir}/update/$update_filename" ]];then
  echo "Start to update application Failed,$update_filename not exist!";
  exit 1;
fi

##start to backup
cd $app_dir
echo "start to backup app db."
sh backupAppDB.sh
echo "start to backup app."
sh backupApp.sh

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

#app.jar
appJAR="app.jar"
if [[ -f $appJAR ]];then
  echo "start to copy $appJAR"
  rm -rf  $app_dir/$appJAR
  cp $appJAR $app_dir/
  chmod +x $app_dir/$appJAR
fi

#application.yml
confFile="application.yml"
if [[ -f $confFile ]];then
  echo "start to copy $confFile"
  rm -rf  $app_dir/$confFile
  cp $confFile $app_dir/
  chmod +x $app_dir/$confFile
fi

#app.sh
appActionScript="app.sh"
if [[ -f $appActionScript ]];then
  echo "start to copy $appActionScript"
  rm -rf  $app_dir/bin/$appActionScript
  cp $appActionScript $app_dir/bin/
  chmod +x $app_dir/bin/$appActionScript
fi

#updateApp.sh
updateFileScript="updateApp.sh"
if [[ -f $updateFileScript ]];then
    echo "start to copy $updateFileScript"
  rm -rf  $app_dir/bin/$updateFileScript
  cp $updateFileScript $app_dir/bin/
  chmod +x $app_dir/bin/$updateFileScript
fi
echo "app update success!"


if [[ -f "$app_dir/update/update/update.sql" ]];then
  echo "update update.sql "
  sh $app_dir/bin/runSql.sh $app_dir/update/update/update.sql
  echo "execute $app_dir/update/update/update.sql success!"
fi

if [[ -f "$app_dir/bin/sql/app_updateVersion.sql" ]];then
  echo "update version"
  sh $app_dir/bin/runSql.sh $app_dir/bin/sql/app_updateVersion.sql
  echo "execute $app_dir/bin/sql/app_updateVersion.sql success!"
fi

exit 0
