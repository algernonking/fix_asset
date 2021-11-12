#!/bin/sh
#####################################################################
# Script Help:
#     sh updateEAM.sh
#
#####################################################################
####################### Configure ###################################
update_filename="update.tar"
app_dir=/opt/eam

####################### App Environment ############################
if [[ ! -d $app_dir ]];then
  echo "App_dir:$app_dir not exist"
  exit 1;
fi

if [[ ! -d "$app_dir/data" ]];then
  mkdir -p "$app_dir/data"
fi

if [[ ! -d "$app_dir/log" ]];then
  mkdir -p "$app_dir/log"
fi

if [[ ! -d "$app_dir/sql" ]];then
  mkdir -p "$app_dir/sql"
fi

if [[ ! -d "$app_dir/update" ]];then
  mkdir -p "$app_dir/update"
fi

if [[ ! -d "$app_dir/upload" ]];then
  mkdir -p "$app_dir/upload/tpl/T001"
fi


if [[ ! -f "update/$update_filename" ]];then
  echo "Start to update application Failed,$update_filename not exist!";
  exit 1;
fi

##start to backup
cd $app_dir
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
eamActionScript="eam.sh"
if [[ -f $eamActionScript ]];then
  echo "start to copy $eamActionScript"
  rm -rf  $app_dir/$eamActionScript
  cp $eamActionScript $app_dir/
  chmod +x $app_dir/$eamActionScript
fi

#eamUpdate.sh
updateFileScript="updateEAM.sh"
if [[ -f $updateFileScript ]];then
    echo "start to copy $updateFileScript"
  rm -rf  $app_dir/$updateFileScript
  cp $updateFileScript $app_dir/
  chmod +x $app_dir/$updateFileScript
fi
echo "eam update success!"
exit 0


