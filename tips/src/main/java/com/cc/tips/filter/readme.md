## implements Filter主要是用于web请求中，在请求到达目标接口前或者准备返回时的过滤，如权限不符合要求就可以在这做

三种实现方式:  
1、implements Filter后在该类上使用@Component 存在多个Filter使用@Order(12)进行排序  
2、implements Filter后在该类上使用@WebFilter 存在多个Filter使用@Order(12)进行排序  
3、implements Filter后,新建一个配置类在配置类上加@Configuration
然后注册@Bean就行，如类[AuthFilterConfig.java](AuthFilterConfig.java)
