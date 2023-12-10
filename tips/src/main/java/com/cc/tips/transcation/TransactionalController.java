package com.cc.tips.transcation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@RestController(value = "/api/transcation")
public class TransactionalController {

    @Resource
    private TransactionalService transactionalService;
    @Resource
    private TransactionalRepository transactionalRepository;

    private final ExecutorService executorService=Executors.newSingleThreadExecutor();

    @GetMapping("/save")
//    @Transactional
    public ResponseEntity save(){
        TransactionalDto transactionalDto=new TransactionalDto();
        transactionalDto.setName("test1");
        transactionalRepository.save(transactionalDto);//
        executorService.submit(()->{
            transactionalService.saveS();
        });

       transactionalService.saveT();

        return  ResponseEntity.ok().build();
    }
}
