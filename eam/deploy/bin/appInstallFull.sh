#!/bin/sh
# modify at 20220610
#sh appInstallFull.sh 1.0.12
# test on RedHat 7.9 ,need to yum source before
#	mysql_soft:/tmp/mysql5.7.tar.gz
#	java_soft:/tmp/jdk-8u333-linux-x64.tar.gz
#	app_soft:/tmp/app.tar.gz
#######################################################
####################################  config
## soft
app_version="last"
if [[ -n $1 ]];then
	app_version=$1
fi
soft_base_dir=/tmp
java_soft=$soft_base_dir/jdk-8u333-linux-x64.tar.gz
mysql_soft=$soft_base_dir/mysql-5.7.37-linux-glibc2.12-x86_64.tar.gz
app_soft_name=app_release_${app_version}.tar.gz
app_soft=$soft_base_dir/app_release_${app_version}.tar.gz

java_soft_md5=913c45332b22860b096217d9952c2ea4
mysql_soft_md5=423915249cc67bbfa75223d9753cde77

## directory
java_dir="/app/java"
app_dir="/app/app"
mysql_dir="/app/db"

############################################
db_port=3306
app_port=8089
JAVA_HOME=$java_dir/jdk1.8.0_333
JAVA=$JAVA_HOME/bin/java

MYSQL_HOME=$mysql_dir/mysql
MYSQL=$mysql_dir/mysql/bin/mysql
MYSQL_ROOT_PWD="root_pwd"
#################################### verify command,netstat
yum -y install unzip telnet net-tools wget
yum -y install glibc-*
yum -y install numactl
cd $soft_base_dir


echo "start to verify command"
which netstat>/dev/null
netstatRes=$?
if [[ $netstatRes -ne 0 ]];then
	echo "ninstall check error,netstat command not exist,please install it first!"
	exit 1
fi

#####check port 3306,8089
db_port_cnt=`netstat -ant|grep LISTEN|grep ":$db_port"|wc -l`
if [[ $db_port_cnt -ne 0 ]];then
	echo "install check error,db_port:$db_port exist"
	exit 1
fi

app_port_cnt=`netstat -ant|grep LISTEN|grep ":$app_port"|wc -l`
if [[ $app_port_cnt -ne 0 ]];then
	echo "install check error,app_port:$app_port exist"
	exit 1
fi

#################################### Install Function
function verifySoft(){
	if [[ -f $1 ]];then
		return 0
	else
		return 1
	fi
}
function clearTips(){
	echo "########################clear Tips########################"
	echo "if you want to reinstall full app,please run below commands"
	echo "rm -rf $java_dir"
	echo "rm -rf $mysql_dir"
	echo "rm -rf $app_dir"
	echo "ps -ef|grep java |grep -v grep |awk '{print \$2}'|xargs kill -9"
  echo "ps -ef|grep mysql |grep -v grep |awk '{print \$2}'|xargs kill -9"
}

function installJava(){
	echo "#############install java start#############"
	if [[ ! -d $java_dir ]];then
		echo "command:mkdir -p $java_dir"
		mkdir -p $java_dir
	fi
	verifySoft $java_soft
	java_soft_VR=$?
	if [[ $java_soft_VR -eq 1 ]];then
		echo "install error,java_soft:$java_soft not exist";
		clearTips
		echo "failed">$java_dir/result.txt
		echo "#############install java failed#############"
		exit 1
	fi
	cd $java_dir
	cp $java_soft .
	echo "start to tar $java_soft"
	tar xvf $java_soft >/dev/null
	echo "success">$java_dir/result.txt
	echo "#############install java success#############"
	echo ""
	echo ""
}

