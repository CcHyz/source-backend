package com.cc.tips.transcation;

import com.cc.tips.thread.threadLocal.ThreadLocalWarp;
import com.cc.tips.thread.threadLocal.User;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


@RestController(value = "/api/transcation")
public class TransactionalController {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final ScheduledExecutorService taskExecutor = Executors.newSingleThreadScheduledExecutor();
    private final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
    @Resource
    private TransactionalService transactionalService;
    @Resource
    private TransactionalRepository transactionalRepository;
    @Resource
    private ThreadLocalWarp threadLocalWarp;
    @Resource
    private EntityManager entityManager;

    @GetMapping("/save")
    public ResponseEntity save() {

        threadLocalWarp.set(new User("huo"));
        TransactionalDto transactionalDto = new TransactionalDto();
        transactionalDto.setName("test1");
        CompletableFuture.supplyAsync(() -> {
            transactionalService.saveT();
            return 1;
        }, taskExecutor).exceptionally((e) -> {
            return 0;
        });
        transactionalRepository.save(transactionalDto);//
//        executorService.submit(()->{
//            transactionalService.saveS();
//        });
        transactionalService.saveT();


        return ResponseEntity.ok().build();
    }

    @GetMapping("/saveAll")
    @Transactional
    public ResponseEntity saveAll() {
        for (int o = 0; o < 10; o++) {
            scheduledThreadPool.submit(() -> {
                List<TransactionalDto> transactionalDtos = new ArrayList<>();
                for (int i = 0; i < 10000; i++) {
                    TransactionalDto transactionalDto = new TransactionalDto();
                    transactionalDto.setName("test" + i);
                    transactionalDtos.add(transactionalDto);
                }
//                batchInsert(transactionalDtos);
                transactionalRepository.saveAllAndFlush(transactionalDtos);
            });
        }
        return ResponseEntity.ok().build();
    }

    @Transactional
    public <T> void batchInsert(List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                if (i % 500 == 0) {//100
                    System.out.println(list.size());
                    entityManager.flush();
                    entityManager.clear();
                }
                entityManager.persist(list.get(i));
            }

        }
    }
}
