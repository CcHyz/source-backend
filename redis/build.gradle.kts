plugins {
    id("java")
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "yh"
version = "1.0-SNAPSHOT"

repositories {
    maven {
        isAllowInsecureProtocol = true//未使用https需要添加
        url = uri("http://192.168.2.192/nexus/repository/sf_develop_group/")//仓库地址
        credentials {//授权
            username = "sf_user"
            password = "sFkJ_Nexus3.com"
        }

    }
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    implementation("cn.hutool:hutool-all:5.8.12")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.0")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:2.7.5")
    implementation ("org.springframework.boot:spring-boot-starter-data-redis:2.7.18")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}