function installMysql(){
	echo "#############install mysql start#############"
	if [[ ! -d $mysql_dir ]];then
		echo "command:mkdir -p $mysql_dir"
		mkdir -p $mysql_dir
	fi
	verifySoft $mysql_soft
	mysql_soft_VR=$?
	if [[ $mysql_soft_VR -eq 1 ]];then
		echo "install error,mysql_soft:$mysql_soft not exist";
		echo "#############install mysql failed#############"
		clearTips
		exit 1
	fi

	glibcnt=`strings /lib64/libc.so.6|grep GLIBC|grep 2.12|wc -l`
	if [[ $glibcnt -eq 0 ]];then
		echo "GLIBC 2.12 Match Failed"
		clearTips
		exit 1
	fi

	if [[ -d "${mysql_dir}/mysql/data" ]];then
		echo "${mysql_dir}/mysql/data Exists Deploy Failed,Please remove it first!"
		clearTips
		exit 1
	fi

	groupadd mysql
	useradd -r -g mysql mysql
	mkdir -p ${mysql_dir}/mysql/data
	#chown -R mysql:mysql /usr/local/mysql
	if [[ -f "/etc/my.cnf" ]];then
		d=`date "+%Y_%m_%d_%H_%M_%S"`
		mv /etc/my.cnf /etc/my.cnf.$d
	fi
	mycnftmp="/tmp/my.cnf.tmp"
	cat > $mycnftmp <<EOF
[mysqld]
lower_case_table_names = 1
max_allowed_packet = 100M
basedir=/usr/local/mysql
datadir=/usr/local/mysql/data
pid-file=/usr/local/mysql/mysqld.pid
socket=/usr/local/mysql/mysql.sock
log-error=/usr/local/mysql/mysqld.log
lc-messages=en_US
lc-messages-dir=/usr/local/mysql/share
symbolic-links=0
port=3306
sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION'
[client]
default-character-set=utf8
[mysql]
default-character-set=utf8
[mysqld]
log-bin=mysql-bin
binlog-format=ROW
server_id=1
max_connections=1000
#init_connect='set collation_connection = utf8_unicode_ci'
init_connect='set names utf8'
character-set-server=utf8
#collation-server=utf8_unicode_ci
skip-character-set-client-handshake
EOF
	smysqldir="/usr/local"
	cat $mycnftmp |sed "s:${smysqldir}:${mysql_dir}:g">/etc/my.cnf
	cp $mysql_soft ${mysql_dir}/mysql
	cd $mysql_dir/mysql
	tar xvf $mysql_soft
	onedir=`ls -rtl |tail -1 |awk '{print $NF}'`
	mv $onedir/* .
	chown -R mysql:mysql $mysql_dir/mysql
	rm -rf /tmp/mysql.sock
	ln -s $mysql_dir/mysql/mysql.sock /tmp/mysql.sock
	$mysql_dir/mysql/bin/mysqld --initialize-insecure --user=mysql --basedir=$mysql_dir/mysql--datadir=$mysql_dir/mysql/data
	echo "start mysql command list:"
	echo "nohup $mysql_dir/mysql/bin/mysqld_safe &"
	su - mysql -c "nohup $mysql_dir/mysql/bin/mysqld_safe &"
	sleep 10
	echo "use mysql;">init.sql
	echo "update mysql.user set authentication_string=password('$MYSQL_ROOT_PWD') where user='root' and Host = 'localhost';">>init.sql
	echo "grant all privileges on *.* to 'root'@'%' identified by '$MYSQL_ROOT_PWD'  WITH GRANT OPTION; ">>init.sql
	echo "flush privileges;">>init.sql
	$mysql_dir/mysql/bin/mysql -uroot <init.sql
	rm -rf init.sql
	chmod +x /etc/rc.d/rc.local
	chown mysql:mysql /etc/my.cnf
	sed -i '/mysql/d' /etc/rc.d/rc.local
	echo "su - mysql -c \"nohup $mysql_dir/mysql/bin/mysqld_safe &\"">> /etc/rc.d/rc.local
	chmod +x /etc/rc.d/rc.local
	cat /etc/rc.d/rc.local
	chown -R mysql:mysql $mysql_dir
	echo "#############install mysql success#############"
	echo ""
	echo ""
}

function installApp(){
	echo "#############install app start#############"
	if [[ ! -d $app_dir ]];then
		echo "command:mkdir -p $app_dir"
		mkdir -p $app_dir
	fi
	verifySoft $app_soft
	app_soft_VR=$?
	if [[ $app_soft_VR -eq 1 ]];then
		echo "install error,app_soft:$app_soft not exist";
		echo "#############install app failed#############"
		clearTips
		exit 1
	fi
	cd $app_dir
	cp $app_soft .
	tar xvf $app_soft
	cd $app_dir/bin/sql
	tar xvf db.tar.gz
	appConf=$app_dir/bin/app.conf
	echo "">$appConf
	echo "JAVA=java"                                    >>$appConf
	echo "APP_UID=app"                                  >>$appConf
	echo "APP_NAME=app.jar"                             >>$appConf
	echo "APP_DIR=$app_dir"                             >>$appConf
	echo "BACKUP_DIR=$app_dir/backup"                   >>$appConf
	echo "APP_WEB_PORT=8089"                            >>$appConf
	echo "DATA_CLEAR=1"                                 >>$appConf
	echo "MYSQL=$mysql_dir/mysql/bin/mysql"             >>$appConf
	echo "MYSQL_DUMP=$mysql_dir/mysql/bin/mysqldump"    >>$appConf
	echo "MYSQL_ADMIN=$mysql_dir/mysql/bin/mysqladmin"  >>$appConf
	echo "DB_HOST=127.0.0.1"                            >>$appConf
	echo "DB_PORT=3306"                                 >>$appConf
	echo "DB_NAME=eam"                                  >>$appConf
	echo "DB_USER=root"                                 >>$appConf
	echo "DB_PWD=$MYSQL_ROOT_PWD"                       >>$appConf

	db_create_db_file=$app_dir/bin/sql/createdb.sql
	db_sql_file=$app_dir/bin/sql/db.sql
	db_procedure_file=$app_dir/bin/sql/nextVal.sql
	db_clear_data_file=$app_dir/bin/sql/cleardata.sql
	application_tpl_yml=$app_dir/application_tpl.yml
	application_yml=$app_dir/application.yml

	if [[ ! -f "$db_sql_file" ]];then
	  echo "Error|db sql file:$db_sql_file not exist"
	  echo "deploy failed!"
	  exit 1
	fi

	if [[ ! -f "$db_procedure_file" ]];then
	  echo "Error|db procedure file:$db_procedure_file not exist"
	  echo "deploy failed!"
	  exit 1
	fi
	app_port=8089
	app_upload_dir=$app_dir/upload
	db_host=127.0.0.1
	db_port=3306
	db_name=eam
	db_user=root
	db_pwd=$MYSQL_ROOT_PWD

	MYSQL_DUMP=$mysql_dir/mysql/bin/mysqldump
	MYSQL_ADMIN=$mysql_dir/mysql/bin/mysqladmin
	echo "#########start to create database"
	echo "CREATE DATABASE $db_name DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;" > $db_create_db_file
	db_cnt=`$MYSQL -u$db_user -p$db_pwd -e 'show databases;' 2>/dev/null|grep $db_name|wc -l `
	if [[ $db_cnt -gt 0 ]];then
	  echo "Error|db:$db_name exist!"
	  echo "deploy failed!"
	  exit 1
	fi

	$MYSQL -u$db_user -p$db_pwd -h$db_host  < $db_create_db_file  2>/dev/null
	tab_cnt=`$MYSQL -u$db_user -p$db_pwd $db_name -e 'show tables' 2>/dev/null |wc -l`
	echo "create database success,table count:$tab_cnt"

	echo "#########start to backup db"
	$MYSQL_DUMP -u$db_user -p$db_pwd -h$db_host $db_name  > /tmp/db.sql  2>/dev/null

	echo "#########start to load data"
	$MYSQL -u$db_user -p$db_pwd -h$db_host $db_name < $db_sql_file  2>/dev/null
	tab_cnt=`$MYSQL -u$db_user -p$db_pwd $db_name -e 'show tables' 2>/dev/null |wc -l`
	echo "load tables success,table count:$tab_cnt"

	echo "#########start to create procedure"
	$MYSQL -u$db_user -p$db_pwd -h$db_host $db_name < $db_procedure_file  2>/dev/null

	echo "#########start to clear data "
	$MYSQL -u$db_user -p$db_pwd -h$db_host $db_name < $db_clear_data_file  2>/dev/null

	echo "#########start to create application.yml from $application_tpl_yml"
	cat $application_tpl_yml>$application_yml
	sed -i "s@APP_UPLOAD_DIR@$app_upload_dir@g"     $application_yml
	sed -i "s/APP_WEB_PORT/$app_port/g"             $application_yml
	sed -i "s/APP_DB_PORT/$db_port/g"               $application_yml
	sed -i "s/APP_DB_NAME/$db_name/g"               $application_yml
	sed -i "s/APP_DB_USERNAME/$db_user/g"           $application_yml
	sed -i "s/APP_DB_PASSWORD/$db_pwd/g"            $application_yml
	echo "#############install app success#############"
}

function stopFirewalld(){
  btcnt=`ps -ef|grep python|grep BT|grep -v grep|wc -l`
 if [[ $btcnt -gt 0 ]];then
    echo "firewalld don't stop it"
    return 1
  fi
  systemctl disable firewalld.service;systemctl stop firewalld.service
}


####################### Main Run ##########################
cd $soft_base_dir
# java_soft_md5=913c45332b22860b096217d9952c2ea4
# mysql_soft_md5=423915249cc67bbfa75223d9753cde77
mysql_download=1
if [[ -f $mysql_soft ]];then
	md5=`md5sum $mysql_soft|awk '{print $1}'`
	echo "mysql md5:$md5"
	if [[ $md5 == $mysql_soft_md5 ]];then
		mysql_download=0
		echo "mysql_soft is checked."
	fi
fi
if [[ $mysql_download -eq 1 ]];then
	echo "start to download mysql"
	wget https://cdn.mysql.com/archives/mysql-5.7/mysql-5.7.37-linux-glibc2.12-x86_64.tar.gz
fi


java_download=1
if [[ -f $java_soft ]];then
	md5=`md5sum $java_soft|awk '{print $1}'`
	echo "java md5:$md5"
	if [[ $md5 == $java_soft_md5 ]];then
		java_download=0
		echo "java_soft is checked."
	fi
fi
if [[ $java_download -eq 1 ]];then
	echo "start to download java"
	wget http://resource.rainbooow.com/jdk-8u333-linux-x64.tar.gz
fi

if [[ -f $app_soft ]];then
	 rm -rf $app_soft
fi

echo "start to download app"
wget http://resource.rainbooow.com/$app_soft_name

verifySoft $app_soft
app_soft_VR=$?
if [[ $app_soft_VR -eq 1 ]];then
	echo "install error,app_soft:$app_soft not exist";
	clearTips
	exit 1
fi

verifySoft $mysql_soft
mysql_soft_VR=$?
if [[ $mysql_soft_VR -eq 1 ]];then
	echo "install error,mysql_soft:$mysql_soft not exist";
	clearTips
	exit 1
fi

verifySoft $java_soft
java_soft_VR=$?
if [[ $java_soft_VR -eq 1 ]];then
	echo "install error,java_soft:$java_soft not exist";
	clearTips
	exit 1
fi

## install java
installJava
which $JAVA>/dev/null
java_command=$?
if [[ $java_command -eq 1 ]];then
	echo "install error,java command:$JAVA not exist";
	clearTips
	exit 1
fi

## install mysql
installMysql
which $MYSQL>/dev/null
mysql_command=$?
if [[ $mysql_command -eq 1 ]];then
	echo "install error,mysql command:$MYSQL not exist";
	clearTips
	exit 1
fi
db_port_cnt=`netstat -ant|grep LISTEN|grep ":$db_port"|wc -l`
if [[ $db_port_cnt -eq 0 ]];then
	echo "install check error,db_port:$db_port not exist"
	clearTips
	exit 1
else
	echo "mysql install success,password:$MYSQL_ROOT_PWD"
fi
## install app
installApp

## stop Firewalld
stopFirewalld

cd $app_dir
sh appStart.sh
exit 0





