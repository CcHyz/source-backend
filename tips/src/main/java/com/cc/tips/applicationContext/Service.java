package com.cc.tips.applicationContext;

import com.cc.tips.transcation.TransactionalRepository;
import com.cc.tips.transcation.TransactionalTwoDto;
import com.cc.tips.transcation.TransactionalTwoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class Service {
    private final TransactionalTwoRepository transactionalTwoRepository;
    private final TransactionalRepository transactionalRepository;
    private final ApplicationContext applicationContext;


    @Transactional
    public void transactional() {
        transactionalTwoRepository.save(new TransactionalTwoDto(null, "a"));
        Integer a = null;
        if (a == 0) {

        }
    }

    public void call() {
        //未使用上下文获取，不会触发事务
        Service bean = applicationContext.getBean(Service.class);
        bean.transactional();
    }
}
