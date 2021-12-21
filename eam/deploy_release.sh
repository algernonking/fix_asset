#!/bin.sh
#
jar_dir="/Users/lank/IdeaProjectsnew/eam/eam/wrapper/wrapper-all/target"
deploy_dir="/Users/lank/IdeaProjectsnew/eam/eam/deploy"
release_dir="/tmp/eam_deploy"

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










