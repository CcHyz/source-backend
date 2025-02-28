## 1、&命令

```text
表示在后台运行  
例子：java -jar a.jar &
```

## Systemd

```text
Systemd 默认从以下目录加载服务文件：
/usr/lib/systemd/system/ （系统级服务）
/etc/systemd/system/ （用户自定义服务）

如果上述目录中没有.server则
systemctl start nginx.service 会提示
Unit nginx.service could not be found.
```