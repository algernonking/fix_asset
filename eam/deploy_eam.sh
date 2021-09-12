#!/bin.sh
demo_sql="/tmp/demo.sql"
echo "use eam_demo;">$demo_sql
echo "source full.sql;">>$demo_sql
cd /tmp
mysql_pwd=`cat /opt/password.txt|tail -1`
/usr/bin/mysqldump -uroot -p$mysql_pwd -h127.0.0.1 eam  > $demo_sql
/usr/bin/mysql -uroot -p$mysql_pwd -h127.0.0.1 eam_demo < $demo_sql
app_dir=/tmp/eam
if [[ ! -d $app_dir ]];then
  mkdir -p $app_dir
  mkdir $app_dir/log
  mkidr $app_dir/data
  mkidr $app_dir/tmp
fi
if [[ ! -d $app_dir ]];then
  exit 1
fi
cd $app_dir
rm -rf app.tar
rm -rf lib/*
cp /tmp/app.tar .
tar xvf app.tar
sleep 2
mkdir package
rm -rf package/*
cp wrapper-all-0.0.2.RELEASE.jar package/
cd package
unzip wrapper-all-0.0.2.RELEASE.jar BOOT-INF/classes/application.yml
sleep 2
u1="a0WwT/76Vgi3kLk6HoY1zPYTublu7Nrfsfaw+3xe/NtQSPN/vG37pE0WeSGDP4mKHVNSz8z8CBtwpihb0Yuv2iOeWjorHS6Aszqc0Mvg1vvYPY9UXm2mFl1nF62HIksKwU7Sr1gASx/TMIpD6WhITqIMjF9il5QJJJrsWaul5CUxJKC43zAo0w5As8X1hKcFc5z408+y4rf5e617vboT2D34kRvuh7+VYQovLwf9Bshu/1ZfPf3Fdp/xzRnncfHr"
u2="a0WwT/76Vgi3kLk6HoY1zPYTublu7Nrfsfaw+3xe/NuSIDpBhoC4wBMuQ7DsGJc/ZFxardNYEjXZRNf9VGmxy6VzfkOzLPRJMv4cbXMD8m5RZtAt5flc/PfNB2ScolLZ9htpur58Y4AMzJD3ma0pJA8m9Mild+AG93Lnbn72yoA6SAENEhP27C0vXcDnMBzPLLNhgZSZ0mT8b92Yc3X0xqzKbPcXfg2XdJy84evH+qw04hjuX9RtsLEmjLX6QRHH"
sed -i "s@${u1}@${u2}@g"  BOOT-INF/classes/application.yml
sleep 2
zip -u wrapper-all-0.0.2.RELEASE.jar  BOOT-INF/classes/application.yml
cd ..
rm -rf app.jar
mv package/wrapper-all-0.0.2.RELEASE.jar app.jar
nohup sh run.sh restart &
exit 0