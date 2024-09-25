pluginManagement {
    repositories {
        maven {
            isAllowInsecureProtocol = true//未使用https需要添加
            url = uri("http://192.168.2.192/nexus/repository/sf_develop_group/")//仓库地址
            credentials {//授权
                username ="sf_user"
                password ="sFkJ_Nexus3.com"
            }
        }
    }
}
rootProject.name = "redis"

