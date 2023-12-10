package com.cc.tips.transcation;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TransactionalTwoServiceImpl implements TransactionalTwoService{

    private final TransactionalTwoRepository transactionalTwoRepository;

    @SneakyThrows
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void saveTw() {

        TransactionalTwoDto transactionalDto=new TransactionalTwoDto();
        transactionalDto.setCode("twoTest2");
        transactionalTwoRepository.save(transactionalDto);

        Long id = transactionalDto.getId();


    }
}
