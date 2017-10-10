#这不是一个shell文件

#把这个目录下的所有文件复制到MYSQL_HOME目录下

#修改my.cnf文件中有关路径的信息

#初始化数据库
bin/mysqld --defaults-file=/home/wayss/developmentEnv/mysql-5.7.19-linux-glibc2.12-x86_64/my.cnf --initialize-insecure

#启动MySQL数据库
bin/mysqld --defaults-file=/home/wayss/developmentEnv/mysql-5.7.19-linux-glibc2.12-x86_64/my.cnf &

#设置密码
bin/mysqladmin -uroot password '123456' --socket=./mysql.sock

#设置允许远程登录
bin/mysql -uroot -p123456 -e "grant all on *.*  to root@'%' identified by '123456';" --socket=./mysql.sock