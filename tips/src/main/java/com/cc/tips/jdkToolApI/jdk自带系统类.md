## JDK自带系统类  
一、System类(系统类)    
终止虚拟机运行：System.exit(int status);  
获取环境变量： System.getenv(); linux的系统变量在/etc/profile或/etc/environment  
获取虚拟机的环境变量： System.getProperties(); 可以使用System.setProperty()设置虚拟机环境变量  
----------------------------------------------  
二、Runtime类(运行类)  
System内部调用的还是Runtime得方法  
Runtime runtime = Runtime.getRuntime();  
runtime.freeMemory();//剩余内存
runtime.totalMemory();//总内存
runtime.maxMemory();//最大内存  
--------------------------------------------------
