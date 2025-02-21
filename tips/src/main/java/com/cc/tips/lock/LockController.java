package com.cc.tips.lock;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/lock", produces = {APPLICATION_JSON_VALUE})
public class LockController {
    private final Lock lock;
    private final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

    public LockController(Lock lock) {
        this.lock = lock;
    }


    @GetMapping("/get")
    public ResponseEntity get() {
        lock.useLock();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getTwo")
    public ResponseEntity getTwo() {
        lock.unUseLock();
        return ResponseEntity.ok().build();
    }
}
