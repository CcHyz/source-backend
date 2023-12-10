package com.cc.tips.transcation;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TransactionalServiceImpl implements TransactionalService{

    private final TransactionalTwoRepository transactionalTwoRepository;
    private final TransactionalRepository transactionalRepository;
    private final TransactionalTwoService transactionalTwoService;
    private final ExecutorService executorService=Executors.newSingleThreadExecutor();


    @SneakyThrows
//    @Transactional
    @Override
    public void saveT() {

        transactionalTwoService.saveTw();

        //异常catch后是不会导致事物回滚
//        try {
//            Integer a=0;
//            if (a==0){
//                throw  new Exception("error");
//            }
//        } catch (Throwable throwable){
//            throwable.printStackTrace();
//        }

//            Integer a=0;
//            if (a==0){
//                throw  new Exception("error");
//            }



        List<TransactionalDto> all = transactionalRepository.findAll();

        TransactionalTwoDto transactionalDto=new TransactionalTwoDto();
        transactionalDto.setCode("twoTest2");
        transactionalTwoRepository.save(transactionalDto);

        Long id = transactionalDto.getId();


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

        TransactionalTwoDto transactionalDto=new TransactionalTwoDto();
        transactionalDto.setCode("twoTest5");
        transactionalTwoRepository.save(transactionalDto);

        Long id = transactionalDto.getId();
    }
}
