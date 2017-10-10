#/bin/bash

bin/mysqld --defaults-file=/home/wayss/developmentEnv/mysql-5.7.19-linux-glibc2.12-x86_64/my.cnf &

#初始化数据库
bin/mysqld --defaults-file=/home/wayss/developmentEnv/mysql-5.7.19-linux-glibc2.12-x86_64/my.cnf --initialize-insecure

#设置密码
bin/mysqladmin -uroot password '123456' --socket=./mysql.sock

#设置远程登录
bin/mysql -uroot -p123456 -e "grant all on *.*  to root@'%' identified by '123456';" --socket=./mysql.sock