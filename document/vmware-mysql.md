## Centos安装Mysql

### 1、创建mysql文件目录

```shell
cd /;
mkdir /app;
mkdir /app/mysql;
```

### 2、下载mysql tar包 并解压

```shell
cd /app/mysql;
wget https://downloads.mysql.com/archives/get/p/23/file/mysql-8.0.30-el7-x86_64.tar

#拆分tar包
tar -xvf mysql-8.0.30-el7-x86_64.tar
#解压tar
tar -zxvf mysql-8.0.30-el7-x86_64.tar.gz
#修改文件夹名称
mv mysql-8.0.30-el7-x86_64.tar.gz mysql
```

### 4、开始

```shell
#创建data文件夹
mkdir /app/mysql/mysql/data
mkdir /app/mysql/mysql/log
touch /app/mysql/mysql/log/mysqld.log
#设置用户组
groupadd mysql
#创建用户
useradd -r -g mysql mysql
#修改目录及其内容的所有者为mysql 
chmod -R mysql /app/mysql/mysql
#初始化mysql
sh /app/mysql/mysql/bin/mysqld --initialize --user=mysql --datadir=/app/mysql/mysql/data --basedir=/app/mysql/mysql
注:此处会给出默认密码
#修改my.cnf
vim /etc/my.cnf

--------------------
[client]
socket=/tmp/mysql.sock
[mysqld]
#datadir=/var/lib/mysql
#socket=/var/lib/mysql/mysql.sock
datadir=/app/mysql/mysql/data #数据库data存放位置
basedir=/app/mysql/mysql #mysql安装位置
socket=/tmp/mysql.sock  #mysql sock文件
bind-address=0.0.0.0 #外部需要访问时需要配置，如navicat
port=3306
default_authentication_plugin=mysql_native_password

# Disabling symbolic-links is recommended to prevent assorted security risks
symbolic-links=0
# Settings user and group are ignored when systemd is used.
# If you need to run mysqld under a different user or group,
# customize your systemd unit file for mariadb according to the
# instructions in http://fedoraproject.org/wiki/Systemd

[mysqld_safe]
log-error=/app/mysql/mysql/log/mysqld.log #mysql log文件
pid-file=/var/run/mysqld/mysqld.pid #mysql pid文件

#
# include all files from the config directory
#
!includedir /etc/my.cnf.d
----------------------------------

#链接mysql
ln -s /app/mysql/mysql/bin/mysql /usr/local/bin/mysql
#登录mysql
mysql -uroot -p
#mysql默认用户是本地连接需要开启外部连接
DROP USER 'root'@'%';
CREATE USER 'root'@'%' IDENTIFIED BY 'NewPassword';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
#如果开启了防火墙需要开放端口（此步如navicat等外部连接需要连接是就需要）
## 查看开放的端口
firewall-cmd --list-ports
## 将3306开放 --permanent代表永久生效
firewall-cmd --zone=public --add-port=3306/tcp --permanent
## 重新加载防火墙
firewall-cmd --reload

#启动mysql
systemctl start mysql.service | systemctl start mysqld
#停止mysql
systemctl stop mysql.service | systemctl stop mysqld
#mysql服务自启动
systemctl enable mysql.service


```

### 特殊问题

如果提示pid不存在则可以手动创建:

```shell
mkdir -p /var/run/mysqld
chown mysql:mysql /var/run/mysqld
touch /var/run/mysqld/mysqld.pid
chown mysql:mysql /var/run/mysqld/mysqld.pid
```