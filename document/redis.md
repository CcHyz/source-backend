## 一、redis安装使用

1、redis安装目录  
2、重启：  
redis-server redis.conf  
3、停止：  
redis-cli -shutdown

4、需修改redis.conf文件bind参数不然使用ip访问不上

## 二、Cli指令

| 指令             | 作用          | 备注                                                                       | 例子                   |
|----------------|-------------|--------------------------------------------------------------------------|----------------------|
| select [index] | 选中一个库       | Index为数据库下标，redis中数据库从0-15                                               | select 1             |
| flushall       | 清除所有库的数据    |                                                                          |                      |
| flushdb        | 清除某个库的数据    | 需要先使用select [index]选中对应的库                                                |                      |
| keys *         | 查看当前数据库中的所有 |                                                                          |                      |
| keys prefix:*  | 按前缀查看所有key  | prefix可以替换为对应的前缀，<br/>redis是通过前缀来生成文件夹形式的,<br/>如例子中使用:就会生成文件夹,test为文件夹名称 | keys test:*          |
| type key       | 查看key的类型    | key 可以替换为对应的key名                                                         | type test:111        |
| DEL key        | 删除key       | key 可以替换为对应的key名                                                         | DEL test:111或DEL 222 |

## 三、spring中使用redis

1、引入依赖
2、添加序列化