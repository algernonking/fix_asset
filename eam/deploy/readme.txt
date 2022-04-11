

################  应用日常维护,启动停止服务 ################
#启动服务
sh appStart.sh

#停止服务
sh appStop.sh

#重启服务
sh appRestart.sh

#检查环境
sh bin/checkAppEnvironment.sh

#crontab -e
###APP CRONTAB
08 14 * * * sh /opt/eam/bin/clearData.sh
0 */1 * * * sh /opt/eam/bin/checkIfRestartApp.sh
12 12 * * * sh /opt/eam/bin/backupAppDB.sh eam

################ 应用更新 ###############################
#前置条件 update/appUpdate.tar存在
sh bin/updateApp.sh

#应用版本号更新(非必须)
sh bin/runSql.sh bin/sql/app_updateVersion.sql

################ 初始化 ###############################
#先编辑app.conf的数据库连接信息,数据库的初始化
sh bin/deployAppDB.sh eam


