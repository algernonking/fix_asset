
################ EAM 日常维护,启动停止服务 ################
#启动EAM服务
sh eamStart.sh

#停止EAM服务
sh eamStop.sh

#重启EAM服务
sh eamRestart.sh

################ EAM 更新 ################
前置条件 update/eamUpdate.tar存在
sh bin/updateApp.sh


#更新EAM版本
sh bin/runSql.sh bin/sql/app_updateVersion.sql

#初始化EAM
sh bin/runSql.sh ./sql/init.sql













