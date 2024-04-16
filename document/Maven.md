## 指令:  
全局配置文件:  
**setting.xml**
  
推包指令:  
**mvn deploy**  

下载依赖指令:  
**mvn install**  

打包指令:  
**mvn package**  

删除打包指令:  
**mvn clean**  

nexus配置:
````
注:    
1、此处id与pom.xml一样，通过这个找的  

2、repo优先级:  
本地仓库jar>global settings active profile> user settings active profile>pom profile>pom repo>user mirror>global mirror pom中的repo配置高于user/global settings中的mirror user/global settings中的activa profile高于pom中的repo global settgings中的active profile高于user settings中的active profile user settings active profile高于mirror(checked) 但是settings定位不同,它倾向于提供一些公共的附属信息,而不是个性化的构建信息.它会尽量融合到你的pom中.
````

setting.xml:  
 ````   
 <server>
        <id>sfkj-nexus</id>
        <username>sf_user</username>
        <password>3men.net</password>
 </server>
   <mirror>
      <id>sfkj-nexus</id>
      <mirrorOf>*</mirrorOf>
      <url>http://192.168.2.192:8081/repository/sf_develop_group/</url>
  </mirror>
````
    
pom.xml:  
````
    //推包
    <distributionManagement>
        <snapshotRepository>
        <id>sfkj-nexus</id>
        <url>http://192.168.2.192:8081/repository/sf_develop_snapshot/</url>
        </snapshotRepository>
        <repository>
        <id>sfkj-nexus</id>
        <url>http://192.168.2.192:8081/repository/sf_develop_host/</url>
        </repository>
    </distributionManagement>
    
    //nexus地址
    <repositories>
        <repository>
            <id>sfkj-nexus</id>
            <url>http://192.168.2.192:8081/repository/sf_develop_group/</url>
        </repository>
    </repositories>
    
    //插件下载防止去中央仓库下载
    <pluginRepositories>
        <pluginRepository>
            <id>sfkj-nexus</id>
            <url>http://192.168.2.192:8081/repository/sf_develop_group/</url>
        </pluginRepository>
    </pluginRepositories>
````