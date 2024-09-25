package redis;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import redis.config.RedisTemplateWrap;
import redis.modles.User;

import javax.annotation.Resource;

@Configuration
public class BeforeRun implements ApplicationRunner {

    @Resource
    private RedisTemplateWrap<String, Object> redisTemplateUser;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        redisTemplateUser.set("user",new User());
        User user = (User) redisTemplateUser.get("user");
        System.out.println(user);
    }
}
