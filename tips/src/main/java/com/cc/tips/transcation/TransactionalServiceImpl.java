package com.cc.tips.transcation;

import com.cc.tips.thread.threadLocal.ThreadLocalWarp;
import com.cc.tips.thread.threadLocal.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionalServiceImpl implements TransactionalService {

    private final TransactionalTwoRepository transactionalTwoRepository;
    private final TransactionalRepository transactionalRepository;
    private final TransactionalTwoService transactionalTwoService;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    @Resource
    private ThreadLocalWarp threadLocalWarp;

    /**
     * .
     * <p>异常catch后是不会导致事物回滚,但是throw 出去后就会回滚</>
     */
    @Transactional
    @Override
    public void saveT() {
        User object = (User) threadLocalWarp.get();
        System.out.println("obj" + object);
        executorService.submit(() -> {
            User object1 = (User) threadLocalWarp.get();
            System.out.println("obj1" + object1);
            transactionalTwoService.saveTw();
            try {
                Integer a = null;
                if (a == 0) {
                    System.out.println("11111");
                }

                List<TransactionalDto> all = transactionalRepository.findAll();

                TransactionalTwoDto transactionalDto = new TransactionalTwoDto();
                transactionalDto.setCode("twoTest3");
                transactionalTwoRepository.save(transactionalDto);

                Long id = transactionalDto.getId();
            } catch (Exception throwable) {
                throw throwable;
            }
        });

    }

    @Override
    public void saveS() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transactionalTwoService.saveTw();

        List<TransactionalDto> all = transactionalRepository.findAll();

        TransactionalTwoDto transactionalDto = new TransactionalTwoDto();
        transactionalDto.setCode("twoTest5");
        transactionalTwoRepository.save(transactionalDto);

        Long id = transactionalDto.getId();
    }
}
