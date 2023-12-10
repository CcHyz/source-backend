package com.cc.tips.transcation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionalRepository extends JpaRepository<TransactionalDto,Long> {
}
