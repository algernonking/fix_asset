################  应用日常维护,启动停止服务 ################
#启动应用服务
sh appStart.sh

#停止EAM服务
sh appStop.sh

#重启EAM服务
sh appRestart.sh


################ 应用更新 ###############################
#前置条件 update/appUpdate.tar存在
sh bin/updateApp.sh

#应用版本号更新(非必须)
sh bin/runSql.sh bin/sql/app_updateVersion.sql














