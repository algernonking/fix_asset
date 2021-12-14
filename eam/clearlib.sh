#!/bin/sh

if [[ -d "/Users/lank/.m2/repository/com/github/foxnic" ]];then
  cd /Users/lank/.m2/repository/com/github/foxnic
  rm -rf *
fi

if [[ -d "/Users/lank/IdeaProjectsnew/eam/logs" ]];then
  cd /Users/lank/IdeaProjectsnew/eam/logs
  rm -rf *
fi

exit 0

