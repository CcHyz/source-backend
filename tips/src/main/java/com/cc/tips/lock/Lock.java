package com.cc.tips.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试锁的使用.
 *
 * @author Cc
 */
@Slf4j
@Component
public class Lock {
    /**
     * 可重入锁.
     */
    private final ReentrantLock reentrantLock = new ReentrantLock();

    public void useLock() {
        log.info("线程进入-----{}", Thread.currentThread().getName());
        reentrantLock.lock();
        log.info("线程加锁-----{}", Thread.currentThread().getName());
        try {
            log.info("线程锁定区域获取东西-----{}", Thread.currentThread().getName());
        } finally {
            log.info("线程释放锁-----{}", Thread.currentThread().getName());
            reentrantLock.unlock();
        }
    }

    public void unUseLock() {
        log.info("线程进入-----{}", Thread.currentThread().getName());
        try {
            log.info("线程区域获取东西-----{}", Thread.currentThread().getName());
        } finally {
            log.info("线程结束-----{}", Thread.currentThread().getName());
        }
    }


}
